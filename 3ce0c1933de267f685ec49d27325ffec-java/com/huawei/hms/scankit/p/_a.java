package com.huawei.hms.scankit.p;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.config.AGConnectServicesConfig;
/* compiled from: HaUtil.java */
/* loaded from: classes2.dex */
public class _a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14729a = "_a";

    /* renamed from: b  reason: collision with root package name */
    private static volatile Bundle f14730b;

    public static Bundle a(Context context) {
        if (context == null) {
            return new Bundle();
        }
        if (f14730b == null) {
            Bundle bundle = new Bundle();
            try {
                String string = AGConnectServicesConfig.fromContext(context).getString("client/app_id");
                if (string == null) {
                    string = context.getPackageName();
                }
                bundle.putString("appid", string);
            } catch (RuntimeException unused) {
                Log.e(f14729a, "getAppInfo: RuntimeException");
            } catch (Exception unused2) {
                Log.e(f14729a, "getAppInfo: Exception");
            }
            f14730b = bundle;
        }
        return f14730b;
    }
}
