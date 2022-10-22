package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.views.order.AbstractMethod;
import com.unionpay.mobile.android.views.order.CViewMethods;
import com.unionpay.mobile.android.views.order.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class o extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f24240a;

    /* renamed from: b  reason: collision with root package name */
    private int f24241b;

    /* renamed from: c  reason: collision with root package name */
    private int f24242c;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f24243d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f24244e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f24245f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f24246g;

    /* renamed from: h  reason: collision with root package name */
    private JSONArray f24247h;

    /* renamed from: i  reason: collision with root package name */
    private List<Map<String, Object>> f24248i;

    /* renamed from: j  reason: collision with root package name */
    private String f24249j;

    /* renamed from: k  reason: collision with root package name */
    private AbstractMethod f24250k;

    /* renamed from: l  reason: collision with root package name */
    private CViewMethods f24251l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f24252m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24253n;

    /* loaded from: classes2.dex */
    public interface a extends AbstractMethod.a, AbstractMethod.b, CViewMethods.a, b.AbstractC0268b {
    }

    private o(Context context) {
        super(context);
        Integer num = l.f24227a;
        this.f24241b = num.intValue();
        this.f24242c = num.intValue();
        this.f24240a = context;
        setOrientation(1);
    }

    public static o a(Context context, Drawable drawable) {
        o oVar = new o(context);
        oVar.f24246g = drawable;
        return oVar;
    }

    public static o a(Context context, Drawable drawable, Drawable drawable2) {
        o oVar = new o(context);
        oVar.f24252m = drawable2;
        Integer num = l.f24229c;
        oVar.f24241b = num.intValue();
        oVar.f24242c = num.intValue();
        oVar.f24246g = drawable;
        oVar.c();
        return oVar;
    }

    public static o a(Context context, JSONArray jSONArray, List<Map<String, Object>> list, Drawable drawable, Drawable drawable2, String str) {
        o oVar = new o(context);
        oVar.f24252m = drawable2;
        Integer num = l.f24228b;
        oVar.f24241b = num.intValue();
        oVar.f24242c = num.intValue();
        oVar.f24246g = drawable;
        oVar.f24247h = jSONArray;
        oVar.f24248i = list;
        oVar.f24249j = str;
        oVar.c();
        return oVar;
    }

    public static o b(Context context, JSONArray jSONArray, List<Map<String, Object>> list, Drawable drawable, Drawable drawable2, String str) {
        o oVar = new o(context);
        oVar.f24252m = drawable2;
        Integer num = l.f24231e;
        oVar.f24241b = num.intValue();
        oVar.f24242c = num.intValue();
        oVar.f24246g = drawable;
        oVar.f24247h = jSONArray;
        oVar.f24248i = list;
        oVar.f24249j = str;
        oVar.c();
        return oVar;
    }

    public final int a() {
        return this.f24241b;
    }

    public final o a(int i10) {
        this.f24242c = i10;
        return this;
    }

    public final o a(Drawable drawable) {
        this.f24252m = drawable;
        return this;
    }

    public final o a(a aVar) {
        AbstractMethod abstractMethod = this.f24250k;
        if (abstractMethod != null) {
            abstractMethod.a((AbstractMethod.b) aVar);
            this.f24250k.a((AbstractMethod.a) aVar);
            AbstractMethod abstractMethod2 = this.f24250k;
            if (abstractMethod2 instanceof b) {
                ((b) abstractMethod2).a((b.AbstractC0268b) aVar);
            }
        }
        CViewMethods cViewMethods = this.f24251l;
        if (cViewMethods != null) {
            cViewMethods.a(aVar);
        }
        return this;
    }

    public final o a(String str) {
        this.f24249j = str;
        return this;
    }

    public final o a(List<Map<String, Object>> list) {
        this.f24248i = list;
        return this;
    }

    public final o a(JSONArray jSONArray) {
        this.f24247h = jSONArray;
        return this;
    }

    public final o a(JSONObject jSONObject) {
        this.f24243d = jSONObject;
        AbstractMethod abstractMethod = this.f24250k;
        if (abstractMethod != null && (abstractMethod instanceof b)) {
            ((b) abstractMethod).a(jSONObject);
        }
        return this;
    }

    public final o a(boolean z10) {
        this.f24253n = z10;
        return this;
    }

    public final o b(int i10) {
        this.f24241b = i10;
        return this;
    }

    public final o b(Drawable drawable) {
        AbstractMethod abstractMethod = this.f24250k;
        if (abstractMethod != null) {
            abstractMethod.a(drawable);
        }
        return this;
    }

    public final o b(JSONObject jSONObject) {
        this.f24244e = jSONObject;
        AbstractMethod abstractMethod = this.f24250k;
        if (abstractMethod != null && (abstractMethod instanceof i)) {
            ((i) abstractMethod).a(jSONObject);
        }
        return this;
    }

    public final String b() {
        AbstractMethod abstractMethod = this.f24250k;
        if (abstractMethod == null || !(abstractMethod instanceof i)) {
            return null;
        }
        return ((i) abstractMethod).h();
    }

    public final void b(String str) {
        ((b) this.f24250k).b(str);
    }

    public final o c(JSONObject jSONObject) {
        this.f24245f = jSONObject;
        AbstractMethod abstractMethod = this.f24250k;
        if (abstractMethod != null && (abstractMethod instanceof i)) {
            ((i) abstractMethod).b(jSONObject);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0121 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        AbstractMethod abstractMethod;
        int i10;
        Integer num;
        String str;
        Integer num2;
        i iVar;
        this.f24250k = null;
        int i11 = this.f24241b;
        Integer num3 = l.f24228b;
        if (i11 == num3.intValue()) {
            this.f24242c &= ~num3.intValue();
            b bVar = new b(this.f24240a, this.f24248i, this.f24249j);
            bVar.d(c.bD.by);
            bVar.e(c.bD.bz);
            bVar.a(this.f24243d);
            bVar.a(this.f24247h);
            bVar.b(this.f24253n);
            bVar.b(com.unionpay.mobile.android.resource.c.a(this.f24240a).a(2014, -1, -1));
            com.unionpay.mobile.android.resource.c a10 = com.unionpay.mobile.android.resource.c.a(this.f24240a);
            bVar.a(a10.a(1015, -1, -1), a10.a(1016, -1, -1), a10.a(1002, -1, -1));
            iVar = bVar;
        } else {
            int i12 = this.f24241b;
            Integer num4 = l.f24229c;
            if (i12 == num4.intValue()) {
                this.f24242c &= ~num4.intValue();
                i iVar2 = new i(this.f24240a);
                iVar2.b(c.bD.bA);
                iVar2.d(c.bD.bB);
                iVar2.a(this.f24244e);
                iVar2.b(this.f24245f);
                iVar = iVar2;
            } else {
                int i13 = this.f24241b;
                Integer num5 = l.f24231e;
                if (i13 == num5.intValue()) {
                    this.f24242c &= ~num5.intValue();
                    b bVar2 = new b(this.f24240a, this.f24248i, "");
                    bVar2.d("");
                    bVar2.e(c.bD.bz);
                    bVar2.a((JSONObject) null);
                    bVar2.a(this.f24247h);
                    bVar2.b(num5.intValue());
                    bVar2.f("");
                    bVar2.b(com.unionpay.mobile.android.resource.c.a(this.f24240a).a(2014, -1, -1));
                    com.unionpay.mobile.android.resource.c a11 = com.unionpay.mobile.android.resource.c.a(this.f24240a);
                    bVar2.a(a11.a(1015, -1, -1), a11.a(1016, -1, -1), a11.a(1002, -1, -1));
                    this.f24250k = bVar2;
                }
                abstractMethod = this.f24250k;
                if (abstractMethod != null) {
                    abstractMethod.a();
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.topMargin = com.unionpay.mobile.android.global.b.f23336a;
                    addView(this.f24250k, layoutParams);
                }
                i10 = this.f24241b;
                num = l.f24231e;
                if (i10 == num.intValue()) {
                    CViewMethods cViewMethods = new CViewMethods(this.f24240a);
                    this.f24251l = cViewMethods;
                    cViewMethods.a(this.f24246g);
                    this.f24251l.a(this.f24242c);
                    HashMap<Integer, String> hashMap = new HashMap<>();
                    hashMap.put(num3, c.bD.by);
                    String str2 = c.bD.f23459bp;
                    if (str2 == null || TextUtils.isEmpty(str2)) {
                        num2 = l.f24230d;
                        str = c.bD.f23458bo;
                    } else {
                        num2 = l.f24230d;
                        str = c.bD.f23459bp;
                    }
                    hashMap.put(num2, str);
                    Integer num6 = l.f24229c;
                    hashMap.put(num6, c.bD.bA);
                    String str3 = c.bD.br;
                    hashMap.put(num, (str3 == null || TextUtils.isEmpty(str3)) ? c.bD.f23460bq : c.bD.br);
                    Integer num7 = l.f24232f;
                    hashMap.put(num7, c.bD.bt);
                    this.f24251l.a(hashMap);
                    HashMap<Integer, Drawable> hashMap2 = new HashMap<>();
                    hashMap2.put(num3, this.f24252m);
                    hashMap2.put(l.f24230d, this.f24252m);
                    hashMap2.put(num6, this.f24252m);
                    hashMap2.put(num, this.f24252m);
                    hashMap2.put(num7, this.f24252m);
                    this.f24251l.b(hashMap2);
                    this.f24251l.a(c.bD.bC).a();
                    addView(this.f24251l, new LinearLayout.LayoutParams(-1, -2));
                    return;
                }
                return;
            }
        }
        this.f24250k = iVar;
        abstractMethod = this.f24250k;
        if (abstractMethod != null) {
        }
        i10 = this.f24241b;
        num = l.f24231e;
        if (i10 == num.intValue()) {
        }
    }

    public final void c(int i10) {
        AbstractMethod abstractMethod = this.f24250k;
        if (abstractMethod != null && (abstractMethod instanceof b)) {
            ((b) abstractMethod).a(i10);
        }
    }
}
