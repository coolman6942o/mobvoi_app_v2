package gn;

import android.bluetooth.BluetoothAdapter;
/* loaded from: classes2.dex */
public class e {
    public static boolean a() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            return false;
        }
        boolean disable = defaultAdapter.disable();
        u.a("AboutActivity", "trunOff=" + disable + ",bluetoothAdapter=" + defaultAdapter);
        if (!disable) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e10) {
            u.a("AboutActivity", "reBootBluetooth e=" + e10);
            e10.printStackTrace();
        }
        boolean enable = defaultAdapter.enable();
        u.a("AboutActivity", "trunOn=" + enable + ",bluetoothAdapter=" + defaultAdapter);
        return enable;
    }
}
