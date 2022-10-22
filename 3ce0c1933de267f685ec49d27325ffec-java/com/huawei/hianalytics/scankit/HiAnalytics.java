package com.huawei.hianalytics.scankit;

import android.content.Context;
import com.huawei.hianalytics.mn.no.b.st;
import com.huawei.hianalytics.mn.rs.mn;
import com.huawei.hianalytics.mn.rs.op;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public abstract class HiAnalytics {
    private static op defaultInstance;

    public static void clearCachedData() {
        if (st.mn().no()) {
            mn.mn().no();
        }
    }

    private static synchronized op getDefaultInstance() {
        op opVar;
        synchronized (HiAnalytics.class) {
            if (defaultInstance == null) {
                defaultInstance = mn.mn().no();
            }
            opVar = defaultInstance;
        }
        return opVar;
    }

    public static boolean getInitFlag() {
        return mn.mn().op();
    }

    public static void onEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() != null && st.mn().no()) {
            if (i10 == 1 || i10 == 0) {
                defaultInstance.mn(i10, str, linkedHashMap);
            } else {
                com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "Data type no longer collects range.type: ".concat(String.valueOf(i10)));
            }
        }
    }

    @Deprecated
    public static void onEvent(Context context, String str, String str2) {
        if (getDefaultInstance() != null) {
            defaultInstance.mn(context, str, str2);
        }
    }

    public static void onEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.mn(0, str, linkedHashMap);
        }
    }

    public static void onPause(Context context) {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.mn(context);
        }
    }

    public static void onPause(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.mn(context, linkedHashMap);
        }
    }

    public static void onPause(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.mn(str, linkedHashMap);
        }
    }

    public static void onReport() {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.mn(-1);
        }
    }

    @Deprecated
    public static void onReport(Context context) {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.mn(context, -1);
        }
    }

    public static void onResume(Context context) {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.no(context);
        }
    }

    public static void onResume(Context context, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.no(context, linkedHashMap);
        }
    }

    public static void onResume(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() != null && st.mn().no()) {
            defaultInstance.no(str, linkedHashMap);
        }
    }

    public static void onStreamEvent(int i10, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (getDefaultInstance() != null && st.mn().no()) {
            if (i10 == 1 || i10 == 0) {
                defaultInstance.no(i10, str, linkedHashMap);
            } else {
                com.huawei.hianalytics.mn.no.qr.mn.no("hmsSdk", "Data type no longer collects range.type: ".concat(String.valueOf(i10)));
            }
        }
    }

    public static void setIsOaidTracking(boolean z10) {
        if (getDefaultInstance() != null) {
            defaultInstance.mn(1, z10);
            defaultInstance.mn(0, z10);
        }
    }

    public static void setOAID(String str) {
        if (getDefaultInstance() != null) {
            defaultInstance.no(1, str);
            defaultInstance.no(0, str);
        }
    }

    public static void setUPID(String str) {
        if (getDefaultInstance() != null) {
            defaultInstance.mn(1, str);
            defaultInstance.mn(0, str);
        }
    }
}
