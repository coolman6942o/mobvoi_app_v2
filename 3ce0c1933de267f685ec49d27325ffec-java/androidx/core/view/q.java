package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
/* compiled from: NestedScrollingChildHelper.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f2619a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f2620b;

    /* renamed from: c  reason: collision with root package name */
    private final View f2621c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2622d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f2623e;

    public q(View view) {
        this.f2621c = view;
    }

    private boolean g(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent h10;
        int i15;
        int i16;
        int[] iArr3;
        if (!l() || (h10 = h(i14)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f2621c.getLocationInWindow(iArr);
            i16 = iArr[0];
            i15 = iArr[1];
        } else {
            i16 = 0;
            i15 = 0;
        }
        if (iArr2 == null) {
            int[] i17 = i();
            i17[0] = 0;
            i17[1] = 0;
            iArr3 = i17;
        } else {
            iArr3 = iArr2;
        }
        h0.d(h10, this.f2621c, i10, i11, i12, i13, i14, iArr3);
        if (iArr != null) {
            this.f2621c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i16;
            iArr[1] = iArr[1] - i15;
        }
        return true;
    }

    private ViewParent h(int i10) {
        if (i10 == 0) {
            return this.f2619a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f2620b;
    }

    private int[] i() {
        if (this.f2623e == null) {
            this.f2623e = new int[2];
        }
        return this.f2623e;
    }

    private void n(int i10, ViewParent viewParent) {
        if (i10 == 0) {
            this.f2619a = viewParent;
        } else if (i10 == 1) {
            this.f2620b = viewParent;
        }
    }

    public boolean a(float f10, float f11, boolean z10) {
        ViewParent h10;
        if (!l() || (h10 = h(0)) == null) {
            return false;
        }
        return h0.a(h10, this.f2621c, f10, f11, z10);
    }

    public boolean b(float f10, float f11) {
        ViewParent h10;
        if (!l() || (h10 = h(0)) == null) {
            return false;
        }
        return h0.b(h10, this.f2621c, f10, f11);
    }

    public boolean c(int i10, int i11, int[] iArr, int[] iArr2) {
        return d(i10, i11, iArr, iArr2, 0);
    }

    public boolean d(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        ViewParent h10;
        int i13;
        int i14;
        if (!l() || (h10 = h(i12)) == null) {
            return false;
        }
        if (i10 != 0 || i11 != 0) {
            if (iArr2 != null) {
                this.f2621c.getLocationInWindow(iArr2);
                i14 = iArr2[0];
                i13 = iArr2[1];
            } else {
                i14 = 0;
                i13 = 0;
            }
            if (iArr == null) {
                iArr = i();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            h0.c(h10, this.f2621c, i10, i11, iArr, i12);
            if (iArr2 != null) {
                this.f2621c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i14;
                iArr2[1] = iArr2[1] - i13;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public void e(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        g(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public boolean f(int i10, int i11, int i12, int i13, int[] iArr) {
        return g(i10, i11, i12, i13, iArr, 0, null);
    }

    public boolean j() {
        return k(0);
    }

    public boolean k(int i10) {
        return h(i10) != null;
    }

    public boolean l() {
        return this.f2622d;
    }

    public void m(boolean z10) {
        if (this.f2622d) {
            d0.R0(this.f2621c);
        }
        this.f2622d = z10;
    }

    public boolean o(int i10) {
        return p(i10, 0);
    }

    public boolean p(int i10, int i11) {
        if (k(i11)) {
            return true;
        }
        if (!l()) {
            return false;
        }
        View view = this.f2621c;
        for (ViewParent parent = this.f2621c.getParent(); parent != null; parent = parent.getParent()) {
            if (h0.f(parent, view, this.f2621c, i10, i11)) {
                n(i11, parent);
                h0.e(parent, view, this.f2621c, i10, i11);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void q() {
        r(0);
    }

    public void r(int i10) {
        ViewParent h10 = h(i10);
        if (h10 != null) {
            h0.g(h10, this.f2621c, i10);
            n(i10, null);
        }
    }
}
