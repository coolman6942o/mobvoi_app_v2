package com.google.android.gms.wearable;

import com.amap.api.services.core.AMapException;
import com.google.android.gms.common.api.b;
/* loaded from: classes.dex */
public final class n extends b {
    public static String a(int i10) {
        switch (i10) {
            case AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED /* 4000 */:
                return "TARGET_NODE_NOT_CONNECTED";
            case AMapException.CODE_AMAP_SHARE_FAILURE /* 4001 */:
                return "DUPLICATE_LISTENER";
            case AMapException.CODE_AMAP_SHARE_SIGNATURE_FAILURE /* 4002 */:
                return "UNKNOWN_LISTENER";
            case 4003:
                return "DATA_ITEM_TOO_LARGE";
            case 4004:
                return "INVALID_TARGET_NODE";
            case 4005:
                return "ASSET_UNAVAILABLE";
            default:
                return b.a(i10);
        }
    }
}
