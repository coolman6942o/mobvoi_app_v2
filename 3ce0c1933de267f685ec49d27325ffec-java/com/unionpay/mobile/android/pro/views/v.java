package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.os.Handler;
import com.unionpay.mobile.android.hce.c;
import com.unionpay.mobile.android.hce.f;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.views.ao;
import com.unionpay.uppay.PayActivity;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class v extends ao {
    public v(Context context, e eVar) {
        super(context, eVar);
    }

    @Override // com.unionpay.mobile.android.nocard.views.ao
    protected final void a(Handler handler) {
        Object a10 = ((PayActivity) this.f23642d).a(f.class.toString());
        if (a10 != null) {
            ((f) a10).a(handler);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.ao
    public final void d(String str, String str2) {
        if (b.f23495bn) {
            a(this.f23639a.f23513ap, false);
            return;
        }
        Object a10 = ((PayActivity) this.f23642d).a(com.unionpay.mobile.android.pro.pboc.engine.b.class.toString());
        if (a10 != null) {
            ((com.unionpay.mobile.android.pro.pboc.engine.b) a10).a(new Handler(new w(this)), str, str2);
        }
    }

    @Override // com.unionpay.mobile.android.nocard.views.ao
    protected final boolean t() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.nocard.views.ao
    public final void u() {
        List<d> list = b.f23492bb;
        if (list != null) {
            Iterator<d> it = list.iterator();
            while (it.hasNext()) {
                try {
                    this.f23642d.unbindService(((c) it.next()).h());
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }
}
