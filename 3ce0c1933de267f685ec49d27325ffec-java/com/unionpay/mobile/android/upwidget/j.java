package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.mobile.android.widgets.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class j extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f24069a;

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f24070b;

    /* renamed from: c  reason: collision with root package name */
    private int f24071c;

    /* renamed from: d  reason: collision with root package name */
    private int f24072d;

    /* renamed from: f  reason: collision with root package name */
    private a[] f24074f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<Object> f24075g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f24076h;

    /* renamed from: i  reason: collision with root package name */
    private HorizontalScrollView f24077i;

    /* renamed from: o  reason: collision with root package name */
    private int f24083o;

    /* renamed from: q  reason: collision with root package name */
    private int f24085q;

    /* renamed from: r  reason: collision with root package name */
    private int f24086r;

    /* renamed from: s  reason: collision with root package name */
    private String f24087s;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24073e = true;

    /* renamed from: j  reason: collision with root package name */
    private k f24078j = null;

    /* renamed from: k  reason: collision with root package name */
    private ad f24079k = null;

    /* renamed from: l  reason: collision with root package name */
    private TextView f24080l = null;

    /* renamed from: m  reason: collision with root package name */
    private TextView f24081m = null;

    /* renamed from: n  reason: collision with root package name */
    private int f24082n = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f24084p = -1;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList<AdapterView.OnItemClickListener> f24088t = new ArrayList<>();

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24089u = new ArrayList<>();

    /* renamed from: v  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24090v = new ArrayList<>();

    /* renamed from: w  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24091w = new ArrayList<>();

    /* renamed from: x  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24092x = new ArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private AdapterView.OnItemClickListener f24093y = new k(this);

    /* renamed from: z  reason: collision with root package name */
    private View.OnClickListener f24094z = new l(this);
    private View.OnClickListener A = new m(this);
    private View.OnClickListener B = new n(this);
    private View.OnClickListener C = new o(this);
    private View.OnClickListener D = new p(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        TextView f24095a;

        /* renamed from: b  reason: collision with root package name */
        LinearLayout f24096b;

        /* renamed from: c  reason: collision with root package name */
        View f24097c;

        /* renamed from: d  reason: collision with root package name */
        String f24098d;

        private a() {
        }

        /* synthetic */ a(j jVar, byte b10) {
            this();
        }
    }

    public j(Context context, JSONArray jSONArray, int i10, String str) {
        super(context);
        this.f24083o = 0;
        this.f24069a = context;
        this.f24070b = jSONArray;
        this.f24083o = i10;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f24069a).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f24085q = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((Activity) this.f24069a).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
        this.f24086r = displayMetrics2.heightPixels;
        this.f24087s = str;
        if (this.f24070b != null) {
            FrameLayout frameLayout = new FrameLayout(this.f24069a);
            RelativeLayout relativeLayout = new RelativeLayout(this.f24069a);
            frameLayout.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (this.f24086r / 3) * 2);
            layoutParams.addRule(12, -1);
            LinearLayout linearLayout = new LinearLayout(this.f24069a);
            linearLayout.setOrientation(1);
            linearLayout.setBackgroundColor(-1);
            linearLayout.setId(linearLayout.hashCode());
            relativeLayout.addView(linearLayout, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            LinearLayout linearLayout2 = new LinearLayout(this.f24069a);
            layoutParams2.addRule(10, -1);
            layoutParams2.addRule(2, linearLayout.getId());
            relativeLayout.addView(linearLayout2, layoutParams2);
            linearLayout2.setOnClickListener(this.f24094z);
            LinearLayout linearLayout3 = new LinearLayout(this.f24069a);
            this.f24076h = linearLayout3;
            linearLayout3.setBackgroundColor(-1);
            this.f24076h.setOrientation(0);
            linearLayout.addView(this.f24076h, new LinearLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.f23323n));
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, g.a(this.f24069a, 1.0f));
            LinearLayout linearLayout4 = new LinearLayout(this.f24069a);
            linearLayout4.setBackgroundColor(-3355444);
            linearLayout.addView(linearLayout4, layoutParams3);
            HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this.f24069a);
            this.f24077i = horizontalScrollView;
            horizontalScrollView.setBackgroundColor(-1052684);
            linearLayout.addView(this.f24077i, new LinearLayout.LayoutParams(-2, -1));
            int a10 = g.a(this.f24069a, 40.0f);
            ImageView imageView = new ImageView(this.f24069a);
            imageView.setBackgroundDrawable(c.a(this.f24069a).a(1034, -1, -1));
            imageView.setOnClickListener(this.f24094z);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(a10, a10);
            layoutParams4.gravity = 85;
            layoutParams4.rightMargin = g.a(this.f24069a, 10.0f);
            layoutParams4.bottomMargin = ((this.f24086r / 3) * 2) - (a10 / 2);
            frameLayout.addView(imageView, layoutParams4);
            addView(frameLayout);
            a();
        }
    }

    private View a(LinearLayout linearLayout, JSONObject jSONObject) {
        c cVar = new c(this.f24069a, b(com.unionpay.mobile.android.utils.j.d(jSONObject, "options")), "", "", "", this.f24084p, 1);
        this.f24075g.add(cVar);
        ListView listView = new ListView(this.f24069a);
        listView.setDivider(null);
        listView.setAdapter((ListAdapter) cVar);
        listView.setOnItemClickListener(this.f24093y);
        listView.setCacheColorHint(-1);
        linearLayout.addView(listView, new LinearLayout.LayoutParams(this.f24085q, -1));
        return listView;
    }

    private static String a(JSONArray jSONArray, int i10, String str) {
        Object b10 = com.unionpay.mobile.android.utils.j.b(jSONArray, i10);
        return b10 != null ? com.unionpay.mobile.android.utils.j.a((JSONObject) b10, str) : "";
    }

    private void a() {
        View view;
        int length = this.f24070b.length();
        this.f24074f = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            this.f24074f[i10] = new a(this, (byte) 0);
            a[] aVarArr = this.f24074f;
            if (aVarArr[i10].f24095a == null) {
                aVarArr[i10].f24095a = new TextView(this.f24069a);
            }
            a[] aVarArr2 = this.f24074f;
            if (aVarArr2[i10].f24096b == null) {
                aVarArr2[i10].f24096b = new LinearLayout(this.f24069a);
            }
            a[] aVarArr3 = this.f24074f;
            if (aVarArr3[i10].f24097c == null) {
                aVarArr3[i10].f24097c = new ListView(this.f24069a);
            }
            a[] aVarArr4 = this.f24074f;
            if (aVarArr4[i10].f24098d == null) {
                aVarArr4[i10].f24098d = "";
            }
        }
        this.f24075g = new ArrayList<>(this.f24070b.length());
        LinearLayout linearLayout = new LinearLayout(this.f24069a);
        linearLayout.setOrientation(0);
        this.f24077i.addView(linearLayout, new LinearLayout.LayoutParams(-2, -1));
        for (int i11 = 0; i11 < this.f24070b.length(); i11++) {
            JSONObject jSONObject = (JSONObject) com.unionpay.mobile.android.utils.j.b(this.f24070b, i11);
            String a10 = com.unionpay.mobile.android.utils.j.a(jSONObject, TelephonyUtil.KEY_SIM_ACTION);
            String a11 = com.unionpay.mobile.android.utils.j.a(jSONObject, "label");
            RelativeLayout relativeLayout = new RelativeLayout(this.f24069a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.leftMargin = g.a(this.f24069a, 10.0f);
            this.f24076h.addView(relativeLayout, layoutParams);
            int a12 = g.a(this.f24069a, 10.0f);
            TextView textView = new TextView(this.f24069a);
            textView.setText(a11);
            textView.setTextSize(b.f23346k);
            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
            textView.setSingleLine(true);
            textView.setTextColor(-10066330);
            textView.setPadding(a12, 0, a12, 0);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(15, -1);
            relativeLayout.addView(textView, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(((int) textView.getPaint().measureText(a11)) + a12 + a12, g.a(this.f24069a, 2.0f));
            layoutParams3.addRule(12, -1);
            LinearLayout linearLayout2 = new LinearLayout(this.f24069a);
            linearLayout2.setBackgroundColor(-16730965);
            if (this.f24083o != i11) {
                linearLayout2.setVisibility(8);
            }
            relativeLayout.addView(linearLayout2, layoutParams3);
            relativeLayout.setTag(Integer.valueOf(i11));
            relativeLayout.setOnClickListener(this.D);
            a[] aVarArr5 = this.f24074f;
            aVarArr5[i11].f24095a = textView;
            aVarArr5[i11].f24096b = linearLayout2;
            aVarArr5[i11].f24098d = a10;
            if (this.f24083o == i11) {
                this.f24084p = 0;
            } else {
                this.f24084p = -1;
            }
            String a13 = com.unionpay.mobile.android.utils.j.a(jSONObject, "type");
            if ("coupon".equals(a13)) {
                this.f24072d = i11;
                view = b(linearLayout, jSONObject);
            } else {
                if ("point".equals(a13)) {
                    this.f24071c = i11;
                } else if (!"upoint".equals(a13)) {
                    view = a(linearLayout, jSONObject);
                }
                view = c(linearLayout, jSONObject);
            }
            a[] aVarArr6 = this.f24074f;
            aVarArr6[i11].f24097c = view;
            aVarArr6[i11].f24097c.setVisibility(8);
        }
        a(this.f24083o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10) {
        this.f24074f[this.f24083o].f24096b.setVisibility(8);
        this.f24074f[this.f24083o].f24095a.setTextColor(-16777216);
        this.f24074f[this.f24083o].f24097c.setVisibility(8);
        this.f24074f[i10].f24096b.setVisibility(0);
        this.f24074f[i10].f24095a.setTextColor(-16730965);
        this.f24074f[i10].f24097c.setVisibility(0);
        this.f24083o = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LinearLayout linearLayout, boolean z10, String str, JSONObject jSONObject, c cVar) {
        linearLayout.removeAllViews();
        ListView listView = new ListView(this.f24069a);
        listView.setDivider(null);
        listView.setAdapter((ListAdapter) cVar);
        listView.setOnItemClickListener(this.f24093y);
        this.f24075g.add(cVar);
        linearLayout.addView(listView, new LinearLayout.LayoutParams(this.f24085q, -2));
        if (cVar != null) {
            ((LinearLayout.LayoutParams) linearLayout.getLayoutParams()).gravity = 48;
        }
        if (z10) {
            int i10 = com.unionpay.mobile.android.global.a.f23325p;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i10);
            layoutParams.bottomMargin = g.a(this.f24069a, 12.0f);
            layoutParams.gravity = 17;
            linearLayout.addView(new ProgressBar(this.f24069a), layoutParams);
        }
        TextView textView = new TextView(this.f24069a);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
            textView.setTextSize(b.f23346k);
            textView.setTextColor(-13421773);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            linearLayout.addView(textView, layoutParams2);
        }
        if (jSONObject != null) {
            TextView textView2 = new TextView(this.f24069a);
            textView2.setText(com.unionpay.mobile.android.utils.j.a(jSONObject, "label"));
            textView2.setTextSize(b.f23344i);
            int i11 = b.f23337b;
            int i12 = b.f23338c;
            textView2.setTextColor(h.a(i11, i12, i12, b.f23339d));
            textView2.setGravity(17);
            textView2.setEnabled(true);
            int i13 = com.unionpay.mobile.android.global.a.f23323n;
            textView2.setBackgroundDrawable(c.a(this.f24069a).a(2008, -1, -1));
            float measureText = textView.getPaint().measureText(str);
            textView2.setOnClickListener(this.A);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) measureText, i13);
            int i14 = com.unionpay.mobile.android.global.a.f23315f;
            layoutParams3.bottomMargin = i14;
            layoutParams3.topMargin = i14;
            int a10 = g.a(this.f24069a, 10.0f);
            layoutParams3.rightMargin = a10;
            layoutParams3.leftMargin = a10;
            linearLayout.addView(textView2, layoutParams3);
        }
    }

    private View b(LinearLayout linearLayout, JSONObject jSONObject) {
        JSONObject jSONObject2;
        RelativeLayout relativeLayout = new RelativeLayout(this.f24069a);
        ListView listView = new ListView(this.f24069a);
        JSONObject jSONObject3 = null;
        listView.setDivider(null);
        listView.setAdapter((ListAdapter) null);
        this.f24075g.add(listView);
        JSONArray d10 = com.unionpay.mobile.android.utils.j.d(jSONObject, "rules");
        if (d10 == null || d10.length() <= 0) {
            jSONObject2 = null;
        } else {
            jSONObject2 = null;
            for (int i10 = 0; i10 < d10.length(); i10++) {
                Object b10 = com.unionpay.mobile.android.utils.j.b(d10, i10);
                if (b10 != null) {
                    JSONObject jSONObject4 = (JSONObject) b10;
                    String a10 = com.unionpay.mobile.android.utils.j.a(jSONObject4, "type");
                    if ("coupon_code".equals(a10)) {
                        jSONObject3 = jSONObject4;
                    } else if ("string".equals(a10)) {
                        jSONObject2 = jSONObject4;
                    }
                }
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f24085q, -2);
        layoutParams.addRule(10, -1);
        relativeLayout.addView(listView, layoutParams);
        int i11 = com.unionpay.mobile.android.global.a.I - (com.unionpay.mobile.android.global.a.f23315f * 4);
        k kVar = new k(this.f24069a, i11, jSONObject3, this.f24087s);
        this.f24078j = kVar;
        kVar.setId(kVar.hashCode());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f24085q, -2);
        layoutParams2.addRule(10, -1);
        int a11 = g.a(this.f24069a, 10.0f);
        layoutParams2.topMargin = a11;
        layoutParams2.rightMargin = a11;
        layoutParams2.leftMargin = a11;
        relativeLayout.addView(this.f24078j, layoutParams2);
        this.f24079k = new ad(this.f24069a, i11, jSONObject2, this.f24087s);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f24085q, -2);
        layoutParams3.addRule(3, this.f24078j.getId());
        int a12 = g.a(this.f24069a, 10.0f);
        layoutParams3.topMargin = a12;
        layoutParams3.rightMargin = a12;
        layoutParams3.leftMargin = a12;
        relativeLayout.addView(this.f24079k, layoutParams3);
        TextView textView = new TextView(this.f24069a);
        this.f24080l = textView;
        textView.setTextSize(b.f23346k);
        this.f24080l.setTextColor(-10066330);
        this.f24080l.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.f24085q, -2);
        layoutParams4.addRule(3, this.f24078j.getId());
        int a13 = g.a(this.f24069a, 10.0f);
        layoutParams4.topMargin = a13;
        layoutParams4.rightMargin = a13;
        layoutParams4.leftMargin = a13;
        relativeLayout.addView(this.f24080l, layoutParams4);
        JSONObject c10 = com.unionpay.mobile.android.utils.j.c(jSONObject, "use_button");
        LinearLayout linearLayout2 = new LinearLayout(this.f24069a);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, g.a(this.f24069a, 1.0f));
        LinearLayout linearLayout3 = new LinearLayout(this.f24069a);
        linearLayout3.setBackgroundColor(-3355444);
        linearLayout2.addView(linearLayout3, layoutParams5);
        TextView textView2 = new TextView(this.f24069a);
        this.f24081m = textView2;
        textView2.setText(com.unionpay.mobile.android.utils.j.a(c10, "label"));
        this.f24081m.setTextSize(b.f23344i);
        TextView textView3 = this.f24081m;
        int i12 = b.f23337b;
        int i13 = b.f23338c;
        textView3.setTextColor(h.a(i12, i13, i13, b.f23339d));
        this.f24081m.setGravity(17);
        this.f24081m.setEnabled(false);
        int i14 = com.unionpay.mobile.android.global.a.f23323n;
        this.f24081m.setBackgroundDrawable(c.a(this.f24069a).a(2008, -1, -1));
        this.f24081m.setTag(Integer.valueOf(this.f24072d));
        this.f24081m.setOnClickListener(this.C);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, i14);
        int i15 = com.unionpay.mobile.android.global.a.f23315f;
        layoutParams6.bottomMargin = i15;
        layoutParams6.topMargin = i15;
        int a14 = g.a(this.f24069a, 10.0f);
        layoutParams6.rightMargin = a14;
        layoutParams6.leftMargin = a14;
        linearLayout2.addView(this.f24081m, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(this.f24085q, -2);
        layoutParams7.addRule(12, -1);
        relativeLayout.addView(linearLayout2, layoutParams7);
        linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(this.f24085q, -2));
        return relativeLayout;
    }

    private static List<Map<String, Object>> b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            HashMap hashMap = new HashMap();
            hashMap.put("text1", a(jSONArray, i10, "label"));
            hashMap.put("text2", "");
            hashMap.put("editable", Boolean.FALSE);
            String a10 = a(jSONArray, i10, "available");
            hashMap.put("available", Boolean.valueOf(TextUtils.isEmpty(a10) || !"1".equals(a10)));
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    private View c(LinearLayout linearLayout, JSONObject jSONObject) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout2 = new LinearLayout(this.f24069a);
        linearLayout2.setOrientation(1);
        String a10 = com.unionpay.mobile.android.utils.j.a(jSONObject, "tip");
        String a11 = com.unionpay.mobile.android.utils.j.a(jSONObject, "empty_info");
        JSONObject c10 = com.unionpay.mobile.android.utils.j.c(jSONObject, "button");
        if (c10 != null) {
            a(linearLayout2, false, a10, c10, null);
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        } else if (!"upoint".equals(com.unionpay.mobile.android.utils.j.a(jSONObject, "type"))) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        } else if (a11 == null || TextUtils.isEmpty(a11)) {
            return a(linearLayout, jSONObject);
        } else {
            a(linearLayout2, false, a11, null, null);
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.gravity = 17;
        linearLayout2.setGravity(17);
        linearLayout.addView(linearLayout2, layoutParams);
        return linearLayout2;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f24089u.add(onClickListener);
    }

    public final void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f24088t.add(onItemClickListener);
    }

    public final void a(JSONArray jSONArray) {
        Object b10 = com.unionpay.mobile.android.utils.j.b(jSONArray, 0);
        if (b10 != null) {
            this.f24080l.setText(com.unionpay.mobile.android.utils.j.a((JSONObject) b10, "label"));
            this.f24080l.setVisibility(0);
            this.f24079k.setVisibility(8);
        }
        this.f24081m.setEnabled(true);
    }

    public final void a(JSONArray jSONArray, String str) {
        c cVar;
        if (jSONArray == null || jSONArray.length() <= 0) {
            cVar = null;
        } else {
            cVar = new c(this.f24069a, b(jSONArray), "", "", "", -1, 1);
            this.f24075g.add(this.f24071c, cVar);
        }
        a((LinearLayout) this.f24074f[this.f24071c].f24097c, false, str, null, cVar);
    }

    public final void b(View.OnClickListener onClickListener) {
        this.f24090v.add(onClickListener);
    }

    public final void c(View.OnClickListener onClickListener) {
        this.f24091w.add(onClickListener);
    }

    public final void d(View.OnClickListener onClickListener) {
        this.f24092x.add(onClickListener);
    }

    public final void e(View.OnClickListener onClickListener) {
        k kVar = this.f24078j;
        if (kVar != null) {
            kVar.a(onClickListener);
            this.f24078j.b(this.B);
        }
    }
}
