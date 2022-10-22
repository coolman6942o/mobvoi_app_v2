package com.huawei.hms.ml.camera;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import java.lang.ref.WeakReference;
/* compiled from: BundleGetting.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14004a = "a";

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f14005b;

    public a(Context context) {
        this.f14005b = new WeakReference<>(context);
    }

    public final Bundle a() {
        if (this.f14005b.get() == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packageName", this.f14005b.get().getPackageName() == null ? "camera.cannot.get.package.name" : this.f14005b.get().getPackageName());
        bundle.putString("appid", "com.huawei.hms.ml.camera");
        bundle.putString("com.huawei.hms.client.service.name:ml-computer-vision", "ml-computer-vision:".concat("2.0.3.300"));
        bundle.putString("appName", a(this.f14005b.get()));
        boolean z10 = true;
        if (Settings.Secure.getInt(this.f14005b.get().getContentResolver(), "hw_app_analytics_state", 0) != 1) {
            z10 = false;
        }
        bundle.putBoolean("openHa", z10);
        bundle.putString("countryCode", new CountryCodeBean(this.f14005b.get(), false).getCountryCode());
        return bundle;
    }

    private static String a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(f14004a, "readManifest failed ");
            return "";
        }
    }
}
