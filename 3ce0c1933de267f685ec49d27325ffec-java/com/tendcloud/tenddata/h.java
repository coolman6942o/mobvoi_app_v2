package com.tendcloud.tenddata;

import android.content.Context;
/* compiled from: td */
/* loaded from: classes2.dex */
public class h {
    private static final String A = "TDdeep_link_url";
    private static final String B = "TDtd_role_id";
    private static final String C = "TDpref.accountid.key";
    private static final String D = "TDpref.accountgame.key";
    private static final String E = "TDpref.missionid.key";
    private static final String F = "TDpref.game.session.startsystem.key";

    /* renamed from: a  reason: collision with root package name */
    public static final String f22894a = "TDpref.profile.key";

    /* renamed from: b  reason: collision with root package name */
    public static final String f22895b = "TDpref.session.key";

    /* renamed from: c  reason: collision with root package name */
    public static final String f22896c = "TDpref.session.backup.key";

    /* renamed from: d  reason: collision with root package name */
    public static final String f22897d = "TDpref.lastactivity.key";

    /* renamed from: e  reason: collision with root package name */
    public static final String f22898e = "TDpref.start.key";

    /* renamed from: f  reason: collision with root package name */
    public static final String f22899f = "TDpref.init.key";

    /* renamed from: g  reason: collision with root package name */
    public static final String f22900g = "TDpref.init.flag";

    /* renamed from: h  reason: collision with root package name */
    public static final String f22901h = "TDpref.actstart.key";

    /* renamed from: i  reason: collision with root package name */
    public static final String f22902i = "TDpref.end.key";

    /* renamed from: j  reason: collision with root package name */
    public static final String f22903j = "TDpref.ip";

    /* renamed from: k  reason: collision with root package name */
    public static final String f22904k = "TD_CHANNEL_ID";

    /* renamed from: l  reason: collision with root package name */
    public static final String f22905l = "TDappcontext_push";

    /* renamed from: m  reason: collision with root package name */
    public static final String f22906m = "TDpref.tokensync.key";

    /* renamed from: n  reason: collision with root package name */
    public static final String f22907n = "TDpref.push.msgid.key";

    /* renamed from: o  reason: collision with root package name */
    public static final String f22908o = "TDpref_longtime";

    /* renamed from: p  reason: collision with root package name */
    public static final String f22909p = "TDpref_shorttime";

    /* renamed from: q  reason: collision with root package name */
    public static final String f22910q = "TDapp.account.key";

    /* renamed from: r  reason: collision with root package name */
    public static final String f22911r = "TDuniversal.account.key";

    /* renamed from: s  reason: collision with root package name */
    public static final String f22912s = "TDaes_key";

    /* renamed from: t  reason: collision with root package name */
    public static final String f22913t = "TDpref_game";

    /* renamed from: u  reason: collision with root package name */
    public static final String f22914u = "TD_push_pref_file";

    /* renamed from: v  reason: collision with root package name */
    static final String f22915v = "TDisAppQuiting";

    /* renamed from: w  reason: collision with root package name */
    public static final String f22916w = "TDpref.last.sdk.check";

    /* renamed from: x  reason: collision with root package name */
    public static final String f22917x = "TDadditionalVersionName";

    /* renamed from: y  reason: collision with root package name */
    public static final String f22918y = "TDadditionalVersionCode";

    /* renamed from: z  reason: collision with root package name */
    private static final String f22919z = "TDtime_set_collect_net";

