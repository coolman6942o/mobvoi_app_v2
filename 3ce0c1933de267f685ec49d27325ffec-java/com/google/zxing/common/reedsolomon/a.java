package com.google.zxing.common.reedsolomon;
/* compiled from: GenericGF.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: j  reason: collision with root package name */
    public static final a f13419j;

    /* renamed from: m  reason: collision with root package name */
    public static final a f13422m;

    /* renamed from: n  reason: collision with root package name */
    public static final a f13423n;

    /* renamed from: o  reason: collision with root package name */
    public static final a f13424o;

    /* renamed from: a  reason: collision with root package name */
    private final int[] f13425a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f13426b;

    /* renamed from: c  reason: collision with root package name */
    private final b f13427c;

    /* renamed from: d  reason: collision with root package name */
    private final b f13428d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13429e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13430f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13431g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f13417h = new a(4201, 4096, 1);

    /* renamed from: i  reason: collision with root package name */
    public static final a f13418i = new a(1033, 1024, 1);

    /* renamed from: k  reason: collision with root package name */
    public static final a f13420k = new a(19, 16, 1);

    /* renamed from: l  reason: collision with root package name */
    public static final a f13421l = new a(285, 256, 0);

    static {
        a aVar = new a(67, 64, 1);
        f13419j = aVar;
        a aVar2 = new a(301, 256, 1);
        f13422m = aVar2;
        f13423n = aVar2;
        f13424o = aVar;
    }

    public a(int i10, int i11, int i12) {
        this.f13430f = i10;
        this.f13429e = i11;
        this.f13431g = i12;
        this.f13425a = new int[i11];
        this.f13426b = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f13425a[i14] = i13;
            i13 <<= 1;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f13426b[this.f13425a[i15]] = i15;
        }
        this.f13427c = new b(this, new int[]{0});
        this.f13428d = new b(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        } else if (i11 == 0) {
            return this.f13427c;
        } else {
            int[] iArr = new int[i10 + 1];
            iArr[0] = i11;
            return new b(this, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10) {
        return this.f13425a[i10];
    }

    public int d() {
        return this.f13431g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e() {
        return this.f13428d;
    }

    public int f() {
        return this.f13429e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() {
        return this.f13427c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i10) {
        if (i10 != 0) {
            return this.f13425a[(this.f13429e - this.f13426b[i10]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i10) {
        if (i10 != 0) {
            return this.f13426b[i10];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f13425a;
        int[] iArr2 = this.f13426b;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f13429e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f13430f) + ',' + this.f13429e + ')';
    }
}
