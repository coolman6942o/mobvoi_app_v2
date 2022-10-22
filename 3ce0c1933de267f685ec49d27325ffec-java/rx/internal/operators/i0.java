package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.c;
import rx.g;
import rx.h;
import rx.i;
/* compiled from: SingleFromObservable.java */
/* loaded from: classes3.dex */
public final class i0<T> implements g.c<T> {

    /* renamed from: a  reason: collision with root package name */
    final c.a<T> f33838a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleFromObservable.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f33839a;

        /* renamed from: b  reason: collision with root package name */
        T f33840b;

        /* renamed from: c  reason: collision with root package name */
        int f33841c;

        a(h<? super T> hVar) {
            this.f33839a = hVar;
        }

        @Override // rx.d
        public void onCompleted() {
            int i10 = this.f33841c;
            if (i10 == 0) {
                this.f33839a.b(new NoSuchElementException());
            } else if (i10 == 1) {
                this.f33841c = 2;
                T t10 = this.f33840b;
                this.f33840b = null;
                this.f33839a.c(t10);
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (this.f33841c == 2) {
                bq.c.i(th2);
                return;
            }
            this.f33840b = null;
            this.f33839a.b(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            int i10 = this.f33841c;
            if (i10 == 0) {
                this.f33841c = 1;
                this.f33840b = t10;
            } else if (i10 == 1) {
                this.f33841c = 2;
                this.f33839a.b(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }
    }

    public i0(c.a<T> aVar) {
        this.f33838a = aVar;
    }

    /* renamed from: a */
    public void call(h<? super T> hVar) {
        a aVar = new a(hVar);
        hVar.a(aVar);
        this.f33838a.call(aVar);
    }
}
