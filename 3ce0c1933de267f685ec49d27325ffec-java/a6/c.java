package a6;

import b6.i;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class c<T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final b<T> f103a;

    /* renamed from: b  reason: collision with root package name */
    protected int f104b = -1;

    public c(b<T> bVar) {
        this.f103a = (b) i.k(bVar);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f104b < this.f103a.getCount() - 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext()) {
            b<T> bVar = this.f103a;
            int i10 = this.f104b + 1;
            this.f104b = i10;
            return bVar.get(i10);
        }
        int i11 = this.f104b;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(i11);
        throw new NoSuchElementException(sb2.toString());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
