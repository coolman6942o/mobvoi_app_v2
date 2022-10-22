package com.mobvoi.companion.common.receiver;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.wear.WearPairingPool;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.u;
/* compiled from: BleStateChangeReceiver.kt */
/* loaded from: classes2.dex */
public final class BleStateChangeReceiver extends BroadcastReceiver {

    /* compiled from: BleStateChangeReceiver.kt */
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

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean I;
        i.f(context, "context");
        i.f(intent, "intent");
        if (i.b("android.bluetooth.device.action.ACL_DISCONNECTED", intent.getAction())) {
            k.a("BleStateChangeReceiver", "BleStateChangeReceiver ACTION_ACL_DISCONNECTED");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null && !TextUtils.isEmpty(bluetoothDevice.getName())) {
                String name = bluetoothDevice.getName();
                i.e(name, "device.name");
                I = u.I(name, "watch", false, 2, null);
                if (I) {
                    k.c("BleStateChangeReceiver", "device name : %s", bluetoothDevice.getName());
                    WearPairingPool.i().t("");
                }
            }
        }
    }
}
