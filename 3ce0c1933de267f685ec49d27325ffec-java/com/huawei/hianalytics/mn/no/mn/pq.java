package com.huawei.hianalytics.mn.no.mn;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.qr.mn;
import java.security.SecureRandom;
import java.util.Locale;
/* loaded from: classes.dex */
public abstract class pq {

    /* renamed from: mn  reason: collision with root package name */
    private static final char[] f13545mn = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static byte mn(char c10) {
        return (byte) "0123456789ABCDEF".indexOf(c10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String mn(int i10) {
        byte[] bArr = new byte[i10];
        new SecureRandom().nextBytes(bArr);
        return mn(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String mn(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            mn.op("HexUtil", "byteArray is empty");
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            char[] cArr = f13545mn;
            sb2.append(cArr[(b10 & 240) >> 4]);
            sb2.append(cArr[b10 & 15]);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] mn() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] mn(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (mn(charArray[i11 + 1]) | (mn(charArray[i11]) << 4));
        }
        return bArr;
    }
}
