package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.unionpay.UPSEInfoResp;
import com.unionpay.utils.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f23282a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Handler handler;
        String str;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        int i10;
        boolean z10;
        int i11 = message.what;
        if (i11 != 1) {
            if (i11 != 4) {
                switch (i11) {
                    case AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED /* 4000 */:
                        handler2 = this.f23282a.f23280j;
                        handler2.removeMessages(4);
                        b.a(this.f23282a, (Bundle) message.obj);
                        break;
                    case AMapException.CODE_AMAP_SHARE_FAILURE /* 4001 */:
                        handler3 = this.f23282a.f23280j;
                        handler3.removeMessages(4003);
                        Object obj = message.obj;
                        if (obj instanceof Bundle) {
                            b.b(this.f23282a, (Bundle) obj);
                            break;
                        }
                        break;
                    case AMapException.CODE_AMAP_SHARE_SIGNATURE_FAILURE /* 4002 */:
                        handler4 = this.f23282a.f23280j;
                        handler4.removeMessages(4003);
                        Object obj2 = message.obj;
                        if (obj2 instanceof Bundle) {
                            b.c(this.f23282a, (Bundle) obj2);
                            break;
                        }
                        break;
                    case 4003:
                        str = "queryHwPayStatus timeout";
                        break;
                    case 4004:
                        handler5 = this.f23282a.f23280j;
                        handler5.removeMessages(4005);
                        try {
                            i10 = ((Integer) message.obj).intValue();
                        } catch (Exception unused) {
                            i10 = 0;
                        }
                        z10 = this.f23282a.f23277g;
                        if (!z10) {
                            if (i10 == 1) {
                                b.e(this.f23282a);
                                break;
                            }
                            this.f23282a.c();
                            break;
                        }
                        break;
                    case 4005:
                        j.b("uppay", "QUERY_VENDOR_CAPACITY_TIMEOUT");
                        this.f23282a.f23277g = true;
                        this.f23282a.c();
                        break;
                }
            } else {
                str = "timeout";
            }
            j.b("uppay", str);
            r7.a(r7.f23274d, this.f23282a.f23275e, UPSEInfoResp.ERROR_TIMEOUT, "timeout");
            this.f23282a.f23272b = null;
        } else {
            handler = this.f23282a.f23280j;
            handler.removeMessages(4);
            j.b("uppay", "msg error");
            b.a(this.f23282a, message.arg1, (String) message.obj);
        }
        return false;
    }
}
