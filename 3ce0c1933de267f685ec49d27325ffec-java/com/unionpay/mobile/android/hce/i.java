package com.unionpay.mobile.android.hce;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.hce.service.a;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f23407a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f23408b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ f f23409c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(f fVar, String str, String str2) {
        this.f23409c = fVar;
        this.f23407a = str;
        this.f23408b = str2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Handler handler;
        a aVar;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Handler handler2;
        Handler handler3;
        String str;
        String str2;
        Handler handler4;
        Handler handler5;
        Handler handler6;
        int i10;
        handler = this.f23409c.f23402y;
        handler.removeMessages(2006, this.f23407a);
        String str3 = null;
        try {
            aVar = a.AbstractBinderC0261a.a(iBinder);
        } catch (Exception e10) {
            e10.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            try {
                str = this.f23409c.f23382d;
                str2 = this.f23409c.f23383e;
                String str4 = this.f23407a;
                handler4 = this.f23409c.f23402y;
                str3 = aVar.a(str, str2, new b(AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST, str4, handler4));
                handler5 = this.f23409c.f23402y;
                Message obtainMessage = handler5.obtainMessage(2006, this.f23407a);
                handler6 = this.f23409c.f23402y;
                i10 = this.f23409c.f23387i;
                handler6.sendMessageDelayed(obtainMessage, i10);
            } catch (RemoteException e11) {
                e11.printStackTrace();
            } catch (Exception unused) {
            }
            if (str3 != null) {
                String a10 = a.a(str3, this.f23408b);
                concurrentHashMap = this.f23409c.f23400v;
                l lVar = (l) concurrentHashMap.get(this.f23407a);
                if (lVar == null) {
                    lVar = new l(this.f23407a);
                }
                lVar.a(a10);
                lVar.a(aVar);
                lVar.d();
                concurrentHashMap2 = this.f23409c.f23400v;
                concurrentHashMap2.put(this.f23407a, lVar);
                handler2 = this.f23409c.f23402y;
                Message obtainMessage2 = handler2.obtainMessage(2002, this.f23407a);
                handler3 = this.f23409c.f23402y;
                handler3.sendMessage(obtainMessage2);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f23409c.f23402y;
        handler.removeMessages(2006, this.f23407a);
        handler2 = this.f23409c.f23402y;
        Message obtainMessage = handler2.obtainMessage(2005, this.f23407a);
        handler3 = this.f23409c.f23402y;
        handler3.sendMessage(obtainMessage);
    }
}
