package com.mobvoi.wear.proxy;

import android.util.Log;
/* loaded from: classes2.dex */
public class ProxyUtils {
    public static String convertIpAddress(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (byte b10 : bArr) {
            if (!z10) {
                sb2.append('.');
            } else {
                z10 = false;
            }
            sb2.append(b10 & 255);
        }
        return sb2.toString();
    }

    public static boolean isDebugEnabled() {
        return Log.isLoggable("ProxyDebugTag", 3);
    }
}
