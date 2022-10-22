package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.permission.PermissionConstant;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.nocard.views.bh;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class y extends b implements Handler.Callback, a.b {
    private String B;
    private boolean C;
    private Handler D;

    /* renamed from: r  reason: collision with root package name */
    private String f23964r = "00";

    /* renamed from: s  reason: collision with root package name */
    private int f23965s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f23966t = 0;

    /* renamed from: u  reason: collision with root package name */
    private int f23967u = 20;

    /* renamed from: v  reason: collision with root package name */
    private int f23968v = 5;

    /* renamed from: w  reason: collision with root package name */
    private com.unionpay.mobile.android.upwidget.a f23969w = null;

    /* renamed from: x  reason: collision with root package name */
    private com.unionpay.mobile.android.upwidget.a f23970x = null;

    /* renamed from: y  reason: collision with root package name */
    private TextView f23971y = null;

    /* renamed from: z  reason: collision with root package name */
    private a f23972z = null;
    private a A = null;
    private View.OnClickListener E = new z(this);
    private View.OnClickListener F = new aa(this);
    private View.OnClickListener G = new ab(this);
    private View.OnClickListener H = new ac(this);
    private View.OnClickListener I = new ae(this);

    public y(Context context, e eVar) {
        super(context, eVar);
        this.C = false;
        this.D = null;
        this.f23644f = 6;
        this.f23655q = "sdpay";
        this.D = new Handler(this);
        this.C = this.f23639a.K;
        setBackgroundColor(-1052684);
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String C(y yVar) {
        a.C0266a b10;
        a aVar = yVar.A;
        String str = "";
        if (aVar != null) {
            if (aVar.b().a()) {
                str = str + b10.f23995b;
            }
        }
        a aVar2 = yVar.f23972z;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(y yVar, c cVar, String str, HashMap hashMap) {
        yVar.f23966t = 3;
        com.unionpay.mobile.android.pro.pboc.engine.b s10 = yVar.s();
        if (s10 == null) {
            yVar.b(5);
        } else {
            new Thread(new ad(yVar, s10, cVar, str, hashMap)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(y yVar, String str, String str2) {
        yVar.f23966t = 7;
        yVar.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        yVar.f23643e.c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2) {
        this.f23966t = 8;
        if (TextUtils.isEmpty(str2)) {
            this.f23643e.c(str, "");
        } else {
            this.f23643e.a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.f23968v--;
    }

    private void f(int i10) {
        this.f23966t = 4;
        this.f23965s = i10;
        this.f23643e.a("query", this.f23639a.f23507aj, 3);
        this.f23967u--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void f(y yVar, String str) {
        yVar.f23648j = false;
        yVar.f23966t = 3;
        String a10 = bh.a(yVar.f23639a.C);
        com.unionpay.mobile.android.upwidget.a aVar = yVar.f23969w;
        yVar.f23643e.c(a10, bh.c("2", "1", aVar != null ? aVar.a() : null, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ HashMap i(y yVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        a aVar = yVar.A;
        if (aVar != null) {
            hashMap = aVar.c();
        }
        a aVar2 = yVar.f23972z;
        if (aVar2 != null) {
            HashMap<String, String> c10 = aVar2.c();
            if (c10 != null && hashMap != null) {
                hashMap.putAll(c10);
            } else if (c10 != null && hashMap == null) {
                return c10;
            }
        }
        return hashMap;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
        if (!aVar.a()) {
            a(aVar.f23995b);
            return;
        }
        k.a("uppay", "sms elements:" + aVar.f23995b);
        this.f23648j = false;
        this.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        this.f23643e.c("sms", aVar.f23995b);
        this.f23966t = 1;
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        this.C = false;
        int i10 = this.f23966t;
        if (i10 == 1) {
            i();
            this.f23966t = 0;
            this.A.a(com.unionpay.mobile.android.global.b.f23351p);
        } else if (i10 == 3) {
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
            this.f23967u = 20;
            f(this.f23966t);
        } else if (i10 == 4) {
            String a11 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
            this.f23964r = a11;
            if (this.f23967u <= 0 || !a11.equalsIgnoreCase("01")) {
                this.f23966t = 0;
                if (this.f23964r.equalsIgnoreCase("00")) {
                    i();
                    this.f23966t = 0;
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
                    a aVar = this.A;
                    if (aVar != null) {
                        aVar.f();
                    }
                    com.unionpay.mobile.android.model.b bVar = this.f23639a;
                    if (bVar.f23530f) {
                        bVar.I.f23866f = Constant.CASH_LOAD_SUCCESS;
                        j();
                        return;
                    }
                    d(8);
                } else if (this.f23964r.equalsIgnoreCase("03")) {
                    String a12 = j.a(jSONObject, "fail_msg");
                    String[] strArr = o.f24168j;
                    if (this.f23966t == 3) {
                        a(a12);
                        return;
                    }
                    af afVar = new af(this);
                    ag agVar = new ag(this);
                    if (this.f23639a.F) {
                        this.f23640b.a(afVar, agVar);
                        m mVar = this.f23640b;
                        com.unionpay.mobile.android.languages.c cVar = com.unionpay.mobile.android.languages.c.bD;
                        mVar.a(cVar.Y, a12, cVar.W, cVar.X);
                        return;
                    }
                    this.f23640b.a(afVar, null);
                    m mVar2 = this.f23640b;
                    com.unionpay.mobile.android.languages.c cVar2 = com.unionpay.mobile.android.languages.c.bD;
                    mVar2.a(cVar2.Y, a12, cVar2.W);
                } else if (this.f23967u > 0) {
                } else {
                    if (this.f23965s == 3) {
                        a(this.f23639a.f23508ak, true);
                    } else {
                        a(this.f23639a.f23508ak);
                    }
                }
            } else {
                f(this.f23965s);
            }
        } else if (i10 == 6) {
            i();
            int a13 = f.a(this.f23639a, jSONObject, false);
            if (a13 != 0) {
                b(a13);
            } else {
                com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
                bVar2.K = true;
                JSONArray jSONArray = bVar2.f23550z;
                if (jSONArray == null || jSONArray.length() <= 0) {
                    JSONArray jSONArray2 = this.f23639a.D;
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        d(5);
                    }
                } else {
                    d(6);
                }
            }
            this.f23966t = 0;
        } else if (i10 == 7) {
            i();
            JSONArray d10 = j.d(jSONObject, "options");
            a aVar2 = this.f23972z;
            if (aVar2 != null) {
                aVar2.a(d10);
            }
        } else if (i10 == 8) {
            String a14 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
            if (a14 == null || !"01".equals(a14)) {
                JSONArray d11 = j.d(jSONObject, "options");
                String a15 = j.a(jSONObject, "empty_info");
                a aVar3 = this.f23972z;
                if (aVar3 != null) {
                    aVar3.a(d11, a15);
                    return;
                }
                return;
            }
            String a16 = j.a(jSONObject, "uuid");
            if (this.f23968v >= 0) {
                d(this.B, a16);
                return;
            }
            String str2 = com.unionpay.mobile.android.languages.c.bD.D;
            a aVar4 = this.f23972z;
            if (aVar4 != null) {
                aVar4.a((JSONArray) null, str2);
            }
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        TextView textView = this.f23971y;
        if (textView != null) {
            textView.setEnabled(!z10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final boolean a(String str, JSONObject jSONObject) {
        this.C = false;
        return false;
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ay ayVar = new ay(getContext(), this.f23639a.A, this);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00ea, code lost:
        if (r1.f23510am == null) goto L23;
     */
    @Override // com.unionpay.mobile.android.nocard.views.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void c() {
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        linearLayout.setId(linearLayout.hashCode());
        boolean z10 = true;
        linearLayout.setOrientation(1);
        this.f23651m.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -2));
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
            this.f23972z = aVar;
            aVar.a(this.f23640b, this.f23639a.aU);
            this.f23972z.a(this.F);
            this.f23972z.b(this.G);
            this.f23972z.c(this.H);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout.addView(this.f23972z, layoutParams);
        }
        a aVar2 = this.f23972z;
        if (aVar2 != null) {
            aVar2.c("instalment");
        }
        this.A = new a(this.f23642d, this.f23639a.f23550z, this.f23643e.c(), this, this.f23639a.f23514aq, false, this.f23655q);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        linearLayout.addView(this.A, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
        linearLayout2.setOrientation(1);
        linearLayout2.setId(linearLayout2.hashCode());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(3, linearLayout.getId());
        int i10 = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams3.leftMargin = i10;
        layoutParams3.topMargin = i10;
        this.f23651m.addView(linearLayout2, layoutParams3);
        if (!h()) {
            com.unionpay.mobile.android.model.b bVar = this.f23639a;
            if (bVar.f23509al == null) {
            }
        }
        if (this.f23639a.f23509al != null) {
            Context context = this.f23642d;
            JSONObject jSONObject = this.f23639a.f23509al;
            View.OnClickListener onClickListener = this.I;
            com.unionpay.mobile.android.upwidget.a aVar3 = new com.unionpay.mobile.android.upwidget.a(context, jSONObject, onClickListener, this.f23655q + "_agree_user_protocol");
            this.f23970x = aVar3;
            linearLayout2.addView(aVar3);
        }
        if (this.f23639a.f23510am != null) {
            Context context2 = this.f23642d;
            JSONObject jSONObject2 = this.f23639a.f23510am;
            this.f23969w = new com.unionpay.mobile.android.upwidget.a(context2, jSONObject2, null, this.f23655q + "_remember_bankNO");
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout2.addView(this.f23969w, layoutParams4);
        }
        TextView textView = new TextView(this.f23642d);
        this.f23971y = textView;
        textView.setText(j.a(this.f23639a.C, "label"));
        this.f23971y.setTextSize(com.unionpay.mobile.android.global.b.f23344i);
        this.f23971y.setTextColor(b.o());
        this.f23971y.setGravity(17);
        TextView textView2 = this.f23971y;
        a aVar4 = this.A;
        if (aVar4 != null && !aVar4.e()) {
            z10 = false;
        }
        textView2.setEnabled(z10);
        int i11 = com.unionpay.mobile.android.global.a.f23323n;
        this.f23971y.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
        this.f23971y.setOnClickListener(this.E);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, i11);
        layoutParams5.addRule(3, linearLayout2.getId());
        layoutParams5.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        int a10 = g.a(this.f23642d, 10.0f);
        layoutParams5.rightMargin = a10;
        layoutParams5.leftMargin = a10;
        this.f23651m.addView(this.f23971y, layoutParams5);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
        this.f23648j = false;
        this.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        StringBuilder sb2 = new StringBuilder("\"card\":\"");
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        sb2.append(bVar.f23541q.get(bVar.N).a());
        sb2.append("\"");
        String sb3 = sb2.toString();
        k.a("uppay", "cmd:" + str + ", ele:" + sb3);
        this.f23643e.c(str, sb3);
        this.f23966t = 6;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj = message.obj;
        if (obj != null) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("action_resp_code");
            String string2 = bundle.getString("action_resp_message");
            if (!"0000".equalsIgnoreCase(string)) {
                a(this.f23639a.f23513ap, false);
            } else if (string2 != null) {
                a(0, string2);
            }
            return true;
        }
        b(1);
        return true;
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        if (!this.A.d()) {
            com.unionpay.mobile.android.model.b bVar = this.f23639a;
            if (!bVar.K || !this.C) {
                bVar.K = false;
                bVar.br = false;
                a(2);
                return;
            }
            bVar.K = false;
            m();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A.d();
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }

    public com.unionpay.mobile.android.pro.pboc.engine.b s() {
        return null;
    }
}
