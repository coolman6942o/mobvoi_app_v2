package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.unionpay.utils.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class f implements HwOpenPayTask.IHwPayResultCallBack {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23285a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f23285a = bVar;
    }

    @Override // com.huawei.nfc.sdk.service.HwOpenPayTask.IHwPayResultCallBack
    public final void onError(String str, String str2) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        j.b("uppay", "queryHwPayStatus onError, errorCode:" + str + " errorMsg:" + str2);
        handler = this.f23285a.f23280j;
        if (handler != null) {
            handler2 = this.f23285a.f23280j;
            Message obtainMessage = handler2.obtainMessage(AMapException.CODE_AMAP_SHARE_SIGNATURE_FAILURE);
            Bundle bundle = new Bundle();
            bundle.putString("errorCode", str);
            bundle.putString("errorDesc", str2);
            obtainMessage.obj = bundle;
            handler3 = this.f23285a.f23280j;
            handler3.sendMessage(obtainMessage);
        }
    }

    @Override // com.huawei.nfc.sdk.service.HwOpenPayTask.IHwPayResultCallBack
    public final void onResult(Bundle bundle) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        j.b("uppay", "queryHwPayStatus onResult");
        handler = this.f23285a.f23280j;
        if (handler != null) {
            handler2 = this.f23285a.f23280j;
            Message obtainMessage = handler2.obtainMessage(AMapException.CODE_AMAP_SHARE_FAILURE);
            obtainMessage.obj = bundle;
            handler3 = this.f23285a.f23280j;
            handler3.sendMessage(obtainMessage);
        }
    }
}
