package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.j;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableInterval.java */
/* loaded from: classes3.dex */
public final class n1 extends k<Long> {

    /* renamed from: a  reason: collision with root package name */
    final s f28866a;

    /* renamed from: b  reason: collision with root package name */
    final long f28867b;

    /* renamed from: c  reason: collision with root package name */
    final long f28868c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f28869d;

    /* compiled from: ObservableInterval.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final r<? super Long> downstream;

        a(r<? super Long> rVar) {
            this.downstream = rVar;
        }

        public void a(b bVar) {
            DisposableHelper.setOnce(this, bVar);
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
            if (get() != DisposableHelper.DISPOSED) {
                r<? super Long> rVar = this.downstream;
                long j10 = this.count;
                this.count = 1 + j10;
                rVar.onNext(Long.valueOf(j10));
            }
        }
    }

    public n1(long j10, long j11, TimeUnit timeUnit, s sVar) {
        this.f28867b = j10;
        this.f28868c = j11;
        this.f28869d = timeUnit;
        this.f28866a = sVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super Long> rVar) {
        a aVar = new a(rVar);
        rVar.onSubscribe(aVar);
        s sVar = this.f28866a;
        if (sVar instanceof j) {
            s.c a10 = sVar.a();
            aVar.a(a10);
            a10.d(aVar, this.f28867b, this.f28868c, this.f28869d);
            return;
        }
        aVar.a(sVar.e(aVar, this.f28867b, this.f28868c, this.f28869d));
    }
}
