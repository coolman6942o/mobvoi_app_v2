package gn;
/* loaded from: classes2.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static a0 f27517a;

    public static a0 b() {
        if (f27517a == null) {
            f27517a = new a0();
        }
        return f27517a;
    }

    public String a(byte[] bArr) {
        int i10 = bArr[6] & 255;
        int i11 = bArr[5] & 255;
        int i12 = (bArr[4] & 255) | ((bArr[3] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        return String.valueOf(i12) + valueOf2 + valueOf;
    }

    public String c(String str, int i10, int i11) {
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        return str + valueOf + valueOf2;
    }

    public String d(String str, int i10, int i11, int i12) {
        int i13 = (i10 * 60) + i11 + i12;
        int i14 = i13 / 60;
        int i15 = i13 % 60;
        String valueOf = String.valueOf(i14);
        String valueOf2 = String.valueOf(i15);
        if (i14 < 10) {
            valueOf = "0" + i14;
        }
        if (i15 < 10) {
            valueOf2 = "0" + i15;
        }
        return str + valueOf + valueOf2;
    }
}
