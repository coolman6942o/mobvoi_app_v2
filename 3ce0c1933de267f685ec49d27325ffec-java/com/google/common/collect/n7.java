package com.google.common.collect;

import com.google.common.base.p;
import java.util.Collections;
import java.util.Spliterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingletonImmutableList.java */
/* loaded from: classes.dex */
public final class n7<E> extends ImmutableList<E> {
    final transient E element;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n7(E e10) {
        this.element = (E) p.o(e10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    @Override // java.util.List
    public E get(int i10) {
        p.m(i10, 1);
        return this.element;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Collections.singleton(this.element).spliterator();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String obj = this.element.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 2);
        sb2.append('[');
        sb2.append(obj);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return j5.v(this.element);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int i10, int i11) {
        p.t(i10, i11, 1);
        return i10 == i11 ? ImmutableList.of() : this;
    }
}
