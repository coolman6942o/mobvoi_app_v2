package com.cardiex.arty.lite.networking;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import io.d;
import io.f;
import kotlin.jvm.internal.i;
import okhttp3.b0;
import okhttp3.v;
/* compiled from: UserAgentInterceptor.kt */
/* loaded from: classes.dex */
public final class UserAgentInterceptor implements v {
    private final d userAgent$delegate;

    public UserAgentInterceptor(Context context) {
        d a10;
        i.f(context, "context");
        a10 = f.a(new UserAgentInterceptor$userAgent$2(this, context));
        this.userAgent$delegate = a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildUserAgent(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String str = Build.MODEL;
        int i10 = Build.VERSION.SDK_INT;
        String str2 = Build.VERSION.RELEASE;
        String str3 = Build.MANUFACTURER;
        String installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
        if (installerPackageName == null) {
            installerPackageName = "StandAloneInstall";
        }
        return "arty-android/; (" + ((Object) str3) + "; " + ((Object) str) + "; SDK " + i10 + "; Android " + ((Object) str2) + "); " + installerPackageName;
    }

    private final String getUserAgent() {
        return (String) this.userAgent$delegate.getValue();
    }

    @Override // okhttp3.v
    public b0 intercept(v.a chain) {
        i.f(chain, "chain");
        return chain.a(chain.request().i().h("User-Agent", getUserAgent()).b());
    }
}
