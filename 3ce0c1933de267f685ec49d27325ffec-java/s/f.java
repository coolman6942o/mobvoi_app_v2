package s;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
/* compiled from: TimeCycleSplineSet.java */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    protected a f34218a;

    /* renamed from: e  reason: collision with root package name */
    protected int f34222e;

    /* renamed from: f  reason: collision with root package name */
    protected String f34223f;

    /* renamed from: i  reason: collision with root package name */
    protected long f34226i;

    /* renamed from: b  reason: collision with root package name */
    protected int f34219b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected int[] f34220c = new int[10];

    /* renamed from: d  reason: collision with root package name */
    protected float[][] f34221d = (float[][]) Array.newInstance(float.class, 10, 3);

    /* renamed from: g  reason: collision with root package name */
    protected float[] f34224g = new float[3];

    /* renamed from: h  reason: collision with root package name */
    protected boolean f34225h = false;

    /* renamed from: j  reason: collision with root package name */
    protected float f34227j = Float.NaN;

    public String toString() {
        String str = this.f34223f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f34222e; i10++) {
            str = str + "[" + this.f34220c[i10] + " , " + decimalFormat.format(this.f34221d[i10]) + "] ";
        }
        return str;
    }
}
