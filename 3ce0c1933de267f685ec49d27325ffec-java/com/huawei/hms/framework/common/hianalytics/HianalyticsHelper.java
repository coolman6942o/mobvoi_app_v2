package com.huawei.hms.framework.common.hianalytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.v2.HiAnalytics;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class HianalyticsHelper {
    private static final String EVENT_ID = "networkkit_restclient";
    private static final String HWID_HA_SERVICE_TAG = "hms_hwid";
    private static final String TAG = "HianalyticsHelper";
    private static final int TYPE_MAINTF = 1;
    private static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
    private static final int USER_EXPERIENCE_ON = 1;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile HianalyticsHelper instance;
    private boolean hasHianalytics;
    private String haTag = HWID_HA_SERVICE_TAG;
    private HiAnalyticsInstance hInstance = null;
    private ExecutorService reportExecutor = ExecutorsUtils.newSingleThreadExecutor("report_ha");

    private HianalyticsHelper() {
        try {
            HiAnalytics.getInitFlag();
            this.hasHianalytics = true;
        } catch (Throwable unused) {
            Logger.w(TAG, "maybe you need add Hianalytics sdk");
            this.hasHianalytics = false;
        }
    }

    public static HianalyticsHelper getInstance() {
        if (instance == null) {
            synchronized (HianalyticsHelper.class) {
                if (instance == null) {
                    instance = new HianalyticsHelper();
                }
            }
        }
        return instance;
    }

    public ExecutorService getReportExecutor() {
        return this.reportExecutor;
    }

    public boolean isEnableReport(Context context) {
        if (!this.hasHianalytics) {
            return false;
        }
        return isEnableReportNoSeed(context);
    }

    public boolean isEnableReportNoSeed(Context context) {
        String str;
        if (!this.hasHianalytics) {
            str = "Hianalytics sdk need to be initialized";
        } else if (context == null) {
            str = "HianalyticsHelper context can't be null";
        } else if (Settings.Secure.getInt(context.getContentResolver(), USER_EXPERIENCE_INVOLVED, -1) != 1) {
            str = "user experience involved needs to be opened";
        } else if (HiAnalytics.getInitFlag()) {
            return true;
        } else {
            if (this.hInstance == null) {
                this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag);
            }
            return this.hInstance != null;
        }
        Logger.i(TAG, str);
        return false;
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap) {
        onEvent(linkedHashMap, EVENT_ID);
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str) {
        if (this.hasHianalytics && linkedHashMap != null) {
            Logger.v(TAG, "data = %s", linkedHashMap);
            if (HiAnalytics.getInitFlag()) {
                HiAnalytics.onEvent(1, str, linkedHashMap);
                return;
            }
            HiAnalyticsInstance hiAnalyticsInstance = this.hInstance;
            if (hiAnalyticsInstance != null) {
                hiAnalyticsInstance.onEvent(1, str, linkedHashMap);
            }
        }
    }

    public void setHaTag(String str) {
        this.haTag = str;
    }
}
