package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.upwidget.c;
import com.unionpay.tsmservice.data.AppStatus;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class g extends z {

    /* renamed from: u  reason: collision with root package name */
    private static List<String> f24388u;

    /* renamed from: v  reason: collision with root package name */
    private static List<String> f24389v;

    /* renamed from: o  reason: collision with root package name */
    private c f24393o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f24394p;

    /* renamed from: q  reason: collision with root package name */
    private RelativeLayout f24395q;

    /* renamed from: r  reason: collision with root package name */
    private PopupWindow f24396r;

    /* renamed from: s  reason: collision with root package name */
    private com.unionpay.mobile.android.upwidget.g f24397s;

    /* renamed from: t  reason: collision with root package name */
    private List<Map<String, Object>> f24398t;

    /* renamed from: a  reason: collision with root package name */
    private Spinner f24390a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f24391b = 1;

    /* renamed from: w  reason: collision with root package name */
    private final View.OnClickListener f24399w = new h(this);

    /* renamed from: x  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f24400x = new i(this);

    /* renamed from: c  reason: collision with root package name */
    private String f24392c = com.unionpay.mobile.android.languages.c.bD.f23449bf;

    static {
        ArrayList arrayList = new ArrayList(8);
        arrayList.add(com.unionpay.mobile.android.languages.c.bD.M);
        arrayList.add(com.unionpay.mobile.android.languages.c.bD.N);
        arrayList.add(com.unionpay.mobile.android.languages.c.bD.O);
        arrayList.add(com.unionpay.mobile.android.languages.c.bD.P);
        arrayList.add(com.unionpay.mobile.android.languages.c.bD.Q);
        arrayList.add(com.unionpay.mobile.android.languages.c.bD.R);
        arrayList.add(com.unionpay.mobile.android.languages.c.bD.S);
        arrayList.add(com.unionpay.mobile.android.languages.c.bD.T);
        f24388u = arrayList;
        ArrayList arrayList2 = new ArrayList(8);
        arrayList2.add("01");
        arrayList2.add("02");
        arrayList2.add("03");
        arrayList2.add(Constant.RECHARGE_MODE_DESIGNATED_AND_CACH);
        arrayList2.add(AppStatus.OPEN);
        arrayList2.add("06");
        arrayList2.add(AppStatus.VIEW);
        arrayList2.add("99");
        f24389v = arrayList2;
    }

    public g(Context context, JSONObject jSONObject, String str) {
        super(context, jSONObject, str);
        ArrayList arrayList = null;
        List<String> list = f24388u;
        if (list != null && list.size() > 0) {
            arrayList = new ArrayList(f24388u.size());
            for (int i10 = 0; i10 < f24388u.size(); i10++) {
                HashMap hashMap = new HashMap();
                hashMap.put("text1", f24388u.get(i10));
                hashMap.put("text2", "");
                hashMap.put("editable", Boolean.FALSE);
                arrayList.add(hashMap);
            }
        }
        this.f24398t = arrayList;
        c cVar = new c(context, this.f24398t, this.f24392c, "", "", this.f24391b, 0);
        this.f24393o = cVar;
        com.unionpay.mobile.android.upwidget.g gVar = new com.unionpay.mobile.android.upwidget.g(this.f24347d, cVar);
        this.f24397s = gVar;
        gVar.a(this.f24400x);
        this.f24397s.a(this.f24399w);
        RelativeLayout relativeLayout = this.f24356m;
        Drawable a10 = com.unionpay.mobile.android.resource.c.a(this.f24347d).a(2014, -1, -1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f24347d);
        this.f24395q = relativeLayout2;
        relativeLayout2.setBackgroundDrawable(a10);
        this.f24395q.setOnClickListener(new j(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, a.f23323n);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(this.f24395q, layoutParams);
        ImageView imageView = new ImageView(this.f24347d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.f24347d).a(1002, -1, -1));
        int a11 = com.unionpay.mobile.android.utils.g.a(this.f24347d, 15.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a11, a11);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.rightMargin = com.unionpay.mobile.android.utils.g.a(this.f24347d, 10.0f);
        this.f24395q.addView(imageView, layoutParams2);
        TextView textView = new TextView(this.f24347d);
        textView.setId(textView.hashCode());
        textView.setTextSize(b.f23346k);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setSingleLine(true);
        textView.setEms(4);
        textView.setText(com.unionpay.mobile.android.languages.c.bD.f23446bc);
        textView.setTextColor(-16777216);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(9, -1);
        layoutParams3.leftMargin = com.unionpay.mobile.android.utils.g.a(this.f24347d, 10.0f);
        this.f24395q.addView(textView, layoutParams3);
        TextView textView2 = new TextView(this.f24347d);
        this.f24394p = textView2;
        textView2.setTextSize(b.f23346k);
        this.f24394p.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f24394p.setSingleLine(true);
        this.f24394p.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(1, textView.getId());
        layoutParams4.addRule(0, imageView.getId());
        this.f24395q.addView(this.f24394p, layoutParams4);
        if (this.f24352i) {
            this.f24394p.setText(b(i()));
            imageView.setVisibility(8);
            this.f24395q.setClickable(false);
            return;
        }
        a(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        List<String> list;
        this.f24391b = i10;
        int c10 = i10 - this.f24393o.c();
        this.f24393o.a(this.f24391b);
        TextView textView = this.f24394p;
        if (textView != null && (list = f24388u) != null) {
            textView.setText(list.get(c10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, View view) {
        if (gVar.f24396r == null) {
            gVar.f24396r = new PopupWindow((View) gVar.f24397s, -1, -1, true);
            gVar.f24396r.setBackgroundDrawable(new ColorDrawable(-1342177280));
            gVar.f24396r.update();
        }
        gVar.f24396r.showAtLocation(view, 80, 0, 0);
    }

    private static String b(String str) {
        String str2 = "";
        for (int i10 = 0; i10 < f24389v.size(); i10++) {
            if (f24389v.get(i10).equals(str)) {
                str2 = f24388u.get(i10);
            }
        }
        return str2;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        int c10 = this.f24391b - this.f24393o.c();
        return this.f24352i ? i() : (c10 < 0 || c10 > f24388u.size()) ? "" : f24389v.get(c10);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_select_certtype";
    }
}
