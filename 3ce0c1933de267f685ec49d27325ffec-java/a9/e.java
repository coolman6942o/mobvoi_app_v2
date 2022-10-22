package a9;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import z8.c;
/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes.dex */
final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f149a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f150b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final Charset f151c = Charset.forName("ISO-8859-1");

    /* renamed from: d  reason: collision with root package name */
    private static final BigInteger[] f152d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f153a;

        static {
            int[] iArr = new int[b.values().length];
            f153a = iArr;
            try {
                iArr[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f153a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f153a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f153a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f153a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f153a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DecodedBitStreamParser.java */
    /* loaded from: classes.dex */
    public enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f152d = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f152d;
            if (i10 < bigIntegerArr2.length) {
                bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(valueOf);
                i10++;
            } else {
                return;
            }
        }
    }

    private static int a(int i10, int[] iArr, Charset charset, int i11, StringBuilder sb2) {
        int i12;
        int i13;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i14 = 922;
        int i15 = 923;
        int i16 = 928;
        int i17 = 902;
        long j10 = 900;
        if (i10 == 901) {
            int[] iArr2 = new int[6];
            i12 = i11 + 1;
            int i18 = iArr[i11];
            long j11 = 0;
            boolean z10 = false;
            int i19 = 0;
            while (i12 < iArr[0] && !z10) {
                int i20 = i19 + 1;
                iArr2[i19] = i18;
                j11 = (j11 * j10) + i18;
                int i21 = i12 + 1;
                i18 = iArr[i12];
                if (i18 == 900 || i18 == 901 || i18 == 902 || i18 == 924 || i18 == 928 || i18 == i15 || i18 == i14) {
                    i12 = i21 - 1;
                    i19 = i20;
                    i14 = 922;
                    i15 = 923;
                    j10 = 900;
                    z10 = true;
                } else if (i20 % 5 != 0 || i20 <= 0) {
                    i12 = i21;
                    i19 = i20;
                    i14 = 922;
                    i15 = 923;
                    j10 = 900;
                } else {
                    int i22 = 0;
                    while (i22 < 6) {
                        byteArrayOutputStream.write((byte) (j11 >> ((5 - i22) * 8)));
                        i22++;
                        i14 = 922;
                        i15 = 923;
                    }
                    i12 = i21;
                    i19 = 0;
                    j10 = 900;
                    j11 = 0;
                }
            }
            if (i12 != iArr[0] || i18 >= 900) {
                i13 = i19;
            } else {
                i13 = i19 + 1;
                iArr2[i19] = i18;
            }
            for (int i23 = 0; i23 < i13; i23++) {
                byteArrayOutputStream.write((byte) iArr2[i23]);
            }
        } else if (i10 == 924) {
            int i24 = i11;
            boolean z11 = false;
            int i25 = 0;
            long j12 = 0;
            while (i24 < iArr[0] && !z11) {
                int i26 = i24 + 1;
                int i27 = iArr[i24];
                if (i27 < 900) {
                    i25++;
                    j12 = (j12 * 900) + i27;
                    i24 = i26;
                } else {
                    if (i27 != 900 && i27 != 901 && i27 != i17 && i27 != 924 && i27 != i16) {
                        if (!(i27 == 923 || i27 == 922)) {
                            i24 = i26;
                        }
                    }
                    i24 = i26 - 1;
                    z11 = true;
                }
                if (i25 % 5 == 0 && i25 > 0) {
                    for (int i28 = 0; i28 < 6; i28++) {
                        byteArrayOutputStream.write((byte) (j12 >> ((5 - i28) * 8)));
                    }
                    i25 = 0;
                    j12 = 0;
                }
                i16 = 928;
                i17 = 902;
            }
            i12 = i24;
        } else {
            i12 = i11;
        }
        sb2.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static o8.b b(int[] iArr, String str) throws FormatException {
        int i10;
        StringBuilder sb2 = new StringBuilder(iArr.length << 1);
        Charset charset = f151c;
        int i11 = iArr[1];
        c cVar = new c();
        int i12 = 2;
        while (i12 < iArr[0]) {
            if (i11 != 913) {
                switch (i11) {
                    case 900:
                        i10 = g(iArr, i12, sb2);
                        break;
                    case 901:
                        i10 = a(i11, iArr, charset, i12, sb2);
                        break;
                    case 902:
                        i10 = f(iArr, i12, sb2);
                        break;
                    default:
                        switch (i11) {
                            case 922:
                            case 923:
                                throw FormatException.getFormatInstance();
                            case 924:
                                break;
                            case 925:
                                i10 = i12 + 1;
                                break;
                            case 926:
                                i10 = i12 + 2;
                                break;
                            case 927:
                                i10 = i12 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i12]).name());
                                break;
                            case 928:
                                i10 = d(iArr, i12, cVar);
                                break;
                            default:
                                i10 = g(iArr, i12 - 1, sb2);
                                break;
                        }
                }
            } else {
                i10 = i12 + 1;
                sb2.append((char) iArr[i12]);
            }
            if (i10 < iArr.length) {
                i12 = i10 + 1;
                i11 = iArr[i10];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb2.length() != 0) {
            o8.b bVar = new o8.b(null, sb2.toString(), null, str);
            bVar.m(cVar);
            return bVar;
        }
        throw FormatException.getFormatInstance();
    }

    private static String c(int[] iArr, int i10) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigInteger = bigInteger.add(f152d[(i10 - i11) - 1].multiply(BigInteger.valueOf(iArr[i11])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int d(int[] iArr, int i10, c cVar) throws FormatException {
        if (i10 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i11 = 0;
            while (i11 < 2) {
                iArr2[i11] = iArr[i10];
                i11++;
                i10++;
            }
            cVar.d(Integer.parseInt(c(iArr2, 2)));
            StringBuilder sb2 = new StringBuilder();
            int g10 = g(iArr, i10, sb2);
            cVar.a(sb2.toString());
            if (iArr[g10] == 923) {
                int i12 = g10 + 1;
                int[] iArr3 = new int[iArr[0] - i12];
                boolean z10 = false;
                int i13 = 0;
                while (i12 < iArr[0] && !z10) {
                    int i14 = i12 + 1;
                    int i15 = iArr[i12];
                    if (i15 < 900) {
                        i13++;
                        iArr3[i13] = i15;
                        i12 = i14;
                    } else if (i15 == 922) {
                        cVar.b(true);
                        i12 = i14 + 1;
                        z10 = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                cVar.c(Arrays.copyOf(iArr3, i13));
                return i12;
            } else if (iArr[g10] != 922) {
                return g10;
            } else {
                cVar.b(true);
                return g10 + 1;
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void e(int[] iArr, int[] iArr2, int i10, StringBuilder sb2) {
        int i11;
        b bVar;
        b bVar2 = b.ALPHA;
        b bVar3 = bVar2;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = iArr[i12];
            char c10 = ' ';
            switch (a.f153a[bVar2.ordinal()]) {
                case 1:
                    if (i13 >= 26) {
                        if (i13 != 26) {
                            if (i13 == 27) {
                                bVar2 = b.LOWER;
                            } else if (i13 == 28) {
                                bVar2 = b.MIXED;
                            } else if (i13 == 29) {
                                bVar = b.PUNCT_SHIFT;
                                c10 = 0;
                                bVar2 = bVar;
                                bVar3 = bVar2;
                                break;
                            } else if (i13 == 913) {
                                sb2.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                bVar2 = b.ALPHA;
                            }
                            c10 = 0;
                            break;
                        }
                    } else {
                        i11 = i13 + 65;
                        c10 = (char) i11;
                        break;
                    }
                    break;
                case 2:
                    if (i13 >= 26) {
                        if (i13 != 26) {
                            if (i13 != 27) {
                                if (i13 == 28) {
                                    bVar2 = b.MIXED;
                                } else if (i13 == 29) {
                                    bVar = b.PUNCT_SHIFT;
                                } else if (i13 == 913) {
                                    sb2.append((char) iArr2[i12]);
                                } else if (i13 == 900) {
                                    bVar2 = b.ALPHA;
                                }
                                c10 = 0;
                                break;
                            } else {
                                bVar = b.ALPHA_SHIFT;
                            }
                            c10 = 0;
                            bVar2 = bVar;
                            bVar3 = bVar2;
                            break;
                        }
                    } else {
                        i11 = i13 + 97;
                        c10 = (char) i11;
                        break;
                    }
                    break;
                case 3:
                    if (i13 < 25) {
                        c10 = f150b[i13];
                        break;
                    } else {
                        if (i13 == 25) {
                            bVar2 = b.PUNCT;
                        } else if (i13 != 26) {
                            if (i13 == 27) {
                                bVar2 = b.LOWER;
                            } else if (i13 == 28) {
                                bVar2 = b.ALPHA;
                            } else if (i13 == 29) {
                                bVar = b.PUNCT_SHIFT;
                                c10 = 0;
                                bVar2 = bVar;
                                bVar3 = bVar2;
                                break;
                            } else if (i13 == 913) {
                                sb2.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                bVar2 = b.ALPHA;
                            }
                        }
                        c10 = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i13 < 29) {
                        c10 = f149a[i13];
                        break;
                    } else {
                        if (i13 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i13 == 913) {
                            sb2.append((char) iArr2[i12]);
                        } else if (i13 == 900) {
                            bVar2 = b.ALPHA;
                        }
                        c10 = 0;
                        break;
                    }
                case 5:
                    if (i13 < 26) {
                        c10 = (char) (i13 + 65);
                    } else if (i13 != 26) {
                        if (i13 == 900) {
                            bVar2 = b.ALPHA;
                            c10 = 0;
                            break;
                        }
                        c10 = 0;
                    }
                    bVar2 = bVar3;
                    break;
                case 6:
                    if (i13 < 29) {
                        c10 = f149a[i13];
                        bVar2 = bVar3;
                        break;
                    } else {
                        if (i13 == 29) {
                            bVar2 = b.ALPHA;
                        } else {
                            if (i13 == 913) {
                                sb2.append((char) iArr2[i12]);
                            } else if (i13 == 900) {
                                bVar2 = b.ALPHA;
                            }
                            c10 = 0;
                            bVar2 = bVar3;
                        }
                        c10 = 0;
                        break;
                    }
                default:
                    c10 = 0;
                    break;
            }
            if (c10 != 0) {
                sb2.append(c10);
            }
        }
    }

    private static int f(int[] iArr, int i10, StringBuilder sb2) throws FormatException {
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
            } else if (i13 == 900 || i13 == 901 || i13 == 924 || i13 == 928 || i13 == 923 || i13 == 922) {
                i12--;
                z10 = true;
            }
            if ((i11 % 15 == 0 || i13 == 902 || z10) && i11 > 0) {
                sb2.append(c(iArr2, i11));
                i11 = 0;
            }
            i10 = i12;
        }
        return i10;
    }

    private static int g(int[] iArr, int i10, StringBuilder sb2) {
        int[] iArr2 = new int[(iArr[0] - i10) << 1];
        int[] iArr3 = new int[(iArr[0] - i10) << 1];
        boolean z10 = false;
        int i11 = 0;
        while (i10 < iArr[0] && !z10) {
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 < 900) {
                iArr2[i11] = i13 / 30;
                iArr2[i11 + 1] = i13 % 30;
                i11 += 2;
            } else if (i13 != 913) {
                if (i13 != 928) {
                    switch (i13) {
                        case 900:
                            i11++;
                            iArr2[i11] = 900;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i13) {
                            }
                    }
                }
                i10 = i12 - 1;
                z10 = true;
            } else {
                iArr2[i11] = 913;
                i10 = i12 + 1;
                iArr3[i11] = iArr[i12];
                i11++;
            }
            i10 = i12;
        }
        e(iArr2, iArr3, i11, sb2);
        return i10;
    }
}
