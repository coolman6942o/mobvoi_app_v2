package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.result.VendorPayStatusResult;
import com.unionpay.utils.j;
/* loaded from: classes2.dex */
public final class a extends ITsmCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    private int f23269a = AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED;

    /* renamed from: b  reason: collision with root package name */
    private Handler f23270b;

    public a(Handler handler) {
        this.f23270b = handler;
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onError(String str, String str2) {
        j.b("uppay", "errorCode:" + str + ", errorDesc:" + str2);
        Handler handler = this.f23270b;
        int i10 = this.f23269a;
        handler.sendMessage(Message.obtain(handler, 1, i10, 0, str + str2));
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onResult(Bundle bundle) {
        if (this.f23269a == 4000) {
            j.b("uppay-spay", "query vendor pay status callback");
            bundle.setClassLoader(VendorPayStatusResult.class.getClassLoader());
            Bundle vendorPayStatusResult = ((VendorPayStatusResult) bundle.get("result")).getVendorPayStatusResult();
            Handler handler = this.f23270b;
            handler.sendMessage(Message.obtain(handler, AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED, vendorPayStatusResult));
        }
    }
}
