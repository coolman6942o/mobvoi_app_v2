package com.huawei.hms.mlkit.common.ha.event;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.mlkit.common.ha.HianalyticsLogProvider;
import com.huawei.hms.mlkit.common.ha.a;
import com.huawei.hms.mlkit.common.ha.annotation.KeepHa;
import com.huawei.hms.mlkit.common.ha.d;
import java.util.LinkedHashMap;
@KeepHa
/* loaded from: classes2.dex */
public abstract class BaseInfoGatherEvent {
    public static final int TYPE_MAINT = 2;
    public static final int TYPE_OPERATE = 1;
    public static final int TYPE_PRELOAD = 4;

    private LinkedHashMap<String, String> getCommonData(Context context) {
        a a10 = d.a(context, getAppInfo());
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("package", a10.f14061a);
        linkedHashMap.put("appid", a10.f14062b);
        linkedHashMap.put("appName", a10.f14064d);
        linkedHashMap.put("version", a10.f14063c);
        linkedHashMap.put("service", d.e());
        linkedHashMap.put("transId", HianalyticsLogProvider.getInstance().getTransId());
        linkedHashMap.put("operator", d.a(context.getApplicationContext()));
        linkedHashMap.put("networkType", d.b(context.getApplicationContext()));
        linkedHashMap.put("apkVersion", getModelApkVersion());
        linkedHashMap.put("apiName", getApiName());
        linkedHashMap.put("countryCode", a10.f14066f);
        linkedHashMap.put("deviceType", d.a());
        linkedHashMap.put("emuiVersion", d.b());
        linkedHashMap.put("moduleName", getModuleName());
        linkedHashMap.put("moduleVersion", getModuleVersion());
        linkedHashMap.put("deviceCategory", d.d());
        return linkedHashMap;
    }

    public abstract String getApiName();

    public abstract Bundle getAppInfo();

    public abstract LinkedHashMap<String, String> getCustomizedData();

    public final LinkedHashMap<String, String> getEventData(Context context) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.putAll(getCommonData(context));
        linkedHashMap.putAll(getCustomizedData());
        return linkedHashMap;
    }

    public abstract String getEventId();

    public abstract String getExtension(String str);

    public abstract String getModelApkVersion();

    public abstract String getModuleName();

    public abstract String getModuleVersion();
}
