package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.VirtualCardInfo;
import com.unionpay.tsmservice.result.CheckSSamsungPayResult;
import com.unionpay.tsmservice.result.GetCardInfoBySpayResult;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import com.unionpay.tsmservice.result.InitResult;
import com.unionpay.tsmservice.result.OpenChannelResult;
import com.unionpay.tsmservice.result.SendApduResult;
import com.unionpay.tsmservice.result.VendorPayStatusResult;
/* loaded from: classes2.dex */
public final class e extends ITsmCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    private int f23808a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f23809b;

    public e(int i10, Handler handler) {
        this.f23808a = i10;
        this.f23809b = handler;
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onError(String str, String str2) throws RemoteException {
        Handler handler;
        Message obtain;
        Log.e("uppay", "errorCode:" + str + ", errorDesc:" + str2);
        if (!"1003700023".equals(str) || this.f23808a != 1018) {
            handler = this.f23809b;
            obtain = Message.obtain(handler, 1, this.f23808a, 0, str);
        } else {
            k.c("uppay", "error 100370023 from get vendor pay status");
            Bundle bundle = new Bundle();
            bundle.putBoolean("KEY_SUCCESS_VENDOR", false);
            handler = this.f23809b;
            obtain = Message.obtain(handler, 1018, bundle);
        }
        handler.sendMessage(obtain);
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onResult(Bundle bundle) throws RemoteException {
        int i10 = this.f23808a;
        if (i10 == 1000) {
            bundle.setClassLoader(InitResult.class.getClassLoader());
            Handler handler = this.f23809b;
            handler.sendMessage(Message.obtain(handler, 1000, bundle));
        } else if (i10 != 1018) {
            switch (i10) {
                case AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS /* 1011 */:
                    bundle.setClassLoader(OpenChannelResult.class.getClassLoader());
                    OpenChannelResult openChannelResult = (OpenChannelResult) bundle.get("result");
                    String channel = openChannelResult.getChannel();
                    String outHexApdu = openChannelResult.getOutHexApdu();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("channel", channel);
                    bundle2.putString("apdu", outHexApdu);
                    Handler handler2 = this.f23809b;
                    handler2.sendMessage(Message.obtain(handler2, AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS, bundle2));
                    return;
                case AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES /* 1012 */:
                    bundle.setClassLoader(SendApduResult.class.getClassLoader());
                    String outHexApdu2 = ((SendApduResult) bundle.get("result")).getOutHexApdu();
                    Handler handler3 = this.f23809b;
                    handler3.sendMessage(Message.obtain(handler3, AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES, outHexApdu2));
                    return;
                case AMapException.CODE_AMAP_USER_KEY_RECYCLED /* 1013 */:
                    Handler handler4 = this.f23809b;
                    handler4.sendMessage(Message.obtain(handler4, AMapException.CODE_AMAP_USER_KEY_RECYCLED, ""));
                    return;
                case 1014:
                    bundle.setClassLoader(GetSeAppListResult.class.getClassLoader());
                    Handler handler5 = this.f23809b;
                    handler5.sendMessage(Message.obtain(handler5, 1014, (GetSeAppListResult) bundle.get("result")));
                    return;
                case 1015:
                    bundle.setClassLoader(GetCardInfoBySpayResult.class.getClassLoader());
                    VirtualCardInfo virtualCardInfo = ((GetCardInfoBySpayResult) bundle.get("result")).getVirtualCardInfo();
                    Handler handler6 = this.f23809b;
                    handler6.sendMessage(Message.obtain(handler6, 1015, virtualCardInfo));
                    return;
                case 1016:
                    k.c("uppay-spay", "check spay support callback");
                    bundle.setClassLoader(CheckSSamsungPayResult.class.getClassLoader());
                    bundle.get("result");
                    Handler handler7 = this.f23809b;
                    handler7.sendMessage(Message.obtain(handler7, 1016, ""));
                    return;
                default:
                    return;
            }
        } else {
            k.c("uppay-spay", "get vendor pay status callback");
            bundle.setClassLoader(VendorPayStatusResult.class.getClassLoader());
            Bundle vendorPayStatusResult = ((VendorPayStatusResult) bundle.get("result")).getVendorPayStatusResult();
            vendorPayStatusResult.putBoolean("KEY_SUCCESS_VENDOR", true);
            Handler handler8 = this.f23809b;
            handler8.sendMessage(Message.obtain(handler8, 1018, vendorPayStatusResult));
            k.c("unpay", "result vendorPayStatusResult max card num reached:" + vendorPayStatusResult.getBoolean(Constant.KEY_MAX_CARD_NUM_REACHED));
        }
    }
}
