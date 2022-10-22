package com.mobvoi.companion.health.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import com.mobvoi.android.common.ui.widget.CirclePageIndicator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import y9.b;
/* compiled from: DiscoveryPageIndicator.kt */
/* loaded from: classes2.dex */
public final class DiscoveryPageIndicator extends CirclePageIndicator {

    /* renamed from: u  reason: collision with root package name */
    private ViewPager f17127u;

    /* compiled from: DiscoveryPageIndicator.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscoveryPageIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
    }

    private final int d(int i10) {
        androidx.viewpager.widget.a adapter;
        ViewPager viewPager = this.f17127u;
        Integer num = null;
        if (!(viewPager == null || (adapter = viewPager.getAdapter()) == null)) {
            num = Integer.valueOf(adapter.d());
        }
        if (num == null) {
            return 0;
        }
        int intValue = num.intValue();
        if (i10 == 0) {
            return (intValue - 2) - 1;
        }
        if (i10 == intValue - 1) {
            return 0;
        }
        return i10 - 1;
    }

    @Override // com.mobvoi.android.common.ui.widget.CirclePageIndicator, androidx.viewpager.widget.ViewPager.j
    public void c(int i10, float f10, int i11) {
        super.c(d(i10), f10, i11);
    }

    @Override // com.mobvoi.android.common.ui.widget.CirclePageIndicator
    public void setViewPager(ViewPager viewPager) {
        super.setViewPager(viewPager);
        this.f17127u = viewPager;
    }

    @Override // com.mobvoi.android.common.ui.widget.CirclePageIndicator, androidx.viewpager.widget.ViewPager.j
    public void u(int i10) {
        androidx.viewpager.widget.a adapter;
        super.u(i10);
        ViewPager viewPager = this.f17127u;
        if (viewPager != null && (adapter = viewPager.getAdapter()) != null && i10 == 0) {
            if (viewPager.getCurrentItem() == 0) {
                viewPager.R(adapter.d() - 2, false);
            } else if (viewPager.getCurrentItem() == adapter.d() - 1) {
                viewPager.R(1, false);
            }
        }
    }

    @Override // com.mobvoi.android.common.ui.widget.CirclePageIndicator, androidx.viewpager.widget.ViewPager.j
    public void v(int i10) {
        super.v(d(i10));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DiscoveryPageIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f36804a);
        i.f(context, "context");
    }
}
