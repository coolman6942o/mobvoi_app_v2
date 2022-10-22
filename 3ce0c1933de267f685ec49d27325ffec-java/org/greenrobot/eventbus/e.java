package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* compiled from: HandlerPoster.java */
/* loaded from: classes3.dex */
public class e extends Handler implements j {

    /* renamed from: a  reason: collision with root package name */
    private final i f32478a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final int f32479b;

    /* renamed from: c  reason: collision with root package name */
    private final c f32480c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f32481d;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(c cVar, Looper looper, int i10) {
        super(looper);
        this.f32480c = cVar;
        this.f32479b = i10;
    }

    @Override // org.greenrobot.eventbus.j
    public void a(n nVar, Object obj) {
        h a10 = h.a(nVar, obj);
        synchronized (this) {
            this.f32478a.a(a10);
            if (!this.f32481d) {
                this.f32481d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z10 = false;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                h b10 = this.f32478a.b();
                if (b10 == null) {
                    synchronized (this) {
                        b10 = this.f32478a.b();
                        if (b10 == null) {
                            this.f32481d = z10;
                            return;
                        }
                    }
                }
                this.f32480c.g(b10);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f32479b);
            if (sendMessage(obtainMessage())) {
                z10 = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f32481d = z10;
        }
    }
}
