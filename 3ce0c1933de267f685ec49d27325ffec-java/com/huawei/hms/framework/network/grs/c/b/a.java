package com.huawei.hms.framework.network.grs.c.b;

import com.huawei.hms.framework.common.BuildConfig;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
/* loaded from: classes.dex */
public class a extends HianalyticsBaseData {
    public static final String TAG = HianalyticsBaseData.class.getSimpleName();

    public a() {
        put("sdk_version", BuildConfig.VERSION_NAME);
        put("if_name", "NetworkKit-grs");
    }
}
