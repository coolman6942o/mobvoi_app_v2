package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class k extends aa {

    /* renamed from: q  reason: collision with root package name */
    private TextView f24407q;

    /* renamed from: s  reason: collision with root package name */
    private String f24409s;

    /* renamed from: t  reason: collision with root package name */
    private String f24410t;

    /* renamed from: c  reason: collision with root package name */
    private final String f24404c = "[A-Za-z0-9]{8,32}";

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24405o = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24406p = new ArrayList<>();

    /* renamed from: r  reason: collision with root package name */
    private boolean f24408r = true;

    /* renamed from: u  reason: collision with root package name */
    private View.OnClickListener f24411u = new l(this);

    public k(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
        this.f24407q = null;
        this.f24409s = null;
        this.f24410t = null;
        this.f24409s = j.a(jSONObject, "button_label");
        this.f24410t = j.a(jSONObject, "button_action");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, b.f23349n);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        ((aa) this).f24277b.setLayoutParams(layoutParams);
        TextView textView = new TextView(getContext());
        this.f24407q = textView;
        textView.setGravity(17);
        this.f24407q.setText(this.f24409s);
        this.f24407q.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
        this.f24407q.setTextSize(b.f23346k);
        this.f24407q.setOnClickListener(this.f24411u);
        a(false);
        ((aa) this).f24277b.a(this.f24407q, new LinearLayout.LayoutParams(-2, -1));
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f24405o.add(onClickListener);
    }

    public final void a(boolean z10) {
        boolean z11;
        if (z10) {
            this.f24407q.setText(c.bD.B);
            z11 = false;
        } else {
            this.f24407q.setText(this.f24409s);
            z11 = true;
        }
        this.f24408r = z11;
    }

    public final void b(View.OnClickListener onClickListener) {
        this.f24406p.add(onClickListener);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return this.f24352i || 6 == a().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_input_coupon";
    }
}
