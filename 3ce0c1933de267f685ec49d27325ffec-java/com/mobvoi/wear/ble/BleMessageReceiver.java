package com.mobvoi.wear.ble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes2.dex */
public abstract class BleMessageReceiver extends BroadcastReceiver {
    private static final String TAG = "BleMessageReceiver";
    private boolean mIsCompanionConnected = false;

    public boolean isCompanionConnected() {
        return this.mIsCompanionConnected;
    }

    public abstract void onCompanionConnected(Context context);

    public abstract void onCompanionDisconnected(Context context);

    public abstract void onMessageReceived(Context context, String str, byte[] bArr);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(BleProtocol.ACTION_COMPANION_CONNECTED)) {
            this.mIsCompanionConnected = true;
            onCompanionConnected(context);
        } else if (action.equals(BleProtocol.ACTION_COMPANION_DISCONNECTED)) {
            this.mIsCompanionConnected = false;
            onCompanionDisconnected(context);
        } else if (action.equals(BleProtocol.ACTION_RECEIVE_MESSAGE)) {
            onMessageReceived(context, intent.getStringExtra("path"), intent.getByteArrayExtra(BleProtocol.EXTRA_PAYLOAD));
        }
    }
}
