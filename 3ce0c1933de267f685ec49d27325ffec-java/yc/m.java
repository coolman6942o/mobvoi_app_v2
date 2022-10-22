package yc;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ArtySurfaceVideoView.kt */
/* loaded from: classes2.dex */
public final class m extends SurfaceView implements SurfaceHolder.Callback, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener {

    /* renamed from: a  reason: collision with root package name */
    private boolean f36997a;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceHolder f36998b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f36999c;

    /* compiled from: ArtySurfaceVideoView.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public /* synthetic */ m(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final void a() {
        if (this.f36997a) {
            this.f36999c.start();
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f36999c.release();
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f36997a = true;
    }

    public final void setDataSource(String path) {
        i.f(path, "path");
        try {
            this.f36999c.setDataSource(path);
            this.f36999c.prepareAsync();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int i10, int i11, int i12) {
        i.f(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        i.f(holder, "holder");
        this.f36999c.reset();
        this.f36999c.setDisplay(holder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        i.f(holder, "holder");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        SurfaceHolder holder = getHolder();
        i.e(holder, "this.holder");
        this.f36998b = holder;
        holder.addCallback(this);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f36999c = mediaPlayer;
        mediaPlayer.setOnCompletionListener(this);
        this.f36999c.setOnPreparedListener(this);
    }
}
