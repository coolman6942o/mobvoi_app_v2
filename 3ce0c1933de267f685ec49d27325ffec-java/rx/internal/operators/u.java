package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.c;
import rx.f;
import rx.i;
/* compiled from: OnSubscribeTimerPeriodically.java */
/* loaded from: classes3.dex */
public final class u implements c.a<Long> {

    /* renamed from: a  reason: collision with root package name */
    final long f33926a;

    /* renamed from: b  reason: collision with root package name */
    final long f33927b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f33928c;

    /* renamed from: d  reason: collision with root package name */
    final f f33929d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTimerPeriodically.java */
    /* loaded from: classes3.dex */
    public class a implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        long f33930a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f33931b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f.a f33932c;

        a(u uVar, i iVar, f.a aVar) {
            this.f33931b = iVar;
            this.f33932c = aVar;
        }

        @Override // yp.a
        public void call() {
            try {
                i iVar = this.f33931b;
                long j10 = this.f33930a;
                this.f33930a = 1 + j10;
                iVar.onNext(Long.valueOf(j10));
            } catch (Throwable th2) {
                try {
                    this.f33932c.unsubscribe();
                } finally {
                    rx.exceptions.a.f(th2, this.f33931b);
                }
            }
        }
    }

    public u(long j10, long j11, TimeUnit timeUnit, f fVar) {
        this.f33926a = j10;
        this.f33927b = j11;
        this.f33928c = timeUnit;
        this.f33929d = fVar;
    }

    /* renamed from: a */
    public void call(i<? super Long> iVar) {
        f.a a10 = this.f33929d.a();
        iVar.add(a10);
        a10.d(new a(this, iVar, a10), this.f33926a, this.f33927b, this.f33928c);
    }
}
