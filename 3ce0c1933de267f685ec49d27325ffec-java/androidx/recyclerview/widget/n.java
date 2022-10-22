package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: PagerSnapHelper.java */
/* loaded from: classes.dex */
public class n extends r {

    /* renamed from: c  reason: collision with root package name */
    private m f4107c;

    /* renamed from: d  reason: collision with root package name */
    private m f4108d;

    /* compiled from: PagerSnapHelper.java */
    /* loaded from: classes.dex */
    class a extends k {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.RecyclerView.x
        protected void o(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
            n nVar = n.this;
            int[] c10 = nVar.c(nVar.f4115a.getLayoutManager(), view);
            int i10 = c10[0];
            int i11 = c10[1];
            int w10 = w(Math.max(Math.abs(i10), Math.abs(i11)));
            if (w10 > 0) {
                aVar.d(i10, i11, w10, this.f4096j);
            }
        }

        @Override // androidx.recyclerview.widget.k
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.k
        public int x(int i10) {
            return Math.min(100, super.x(i10));
        }
    }

    private int k(View view, m mVar) {
        return (mVar.g(view) + (mVar.e(view) / 2)) - (mVar.m() + (mVar.n() / 2));
    }

    private View l(RecyclerView.LayoutManager layoutManager, m mVar) {
        int K = layoutManager.K();
        View view = null;
        if (K == 0) {
            return null;
        }
        int m10 = mVar.m() + (mVar.n() / 2);
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < K; i11++) {
            View J = layoutManager.J(i11);
            int abs = Math.abs((mVar.g(J) + (mVar.e(J) / 2)) - m10);
            if (abs < i10) {
                view = J;
                i10 = abs;
            }
        }
        return view;
    }

    private m m(RecyclerView.LayoutManager layoutManager) {
        m mVar = this.f4108d;
        if (mVar == null || mVar.f4104a != layoutManager) {
            this.f4108d = m.a(layoutManager);
        }
        return this.f4108d;
    }

    private m n(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.m()) {
            return o(layoutManager);
        }
        if (layoutManager.l()) {
            return m(layoutManager);
        }
        return null;
    }

    private m o(RecyclerView.LayoutManager layoutManager) {
        m mVar = this.f4107c;
        if (mVar == null || mVar.f4104a != layoutManager) {
            this.f4107c = m.c(layoutManager);
        }
        return this.f4107c;
    }

    private boolean p(RecyclerView.LayoutManager layoutManager, int i10, int i11) {
        return layoutManager.l() ? i10 > 0 : i11 > 0;
    }

    private boolean q(RecyclerView.LayoutManager layoutManager) {
        PointF a10;
        int Z = layoutManager.Z();
        if (!(layoutManager instanceof RecyclerView.x.b) || (a10 = ((RecyclerView.x.b) layoutManager).a(Z - 1)) == null) {
            return false;
        }
        return a10.x < 0.0f || a10.y < 0.0f;
    }

    @Override // androidx.recyclerview.widget.r
    public int[] c(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.l()) {
            iArr[0] = k(view, m(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.m()) {
            iArr[1] = k(view, o(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.r
    protected RecyclerView.x d(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.x.b)) {
            return null;
        }
        return new a(this.f4115a.getContext());
    }

    @Override // androidx.recyclerview.widget.r
    public View f(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.m()) {
            return l(layoutManager, o(layoutManager));
        }
        if (layoutManager.l()) {
            return l(layoutManager, m(layoutManager));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.r
    public int g(RecyclerView.LayoutManager layoutManager, int i10, int i11) {
        m n10;
        int Z = layoutManager.Z();
        if (Z == 0 || (n10 = n(layoutManager)) == null) {
            return -1;
        }
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        int K = layoutManager.K();
        View view = null;
        View view2 = null;
        for (int i14 = 0; i14 < K; i14++) {
            View J = layoutManager.J(i14);
            if (J != null) {
                int k10 = k(J, n10);
                if (k10 <= 0 && k10 > i12) {
                    view2 = J;
                    i12 = k10;
                }
                if (k10 >= 0 && k10 < i13) {
                    view = J;
                    i13 = k10;
                }
            }
        }
        boolean p10 = p(layoutManager, i10, i11);
        if (p10 && view != null) {
            return layoutManager.i0(view);
        }
        if (!(p10 || view2 == null)) {
            return layoutManager.i0(view2);
        }
        if (p10) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int i02 = layoutManager.i0(view) + (q(layoutManager) == p10 ? -1 : 1);
        if (i02 < 0 || i02 >= Z) {
            return -1;
        }
        return i02;
    }
}
