package fp;

import com.realsil.sdk.dfu.DfuException;
/* compiled from: LegacyDfuError.java */
/* loaded from: classes3.dex */
public final class b {
    public static String a(int i10) {
        switch (i10) {
            case DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED /* 258 */:
                return "INVALID STATE";
            case DfuException.ERROR_LOCK_WAIT_INTERRUPTED /* 259 */:
                return "NOT SUPPORTED";
            case DfuException.ERROR_CONNECTION_TIMEOUT /* 260 */:
                return "DATA SIZE EXCEEDS LIMIT";
            case DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK /* 261 */:
                return "INVALID CRC ERROR";
            case DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS /* 262 */:
                return "OPERATION FAILED";
            default:
                return "UNKNOWN (" + i10 + ")";
        }
    }
}
