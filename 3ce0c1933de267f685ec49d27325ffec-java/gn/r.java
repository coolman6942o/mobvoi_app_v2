package gn;

import android.content.Context;
/* loaded from: classes2.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static r f27598a;

    public r(Context context) {
    }

    public static void a(String str) {
        u.d("sendTextKey", str);
    }

    public static r f(Context context) {
        if (f27598a == null) {
            f27598a = new r(context);
        }
        return f27598a;
    }

    public int b(byte[] bArr) {
        return (bArr[5] & 255) | ((bArr[4] << 8) & 65280);
    }

    public int c(byte[] bArr) {
        return (bArr[12] & 255) | ((bArr[11] << 8) & 65280);
    }

    public float d(byte[] bArr) {
        return (bArr[13] & 255) + ((bArr[14] & 255) / 100.0f);
    }

    public int e(byte[] bArr) {
        return (bArr[17] & 255) | ((bArr[15] << 8) & 16711680) | ((bArr[16] << 8) & 65280);
    }

    public int g(byte[] bArr) {
        return ((bArr[6] & 255) * 60) + (bArr[7] & 255);
    }

    public int h(byte[] bArr) {
        return bArr[3];
    }

    public int i(byte[] bArr) {
        return bArr[2];
    }

    public int j(byte[] bArr) {
        int i10 = (bArr[9] << 8) & 65280;
        return (bArr[10] & 255) | i10 | ((bArr[8] << 8) & 16711680);
    }
}
