package com.google.common.collect;

import com.google.common.base.p;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Cut.java */
/* loaded from: classes.dex */
public abstract class c3<C extends Comparable> implements Comparable<c3<C>>, Serializable {
    private static final long serialVersionUID = 0;
    final C endpoint;

    /* compiled from: Cut.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11950a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f11950a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11950a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cut.java */
    /* loaded from: classes.dex */
    public static final class b extends c3<Comparable<?>> {
        private static final b INSTANCE = new b();
        private static final long serialVersionUID = 0;

        private b() {
            super(null);
        }

        @Override // com.google.common.collect.c3
        /* renamed from: h */
        public int compareTo(c3<Comparable<?>> c3Var) {
            return c3Var == this ? 0 : 1;
        }

        @Override // com.google.common.collect.c3
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.c3
        void i(StringBuilder sb2) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.c3
        void j(StringBuilder sb2) {
            sb2.append("+∞)");
        }

        @Override // com.google.common.collect.c3
        Comparable<?> k() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.c3
        Comparable<?> l(h3<Comparable<?>> h3Var) {
            return h3Var.d();
        }

        @Override // com.google.common.collect.c3
        boolean m(Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.common.collect.c3
        Comparable<?> n(h3<Comparable<?>> h3Var) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.c3
        BoundType q() {
            throw new AssertionError("this statement should be unreachable");
        }

        public String toString() {
            return "+∞";
        }

        @Override // com.google.common.collect.c3
        BoundType u() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.c3
        c3<Comparable<?>> v(BoundType boundType, h3<Comparable<?>> h3Var) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.c3
        c3<Comparable<?>> w(BoundType boundType, h3<Comparable<?>> h3Var) {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cut.java */
    /* loaded from: classes.dex */
    public static final class c<C extends Comparable> extends c3<C> {
        private static final long serialVersionUID = 0;

        c(C c10) {
            super((Comparable) p.o(c10));
        }

        @Override // com.google.common.collect.c3, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return c3.super.compareTo((c3) obj);
        }

        @Override // com.google.common.collect.c3
        c3<C> g(h3<C> h3Var) {
            C n10 = n(h3Var);
            return n10 != null ? c3.d(n10) : c3.a();
        }

        @Override // com.google.common.collect.c3
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.c3
        void i(StringBuilder sb2) {
            sb2.append('(');
            sb2.append(this.endpoint);
        }

        @Override // com.google.common.collect.c3
        void j(StringBuilder sb2) {
            sb2.append(this.endpoint);
            sb2.append(']');
        }

        @Override // com.google.common.collect.c3
        C l(h3<C> h3Var) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.c3
        boolean m(C c10) {
            return Range.b(this.endpoint, c10) < 0;
        }

        @Override // com.google.common.collect.c3
        C n(h3<C> h3Var) {
            return h3Var.h(this.endpoint);
        }

        @Override // com.google.common.collect.c3
        BoundType q() {
            return BoundType.OPEN;
        }

        public String toString() {
            String valueOf = String.valueOf(this.endpoint);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2);
            sb2.append("/");
            sb2.append(valueOf);
            sb2.append("\\");
            return sb2.toString();
        }

        @Override // com.google.common.collect.c3
        BoundType u() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.c3
        c3<C> v(BoundType boundType, h3<C> h3Var) {
            int i10 = a.f11950a[boundType.ordinal()];
            if (i10 == 1) {
                C h10 = h3Var.h(this.endpoint);
                return h10 == null ? c3.c() : c3.d(h10);
            } else if (i10 == 2) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        @Override // com.google.common.collect.c3
        c3<C> w(BoundType boundType, h3<C> h3Var) {
            int i10 = a.f11950a[boundType.ordinal()];
            if (i10 == 1) {
                return this;
            }
            if (i10 == 2) {
                C h10 = h3Var.h(this.endpoint);
                return h10 == null ? c3.a() : c3.d(h10);
            }
            throw new AssertionError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cut.java */
    /* loaded from: classes.dex */
    public static final class d extends c3<Comparable<?>> {
        private static final d INSTANCE = new d();
        private static final long serialVersionUID = 0;

        private d() {
            super(null);
        }

        @Override // com.google.common.collect.c3
        c3<Comparable<?>> g(h3<Comparable<?>> h3Var) {
            try {
                return c3.d(h3Var.g());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // com.google.common.collect.c3
        /* renamed from: h */
        public int compareTo(c3<Comparable<?>> c3Var) {
            return c3Var == this ? 0 : -1;
        }

        @Override // com.google.common.collect.c3
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.c3
        void i(StringBuilder sb2) {
            sb2.append("(-∞");
        }

        @Override // com.google.common.collect.c3
        void j(StringBuilder sb2) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.c3
        Comparable<?> k() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.c3
        Comparable<?> l(h3<Comparable<?>> h3Var) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.c3
        boolean m(Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.common.collect.c3
        Comparable<?> n(h3<Comparable<?>> h3Var) {
            return h3Var.g();
        }

        @Override // com.google.common.collect.c3
        BoundType q() {
            throw new IllegalStateException();
        }

        public String toString() {
            return "-∞";
        }

        @Override // com.google.common.collect.c3
        BoundType u() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.c3
        c3<Comparable<?>> v(BoundType boundType, h3<Comparable<?>> h3Var) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.c3
        c3<Comparable<?>> w(BoundType boundType, h3<Comparable<?>> h3Var) {
            throw new AssertionError("this statement should be unreachable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cut.java */
    /* loaded from: classes.dex */
    public static final class e<C extends Comparable> extends c3<C> {
        private static final long serialVersionUID = 0;

        e(C c10) {
            super((Comparable) p.o(c10));
        }

        @Override // com.google.common.collect.c3, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return c3.super.compareTo((c3) obj);
        }

        @Override // com.google.common.collect.c3
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.c3
        void i(StringBuilder sb2) {
            sb2.append('[');
            sb2.append(this.endpoint);
        }

        @Override // com.google.common.collect.c3
        void j(StringBuilder sb2) {
            sb2.append(this.endpoint);
            sb2.append(')');
        }

        @Override // com.google.common.collect.c3
        C l(h3<C> h3Var) {
            return h3Var.j(this.endpoint);
        }

        @Override // com.google.common.collect.c3
        boolean m(C c10) {
            return Range.b(this.endpoint, c10) <= 0;
        }

        @Override // com.google.common.collect.c3
        C n(h3<C> h3Var) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.c3
        BoundType q() {
            return BoundType.CLOSED;
        }

        public String toString() {
            String valueOf = String.valueOf(this.endpoint);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2);
            sb2.append("\\");
            sb2.append(valueOf);
            sb2.append("/");
            return sb2.toString();
        }

        @Override // com.google.common.collect.c3
        BoundType u() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.c3
        c3<C> v(BoundType boundType, h3<C> h3Var) {
            int i10 = a.f11950a[boundType.ordinal()];
            if (i10 == 1) {
                return this;
            }
            if (i10 == 2) {
                C j10 = h3Var.j(this.endpoint);
                return j10 == null ? c3.c() : new c(j10);
            }
            throw new AssertionError();
        }

        @Override // com.google.common.collect.c3
        c3<C> w(BoundType boundType, h3<C> h3Var) {
            int i10 = a.f11950a[boundType.ordinal()];
            if (i10 == 1) {
                C j10 = h3Var.j(this.endpoint);
                return j10 == null ? c3.a() : new c(j10);
            } else if (i10 == 2) {
                return this;
            } else {
                throw new AssertionError();
            }
        }
    }

    c3(C c10) {
        this.endpoint = c10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> c3<C> a() {
        return b.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> c3<C> b(C c10) {
        return new c(c10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> c3<C> c() {
        return d.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> c3<C> d(C c10) {
        return new e(c10);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c3)) {
            return false;
        }
        try {
            return compareTo((c3) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c3<C> g(h3<C> h3Var) {
        return this;
    }

    /* renamed from: h */
    public int compareTo(c3<C> c3Var) {
        if (c3Var == c()) {
            return 1;
        }
        if (c3Var == a()) {
            return -1;
        }
        int b10 = Range.b(this.endpoint, c3Var.endpoint);
        return b10 != 0 ? b10 : com.google.common.primitives.a.a(this instanceof c, c3Var instanceof c);
    }

    public abstract int hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(StringBuilder sb2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(StringBuilder sb2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public C k() {
        return this.endpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C l(h3<C> h3Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m(C c10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract C n(h3<C> h3Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType q();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType u();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract c3<C> v(BoundType boundType, h3<C> h3Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract c3<C> w(BoundType boundType, h3<C> h3Var);
}
