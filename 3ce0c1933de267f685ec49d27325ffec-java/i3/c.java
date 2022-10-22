package i3;

import k3.b;
import k3.g;
/* compiled from: GradientColor.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f28027a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f28028b;

    public c(float[] fArr, int[] iArr) {
        this.f28027a = fArr;
        this.f28028b = iArr;
    }

    public int[] a() {
        return this.f28028b;
    }

    public float[] b() {
        return this.f28027a;
    }

    public int c() {
        return this.f28028b.length;
    }

    public void d(c cVar, c cVar2, float f10) {
        if (cVar.f28028b.length == cVar2.f28028b.length) {
            for (int i10 = 0; i10 < cVar.f28028b.length; i10++) {
                this.f28027a[i10] = g.j(cVar.f28027a[i10], cVar2.f28027a[i10], f10);
                this.f28028b[i10] = b.c(f10, cVar.f28028b[i10], cVar2.f28028b[i10]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f28028b.length + " vs " + cVar2.f28028b.length + ")");
    }
}
