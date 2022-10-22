package com.mobvoi.wear.msgproxy.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.ble.BleProtocol;
import com.mobvoi.wear.msgproxy.MessageProxyService;
import com.mobvoi.wear.msgproxy.NodeInfo;
import com.mobvoi.wear.util.AwUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class AwWearMessageProxyService extends MessageProxyService {
    private static final String TAG = "AwMsgProxyService";
    private static WearableClient sWearableClient;
    private final BroadcastReceiver mVsMsgReceiver = new BroadcastReceiver() { // from class: com.mobvoi.wear.msgproxy.server.AwWearMessageProxyService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(BleProtocol.EXTRA_NODE);
            String stringExtra2 = intent.getStringExtra("path");
            byte[] byteArrayExtra = intent.getByteArrayExtra(BleProtocol.EXTRA_PAYLOAD);
            k.c(AwWearMessageProxyService.TAG, "onReceive() called with: path = [%s]", stringExtra2);
            if (!TextUtils.isEmpty(stringExtra2)) {
                AwWearMessageProxyService.this.sendMessage(stringExtra, stringExtra2, byteArrayExtra);
            } else {
                k.a(AwWearMessageProxyService.TAG, "mVsMsgReceiver path is empty");
            }
        }
    };

    private static WearableClient getWearableClient(Context context) {
        WearableClient wearableClient = sWearableClient;
        if (wearableClient != null) {
            return wearableClient;
        }
        int phoneDeviceType = AwUtils.getPhoneDeviceType(context);
        if (phoneDeviceType == 1) {
            k.h(TAG, "setup GMS wearable client");
            sWearableClient = GmsWearableClient.getInstance(context);
        } else if (phoneDeviceType == 2) {
            k.h(TAG, "setup BLE wearable client");
            synchronized (AwWearMessageProxyService.class) {
                if (sWearableClient == null) {
                    sWearableClient = new BleWearableClient(context);
                }
            }
        } else {
            k.c(TAG, "unknown phone device type %d", Integer.valueOf(phoneDeviceType));
        }
        return sWearableClient;
    }

    public static void onAppStart(Context context) {
        MpsConfig.getInstance().init(2, true, false);
        context.startService(new Intent(context, AwWearMessageProxyService.class));
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        WearableClient wearableClient = getWearableClient(this);
        if (wearableClient == null) {
            printWriter.append("Not paired, cannot dump");
            return;
        }
        if (wearableClient instanceof GmsWearableClient) {
            printWriter.append("Local node: ").append((CharSequence) String.valueOf(GmsWearableClient.getInstance(this).getLocalNode()));
            printWriter.println();
        }
        printWriter.append("Connected nodes: ").append((CharSequence) String.valueOf(wearableClient.getConnectedNodes()));
        printWriter.println();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyService
    public List<NodeInfo> getConnectedNodes() {
        WearableClient wearableClient = getWearableClient(this);
        return wearableClient != null ? wearableClient.getConnectedNodes() : Collections.emptyList();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyService
    public boolean hasConnectedNodes() {
        WearableClient wearableClient = getWearableClient(this);
        return wearableClient != null && wearableClient.hasConnectedNodes();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyService, android.app.Service
    public void onCreate() {
        super.onCreate();
        registerReceiver(this.mVsMsgReceiver, new IntentFilter(BleProtocol.ACTION_SEND_MESSAGE));
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mVsMsgReceiver);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyService
    public void sendMessage(String str, String str2, byte[] bArr) {
        WearableClient wearableClient = getWearableClient(this);
        if (wearableClient != null) {
            wearableClient.sendMessage(str, str2, bArr);
        } else {
            k.s(TAG, "not provisioned, cannot send message: %s", str2);
        }
    }
}
