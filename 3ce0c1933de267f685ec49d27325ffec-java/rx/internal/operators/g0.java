package rx.internal.operators;

import rx.c;
import rx.e;
import rx.i;
import yp.g;
/* compiled from: OperatorTakeUntilPredicate.java */
/* loaded from: classes3.dex */
public final class g0<T> implements c.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final g<? super T, Boolean> f33819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeUntilPredicate.java */
    /* loaded from: classes3.dex */
    public class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f33820a;

        a(g0 g0Var, b bVar) {
            this.f33820a = bVar;
        }

        @Override // rx.e
        public void request(long j10) {
            this.f33820a.b(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorTakeUntilPredicate.java */
    /* loaded from: classes3.dex */
    public final class b extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        private final i<? super T> f33821a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f33822b;

        b(i<? super T> iVar) {
            this.f33821a = iVar;
        }

        void b(long j10) {
            request(j10);
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33822b) {
                this.f33821a.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (!this.f33822b) {
                this.f33821a.onError(th2);
            }
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f33821a.onNext(t10);
            try {
                if (g0.this.f33819a.call(t10).booleanValue()) {
                    this.f33822b = true;
                    this.f33821a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th2) {
                this.f33822b = true;
                rx.exceptions.a.g(th2, this.f33821a, t10);
                unsubscribe();
            }
        }
    }

    public g0(g<? super T, Boolean> gVar) {
        this.f33819a = gVar;
    }

    /* renamed from: a */
    public i<? super T> call(i<? super T> iVar) {
        b bVar = new b(iVar);
        iVar.add(bVar);
        iVar.setProducer(new a(this, bVar));
        return bVar;
    }
}
