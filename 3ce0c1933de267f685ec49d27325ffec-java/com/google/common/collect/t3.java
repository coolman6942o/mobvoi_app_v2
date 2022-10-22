package com.google.common.collect;

import com.google.common.base.p;
import java.util.Collection;
import java.util.Set;
/* compiled from: ForwardingSet.java */
/* loaded from: classes.dex */
public abstract class t3<E> extends m3<E> implements Set<E> {
    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || b().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return b().hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public abstract Set<E> b();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(Collection<?> collection) {
        return l7.g(this, (Collection) p.o(collection));
    }
}
