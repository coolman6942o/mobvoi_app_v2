package gp;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import kotlin.text.u;
import okio.c;
/* compiled from: hostnames.kt */
/* loaded from: classes3.dex */
public final class a {
    private static final boolean a(String str) {
        int S;
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (i.h(charAt, 31) <= 0 || i.h(charAt, 127) >= 0) {
                return true;
            }
            S = u.S(" #%/:?@[\\]", charAt, 0, false, 6, null);
            if (S != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean b(String str, int i10, int i11, byte[] bArr, int i12) {
        int i13 = i12;
        while (i10 < i11) {
            if (i13 == bArr.length) {
                return false;
            }
            if (i13 != i12) {
                if (str.charAt(i10) != '.') {
                    return false;
                }
                i10++;
            }
            int i14 = i10;
            int i15 = 0;
            while (i14 < i11) {
                char charAt = str.charAt(i14);
                if (i.h(charAt, 48) < 0 || i.h(charAt, 57) > 0) {
                    break;
                } else if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i14++;
                }
            }
            if (i14 - i10 == 0) {
                return false;
            }
            i13++;
            bArr[i13] = (byte) i15;
            i10 = i14;
        }
        return i13 == i12 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0097, code lost:
        if (r13 == 16) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0099, code lost:
        if (r14 != (-1)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x009b, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009c, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ae, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final InetAddress c(String str, int i10, int i11) {
        int i12;
        boolean C;
        boolean C2;
        boolean C3;
        byte[] bArr = new byte[16];
        int i13 = i10;
        int i14 = -1;
        int i15 = -1;
        int i16 = 0;
        while (true) {
            if (i13 < i11) {
                if (i16 != 16) {
                    int i17 = i13 + 2;
                    if (i17 <= i11) {
                        C3 = t.C(str, "::", i13, false, 4, null);
                        if (C3) {
                            if (i14 != -1) {
                                return null;
                            }
                            i16 += 2;
                            if (i17 == i11) {
                                i14 = i16;
                                break;
                            }
                            i15 = i17;
                            i14 = i16;
                            i13 = i15;
                            int i18 = 0;
                            while (i13 < i11) {
                                int E = b.E(str.charAt(i13));
                                if (E == -1) {
                                    break;
                                }
                                i18 = (i18 << 4) + E;
                                i13++;
                            }
                            i12 = i13 - i15;
                            if (i12 == 0 || i12 > 4) {
                                break;
                            }
                            int i19 = i16 + 1;
                            bArr[i16] = (byte) ((i18 >>> 8) & 255);
                            i16 = i19 + 1;
                            bArr[i19] = (byte) (i18 & 255);
                        }
                    }
                    if (i16 != 0) {
                        C = t.C(str, ":", i13, false, 4, null);
                        if (C) {
                            i13++;
                        } else {
                            C2 = t.C(str, ".", i13, false, 4, null);
                            if (!C2 || !b(str, i15, i11, bArr, i16 - 2)) {
                                return null;
                            }
                            i16 += 2;
                        }
                    }
                    i15 = i13;
                    i13 = i15;
                    int i182 = 0;
                    while (i13 < i11) {
                    }
                    i12 = i13 - i15;
                    if (i12 == 0) {
                        break;
                    }
                    break;
                }
                return null;
            }
            break;
        }
        return null;
    }

    private static final String d(byte[] bArr) {
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        while (i12 < bArr.length) {
            int i14 = i12;
            while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i11 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        c cVar = new c();
        while (i10 < bArr.length) {
            if (i10 == i11) {
                cVar.C(58);
                i10 += i13;
                if (i10 == 16) {
                    cVar.C(58);
                }
            } else {
                if (i10 > 0) {
                    cVar.C(58);
                }
                cVar.c0((b.b(bArr[i10], 255) << 8) | b.b(bArr[i10 + 1], 255));
                i10 += 2;
            }
        }
        return cVar.V();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String e(String toCanonicalHost) {
        boolean I;
        boolean D;
        InetAddress inetAddress;
        boolean o10;
        i.f(toCanonicalHost, "$this$toCanonicalHost");
        boolean z10 = false;
        I = u.I(toCanonicalHost, ":", false, 2, null);
        if (I) {
            D = t.D(toCanonicalHost, "[", false, 2, null);
            if (D) {
                o10 = t.o(toCanonicalHost, "]", false, 2, null);
                if (o10) {
                    inetAddress = c(toCanonicalHost, 1, toCanonicalHost.length() - 1);
                    if (inetAddress != null) {
                        return null;
                    }
                    byte[] address = inetAddress.getAddress();
                    if (address.length == 16) {
                        i.e(address, "address");
                        return d(address);
                    } else if (address.length == 4) {
                        return inetAddress.getHostAddress();
                    } else {
                        throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
                    }
                }
            }
            inetAddress = c(toCanonicalHost, 0, toCanonicalHost.length());
            if (inetAddress != null) {
            }
        } else {
            try {
                String ascii = IDN.toASCII(toCanonicalHost);
                i.e(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                i.e(locale, "Locale.US");
                if (ascii != null) {
                    String lowerCase = ascii.toLowerCase(locale);
                    i.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (lowerCase.length() == 0) {
                        z10 = true;
                    }
                    if (!z10 && !a(lowerCase)) {
                        return lowerCase;
                    }
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }
}
