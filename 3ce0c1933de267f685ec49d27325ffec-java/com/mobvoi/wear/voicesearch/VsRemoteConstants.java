package com.mobvoi.wear.voicesearch;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class VsRemoteConstants {

    /* loaded from: classes2.dex */
    public @interface ErrorCode {
        public static final int OK = 0;
        public static final int SESSION_STARTED_ALREADY = 2;
        public static final int UNAVAILABLE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Event {
        public static final int QW_CALL_LAST_DIAL_IN = 2;
        public static final int QW_PAY = 1;
        public static final int QW_TIME_NOW = 3;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface VsSessionType {
        public static final int JOKE = 3;
        public static final int NORMAL = 0;
        public static final int PUSH_TO_TALK = 1;
        public static final int SECRETARY = 2;
    }

    public static String errorCodeStr(@ErrorCode int i10) {
        if (i10 == 0) {
            return "OK";
        }
        if (i10 == 1) {
            return "UNAVAILABLE";
        }
        if (i10 == 2) {
            return "SESSION_STARTED_ALREADY";
        }
        return "UNKNOWN-" + i10;
    }

    public static String getEventLabel(int i10) {
        if (i10 == 0) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        if (i10 == 1) {
            return "QW_PAY";
        }
        if (i10 == 2) {
            return "QW_CALL_LAST_DIAL_IN";
        }
        if (i10 == 3) {
            return "QW_TIME_NOW";
        }
        return "UNKNOWN (" + i10 + ")";
    }

    public static String getSessionTypeLabel(int i10) {
        if (i10 == 0) {
            return "NORMAL";
        }
        if (i10 == 1) {
            return "PUSH_TO_TALK";
        }
        if (i10 == 2) {
            return "SECRETARY";
        }
        if (i10 == 3) {
            return "JOKE";
        }
        return "UNKNOWN (" + i10 + ")";
    }
}
