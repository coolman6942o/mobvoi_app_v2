package com.huawei.hms.hmsscankit;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
/* compiled from: RemoteDecoder.java */
/* loaded from: classes2.dex */
class f extends SimpleDateFormat {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(String str) {
        super(str);
        setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
