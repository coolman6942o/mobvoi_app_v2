package com.huawei.hms.feature.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;
/* loaded from: classes.dex */
public class c implements DynamicModule.VersionPolicy {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13787a = "c";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        DynamicModule.LoadingException e10;
        Bundle bundle;
        try {
            bundle = DynamicModule.getRemoteModuleInfo(context, str);
            e10 = null;
        } catch (DynamicModule.LoadingException e11) {
            e10 = e11;
            String str2 = f13787a;
            Logger.w(str2, "Get remote module info failed: " + e10.getMessage() + ". try to query local.");
            bundle = new Bundle();
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str3 = f13787a;
        Logger.i(str3, "The version of remote module " + str + ":" + bundle.getInt(b.f13799j));
        Logger.i(str3, "The version of local module " + str + ":" + localModuleInfo.getInt(b.f13800k));
        if (localModuleInfo.getInt(b.f13800k) > 0 && localModuleInfo.getInt(b.f13800k) >= bundle.getInt(b.f13799j)) {
            Logger.i(str3, "Choose local module info.");
            return localModuleInfo;
        } else if (e10 == null || bundle.getInt(b.f13799j) != 0) {
            Logger.i(str3, "Choose remote module info.");
            return bundle;
        } else {
            throw e10;
        }
    }
}
