package com.google.common.collect;

import com.google.common.base.p;
import java.io.Serializable;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComparatorOrdering.java */
/* loaded from: classes.dex */
public final class z2<T> extends q6<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z2(Comparator<T> comparator) {
        this.comparator = (Comparator) p.o(comparator);
    }

    @Override // com.google.common.collect.q6, java.util.Comparator
    public int compare(T t10, T t11) {
        return this.comparator.compare(t10, t11);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z2) {
            return this.comparator.equals(((z2) obj).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
