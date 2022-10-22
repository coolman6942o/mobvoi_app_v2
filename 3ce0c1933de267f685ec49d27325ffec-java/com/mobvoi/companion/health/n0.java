package com.mobvoi.companion.health;

import android.animation.FloatEvaluator;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.i;
/* compiled from: HealthFragmentModule.kt */
/* loaded from: classes2.dex */
public final class n0 extends RecyclerView.s {

    /* renamed from: a  reason: collision with root package name */
    private View f16894a;

    /* renamed from: b  reason: collision with root package name */
    private View f16895b;

    /* renamed from: c  reason: collision with root package name */
    private int f16896c;

    /* renamed from: d  reason: collision with root package name */
    private final float f16897d;

    /* renamed from: e  reason: collision with root package name */
    private final FloatEvaluator f16898e = new FloatEvaluator();

    /* renamed from: f  reason: collision with root package name */
    private final AccelerateInterpolator f16899f = new AccelerateInterpolator();

    public n0(Context context) {
        i.f(context, "context");
        this.f16897d = (u1.a(context) * 147.0f) / 375;
    }

    private final void c() {
        float f10 = this.f16897d;
        Float alpha = this.f16898e.evaluate(this.f16899f.getInterpolation((((float) Math.abs(this.f16896c)) > f10 ? (int) f10 : Math.abs(this.f16896c)) / this.f16897d), (Number) Float.valueOf(1.0f), (Number) Float.valueOf(0.0f));
        View view = this.f16894a;
        if (view != null) {
            i.e(alpha, "alpha");
            view.setAlpha(alpha.floatValue());
        }
        View view2 = this.f16895b;
        if (view2 != null) {
            i.e(alpha, "alpha");
            view2.setAlpha(Math.abs(1 - alpha.floatValue()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void b(RecyclerView recyclerView, int i10, int i11) {
        float f10;
        i.f(recyclerView, "recyclerView");
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null) {
            if (childAt instanceof PercentLayout) {
                PercentLayout percentLayout = (PercentLayout) childAt;
                if (percentLayout.getChildCount() == 0) {
                    f10 = percentLayout.getY();
                    this.f16896c = (int) f10;
                    c();
                }
            }
            f10 = this.f16897d;
            this.f16896c = (int) f10;
            c();
        }
    }

    public final void d(View view) {
        this.f16894a = view;
    }

    public final void e(View view) {
        this.f16895b = view;
    }
}
