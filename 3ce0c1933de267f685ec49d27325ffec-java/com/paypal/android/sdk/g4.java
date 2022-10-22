package com.paypal.android.sdk;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class g4 implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    private List f21315a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f21316b;

    public g4(JSONArray jSONArray, JSONObject jSONObject) {
        f4 f4Var;
        int i10 = 0;
        while (true) {
            f4Var = null;
            if (i10 >= jSONArray.length()) {
                break;
            }
            try {
                f4Var = f4.a(jSONArray.getJSONObject(i10));
            } catch (JSONException e10) {
                Log.w("paypal.sdk", "Error extracting funding source: " + e10.getMessage());
            }
            if (f4Var != null) {
                this.f21315a.add(f4Var);
            }
            i10++;
        }
        if (jSONObject != null) {
            try {
                f4Var = f4.a(jSONObject);
            } catch (JSONException e11) {
                Log.w("paypal.sdk", "Error parsing backup funding instrument: " + e11.getMessage());
            }
            if (f4Var != null) {
                this.f21315a.add(f4Var);
            }
        }
        this.f21316b = g();
    }

    private int g() {
        Double valueOf = Double.valueOf(0.0d);
        int i10 = 0;
        for (int i11 = 0; i11 < this.f21315a.size(); i11++) {
            if (((f4) this.f21315a.get(i11)).f().doubleValue() > valueOf.doubleValue()) {
                valueOf = ((f4) this.f21315a.get(i11)).f();
                i10 = i11;
            }
        }
        return i10;
    }

    public final f4 a(int i10) {
        this.f21315a.size();
        return (f4) this.f21315a.get(0);
    }

    public final String b() {
        return ((f4) this.f21315a.get(this.f21316b)).b();
    }

    public final boolean c() {
        String h10 = ((f4) this.f21315a.get(this.f21316b)).h();
        if (y1.m(h10)) {
            return h10.toUpperCase().equals("DELAYED_TRANSFER");
        }
        return false;
    }

    public final String d() {
        return this.f21315a.size() == 1 ? ((f4) this.f21315a.get(0)).d() : z3.a(ft.AND_OTHER_FUNDING_SOURCES);
    }

    public final String e() {
        return ((f4) this.f21315a.get(this.f21316b)).g();
    }

    public final int f() {
        return this.f21315a.size();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f21315a.iterator();
    }
}
