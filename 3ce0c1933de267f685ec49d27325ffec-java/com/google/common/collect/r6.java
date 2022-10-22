package com.google.common.collect;

import java.util.Iterator;
/* compiled from: PeekingIterator.java */
/* loaded from: classes.dex */
public interface r6<E> extends Iterator<E> {
    @Override // java.util.Iterator
    E next();

    E peek();
}
