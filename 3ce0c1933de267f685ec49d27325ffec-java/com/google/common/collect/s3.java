package com.google.common.collect;

import java.util.Queue;
/* compiled from: ForwardingQueue.java */
/* loaded from: classes.dex */
public abstract class s3<E> extends m3<E> implements Queue<E> {
    @Override // java.util.Queue
    public E element() {
        return b().element();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public abstract Queue<E> b();

    public boolean offer(E e10) {
        return b().offer(e10);
    }

    @Override // java.util.Queue
    public E peek() {
        return b().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return b().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return b().remove();
    }
}
