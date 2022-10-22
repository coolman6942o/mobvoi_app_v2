package bn;
/* loaded from: classes2.dex */
public class l implements Comparable<l> {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f5314a;

    /* renamed from: b  reason: collision with root package name */
    private int f5315b;

    public l() {
        this.f5315b = 0;
    }

    public l(int i10, byte[] bArr) {
        this.f5315b = 0;
        this.f5315b = i10;
        this.f5314a = bArr;
    }

    /* renamed from: a */
    public int compareTo(l lVar) {
        return c() - lVar.c();
    }

    public byte[] b() {
        return this.f5314a;
    }

    public int c() {
        return this.f5315b;
    }

    public void d(byte[] bArr) {
        this.f5314a = bArr;
    }

    public void e(int i10) {
        this.f5315b = i10;
    }
}
