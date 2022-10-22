package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.unionpay.tsmservice.mi.ITsmCallback;
import com.unionpay.tsmservice.mi.result.VendorPayStatusResult;
/* loaded from: classes2.dex */
public final class j extends ITsmCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    private int f23298a = AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED;

    /* renamed from: b  reason: collision with root package name */
    private Handler f23299b;

    public j(Handler handler) {
        this.f23299b = handler;
    }

    @Override // com.unionpay.tsmservice.mi.ITsmCallback
    public final void onError(String str, String str2) {
        com.unionpay.utils.j.b("uppay", "errorCode:" + str + ", errorDesc:" + str2);
        Handler handler = this.f23299b;
        int i10 = this.f23298a;
        handler.sendMessage(Message.obtain(handler, 1, i10, 0, str + str2));
    }

    @Override // com.unionpay.tsmservice.mi.ITsmCallback
    public final void onResult(Bundle bundle) {
        if (this.f23298a == 4000) {
            com.unionpay.utils.j.b("uppay-spay", "query vendor pay status callback");
            bundle.setClassLoader(VendorPayStatusResult.class.getClassLoader());
            Bundle vendorPayStatusResult = ((VendorPayStatusResult) bundle.get("result")).getVendorPayStatusResult();
            Handler handler = this.f23299b;
            handler.sendMessage(Message.obtain(handler, AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED, vendorPayStatusResult));
        }
    }
}
