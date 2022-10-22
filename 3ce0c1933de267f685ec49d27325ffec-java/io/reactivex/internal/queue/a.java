package io.reactivex.internal.queue;

import co.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: MpscLinkedQueue.java */
/* loaded from: classes3.dex */
public final class a<T> implements f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<C0346a<T>> f29169a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<C0346a<T>> f29170b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MpscLinkedQueue.java */
    /* renamed from: io.reactivex.internal.queue.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0346a<E> extends AtomicReference<C0346a<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        C0346a() {
        }

        public E a() {
            E b10 = b();
            g(null);
            return b10;
        }

        public E b() {
            return this.value;
        }

        public C0346a<E> c() {
            return get();
        }

        public void d(C0346a<E> aVar) {
            lazySet(aVar);
        }

        public void g(E e10) {
            this.value = e10;
        }

        C0346a(E e10) {
            g(e10);
        }
    }

    public a() {
        C0346a<T> aVar = new C0346a<>();
        d(aVar);
        e(aVar);
    }

    C0346a<T> a() {
        return this.f29170b.get();
    }

    C0346a<T> b() {
        return this.f29170b.get();
    }

    C0346a<T> c() {
        return this.f29169a.get();
    }

    @Override // co.g
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    void d(C0346a<T> aVar) {
        this.f29170b.lazySet(aVar);
    }

    C0346a<T> e(C0346a<T> aVar) {
        return this.f29169a.getAndSet(aVar);
    }

    @Override // co.g
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // co.g
    public boolean offer(T t10) {
        Objects.requireNonNull(t10, "Null is not a valid element");
        C0346a<T> aVar = new C0346a<>(t10);
        e(aVar).d(aVar);
        return true;
    }

    @Override // co.f, co.g
    public T poll() {
        C0346a<T> c10;
        C0346a<T> a10 = a();
        C0346a<T> c11 = a10.c();
        if (c11 != null) {
            T a11 = c11.a();
            d(c11);
            return a11;
        } else if (a10 == c()) {
            return null;
        } else {
            do {
                c10 = a10.c();
            } while (c10 == null);
            T a12 = c10.a();
            d(c10);
            return a12;
        }
    }
}
