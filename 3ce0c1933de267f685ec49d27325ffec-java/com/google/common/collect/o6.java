package com.google.common.collect;

import com.google.common.base.p;
import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NaturalOrdering.java */
/* loaded from: classes.dex */
public final class o6 extends q6<Comparable> implements Serializable {
    static final o6 INSTANCE = new o6();
    private static final long serialVersionUID = 0;
    private transient q6<Comparable> nullsFirst;
    private transient q6<Comparable> nullsLast;

    private o6() {
    }

    @Override // com.google.common.collect.q6
    public <S extends Comparable> q6<S> j() {
        return i7.INSTANCE;
    }

    /* renamed from: k */
    public int compare(Comparable comparable, Comparable comparable2) {
        p.o(comparable);
        p.o(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
