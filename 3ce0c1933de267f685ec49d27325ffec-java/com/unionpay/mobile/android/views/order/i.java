package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.g;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class i extends AbstractMethod {

    /* renamed from: g  reason: collision with root package name */
    private JSONObject f24219g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f24220h;

    /* renamed from: i  reason: collision with root package name */
    private a f24221i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f24222j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f24223k;

    /* renamed from: l  reason: collision with root package name */
    private RelativeLayout f24224l;

    public i(Context context) {
        super(context);
    }

    private static JSONArray e(String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("label", "");
            jSONObject.put(ContactConstant.CallsRecordKeys.NAME, "user_name");
            if (!AbstractMethod.a(str)) {
                jSONObject.put(HealthDataProviderContracts.NAME_VALUE, str);
            }
            jSONObject.put("regexp", "[.@_A-Za-z0-9]{1,64}");
            jSONObject.put("type", "user_name");
            jSONObject.put("tip", "");
            jSONObject.put("placeholder", c.bD.bw);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("label", "");
            jSONObject2.put(ContactConstant.CallsRecordKeys.NAME, "password");
            jSONObject2.put("type", "password");
            jSONObject2.put("placeholder", c.bD.bx);
            jSONArray.put(jSONObject2);
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    public final i a(JSONObject jSONObject) {
        this.f24219g = jSONObject;
        if (this.f24222j != null) {
            String a10 = AbstractMethod.a(jSONObject, "label");
            if (!TextUtils.isEmpty(a10)) {
                this.f24222j.setText(Html.fromHtml(a10));
                RelativeLayout relativeLayout = this.f24224l;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }
        }
        return this;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final void a(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f24170b);
        textView.setText(this.f24171c);
        textView.setTextColor(-13421773);
        textView.setTextSize(b.f23346k);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = g.a(this.f24170b, 10.0f);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final int b() {
        return l.f24229c.intValue();
    }

    public final i b(String str) {
        this.f24171c = str;
        return this;
    }

    public final i b(JSONObject jSONObject) {
        this.f24220h = jSONObject;
        if (this.f24223k != null) {
            String a10 = AbstractMethod.a(jSONObject, "label");
            if (!TextUtils.isEmpty(a10)) {
                this.f24223k.setText(Html.fromHtml(a10));
                RelativeLayout relativeLayout = this.f24224l;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
            }
        }
        return this;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final void b(RelativeLayout relativeLayout) {
        Context context = this.f24170b;
        this.f24221i = new a(context, e(PreferenceUtils.c(context)), this, "");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        relativeLayout.addView(this.f24221i, layoutParams);
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final a.C0266a c() {
        a aVar = this.f24221i;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final void c(RelativeLayout relativeLayout) {
        String a10 = AbstractMethod.a(this.f24219g, "label");
        TextView textView = new TextView(this.f24170b);
        this.f24222j = textView;
        AbstractMethod.a(textView);
        if (!TextUtils.isEmpty(a10)) {
            this.f24222j.setText(Html.fromHtml(a10));
        }
        this.f24222j.setOnClickListener(new j(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = g.a(this.f24170b, 10.0f);
        relativeLayout.addView(this.f24222j, layoutParams);
        String a11 = AbstractMethod.a(this.f24220h, "label");
        TextView textView2 = new TextView(this.f24170b);
        this.f24223k = textView2;
        AbstractMethod.a(textView2);
        if (!TextUtils.isEmpty(a11)) {
            this.f24223k.setText(Html.fromHtml(a11));
        }
        this.f24223k.setOnClickListener(new k(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.rightMargin = g.a(this.f24170b, 10.0f);
        relativeLayout.addView(this.f24223k, layoutParams2);
        if (TextUtils.isEmpty(a11) && TextUtils.isEmpty(a10)) {
            relativeLayout.setVisibility(8);
        }
        this.f24224l = relativeLayout;
    }

    public final i d(String str) {
        this.f24172d = str;
        return this;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final String e() {
        return this.f24172d;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final boolean f() {
        a aVar = this.f24221i;
        return aVar == null || aVar.e();
    }

    public final String h() {
        a aVar = this.f24221i;
        return aVar != null ? aVar.b("user_name") : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextUtils.isEmpty(h());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f24221i;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }
}
