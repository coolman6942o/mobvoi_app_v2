package org.greenrobot.eventbus;

import java.util.logging.Level;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundPoster.java */
/* loaded from: classes3.dex */
public final class b implements Runnable, j {

    /* renamed from: a  reason: collision with root package name */
    private final i f32435a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final c f32436b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f32437c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f32436b = cVar;
    }

    @Override // org.greenrobot.eventbus.j
    public void a(n nVar, Object obj) {
        h a10 = h.a(nVar, obj);
        synchronized (this) {
            this.f32435a.a(a10);
            if (!this.f32437c) {
                this.f32437c = true;
                this.f32436b.d().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                h c10 = this.f32435a.c(1000);
                if (c10 == null) {
                    synchronized (this) {
                        c10 = this.f32435a.b();
                        if (c10 == null) {
                            return;
                        }
                    }
                }
                this.f32436b.g(c10);
            } catch (InterruptedException e10) {
                f e11 = this.f32436b.e();
                Level level = Level.WARNING;
                e11.b(level, Thread.currentThread().getName() + " was interruppted", e10);
                return;
            } finally {
                this.f32437c = false;
            }
        }
    }
}
