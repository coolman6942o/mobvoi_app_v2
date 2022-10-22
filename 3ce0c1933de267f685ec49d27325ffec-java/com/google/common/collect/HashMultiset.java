package com.google.common.collect;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
/* loaded from: classes.dex */
public final class HashMultiset<E> extends m<E> {
    private static final long serialVersionUID = 0;

    private HashMultiset() {
        super(new HashMap());
    }

    public static <E> HashMultiset<E> create() {
        return new HashMultiset<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.m, com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ int add(Object obj, int i10) {
        return super.add(obj, i10);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ int count(Object obj) {
        return super.count(obj);
    }

    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.p, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer<? super E> consumer) {
        i6.a(this, consumer);
    }

    @Override // com.google.common.collect.m, com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        super.forEachEntry(objIntConsumer);
    }

    @Override // com.google.common.collect.p, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.m, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.m, com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ int remove(Object obj, int i10) {
        return super.remove(obj, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.m, com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i10) {
        return super.setCount(obj, i10);
    }

    @Override // com.google.common.collect.m, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.p, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Spliterator<E> spliterator() {
        return i6.c(this);
    }

    private HashMultiset(int i10) {
        super(w5.l(i10));
    }

    public static <E> HashMultiset<E> create(int i10) {
        return new HashMultiset<>(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.p, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ boolean setCount(Object obj, int i10, int i11) {
        return super.setCount(obj, i10, i11);
    }

    public static <E> HashMultiset<E> create(Iterable<? extends E> iterable) {
        HashMultiset<E> create = create(m6.h(iterable));
        h5.a(create, iterable);
        return create;
    }
}
