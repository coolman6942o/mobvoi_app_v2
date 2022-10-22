package gn;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f27515b;

    /* renamed from: a  reason: collision with root package name */
    private int f27516a = 0;

    public static a g() {
        if (f27515b == null) {
            f27515b = new a();
        }
        return f27515b;
    }

    public int a(byte[] bArr) {
        return ((bArr[8] << 32) & (-16777216)) | (bArr[11] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[9] << 16) & 16711680);
    }

    public int b(byte[] bArr) {
        return ((bArr[2] << 32) & (-16777216)) | (bArr[5] & 255) | ((bArr[4] << 8) & 65280) | ((bArr[3] << 16) & 16711680);
    }

    public int c(byte[] bArr) {
        return bArr[2] & 255;
    }

    public String d(byte[] bArr) {
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
        return String.valueOf(i12) + valueOf2 + valueOf;
    }

    public int e() {
        j("获取tempSDKCrc =" + this.f27516a);
        return this.f27516a;
    }

    public int f(byte[] bArr) {
        return ((bArr[6] & 255) * 60) + (bArr[7] & 255);
    }

    public int h(byte[] bArr) {
        return ((bArr[12] << 32) & (-16777216)) | (bArr[15] & 255) | ((bArr[14] << 8) & 65280) | ((bArr[13] << 16) & 16711680);
    }

    public int i(byte[] bArr) {
        return ((bArr[6] << 32) & (-16777216)) | (bArr[9] & 255) | ((bArr[8] << 8) & 65280) | ((bArr[7] << 16) & 16711680);
    }

    public void j(String str) {
        u.d("AirPressureTemperature", str);
    }

    public void k(int i10) {
        this.f27516a = i10;
        j("初始化tempSDKCrc =" + this.f27516a);
    }

    public void l(byte[] bArr) {
        for (int i10 = 2; i10 < bArr.length; i10++) {
            this.f27516a ^= bArr[i10];
        }
        j("tempSDKCrc =" + this.f27516a);
    }
}
