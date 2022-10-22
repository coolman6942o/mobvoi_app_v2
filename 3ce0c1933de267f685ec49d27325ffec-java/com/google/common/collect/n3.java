package com.google.common.collect;

import java.util.Iterator;
/* compiled from: ForwardingIterator.java */
/* loaded from: classes.dex */
public abstract class n3<T> extends r3 implements Iterator<T> {
    protected abstract Iterator<T> b();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return b().hasNext();
    }

    public T next() {
        return b().next();
    }
}
