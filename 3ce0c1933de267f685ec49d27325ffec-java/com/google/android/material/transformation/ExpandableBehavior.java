package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import java.util.List;
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {

    /* renamed from: a  reason: collision with root package name */
    private int f11665a = 0;

    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f11666a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f11667b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ o7.a f11668c;

        a(View view, int i10, o7.a aVar) {
            this.f11666a = view;
            this.f11667b = i10;
            this.f11668c = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f11666a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f11665a == this.f11667b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                o7.a aVar = this.f11668c;
                expandableBehavior.H((View) aVar, this.f11666a, aVar.isExpanded(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
    }

    private boolean F(boolean z10) {
        if (!z10) {
            return this.f11665a == 1;
        }
        int i10 = this.f11665a;
        return i10 == 0 || i10 == 2;
    }

    protected o7.a G(CoordinatorLayout coordinatorLayout, View view) {
        List<View> r10 = coordinatorLayout.r(view);
        int size = r10.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = r10.get(i10);
            if (e(coordinatorLayout, view, view2)) {
                return (o7.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean H(View view, View view2, boolean z10, boolean z11);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
        o7.a aVar = (o7.a) view2;
        if (!F(aVar.isExpanded())) {
            return false;
        }
        this.f11665a = aVar.isExpanded() ? 1 : 2;
        return H((View) aVar, view, aVar.isExpanded(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i10) {
        o7.a G;
        if (d0.X(view) || (G = G(coordinatorLayout, view)) == null || !F(G.isExpanded())) {
            return false;
        }
        int i11 = G.isExpanded() ? 1 : 2;
        this.f11665a = i11;
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, G));
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
