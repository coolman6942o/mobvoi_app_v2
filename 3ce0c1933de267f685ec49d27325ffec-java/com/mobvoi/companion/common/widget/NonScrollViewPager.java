package com.mobvoi.companion.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.internal.i;
/* compiled from: NonScrollViewPager.kt */
/* loaded from: classes2.dex */
public final class NonScrollViewPager extends ViewPager {

    /* renamed from: t0  reason: collision with root package name */
    private boolean f16669t0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        i.f(event, "event");
        return this.f16669t0 && super.onInterceptTouchEvent(event);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        i.f(event, "event");
        return this.f16669t0 && super.onTouchEvent(event);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i10) {
        super.R(i10, false);
    }

    public final void setScrollingEnabled(boolean z10) {
        this.f16669t0 = z10;
    }
}
