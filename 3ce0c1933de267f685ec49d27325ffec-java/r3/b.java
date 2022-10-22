package r3;

import a4.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ConditionVariable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.app.PayTask;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public static volatile b f33394d;

    /* renamed from: a  reason: collision with root package name */
    public String f33395a;

    /* renamed from: b  reason: collision with root package name */
    public String f33396b = "sdk-and-lite";

    /* renamed from: c  reason: collision with root package name */
    public String f33397c;

    /* loaded from: classes.dex */
    public static class a implements APSecuritySdk.InitResultListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f33398a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f33399b;

        public a(String[] strArr, ConditionVariable conditionVariable) {
            this.f33398a = strArr;
            this.f33399b = conditionVariable;
        }

        @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
        public void onResult(APSecuritySdk.TokenResult tokenResult) {
            if (tokenResult != null) {
                this.f33398a[0] = tokenResult.apdidToken;
            }
            this.f33399b.open();
        }
    }

    /* renamed from: r3.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class CallableC0458b implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y3.a f33400a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f33401b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HashMap f33402c;

        public CallableC0458b(y3.a aVar, Context context, HashMap hashMap) {
            this.f33400a = aVar;
            this.f33401b = context;
            this.f33402c = hashMap;
        }

        /* renamed from: a */
        public String call() throws Exception {
            return b.j(this.f33400a, this.f33401b, this.f33402c);
        }
    }

    public b() {
        String a10 = o3.a.a();
        if (!o3.a.c()) {
            this.f33396b += '_' + a10;
        }
    }

    public static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public static synchronized void d(String str) {
        synchronized (b.class) {
            if (!TextUtils.isEmpty(str)) {
                PreferenceManager.getDefaultSharedPreferences(y3.b.e().c()).edit().putString("trideskey", str).apply();
                q3.a.f32920b = str;
            }
        }
    }

    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb2.append("(");
            sb2.append(packageName);
            sb2.append(";");
            sb2.append(packageInfo.versionCode);
            sb2.append(")");
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f(y3.a aVar, Context context, HashMap<String, String> hashMap) {
        try {
            return (String) Executors.newFixedThreadPool(2).submit(new CallableC0458b(aVar, context, hashMap)).get(PayTask.f6879j, TimeUnit.MILLISECONDS);
        } catch (Throwable th2) {
            p3.a.d(aVar, "third", "GetApdidTimeout", th2);
            return "";
        }
    }

    public static synchronized b g() {
        b bVar;
        synchronized (b.class) {
            if (f33394d == null) {
                f33394d = new b();
            }
            bVar = f33394d;
        }
        return bVar;
    }

    public static String h() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        return hexString + (random.nextInt(9000) + 1000);
    }

    public static String i(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    public static String j(y3.a aVar, Context context, HashMap<String, String> hashMap) {
        String[] strArr = {""};
        try {
            APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(context);
            ConditionVariable conditionVariable = new ConditionVariable();
            aPSecuritySdk.initToken(0, hashMap, new a(strArr, conditionVariable));
            conditionVariable.block(PayTask.f6879j);
        } catch (Throwable th2) {
            d.d(th2);
            p3.a.d(aVar, "third", "GetApdidEx", th2);
        }
        if (TextUtils.isEmpty(strArr[0])) {
            p3.a.h(aVar, "third", "GetApdidNull", "missing token");
        }
        d.f("mspl", "ap:" + strArr[0]);
        return strArr[0];
    }

    public static String k() {
        return "-1;-1";
    }

    public static String l(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : "-1";
    }

    public static String m() {
        return "1";
    }

    public static String n() {
        String str;
        Context c10 = y3.b.e().c();
        SharedPreferences sharedPreferences = c10.getSharedPreferences("virtualImeiAndImsi", 0);
        String string = sharedPreferences.getString("virtual_imei", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(z3.a.a(c10).g())) {
            str = h();
        } else {
            str = a4.b.a(c10).b();
        }
        String str2 = str;
        sharedPreferences.edit().putString("virtual_imei", str2).apply();
        return str2;
    }

    public static String o() {
        String str;
        Context c10 = y3.b.e().c();
        SharedPreferences sharedPreferences = c10.getSharedPreferences("virtualImeiAndImsi", 0);
        String string = sharedPreferences.getString("virtual_imsi", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(z3.a.a(c10).g())) {
            String d10 = y3.b.e().d();
            if (TextUtils.isEmpty(d10) || d10.length() < 18) {
                str = h();
            } else {
                str = d10.substring(3, 18);
            }
        } else {
            str = a4.b.a(c10).c();
        }
        String str2 = str;
        sharedPreferences.edit().putString("virtual_imsi", str2).apply();
        return str2;
    }

    public String c(y3.a aVar, z3.a aVar2) {
        Context c10 = y3.b.e().c();
        a4.b a10 = a4.b.a(c10);
        if (TextUtils.isEmpty(this.f33395a)) {
            String J = com.alipay.sdk.util.b.J();
            String G = com.alipay.sdk.util.b.G();
            String D = com.alipay.sdk.util.b.D(c10);
            String K = com.alipay.sdk.util.b.K(c10);
            String O = com.alipay.sdk.util.b.O(c10);
            String a11 = a(c10);
            this.f33395a = "Msp/15.8.02 (" + J + ";" + G + ";" + D + ";" + K + ";" + O + ";" + a11;
        }
        String b10 = a4.b.e(c10).b();
        String x10 = com.alipay.sdk.util.b.x(c10);
        String m10 = m();
        String c11 = a10.c();
        String b11 = a10.b();
        String o10 = o();
        String n10 = n();
        if (aVar2 != null) {
            this.f33397c = aVar2.f();
        }
        String replace = Build.MANUFACTURER.replace(";", " ");
        String replace2 = Build.MODEL.replace(";", " ");
        boolean f10 = y3.b.f();
        String f11 = a10.f();
        String l10 = l(c10);
        String i10 = i(c10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f33395a);
        sb2.append(";");
        sb2.append(b10);
        sb2.append(";");
        sb2.append(x10);
        sb2.append(";");
        sb2.append(m10);
        sb2.append(";");
        sb2.append(c11);
        sb2.append(";");
        sb2.append(b11);
        sb2.append(";");
        sb2.append(this.f33397c);
        sb2.append(";");
        sb2.append(replace);
        sb2.append(";");
        sb2.append(replace2);
        sb2.append(";");
        sb2.append(f10);
        sb2.append(";");
        sb2.append(f11);
        sb2.append(";");
        sb2.append(k());
        sb2.append(";");
        sb2.append(this.f33396b);
        sb2.append(";");
        sb2.append(o10);
        sb2.append(";");
        sb2.append(n10);
        sb2.append(";");
        sb2.append(l10);
        sb2.append(";");
        sb2.append(i10);
        if (aVar2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("tid", z3.a.a(c10).g());
            hashMap.put("utdid", y3.b.e().d());
            String f12 = f(aVar, c10, hashMap);
            if (!TextUtils.isEmpty(f12)) {
                sb2.append(";;;");
                sb2.append(f12);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
