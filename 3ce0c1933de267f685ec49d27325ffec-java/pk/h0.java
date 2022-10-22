package pk;
/* compiled from: RateDayInfo.java */
/* loaded from: classes2.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    private long f32807a;

    /* renamed from: b  reason: collision with root package name */
    private int f32808b;

    public h0(long j10, int i10) {
        d(j10);
        c(i10);
    }

    public int a() {
        return this.f32808b;
    }

    public long b() {
        return this.f32807a;
    }

    public void c(int i10) {
        this.f32808b = i10;
    }

    public void d(long j10) {
        this.f32807a = j10;
    }

    public String toString() {
        return "RateDayInfo{time=" + this.f32807a + ", rate=" + this.f32808b + '}';
    }
}
