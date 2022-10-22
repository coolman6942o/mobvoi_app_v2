package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.widgets.as;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class bd extends b {

    /* renamed from: r  reason: collision with root package name */
    private TextView f23665r = null;

    /* renamed from: s  reason: collision with root package name */
    private View.OnClickListener f23666s = new be(this);

    /* renamed from: t  reason: collision with root package name */
    private a f23667t;

    /* loaded from: classes2.dex */
    public class a extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private Context f23669b;

        public a(Context context) {
            super(context);
            this.f23669b = context;
            setOrientation(1);
        }

        private void a(JSONArray jSONArray) {
            if (jSONArray != null && jSONArray.length() > 0) {
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                LinearLayout linearLayout = new LinearLayout(bd.this.f23642d);
                linearLayout.setOrientation(1);
                linearLayout.setBackgroundColor(-1);
                addView(linearLayout, layoutParams);
                ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, b.f23349n);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        String a10 = j.a(jSONObject, "label");
                        String a11 = j.a(jSONObject, "url");
                        LinearLayout linearLayout2 = new LinearLayout(bd.this.f23642d);
                        linearLayout2.setBackgroundColor(-3419943);
                        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 1);
                        if (i10 != 0) {
                            layoutParams3.leftMargin = g.a(bd.this.f23642d, 12.0f);
                        }
                        linearLayout.addView(linearLayout2, layoutParams3);
                        Context context = this.f23669b;
                        RelativeLayout relativeLayout = new RelativeLayout(this.f23669b);
                        relativeLayout.setBackgroundDrawable(bd.this.f23641c.a(2014, -1, -1));
                        relativeLayout.setOnClickListener(new bg(this, i10, a10, a11));
                        TextView textView = new TextView(context);
                        textView.setText(a10);
                        textView.setTextSize(b.f23346k);
                        textView.setTextColor(-13421773);
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams4.addRule(15, -1);
                        layoutParams4.addRule(9, -1);
                        layoutParams4.leftMargin = g.a(context, 12.0f);
                        relativeLayout.addView(textView, layoutParams4);
                        int a12 = g.a(context, 20.0f);
                        Drawable a13 = bd.this.f23641c.a(1002, -1, -1);
                        ImageView imageView = new ImageView(context);
                        imageView.setBackgroundDrawable(a13);
                        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(a12, a12);
                        layoutParams5.addRule(15, -1);
                        layoutParams5.addRule(11, -1);
                        layoutParams5.rightMargin = g.a(context, 12.0f);
                        relativeLayout.addView(imageView, layoutParams5);
                        linearLayout.addView(relativeLayout, layoutParams2);
                        if (i10 == jSONArray.length() - 1) {
                            LinearLayout linearLayout3 = new LinearLayout(bd.this.f23642d);
                            linearLayout3.setBackgroundColor(-3419943);
                            linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, 1));
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }

        public final void a(JSONObject jSONObject) {
            removeAllViews();
            String a10 = j.a(jSONObject, "label");
            if (b.b(a10)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.leftMargin = g.a(bd.this.f23642d, 12.0f);
                layoutParams.bottomMargin = com.unionpay.mobile.android.global.a.f23315f;
                TextView textView = new TextView(this.f23669b);
                textView.setText(a10);
                textView.setTextSize(b.f23346k);
                textView.setTextColor(-25009);
                addView(textView, layoutParams);
            }
            a(j.d(jSONObject, "options"));
        }
    }

    public bd(Context context) {
        super(context);
        e();
        this.f23655q = "result";
        com.unionpay.mobile.android.model.b bVar = this.f23639a;
        bVar.f23514aq = null;
        if (bVar.aV) {
            this.f23643e.c("bingopromotion", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f23639a.aQ);
        String sb3 = sb2.toString();
        k.c("functionEx", sb3);
        if (this.f23639a.aQ == l.f24228b.intValue() || this.f23639a.aQ == l.f24229c.intValue()) {
            PreferenceUtils.c(this.f23642d, sb3);
        }
        this.f23639a.I.f23866f = Constant.CASH_LOAD_SUCCESS;
        j();
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        JSONObject c10 = j.c(jSONObject, "luck_draw");
        if (c10 != null) {
            this.f23667t.setVisibility(0);
            this.f23667t.a(c10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ay ayVar = new ay(getContext(), this.f23639a.A, this);
        ayVar.a();
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void b(int i10) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void c() {
        this.f23651m.invalidate();
        UPScrollView uPScrollView = this.f23653o;
        if (uPScrollView != null) {
            uPScrollView.setBackgroundColor(-1052684);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.f23642d);
        relativeLayout.setBackgroundColor(-1052684);
        relativeLayout.setId(relativeLayout.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10, -1);
        layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23313d;
        this.f23651m.addView(relativeLayout, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f23642d);
        relativeLayout2.setId(relativeLayout2.hashCode());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f23313d;
        relativeLayout.addView(relativeLayout2, layoutParams2);
        int i10 = com.unionpay.mobile.android.global.a.f23323n;
        Drawable a10 = this.f23641c.a(2008, -1, -1);
        TextView textView = new TextView(this.f23642d);
        this.f23665r = textView;
        textView.setId(textView.hashCode());
        this.f23665r.setText(c.bD.E);
        this.f23665r.setTextSize(b.f23344i);
        this.f23665r.setTextColor(b.o());
        this.f23665r.setGravity(17);
        this.f23665r.setOnClickListener(this.f23666s);
        this.f23665r.setBackgroundDrawable(a10);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i10);
        int a11 = g.a(this.f23642d, 12.0f);
        layoutParams3.rightMargin = a11;
        layoutParams3.leftMargin = a11;
        layoutParams3.addRule(9, -1);
        layoutParams3.addRule(15, -1);
        relativeLayout2.addView(this.f23665r, layoutParams3);
        a aVar = new a(this.f23642d);
        this.f23667t = aVar;
        aVar.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(3, relativeLayout2.getId());
        layoutParams4.topMargin = g.a(this.f23642d, 20.0f);
        relativeLayout.addView(this.f23667t, layoutParams4);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void f() {
        SpannableString spannableString;
        String str;
        String str2;
        String[] split;
        int i10 = 2;
        if (this.f23639a.H != null) {
            LinearLayout linearLayout = new LinearLayout(this.f23642d);
            linearLayout.setOrientation(1);
            int a10 = g.a(this.f23642d, 10.0f);
            if (!TextUtils.isEmpty(this.f23639a.B)) {
                TextView textView = new TextView(this.f23642d);
                textView.setText(this.f23639a.B);
                textView.setTextSize(24.0f);
                textView.setTextColor(-15365480);
                textView.setGravity(1);
                textView.setPadding(0, com.unionpay.mobile.android.global.a.f23313d, 0, 0);
                textView.getPaint().setFakeBoldText(true);
                linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
                LinearLayout linearLayout2 = new LinearLayout(this.f23642d);
                linearLayout2.setOrientation(0);
                linearLayout2.setBackgroundColor(-6958338);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                int i11 = com.unionpay.mobile.android.global.a.f23313d;
                layoutParams.bottomMargin = i11;
                layoutParams.topMargin = i11;
                linearLayout.addView(linearLayout2, layoutParams);
                this.f23650l.addView(linearLayout);
            }
            JSONArray jSONArray = this.f23639a.H;
            if (jSONArray != null) {
                if (jSONArray.length() < 2) {
                    i10 = jSONArray.length();
                }
                LinearLayout a11 = bh.a(this.f23642d, jSONArray, 0, i10);
                a11.setBackgroundColor(0);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.rightMargin = a10;
                layoutParams2.leftMargin = a10;
                linearLayout.addView(a11, layoutParams2);
                LinearLayout a12 = bh.a(this.f23642d, jSONArray, i10, jSONArray.length());
                a12.setBackgroundColor(0);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.rightMargin = a10;
                layoutParams3.leftMargin = a10;
                this.f23650l.addView(a12, layoutParams3);
            }
            as asVar = new as(this.f23642d);
            asVar.setId(asVar.hashCode());
            this.f23650l.setOnClickListener(new bf(this));
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.bottomMargin = 0;
            this.f23650l.addView(asVar, layoutParams4);
            return;
        }
        int a13 = g.a(this.f23642d, 10.0f);
        LinearLayout linearLayout3 = new LinearLayout(this.f23642d);
        linearLayout3.setPadding(a13, a13, a13, a13);
        linearLayout3.setOrientation(1);
        linearLayout3.setBackgroundColor(-1);
        this.f23650l.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.f23642d);
        linearLayout4.setOrientation(0);
        linearLayout3.addView(linearLayout4);
        int a14 = g.a(this.f23642d, 25.0f);
        ImageView imageView = new ImageView(this.f23642d);
        imageView.setBackgroundDrawable(this.f23641c.a(1035, -1, -1));
        linearLayout4.addView(imageView, new LinearLayout.LayoutParams(a14, a14));
        LinearLayout linearLayout5 = new LinearLayout(this.f23642d);
        linearLayout5.setOrientation(1);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = a13;
        linearLayout4.addView(linearLayout5, layoutParams5);
        String str3 = this.f23639a.aR;
        if (!i.b(str3)) {
            int indexOf = str3.indexOf(60);
            String substring = -1 != indexOf ? str3.substring(0, indexOf) : null;
            int indexOf2 = str3.indexOf(62) + 1;
            String substring2 = -1 != indexOf2 ? str3.substring(indexOf2) : null;
            int i12 = indexOf + 1;
            int i13 = indexOf2 - 1;
            if (!(-1 == indexOf || i12 >= i13 || indexOf2 == -1)) {
                String substring3 = str3.substring(i12, i13);
                if (!i.b(substring3) && (split = substring3.split("#")) != null && split.length == 2) {
                    str = split[0];
                    str2 = split[1];
                    spannableString = i.a(substring, str, str2, substring2);
                }
            }
            str2 = null;
            str = null;
            spannableString = i.a(substring, str, str2, substring2);
        } else {
            spannableString = null;
        }
        if (spannableString != null) {
            TextView textView2 = new TextView(this.f23642d);
            textView2.setTextSize(20.0f);
            textView2.setText(spannableString);
            linearLayout5.addView(textView2);
        }
        if (b.b(this.f23639a.aS)) {
            TextView textView3 = new TextView(this.f23642d);
            textView3.setTextSize(b.f23347l);
            textView3.setText(this.f23639a.aS);
            textView3.setTextColor(-10066330);
            linearLayout5.addView(textView3);
        }
        if (b.b(this.f23639a.aT)) {
            TextView textView4 = new TextView(this.f23642d);
            textView4.setTextSize(b.f23347l);
            textView4.setTextColor(-10066330);
            textView4.setText(this.f23639a.aT);
            linearLayout5.addView(textView4);
        }
        int a15 = g.a(this.f23642d, 5.0f);
        LinearLayout linearLayout6 = new LinearLayout(this.f23642d);
        linearLayout6.setOrientation(1);
        linearLayout6.setBackgroundColor(-1052684);
        linearLayout6.setPadding(a15, a15, a15, a15);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.topMargin = g.a(this.f23642d, 10.0f);
        linearLayout3.addView(linearLayout6, layoutParams6);
        linearLayout6.setVisibility(8);
        if ("0".equals(this.f23639a.aW) && b.b(this.f23639a.aX)) {
            TextView textView5 = new TextView(this.f23642d);
            textView5.setTextSize(b.f23347l);
            textView5.setText(this.f23639a.aX);
            linearLayout6.addView(textView5);
            linearLayout6.setVisibility(0);
        }
        Drawable a16 = this.f23641c.a(1026, -1, -1);
        LinearLayout linearLayout7 = new LinearLayout(this.f23642d);
        if (a16 != null) {
            linearLayout7.setBackgroundDrawable(a16);
        }
        this.f23650l.addView(linearLayout7, new LinearLayout.LayoutParams(-1, g.a(this.f23642d, 2.0f)));
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    public final void k() {
        r();
    }
}
