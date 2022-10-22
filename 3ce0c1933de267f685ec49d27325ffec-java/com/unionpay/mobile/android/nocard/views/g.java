package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.permission.PermissionConstant;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class g extends b implements a.b {

    /* renamed from: x  reason: collision with root package name */
    private boolean f23698x;

    /* renamed from: r  reason: collision with root package name */
    private int f23692r = 20;

    /* renamed from: s  reason: collision with root package name */
    private int f23693s = 100;

    /* renamed from: t  reason: collision with root package name */
    private com.unionpay.mobile.android.upwidget.a f23694t = null;

    /* renamed from: u  reason: collision with root package name */
    private TextView f23695u = null;

    /* renamed from: v  reason: collision with root package name */
    private a f23696v = null;

    /* renamed from: w  reason: collision with root package name */
    private boolean f23697w = false;

    /* renamed from: y  reason: collision with root package name */
    private View.OnClickListener f23699y = new h(this);

    /* renamed from: z  reason: collision with root package name */
    private View.OnClickListener f23700z = new i(this);

    public g(Context context) {
        super(context);
        this.f23698x = true;
        this.f23644f = 5;
        boolean z10 = this.f23639a.K;
        this.f23655q = z10 ? "entrust_phoneNO_change" : "entrust";
        this.f23698x = true ^ z10;
        setBackgroundColor(-1052684);
        e();
    }

    private void d(JSONObject jSONObject) {
        i();
        this.f23639a.f23550z = j.d(jSONObject, "rules");
        this.f23639a.A = j.a(jSONObject, "title");
        this.f23639a.C = j.c(jSONObject, "followrules_button");
        this.f23639a.f23509al = j.c(jSONObject, "service_checkbox");
        this.f23639a.f23510am = j.c(jSONObject, "bind_card_checkbox");
        this.f23639a.f23514aq = j.a(jSONObject, Constant.KEY_PAN);
        JSONArray jSONArray = this.f23639a.f23550z;
        if (jSONArray == null || jSONArray.length() <= 0) {
            b(2);
            return;
        }
        a aVar = this.f23696v;
        if (aVar != null) {
            aVar.f();
        }
        e a10 = f.a(jSONObject);
        this.f23639a.K = false;
        a(6, a10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        this.f23643e.j(this.f23696v.a(Constant.KEY_PAN));
        this.f23693s = 104;
    }

    private void t() {
        this.f23693s = 103;
        this.f23643e.a("query", this.f23639a.f23507aj, 3);
        this.f23692r--;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
        if (aVar.a()) {
            this.f23648j = false;
            this.f23693s = 101;
            this.f23640b.a(c.bD.U);
            k.a("uppay", "sms elements:" + aVar.f23995b);
            this.f23643e.c("sms", aVar.f23995b);
            return;
        }
        a(aVar.f23995b);
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        this.f23698x = false;
        switch (this.f23693s) {
            case 101:
                this.f23696v.a(b.f23351p);
                this.f23640b.c();
                this.f23693s = 100;
                return;
            case 102:
                this.f23639a.f23507aj = i.a(jSONObject.toString());
                String str = this.f23639a.f23507aj;
                if (str == null || str.length() <= 0) {
                    b(2);
                    return;
                }
                this.f23692r = 20;
                t();
                return;
            case 103:
                String a10 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
                String a11 = j.a(jSONObject, "fail_msg");
                if (this.f23692r <= 0 || !a10.equalsIgnoreCase("01")) {
                    this.f23693s = 100;
                    if (a10.equalsIgnoreCase("00")) {
                        this.f23697w = true;
                        s();
                        return;
                    }
                    i();
                    String[] strArr = o.f24168j;
                    if (a10.equalsIgnoreCase("03")) {
                        j jVar = new j(this);
                        k kVar = new k(this);
                        if (this.f23639a.F) {
                            this.f23640b.a(jVar, kVar);
                            m mVar = this.f23640b;
                            c cVar = c.bD;
                            mVar.a(cVar.f23427ab, a11, cVar.f23428ac, cVar.f23429ad);
                            return;
                        }
                        this.f23640b.a(jVar, null);
                        m mVar2 = this.f23640b;
                        c cVar2 = c.bD;
                        mVar2.a(cVar2.f23427ab, a11, cVar2.f23428ac);
                        return;
                    } else if (this.f23692r <= 0) {
                        a(this.f23639a.f23508ak);
                        return;
                    } else {
                        return;
                    }
                } else {
                    t();
                    return;
                }
            case 104:
                if (!b(jSONObject)) {
                    d(jSONObject);
                    return;
                }
                return;
            case 105:
                i();
                int a12 = f.a(this.f23639a, jSONObject, false);
                if (a12 != 0) {
                    b(a12);
                    return;
                }
                e a13 = f.a(jSONObject);
                JSONArray jSONArray = this.f23639a.f23550z;
                if (jSONArray == null || jSONArray.length() <= 0) {
                    JSONArray jSONArray2 = this.f23639a.D;
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        d(5);
                        return;
                    }
                    return;
                }
                a(6, a13);
                return;
            default:
                return;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        TextView textView = this.f23695u;
        if (textView != null) {
            textView.setEnabled(!z10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final boolean a(String str, JSONObject jSONObject) {
        this.f23698x = false;
        return false;
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ay ayVar = new ay(getContext(), this.f23639a.A, this);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(String str, JSONObject jSONObject) {
        if ("init".equals(str)) {
            a(2);
        } else if ("".equals(str)) {
            d(jSONObject);
        } else {
            this.f23640b.a(c.bD.U);
            this.f23648j = false;
            this.f23693s = 105;
            this.f23643e.c(str, "");
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void c() {
        this.f23653o.a(this);
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        boolean z10 = true;
        linearLayout.setOrientation(1);
        linearLayout.setId(linearLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        int i10 = com.unionpay.mobile.android.global.a.f23313d;
        this.f23651m.addView(linearLayout, layoutParams);
        this.f23696v = new a(this.f23642d, this.f23639a.D, this.f23643e.c(), this, this.f23639a.f23514aq, true, this.f23655q);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        linearLayout.addView(this.f23696v, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = i10;
        layoutParams3.leftMargin = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams3.addRule(3, linearLayout.getId());
        LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
        linearLayout2.setOrientation(0);
        linearLayout2.setId(linearLayout2.hashCode());
        this.f23694t = new com.unionpay.mobile.android.upwidget.a(this.f23642d, this.f23639a.f23509al, this.f23700z, this.f23655q + "_agree_user_protocol");
        linearLayout2.addView(this.f23694t, new LinearLayout.LayoutParams(-2, -2));
        this.f23651m.addView(linearLayout2, layoutParams3);
        TextView textView = new TextView(this.f23642d);
        this.f23695u = textView;
        textView.setText(j.a(this.f23639a.C, "label"));
        this.f23695u.setTextSize(b.f23344i);
        this.f23695u.setTextColor(b.o());
        this.f23695u.setGravity(17);
        int i11 = com.unionpay.mobile.android.global.a.f23323n;
        this.f23695u.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
        this.f23695u.setOnClickListener(this.f23699y);
        TextView textView2 = this.f23695u;
        a aVar = this.f23696v;
        if (aVar != null && !aVar.e()) {
            z10 = false;
        }
        textView2.setEnabled(z10);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i11);
        layoutParams4.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        int a10 = com.unionpay.mobile.android.utils.g.a(this.f23642d, 10.0f);
        layoutParams4.rightMargin = a10;
        layoutParams4.leftMargin = a10;
        layoutParams4.addRule(3, linearLayout2.getId());
        this.f23651m.addView(this.f23695u, layoutParams4);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        if (!this.f23696v.d()) {
            com.unionpay.mobile.android.model.b bVar = this.f23639a;
            if (bVar.L) {
                a(13);
                this.f23639a.L = false;
            } else if (!bVar.K || !this.f23698x) {
                bVar.K = false;
                bVar.G = null;
                a(2);
            } else {
                bVar.K = false;
                f.a(bVar, bVar.G);
                m();
            }
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }
}
