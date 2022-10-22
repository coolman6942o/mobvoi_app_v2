package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.data.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ad extends z {

    /* renamed from: a  reason: collision with root package name */
    private int f24281a;

    /* renamed from: b  reason: collision with root package name */
    private String f24282b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f24283c;

    /* renamed from: o  reason: collision with root package name */
    private TextView f24284o;

    public ad(Context context, int i10, JSONObject jSONObject, String str) {
        this(context, i10, jSONObject, str, (byte) 0);
    }

    private ad(Context context, int i10, JSONObject jSONObject, String str, byte b10) {
        super(context, jSONObject, str);
        this.f24281a = 0;
        this.f24281a = i10;
        if (jSONObject != null) {
            this.f24282b = j.a(jSONObject, "style");
        }
        RelativeLayout relativeLayout = this.f24356m;
        LinearLayout linearLayout = new LinearLayout(this.f24347d);
        relativeLayout.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.f24347d);
        this.f24283c = textView;
        textView.setTextSize(b.f23346k);
        this.f24283c.setText(p());
        this.f24283c.setGravity(3);
        this.f24283c.setTextColor(-13421773);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 0.3f);
        layoutParams.gravity = 3;
        linearLayout.addView(this.f24283c, layoutParams);
        TextView textView2 = new TextView(this.f24347d);
        this.f24284o = textView2;
        textView2.setGravity(16);
        this.f24284o.setTextSize(b.f23346k);
        this.f24284o.setText(a.a(i(), this.f24282b));
        this.f24284o.setPadding(0, 0, com.unionpay.mobile.android.global.a.f23316g, 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 0.7f);
        layoutParams2.gravity = 21;
        linearLayout.addView(this.f24284o, layoutParams2);
    }

    public ad(Context context, JSONObject jSONObject, String str) {
        super(context, jSONObject, str);
        this.f24281a = 0;
        String p10 = p();
        if (p10 != null && p10.length() > 0) {
            TextView textView = new TextView(this.f24347d);
            this.f24283c = textView;
            textView.setTextSize(b.f23346k);
            this.f24283c.setText(p());
            this.f24283c.setTextColor(-7829368);
            addView(this.f24283c);
        }
        String i10 = i();
        if (i10 != null && i10.length() > 0) {
            TextView textView2 = new TextView(this.f24347d);
            this.f24284o = textView2;
            textView2.setTextSize(b.f23346k);
            this.f24284o.setTextColor(-7829368);
            this.f24284o.setText(i());
            addView(this.f24284o);
        }
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        return null;
    }

    public final void a(float f10) {
        this.f24284o.setTextSize(f10);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean c() {
        return true;
    }

    public final void g() {
        this.f24284o.setTextColor(-6710887);
    }
}
