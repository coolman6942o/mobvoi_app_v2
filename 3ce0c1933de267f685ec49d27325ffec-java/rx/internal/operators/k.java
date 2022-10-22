package rx.internal.operators;

import rx.c;
import rx.e;
import rx.exceptions.OnErrorThrowable;
import rx.i;
import yp.g;
/* compiled from: OnSubscribeFilter.java */
/* loaded from: classes3.dex */
public final class k<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f33848a;

    /* renamed from: b  reason: collision with root package name */
    final g<? super T, Boolean> f33849b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeFilter.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final i<? super T> f33850a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super T, Boolean> f33851b;

        /* renamed from: c  reason: collision with root package name */
        boolean f33852c;

        public a(i<? super T> iVar, g<? super T, Boolean> gVar) {
            this.f33850a = iVar;
            this.f33851b = gVar;
            request(0L);
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33852c) {
                this.f33850a.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (this.f33852c) {
                bq.c.i(th2);
                return;
            }
            this.f33852c = true;
            this.f33850a.onError(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            try {
                if (this.f33851b.call(t10).booleanValue()) {
                    this.f33850a.onNext(t10);
                } else {
                    request(1L);
                }
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }

        @Override // rx.i
        public void setProducer(e eVar) {
            super.setProducer(eVar);
            this.f33850a.setProducer(eVar);
        }
    }

    public k(c<T> cVar, g<? super T, Boolean> gVar) {
        this.f33848a = cVar;
        this.f33849b = gVar;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        a aVar = new a(iVar, this.f33849b);
        iVar.add(aVar);
        this.f33848a.j0(aVar);
    }
}
