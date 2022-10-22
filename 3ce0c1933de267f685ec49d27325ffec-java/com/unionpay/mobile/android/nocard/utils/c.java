package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.views.order.l;
/* loaded from: classes2.dex */
public final class c {
    public static int a(Context context, b bVar) {
        String b10 = PreferenceUtils.b(context);
        Integer num = l.f24228b;
        int intValue = num.intValue();
        if (!TextUtils.isEmpty(b10) && TextUtils.isDigitsOnly(b10)) {
            intValue = Integer.valueOf(b10).intValue();
        }
        boolean equalsIgnoreCase = "0".equalsIgnoreCase(bVar.f23511an);
        if (bVar.aw && (bVar.f23512ao & 69889) == 0) {
            equalsIgnoreCase = true;
        }
        if (equalsIgnoreCase) {
            return l.f24227a.intValue();
        }
        if (!TextUtils.isEmpty(bVar.f23545u)) {
            intValue = num.intValue();
        }
        return f.a(bVar.f23544t) ? num.intValue() : intValue;
    }
}
