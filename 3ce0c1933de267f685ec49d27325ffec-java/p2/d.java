package p2;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ int f32547a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ byte[] f32548b;

    public void a(byte[] bArr) {
    }

    public void b(int i10) {
        this.f32547a = i10;
    }

    public void c(byte[] bArr) {
        this.f32548b = bArr;
    }

    public byte[] d() {
        byte[] bArr = this.f32548b;
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length + 3];
        int i10 = 0;
        bArr2[0] = -94;
        bArr2[1] = (byte) (bArr.length + 1);
        bArr2[2] = (byte) this.f32547a;
        while (true) {
            byte[] bArr3 = this.f32548b;
            if (i10 >= bArr3.length) {
                return bArr2;
            }
            bArr2[i10 + 3] = bArr3[i10];
            i10++;
        }
    }
}
