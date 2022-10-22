package com.unionpay.mobile.android.pboctransaction.nfc;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f23787a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr, int i10) {
        char[] cArr = new char[i10 * 2];
        int i11 = i10 + 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            byte b10 = bArr[i13];
            int i14 = i12 + 1;
            char[] cArr2 = f23787a;
            cArr[i12] = cArr2[(b10 >> 4) & 15];
            i12 = i14 + 1;
            cArr[i14] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }
}
