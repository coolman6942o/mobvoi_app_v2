package bn;
/* loaded from: classes2.dex */
public class j implements Comparable<j> {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f5303a;

    /* renamed from: b  reason: collision with root package name */
    private int f5304b;

    public j() {
        this.f5304b = 0;
    }

    public j(int i10, byte[] bArr) {
        this.f5304b = 0;
        this.f5304b = i10;
        this.f5303a = bArr;
    }

    /* renamed from: a */
    public int compareTo(j jVar) {
        return c() - jVar.c();
    }

    public byte[] b() {
        return this.f5303a;
    }

    public int c() {
        return this.f5304b;
    }

    public void d(byte[] bArr) {
        this.f5303a = bArr;
    }

    public void e(int i10) {
        this.f5304b = i10;
    }
}
