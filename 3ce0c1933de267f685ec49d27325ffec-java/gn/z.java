package gn;

import android.content.Context;
import android.content.SharedPreferences;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
public class z {

    /* renamed from: d  reason: collision with root package name */
    private static z f27611d;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f27612a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f27613b;

    /* renamed from: c  reason: collision with root package name */
    private Context f27614c;

    private z(Context context) {
        this.f27614c = null;
        this.f27614c = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(q.f27582a, 0);
        this.f27612a = sharedPreferences;
        this.f27613b = sharedPreferences.edit();
    }

    public static z v(Context context) {
        if (f27611d == null) {
            f27611d = new z(context);
        }
        return f27611d;
    }

    public boolean A() {
        return this.f27612a.getBoolean("personage_gender_sp", true);
    }

    public void A0(int i10) {
        this.f27613b.putInt("personage_age_sp", i10).apply();
    }

    public String B() {
        return this.f27612a.getString("personage_height", "170");
    }

    public void B0(boolean z10) {
        this.f27613b.putBoolean("personage_gender_sp", z10).apply();
    }

    public String C() {
        return this.f27612a.getString("step_length", "71");
    }

    public void C0(String str) {
        this.f27613b.putString("personage_height", str).apply();
    }

    public String D() {
        return this.f27612a.getString("body_weight", Constant.TRANS_TYPE_LOAD);
    }

    public void D0(String str) {
        this.f27613b.putString("step_length", str).apply();
    }

    public boolean E() {
        return this.f27612a.getBoolean("is_rk_platform_sp", false);
    }

    public void E0(String str) {
        this.f27613b.putString("body_weight", str).apply();
    }

    public int F() {
        String H = H();
        if (H.contains(MessageProxyConstants.NODE_ID_ANY)) {
            return Integer.valueOf(H.split("\\*")[1]).intValue();
        }
        return 240;
    }

    public void F0(int i10) {
        this.f27613b.putInt("PushMessageDisplay1", i10).apply();
    }

    public int G() {
        String H = H();
        if (H.contains(MessageProxyConstants.NODE_ID_ANY)) {
            return Integer.valueOf(H.split("\\*")[0]).intValue();
        }
        return 240;
    }

    public void G0(int i10) {
        this.f27613b.putInt("PushMessageDisplay2", i10).apply();
    }

    public String H() {
        return this.f27612a.getString("resolution_width_height", "240*240");
    }

    public void H0(boolean z10) {
        this.f27613b.putBoolean("is_rk_platform_sp", z10).apply();
    }

    public String I() {
        return this.f27612a.getString("sms_received_number", "");
    }

    public void I0(String str) {
        this.f27613b.putString("resolution_width_height", str).apply();
    }

    public void J() {
        this.f27613b.remove("watch_list").apply();
    }

    public void K(int i10) {
        this.f27613b.putInt("BandCurrentLanguageType", i10).apply();
    }

    public void L(int i10) {
        this.f27613b.putInt("BandDisplayMaxSports", i10).apply();
    }

    public void M(int i10) {
        this.f27613b.putInt("BandDisplayMinSports", i10).apply();
    }

    public void N(int i10) {
        this.f27613b.putInt("BandLanguageDisplay1", i10).apply();
    }

    public void O(int i10) {
        this.f27613b.putInt("BandLanguageDisplay2", i10).apply();
    }

    public void P(int i10) {
        this.f27613b.putInt("BandLanguageDisplay3", i10).apply();
    }

    public void Q(int i10) {
        this.f27613b.putInt("BandLanguageDisplay4", i10).apply();
    }

    public void R(int i10) {
        this.f27613b.putInt("BandLanguageDisplay5", i10).apply();
    }

    public void S(int i10) {
        this.f27613b.putInt("band_language_sp", i10).apply();
    }

    public void T(int i10) {
        this.f27613b.putInt("band_language_OnlyUseOnCommand_sp", i10).apply();
    }

    public void U(int i10) {
        this.f27613b.putInt("BandSupportMaxSports", i10).apply();
    }

    public void V(int i10) {
        this.f27613b.putInt("BandSupportSports1", i10).apply();
    }

    public void W(int i10) {
        this.f27613b.putInt("BandSupportSports2", i10).apply();
    }

    public void X(int i10) {
        this.f27613b.putInt("BandSupportSports3", i10).apply();
    }

    public void Y(int i10) {
        this.f27613b.putInt("BandSupportSports4", i10).apply();
    }

    public void Z(int i10) {
        this.f27613b.putInt("BandSupportSports5", i10).apply();
    }

    public void a() {
        c0(0);
        d0(0);
        e0(0);
        f0(0);
        g0(0);
        h0(0);
        i0(0);
    }

    public void a0(int i10) {
        this.f27613b.putInt("ble_battery_value", i10).apply();
    }

    public int b() {
        return this.f27612a.getInt("BandDisplayMaxSports", 25);
    }

    public void b0(boolean z10) {
        this.f27613b.putBoolean("ble_connected", z10).apply();
    }

    public int c() {
        return this.f27612a.getInt("BandDisplayMinSports", 4);
    }

