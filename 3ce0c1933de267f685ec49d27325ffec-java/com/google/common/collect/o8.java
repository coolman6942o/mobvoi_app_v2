package com.google.common.collect;

import java.util.ListIterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformedListIterator.java */
/* loaded from: classes.dex */
public abstract class o8<F, T> extends n8<F, T> implements ListIterator<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o8(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> b() {
        return j5.c(this.f12133a);
    }

    @Override // java.util.ListIterator
    public void add(T t10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(T t10) {
        throw new UnsupportedOperationException();
    }
}
