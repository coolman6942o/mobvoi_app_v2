package com.mobvoi.mcuwatch.pair.service;

import aa.b;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.mobvoi.mcuwatch.pair.service.RingingService;
import java.io.IOException;
import sh.f;
import sh.k;
/* loaded from: classes2.dex */
public class RingingService extends Service {

    /* renamed from: f  reason: collision with root package name */
    private static String f19249f = "PhoneSoundManager";

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f19252c;

    /* renamed from: d  reason: collision with root package name */
    private int f19253d;

    /* renamed from: a  reason: collision with root package name */
    private AudioManager f19250a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19251b = false;

    /* renamed from: e  reason: collision with root package name */
    private AudioManager.OnAudioFocusChangeListener f19254e = new a(this);

    /* loaded from: classes2.dex */
    class a implements AudioManager.OnAudioFocusChangeListener {
        a(RingingService ringingService) {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c(MediaPlayer mediaPlayer, int i10, int i11) {
        Log.v(f19249f, "Error occurred while playing audio.");
        mediaPlayer.stop();
        mediaPlayer.release();
        this.f19252c = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(MediaPlayer mediaPlayer) {
        int i10 = this.f19253d + 1;
        this.f19253d = i10;
        if (i10 <= 15) {
            mediaPlayer.start();
            return;
        }
        this.f19253d = 0;
        stopSelf();
    }

    private void e() {
        b.a aVar = new b.a(this, "media");
        Intent intent = new Intent(this, RingingService.class);
        intent.setAction("action_stop");
        aVar.i(PendingIntent.getService(this, 0, intent, 201326592));
        aVar.q(false);
        aVar.e(true);
        aVar.s(2);
        aVar.j(getString(k.f34902z2));
        aVar.l(-1);
        aVar.u(f.f34551h0);
        startForeground(10000, aVar.b());
        this.f19250a.requestAudioFocus(this.f19254e, 4, 2);
        g();
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f19252c = mediaPlayer;
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: hi.f
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i10, int i11) {
                boolean c10;
                c10 = RingingService.this.c(mediaPlayer2, i10, i11);
                return c10;
            }
        });
        this.f19252c.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: hi.e
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                RingingService.this.d(mediaPlayer2);
            }
        });
        try {
            AssetFileDescriptor openFd = getAssets().openFd("alarm/alarm.mp3");
            this.f19252c.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            f(this.f19252c);
            openFd.close();
        } catch (Exception e10) {
            String str = f19249f;
            Log.v(str, "Failed to play fallback ringtone" + e10);
        }
        this.f19251b = true;
    }

    private void f(MediaPlayer mediaPlayer) throws IOException, IllegalArgumentException, IllegalStateException {
        if (((AudioManager) getSystemService("audio")).getStreamVolume(4) != 0) {
            mediaPlayer.setAudioStreamType(4);
            mediaPlayer.prepare();
            mediaPlayer.start();
        }
    }

    private void g() {
        if (this.f19251b) {
            this.f19251b = false;
            MediaPlayer mediaPlayer = this.f19252c;
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                this.f19252c.release();
                this.f19252c = null;
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f19250a = (AudioManager) getSystemService("audio");
    }

    @Override // android.app.Service
    public void onDestroy() {
        g();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent == null) {
            return 2;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return 2;
        }
        action.hashCode();
        if (action.equals("action_stop")) {
            stopSelf();
            return 1;
        } else if (!action.equals("action_start")) {
            return 1;
        } else {
            e();
            return 1;
        }
    }
}
