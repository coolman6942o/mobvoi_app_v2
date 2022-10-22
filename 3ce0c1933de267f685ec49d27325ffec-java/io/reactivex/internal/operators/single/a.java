package io.reactivex.internal.operators.single;

import io.reactivex.t;
import io.reactivex.u;
import io.reactivex.v;
import xn.b;
import zn.o;
/* compiled from: SingleMap.java */
/* loaded from: classes3.dex */
public final class a<T, R> extends t<R> {

    /* renamed from: a  reason: collision with root package name */
    final v<? extends T> f29164a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends R> f29165b;

    /* compiled from: SingleMap.java */
    /* renamed from: io.reactivex.internal.operators.single.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0345a<T, R> implements u<T> {

        /* renamed from: a  reason: collision with root package name */
        final u<? super R> f29166a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super T, ? extends R> f29167b;

        C0345a(u<? super R> uVar, o<? super T, ? extends R> oVar) {
            this.f29166a = uVar;
            this.f29167b = oVar;
        }

        @Override // io.reactivex.u
        public void onError(Throwable th2) {
            this.f29166a.onError(th2);
        }

        @Override // io.reactivex.u
        public void onSubscribe(b bVar) {
            this.f29166a.onSubscribe(bVar);
        }

        @Override // io.reactivex.u
        public void onSuccess(T t10) {
            try {
                this.f29166a.onSuccess(bo.b.e(this.f29167b.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(th2);
            }
        }
    }

    public a(v<? extends T> vVar, o<? super T, ? extends R> oVar) {
        this.f29164a = vVar;
        this.f29165b = oVar;
    }

    @Override // io.reactivex.t
    protected void e(u<? super R> uVar) {
        this.f29164a.b(new C0345a(uVar, this.f29165b));
    }
}
