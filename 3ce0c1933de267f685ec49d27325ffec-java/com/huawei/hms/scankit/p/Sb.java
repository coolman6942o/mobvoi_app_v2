package com.huawei.hms.scankit.p;

import com.bjleisen.iface.sdk.a;
import com.huawei.hms.scankit.util.b;
import java.util.Arrays;
/* compiled from: HighLevelEncoder.java */
/* loaded from: classes2.dex */
public final class Sb {
    private static char a(char c10, int i10) {
        int i11 = c10 + ((i10 * a.f7612e) % 253) + 1;
        if (i11 > 254) {
            i11 -= 254;
        }
        return (char) i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(char c10) {
        return c10 >= 128 && c10 <= 255;
    }

    private static boolean d(char c10) {
        return c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'A' && c10 <= 'Z');
    }

    private static boolean e(char c10) {
        return c10 >= ' ' && c10 <= '^';
    }

    private static boolean f(char c10) {
        return c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'a' && c10 <= 'z');
    }

    private static boolean g(char c10) {
        return i(c10) || c10 == ' ' || (c10 >= '0' && c10 <= '9') || (c10 >= 'A' && c10 <= 'Z');
    }

    private static boolean h(char c10) {
        return false;
    }

    private static boolean i(char c10) {
        return c10 == '\r' || c10 == '*' || c10 == '>';
    }

    public static String a(String str, Ub ub2, C0639wb wbVar, C0639wb wbVar2) {
        int i10 = 0;
        Pb[] pbArr = {new Jb(), new Lb(), new Vb(), new Wb(), new Ob(), new Kb()};
        Qb qb2 = new Qb(str);
        qb2.a(ub2);
        qb2.a(wbVar, wbVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            qb2.a((char) 236);
            qb2.a(2);
            qb2.f14627f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            qb2.a((char) 237);
            qb2.a(2);
            qb2.f14627f += 7;
        }
        while (qb2.h()) {
            if (i10 >= 0 && i10 < 6) {
                pbArr[i10].a(qb2);
            }
            if (qb2.e() >= 0) {
                i10 = qb2.e();
                qb2.i();
            }
        }
        int a10 = qb2.a();
        qb2.k();
        int a11 = qb2.g().a();
        if (!(a10 >= a11 || i10 == 0 || i10 == 5 || i10 == 4)) {
            qb2.a((char) 254);
        }
        StringBuilder b10 = qb2.b();
        if (b10.length() < a11) {
            b10.append((char) 129);
        }
        while (b10.length() < a11) {
            b10.append(a((char) 129, b10.length() + 1));
        }
        return qb2.b().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x01ed, code lost:
        r1 = (r18 + r5) + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01f3, code lost:
        if (r1 >= r17.length()) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01f5, code lost:
        r2 = r17.charAt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01fd, code lost:
        if (i(r2) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01ff, code lost:
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0204, code lost:
        if (g(r2) != false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0207, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x020a, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(CharSequence charSequence, int i10, int i11) {
        float[] fArr;
        if (i10 >= charSequence.length()) {
            return i11;
        }
        if (i11 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i11] = 0.0f;
        }
        int i12 = 0;
        while (true) {
            int i13 = i10 + i12;
            if (i13 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int a10 = a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int a11 = a(bArr);
                try {
                    if (b.a(iArr, 0) && iArr[0] == a10) {
                        return 0;
                    }
                    if (a11 == 1 && b.a(bArr, 5) && bArr[5] > 0) {
                        return 5;
                    }
                    if (a11 == 1 && b.a(bArr, 4) && bArr[4] > 0) {
                        return 4;
                    }
                    if (a11 == 1 && b.a(bArr, 2) && bArr[2] > 0) {
                        return 2;
                    }
                    if (a11 == 1 && b.a(bArr, 3)) {
                        if (bArr[3] > 0) {
                            return 3;
                        }
                    }
                    return 1;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    throw e10;
                }
            } else {
                char charAt = charSequence.charAt(i13);
                i12++;
                if (b(charAt)) {
                    fArr[0] = fArr[0] + 0.5f;
                } else if (c(charAt)) {
                    fArr[0] = (float) Math.ceil(fArr[0]);
                    fArr[0] = fArr[0] + 2.0f;
                } else {
                    fArr[0] = (float) Math.ceil(fArr[0]);
                    fArr[0] = fArr[0] + 1.0f;
                }
                if (1 < fArr.length) {
                    if (d(charAt)) {
                        fArr[1] = fArr[1] + 0.6666667f;
                    } else if (c(charAt)) {
                        fArr[1] = fArr[1] + 2.6666667f;
                    } else {
                        fArr[1] = fArr[1] + 1.3333334f;
                    }
                }
                if (2 < fArr.length) {
                    if (f(charAt)) {
                        fArr[2] = fArr[2] + 0.6666667f;
                    } else if (c(charAt)) {
                        fArr[2] = fArr[2] + 2.6666667f;
                    } else {
                        fArr[2] = fArr[2] + 1.3333334f;
                    }
                }
                if (3 < fArr.length) {
                    if (g(charAt)) {
                        fArr[3] = fArr[3] + 0.6666667f;
                    } else if (c(charAt)) {
                        fArr[3] = fArr[3] + 4.3333335f;
                    } else {
                        fArr[3] = fArr[3] + 3.3333333f;
                    }
                }
                if (4 < fArr.length) {
                    if (e(charAt)) {
                        fArr[4] = fArr[4] + 0.75f;
                    } else if (c(charAt)) {
                        fArr[4] = fArr[4] + 4.25f;
                    } else {
                        fArr[4] = fArr[4] + 3.25f;
                    }
                }
                if (5 < fArr.length) {
                    if (h(charAt)) {
                        fArr[5] = fArr[5] + 4.0f;
                    } else {
                        fArr[5] = fArr[5] + 1.0f;
                    }
                }
                if (i12 >= 4) {
                    int[] iArr2 = new int[6];
                    byte[] bArr2 = new byte[6];
                    a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                    int a12 = a(bArr2);
                    try {
                        if (iArr2[0] < iArr2[5] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                            return 0;
                        }
                        if (iArr2[5] >= iArr2[0] && bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] != 0) {
                            if (a12 == 1 && bArr2[4] > 0) {
                                return 4;
                            }
                            if (a12 == 1 && bArr2[2] > 0) {
                                return 2;
                            }
                            if (a12 == 1 && bArr2[3] > 0) {
                                return 3;
                            }
                            if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                                if (iArr2[1] < iArr2[3]) {
                                    return 1;
                                }
                                if (iArr2[1] == iArr2[3]) {
                                    break;
                                }
                            }
                        }
                        return 5;
                    } catch (ArrayIndexOutOfBoundsException e11) {
                        throw e11;
                    }
                }
            }
        }
    }

    private static int a(float[] fArr, int[] iArr, int i10, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i11 = 0; i11 < 6; i11++) {
            iArr[i11] = (int) Math.ceil(fArr[i11]);
            int i12 = iArr[i11];
            if (i10 > i12) {
                Arrays.fill(bArr, (byte) 0);
                i10 = i12;
            }
            if (i10 == i12) {
                bArr[i11] = (byte) (bArr[i11] + 1);
            }
        }
        return i10;
    }

    private static int a(byte[] bArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            i10 += bArr[i11];
        }
        return i10;
    }

    public static int a(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        if (i10 < length) {
            char charAt = charSequence.charAt(i10);
            while (b(charAt) && i10 < length) {
                i11++;
                i10++;
                if (i10 < length) {
                    charAt = charSequence.charAt(i10);
                }
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(char c10) {
        String hexString;
        String str = "0000".substring(0, 4 - hexString.length()) + Integer.toHexString(c10);
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Illegal character: ");
            sb2.append(c10);
            sb2.append(" (0x");
            sb2.append(str);
            sb2.append(')');
            throw new IllegalArgumentException(sb2.toString());
        } catch (Exception e10) {
            throw e10;
        }
    }
}
