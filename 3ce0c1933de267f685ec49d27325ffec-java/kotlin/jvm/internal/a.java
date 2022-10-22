package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* compiled from: ArrayIterator.kt */
/* loaded from: classes3.dex */
final class a<T> implements Iterator<T>, ro.a {

    /* renamed from: a  reason: collision with root package name */
    private int f30073a;

    /* renamed from: b  reason: collision with root package name */
    private final T[] f30074b;

    public a(T[] array) {
        i.f(array, "array");
        this.f30074b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f30073a < this.f30074b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f30074b;
            int i10 = this.f30073a;
            this.f30073a = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f30073a--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
