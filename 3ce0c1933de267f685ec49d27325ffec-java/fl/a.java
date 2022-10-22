package fl;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    public static byte[] a(String str) {
        byte[] bArr = new byte[6];
        if (str != null) {
            bArr[0] = (byte) ((Character.digit(str.charAt(15), 16) * 16) + Character.digit(str.charAt(16), 16));
            bArr[1] = (byte) ((Character.digit(str.charAt(12), 16) * 16) + Character.digit(str.charAt(13), 16));
            bArr[2] = (byte) ((Character.digit(str.charAt(9), 16) * 16) + Character.digit(str.charAt(10), 16));
            bArr[3] = (byte) ((Character.digit(str.charAt(6), 16) * 16) + Character.digit(str.charAt(7), 16));
            bArr[4] = (byte) ((Character.digit(str.charAt(3), 16) * 16) + Character.digit(str.charAt(4), 16));
            bArr[5] = (byte) ((Character.digit(str.charAt(0), 16) * 16) + Character.digit(str.charAt(1), 16));
        } else {
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 0;
            bArr[4] = 0;
            bArr[5] = 0;
        }
        return bArr;
    }

    public static String b(BluetoothDevice bluetoothDevice) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("BluetoothDevice{ %s/%s", c(bluetoothDevice.getAddress(), true), bluetoothDevice.getName()));
        Locale locale = Locale.US;
        sb2.append(String.format(locale, "\n\tbondState=%d", Integer.valueOf(bluetoothDevice.getBondState())));
        sb2.append(String.format(locale, "\n\ttype=%d", Integer.valueOf(bluetoothDevice.getType())));
        BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
        if (bluetoothClass != null) {
            sb2.append(String.format(locale, "majorDeviceClass=%d", Integer.valueOf(bluetoothClass.getMajorDeviceClass())));
        }
        ParcelUuid[] uuids = bluetoothDevice.getUuids();
        if (uuids != null && uuids.length > 0) {
            sb2.append("\n\tsupportedFeaturesUuids");
            int length = uuids.length;
            for (int i10 = 0; i10 < length; i10++) {
                sb2.append(String.format("\n\t\t%s", uuids[i10].toString()));
            }
        }
        sb2.append("\n}");
        return sb2.toString();
    }

    public static String c(String str, boolean z10) {
        if (!z10) {
            return str;
        }
        if (str == null || str.length() != 17) {
            return "";
        }
        byte[] a10 = a(str);
        return a10.length < 6 ? "" : String.format("**:**:**:%02X:%02X:%02X", Byte.valueOf(a10[2]), Byte.valueOf(a10[1]), Byte.valueOf(a10[0]));
    }

    public static String d(byte[] bArr) {
        if (bArr == null || bArr.length < 6) {
            return null;
        }
        return String.format("%02X:%02X:%02X:%02X:%02X:%02X", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]));
    }

    public static String e(int i10) {
        if (i10 == 16) {
            return "HEADSET_CLIENT";
        }
        if (i10 == 17) {
            return "PBAP_CLIENT";
        }
        switch (i10) {
            case 1:
                return "HEADSET";
            case 2:
                return "A2DP";
            case 3:
                return "HEALTH";
            case 4:
                return "HID_HOST";
            case 5:
                return "PAN";
            case 6:
                return "PBAP";
            case 7:
                return "GATT";
            case 8:
                return "GATT_SERVER";
            case 9:
                return "MAP";
            case 10:
                return "SAP";
            case 11:
                return "A2DP_SINK";
            case 12:
                return "AVRCP_CONTROLLER";
            default:
                return "Unknown";
        }
    }

    public static String f(int i10) {
        if (i10 == 0) {
            return "0-BluetoothProfile.STATE_DISCONNECTED";
        }
        if (i10 == 1) {
            return "1-BluetoothProfile.STATE_CONNECTING";
        }
        if (i10 == 2) {
            return "2-BluetoothProfile.STATE_CONNECTED";
        }
        if (i10 == 3) {
            return "3-BluetoothProfile.STATE_DISCONNECTING";
        }
        return "UNKNOWN (" + i10 + ")";
    }
}
