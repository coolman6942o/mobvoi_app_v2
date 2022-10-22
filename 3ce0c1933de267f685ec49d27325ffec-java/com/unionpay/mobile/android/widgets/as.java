package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.resource.c;
/* loaded from: classes2.dex */
public final class as extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private c f24325a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f24326b = null;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f24327c;

    public as(Context context) {
        super(context);
        this.f24325a = null;
        this.f24327c = null;
        this.f24325a = c.a(context);
        setBackgroundColor(0);
        setOrientation(1);
        this.f24327c = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a.C);
        layoutParams.gravity = 80;
        addView(this.f24327c, layoutParams);
        Drawable a10 = this.f24325a.a(1001, -1, -1);
        ImageView imageView = this.f24326b;
        if (imageView != null) {
            imageView.setBackgroundDrawable(a10);
        }
    }
}