    public static String a() {
        Context context = ab.f22568h;
        if (context == null) {
            return null;
        }
        try {
            return o.b(context, f22908o, f22912s, (String) null);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    public static void b(String str, a aVar) {
        Context context = ab.f22568h;
        if (context != null && aVar != null) {
            try {
                o.a(context, f22908o + aVar.index(), f22896c, str);
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    public static boolean c() {
        Context context = ab.f22568h;
        if (context == null) {
            return false;
        }
        try {
            return context.getSharedPreferences("TD_CHANNEL_ID", 0).getBoolean("location_called", false);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return false;
        }
    }

    public static String d() {
        Context context = ab.f22568h;
        if (context == null) {
            return "";
        }
        try {
            return o.b(context, f22909p, f22897d, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long e(a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                return o.b(context, f22908o + aVar.index(), f22900g, 1L);
            } catch (Throwable unused) {
            }
        }
        return 1L;
    }

    public static long f() {
        Context context = ab.f22568h;
        if (context == null) {
            return 0L;
        }
        try {
            return o.b(context, f22909p, f22901h, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String g() {
        Context context = ab.f22568h;
        if (context == null) {
            return null;
        }
        try {
            return o.b(context, f22908o, f22917x, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long h() {
        Context context = ab.f22568h;
        if (context == null) {
            return -1L;
        }
        try {
            return o.b(context, f22908o, f22918y, -1L);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static int i() {
        try {
            if (h() != -1) {
                return Integer.parseInt(String.valueOf(h()));
            }
            return f.a().b(ab.f22568h);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String j() {
        try {
            if (g() != null) {
                return g();
            }
            return f.a().c(ab.f22568h);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String k() {
        Context context = ab.f22568h;
        if (context == null) {
            return null;
        }
        try {
            return o.b(context, f22909p, f22910q, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String l() {
        Context context = ab.f22568h;
        if (context == null) {
            return null;
        }
        try {
            return o.b(context, f22909p, f22911r, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String m() {
        Context context = ab.f22568h;
        if (context == null) {
            return null;
        }
        try {
            return o.b(context, f22909p, B, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long n() {
        Context context = ab.f22568h;
        if (context == null) {
            return 0L;
        }
        try {
            return o.b(context, f22909p, f22919z, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String o() {
        Context context = ab.f22568h;
        if (context == null) {
            return null;
        }
        try {
            return o.b(context, f22909p, A, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String p() {
        Context context = ab.f22568h;
        if (context == null) {
            return "";
        }
        try {
            return o.b(context, f22913t, C, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String q() {
        Context context = ab.f22568h;
        if (context == null) {
            return "";
        }
        try {
            return o.b(context, f22913t, E, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void r() {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22913t, F, System.currentTimeMillis());
            } catch (Throwable unused) {
            }
        }
    }

    public static String s() {
        Context context = ab.f22568h;
        if (context == null) {
            return "";
        }
        try {
            return o.b(context, f22914u, f22905l, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void setAESKey(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22908o, f22912s, str);
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    public static void setActivityStartTime(long j10) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, f22901h, j10);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setAdditionalVersionCode(long j10) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22908o, f22918y, j10);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setAdditionalVersionName(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22908o, f22917x, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setCollectNetInfoTime(long j10) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, f22919z, j10);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setDeepLink(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, A, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setInitTime(long j10) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22908o, f22899f, j10);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setLastActivity(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, f22897d, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setLastRoleName(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, B, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setMissionId(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22913t, E, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setPostProfile(boolean z10) {
        try {
            o.a(ab.f22568h, f22908o, f22894a, z10 ? 1L : 0L);
        } catch (Throwable unused) {
        }
    }

    public static void setProfileId(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22913t, C, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setProfileInfo(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, f22910q, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setPushAppContext(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22914u, f22905l, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setPushLastMsgId(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22914u, f22907n, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setPushSyncTokenLastTime(long j10) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22914u, f22906m, j10);
            } catch (Throwable unused) {
            }
        }
    }

    public static void setUniversalProfileInfo(String str) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, f22911r, str);
            } catch (Throwable unused) {
            }
        }
    }

    public static long t() {
        Context context = ab.f22568h;
        if (context == null) {
            return 0L;
        }
        try {
            return o.b(context, f22914u, f22906m, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String u() {
        Context context = ab.f22568h;
        if (context == null) {
            return "";
        }
        try {
            return o.b(context, f22914u, f22907n, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long d(a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                return o.b(context, f22908o + aVar.index(), f22899f, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static long e() {
        Context context = ab.f22568h;
        if (context == null) {
            return 0L;
        }
        try {
            return o.b(context, f22908o, f22899f, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long f(a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                return o.b(context, f22909p + aVar.index(), f22902i, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static String a(a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                return o.b(context, f22908o + aVar.index(), f22895b, (String) null);
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
        return null;
    }

    public static String b(a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                return o.b(context, f22908o + aVar.index(), f22896c, (String) null);
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
        return null;
    }

    public static long c(a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                return o.b(context, f22908o + aVar.index(), f22898e, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static void a(String str, a aVar) {
        Context context = ab.f22568h;
        if (context != null && aVar != null) {
            try {
                o.a(context, f22908o + aVar.index(), f22895b, str);
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    public static void b() {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                context.getSharedPreferences("TD_CHANNEL_ID", 0).edit().putBoolean("location_called", true).commit();
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    public static void c(long j10, a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                o.a(context, f22909p + aVar.index(), f22902i, j10);
            } catch (Throwable unused) {
            }
        }
    }

    public static String c(String str) {
        Context context = ab.f22568h;
        if (context == null) {
            return "";
        }
        try {
            return o.b(context, f22913t, str + D, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(long j10, a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                o.a(context, f22908o + aVar.index(), f22898e, j10);
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(long j10, a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                o.a(context, f22908o + aVar.index(), f22899f, j10);
            } catch (Throwable unused) {
            }
        }
    }

    public static void c(String str, String str2) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22913t, str + D, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(boolean z10, a aVar) {
        Context context = ab.f22568h;
        if (!(context == null || aVar == null)) {
            try {
                o.a(context, f22908o + aVar.index(), f22900g, z10 ? 1L : 0L);
            } catch (Throwable unused) {
            }
        }
    }

    public static void b(String str, String str2) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(String str, String str2) {
        Context context = ab.f22568h;
        if (context != null) {
            try {
                o.a(context, f22909p, str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    public static String b(String str) {
        Context context = ab.f22568h;
        if (context == null) {
            return null;
        }
        try {
            return o.b(context, f22909p, str, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str) {
        Context context = ab.f22568h;
        if (context == null) {
            return null;
        }
        try {
            return o.b(context, f22909p, str, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
