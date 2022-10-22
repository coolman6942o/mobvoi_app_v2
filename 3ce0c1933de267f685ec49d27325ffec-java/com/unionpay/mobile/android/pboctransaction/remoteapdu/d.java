package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.os.Handler;
import android.os.RemoteException;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.tsm.connect.IInitCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d extends IInitCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f23799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f23799a = aVar;
    }

    @Override // com.unionpay.mobile.tsm.connect.IInitCallback
    public final void initFailed() throws RemoteException {
        Handler handler;
        Handler handler2;
        k.a("plugin-tsm", "mInitCallback.initFailed()");
        handler = this.f23799a.f23792e;
        if (handler != null) {
            handler2 = this.f23799a.f23792e;
            handler2.removeMessages(AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE);
        }
        b bVar = this.f23799a.f23788a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.unionpay.mobile.tsm.connect.IInitCallback
    public final void initSucceed() throws RemoteException {
        Handler handler;
        Handler handler2;
        k.a("plugin-tsm", "mInitCallback.initSucceed()");
        handler = this.f23799a.f23792e;
        if (handler != null) {
            handler2 = this.f23799a.f23792e;
            handler2.removeMessages(AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE);
        }
        b bVar = this.f23799a.f23788a;
        if (bVar != null) {
            bVar.a();
        }
    }
}
