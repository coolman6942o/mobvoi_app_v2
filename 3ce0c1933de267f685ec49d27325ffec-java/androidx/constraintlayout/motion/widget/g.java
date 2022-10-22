package androidx.constraintlayout.motion.widget;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import s.a;
import x.b;
import x.c;
import x.d;
/* compiled from: MotionController.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    boolean f1675a;

    /* renamed from: b  reason: collision with root package name */
    private k f1676b;

    /* renamed from: c  reason: collision with root package name */
    private k f1677c;

    /* renamed from: d  reason: collision with root package name */
    private f f1678d;

    /* renamed from: e  reason: collision with root package name */
    private f f1679e;

    /* renamed from: f  reason: collision with root package name */
    private a[] f1680f;

    /* renamed from: g  reason: collision with root package name */
    private a f1681g;

    /* renamed from: h  reason: collision with root package name */
    float f1682h;

    /* renamed from: i  reason: collision with root package name */
    float f1683i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f1684j;

    /* renamed from: k  reason: collision with root package name */
    private double[] f1685k;

    /* renamed from: l  reason: collision with root package name */
    private double[] f1686l;

    /* renamed from: m  reason: collision with root package name */
    private String[] f1687m;

    /* renamed from: n  reason: collision with root package name */
    private float[] f1688n;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<k> f1689o;

    /* renamed from: p  reason: collision with root package name */
    private HashMap<String, d> f1690p;

    /* renamed from: q  reason: collision with root package name */
    private HashMap<String, c> f1691q;

    /* renamed from: r  reason: collision with root package name */
    private HashMap<String, b> f1692r;

    /* renamed from: s  reason: collision with root package name */
    private e[] f1693s;

    /* renamed from: t  reason: collision with root package name */
    private int f1694t;

    /* renamed from: u  reason: collision with root package name */
    private View f1695u;

    /* renamed from: v  reason: collision with root package name */
    private int f1696v;

    /* renamed from: w  reason: collision with root package name */
    private float f1697w;

    /* renamed from: x  reason: collision with root package name */
    private Interpolator f1698x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f1699y;

    private float a(float f10, float[] fArr) {
        float f11 = 0.0f;
        float f12 = 1.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f13 = this.f1683i;
            if (f13 != 1.0d) {
                float f14 = this.f1682h;
                if (f10 < f14) {
                    f10 = 0.0f;
                }
                if (f10 > f14 && f10 < 1.0d) {
                    f10 = Math.min((f10 - f14) * f13, 1.0f);
                }
            }
        }
        s.b bVar = this.f1676b.f1735a;
        float f15 = Float.NaN;
        Iterator<k> it = this.f1689o.iterator();
        while (it.hasNext()) {
            k next = it.next();
            s.b bVar2 = next.f1735a;
            if (bVar2 != null) {
                float f16 = next.f1737c;
                if (f16 < f10) {
                    bVar = bVar2;
                    f11 = f16;
                } else if (Float.isNaN(f15)) {
                    f15 = next.f1737c;
                }
            }
        }
        if (bVar != null) {
            if (!Float.isNaN(f15)) {
                f12 = f15;
            }
            float f17 = f12 - f11;
            double d10 = (f10 - f11) / f17;
            f10 = (((float) bVar.a(d10)) * f17) + f11;
            if (fArr != null) {
                fArr[0] = (float) bVar.b(d10);
            }
        }
        return f10;
    }

    public void b(double d10, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f1680f[0].b(d10, dArr);
        this.f1680f[0].d(d10, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.f1676b.b(d10, this.f1684j, dArr, fArr, dArr2, fArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(View view, float f10, long j10, s.c cVar) {
        boolean z10;
        d.a aVar;
        int i10;
        double d10;
        View view2;
        float f11;
        float a10 = a(f10, null);
        int i11 = this.f1696v;
        if (i11 != d.f1672a) {
            float f12 = 1.0f / i11;
            float floor = ((float) Math.floor(a10 / f12)) * f12;
            float f13 = (a10 % f12) / f12;
            if (!Float.isNaN(this.f1697w)) {
                f13 = (f13 + this.f1697w) % 1.0f;
            }
            Interpolator interpolator = this.f1698x;
            if (interpolator != null) {
                f11 = interpolator.getInterpolation(f13);
            } else {
                f11 = ((double) f13) > 0.5d ? 1.0f : 0.0f;
            }
            a10 = (f11 * f12) + floor;
        }
        float f14 = a10;
        HashMap<String, c> hashMap = this.f1691q;
        if (hashMap != null) {
            for (c cVar2 : hashMap.values()) {
                cVar2.b(view, f14);
            }
        }
        HashMap<String, d> hashMap2 = this.f1690p;
        if (hashMap2 != null) {
            d.a aVar2 = null;
            boolean z11 = false;
            for (d dVar : hashMap2.values()) {
                if (dVar instanceof d.a) {
                    aVar2 = (d.a) dVar;
                } else {
                    z11 |= dVar.b(view, f14, j10, cVar);
                }
            }
            z10 = z11;
            aVar = aVar2;
        } else {
            aVar = null;
            z10 = false;
        }
        a[] aVarArr = this.f1680f;
        if (aVarArr != null) {
            double d11 = f14;
            aVarArr[0].b(d11, this.f1685k);
            this.f1680f[0].d(d11, this.f1686l);
            a aVar3 = this.f1681g;
            if (aVar3 != null) {
                double[] dArr = this.f1685k;
                if (dArr.length > 0) {
                    aVar3.b(d11, dArr);
                    this.f1681g.d(d11, this.f1686l);
                }
            }
            if (!this.f1699y) {
                d10 = d11;
                this.f1676b.c(f14, view, this.f1684j, this.f1685k, this.f1686l, null, this.f1675a);
                this.f1675a = false;
            } else {
                d10 = d11;
            }
            if (this.f1694t != d.f1672a) {
                if (this.f1695u == null) {
                    this.f1695u = ((View) view.getParent()).findViewById(this.f1694t);
                }
                if (this.f1695u != null) {
                    float top = (view2.getTop() + this.f1695u.getBottom()) / 2.0f;
                    float left = (this.f1695u.getLeft() + this.f1695u.getRight()) / 2.0f;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(left - view.getLeft());
                        view.setPivotY(top - view.getTop());
                    }
                }
            }
            HashMap<String, c> hashMap3 = this.f1691q;
            if (hashMap3 != null) {
                for (c cVar3 : hashMap3.values()) {
                    if (cVar3 instanceof c.a) {
                        double[] dArr2 = this.f1686l;
                        if (dArr2.length > 1) {
                            ((c.a) cVar3).c(view, f14, dArr2[0], dArr2[1]);
                        }
                    }
                }
            }
            if (aVar != null) {
                double[] dArr3 = this.f1686l;
                i10 = 1;
                z10 |= aVar.c(view, cVar, f14, j10, dArr3[0], dArr3[1]);
            } else {
                i10 = 1;
            }
            int i12 = i10;
            while (true) {
                a[] aVarArr2 = this.f1680f;
                if (i12 >= aVarArr2.length) {
                    break;
                }
                aVarArr2[i12].c(d10, this.f1688n);
                this.f1676b.f1747m.get(this.f1687m[i12 - 1]).e(view, this.f1688n);
                i12++;
            }
            f fVar = this.f1678d;
            if (fVar.f1673a == 0) {
                if (f14 <= 0.0f) {
                    view.setVisibility(fVar.f1674b);
                } else if (f14 >= 1.0f) {
                    view.setVisibility(this.f1679e.f1674b);
                } else if (this.f1679e.f1674b != fVar.f1674b) {
                    view.setVisibility(0);
                }
            }
            if (this.f1693s != null) {
                int i13 = 0;
                while (true) {
                    e[] eVarArr = this.f1693s;
                    if (i13 >= eVarArr.length) {
                        break;
                    }
                    eVarArr[i13].a(f14, view);
                    i13++;
                }
            }
        } else {
            i10 = 1;
            k kVar = this.f1676b;
            float f15 = kVar.f1739e;
            k kVar2 = this.f1677c;
            float f16 = f15 + ((kVar2.f1739e - f15) * f14);
            float f17 = kVar.f1740f;
            float f18 = f17 + ((kVar2.f1740f - f17) * f14);
            float f19 = kVar.f1741g;
            float f20 = kVar2.f1741g;
            float f21 = kVar.f1742h;
            float f22 = kVar2.f1742h;
            float f23 = f16 + 0.5f;
            int i14 = (int) f23;
            float f24 = f18 + 0.5f;
            int i15 = (int) f24;
            int i16 = (int) (f23 + ((f20 - f19) * f14) + f19);
            int i17 = (int) (f24 + ((f22 - f21) * f14) + f21);
            int i18 = i16 - i14;
            int i19 = i17 - i15;
            if (!(f20 == f19 && f22 == f21 && !this.f1675a)) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i18, 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
                this.f1675a = false;
            }
            view.layout(i14, i15, i16, i17);
        }
        HashMap<String, b> hashMap4 = this.f1692r;
        if (hashMap4 != null) {
            for (b bVar : hashMap4.values()) {
                if (bVar instanceof b.a) {
                    double[] dArr4 = this.f1686l;
                    ((b.a) bVar).c(view, f14, dArr4[0], dArr4[i10]);
                } else {
                    bVar.b(view, f14);
                }
            }
        }
        return z10;
    }

    public String toString() {
        k kVar = this.f1676b;
        float f10 = kVar.f1739e;
        float f11 = kVar.f1740f;
        k kVar2 = this.f1677c;
        float f12 = kVar2.f1739e;
        float f13 = kVar2.f1740f;
        StringBuilder sb2 = new StringBuilder(88);
        sb2.append(" start: x: ");
        sb2.append(f10);
        sb2.append(" y: ");
        sb2.append(f11);
        sb2.append(" end: x: ");
        sb2.append(f12);
        sb2.append(" y: ");
        sb2.append(f13);
        return sb2.toString();
    }
}
