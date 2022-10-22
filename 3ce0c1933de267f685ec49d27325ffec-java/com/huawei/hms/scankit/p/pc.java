package com.huawei.hms.scankit.p;

import com.alibaba.fastjson.parser.JSONLexer;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.EnumC0552c;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.b;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
/* compiled from: PDF417HighLevelEncoder.java */
/* loaded from: classes2.dex */
final class pc {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f14898c;

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f14896a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f14897b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f14899d = new byte[128];

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f14900e = StandardCharsets.ISO_8859_1;

    static {
        byte[] bArr = new byte[128];
        f14898c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f14896a;
            if (i11 >= bArr2.length) {
                break;
            }
            byte b10 = bArr2[i11];
            if (b10 > 0) {
                f14898c[b10] = (byte) i11;
            }
            i11++;
        }
        Arrays.fill(f14899d, (byte) -1);
        while (true) {
            byte[] bArr3 = f14897b;
            if (i10 < bArr3.length) {
                byte b11 = bArr3[i10];
                if (b11 > 0) {
                    f14899d[b11] = (byte) i10;
                }
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, kc kcVar, Charset charset) throws WriterException {
        StringBuilder sb2 = new StringBuilder(str.length());
        if (charset == null) {
            charset = f14900e;
        } else if (!f14900e.equals(charset)) {
            EnumC0552c a10 = EnumC0552c.a(charset.name());
            if (a10 != null) {
                a(a10.a(), sb2);
            }
        } else {
            a.a("PDF417", "else");
        }
        int length = str.length();
        int i10 = oc.f14888a[kcVar.ordinal()];
        if (i10 == 1) {
            a(str, 0, length, sb2, 0);
        } else if (i10 == 2) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, 0, bytes.length, 1, sb2);
        } else if (i10 != 3) {
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i11 < length) {
                int a11 = a(str, i11);
                if (a11 >= 13) {
                    sb2.append((char) 902);
                    a(str, i11, a11, sb2);
                    i11 += a11;
                    i13 = 0;
                    i12 = 2;
                } else {
                    int b10 = b(str, i11);
                    if (b10 >= 5 || a11 == length) {
                        if (i12 != 0) {
                            sb2.append((char) 900);
                            i12 = 0;
                            i13 = 0;
                        }
                        i13 = a(str, i11, b10, sb2, i13);
                        i11 += b10;
                    } else {
                        int a12 = a(str, i11, charset);
                        if (a12 == 0) {
                            a12 = 1;
                        }
                        int i14 = a12 + i11;
                        byte[] bytes2 = str.substring(i11, i14).getBytes(charset);
                        if (bytes2.length == 1 && i12 == 0) {
                            a(bytes2, 0, 1, 0, sb2);
                        } else {
                            a(bytes2, 0, bytes2.length, i12, sb2);
                            i12 = 1;
                            i13 = 0;
                        }
                        i11 = i14;
                    }
                }
            }
        } else {
            sb2.append((char) 902);
            a(str, 0, length, sb2);
        }
        return sb2.toString();
    }

    private static boolean a(char c10) {
        return c10 == ' ' || (c10 >= 'a' && c10 <= 'z');
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        return (r1 - r7) - r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int b(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = i10;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            int i12 = 0;
            while (i12 < 13 && c(charAt) && i11 < length) {
                i12++;
                i11++;
                if (i11 < length) {
                    charAt = charSequence.charAt(i11);
                }
            }
            if (i12 <= 0) {
                if (!f(charSequence.charAt(i11))) {
                    break;
                }
                i11++;
            }
        }
        return i11 - i10;
    }

    private static boolean b(char c10) {
        return c10 == ' ' || (c10 >= 'A' && c10 <= 'Z');
    }

    private static boolean c(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    private static boolean d(char c10) {
        try {
            byte[] bArr = f14898c;
            if (b.a(bArr, (int) c10)) {
                return bArr[c10] != -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    private static boolean e(char c10) {
        try {
            if (b.a(f14898c, (int) c10)) {
                return f14899d[c10] != -1;
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw e10;
        }
    }

    private static boolean f(char c10) {
        return c10 == '\t' || c10 == '\n' || c10 == '\r' || (c10 >= ' ' && c10 <= '~');
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x00f6 A[EDGE_INSN: B:92:0x00f6->B:55:0x00f6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0011 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(CharSequence charSequence, int i10, int i11, StringBuilder sb2, int i12) {
        StringBuilder sb3 = new StringBuilder(i11);
        int i13 = i12;
        int i14 = 0;
        while (true) {
            int i15 = i10 + i14;
            char charAt = charSequence.charAt(i15);
            if (i13 != 0) {
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (e(charAt)) {
                            sb3.append((char) f14899d[charAt]);
                        } else {
                            sb3.append((char) 29);
                            i13 = 0;
                        }
                    } else if (d(charAt)) {
                        sb3.append((char) f14898c[charAt]);
                    } else if (b(charAt)) {
                        sb3.append((char) 28);
                        i13 = 0;
                    } else if (a(charAt)) {
                        sb3.append((char) 27);
                        i13 = 1;
                    } else {
                        int i16 = i15 + 1;
                        if (i16 >= i11 || !e(charSequence.charAt(i16))) {
                            sb3.append((char) 29);
                            sb3.append((char) f14899d[charAt]);
                        } else {
                            i13 = 3;
                            sb3.append((char) 25);
                        }
                    }
                } else if (a(charAt)) {
                    if (charAt == ' ') {
                        sb3.append(JSONLexer.EOI);
                    } else {
                        sb3.append((char) (charAt - 'a'));
                    }
                } else if (b(charAt)) {
                    sb3.append((char) 27);
                    sb3.append((char) (charAt - 'A'));
                } else if (d(charAt)) {
                    sb3.append((char) 28);
                    i13 = 2;
                } else {
                    sb3.append((char) 29);
                    sb3.append((char) f14899d[charAt]);
                }
                i14++;
                if (i14 < i11) {
                    break;
                }
            } else {
                if (b(charAt)) {
                    if (charAt == ' ') {
                        sb3.append(JSONLexer.EOI);
                    } else {
                        sb3.append((char) (charAt - 'A'));
                    }
                } else if (a(charAt)) {
                    sb3.append((char) 27);
                    i13 = 1;
                } else if (d(charAt)) {
                    sb3.append((char) 28);
                    i13 = 2;
                } else {
                    sb3.append((char) 29);
                    sb3.append((char) f14899d[charAt]);
                }
                i14++;
                if (i14 < i11) {
                }
            }
        }
        int length = sb3.length();
        char c10 = 0;
        for (int i17 = 0; i17 < length; i17++) {
            if (i17 % 2 != 0) {
                c10 = (char) ((c10 * 30) + sb3.charAt(i17));
                sb2.append(c10);
            } else {
                c10 = sb3.charAt(i17);
            }
        }
        if (length % 2 != 0) {
            sb2.append((char) ((c10 * 30) + 29));
        }
        return i13;
    }

    private static void a(byte[] bArr, int i10, int i11, int i12, StringBuilder sb2) {
        int i13;
        if (i11 == 1 && i12 == 0) {
            sb2.append((char) 913);
        } else if (i11 % 6 == 0) {
            sb2.append((char) 924);
        } else {
            sb2.append((char) 901);
        }
        if (i11 >= 6) {
            char[] cArr = new char[5];
            i13 = i10;
            while ((i10 + i11) - i13 >= 6) {
                long j10 = 0;
                for (int i14 = 0; i14 < 6; i14++) {
                    j10 = (j10 << 8) + (bArr[i13 + i14] & 255);
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    cArr[i15] = (char) (j10 % 900);
                    j10 /= 900;
                }
                for (int i16 = 4; i16 >= 0; i16--) {
                    sb2.append(cArr[i16]);
                }
                i13 += 6;
            }
        } else {
            i13 = i10;
        }
        while (i13 < i10 + i11) {
            sb2.append((char) (bArr[i13] & 255));
            i13++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0066 A[LOOP:2: B:10:0x0064->B:11:0x0066, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(String str, int i10, int i11, StringBuilder sb2) {
        int length;
        StringBuilder sb3 = new StringBuilder((i11 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900L);
        BigInteger valueOf2 = BigInteger.valueOf(0L);
        int i12 = 0;
        while (i12 < i11) {
            sb3.setLength(0);
            int min = Math.min(44, i11 - i12);
            if (str.length() > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append('1');
                int i13 = i10 + i12;
                sb4.append(str.substring(i13, i13 + min));
                BigInteger bigInteger = new BigInteger(sb4.toString());
                do {
                    sb3.append((char) bigInteger.mod(valueOf).intValue());
                    bigInteger = bigInteger.divide(valueOf);
                } while (!bigInteger.equals(valueOf2));
                for (length = sb3.length() - 1; length >= 0; length--) {
                    sb2.append(sb3.charAt(length));
                }
                i12 += min;
            } else {
                while (length >= 0) {
                }
                i12 += min;
            }
        }
    }

    private static int a(CharSequence charSequence, int i10) {
        return Sb.a(charSequence, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        return r1 - r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int a(String str, int i10, Charset charset) throws WriterException {
        int i11;
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i12 = i10;
        while (i12 < length) {
            char charAt = str.charAt(i12);
            int i13 = 0;
            while (i13 < 13 && c(charAt) && (i11 = i12 + (i13 = i13 + 1)) < length) {
                charAt = str.charAt(i11);
            }
            char charAt2 = str.charAt(i12);
            if (newEncoder.canEncode(charAt2)) {
                i12++;
            } else {
                throw new WriterException("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
            }
        }
        return i12 - i10;
    }

    private static void a(int i10, StringBuilder sb2) throws WriterException {
        if (i10 >= 0 && i10 < 900) {
            sb2.append((char) 927);
            sb2.append((char) i10);
        } else if (i10 < 810900) {
            sb2.append((char) 926);
            sb2.append((char) ((i10 / 900) - 1));
            sb2.append((char) (i10 % 900));
        } else if (i10 < 811800) {
            sb2.append((char) 925);
            sb2.append((char) (810900 - i10));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i10);
        }
    }
}
