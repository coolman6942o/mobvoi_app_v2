package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class ba extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f24344a;

    /* renamed from: b  reason: collision with root package name */
    private String f24345b;

    /* renamed from: c  reason: collision with root package name */
    private String f24346c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f24347d;

    /* renamed from: g  reason: collision with root package name */
    protected String f24350g;

    /* renamed from: h  reason: collision with root package name */
    protected String f24351h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f24352i;

    /* renamed from: j  reason: collision with root package name */
    protected String f24353j;

    /* renamed from: k  reason: collision with root package name */
    protected LinearLayout f24354k;

    /* renamed from: l  reason: collision with root package name */
    protected TextView f24355l;

    /* renamed from: n  reason: collision with root package name */
    protected JSONObject f24357n;

    /* renamed from: o  reason: collision with root package name */
    private String f24358o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f24359p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f24361r;

    /* renamed from: s  reason: collision with root package name */
    private String f24362s;

    /* renamed from: e  reason: collision with root package name */
    protected int f24348e = -16777216;

    /* renamed from: f  reason: collision with root package name */
    protected int f24349f = -7829368;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f24360q = null;

    /* renamed from: m  reason: collision with root package name */
    protected RelativeLayout f24356m = null;

    /* loaded from: classes2.dex */
    public interface a {
        String a();

        boolean b();

        boolean c();
    }

    public ba(Context context, JSONObject jSONObject, String str) {
        super(context);
        this.f24347d = null;
        this.f24344a = null;
        this.f24350g = null;
        this.f24345b = null;
        this.f24351h = null;
        this.f24346c = null;
        this.f24358o = null;
        this.f24352i = false;
        this.f24353j = null;
        this.f24359p = null;
        this.f24354k = null;
        this.f24355l = null;
        this.f24361r = false;
        this.f24362s = "uppay";
        this.f24357n = jSONObject;
        this.f24347d = context;
        this.f24351h = j.a(jSONObject, "label");
        this.f24358o = j.a(jSONObject, "placeholder");
        this.f24346c = j.a(jSONObject, "tip");
        this.f24344a = j.a(jSONObject, ContactConstant.CallsRecordKeys.NAME);
        this.f24350g = j.a(jSONObject, HealthDataProviderContracts.NAME_VALUE);
        this.f24345b = j.a(jSONObject, "type");
        this.f24353j = j.a(jSONObject, "regexp");
        String a10 = j.a(jSONObject, "readonly");
        if (a10 != null && a10.equalsIgnoreCase("true")) {
            this.f24352i = true;
        }
        this.f24361r = j.a(jSONObject, "margin").length() > 0;
        this.f24362s = str;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setBackgroundColor(0);
        setOrientation(1);
        setPadding(2, 2, 2, 2);
        if (!this.f24345b.equalsIgnoreCase("string")) {
            if (!a(this, this.f24351h)) {
                TextView textView = new TextView(this.f24347d);
                this.f24359p = textView;
                textView.setTextSize(20.0f);
                this.f24359p.setText("");
                this.f24359p.setTextColor(this.f24348e);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.leftMargin = com.unionpay.mobile.android.global.a.f23315f;
                addView(this.f24359p, layoutParams);
                String str2 = this.f24351h;
                if (!(str2 == null || str2.length() == 0)) {
                    this.f24359p.setText(this.f24351h);
                }
                this.f24359p.setVisibility(8);
            }
            g();
            if (!b_()) {
                LinearLayout linearLayout = new LinearLayout(this.f24347d);
                this.f24354k = linearLayout;
                linearLayout.setBackgroundColor(-267336);
                addView(this.f24354k, new LinearLayout.LayoutParams(-1, -2));
                TextView textView2 = new TextView(this.f24347d);
                this.f24355l = textView2;
                textView2.setTextSize(15.0f);
                this.f24355l.setTextColor(this.f24349f);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                int a11 = g.a(this.f24347d, 10.0f);
                layoutParams2.rightMargin = a11;
                layoutParams2.leftMargin = a11;
                int a12 = g.a(this.f24347d, 5.0f);
                layoutParams2.bottomMargin = a12;
                layoutParams2.topMargin = a12;
                this.f24354k.addView(this.f24355l, layoutParams2);
                String str3 = this.f24346c;
                if (str3 == null || str3.length() <= 0) {
                    this.f24354k.setVisibility(8);
                    this.f24360q.setVisibility(8);
                    return;
                }
                this.f24360q.setVisibility(0);
                this.f24355l.setText(this.f24346c);
                return;
            }
            return;
        }
        g();
    }

    private void g() {
        FrameLayout frameLayout = new FrameLayout(this.f24347d);
        addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        this.f24356m = new RelativeLayout(this.f24347d);
        frameLayout.addView(this.f24356m, new FrameLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.f24347d);
        this.f24360q = imageView;
        imageView.setBackgroundDrawable(c.a(this.f24347d).a(1038, -1, -1));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g.a(this.f24347d, 10.0f), g.a(this.f24347d, 5.0f));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = g.a(this.f24347d, 20.0f);
        this.f24360q.setVisibility(8);
        frameLayout.addView(this.f24360q, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f24359p != null && charSequence.length() > 0) {
            this.f24359p.setText(charSequence, bufferType);
        }
    }

    protected boolean a(LinearLayout linearLayout, String str) {
        return false;
    }

    public boolean a(String str) {
        return str == null || str.length() == 0;
    }

    protected boolean b_() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(String str) {
        if (this.f24355l != null && str != null && str.length() > 0) {
            this.f24355l.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return "_input_method";
    }

    public boolean f() {
        return true;
    }

    public String i() {
        return this.f24350g;
    }

    public String n() {
        return this.f24344a;
    }

    public String o() {
        return this.f24345b;
    }

    public final String p() {
        return this.f24351h;
    }

    public final String q() {
        return this.f24346c;
    }

    public String r() {
        return this.f24358o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String s() {
        return this.f24362s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t() {
        TextView textView = this.f24359p;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u() {
        TextView textView = this.f24355l;
        if (textView != null) {
            textView.setVisibility(0);
            this.f24360q.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v() {
        TextView textView = this.f24359p;
        if (textView != null) {
            textView.setTextSize(16.0f);
        }
    }
}
