package fp;

import com.realsil.sdk.dfu.DfuException;
/* compiled from: SecureDfuError.java */
/* loaded from: classes3.dex */
public final class c {
    public static String a(int i10) {
        switch (i10) {
            case 514:
                return "OP CODE NOT SUPPORTED";
            case 515:
                return "INVALID PARAM";
            case 516:
                return "INSUFFICIENT RESOURCES";
            case DfuException.ERROR_REMOTE_CRC_ERROR /* 517 */:
                return "INVALID OBJECT";
            case 518:
            case 521:
            default:
                return "UNKNOWN (" + i10 + ")";
            case 519:
                return "UNSUPPORTED TYPE";
            case DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR /* 520 */:
                return "OPERATION NOT PERMITTED";
            case 522:
                return "OPERATION FAILED";
            case 523:
                return "EXTENDED ERROR";
        }
    }

    public static String b(int i10) {
        if (i10 == 2050) {
            return "OP CODE NOT SUPPORTED";
        }
        if (i10 == 2052) {
            return "OPERATION FAILED";
        }
        return "UNKNOWN (" + i10 + ")";
    }

    public static String c(int i10) {
        switch (i10) {
            case 1026:
                return "Wrong command format";
            case DfuException.ERROR_WRITE_NOT_PERMIT /* 1027 */:
                return "Unknown command";
            case DfuException.ERROR_GATT_INVALID_PDU /* 1028 */:
                return "Init command invalid";
            case 1029:
                return "FW version failure";
            case 1030:
                return "HW version failure";
            case 1031:
                return "SD version failure";
            case 1032:
                return "Signature mismatch";
            case 1033:
                return "Wrong hash type";
            case 1034:
                return "Hash failed";
            case 1035:
                return "Wrong signature type";
            case 1036:
                return "Verification failed";
            case 1037:
                return "Insufficient space";
            default:
                return "Reserved for future use";
        }
    }
}
