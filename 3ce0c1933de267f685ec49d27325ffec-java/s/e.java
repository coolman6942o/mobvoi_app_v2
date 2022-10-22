package s;

import java.text.DecimalFormat;
/* compiled from: SplineSet.java */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    protected a f34213a;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f34214b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    protected float[] f34215c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    private int f34216d;

    /* renamed from: e  reason: collision with root package name */
    private String f34217e;

    public float a(float f10) {
        return (float) this.f34213a.a(f10, 0);
    }

    public String toString() {
        String str = this.f34217e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f34216d; i10++) {
            str = str + "[" + this.f34214b[i10] + " , " + decimalFormat.format(this.f34215c[i10]) + "] ";
        }
        return str;
    }
}
