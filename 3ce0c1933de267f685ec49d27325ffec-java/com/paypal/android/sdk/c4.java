package com.paypal.android.sdk;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes2.dex */
public final class c4 {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f21085a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f21086b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21087c;

    public c4(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f21086b = linearLayout;
        linearLayout.setOrientation(0);
        TextView textView = new TextView(context);
        this.f21087c = textView;
        textView.setText("server");
        this.f21087c.setTextColor(-1);
        this.f21087c.setBackgroundColor(t1.f21983j);
        this.f21087c.setGravity(17);
        this.f21086b.addView(this.f21087c);
        u1.q(this.f21087c, "8dip", "8dip", "8dip", "8dip");
        u1.m(this.f21087c, -2, -2);
        u1.y(this.f21087c, null, "15dip", null, "15dip");
        u1.l(this.f21087c, 1, 1.0f);
        this.f21085a = this.f21086b;
    }
}
