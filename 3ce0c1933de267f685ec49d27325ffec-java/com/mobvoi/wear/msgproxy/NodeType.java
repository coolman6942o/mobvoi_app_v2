package com.mobvoi.wear.msgproxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes2.dex */
public @interface NodeType {
    public static final int PHONE_ANDROID = 3;
    public static final int PHONE_IOS = 4;
    public static final int UNKNOWN = -1;
    public static final int WATCH_TICWEAR = 2;
    public static final int WATCH_WEAR_OS = 1;
}
