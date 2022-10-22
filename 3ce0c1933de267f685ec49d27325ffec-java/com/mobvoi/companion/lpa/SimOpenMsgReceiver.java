package com.mobvoi.companion.lpa;

import android.app.Application;
import android.content.Intent;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyReceiver;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.d;
/* compiled from: SimOpenMsgReceiver.kt */
/* loaded from: classes2.dex */
public final class SimOpenMsgReceiver extends MessageProxyReceiver {

    /* compiled from: SimOpenMsgReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyReceiver, com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<? extends NodeInfo> nodes) {
        i.f(nodes, "nodes");
        k.c("MessageProxyReceiver", "onConnectedNodesChanged: %s", nodes);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyReceiver, com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo message) {
        i.f(message, "message");
        byte[] payload = message.getPayload();
        i.e(payload, "message.payload");
        k.c("MessageProxyReceiver", "onMessageReceived: %s, data: %s", message, new String(payload, d.f30092a));
        if (i.b(message.getPath(), WearPath.Lpa.OPEN_TUTORIAL_ON_PHONE_PATH)) {
            Application e10 = b.e();
            i.e(e10, "getApplication()");
            Intent intent = new Intent(e10, SimOpenBaseActivity.class);
            intent.addFlags(268435456);
            e10.startActivity(intent);
        }
    }
}
