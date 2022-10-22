package io.reactivex.internal.observers;

import io.reactivex.b;
import io.reactivex.h;
import io.reactivex.internal.util.c;
import io.reactivex.u;
import java.util.concurrent.CountDownLatch;
/* compiled from: BlockingMultiObserver.java */
/* loaded from: classes2.dex */
public final class f<T> extends CountDownLatch implements u<T>, b, h<T> {

    /* renamed from: a  reason: collision with root package name */
    T f28362a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f28363b;

    /* renamed from: c  reason: collision with root package name */
    xn.b f28364c;

    /* renamed from: d  reason: collision with root package name */
    volatile boolean f28365d;

    public f() {
        super(1);
    }

    public T a() {
        if (getCount() != 0) {
            try {
                c.b();
                await();
            } catch (InterruptedException e10) {
                b();
                throw io.reactivex.internal.util.f.d(e10);
            }
        }
        Throwable th2 = this.f28363b;
        if (th2 == null) {
            return this.f28362a;
        }
        throw io.reactivex.internal.util.f.d(th2);
    }

    void b() {
        this.f28365d = true;
        xn.b bVar = this.f28364c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.b
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.u
    public void onError(Throwable th2) {
        this.f28363b = th2;
        countDown();
    }

    @Override // io.reactivex.u
    public void onSubscribe(xn.b bVar) {
        this.f28364c = bVar;
        if (this.f28365d) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.u
    public void onSuccess(T t10) {
        this.f28362a = t10;
        countDown();
    }
}
