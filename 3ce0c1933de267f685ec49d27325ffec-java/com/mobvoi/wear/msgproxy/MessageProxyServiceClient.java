package com.mobvoi.wear.msgproxy;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.mobvoi.android.common.ipc.c;
import com.mobvoi.wear.msgproxy.IMessageProxyService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MessageProxyServiceClient extends c<IMessageProxyService> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageProxyServiceClient(Context context) {
        super(context, "mps");
    }

    @Override // com.mobvoi.android.common.ipc.c
    protected Intent getServiceIntent() {
        Intent intent = new Intent(MessageProxyConstants.ACTION_MASSAGE_PROXY_SERVICE);
        if (MessageProxyClient.getInstance().isStandalone()) {
            intent.setPackage(this.mAppContext.getPackageName());
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.mobvoi.android.common.ipc.c
    public IMessageProxyService asInterface(IBinder iBinder) {
        return IMessageProxyService.Stub.asInterface(iBinder);
    }
}
