package vc;

import android.content.Context;
import android.content.SharedPreferences;
import com.mobvoi.android.common.utils.q;
/* compiled from: ThirdPartyHelper.java */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(Context context) {
        return q.a(context, "health_pre_name", "google_fit", false);
    }

    public static boolean b(Context context) {
        return q.a(context, "health_pre_name", "runnkeeper", false);
    }

    public static boolean c(Context context) {
        return q.a(context, "health_pre_name", "strava", false);
    }

    public static void d(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        context.getSharedPreferences("health_pre_name", 0).registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static void e(Context context, boolean z10) {
        q.e(context, "health_pre_name", "google_fit", z10);
    }

    public static void f(Context context, boolean z10) {
        q.e(context, "health_pre_name", "runnkeeper", z10);
    }

    public static void g(Context context, boolean z10) {
        q.e(context, "health_pre_name", "strava", z10);
    }

    public static void h(Context context, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        context.getSharedPreferences("health_pre_name", 0).unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
