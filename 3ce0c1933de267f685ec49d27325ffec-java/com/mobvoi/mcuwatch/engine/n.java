package com.mobvoi.mcuwatch.engine;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.unionpay.tsmservice.data.Constant;
import gn.q;
import io.d;
import io.f;
import io.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
/* compiled from: SettingSP.kt */
/* loaded from: classes2.dex */
public final class n implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public static final n f19178a = new n();

    /* renamed from: b  reason: collision with root package name */
    private static final Context f19179b;

    /* renamed from: c  reason: collision with root package name */
    private static final SharedPreferences f19180c;

    /* renamed from: d  reason: collision with root package name */
    private static final SharedPreferences f19181d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f19182e;

    /* renamed from: f  reason: collision with root package name */
    private static final d f19183f;

    /* compiled from: SettingSP.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void U(SharedPreferences sharedPreferences, String str);
    }

    /* compiled from: SettingSP.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<HashMap<String, List<a>>> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final HashMap<String, List<a>> invoke() {
            return new HashMap<>();
        }
    }

    static {
        d a10;
        a10 = f.a(b.INSTANCE);
        f19183f = a10;
        Application e10 = com.mobvoi.android.common.utils.b.e();
        i.e(e10, "getApplication()");
        f19179b = e10;
        SharedPreferences sharedPreferences = e10.getSharedPreferences(q.f27582a, 0);
        i.e(sharedPreferences, "context.getSharedPreferences(GlobalVariable.SettingSP, 0)");
        f19181d = sharedPreferences;
        SharedPreferences sharedPreferences2 = e10.getSharedPreferences("watch_lite_sp", 0);
        i.e(sharedPreferences2, "context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)");
        f19180c = sharedPreferences2;
    }

    private n() {
    }

    private final void J() {
        if (!f19182e) {
            f19182e = true;
            f19180c.registerOnSharedPreferenceChangeListener(this);
        }
    }

    private final Map<String, List<a>> l() {
        return (Map) f19183f.getValue();
    }

    private final void n0() {
        if (f19182e) {
            f19182e = false;
            f19180c.unregisterOnSharedPreferenceChangeListener(this);
        }
    }

    public final boolean A() {
        return f19180c.getBoolean("key_not_disturb", false);
    }

    public final boolean B() {
        return f19180c.getBoolean("key_oxygen", true);
    }

    public final boolean C() {
        return f19180c.getBoolean("key_raise_hand_bright", true);
    }

    public final boolean D() {
        return f19180c.getBoolean("key_sedentary", false);
    }

    public final boolean E() {
        return f19180c.getBoolean("key_sedentary_lunch_break", false);
    }

    public final boolean F() {
        return f19180c.getBoolean("key_sms", true);
    }

    public final boolean G() {
        return f19180c.getBoolean("key_not_disturb_sync_watchface", true);
    }

    public final boolean H() {
        return f19180c.getBoolean("key_temperature", true);
    }

    public final boolean I() {
        return f19180c.getBoolean("key_vibrate", true);
    }

    public final void K(String key, a listener) {
        i.f(key, "key");
        i.f(listener, "listener");
        J();
        m mVar = m.f28349a;
        n nVar = f19178a;
        List<a> list = nVar.l().get(key);
        if (list == null) {
            list = new ArrayList<>();
            nVar.l().put(key, list);
        }
        if (!(!list.contains(listener))) {
            list = null;
        }
        if (list != null) {
            list.add(listener);
        }
    }

    public final void L(boolean z10) {
        f19180c.edit().putBoolean("key_24_hour", z10).apply();
    }

    public final void M(String value) {
        i.f(value, "value");
        f19180c.edit().putString("key_alarm_data", value).apply();
    }

    public final void N(String key, boolean z10) {
        i.f(key, "key");
        f19180c.edit().putBoolean(i.n("key_app_check_", key), z10).apply();
    }

    public final void O(boolean z10) {
        f19180c.edit().putBoolean("key_app", z10).apply();
    }

    public final void P(int i10) {
        f19180c.edit().putInt("key_ble_battery", i10).apply();
    }

    public final void Q(String value) {
        i.f(value, "value");
        f19180c.edit().putString("key_ble_server_version", value).apply();
    }

    public final void R(boolean z10) {
        f19180c.edit().putBoolean("key_breathe", z10).apply();
    }

    public final void S(long j10) {
        f19180c.edit().putLong("key_not_disturb_end_time", j10).apply();
    }

    public final void T(long j10) {
        f19180c.edit().putLong("key_sedentary_end_time", j10).apply();
    }

    public final void U(boolean z10) {
        f19180c.edit().putBoolean("key_heart_rate", z10).apply();
    }

    public final void V(boolean z10) {
        f19180c.edit().putBoolean("key_incall", z10).apply();
    }

    public final void W(String value) {
        i.f(value, "value");
        f19180c.edit().putString("key_device_language", value).apply();
    }

    public final void X(boolean z10) {
        f19180c.edit().putBoolean("key_ble_version_status", z10).apply();
    }

    public final void Y(boolean z10) {
        f19180c.edit().putBoolean("key_not_disturb", z10).apply();
    }

    public final void Z(int i10) {
        f19180c.edit().putInt("off_screen_time", i10).apply();
    }

    public final int a() {
        return f19180c.getBoolean("key_24_hour", false) ? 1 : 2;
    }

    public final void a0(boolean z10) {
        f19180c.edit().putBoolean("key_oxygen", z10).apply();
    }

    public final int b() {
        return f19181d.getInt("personage_age_sp", 20);
    }

    public final void b0(boolean z10) {
        f19180c.edit().putBoolean("key_raise_hand_bright", z10).apply();
    }

    public final String c() {
        String string = f19180c.getString("key_alarm_data", "");
        i.d(string);
        i.e(string, "sp.getString(KEY_ALARM_DATA, \"\")!!");
        return string;
    }

    public final void c0(boolean z10) {
        f19180c.edit().putBoolean("key_request_permission", z10).apply();
    }

    public final boolean d(String key) {
        i.f(key, "key");
        return f19180c.getBoolean(i.n("key_app_check_", key), true);
    }

    public final void d0(boolean z10) {
        f19180c.edit().putBoolean("key_sedentary", z10).apply();
    }

    public final int e() {
        return f19180c.getInt("key_ble_battery", 0);
    }

    public final void e0(boolean z10) {
        f19180c.edit().putBoolean("key_sedentary_lunch_break", z10).apply();
    }

    public final String f() {
        String string = f19180c.getString("key_ble_server_version", "");
        i.d(string);
        i.e(string, "sp.getString(KEY_BLE_SERVER_VERSION, \"\")!!");
        return string;
    }

    public final void f0(boolean z10) {
        f19180c.edit().putBoolean("key_sms", z10).apply();
    }

    public final long g() {
        return f19180c.getLong("key_not_disturb_end_time", 0L);
    }

    public final void g0(long j10) {
        f19180c.edit().putLong("key_not_disturb_start_time", j10).apply();
    }

    public final long h() {
        return f19180c.getLong("key_sedentary_end_time", 0L);
    }

    public final void h0(long j10) {
        f19180c.edit().putLong("key_sedentary_start_time", j10).apply();
    }

    public final boolean i() {
        return f19181d.getBoolean("personage_gender_sp", false);
    }

    public final void i0(int i10) {
        f19180c.edit().putInt("step_length", i10).apply();
    }

    public final int j() {
        String string = f19181d.getString("personage_height", "175");
        i.d(string);
        i.e(string, "bandSp.getString(GlobalVariable.PERSONAGE_HEIGHT, \"175\")!!");
        return Integer.parseInt(string);
    }

    public final void j0(boolean z10) {
        f19180c.edit().putBoolean("key_set_sync_language_flag", z10).apply();
    }

    public final String k() {
        String string = f19180c.getString("key_device_language", "language_default");
        i.d(string);
        i.e(string, "sp.getString(KEY_DEVICE_LANGUAGE, AppSwitch.Language.DEFAULT)!!");
        return string;
    }

    public final void k0(boolean z10) {
        f19180c.edit().putBoolean("key_not_disturb_sync_watchface", z10).apply();
    }

    public final void l0(boolean z10) {
        f19180c.edit().putBoolean("key_temperature", z10).apply();
    }

    public final int m() {
        return f19180c.getInt("off_screen_time", 5);
    }

    public final void m0(boolean z10) {
        f19180c.edit().putBoolean("key_vibrate", z10).apply();
    }

    public final String n() {
        String string = f19181d.getString("path_local_version_name", "0");
        i.d(string);
        i.e(string, "bandSp.getString(GlobalVariable.PATH_LOCAL_VERSION_NAME_SP, \"0\")!!");
        return string;
    }

    public final boolean o() {
        return f19180c.getBoolean("key_request_permission", true);
    }

    public final void o0(String key, a listener) {
        List<a> list;
        i.f(key, "key");
        i.f(listener, "listener");
        if (f19182e && (list = l().get(key)) != null) {
            if (!list.contains(listener)) {
                list = null;
            }
            if (list != null) {
                list.remove(listener);
                if (list.isEmpty()) {
                    n nVar = f19178a;
                    Map<String, List<a>> l10 = nVar.l();
                    l10.remove(key);
                    if (l10.isEmpty()) {
                        nVar.n0();
                    }
                }
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        List<a> list;
        if (!(str == null || (list = f19178a.l().get(str)) == null)) {
            for (a aVar : list) {
                aVar.U(sharedPreferences, str);
            }
        }
    }

    public final long p() {
        return f19180c.getLong("key_not_disturb_start_time", 0L);
    }

    public final long q() {
        return f19180c.getLong("key_sedentary_start_time", 0L);
    }

    public final int r() {
        return f19180c.getInt("step_length", 10001);
    }

    public final String s() {
        String string = f19181d.getString("img_local_version_name", "0");
        i.d(string);
        i.e(string, "bandSp.getString(GlobalVariable.IMG_LOCAL_VERSION_NAME_SP, \"0\")!!");
        return string;
    }

    public final int t() {
        String string = f19181d.getString("body_weight", Constant.TRANS_TYPE_LOAD);
        i.d(string);
        i.e(string, "bandSp.getString(GlobalVariable.PERSONAGE_WEIGHT, \"60\")!!");
        return Integer.parseInt(string);
    }

    public final boolean u() {
        return f19180c.getBoolean("key_24_hour", false);
    }

    public final boolean v() {
        return f19180c.getBoolean("key_app", true);
    }

    public final boolean w() {
        return f19180c.getBoolean("key_breathe", true);
    }

    public final boolean x() {
        return f19180c.getBoolean("key_heart_rate", true);
    }

    public final boolean y() {
        return f19180c.getBoolean("key_incall", true);
    }

    public final boolean z() {
        return f19180c.getBoolean("key_ble_version_status", false);
    }
}
