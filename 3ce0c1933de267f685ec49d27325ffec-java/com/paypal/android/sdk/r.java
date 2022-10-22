package com.paypal.android.sdk;

import java.io.ByteArrayInputStream;
import java.util.Properties;
/* loaded from: classes2.dex */
public final class r {
    /* JADX WARN: Finally extract failed */
    public static String a(String str) {
        Properties properties = new Properties();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("suFileName=/system/xbin/su\nsuperUserApk=/system/app/Superuser.apk\nemptyIp=0.0.0.0".getBytes());
        try {
            properties.load(byteArrayInputStream);
            byteArrayInputStream.close();
            return properties.getProperty(str);
        } catch (Throwable th2) {
            byteArrayInputStream.close();
            throw th2;
        }
    }
}
