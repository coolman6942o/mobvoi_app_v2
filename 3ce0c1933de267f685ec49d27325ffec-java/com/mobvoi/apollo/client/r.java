package com.mobvoi.apollo.client;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.setting.CompanionSetting;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ApolloPrefs.kt */
/* loaded from: classes2.dex */
public final class r {

    /* renamed from: b  reason: collision with root package name */
    public static final a f15521b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static String f15522c;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f15523a;

    /* compiled from: ApolloPrefs.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String a() {
            return r.f15522c;
        }
    }

    static {
        Application e10 = b.e();
        i.e(e10, "getApplication()");
        f15522c = new r(e10).g();
    }

    public r(Context context) {
        i.f(context, "context");
        this.f15523a = context.getSharedPreferences(CompanionSetting.TICPAY_PLATFORM_APOLLO, 0);
    }

    public final String b() {
        return this.f15523a.getString("abup_device_id", null);
    }

    public final String c() {
        return this.f15523a.getString("abup_device_secret", null);
    }

    public final String d() {
        String string = this.f15523a.getString("eid", "");
        return string == null ? "" : string;
    }

    public final String e() {
        String string = this.f15523a.getString("fota_version", "");
        i.d(string);
        i.e(string, "prefs.getString(KEY_FOTA_VERSION, \"\")!!");
        return string;
    }

    public final String f() {
        return this.f15523a.getString("host_bt_address", null);
    }

    public final String g() {
        String string = this.f15523a.getString("imei", "");
        i.d(string);
        i.e(string, "prefs.getString(KEY_IMEI, \"\")!!");
        return string;
    }

    public final boolean h() {
        return this.f15523a.getBoolean("notify_switch", true);
    }

    public final boolean i(String key) {
        i.f(key, "key");
        return this.f15523a.getBoolean(i.n("notify_switch_app_", key), true);
    }

    public final String j() {
        String string = this.f15523a.getString("apollo_connect_key", "");
        return string == null ? "" : string;
    }

    public final boolean k(String key) {
        i.f(key, "key");
        return this.f15523a.getBoolean(i.n("could_push_app_", key), true);
    }

    public final String l() {
        String string = this.f15523a.getString("version", "");
        i.d(string);
        i.e(string, "prefs.getString(KEY_VERSION, \"\")!!");
        return string;
    }

    public final boolean m() {
        return this.f15523a.getBoolean("could_push", true);
    }

    public final boolean n() {
        return this.f15523a.getBoolean("apollo_connect_type", true);
    }

    public final void o(String str) {
        SharedPreferences prefs = this.f15523a;
        i.e(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        i.e(editor, "editor");
        editor.putString("fota_version", str);
        editor.apply();
    }

    public final void p(String str) {
        SharedPreferences prefs = this.f15523a;
        i.e(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        i.e(editor, "editor");
        editor.putString("host_bt_address", str);
        editor.apply();
    }

    public final void q(String str) {
        SharedPreferences prefs = this.f15523a;
        i.e(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        i.e(editor, "editor");
        editor.putString("version", str);
        editor.apply();
    }

    public final void r(String str) {
        SharedPreferences prefs = this.f15523a;
        i.e(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        i.e(editor, "editor");
        editor.putString("abup_device_id", str);
        editor.apply();
    }

    public final void s(String str) {
        SharedPreferences prefs = this.f15523a;
        i.e(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        i.e(editor, "editor");
        editor.putString("abup_device_secret", str);
        editor.apply();
    }

    public final void t(boolean z10) {
        this.f15523a.edit().putBoolean("could_push", z10).apply();
    }

    public final void u(String value) {
        i.f(value, "value");
        this.f15523a.edit().putString("eid", value).apply();
    }

    public final void v(String str) {
        SharedPreferences prefs = this.f15523a;
        i.e(prefs, "prefs");
        SharedPreferences.Editor editor = prefs.edit();
        i.e(editor, "editor");
        editor.putString("imei", str);
        editor.apply();
        if (str != null) {
            f15522c = str;
        }
    }

    public final void w(boolean z10) {
        this.f15523a.edit().putBoolean("apollo_connect_type", z10).apply();
    }

    public final void x(boolean z10) {
        this.f15523a.edit().putBoolean("notify_switch", z10).apply();
    }

    public final void y(String value) {
        i.f(value, "value");
        this.f15523a.edit().putString("apollo_connect_key", value).apply();
    }

    public final void z(String key, boolean z10) {
        i.f(key, "key");
        this.f15523a.edit().putBoolean(i.n("could_push_app_", key), z10).apply();
    }
}
