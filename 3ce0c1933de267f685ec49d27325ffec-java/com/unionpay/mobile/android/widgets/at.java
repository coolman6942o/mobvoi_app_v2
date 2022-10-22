package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class at extends aa {

    /* renamed from: c  reason: collision with root package name */
    private int f24328c;

    public at(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
        this.f24328c = 0;
        String a10 = j.a(jSONObject, "maxLength");
        this.f24328c = (a10 == null || a10.length() <= 0) ? 23 : Integer.getInteger(a10).intValue();
        ((aa) this).f24277b.a(new InputFilter.LengthFilter(this.f24328c));
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return this.f24352i || this.f24328c >= a().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_input_text";
    }
}
