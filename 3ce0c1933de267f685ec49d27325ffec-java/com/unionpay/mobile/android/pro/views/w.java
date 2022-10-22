package com.unionpay.mobile.android.pro.views;

import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
final class w implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ v f23963a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f23963a = vVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        int i10 = message.what;
        if (i10 == 2000) {
            Object obj = message.obj;
            if (obj != null) {
                a aVar = (a) obj;
                if (aVar == null) {
                    return true;
                }
                this.f23963a.a(aVar);
                return true;
            }
            v vVar = this.f23963a;
            bVar = ((com.unionpay.mobile.android.nocard.views.b) vVar).f23639a;
            vVar.a(bVar.f23513ap, false);
            return true;
        } else if (i10 != 2001) {
            return true;
        } else {
            if ("1003100020".equalsIgnoreCase((String) message.obj)) {
                if (!b.f23494bm) {
                    return true;
                }
                this.f23963a.s();
                return true;
            } else if (b.f23494bm) {
                v vVar2 = this.f23963a;
                bVar3 = ((com.unionpay.mobile.android.nocard.views.b) vVar2).f23639a;
                vVar2.e(bVar3.f23513ap, Constant.CASH_LOAD_FAIL);
                return true;
            } else {
                v vVar3 = this.f23963a;
                bVar2 = ((com.unionpay.mobile.android.nocard.views.b) vVar3).f23639a;
                vVar3.a(bVar2.f23513ap, false);
                return true;
            }
        }
    }
}
