package com.huawei.hms.feature.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;
/* loaded from: classes.dex */
public class d implements DynamicModule.VersionPolicy {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13788a = "d";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        String str2 = f13788a;
        Logger.i(str2, "The version of remote module " + str + ":" + remoteModuleInfo.getInt(b.f13799j));
        Logger.i(str2, "The version of local module " + str + ":" + localModuleInfo.getInt(b.f13800k));
        if (remoteModuleInfo.getInt(b.f13799j) >= localModuleInfo.getInt(b.f13800k)) {
            Logger.i(str2, "Choose remote module info.");
            return remoteModuleInfo;
        }
        Logger.i(str2, "Choose local module info.");
        return localModuleInfo;
    }
}
