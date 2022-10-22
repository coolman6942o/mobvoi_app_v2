package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import androidx.core.view.f;
import androidx.core.view.n0;
import e0.a;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HeaderScrollingViewBehavior.java */
/* loaded from: classes.dex */
public abstract class b extends c<View> {

    /* renamed from: d  reason: collision with root package name */
    final Rect f10392d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    final Rect f10393e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private int f10394f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f10395g;

    public b() {
    }

    private static int N(int i10) {
        if (i10 == 0) {
            return 8388659;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.appbar.c
    public void F(CoordinatorLayout coordinatorLayout, View view, int i10) {
        View H = H(coordinatorLayout.r(view));
        if (H != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f10392d;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, H.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((coordinatorLayout.getHeight() + H.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            n0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && d0.B(coordinatorLayout) && !d0.B(view)) {
                rect.left += lastWindowInsets.k();
                rect.right -= lastWindowInsets.l();
            }
            Rect rect2 = this.f10393e;
            f.a(N(fVar.f2200c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i10);
            int I = I(H);
            view.layout(rect2.left, rect2.top - I, rect2.right, rect2.bottom - I);
            this.f10394f = rect2.top - H.getBottom();
            return;
        }
        super.F(coordinatorLayout, view, i10);
        this.f10394f = 0;
    }

    abstract View H(List<View> list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int I(View view) {
        if (this.f10395g == 0) {
            return 0;
        }
        float J = J(view);
        int i10 = this.f10395g;
        return a.b((int) (J * i10), 0, i10);
    }

    abstract float J(View view);

    public final int K() {
        return this.f10395g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int L(View view) {
        return view.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int M() {
        return this.f10394f;
    }

    public final void O(int i10) {
        this.f10395g = i10;
    }

    protected boolean P() {
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i10, int i11, int i12, int i13) {
        View H;
        n0 lastWindowInsets;
        int i14 = view.getLayoutParams().height;
        if ((i14 != -1 && i14 != -2) || (H = H(coordinatorLayout.r(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i12);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (d0.B(H) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.m() + lastWindowInsets.j();
        }
        int L = size + L(H);
        int measuredHeight = H.getMeasuredHeight();
        if (P()) {
            view.setTranslationY(-measuredHeight);
        } else {
            L -= measuredHeight;
        }
        coordinatorLayout.J(view, i10, i11, View.MeasureSpec.makeMeasureSpec(L, i14 == -1 ? 1073741824 : Integer.MIN_VALUE), i13);
        return true;
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
