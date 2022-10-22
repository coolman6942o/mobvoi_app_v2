package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.agconnect.exception.AGCServerException;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.views.order.o;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ao extends b implements a.b {

    /* renamed from: w  reason: collision with root package name */
    private o f23615w;

    /* renamed from: x  reason: collision with root package name */
    private LinearLayout f23616x;

    /* renamed from: z  reason: collision with root package name */
    private Handler f23618z;

    /* renamed from: s  reason: collision with root package name */
    private int f23611s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f23612t = -1;

    /* renamed from: u  reason: collision with root package name */
    private Button f23613u = null;

    /* renamed from: v  reason: collision with root package name */
    private com.unionpay.mobile.android.upviews.a f23614v = null;

    /* renamed from: r  reason: collision with root package name */
    List<Map<String, Object>> f23610r = new ArrayList(1);

    /* renamed from: y  reason: collision with root package name */
    private boolean f23617y = false;
    private Handler A = new Handler(new ap(this));

    /* loaded from: classes2.dex */
    public class a implements o.a {
        public a() {
        }

        @Override // com.unionpay.mobile.android.views.order.b.AbstractC0268b
        public final int a() {
            ao aoVar = ao.this;
            aoVar.f23639a.J = true;
            aoVar.d(2);
            return 0;
        }

        @Override // com.unionpay.mobile.android.views.order.b.AbstractC0268b
        public final int a(int i10) {
            ao.this.f23612t = i10;
            ao.this.f23611s = 3;
            ao aoVar = ao.this;
            aoVar.f23648j = false;
            aoVar.f23640b.a(c.bD.U);
            ao aoVar2 = ao.this;
            aoVar2.f23643e.l(aoVar2.f23639a.f23541q.get(i10).a());
            return 0;
        }

        @Override // com.unionpay.mobile.android.views.order.AbstractMethod.a
        public final void a(int i10, boolean z10, int i11, a.C0266a aVar) {
            String str;
            if (ao.this.f23615w != null) {
                ao aoVar = ao.this;
                aoVar.f23639a.aQ = aoVar.f23615w.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ao.this.f23639a.aQ);
                k.c("functionEx", sb2.toString());
            }
            if (i10 == l.f24231e.intValue()) {
                ao.c(ao.this, i11);
            } else if (z10) {
                ao aoVar2 = ao.this;
                aoVar2.f23639a.N = i11;
                aoVar2.f23648j = false;
                aoVar2.f23611s = 2;
                ao.this.f23640b.a(c.bD.U);
                if (ao.this.f23639a.f23541q.get(i11).c() == 0) {
                    String a10 = ao.this.f23639a.f23541q.get(i11).a();
                    ao.this.f23639a.M = "1";
                    str = bh.a("1", a10, "1", "1");
                } else {
                    b bVar = ao.this.f23639a;
                    bVar.M = "0";
                    String b10 = bVar.f23541q.get(i11).b();
                    String str2 = ao.this.f23639a.M;
                    str = bh.b(str2, "\"pan\":\"" + b10 + "\"", "2", "1\",\"carrier_tp\":\"2");
                }
                ao aoVar3 = ao.this;
                aoVar3.f23643e.c(bh.a(aoVar3.f23639a.f23534j), str);
            } else if (!aVar.a()) {
                ao.this.a(aVar.f23995b);
            } else if (i10 == l.f24229c.intValue()) {
                ao aoVar4 = ao.this;
                aoVar4.f23648j = false;
                aoVar4.f23611s = 4;
                ao.this.f23640b.a(c.bD.U);
                ao.this.f23643e.m(aVar.f23995b);
            } else {
                ao aoVar5 = ao.this;
                aoVar5.f23648j = false;
                aoVar5.f23611s = 2;
                ao.this.f23640b.a(c.bD.U);
                ao.this.f23639a.M = "0";
                String b11 = bh.b("0", aVar.f23995b, "1", "1");
                ao aoVar6 = ao.this;
                aoVar6.f23643e.c(bh.a(aoVar6.f23639a.f23534j), b11);
            }
        }

        @Override // com.unionpay.mobile.android.views.order.AbstractMethod.b
        public final void a(String str, String str2) {
            ao.this.a(str, str2);
        }

        @Override // com.unionpay.mobile.android.views.order.b.AbstractC0268b
        public final int b(int i10) {
            String[] strArr = com.unionpay.mobile.android.utils.o.f24164f;
            return 0;
        }

        @Override // com.unionpay.mobile.android.views.order.CViewMethods.a
        public final void c(int i10) {
            ao.this.q();
            Integer num = l.f24228b;
            if (i10 == num.intValue()) {
                ao.this.f23639a.aP = num.intValue();
                ao.this.d(2);
            } else if (i10 == l.f24229c.intValue()) {
                ao.d(ao.this);
            } else if (i10 == l.f24230d.intValue()) {
                ao.this.d(17);
            } else if (i10 == l.f24231e.intValue()) {
                ao.f(ao.this);
            } else if (i10 == l.f24232f.intValue()) {
                ao aoVar = ao.this;
                b bVar = aoVar.f23639a;
                aoVar.d(bVar.f23525bp, bVar.f23526bq);
            }
        }
    }

    public ao(Context context, e eVar) {
        super(context, eVar);
        this.f23618z = null;
        this.f23644f = 2;
        b bVar = this.f23639a;
        if (bVar.aE && bVar.az) {
            bVar.aP = l.f24231e.intValue();
        }
        this.f23655q = "order";
        setBackgroundColor(-1052684);
        e();
        if (!TextUtils.isEmpty(this.f23639a.f23545u) || this.f23639a.aC) {
            this.f23618z = new Handler(new aq(this));
        }
        if (!b.f23493bl && this.f23639a.aP == l.f24231e.intValue()) {
            b bVar2 = this.f23639a;
            if (bVar2.az && !bVar2.aC && !bVar2.aD) {
                this.A.sendMessageDelayed(this.A.obtainMessage(AGCServerException.UNKNOW_EXCEPTION), 8000L);
                k.c("uppay", "mHceHandler.sendMessageDelayed(msg, 8000)");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> b(d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("text1", dVar.b() + dVar.c());
        hashMap.put("text2", dVar.a().substring(0, 4) + " **** " + dVar.a().substring(dVar.a().length() - 4));
        return hashMap;
    }

    static /* synthetic */ void c(ao aoVar, int i10) {
        aoVar.f23611s = 6;
        aoVar.f23648j = false;
        aoVar.f23640b.a(c.bD.U);
        String a10 = b.f23492bb.get(i10).a();
        String e10 = b.f23492bb.get(i10).e();
        String d10 = b.f23492bb.get(i10).d();
        aoVar.f23639a.f23516bc = i10;
        String str = "\"pan\":\"" + a10 + "\",\"carrier_tp\":\"9\",\"issuer\":\"" + e10 + "\",\"type\":\"" + d10 + "\"";
        k.c("uppay", str);
        aoVar.f23643e.c("cardrules", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(ao aoVar) {
        String str = aoVar.f23639a.f23545u;
        if (str == null || str.length() <= 0) {
            aoVar.f23639a.aP = l.f24229c.intValue();
            aoVar.d(2);
            return;
        }
        aoVar.f23611s = 4;
        aoVar.f23648j = false;
        aoVar.f23640b.a(c.bD.U);
        aoVar.f23643e.m(String.format("\"user_id\":\"%s\"", aoVar.f23639a.f23545u));
    }

    private void d(JSONObject jSONObject) {
        int a10 = f.a(this.f23639a, jSONObject, false);
        if (a10 != 0) {
            b(a10);
        } else {
            e a11 = f.a(jSONObject);
            JSONArray jSONArray = this.f23639a.f23550z;
            if (jSONArray == null || jSONArray.length() <= 0) {
                JSONArray jSONArray2 = this.f23639a.D;
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    d(5);
                }
            } else {
                a(6, a11);
            }
        }
        this.f23611s = 0;
    }

    private void e(JSONObject jSONObject) {
        int b10 = f.b(this.f23639a, jSONObject);
        if (b10 != 0) {
            b(b10);
            return;
        }
        if (!TextUtils.isEmpty(j.a(jSONObject, "userId"))) {
            String[] strArr = com.unionpay.mobile.android.utils.o.f24163e;
        }
        o oVar = this.f23615w;
        if (oVar != null) {
            String b11 = oVar.b();
            if (!TextUtils.isEmpty(b11)) {
                PreferenceUtils.d(this.f23642d, b11);
            }
        }
        a(13, f.a(jSONObject));
        this.f23611s = 0;
    }

    static /* synthetic */ void f(ao aoVar) {
        List<d> list;
        if (!b.f23493bl || ((list = b.f23492bb) != null && list.size() > 0)) {
            aoVar.f23639a.aP = l.f24231e.intValue();
            aoVar.d(2);
            return;
        }
        b bVar = aoVar.f23639a;
        aoVar.a(c.bD.f23460bq, bVar.f23521bh, bVar.aE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.f23639a.aP == l.f24231e.intValue()) {
            b bVar = this.f23639a;
            if (bVar.az && !bVar.aC && !bVar.aD) {
                this.A.removeMessages(AGCServerException.UNKNOW_EXCEPTION);
                k.c("uppay", "mHceHandler remove Message");
            }
        }
    }

    protected void a(Handler handler) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(com.unionpay.mobile.android.model.a aVar) {
        b bVar = this.f23639a;
        bVar.br = true;
        bVar.bs = aVar;
        this.f23611s = 2;
        this.f23640b.a(c.bD.U);
        this.f23639a.M = "0";
        this.f23643e.c(bh.a(this.f23639a.f23534j), bh.b("0", "\"pan\":\"" + aVar.b() + "\"", "2", "1\",\"carrier_tp\":\"10"));
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        this.f23640b.c();
        switch (this.f23611s) {
            case 1:
                b bVar = this.f23639a;
                bVar.X = j.d(jSONObject, "login_rules");
                bVar.Y = j.c(jSONObject, "register_url");
                JSONArray jSONArray = bVar.X;
                if ((jSONArray == null || jSONArray.length() <= 0) ? true : false) {
                    b(2);
                } else {
                    d(12);
                }
                this.f23611s = 0;
                return;
            case 2:
                if (!b(jSONObject)) {
                    d(jSONObject);
                    return;
                }
                return;
            case 3:
                b bVar2 = this.f23639a;
                int i10 = this.f23612t;
                List<com.unionpay.mobile.android.model.c> list = bVar2.f23541q;
                if (list != null && i10 < list.size()) {
                    bVar2.f23541q.remove(i10);
                }
                List<com.unionpay.mobile.android.model.c> list2 = this.f23639a.f23541q;
                if (list2 == null || list2.size() <= 0) {
                    this.f23639a.N = -1;
                    c();
                } else {
                    int i11 = this.f23612t;
                    b bVar3 = this.f23639a;
                    int i12 = bVar3.N;
                    if (i11 == i12) {
                        bVar3.N = 0;
                    } else if (i11 < i12) {
                        bVar3.N = i12 - 1;
                    }
                    this.f23615w.c(bVar3.N);
                }
                this.f23611s = 0;
                return;
            case 4:
                if (!b(jSONObject)) {
                    e(jSONObject);
                    return;
                }
                return;
            case 5:
                i();
                int a10 = f.a(this.f23639a, jSONObject, false);
                if (a10 != 0) {
                    b(a10);
                    return;
                }
                e a11 = f.a(jSONObject);
                JSONArray jSONArray2 = this.f23639a.f23550z;
                if (jSONArray2 == null || jSONArray2.length() <= 0) {
                    JSONArray jSONArray3 = this.f23639a.D;
                    if (jSONArray3 != null && jSONArray3.length() > 0) {
                        d(5);
                        return;
                    }
                    return;
                }
                a(6, a11);
                return;
            case 6:
                this.f23640b.c();
                int a12 = f.a(this.f23639a, jSONObject, false);
                if (a12 != 0) {
                    b(a12);
                    return;
                }
                e a13 = f.a(jSONObject);
                v();
                a(18, a13);
                return;
            default:
                return;
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        Button button = this.f23613u;
        if (button != null && button != null) {
            button.setEnabled(!z10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
        if (r3.size() <= 0) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
    @Override // com.unionpay.mobile.android.nocard.views.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void b() {
        String str;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        String str2 = this.f23639a.f23539o;
        ay ayVar = new ay(this.f23642d, str2, this);
        b bVar = this.f23639a;
        if (!bVar.J) {
            if ((!bVar.aE || bVar.aP != l.f24231e.intValue()) && this.f23639a.aP != l.f24227a.intValue()) {
                if (this.f23639a.aP == l.f24229c.intValue()) {
                    b bVar2 = this.f23639a;
                    if (bVar2.aC) {
                        List<com.unionpay.mobile.android.model.c> list = bVar2.f23541q;
                        if (list != null) {
                        }
                    }
                }
                if (this.f23639a.aP == l.f24231e.intValue()) {
                    str = c.bD.f23460bq;
                }
                layoutParams.addRule(13, -1);
                this.f23649k.addView(ayVar, layoutParams);
            }
            ayVar = new ay(this.f23642d, str2, this.f23641c.a(1030, -1, -1), g.a(this.f23642d, 20.0f), this);
            if (this.f23639a.aP == l.f24231e.intValue()) {
            }
            layoutParams.addRule(13, -1);
            this.f23649k.addView(ayVar, layoutParams);
        }
        str = c.bD.f23470l;
        ayVar.a(str);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(String str, JSONObject jSONObject) {
        if ("init".equals(str)) {
            if (this.f23639a.J) {
                m();
            }
        } else if ("".equals(str)) {
            int i10 = this.f23611s;
            if (i10 == 2) {
                d(jSONObject);
            } else if (i10 == 4) {
                e(jSONObject);
            }
        } else {
            this.f23640b.a(c.bD.U);
            this.f23648j = false;
            this.f23611s = 5;
            this.f23643e.c(str, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // com.unionpay.mobile.android.nocard.views.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void c() {
        o oVar;
        List<com.unionpay.mobile.android.model.c> list;
        List<com.unionpay.mobile.android.model.c> list2;
        this.f23651m.removeAllViews();
        this.f23653o.a(this);
        Drawable a10 = this.f23641c.a(2014, -1, -1);
        Drawable a11 = this.f23641c.a(1002, -1, -1);
        int i10 = this.f23639a.aP;
        Integer num = l.f24228b;
        if (i10 != num.intValue()) {
            b bVar = this.f23639a;
            if (!bVar.J) {
                int i11 = bVar.aP;
                Integer num2 = l.f24229c;
                if (i11 == num2.intValue()) {
                    oVar = o.a(this.f23642d, a10, a11);
                } else {
                    int i12 = this.f23639a.aP;
                    Integer num3 = l.f24231e;
                    if (i12 == num3.intValue()) {
                        HashMap hashMap = new HashMap();
                        if (b.f23493bl) {
                            List<d> list3 = b.f23492bb;
                            if (list3 != null && list3.size() > 0) {
                                int size = b.f23492bb.size();
                                for (int i13 = 0; i13 < size; i13++) {
                                    this.f23610r.add(b(b.f23492bb.get(i13)));
                                }
                            }
                        } else {
                            this.f23610r.add(hashMap);
                        }
                        oVar = o.b(this.f23642d, this.f23639a.f23544t, this.f23610r, a10, a11, "");
                    } else {
                        o a12 = o.a(this.f23642d, a10);
                        this.f23615w = a12;
                        a12.a(a11);
                        Integer num4 = l.f24227a;
                        int intValue = num4.intValue();
                        boolean a13 = f.a(this.f23639a.f23544t);
                        if (!a13) {
                            String a14 = j.a(this.f23639a.f23546v, "label");
                            if (this.f23639a.f23546v != null && a14.length() > 0) {
                                intValue |= num2.intValue();
                            }
                            k.a("uppay", String.valueOf(intValue));
                            String a15 = j.a(this.f23639a.f23547w, "label");
                            if (this.f23639a.f23547w != null && a15.length() > 0 && (list2 = this.f23639a.f23541q) != null && list2.size() > 0) {
                                a12.a(com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.f23642d, this.f23639a.f23541q, true));
                            }
                            b bVar2 = this.f23639a;
                            if (bVar2.ax && bVar2.ay && !bVar2.aC) {
                                intValue |= l.f24230d.intValue();
                            }
                            if (t()) {
                                b bVar3 = this.f23639a;
                                if (bVar3.az && !bVar3.aC) {
                                    intValue = num3.intValue() | intValue;
                                }
                            }
                            if (t() && b.aA && b.aB && this.f23639a.aP == num4.intValue() && !"1".equalsIgnoreCase(this.f23639a.f23511an)) {
                                k.c("spay", "in");
                                intValue |= l.f24232f.intValue();
                            }
                        }
                        if (this.f23639a.aD) {
                            intValue = num4.intValue();
                        }
                        b bVar4 = this.f23639a;
                        if (!bVar4.aC || TextUtils.isEmpty(bVar4.f23545u) || ((list = this.f23639a.f23541q) != null && list.size() > 0)) {
                            int a16 = com.unionpay.mobile.android.nocard.utils.c.a(this.f23642d, this.f23639a) & intValue;
                            if (a16 == 0 && !this.f23639a.aD) {
                                a16 = num.intValue();
                            }
                            a12.b(a16);
                            if (!this.f23639a.aD) {
                                intValue |= num.intValue();
                            }
                        } else {
                            int intValue2 = num4.intValue();
                            intValue = num4.intValue() | num2.intValue();
                            a12.b(intValue2);
                        }
                        a12.a(this.f23639a.f23544t);
                        k.a("uppay", String.valueOf(intValue));
                        a12.a(j.a(this.f23639a.f23547w, "label"));
                        a12.a(intValue);
                        a12.a(a13);
                        a12.c();
                        this.f23615w.a(new a());
                        this.f23615w.b(this.f23639a.au);
                        this.f23615w.c(this.f23639a.Y);
                        if (!TextUtils.isEmpty(this.f23639a.f23543s)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("href", this.f23639a.f23543s);
                                jSONObject.put("title", c.bD.f23469k);
                                jSONObject.put("label", c.bD.f23468j);
                                this.f23615w.a(jSONObject);
                            } catch (JSONException e10) {
                                e10.printStackTrace();
                            }
                        }
                        this.f23615w.b(this.f23641c.a(2008, -1, -1));
                        this.f23651m.addView(this.f23615w, new RelativeLayout.LayoutParams(-1, -1));
                        if (!(this.f23639a.aP == l.f24231e.intValue() || b.f23493bl)) {
                            a(this.A);
                            LinearLayout linearLayout = new LinearLayout(this.f23642d);
                            this.f23616x = linearLayout;
                            linearLayout.setOrientation(0);
                            int i14 = com.unionpay.mobile.android.global.a.f23332w;
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i14, i14);
                            layoutParams.gravity = 17;
                            this.f23616x.addView(new ProgressBar(this.f23642d), layoutParams);
                            TextView textView = new TextView(this.f23642d);
                            textView.setText(c.bD.bs);
                            textView.setTextSize(com.unionpay.mobile.android.global.b.f23347l);
                            textView.setTextColor(-10066330);
                            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams2.gravity = 17;
                            layoutParams2.leftMargin = com.unionpay.mobile.android.global.a.f23311b;
                            this.f23616x.addView(textView, layoutParams2);
                            this.f23615w.setVisibility(8);
                            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f23323n;
                            layoutParams3.addRule(14, -1);
                            this.f23651m.addView(this.f23616x, layoutParams3);
                            return;
                        }
                        return;
                    }
                }
                this.f23615w = oVar;
                this.f23615w.a(new a());
                this.f23615w.b(this.f23639a.au);
                this.f23615w.c(this.f23639a.Y);
                if (!TextUtils.isEmpty(this.f23639a.f23543s)) {
                }
                this.f23615w.b(this.f23641c.a(2008, -1, -1));
                this.f23651m.addView(this.f23615w, new RelativeLayout.LayoutParams(-1, -1));
                if (this.f23639a.aP == l.f24231e.intValue()) {
                    return;
                }
                return;
            }
        }
        List<Map<String, Object>> a17 = com.unionpay.mobile.android.nocard.views.xlistview.a.a(this.f23642d, this.f23639a.f23541q, true);
        b bVar5 = this.f23639a;
        if (bVar5.J && (bVar5.aP == num.intValue() || l.f24227a.intValue() == this.f23639a.aP)) {
            a17 = null;
        }
        oVar = o.a(this.f23642d, this.f23639a.f23544t, a17, a10, a11, j.a(this.f23639a.f23547w, "label"));
        this.f23615w = oVar;
        this.f23615w.a(new a());
        this.f23615w.b(this.f23639a.au);
        this.f23615w.c(this.f23639a.Y);
        if (!TextUtils.isEmpty(this.f23639a.f23543s)) {
        }
        this.f23615w.b(this.f23641c.a(2008, -1, -1));
        this.f23651m.addView(this.f23615w, new RelativeLayout.LayoutParams(-1, -1));
        if (this.f23639a.aP == l.f24231e.intValue()) {
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e(String str, String str2) {
        if (str2 != null && str2.length() > 0) {
            this.f23639a.I.f23866f = str2;
        }
        a(str, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        if (r0.size() <= 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r3.f23639a.aP == com.unionpay.mobile.android.views.order.l.f24231e.intValue()) goto L21;
     */
    @Override // com.unionpay.mobile.android.nocard.views.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k() {
        b bVar = this.f23639a;
        boolean z10 = bVar.aE;
        if (z10 || !bVar.J) {
            if (!z10) {
                int i10 = bVar.aP;
                Integer num = l.f24227a;
                if (i10 != num.intValue()) {
                    if (this.f23639a.aP == l.f24229c.intValue()) {
                        b bVar2 = this.f23639a;
                        if (bVar2.aC) {
                            List<com.unionpay.mobile.android.model.c> list = bVar2.f23541q;
                            if (list != null) {
                            }
                        }
                    }
                    super.k();
                    v();
                    this.f23639a.aP = num.intValue();
                    return;
                }
            }
            v();
            s();
            return;
        }
        super.k();
        v();
        this.f23639a.J = false;
    }

    @Override // com.unionpay.mobile.android.nocard.views.b, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (b.f23494bm && this.f23639a.aP == l.f24227a.intValue() && !"1".equalsIgnoreCase(this.f23639a.f23511an)) {
            k.c("spay", "out");
            b bVar = this.f23639a;
            d(bVar.f23525bp, bVar.f23526bq);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.unionpay.mobile.android.upviews.a aVar = this.f23614v;
        if (aVar != null) {
            aVar.clearFocus();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Handler handler;
        super.onDraw(canvas);
        if (!this.f23617y && (handler = this.f23618z) != null) {
            this.f23617y = true;
            handler.sendEmptyMessage(0);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s() {
        this.f23640b.a(new ar(this), new as(this));
        m mVar = this.f23640b;
        c cVar = c.bD;
        mVar.a(cVar.Y, cVar.av, cVar.W, cVar.X);
    }

    protected boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
    }
}
