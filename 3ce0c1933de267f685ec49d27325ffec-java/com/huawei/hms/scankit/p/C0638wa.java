package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.B;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0552c;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.util.b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* compiled from: DecodedBitStreamParser.java */
/* renamed from: com.huawei.hms.scankit.p.wa  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0638wa {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14996a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0554e a(byte[] bArr, Ia ia2, EnumC0647za zaVar, Map<EnumC0553d, ?> map) throws C0550a {
        Fa a10;
        int i10;
        int i11;
        C0599j jVar = new C0599j(bArr);
        StringBuilder sb2 = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int i12 = -1;
        int i13 = -1;
        int i14 = 0;
        while (true) {
            try {
                if (jVar.a() < 4) {
                    a10 = Fa.TERMINATOR;
                } else {
                    a10 = Fa.a(jVar.a(4));
                }
                Fa fa2 = a10;
                int[] iArr = {i14, i12, i13};
                a(fa2, jVar, sb2, ia2, iArr, null, arrayList, map);
                i14 = iArr[0] == 1 ? 1 : 0;
                i10 = iArr[1];
                i11 = iArr[2];
                if (fa2 == Fa.TERMINATOR) {
                    break;
                }
                i12 = i10;
                i13 = i11;
            } catch (IllegalArgumentException unused) {
                throw C0550a.a();
            }
        }
        return new C0554e(bArr, sb2.toString(), arrayList.isEmpty() ? null : arrayList, zaVar == null ? null : zaVar.toString(), i10, i11);
    }

    private static void b(C0599j jVar, StringBuilder sb2, int i10) throws C0550a {
        if (i10 * 13 <= jVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i11 = 0;
            while (i10 > 0) {
                int a10 = jVar.a(13);
                int i12 = (a10 % 192) | ((a10 / 192) << 8);
                int i13 = i12 + (i12 < 7936 ? 33088 : 49472);
                try {
                    if (b.a(bArr, i11)) {
                        int i14 = i11 + 1;
                        if (b.a(bArr, i14)) {
                            bArr[i11] = (byte) (i13 >> 8);
                            bArr[i14] = (byte) i13;
                            i11 += 2;
                            i10--;
                        }
                    }
                    throw new ArrayIndexOutOfBoundsException();
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw e10;
                }
            }
            try {
                sb2.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }

    private static void c(C0599j jVar, StringBuilder sb2, int i10) throws C0550a {
        while (i10 >= 3) {
            if (jVar.a() >= 10) {
                int a10 = jVar.a(10);
                if (a10 < 1000) {
                    sb2.append(a(a10 / 100));
                    sb2.append(a((a10 / 10) % 10));
                    sb2.append(a(a10 % 10));
                    i10 -= 3;
                } else {
                    throw C0550a.a();
                }
            } else {
                throw C0550a.a();
            }
        }
        if (i10 == 2) {
            if (jVar.a() >= 7) {
                int a11 = jVar.a(7);
                if (a11 < 100) {
                    sb2.append(a(a11 / 10));
                    sb2.append(a(a11 % 10));
                    return;
                }
                throw C0550a.a();
            }
            throw C0550a.a();
        } else if (i10 != 1) {
        } else {
            if (jVar.a() >= 4) {
                int a12 = jVar.a(4);
                if (a12 < 10) {
                    sb2.append(a(a12));
                    return;
                }
                throw C0550a.a();
            }
            throw C0550a.a();
        }
    }

    private static void a(Fa fa2, C0599j jVar, StringBuilder sb2, Ia ia2, int[] iArr, EnumC0552c cVar, List<byte[]> list, Map<EnumC0553d, ?> map) throws C0550a {
        int[] iArr2 = C0635va.f14991a;
        boolean z10 = false;
        switch (iArr2[fa2.ordinal()]) {
            case 5:
                return;
            case 6:
            case 7:
                iArr[0] = 1;
                return;
            case 8:
                if (jVar.a() >= 16) {
                    iArr[1] = jVar.a(8);
                    iArr[2] = jVar.a(8);
                    return;
                }
                throw C0550a.a();
            case 9:
                if (EnumC0552c.a(a(jVar)) == null) {
                    throw C0550a.a();
                }
                return;
            case 10:
                int a10 = jVar.a(4);
                int a11 = jVar.a(fa2.a(ia2));
                if (a10 == 1) {
                    a(jVar, sb2, a11);
                    return;
                }
                return;
            default:
                int a12 = jVar.a(fa2.a(ia2));
                int i10 = iArr2[fa2.ordinal()];
                if (i10 == 1) {
                    c(jVar, sb2, a12);
                    return;
                } else if (i10 == 2) {
                    if (iArr[0] == 1) {
                        z10 = true;
                    }
                    a(jVar, sb2, a12, z10);
                    return;
                } else if (i10 == 3) {
                    a(jVar, sb2, a12, cVar, list, map);
                    return;
                } else if (i10 == 4) {
                    b(jVar, sb2, a12);
                    return;
                } else {
                    throw C0550a.a();
                }
        }
    }

    private static void a(C0599j jVar, StringBuilder sb2, int i10) throws C0550a {
        if (i10 * 13 <= jVar.a()) {
            byte[] bArr = new byte[i10 * 2];
            int i11 = 0;
            while (i10 > 0) {
                int a10 = jVar.a(13);
                int i12 = (a10 % 96) | ((a10 / 96) << 8);
                int i13 = i12 + (i12 < 959 ? 41377 : 42657);
                try {
                    if (b.a(bArr, i11)) {
                        int i14 = i11 + 1;
                        if (b.a(bArr, i14)) {
                            bArr[i11] = (byte) ((i13 >> 8) & 255);
                            bArr[i14] = (byte) (i13 & 255);
                            i11 += 2;
                            i10--;
                        }
                    }
                    throw new ArrayIndexOutOfBoundsException();
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw e10;
                }
            }
            try {
                sb2.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }

    private static void a(C0599j jVar, StringBuilder sb2, int i10, EnumC0552c cVar, Collection<byte[]> collection, Map<EnumC0553d, ?> map) throws C0550a {
        String str;
        if (i10 * 8 <= jVar.a()) {
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr[i11] = (byte) jVar.a(8);
            }
            if (cVar == null) {
                str = B.a(bArr, map);
            } else {
                str = cVar.name();
            }
            try {
                sb2.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }

    private static char a(int i10) throws C0550a {
        char[] cArr = f14996a;
        if (i10 < cArr.length) {
            return cArr[i10];
        }
        throw C0550a.a();
    }

    private static void a(C0599j jVar, StringBuilder sb2, int i10, boolean z10) throws C0550a {
        while (i10 > 1) {
            if (jVar.a() >= 11) {
                int a10 = jVar.a(11);
                sb2.append(a(a10 / 45));
                sb2.append(a(a10 % 45));
                i10 -= 2;
            } else {
                throw C0550a.a();
            }
        }
        if (i10 == 1) {
            if (jVar.a() >= 6) {
                sb2.append(a(jVar.a(6)));
            } else {
                throw C0550a.a();
            }
        }
        if (z10) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i11 = length + 1;
                        if (sb2.charAt(i11) == '%') {
                            sb2.deleteCharAt(i11);
                        }
                    }
                    sb2.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static int a(C0599j jVar) throws C0550a {
        int a10 = jVar.a(8);
        if ((a10 & 128) == 0) {
            return a10 & 127;
        }
        if ((a10 & 192) == 128) {
            return jVar.a(8) | ((a10 & 63) << 8);
        }
        if ((a10 & 224) == 192) {
            return jVar.a(16) | ((a10 & 31) << 16);
        }
        throw C0550a.a();
    }
}
