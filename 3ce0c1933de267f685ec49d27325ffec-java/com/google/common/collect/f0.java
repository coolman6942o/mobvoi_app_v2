package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.m;
import com.google.common.base.p;
import java.io.Serializable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ByFunctionOrdering.java */
/* loaded from: classes.dex */
public final class f0<F, T> extends q6<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final h<F, ? extends T> function;
    final q6<T> ordering;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(h<F, ? extends T> hVar, q6<T> q6Var) {
        this.function = (h) p.o(hVar);
        this.ordering = (q6) p.o(q6Var);
    }

    @Override // com.google.common.collect.q6, java.util.Comparator
    public int compare(F f10, F f11) {
        return this.ordering.compare(this.function.apply(f10), this.function.apply(f11));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.function.equals(f0Var.function) && this.ordering.equals(f0Var.ordering);
    }

    public int hashCode() {
        return m.b(this.function, this.ordering);
    }

    public String toString() {
        String valueOf = String.valueOf(this.ordering);
        String valueOf2 = String.valueOf(this.function);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 13 + valueOf2.length());
        sb2.append(valueOf);
        sb2.append(".onResultOf(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
