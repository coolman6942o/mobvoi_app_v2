package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
/* loaded from: classes2.dex */
public final class n4 {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f21468a;

    /* renamed from: b  reason: collision with root package name */
    private final TableLayout f21469b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f21470c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f21471d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21472e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f21473f;

    /* renamed from: g  reason: collision with root package name */
    public final Button f21474g;

    public n4(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f21468a = linearLayout;
        linearLayout.setLayoutParams(u1.d());
        this.f21468a.setOrientation(1);
        u1.c(this.f21468a);
        TableLayout tableLayout = new TableLayout(context);
        this.f21469b = tableLayout;
        tableLayout.setColumnShrinkable(0, false);
        tableLayout.setColumnStretchable(0, false);
        tableLayout.setColumnStretchable(1, false);
        tableLayout.setColumnShrinkable(1, false);
        TableRow tableRow = new TableRow(context);
        tableLayout.addView(tableRow);
        this.f21468a.addView(tableLayout);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f21470c = relativeLayout;
        tableRow.addView(relativeLayout);
        u1.l(this.f21470c, 19, 1.0f);
        u1.y(this.f21470c, null, null, "10dip", null);
        TextView textView = new TextView(context);
        this.f21473f = textView;
        u1.D(textView, 0);
        this.f21473f.setId(2301);
        this.f21470c.addView(this.f21473f);
        u1.y(this.f21473f, "6dip", null, null, null);
        TextView textView2 = new TextView(context);
        this.f21472e = textView2;
        u1.A(textView2, 0);
        this.f21472e.setId(2302);
        this.f21470c.addView(this.f21472e, u1.i(-2, -2, 3, 2301));
        u1.y(this.f21472e, "6dip", null, null, null);
        ImageView f10 = u1.f(context, "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAATZJREFUeNrsmMENgkAQRVnPUoAWQB0WoAVoAViA3tW7FEADUIDebUAaoAELwDv+TcaEkFUOsDhj5ieTTdgQ5jHLZ3aDQKVSqVSqAVTX9Q4RSUw8RKSIO+KGmI/5fNMzeZvsGdF88yVia4ypxgCY9Lx/ipi1rkUExb8CVIXFh4SvqMKRPQBBrDAcHFMJIHL2AG8XwrB2TJ0AcWEPQBB2ySwdUxtAlBIAQgxpy5WsKnKmkjVAAyJzuJMXezU+ykp/ZFuJsA0BgA17gAZE5ttevQF02GsOiIQ9AEHEGGJf9uodoMNe7UddsAcgiMyHvU4C4dIl9NcfsWgbFf0jE91KiG7mxLfTojc0oreUojf1oo9VvthlgeS3Y7QpfZu5J+LhsMu9mG7w14e7Q4LIPF5XqVQqlWi9BBgAacm2vqgEoPIAAAAASUVORK5CYII=", "go to selection");
        this.f21471d = f10;
        f10.setId(2307);
        this.f21471d.setColorFilter(t1.f21993t);
        RelativeLayout.LayoutParams j10 = u1.j(context, "20dip", "20dip", 15);
        j10.addRule(1, 2302);
        j10.addRule(1, 2301);
        this.f21470c.addView(this.f21471d, j10);
        Button button = new Button(context);
        this.f21474g = button;
        button.setId(2305);
        u1.u(button, 21);
        button.setTextSize(18.0f);
        tableRow.addView(button);
        u1.y(button, null, null, "6dip", null);
        u1.l(button, 21, 1.0f);
        u1.c(this.f21468a);
        this.f21468a.setVisibility(0);
    }

    public final void a(String str) {
        this.f21472e.setText(str);
        u1.m(this.f21472e, -2, -1);
        this.f21472e.setEllipsize(TextUtils.TruncateAt.START);
    }

    public final void b(boolean z10) {
        this.f21470c.setClickable(z10);
        this.f21471d.setVisibility(z10 ? 0 : 8);
    }

    public final void c(String str) {
        this.f21473f.setText(str);
    }
}
