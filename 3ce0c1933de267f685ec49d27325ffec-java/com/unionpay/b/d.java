package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.unionpay.utils.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements HwOpenPayTask.IHwResultCallBack {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23283a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f23283a = bVar;
    }

    @Override // com.huawei.nfc.sdk.service.HwOpenPayTask.IHwResultCallBack
    public final void onResult(int i10, Bundle bundle) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        j.b("uppay", "supportCapacity result:" + i10);
        handler = this.f23283a.f23280j;
        if (handler != null) {
            handler2 = this.f23283a.f23280j;
            Message obtainMessage = handler2.obtainMessage(4004);
            obtainMessage.obj = Integer.valueOf(i10);
            handler3 = this.f23283a.f23280j;
            handler3.sendMessage(obtainMessage);
        }
    }
}
