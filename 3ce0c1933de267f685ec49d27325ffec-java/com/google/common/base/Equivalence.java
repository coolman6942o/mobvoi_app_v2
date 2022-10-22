package com.google.common.base;

import java.io.Serializable;
import java.util.function.BiPredicate;
/* loaded from: classes.dex */
public abstract class Equivalence<T> implements BiPredicate<T, T> {

    /* loaded from: classes.dex */
    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        private final T reference;

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.d((T) this.reference, (T) wrapper.reference);
            }
            return false;
        }

        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.g((T) this.reference);
        }

        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.reference);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 7 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".wrap(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: classes.dex */
    static final class a extends Equivalence<Object> implements Serializable {
        static final a INSTANCE = new a();
        private static final long serialVersionUID = 1;

        a() {
        }

        @Override // com.google.common.base.Equivalence
        protected boolean a(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        protected int b(Object obj) {
            return obj.hashCode();
        }
    }

    /* loaded from: classes.dex */
    static final class b extends Equivalence<Object> implements Serializable {
        static final b INSTANCE = new b();
        private static final long serialVersionUID = 1;

        b() {
        }

        @Override // com.google.common.base.Equivalence
        protected boolean a(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        protected int b(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    protected Equivalence() {
    }

    public static Equivalence<Object> c() {
        return a.INSTANCE;
    }

    public static Equivalence<Object> h() {
        return b.INSTANCE;
    }

    protected abstract boolean a(T t10, T t11);

    protected abstract int b(T t10);

    public final boolean d(T t10, T t11) {
        if (t10 == t11) {
            return true;
        }
        if (t10 == null || t11 == null) {
            return false;
        }
        return a(t10, t11);
    }

    public final int g(T t10) {
        if (t10 == null) {
            return 0;
        }
        return b(t10);
    }

    @Override // java.util.function.BiPredicate
    @Deprecated
    public final boolean test(T t10, T t11) {
        return d(t10, t11);
    }
}
