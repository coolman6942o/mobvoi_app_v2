package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class LimitQueue<E> extends LinkedList<E> {
    private static final long serialVersionUID = -4636313759149307798L;
    private boolean deduplication;
    private int limit;
    private final Object lock;

    public LimitQueue(int i10) {
        this.lock = new Object();
        this.deduplication = false;
        this.limit = i10;
    }

    public LimitQueue(int i10, boolean z10) {
        this.lock = new Object();
        this.deduplication = false;
        this.limit = i10;
        this.deduplication = z10;
    }

    public LimitQueue(Collection<? extends E> collection, boolean z10) {
        this(collection.size(), z10);
        addAll(collection);
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public boolean add(E e10) {
        boolean add;
        synchronized (this.lock) {
            if (this.deduplication) {
                super.remove(e10);
            }
            if (super.size() >= this.limit) {
                super.poll();
            }
            add = super.add(e10);
        }
        return add;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() > this.limit) {
            return false;
        }
        if (this.deduplication) {
            super.removeAll(collection);
        }
        for (int size = (collection.size() + super.size()) - this.limit; size > 0; size--) {
            super.poll();
        }
        return super.addAll(collection);
    }

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        synchronized (this.lock) {
            super.clear();
        }
    }

    public int getLimit() {
        return this.limit;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public boolean offer(E e10) {
        boolean offer;
        synchronized (this.lock) {
            if (this.deduplication) {
                super.remove(e10);
            }
            if (super.size() >= this.limit) {
                super.poll();
            }
            offer = super.offer(e10);
        }
        return offer;
    }

    @Override // java.util.LinkedList, java.util.Deque
    public E peekLast() {
        E e10;
        synchronized (this.lock) {
            e10 = (E) super.peekLast();
        }
        return e10;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public E poll() {
        E e10;
        synchronized (this.lock) {
            e10 = (E) super.poll();
        }
        return e10;
    }

    @Override // java.util.LinkedList, java.util.Deque, java.util.Queue
    public E remove() {
        E e10;
        synchronized (this.lock) {
            e10 = (E) super.remove();
        }
        return e10;
    }

    @Override // java.util.LinkedList, java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public E remove(int i10) {
        E e10;
        synchronized (this.lock) {
            e10 = (E) super.remove(i10);
        }
        return e10;
    }

    @Override // java.util.LinkedList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque
    public boolean remove(Object obj) {
        boolean remove;
        synchronized (this.lock) {
            remove = super.remove(obj);
        }
        return remove;
    }
}
