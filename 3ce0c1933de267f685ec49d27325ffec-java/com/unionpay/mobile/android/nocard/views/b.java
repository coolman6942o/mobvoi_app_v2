package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.contacts.ContactConstant;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.d;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.o;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.widgets.UPWidget;
import com.unionpay.mobile.android.widgets.aa;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.mobile.android.widgets.ae;
import com.unionpay.mobile.android.widgets.af;
import com.unionpay.mobile.android.widgets.ah;
import com.unionpay.mobile.android.widgets.ao;
import com.unionpay.mobile.android.widgets.ap;
import com.unionpay.mobile.android.widgets.as;
import com.unionpay.mobile.android.widgets.at;
import com.unionpay.mobile.android.widgets.au;
import com.unionpay.mobile.android.widgets.av;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.f;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.u;
import com.unionpay.mobile.android.widgets.y;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.tsmservice.data.Constant;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b extends RelativeLayout implements UPPayEngine.a, a, UPScrollView.a, aa.a, ay.a {

    /* renamed from: a  reason: collision with root package name */
    protected com.unionpay.mobile.android.model.b f23639a;

    /* renamed from: b  reason: collision with root package name */
    protected m f23640b;

    /* renamed from: c  reason: collision with root package name */
    protected c f23641c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f23642d;

    /* renamed from: e  reason: collision with root package name */
    protected UPPayEngine f23643e;

    /* renamed from: f  reason: collision with root package name */
    protected int f23644f;

    /* renamed from: g  reason: collision with root package name */
    protected String f23645g;

    /* renamed from: h  reason: collision with root package name */
    protected String f23646h;

    /* renamed from: i  reason: collision with root package name */
    protected String f23647i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f23648j;

    /* renamed from: k  reason: collision with root package name */
    protected RelativeLayout f23649k;

    /* renamed from: l  reason: collision with root package name */
    protected ViewGroup f23650l;

    /* renamed from: m  reason: collision with root package name */
    protected RelativeLayout f23651m;

    /* renamed from: n  reason: collision with root package name */
    protected as f23652n;

    /* renamed from: o  reason: collision with root package name */
    protected UPScrollView f23653o;

    /* renamed from: p  reason: collision with root package name */
    protected e f23654p;

    /* renamed from: q  reason: collision with root package name */
    protected String f23655q;

    /* renamed from: r  reason: collision with root package name */
    private LinearLayout f23656r;

    /* renamed from: s  reason: collision with root package name */
    private LinearLayout f23657s;

    /* renamed from: t  reason: collision with root package name */
    private LinearLayout f23658t;

    /* renamed from: u  reason: collision with root package name */
    private int f23659u;

    /* renamed from: v  reason: collision with root package name */
    private int f23660v;

    /* renamed from: w  reason: collision with root package name */
    private Activity f23661w;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, e eVar) {
        super(context);
        this.f23639a = null;
        this.f23640b = null;
        this.f23641c = null;
        this.f23642d = null;
        this.f23643e = null;
        this.f23645g = null;
        this.f23646h = null;
        this.f23647i = null;
        this.f23648j = true;
        this.f23649k = null;
        this.f23650l = null;
        this.f23651m = null;
        this.f23652n = null;
        this.f23653o = null;
        this.f23655q = "uppay";
        this.f23661w = null;
        this.f23644f = 0;
        this.f23642d = context;
        if (context instanceof Activity) {
            this.f23661w = (Activity) context;
        }
        this.f23654p = eVar;
        BaseActivity baseActivity = (BaseActivity) context;
        this.f23643e = (UPPayEngine) baseActivity.a(UPPayEngine.class.toString());
        this.f23639a = (com.unionpay.mobile.android.model.b) baseActivity.a((String) null);
        this.f23640b = (m) baseActivity.a(m.class.toString());
        this.f23641c = c.a(context);
        setId(8888);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setBackgroundColor(-1);
        k.b("uppayEx", "UPViewBase:" + toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i10, boolean z10, boolean z11) {
        Context context = this.f23642d;
        BaseActivity baseActivity = (BaseActivity) context;
        b bVar = null;
        if (i10 != 2) {
            if (i10 == 8) {
                bVar = new bd(context);
            } else if (i10 == 5) {
                bVar = new g(context);
            } else if (i10 != 6) {
                if (!(i10 == 17 || i10 == 18)) {
                    switch (i10) {
                        case 10:
                            bVar = new ak(context);
                            break;
                        case 11:
                            bVar = new ai(context);
                            break;
                        case 12:
                            bVar = new af(context);
                            break;
                        case 13:
                            bVar = new o(context, null);
                            break;
                        case 14:
                            bVar = new bi(this.f23642d, z10, z11);
                            break;
                    }
                }
            } else {
                int i11 = 0;
                List<com.unionpay.mobile.android.model.c> list = this.f23639a.f23541q;
                if (list != null && list.size() > 0) {
                    com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
                    i11 = bVar2.f23541q.get(bVar2.N).c();
                }
                bVar = ((h() || i11 == 0) && !this.f23639a.br) ? new at(this.f23642d) : baseActivity.a(6, null);
            }
            if (bVar == null) {
                baseActivity.a(bVar);
                return;
            }
            return;
        }
        bVar = baseActivity.a(i10, null);
        if (bVar == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(String str) {
        return str != null && str.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ColorStateList o() {
        int i10 = com.unionpay.mobile.android.global.b.f23337b;
        int i11 = com.unionpay.mobile.android.global.b.f23338c;
        return h.a(i10, i11, i11, com.unionpay.mobile.android.global.b.f23339d);
    }

    private RelativeLayout r() {
        int i10;
        LinearLayout linearLayout;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = this.f23649k;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
            layoutParams.addRule(12, -1);
        }
        FrameLayout frameLayout = new FrameLayout(this.f23642d);
        addView(frameLayout, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        UPScrollView uPScrollView = new UPScrollView(this.f23642d);
        this.f23653o = uPScrollView;
        uPScrollView.setPadding(0, 0, 0, 0);
        frameLayout.addView(this.f23653o, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        int a10 = g.a(this.f23642d, 10.0f);
        LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
        this.f23658t = linearLayout2;
        linearLayout2.setId(linearLayout2.hashCode());
        this.f23658t.setOrientation(1);
        if (!this.f23639a.aM || com.unionpay.mobile.android.model.b.f23494bm) {
            linearLayout = this.f23658t;
            i10 = -267336;
        } else {
            linearLayout = this.f23658t;
            i10 = -34177;
        }
        linearLayout.setBackgroundColor(i10);
        this.f23658t.setPadding(a10, a10, a10, a10);
        String str = "";
        if (b(this.f23639a.ar)) {
            str = str + this.f23639a.ar;
        }
        if (b(str)) {
            TextView textView = new TextView(this.f23642d);
            if (!this.f23639a.aM || com.unionpay.mobile.android.model.b.f23494bm) {
                textView.setTextColor(-10066330);
            } else {
                textView.setTextColor(-1);
            }
            textView.setText(str);
            textView.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
            this.f23658t.addView(textView);
        } else {
            this.f23658t.setVisibility(8);
        }
        this.f23658t.setVisibility(8);
        frameLayout.addView(this.f23658t, layoutParams3);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f23642d);
        relativeLayout2.setBackgroundColor(-1052684);
        this.f23653o.addView(relativeLayout2, new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final RelativeLayout a() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(relativeLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        addView(relativeLayout, layoutParams);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final z a(JSONObject jSONObject, String str) {
        String a10 = j.a(jSONObject, "type");
        int i10 = a.I - (a.f23315f * 4);
        z afVar = Constant.KEY_PAN.equalsIgnoreCase(a10) ? new af(this.f23642d, i10, jSONObject, str) : "mobile".equalsIgnoreCase(a10) ? new ah(this.f23642d, i10, jSONObject, str) : "sms".equalsIgnoreCase(a10) ? new ap(this.f23642d, i10, jSONObject, str) : Constant.KEY_CVN2.equalsIgnoreCase(a10) ? new com.unionpay.mobile.android.widgets.e(this.f23642d, i10, jSONObject, str) : "expire".equalsIgnoreCase(a10) ? new av(this.f23642d, i10, jSONObject, str) : "pwd".equalsIgnoreCase(a10) ? new UPWidget(this.f23642d, this.f23643e.c(), i10, jSONObject, str) : "text".equalsIgnoreCase(a10) ? new at(this.f23642d, i10, jSONObject, str) : "string".equalsIgnoreCase(a10) ? new ad(this.f23642d, jSONObject, str) : "cert_id".equalsIgnoreCase(a10) ? new f(this.f23642d, i10, jSONObject, str) : "cert_type".equalsIgnoreCase(a10) ? new com.unionpay.mobile.android.widgets.g(this.f23642d, jSONObject, str) : ContactConstant.CallsRecordKeys.NAME.equalsIgnoreCase(a10) ? new ae(this.f23642d, i10, jSONObject, str) : "hidden".equalsIgnoreCase(a10) ? new y(this.f23642d, jSONObject, str) : "user_name".equalsIgnoreCase(a10) ? new au(this.f23642d, i10, jSONObject, str) : "password".equalsIgnoreCase(a10) ? new ao(this.f23642d, i10, jSONObject, str) : null;
        if (afVar != null && (afVar instanceof aa)) {
            ((aa) afVar).a((aa.a) this);
        }
        return afVar;
    }

    public final void a(int i10) {
        ((BaseActivity) this.f23642d).a(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i10, e eVar) {
        b bVar;
        Context context = this.f23642d;
        BaseActivity baseActivity = (BaseActivity) context;
        if (i10 != 2) {
            if (i10 == 8) {
                bVar = new bd(context);
            } else if (i10 == 5) {
                bVar = new g(context);
            } else if (i10 != 6) {
                if (!(i10 == 17 || i10 == 18)) {
                    switch (i10) {
                        case 10:
                            bVar = new ak(context);
                            break;
                        case 11:
                            bVar = new ai(context);
                            break;
                        case 12:
                            bVar = new af(context);
                            break;
                        case 13:
                            bVar = new o(context, eVar);
                            break;
                        case 14:
                            bVar = new bi(this.f23642d);
                            break;
                        default:
                            bVar = null;
                            break;
                    }
                }
            } else {
                int i11 = 0;
                List<com.unionpay.mobile.android.model.c> list = this.f23639a.f23541q;
                if (list != null && list.size() > 0) {
                    com.unionpay.mobile.android.model.b bVar2 = this.f23639a;
                    i11 = bVar2.f23541q.get(bVar2.N).c();
                }
                bVar = ((h() || i11 == 0 || this.f23639a.aP == l.f24229c.intValue()) && !this.f23639a.br) ? new at(this.f23642d, eVar) : baseActivity.a(6, eVar);
            }
            if (bVar == null) {
                baseActivity.a(bVar);
                return;
            }
            return;
        }
        bVar = baseActivity.a(i10, eVar);
        if (bVar == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    @Override // com.unionpay.mobile.android.nocard.utils.UPPayEngine.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i10, String str) {
        String str2;
        String str3;
        this.f23648j = true;
        k.a("uppay", " " + toString());
        if (i10 == 0) {
            k.a("uppay", "parserResponseMesage() +++");
            int i11 = 0;
            JSONObject jSONObject = null;
            int i12 = 2;
            if (!(str == null || str.length() == 0)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    this.f23645g = j.a(jSONObject2, "resp");
                    this.f23646h = j.a(jSONObject2, "msg");
                    this.f23647i = j.a(jSONObject2, "cmd");
                    jSONObject = j.c(jSONObject2, Constant.KEY_PARAMS);
                    if (!this.f23645g.equalsIgnoreCase("00")) {
                        if ("pay".equals(this.f23647i) || ((str3 = this.f23639a.E) != null && str3.length() > 0 && this.f23639a.E.equals(this.f23647i))) {
                            String[] strArr = o.f24168j;
                        }
                        if ("rules".equals(this.f23647i)) {
                            String[] strArr2 = o.f24168j;
                        }
                        if ("getuserinfo".equals(this.f23647i)) {
                            String[] strArr3 = o.f24168j;
                        }
                        if (this.f23645g.equalsIgnoreCase("21")) {
                            i11 = 17;
                            str2 = " ERROR_ORDER_TIMEOUT";
                        } else {
                            i11 = 3;
                            str2 = " ERROR_TRANSACTION";
                        }
                        k.a("uppay", str2);
                    }
                    i12 = i11;
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                if (i12 != 0) {
                    a(jSONObject);
                } else if (!a(this.f23646h, jSONObject)) {
                    b(i12);
                }
                k.a("uppay", "parserResponseMesage() ---");
                return;
            }
            k.a("uppay", " ERROR_MSG_FORMAT");
            if (i12 != 0) {
            }
            k.a("uppay", "parserResponseMesage() ---");
            return;
        }
        b(i10);
    }

    @Override // com.unionpay.mobile.android.widgets.aa.a
    public final void a(u uVar, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        a(str, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        com.unionpay.mobile.android.languages.c cVar;
        this.f23640b.a(onClickListener, onClickListener2);
        Activity activity = this.f23661w;
        if (activity != null && !activity.isFinishing() && (cVar = com.unionpay.mobile.android.languages.c.bD) != null) {
            this.f23640b.a(cVar.Y, str, cVar.W, cVar.X, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, String str2) {
        a(str, str2, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str, String str2, boolean z10, boolean z11) {
        ((InputMethodManager) this.f23642d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        bVar.f23504ag = str2;
        bVar.f23503af = str;
        a(14, z10, z11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, boolean z10) {
        com.unionpay.mobile.android.languages.c cVar;
        d dVar = new d(this, z10);
        k.a("uppay", " showErrDialog(msg, boolean)  ");
        this.f23640b.a(dVar, null);
        Activity activity = this.f23661w;
        if (activity != null && !activity.isFinishing() && (cVar = com.unionpay.mobile.android.languages.c.bD) != null) {
            this.f23640b.a(cVar.Y, str, cVar.W);
        }
    }

    protected boolean a(String str, JSONObject jSONObject) {
        return false;
    }

    protected void b() {
    }

    public void b(int i10) {
        String c10;
        boolean z10;
        if (i10 == 8 || i10 == 17 || i10 == 19) {
            this.f23639a.I.f23866f = Constant.CASH_LOAD_FAIL;
            k.a("uppay", "showErrDialog 1");
            c10 = c(i10);
            z10 = true;
        } else {
            k.a("uppay", "showErrDialog 2");
            c10 = c(i10);
            z10 = false;
        }
        a(c10, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(String str, String str2) {
        a(str, str2, true, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(JSONObject jSONObject) {
        if (!com.unionpay.mobile.android.nocard.utils.f.c(this.f23639a, jSONObject)) {
            return false;
        }
        c(jSONObject);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final String c(int i10) {
        switch (i10) {
            case 2:
                return com.unionpay.mobile.android.languages.c.bD.aB;
            case 3:
                break;
            case 4:
                return com.unionpay.mobile.android.languages.c.bD.az;
            case 5:
                return com.unionpay.mobile.android.languages.c.bD.aH;
            case 6:
                return com.unionpay.mobile.android.languages.c.bD.aI;
            case 7:
                return com.unionpay.mobile.android.languages.c.bD.aG;
            case 8:
                return com.unionpay.mobile.android.languages.c.bD.aJ;
            case 9:
                return com.unionpay.mobile.android.languages.c.bD.aK;
            default:
                switch (i10) {
                    case 16:
                        return com.unionpay.mobile.android.languages.c.bD.aM;
                    case 17:
                        break;
                    case 18:
                        return com.unionpay.mobile.android.languages.c.bD.aP;
                    case 19:
                        return com.unionpay.mobile.android.languages.c.bD.aN;
                    case 20:
                        return com.unionpay.mobile.android.languages.c.bD.aO;
                    case 21:
                        return com.unionpay.mobile.android.languages.c.bD.aL;
                    default:
                        return com.unionpay.mobile.android.languages.c.bD.aA;
                }
        }
        return this.f23646h;
    }

    protected void c() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(JSONObject jSONObject) {
        com.unionpay.mobile.android.model.b bVar;
        this.f23640b.a(new e(this, jSONObject), new f(this, jSONObject));
        Activity activity = this.f23661w;
        if (activity != null && !activity.isFinishing() && (bVar = this.f23639a) != null) {
            this.f23640b.a(bVar.aG, bVar.aH, bVar.aI, bVar.aK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        this.f23651m = r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(int i10) {
        a(i10, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        this.f23649k = a();
        b();
        RelativeLayout r10 = r();
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        linearLayout.setOrientation(1);
        linearLayout.setId(linearLayout.hashCode());
        linearLayout.setBackgroundColor(-1114114);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        r10.addView(linearLayout, layoutParams);
        this.f23650l = linearLayout;
        linearLayout.setBackgroundColor(0);
        f();
        int id2 = this.f23650l.getId();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(12, -1);
        layoutParams2.addRule(3, id2);
        RelativeLayout relativeLayout = new RelativeLayout(this.f23642d);
        r10.addView(relativeLayout, layoutParams2);
        this.f23651m = relativeLayout;
        c();
    }

    @Override // com.unionpay.mobile.android.upwidget.UPScrollView.a
    public final void e(int i10) {
        LinearLayout linearLayout;
        int i11 = this.f23660v;
        if (i10 >= i11) {
            if (this.f23658t.getVisibility() != 0 && this.f23658t != null && this.f23656r.getVisibility() == 0) {
                this.f23658t.setVisibility(0);
            }
        } else if (i10 <= i11 + this.f23659u && this.f23658t.getVisibility() == 0 && (linearLayout = this.f23658t) != null) {
            linearLayout.setVisibility(8);
        }
    }

    protected void f() {
        String str;
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        this.f23657s = linearLayout;
        linearLayout.setOrientation(1);
        if (!this.f23639a.aM || com.unionpay.mobile.android.model.b.f23494bm) {
            this.f23657s.setBackgroundColor(-267336);
        } else {
            this.f23657s.setBackgroundColor(-34177);
        }
        int a10 = g.a(this.f23642d, 10.0f);
        if (b(this.f23639a.ar)) {
            this.f23657s.setPadding(a10, a10, a10, 0);
        } else {
            this.f23657s.setPadding(a10, a10, a10, a10);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = 0;
        this.f23650l.addView(this.f23657s, layoutParams);
        String str2 = "";
        if (b(this.f23639a.at)) {
            str = str2 + this.f23639a.at;
        } else {
            str = str2;
        }
        if (b(str)) {
            TextView textView = new TextView(this.f23642d);
            if (!this.f23639a.aM || com.unionpay.mobile.android.model.b.f23494bm) {
                textView.setTextColor(-10066330);
            } else {
                textView.setTextColor(-1);
            }
            textView.setText(str);
            textView.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
            this.f23657s.addView(textView);
        } else {
            this.f23657s.setVisibility(8);
        }
        LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
        this.f23656r = linearLayout2;
        linearLayout2.setOrientation(1);
        if (!this.f23639a.aM || com.unionpay.mobile.android.model.b.f23494bm) {
            this.f23656r.setBackgroundColor(-267336);
        } else {
            this.f23656r.setBackgroundColor(-34177);
        }
        this.f23656r.setPadding(a10, a10, a10, a10);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = 0;
        this.f23650l.addView(this.f23656r, layoutParams2);
        if (b(this.f23639a.ar)) {
            str2 = str2 + this.f23639a.ar;
        }
        if (b(str2)) {
            TextView textView2 = new TextView(this.f23642d);
            if (!this.f23639a.aM || com.unionpay.mobile.android.model.b.f23494bm) {
                textView2.setTextColor(-10066330);
            } else {
                textView2.setTextColor(-1);
            }
            textView2.setText(str2);
            textView2.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
            this.f23656r.addView(textView2);
        } else {
            this.f23656r.setVisibility(8);
        }
        this.f23656r.getViewTreeObserver().addOnPreDrawListener(new c(this));
        com.unionpay.mobile.android.views.order.m mVar = new com.unionpay.mobile.android.views.order.m(this.f23642d);
        mVar.a(this.f23641c.a(1003, -1, -1), this.f23641c.a(1001, -1, -1));
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        mVar.a(true ^ (this instanceof ao), bVar.f23532h, bVar.f23533i);
        this.f23650l.addView(mVar, new LinearLayout.LayoutParams(-1, -2));
        Drawable a11 = this.f23641c.a(1026, -1, -1);
        LinearLayout linearLayout3 = new LinearLayout(this.f23642d);
        if (a11 != null) {
            linearLayout3.setBackgroundDrawable(a11);
        }
        this.f23650l.addView(linearLayout3, new LinearLayout.LayoutParams(-1, g.a(this.f23642d, 2.0f)));
    }

    public final int g() {
        return this.f23644f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean h() {
        List<com.unionpay.mobile.android.model.c> list;
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        return bVar.J || (list = bVar.f23541q) == null || list.size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i() {
        m mVar = this.f23640b;
        if (mVar != null && mVar.a()) {
            this.f23640b.c();
        }
    }

    public final void j() {
        d.a(this.f23642d, this.f23639a);
    }

    public void k() {
        if (this.f23648j) {
            m();
        }
    }

    @Override // com.unionpay.mobile.android.widgets.ay.a
    public final void l() {
        k();
    }

    public final void m() {
        ((BaseActivity) this.f23642d).b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean n() {
        m mVar = this.f23640b;
        boolean z10 = mVar != null && mVar.a();
        k.a("uppay", " dialog showing:" + z10);
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        k.b("uppayEx", toString() + " onAttachedToWindow()");
        super.onAttachedToWindow();
        this.f23643e.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean p() {
        return !this.f23639a.f23527c;
    }

    public final void q() {
        Context context = this.f23642d;
        if (context != null) {
            ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }
}
