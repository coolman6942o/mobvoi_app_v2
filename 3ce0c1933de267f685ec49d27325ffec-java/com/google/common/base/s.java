package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;
/* compiled from: Predicates.java */
/* loaded from: classes.dex */
public final class s {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Predicates.java */
    /* loaded from: classes.dex */
    public static class b<A, B> implements r<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f  reason: collision with root package name */
        final h<A, ? extends B> f11715f;

        /* renamed from: p  reason: collision with root package name */
        final r<B> f11716p;

        @Override // com.google.common.base.r
        public boolean apply(A a10) {
            return this.f11716p.apply(this.f11715f.apply(a10));
        }

        @Override // com.google.common.base.r
        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f11715f.equals(bVar.f11715f) && this.f11716p.equals(bVar.f11716p);
        }

        public int hashCode() {
            return this.f11715f.hashCode() ^ this.f11716p.hashCode();
        }

        @Override // com.google.common.base.r, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return q.a(this, obj);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f11716p);
            String valueOf2 = String.valueOf(this.f11715f);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append("(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        private b(r<B> rVar, h<A, ? extends B> hVar) {
            this.f11716p = (r) p.o(rVar);
            this.f11715f = (h) p.o(hVar);
        }
    }

    /* compiled from: Predicates.java */
    /* loaded from: classes.dex */
    private static class c<T> implements r<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        @Override // com.google.common.base.r
        public boolean apply(T t10) {
            try {
                return this.target.contains(t10);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.r
        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return this.target.equals(((c) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        @Override // com.google.common.base.r, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return q.a(this, obj);
        }

        public String toString() {
            String valueOf = String.valueOf(this.target);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 15);
            sb2.append("Predicates.in(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        private c(Collection<?> collection) {
            this.target = (Collection) p.o(collection);
        }
    }

    /* compiled from: Predicates.java */
    /* loaded from: classes.dex */
    private static class d<T> implements r<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        @Override // com.google.common.base.r
        public boolean apply(T t10) {
            return this.target.equals(t10);
        }

        @Override // com.google.common.base.r
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.target.equals(((d) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        @Override // com.google.common.base.r, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return q.a(this, obj);
        }

        public String toString() {
            String valueOf = String.valueOf(this.target);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
            sb2.append("Predicates.equalTo(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        private d(T t10) {
            this.target = t10;
        }
    }

    /* compiled from: Predicates.java */
    /* loaded from: classes.dex */
    private static class e<T> implements r<T>, Serializable {
        private static final long serialVersionUID = 0;
        final r<T> predicate;

        e(r<T> rVar) {
            this.predicate = (r) p.o(rVar);
        }

        @Override // com.google.common.base.r
        public boolean apply(T t10) {
            return !this.predicate.apply(t10);
        }

        @Override // com.google.common.base.r
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return this.predicate.equals(((e) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        @Override // com.google.common.base.r, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return q.a(this, obj);
        }

        public String toString() {
            String valueOf = String.valueOf(this.predicate);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 16);
            sb2.append("Predicates.not(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Predicates.java */
    /* loaded from: classes.dex */
    public static abstract class f extends Enum<f> implements r<Object> {
        public static final f ALWAYS_TRUE = new a("ALWAYS_TRUE", 0);
        public static final f ALWAYS_FALSE = new b("ALWAYS_FALSE", 1);
        public static final f IS_NULL = new c("IS_NULL", 2);
        public static final f NOT_NULL = new d("NOT_NULL", 3);
        private static final /* synthetic */ f[] $VALUES = a();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Predicates.java */
        /* loaded from: classes.dex */
        final class a extends f {
            a(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.base.r
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Predicates.java */
        /* loaded from: classes.dex */
        final class b extends f {
            b(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.base.r
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Predicates.java */
        /* loaded from: classes.dex */
        final class c extends f {
            c(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.base.r
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Predicates.java */
        /* loaded from: classes.dex */
        final class d extends f {
            d(String str, int i10) {
                super(str, i10);
            }

            @Override // com.google.common.base.r
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        private f(String str, int i10) {
        }

        private static /* synthetic */ f[] a() {
            return new f[]{ALWAYS_TRUE, ALWAYS_FALSE, IS_NULL, NOT_NULL};
        }

        public static f valueOf(String str) {
            return (f) Enum.valueOf(f.class, str);
        }

        public static f[] values() {
            return (f[]) $VALUES.clone();
        }

        <T> r<T> b() {
            return this;
        }

        @Override // com.google.common.base.r, java.util.function.Predicate
        public /* synthetic */ boolean test(Object obj) {
            return q.a(this, obj);
        }
    }

    public static <T> r<T> a() {
        return f.ALWAYS_TRUE.b();
    }

    public static <A, B> r<A> b(r<B> rVar, h<A, ? extends B> hVar) {
        return new b(rVar, hVar);
    }

    public static <T> r<T> c(T t10) {
        return t10 == null ? e() : new d(t10);
    }

    public static <T> r<T> d(Collection<? extends T> collection) {
        return new c(collection);
    }

    public static <T> r<T> e() {
        return f.IS_NULL.b();
    }

    public static <T> r<T> f(r<T> rVar) {
        return new e(rVar);
    }
}
