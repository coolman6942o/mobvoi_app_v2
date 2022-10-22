package com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableList.java */
/* loaded from: classes.dex */
public class b7<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new b7(new Object[0]);
    final transient Object[] array;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b7(Object[] objArr) {
        this.array = objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i10) {
        Object[] objArr2 = this.array;
        System.arraycopy(objArr2, 0, objArr, i10, objArr2.length);
        return i10 + this.array.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] b() {
        return this.array;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.array.length;
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

    @Override // java.util.List
    public E get(int i10) {
        return (E) this.array[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.array.length;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.array, 1296);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public q8<E> listIterator(int i10) {
        Object[] objArr = this.array;
        return j5.m(objArr, 0, objArr.length, i10);
    }
}
