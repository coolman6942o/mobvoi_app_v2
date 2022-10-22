package com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableSet.java */
/* loaded from: classes.dex */
public final class e7<E> extends ImmutableSet<E> {
    static final e7<Object> EMPTY = new e7<>(new Object[0], 0, null, 0);
    private final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    final transient Object[] table;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e7(Object[] objArr, int i10, Object[] objArr2, int i11) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = i11;
        this.hashCode = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i10) {
        Object[] objArr2 = this.elements;
        System.arraycopy(objArr2, 0, objArr, i10, objArr2.length);
        return i10 + this.elements.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] b() {
        return this.elements;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int d10 = y3.d(obj);
        while (true) {
            int i10 = d10 & this.mask;
            Object obj2 = objArr[i10];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            d10 = i10 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int d() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> m() {
        return this.table == null ? ImmutableList.of() : new y6(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean o() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.elements, 1297);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return j5.l(this.elements);
    }
}
