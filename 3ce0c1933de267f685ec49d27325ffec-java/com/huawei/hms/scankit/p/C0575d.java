package com.huawei.hms.scankit.p;

import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.mlkit.common.ha.d;
import com.huawei.hms.scankit.C0559e;
import com.huawei.hms.scankit.aiscan.common.B;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.h;
import com.huawei.hms.scankit.aiscan.common.u;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.unionpay.tsmservice.data.Constant;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
/* compiled from: Decoder.java */
/* renamed from: com.huawei.hms.scankit.p.d  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0575d {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f14758a = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f14759b = {"CTRL_PS", " ", "a", "b", "c", d.f14069a, C0559e.f14347a, "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f14760c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f14761d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", ContainerUtils.FIELD_DELIMITER, "'", "(", ")", MessageProxyConstants.NODE_ID_ANY, "+", ",", "-", ".", "/", ":", ";", "<", ContainerUtils.KEY_VALUE_DELIMITER, ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f14762e = {"CTRL_PS", " ", "0", "1", "2", Constant.APPLY_MODE_DECIDED_BY_BANK, "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: f  reason: collision with root package name */
    private C0563a f14763f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Decoder.java */
    /* renamed from: com.huawei.hms.scankit.p.d$a */
    /* loaded from: classes2.dex */
    public enum a {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    private static int a(int i10, boolean z10) {
        return ((z10 ? 88 : 112) + (i10 * 16)) * i10;
    }

    private boolean[] b(boolean[] zArr) throws C0550a {
        h hVar;
        C0563a aVar = this.f14763f;
        if (aVar != null) {
            int i10 = 8;
            if (aVar.f() <= 2) {
                i10 = 6;
                hVar = h.f14222c;
            } else if (this.f14763f.f() <= 8) {
                hVar = h.f14226g;
            } else if (this.f14763f.f() <= 22) {
                i10 = 10;
                hVar = h.f14221b;
            } else {
                i10 = 12;
                hVar = h.f14220a;
            }
            int e10 = this.f14763f.e();
            int length = zArr.length / i10;
            if (length >= e10) {
                int length2 = zArr.length % i10;
                int[] iArr = new int[length];
                int i11 = 0;
                while (i11 < length) {
                    iArr[i11] = a(zArr, length2, i10);
                    i11++;
                    length2 += i10;
                }
                try {
                    new u(hVar).a(iArr, length - e10);
                    return a(e10, i10, iArr);
                } catch (C0550a e11) {
                    throw C0550a.a(e11.getMessage());
                }
            } else {
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }

    public C0554e a(C0563a aVar, Map<EnumC0553d, ?> map) throws C0550a {
        this.f14763f = aVar;
        boolean[] b10 = b(a(aVar.a()));
        C0554e eVar = new C0554e(a(b10), a(b10, map), null, null);
        eVar.a(b10.length);
        return eVar;
    }

    private static String a(boolean[] zArr, Map<EnumC0553d, ?> map) throws C0550a {
        a aVar = a.UPPER;
        StringBuilder a10 = a(zArr, aVar, aVar);
        int length = a10.length();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = (byte) a10.charAt(i10);
        }
        try {
            return new String(bArr, B.a(bArr, map));
        } catch (UnsupportedEncodingException unused) {
            throw C0550a.a();
        }
    }

    private static StringBuilder a(boolean[] zArr, a aVar, a aVar2) {
        int length = zArr.length;
        StringBuilder sb2 = new StringBuilder(20);
        int i10 = 0;
        loop0: while (true) {
            aVar = aVar2;
            aVar2 = aVar;
            while (i10 < length) {
                if (aVar != a.BINARY) {
                    int i11 = aVar == a.DIGIT ? 4 : 5;
                    if (length - i10 < i11) {
                        break loop0;
                    }
                    int a10 = a(zArr, i10, i11);
                    i10 += i11;
                    String a11 = a(aVar, a10);
                    if (a11.startsWith("CTRL_")) {
                        aVar2 = a(a11.charAt(5));
                        if (a11.charAt(6) == 'L') {
                        }
                    } else {
                        sb2.append(a11);
                    }
                    aVar = aVar2;
                } else if (length - i10 < 5) {
                    break loop0;
                } else {
                    int a12 = a(zArr, i10, 5);
                    i10 += 5;
                    if (a12 == 0) {
                        if (length - i10 < 11) {
                            break loop0;
                        }
                        a12 = a(zArr, i10, 11) + 31;
                        i10 += 11;
                    }
                    int i12 = 0;
                    while (true) {
                        if (i12 >= a12) {
                            break;
                        } else if (length - i10 < 8) {
                            i10 = length;
                            break;
                        } else {
                            sb2.append((char) a(zArr, i10, 8));
                            i10 += 8;
                            i12++;
                        }
                    }
                    aVar = aVar2;
                }
            }
        }
        return sb2;
    }

    private static a a(char c10) {
        if (c10 == 'B') {
            return a.BINARY;
        }
        if (c10 == 'D') {
            return a.DIGIT;
        }
        if (c10 == 'P') {
            return a.PUNCT;
        }
        if (c10 == 'L') {
            return a.LOWER;
        }
        if (c10 != 'M') {
            return a.UPPER;
        }
        return a.MIXED;
    }

    private static String a(a aVar, int i10) {
        int i11 = C0571c.f14754a[aVar.ordinal()];
        if (i11 == 1) {
            return f14758a[i10];
        }
        if (i11 == 2) {
            return f14759b[i10];
        }
        if (i11 == 3) {
            return f14760c[i10];
        }
        if (i11 == 4) {
            return f14761d[i10];
        }
        if (i11 == 5) {
            return f14762e[i10];
        }
        throw new IllegalStateException("Bad table");
    }

    private boolean[] a(int i10, int i11, int[] iArr) throws C0550a {
        int i12 = (1 << i11) - 1;
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = iArr[i14];
            if (i15 == 0 || i15 == i12) {
                throw C0550a.a();
            }
            if (i15 == 1 || i15 == i12 - 1) {
                i13++;
            }
        }
        boolean[] zArr = new boolean[(i10 * i11) - i13];
        int i16 = 0;
        for (int i17 = 0; i17 < i10; i17++) {
            int i18 = iArr[i17];
            if (i18 == 1 || i18 == i12 - 1) {
                Arrays.fill(zArr, i16, (i16 + i11) - 1, i18 > 1);
                i16 += i11 - 1;
            } else {
                for (int i19 = i11 - 1; i19 >= 0; i19--) {
                    i16++;
                    zArr[i16] = ((1 << i19) & i18) != 0;
                }
            }
        }
        return zArr;
    }

    private boolean[] a(C0595i iVar) {
        C0563a aVar = this.f14763f;
        boolean z10 = aVar != null && aVar.g();
        C0563a aVar2 = this.f14763f;
        int f10 = aVar2 != null ? aVar2.f() : 0;
        int i10 = (z10 ? 11 : 14) + (f10 * 4);
        int[] iArr = new int[i10];
        boolean[] zArr = new boolean[a(f10, z10)];
        int i11 = 2;
        if (z10) {
            for (int i12 = 0; i12 < i10; i12++) {
                iArr[i12] = i12;
            }
        } else {
            int i13 = i10 / 2;
            int i14 = ((i10 + 1) + (((i13 - 1) / 15) * 2)) / 2;
            for (int i15 = 0; i15 < i13; i15++) {
                int i16 = (i15 / 15) + i15;
                iArr[(i13 - i15) - 1] = (i14 - i16) - 1;
                iArr[i13 + i15] = i16 + i14 + 1;
            }
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < f10) {
            int i19 = ((f10 - i17) * 4) + (z10 ? 9 : 12);
            int i20 = i17 * 2;
            int i21 = (i10 - 1) - i20;
            int i22 = 0;
            while (i22 < i19) {
                int i23 = i22 * 2;
                int i24 = 0;
                while (i24 < i11) {
                    int i25 = i20 + i24;
                    int i26 = i20 + i22;
                    zArr[i18 + i23 + i24] = iVar.b(iArr[i25], iArr[i26]);
                    int i27 = i21 - i24;
                    zArr[(i19 * 2) + i18 + i23 + i24] = iVar.b(iArr[i26], iArr[i27]);
                    int i28 = i21 - i22;
                    z10 = z10;
                    zArr[(i19 * 4) + i18 + i23 + i24] = iVar.b(iArr[i27], iArr[i28]);
                    zArr[(i19 * 6) + i18 + i23 + i24] = iVar.b(iArr[i28], iArr[i25]);
                    i24++;
                    i11 = 2;
                }
                i22++;
                i11 = 2;
            }
            i18 += i19 * 8;
            i17++;
            i11 = 2;
        }
        return zArr;
    }

    private static int a(boolean[] zArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i10 + i11; i13++) {
            i12 <<= 1;
            if (zArr[i13]) {
                i12 |= 1;
            }
        }
        return i12;
    }

    private static byte a(boolean[] zArr, int i10) {
        int a10;
        int length = zArr.length - i10;
        if (length >= 8) {
            a10 = a(zArr, i10, 8);
        } else {
            a10 = a(zArr, i10, length) << (8 - length);
        }
        return (byte) a10;
    }

    static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = a(zArr, i10 * 8);
        }
        return bArr;
    }
}
