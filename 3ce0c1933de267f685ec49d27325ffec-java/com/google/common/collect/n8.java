package com.google.common.collect;

import com.google.common.base.p;
import java.util.Iterator;
/* compiled from: TransformedIterator.java */
/* loaded from: classes.dex */
abstract class n8<F, T> implements Iterator<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterator<? extends F> f12133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n8(Iterator<? extends F> it) {
        this.f12133a = (Iterator) p.o(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T a(F f10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12133a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f12133a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f12133a.remove();
    }
}
