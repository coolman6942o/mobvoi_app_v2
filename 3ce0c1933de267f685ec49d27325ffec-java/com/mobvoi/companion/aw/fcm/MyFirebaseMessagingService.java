package com.mobvoi.companion.aw.fcm;

import android.content.Intent;
import android.text.TextUtils;
import b1.a;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.aw.base.App;
import com.mobvoi.wear.ble.BleProtocol;
import com.mobvoi.wear.util.TelephonyUtil;
import java.util.Map;
/* loaded from: classes2.dex */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void g(RemoteMessage remoteMessage) {
        Map<String, String> G0 = remoteMessage.G0();
        k.c("MyFirebaseService", "onMessageReceived remoteMessage.getData : %s", G0);
        if (G0 != null && G0.size() > 0) {
            if (G0.containsKey(TelephonyUtil.KEY_SIM_ACTION)) {
                String str = G0.get(TelephonyUtil.KEY_SIM_ACTION);
                String str2 = G0.get("bin");
                String str3 = G0.get("adviceId");
                String str4 = G0.get("validity");
                long currentTimeMillis = System.currentTimeMillis();
                if ((str4 == null || currentTimeMillis <= Long.parseLong(str4)) && TextUtils.equals(str, "sendBin") && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    Intent intent = new Intent("com.mobvoi.action.notification.bin");
                    intent.putExtra("extra.notification", str2);
                    intent.putExtra("extra.notification_id", str3);
                    a.b(App.d()).d(intent);
                }
            } else if (G0.containsKey("path")) {
                Intent intent2 = new Intent(G0.get("path"));
                intent2.putExtra(BleProtocol.EXTRA_PAYLOAD, G0.get(BleProtocol.EXTRA_PAYLOAD));
                a.b(App.d()).d(intent2);
            }
        }
    }
}
