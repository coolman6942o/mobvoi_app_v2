package com.unionpay.mobile.android.widgets;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ao extends aa {
    public ao(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
        ((aa) this).f24277b.a(129);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        String a10 = a();
        return a10 != null && a10.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "login_pwd";
    }
}
