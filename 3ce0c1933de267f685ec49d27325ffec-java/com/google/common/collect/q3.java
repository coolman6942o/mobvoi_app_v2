package com.google.common.collect;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
/* compiled from: ForwardingMultiset.java */
/* loaded from: classes.dex */
public abstract class q3<E> extends m3<E> implements j6<E> {
    @Override // com.google.common.collect.j6
    public int add(E e10, int i10) {
        return l().add(e10, i10);
    }

    @Override // com.google.common.collect.j6
    public int count(Object obj) {
        return l().count(obj);
    }

    @Override // java.util.Collection, com.google.common.collect.j6
    public boolean equals(Object obj) {
        return obj == this || l().equals(obj);
    }

    @Override // java.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        i6.a(this, consumer);
    }

    @Override // com.google.common.collect.j6
    public /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        i6.b(this, objIntConsumer);
    }

    @Override // java.util.Collection, com.google.common.collect.j6
    public int hashCode() {
        return l().hashCode();
    }

    protected abstract j6<E> l();

    @Override // com.google.common.collect.j6
    public int remove(Object obj, int i10) {
        return l().remove(obj, i10);
    }

    @Override // com.google.common.collect.j6
    public int setCount(E e10, int i10) {
        return l().setCount(e10, i10);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public /* synthetic */ Spliterator spliterator() {
        return i6.c(this);
    }

    @Override // com.google.common.collect.j6
    public boolean setCount(E e10, int i10, int i11) {
        return l().setCount(e10, i10, i11);
    }
}
