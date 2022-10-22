package com.mobvoi.companion.base.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes2.dex */
public class CustomViewPager extends ViewPager {

    /* renamed from: t0  reason: collision with root package name */
    private boolean f16574t0 = true;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f16574t0) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f16574t0) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setScanScroll(boolean z10) {
        this.f16574t0 = z10;
    }
}
