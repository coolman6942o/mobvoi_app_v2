package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.c;
import rx.f;
import rx.i;
/* compiled from: OperatorDelay.java */
/* loaded from: classes3.dex */
public final class x<T> implements c.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f33956a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f33957b;

    /* renamed from: c  reason: collision with root package name */
    final f f33958c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDelay.java */
    /* loaded from: classes3.dex */
    public class a extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f33959a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f.a f33960b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i f33961c;

        /* compiled from: OperatorDelay.java */
        /* renamed from: rx.internal.operators.x$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0477a implements yp.a {
            C0477a() {
            }

            @Override // yp.a
            public void call() {
                a aVar = a.this;
                if (!aVar.f33959a) {
                    aVar.f33959a = true;
                    aVar.f33961c.onCompleted();
                }
            }
        }

        /* compiled from: OperatorDelay.java */
        /* loaded from: classes3.dex */
        class b implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Throwable f33964a;

            b(Throwable th2) {
                this.f33964a = th2;
            }

            @Override // yp.a
            public void call() {
                a aVar = a.this;
                if (!aVar.f33959a) {
                    aVar.f33959a = true;
                    aVar.f33961c.onError(this.f33964a);
                    a.this.f33960b.unsubscribe();
                }
            }
        }

        /* compiled from: OperatorDelay.java */
        /* loaded from: classes3.dex */
        class c implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f33966a;

            c(Object obj) {
                this.f33966a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // yp.a
            public void call() {
                a aVar = a.this;
                if (!aVar.f33959a) {
                    aVar.f33961c.onNext(this.f33966a);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(i iVar, f.a aVar, i iVar2) {
            super(iVar);
            this.f33960b = aVar;
            this.f33961c = iVar2;
        }

        @Override // rx.d
        public void onCompleted() {
            f.a aVar = this.f33960b;
            C0477a aVar2 = new C0477a();
            x xVar = x.this;
            aVar.c(aVar2, xVar.f33956a, xVar.f33957b);
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33960b.b(new b(th2));
        }

        @Override // rx.d
        public void onNext(T t10) {
            f.a aVar = this.f33960b;
            c cVar = new c(t10);
            x xVar = x.this;
            aVar.c(cVar, xVar.f33956a, xVar.f33957b);
        }
    }

    public x(long j10, TimeUnit timeUnit, f fVar) {
        this.f33956a = j10;
        this.f33957b = timeUnit;
        this.f33958c = fVar;
    }

    /* renamed from: a */
    public i<? super T> call(i<? super T> iVar) {
        f.a a10 = this.f33958c.a();
        iVar.add(a10);
        return new a(iVar, a10, iVar);
    }
}
