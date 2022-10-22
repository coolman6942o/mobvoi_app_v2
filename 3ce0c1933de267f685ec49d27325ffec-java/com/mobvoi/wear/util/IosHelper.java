package com.mobvoi.wear.util;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Set;
/* loaded from: classes2.dex */
public class IosHelper {
    private static final String TAG = "IosHelper";

    public static boolean checkIfIosConnected() {
        Set<BluetoothDevice> bondedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        if (bondedDevices != null) {
            for (BluetoothDevice bluetoothDevice : bondedDevices) {
                int type = bluetoothDevice.getType();
                k.c(TAG, "[device] name = %s, type = %d, address = %s", bluetoothDevice.getName(), Integer.valueOf(type), bluetoothDevice.getAddress());
                if (type == 2) {
                    return true;
                }
                if (type == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void trySetupPairedPlatform(Context context) {
        SharedWearInfoHelper sharedWearInfoHelper = SharedWearInfoHelper.getInstance(context);
        if (sharedWearInfoHelper.getPairedPlatform() == 0) {
            boolean checkIfIosConnected = checkIfIosConnected();
            k.i(TAG, "setup paired platform, check iOS connected result: %s", Boolean.valueOf(checkIfIosConnected));
            if (checkIfIosConnected) {
                sharedWearInfoHelper.setPairedPlatform(2);
            } else {
                sharedWearInfoHelper.setPairedPlatform(1);
            }
        }
    }
}
