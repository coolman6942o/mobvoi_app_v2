package com.mobvoi.wear.msgproxy.server;

import android.text.TextUtils;
import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.i;
import com.google.android.gms.wearable.m;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.msgproxy.MessageProxyDispatcher;
/* loaded from: classes2.dex */
public class GmsWearableListenerService extends m {
    private static final String TAG = "GmsWLService";

    @Override // com.google.android.gms.wearable.m, com.google.android.gms.wearable.a.AbstractC0116a
    public void onCapabilityChanged(b bVar) {
        k.i(TAG, "onCapabilityChanged: %s", bVar);
        String name = bVar.getName();
        String peerNodeCapability = MpsConfig.getInstance().getPeerNodeCapability();
        if (TextUtils.isEmpty(peerNodeCapability)) {
            k.q(TAG, "No expected capability. MpsConfig not initialized?");
            return;
        }
        k.c(TAG, "expected capability: %s, incoming: %s", peerNodeCapability, name);
        if (peerNodeCapability.equals(name)) {
            GmsWearableClient.getInstance(this).updateConnectedNodes(bVar.d());
        }
    }

    @Override // com.google.android.gms.wearable.m, com.google.android.gms.wearable.h.a
    public void onMessageReceived(i iVar) {
        k.c(TAG, "onMessageReceived: %s, node: %s", iVar.a(), iVar.u());
        MessageProxyDispatcher.getInstance(this).onMessageReceived(iVar.u(), iVar.a(), iVar.c());
    }
}
