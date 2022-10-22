package com.google.common.collect;
/* compiled from: ComparisonChain.java */
/* loaded from: classes.dex */
public abstract class a3 {

    /* renamed from: a  reason: collision with root package name */
    private static final a3 f11930a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final a3 f11931b = new b(-1);

    /* renamed from: c  reason: collision with root package name */
    private static final a3 f11932c = new b(1);

    /* compiled from: ComparisonChain.java */
    /* loaded from: classes.dex */
    class a extends a3 {
        a() {
            super(null);
        }

        @Override // com.google.common.collect.a3
        public a3 d(Comparable comparable, Comparable comparable2) {
            return g(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.a3
        public int e() {
            return 0;
        }

        a3 g(int i10) {
            if (i10 < 0) {
                return a3.f11931b;
            }
            return i10 > 0 ? a3.f11932c : a3.f11930a;
        }
    }

    /* compiled from: ComparisonChain.java */
    /* loaded from: classes.dex */
    private static final class b extends a3 {

        /* renamed from: d  reason: collision with root package name */
        final int f11933d;

        b(int i10) {
            super(null);
            this.f11933d = i10;
        }

        @Override // com.google.common.collect.a3
        public a3 d(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.a3
        public int e() {
            return this.f11933d;
        }
    }

    /* synthetic */ a3(a aVar) {
        this();
    }

    public static a3 f() {
        return f11930a;
    }

    public abstract a3 d(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract int e();

    private a3() {
    }
}
