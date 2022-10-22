package com.huawei.hms.scankit.p;

import com.huawei.agconnect.exception.AGCServerException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import com.realsil.sdk.dfu.DfuException;
import java.util.Arrays;
import java.util.Map;
/* compiled from: Code39Reader.java */
/* loaded from: classes2.dex */
public final class A extends H {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f14427a = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, DfuException.ERROR_CANNOT_FIND_DEVICE, 73, 328, 25, DfuException.ERROR_ENTER_OTA_MODE_FAILED, 88, 13, DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES, 76, 28, DfuException.ERROR_LOCK_WAIT_INTERRUPTED, 67, 322, 19, DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, 82, 7, DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, 70, 22, 385, 193, 448, 145, AGCServerException.AUTHENTICATION_INVALID, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f14428b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f14429c;

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f14430d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f14431e;

    public A() {
        this(false);
    }

    private static boolean b(int[] iArr) {
        int i10 = Integer.MAX_VALUE;
        int i11 = 0;
        for (int i12 : iArr) {
            if (i12 < i10) {
                i10 = i12;
            }
            if (i12 > i11) {
                i11 = i12;
            }
        }
        return i11 / i10 > 6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r1 >= r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r5 <= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
        r3 = r11[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r3 <= r4) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
        if ((r3 * 2) < r6) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int c(int[] iArr) {
        int length = iArr.length;
        if (b(iArr)) {
            return -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = Integer.MAX_VALUE;
            for (int i13 : iArr) {
                if (i13 < i12 && i13 > i11) {
                    i12 = i13;
                }
            }
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < length; i17++) {
                int i18 = iArr[i17];
                if (i18 > i12) {
                    i16 |= 1 << ((length - 1) - i17);
                    i14++;
                    i15 += i18;
                }
            }
            if (i14 == 3) {
                break;
            } else if (i14 <= 3) {
                return -1;
            } else {
                i11 = i12;
            }
        }
    }

    @Override // com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        int[] iArr = this.f14431e;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f14430d;
        sb2.setLength(0);
        int[] a10 = a(hVar, iArr);
        int b10 = hVar.b(a10[1]);
        int d10 = hVar.d();
        while (true) {
            H.a(hVar, b10, iArr);
            int c10 = c(iArr);
            if (c10 >= 0) {
                char a11 = a(c10);
                sb2.append(a11);
                int i11 = b10;
                for (int i12 : iArr) {
                    i11 += i12;
                }
                int b11 = hVar.b(i11);
                if (a11 == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i13 = 0;
                    for (int i14 : iArr) {
                        i13 += i14;
                    }
                    int i15 = (b11 - b10) - i13;
                    if (b11 == d10 || i15 * 5 >= i13) {
                        return a(sb2, a10, b10, i13, i10);
                    }
                    throw C0550a.a();
                }
                b10 = b11;
            } else {
                throw C0550a.a();
            }
        }
    }

    public A(boolean z10) {
        this(z10, false);
    }

    public A(boolean z10, boolean z11) {
        this.f14428b = z10;
        this.f14429c = z11;
        this.f14430d = new StringBuilder(20);
        this.f14431e = new int[9];
    }

    private x a(StringBuilder sb2, int[] iArr, int i10, int i11, int i12) throws C0550a {
        String str;
        if (this.f14428b) {
            int length = sb2.length() - 1;
            int i13 = 0;
            for (int i14 = 0; i14 < length; i14++) {
                i13 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f14430d.charAt(i14));
            }
            if (sb2.charAt(length) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i13 % 43)) {
                sb2.setLength(length);
            } else {
                throw C0550a.a();
            }
        }
        if (sb2.length() != 0) {
            if (this.f14429c) {
                str = a(sb2);
            } else {
                str = sb2.toString();
            }
            float f10 = i12;
            return new x(str, null, new z[]{new z(iArr[0], f10), new z(i10 + i11, f10)}, BarcodeFormat.CODE_39);
        }
        throw C0550a.a();
    }

    private static int[] a(C0591h hVar, int[] iArr) throws C0550a {
        int d10 = hVar.d();
        int b10 = hVar.b(0);
        int length = iArr.length;
        boolean z10 = false;
        int i10 = 0;
        int i11 = b10;
        while (b10 < d10) {
            if (hVar.a(b10) == z10) {
                if (i10 != length - 1) {
                    i10++;
                } else if (c(iArr) == 148 && hVar.a(Math.max(0, i11 - ((b10 - i11) / 5)), i11, false, true)) {
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
            int[] iArr = f14427a;
            if (i11 < iArr.length) {
                if (iArr[i11] == i10) {
                    return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i11);
                }
                i11++;
            } else if (i10 == 148) {
                return '*';
            } else {
                throw C0550a.a();
            }
        }
    }

    private static String a(CharSequence charSequence) throws C0550a {
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        int i10 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i10++;
                sb2.append(a(charAt, charSequence.charAt(i10)));
            } else {
                sb2.append(charAt);
            }
            i10++;
        }
        return sb2.toString();
    }

    private static char a(char c10, char c11) throws C0550a {
        int i10;
        if (c10 != '$') {
            if (c10 != '%') {
                if (c10 != '+') {
                    if (c10 == '/') {
                        if (c11 >= 'A' && c11 <= 'O') {
                            i10 = c11 - ' ';
                        } else if (c11 == 'Z') {
                            return ':';
                        } else {
                            throw C0550a.a();
                        }
                    }
                    return (char) 0;
                } else if (c11 < 'A' || c11 > 'Z') {
                    throw C0550a.a();
                } else {
                    i10 = c11 + ' ';
                }
            } else if (c11 >= 'A' && c11 <= 'E') {
                i10 = c11 - '&';
            } else if (c11 >= 'F' && c11 <= 'J') {
                i10 = c11 - 11;
            } else if (c11 >= 'K' && c11 <= 'O') {
                i10 = c11 + 16;
            } else if (c11 < 'P' || c11 > 'T') {
                if (c11 != 'U') {
                    if (c11 == 'V') {
                        return '@';
                    }
                    if (c11 == 'W') {
                        return '`';
                    }
                    if (c11 == 'X' || c11 == 'Y' || c11 == 'Z') {
                        return (char) 127;
                    }
                    throw C0550a.a();
                }
                return (char) 0;
            } else {
                i10 = c11 + '+';
            }
        } else if (c11 < 'A' || c11 > 'Z') {
            throw C0550a.a();
        } else {
            i10 = c11 - '@';
        }
        return (char) i10;
    }
}
