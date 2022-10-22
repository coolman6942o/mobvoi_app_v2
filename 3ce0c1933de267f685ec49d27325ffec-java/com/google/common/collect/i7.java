package com.google.common.collect;

import com.google.common.base.p;
import java.io.Serializable;
/* compiled from: ReverseNaturalOrdering.java */
/* loaded from: classes.dex */
final class i7 extends q6<Comparable> implements Serializable {
    static final i7 INSTANCE = new i7();
    private static final long serialVersionUID = 0;

    private i7() {
    }

    @Override // com.google.common.collect.q6
    public <S extends Comparable> q6<S> j() {
        return q6.g();
    }

    /* renamed from: k */
    public int compare(Comparable comparable, Comparable comparable2) {
        p.o(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    /* renamed from: l */
    public <E extends Comparable> E c(E e10, E e11) {
        return (E) o6.INSTANCE.d(e10, e11);
    }

    /* renamed from: m */
    public <E extends Comparable> E d(E e10, E e11) {
        return (E) o6.INSTANCE.c(e10, e11);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
