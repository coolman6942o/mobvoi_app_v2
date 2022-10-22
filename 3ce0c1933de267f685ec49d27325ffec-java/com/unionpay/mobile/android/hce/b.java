package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.hce.service.b;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
public final class b extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f23353a;

    /* renamed from: b  reason: collision with root package name */
    private String f23354b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f23355c;

    public b(int i10, String str, Handler handler) {
        this.f23353a = i10;
        this.f23354b = str;
        this.f23355c = handler;
    }

    @Override // com.unionpay.mobile.android.hce.service.b
    public final void a(String str) throws RemoteException {
        int i10 = this.f23353a;
        if (i10 == 2003) {
            Bundle bundle = new Bundle();
            bundle.putString("pkgName", this.f23354b);
            bundle.putBoolean(Constant.CASH_LOAD_SUCCESS, false);
            bundle.putString("errCode", str);
            Handler handler = this.f23355c;
            handler.sendMessage(Message.obtain(handler, AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST, bundle));
        } else if (i10 == 2004) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(Constant.CASH_LOAD_SUCCESS, false);
            bundle2.putString("errCode", str);
            Handler handler2 = this.f23355c;
            handler2.sendMessage(Message.obtain(handler2, 2004, bundle2));
        }
    }

    @Override // com.unionpay.mobile.android.hce.service.b
    public final void a(String str, String str2) throws RemoteException {
        int i10 = this.f23353a;
        if (i10 == 2003) {
            Bundle bundle = new Bundle();
            bundle.putString("pkgName", this.f23354b);
            bundle.putBoolean(Constant.CASH_LOAD_SUCCESS, true);
            bundle.putString("result", str);
            bundle.putString("reserved", str2);
            Handler handler = this.f23355c;
            handler.sendMessage(Message.obtain(handler, AMapException.CODE_AMAP_ENGINE_TABLEID_NOT_EXIST, bundle));
        } else if (i10 == 2004) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(Constant.CASH_LOAD_SUCCESS, true);
            bundle2.putString("result", str);
            bundle2.putString("reserved", str2);
            Handler handler2 = this.f23355c;
            handler2.sendMessage(Message.obtain(handler2, 2004, bundle2));
        }
    }
}
