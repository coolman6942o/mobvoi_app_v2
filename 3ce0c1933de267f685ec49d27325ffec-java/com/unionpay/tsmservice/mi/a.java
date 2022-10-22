package com.unionpay.tsmservice.mi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.unionpay.tsmservice.mi.ITsmActivityCallback;
/* loaded from: classes2.dex */
public final class a extends ITsmActivityCallback.Stub {

    /* renamed from: a  reason: collision with root package name */
    private Context f24574a;

    public a(Context context) {
        this.f24574a = context;
    }

    @Override // com.unionpay.tsmservice.mi.ITsmActivityCallback
    public final void startActivity(String str, String str2, int i10, Bundle bundle) {
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (i10 != -1) {
            intent.setFlags(i10);
        }
        intent.setComponent(componentName);
        this.f24574a.startActivity(intent);
    }
}
