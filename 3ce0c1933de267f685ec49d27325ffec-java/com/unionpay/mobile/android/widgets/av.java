package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import java.util.Calendar;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class av extends aa {
    public av(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
        ((aa) this).f24277b.a(new InputFilter.LengthFilter(4));
        ((aa) this).f24277b.a(2);
    }

    @Override // com.unionpay.mobile.android.widgets.aa, com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        return ((aa) this).f24277b.b().trim();
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        String a10 = a();
        if (4 == a10.length()) {
            int parseInt = Integer.parseInt(a10.substring(0, 2));
            int parseInt2 = Integer.parseInt(a10.substring(2));
            int i10 = Calendar.getInstance().get(1) % 100;
            if (parseInt > 0 && parseInt <= 12 && (parseInt2 > i10 || (parseInt2 == i10 && parseInt >= Calendar.getInstance().get(2) + 1))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_select_availdata";
    }
}
