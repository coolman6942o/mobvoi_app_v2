package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
/* compiled from: Version.java */
/* renamed from: com.huawei.hms.scankit.p.u  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0631u {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f14946a = {new int[]{1, 10, 10, 8, 8, 5, 1, 3}, new int[]{2, 12, 12, 10, 10, 7, 1, 5}, new int[]{3, 14, 14, 12, 12, 10, 1, 8}, new int[]{4, 16, 16, 14, 14, 12, 1, 12}, new int[]{5, 18, 18, 16, 16, 14, 1, 18}, new int[]{6, 20, 20, 18, 18, 18, 1, 22}, new int[]{7, 22, 22, 20, 20, 20, 1, 30}, new int[]{8, 24, 24, 22, 22, 24, 1, 36}, new int[]{9, 26, 26, 24, 24, 28, 1, 44}, new int[]{10, 32, 32, 14, 14, 36, 1, 62}, new int[]{11, 36, 36, 16, 16, 42, 1, 86}, new int[]{12, 40, 40, 18, 18, 48, 1, 114}, new int[]{13, 44, 44, 20, 20, 56, 1, 144}, new int[]{14, 48, 48, 22, 22, 68, 1, 174}, new int[]{15, 52, 52, 24, 24, 42, 2, 102}, new int[]{16, 64, 64, 14, 14, 56, 2, 140}, new int[]{17, 72, 72, 16, 16, 36, 4, 92}, new int[]{18, 80, 80, 18, 18, 48, 4, 114}, new int[]{19, 88, 88, 20, 20, 56, 4, 144}, new int[]{20, 96, 96, 22, 22, 68, 4, 174}, new int[]{21, 104, 104, 24, 24, 56, 6, 136}, new int[]{22, 120, 120, 18, 18, 68, 6, 175}, new int[]{23, 132, 132, 20, 20, 62, 8, 163}, new int[]{24, 144, 144, 22, 22, 62, 8, 156, 2, 155}, new int[]{25, 8, 18, 6, 16, 7, 1, 5}, new int[]{26, 8, 32, 6, 14, 11, 1, 10}, new int[]{27, 12, 26, 10, 24, 14, 1, 16}, new int[]{28, 12, 36, 10, 16, 18, 1, 22}, new int[]{29, 16, 36, 14, 16, 24, 1, 32}, new int[]{30, 16, 48, 14, 22, 28, 1, 49}};

    /* renamed from: b  reason: collision with root package name */
    private static final C0631u[] f14947b = h();

    /* renamed from: c  reason: collision with root package name */
    private final int f14948c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14949d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14950e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14951f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14952g;

    /* renamed from: h  reason: collision with root package name */
    private final b f14953h;

    /* renamed from: i  reason: collision with root package name */
    private final int f14954i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Version.java */
    /* renamed from: com.huawei.hms.scankit.p.u$a */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f14955a;

        /* renamed from: b  reason: collision with root package name */
        private final int f14956b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.f14955a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f14956b;
        }

        private a(int i10, int i11) {
            this.f14955a = i10;
            this.f14956b = i11;
        }
    }

    private C0631u(int i10, int i11, int i12, int i13, int i14, b bVar) {
        a[] a10;
        this.f14948c = i10;
        this.f14949d = i11;
        this.f14950e = i12;
        this.f14951f = i13;
        this.f14952g = i14;
        this.f14953h = bVar;
        int b10 = bVar.b();
        int i15 = 0;
        for (a aVar : bVar.a()) {
            i15 += aVar.a() * (aVar.b() + b10);
        }
        this.f14954i = i15;
    }

    private static C0631u[] h() {
        C0631u[] uVarArr = new C0631u[f14946a.length];
        int i10 = 0;
        while (true) {
            int[][] iArr = f14946a;
            if (i10 >= iArr.length) {
                return uVarArr;
            }
            int[] iArr2 = iArr[i10];
            if (i10 == 23) {
                uVarArr[i10] = new C0631u(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new b(iArr2[5], new a(iArr2[6], iArr2[7]), new a(iArr2[8], iArr2[9])));
            } else {
                uVarArr[i10] = new C0631u(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new b(iArr2[5], new a(iArr2[6], iArr2[7])));
            }
            i10++;
        }
    }

    public int a() {
        return this.f14952g;
    }

    public int b() {
        return this.f14951f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b c() {
        return this.f14953h;
    }

    public int d() {
        return this.f14950e;
    }

    public int e() {
        return this.f14949d;
    }

    public int f() {
        return this.f14954i;
    }

    public int g() {
        return this.f14948c;
    }

    public String toString() {
        return String.valueOf(this.f14948c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Version.java */
    /* renamed from: com.huawei.hms.scankit.p.u$b */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f14957a;

        /* renamed from: b  reason: collision with root package name */
        private final a[] f14958b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a[] a() {
            return this.f14958b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f14957a;
        }

        private b(int i10, a aVar) {
            this.f14957a = i10;
            this.f14958b = new a[]{aVar};
        }

        private b(int i10, a aVar, a aVar2) {
            this.f14957a = i10;
            this.f14958b = new a[]{aVar, aVar2};
        }
    }

    public static C0631u a(int i10, int i11) throws C0550a {
        C0631u[] uVarArr;
        if ((i10 & 1) == 0 && (i11 & 1) == 0) {
            for (C0631u uVar : f14947b) {
                if (uVar.f14949d == i10 && uVar.f14950e == i11) {
                    return uVar;
                }
            }
            throw C0550a.a();
        }
        throw C0550a.a();
    }
}
