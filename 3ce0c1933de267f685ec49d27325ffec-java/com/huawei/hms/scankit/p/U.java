package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.B;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0552c;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes2.dex */
final class U {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f14682a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f14683b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final BigInteger[] f14684c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes2.dex */
    public enum a {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f14684c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f14684c;
            if (i10 < bigIntegerArr2.length) {
                bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(valueOf);
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0554e a(int[] iArr, String str, Map<EnumC0553d, ?> map) throws C0550a {
        int i10;
        int i11;
        StringBuilder sb2 = new StringBuilder(iArr.length * 2);
        Charset charset = StandardCharsets.ISO_8859_1;
        int i12 = iArr[1];
        C0588ga gaVar = new C0588ga();
        Charset charset2 = charset;
        int i13 = 2;
        int i14 = i12;
        while (true) {
            if (i13 > iArr[0] || (i13 == iArr[0] && sb2.length() > 0)) {
                break;
            }
            if (i14 == 927) {
                i11 = i13 + 1;
                charset2 = Charset.forName(EnumC0552c.a(iArr[i13]).name());
            } else {
                i11 = a(sb2, i14, iArr, i13, charset2, gaVar);
            }
            if (i11 < iArr.length) {
                i13 = i11 + 1;
                i14 = iArr[i11];
            } else {
                throw C0550a.a();
            }
        }
        if (sb2.length() == 0) {
            throw C0550a.a();
        } else if (charset2 == StandardCharsets.ISO_8859_1) {
            int length = sb2.length();
            byte[] bArr = new byte[length];
            for (i10 = 0; i10 < length; i10++) {
                bArr[i10] = (byte) sb2.charAt(i10);
            }
            try {
                C0554e eVar = new C0554e(null, new String(bArr, B.a(bArr, map)), null, str);
                eVar.a(gaVar);
                return eVar;
            } catch (UnsupportedEncodingException unused) {
                throw C0550a.a();
            }
        } else {
            C0554e eVar2 = new C0554e(null, sb2.toString(), null, str);
            eVar2.a(gaVar);
            return eVar2;
        }
    }

    private static boolean a(int i10) {
        return i10 == 901 || i10 == 924 || i10 == 902 || i10 == 928 || i10 == 923 || i10 == 922;
    }

    private static int b(int[] iArr, int i10, StringBuilder sb2) throws C0550a {
        int[] iArr2 = new int[(iArr[0] - i10) * 2];
        int[] iArr3 = new int[(iArr[0] - i10) * 2];
        boolean z10 = false;
        int i11 = 0;
        while (i10 < iArr[0] && !z10) {
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 < 900) {
                iArr2[i11] = i13 / 30;
                iArr2[i11 + 1] = i13 % 30;
                i11 += 2;
            } else if (i13 == 900) {
                i11++;
                iArr2[i11] = 900;
            } else if (i13 == 913) {
                iArr2[i11] = 913;
                i10 = i12 + 1;
                iArr3[i11] = iArr[i12];
                i11++;
            } else if (a(i13)) {
                i10 = i12 - 1;
                z10 = true;
            } else {
                throw C0550a.a();
            }
            i10 = i12;
        }
        a(iArr2, iArr3, i11, sb2);
        return i10;
    }

    private static a[] c(StringBuilder sb2, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0550a {
        a aVar3;
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 97);
        } else {
            int i10 = iArr2[1];
            if (i10 == 900) {
                aVar = a.ALPHA;
            } else if (i10 != 913) {
                switch (i10) {
                    case 26:
                        iArr2[2] = 32;
                        break;
                    case 27:
                        aVar3 = a.ALPHA_SHIFT;
                        aVar2 = aVar;
                        aVar = aVar3;
                        break;
                    case 28:
                        aVar = a.MIXED;
                        break;
                    case 29:
                        aVar3 = a.PUNCT_SHIFT;
                        aVar2 = aVar;
                        aVar = aVar3;
                        break;
                    default:
                        throw C0550a.a();
                }
            } else {
                sb2.append((char) iArr[iArr2[0]]);
            }
        }
        return new a[]{aVar, aVar2};
    }

