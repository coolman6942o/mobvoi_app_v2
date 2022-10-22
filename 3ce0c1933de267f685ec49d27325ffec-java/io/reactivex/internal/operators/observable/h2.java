package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.k;
import io.reactivex.r;
/* compiled from: ObservableRangeLong.java */
/* loaded from: classes3.dex */
public final class h2 extends k<Long> {

    /* renamed from: a  reason: collision with root package name */
    private final long f28701a;

    /* renamed from: b  reason: collision with root package name */
    private final long f28702b;

    /* compiled from: ObservableRangeLong.java */
    /* loaded from: classes3.dex */
    static final class a extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final r<? super Long> downstream;
        final long end;
        boolean fused;
        long index;

        a(r<? super Long> rVar, long j10, long j11) {
            this.downstream = rVar;
            this.index = j10;
            this.end = j11;
        }

        /* renamed from: a */
        public Long poll() throws Exception {
            long j10 = this.index;
            if (j10 != this.end) {
                this.index = 1 + j10;
                return Long.valueOf(j10);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }

        void run() {
            if (!this.fused) {
                r<? super Long> rVar = this.downstream;
                long j10 = this.end;
                for (long j11 = this.index; j11 != j10 && get() == 0; j11++) {
                    rVar.onNext(Long.valueOf(j11));
                }
                if (get() == 0) {
                    lazySet(1);
                    rVar.onComplete();
                }
            }
        }
    }

    public h2(long j10, long j11) {
        this.f28701a = j10;
        this.f28702b = j11;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super Long> rVar) {
        long j10 = this.f28701a;
        a aVar = new a(rVar, j10, j10 + this.f28702b);
        rVar.onSubscribe(aVar);
        aVar.run();
    }
}
