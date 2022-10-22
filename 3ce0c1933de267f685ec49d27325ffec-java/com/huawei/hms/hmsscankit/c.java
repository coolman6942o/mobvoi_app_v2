package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.util.Log;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
/* compiled from: OnErrorCallbackDelegate.java */
/* loaded from: classes2.dex */
class c extends IOnErrorCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    private final OnErrorCallback f13994a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(OnErrorCallback onErrorCallback) {
        this.f13994a = onErrorCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnErrorCallback
    public void onError(int i10) throws RemoteException {
        if (this.f13994a != null) {
            Log.i("OnErrorCallbackDelegate", "onError: ErrorCode：" + i10);
            this.f13994a.onError(i10);
        }
    }
}
