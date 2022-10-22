package k3;
/* compiled from: MeanCalculator.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private float f29734a;

    /* renamed from: b  reason: collision with root package name */
    private int f29735b;

    public void a(float f10) {
        float f11 = this.f29734a + f10;
        this.f29734a = f11;
        int i10 = this.f29735b + 1;
        this.f29735b = i10;
        if (i10 == Integer.MAX_VALUE) {
            this.f29734a = f11 / 2.0f;
            this.f29735b = i10 / 2;
        }
    }
}
