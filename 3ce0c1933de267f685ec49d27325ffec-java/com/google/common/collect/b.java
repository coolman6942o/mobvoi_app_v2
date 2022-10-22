package com.google.common.collect;

import com.google.common.base.p;
import java.util.NoSuchElementException;
/* compiled from: AbstractIndexedListIterator.java */
/* loaded from: classes.dex */
abstract class b<E> extends q8<E> {

    /* renamed from: a  reason: collision with root package name */
    private final int f11937a;

    /* renamed from: b  reason: collision with root package name */
    private int f11938b;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i10) {
        this(i10, 0);
    }

    protected abstract E a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f11938b < this.f11937a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f11938b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i10 = this.f11938b;
            this.f11938b = i10 + 1;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f11938b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i10 = this.f11938b - 1;
            this.f11938b = i10;
            return a(i10);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f11938b - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i10, int i11) {
        p.r(i11, i10);
        this.f11937a = i10;
        this.f11938b = i11;
    }
}
