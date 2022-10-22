package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
/* compiled from: MatrixUtil.java */
/* loaded from: classes2.dex */
final class xc {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f15003a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f15004b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f15005c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f15006d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(sc scVar) {
        scVar.a((byte) -1);
    }

    static void b(Ia ia2, sc scVar) throws WriterException {
        if (ia2.e() >= 7) {
            C0591h hVar = new C0591h();
            a(ia2, hVar);
            int i10 = 17;
            for (int i11 = 0; i11 < 6; i11++) {
                for (int i12 = 0; i12 < 3; i12++) {
                    boolean a10 = hVar.a(i10);
                    i10--;
                    scVar.a(i11, (scVar.b() - 11) + i12, a10);
                    scVar.a((scVar.b() - 11) + i12, i11, a10);
                }
            }
        }
    }

    private static boolean b(int i10) {
        return i10 == -1;
    }

    private static void c(int i10, int i11, sc scVar) {
        for (int i12 = 0; i12 < 7; i12++) {
            int[] iArr = f15003a[i12];
            for (int i13 = 0; i13 < 7; i13++) {
                scVar.a(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    private static void d(sc scVar) {
        int i10 = 8;
        while (i10 < scVar.c() - 8) {
            int i11 = i10 + 1;
            int i12 = i11 % 2;
            if (b(scVar.a(i10, 6))) {
                scVar.a(i10, 6, i12);
            }
            if (b(scVar.a(6, i10))) {
                scVar.a(6, i10, i12);
            }
            i10 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(C0591h hVar, EnumC0647za zaVar, Ia ia2, int i10, sc scVar) throws WriterException {
        a(scVar);
        a(ia2, scVar);
        a(zaVar, i10, scVar);
        b(ia2, scVar);
        a(hVar, i10, scVar);
    }

    private static void c(sc scVar) throws WriterException {
        int length = f15003a[0].length;
        c(0, 0, scVar);
        c(scVar.c() - length, 0, scVar);
        c(0, scVar.c() - length, scVar);
        a(0, 7, scVar);
        a(scVar.c() - 8, 7, scVar);
        a(0, scVar.c() - 8, scVar);
        d(7, 0, scVar);
        d((scVar.b() - 7) - 1, 0, scVar);
        d(7, scVar.b() - 7, scVar);
    }

    static void a(Ia ia2, sc scVar) throws WriterException {
        c(scVar);
        b(scVar);
        c(ia2, scVar);
        d(scVar);
    }

    private static void b(sc scVar) throws WriterException {
        if (scVar.a(8, scVar.b() - 8) != 0) {
            scVar.a(8, scVar.b() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static void d(int i10, int i11, sc scVar) throws WriterException {
        for (int i12 = 0; i12 < 7; i12++) {
            int i13 = i11 + i12;
            if (b(scVar.a(i10, i13))) {
                scVar.a(i10, i13, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void b(int i10, int i11, sc scVar) {
        for (int i12 = 0; i12 < 5; i12++) {
            int[] iArr = f15004b[i12];
            for (int i13 = 0; i13 < 5; i13++) {
                scVar.a(i10 + i13, i11 + i12, iArr[i13]);
            }
        }
    }

    static void a(EnumC0647za zaVar, int i10, sc scVar) throws WriterException {
        C0591h hVar = new C0591h();
        a(zaVar, i10, hVar);
        for (int i11 = 0; i11 < hVar.d(); i11++) {
            boolean a10 = hVar.a((hVar.d() - 1) - i11);
            int[] iArr = f15006d[i11];
            scVar.a(iArr[0], iArr[1], a10);
            if (i11 < 8) {
                scVar.a((scVar.c() - i11) - 1, 8, a10);
            } else {
                scVar.a(8, (scVar.b() - 7) + (i11 - 8), a10);
            }
        }
    }

    private static void c(Ia ia2, sc scVar) {
        if (ia2.e() >= 2) {
            int e10 = ia2.e() - 1;
            int[][] iArr = f15005c;
            if (e10 < iArr.length) {
                int[] iArr2 = iArr[e10];
                for (int i10 : iArr2) {
                    if (i10 >= 0) {
                        for (int i11 : iArr2) {
                            if (i11 >= 0 && b(scVar.a(i11, i10))) {
                                b(i11 - 2, i10 - 2, scVar);
                            }
                        }
                    }
                }
            }
        }
    }

    static void a(C0591h hVar, int i10, sc scVar) throws WriterException {
        boolean z10;
        int c10 = scVar.c() - 1;
        int b10 = scVar.b() - 1;
        int i11 = -1;
        int i12 = 0;
        while (c10 > 0) {
            if (c10 == 6) {
                c10--;
            }
            while (b10 >= 0 && b10 < scVar.b()) {
                for (int i13 = 0; i13 < 2; i13++) {
                    int i14 = c10 - i13;
                    if (b(scVar.a(i14, b10))) {
                        if (i12 < hVar.d()) {
                            z10 = hVar.a(i12);
                            i12++;
                        } else {
                            z10 = false;
                        }
                        if (i10 != -1 && wc.a(i10, i14, b10)) {
                            z10 = !z10;
                        }
                        scVar.a(i14, b10, z10);
                    }
                }
                b10 += i11;
            }
            i11 = -i11;
            b10 += i11;
            c10 -= 2;
        }
        if (i12 != hVar.d()) {
            throw new WriterException("Not all bits consumed: " + i12 + '/' + hVar.d());
        }
    }

    static int a(int i10) {
        return 32 - Integer.numberOfLeadingZeros(i10);
    }

    static int a(int i10, int i11) {
        if (i11 != 0) {
            int a10 = a(i11);
            int i12 = i10 << (a10 - 1);
            while (a(i12) >= a10) {
                i12 ^= i11 << (a(i12) - a10);
            }
            return i12;
        }
        try {
            throw new IllegalArgumentException("0 polynomial");
        } catch (Exception e10) {
            throw e10;
        }
    }

    static void a(EnumC0647za zaVar, int i10, C0591h hVar) throws WriterException {
        if (yc.a(i10)) {
            int a10 = (zaVar.a() << 3) | i10;
            hVar.a(a10, 5);
            hVar.a(a(a10, 1335), 10);
            C0591h hVar2 = new C0591h();
            hVar2.a(21522, 15);
            hVar.b(hVar2);
            if (hVar.d() != 15) {
                throw new WriterException("should not happen but we got: " + hVar.d());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void a(Ia ia2, C0591h hVar) throws WriterException {
        hVar.a(ia2.e(), 6);
        hVar.a(a(ia2.e(), 7973), 12);
        if (hVar.d() != 18) {
            throw new WriterException("should not happen but we got: " + hVar.d());
        }
    }

    private static void a(int i10, int i11, sc scVar) throws WriterException {
        for (int i12 = 0; i12 < 8; i12++) {
            int i13 = i10 + i12;
            if (b(scVar.a(i13, i11))) {
                scVar.a(i13, i11, 0);
            } else {
                throw new WriterException();
            }
        }
    }
}
