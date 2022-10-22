package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class e extends aa {
    public e(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
        ((aa) this).f24277b.a(new InputFilter.LengthFilter(3));
        ((aa) this).f24277b.a(18);
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return 3 == a().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_input_cvn2";
    }
}
