package gn;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.util.Log;
import java.util.List;
/* loaded from: classes2.dex */
public class o {
    public static boolean a(Context context) {
        String w10 = z.v(context).w();
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        if (bluetoothManager == null) {
            Log.i("GattDevive", "Unable to initialize BluetoothManager.");
            return false;
        }
        List<BluetoothDevice> connectedDevices = bluetoothManager.getConnectedDevices(7);
        for (int i10 = 0; i10 < connectedDevices.size(); i10++) {
            if (connectedDevices.get(i10).getAddress().contains(w10)) {
                return true;
            }
        }
        return false;
    }
}
