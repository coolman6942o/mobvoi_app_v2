package gn;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f27546a;

    private g() {
    }

    public static void a(String str) {
        u.d("BreatheUtil", str);
    }

    public static g d() {
        if (f27546a == null) {
            f27546a = new g();
        }
        return f27546a;
    }

    public String b(byte[] bArr) {
        int i10 = bArr[5] & 255;
        int i11 = bArr[4] & 255;
        int i12 = (bArr[3] & 255) | ((bArr[2] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        return i12 + valueOf2 + valueOf;
    }

    public int c(byte[] bArr) {
        return bArr[6] & 255;
    }
}
