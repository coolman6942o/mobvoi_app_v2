package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes2.dex */
public final class u4 {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f22022a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f22023b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f22024c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f22025d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22026e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22027f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f22028g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f22029h;

    public u4(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f22022a = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f22023b = relativeLayout;
        this.f22022a.addView(relativeLayout);
        ImageView imageView = new ImageView(context);
        this.f22024c = imageView;
        imageView.setId(2301);
        this.f22023b.addView(this.f22024c);
        u1.x(this.f22024c, "35dip", "35dip");
        u1.y(this.f22024c, null, "4dip", null, null);
        ImageView f10 = u1.f(context, "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAATZJREFUeNrsmMENgkAQRVnPUoAWQB0WoAVoAViA3tW7FEADUIDebUAaoAELwDv+TcaEkFUOsDhj5ieTTdgQ5jHLZ3aDQKVSqVSqAVTX9Q4RSUw8RKSIO+KGmI/5fNMzeZvsGdF88yVia4ypxgCY9Lx/ipi1rkUExb8CVIXFh4SvqMKRPQBBrDAcHFMJIHL2AG8XwrB2TJ0AcWEPQBB2ySwdUxtAlBIAQgxpy5WsKnKmkjVAAyJzuJMXezU+ykp/ZFuJsA0BgA17gAZE5ttevQF02GsOiIQ9AEHEGGJf9uodoMNe7UddsAcgiMyHvU4C4dIl9NcfsWgbFf0jE91KiG7mxLfTojc0oreUojf1oo9VvthlgeS3Y7QpfZu5J+LhsMu9mG7w14e7Q4LIPF5XqVQqlWi9BBgAacm2vqgEoPIAAAAASUVORK5CYII=", "go to selection");
        this.f22025d = f10;
        f10.setId(2304);
        this.f22025d.setColorFilter(t1.f21993t);
        RelativeLayout.LayoutParams j10 = u1.j(context, "20dip", "20dip", 11);
        j10.addRule(15);
        this.f22023b.addView(this.f22025d, j10);
        TextView textView = new TextView(context);
        this.f22026e = textView;
        u1.D(textView, 83);
        this.f22026e.setId(2302);
        RelativeLayout.LayoutParams i10 = u1.i(-2, -2, 1, 2301);
        i10.addRule(0, 2304);
        this.f22023b.addView(this.f22026e, i10);
        u1.y(this.f22026e, "6dip", null, null, null);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setId(2306);
        RelativeLayout.LayoutParams i11 = u1.i(-2, -2, 1, 2301);
        i11.addRule(3, 2302);
        i11.addRule(0, 2304);
        this.f22023b.addView(linearLayout2, i11);
        TextView textView2 = new TextView(context);
        this.f22027f = textView2;
        u1.A(textView2, 83);
        linearLayout2.addView(this.f22027f);
        u1.y(this.f22027f, "6dip", null, null, null);
        TextView textView3 = new TextView(context);
        this.f22028g = textView3;
        textView3.setId(2305);
        u1.D(this.f22028g, 83);
        linearLayout2.addView(this.f22028g);
        u1.y(this.f22028g, "6dip", null, null, null);
        TextView textView4 = new TextView(context);
        this.f22029h = textView4;
        textView4.setId(2307);
        u1.C(this.f22029h, 83);
        RelativeLayout.LayoutParams i12 = u1.i(-2, -2, 1, 2301);
        i12.addRule(3, 2306);
        i12.addRule(0, 2304);
        this.f22023b.addView(this.f22029h, i12);
        this.f22029h.setText(z3.a(ft.PAY_AFTER_DELIVERY));
        u1.y(this.f22029h, "6dip", null, null, null);
        this.f22029h.setVisibility(8);
        u1.c(this.f22022a);
        this.f22022a.setVisibility(8);
    }

    public final View a() {
        return this.f22022a;
    }

    public final void b(Context context, t4 t4Var) {
        TextView textView;
        int i10;
        this.f22024c.setImageBitmap(u1.B(t4Var.a(), context));
        this.f22026e.setText(t4Var.b());
        u1.m(this.f22026e, -2, -1);
        this.f22027f.setText(t4Var.c());
        u1.m(this.f22027f, -2, -1);
        this.f22027f.setEllipsize(TextUtils.TruncateAt.END);
        this.f22028g.setText(t4Var.d());
        u1.m(this.f22028g, -2, -1);
        this.f22028g.setEllipsize(TextUtils.TruncateAt.END);
        if (t4Var.e()) {
            textView = this.f22029h;
            i10 = 0;
        } else {
            textView = this.f22029h;
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    public final void c(View.OnClickListener onClickListener) {
        this.f22022a.setOnClickListener(onClickListener);
    }
}
