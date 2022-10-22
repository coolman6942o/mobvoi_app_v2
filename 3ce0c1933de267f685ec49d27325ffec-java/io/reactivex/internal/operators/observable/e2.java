package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.f;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import zn.g;
/* compiled from: ObservablePublish.java */
/* loaded from: classes3.dex */
public final class e2<T> extends p001do.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28560a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<b<T>> f28561b;

    /* renamed from: c  reason: collision with root package name */
    final p<T> f28562c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicReference<Object> implements xn.b {
        private static final long serialVersionUID = -1100270633763673112L;
        final r<? super T> child;

        a(r<? super T> rVar) {
            this.child = rVar;
        }

        void a(b<T> bVar) {
            if (!compareAndSet(null, bVar)) {
                bVar.b(this);
            }
        }

        @Override // xn.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((b) andSet).b(this);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return get() == this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements r<T>, xn.b {

        /* renamed from: e  reason: collision with root package name */
        static final a[] f28563e = new a[0];

        /* renamed from: f  reason: collision with root package name */
        static final a[] f28564f = new a[0];

        /* renamed from: a  reason: collision with root package name */
        final AtomicReference<b<T>> f28565a;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<xn.b> f28568d = new AtomicReference<>();

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<a<T>[]> f28566b = new AtomicReference<>(f28563e);

        /* renamed from: c  reason: collision with root package name */
        final AtomicBoolean f28567c = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.f28565a = atomicReference;
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f28566b.get();
                if (aVarArr == f28564f) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.f28566b.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a<T>[] aVarArr2;
            do {
                aVarArr = this.f28566b.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (aVarArr[i11].equals(aVar)) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            aVarArr2 = f28563e;
                        } else {
                            a<T>[] aVarArr3 = new a[length - 1];
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
            } while (!this.f28566b.compareAndSet(aVarArr, aVarArr2));
        }

        @Override // xn.b
        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.f28566b;
            a<T>[] aVarArr = f28564f;
            if (atomicReference.getAndSet(aVarArr) != aVarArr) {
                this.f28565a.compareAndSet(this, null);
                DisposableHelper.dispose(this.f28568d);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28566b.get() == f28564f;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28565a.compareAndSet(this, null);
            for (a<T> aVar : this.f28566b.getAndSet(f28564f)) {
                aVar.child.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28565a.compareAndSet(this, null);
            a<T>[] andSet = this.f28566b.getAndSet(f28564f);
            if (andSet.length != 0) {
                for (a<T> aVar : andSet) {
                    aVar.child.onError(th2);
                }
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            for (a<T> aVar : this.f28566b.get()) {
                aVar.child.onNext(t10);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.f28568d, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservablePublish.java */
    /* loaded from: classes3.dex */
    public static final class c<T> implements p<T> {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicReference<b<T>> f28569a;

        c(AtomicReference<b<T>> atomicReference) {
            this.f28569a = atomicReference;
        }

        @Override // io.reactivex.p
        public void subscribe(r<? super T> rVar) {
            a aVar = new a(rVar);
            rVar.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.f28569a.get();
                if (bVar == null || bVar.isDisposed()) {
                    b<T> bVar2 = new b<>(this.f28569a);
                    if (!this.f28569a.compareAndSet(bVar, bVar2)) {
                        continue;
                    } else {
                        bVar = bVar2;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }

    private e2(p<T> pVar, p<T> pVar2, AtomicReference<b<T>> atomicReference) {
        this.f28562c = pVar;
        this.f28560a = pVar2;
        this.f28561b = atomicReference;
    }

    public static <T> p001do.a<T> d(p<T> pVar) {
        AtomicReference atomicReference = new AtomicReference();
        return fo.a.k(new e2(new c(atomicReference), pVar, atomicReference));
    }

    @Override // p001do.a
    public void b(g<? super xn.b> gVar) {
        b<T> bVar;
        while (true) {
            bVar = this.f28561b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.f28561b);
            if (this.f28561b.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z10 = true;
        if (bVar.f28567c.get() || !bVar.f28567c.compareAndSet(false, true)) {
            z10 = false;
        }
        try {
            gVar.accept(bVar);
            if (z10) {
                this.f28560a.subscribe(bVar);
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            throw f.d(th2);
        }
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28562c.subscribe(rVar);
    }
}
