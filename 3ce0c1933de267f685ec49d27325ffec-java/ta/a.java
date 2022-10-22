package ta;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.assistant.account.AccountConstant;
import java.util.ArrayList;
import java.util.List;
/* compiled from: AccountPreferenceHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static List<SharedPreferences.OnSharedPreferenceChangeListener> f35104a = new ArrayList();

    public static boolean A() {
        return q().getBoolean("key_pii_showed", false);
    }

    public static boolean B() {
        return q().getInt("privacy_confirm", 0) == 1;
    }

    public static void C(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (f35104a.contains(onSharedPreferenceChangeListener)) {
            q().unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            f35104a.remove(onSharedPreferenceChangeListener);
        }
    }

    public static void D(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_account_id", str).apply();
    }

    public static void E(sa.a aVar) {
        if (aVar != null) {
            V(aVar.phoneNumber);
            K(aVar.email);
            Y(aVar.sessionId);
            d0(aVar.wwid);
            H(aVar.career);
            P(aVar.home);
            M(aVar.headUrl);
            F(aVar.birthday);
            D(aVar.accountId);
            I(aVar.company);
            Z(aVar.sex);
            T(aVar.nickName);
            c0(aVar.weight);
            N(aVar.height);
            R(aVar);
            X(aVar.referralCode);
            W(aVar.agree);
            G(aVar.pii);
            b0(aVar.region);
        }
    }

    public static void F(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_birthday", str).apply();
    }

    public static void G(boolean z10) {
        q().edit().putBoolean("key_pii", z10).apply();
    }

    public static void H(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_career", str).apply();
    }

    public static void I(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_company", str).apply();
    }

    public static void J(boolean z10) {
        q().edit().putBoolean("key_develop_server", z10).apply();
    }

    public static void K(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_email", str).apply();
    }

    public static void L(boolean z10) {
        q().edit().putBoolean("key_google_login", z10).apply();
    }

    public static void M(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_head_url", str).apply();
    }

    public static void N(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_height", str).apply();
    }

    public static void O(boolean z10) {
        q().edit().putBoolean("key_pii_showed", z10).apply();
    }

    public static void P(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_home", str).apply();
    }

    public static void Q(String str) {
        q().edit().putString("key_last_account", com.mobvoi.android.common.utils.a.d(str, "mobvoi")).apply();
    }

    public static void R(sa.a aVar) {
        if (!TextUtils.isEmpty(aVar.phoneNumber)) {
            Q(aVar.phoneNumber);
        } else if (!TextUtils.isEmpty(aVar.email)) {
            Q(aVar.email);
        }
    }

    public static void S(long j10) {
        q().edit().putLong("key_last_update_time", j10).apply();
    }

    public static void T(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_nick_name", str).apply();
    }

    public static void U(int i10) {
        va.a.d("key_night_mode", Integer.valueOf(i10));
    }

    public static void V(String str) {
        q().edit().putString("key_phone", str != null ? com.mobvoi.android.common.utils.a.d(str, "mobvoi") : "").apply();
    }

    public static void W(boolean z10) {
        q().edit().putInt("privacy_confirm", z10 ? 1 : 0).apply();
    }

    public static void X(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_referral", str).apply();
    }

    public static void Y(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_session_id", str).apply();
    }

    public static void Z(int i10) {
        q().edit().putInt("key_sex", i10).apply();
    }

    public static void a(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        q().registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        f35104a.add(onSharedPreferenceChangeListener);
    }

    public static void a0(int i10) {
        q().edit().putInt("key_step_goal", i10).apply();
    }

    public static boolean b() {
        return q().getBoolean("key_pii", false) || !com.mobvoi.companion.base.settings.a.isOversea();
    }

    public static void b0(String str) {
        if (!TextUtils.isEmpty(str)) {
            q().edit().putString("key_user_region", str).apply();
        }
    }

    public static void c() {
        Y("");
        d0("");
        D("");
        S(0L);
        M("");
        H("");
        T("");
        V("");
        K("");
        P("");
        I("");
        M("");
        F("");
        c0("");
        N("");
        W(false);
        G(false);
        b0("");
    }

    public static void c0(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_weight", str).apply();
    }

    public static String d() {
        return q().getString("key_account_id", null);
    }

    public static void d0(String str) {
        SharedPreferences.Editor edit = q().edit();
        if (str == null) {
            str = "";
        }
        edit.putString("key_wwid", str).apply();
    }

    public static sa.a e() {
        sa.a aVar = new sa.a();
        aVar.phoneNumber = p();
        aVar.email = i();
        aVar.sessionId = s();
        aVar.wwid = x();
        aVar.career = g();
        aVar.home = l();
        aVar.headUrl = j();
        aVar.birthday = f();
        aVar.accountId = d();
        aVar.company = h();
        aVar.sex = t();
        aVar.nickName = n();
        aVar.weight = w();
        aVar.height = k();
        aVar.referralCode = r();
        aVar.agree = B();
        aVar.pii = b();
        aVar.region = v();
        return aVar;
    }

    private static boolean e0(String str) {
        return str != null && (str.length() == 32 || str.length() == 64);
    }

    public static String f() {
        return q().getString("key_birthday", null);
    }

    public static String g() {
        return q().getString("key_career", null);
    }

    public static String h() {
        return q().getString("key_company", null);
    }

    public static String i() {
        return q().getString("key_email", null);
    }

    public static String j() {
        return q().getString("key_head_url", null);
    }

    public static String k() {
        return q().getString("key_height", null);
    }

    public static String l() {
        return q().getString("key_home", null);
    }

    public static String m() {
        String string = q().getString("key_last_account", "");
        return e0(string) ? com.mobvoi.android.common.utils.a.a(string, "mobvoi") : string;
    }

    public static String n() {
        return q().getString("key_nick_name", null);
    }

    public static int o() {
        return va.a.b("key_night_mode", 1);
    }

    public static String p() {
        String string = q().getString("key_phone", null);
        return e0(string) ? com.mobvoi.android.common.utils.a.a(string, "mobvoi") : string;
    }

    private static SharedPreferences q() {
        return b.e().getSharedPreferences("account_info", 0);
    }

    public static String r() {
        return q().getString("key_referral", null);
    }

    public static String s() {
        return q().getString("key_session_id", null);
    }

    public static int t() {
        return q().getInt("key_sex", AccountConstant.Sex.MALE.ordinal());
    }

    public static int u() {
        return q().getInt("key_step_goal", 10000);
    }

    public static String v() {
        return q().getString("key_user_region", "");
    }

    public static String w() {
        return q().getString("key_weight", null);
    }

    public static String x() {
        return q().getString("key_wwid", null);
    }

    public static boolean y() {
        return q().getBoolean("key_develop_server", false);
    }

    public static boolean z() {
        return q().getBoolean("key_google_login", false);
    }
}
