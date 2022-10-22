package dl;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class b {
    public static void a(BluetoothDevice bluetoothDevice) {
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        if (uuids != null && uuids.length > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("supported features (UUIDs)");
            for (ParcelUuid parcelUuid : uuids) {
                sb2.append("\n\t" + parcelUuid.toString());
            }
            il.b.j(sb2.toString());
        }
    }

    public static String b(int i10) {
        switch (i10) {
            case 0:
                return "PAIRING_VARIANT_PIN";
            case 1:
                return "PAIRING_VARIANT_PASSKEY";
            case 2:
                return "PAIRING_VARIANT_PASSKEY_CONFIRMATION";
            case 3:
                return "PAIRING_VARIANT_CONSENT";
            case 4:
                return "PAIRING_VARIANT_DISPLAY_PASSKEY";
            case 5:
                return "PAIRING_VARIANT_DISPLAY_PIN";
            case 6:
                return "PAIRING_VARIANT_OOB_CONSENT";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static boolean c(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("removeBond", null);
            if (method == null) {
                return false;
            }
            method.setAccessible(true);
            return ((Boolean) method.invoke(bluetoothDevice, null)).booleanValue();
        } catch (Exception e10) {
            il.b.l("An exception occurred while removing bond information: " + e10.getMessage());
            return false;
        }
    }
}
