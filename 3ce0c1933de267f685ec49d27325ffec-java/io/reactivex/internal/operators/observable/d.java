package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.f;
import io.reactivex.p;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: BlockingObservableMostRecent.java */
/* loaded from: classes3.dex */
public final class d<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28500a;

    /* renamed from: b  reason: collision with root package name */
    final T f28501b;

    /* compiled from: BlockingObservableMostRecent.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends eo.a<T> {

        /* renamed from: b  reason: collision with root package name */
        volatile Object f28502b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BlockingObservableMostRecent.java */
        /* renamed from: io.reactivex.internal.operators.observable.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0328a implements Iterator<T> {

            /* renamed from: a  reason: collision with root package name */
            private Object f28503a;

            C0328a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object obj = a.this.f28502b;
                this.f28503a = obj;
                return !NotificationLite.isComplete(obj);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f28503a == null) {
                        this.f28503a = a.this.f28502b;
                    }
                    if (NotificationLite.isComplete(this.f28503a)) {
                        throw new NoSuchElementException();
                    } else if (!NotificationLite.isError(this.f28503a)) {
                        return (T) NotificationLite.getValue(this.f28503a);
                    } else {
                        throw f.d(NotificationLite.getError(this.f28503a));
                    }
                } finally {
                    this.f28503a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(T t10) {
            this.f28502b = NotificationLite.next(t10);
        }

        public a<T>.C0328a b() {
            return new C0328a();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28502b = NotificationLite.complete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28502b = NotificationLite.error(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28502b = NotificationLite.next(t10);
        }
    }

    public d(p<T> pVar, T t10) {
        this.f28500a = pVar;
        this.f28501b = t10;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f28501b);
        this.f28500a.subscribe(aVar);
        return aVar.b();
    }
}
