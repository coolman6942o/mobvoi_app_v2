package com.google.android.gms.common.api;

import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
/* loaded from: classes.dex */
public class b {
    public static String a(int i10) {
        switch (i10) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return MonitorResult.SUCCESS;
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("unknown status code: ");
                sb2.append(i10);
                return sb2.toString();
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return "ERROR";
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
        }
    }
}
