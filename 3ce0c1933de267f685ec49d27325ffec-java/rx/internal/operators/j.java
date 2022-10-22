package rx.internal.operators;

import java.util.Arrays;
import rx.c;
import rx.d;
import rx.exceptions.CompositeException;
import rx.i;
/* compiled from: OnSubscribeDoOnEach.java */
/* loaded from: classes3.dex */
public class j<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d<? super T> f33842a;

    /* renamed from: b  reason: collision with root package name */
    private final c<T> f33843b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: OnSubscribeDoOnEach.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        private final i<? super T> f33844a;

        /* renamed from: b  reason: collision with root package name */
        private final d<? super T> f33845b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f33846c;

        a(i<? super T> iVar, d<? super T> dVar) {
            super(iVar);
            this.f33844a = iVar;
            this.f33845b = dVar;
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33846c) {
                try {
                    this.f33845b.onCompleted();
                    this.f33846c = true;
                    this.f33844a.onCompleted();
                } catch (Throwable th2) {
                    rx.exceptions.a.f(th2, this);
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (this.f33846c) {
                bq.c.i(th2);
                return;
            }
            this.f33846c = true;
            try {
                this.f33845b.onError(th2);
                this.f33844a.onError(th2);
            } catch (Throwable th3) {
                rx.exceptions.a.e(th3);
                this.f33844a.onError(new CompositeException(Arrays.asList(th2, th3)));
            }
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (!this.f33846c) {
                try {
                    this.f33845b.onNext(t10);
                    this.f33844a.onNext(t10);
                } catch (Throwable th2) {
                    rx.exceptions.a.g(th2, this, t10);
                }
            }
        }
    }

    public j(c<T> cVar, d<? super T> dVar) {
        this.f33843b = cVar;
        this.f33842a = dVar;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        this.f33843b.j0(new a(iVar, this.f33842a));
    }
}
