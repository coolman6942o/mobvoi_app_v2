package rx.internal.operators;

import rx.c;
import rx.e;
import rx.exceptions.OnErrorThrowable;
import rx.i;
import yp.g;
/* compiled from: OnSubscribeMap.java */
/* loaded from: classes3.dex */
public final class o<T, R> implements c.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f33864a;

    /* renamed from: b  reason: collision with root package name */
    final g<? super T, ? extends R> f33865b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final i<? super R> f33866a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super T, ? extends R> f33867b;

        /* renamed from: c  reason: collision with root package name */
        boolean f33868c;

        public a(i<? super R> iVar, g<? super T, ? extends R> gVar) {
            this.f33866a = iVar;
            this.f33867b = gVar;
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33868c) {
                this.f33866a.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (this.f33868c) {
                bq.c.i(th2);
                return;
            }
            this.f33868c = true;
            this.f33866a.onError(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            try {
                this.f33866a.onNext(this.f33867b.call(t10));
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th2, t10));
            }
        }

        @Override // rx.i
        public void setProducer(e eVar) {
            this.f33866a.setProducer(eVar);
        }
    }

    public o(c<T> cVar, g<? super T, ? extends R> gVar) {
        this.f33864a = cVar;
        this.f33865b = gVar;
    }

    /* renamed from: a */
    public void call(i<? super R> iVar) {
        a aVar = new a(iVar, this.f33865b);
        iVar.add(aVar);
        this.f33864a.j0(aVar);
    }
}
