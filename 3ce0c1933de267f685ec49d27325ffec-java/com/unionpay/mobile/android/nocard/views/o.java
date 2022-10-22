package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.permission.PermissionConstant;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.c;
import com.unionpay.mobile.android.upwidget.g;
import com.unionpay.mobile.android.upwidget.w;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.p;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.tsmservice.data.Constant;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class o extends com.unionpay.mobile.android.nocard.views.b implements a.b {
    private b E;
    private String F;
    private boolean I;

    /* renamed from: u  reason: collision with root package name */
    private View.OnClickListener f23719u;

    /* renamed from: v  reason: collision with root package name */
    private View.OnClickListener f23720v;

    /* renamed from: w  reason: collision with root package name */
    private View.OnClickListener f23721w;

    /* renamed from: s  reason: collision with root package name */
    private int f23717s = 0;

    /* renamed from: t  reason: collision with root package name */
    private com.unionpay.mobile.android.upviews.a f23718t = null;

    /* renamed from: x  reason: collision with root package name */
    private TextView f23722x = null;

    /* renamed from: r  reason: collision with root package name */
    LinearLayout f23716r = null;

    /* renamed from: y  reason: collision with root package name */
    private int f23723y = 0;

    /* renamed from: z  reason: collision with root package name */
    private int f23724z = 0;
    private int A = 20;
    private int B = 5;
    private com.unionpay.mobile.android.upwidget.a C = null;
    private com.unionpay.mobile.android.upviews.a D = null;
    private View.OnClickListener G = new p(this);
    private View.OnClickListener H = new u(this);

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private PopupWindow f23726b;

        /* renamed from: c  reason: collision with root package name */
        private c f23727c;

        /* renamed from: d  reason: collision with root package name */
        private g f23728d;

        /* renamed from: e  reason: collision with root package name */
        private String f23729e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f23730f;

        /* renamed from: g  reason: collision with root package name */
        private int f23731g = 1;

        /* renamed from: h  reason: collision with root package name */
        private final View.OnClickListener f23732h;

        /* renamed from: i  reason: collision with root package name */
        private final AdapterView.OnItemClickListener f23733i;

        /* renamed from: j  reason: collision with root package name */
        private List<Map<String, Object>> f23734j;

        /* renamed from: k  reason: collision with root package name */
        private a f23735k;

        /* renamed from: l  reason: collision with root package name */
        private String f23736l;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Context context, a aVar, List<Map<String, Object>> list, JSONArray jSONArray, String str) {
            super(context);
            ac acVar = new ac(this);
            this.f23732h = acVar;
            ad adVar = new ad(this);
            this.f23733i = adVar;
            setOrientation(1);
            this.f23735k = aVar;
            this.f23734j = list;
            this.f23729e = jSONArray;
            this.f23736l = str;
            c cVar = new c(o.this.f23642d, this.f23734j, this.f23729e, this.f23736l, "", this.f23731g, 0);
            this.f23727c = cVar;
            g gVar = new g(o.this.f23642d, cVar);
            this.f23728d = gVar;
            gVar.a(adVar);
            this.f23728d.a(acVar);
            if (list != null && list.size() > 0) {
                Drawable a10 = com.unionpay.mobile.android.resource.c.a(o.this.f23642d).a(2014, -1, -1);
                RelativeLayout relativeLayout = new RelativeLayout(o.this.f23642d);
                relativeLayout.setBackgroundDrawable(a10);
                relativeLayout.setOnClickListener(new ae(this));
                addView(relativeLayout, new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.f23323n));
                ImageView imageView = new ImageView(o.this.f23642d);
                imageView.setId(imageView.hashCode());
                imageView.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(o.this.f23642d).a(1002, -1, -1));
                int a11 = com.unionpay.mobile.android.utils.g.a(o.this.f23642d, 15.0f);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a11, a11);
                layoutParams.addRule(11, -1);
                layoutParams.addRule(15, -1);
                layoutParams.rightMargin = com.unionpay.mobile.android.utils.g.a(o.this.f23642d, 10.0f);
                relativeLayout.addView(imageView, layoutParams);
                TextView textView = new TextView(o.this.f23642d);
                this.f23730f = textView;
                textView.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
                this.f23730f.setTextColor(-10066330);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                this.f23730f.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                this.f23730f.setSingleLine(true);
                int a12 = com.unionpay.mobile.android.utils.g.a(o.this.f23642d, 10.0f);
                layoutParams2.leftMargin = a12;
                layoutParams2.rightMargin = a12;
                layoutParams2.addRule(15, -1);
                layoutParams2.addRule(9, -1);
                layoutParams2.addRule(0, imageView.getId());
                relativeLayout.addView(this.f23730f, layoutParams2);
                a(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(b bVar, View view) {
            if (bVar.f23726b == null) {
                bVar.f23726b = new PopupWindow((View) bVar.f23728d, -1, -1, true);
                bVar.f23726b.setBackgroundDrawable(new ColorDrawable(-1342177280));
                bVar.f23726b.update();
            }
            bVar.f23726b.showAtLocation(view, 80, 0, 0);
        }

        public final void a(int i10) {
            int c10 = i10 + this.f23727c.c();
            TextView textView = this.f23730f;
            if (textView != null) {
                textView.setText(this.f23727c.b(c10));
            }
        }
    }

    public o(Context context, e eVar) {
        super(context, eVar);
        this.f23719u = null;
        this.f23720v = null;
        this.f23721w = null;
        this.I = false;
        this.f23644f = 13;
        this.f23655q = this.f23639a.K ? "loginpay_phoneNO_change" : "loginpay";
        this.f23719u = new v(this);
        this.f23720v = new w(this);
        this.f23721w = new x(this);
        if (!p() && !t() && !this.f23639a.aZ) {
            this.I = true;
        }
        setBackgroundColor(-1052684);
        e();
        if (this.f23639a.aF != null) {
            c((JSONObject) null);
        }
    }

    private void a(LinearLayout linearLayout) {
        JSONArray jSONArray = this.f23639a.f23500ac;
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                z a10 = a((JSONObject) j.b(jSONArray, i10), this.f23655q);
                if (a10 != null) {
                    linearLayout.addView(a10);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(o oVar, int i10) {
        List<com.unionpay.mobile.android.model.c> list = oVar.f23639a.f23499ab;
        if (list == null || i10 != list.size()) {
            String[] strArr = com.unionpay.mobile.android.utils.o.f24164f;
            oVar.I = false;
            oVar.f23724z = oVar.f23723y;
            oVar.f23723y = i10;
            String a10 = oVar.f23639a.f23499ab.get(i10).a();
            oVar.f23648j = false;
            oVar.f23717s = 1;
            oVar.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
            oVar.f23643e.i(bh.a("1", a10, "1", "2"));
            return;
        }
        oVar.f23639a.aZ = true;
        oVar.I = true;
        oVar.d(13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(o oVar, String str, String str2) {
        oVar.f23717s = 8;
        oVar.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        oVar.f23643e.c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(o oVar, String str) {
        oVar.f23648j = false;
        oVar.f23717s = 3;
        oVar.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        oVar.f23643e.a("1", "2", "yes", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, String str2) {
        this.f23717s = 9;
        if (TextUtils.isEmpty(str2)) {
            this.f23643e.c(str, "");
        } else {
            this.f23643e.a(str, "\"uuid\":\"" + str2 + "\"", 10);
        }
        this.B--;
    }

    private void d(JSONObject jSONObject) {
        boolean z10 = false;
        int a10 = f.a(this.f23639a, jSONObject, false);
        if (a10 != 0) {
            b(a10);
            if (1 == this.f23717s) {
                f(this.f23724z);
                return;
            }
            return;
        }
        e a11 = f.a(jSONObject);
        if (5 == this.f23717s) {
            JSONArray jSONArray = this.f23639a.f23550z;
            if (jSONArray == null || jSONArray.length() <= 0) {
                JSONArray jSONArray2 = this.f23639a.D;
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    d(5);
                    return;
                }
                return;
            }
            a(6, a11);
            return;
        }
        this.f23654p = a11;
        f(this.f23723y);
        com.unionpay.mobile.android.upviews.a aVar = this.D;
        JSONArray s10 = s();
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        aVar.a(s10, bVar.f23514aq, true, null, bVar.f23501ad, this.f23655q);
        this.D.a(this.G);
        this.D.b(this.H);
        this.D.a(this.f23640b, this.f23639a.aU);
        this.D.d(this.f23639a.bt);
        z zVar = null;
        com.unionpay.mobile.android.upviews.a aVar2 = this.D;
        if (aVar2 != null) {
            zVar = aVar2.c("instalment");
        }
        z zVar2 = zVar;
        com.unionpay.mobile.android.upviews.a aVar3 = this.f23718t;
        com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
        aVar3.a(bVar2.f23550z, bVar2.f23514aq, true, zVar2, bVar2.f23501ad, this.f23655q);
        TextView textView = this.f23722x;
        com.unionpay.mobile.android.upviews.a aVar4 = this.f23718t;
        if (aVar4 == null || aVar4.e()) {
            z10 = true;
        }
        textView.setEnabled(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(o oVar) {
        com.unionpay.mobile.android.upviews.a aVar = oVar.f23718t;
        if (aVar != null) {
            a.C0266a b10 = aVar.b();
            if (!b10.a()) {
                oVar.a(b10.f23995b);
                return;
            }
            oVar.f23648j = false;
            oVar.f23717s = 5;
            oVar.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
            oVar.f23643e.c("bindcardrules", b10.f23995b);
        }
    }

    private void f(int i10) {
        this.f23723y = i10;
        this.E.a(i10);
    }

    private JSONArray s() {
        JSONArray jSONArray = new JSONArray();
        e eVar = this.f23654p;
        if (eVar != null) {
            com.unionpay.mobile.android.model.f fVar = (com.unionpay.mobile.android.model.f) eVar;
            jSONArray.put(fVar.a("promotion"));
            jSONArray.put(fVar.a("instalment"));
            this.f23639a.aU = fVar.a("promotion_instalment_msgbox");
        }
        return jSONArray;
    }

    private final boolean t() {
        List<com.unionpay.mobile.android.model.c> list;
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        return !bVar.aZ && (list = bVar.f23499ab) != null && list.size() > 0;
    }

    private void u() {
        this.f23717s = 4;
        this.f23643e.a("query", this.f23639a.f23507aj, 3);
        this.A--;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
        this.f23718t.d();
        if (!aVar.a()) {
            a(aVar.f23995b);
            return;
        }
        this.f23648j = false;
        this.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        this.f23643e.c("sms", aVar.f23995b);
        this.f23717s = 2;
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        int i10 = this.f23717s;
        if (i10 != 16) {
            switch (i10) {
                case 1:
                case 5:
                    i();
                    if (!b(jSONObject)) {
                        if (this.f23717s == 5) {
                            this.f23639a.L = true;
                        }
                        d(jSONObject);
                        return;
                    }
                    return;
                case 2:
                    i();
                    this.f23718t.a(com.unionpay.mobile.android.global.b.f23351p);
                    return;
                case 3:
                    this.f23639a.f23507aj = i.a(jSONObject.toString());
                    String a10 = j.a(jSONObject, "qn");
                    if (!TextUtils.isEmpty(a10)) {
                        this.f23639a.f23538n = this.f23643e.h(com.unionpay.mobile.android.utils.c.b(a10));
                    }
                    if (this.f23639a.f23507aj == null) {
                        b(2);
                        return;
                    }
                    this.A = 20;
                    u();
                    return;
                case 4:
                    String a11 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
                    if (this.A <= 0 || !a11.equalsIgnoreCase("01")) {
                        i();
                        if (a11.equalsIgnoreCase("00")) {
                            this.f23717s = 0;
                            this.f23639a.H = j.d(jSONObject, "result");
                            this.f23639a.P = j.a(jSONObject, "openupgrade_flag");
                            this.f23639a.Q = j.a(jSONObject, "temporary_pay_flag");
                            this.f23639a.R = j.a(jSONObject, "temporary_pay_info");
                            this.f23639a.V = j.a(jSONObject, "front_url");
                            this.f23639a.W = j.a(jSONObject, "front_request");
                            this.f23639a.A = j.a(jSONObject, "title");
                            this.f23639a.B = j.a(jSONObject, "succ_info");
                            com.unionpay.mobile.android.nocard.utils.b.a(jSONObject, this.f23639a);
                            com.unionpay.mobile.android.nocard.utils.b.b(jSONObject, this.f23639a);
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
                        } else if (a11.equalsIgnoreCase("03")) {
                            String a12 = j.a(jSONObject, "fail_msg");
                            String[] strArr = com.unionpay.mobile.android.utils.o.f24168j;
                            a(a12);
                            return;
                        } else if (this.A <= 0) {
                            b(19);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        u();
                        return;
                    }
                case 6:
                    i();
                    int a13 = f.a(this.f23639a, jSONObject, true);
                    if (a13 != 0) {
                        b(a13);
                    } else {
                        this.f23639a.K = true;
                        e a14 = f.a(jSONObject);
                        JSONArray jSONArray = this.f23639a.f23550z;
                        if (jSONArray == null || jSONArray.length() <= 0) {
                            JSONArray jSONArray2 = this.f23639a.D;
                            if (jSONArray2 != null && jSONArray2.length() > 0) {
                                d(5);
                            }
                        } else {
                            a(6, a14);
                        }
                    }
                    this.f23717s = 0;
                    return;
                case 7:
                    i();
                    int a15 = f.a(this.f23639a, jSONObject, false);
                    if (a15 != 0) {
                        b(a15);
                        return;
                    }
                    e a16 = f.a(jSONObject);
                    JSONArray jSONArray3 = this.f23639a.f23550z;
                    if (jSONArray3 == null || jSONArray3.length() <= 0) {
                        JSONArray jSONArray4 = this.f23639a.D;
                        if (jSONArray4 != null && jSONArray4.length() > 0) {
                            d(5);
                            return;
                        }
                        return;
                    }
                    a(6, a16);
                    return;
                case 8:
                    i();
                    JSONArray d10 = j.d(jSONObject, "options");
                    com.unionpay.mobile.android.upviews.a aVar = this.D;
                    if (aVar != null) {
                        aVar.a(d10);
                        return;
                    }
                    return;
                case 9:
                    String a17 = j.a(jSONObject, PermissionConstant.Columns.STATUS);
                    if (a17 == null || !"01".equals(a17)) {
                        JSONArray d11 = j.d(jSONObject, "options");
                        String a18 = j.a(jSONObject, "empty_info");
                        com.unionpay.mobile.android.upviews.a aVar2 = this.D;
                        if (aVar2 != null) {
                            aVar2.a(d11, a18);
                            return;
                        }
                        return;
                    }
                    String a19 = j.a(jSONObject, "uuid");
                    if (this.B >= 0) {
                        d(this.F, a19);
                        return;
                    }
                    String str = com.unionpay.mobile.android.languages.c.bD.D;
                    com.unionpay.mobile.android.upviews.a aVar3 = this.D;
                    if (aVar3 != null) {
                        aVar3.a((JSONArray) null, str);
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
            this.D.a(jSONObject);
            this.f23717s = 0;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        this.f23722x.setEnabled(!z10);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final boolean a(String str, JSONObject jSONObject) {
        if (this.f23717s != 1) {
            return false;
        }
        f(this.f23724z);
        i();
        a(str);
        return true;
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        List<com.unionpay.mobile.android.model.c> list;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        String str = com.unionpay.mobile.android.languages.c.bD.f23473o;
        ay ayVar = new ay(this.f23642d, str, this);
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        if (bVar.aC && ((list = bVar.f23541q) == null || list.size() == 0)) {
            com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
            if (!bVar2.aZ && !TextUtils.isEmpty(bVar2.f23545u)) {
                ayVar = new ay(this.f23642d, str, this.f23641c.a(1030, -1, -1), com.unionpay.mobile.android.utils.g.a(this.f23642d, 20.0f), this);
            }
        }
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(int i10) {
        if (this.f23717s == 16) {
            m mVar = this.f23640b;
            if (mVar != null) {
                mVar.c();
            }
            z c10 = this.D.c("instalment");
            if (c10 != null) {
                p pVar = (p) c10;
                pVar.a(false);
                pVar.b(false);
            }
        }
        super.b(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(String str, JSONObject jSONObject) {
        if ("init".equals(str)) {
            a(2);
        } else if ("".equals(str)) {
            if (this.f23717s == 5) {
                this.f23639a.L = true;
            }
            if (jSONObject != null) {
                d(jSONObject);
            }
        } else {
            this.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
            this.f23648j = false;
            this.f23717s = 7;
            this.f23643e.c(str, "");
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void c() {
        int i10;
        int i11;
        TextView textView;
        boolean z10;
        String str;
        TextView textView2;
        TextView textView3;
        View.OnClickListener onClickListener;
        this.f23651m.removeAllViews();
        this.f23653o.a(this);
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams.addRule(10, -1);
        this.f23651m.addView(linearLayout, layoutParams);
        a(linearLayout);
        JSONArray s10 = s();
        if (s10.length() > 0 && t()) {
            com.unionpay.mobile.android.upviews.a aVar = new com.unionpay.mobile.android.upviews.a(this.f23642d, s10, this, this.f23655q);
            this.D = aVar;
            aVar.a(this.G);
            this.D.b(this.H);
            this.D.a(this.f23640b, this.f23639a.aU);
            this.D.d(this.f23639a.bt);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.bottomMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout.addView(this.D, layoutParams2);
        }
        if (p()) {
            if (t()) {
                LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
                linearLayout2.setBackgroundColor(-3419943);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
                layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f23315f;
                linearLayout.addView(linearLayout2, layoutParams3);
                ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                b bVar = new b(this.f23642d, new z(this), com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.f23642d, this.f23639a.f23499ab, false), com.unionpay.mobile.android.languages.c.bD.f23451bh, this.f23639a.aY);
                this.E = bVar;
                linearLayout.addView(bVar, layoutParams4);
                com.unionpay.mobile.android.upviews.a aVar2 = this.D;
                z c10 = aVar2 != null ? aVar2.c("instalment") : null;
                Context context = this.f23642d;
                JSONArray jSONArray = this.f23639a.f23550z;
                long c11 = this.f23643e.c();
                com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
                com.unionpay.mobile.android.upviews.a aVar3 = new com.unionpay.mobile.android.upviews.a(context, jSONArray, c11, this, bVar2.f23514aq, true, true, c10, bVar2.f23501ad, this.f23655q);
                this.f23718t = aVar3;
                linearLayout.addView(aVar3, layoutParams4);
            } else if (!TextUtils.isEmpty(this.f23639a.f23502ae)) {
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams5.topMargin = com.unionpay.mobile.android.global.a.f23315f;
                TextView textView4 = new TextView(this.f23642d);
                textView4.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
                textView4.setText(this.f23639a.f23502ae);
                linearLayout.addView(textView4, layoutParams5);
                i10 = -2;
                i11 = -1;
            }
            i11 = -1;
            i10 = -2;
        } else if (t()) {
            i10 = -2;
            LinearLayout linearLayout3 = new LinearLayout(this.f23642d);
            linearLayout3.setBackgroundColor(-3419943);
            linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, 1));
            ViewGroup.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
            b bVar3 = new b(this.f23642d, new aa(this), com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.f23642d, this.f23639a.f23499ab, false), com.unionpay.mobile.android.languages.c.bD.f23451bh, this.f23639a.aY);
            this.E = bVar3;
            linearLayout.addView(bVar3, layoutParams6);
            com.unionpay.mobile.android.upviews.a aVar4 = this.D;
            z c12 = aVar4 != null ? aVar4.c("instalment") : null;
            Context context2 = this.f23642d;
            JSONArray jSONArray2 = this.f23639a.f23550z;
            long c13 = this.f23643e.c();
            com.unionpay.mobile.android.model.b bVar4 = this.f23639a;
            this.f23718t = new com.unionpay.mobile.android.upviews.a(context2, jSONArray2, c13, this, bVar4.f23514aq, true, true, c12, bVar4.f23501ad, this.f23655q);
            i11 = -1;
            linearLayout.addView(this.f23718t, new LinearLayout.LayoutParams(-1, -2));
        } else if (TextUtils.isEmpty(this.f23639a.aY)) {
            i10 = -2;
            LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams7.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            layoutParams7.leftMargin = com.unionpay.mobile.android.utils.g.a(this.f23642d, 10.0f);
            TextView textView5 = new TextView(this.f23642d);
            textView5.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
            textView5.setText(this.f23639a.f23502ae);
            linearLayout.addView(textView5, layoutParams7);
            i11 = -1;
        } else {
            i10 = -2;
            RelativeLayout relativeLayout = new RelativeLayout(this.f23642d);
            TextView textView6 = new TextView(this.f23642d);
            textView6.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
            textView6.setTextColor(-13421773);
            textView6.setText(com.unionpay.mobile.android.languages.c.bD.bA);
            RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams8.addRule(9, -1);
            layoutParams8.addRule(15, -1);
            layoutParams8.leftMargin = com.unionpay.mobile.android.utils.g.a(this.f23642d, 10.0f);
            relativeLayout.addView(textView6, layoutParams8);
            TextView textView7 = new TextView(this.f23642d);
            textView7.setText(Html.fromHtml(com.unionpay.mobile.android.languages.c.bD.f23468j));
            textView7.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
            textView7.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
            textView7.setOnClickListener(new y(this));
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams9.addRule(11, -1);
            layoutParams9.rightMargin = com.unionpay.mobile.android.utils.g.a(this.f23642d, 10.0f);
            layoutParams9.addRule(15, -1);
            relativeLayout.addView(textView7, layoutParams9);
            LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams10.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout.addView(relativeLayout, layoutParams10);
            this.f23718t = new com.unionpay.mobile.android.upviews.a(this.f23642d, this.f23639a.f23544t, this, this.f23655q);
            LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams11.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout.addView(this.f23718t, layoutParams11);
            i11 = -1;
        }
        LinearLayout linearLayout4 = new LinearLayout(this.f23642d);
        linearLayout4.setOrientation(1);
        linearLayout4.setId(linearLayout4.hashCode());
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(i11, i10);
        layoutParams12.topMargin = com.unionpay.mobile.android.global.a.f23313d;
        linearLayout.addView(linearLayout4, layoutParams12);
        if (this.f23639a.Z != null && t()) {
            com.unionpay.mobile.android.upwidget.a aVar5 = new com.unionpay.mobile.android.upwidget.a(this.f23642d, com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.f23639a.Z, com.unionpay.mobile.android.languages.c.bD.f23477s), new q(this), this.f23655q + "_agree_user_protocol");
            this.C = aVar5;
            linearLayout4.addView(aVar5);
        }
        w a10 = w.a(this.f23642d, this.f23639a.f23498aa, this.f23641c.a(1017, -1, -1));
        if (a10 != null) {
            a10.a(new r(this, a10.a()));
            LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(i10, i10);
            layoutParams13.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            linearLayout4.addView(a10, layoutParams13);
        }
        this.f23722x = new TextView(this.f23642d);
        if (t()) {
            this.f23722x.setText(com.unionpay.mobile.android.languages.c.bD.f23474p);
            this.f23722x.setOnClickListener(this.f23719u);
            TextView textView8 = this.f23722x;
            com.unionpay.mobile.android.upviews.a aVar6 = this.f23718t;
            textView8.setEnabled(aVar6 == null || aVar6.e());
        } else {
            if (p()) {
                this.f23722x.setText(com.unionpay.mobile.android.languages.c.bD.f23475q);
                textView3 = this.f23722x;
                onClickListener = new ab(this);
            } else {
                if (TextUtils.isEmpty(this.f23639a.aY)) {
                    com.unionpay.mobile.android.model.b bVar5 = this.f23639a;
                    if (!bVar5.aZ) {
                        List<com.unionpay.mobile.android.model.c> list = bVar5.f23541q;
                        if (list == null || list.size() == 0) {
                            textView2 = this.f23722x;
                            str = com.unionpay.mobile.android.languages.c.bD.bu;
                        } else {
                            textView2 = this.f23722x;
                            str = com.unionpay.mobile.android.languages.c.bD.bv;
                        }
                        textView2.setText(str);
                        textView3 = this.f23722x;
                        onClickListener = this.f23721w;
                    }
                }
                this.f23722x.setText(com.unionpay.mobile.android.languages.c.bD.f23476r);
                this.f23722x.setOnClickListener(this.f23720v);
                textView = this.f23722x;
                z10 = false;
                textView.setEnabled(z10);
            }
            textView3.setOnClickListener(onClickListener);
            textView = this.f23722x;
            z10 = true;
            textView.setEnabled(z10);
        }
        this.f23722x.setTextSize(com.unionpay.mobile.android.global.b.f23344i);
        this.f23722x.setTextColor(com.unionpay.mobile.android.nocard.views.b.o());
        this.f23722x.setGravity(17);
        int i12 = com.unionpay.mobile.android.global.a.f23323n;
        this.f23722x.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
        LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(-1, i12);
        layoutParams14.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        int a11 = com.unionpay.mobile.android.utils.g.a(this.f23642d, 10.0f);
        layoutParams14.rightMargin = a11;
        layoutParams14.leftMargin = a11;
        linearLayout.addView(this.f23722x, layoutParams14);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
        String str2;
        StringBuilder sb2;
        this.f23648j = false;
        this.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        if (this.f23639a.aZ) {
            sb2 = new StringBuilder("\"card\":\"");
            str2 = this.f23639a.f23514aq;
        } else {
            sb2 = new StringBuilder("\"card\":\"");
            str2 = this.f23639a.f23499ab.get(this.f23723y).a();
        }
        sb2.append(str2);
        sb2.append("\"");
        String sb3 = sb2.toString();
        k.a("uppay", "cmd:" + str + ", ele:" + sb3);
        this.f23643e.c(str, sb3);
        this.f23717s = 6;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
        a(str, str2);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        List<com.unionpay.mobile.android.model.c> list;
        if (!TextUtils.isEmpty(this.f23639a.f23545u)) {
            com.unionpay.mobile.android.model.b bVar = this.f23639a;
            if (bVar.aC && ((list = bVar.f23541q) == null || list.size() == 0)) {
                this.f23640b.a(new s(this), new t(this));
                m mVar = this.f23640b;
                com.unionpay.mobile.android.languages.c cVar = com.unionpay.mobile.android.languages.c.bD;
                mVar.a(cVar.Y, cVar.av, cVar.W, cVar.X);
                return;
            }
        }
        com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
        if (bVar2.aZ) {
            bVar2.aZ = false;
        }
        com.unionpay.mobile.android.upviews.a aVar = this.f23718t;
        if (aVar == null || !aVar.d()) {
            String str = this.f23639a.f23545u;
            if (str == null || str.length() <= 0) {
                m();
            } else {
                a(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.b, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
        z c10;
        String str;
        this.f23640b.a(com.unionpay.mobile.android.languages.c.bD.U);
        if (this.D.c("promotion") != null) {
            str = "\"" + ((aj) c10).g() + "\"";
        } else {
            str = "\"\"";
        }
        this.f23643e.c("instalment", "\"promotion\":" + str);
        this.f23717s = 16;
    }
}
