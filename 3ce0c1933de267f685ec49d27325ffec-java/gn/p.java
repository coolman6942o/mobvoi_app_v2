package gn;

import android.content.Context;
/* loaded from: classes2.dex */
public class p {
    private static boolean a(Context context) {
        String str;
        String u10 = z.v(context).u();
        boolean z10 = false;
        String substring = (!u10.contains("V") || u10.length() <= 2) ? null : u10.substring(0, u10.indexOf("V"));
        if (substring != null) {
            if (substring.length() > 0) {
                String substring2 = substring.substring(0, 1);
                String substring3 = substring.length() > 1 ? substring.substring(0, 2) : "AA";
                if (substring2.contains("B") || substring3.contains("RB")) {
                    z10 = true;
                }
            }
            str = "是否支持血压 =" + z10;
        } else {
            str = "是否支持血压 =false";
        }
        u.a("GetFunctionList", str);
        return z10;
    }

    private static boolean b(Context context) {
        String u10 = z.v(context).u();
        boolean z10 = false;
        String substring = (!u10.contains("V") || u10.length() <= 2) ? null : u10.substring(0, u10.indexOf("V"));
        if (substring != null && substring.length() > 0 && (substring.contains("MH") || substring.contains("RH") || substring.contains("UH"))) {
            z10 = true;
        }
        u.a("GetFunctionList", "是否支持心率 =" + z10);
        return z10;
    }

    public static boolean c(Context context, int i10) {
        int l10 = z.v(context).l();
        boolean z10 = (l10 & i10) == i10;
        u.a("GetFunctionList", "isSupport =" + z10 + ",functionType =" + i10 + ",function=" + l10);
        if (z10 || i10 != 524288) {
            if (!z10 && i10 == 1048576 && a(context)) {
                return true;
            }
        } else if (b(context) || a(context)) {
            return true;
        }
        return z10;
    }

    public static boolean d(Context context, int i10) {
        int p10 = z.v(context).p();
        boolean z10 = (p10 & i10) == i10;
        u.a("GetFunctionList", "isSupport5 =" + z10 + ",functionType =" + i10 + ",function =" + p10);
        return z10;
    }

    public static boolean e(Context context, int i10) {
        int o10 = z.v(context).o();
        boolean z10 = (o10 & i10) == i10;
        u.a("GetFunctionList", "isSupport4 =" + z10 + ",functionType =" + i10 + ",function =" + o10);
        return z10;
    }

    public static boolean f(Context context, int i10) {
        int m10 = z.v(context).m();
        boolean z10 = (m10 & i10) == i10;
        u.a("GetFunctionList", "isSupport2 =" + z10 + ",functionType =" + i10 + ",function =" + m10);
        return z10;
    }

    public static boolean g(Context context, int i10) {
        int q5 = z.v(context).q();
        boolean z10 = (q5 & i10) == i10;
        u.a("GetFunctionList", "isSupport7 =" + z10 + ",functionType =" + i10 + ",function =" + q5);
        return z10;
    }

    public static boolean h(Context context, int i10) {
        int n10 = z.v(context).n();
        boolean z10 = (n10 & i10) == i10;
        u.a("GetFunctionList", "isSupport3 =" + z10 + ",functionType =" + i10 + ",function =" + n10);
        return z10;
    }
}
