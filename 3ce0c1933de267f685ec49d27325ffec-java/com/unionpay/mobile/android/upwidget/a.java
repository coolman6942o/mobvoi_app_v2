package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.services.core.AMapException;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f24020a;

    /* renamed from: b  reason: collision with root package name */
    private String f24021b;

    /* renamed from: c  reason: collision with root package name */
    private String f24022c;

    /* renamed from: d  reason: collision with root package name */
    private String f24023d;

    /* renamed from: e  reason: collision with root package name */
    private String f24024e;

    /* renamed from: f  reason: collision with root package name */
    private String f24025f;

    /* renamed from: g  reason: collision with root package name */
    private String f24026g;

    /* renamed from: h  reason: collision with root package name */
    private String f24027h;

    /* renamed from: i  reason: collision with root package name */
    private String f24028i;

    /* renamed from: j  reason: collision with root package name */
    private Button f24029j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24030k;

    /* renamed from: l  reason: collision with root package name */
    private Context f24031l;

    /* renamed from: m  reason: collision with root package name */
    private float f24032m;

    /* renamed from: n  reason: collision with root package name */
    private View.OnClickListener f24033n;

    /* renamed from: o  reason: collision with root package name */
    private String f24034o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f24035p;

    /* renamed from: q  reason: collision with root package name */
    private String f24036q;

    public a(Context context, JSONObject jSONObject, View.OnClickListener onClickListener, String str) {
        this(context, jSONObject, onClickListener, str, (byte) 0);
    }

    private a(Context context, JSONObject jSONObject, View.OnClickListener onClickListener, String str, byte b10) {
        super(context);
        this.f24020a = "";
        this.f24021b = "";
        this.f24022c = "";
        this.f24023d = "";
        this.f24024e = "";
        this.f24025f = "";
        this.f24026g = "";
        this.f24027h = "";
        this.f24028i = "";
        this.f24029j = null;
        this.f24030k = false;
        this.f24031l = null;
        this.f24032m = 0.0f;
        this.f24033n = new b(this);
        this.f24031l = context;
        this.f24032m = 16.0f;
        this.f24036q = str;
        this.f24020a = j.a(jSONObject, ContactConstant.CallsRecordKeys.NAME);
        this.f24021b = j.a(jSONObject, HealthDataProviderContracts.NAME_VALUE);
        this.f24022c = j.a(jSONObject, "label");
        this.f24023d = j.a(jSONObject, "href_label");
        this.f24024e = j.a(jSONObject, "href_url");
        this.f24025f = j.a(jSONObject, "href_title");
        this.f24026g = j.a(jSONObject, "checked");
        this.f24027h = j.a(jSONObject, "required");
        this.f24028i = j.a(jSONObject, "error_info");
        this.f24034o = j.a(jSONObject, "ckb_style");
        this.f24029j = new Button(this.f24031l);
        if (!a(this.f24026g) || !this.f24026g.equalsIgnoreCase("0")) {
            this.f24030k = false;
        } else {
            this.f24030k = true;
        }
        this.f24029j.setOnClickListener(this.f24033n);
        g();
        f();
        int a10 = g.a(this.f24031l, 20.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a10, a10);
        layoutParams.gravity = 16;
        addView(this.f24029j, layoutParams);
        if (a(this.f24022c)) {
            TextView textView = new TextView(this.f24031l);
            this.f24035p = textView;
            textView.setText(this.f24022c);
            this.f24035p.setTextSize(this.f24032m);
            this.f24035p.setTextColor(-16777216);
            this.f24035p.setOnClickListener(this.f24033n);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = com.unionpay.mobile.android.global.a.f23313d;
            addView(this.f24035p, layoutParams2);
        }
        if (a(this.f24023d) && a(this.f24024e)) {
            TextView textView2 = new TextView(this.f24031l);
            textView2.setText(Html.fromHtml(this.f24023d));
            textView2.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
            String.format("<u>%s</u>", this.f24023d);
            textView2.setTextSize(this.f24032m);
            textView2.setOnClickListener(onClickListener);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 16;
            addView(textView2, layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        aVar.f24030k = !aVar.f24030k;
        String[] strArr = o.f24165g;
        aVar.g();
    }

    private static boolean a(String str) {
        return str != null && str.length() > 0;
    }

    private boolean f() {
        return "small".equalsIgnoreCase(this.f24034o);
    }

    private void g() {
        if (this.f24029j != null) {
            int i10 = this.f24030k ? AMapException.CODE_AMAP_INVALID_USER_SCODE : AMapException.CODE_AMAP_INVALID_USER_DOMAIN;
            int a10 = f() ? g.a(this.f24031l, 15.0f) : com.unionpay.mobile.android.global.a.f23332w;
            this.f24029j.setBackgroundDrawable(c.a(this.f24031l).a(i10, a10, a10));
        }
    }

    public final String a() {
        return String.format("\"%s\":\"%s\"", this.f24020a, this.f24030k ? this.f24021b : "");
    }

    public final String b() {
        return this.f24028i;
    }

    public final String c() {
        return this.f24024e;
    }

    public final String d() {
        return this.f24025f;
    }

    public final boolean e() {
        if (!a(this.f24027h) || !this.f24027h.equalsIgnoreCase("0")) {
            return true;
        }
        return this.f24030k;
    }
}