    private static a[] d(StringBuilder sb2, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0550a {
        if (iArr2[1] < 25) {
            iArr2[2] = f14683b[iArr2[1]];
        } else {
            int i10 = iArr2[1];
            if (i10 != 900) {
                if (i10 != 913) {
                    switch (i10) {
                        case 25:
                            aVar = a.PUNCT;
                            break;
                        case 26:
                            iArr2[2] = 32;
                            break;
                        case 27:
                            aVar = a.LOWER;
                            break;
                        case 28:
                            break;
                        case 29:
                            aVar2 = aVar;
                            aVar = a.PUNCT_SHIFT;
                            break;
                        default:
                            throw C0550a.a();
                    }
                } else {
                    sb2.append((char) iArr[iArr2[0]]);
                }
            }
            aVar = a.ALPHA;
        }
        return new a[]{aVar, aVar2};
    }

    private static a[] e(StringBuilder sb2, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0550a {
        if (iArr2[1] < 29) {
            iArr2[2] = f14682a[iArr2[1]];
        } else {
            int i10 = iArr2[1];
            if (i10 == 29 || i10 == 900) {
                aVar = a.ALPHA;
            } else if (i10 == 913) {
                sb2.append((char) iArr[iArr2[0]]);
            } else {
                throw C0550a.a();
            }
        }
        return new a[]{aVar, aVar2};
    }

    private static a[] f(StringBuilder sb2, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0550a {
        a aVar3;
        if (iArr2[1] < 29) {
            iArr2[2] = f14682a[iArr2[1]];
        } else {
            int i10 = iArr2[1];
            if (i10 == 29 || i10 == 900) {
                aVar3 = a.ALPHA;
                return new a[]{aVar3, aVar2};
            } else if (i10 == 913) {
                sb2.append((char) iArr[iArr2[0]]);
            } else {
                throw C0550a.a();
            }
        }
        aVar3 = aVar2;
        return new a[]{aVar3, aVar2};
    }

    private static a[] b(StringBuilder sb2, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0550a {
        a aVar3;
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 65);
        } else {
            int i10 = iArr2[1];
            if (i10 == 26) {
                iArr2[2] = 32;
            } else if (i10 == 900) {
                aVar3 = a.ALPHA;
                return new a[]{aVar3, aVar2};
            } else {
                throw C0550a.a();
            }
        }
        aVar3 = aVar2;
        return new a[]{aVar3, aVar2};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int a(StringBuilder sb2, int i10, int[] iArr, int i11, Charset charset, C0588ga gaVar) throws C0550a {
        if (i10 == 913) {
            int i12 = i11 + 1;
            sb2.append((char) iArr[i11]);
            return i12;
        } else if (i10 == 928) {
            return a(iArr, i11, gaVar);
        } else {
            switch (i10) {
                case 900:
                    return b(iArr, i11, sb2);
                case 901:
                    break;
                case 902:
                    return a(iArr, i11, sb2);
                default:
                    switch (i10) {
                        case 922:
                        case 923:
                            throw C0550a.a();
                        case 924:
                            break;
                        case 925:
                            return i11 + 1;
                        case 926:
                            return i11 + 2;
                        default:
                            return b(iArr, i11 - 1, sb2);
                    }
            }
            return a(i10, iArr, charset, i11, sb2);
        }
    }

    static int a(int[] iArr, int i10, C0588ga gaVar) throws C0550a {
        int i11 = 0;
        if (i10 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            while (i11 < 2) {
                iArr2[i11] = iArr[i10];
                i11++;
                i10++;
            }
            try {
                gaVar.c(Integer.parseInt(a(iArr2, 2)));
                StringBuilder sb2 = new StringBuilder();
                int b10 = b(iArr, i10, sb2);
                gaVar.b(sb2.toString());
                int i12 = iArr[b10] == 923 ? b10 + 1 : -1;
                a(b10, iArr, gaVar);
                if (i12 != -1) {
                    int i13 = b10 - i12;
                    if (gaVar.a()) {
                        i13--;
                    }
                    gaVar.a(Arrays.copyOfRange(iArr, i12, i13 + i12));
                }
                return b10;
            } catch (Exception unused) {
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }

    private static void a(int i10, int[] iArr, C0588ga gaVar) throws C0550a {
        while (i10 < iArr[0]) {
            if (iArr[i10] == 923) {
                int i11 = i10 + 1;
                if (iArr[i11] == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    i10 = b(iArr, i11 + 1, sb2);
                    gaVar.c(sb2.toString());
                } else if (iArr[i11] == 3) {
                    StringBuilder sb3 = new StringBuilder();
                    i10 = b(iArr, i11 + 1, sb3);
                    gaVar.d(sb3.toString());
                } else if (iArr[i11] == 4) {
                    StringBuilder sb4 = new StringBuilder();
                    i10 = b(iArr, i11 + 1, sb4);
                    gaVar.a(sb4.toString());
                } else if (iArr[i11] == 1) {
                    StringBuilder sb5 = new StringBuilder();
                    i10 = a(iArr, i11 + 1, sb5);
                    gaVar.b(Integer.parseInt(sb5.toString()));
                } else if (iArr[i11] == 2) {
                    StringBuilder sb6 = new StringBuilder();
                    i10 = a(iArr, i11 + 1, sb6);
                    gaVar.b(Long.parseLong(sb6.toString()));
                } else if (iArr[i11] == 6) {
                    StringBuilder sb7 = new StringBuilder();
                    i10 = a(iArr, i11 + 1, sb7);
                    gaVar.a(Integer.parseInt(sb7.toString()));
                } else if (iArr[i11] == 5) {
                    StringBuilder sb8 = new StringBuilder();
                    i10 = a(iArr, i11 + 1, sb8);
                    gaVar.a(Long.parseLong(sb8.toString()));
                } else {
                    throw C0550a.a();
                }
            } else if (iArr[i10] == 922) {
                i10++;
                gaVar.a(true);
            } else {
                throw C0550a.a();
            }
        }
    }

    private static void a(int[] iArr, int[] iArr2, int i10, StringBuilder sb2) throws C0550a {
        a aVar = a.ALPHA;
        a aVar2 = aVar;
        int i11 = 0;
        while (i11 < i10) {
            int[] iArr3 = {i11, iArr[i11], 0};
            a[] aVarArr = {aVar, aVar2};
            switch (T.f14642a[aVar.ordinal()]) {
                case 1:
                    aVarArr = a(sb2, iArr2, aVar, aVar2, iArr3);
                    break;
                case 2:
                    aVarArr = c(sb2, iArr2, aVar, aVar2, iArr3);
                    break;
                case 3:
                    aVarArr = d(sb2, iArr2, aVar, aVar2, iArr3);
                    break;
                case 4:
                    aVarArr = e(sb2, iArr2, aVar, aVar2, iArr3);
                    break;
                case 5:
                    aVarArr = b(sb2, iArr2, aVar, aVar2, iArr3);
                    break;
                case 6:
                    aVarArr = f(sb2, iArr2, aVar, aVar2, iArr3);
                    break;
            }
            aVar = aVarArr[0];
            aVar2 = aVarArr[1];
            int i12 = iArr3[0];
            int i13 = iArr3[1];
            char c10 = (char) iArr3[2];
            if (c10 != 0) {
                sb2.append(c10);
            }
            i11 = 1 + i12;
        }
    }

    private static a[] a(StringBuilder sb2, int[] iArr, a aVar, a aVar2, int[] iArr2) throws C0550a {
        if (iArr2[1] < 26) {
            iArr2[2] = (char) (iArr2[1] + 65);
        } else {
            int i10 = iArr2[1];
            if (i10 == 900) {
                aVar = a.ALPHA;
            } else if (i10 != 913) {
                switch (i10) {
                    case 26:
                        iArr2[2] = 32;
                        break;
                    case 27:
                        aVar = a.LOWER;
                        break;
                    case 28:
                        aVar = a.MIXED;
                        break;
                    case 29:
                        aVar2 = aVar;
                        aVar = a.PUNCT_SHIFT;
                        break;
                    default:
                        throw C0550a.a();
                }
            } else {
                sb2.append((char) iArr[iArr2[0]]);
            }
        }
        return new a[]{aVar, aVar2};
    }

    private static int a(int i10, int[] iArr, Charset charset, int i11, StringBuilder sb2) throws C0550a {
        int i12;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i13 = 0;
        long j10 = 0;
        boolean z10 = false;
        if (i10 == 901) {
            int[] iArr2 = new int[6];
            int i14 = i11 + 1;
            int i15 = iArr[i11];
            while (i14 < iArr[0] && !z10) {
                int i16 = i13 + 1;
                iArr2[i13] = i15;
                j10 = (j10 * 900) + i15;
                int i17 = i14 + 1;
                i15 = iArr[i14];
                if (i15 != 928) {
                    switch (i15) {
                        case 900:
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i15) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    if (i16 % 5 != 0 || i16 <= 0) {
                                        i14 = i17;
                                        break;
                                    } else {
                                        for (int i18 = 0; i18 < 6; i18++) {
                                            byteArrayOutputStream.write((byte) (j10 >> ((5 - i18) * 8)));
                                        }
                                        j10 = 0;
                                        i14 = i17;
                                        i13 = 0;
                                        continue;
                                        continue;
                                    }
                                    break;
                            }
                    }
                    i13 = i16;
                }
                i14 = i17 - 1;
                z10 = true;
                i13 = i16;
            }
            if (i14 == iArr[0] && i15 < 900) {
                i13++;
                iArr2[i13] = i15;
            }
            for (int i19 = 0; i19 < i13; i19++) {
                byteArrayOutputStream.write((byte) iArr2[i19]);
            }
            i12 = i14;
        } else {
            i12 = i10 == 924 ? a(i11, iArr, false, 0, 0L, byteArrayOutputStream) : i11;
        }
        sb2.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i12;
    }

    private static int a(int i10, int[] iArr, boolean z10, int i11, long j10, ByteArrayOutputStream byteArrayOutputStream) throws C0550a {
        while (i10 < iArr[0] && !z10) {
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 < 900) {
                i11++;
                j10 = (j10 * 900) + i13;
            } else {
                if (i13 != 928) {
                    switch (i13) {
                        case 900:
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i13) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    throw C0550a.a();
                            }
                    }
                }
                i12--;
                z10 = true;
            }
            i10 = i12;
            if (i11 % 5 == 0 && i11 > 0) {
                for (int i14 = 0; i14 < 6; i14++) {
                    byteArrayOutputStream.write((byte) (j10 >> ((5 - i14) * 8)));
                }
                j10 = 0;
                i11 = 0;
            }
        }
        return i10;
    }

    private static int a(int[] iArr, int i10, StringBuilder sb2) throws C0550a {
        int[] iArr2 = new int[15];
        boolean z10 = false;
        int i11 = 0;
        while (i10 < iArr[0] && !z10) {
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i12 == iArr[0]) {
                z10 = true;
            }
            if (i13 < 900) {
                iArr2[i11] = i13;
                i11++;
            } else {
                if (!(i13 == 900 || i13 == 901 || i13 == 928)) {
                    switch (i13) {
                        case 922:
                        case 923:
                        case 924:
                            break;
                        default:
                            throw C0550a.a();
                    }
                }
                i12--;
                z10 = true;
            }
            if ((i11 % 15 == 0 || i13 == 902 || z10) && i11 > 0) {
                sb2.append(a(iArr2, i11));
                i11 = 0;
            }
            i10 = i12;
        }
        return i10;
    }

    private static String a(int[] iArr, int i10) throws C0550a {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigInteger = bigInteger.add(f14684c[(i10 - i11) - 1].multiply(BigInteger.valueOf(iArr[i11])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw C0550a.a();
    }
}
