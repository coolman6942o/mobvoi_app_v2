package com.unionpay.mobile.android.nocard.views;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.views.order.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aq implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f23621a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.f23621a = aoVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (this.f23621a.f23639a.aP != l.f24227a.intValue()) {
            return true;
        }
        b bVar = this.f23621a.f23639a;
        if (bVar.J) {
            return true;
        }
        if (!TextUtils.isEmpty(bVar.f23545u)) {
            ao aoVar = this.f23621a;
            aoVar.a(13, aoVar.f23654p);
            return true;
        }
        ao aoVar2 = this.f23621a;
        if (!aoVar2.f23639a.aC) {
            return true;
        }
        ao.d(aoVar2);
        return true;
    }
}
