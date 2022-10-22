package com.huawei.hms.scankit.aiscan.common;

import java.nio.charset.Charset;
import java.util.Map;
/* compiled from: StringUtils.java */
/* loaded from: classes2.dex */
public final class B {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14135a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f14136b;

    static {
        String name = Charset.defaultCharset().name();
        f14135a = name;
        f14136b = "SJIS".equalsIgnoreCase(name) || "EUC_JP".equalsIgnoreCase(name);
    }

    public static String a(byte[] bArr, Map<EnumC0553d, ?> map) {
        if (map != null) {
            EnumC0553d dVar = EnumC0553d.CHARACTER_SET;
            if (map.containsKey(dVar)) {
                return map.get(dVar).toString();
            }
        }
        int[] iArr = new int[15];
        iArr[0] = bArr.length;
        iArr[1] = 1;
        iArr[2] = 1;
        iArr[3] = 1;
        boolean z10 = bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65;
        for (int i10 = 0; i10 < iArr[0] && (iArr[1] == 1 || iArr[2] == 1 || iArr[3] == 1); i10++) {
            int i11 = bArr[i10] & 255;
            c(i11, iArr);
            b(i11, iArr);
            a(i11, iArr);
        }
        return a(bArr, iArr[3] == 1, iArr[2] == 1, iArr[1] == 1, iArr[4], iArr[8], z10, iArr[5], iArr[6], iArr[7], iArr[12], iArr[13], iArr[9], iArr[14], iArr[0]);
    }

    private static void b(int i10, int[] iArr) {
        if (iArr[2] != 1) {
            return;
        }
        if (iArr[8] > 0) {
            if (i10 < 64 || i10 == 127 || i10 > 252) {
                iArr[2] = 0;
            } else {
                iArr[8] = iArr[8] - 1;
            }
        } else if (i10 == 128 || i10 == 160 || i10 > 239) {
            iArr[2] = 0;
        } else if (i10 > 160 && i10 < 224) {
            iArr[9] = iArr[9] + 1;
            iArr[11] = 0;
            iArr[10] = iArr[10] + 1;
            if (iArr[10] > iArr[12]) {
                iArr[12] = iArr[10];
            }
        } else if (i10 > 127) {
            iArr[8] = iArr[8] + 1;
            iArr[10] = 0;
            iArr[11] = iArr[11] + 1;
            if (iArr[11] > iArr[13]) {
                iArr[13] = iArr[11];
            }
        } else {
            iArr[10] = 0;
            iArr[11] = 0;
        }
    }

    private static void c(int i10, int[] iArr) {
        if (iArr[3] != 1) {
            return;
        }
        if (iArr[4] > 0) {
            if ((i10 & 128) == 0) {
                iArr[3] = 0;
            } else {
                iArr[4] = iArr[4] - 1;
            }
        } else if ((i10 & 128) == 0) {
        } else {
            if ((i10 & 64) == 0) {
                iArr[3] = 0;
                return;
            }
            iArr[4] = iArr[4] + 1;
            if ((i10 & 32) == 0) {
                iArr[5] = iArr[5] + 1;
                return;
            }
            iArr[4] = iArr[4] + 1;
            if ((i10 & 16) == 0) {
                iArr[6] = iArr[6] + 1;
                return;
            }
            iArr[4] = iArr[4] + 1;
            if ((i10 & 8) == 0) {
                iArr[7] = iArr[7] + 1;
            } else {
                iArr[3] = 0;
            }
        }
    }

    private static void a(int i10, int[] iArr) {
        if (iArr[1] != 1) {
            return;
        }
        if (i10 > 127 && i10 < 160) {
            iArr[1] = 0;
        } else if (i10 <= 159) {
        } else {
            if (i10 < 192 || i10 == 215 || i10 == 247) {
                iArr[14] = iArr[14] + 1;
            }
        }
    }

    public static String a(byte[] bArr, boolean z10, boolean z11, boolean z12, int i10, int i11, boolean z13, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        if (z10 && i10 > 0) {
            z10 = false;
        }
        if (z11 && i11 > 0) {
            z11 = false;
        }
        return (!z10 || (!z13 && (i12 + i13) + i14 <= 0)) ? a(bArr).booleanValue() ? "GBK" : (!z11 || (!f14136b && i15 < 3 && i16 < 3)) ? (!z12 || !z11) ? (!z12 || i18 * 10 >= i19) ? z11 ? "SJIS" : z10 ? "UTF8" : (z10 || !"UTF-8".equals(f14135a)) ? f14135a : "GB2312" : "ISO8859_1" : (!(i15 == 2 && i17 == 2) && i18 * 10 < i19) ? "ISO8859_1" : "SJIS" : "SJIS" : "UTF8";
    }

    public static Boolean a(byte[] bArr) {
        int length = bArr.length;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = true;
                break;
            }
            byte b10 = bArr[i10];
            if ((b10 & 128) != 0) {
                int i11 = b10 & 255;
                if ((i11 >= 170 || i11 <= 160) && (i11 >= 248 || i11 <= 175)) {
                    if (i11 >= 161 || i11 <= 128) {
                        if (((i11 >= 255 || i11 <= 169) && (i11 >= 170 || i11 <= 167)) || (i10 = i10 + 1) >= length || (bArr[i10] & 255) >= 161 || (bArr[i10] & 255) <= 63 || (bArr[i10] & 255) == 127) {
                            break;
                        }
                    } else {
                        i10++;
                        if (i10 >= length || (bArr[i10] & 255) >= 255 || (bArr[i10] & 255) <= 63 || (bArr[i10] & 255) == 127) {
                            break;
                        }
                    }
                } else {
                    i10++;
                    if (i10 >= length || (bArr[i10] & 255) >= 255 || (bArr[i10] & 255) <= 160 || (bArr[i10] & 255) == 127) {
                        break;
                    }
                }
            }
            i10++;
        }
        return Boolean.valueOf(z10);
    }
}
