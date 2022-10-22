package com.unionpay.mobile.android.pboctransaction.samsung;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.pboctransaction.samsung.f;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.data.SeAppListItem;
import com.unionpay.tsmservice.data.VirtualCardInfo;
import com.unionpay.tsmservice.result.GetSeAppListResult;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f23836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f23836a = fVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        boolean z10;
        String str;
        f.a aVar;
        Handler handler4;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        int i10;
        Handler handler8;
        Object obj;
        Handler handler9;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        int i11 = message.what;
        if (i11 == 1) {
            handler = this.f23836a.G;
            handler.removeMessages(4);
            k.c("uppay", "msg error");
            f.a(this.f23836a, message.arg1, (String) message.obj);
        } else if (i11 != 1000) {
            if (i11 == 1018) {
                handler3 = this.f23836a.G;
                handler3.removeMessages(4);
                this.f23836a.E = ((Bundle) message.obj).getBoolean("KEY_SUCCESS_VENDOR");
                StringBuilder sb2 = new StringBuilder("mIsVendorStateReady: ");
                z10 = this.f23836a.E;
                sb2.append(z10);
                k.c("uppay-spay", sb2.toString());
                str = "get vendor pay status";
            } else if (i11 == 3) {
                k.c("uppay-spay", "send apdu time out");
                this.f23836a.f23830u = true;
            } else if (i11 != 4) {
                switch (i11) {
                    case AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS /* 1011 */:
                        k.c("uppay", "channel success");
                        Bundle bundle = (Bundle) message.obj;
                        this.f23836a.f23828s = bundle.getString("channel");
                        this.f23836a.f23829t = bundle.getString("apdu");
                        break;
                    case AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES /* 1012 */:
                        k.c("uppay", "apdu success version 3.3.1");
                        handler4 = this.f23836a.G;
                        handler4.removeMessages(3);
                        this.f23836a.f23831v = (String) message.obj;
                        break;
                    case AMapException.CODE_AMAP_USER_KEY_RECYCLED /* 1013 */:
                        k.c("uppay", "close channel success");
                        this.f23836a.f23833x = Constant.CASH_LOAD_SUCCESS;
                        break;
                    case 1014:
                        handler5 = this.f23836a.G;
                        handler5.removeMessages(4);
                        k.c("uppay", "list success");
                        handler6 = this.f23836a.f23824o;
                        if (handler6 != null) {
                            ArrayList arrayList = new ArrayList();
                            SeAppListItem[] seAppList = ((GetSeAppListResult) message.obj).getSeAppList();
                            if (seAppList != null && seAppList.length > 0) {
                                arrayList = new ArrayList();
                                for (int i12 = 0; i12 < seAppList.length; i12++) {
                                    if (!(seAppList[i12] == null || seAppList[i12].getAppDetail() == null || seAppList[i12].getAppDetail().getAppID() == null)) {
                                        String appAid = seAppList[i12].getAppDetail().getAppID().getAppAid();
                                        if (!(appAid == null || appAid.length() <= 16 || "06".equalsIgnoreCase(appAid.substring(14, 16)))) {
                                            arrayList.add(new a(1, seAppList[i12].getAppDetail().getAppID().getAppAid(), "", seAppList[i12].getAppDetail().getMpan(), 1));
                                        }
                                    }
                                }
                            }
                            handler7 = this.f23836a.G;
                            i10 = 8;
                            obj = arrayList;
                            handler8 = handler7;
                            Message obtainMessage = handler8.obtainMessage(i10, obj);
                            handler9 = this.f23836a.f23824o;
                            handler9.sendMessage(obtainMessage);
                            break;
                        }
                        break;
                    case 1015:
                        handler10 = this.f23836a.G;
                        handler10.removeMessages(4);
                        k.c("uppay-spay", "get spay list call back");
                        VirtualCardInfo virtualCardInfo = (VirtualCardInfo) message.obj;
                        Object aVar2 = new a(32, virtualCardInfo.getAppID().getAppAid(), "", virtualCardInfo.getCardNo(), 1);
                        handler11 = this.f23836a.f23824o;
                        i10 = 2000;
                        obj = aVar2;
                        handler8 = handler11;
                        Message obtainMessage2 = handler8.obtainMessage(i10, obj);
                        handler9 = this.f23836a.f23824o;
                        handler9.sendMessage(obtainMessage2);
                        break;
                    case 1016:
                        handler12 = this.f23836a.G;
                        handler12.removeMessages(4);
                        str = "check spay support";
                        break;
                }
            } else {
                k.c("uppay", "timeout");
                f.a(this.f23836a, message.arg1, "");
            }
            k.c("uppay-spay", str);
            aVar = this.f23836a.f23822m;
            aVar.a(true);
        } else {
            handler2 = this.f23836a.G;
            handler2.removeMessages(4);
            k.c("uppay", "init success");
            this.f23836a.a(true);
            this.f23836a.f23817h = true;
        }
        return false;
    }
}
