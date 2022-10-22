package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: LinearSmoothScroller.java */
/* loaded from: classes.dex */
public class k extends RecyclerView.x {

    /* renamed from: k  reason: collision with root package name */
    protected PointF f4097k;

    /* renamed from: l  reason: collision with root package name */
    private final DisplayMetrics f4098l;

    /* renamed from: n  reason: collision with root package name */
    private float f4100n;

    /* renamed from: i  reason: collision with root package name */
    protected final LinearInterpolator f4095i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    protected final DecelerateInterpolator f4096j = new DecelerateInterpolator();

    /* renamed from: m  reason: collision with root package name */
    private boolean f4099m = false;

    /* renamed from: o  reason: collision with root package name */
    protected int f4101o = 0;

    /* renamed from: p  reason: collision with root package name */
    protected int f4102p = 0;

    public k(Context context) {
        this.f4098l = context.getResources().getDisplayMetrics();
    }

    private float A() {
        if (!this.f4099m) {
            this.f4100n = v(this.f4098l);
            this.f4099m = true;
        }
        return this.f4100n;
    }

    private int y(int i10, int i11) {
        int i12 = i10 - i11;
        if (i10 * i12 <= 0) {
            return 0;
        }
        return i12;
    }

    protected int B() {
        PointF pointF = this.f4097k;
        if (pointF != null) {
            float f10 = pointF.y;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    protected void C(RecyclerView.x.a aVar) {
        PointF a10 = a(f());
        if (a10 == null || (a10.x == 0.0f && a10.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(a10);
        this.f4097k = a10;
        this.f4101o = (int) (a10.x * 10000.0f);
        this.f4102p = (int) (a10.y * 10000.0f);
        aVar.d((int) (this.f4101o * 1.2f), (int) (this.f4102p * 1.2f), (int) (x(10000) * 1.2f), this.f4095i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    protected void l(int i10, int i11, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f4101o = y(this.f4101o, i10);
        int y10 = y(this.f4102p, i11);
        this.f4102p = y10;
        if (this.f4101o == 0 && y10 == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    protected void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    protected void n() {
        this.f4102p = 0;
        this.f4101o = 0;
        this.f4097k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    protected void o(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        int t10 = t(view, z());
        int u10 = u(view, B());
        int w10 = w((int) Math.sqrt((t10 * t10) + (u10 * u10)));
        if (w10 > 0) {
            aVar.d(-t10, -u10, w10, this.f4096j);
        }
    }

    public int s(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == -1) {
            return i12 - i10;
        }
        if (i14 == 0) {
            int i15 = i12 - i10;
            if (i15 > 0) {
                return i15;
            }
            int i16 = i13 - i11;
            if (i16 < 0) {
                return i16;
            }
            return 0;
        } else if (i14 == 1) {
            return i13 - i11;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int t(View view, int i10) {
        RecyclerView.LayoutManager e10 = e();
        if (e10 == null || !e10.l()) {
            return 0;
        }
        RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
        return s(e10.R(view) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, e10.U(view) + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, e10.f0(), e10.p0() - e10.g0(), i10);
    }

    public int u(View view, int i10) {
        RecyclerView.LayoutManager e10 = e();
        if (e10 == null || !e10.m()) {
            return 0;
        }
        RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
        return s(e10.V(view) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, e10.P(view) + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, e10.h0(), e10.X() - e10.e0(), i10);
    }

    protected float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w(int i10) {
        return (int) Math.ceil(x(i10) / 0.3356d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int x(int i10) {
        return (int) Math.ceil(Math.abs(i10) * A());
    }

    protected int z() {
        PointF pointF = this.f4097k;
        if (pointF != null) {
            float f10 = pointF.x;
            if (f10 != 0.0f) {
                return f10 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
