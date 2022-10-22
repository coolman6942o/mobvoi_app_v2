package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.w;
import com.unionpay.mobile.android.widgets.ay;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class af extends b implements a.b {

    /* renamed from: s  reason: collision with root package name */
    private View.OnClickListener f23591s;

    /* renamed from: r  reason: collision with root package name */
    private TextView f23590r = null;

    /* renamed from: t  reason: collision with root package name */
    private a f23592t = null;

    /* renamed from: u  reason: collision with root package name */
    private int f23593u = 0;

    public af(Context context) {
        super(context);
        this.f23591s = null;
        this.f23644f = 12;
        this.f23591s = new ag(this);
        setBackgroundColor(-1052684);
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(af afVar) {
        afVar.f23593u = 1;
        a.C0266a b10 = afVar.f23592t.b();
        if (b10.a()) {
            afVar.f23648j = false;
            afVar.f23640b.a(c.bD.U);
            afVar.f23643e.m(b10.f23995b);
            return;
        }
        afVar.a(b10.f23995b);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
    }

    @Override // com.unionpay.mobile.android.nocard.views.a
    public final void a(JSONObject jSONObject) {
        if (this.f23593u == 1) {
            this.f23640b.c();
            f.c(this.f23639a, jSONObject);
            int b10 = f.b(this.f23639a, jSONObject);
            if (b10 != 0) {
                b(b10);
                return;
            }
            a aVar = this.f23592t;
            if (aVar != null) {
                aVar.f();
            }
            d(13);
        }
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        TextView textView = this.f23590r;
        if (textView != null) {
            textView.setEnabled(!z10);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        ay ayVar = new ay(this.f23642d, c.bD.f23471m, this);
        layoutParams.addRule(13, -1);
        this.f23649k.addView(ayVar, layoutParams);
    }

    @Override // com.unionpay.mobile.android.nocard.views.b
    protected final void c() {
        this.f23653o.a(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10, -1);
        layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        a aVar = new a(this.f23642d, this.f23639a.X, this, "");
        this.f23592t = aVar;
        boolean z10 = true;
        aVar.setOrientation(1);
        a aVar2 = this.f23592t;
        aVar2.setId(aVar2.hashCode());
        this.f23651m.addView(this.f23592t, layoutParams);
        w a10 = w.a(this.f23642d, this.f23639a.Y, this.f23641c.a(1017, -1, -1));
        if (a10 != null) {
            a10.setId(a10.hashCode());
            a10.a(new ah(this, a10.a()));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(3, this.f23592t.getId());
            int i10 = com.unionpay.mobile.android.global.a.f23313d;
            layoutParams2.bottomMargin = i10;
            layoutParams2.topMargin = i10;
            layoutParams2.leftMargin = i10;
            this.f23651m.addView(a10, layoutParams2);
        }
        TextView textView = new TextView(this.f23642d);
        this.f23590r = textView;
        textView.setText(c.bD.f23472n);
        this.f23590r.setTextSize(b.f23344i);
        this.f23590r.setTextColor(b.o());
        this.f23590r.setGravity(17);
        TextView textView2 = this.f23590r;
        a aVar3 = this.f23592t;
        if (aVar3 != null && !aVar3.e()) {
            z10 = false;
        }
        textView2.setEnabled(z10);
        int i11 = com.unionpay.mobile.android.global.a.f23323n;
        this.f23590r.setBackgroundDrawable(this.f23641c.a(2008, -1, -1));
        this.f23590r.setOnClickListener(this.f23591s);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i11);
        LinearLayout linearLayout = a10;
        if (a10 == null) {
            linearLayout = this.f23592t;
        }
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        this.f23651m.addView(this.f23590r, layoutParams3);
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }
}
