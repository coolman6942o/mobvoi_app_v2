package nk;
/* compiled from: PeriodCycle.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final long f31298a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31299b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31300c;

    public a(long j10, int i10, int i11) {
        this.f31298a = j10;
        this.f31299b = i10;
        this.f31300c = i11;
    }

    public int a() {
        int i10 = this.f31300c;
        if (i10 > 0) {
            return i10;
        }
        return 28;
    }

    public int b() {
        int i10 = this.f31299b;
        if (i10 > 0) {
            return i10;
        }
        return 5;
    }

    public long c() {
        return this.f31298a;
    }

    public String toString() {
        return "PeriodCycle {" + this.f31298a + ": menstruation " + this.f31299b + ", cycle " + this.f31300c + "}";
    }
}
