package z3;

import a4.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Random;
import org.json.JSONObject;
import s3.e;
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static Context f37267g;

    /* renamed from: h  reason: collision with root package name */
    public static a f37268h;

    /* renamed from: a  reason: collision with root package name */
    public String f37269a;

    /* renamed from: b  reason: collision with root package name */
    public String f37270b;

    /* renamed from: c  reason: collision with root package name */
    public long f37271c;

    /* renamed from: d  reason: collision with root package name */
    public String f37272d;

    /* renamed from: e  reason: collision with root package name */
    public String f37273e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37274f = false;

    /* renamed from: z3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0543a {
        public static String a() {
            String str;
            try {
                str = a.f37267g.getApplicationContext().getPackageName();
            } catch (Throwable th2) {
                d.d(th2);
                str = "";
            }
            return (str + "0000000000000000000000000000").substring(0, 24);
        }

        public static String b(String str, String str2, boolean z10) {
            if (a.f37267g == null) {
                return null;
            }
            String string = a.f37267g.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z10) {
                string = e.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    d.f("mspl", "tid_str: pref failed");
                }
            }
            d.f("mspl", "tid_str: from local");
            return string;
        }

        public static void c(String str, String str2, String str3, boolean z10) {
            if (a.f37267g != null) {
                SharedPreferences sharedPreferences = a.f37267g.getSharedPreferences(str, 0);
                if (z10) {
                    String a10 = a();
                    String c10 = e.c(a10, str3, str3);
                    if (TextUtils.isEmpty(c10)) {
                        String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, a10);
                    }
                    str3 = c10;
                }
                sharedPreferences.edit().putString(str2, str3).apply();
            }
        }

        public static void d(String str, String str2) {
            if (a.f37267g != null) {
                a.f37267g.getSharedPreferences(str, 0).edit().remove(str2).apply();
            }
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f37268h == null) {
                f37268h = new a();
            }
            if (f37267g == null) {
                f37268h.e(context);
            }
            aVar = f37268h;
        }
        return aVar;
    }

    private boolean c(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    private void e(Context context) {
        if (context != null) {
            f37267g = context.getApplicationContext();
        }
        if (!this.f37274f) {
            this.f37274f = true;
            j();
        }
    }

    private String i() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j() {
        String str;
        String str2;
        String str3;
        String str4;
        Exception e10;
        String b10;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        String str5 = null;
        try {
            b10 = C0543a.b("alipay_tid_storage", "tidinfo", true);
        } catch (Exception e11) {
            e10 = e11;
            str4 = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(b10)) {
            JSONObject jSONObject = new JSONObject(b10);
            str4 = jSONObject.optString("tid", "");
            try {
                str2 = jSONObject.optString("client_key", "");
                try {
                    valueOf = Long.valueOf(jSONObject.optLong("timestamp", System.currentTimeMillis()));
                    str = jSONObject.optString("vimei", "");
                } catch (Exception e12) {
                    e10 = e12;
                    str = null;
                }
            } catch (Exception e13) {
                e10 = e13;
                str2 = null;
                str = str2;
                d.d(e10);
                str3 = str5;
                str5 = str4;
                d.f("mspl", "tid_str: load");
                if (!c(str5, str2, str, str3)) {
                }
            }
            try {
                str5 = jSONObject.optString("vimsi", "");
            } catch (Exception e14) {
                e10 = e14;
                d.d(e10);
                str3 = str5;
                str5 = str4;
                d.f("mspl", "tid_str: load");
                if (!c(str5, str2, str, str3)) {
                }
            }
            str3 = str5;
            str5 = str4;
            d.f("mspl", "tid_str: load");
            if (!c(str5, str2, str, str3)) {
                k();
                return;
            }
            this.f37269a = str5;
            this.f37270b = str2;
            this.f37271c = valueOf.longValue();
            this.f37272d = str;
            this.f37273e = str3;
            return;
        }
        str3 = null;
        str2 = null;
        str = null;
        d.f("mspl", "tid_str: load");
        if (!c(str5, str2, str, str3)) {
        }
    }

    private void k() {
        this.f37269a = "";
        this.f37270b = d();
        this.f37271c = System.currentTimeMillis();
        this.f37272d = i();
        this.f37273e = i();
        C0543a.d("alipay_tid_storage", "tidinfo");
    }

    private void l() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f37269a);
            jSONObject.put("client_key", this.f37270b);
            jSONObject.put("timestamp", this.f37271c);
            jSONObject.put("vimei", this.f37272d);
            jSONObject.put("vimsi", this.f37273e);
            C0543a.c("alipay_tid_storage", "tidinfo", jSONObject.toString(), true);
        } catch (Exception e10) {
            d.d(e10);
        }
    }

    private void m() {
    }

    public void b(String str, String str2) {
        d.f("mspl", "tid_str: save");
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f37269a = str;
            this.f37270b = str2;
            this.f37271c = System.currentTimeMillis();
            l();
            m();
        }
    }

    public String d() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public String f() {
        return this.f37270b;
    }

    public String g() {
        return this.f37269a;
    }
}
