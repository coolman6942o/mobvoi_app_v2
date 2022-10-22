package io.reactivex.internal.observers;

import io.reactivex.internal.util.f;
import io.reactivex.r;
import java.util.concurrent.CountDownLatch;
import xn.b;
/* compiled from: BlockingBaseObserver.java */
/* loaded from: classes2.dex */
public abstract class c<T> extends CountDownLatch implements r<T>, b {

    /* renamed from: a  reason: collision with root package name */
    T f28358a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f28359b;

    /* renamed from: c  reason: collision with root package name */
    b f28360c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f28361d;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.b();
                await();
            } catch (InterruptedException e10) {
                dispose();
                throw f.d(e10);
            }
        }
        Throwable th2 = this.f28359b;
        if (th2 == null) {
            return this.f28358a;
        }
        throw f.d(th2);
    }

    @Override // xn.b
    public final void dispose() {
        this.f28361d = true;
        b bVar = this.f28360c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // xn.b
    public final boolean isDisposed() {
        return this.f28361d;
    }

    @Override // io.reactivex.r
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.r
    public final void onSubscribe(b bVar) {
        this.f28360c = bVar;
        if (this.f28361d) {
            bVar.dispose();
        }
    }
}
