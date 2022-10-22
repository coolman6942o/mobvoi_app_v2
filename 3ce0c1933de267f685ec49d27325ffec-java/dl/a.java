package dl;

import android.bluetooth.BluetoothClass;
import com.realsil.sdk.dfu.DfuException;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
/* loaded from: classes2.dex */
public class a {
    public static boolean a(BluetoothClass bluetoothClass, int i10) {
        int deviceClass;
        int deviceClass2;
        int deviceClass3;
        if (i10 == 1) {
            return bluetoothClass.hasService(262144) || (deviceClass3 = bluetoothClass.getDeviceClass()) == 1044 || deviceClass3 == 1048 || deviceClass3 == 1056 || deviceClass3 == 1064;
        }
        if (i10 == 6) {
            return bluetoothClass.hasService(524288) || (deviceClass2 = bluetoothClass.getDeviceClass()) == 1060 || deviceClass2 == 1064 || deviceClass2 == 1068;
        }
        if (i10 == 0) {
            return bluetoothClass.hasService(262144) || (deviceClass = bluetoothClass.getDeviceClass()) == 1028 || deviceClass == 1032 || deviceClass == 1056;
        }
        if (i10 == 2) {
            if (bluetoothClass.hasService(1048576)) {
                return true;
            }
            switch (bluetoothClass.getDeviceClass()) {
                case 256:
                case DfuException.ERROR_CONNECTION_TIMEOUT /* 260 */:
                case DfuException.ERROR_CONNECT_ERROR /* 264 */:
                case DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES /* 268 */:
                case DfuException.ERROR_READ_PATCH_INFO_ERROR /* 272 */:
                case DfuException.ERROR_REQUEST_MTU_NO_CALLBACK /* 276 */:
                case DfuException.ERROR_ENTER_OTA_MODE_FAILED /* 280 */:
                case 512:
                case 516:
                case DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR /* 520 */:
                case 524:
                case 528:
                case 532:
                    return true;
                default:
                    return false;
            }
        } else if (i10 == 3) {
            return (bluetoothClass.getDeviceClass() & 1280) == 1280;
        } else {
            if (i10 == 4 || i10 == 5) {
                return bluetoothClass.hasService(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || (bluetoothClass.getDeviceClass() & 768) == 768;
            }
            return false;
        }
    }
}
