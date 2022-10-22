package com.google.common.collect;

import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EmptyContiguousSet.java */
/* loaded from: classes.dex */
public final class i3<C extends Comparable> extends ContiguousSet<C> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i3(h3<C> h3Var) {
        super(h3Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: B */
    public ContiguousSet<C> u(C c10, boolean z10) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: C */
    public ContiguousSet<C> w(C c10, boolean z10, C c11, boolean z11) {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: D */
    public ContiguousSet<C> y(C c10, boolean z10) {
        return this;
    }

    /* renamed from: F */
    public C first() {
        throw new NoSuchElementException();
    }

    /* renamed from: G */
    public C last() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList<C> asList() {
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        return -1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean o() {
        return true;
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ContiguousSet, com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<C> s() {
        return ImmutableSortedSet.t(q6.g().j());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ContiguousSet, java.util.AbstractCollection
    public String toString() {
        return "[]";
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public p8<C> descendingIterator() {
        return j5.h();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<C> iterator() {
        return j5.h();
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        throw new NoSuchElementException();
    }
}
