package com.paypal.android.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobvoi.wear.providers.OtaColumn;
/* loaded from: classes2.dex */
public final class j4 {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f21387a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f21388b;

    /* renamed from: c  reason: collision with root package name */
    private p4 f21389c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f21390d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f21391e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f21392f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f21393g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f21394h;

    /* renamed from: i  reason: collision with root package name */
    private o4 f21395i;

    /* renamed from: j  reason: collision with root package name */
    private c4 f21396j;

    /* renamed from: k  reason: collision with root package name */
    private p4 f21397k;

    /* renamed from: l  reason: collision with root package name */
    private u4 f21398l;

    /* renamed from: m  reason: collision with root package name */
    private u4 f21399m;

    /* renamed from: n  reason: collision with root package name */
    private l4 f21400n;

    public j4(Context context, boolean z10) {
        ViewGroup e10 = u1.e(context);
        this.f21388b = e10;
        LinearLayout h10 = u1.h(e10);
        this.f21390d = h10;
        LinearLayout w10 = u1.w(h10);
        TextView textView = new TextView(context);
        this.f21391e = textView;
        u1.q(textView, "0dip", "0dip", "0dip", "14dip");
        this.f21391e.setTextSize(24.0f);
        this.f21391e.setTextColor(t1.f21978e);
        w10.addView(this.f21391e);
        u1.m(this.f21391e, -2, -2);
        p4 p4Var = new p4(context, OtaColumn.COLUMN_DESCRIPTION);
        this.f21389c = p4Var;
        p4Var.f21509d.setTypeface(t1.E);
        w10.addView(this.f21389c.f21506a);
        u1.k(this.f21389c.f21506a);
        u1.c(w10);
        if (z10) {
            l4 l4Var = new l4(context);
            this.f21400n = l4Var;
            w10.addView(l4Var.a());
            u1.c(w10);
            u4 u4Var = new u4(context);
            this.f21398l = u4Var;
            w10.addView(u4Var.a());
        } else {
            o4 o4Var = new o4(context);
            this.f21395i = o4Var;
            w10.addView(o4Var.f21484a);
            u1.k(this.f21395i.f21484a);
            u1.c(w10);
            p4 p4Var2 = new p4(context, "00 / 0000");
            this.f21397k = p4Var2;
            w10.addView(p4Var2.f21506a);
            u1.k(this.f21397k.f21506a);
        }
        u4 u4Var2 = new u4(context);
        this.f21399m = u4Var2;
        u4Var2.b(context, new q4());
        w10.addView(this.f21399m.a());
        TextView textView2 = new TextView(context);
        this.f21393g = textView2;
        textView2.setId(43002);
        u1.z(this.f21393g);
        w10.addView(this.f21393g);
        u1.m(this.f21393g, -1, -2);
        u1.y(this.f21393g, null, "20dip", null, "10dip");
        this.f21393g.setVisibility(8);
        this.f21392f = u1.g(context, true, 43001, w10);
        TextView textView3 = new TextView(context);
        this.f21394h = textView3;
        u1.t(textView3);
        this.f21394h.setText("init");
        this.f21392f.addView(this.f21394h);
        c4 c4Var = new c4(context);
        this.f21396j = c4Var;
        this.f21390d.addView(c4Var.f21085a);
        u1.m(this.f21396j.f21085a, -2, -2);
        u1.l(this.f21396j.f21085a, 17, 1.0f);
        this.f21387a = this.f21388b;
    }

    public final View a() {
        return this.f21387a;
    }

    public final void b(Context context, d4 d4Var) {
        u4 u4Var = this.f21398l;
        if (u4Var != null) {
            u4Var.b(context, d4Var);
        }
    }

    public final void c(Context context, q4 q4Var) {
        u4 u4Var = this.f21399m;
        if (u4Var != null) {
            u4Var.b(context, q4Var);
        }
    }

    public final void d(SpannableString spannableString) {
        TextView textView;
        int i10;
        if (y1.m(spannableString)) {
            this.f21393g.setText(spannableString);
            textView = this.f21393g;
            i10 = 0;
        } else {
            textView = this.f21393g;
            i10 = 8;
        }
        textView.setVisibility(i10);
    }

    public final void e(View.OnClickListener onClickListener) {
        l4 l4Var = this.f21400n;
        if (l4Var != null) {
            l4Var.b(onClickListener);
        }
    }

    public final void f(String str) {
        this.f21400n.c(str);
    }

    public final void g(String str, Bitmap bitmap, String str2) {
        this.f21395i.f21486c.setText(str);
        this.f21395i.f21487d.setImageBitmap(bitmap);
        this.f21397k.f21508c.setText(str2);
    }

    public final void h(String str, String str2) {
        this.f21389c.f21509d.setText(str);
        this.f21389c.f21508c.setText(str2);
    }

    public final void i(boolean z10) {
        TextView textView;
        ft ftVar;
        if (z10) {
            if (y1.n()) {
                textView = this.f21394h;
                ftVar = ft.AGREE_AND_PAY;
            } else {
                textView = this.f21394h;
                ftVar = ft.CONFIRM_SEND_PAYMENT;
            }
            textView.setText(z3.a(ftVar));
            this.f21400n.d();
            return;
        }
        this.f21394h.setText(z3.a(ft.CONFIRM_CHARGE_CREDIT_CARD));
        this.f21395i.f21484a.setVisibility(0);
        this.f21397k.f21506a.setVisibility(0);
        this.f21397k.f21509d.setText(z3.a(ft.EXPIRES_ON_DATE));
    }

    public final TextView j() {
        return this.f21391e;
    }

    public final void k(View.OnClickListener onClickListener) {
        this.f21392f.setOnClickListener(onClickListener);
    }

    public final void l(boolean z10) {
        LinearLayout linearLayout = this.f21392f;
        if (linearLayout != null) {
            linearLayout.setEnabled(z10);
        }
    }

    public final void m() {
        this.f21389c.a();
    }

    public final void n(View.OnClickListener onClickListener) {
        u4 u4Var = this.f21398l;
        if (u4Var != null) {
            u4Var.c(onClickListener);
        }
    }

    public final TextView o() {
        return this.f21396j.f21087c;
    }

    public final void p(View.OnClickListener onClickListener) {
        u4 u4Var = this.f21399m;
        if (u4Var != null) {
            u4Var.c(onClickListener);
        }
    }

    public final View q() {
        u4 u4Var = this.f21398l;
        if (u4Var != null) {
            return u4Var.a();
        }
        return null;
    }

    public final View r() {
        u4 u4Var = this.f21399m;
        if (u4Var != null) {
            return u4Var.a();
        }
        return null;
    }
}
