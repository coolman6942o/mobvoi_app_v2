package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class au extends aa {
    public au(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        if (this.f24352i) {
            return true;
        }
        String a10 = a() != null ? a() : "";
        String str = this.f24353j;
        return (str == null || str.length() <= 0) ? a10.length() > 0 && a10.length() <= 64 : a10.matches(this.f24353j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "login_user";
    }
}
