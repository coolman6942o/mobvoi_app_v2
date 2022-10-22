package com.google.common.collect;

import com.google.common.base.v;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: MultimapBuilder.java */
/* loaded from: classes.dex */
public abstract class d6<K0, V0> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultimapBuilder.java */
    /* loaded from: classes.dex */
    public class a extends e<Object> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f11956a;

        a(int i10) {
            this.f11956a = i10;
        }

        @Override // com.google.common.collect.d6.e
        <K, V> Map<K, Collection<V>> c() {
            return s6.e(this.f11956a);
        }
    }

    /* compiled from: MultimapBuilder.java */
    /* loaded from: classes.dex */
    private static final class b<V> implements v<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        b(int i10) {
            this.expectedValuesPerKey = p2.b(i10, "expectedValuesPerKey");
        }

        /* renamed from: a */
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    /* compiled from: MultimapBuilder.java */
    /* loaded from: classes.dex */
    private static final class c<V> implements v<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        c(int i10) {
            this.expectedValuesPerKey = p2.b(i10, "expectedValuesPerKey");
        }

        /* renamed from: a */
        public Set<V> get() {
            return s6.f(this.expectedValuesPerKey);
        }
    }

    /* compiled from: MultimapBuilder.java */
    /* loaded from: classes.dex */
    public static abstract class d<K0, V0> extends d6<K0, V0> {
        d() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> q5<K, V> c();
    }

    /* compiled from: MultimapBuilder.java */
    /* loaded from: classes.dex */
    public static abstract class e<K0> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MultimapBuilder.java */
        /* loaded from: classes.dex */
        public class a extends d<K0, Object> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f11957a;

            a(int i10) {
                this.f11957a = i10;
            }

            @Override // com.google.common.collect.d6.d
            public <K extends K0, V> q5<K, V> c() {
                return e6.b(e.this.c(), new b(this.f11957a));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: MultimapBuilder.java */
        /* loaded from: classes.dex */
        public class b extends f<K0, Object> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f11959a;

            b(int i10) {
                this.f11959a = i10;
            }

            @Override // com.google.common.collect.d6.f
            public <K extends K0, V> k7<K, V> c() {
                return e6.c(e.this.c(), new c(this.f11959a));
            }
        }

        e() {
        }

        public d<K0, Object> a() {
            return b(2);
        }

        public d<K0, Object> b(int i10) {
            p2.b(i10, "expectedValuesPerKey");
            return new a(i10);
        }

        abstract <K extends K0, V> Map<K, Collection<V>> c();

        public f<K0, Object> d() {
            return e(2);
        }

        public f<K0, Object> e(int i10) {
            p2.b(i10, "expectedValuesPerKey");
            return new b(i10);
        }
    }

    /* compiled from: MultimapBuilder.java */
    /* loaded from: classes.dex */
    public static abstract class f<K0, V0> extends d6<K0, V0> {
        f() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> k7<K, V> c();
    }

    /* synthetic */ d6(c6 c6Var) {
        this();
    }

    public static e<Object> a() {
        return b(8);
    }

    public static e<Object> b(int i10) {
        p2.b(i10, "expectedKeys");
        return new a(i10);
    }

    private d6() {
    }
}
