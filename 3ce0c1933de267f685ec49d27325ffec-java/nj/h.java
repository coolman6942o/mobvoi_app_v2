package nj;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.util.Log;
import gn.z;
import java.util.List;
/* compiled from: GattDeviceConnection.java */
/* loaded from: classes2.dex */
public class h {
    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context) {
        String w10 = z.v(context).w();
        boolean j10 = z.v(context).j();
        Log.i("GattDevice", "ble_connect=" + j10);
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            Log.i("GattDevice", "Unable to initialize BluetoothManager.");
            return false;
        }
        List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(7);
        Log.i("GattDevice", "devices=" + connectedDevices);
        for (int i10 = 0; i10 < connectedDevices.size(); i10++) {
            Log.i("GattDevice", "-----connect-->name =" + connectedDevices.get(i10).getName() + " address=" + connectedDevices.get(i10).getAddress());
            if (connectedDevices.get(i10).getAddress().contains(w10)) {
                return true;
            }
        }
        return false;
    }
}
