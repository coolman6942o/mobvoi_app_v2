package com.huawei.hms.feature.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.feature.dynamic.b;
/* loaded from: classes.dex */
public class e implements DynamicModule.VersionPolicy {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13789a = "e";

    @Override // com.huawei.hms.feature.dynamic.DynamicModule.VersionPolicy
    public Bundle getModuleInfo(Context context, String str) throws DynamicModule.LoadingException {
        Bundle remoteModuleInfo = DynamicModule.getRemoteModuleInfo(context, str);
        if (remoteModuleInfo.getInt(b.f13799j) > 0) {
            String str2 = f13789a;
            Logger.i(str2, "Prefer remote: The version of remote module " + str + ":" + remoteModuleInfo.getInt(b.f13799j));
            return remoteModuleInfo;
        }
        Bundle localModuleInfo = DynamicModule.getLocalModuleInfo(context, str);
        if (localModuleInfo.getInt(b.f13800k) > 0) {
            String str3 = f13789a;
            Logger.i(str3, "Choose local: The version of local module " + str + ":" + localModuleInfo.getInt(b.f13800k));
            return localModuleInfo;
        }
        Logger.i(f13789a, "Cannot get module info in remote or local.");
        return new Bundle();
    }
}
