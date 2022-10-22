package r8;

import com.google.zxing.FormatException;
/* compiled from: Version.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: h  reason: collision with root package name */
    private static final e[] f33453h = a();

    /* renamed from: a  reason: collision with root package name */
    private final int f33454a;

    /* renamed from: b  reason: collision with root package name */
    private final int f33455b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33456c;

    /* renamed from: d  reason: collision with root package name */
    private final int f33457d;

    /* renamed from: e  reason: collision with root package name */
    private final int f33458e;

    /* renamed from: f  reason: collision with root package name */
    private final c f33459f;

    /* renamed from: g  reason: collision with root package name */
    private final int f33460g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Version.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f33461a;

        /* renamed from: b  reason: collision with root package name */
        private final int f33462b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public int a() {
            return this.f33461a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f33462b;
        }

        private b(int i10, int i11) {
            this.f33461a = i10;
            this.f33462b = i11;
        }
    }

    private e(int i10, int i11, int i12, int i13, int i14, c cVar) {
        b[] a10;
        this.f33454a = i10;
        this.f33455b = i11;
        this.f33456c = i12;
        this.f33457d = i13;
        this.f33458e = i14;
        this.f33459f = cVar;
        int b10 = cVar.b();
        int i15 = 0;
        for (b bVar : cVar.a()) {
            i15 += bVar.a() * (bVar.b() + b10);
        }
        this.f33460g = i15;
    }

    private static e[] a() {
        return new e[]{new e(1, 10, 10, 8, 8, new c(5, new b(1, 3))), new e(2, 12, 12, 10, 10, new c(7, new b(1, 5))), new e(3, 14, 14, 12, 12, new c(10, new b(1, 8))), new e(4, 16, 16, 14, 14, new c(12, new b(1, 12))), new e(5, 18, 18, 16, 16, new c(14, new b(1, 18))), new e(6, 20, 20, 18, 18, new c(18, new b(1, 22))), new e(7, 22, 22, 20, 20, new c(20, new b(1, 30))), new e(8, 24, 24, 22, 22, new c(24, new b(1, 36))), new e(9, 26, 26, 24, 24, new c(28, new b(1, 44))), new e(10, 32, 32, 14, 14, new c(36, new b(1, 62))), new e(11, 36, 36, 16, 16, new c(42, new b(1, 86))), new e(12, 40, 40, 18, 18, new c(48, new b(1, 114))), new e(13, 44, 44, 20, 20, new c(56, new b(1, 144))), new e(14, 48, 48, 22, 22, new c(68, new b(1, 174))), new e(15, 52, 52, 24, 24, new c(42, new b(2, 102))), new e(16, 64, 64, 14, 14, new c(56, new b(2, 140))), new e(17, 72, 72, 16, 16, new c(36, new b(4, 92))), new e(18, 80, 80, 18, 18, new c(48, new b(4, 114))), new e(19, 88, 88, 20, 20, new c(56, new b(4, 144))), new e(20, 96, 96, 22, 22, new c(68, new b(4, 174))), new e(21, 104, 104, 24, 24, new c(56, new b(6, 136))), new e(22, 120, 120, 18, 18, new c(68, new b(6, 175))), new e(23, 132, 132, 20, 20, new c(62, new b(8, 163))), new e(24, 144, 144, 22, 22, new c(62, new b(8, 156), new b(2, 155))), new e(25, 8, 18, 6, 16, new c(7, new b(1, 5))), new e(26, 8, 32, 6, 14, new c(11, new b(1, 10))), new e(27, 12, 26, 10, 24, new c(14, new b(1, 16))), new e(28, 12, 36, 10, 16, new c(18, new b(1, 22))), new e(29, 16, 36, 14, 16, new c(24, new b(1, 32))), new e(30, 16, 48, 14, 22, new c(28, new b(1, 49)))};
    }

    public static e h(int i10, int i11) throws FormatException {
        e[] eVarArr;
        if ((i10 & 1) == 0 && (i11 & 1) == 0) {
            for (e eVar : f33453h) {
                if (eVar.f33455b == i10 && eVar.f33456c == i11) {
                    return eVar;
                }
            }
            throw FormatException.getFormatInstance();
        }
        throw FormatException.getFormatInstance();
    }

    public int b() {
        return this.f33458e;
    }

    public int c() {
        return this.f33457d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f33459f;
    }

    public int e() {
        return this.f33456c;
    }

    public int f() {
        return this.f33455b;
    }

    public int g() {
        return this.f33460g;
    }

    public int i() {
        return this.f33454a;
    }

    public String toString() {
        return String.valueOf(this.f33454a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Version.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final int f33463a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f33464b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b[] a() {
            return this.f33464b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f33463a;
        }

        private c(int i10, b bVar) {
            this.f33463a = i10;
            this.f33464b = new b[]{bVar};
        }

        private c(int i10, b bVar, b bVar2) {
            this.f33463a = i10;
            this.f33464b = new b[]{bVar, bVar2};
        }
    }
}
