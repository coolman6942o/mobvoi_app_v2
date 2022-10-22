package com.unionpay.tsmservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.unionpay.tsmservice.ITsmActivityCallback;
/* loaded from: classes2.dex */
public final class a extends ITsmActivityCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    private Context f24525a;

    public a(Context context) {
        this.f24525a = context;
    }

    @Override // com.unionpay.tsmservice.ITsmActivityCallback
    public final void startActivity(String str, String str2, int i10, Bundle bundle) throws RemoteException {
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (i10 != -1) {
            intent.setFlags(i10);
        }
        intent.setComponent(componentName);
        this.f24525a.startActivity(intent);
    }
}
