package com.mobvoi.record.utils;

import android.media.MediaPlayer;
import java.io.IOException;
/* compiled from: MediaPlayerController.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f20689c;

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayer f20690a;

    /* renamed from: b  reason: collision with root package name */
    private b f20691b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MediaPlayerController.java */
    /* renamed from: com.mobvoi.record.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0239a implements MediaPlayer.OnCompletionListener {
        C0239a() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.reset();
            mediaPlayer.release();
            if (a.this.f20691b != null) {
                a.this.f20691b.f();
            }
        }
    }

    /* compiled from: MediaPlayerController.java */
    /* loaded from: classes2.dex */
    public interface b {
        void f();
    }

    private a() {
    }

    public static a b() {
        if (f20689c == null) {
            synchronized (a.class) {
                if (f20689c == null) {
                    f20689c = new a();
                }
            }
        }
        return f20689c;
    }

    public MediaPlayer c() {
        MediaPlayer mediaPlayer = this.f20690a;
        if (mediaPlayer != null) {
            return mediaPlayer;
        }
        return null;
    }

    public void d() {
        MediaPlayer mediaPlayer = this.f20690a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f20690a.release();
            this.f20690a = null;
        }
    }

    public void e(b bVar) {
        this.f20691b = bVar;
    }

    public void f(String str) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f20690a = mediaPlayer;
            mediaPlayer.reset();
            this.f20690a.setDataSource(str);
            this.f20690a.prepareAsync();
            this.f20690a.setOnCompletionListener(new C0239a());
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }
}
