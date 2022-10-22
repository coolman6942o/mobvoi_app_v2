package com.unionpay;

import android.os.Bundle;
import android.os.Handler;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d implements HwOpenPayTask.IHwResultCallBack {
    @Override // com.huawei.nfc.sdk.service.HwOpenPayTask.IHwResultCallBack
    public final void onResult(int i10, Bundle bundle) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler.Callback callback;
        handler = UPPayAssistEx.U;
        if (handler == null) {
            callback = UPPayAssistEx.Y;
            Handler unused = UPPayAssistEx.U = new Handler(callback);
        }
        handler2 = UPPayAssistEx.U;
        handler3 = UPPayAssistEx.U;
        handler2.sendMessage(handler3.obtainMessage(1003, Integer.valueOf(i10)));
    }
}
