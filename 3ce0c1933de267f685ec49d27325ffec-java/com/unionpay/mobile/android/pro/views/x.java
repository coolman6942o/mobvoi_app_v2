package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.uppay.PayActivity;
/* loaded from: classes2.dex */
public final class x extends y {
    public x(Context context, e eVar) {
        super(context, eVar);
    }

    @Override // com.unionpay.mobile.android.pro.views.y
    public final b s() {
        Object a10 = ((PayActivity) this.f23642d).a(b.class.toString());
        if (a10 != null) {
            return (b) a10;
        }
        return null;
    }
}
