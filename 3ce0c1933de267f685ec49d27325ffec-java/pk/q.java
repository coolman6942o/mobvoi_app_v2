package pk;

import android.content.Context;
import android.text.TextUtils;
/* compiled from: GBUtils.java */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static q f32817a;

    public q(Context context) {
    }

    private static byte a(char c10) {
        return (byte) "0123456789ABCDEF".indexOf(c10);
    }

    public static q b(Context context) {
        if (f32817a == null) {
            f32817a = new q(context);
        }
        return f32817a;
    }

    public byte[] c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (a(charArray[i11 + 1]) | (a(charArray[i11]) << 4));
        }
        return bArr;
    }
}
