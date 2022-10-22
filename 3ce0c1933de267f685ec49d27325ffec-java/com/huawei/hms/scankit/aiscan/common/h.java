package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.util.b;
/* compiled from: GenericGF.java */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: c  reason: collision with root package name */
    public static final h f14222c;

    /* renamed from: f  reason: collision with root package name */
    public static final h f14225f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f14226g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f14227h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f14228i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f14229j;

    /* renamed from: k  reason: collision with root package name */
    private final i f14230k;

    /* renamed from: l  reason: collision with root package name */
    private final i f14231l;

    /* renamed from: m  reason: collision with root package name */
    private final int f14232m;

    /* renamed from: n  reason: collision with root package name */
    private final int f14233n;

    /* renamed from: o  reason: collision with root package name */
    private final int f14234o;

    /* renamed from: a  reason: collision with root package name */
    public static final h f14220a = new h(4201, 4096, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final h f14221b = new h(1033, 1024, 1);

    /* renamed from: d  reason: collision with root package name */
    public static final h f14223d = new h(19, 16, 1);

    /* renamed from: e  reason: collision with root package name */
    public static final h f14224e = new h(285, 256, 0);

    static {
        h hVar = new h(67, 64, 1);
        f14222c = hVar;
        h hVar2 = new h(301, 256, 1);
        f14225f = hVar2;
        f14226g = hVar2;
        f14227h = hVar;
    }

    public h(int i10, int i11, int i12) {
        this.f14233n = i10;
        this.f14232m = i11;
        this.f14234o = i12;
        this.f14228i = new int[i11];
        this.f14229j = new int[i11];
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            this.f14228i[i14] = i13;
            i13 *= 2;
            if (i13 >= i11) {
                i13 = (i13 ^ i10) & (i11 - 1);
            }
        }
        for (int i15 = 0; i15 < i11 - 1; i15++) {
            this.f14229j[this.f14228i[i15]] = i15;
        }
        this.f14230k = new i(this, new int[]{0});
        this.f14231l = new i(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i10) {
        if (b.a(this.f14228i, i10)) {
            return this.f14228i[i10];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i b() {
        return this.f14231l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10) {
        if (i10 != 0) {
            return this.f14229j[i10];
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e10) {
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i d() {
        return this.f14230k;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f14233n) + ',' + this.f14232m + ')';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i b(int i10, int i11) {
        if (i10 < 0) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e10) {
                throw e10;
            }
        } else if (i11 == 0) {
            return this.f14230k;
        } else {
            int[] iArr = new int[i10 + 1];
            iArr[0] = i11;
            return new i(this, iArr);
        }
    }

    public int a() {
        return this.f14234o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i10, int i11) {
        if (i10 == 0 || i11 == 0) {
            return 0;
        }
        int[] iArr = this.f14228i;
        int[] iArr2 = this.f14229j;
        return iArr[(iArr2[i10] + iArr2[i11]) % (this.f14232m - 1)];
    }

    public int c() {
        return this.f14232m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i10) {
        if (i10 != 0) {
            return this.f14228i[(this.f14232m - this.f14229j[i10]) - 1];
        }
        try {
            throw new ArithmeticException();
        } catch (Exception e10) {
            throw e10;
        }
    }
}
