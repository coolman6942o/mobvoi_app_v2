package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class af extends aa {

    /* renamed from: c  reason: collision with root package name */
    private TextWatcher f24285c;

    /* renamed from: o  reason: collision with root package name */
    private ArrayList<a> f24286o;

    /* loaded from: classes2.dex */
    class a {

        /* renamed from: b  reason: collision with root package name */
        private String f24288b;

        /* renamed from: c  reason: collision with root package name */
        private String f24289c;

        /* renamed from: d  reason: collision with root package name */
        private String f24290d;

        public a(JSONObject jSONObject) {
            this.f24288b = null;
            this.f24289c = null;
            this.f24290d = null;
            this.f24288b = j.a(jSONObject, "pattern");
            this.f24289c = j.a(jSONObject, "prefix");
            this.f24290d = j.a(jSONObject, "isCheck");
        }

        public final String a() {
            return this.f24288b;
        }

        public final String b() {
            return this.f24289c;
        }

        public final boolean c() {
            String str = this.f24290d;
            return str == null || !"false".equalsIgnoreCase(str);
        }
    }

    public af(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str, (byte) 0);
        ag agVar = new ag(this);
        this.f24285c = agVar;
        this.f24286o = null;
        ((aa) this).f24277b.a(agVar);
        ((aa) this).f24277b.a(new InputFilter.LengthFilter(23));
        ((aa) this).f24277b.a(2);
        if (this.f24352i) {
            ((aa) this).f24277b.setEnabled(false);
        }
        JSONArray d10 = j.d(jSONObject, "regex");
        if (d10 != null) {
            if (this.f24286o == null) {
                this.f24286o = new ArrayList<>();
            }
            for (int i11 = 0; i11 < d10.length(); i11++) {
                JSONObject jSONObject2 = (JSONObject) j.b(d10, i11);
                if (jSONObject2 != null) {
                    this.f24286o.add(new a(jSONObject2));
                }
            }
        }
    }

    private static boolean b(String str) {
        char c10;
        int length = str.length();
        int i10 = length - 2;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            c10 = '0';
            if (i10 < 0) {
                break;
            }
            int charAt = str.charAt(i10) - '0';
            if (i12 % 2 == 0) {
                int i13 = charAt * 2;
                charAt = (i13 % 10) + (i13 / 10);
            }
            i11 += charAt;
            i10--;
            i12++;
        }
        int i14 = i11 % 10;
        if (i14 != 0) {
            c10 = (char) ((10 - i14) + 48);
        }
        return c10 == str.charAt(length - 1);
    }

    @Override // com.unionpay.mobile.android.widgets.aa, com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        return (this.f24352i ? i() : ((aa) this).f24277b.b()).replace(" ", "");
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        if (this.f24352i) {
            return true;
        }
        String a10 = a();
        ArrayList<a> arrayList = this.f24286o;
        if (arrayList != null && arrayList.size() > 0) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f24286o.size(); i10++) {
                a aVar = this.f24286o.get(i10);
                if (aVar.a() != null) {
                    z10 = a10.matches(aVar.a());
                }
                if (z10) {
                    if (!aVar.c()) {
                        return 13 <= a10.length() && 19 >= a10.length();
                    } else {
                        return b(aVar.b() + a10);
                    }
                }
            }
        }
        return 13 <= a10.length() && 19 >= a10.length() && b(a10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_input_cardNO";
    }
}
