package com.google.common.collect;

import java.util.NoSuchElementException;
/* compiled from: AbstractSequentialIterator.java */
/* loaded from: classes.dex */
public abstract class s<T> extends p8<T> {

    /* renamed from: a  reason: collision with root package name */
    private T f12162a;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(T t10) {
        this.f12162a = t10;
    }

    protected abstract T a(T t10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12162a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                T t10 = this.f12162a;
                this.f12162a = a(t10);
                return t10;
            } catch (Throwable th2) {
                this.f12162a = a(this.f12162a);
                throw th2;
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
