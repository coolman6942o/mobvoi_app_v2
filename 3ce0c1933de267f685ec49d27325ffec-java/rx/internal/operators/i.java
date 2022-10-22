package rx.internal.operators;

import dq.d;
import dq.e;
import rx.c;
/* compiled from: OnSubscribeDelaySubscriptionOther.java */
/* loaded from: classes3.dex */
public final class i<T, U> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final c<? extends T> f33832a;

    /* renamed from: b  reason: collision with root package name */
    final c<U> f33833b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeDelaySubscriptionOther.java */
    /* loaded from: classes3.dex */
    public class a extends rx.i<U> {

        /* renamed from: a  reason: collision with root package name */
        boolean f33834a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.i f33835b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f33836c;

        a(rx.i iVar, d dVar) {
            this.f33835b = iVar;
            this.f33836c = dVar;
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33834a) {
                this.f33834a = true;
                this.f33836c.a(e.c());
                i.this.f33832a.j0(this.f33835b);
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (this.f33834a) {
                bq.c.i(th2);
                return;
            }
            this.f33834a = true;
            this.f33835b.onError(th2);
        }

        @Override // rx.d
        public void onNext(U u10) {
            onCompleted();
        }
    }

    public i(c<? extends T> cVar, c<U> cVar2) {
        this.f33832a = cVar;
        this.f33833b = cVar2;
    }

    /* renamed from: a */
    public void call(rx.i<? super T> iVar) {
        d dVar = new d();
        iVar.add(dVar);
        a aVar = new a(aq.e.c(iVar), dVar);
        dVar.a(aVar);
        this.f33833b.j0(aVar);
    }
}
