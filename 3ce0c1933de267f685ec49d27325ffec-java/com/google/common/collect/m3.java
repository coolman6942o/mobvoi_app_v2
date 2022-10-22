package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
/* compiled from: ForwardingCollection.java */
/* loaded from: classes.dex */
public abstract class m3<E> extends r3 implements Collection<E> {
    public boolean add(E e10) {
        return a().add(e10);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return a().addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Collection<E> a();

    public void clear() {
        a().clear();
    }

    public boolean contains(Object obj) {
        return a().contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return a().containsAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Collection<? extends E> collection) {
        return j5.a(this, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(Collection<?> collection) {
        return y2.a(this, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(Collection<?> collection) {
        return j5.u(iterator(), collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object[] i() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return a().isEmpty();
    }

    public Iterator<E> iterator() {
        return a().iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T[] j(T[] tArr) {
        return (T[]) p6.f(this, tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String k() {
        return y2.e(this);
    }

    public boolean remove(Object obj) {
        return a().remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return a().removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return a().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return a().size();
    }

    public Object[] toArray() {
        return a().toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) a().toArray(tArr);
    }
}
