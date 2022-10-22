package a8;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.huawei.hms.ml.camera.CameraConfig;
import com.mobvoi.wear.providers.OtaColumn;
import h6.b;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f124a = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd", "app_open");

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f125b = Arrays.asList(CameraConfig.CAMERA_FOCUS_AUTO, OtaColumn.COLUMN_APP, "am");

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f126c = Arrays.asList("_r", "_dbg");

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f127d = Arrays.asList((String[]) b.a(AppMeasurement.e.f10135a, AppMeasurement.e.f10136b));

    /* renamed from: e  reason: collision with root package name */
    private static final List<String> f128e = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static boolean a(String str, Bundle bundle) {
        if (f124a.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        for (String str2 : f126c) {
            if (bundle.containsKey(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String str, String str2, Bundle bundle) {
        String str3;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!c(str) || bundle == null) {
            return false;
        }
        for (String str4 : f126c) {
            if (bundle.containsKey(str4)) {
                return false;
            }
        }
        str.hashCode();
        if (str.equals(AppMeasurement.FCM_ORIGIN)) {
            str3 = "fcm_integration";
        } else if (!str.equals("fdl")) {
            return false;
        } else {
            str3 = "fdl_integration";
        }
        bundle.putString("_cis", str3);
        return true;
    }

    public static boolean c(String str) {
        return !f125b.contains(str);
    }

    public static boolean d(String str) {
        if (f127d.contains(str)) {
            return false;
        }
        for (String str2 : f128e) {
            if (str.matches(str2)) {
                return false;
            }
        }
        return true;
    }
}
