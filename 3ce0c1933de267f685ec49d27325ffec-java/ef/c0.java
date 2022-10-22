package ef;

import xf.f;
/* compiled from: UiStride.java */
/* loaded from: classes2.dex */
public class c0 implements f {

    /* renamed from: a  reason: collision with root package name */
    private final long f25914a;

    /* renamed from: b  reason: collision with root package name */
    private final float f25915b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(long j10, float f10) {
        this.f25914a = j10;
        this.f25915b = f10;
    }

    @Override // xf.f
    public double a() {
        return this.f25914a / 1000.0d;
    }

    public long b() {
        return this.f25914a;
    }

    public float c() {
        return this.f25915b;
    }

    @Override // xf.f
    public double getValue() {
        return this.f25915b;
    }
}
