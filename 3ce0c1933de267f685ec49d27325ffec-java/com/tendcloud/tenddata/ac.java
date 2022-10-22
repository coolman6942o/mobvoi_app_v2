package com.tendcloud.tenddata;

import android.app.Activity;
import android.content.Context;
import com.tendcloud.tenddata.af;
import java.util.Map;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class ac {

    /* renamed from: a  reason: collision with root package name */
    private static ao f22587a;

    public static synchronized void a(Context context, a aVar) {
        synchronized (ac.class) {
            try {
                f(context, aVar);
                f22587a.a(context, aVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static String b(Context context, a aVar) {
        return ab.a(context, aVar);
    }

    public static String c(Context context, a aVar) {
        return ab.b(context, aVar);
    }

    public static synchronized String d(Context context, a aVar) {
        String b10;
        synchronized (ac.class) {
            try {
                f(context, aVar);
                b10 = f22587a.b(context, aVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
        return b10;
    }

    public static void e(String str, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.c(str, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private static synchronized void f(Context context, a aVar) {
        synchronized (ac.class) {
            if (context != null) {
                ab.f22568h = context.getApplicationContext();
            }
            if (ab.f22568h == null) {
                g.eForDeveloper("Init failed Context is null ");
                return;
            }
            if (f22587a == null) {
                System.currentTimeMillis();
                f22587a = zz.a();
            }
        }
    }

    public static void g(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.g(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void h(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.h(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void i(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.i(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void j(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.j(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void k(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.k(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static synchronized void setConfigurationDisable(int i10) {
        synchronized (ac.class) {
            try {
                ab.setConfigurationDisable(i10);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void setProfileId(String str) {
        try {
            ab.f22580t = str;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static Context b() {
        return f22587a.d();
    }

    public static void c() {
        try {
            g.f22893a = false;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(Activity activity, a aVar) {
        try {
            f(activity, aVar);
            f22587a.b(activity, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void c(Context context, String str, a aVar) {
        b(context, str, "", aVar);
    }

    public static void e(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.e(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static synchronized void a(Context context, String str, String str2, a aVar) {
        synchronized (ac.class) {
            try {
                f(context, aVar);
                f22587a.a(context, str, str2, aVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void c(String str, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.b(str, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void d(String str, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.d(str, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(Context context, String str, a aVar) {
        try {
            f(context, aVar);
            f22587a.b(context, str, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static synchronized String e(Context context, a aVar) {
        String e10;
        synchronized (ac.class) {
            try {
                f(context, aVar);
                e10 = f22587a.e(context, aVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
        return e10;
    }

    public static void c(String str, int i10, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.c(str, i10, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void d(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.d(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static synchronized void a(Context context, String str, String str2, String str3, a aVar) {
        synchronized (ac.class) {
            try {
                f(context, aVar);
                f22587a.a(context, str, str2, str3, aVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static void b(Context context, String str, String str2, a aVar) {
        a(context, str, str2, (Map<String, Object>) null, aVar);
    }

    public static void f(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.f(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(String str, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void c(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.c(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static boolean a() {
        return zz.f23040b;
    }

    public static void b(String str, af.ProfileType profileType, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, profileType, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static synchronized String a(Context context) {
        String b10;
        synchronized (ac.class) {
            try {
                f(context, null);
                b10 = f22587a.b(context);
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
        return b10;
    }

    public static void c(String str, String str2, long j10, int i10, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.c(str, str2, j10, i10, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(String str, String str2, int i10, String str3, String str4, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, i10, str3, str4, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Activity activity, String str, String str2, a aVar) {
        try {
            f(activity, aVar);
            f22587a.a(activity, str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(String str, int i10, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.b(str, i10, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Activity activity, a aVar) {
        try {
            f(activity, aVar);
            f22587a.a(activity, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.b(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, String str, a aVar) {
        try {
            f(context, aVar);
            f22587a.a(context, str, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(String str, String str2, String str3, int i10, String str4, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.b(str, str2, str3, i10, str4, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, Object obj, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, obj);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(String str, String str2, long j10, int i10, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.b(str, str2, j10, i10, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.removeGlobalKV(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, String str, Map<String, Object> map, a aVar) {
        a(context, str, (String) null, map, aVar);
    }

    public static void a(Context context, String str, String str2, Map<String, Object> map, a aVar) {
        try {
            f(context, aVar);
            f22587a.a(context, str, str2, map, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, Map<String, Object> map, double d10, a aVar) {
        try {
            f(context, aVar);
            f22587a.a(context, str, str2, map, d10, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, String str, double d10, Map<String, Object> map, a aVar) {
        try {
            f(context, aVar);
            f22587a.a(context, str, map, d10, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(a aVar, String str) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(ab.f22568h, str, "", (Map<String, Object>) null, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(boolean z10, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.c(z10);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Context context, Throwable th2, a aVar) {
        try {
            f(context, aVar);
            f22587a.a(context, th2, aVar);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void a(String str, af.ProfileType profileType, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.b(str, profileType, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, TalkingDataProfile talkingDataProfile, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, talkingDataProfile, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(TalkingDataProfile talkingDataProfile, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(talkingDataProfile, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, TalkingDataProfile talkingDataProfile, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, talkingDataProfile, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, str3, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i10, String str3, String str4, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.b(str, str2, i10, str3, str4, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, cu cuVar, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, cuVar, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i10, String str3, String str4, cu cuVar, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, i10, str3, str4, cuVar, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, int i10, String str3, String str4, String str5, int i11, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, i10, str3, str4, str5, i11, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, int i10, String str2, String str3, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, i10, str2, str3, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(TalkingDataOrder talkingDataOrder, String str, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(talkingDataOrder, str, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, cu cuVar, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, cuVar, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, int i10, String str2, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, i10, str2, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(TalkingDataOrder talkingDataOrder, String str, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(talkingDataOrder, str, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(TalkingDataOrder talkingDataOrder, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(talkingDataOrder, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i10, int i11, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, str3, i10, i11, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i10, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, str3, i10, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(cv cvVar, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(cvVar, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(TalkingDataShoppingCart talkingDataShoppingCart, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(talkingDataShoppingCart, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(cw cwVar, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(cwVar, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(TalkingDataSearch talkingDataSearch, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(talkingDataSearch, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, cx cxVar, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, cxVar, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, TalkingDataTransaction talkingDataTransaction, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, talkingDataTransaction, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, int i10, String str4, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, str3, i10, str4, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, long j10, int i10, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, j10, i10, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, String str4, a aVar) {
        try {
            f(ab.f22568h, aVar);
            f22587a.a(str, str2, str3, str4, aVar);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
