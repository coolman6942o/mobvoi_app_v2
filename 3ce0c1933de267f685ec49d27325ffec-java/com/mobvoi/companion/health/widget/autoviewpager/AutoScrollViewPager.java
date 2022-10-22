package com.mobvoi.companion.health.widget.autoviewpager;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.alipay.sdk.app.PayTask;
import com.mobvoi.android.common.utils.l;
/* loaded from: classes2.dex */
public class AutoScrollViewPager extends ViewPager {

    /* renamed from: t0  reason: collision with root package name */
    private int f17146t0;

    /* renamed from: u0  reason: collision with root package name */
    private boolean f17147u0 = true;

    /* renamed from: v0  reason: collision with root package name */
    private Runnable f17148v0 = new a();

    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollViewPager autoScrollViewPager = AutoScrollViewPager.this;
            autoScrollViewPager.f17146t0 = autoScrollViewPager.getCurrentItem();
            androidx.viewpager.widget.a adapter = AutoScrollViewPager.this.getAdapter();
            if (adapter == null || AutoScrollViewPager.this.f17146t0 != adapter.d() - 1) {
                AutoScrollViewPager.Y(AutoScrollViewPager.this);
            } else {
                AutoScrollViewPager.this.f17146t0 = 0;
            }
            AutoScrollViewPager autoScrollViewPager2 = AutoScrollViewPager.this;
            autoScrollViewPager2.setCurrentItem(autoScrollViewPager2.f17146t0);
            l.a().postDelayed(this, PayTask.f6879j);
        }
    }

    public AutoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Z();
    }

    static /* synthetic */ int Y(AutoScrollViewPager autoScrollViewPager) {
        int i10 = autoScrollViewPager.f17146t0;
        autoScrollViewPager.f17146t0 = i10 + 1;
        return i10;
    }

    private void Z() {
    }

    private void a0() {
        b0();
        l.a().postDelayed(this.f17148v0, 1500L);
    }

    private void b0() {
        l.a().removeCallbacks(this.f17148v0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        a0();
        super.onAttachedToWindow();
        if (this.f17147u0) {
            this.f17147u0 = false;
        } else {
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        b0();
        if (getContext() instanceof Activity) {
            Activity activity = (Activity) getContext();
            if (activity.isFinishing() || activity.isDestroyed()) {
                super.onDetachedFromWindow();
                return;
            }
            return;
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            b0();
        } else if (action == 1) {
            a0();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAutoScroll(boolean z10) {
        if (!z10) {
            b0();
        } else {
            a0();
        }
    }
}
