package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.b;
import io.reactivex.k;
import io.reactivex.r;
/* compiled from: ObservableFromArray.java */
/* loaded from: classes3.dex */
public final class b1<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final T[] f28448a;

    /* compiled from: ObservableFromArray.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28449a;

        /* renamed from: b  reason: collision with root package name */
        final T[] f28450b;

        /* renamed from: c  reason: collision with root package name */
        int f28451c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28452d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f28453e;

        a(r<? super T> rVar, T[] tArr) {
            this.f28449a = rVar;
            this.f28450b = tArr;
        }

        void a() {
            T[] tArr = this.f28450b;
            int length = tArr.length;
            for (int i10 = 0; i10 < length && !isDisposed(); i10++) {
                T t10 = tArr[i10];
                if (t10 == null) {
                    r<? super T> rVar = this.f28449a;
                    rVar.onError(new NullPointerException("The element at index " + i10 + " is null"));
                    return;
                }
                this.f28449a.onNext(t10);
            }
            if (!isDisposed()) {
                this.f28449a.onComplete();
            }
        }

        @Override // co.g
        public void clear() {
            this.f28451c = this.f28450b.length;
        }

        @Override // xn.b
        public void dispose() {
            this.f28453e = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28453e;
        }

        @Override // co.g
        public boolean isEmpty() {
            return this.f28451c == this.f28450b.length;
        }

        @Override // co.g
        public T poll() {
            int i10 = this.f28451c;
            T[] tArr = this.f28450b;
            if (i10 == tArr.length) {
                return null;
            }
            this.f28451c = i10 + 1;
            return (T) bo.b.e(tArr[i10], "The array element is null");
        }

        @Override // co.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f28452d = true;
            return 1;
        }
    }

    public b1(T[] tArr) {
        this.f28448a = tArr;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        a aVar = new a(rVar, this.f28448a);
        rVar.onSubscribe(aVar);
        if (!aVar.f28452d) {
            aVar.a();
        }
    }
}
