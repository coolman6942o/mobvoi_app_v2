package com.google.common.collect;

import com.google.common.base.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingletonImmutableSet.java */
/* loaded from: classes.dex */
public final class o7<E> extends ImmutableSet<E> {
    private transient int cachedHashCode;
    final transient E element;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o7(E e10) {
        this.element = (E) p.o(e10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i10) {
        objArr[i10] = this.element;
        return i10 + 1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i10 = this.cachedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = this.element.hashCode();
        this.cachedHashCode = hashCode;
        return hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> m() {
        return ImmutableList.of((Object) this.element);
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean o() {
        return this.cachedHashCode != 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
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

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return j5.v(this.element);
    }
}
