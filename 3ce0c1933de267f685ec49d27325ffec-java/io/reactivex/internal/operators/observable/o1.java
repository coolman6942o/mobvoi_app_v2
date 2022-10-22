package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.j;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableIntervalRange.java */
/* loaded from: classes3.dex */
public final class o1 extends k<Long> {

    /* renamed from: a  reason: collision with root package name */
    final s f28887a;

    /* renamed from: b  reason: collision with root package name */
    final long f28888b;

    /* renamed from: c  reason: collision with root package name */
    final long f28889c;

    /* renamed from: d  reason: collision with root package name */
    final long f28890d;

    /* renamed from: e  reason: collision with root package name */
    final long f28891e;

    /* renamed from: f  reason: collision with root package name */
    final TimeUnit f28892f;

    /* compiled from: ObservableIntervalRange.java */
    /* loaded from: classes3.dex */
    static final class a extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final r<? super Long> downstream;
        final long end;

        a(r<? super Long> rVar, long j10, long j11) {
            this.downstream = rVar;
            this.count = j10;
            this.end = j11;
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
            if (!isDisposed()) {
                long j10 = this.count;
                this.downstream.onNext(Long.valueOf(j10));
                if (j10 == this.end) {
                    DisposableHelper.dispose(this);
                    this.downstream.onComplete();
                    return;
                }
                this.count = j10 + 1;
            }
        }
    }

    public o1(long j10, long j11, long j12, long j13, TimeUnit timeUnit, s sVar) {
        this.f28890d = j12;
        this.f28891e = j13;
        this.f28892f = timeUnit;
        this.f28887a = sVar;
        this.f28888b = j10;
        this.f28889c = j11;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super Long> rVar) {
        a aVar = new a(rVar, this.f28888b, this.f28889c);
        rVar.onSubscribe(aVar);
        s sVar = this.f28887a;
        if (sVar instanceof j) {
            s.c a10 = sVar.a();
            aVar.a(a10);
            a10.d(aVar, this.f28890d, this.f28891e, this.f28892f);
            return;
        }
        aVar.a(sVar.e(aVar, this.f28890d, this.f28891e, this.f28892f));
    }
}