    public void c0(int i10) {
        this.f27613b.putInt("characteristic_function_list_sp", i10).apply();
    }

    public int d() {
        return this.f27612a.getInt("BandLanguageDisplay1", 0);
    }

    public void d0(int i10) {
        this.f27613b.putInt("characteristic_function_list_sp_2", i10).apply();
    }

    public int e() {
        return this.f27612a.getInt("BandLanguageDisplay2", 0);
    }

    public void e0(int i10) {
        this.f27613b.putInt("characteristic_function_list_sp_3", i10).apply();
    }

    public int f() {
        return this.f27612a.getInt("BandLanguageDisplay3", 0);
    }

    public void f0(int i10) {
        this.f27613b.putInt("characteristic_function_list_sp_4", i10).apply();
    }

    public int g() {
        return this.f27612a.getInt("BandLanguageDisplay4", 0);
    }

    public void g0(int i10) {
        this.f27613b.putInt("characteristic_function_list_sp_5", i10).apply();
    }

    public int h() {
        return this.f27612a.getInt("BandLanguageDisplay5", 0);
    }

    public void h0(int i10) {
        this.f27613b.putInt("characteristic_function_list_sp_6", i10).apply();
    }

    public int i() {
        return this.f27612a.getInt("band_language_OnlyUseOnCommand_sp", 0);
    }

    public void i0(int i10) {
        this.f27613b.putInt("characteristic_function_list_sp_7", i10).apply();
    }

    public boolean j() {
        return this.f27612a.getBoolean("ble_connected", false) && o.a(this.f27614c);
    }

    public void j0(String str) {
        this.f27613b.putString("dial_max_data_size", str).apply();
    }

    public String k() {
        return this.f27612a.getString("bp_calibrate_co", "");
    }

    public void k0(int i10) {
        this.f27613b.putInt("dial_number_sp", i10).apply();
    }

    public int l() {
        return this.f27612a.getInt("characteristic_function_list_sp", 0);
    }

    public void l0(int i10) {
        this.f27613b.putInt("dialScreen_compatibility_level", i10).apply();
    }

    public int m() {
        return this.f27612a.getInt("characteristic_function_list_sp_2", 0);
    }

    public void m0(int i10) {
        if (i10 == 0) {
            i10 = 2;
        }
        this.f27613b.putInt("dial_screen_type", i10).apply();
    }

    public int n() {
        return this.f27612a.getInt("characteristic_function_list_sp_3", 0);
    }

    public void n0(int i10) {
        this.f27613b.putInt("do_not_disturb_from_hour_sp", i10).apply();
    }

    public int o() {
        return this.f27612a.getInt("characteristic_function_list_sp_4", 0);
    }

    public void o0(int i10) {
        this.f27613b.putInt("do_not_disturb_from_minute_sp", i10).apply();
    }

    public int p() {
        return this.f27612a.getInt("characteristic_function_list_sp_5", 0);
    }

    public void p0(boolean z10) {
        this.f27613b.putBoolean("do_not_disturb_message_switch_sp", z10).apply();
    }

    public int q() {
        return this.f27612a.getInt("characteristic_function_list_sp_7", 0);
    }

    public void q0(boolean z10) {
        this.f27613b.putBoolean("do_not_disturb_motor_switch_sp", z10).apply();
    }

    public int r() {
        return this.f27612a.getInt("dialScreen_compatibility_level", 0);
    }

    public void r0(boolean z10) {
        this.f27613b.putBoolean("do_not_disturb_time_switch_sp", z10).apply();
    }

    public int s() {
        return this.f27612a.getInt("dial_screen_type", 2);
    }

    public void s0(int i10) {
        this.f27613b.putInt("do_not_disturb_to_hour_sp", i10).apply();
    }

    public boolean t() {
        return this.f27612a.getBoolean("end_call_switch_sp", true);
    }

    public void t0(int i10) {
        this.f27613b.putInt("do_not_disturb_to_minute_sp", i10).apply();
    }

    public String u() {
        return this.f27612a.getString("img_local_version_name", "0");
    }

    public void u0(boolean z10) {
        this.f27613b.putBoolean("end_call_switch_sp", z10).apply();
    }

    public void v0(String str) {
        this.f27613b.putString("img_local_version_name", str).apply();
    }

    public String w() {
        return this.f27612a.getString("last_connect_device_address", "00:00:00:00:00:00");
    }

    public void w0(String str) {
        this.f27613b.putString("last_connect_device_address", str).apply();
    }

    public int x() {
        return this.f27612a.getInt("max_communication_length_sp", 0);
    }

    public void x0(int i10) {
        this.f27613b.putInt("max_communication_length_sp", i10).apply();
    }

    public String y() {
        return this.f27612a.getString("path_local_version_name", "00000");
    }

    public void y0(boolean z10) {
        this.f27613b.putBoolean("is_metric_unit_sp", z10).apply();
    }

    public int z() {
        return this.f27612a.getInt("personage_age_sp", 20);
    }

    public void z0(String str) {
        this.f27613b.putString("path_local_version_name", str).apply();
    }
}
