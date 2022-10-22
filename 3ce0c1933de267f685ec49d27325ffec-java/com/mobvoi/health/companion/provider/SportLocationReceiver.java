package com.mobvoi.health.companion.provider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import eg.a;
/* loaded from: classes2.dex */
public class SportLocationReceiver extends BroadcastReceiver {
    public static boolean a(Context context) {
        return context.getSharedPreferences("health_companion_provider_location", 0).getBoolean("isEnable", true);
    }

    public static boolean b(Context context) {
        return ((LocationManager) context.getSystemService(SharedWearInfoHelper.LocationInfo.TABLE)).isProviderEnabled("gps");
    }

    public static void c(Context context, boolean z10) {
        d(context, z10);
        a.e().m(WearPath.Sports.SPORTS_LOCATION_ENABLE, Boolean.valueOf(z10));
    }

    public static void d(Context context, boolean z10) {
        context.getSharedPreferences("health_companion_provider_location", 0).edit().putBoolean("isEnable", z10).apply();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean b10;
        if (intent.getAction().equals("android.location.PROVIDERS_CHANGED") && (b10 = b(context)) != a(context)) {
            c(context, b10);
        }
    }
}
