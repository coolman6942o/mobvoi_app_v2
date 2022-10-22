package io.reactivex.subjects;

import io.reactivex.r;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: PublishSubject.java */
/* loaded from: classes3.dex */
public final class a<T> extends c<T> {

    /* renamed from: c  reason: collision with root package name */
    static final C0350a[] f29289c = new C0350a[0];

    /* renamed from: d  reason: collision with root package name */
    static final C0350a[] f29290d = new C0350a[0];

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<C0350a<T>[]> f29291a = new AtomicReference<>(f29290d);

    /* renamed from: b  reason: collision with root package name */
    Throwable f29292b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* renamed from: io.reactivex.subjects.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0350a<T> extends AtomicBoolean implements b {
        private static final long serialVersionUID = 3562861878281475070L;
        final r<? super T> downstream;
        final a<T> parent;

        C0350a(r<? super T> rVar, a<T> aVar) {
            this.downstream = rVar;
            this.parent = aVar;
        }

        public void a() {
            if (!get()) {
                this.downstream.onComplete();
            }
        }

        public void b(Throwable th2) {
            if (get()) {
                fo.a.s(th2);
            } else {
                this.downstream.onError(th2);
            }
        }

        public void c(T t10) {
            if (!get()) {
                this.downstream.onNext(t10);
            }
        }

        @Override // xn.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.e(this);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return get();
        }
    }

    a() {
    }

    public static <T> a<T> d() {
        return new a<>();
    }

    boolean c(C0350a<T> aVar) {
        C0350a<T>[] aVarArr;
        C0350a<T>[] aVarArr2;
        do {
            aVarArr = this.f29291a.get();
            if (aVarArr == f29289c) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new C0350a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f29291a.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void e(C0350a<T> aVar) {
        C0350a<T>[] aVarArr;
        C0350a<T>[] aVarArr2;
        do {
            aVarArr = this.f29291a.get();
            if (aVarArr != f29289c && aVarArr != f29290d) {
                int length = aVarArr.length;
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (aVarArr[i11] == aVar) {
                        i10 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        aVarArr2 = f29290d;
                    } else {
                        C0350a<T>[] aVarArr3 = new C0350a[length - 1];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                        System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f29291a.compareAndSet(aVarArr, aVarArr2));
    }

    @Override // io.reactivex.r
    public void onComplete() {
        C0350a<T>[] aVarArr = this.f29291a.get();
        C0350a<T>[] aVarArr2 = f29289c;
        if (aVarArr != aVarArr2) {
            for (C0350a<T> aVar : this.f29291a.getAndSet(aVarArr2)) {
                aVar.a();
            }
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        bo.b.e(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        C0350a<T>[] aVarArr = this.f29291a.get();
        C0350a<T>[] aVarArr2 = f29289c;
        if (aVarArr == aVarArr2) {
            fo.a.s(th2);
            return;
        }
        this.f29292b = th2;
        for (C0350a<T> aVar : this.f29291a.getAndSet(aVarArr2)) {
            aVar.b(th2);
        }
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        bo.b.e(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (C0350a<T> aVar : this.f29291a.get()) {
            aVar.c(t10);
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(b bVar) {
        if (this.f29291a.get() == f29289c) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        C0350a<T> aVar = new C0350a<>(rVar, this);
        rVar.onSubscribe(aVar);
        if (!c(aVar)) {
            Throwable th2 = this.f29292b;
            if (th2 != null) {
                rVar.onError(th2);
            } else {
                rVar.onComplete();
            }
        } else if (aVar.isDisposed()) {
            e(aVar);
        }
    }
}
