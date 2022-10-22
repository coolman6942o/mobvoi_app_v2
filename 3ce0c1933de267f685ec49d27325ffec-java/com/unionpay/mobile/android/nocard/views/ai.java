package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ai extends b {

    /* renamed from: r  reason: collision with root package name */
    private TextView f23597r = null;

    /* renamed from: s  reason: collision with root package name */
    private View.OnClickListener f23598s = new aj(this);

    public ai(Context context) {
        super(context);
        this.f23644f = 11;
        this.f23649k = a();
        b();
        super.d();
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.f23639a.I.f23866f = Constant.CASH_LOAD_SUCCESS;
        j();
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        i();
        this.f23639a.T = j.d(jSONObject, "open_rules");
        JSONArray jSONArray = this.f23639a.T;
        if (jSONArray == null || jSONArray.length() <= 0) {
            b(2);
        } else {
            d(10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ay ayVar = new ay(getContext(), this.f23639a.A, this);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void c() {
        int i10 = a.f23313d;
        LinearLayout linearLayout = new LinearLayout(this.f23642d);
        linearLayout.setBackgroundColor(-1114114);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, i10, 0, i10);
        linearLayout.setId(linearLayout.hashCode());
        TextView textView = new TextView(this.f23642d);
        textView.setText(this.f23639a.B);
        textView.setTextSize(24.0f);
        textView.setTextColor(-15365480);
        textView.setGravity(1);
        textView.getPaint().setFakeBoldText(true);
        linearLayout.addView(textView);
        LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
        linearLayout2.setOrientation(0);
        linearLayout2.setBackgroundColor(-6958338);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 2);
        layoutParams.addRule(14, -1);
        int i11 = a.f23313d;
        layoutParams.bottomMargin = i11;
        layoutParams.topMargin = i11;
        linearLayout.addView(linearLayout2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(10, -1);
        this.f23651m.addView(linearLayout, layoutParams2);
        LinearLayout linearLayout3 = new LinearLayout(this.f23642d);
        linearLayout3.setPadding(i10, i10, i10, i10);
        linearLayout3.setOrientation(1);
        linearLayout3.setId(linearLayout3.hashCode());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(3, linearLayout.getId());
        this.f23651m.addView(linearLayout3, layoutParams3);
        TextView textView2 = new TextView(this.f23642d);
        textView2.setTextSize(18.0f);
        textView2.setText(this.f23639a.S);
        textView2.setTextColor(-10066330);
        textView2.setGravity(3);
        linearLayout3.addView(textView2, new RelativeLayout.LayoutParams(-1, -2));
        TextView textView3 = new TextView(this.f23642d);
        this.f23597r = textView3;
        textView3.setText(c.bD.E);
        this.f23597r.setTextSize(22.0f);
        this.f23597r.setTextColor(h.a(-1, -730710, -730710, -6745));
        this.f23597r.setGravity(17);
        this.f23597r.setOnClickListener(this.f23598s);
        int i12 = a.f23323n;
        this.f23597r.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, i12);
        layoutParams4.addRule(3, linearLayout3.getId());
        layoutParams4.addRule(12, -1);
        int i13 = a.f23311b;
        layoutParams4.bottomMargin = i13;
        layoutParams4.topMargin = i13;
        int i14 = a.f23313d;
        layoutParams4.rightMargin = i14;
        layoutParams4.leftMargin = i14;
        this.f23651m.addView(this.f23597r, layoutParams4);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        r();
    }
}
