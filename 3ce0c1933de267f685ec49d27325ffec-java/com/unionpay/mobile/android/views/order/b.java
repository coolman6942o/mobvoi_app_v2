package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.c;
import com.unionpay.mobile.android.upwidget.g;
import com.unionpay.mobile.android.utils.k;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b extends AbstractMethod {
    private TextView A;

    /* renamed from: g  reason: collision with root package name */
    private JSONObject f24189g;

    /* renamed from: h  reason: collision with root package name */
    private JSONArray f24190h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24191i;

    /* renamed from: j  reason: collision with root package name */
    private com.unionpay.mobile.android.upviews.a f24192j;

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f24193k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f24194l;

    /* renamed from: m  reason: collision with root package name */
    private PopupWindow f24195m;

    /* renamed from: n  reason: collision with root package name */
    private g f24196n;

    /* renamed from: o  reason: collision with root package name */
    private c f24197o;

    /* renamed from: p  reason: collision with root package name */
    private String f24198p;

    /* renamed from: q  reason: collision with root package name */
    private final View.OnClickListener f24199q;

    /* renamed from: r  reason: collision with root package name */
    private final View.OnClickListener f24200r;

    /* renamed from: s  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f24201s;

    /* renamed from: t  reason: collision with root package name */
    private a f24202t;

    /* renamed from: w  reason: collision with root package name */
    private AbstractC0268b f24205w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f24206x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f24207y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f24208z;
    private boolean B = false;
    private int C = l.f24228b.intValue();

    /* renamed from: v  reason: collision with root package name */
    private int f24204v = 1;

    /* renamed from: u  reason: collision with root package name */
    private int f24203u = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        View f24209a;

        /* renamed from: b  reason: collision with root package name */
        TextView f24210b;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b10) {
            this();
        }
    }

    /* renamed from: com.unionpay.mobile.android.views.order.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0268b {
        int a();

        int a(int i10);

        int b(int i10);
    }

    public b(Context context, List<Map<String, Object>> list, String str) {
        super(context);
        c cVar = new c(this);
        this.f24199q = cVar;
        d dVar = new d(this);
        this.f24200r = dVar;
        e eVar = new e(this);
        this.f24201s = eVar;
        this.f24193k = list;
        this.f24198p = str;
        Context context2 = this.f24170b;
        List<Map<String, Object>> list2 = this.f24193k;
        com.unionpay.mobile.android.languages.c cVar2 = com.unionpay.mobile.android.languages.c.bD;
        c cVar3 = new c(context2, list2, cVar2.f23451bh, this.f24198p, cVar2.f23452bi, this.f24204v, 0);
        this.f24197o = cVar3;
        cVar3.a(cVar);
        g gVar = new g(this.f24170b, this.f24197o);
        this.f24196n = gVar;
        gVar.a(eVar);
        this.f24196n.a(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, View view) {
        if (bVar.f24195m == null) {
            bVar.f24195m = new PopupWindow((View) bVar.f24196n, -1, -1, true);
            bVar.f24195m.setBackgroundDrawable(new ColorDrawable(-1342177280));
            bVar.f24195m.update();
        }
        bVar.f24195m.showAtLocation(view, 80, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i10) {
        int c10 = i10 - this.f24197o.c();
        if (i10 != 0) {
            List<Map<String, Object>> list = this.f24193k;
            if (list != null && i10 == list.size() + this.f24197o.c()) {
                k.a("direct", " new ");
                AbstractC0268b bVar = this.f24205w;
                if (bVar != null) {
                    bVar.a();
                }
            } else if (!this.f24197o.b() || !this.f24197o.c(i10)) {
                this.f24204v = i10;
                this.f24197o.a(i10);
                k.a("direct", " pay with " + i10);
                a aVar = this.f24202t;
                if (aVar != null) {
                    aVar.f24210b.setText(this.f24197o.b(this.f24204v));
                }
                AbstractC0268b bVar2 = this.f24205w;
                if (bVar2 != null) {
                    bVar2.b(c10);
                }
            } else {
                k.a("direct", " delete " + i10);
                i();
                AbstractC0268b bVar3 = this.f24205w;
                if (bVar3 != null) {
                    this.f24203u = c10;
                    bVar3.a(c10);
                }
            }
            this.f24195m.dismiss();
        }
    }

    private boolean h() {
        List<Map<String, Object>> list;
        return this.f24191i || (list = this.f24193k) == null || list.size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        c cVar = this.f24197o;
        if (cVar != null) {
            cVar.a();
            String str = this.f24197o.b() ? com.unionpay.mobile.android.languages.c.bD.f23453bj : com.unionpay.mobile.android.languages.c.bD.f23451bh;
            String str2 = this.f24197o.b() ? com.unionpay.mobile.android.languages.c.bD.f23454bk : com.unionpay.mobile.android.languages.c.bD.f23452bi;
            this.f24197o.a(str);
            this.f24197o.b(str2);
            this.f24197o.notifyDataSetChanged();
        }
    }

    public final b a(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.f24206x = drawable;
        this.f24207y = drawable2;
        this.f24208z = drawable3;
        return this;
    }

    public final b a(AbstractC0268b bVar) {
        this.f24205w = bVar;
        return this;
    }

    public final b a(JSONArray jSONArray) {
        this.f24190h = jSONArray;
        return this;
    }

    public final b a(JSONObject jSONObject) {
        this.f24189g = jSONObject;
        TextView textView = this.A;
        if (textView != null) {
            textView.setText(Html.fromHtml(AbstractMethod.a(jSONObject, "label")));
        }
        return this;
    }

    public final void a(int i10) {
        int i11;
        List<Map<String, Object>> list = this.f24193k;
        int size = list != null ? list.size() : 0;
        if (size > 0 && (i11 = this.f24203u) >= 0 && i11 < size) {
            this.f24193k.remove(i11);
            this.f24203u = -1;
            this.f24197o.notifyDataSetChanged();
        }
        c(i10 + this.f24197o.c());
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final void a(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f24170b);
        textView.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
        textView.setTextColor(-13421773);
        textView.setText(this.f24171c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        layoutParams.leftMargin = com.unionpay.mobile.android.utils.g.a(this.f24170b, 10.0f);
        relativeLayout.addView(textView, layoutParams);
        if (TextUtils.isEmpty(this.f24171c)) {
            relativeLayout.setVisibility(8);
        }
        if (h()) {
            String a10 = AbstractMethod.a(this.f24189g, "label");
            TextView textView2 = new TextView(this.f24170b);
            this.A = textView2;
            textView2.setOnClickListener(new f(this));
            if (!AbstractMethod.a(a10)) {
                this.A.setText(Html.fromHtml(a10));
            }
            AbstractMethod.a(this.A);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(11, -1);
            layoutParams2.rightMargin = com.unionpay.mobile.android.utils.g.a(this.f24170b, 10.0f);
            layoutParams2.addRule(15, -1);
            relativeLayout.addView(this.A, layoutParams2);
        }
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final int b() {
        return this.C;
    }

    public final b b(Drawable drawable) {
        this.f24194l = drawable;
        return this;
    }

    public final b b(boolean z10) {
        this.B = z10;
        return this;
    }

    public final void b(int i10) {
        this.C = i10;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final void b(RelativeLayout relativeLayout) {
        if (h() || this.B) {
            if (this.B) {
                g();
            }
            this.f24192j = new com.unionpay.mobile.android.upviews.a(this.f24170b, this.f24190h, this, "bankpay");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
            relativeLayout.addView(this.f24192j, layoutParams);
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f24170b);
        linearLayout.setId(linearLayout.hashCode());
        linearLayout.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        relativeLayout.addView(linearLayout, layoutParams2);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f24170b);
        relativeLayout2.setId(relativeLayout2.hashCode());
        relativeLayout2.setBackgroundDrawable(this.f24194l);
        relativeLayout2.setOnClickListener(new g(this));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.b.f23349n);
        layoutParams3.addRule(3, linearLayout.getId());
        relativeLayout.addView(relativeLayout2, layoutParams3);
        ImageView imageView = new ImageView(this.f24170b);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.f24170b).a(1002, -1, -1));
        int a10 = com.unionpay.mobile.android.utils.g.a(this.f24170b, 15.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a10, a10);
        layoutParams4.addRule(11, -1);
        layoutParams4.addRule(15, -1);
        layoutParams4.rightMargin = com.unionpay.mobile.android.utils.g.a(this.f24170b, 10.0f);
        relativeLayout2.addView(imageView, layoutParams4);
        TextView textView = new TextView(this.f24170b);
        textView.setText(this.f24197o.b(this.f24204v));
        textView.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
        textView.setTextColor(-10066330);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(9, -1);
        layoutParams5.addRule(15, -1);
        layoutParams5.addRule(0, imageView.getId());
        layoutParams5.leftMargin = com.unionpay.mobile.android.utils.g.a(this.f24170b, 10.0f);
        relativeLayout2.addView(textView, layoutParams5);
        LinearLayout linearLayout2 = new LinearLayout(this.f24170b);
        linearLayout2.setBackgroundColor(-3419943);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams6.bottomMargin = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams6.addRule(3, relativeLayout2.getId());
        relativeLayout.addView(linearLayout2, layoutParams6);
        a aVar = new a(this, (byte) 0);
        this.f24202t = aVar;
        aVar.f24209a = relativeLayout2;
        aVar.f24210b = textView;
    }

    public final void b(String str) {
        a aVar = this.f24202t;
        if (aVar != null) {
            aVar.f24210b.setText(str);
        }
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final a.C0266a c() {
        com.unionpay.mobile.android.upviews.a aVar = this.f24192j;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final void c(RelativeLayout relativeLayout) {
        relativeLayout.setVisibility(8);
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final int d() {
        return this.f24204v - this.f24197o.c();
    }

    public final b d(String str) {
        this.f24171c = str;
        return this;
    }

    public final b e(String str) {
        this.f24172d = str;
        return this;
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final String e() {
        return this.f24172d;
    }

    public final void f(String str) {
        this.f24197o.b(str);
    }

    @Override // com.unionpay.mobile.android.views.order.AbstractMethod
    public final boolean f() {
        com.unionpay.mobile.android.upviews.a aVar = this.f24192j;
        return aVar == null || aVar.e();
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void r() {
    }
}
