package com.google.common.collect;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMapEntry.java */
/* loaded from: classes.dex */
public class g4<K, V> extends b4<K, V> {

    /* compiled from: ImmutableMapEntry.java */
    /* loaded from: classes.dex */
    static final class a<K, V> extends b<K, V> {
        private final transient g4<K, V> nextInValueBucket;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(K k10, V v10, g4<K, V> g4Var, g4<K, V> g4Var2) {
            super(k10, v10, g4Var);
            this.nextInValueBucket = g4Var2;
        }

        @Override // com.google.common.collect.g4
        g4<K, V> i() {
            return this.nextInValueBucket;
        }
    }

    /* compiled from: ImmutableMapEntry.java */
    /* loaded from: classes.dex */
    static class b<K, V> extends g4<K, V> {
        private final transient g4<K, V> nextInKeyBucket;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(K k10, V v10, g4<K, V> g4Var) {
            super(k10, v10);
            this.nextInKeyBucket = g4Var;
        }

        @Override // com.google.common.collect.g4
        final g4<K, V> h() {
            return this.nextInKeyBucket;
        }

        @Override // com.google.common.collect.g4
        final boolean j() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g4(K k10, V v10) {
        super(k10, v10);
        p2.a(k10, v10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> g4<K, V>[] g(int i10) {
        return new g4[i10];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g4<K, V> h() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g4<K, V> i() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return true;
    }
}
