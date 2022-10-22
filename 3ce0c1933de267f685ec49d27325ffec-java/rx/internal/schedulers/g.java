package rx.internal.schedulers;

import rx.f;
import yp.a;
/* compiled from: SleepingAction.java */
/* loaded from: classes3.dex */
class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f34065a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f34066b;

    /* renamed from: c  reason: collision with root package name */
    private final long f34067c;

    public g(a aVar, f.a aVar2, long j10) {
        this.f34065a = aVar;
        this.f34066b = aVar2;
        this.f34067c = j10;
    }

    @Override // yp.a
    public void call() {
        if (!this.f34066b.isUnsubscribed()) {
            long a10 = this.f34067c - this.f34066b.a();
            if (a10 > 0) {
                try {
                    Thread.sleep(a10);
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    rx.exceptions.a.c(e10);
                }
            }
            if (!this.f34066b.isUnsubscribed()) {
                this.f34065a.call();
            }
        }
    }
}
