package com.mobvoi.wear.common.base;

import u9.b;
/* loaded from: classes2.dex */
public class TicwatchSysProperties {
    private static final String KEY_CERT_MODEL = "ro.oem.tw.cmodel";
    private static final String KEY_CHANNEL = "ro.oem.tw.channel";
    private static final String KEY_VERSION = "ro.oem.tw.version";

    public static String getCertModel() {
        return b.a(KEY_CERT_MODEL, "");
    }

    public static String getChannel() {
        return b.a(KEY_CHANNEL, "");
    }

    public static String getVersion() {
        return b.a(KEY_VERSION, "");
    }
}
