package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.services.core.AMapException;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.o;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class q extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f24106a;

    /* renamed from: b  reason: collision with root package name */
    private String f24107b;

    /* renamed from: c  reason: collision with root package name */
    private String f24108c;

    /* renamed from: d  reason: collision with root package name */
    private String f24109d;

    /* renamed from: e  reason: collision with root package name */
    private String f24110e;

    /* renamed from: f  reason: collision with root package name */
    private String f24111f;

    /* renamed from: g  reason: collision with root package name */
    private String f24112g;

    /* renamed from: h  reason: collision with root package name */
    private String f24113h;

    /* renamed from: i  reason: collision with root package name */
    private String f24114i;

    /* renamed from: j  reason: collision with root package name */
    private String f24115j;

    /* renamed from: k  reason: collision with root package name */
    private RelativeLayout f24116k;

    /* renamed from: l  reason: collision with root package name */
    private Button f24117l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24118m;

    /* renamed from: n  reason: collision with root package name */
    private Context f24119n;

    /* renamed from: o  reason: collision with root package name */
    private float f24120o;

    /* renamed from: p  reason: collision with root package name */
    private View.OnClickListener f24121p;

    /* renamed from: q  reason: collision with root package name */
    private View.OnClickListener f24122q;

    /* renamed from: r  reason: collision with root package name */
    private String f24123r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f24124s;

    /* renamed from: t  reason: collision with root package name */
    private String f24125t;

    /* renamed from: u  reason: collision with root package name */
    private a f24126u;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, boolean z10);
    }

    public q(Context context, JSONObject jSONObject, String str) {
        this(context, jSONObject, str, (byte) 0);
    }

    private q(Context context, JSONObject jSONObject, String str, byte b10) {
        super(context);
        this.f24106a = "";
        this.f24107b = "";
        this.f24108c = "";
        this.f24109d = "";
        this.f24110e = "";
        this.f24111f = "";
        this.f24112g = "";
        this.f24113h = "";
        this.f24114i = "";
        this.f24115j = "";
        this.f24117l = null;
        this.f24118m = false;
        this.f24119n = null;
        this.f24120o = 0.0f;
        this.f24121p = new r(this);
        this.f24122q = new s(this);
        this.f24119n = context;
        this.f24120o = 16.0f;
        this.f24125t = str;
        this.f24106a = j.a(jSONObject, ContactConstant.CallsRecordKeys.NAME);
        this.f24107b = j.a(jSONObject, "type");
        this.f24108c = j.a(jSONObject, HealthDataProviderContracts.NAME_VALUE);
        this.f24109d = j.a(jSONObject, "label");
        this.f24110e = j.a(jSONObject, "href_label");
        this.f24111f = j.a(jSONObject, "href_url");
        this.f24112g = j.a(jSONObject, "href_title");
        this.f24113h = j.a(jSONObject, "checked");
        this.f24114i = j.a(jSONObject, "required");
        this.f24115j = j.a(jSONObject, "error_info");
        this.f24123r = j.a(jSONObject, "ckb_style");
        this.f24116k = new RelativeLayout(this.f24119n);
        addView(this.f24116k, new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.f23323n));
        if (a(this.f24109d)) {
            TextView textView = new TextView(this.f24119n);
            this.f24124s = textView;
            textView.setId(textView.hashCode());
            this.f24124s.setText(this.f24109d);
            this.f24124s.setTextSize(this.f24120o);
            this.f24124s.setTextColor(-16777216);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(9, -1);
            layoutParams.addRule(15, -1);
            this.f24116k.addView(this.f24124s, layoutParams);
        }
        Button button = new Button(this.f24119n);
        this.f24117l = button;
        button.setId(button.hashCode());
        if (!a(this.f24113h) || !this.f24113h.equalsIgnoreCase("0")) {
            this.f24118m = false;
        } else {
            this.f24118m = true;
        }
        this.f24117l.setOnClickListener(this.f24121p);
        c();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(g.a(this.f24119n, 60.0f), g.a(this.f24119n, 34.0f));
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        this.f24116k.addView(this.f24117l, layoutParams2);
        a aVar = this.f24126u;
        if (aVar != null) {
            aVar.a(this.f24107b, this.f24118m);
        }
        if (a(this.f24110e) && a(this.f24111f)) {
            TextView textView2 = new TextView(this.f24119n);
            textView2.setText(Html.fromHtml(this.f24110e));
            textView2.setTextSize(b.f23347l);
            textView2.setOnClickListener(this.f24122q);
            textView2.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(1, this.f24124s.getId());
            layoutParams3.addRule(15, -1);
            layoutParams3.leftMargin = g.a(this.f24119n, 10.0f);
            this.f24116k.addView(textView2, layoutParams3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(q qVar) {
        boolean z10 = !qVar.f24118m;
        qVar.f24118m = z10;
        String[] strArr = o.f24165g;
        a aVar = qVar.f24126u;
        if (aVar != null) {
            aVar.a(qVar.f24107b, z10);
        }
        qVar.c();
    }

    private static boolean a(String str) {
        return str != null && str.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(q qVar) {
        a aVar = qVar.f24126u;
        if (aVar != null) {
            aVar.a(qVar.f24110e, qVar.f24111f);
        }
    }

    private void c() {
        if (this.f24117l != null) {
            this.f24117l.setBackgroundDrawable(c.a(this.f24119n).a(this.f24118m ? AMapException.CODE_AMAP_IP_QUERY_OVER_LIMIT : AMapException.CODE_AMAP_USERKEY_PLAT_NOMATCH, g.a(this.f24119n, 60.0f), g.a(this.f24119n, 34.0f)));
        }
    }

    public final void a() {
        TextView textView = this.f24124s;
        if (textView != null) {
            textView.setTextColor(-13421773);
        }
    }

    public final void a(float f10) {
        TextView textView = this.f24124s;
        if (textView != null) {
            textView.setTextSize(f10);
        }
    }

    public final void a(a aVar) {
        this.f24126u = aVar;
    }

    public final void a(boolean z10) {
        this.f24118m = z10;
        c();
    }

    public final boolean b() {
        if (!a(this.f24114i) || !this.f24114i.equalsIgnoreCase("0")) {
            return true;
        }
        return this.f24118m;
    }
}
