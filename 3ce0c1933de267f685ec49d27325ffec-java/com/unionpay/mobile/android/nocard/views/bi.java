package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.b;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class bi extends b implements b.a, b.AbstractC0267b {

    /* renamed from: w  reason: collision with root package name */
    private static String f23676w = "download://";

    /* renamed from: r  reason: collision with root package name */
    private b f23677r;

    /* renamed from: s  reason: collision with root package name */
    private ViewGroup f23678s;

    /* renamed from: t  reason: collision with root package name */
    private int f23679t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f23680u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f23681v;

    public bi(Context context) {
        this(context, false, false);
    }

    public bi(Context context, boolean z10, boolean z11) {
        super(context);
        this.f23677r = null;
        this.f23678s = null;
        this.f23679t = 0;
        this.f23680u = false;
        this.f23681v = false;
        this.f23644f = 14;
        this.f23679t = ((a.f23329t - a.f23320k) - a.b(this.f23642d)) - (a.f23328s * 3);
        this.f23680u = z10;
        this.f23681v = z11;
        this.f23649k = a();
        b();
        d();
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ay ayVar = new ay(this.f23642d, this.f23639a.f23503af, this);
        if (this.f23680u) {
            ayVar = new ay(this.f23642d, this.f23639a.f23503af, this.f23641c.a(1030, -1, -1), g.a(this.f23642d, 20.0f), this);
        }
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    @Override // com.unionpay.mobile.android.upviews.b.AbstractC0267b
    public final void c(String str) {
        if (str != null && str.length() > 0 && str.startsWith(f23676w)) {
            String substring = str.substring(f23676w.length());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(substring));
            this.f23642d.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void d() {
        super.d();
        b bVar = new b(this.f23642d, this);
        this.f23677r = bVar;
        bVar.setOnTouchListener(new bj(this));
        if (this.f23681v) {
            this.f23677r.a(f23676w);
        }
        RelativeLayout.LayoutParams layoutParams = this.f23679t == 0 ? new RelativeLayout.LayoutParams(-1, -1) : new RelativeLayout.LayoutParams(-1, this.f23679t);
        layoutParams.addRule(3, this.f23649k.getId());
        layoutParams.addRule(12, -1);
        this.f23651m.addView(this.f23677r, layoutParams);
        this.f23678s = new RelativeLayout(this.f23642d);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, a.f23329t - a.f23320k);
        layoutParams2.addRule(3, this.f23649k.getId());
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(10, -1);
        layoutParams2.bottomMargin = 0;
        layoutParams2.topMargin = 0;
        this.f23651m.addView(this.f23678s, layoutParams2);
        ProgressBar progressBar = new ProgressBar(this.f23642d);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13, -1);
        this.f23678s.addView(progressBar, layoutParams3);
        this.f23677r.b(this.f23639a.f23504ag);
        if (this.f23680u) {
            a(this.f23639a.f23522bi, false);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        ((InputMethodManager) this.f23642d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        if (this.f23680u) {
            this.f23640b.a(new bk(this), new bl(this));
            m mVar = this.f23640b;
            c cVar = c.bD;
            mVar.a(cVar.Y, cVar.av, cVar.W, cVar.X);
            return;
        }
        super.k();
    }

    @Override // com.unionpay.mobile.android.upviews.b.a
    public final void r() {
        this.f23677r.setVisibility(8);
        this.f23678s.setVisibility(0);
    }

    @Override // com.unionpay.mobile.android.upviews.b.a
    public final void s() {
        this.f23677r.setVisibility(0);
        this.f23678s.setVisibility(8);
    }
}
