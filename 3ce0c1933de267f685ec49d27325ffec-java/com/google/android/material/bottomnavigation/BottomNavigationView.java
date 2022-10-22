package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.x0;
import androidx.core.view.d0;
import androidx.core.view.n0;
import com.google.android.material.internal.m;
import com.google.android.material.navigation.NavigationBarView;
import d7.d;
import d7.k;
import d7.l;
import w7.g;
/* loaded from: classes.dex */
public class BottomNavigationView extends NavigationBarView {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements m.d {
        a(BottomNavigationView bottomNavigationView) {
        }

        @Override // com.google.android.material.internal.m.d
        public n0 a(View view, n0 n0Var, m.e eVar) {
            eVar.f11103d += n0Var.j();
            boolean z10 = true;
            if (d0.E(view) != 1) {
                z10 = false;
            }
            int k10 = n0Var.k();
            int l10 = n0Var.l();
            eVar.f11100a += z10 ? l10 : k10;
            int i10 = eVar.f11102c;
            if (!z10) {
                k10 = l10;
            }
            eVar.f11102c = i10 + k10;
            eVar.a(view);
            return n0Var;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface b extends NavigationBarView.b {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface c extends NavigationBarView.c {
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.f25149e);
    }

    private void f(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.b.c(context, d7.c.f25171a));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.f25194g)));
        addView(view);
    }

    private void g() {
        m.a(this, new a(this));
    }

    private int h(int i10) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i10) == 1073741824 || suggestedMinimumHeight <= 0) {
            return i10;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
    }

    private boolean i() {
        return Build.VERSION.SDK_INT < 21 && !(getBackground() instanceof g);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected com.google.android.material.navigation.c d(Context context) {
        return new com.google.android.material.bottomnavigation.b(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, h(i11));
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        com.google.android.material.bottomnavigation.b bVar = (com.google.android.material.bottomnavigation.b) getMenuView();
        if (bVar.m() != z10) {
            bVar.setItemHorizontalTranslationEnabled(z10);
            getPresenter().d(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(b bVar) {
        setOnItemReselectedListener(bVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(c cVar) {
        setOnItemSelectedListener(cVar);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, k.f25344i);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Context context2 = getContext();
        x0 i12 = com.google.android.material.internal.k.i(context2, attributeSet, l.J, i10, i11, new int[0]);
        setItemHorizontalTranslationEnabled(i12.a(l.L, true));
        int i13 = l.K;
        if (i12.s(i13)) {
            setMinimumHeight(i12.f(i13, 0));
        }
        i12.w();
        if (i()) {
            f(context2);
        }
        g();
    }
}
