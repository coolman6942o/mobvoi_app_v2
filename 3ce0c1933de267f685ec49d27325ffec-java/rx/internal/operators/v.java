package rx.internal.operators;

import rx.c;
import rx.i;
import rx.internal.producers.SingleDelayedProducer;
import yp.g;
/* compiled from: OperatorAny.java */
/* loaded from: classes3.dex */
public final class v<T> implements c.b<Boolean, T> {

    /* renamed from: a  reason: collision with root package name */
    final g<? super T, Boolean> f33933a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f33934b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorAny.java */
    /* loaded from: classes3.dex */
    public class a extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f33935a;

        /* renamed from: b  reason: collision with root package name */
        boolean f33936b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f33937c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ i f33938d;

        a(SingleDelayedProducer singleDelayedProducer, i iVar) {
            this.f33937c = singleDelayedProducer;
            this.f33938d = iVar;
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33936b) {
                this.f33936b = true;
                if (this.f33935a) {
                    this.f33937c.setValue(Boolean.FALSE);
                } else {
                    this.f33937c.setValue(Boolean.valueOf(v.this.f33934b));
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (!this.f33936b) {
                this.f33936b = true;
                this.f33938d.onError(th2);
                return;
            }
            bq.c.i(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (!this.f33936b) {
                this.f33935a = true;
                try {
                    if (v.this.f33933a.call(t10).booleanValue()) {
                        this.f33936b = true;
                        this.f33937c.setValue(Boolean.valueOf(true ^ v.this.f33934b));
                        unsubscribe();
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.g(th2, this, t10);
                }
            }
        }
    }

    public v(g<? super T, Boolean> gVar, boolean z10) {
        this.f33933a = gVar;
        this.f33934b = z10;
    }

    /* renamed from: a */
    public i<? super T> call(i<? super Boolean> iVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(iVar);
        a aVar = new a(singleDelayedProducer, iVar);
        iVar.add(aVar);
        iVar.setProducer(singleDelayedProducer);
        return aVar;
    }
}
