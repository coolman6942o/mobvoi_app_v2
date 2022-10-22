package com.unionpay.mobile.android.pro.views;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.hce.c;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f23926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f23926a = aVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Handler handler;
        com.unionpay.mobile.android.model.b bVar;
        c cVar;
        com.unionpay.mobile.android.model.b bVar2;
        a aVar;
        com.unionpay.mobile.android.model.b bVar3;
        com.unionpay.mobile.android.model.b bVar4;
        int i10 = message.what;
        if (i10 == 2004) {
            handler = this.f23926a.H;
            handler.removeMessages(2006);
            Bundle bundle = (Bundle) message.obj;
            if (bundle == null) {
                return true;
            }
            if (bundle.getBoolean(Constant.CASH_LOAD_SUCCESS)) {
                String string = bundle.getString("result");
                cVar = this.f23926a.C;
                try {
                    if (!a.d(new JSONObject(com.unionpay.mobile.android.hce.a.a(string, cVar.f())))) {
                        a aVar2 = this.f23926a;
                        bVar3 = ((com.unionpay.mobile.android.nocard.views.b) aVar2).f23639a;
                        aVar2.a(bVar3.f23513ap, false);
                        return false;
                    }
                    a aVar3 = this.f23926a;
                    aVar = aVar3.f23912x;
                    a.a(aVar3, aVar.a().f23995b, a.f(this.f23926a));
                    return true;
                } catch (Exception e10) {
                    a aVar4 = this.f23926a;
                    bVar2 = ((com.unionpay.mobile.android.nocard.views.b) aVar4).f23639a;
                    aVar4.a(bVar2.f23513ap, false);
                    e10.printStackTrace();
                    return false;
                }
            } else {
                a aVar5 = this.f23926a;
                bVar = ((com.unionpay.mobile.android.nocard.views.b) aVar5).f23639a;
                aVar5.a(bVar.f23513ap, false);
                return true;
            }
        } else if (i10 != 2006) {
            return true;
        } else {
            a aVar6 = this.f23926a;
            bVar4 = ((com.unionpay.mobile.android.nocard.views.b) aVar6).f23639a;
            aVar6.a(bVar4.f23513ap, false);
            return true;
        }
    }
}
