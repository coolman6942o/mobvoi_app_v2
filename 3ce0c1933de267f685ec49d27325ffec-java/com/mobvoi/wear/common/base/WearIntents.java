package com.mobvoi.wear.common.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public interface WearIntents {
    public static final String ACTION_AW_REBOOT_WATCH = "com.mobvoi.wear.action.REBOOT";
    public static final String ACTION_AW_SETUP_BEGIN = "com.mobvoi.wear.action.AW_SETUP_BEGIN";
    public static final String ACTION_PAYMENT_APDU_END = "com.mobvoi.wear.intent.ACTION_PAYMENT_APDU_END";
    public static final String ACTION_PAYMENT_APDU_START = "com.mobvoi.wear.intent.ACTION_PAYMENT_APDU_START";
    public static final String ACTION_PREFIX = "com.mobvoi.wear.action.";
    public static final String ACTION_SPEAKER_DRY_WATER = "com.mobvoi.intent.action.DRAINAGE";
    public static final String CLOSE_NOTIFICATION_ACTION = "com.mobvoi.wear.action.GUIDE_CLOSE_NOTIFICATION";
    public static final String EXTRA_KEY_FROM = "extra.from";
    public static final String EXTRA_KEY_REASON = "extra.reason";
    public static final String START_NOTIFICATION_ACTION = "com.mobvoi.wear.action.GUIDE_START_NOTIFICATION";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ExtraFrom {
        public static final String LAUNCHER = "launcher";
        public static final String NOTIFICATION = "notification";
        public static final String UNKNOWN = "unknown";
    }
}
