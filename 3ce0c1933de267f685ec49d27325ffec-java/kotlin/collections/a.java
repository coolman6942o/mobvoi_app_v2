package kotlin.collections;

import java.util.Collection;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: AbstractCollection.kt */
/* loaded from: classes3.dex */
public abstract class a<E> implements Collection<E>, ro.a {

    /* compiled from: AbstractCollection.kt */
    /* renamed from: kotlin.collections.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0370a extends Lambda implements l<E, CharSequence> {
        C0370a() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(E e10) {
            return e10 == a.this ? "(this Collection)" : String.valueOf(e10);
        }
    }

    public abstract int a();

    @Override // java.util.Collection
    public boolean add(E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        for (E e10 : this) {
            if (i.b(e10, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        i.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return e.a(this);
    }

    public String toString() {
        String K;
        K = u.K(this, ", ", "[", "]", 0, null, new C0370a(), 24, null);
        return K;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        i.f(array, "array");
        T[] tArr = (T[]) e.b(this, array);
        Objects.requireNonNull(tArr, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr;
    }
}
