package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.permission.PermissionConstant;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ak extends b implements a.b {

    /* renamed from: r  reason: collision with root package name */
    private int f23600r = 100;

    /* renamed from: s  reason: collision with root package name */
    private int f23601s = 20;

    /* renamed from: t  reason: collision with root package name */
    private com.unionpay.mobile.android.upwidget.a f23602t = null;

    /* renamed from: u  reason: collision with root package name */
    private TextView f23603u = null;

    /* renamed from: v  reason: collision with root package name */
    private a f23604v = null;

    /* renamed from: w  reason: collision with root package name */
    private View.OnClickListener f23605w = new al(this);

    /* renamed from: x  reason: collision with root package name */
    private View.OnClickListener f23606x = new am(this);

    public ak(Context context) {
        super(context);
        this.f23644f = 10;
        this.f23655q = "openupgrade";
        setBackgroundColor(-1052684);
        this.f23649k = a();
        b();
        super.d();
        c();
    }

    private void s() {
        this.f23600r = 103;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f23601s);
        k.c("uppay", sb2.toString());
        this.f23643e.a("query", this.f23639a.f23507aj, 3);
        this.f23601s--;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
        if (!aVar.a()) {
            a(aVar.f23995b);
            return;
        }
        this.f23648j = false;
        this.f23600r = 101;
        this.f23640b.a(c.bD.U);
        k.a("uppay", "sms elements:" + aVar.f23995b);
        this.f23643e.c("sms", aVar.f23995b);
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        switch (this.f23600r) {
            case 101:
                this.f23604v.a(b.f23351p);
                this.f23640b.c();
                this.f23600r = 100;
                return;
            case 102:
                this.f23639a.f23507aj = i.a(jSONObject.toString());
                String str = this.f23639a.f23507aj;
                if (str == null || str.length() <= 0) {
                    b(2);
                    return;
                }
                this.f23601s = 20;
                s();
                return;
            case 103:
                String a10 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
                String a11 = j.a(jSONObject, "fail_msg");
                this.f23639a.S = j.a(jSONObject, "open_info");
                this.f23639a.A = j.a(jSONObject, "title");
                this.f23639a.B = j.a(jSONObject, "succ_info");
                if (this.f23601s <= 0 || !a10.equalsIgnoreCase("01")) {
                    this.f23600r = 100;
                    i();
                    if (a10.equalsIgnoreCase("00")) {
                        d(11);
                        return;
                    } else if (a10.equalsIgnoreCase("03")) {
                        this.f23640b.a(new an(this), null);
                        m mVar = this.f23640b;
                        c cVar = c.bD;
                        mVar.a(cVar.f23427ab, a11, cVar.f23428ac);
                        return;
                    } else if (this.f23601s <= 0) {
                        b(20);
                        return;
                    } else {
                        return;
                    }
                } else {
                    s();
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        TextView textView = this.f23603u;
        if (textView != null) {
            textView.setEnabled(!z10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ay ayVar = new ay(getContext(), this.f23639a.A, this);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void c() {
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        linearLayout.setBackgroundColor(-1);
        boolean z10 = true;
        linearLayout.setOrientation(1);
        linearLayout.setId(linearLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int i10 = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams.rightMargin = i10;
        layoutParams.leftMargin = i10;
        this.f23651m.addView(linearLayout, layoutParams);
        this.f23604v = new a(this.f23642d, this.f23639a.T, this.f23643e.c(), this, this.f23639a.f23514aq, true, this.f23655q);
        new LinearLayout.LayoutParams(-1, -1).topMargin = com.unionpay.mobile.android.global.a.f23315f;
        linearLayout.addView(this.f23604v);
        LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
        linearLayout2.setOrientation(1);
        linearLayout2.setId(linearLayout2.hashCode());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        int i11 = com.unionpay.mobile.android.global.a.f23313d;
        layoutParams2.topMargin = i11;
        layoutParams2.leftMargin = i11;
        layoutParams2.addRule(3, linearLayout.getId());
        this.f23651m.addView(linearLayout2, layoutParams2);
        Context context = this.f23642d;
        JSONObject jSONObject = this.f23639a.f23509al;
        View.OnClickListener onClickListener = this.f23606x;
        com.unionpay.mobile.android.upwidget.a aVar = new com.unionpay.mobile.android.upwidget.a(context, jSONObject, onClickListener, this.f23655q + "_agree_user_protocol");
        this.f23602t = aVar;
        linearLayout2.addView(aVar);
        TextView textView = new TextView(this.f23642d);
        this.f23603u = textView;
        textView.setText(j.a(this.f23639a.C, "label"));
        this.f23603u.setTextSize(b.f23344i);
        this.f23603u.setTextColor(b.o());
        this.f23603u.setGravity(17);
        int i12 = com.unionpay.mobile.android.global.a.f23323n;
        this.f23603u.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
        this.f23603u.setOnClickListener(this.f23605w);
        TextView textView2 = this.f23603u;
        a aVar2 = this.f23604v;
        if (aVar2 != null && !aVar2.e()) {
            z10 = false;
        }
        textView2.setEnabled(z10);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i12);
        int i13 = com.unionpay.mobile.android.global.a.f23313d;
        layoutParams3.topMargin = i13;
        layoutParams3.rightMargin = i13;
        layoutParams3.leftMargin = i13;
        layoutParams3.addRule(3, linearLayout2.getId());
        this.f23651m.addView(this.f23603u, layoutParams3);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        if (!this.f23604v.d()) {
            m();
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }
}
