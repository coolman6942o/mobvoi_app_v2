package com.google.common.collect;

import com.google.common.base.p;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
/* loaded from: classes.dex */
public final class EvictingQueue<E> extends s3<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    private EvictingQueue(int i10) {
        p.f(i10 >= 0, "maxSize (%s) must >= 0", i10);
        this.delegate = new ArrayDeque(i10);
        this.maxSize = i10;
    }

    public static <E> EvictingQueue<E> create(int i10) {
        return new EvictingQueue<>(i10);
    }

    @Override // com.google.common.collect.m3, java.util.Collection, java.util.Queue
    public boolean add(E e10) {
        p.o(e10);
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e10);
        return true;
    }

    @Override // com.google.common.collect.m3, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return d(collection);
        }
        clear();
        return h5.a(this, h5.j(collection, size - this.maxSize));
    }

    @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return b().contains(p.o(obj));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.s3
    /* renamed from: l */
    public Queue<E> b() {
        return this.delegate;
    }

    @Override // com.google.common.collect.s3, java.util.Queue
    public boolean offer(E e10) {
        return add(e10);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // com.google.common.collect.m3, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return b().remove(p.o(obj));
    }
}
