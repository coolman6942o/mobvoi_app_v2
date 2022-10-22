package com.google.common.collect;

import com.google.common.collect.j6;
import com.google.common.collect.m6;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultiset.java */
/* loaded from: classes.dex */
public abstract class p<E> extends AbstractCollection<E> implements j6<E> {
    private transient Set<E> elementSet;
    private transient Set<j6.a<E>> entrySet;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMultiset.java */
    /* loaded from: classes.dex */
    public class a extends m6.c<E> {
        a() {
        }

        @Override // com.google.common.collect.m6.c
        j6<E> e() {
            return p.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return p.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMultiset.java */
    /* loaded from: classes.dex */
    public class b extends m6.d<E> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        @Override // com.google.common.collect.m6.d
        j6<E> e() {
            return p.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<j6.a<E>> iterator() {
            return p.this.d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.b();
        }
    }

    Set<E> a() {
        return new a();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public final boolean add(E e10) {
        add(e10, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        return m6.c(this, collection);
    }

    abstract int b();

    abstract Iterator<E> c();

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    Set<j6.a<E>> createEntrySet() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Iterator<j6.a<E>> d();

    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<E> a10 = a();
        this.elementSet = a10;
        return a10;
    }

    public Set<j6.a<E>> entrySet() {
        Set<j6.a<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<j6.a<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.j6
    public final boolean equals(Object obj) {
        return m6.f(this, obj);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        i6.a(this, consumer);
    }

    public /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        i6.b(this, objIntConsumer);
    }

    @Override // java.util.Collection, com.google.common.collect.j6
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return m6.k(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return m6.l(this, collection);
    }

    public int setCount(E e10, int i10) {
        return m6.m(this, e10, i10);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return i6.c(this);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }

    public int add(E e10, int i10) {
        throw new UnsupportedOperationException();
    }

    public int remove(Object obj, int i10) {
        throw new UnsupportedOperationException();
    }

    public boolean setCount(E e10, int i10, int i11) {
        return m6.n(this, e10, i10, i11);
    }
}
