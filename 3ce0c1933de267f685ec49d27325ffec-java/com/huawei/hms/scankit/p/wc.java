package com.huawei.hms.scankit.p;
/* compiled from: MaskUtil.java */
/* loaded from: classes2.dex */
final class wc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(sc scVar) {
        return a(scVar, true) + a(scVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(sc scVar) {
        byte[][] a10 = scVar.a();
        int c10 = scVar.c();
        int b10 = scVar.b();
        int i10 = 0;
        for (int i11 = 0; i11 < b10 - 1; i11++) {
            byte[] bArr = a10[i11];
            int i12 = 0;
            while (i12 < c10 - 1) {
                byte b11 = bArr[i12];
                int i13 = i12 + 1;
                if (b11 == bArr[i13]) {
                    int i14 = i11 + 1;
                    if (b11 == a10[i14][i12] && b11 == a10[i14][i13]) {
                        i10++;
                    }
                }
                i12 = i13;
            }
        }
        return i10 * 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(sc scVar) {
        byte[][] a10 = scVar.a();
        int c10 = scVar.c();
        int b10 = scVar.b();
        int i10 = 0;
        for (int i11 = 0; i11 < b10; i11++) {
            for (int i12 = 0; i12 < c10; i12++) {
                byte[] bArr = a10[i11];
                int i13 = i12 + 6;
                if (i13 < c10 && bArr[i12] == 1 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 1 && bArr[i12 + 3] == 1 && bArr[i12 + 4] == 1 && bArr[i12 + 5] == 0 && bArr[i13] == 1 && (a(bArr, i12 - 4, i12) || a(bArr, i12 + 7, i12 + 11))) {
                    i10++;
                }
                int i14 = i11 + 6;
                if (i14 < b10 && a10[i11][i12] == 1 && a10[i11 + 1][i12] == 0 && a10[i11 + 2][i12] == 1 && a10[i11 + 3][i12] == 1 && a10[i11 + 4][i12] == 1 && a10[i11 + 5][i12] == 0 && a10[i14][i12] == 1 && (a(a10, i12, i11 - 4, i11) || a(a10, i12, i11 + 7, i11 + 11))) {
                    i10++;
                }
            }
        }
        return i10 * 40;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(sc scVar) {
        byte[][] a10 = scVar.a();
        int c10 = scVar.c();
        int b10 = scVar.b();
        int i10 = 0;
        for (int i11 = 0; i11 < b10; i11++) {
            byte[] bArr = a10[i11];
            for (int i12 = 0; i12 < c10; i12++) {
                if (bArr[i12] == 1) {
                    i10++;
                }
            }
        }
        int b11 = scVar.b() * scVar.c();
        return ((Math.abs((i10 * 2) - b11) * 10) / b11) * 10;
    }

    private static boolean a(byte[] bArr, int i10, int i11) {
        int min = Math.min(i11, bArr.length);
        for (int max = Math.max(i10, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i10, int i11, int i12) {
        int min = Math.min(i12, bArr.length);
        for (int max = Math.max(i11, 0); max < min; max++) {
            if (max < bArr.length && i10 < bArr[0].length && bArr[max][i10] == 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a(int i10, int i11, int i12) {
        int i13;
        int i14;
        switch (i10) {
            case 0:
                i12 += i11;
                i13 = i12 & 1;
                break;
            case 1:
                i13 = i12 & 1;
                break;
            case 2:
                i13 = i11 % 3;
                break;
            case 3:
                i13 = (i12 + i11) % 3;
                break;
            case 4:
                i12 /= 2;
                i11 /= 3;
                i12 += i11;
                i13 = i12 & 1;
                break;
            case 5:
                int i15 = i12 * i11;
                i13 = (i15 & 1) + (i15 % 3);
                break;
            case 6:
                int i16 = i12 * i11;
                i14 = (i16 & 1) + (i16 % 3);
                i13 = i14 & 1;
                break;
            case 7:
                i14 = ((i12 * i11) % 3) + ((i12 + i11) & 1);
                i13 = i14 & 1;
                break;
            default:
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid mask pattern: ");
                    sb2.append(i10);
                    throw new IllegalArgumentException(sb2.toString());
                } catch (Exception e10) {
                    throw e10;
                }
        }
        return i13 == 0;
    }

    private static int a(sc scVar, boolean z10) {
        int b10 = z10 ? scVar.b() : scVar.c();
        int c10 = z10 ? scVar.c() : scVar.b();
        byte[][] a10 = scVar.a();
        int i10 = 0;
        for (int i11 = 0; i11 < b10; i11++) {
            byte b11 = -1;
            int i12 = 0;
            for (int i13 = 0; i13 < c10; i13++) {
                byte b12 = z10 ? a10[i11][i13] : a10[i13][i11];
                if (b12 == b11) {
                    i12++;
                } else {
                    if (i12 >= 5) {
                        i10 += (i12 - 5) + 3;
                    }
                    i12 = 1;
                    b11 = b12;
                }
            }
            if (i12 >= 5) {
                i10 += (i12 - 5) + 3;
            }
        }
        return i10;
    }
}
