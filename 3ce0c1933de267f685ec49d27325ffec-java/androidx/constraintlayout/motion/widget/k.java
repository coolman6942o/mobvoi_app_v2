package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.Arrays;
import java.util.LinkedHashMap;
import s.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MotionPaths.java */
/* loaded from: classes.dex */
public class k implements Comparable<k> {

    /* renamed from: q  reason: collision with root package name */
    static String[] f1734q = {"position", "x", "y", Constant.KEY_WIDTH, Constant.KEY_HEIGHT, "pathRotate"};

    /* renamed from: a  reason: collision with root package name */
    b f1735a;

    /* renamed from: c  reason: collision with root package name */
    float f1737c;

    /* renamed from: d  reason: collision with root package name */
    float f1738d;

    /* renamed from: e  reason: collision with root package name */
    float f1739e;

    /* renamed from: f  reason: collision with root package name */
    float f1740f;

    /* renamed from: g  reason: collision with root package name */
    float f1741g;

    /* renamed from: h  reason: collision with root package name */
    float f1742h;

    /* renamed from: j  reason: collision with root package name */
    int f1744j;

    /* renamed from: k  reason: collision with root package name */
    int f1745k;

    /* renamed from: b  reason: collision with root package name */
    int f1736b = 0;

    /* renamed from: i  reason: collision with root package name */
    float f1743i = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    g f1746l = null;

    /* renamed from: m  reason: collision with root package name */
    LinkedHashMap<String, ConstraintAttribute> f1747m = new LinkedHashMap<>();

    /* renamed from: n  reason: collision with root package name */
    int f1748n = 0;

    /* renamed from: o  reason: collision with root package name */
    double[] f1749o = new double[18];

    /* renamed from: p  reason: collision with root package name */
    double[] f1750p = new double[18];

    public k() {
        int i10 = d.f1672a;
        this.f1744j = i10;
        this.f1745k = i10;
    }

