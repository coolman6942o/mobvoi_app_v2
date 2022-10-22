package com.google.common.collect;

import com.google.common.base.p;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndexedImmutableSet.java */
/* loaded from: classes.dex */
public abstract class f5<E> extends ImmutableSet<E> {

    /* compiled from: IndexedImmutableSet.java */
    /* loaded from: classes.dex */
    class a extends z3<E> {
        a() {
        }

        @Override // com.google.common.collect.z3, com.google.common.collect.ImmutableCollection
        boolean g() {
            return f5.this.g();
        }

        @Override // java.util.List
        public E get(int i10) {
            return (E) f5.this.get(i10);
        }

        @Override // com.google.common.collect.z3
        ImmutableCollection<E> l() {
            return f5.this;
        }

        @Override // com.google.common.collect.z3, java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return f5.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i10) {
        return asList().a(objArr, i10);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        p.o(consumer);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            consumer.accept(get(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract E get(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> m() {
        return new a();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return s2.c(size(), 1297, new IntFunction() { // from class: com.google.common.collect.e5
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return f5.this.get(i10);
            }
        });
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return asList().iterator();
    }
}
