package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.c8;
import java.lang.reflect.Array;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DenseImmutableTable.java */
/* loaded from: classes.dex */
public final class d3<R, C, V> extends h7<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final int[] rowCounts;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    private final V[][] values;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DenseImmutableTable.java */
    /* loaded from: classes.dex */
    public final class b extends d<R, V> {
        private final int columnIndex;

        b(int i10) {
            super(d3.this.columnCounts[i10]);
            this.columnIndex = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean l() {
            return true;
        }

        @Override // com.google.common.collect.d3.d
        V q(int i10) {
            return (V) d3.this.values[i10][this.columnIndex];
        }

        @Override // com.google.common.collect.d3.d
        ImmutableMap<R, Integer> s() {
            return d3.this.rowKeyToIndex;
        }
    }

    /* compiled from: DenseImmutableTable.java */
    /* loaded from: classes.dex */
    private final class c extends d<C, ImmutableMap<R, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean l() {
            return false;
        }

        @Override // com.google.common.collect.d3.d
        ImmutableMap<C, Integer> s() {
            return d3.this.columnKeyToIndex;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: t */
        public ImmutableMap<R, V> q(int i10) {
            return new b(i10);
        }

        private c() {
            super(d3.this.columnCounts.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DenseImmutableTable.java */
    /* loaded from: classes.dex */
    public static abstract class d<K, V> extends ImmutableMap.c<K, V> {
        private final int size;

        /* compiled from: DenseImmutableTable.java */
        /* loaded from: classes.dex */
        class a extends com.google.common.collect.c<Map.Entry<K, V>> {

            /* renamed from: c  reason: collision with root package name */
            private int f11953c = -1;

            /* renamed from: d  reason: collision with root package name */
            private final int f11954d;

            a() {
                this.f11954d = d.this.s().size();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<K, V> a() {
                int i10 = this.f11953c;
                while (true) {
                    this.f11953c = i10 + 1;
                    int i11 = this.f11953c;
                    if (i11 >= this.f11954d) {
                        return b();
                    }
                    Object q5 = d.this.q(i11);
                    if (q5 != null) {
                        return w5.e(d.this.p(this.f11953c), q5);
                    }
                    i10 = this.f11953c;
                }
            }
        }

        d(int i10) {
            this.size = i10;
        }

        private boolean r() {
            return this.size == s().size();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(Object obj) {
            Integer num = s().get(obj);
            if (num == null) {
                return null;
            }
            return q(num.intValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.c, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> h() {
            return r() ? s().keySet() : super.h();
        }

        @Override // com.google.common.collect.ImmutableMap.c
        p8<Map.Entry<K, V>> o() {
            return new a();
        }

        K p(int i10) {
            return s().keySet().asList().get(i10);
        }

        abstract V q(int i10);

        abstract ImmutableMap<K, Integer> s();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DenseImmutableTable.java */
    /* loaded from: classes.dex */
    public final class e extends d<C, V> {
        private final int rowIndex;

        e(int i10) {
            super(d3.this.rowCounts[i10]);
            this.rowIndex = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean l() {
            return true;
        }

        @Override // com.google.common.collect.d3.d
        V q(int i10) {
            return (V) d3.this.values[this.rowIndex][i10];
        }

        @Override // com.google.common.collect.d3.d
        ImmutableMap<C, Integer> s() {
            return d3.this.columnKeyToIndex;
        }
    }

    /* compiled from: DenseImmutableTable.java */
    /* loaded from: classes.dex */
    private final class f extends d<R, ImmutableMap<C, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean l() {
            return false;
        }

        @Override // com.google.common.collect.d3.d
        ImmutableMap<R, Integer> s() {
            return d3.this.rowKeyToIndex;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: t */
        public ImmutableMap<C, V> q(int i10) {
            return new e(i10);
        }

        private f() {
            super(d3.this.rowCounts.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d3(ImmutableList<c8.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        this.values = (V[][]) ((Object[][]) Array.newInstance(Object.class, immutableSet.size(), immutableSet2.size()));
        ImmutableMap<R, Integer> f10 = w5.f(immutableSet);
        this.rowKeyToIndex = f10;
        ImmutableMap<C, Integer> f11 = w5.f(immutableSet2);
        this.columnKeyToIndex = f11;
        this.rowCounts = new int[f10.size()];
        this.columnCounts = new int[f11.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i10 = 0; i10 < immutableList.size(); i10++) {
            c8.a<R, C, V> aVar = immutableList.get(i10);
            R b10 = aVar.b();
            C a10 = aVar.a();
            int intValue = this.rowKeyToIndex.get(b10).intValue();
            int intValue2 = this.columnKeyToIndex.get(a10).intValue();
            n(b10, a10, this.values[intValue][intValue2], aVar.getValue());
            this.values[intValue][intValue2] = aVar.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[intValue] = iArr3[intValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[intValue2] = iArr4[intValue2] + 1;
            iArr[i10] = intValue;
            iArr2[i10] = intValue2;
        }
        this.cellRowIndices = iArr;
        this.cellColumnIndices = iArr2;
        this.rowMap = new f();
        this.columnMap = new c();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.y, com.google.common.collect.c8
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.values[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.h7
    c8.a<R, C, V> r(int i10) {
        int i11 = this.cellRowIndices[i10];
        int i12 = this.cellColumnIndices[i10];
        return ImmutableTable.j(rowKeySet().asList().get(i11), columnKeySet().asList().get(i12), this.values[i11][i12]);
    }

    @Override // com.google.common.collect.h7
    V s(int i10) {
        return this.values[this.cellRowIndices[i10]][this.cellColumnIndices[i10]];
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.rowMap);
    }
}
