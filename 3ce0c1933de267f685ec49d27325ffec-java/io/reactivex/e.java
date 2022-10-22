package io.reactivex;

import io.reactivex.internal.operators.flowable.f;
import io.reactivex.internal.operators.flowable.h;
import io.reactivex.internal.subscribers.StrictSubscriber;
import vp.a;
import vp.b;
/* compiled from: Flowable.java */
/* loaded from: classes2.dex */
public abstract class e<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f28350a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int b() {
        return f28350a;
    }

    @Override // vp.a
    public final void a(b<? super T> bVar) {
        if (bVar instanceof f) {
            g((f) bVar);
            return;
        }
        bo.b.e(bVar, "s is null");
        g(new StrictSubscriber(bVar));
    }

    public final e<T> c() {
        return d(b(), false, true);
    }

    public final e<T> d(int i10, boolean z10, boolean z11) {
        bo.b.f(i10, "capacity");
        return fo.a.m(new io.reactivex.internal.operators.flowable.e(this, i10, z11, z10, bo.a.f5359c));
    }

    public final e<T> e() {
        return fo.a.m(new f(this));
    }

    public final e<T> f() {
        return fo.a.m(new h(this));
    }

    public final void g(f<? super T> fVar) {
        bo.b.e(fVar, "s is null");
        try {
            b<? super T> z10 = fo.a.z(this, fVar);
            bo.b.e(z10, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            h(z10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            fo.a.s(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    protected abstract void h(b<? super T> bVar);
}
