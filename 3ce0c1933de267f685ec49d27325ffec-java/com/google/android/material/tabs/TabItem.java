package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.x0;
import d7.l;
/* loaded from: classes.dex */
public class TabItem extends View {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f11336a;

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f11337b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11338c;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x0 u10 = x0.u(context, attributeSet, l.J4);
        this.f11336a = u10.p(l.M4);
        this.f11337b = u10.g(l.K4);
        this.f11338c = u10.n(l.L4, 0);
        u10.w();
    }
}
