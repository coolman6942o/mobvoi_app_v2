package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.tsm.connect.IInitCallback;
import com.unionpay.mobile.tsm.connect.IRemoteApdu;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f23798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f23798a = aVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Handler handler;
        Handler handler2;
        IRemoteApdu iRemoteApdu;
        IInitCallback.Stub stub;
        IRemoteApdu iRemoteApdu2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        k.a("plugin-tsm", "mConnection.onServiceConnected()");
        handler = this.f23798a.f23792e;
        if (handler != null) {
            handler5 = this.f23798a.f23792e;
            handler5.removeMessages(AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE);
        }
        try {
            this.f23798a.f23793f = true;
            this.f23798a.f23789b = IRemoteApdu.Stub.asInterface(iBinder);
            handler2 = this.f23798a.f23792e;
            if (handler2 != null) {
                handler3 = this.f23798a.f23792e;
                handler4 = this.f23798a.f23792e;
                handler3.sendMessageDelayed(Message.obtain(handler4, (int) AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE), 8000L);
            }
            iRemoteApdu = this.f23798a.f23789b;
            stub = this.f23798a.f23796i;
            iRemoteApdu.registerCallback(stub);
            iRemoteApdu2 = this.f23798a.f23789b;
            iRemoteApdu2.init();
        } catch (Exception unused) {
            b bVar = this.f23798a.f23788a;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Handler handler;
        Handler handler2;
        k.a("plugin-tsm", "mConnection.onServiceDisconnected()");
        handler = this.f23798a.f23792e;
        if (handler != null) {
            handler2 = this.f23798a.f23792e;
            handler2.removeMessages(AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE);
        }
        this.f23798a.f23789b = null;
        b bVar = this.f23798a.f23788a;
        if (bVar != null) {
            bVar.b();
        }
    }
}
