package kl;

import com.realsil.sdk.dfu.DfuException;
/* loaded from: classes2.dex */
public class a {
    public static String a(int i10) {
        if (i10 == 0) {
            return "STATE_DISCONNECTED";
        }
        if (i10 == 256) {
            return "STATE_CONNECTING";
        }
        if (i10 == 1024) {
            return "STATE_DISCONNECTING";
        }
        if (i10 == 1280) {
            return "STATE_CLOSED";
        }
        switch (i10) {
            case 512:
                return "STATE_CONNECTED";
            case 513:
                return "STATE_DISCOVER_SERVICE";
            case 514:
                return "SET_PREFERRED_PHY";
            case 515:
                return "STATE_CONNECTED_AND_READY";
            default:
                return "Unknown: " + i10;
        }
    }

    public static String b(int i10) {
        switch (i10) {
            case DfuException.ERROR_FILE_IO_EXCEPTION /* 257 */:
                return "PROGRESS_ORIGIN";
            case DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED /* 258 */:
                return "PROGRESS_IMAGE_ACTIVE_SUCCESS";
            case DfuException.ERROR_LOCK_WAIT_INTERRUPTED /* 259 */:
                return "PROGRESS_ABORTED";
            case DfuException.ERROR_CONNECTION_TIMEOUT /* 260 */:
                return "PROGRESS_PROCESSING_ERROR";
            case DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK /* 261 */:
                return "PROGRESS_COMPLETED";
            default:
                switch (i10) {
                    case 513:
                        return "PROGRESS_INITIALIZE";
                    case 514:
                        return "PROGRESS_STARTED";
                    case 515:
                        return "PROGRESS_SCAN_REMOTE";
                    case 516:
                        return "PROGRESS_CONNECT_REMOTE";
                    case DfuException.ERROR_REMOTE_CRC_ERROR /* 517 */:
                        return "PROGRESS_PREPARE_OTA_ENVIRONMENT";
                    case 518:
                        return "PROGRESS_REMOTE_ENTER_OTA";
                    case 519:
                        return "PROGRESS_SCAN_OTA_REMOTE";
                    case DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR /* 520 */:
                        return "PROGRESS_CONNECT_OTA_REMOTE";
                    case 521:
                        return "PROGRESS_START_DFU_PROCESS";
                    case 522:
                        return "PROGRESS_HAND_OVER_PROCESSING";
                    case 523:
                        return "PROGRESS_PENDING_ACTIVE_IMAGE";
                    case 524:
                        return "PROGRESS_ACTIVE_IMAGE_AND_RESET";
                    case 525:
                        return "PROGRESS_ABORT_PROCESSING";
                    case 526:
                        return "PROGRESS_DOWNLOAD_FIRMWARE";
                    default:
                        return String.format("Unknown: 0x%04X", Integer.valueOf(i10));
                }
        }
    }
}
