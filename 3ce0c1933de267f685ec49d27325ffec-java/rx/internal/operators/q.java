package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.c;
import rx.g;
import rx.h;
import rx.i;
/* compiled from: OnSubscribeSingle.java */
/* loaded from: classes3.dex */
public class q<T> implements g.c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final c<T> f33897a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeSingle.java */
    /* loaded from: classes3.dex */
    public class a extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f33898a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f33899b;

        /* renamed from: c  reason: collision with root package name */
        private T f33900c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h f33901d;

        a(q qVar, h hVar) {
            this.f33901d = hVar;
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33898a) {
                if (this.f33899b) {
                    this.f33901d.c(this.f33900c);
                } else {
                    this.f33901d.b(new NoSuchElementException("Observable emitted no items"));
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33901d.b(th2);
            unsubscribe();
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (this.f33899b) {
                this.f33898a = true;
                this.f33901d.b(new IllegalArgumentException("Observable emitted too many elements"));
                unsubscribe();
                return;
            }
            this.f33899b = true;
            this.f33900c = t10;
        }

        @Override // rx.i
        public void onStart() {
            request(2L);
        }
    }

    public q(c<T> cVar) {
        this.f33897a = cVar;
    }

    public static <T> q<T> b(c<T> cVar) {
        return new q<>(cVar);
    }

    /* renamed from: a */
    public void call(h<? super T> hVar) {
        a aVar = new a(this, hVar);
        hVar.a(aVar);
        this.f33897a.j0(aVar);
    }
}
