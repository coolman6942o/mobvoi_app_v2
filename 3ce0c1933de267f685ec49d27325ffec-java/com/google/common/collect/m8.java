package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.m;
import com.google.common.collect.c8;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
/* compiled from: Tables.java */
/* loaded from: classes.dex */
public final class m8 {

    /* compiled from: Tables.java */
    /* loaded from: classes.dex */
    class a implements h<Map<Object, Object>, Map<Object, Object>> {
        a() {
        }

        /* renamed from: a */
        public Map<Object, Object> apply(Map<Object, Object> map) {
            return Collections.unmodifiableMap(map);
        }
    }

    /* compiled from: Tables.java */
    /* loaded from: classes.dex */
    static abstract class b<R, C, V> implements c8.a<R, C, V> {
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c8.a)) {
                return false;
            }
            c8.a aVar = (c8.a) obj;
            return m.a(b(), aVar.b()) && m.a(a(), aVar.a()) && m.a(getValue(), aVar.getValue());
        }

        public int hashCode() {
            return m.b(b(), a(), getValue());
        }

        public String toString() {
            String valueOf = String.valueOf(b());
            String valueOf2 = String.valueOf(a());
            String valueOf3 = String.valueOf(getValue());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 4 + valueOf2.length() + valueOf3.length());
            sb2.append("(");
            sb2.append(valueOf);
            sb2.append(",");
            sb2.append(valueOf2);
            sb2.append(")=");
            sb2.append(valueOf3);
            return sb2.toString();
        }
    }

    /* compiled from: Tables.java */
    /* loaded from: classes.dex */
    static final class c<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final C columnKey;
        private final R rowKey;
        private final V value;

        c(R r10, C c10, V v10) {
            this.rowKey = r10;
            this.columnKey = c10;
            this.value = v10;
        }

        @Override // com.google.common.collect.c8.a
        public C a() {
            return this.columnKey;
        }

        @Override // com.google.common.collect.c8.a
        public R b() {
            return this.rowKey;
        }

        @Override // com.google.common.collect.c8.a
        public V getValue() {
            return this.value;
        }
    }

    static {
        new a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(c8<?, ?, ?> c8Var, Object obj) {
        if (obj == c8Var) {
            return true;
        }
        if (obj instanceof c8) {
            return c8Var.cellSet().equals(((c8) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> c8.a<R, C, V> b(R r10, C c10, V v10) {
        return new c(r10, c10, v10);
    }
}
