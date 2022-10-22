package com.unionpay.mobile.android.widgets;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upwidget.e;
import com.unionpay.mobile.android.upwidget.q;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class p extends z {

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f24432o;

    /* renamed from: p  reason: collision with root package name */
    private AlertDialog f24433p;

    /* renamed from: q  reason: collision with root package name */
    private PopupWindow f24434q;

    /* renamed from: r  reason: collision with root package name */
    private e f24435r;

    /* renamed from: t  reason: collision with root package name */
    private TextView f24437t;

    /* renamed from: u  reason: collision with root package name */
    private q f24438u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f24439v;

    /* renamed from: w  reason: collision with root package name */
    private String f24440w;

    /* renamed from: x  reason: collision with root package name */
    private RelativeLayout f24441x;

    /* renamed from: a  reason: collision with root package name */
    private final View.OnClickListener f24429a = new q(this);

    /* renamed from: b  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f24430b = new r(this);

    /* renamed from: y  reason: collision with root package name */
    private boolean f24442y = false;

    /* renamed from: z  reason: collision with root package name */
    private boolean f24443z = true;

    /* renamed from: s  reason: collision with root package name */
    private int f24436s = 1;

    /* renamed from: c  reason: collision with root package name */
    private JSONArray f24431c = j.d(this.f24357n, "new_instalments");

    public p(Context context, JSONObject jSONObject, String str) {
        super(context, jSONObject, str);
        String a10 = j.a(jSONObject, "label");
        this.f24440w = a10;
        if (a(a10)) {
            this.f24440w = c.bD.f23450bg;
        }
        this.f24432o = b(this.f24431c);
        this.f24435r = new e(this.f24347d, this.f24432o, "");
        a(this.f24356m);
    }

    private String a(int i10, String str) {
        Object b10 = j.b(this.f24431c, i10);
        return b10 != null ? j.a((JSONObject) b10, str) : "";
    }

    private JSONObject a(String str, String str2, String str3) {
        JSONObject c10;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", str);
            jSONObject.put("label", str2);
            jSONObject.put("checked", str3);
            jSONObject.put("ckb_style", "small");
            jSONObject.put("required", "0");
            if ("instalment".equals(str) && (c10 = j.c(this.f24357n, "url")) != null) {
                jSONObject.put("href_label", j.a(c10, "label"));
                jSONObject.put("href_url", j.a(c10, "href"));
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        this.f24436s = i10;
        int a10 = i10 - this.f24435r.a();
        this.f24435r.a(this.f24436s);
        TextView textView = this.f24437t;
        if (textView != null) {
            textView.setText(a(a10, "label"));
        }
    }

    private void a(RelativeLayout relativeLayout) {
        Drawable a10 = com.unionpay.mobile.android.resource.c.a(this.f24347d).a(2014, -1, -1);
        LinearLayout linearLayout = new LinearLayout(this.f24347d);
        linearLayout.setId(linearLayout.hashCode());
        linearLayout.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 1);
        String a11 = j.a(this.f24357n, "type");
        if ("instalment".equals(a11)) {
            layoutParams.leftMargin = g.a(this.f24347d, 10.0f);
        }
        relativeLayout.addView(linearLayout, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f24347d);
        this.f24441x = relativeLayout2;
        relativeLayout2.setId(relativeLayout2.hashCode());
        this.f24441x.setBackgroundDrawable(a10);
        this.f24441x.setOnClickListener(new s(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, a.f23323n);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(3, linearLayout.getId());
        relativeLayout.addView(this.f24441x, layoutParams2);
        ImageView imageView = new ImageView(this.f24347d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.f24347d).a(1002, -1, -1));
        int a12 = g.a(this.f24347d, 15.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a12, a12);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        layoutParams3.rightMargin = g.a(this.f24347d, 10.0f);
        this.f24441x.addView(imageView, layoutParams3);
        TextView textView = new TextView(this.f24347d);
        this.f24437t = textView;
        textView.setTextSize(b.f23346k);
        this.f24437t.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f24437t.setSingleLine(true);
        this.f24437t.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(9, -1);
        layoutParams4.addRule(0, imageView.getId());
        int a13 = g.a(this.f24347d, 10.0f);
        layoutParams4.leftMargin = a13;
        layoutParams4.rightMargin = a13;
        this.f24441x.addView(this.f24437t, layoutParams4);
        if (!"instalment".equals(a11)) {
            LinearLayout linearLayout2 = new LinearLayout(this.f24347d);
            linearLayout2.setBackgroundColor(-3419943);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, 1);
            layoutParams5.bottomMargin = a.f23315f;
            layoutParams5.addRule(3, this.f24441x.getId());
            relativeLayout.addView(linearLayout2, layoutParams5);
        }
        b(g());
        a(this.f24435r.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Dialog b(p pVar) {
        if (pVar.f24433p == null || pVar.f24443z) {
            pVar.f24443z = false;
            AlertDialog create = new AlertDialog.Builder(pVar.f24347d).setInverseBackgroundForced(false).create();
            pVar.f24433p = create;
            LinearLayout linearLayout = new LinearLayout(pVar.f24347d);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            int a10 = g.a(pVar.f24347d, 1.0f);
            RelativeLayout relativeLayout = new RelativeLayout(pVar.f24347d);
            int i10 = b.f23342g;
            relativeLayout.setPadding(i10, i10, i10, i10);
            linearLayout.addView(relativeLayout);
            LinearLayout linearLayout2 = new LinearLayout(pVar.f24347d);
            linearLayout2.setBackgroundColor(-3419943);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, 1));
            TextView textView = new TextView(pVar.f24347d);
            textView.setText(pVar.f24440w);
            textView.setTextSize(b.f23344i);
            textView.setTextColor(-13421773);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            relativeLayout.addView(textView, layoutParams);
            relativeLayout.setBackgroundColor(-986892);
            new LinearLayout.LayoutParams(-1, -2);
            ListView listView = new ListView(pVar.f24347d);
            listView.setDivider(null);
            listView.setAdapter((ListAdapter) pVar.f24435r);
            listView.setDividerHeight(a10);
            listView.setOnItemClickListener(new t(pVar));
            new LinearLayout.LayoutParams(-1, -2);
            linearLayout.addView(listView);
            create.setView(linearLayout, -1, -1, -1, -1);
            pVar.f24433p.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        return pVar.f24433p;
    }

    private List<Map<String, Object>> b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            HashMap hashMap = new HashMap();
            hashMap.put("label", a(i10, "label"));
            hashMap.put("style", a(i10, "rel_value_style"));
            String[] split = a(i10, "rel_value").split("\\|");
            ArrayList arrayList2 = new ArrayList(split.length);
            ArrayList arrayList3 = new ArrayList(split.length);
            for (String str : split) {
                String[] split2 = str.split(":");
                arrayList2.add(split2[0]);
                arrayList3.add(split2[1]);
            }
            hashMap.put("keys", arrayList2);
            hashMap.put("values", arrayList3);
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        String a10 = a(this.f24436s - this.f24435r.a(), HealthDataProviderContracts.NAME_VALUE);
        q qVar = this.f24438u;
        if (qVar != null && !qVar.b()) {
            a10 = null;
        }
        k.c("uppay", n() + " : " + a10);
        return a10;
    }

    public final void a(q.a aVar) {
        this.f24438u.a(aVar);
    }

    public final void a(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            this.f24443z = true;
            this.f24431c = jSONArray;
            this.f24432o = b(jSONArray);
            this.f24435r = new e(this.f24347d, this.f24432o, "");
            a(this.f24356m);
        }
    }

    public final void a(boolean z10) {
        this.f24442y = z10;
    }

    @Override // com.unionpay.mobile.android.widgets.ba
    protected final boolean a(LinearLayout linearLayout, String str) {
        if (a(str)) {
            return true;
        }
        LinearLayout linearLayout2 = new LinearLayout(this.f24347d);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, a.f23323n));
        String a10 = j.a(this.f24357n, "type");
        if ("instalment".equals(a10)) {
            LinearLayout linearLayout3 = new LinearLayout(this.f24347d);
            linearLayout3.setId(linearLayout3.hashCode());
            linearLayout3.setBackgroundColor(-3419943);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.leftMargin = g.a(this.f24347d, 10.0f);
            linearLayout2.addView(linearLayout3, layoutParams);
        }
        JSONObject a11 = a(a10, str, j.a(this.f24357n, "checked"));
        Context context = this.f24347d;
        q qVar = new q(context, a11, s() + "_agree_installment");
        this.f24438u = qVar;
        qVar.a();
        this.f24438u.a(b.f23346k);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a.f23323n);
        layoutParams2.gravity = 16;
        int a12 = g.a(this.f24347d, 10.0f);
        layoutParams2.rightMargin = a12;
        layoutParams2.leftMargin = a12;
        linearLayout2.addView(this.f24438u, layoutParams2);
        return true;
    }

    public final void b(boolean z10) {
        this.f24438u.a(z10);
        if (!z10) {
            this.f24442y = z10;
        }
        int i10 = (!this.f24442y || !z10) ? 8 : 0;
        this.f24356m.setVisibility(i10);
        TextView textView = this.f24439v;
        if (textView == null) {
            return;
        }
        if (TextUtils.isEmpty(textView.getText().toString())) {
            this.f24439v.setVisibility(8);
        } else {
            this.f24439v.setVisibility(i10);
        }
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.ba
    protected final boolean b_() {
        this.f24439v = new TextView(this.f24347d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = g.a(this.f24347d, 10.0f);
        int a10 = g.a(this.f24347d, 5.0f);
        layoutParams.bottomMargin = a10;
        layoutParams.topMargin = a10;
        this.f24439v.setTextSize(b.f23346k);
        addView(this.f24439v, layoutParams);
        this.f24439v.setVisibility(8);
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_select_installment";
    }

    @Override // com.unionpay.mobile.android.widgets.z, com.unionpay.mobile.android.widgets.ba
    public final boolean f() {
        String a10 = a(this.f24436s - this.f24435r.a(), "available");
        return TextUtils.isEmpty(a10) || !"1".equals(a10);
    }

    public final boolean g() {
        q qVar = this.f24438u;
        if (qVar != null) {
            return qVar.b();
        }
        return true;
    }
}
