package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.text.TextUtils;
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
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.p;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class at extends b implements a.b {
    private a A;
    private a B;
    private boolean C;
    private boolean D;
    private String E;
    private View.OnClickListener F;
    private View.OnClickListener G;
    private View.OnClickListener H;
    private View.OnClickListener I;
    private View.OnClickListener J;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f23624r;

    /* renamed from: s  reason: collision with root package name */
    private String f23625s;

    /* renamed from: t  reason: collision with root package name */
    private int f23626t;

    /* renamed from: u  reason: collision with root package name */
    private int f23627u;

    /* renamed from: v  reason: collision with root package name */
    private int f23628v;

    /* renamed from: w  reason: collision with root package name */
    private int f23629w;

    /* renamed from: x  reason: collision with root package name */
    private com.unionpay.mobile.android.upwidget.a f23630x;

    /* renamed from: y  reason: collision with root package name */
    private com.unionpay.mobile.android.upwidget.a f23631y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f23632z;

    public at(Context context) {
        this(context, null);
    }

    public at(Context context, e eVar) {
        super(context, eVar);
        this.f23625s = "00";
        this.f23626t = 0;
        this.f23627u = 0;
        this.f23628v = 20;
        this.f23629w = 5;
        this.f23630x = null;
        this.f23631y = null;
        this.f23632z = null;
        this.A = null;
        this.B = null;
        this.C = false;
        this.D = false;
        this.f23624r = new LinearLayout(this.f23642d);
        this.F = new au(this);
        this.G = new av(this);
        this.H = new aw(this);
        this.I = new ax(this);
        this.J = new ay(this);
        this.f23644f = 6;
        boolean z10 = this.f23639a.K;
        this.f23655q = z10 ? "bankpay_phoneNO_change" : "bankpay";
        this.D = !z10;
        setBackgroundColor(-1052684);
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(at atVar, String str, String str2) {
        atVar.f23627u = 8;
        atVar.f23640b.a(c.bD.U);
        atVar.f23643e.c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(at atVar, boolean z10, String str) {
        atVar.f23648j = false;
        if (!z10) {
            atVar.f23627u = 2;
            atVar.f23643e.c(atVar.f23639a.E, str);
            return;
        }
        atVar.e(str);
    }

    private void d(String str) {
        a(str, new az(this), new ba(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2) {
        this.f23627u = 9;
        if (TextUtils.isEmpty(str2)) {
            this.f23643e.c(str, "");
        } else {
            this.f23643e.a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.f23629w--;
    }

    private static boolean d(JSONObject jSONObject) {
        return "0".equalsIgnoreCase(j.a(jSONObject, "reopen_flag"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        this.f23648j = false;
        this.f23627u = 3;
        String a10 = bh.a(this.f23639a.C);
        com.unionpay.mobile.android.upwidget.a aVar = this.f23630x;
        this.f23643e.c(a10, bh.c("1", "1", aVar != null ? aVar.a() : null, str));
    }

    private void f(int i10) {
        this.f23627u = 4;
        this.f23626t = i10;
        this.f23643e.a("query", this.f23639a.f23507aj, 3);
        this.f23628v--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(at atVar) {
        atVar.f23639a.K = true;
        atVar.f23640b.a(c.bD.U);
        atVar.f23648j = false;
        atVar.f23627u = 7;
        atVar.f23643e.c("reopenrules", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s() {
        a.C0266a b10;
        a aVar = this.B;
        String str = "";
        if (aVar != null) {
            if (aVar.b().a()) {
                str = str + b10.f23995b;
            }
        }
        a aVar2 = this.A;
        if (aVar2 == null) {
            return str;
        }
        a.C0266a b11 = aVar2.b();
        if (!b11.a()) {
            return str;
        }
        String str2 = b11.f23995b;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + ",";
        }
        return str + str2;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
        if (!aVar.a()) {
            a(aVar.f23995b);
            return;
        }
        k.a("uppay", "sms elements:" + aVar.f23995b);
        this.f23648j = false;
        this.f23640b.a(c.bD.U);
        this.f23643e.c("sms", aVar.f23995b);
        this.f23627u = 1;
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        this.D = false;
        int i10 = this.f23627u;
        if (i10 == 1) {
            i();
            this.f23627u = 0;
            this.B.a(b.f23351p);
        } else if (i10 == 2 || i10 == 3) {
            this.f23639a.f23507aj = i.a(jSONObject.toString());
            String a10 = j.a(jSONObject, "qn");
            if (!TextUtils.isEmpty(a10)) {
                this.f23639a.f23538n = this.f23643e.h(com.unionpay.mobile.android.utils.c.b(a10));
            }
            String str = this.f23639a.f23507aj;
            if (str == null || str.length() <= 0) {
                b(2);
                return;
            }
            this.f23628v = 20;
            f(this.f23627u);
        } else if (i10 == 4) {
            this.f23625s = j.a(jSONObject, PermissionConstant.Columns.STATUS);
            if (d(jSONObject)) {
                d(j.a(jSONObject, "fail_msg"));
            } else if (this.f23628v <= 0 || !this.f23625s.equalsIgnoreCase("01")) {
                this.f23627u = 0;
                if (this.f23625s.equalsIgnoreCase("00")) {
                    if (this.f23626t != 2) {
                        i();
                        this.f23627u = 0;
                        this.f23639a.H = j.d(jSONObject, "result");
                        this.f23639a.P = j.a(jSONObject, "openupgrade_flag");
                        this.f23639a.Q = j.a(jSONObject, "temporary_pay_flag");
                        this.f23639a.R = j.a(jSONObject, "temporary_pay_info");
                        this.f23639a.V = j.a(jSONObject, "front_url");
                        this.f23639a.W = j.a(jSONObject, "front_request");
                        this.f23639a.A = j.a(jSONObject, "title");
                        this.f23639a.B = j.a(jSONObject, "succ_info");
                        com.unionpay.mobile.android.nocard.utils.b.b(jSONObject, this.f23639a);
                        com.unionpay.mobile.android.nocard.utils.b.a(jSONObject, this.f23639a);
                        a aVar = this.B;
                        if (aVar != null) {
                            aVar.f();
                        }
                        if (this.f23639a.f23530f) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.f23639a.aQ);
                            PreferenceUtils.c(this.f23642d, sb2.toString());
                            this.f23639a.I.f23866f = Constant.CASH_LOAD_SUCCESS;
                            j();
                            return;
                        }
                        d(8);
                        return;
                    }
                    this.C = true;
                    e(s());
                } else if (this.f23625s.equalsIgnoreCase("03")) {
                    String a11 = j.a(jSONObject, "fail_msg");
                    String[] strArr = o.f24168j;
                    if (this.f23626t == 3) {
                        a(a11);
                        return;
                    }
                    bb bbVar = new bb(this);
                    bc bcVar = new bc(this);
                    if (this.f23639a.F) {
                        this.f23640b.a(bbVar, bcVar);
                        m mVar = this.f23640b;
                        c cVar = c.bD;
                        mVar.a(cVar.f23427ab, a11, cVar.f23428ac, cVar.f23429ad);
                        return;
                    }
                    this.f23640b.a(bbVar, null);
                    m mVar2 = this.f23640b;
                    c cVar2 = c.bD;
                    mVar2.a(cVar2.f23427ab, a11, cVar2.f23428ac);
                } else if (this.f23628v <= 0) {
                    String c10 = c(19);
                    String str2 = this.f23639a.f23508ak;
                    if (str2 != null && !TextUtils.isEmpty(str2)) {
                        c10 = this.f23639a.f23508ak;
                    }
                    if (this.f23626t == 3) {
                        a(c10, true);
                    } else {
                        a(c10);
                    }
                }
            } else {
                f(this.f23626t);
            }
        } else if (i10 != 16) {
            switch (i10) {
                case 6:
                    i();
                    int a12 = f.a(this.f23639a, jSONObject, true);
                    if (a12 != 0) {
                        b(a12);
                    } else {
                        this.f23639a.K = true;
                        e a13 = f.a(jSONObject);
                        JSONArray jSONArray = this.f23639a.f23550z;
                        if (jSONArray == null || jSONArray.length() <= 0) {
                            JSONArray jSONArray2 = this.f23639a.D;
                            if (jSONArray2 != null && jSONArray2.length() > 0) {
                                d(5);
                            }
                        } else {
                            a(6, a13);
                        }
                    }
                    this.f23627u = 0;
                    return;
                case 7:
                    i();
                    int a14 = f.a(this.f23639a, jSONObject, false);
                    if (a14 != 0) {
                        b(a14);
                        return;
                    }
                    e a15 = f.a(jSONObject);
                    JSONArray jSONArray3 = this.f23639a.f23550z;
                    if (jSONArray3 == null || jSONArray3.length() <= 0) {
                        JSONArray jSONArray4 = this.f23639a.D;
                        if (jSONArray4 != null && jSONArray4.length() > 0) {
                            d(5);
                            return;
                        }
                        return;
                    }
                    a(6, a15);
                    return;
                case 8:
                    i();
                    JSONArray d10 = j.d(jSONObject, "options");
                    a aVar2 = this.A;
                    if (aVar2 != null) {
                        aVar2.a(d10);
                        return;
                    }
                    return;
                case 9:
                    String a16 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
                    if (a16 == null || !"01".equals(a16)) {
                        JSONArray d11 = j.d(jSONObject, "options");
                        String a17 = j.a(jSONObject, "empty_info");
                        a aVar3 = this.A;
                        if (aVar3 != null) {
                            aVar3.a(d11, a17);
                            return;
                        }
                        return;
                    }
                    String a18 = j.a(jSONObject, "uuid");
                    if (this.f23629w >= 0) {
                        d(this.E, a18);
                        return;
                    }
                    String str3 = c.bD.D;
                    a aVar4 = this.A;
                    if (aVar4 != null) {
                        aVar4.a((JSONArray) null, str3);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            if (this.f23640b.a()) {
                this.f23640b.c();
            }
            new JSONObject();
            if (TextUtils.isEmpty(j.a(jSONObject, "instalment_empty_info"))) {
                jSONObject = j.c(jSONObject, "instalment");
            }
            this.A.a(jSONObject);
            this.f23627u = 0;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        TextView textView = this.f23632z;
        if (textView != null) {
            textView.setEnabled(!z10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final boolean a(String str, JSONObject jSONObject) {
        this.D = false;
        if (this.f23627u != 1 || !d(jSONObject)) {
            return false;
        }
        d(str);
        return true;
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ay ayVar = new ay(getContext(), this.f23639a.A, this);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(int i10) {
        if (this.f23627u == 16) {
            m mVar = this.f23640b;
            if (mVar != null) {
                mVar.c();
            }
            z c10 = this.A.c("instalment");
            if (c10 != null) {
                p pVar = (p) c10;
                pVar.a(false);
                pVar.b(false);
            }
        }
        super.b(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0129, code lost:
        if (r2.f23510am == null) goto L24;
     */
    @Override // com.unionpay.mobile.android.nocard.views.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void c() {
        this.f23651m.removeAllViews();
        this.f23653o.a(this);
        LinearLayout linearLayout = this.f23624r;
        linearLayout.setId(linearLayout.hashCode());
        this.f23624r.setOrientation(1);
        this.f23624r.setBackgroundColor(0);
        this.f23651m.addView(this.f23624r, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout2 = this.f23624r;
        linearLayout2.removeAllViews();
        JSONArray jSONArray = new JSONArray();
        e eVar = this.f23654p;
        if (eVar != null) {
            com.unionpay.mobile.android.model.f fVar = (com.unionpay.mobile.android.model.f) eVar;
            jSONArray.put(fVar.a("promotion"));
            jSONArray.put(fVar.a("instalment"));
            this.f23639a.aU = fVar.a("promotion_instalment_msgbox");
        }
        if (jSONArray.length() > 0) {
            a aVar = new a(this.f23642d, jSONArray, this, this.f23655q);
            this.A = aVar;
            aVar.a(this.f23640b, this.f23639a.aU);
            this.A.d(this.f23639a.bt);
            this.A.a(this.G);
            this.A.b(this.H);
            this.A.c(this.I);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout2.addView(this.A, layoutParams);
        }
        a aVar2 = this.A;
        z zVar = null;
        if (aVar2 != null) {
            zVar = aVar2.c("instalment");
        }
        Context context = this.f23642d;
        JSONArray jSONArray2 = this.f23639a.f23550z;
        long c10 = this.f23643e.c();
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        this.B = new a(context, jSONArray2, c10, this, bVar.f23514aq, true, false, zVar, bVar.f23501ad, this.f23655q);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        linearLayout2.addView(this.B, layoutParams2);
        LinearLayout linearLayout3 = new LinearLayout(this.f23642d);
        linearLayout3.setOrientation(1);
        linearLayout3.setId(linearLayout3.hashCode());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(3, this.f23624r.getId());
        int i10 = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams3.leftMargin = i10;
        layoutParams3.topMargin = i10;
        this.f23651m.addView(linearLayout3, layoutParams3);
        if (!h()) {
            com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
            if (bVar2.f23509al == null) {
            }
        }
        if (this.f23639a.f23509al != null) {
            Context context2 = this.f23642d;
            JSONObject jSONObject = this.f23639a.f23509al;
            View.OnClickListener onClickListener = this.J;
            com.unionpay.mobile.android.upwidget.a aVar3 = new com.unionpay.mobile.android.upwidget.a(context2, jSONObject, onClickListener, this.f23655q + "_agree_user_protocol");
            this.f23631y = aVar3;
            linearLayout3.addView(aVar3);
        }
        if (this.f23639a.f23510am != null) {
            Context context3 = this.f23642d;
            JSONObject jSONObject2 = this.f23639a.f23510am;
            this.f23630x = new com.unionpay.mobile.android.upwidget.a(context3, jSONObject2, null, this.f23655q + "_remember_bankNO");
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout3.addView(this.f23630x, layoutParams4);
        }
        TextView textView = new TextView(this.f23642d);
        this.f23632z = textView;
        textView.setText(j.a(this.f23639a.C, "label"));
        this.f23632z.setTextSize(b.f23344i);
        this.f23632z.setTextColor(b.o());
        this.f23632z.setGravity(17);
        TextView textView2 = this.f23632z;
        a aVar4 = this.B;
        textView2.setEnabled(aVar4 == null || aVar4.e());
        int i11 = com.unionpay.mobile.android.global.a.f23323n;
        this.f23632z.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
        this.f23632z.setOnClickListener(this.F);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, i11);
        layoutParams5.addRule(3, linearLayout3.getId());
        layoutParams5.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        int a10 = g.a(this.f23642d, 10.0f);
        layoutParams5.rightMargin = a10;
        layoutParams5.leftMargin = a10;
        this.f23651m.addView(this.f23632z, layoutParams5);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
        String str2;
        StringBuilder sb2;
        this.f23648j = false;
        this.f23640b.a(c.bD.U);
        if (h()) {
            sb2 = new StringBuilder("\"card\":\"");
            str2 = this.f23639a.f23514aq;
        } else {
            sb2 = new StringBuilder("\"card\":\"");
            com.unionpay.mobile.android.model.b bVar = this.f23639a;
            str2 = bVar.f23541q.get(bVar.N).a();
        }
        sb2.append(str2);
        sb2.append("\"");
        String sb3 = sb2.toString();
        k.a("uppay", "cmd:" + str + ", ele:" + sb3);
        this.f23643e.c(str, sb3);
        this.f23627u = 6;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
        a(str, str2);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        if (!this.B.d()) {
            com.unionpay.mobile.android.model.b bVar = this.f23639a;
            if (bVar.L) {
                a(13);
                this.f23639a.L = false;
            } else if (!bVar.K || !this.D) {
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

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.B.d();
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
        z c10;
        String str;
        this.f23640b.a(c.bD.U);
        if (this.A.c("promotion") != null) {
            str = "\"" + ((aj) c10).g() + "\"";
        } else {
            str = "\"\"";
        }
        this.f23643e.c("instalment", "\"promotion\":" + str);
        this.f23627u = 16;
    }
}
