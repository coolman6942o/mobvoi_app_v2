package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upwidget.j;
import com.unionpay.mobile.android.upwidget.q;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class aj extends z {
    private a D;

    /* renamed from: a  reason: collision with root package name */
    private final View.OnClickListener f24299a;

    /* renamed from: b  reason: collision with root package name */
    private final View.OnClickListener f24300b;

    /* renamed from: c  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f24301c;

    /* renamed from: p  reason: collision with root package name */
    private PopupWindow f24303p;

    /* renamed from: q  reason: collision with root package name */
    private j f24304q;

    /* renamed from: s  reason: collision with root package name */
    private int f24306s;

    /* renamed from: v  reason: collision with root package name */
    private TextView f24309v;

    /* renamed from: w  reason: collision with root package name */
    private q f24310w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f24311x;

    /* renamed from: y  reason: collision with root package name */
    private String f24312y;

    /* renamed from: z  reason: collision with root package name */
    private RelativeLayout f24313z;

    /* renamed from: t  reason: collision with root package name */
    private JSONArray f24307t = null;

    /* renamed from: u  reason: collision with root package name */
    private JSONArray f24308u = null;
    private String A = "";
    private boolean B = true;
    private String C = "";

    /* renamed from: r  reason: collision with root package name */
    private int f24305r = 0;

    /* renamed from: o  reason: collision with root package name */
    private JSONArray f24302o = com.unionpay.mobile.android.utils.j.d(this.f24357n, "items");

    /* loaded from: classes2.dex */
    public interface a {
        void g();
    }

    public aj(Context context, JSONObject jSONObject, String str, a aVar) {
        super(context, jSONObject, str);
        ak akVar = new ak(this);
        this.f24299a = akVar;
        al alVar = new al(this);
        this.f24300b = alVar;
        am amVar = new am(this);
        this.f24301c = amVar;
        this.f24306s = 0;
        boolean z10 = true;
        this.D = null;
        this.D = aVar;
        String a10 = com.unionpay.mobile.android.utils.j.a(jSONObject, "label");
        this.f24312y = a10;
        if (a(a10)) {
            this.f24312y = c.bD.f23450bg;
        }
        if (!TextUtils.isEmpty(com.unionpay.mobile.android.utils.j.a(jSONObject, "default_item_idx"))) {
            this.f24306s = Integer.parseInt(com.unionpay.mobile.android.utils.j.a(jSONObject, "default_item_idx"));
        }
        j jVar = new j(context, this.f24302o, this.f24306s, str);
        this.f24304q = jVar;
        jVar.a(amVar);
        this.f24304q.a(akVar);
        this.f24304q.d(alVar);
        RelativeLayout relativeLayout = this.f24356m;
        Drawable a11 = com.unionpay.mobile.android.resource.c.a(this.f24347d).a(2014, -1, -1);
        LinearLayout linearLayout = new LinearLayout(this.f24347d);
        linearLayout.setId(linearLayout.hashCode());
        linearLayout.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 1);
        com.unionpay.mobile.android.utils.j.a(this.f24357n, "type");
        relativeLayout.addView(linearLayout, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f24347d);
        this.f24313z = relativeLayout2;
        relativeLayout2.setId(relativeLayout2.hashCode());
        this.f24313z.setBackgroundDrawable(a11);
        this.f24313z.setOnClickListener(new an(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.f23323n);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(3, linearLayout.getId());
        relativeLayout.addView(this.f24313z, layoutParams2);
        ImageView imageView = new ImageView(this.f24347d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.f24347d).a(1002, -1, -1));
        int a12 = g.a(this.f24347d, 15.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a12, a12);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.rightMargin = g.a(this.f24347d, 10.0f);
        this.f24313z.addView(imageView, layoutParams3);
        TextView textView = new TextView(this.f24347d);
        this.f24309v = textView;
        textView.setTextSize(b.f23346k);
        this.f24309v.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f24309v.setSingleLine(true);
        this.f24309v.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(9, -1);
        layoutParams4.addRule(0, imageView.getId());
        int a13 = g.a(this.f24347d, 10.0f);
        layoutParams4.leftMargin = a13;
        layoutParams4.rightMargin = a13;
        this.f24313z.addView(this.f24309v, layoutParams4);
        LinearLayout linearLayout2 = new LinearLayout(this.f24347d);
        linearLayout2.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams5.bottomMargin = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams5.addRule(3, this.f24313z.getId());
        relativeLayout.addView(linearLayout2, layoutParams5);
        q qVar = this.f24310w;
        a(qVar != null ? qVar.b() : z10);
        a(this.f24306s, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(int i10, int i11, String str) {
        Object b10 = com.unionpay.mobile.android.utils.j.b(this.f24302o, i10);
        if (b10 != null) {
            JSONObject jSONObject = (JSONObject) b10;
            String a10 = com.unionpay.mobile.android.utils.j.a(jSONObject, "type");
            Object b11 = com.unionpay.mobile.android.utils.j.b("coupon".equals(a10) ? this.f24307t : "point".equals(a10) ? this.f24308u : com.unionpay.mobile.android.utils.j.d(jSONObject, "options"), i11);
            if (b11 != null) {
                return com.unionpay.mobile.android.utils.j.a((JSONObject) b11, str);
            }
        }
        return "";
    }

    private static JSONObject a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", str);
            jSONObject.put("label", str2);
            jSONObject.put("checked", str3);
            jSONObject.put("ckb_style", "small");
            jSONObject.put("required", "0");
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, int i11) {
        this.f24306s = i10;
        this.f24305r = i11;
        TextView textView = this.f24309v;
        if (textView != null) {
            textView.setText(a(i10, i11, "label"));
        }
        String a10 = a(i10, i11, "rel_label");
        String a11 = a(i10, i11, "rel_value");
        String a12 = a(i10, i11, "rel_value_style");
        this.C = a11;
        if (!this.B) {
            this.D.g();
        }
        int i12 = 0;
        this.B = false;
        this.A = a(i10, i11, HealthDataProviderContracts.NAME_VALUE);
        if (!a(a10) || !a(a11)) {
            if (com.unionpay.mobile.android.data.a.a(a12)) {
                int parseColor = Color.parseColor(a12);
                a12 = Integer.toString(parseColor, 16);
            }
            String str = "#ff" + a12;
            TextView textView2 = this.f24311x;
            int parseColor2 = Color.parseColor(str);
            int length = a10.length();
            int length2 = TextUtils.isEmpty(a11) ? 0 : a11.length();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a10 + a11);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-13421773);
            ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(parseColor2);
            spannableStringBuilder.setSpan(foregroundColorSpan, 0, length, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan2, length, length2 + length, 18);
            textView2.setText(spannableStringBuilder);
            q qVar = this.f24310w;
            if (!(qVar != null ? qVar.b() : true)) {
                i12 = 8;
            }
            this.f24311x.setVisibility(i12);
            return;
        }
        this.f24311x.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(aj ajVar, View view) {
        if (ajVar.f24303p == null) {
            ajVar.f24303p = new PopupWindow((View) ajVar.f24304q, -1, -1, true);
            ajVar.f24303p.setBackgroundDrawable(new ColorDrawable(-1342177280));
            ajVar.f24303p.update();
        }
        ajVar.f24303p.showAtLocation(view, 80, 0, 0);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        String a10 = a(this.f24306s, this.f24305r, HealthDataProviderContracts.NAME_VALUE);
        if (a10 != null) {
            a10 = a10.replace("\"", "\\\"");
        }
        q qVar = this.f24310w;
        if (qVar != null && !qVar.b()) {
            a10 = null;
        }
        k.c("uppay", n() + " : " + a10);
        return a10;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f24304q.b(this.f24299a);
        this.f24304q.b(onClickListener);
    }

    public final void a(q.a aVar) {
        q qVar = this.f24310w;
        if (qVar != null) {
            qVar.a(aVar);
        }
    }

    public final void a(JSONArray jSONArray) {
        this.f24307t = jSONArray;
        this.f24304q.a(jSONArray);
    }

    public final void a(JSONArray jSONArray, String str) {
        this.f24308u = jSONArray;
        this.f24304q.a(jSONArray, str);
    }

    public final void a(boolean z10) {
        this.A = !z10 ? "" : a(this.f24306s, this.f24305r, HealthDataProviderContracts.NAME_VALUE);
        q qVar = this.f24310w;
        if (qVar != null) {
            qVar.a(z10);
        }
        int i10 = z10 ? 0 : 8;
        this.f24356m.setVisibility(i10);
        TextView textView = this.f24311x;
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(textView.getText().toString())) {
            this.f24311x.setVisibility(8);
        } else {
            this.f24311x.setVisibility(i10);
        }
    }

    @Override // com.unionpay.mobile.android.widgets.ba
    protected final boolean a(LinearLayout linearLayout, String str) {
        if (a(str)) {
            return true;
        }
        LinearLayout linearLayout2 = new LinearLayout(this.f24347d);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.f23323n));
        JSONObject a10 = a(com.unionpay.mobile.android.utils.j.a(this.f24357n, "type"), str, com.unionpay.mobile.android.utils.j.a(this.f24357n, "checked"));
        Context context = this.f24347d;
        q qVar = new q(context, a10, s() + "_agree_reduce_activity");
        this.f24310w = qVar;
        qVar.a();
        this.f24310w.a(b.f23346k);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.f23323n);
        layoutParams.gravity = 16;
        int a11 = g.a(this.f24347d, 10.0f);
        layoutParams.rightMargin = a11;
        layoutParams.leftMargin = a11;
        linearLayout2.addView(this.f24310w, layoutParams);
        return true;
    }

    public final void b(View.OnClickListener onClickListener) {
        this.f24304q.e(onClickListener);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.ba
    protected final boolean b_() {
        this.f24311x = new TextView(this.f24347d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = g.a(this.f24347d, 10.0f);
        int a10 = g.a(this.f24347d, 5.0f);
        layoutParams.bottomMargin = a10;
        layoutParams.topMargin = a10;
        this.f24311x.setTextSize(b.f23346k);
        addView(this.f24311x, layoutParams);
        this.f24311x.setVisibility(8);
        return true;
    }

    public final void c(View.OnClickListener onClickListener) {
        this.f24304q.c(onClickListener);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_select_reduce_activity";
    }

    @Override // com.unionpay.mobile.android.widgets.z, com.unionpay.mobile.android.widgets.ba
    public final boolean f() {
        String a10 = a(this.f24306s, this.f24305r, "available");
        return TextUtils.isEmpty(a10) || !"1".equals(a10);
    }

    public final String g() {
        return this.A;
    }
}