    /* renamed from: a */
    public int compareTo(k kVar) {
        return Float.compare(this.f1738d, kVar.f1738d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(double d10, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f10;
        float f11 = this.f1739e;
        float f12 = this.f1740f;
        float f13 = this.f1741g;
        float f14 = this.f1742h;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            float f19 = (float) dArr[i10];
            float f20 = (float) dArr2[i10];
            int i11 = iArr[i10];
            if (i11 == 1) {
                f11 = f19;
                f15 = f20;
            } else if (i11 == 2) {
                f12 = f19;
                f17 = f20;
            } else if (i11 == 3) {
                f13 = f19;
                f16 = f20;
            } else if (i11 == 4) {
                f14 = f19;
                f18 = f20;
            }
        }
        float f21 = 2.0f;
        float f22 = (f16 / 2.0f) + f15;
        float f23 = (f18 / 2.0f) + f17;
        g gVar = this.f1746l;
        if (gVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            gVar.b(d10, fArr3, fArr4);
            float f24 = fArr3[0];
            float f25 = fArr3[1];
            float f26 = fArr4[0];
            float f27 = fArr4[1];
            double d11 = f11;
            double d12 = f12;
            f10 = f13;
            f11 = (float) ((f24 + (Math.sin(d12) * d11)) - (f13 / 2.0f));
            f12 = (float) ((f25 - (d11 * Math.cos(d12))) - (f14 / 2.0f));
            double d13 = f15;
            double d14 = f17;
            f22 = (float) (f26 + (Math.sin(d12) * d13) + (Math.cos(d12) * d14));
            f23 = (float) ((f27 - (d13 * Math.cos(d12))) + (Math.sin(d12) * d14));
            f21 = 2.0f;
        } else {
            f10 = f13;
        }
        fArr[0] = f11 + (f10 / f21) + 0.0f;
        fArr[1] = f12 + (f14 / f21) + 0.0f;
        fArr2[0] = f22;
        fArr2[1] = f23;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f10, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3, boolean z10) {
        float f11;
        boolean z11;
        boolean z12;
        float f12;
        float f13 = this.f1739e;
        float f14 = this.f1740f;
        float f15 = this.f1741g;
        float f16 = this.f1742h;
        if (iArr.length != 0 && this.f1749o.length <= iArr[iArr.length - 1]) {
            int i10 = iArr[iArr.length - 1] + 1;
            this.f1749o = new double[i10];
            this.f1750p = new double[i10];
        }
        Arrays.fill(this.f1749o, Double.NaN);
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.f1749o[iArr[i11]] = dArr[i11];
            this.f1750p[iArr[i11]] = dArr2[i11];
        }
        float f17 = Float.NaN;
        int i12 = 0;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        float f21 = 0.0f;
        while (true) {
            double[] dArr4 = this.f1749o;
            if (i12 >= dArr4.length) {
                break;
            }
            double d10 = 0.0d;
            if (!Double.isNaN(dArr4[i12]) || !(dArr3 == null || dArr3[i12] == 0.0d)) {
                if (dArr3 != null) {
                    d10 = dArr3[i12];
                }
                if (!Double.isNaN(this.f1749o[i12])) {
                    d10 = this.f1749o[i12] + d10;
                }
                f12 = f17;
                float f22 = (float) d10;
                float f23 = (float) this.f1750p[i12];
                if (i12 == 1) {
                    f17 = f12;
                    f18 = f23;
                    f13 = f22;
                } else if (i12 == 2) {
                    f17 = f12;
                    f19 = f23;
                    f14 = f22;
                } else if (i12 == 3) {
                    f17 = f12;
                    f20 = f23;
                    f15 = f22;
                } else if (i12 == 4) {
                    f17 = f12;
                    f21 = f23;
                    f16 = f22;
                } else if (i12 == 5) {
                    f17 = f22;
                }
                i12++;
            } else {
                f12 = f17;
            }
            f17 = f12;
            i12++;
        }
        float f24 = f17;
        g gVar = this.f1746l;
        if (gVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            gVar.b(f10, fArr, fArr2);
            float f25 = fArr[0];
            float f26 = fArr[1];
            float f27 = fArr2[0];
            float f28 = fArr2[1];
            double d11 = f13;
            double d12 = f14;
            f13 = (float) ((f25 + (Math.sin(d12) * d11)) - (f15 / 2.0f));
            f11 = f16;
            f14 = (float) ((f26 - (Math.cos(d12) * d11)) - (f16 / 2.0f));
            double d13 = f18;
            double d14 = f19;
            float sin = (float) (f27 + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float cos = (float) ((f28 - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            if (dArr2.length >= 2) {
                z12 = false;
                dArr2[0] = sin;
                z11 = true;
                dArr2[1] = cos;
            } else {
                z12 = false;
                z11 = true;
            }
            if (!Float.isNaN(f24)) {
                view.setRotation((float) (f24 + Math.toDegrees(Math.atan2(cos, sin))));
            }
        } else {
            f11 = f16;
            z12 = false;
            z11 = true;
            if (!Float.isNaN(f24)) {
                view.setRotation((float) (0.0f + f24 + Math.toDegrees(Math.atan2(f19 + (f21 / 2.0f), f18 + (f20 / 2.0f)))));
            }
        }
        if (view instanceof c) {
            ((c) view).a(f13, f14, f15 + f13, f14 + f11);
            return;
        }
        float f29 = f13 + 0.5f;
        int i13 = (int) f29;
        float f30 = f14 + 0.5f;
        int i14 = (int) f30;
        int i15 = (int) (f29 + f15);
        int i16 = (int) (f30 + f11);
        int i17 = i15 - i13;
        int i18 = i16 - i14;
        if (!(i17 == view.getMeasuredWidth() && i18 == view.getMeasuredHeight())) {
            z12 = z11;
        }
        if (z12 || z10) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        view.layout(i13, i14, i15, i16);
    }
}
