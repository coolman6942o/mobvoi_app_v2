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
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.upwidget.c;
import com.unionpay.mobile.android.upwidget.g;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a extends z {

    /* renamed from: u  reason: collision with root package name */
    private static List<String> f24263u;

    /* renamed from: v  reason: collision with root package name */
    private static List<String> f24264v;

    /* renamed from: c  reason: collision with root package name */
    private String f24267c;

    /* renamed from: o  reason: collision with root package name */
    private c f24268o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f24269p;

    /* renamed from: q  reason: collision with root package name */
    private RelativeLayout f24270q;

    /* renamed from: r  reason: collision with root package name */
    private PopupWindow f24271r;

    /* renamed from: s  reason: collision with root package name */
    private g f24272s;

    /* renamed from: t  reason: collision with root package name */
    private List<Map<String, Object>> f24273t;

    /* renamed from: a  reason: collision with root package name */
    private Spinner f24265a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f24266b = 1;

    /* renamed from: w  reason: collision with root package name */
    private final View.OnClickListener f24274w = new b(this);

    /* renamed from: x  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f24275x = new c(this);

    public a(Context context, JSONObject jSONObject, JSONArray jSONArray, String str) {
        super(context, jSONObject, str);
        ArrayList arrayList = new ArrayList(1);
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add((JSONArray) j.b(jSONArray, i10));
        }
        if (arrayList.size() > 0) {
            f24263u = new ArrayList(arrayList.size());
            f24264v = new ArrayList(arrayList.size());
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                f24264v.add(j.a((JSONArray) arrayList.get(i11), 0));
                f24263u.add(j.a((JSONArray) arrayList.get(i11), 1));
            }
        }
        RelativeLayout relativeLayout = this.f24356m;
        Drawable a10 = com.unionpay.mobile.android.resource.c.a(this.f24347d).a(2014, -1, -1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f24347d);
        this.f24270q = relativeLayout2;
        relativeLayout2.setBackgroundDrawable(a10);
        this.f24270q.setOnClickListener(new d(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.f23323n);
        layoutParams.addRule(15, -1);
        relativeLayout.addView(this.f24270q, layoutParams);
        ImageView imageView = new ImageView(this.f24347d);
        imageView.setId(imageView.hashCode());
        imageView.setBackgroundDrawable(com.unionpay.mobile.android.resource.c.a(this.f24347d).a(1002, -1, -1));
        int a11 = com.unionpay.mobile.android.utils.g.a(this.f24347d, 15.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a11, a11);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.rightMargin = com.unionpay.mobile.android.utils.g.a(this.f24347d, 10.0f);
        this.f24270q.addView(imageView, layoutParams2);
        TextView textView = new TextView(this.f24347d);
        textView.setId(textView.hashCode());
        textView.setTextSize(b.f23346k);
        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        textView.setTextColor(-13421773);
        textView.setSingleLine(true);
        textView.setEms(4);
        textView.setText(com.unionpay.mobile.android.languages.c.bD.f23447bd);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(9, -1);
        layoutParams3.leftMargin = com.unionpay.mobile.android.utils.g.a(this.f24347d, 10.0f);
        this.f24270q.addView(textView, layoutParams3);
        TextView textView2 = new TextView(this.f24347d);
        this.f24269p = textView2;
        textView2.setTextSize(b.f23346k);
        this.f24269p.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.f24269p.setSingleLine(true);
        this.f24269p.setTextColor(-10066330);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(15, -1);
        layoutParams4.addRule(1, textView.getId());
        layoutParams4.addRule(0, imageView.getId());
        this.f24270q.addView(this.f24269p, layoutParams4);
        if (this.f24352i) {
            this.f24269p.setText(b(i()));
            imageView.setVisibility(8);
            this.f24270q.setClickable(false);
            return;
        }
        List<String> list = f24263u;
        if (list != null && list.size() > 0) {
            this.f24269p.setText(f24263u.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, int i10) {
        List<String> list;
        aVar.f24266b = i10;
        int c10 = i10 - aVar.f24268o.c();
        aVar.f24268o.a(aVar.f24266b);
        TextView textView = aVar.f24269p;
        if (textView != null && (list = f24263u) != null) {
            textView.setText(list.get(c10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, View view) {
        if (aVar.f24271r == null) {
            aVar.f24267c = com.unionpay.mobile.android.languages.c.bD.f23448be;
            ArrayList arrayList = null;
            List<String> list = f24263u;
            if (list != null && list.size() > 0) {
                arrayList = new ArrayList(f24263u.size());
                for (int i10 = 0; i10 < f24263u.size(); i10++) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("text1", f24263u.get(i10));
                    hashMap.put("text2", "");
                    hashMap.put("editable", Boolean.FALSE);
                    arrayList.add(hashMap);
                }
            }
            aVar.f24273t = arrayList;
            c cVar = new c(aVar.f24347d, aVar.f24273t, aVar.f24267c, "", "", aVar.f24266b, 0);
            aVar.f24268o = cVar;
            g gVar = new g(aVar.f24347d, cVar);
            aVar.f24272s = gVar;
            gVar.a(aVar.f24275x);
            aVar.f24272s.a(aVar.f24274w);
            aVar.f24271r = new PopupWindow((View) aVar.f24272s, -1, -1, true);
            aVar.f24271r.setBackgroundDrawable(new ColorDrawable(-1342177280));
            aVar.f24271r.update();
        }
        aVar.f24271r.showAtLocation(view, 80, 0, 0);
    }

    private static String b(String str) {
        String str2 = "";
        for (int i10 = 0; i10 < f24264v.size(); i10++) {
            if (f24264v.get(i10).equals(str)) {
                str2 = f24263u.get(i10);
            }
        }
        return str2;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        c cVar = this.f24268o;
        int c10 = this.f24266b - (cVar == null ? 1 : cVar.c());
        return this.f24352i ? i() : (c10 < 0 || c10 > f24263u.size()) ? "" : f24264v.get(c10);
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
        return "_select_areacode";
    }
}
