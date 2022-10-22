package com.google.common.collect;

import com.google.common.base.p;
import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReverseOrdering.java */
/* loaded from: classes.dex */
public final class j7<T> extends q6<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final q6<? super T> forwardOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j7(q6<? super T> q6Var) {
        this.forwardOrder = (q6) p.o(q6Var);
    }

    @Override // com.google.common.collect.q6
    public <E extends T> E c(E e10, E e11) {
        return (E) this.forwardOrder.d(e10, e11);
    }

    @Override // com.google.common.collect.q6, java.util.Comparator
    public int compare(T t10, T t11) {
        return this.forwardOrder.compare(t11, t10);
    }

    @Override // com.google.common.collect.q6
    public <E extends T> E d(E e10, E e11) {
        return (E) this.forwardOrder.c(e10, e11);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j7) {
            return this.forwardOrder.equals(((j7) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.q6
    public <S extends T> q6<S> j() {
        return (q6<? super T>) this.forwardOrder;
    }

    public String toString() {
        String valueOf = String.valueOf(this.forwardOrder);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 10);
        sb2.append(valueOf);
        sb2.append(".reverse()");
        return sb2.toString();
    }
}
