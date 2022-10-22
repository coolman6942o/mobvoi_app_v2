package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.hce.f;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.uppay.PayActivity;
/* loaded from: classes2.dex */
public final class j extends h {
    public j(Context context) {
        super(context);
    }

    @Override // com.unionpay.mobile.android.nocard.views.l
    public final void a(int i10, int i11, String str, String str2, int i12, String str3) {
        Object a10 = ((PayActivity) this.f23642d).a(f.class.toString());
        if (a10 != null) {
            f fVar = (f) a10;
            fVar.a();
            fVar.a(i10);
            fVar.b(i11);
            fVar.a(str);
            fVar.b(str2);
            fVar.c(str3);
            fVar.c(i12);
            fVar.c();
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.l
    public final boolean s() {
        return true;
    }

    @Override // com.unionpay.mobile.android.nocard.views.l
    public final boolean t() {
        return true;
    }

    @Override // com.unionpay.mobile.android.pro.views.h
    public final b y() {
        Object a10 = ((PayActivity) this.f23642d).a(b.class.toString());
        if (a10 != null) {
            return (b) a10;
        }
        return null;
    }
}
