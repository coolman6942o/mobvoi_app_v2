package gn;
/* loaded from: classes2.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static x f27608a;

    private x() {
    }

    public static void a(String str) {
        u.d("OxygenUtil", str);
    }

    public static x e() {
        if (f27608a == null) {
            f27608a = new x();
        }
        return f27608a;
    }

    public int b(int i10) {
        return i10 > 0 ? Math.max(Math.min(i10, 100), 70) : i10;
    }

    public String c(byte[] bArr) {
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

    public int d(byte[] bArr) {
        return bArr[6] & 255;
    }
}
