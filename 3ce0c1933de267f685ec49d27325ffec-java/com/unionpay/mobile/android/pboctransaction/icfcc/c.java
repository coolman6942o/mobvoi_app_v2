package com.unionpay.mobile.android.pboctransaction.icfcc;

import com.unionpay.mobile.android.pboctransaction.e;
/* loaded from: classes2.dex */
public final class c {
    public static String a(String str, String str2) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        if (str == null) {
            return null;
        }
        byte[] a10 = e.a(str);
        int i19 = 0;
        while (i19 < a10.length) {
            int i20 = 1;
            int i21 = ((byte) (a10[i19] & 31)) == 31 ? 2 : 1;
            byte[] bArr = new byte[i21];
            System.arraycopy(a10, i19, bArr, 0, i21);
            if (e.a(bArr, i21).compareToIgnoreCase(str2) == 0) {
                int i22 = i19 + i21;
                if (((byte) (a10[i22] & 128)) != Byte.MIN_VALUE) {
                    i13 = a10[i22];
                } else {
                    i20 = 1 + (a10[i22] & 127);
                    if (i20 == 2) {
                        i13 = a10[i22 + 1];
                    } else {
                        if (i20 == 3) {
                            i11 = (a10[i22 + 1] & 255) << 8;
                            i12 = a10[i22 + 2];
                        } else if (i20 == 4) {
                            i11 = ((a10[i22 + 1] & 255) << 16) | ((a10[i22 + 2] & 255) << 8);
                            i12 = a10[i22 + 3];
                        } else {
                            i10 = 0;
                            byte[] bArr2 = new byte[i10];
                            System.arraycopy(a10, i22 + i20, bArr2, 0, i10);
                            return e.a(bArr2, i10);
                        }
                        i10 = i11 | (i12 & 255);
                        byte[] bArr22 = new byte[i10];
                        System.arraycopy(a10, i22 + i20, bArr22, 0, i10);
                        return e.a(bArr22, i10);
                    }
                }
                i10 = i13 & 255;
                byte[] bArr222 = new byte[i10];
                System.arraycopy(a10, i22 + i20, bArr222, 0, i10);
                return e.a(bArr222, i10);
            }
            int i23 = a10[i19] & 32;
            int i24 = i19 + i21;
            int length = a10.length;
            if (i23 != 32) {
                if (i24 >= length || ((byte) (a10[i24] & 128)) != 0) {
                    i20 = i24 < a10.length ? (a10[i24] & 127) + 1 : 0;
                    if (i20 != 2 || (i17 = i24 + 1) >= a10.length) {
                        i14 = (i20 != 3 || (i16 = i24 + 2) >= a10.length) ? (i20 != 4 || (i15 = i24 + 2) >= a10.length) ? 0 : ((a10[i15] & 255) << 8) | ((a10[i24 + 1] & 255) << 16) | (a10[i24 + 3] & 255) : (a10[i16] & 255) | ((a10[i24 + 1] & 255) << 8);
                        i20 += i14;
                    } else {
                        i18 = a10[i17];
                    }
                } else {
                    i18 = a10[i24];
                }
                i14 = i18 & 255;
                i20 += i14;
            } else if (i24 < length && ((byte) (a10[i24] & 128)) == Byte.MIN_VALUE) {
                i20 = 1 + (a10[i24] & 127);
            }
            i19 = i24 + i20;
        }
        return null;
    }
}
