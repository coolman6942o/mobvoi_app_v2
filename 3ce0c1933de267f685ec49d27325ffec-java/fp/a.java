package fp;

import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
import com.realsil.sdk.dfu.exception.LoadFileException;
/* compiled from: GattError.java */
/* loaded from: classes3.dex */
public class a {
    public static String a(int i10) {
        if (i10 == 26) {
            return "HCI ERROR UNSUPPORTED REMOTE FEATURE";
        }
        if (i10 == 30) {
            return "HCI ERROR INVALID LMP PARAM";
        }
        if (i10 == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i10 == 42) {
            return "HCI ERROR DIFF TRANSACTION COLLISION";
        }
        if (i10 == 257) {
            return "TOO MANY OPEN CONNECTIONS";
        }
        if (i10 == 58) {
            return "GATT CONTROLLER BUSY";
        }
        if (i10 == 59) {
            return "GATT UNACCEPT CONN INTERVAL";
        }
        switch (i10) {
            case 1:
                return "GATT INVALID HANDLE";
            case 2:
                return "GATT READ NOT PERMIT";
            case 3:
                return "GATT WRITE NOT PERMIT";
            case 4:
                return "GATT INVALID PDU";
            case 5:
                return "GATT INSUF AUTHENTICATION";
            case 6:
                return "GATT REQ NOT SUPPORTED";
            case 7:
                return "GATT INVALID OFFSET";
            case 8:
                return "GATT INSUF AUTHORIZATION";
            case 9:
                return "GATT PREPARE Q FULL";
            case 10:
                return "GATT NOT FOUND";
            case 11:
                return "GATT NOT LONG";
            case 12:
                return "GATT INSUF KEY SIZE";
            case 13:
                return "GATT INVALID ATTR LEN";
            case 14:
                return "GATT ERR UNLIKELY";
            case 15:
                return "GATT INSUF ENCRYPTION";
            case 16:
                return "GATT UNSUPPORT GRP TYPE";
            case 17:
                return "GATT INSUF RESOURCE";
            default:
                switch (i10) {
                    case 128:
                        return "GATT NO RESOURCES";
                    case 129:
                        return "GATT INTERNAL ERROR";
                    case 130:
                        return "GATT WRONG STATE";
                    case 131:
                        return "GATT DB FULL";
                    case 132:
                        return "GATT BUSY";
                    case 133:
                        return "GATT ERROR";
                    case 134:
                        return "GATT CMD STARTED";
                    case 135:
                        return "GATT ILLEGAL PARAMETER";
                    case 136:
                        return "GATT PENDING";
                    case 137:
                        return "GATT AUTH FAIL";
                    case 138:
                        return "GATT MORE";
                    case 139:
                        return "GATT INVALID CFG";
                    case 140:
                        return "GATT SERVICE STARTED";
                    case 141:
                        return "GATT ENCRYPTED NO MITM";
                    case 142:
                        return "GATT NOT ENCRYPTED";
                    case 143:
                        return "GATT CONGESTED";
                    default:
                        switch (i10) {
                            case 253:
                                return "GATT CCCD CFG ERROR";
                            case 254:
                                return "GATT PROCEDURE IN PROGRESS";
                            case 255:
                                return "GATT VALUE OUT OF RANGE";
                            default:
                                switch (i10) {
                                    case 4096:
                                        return "DFU DEVICE DISCONNECTED";
                                    case 4097:
                                        return "DFU FILE NOT FOUND";
                                    case 4098:
                                        return "DFU FILE ERROR";
                                    case 4099:
                                        return "DFU NOT A VALID HEX FILE";
                                    case 4100:
                                        return "DFU IO EXCEPTION";
                                    case 4101:
                                        return "DFU SERVICE DISCOVERY NOT STARTED";
                                    case 4102:
                                        return "DFU CHARACTERISTICS NOT FOUND";
                                    default:
                                        switch (i10) {
                                            case LoadFileException.ERROR_VERSION_CHECK_LOW /* 4104 */:
                                                return "DFU INVALID RESPONSE";
                                            case LoadFileException.ERROR_COMBINE_PACK_MISSING_BUD /* 4105 */:
                                                return "DFU FILE TYPE NOT SUPPORTED";
                                            case LoadFileException.ERROR_COMBINE_PACK_SUB_FILE_INVALID /* 4106 */:
                                                return "BLUETOOTH ADAPTER DISABLED";
                                            case 4107:
                                            case LoadFileException.ERROR_SINGLE_NOT_SUPPORT /* 4108 */:
                                                return "DFU INIT PACKET REQUIRED";
                                            case LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED /* 4109 */:
                                                return "DFU CRC ERROR";
                                            case LoadFileException.ERROR_PACK_EMPTY /* 4110 */:
                                                return "DFU DEVICE NOT BONDED";
                                            default:
                                                return "UNKNOWN (" + i10 + ")";
                                        }
                                }
                        }
                }
        }
    }

    public static String b(int i10) {
        if (i10 == 0) {
            return MonitorResult.SUCCESS;
        }
        if (i10 == 1) {
            return "GATT CONN L2C FAILURE";
        }
        if (i10 == 8) {
            return "GATT CONN TIMEOUT";
        }
        if (i10 == 19) {
            return "GATT CONN TERMINATE PEER USER";
        }
        if (i10 == 22) {
            return "GATT CONN TERMINATE LOCAL HOST";
        }
        if (i10 == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i10 == 62) {
            return "GATT CONN FAIL ESTABLISH";
        }
        if (i10 == 133) {
            return "GATT ERROR";
        }
        if (i10 == 256) {
            return "GATT CONN CANCEL ";
        }
        return "UNKNOWN (" + i10 + ")";
    }

    public static String c(int i10) {
        int i11 = i10 & 3840;
        if (i11 == 256) {
            return b.a(i10);
        }
        if (i11 == 512) {
            return c.a(i10);
        }
        if (i11 == 1024) {
            return c.c(i10);
        }
        if (i11 == 2048) {
            return c.b(i10);
        }
        return "UNKNOWN (" + i10 + ")";
    }
}
