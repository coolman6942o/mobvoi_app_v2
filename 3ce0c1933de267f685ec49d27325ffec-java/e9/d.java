package e9;

import com.google.zxing.i;
/* compiled from: FinderPattern.java */
/* loaded from: classes.dex */
public final class d extends i {

    /* renamed from: c  reason: collision with root package name */
    private final float f25868c;

    /* renamed from: d  reason: collision with root package name */
    private final int f25869d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f25868c);
        return abs <= 1.0f || abs <= this.f25868c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d g(float f10, float f11, float f12) {
        int i10 = this.f25869d;
        int i11 = i10 + 1;
        float c10 = (i10 * c()) + f11;
        float f13 = i11;
        return new d(c10 / f13, ((this.f25869d * d()) + f10) / f13, ((this.f25869d * this.f25868c) + f12) / f13, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f25869d;
    }

    public float i() {
        return this.f25868c;
    }

    private d(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.f25868c = f12;
        this.f25869d = i10;
    }
}
