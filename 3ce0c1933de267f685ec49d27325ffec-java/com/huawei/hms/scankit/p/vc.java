package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.EnumC0552c;
import com.huawei.hms.scankit.aiscan.common.h;
import com.huawei.hms.scankit.aiscan.common.v;
import com.huawei.hms.scankit.p.Ia;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: Encoder.java */
/* loaded from: classes2.dex */
public final class vc {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14993a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int a(sc scVar) {
        return wc.a(scVar) + wc.b(scVar) + wc.c(scVar) + wc.d(scVar);
    }

    static void b(CharSequence charSequence, C0591h hVar) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int charAt = charSequence.charAt(i10) - '0';
            int i11 = i10 + 2;
            if (i11 < length) {
                hVar.a((charAt * 100) + ((charSequence.charAt(i10 + 1) - '0') * 10) + (charSequence.charAt(i11) - '0'), 10);
                i10 += 3;
            } else {
                i10++;
                if (i10 < length) {
                    hVar.a((charAt * 10) + (charSequence.charAt(i10) - '0'), 7);
                    i10 = i11;
                } else {
                    hVar.a(charAt, 4);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static yc a(String str, EnumC0647za zaVar, Map<tc, ?> map) throws WriterException {
        Ia ia2;
        EnumC0552c a10;
        boolean z10 = true;
        boolean z11 = map != null && map.containsKey(tc.CHARACTER_SET);
        String obj = z11 ? map.get(tc.CHARACTER_SET).toString() : "ISO-8859-1";
        Fa a11 = a(str, obj);
        C0591h hVar = new C0591h();
        Fa fa2 = Fa.BYTE;
        if (a11 == fa2 && z11 && (a10 = EnumC0552c.a(obj)) != null) {
            a(a10, hVar);
        }
        if (map == null || !map.containsKey(tc.GS1_FORMAT)) {
            z10 = false;
        }
        if (z10 && Boolean.valueOf(map.get(tc.GS1_FORMAT).toString()).booleanValue()) {
            a(Fa.FNC1_FIRST_POSITION, hVar);
        }
        a(a11, hVar);
        C0591h hVar2 = new C0591h();
        a(str, a11, hVar2, obj);
        if (map != null) {
            tc tcVar = tc.QR_VERSION;
            if (map.containsKey(tcVar)) {
                try {
                    ia2 = Ia.c(Integer.parseInt(map.get(tcVar).toString()));
                    if (!a(a(a11, hVar, hVar2, ia2), ia2, zaVar)) {
                        throw new WriterException("Data too big for requested version");
                    }
                    C0591h hVar3 = new C0591h();
                    hVar3.a(hVar);
                    a(a11 != fa2 ? hVar2.e() : str.length(), ia2, a11, hVar3);
                    hVar3.a(hVar2);
                    Ia.b a12 = ia2.a(zaVar);
                    int d10 = ia2.d() - a12.d();
                    a(d10, hVar3);
                    C0591h a13 = a(hVar3, ia2.d(), d10, a12.c());
                    yc ycVar = new yc();
                    ycVar.a(zaVar);
                    ycVar.a(a11);
                    ycVar.a(ia2);
                    int c10 = ia2.c();
                    sc scVar = new sc(c10, c10);
                    int a14 = a(a13, zaVar, ia2, scVar);
                    ycVar.b(a14);
                    xc.a(a13, zaVar, ia2, a14, scVar);
                    ycVar.a(scVar);
                    return ycVar;
                } catch (Exception e10) {
                    throw e10;
                }
            }
        }
        ia2 = a(zaVar, a11, hVar, hVar2);
        C0591h hVar32 = new C0591h();
        hVar32.a(hVar);
        a(a11 != fa2 ? hVar2.e() : str.length(), ia2, a11, hVar32);
        hVar32.a(hVar2);
        Ia.b a122 = ia2.a(zaVar);
        int d102 = ia2.d() - a122.d();
        a(d102, hVar32);
        C0591h a132 = a(hVar32, ia2.d(), d102, a122.c());
        yc ycVar2 = new yc();
        ycVar2.a(zaVar);
        ycVar2.a(a11);
        ycVar2.a(ia2);
        int c102 = ia2.c();
        sc scVar2 = new sc(c102, c102);
        int a142 = a(a132, zaVar, ia2, scVar2);
        ycVar2.b(a142);
        xc.a(a132, zaVar, ia2, a142, scVar2);
        ycVar2.a(scVar2);
        return ycVar2;
    }

    private static Ia a(EnumC0647za zaVar, Fa fa2, C0591h hVar, C0591h hVar2) throws WriterException {
        return a(a(fa2, hVar, hVar2, a(a(fa2, hVar, hVar2, Ia.c(1)), zaVar)), zaVar);
    }

    private static int a(Fa fa2, C0591h hVar, C0591h hVar2, Ia ia2) {
        return hVar.d() + fa2.a(ia2) + hVar2.d();
    }

    static int a(int i10) {
        int[] iArr = f14993a;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    private static Fa a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return Fa.KANJI;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= '0' && charAt <= '9') {
                z11 = true;
            } else if (a(charAt) == -1) {
                return Fa.BYTE;
            } else {
                z10 = true;
            }
        }
        if (z10) {
            return Fa.ALPHANUMERIC;
        }
        if (z11) {
            return Fa.NUMERIC;
        }
        return Fa.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i10 = 0; i10 < length; i10 += 2) {
                int i11 = bytes[i10] & 255;
                if ((i11 < 129 || i11 > 159) && (i11 < 224 || i11 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(C0591h hVar, EnumC0647za zaVar, Ia ia2, sc scVar) throws WriterException {
        int i10 = Integer.MAX_VALUE;
        int i11 = -1;
        for (int i12 = 0; i12 < 8; i12++) {
            xc.a(hVar, zaVar, ia2, i12, scVar);
            int a10 = a(scVar);
            if (a10 < i10) {
                i11 = i12;
                i10 = a10;
            }
        }
        return i11;
    }

    private static Ia a(int i10, EnumC0647za zaVar) throws WriterException {
        for (int i11 = 1; i11 <= 40; i11++) {
            Ia c10 = Ia.c(i11);
            if (a(i10, c10, zaVar)) {
                return c10;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i10, Ia ia2, EnumC0647za zaVar) {
        return ia2.d() - ia2.a(zaVar).d() >= (i10 + 7) / 8;
    }

    static void a(int i10, C0591h hVar) throws WriterException {
        int i11 = i10 * 8;
        if (hVar.d() <= i11) {
            for (int i12 = 0; i12 < 4 && hVar.d() < i11; i12++) {
                hVar.a(false);
            }
            int d10 = hVar.d() & 7;
            if (d10 > 0) {
                while (d10 < 8) {
                    hVar.a(false);
                    d10++;
                }
            }
            int e10 = i10 - hVar.e();
            for (int i13 = 0; i13 < e10; i13++) {
                hVar.a((i13 & 1) == 0 ? 236 : 17, 8);
            }
            if (hVar.d() != i11) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + hVar.d() + " > " + i11);
    }

    static void a(int i10, int i11, int i12, int i13, int[] iArr, int[] iArr2) throws WriterException {
        if (i13 < i12) {
            int i14 = i10 % i12;
            int i15 = i12 - i14;
            int i16 = i10 / i12;
            int i17 = i16 + 1;
            int i18 = i11 / i12;
            int i19 = i18 + 1;
            int i20 = i16 - i18;
            int i21 = i17 - i19;
            if (i20 != i21) {
                throw new WriterException("EC bytes mismatch");
            } else if (i12 != i15 + i14) {
                throw new WriterException("RS blocks mismatch");
            } else if (i10 != ((i18 + i20) * i15) + ((i19 + i21) * i14)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i13 < i15) {
                iArr[0] = i18;
                iArr2[0] = i20;
            } else {
                iArr[0] = i19;
                iArr2[0] = i21;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    static C0591h a(C0591h hVar, int i10, int i11, int i12) throws WriterException {
        if (hVar.e() == i11) {
            ArrayList<rc> arrayList = new ArrayList(i12);
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i10, i11, i12, i16, iArr, iArr2);
                int i17 = iArr[0];
                byte[] bArr = new byte[i17];
                hVar.a(i13 * 8, bArr, 0, i17);
                byte[] a10 = a(bArr, iArr2[0]);
                arrayList.add(new rc(bArr, a10));
                i15 = Math.max(i15, i17);
                i14 = Math.max(i14, a10.length);
                i13 += iArr[0];
            }
            if (i11 == i13) {
                C0591h hVar2 = new C0591h();
                for (int i18 = 0; i18 < i15; i18++) {
                    for (rc rcVar : arrayList) {
                        byte[] a11 = rcVar.a();
                        if (i18 < a11.length) {
                            hVar2.a(a11[i18], 8);
                        }
                    }
                }
                for (int i19 = 0; i19 < i14; i19++) {
                    for (rc rcVar2 : arrayList) {
                        byte[] b10 = rcVar2.b();
                        if (i19 < b10.length) {
                            hVar2.a(b10[i19], 8);
                        }
                    }
                }
                if (i10 == hVar2.e()) {
                    return hVar2;
                }
                throw new WriterException("Interleaving error: " + i10 + " and " + hVar2.e() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i10) {
        int length = bArr.length;
        int[] iArr = new int[length + i10];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        new v(h.f14224e).a(iArr, i10);
        byte[] bArr2 = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr2[i12] = (byte) iArr[length + i12];
        }
        return bArr2;
    }

    static void a(Fa fa2, C0591h hVar) {
        hVar.a(fa2.a(), 4);
    }

    static void a(int i10, Ia ia2, Fa fa2, C0591h hVar) throws WriterException {
        int a10 = fa2.a(ia2);
        int i11 = 1 << a10;
        if (i10 < i11) {
            hVar.a(i10, a10);
            return;
        }
        throw new WriterException(i10 + " is bigger than " + (i11 - 1));
    }

    static void a(String str, Fa fa2, C0591h hVar, String str2) throws WriterException {
        int i10 = uc.f14968a[fa2.ordinal()];
        if (i10 == 1) {
            b(str, hVar);
        } else if (i10 == 2) {
            a((CharSequence) str, hVar);
        } else if (i10 == 3) {
            a(str, hVar, str2);
        } else if (i10 == 4) {
            a(str, hVar);
        } else {
            throw new WriterException("Invalid mode: " + fa2);
        }
    }

    static void a(CharSequence charSequence, C0591h hVar) throws WriterException {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length) {
            int a10 = a(charSequence.charAt(i10));
            if (a10 != -1) {
                int i11 = i10 + 1;
                if (i11 < length) {
                    int a11 = a(charSequence.charAt(i11));
                    if (a11 != -1) {
                        hVar.a((a10 * 45) + a11, 11);
                        i10 += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    hVar.a(a10, 6);
                    i10 = i11;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    static void a(String str, C0591h hVar, String str2) throws WriterException {
        try {
            for (byte b10 : str.getBytes(str2)) {
                hVar.a(b10, 8);
            }
        } catch (UnsupportedEncodingException e10) {
            throw new WriterException(e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035 A[LOOP:0: B:5:0x0008->B:18:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void a(String str, C0591h hVar) throws WriterException {
        int i10;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i11 = 0; i11 < length; i11 += 2) {
                int i12 = ((bytes[i11] & 255) << 8) | (bytes[i11 + 1] & 255);
                int i13 = 33088;
                if (i12 < 33088 || i12 > 40956) {
                    if (i12 < 57408 || i12 > 60351) {
                        i10 = -1;
                        if (i10 == -1) {
                            hVar.a(((i10 >> 8) * 192) + (i10 & 255), 13);
                        } else {
                            throw new WriterException("Invalid byte sequence");
                        }
                    } else {
                        i13 = 49472;
                    }
                }
                i10 = i12 - i13;
                if (i10 == -1) {
                }
            }
        } catch (UnsupportedEncodingException e10) {
            throw new WriterException(e10);
        }
    }

    private static void a(EnumC0552c cVar, C0591h hVar) {
        hVar.a(Fa.ECI.a(), 4);
        hVar.a(cVar.a(), 8);
    }
}
