package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.f;
import rx.internal.subscriptions.SequentialSubscription;
import rx.j;
/* compiled from: SchedulePeriodicHelper.java */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final long f34054a = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SchedulePeriodicHelper.java */
    /* loaded from: classes3.dex */
    public static class a implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        long f34055a;

        /* renamed from: b  reason: collision with root package name */
        long f34056b;

        /* renamed from: c  reason: collision with root package name */
        long f34057c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f34058d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f34059e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ yp.a f34060f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ SequentialSubscription f34061g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ b f34062h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ f.a f34063i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ long f34064j;

        a(long j10, long j11, yp.a aVar, SequentialSubscription sequentialSubscription, b bVar, f.a aVar2, long j12) {
            this.f34058d = j10;
            this.f34059e = j11;
            this.f34060f = aVar;
            this.f34061g = sequentialSubscription;
            this.f34062h = bVar;
            this.f34063i = aVar2;
            this.f34064j = j12;
            this.f34056b = j10;
            this.f34057c = j11;
        }

        @Override // yp.a
        public void call() {
            long j10;
            this.f34060f.call();
            if (!this.f34061g.isUnsubscribed()) {
                b bVar = this.f34062h;
                long a10 = bVar != null ? bVar.a() : TimeUnit.MILLISECONDS.toNanos(this.f34063i.a());
                long j11 = e.f34054a;
                long j12 = this.f34056b;
                if (a10 + j11 >= j12) {
                    long j13 = this.f34064j;
                    if (a10 < j12 + j13 + j11) {
                        long j14 = this.f34057c;
                        long j15 = this.f34055a + 1;
                        this.f34055a = j15;
                        j10 = j14 + (j15 * j13);
                        this.f34056b = a10;
                        this.f34061g.replace(this.f34063i.c(this, j10 - a10, TimeUnit.NANOSECONDS));
                    }
                }
                long j16 = this.f34064j;
                long j17 = a10 + j16;
                long j18 = this.f34055a + 1;
                this.f34055a = j18;
                this.f34057c = j17 - (j16 * j18);
                j10 = j17;
                this.f34056b = a10;
                this.f34061g.replace(this.f34063i.c(this, j10 - a10, TimeUnit.NANOSECONDS));
            }
        }
    }

    /* compiled from: SchedulePeriodicHelper.java */
    /* loaded from: classes3.dex */
    public interface b {
        long a();
    }

    public static j a(f.a aVar, yp.a aVar2, long j10, long j11, TimeUnit timeUnit, b bVar) {
        long nanos = timeUnit.toNanos(j11);
        long a10 = bVar != null ? bVar.a() : TimeUnit.MILLISECONDS.toNanos(aVar.a());
        SequentialSubscription sequentialSubscription = new SequentialSubscription();
        SequentialSubscription sequentialSubscription2 = new SequentialSubscription(sequentialSubscription);
        sequentialSubscription.replace(aVar.c(new a(a10, timeUnit.toNanos(j10) + a10, aVar2, sequentialSubscription2, bVar, aVar, nanos), j10, timeUnit));
        return sequentialSubscription2;
    }
}
