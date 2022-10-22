package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableTimer.java */
/* loaded from: classes3.dex */
public final class w3 extends k<Long> {

    /* renamed from: a  reason: collision with root package name */
    final s f29113a;

    /* renamed from: b  reason: collision with root package name */
    final long f29114b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f29115c;

    /* compiled from: ObservableTimer.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final r<? super Long> downstream;

        a(r<? super Long> rVar) {
            this.downstream = rVar;
        }

        public void a(b bVar) {
            DisposableHelper.trySet(this, bVar);
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!isDisposed()) {
                this.downstream.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.downstream.onComplete();
            }
        }
    }

    public w3(long j10, TimeUnit timeUnit, s sVar) {
        this.f29114b = j10;
        this.f29115c = timeUnit;
        this.f29113a = sVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super Long> rVar) {
        a aVar = new a(rVar);
        rVar.onSubscribe(aVar);
        aVar.a(this.f29113a.d(aVar, this.f29114b, this.f29115c));
    }
}
