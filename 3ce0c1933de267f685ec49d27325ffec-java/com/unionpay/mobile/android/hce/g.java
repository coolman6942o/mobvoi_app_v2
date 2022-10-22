package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.data.Constant;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f23403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f23403a = fVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        String str;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        ConcurrentHashMap concurrentHashMap4;
        ConcurrentHashMap concurrentHashMap5;
        ConcurrentHashMap concurrentHashMap6;
        switch (message.what) {
            case 2001:
                f.a(this.f23403a);
                this.f23403a.b();
                return false;
            case 2002:
                str = (String) message.obj;
                break;
            case AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST /* 2003 */:
                Bundle bundle = (Bundle) message.obj;
                if (bundle == null) {
                    return false;
                }
                String string = bundle.getString("pkgName");
                boolean z10 = bundle.getBoolean(Constant.CASH_LOAD_SUCCESS);
                String string2 = bundle.getString("result");
                String string3 = bundle.getString("reserved");
                k.c("yitong", "result: " + string2);
                concurrentHashMap = this.f23403a.f23399u;
                d dVar = (d) concurrentHashMap.get(string);
                if (dVar == null) {
                    dVar = new d(string);
                }
                if (z10) {
                    dVar.a(string2);
                    dVar.b(string3);
                }
                dVar.e();
                concurrentHashMap2 = this.f23403a.f23399u;
                concurrentHashMap2.put(string, dVar);
                f.a(this.f23403a, string);
                return false;
            case 2004:
            default:
                return false;
            case 2005:
            case 2006:
                str = (String) message.obj;
                concurrentHashMap3 = this.f23403a.f23399u;
                d dVar2 = (d) concurrentHashMap3.get(str);
                concurrentHashMap4 = this.f23403a.f23400v;
                l lVar = (l) concurrentHashMap4.get(str);
                dVar2.f();
                concurrentHashMap5 = this.f23403a.f23399u;
                concurrentHashMap5.put(str, dVar2);
                lVar.e();
                concurrentHashMap6 = this.f23403a.f23400v;
                concurrentHashMap6.put(str, lVar);
                break;
        }
        f.a(this.f23403a, str);
        return false;
    }
}
