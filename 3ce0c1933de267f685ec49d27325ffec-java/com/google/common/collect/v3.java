package com.google.common.collect;

import com.google.common.base.m;
import com.google.common.base.p;
import java.io.Serializable;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneralRange.java */
/* loaded from: classes.dex */
public final class v3<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    private final T lowerEndpoint;
    private transient v3<T> reverse;
    private final BoundType upperBoundType;
    private final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    private v3(Comparator<? super T> comparator, boolean z10, T t10, BoundType boundType, boolean z11, T t11, BoundType boundType2) {
        this.comparator = (Comparator) p.o(comparator);
        this.hasLowerBound = z10;
        this.hasUpperBound = z11;
        this.lowerEndpoint = t10;
        this.lowerBoundType = (BoundType) p.o(boundType);
        this.upperEndpoint = t11;
        this.upperBoundType = (BoundType) p.o(boundType2);
        if (z10) {
            comparator.compare(t10, t10);
        }
        if (z11) {
            comparator.compare(t11, t11);
        }
        if (z10 && z11) {
            int compare = comparator.compare(t10, t11);
            boolean z12 = true;
            p.k(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t10, t11);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                p.d((boundType != boundType3) | (boundType2 == boundType3 ? false : z12));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> v3<T> a(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new v3<>(comparator, false, null, boundType, false, null, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> v3<T> d(Comparator<? super T> comparator, T t10, BoundType boundType) {
        return new v3<>(comparator, true, t10, boundType, false, null, BoundType.OPEN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> v3<T> p(Comparator<? super T> comparator, T t10, BoundType boundType) {
        return new v3<>(comparator, false, null, BoundType.OPEN, true, t10, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Comparator<? super T> b() {
        return this.comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(T t10) {
        return !o(t10) && !n(t10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v3)) {
            return false;
        }
        v3 v3Var = (v3) obj;
        return this.comparator.equals(v3Var.comparator) && this.hasLowerBound == v3Var.hasLowerBound && this.hasUpperBound == v3Var.hasUpperBound && g().equals(v3Var.g()) && i().equals(v3Var.i()) && m.a(h(), v3Var.h()) && m.a(j(), v3Var.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType g() {
        return this.lowerBoundType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T h() {
        return this.lowerEndpoint;
    }

    public int hashCode() {
        return m.b(this.comparator, h(), g(), j(), i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundType i() {
        return this.upperBoundType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T j() {
        return this.upperEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.hasLowerBound;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.hasUpperBound;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v3<T> m(v3<T> v3Var) {
        BoundType boundType;
        BoundType boundType2;
        T t10;
        int compare;
        BoundType boundType3;
        int compare2;
        int compare3;
        p.o(v3Var);
        p.d(this.comparator.equals(v3Var.comparator));
        boolean z10 = this.hasLowerBound;
        T h10 = h();
        BoundType g10 = g();
        if (!k()) {
            z10 = v3Var.hasLowerBound;
            h10 = v3Var.h();
            g10 = v3Var.g();
        } else if (v3Var.k() && ((compare3 = this.comparator.compare(h(), v3Var.h())) < 0 || (compare3 == 0 && v3Var.g() == BoundType.OPEN))) {
            h10 = v3Var.h();
            g10 = v3Var.g();
        }
        boolean z11 = z10;
        boolean z12 = this.hasUpperBound;
        T j10 = j();
        BoundType i10 = i();
        if (!l()) {
            z12 = v3Var.hasUpperBound;
            j10 = v3Var.j();
            i10 = v3Var.i();
        } else if (v3Var.l() && ((compare2 = this.comparator.compare(j(), v3Var.j())) > 0 || (compare2 == 0 && v3Var.i() == BoundType.OPEN))) {
            j10 = v3Var.j();
            i10 = v3Var.i();
        }
        boolean z13 = z12;
        T t11 = j10;
        if (!z11 || !z13 || ((compare = this.comparator.compare(h10, t11)) <= 0 && !(compare == 0 && g10 == (boundType3 = BoundType.OPEN) && i10 == boundType3))) {
            t10 = h10;
            boundType2 = g10;
            boundType = i10;
        } else {
            boundType2 = BoundType.OPEN;
            boundType = BoundType.CLOSED;
            t10 = t11;
        }
        return new v3<>(this.comparator, z11, t10, boundType2, z13, t11, boundType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(T t10) {
        boolean z10 = false;
        if (!l()) {
            return false;
        }
        int compare = this.comparator.compare(t10, j());
        boolean z11 = compare > 0;
        boolean z12 = compare == 0;
        if (i() == BoundType.OPEN) {
            z10 = true;
        }
        return (z12 & z10) | z11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(T t10) {
        boolean z10 = false;
        if (!k()) {
            return false;
        }
        int compare = this.comparator.compare(t10, h());
        boolean z11 = compare < 0;
        boolean z12 = compare == 0;
        if (g() == BoundType.OPEN) {
            z10 = true;
        }
        return (z12 & z10) | z11;
    }

    public String toString() {
        String valueOf = String.valueOf(this.comparator);
        BoundType boundType = this.lowerBoundType;
        BoundType boundType2 = BoundType.CLOSED;
        char c10 = boundType == boundType2 ? '[' : '(';
        String valueOf2 = String.valueOf(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        String valueOf3 = String.valueOf(this.hasUpperBound ? this.upperEndpoint : "∞");
        char c11 = this.upperBoundType == boundType2 ? ']' : ')';
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + valueOf2.length() + valueOf3.length());
        sb2.append(valueOf);
        sb2.append(":");
        sb2.append(c10);
        sb2.append(valueOf2);
        sb2.append(',');
        sb2.append(valueOf3);
        sb2.append(c11);
        return sb2.toString();
    }
}
