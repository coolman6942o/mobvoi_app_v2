package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import com.realsil.sdk.dfu.DfuException;
import java.util.Arrays;
import java.util.Map;
/* compiled from: Code93Reader.java */
/* loaded from: classes2.dex */
public final class B extends H {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14443a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f14444b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f14445c;

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f14446d = new StringBuilder(20);

    /* renamed from: e  reason: collision with root package name */
    private final int[] f14447e = new int[6];

    static {
        int[] iArr = {DfuException.ERROR_REQUEST_MTU_NO_CALLBACK, 328, 324, 322, 296, 292, 290, 336, DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, DfuException.ERROR_DFU_SPP_RWS_NOT_READY, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f14444b = iArr;
        f14445c = iArr[47];
    }

    private static int b(int[] iArr) {
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        int length = iArr.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            int round = Math.round((iArr[i13] * 9.0f) / i10);
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i13 & 1) == 0) {
                for (int i14 = 0; i14 < round; i14++) {
                    i12 = (i12 << 1) | 1;
                }
            } else {
                i12 <<= round;
            }
        }
        return i12;
    }

    @Override // com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        int[] a10;
        int b10 = hVar.b(a(hVar)[1]);
        int d10 = hVar.d();
        int[] iArr = this.f14447e;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f14446d;
        sb2.setLength(0);
        while (true) {
            H.a(hVar, b10, iArr);
            int b11 = b(iArr);
            if (b11 >= 0) {
                char a11 = a(b11);
                sb2.append(a11);
                int i11 = b10;
                for (int i12 : iArr) {
                    i11 += i12;
                }
                int b12 = hVar.b(i11);
                if (a11 == '*') {
                    sb2.deleteCharAt(sb2.length() - 1);
                    int i13 = 0;
                    for (int i14 : iArr) {
                        i13 += i14;
                    }
                    if (b12 == d10 || !hVar.a(b12)) {
                        throw C0550a.a();
                    } else if (sb2.length() >= 2) {
                        a(sb2);
                        sb2.setLength(sb2.length() - 2);
                        float f10 = i10;
                        return new x(b(sb2), null, new z[]{new z(a10[0], f10), new z(b10 + ((i13 * 10) / 9), f10)}, BarcodeFormat.CODE_93);
                    } else {
                        throw C0550a.a();
                    }
                } else {
                    b10 = b12;
                }
            } else {
                throw C0550a.a();
            }
        }
    }

    private static String b(CharSequence charSequence) throws C0550a {
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i10 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt < 'a' || charAt > 'd') {
                sb2.append(charAt);
            } else if (i10 < length - 1) {
                i10++;
                sb2.append(a(charAt, charSequence.charAt(i10)));
            } else {
                throw C0550a.a();
            }
            i10++;
        }
        return sb2.toString();
    }

    private int[] a(C0591h hVar) throws C0550a {
        int d10 = hVar.d();
        int b10 = hVar.b(0);
        Arrays.fill(this.f14447e, 0);
        int[] iArr = this.f14447e;
        int length = iArr.length;
        boolean z10 = false;
        int i10 = 0;
        int i11 = b10;
        while (b10 < d10) {
            if (hVar.a(b10) == z10) {
                if (i10 != length - 1) {
                    i10++;
                } else if (b(iArr) == f14445c) {
                    return new int[]{i11, b10};
                } else {
                    i11 += iArr[0] + iArr[1];
                    int i12 = i10 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i12);
                    iArr[i12] = 0;
                    iArr[i10] = 0;
                    i10--;
                }
                iArr[i10] = 1;
                z10 = !z10;
            } else if (i10 < 0 || i10 >= iArr.length) {
                throw C0550a.a();
            } else {
                iArr[i10] = iArr[i10] + 1;
            }
            b10++;
        }
        throw C0550a.a();
    }

    private static char a(int i10) throws C0550a {
        int i11 = 0;
        while (true) {
            int[] iArr = f14444b;
            if (i11 >= iArr.length) {
                throw C0550a.a();
            } else if (iArr[i11] == i10) {
                return f14443a[i11];
            } else {
                i11++;
            }
        }
    }

    private static char a(char c10, char c11) throws C0550a {
        int i10;
        switch (c10) {
            case 'a':
                if (c11 >= 'A' && c11 <= 'Z') {
                    i10 = c11 - '@';
                    break;
                } else {
                    throw C0550a.a();
                }
            case 'b':
                if (c11 < 'A' || c11 > 'E') {
                    if (c11 < 'F' || c11 > 'J') {
                        if (c11 < 'K' || c11 > 'O') {
                            if (c11 >= 'P' && c11 <= 'S') {
                                i10 = c11 + '+';
                                break;
                            } else if (c11 >= 'T' && c11 <= 'Z') {
                                return (char) 127;
                            } else {
                                throw C0550a.a();
                            }
                        } else {
                            i10 = c11 + 16;
                            break;
                        }
                    } else {
                        i10 = c11 - 11;
                        break;
                    }
                } else {
                    i10 = c11 - '&';
                    break;
                }
                break;
            case 'c':
                if (c11 >= 'A' && c11 <= 'O') {
                    i10 = c11 - ' ';
                    break;
                } else if (c11 == 'Z') {
                    return ':';
                } else {
                    throw C0550a.a();
                }
            case 'd':
                if (c11 >= 'A' && c11 <= 'Z') {
                    i10 = c11 + ' ';
                    break;
                } else {
                    throw C0550a.a();
                }
            default:
                return (char) 0;
        }
        return (char) i10;
    }

    private static void a(CharSequence charSequence) throws C0550a {
        int length = charSequence.length();
        a(charSequence, length - 2, 20);
        a(charSequence, length - 1, 15);
    }

    private static void a(CharSequence charSequence, int i10, int i11) throws C0550a {
        int i12 = 0;
        int i13 = 1;
        for (int i14 = i10 - 1; i14 >= 0; i14--) {
            i12 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i14)) * i13;
            i13++;
            if (i13 > i11) {
                i13 = 1;
            }
        }
        if (charSequence.charAt(i10) != f14443a[i12 % 47]) {
            throw C0550a.a();
        }
    }
}
