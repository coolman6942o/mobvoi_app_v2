package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
/* compiled from: OnLightVisibleCallBackDelegata.java */
/* loaded from: classes2.dex */
class d extends IOnLightCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    private final OnLightVisibleCallBack f13995a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.f13995a = onLightVisibleCallBack;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnLightCallback
    public void onVisibleChanged(boolean z10) throws RemoteException {
        this.f13995a.onVisibleChanged(z10);
    }
}
