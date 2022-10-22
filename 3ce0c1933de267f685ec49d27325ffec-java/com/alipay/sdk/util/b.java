package com.alipay.sdk.util;

import a4.d;
import a4.i;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alipay.sdk.app.EnvUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.laser.tsm.sdk.AppConfig;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.tendcloud.tenddata.aa;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import r3.a;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f6930a = {"10.1.5.1013151", "10.1.5.1013148"};

    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6931a;

        public a(Activity activity) {
            this.f6931a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6931a.finish();
        }
    }

    /* renamed from: com.alipay.sdk.util.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0092b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Runnable f6932a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f6933b;

        public RunnableC0092b(Runnable runnable, ConditionVariable conditionVariable) {
            this.f6932a = runnable;
            this.f6933b = conditionVariable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f6932a.run();
            } finally {
                this.f6933b.open();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final PackageInfo f6934a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6935b;

        /* renamed from: c  reason: collision with root package name */
        public final String f6936c;

        public c(PackageInfo packageInfo, int i10, String str) {
            this.f6934a = packageInfo;
            this.f6935b = i10;
            this.f6936c = str;
        }

        public boolean a() {
            return this.f6934a.versionCode < this.f6935b;
        }

        public boolean b(y3.a aVar) {
            Signature[] signatureArr = this.f6934a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String m10 = b.m(aVar, signature.toByteArray());
                if (m10 != null && !TextUtils.equals(m10, this.f6936c)) {
                    p3.a.h(aVar, "biz", "PublicKeyUnmatch", String.format("Got %s, expected %s", m10, this.f6936c));
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean A(y3.a aVar, Context context, List<a.b> list) {
        try {
            for (a.b bVar : list) {
                if (bVar != null) {
                    String str = bVar.f33391a;
                    if (EnvUtils.a() && "com.eg.android.AlipayGphone".equals(str)) {
                        str = "com.eg.android.AlipayGphoneRC";
                    }
                    try {
                        if (context.getPackageManager().getPackageInfo(str, 128) != null) {
                            return true;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            p3.a.d(aVar, "biz", "CheckLaunchAppExistEx", th2);
            return false;
        }
    }

    public static int B(String str) {
        try {
            String t10 = r3.a.G().t();
            int i10 = 0;
            if (TextUtils.isEmpty(t10)) {
                return 0;
            }
            if (i(t10, "").contains(str)) {
                i10 = 2;
            }
            return i10 | 1;
        } catch (Throwable unused) {
            return 61440;
        }
    }

    public static String C() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            if (!matcher.matches() || matcher.groupCount() < 4) {
                return "Unavailable";
            }
            return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String D(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String E(y3.a aVar, String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e10) {
            p3.a.h(aVar, "biz", "rflex", e10.getClass().getSimpleName());
            return null;
        }
    }

    public static DisplayMetrics F(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String G() {
        String C = C();
        int indexOf = C.indexOf("-");
        if (indexOf != -1) {
            C = C.substring(0, indexOf);
        }
        int indexOf2 = C.indexOf("\n");
        if (indexOf2 != -1) {
            C = C.substring(0, indexOf2);
        }
        return "Linux " + C;
    }

    public static boolean H(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static boolean I(y3.a aVar, String str) {
        try {
            int B = B(str);
            p3.a.c(aVar, "biz", "bindExt", "" + B);
            return r3.a.G().y() && (B & 2) == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String J() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String K(Context context) {
        String a10 = i.a(context);
        return a10.substring(0, a10.indexOf(aa.f22529a));
    }

    public static String L(String str) {
        return k(str, true);
    }

    public static String M(y3.a aVar, String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e10) {
            p3.a.d(aVar, "biz", "H5PayDataAnalysisError", e10);
            return "";
        }
    }

    public static int N() {
        try {
            return Process.myUid();
        } catch (Throwable th2) {
            d.d(th2);
            return -200;
        }
    }

    public static String O(Context context) {
        DisplayMetrics F = F(context);
        return F.widthPixels + MessageProxyConstants.NODE_ID_ANY + F.heightPixels;
    }

    public static JSONObject P(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static String Q(Context context) {
        String J = J();
        String G = G();
        String D = D(context);
        String O = O(context);
        return " (" + J + ";" + G + ";" + D + ";;" + O + ")(sdk android)";
    }

    public static String R(String str) {
        try {
            Uri parse = Uri.parse(str);
            return String.format("%s%s", parse.getAuthority(), parse.getPath());
        } catch (Throwable th2) {
            d.d(th2);
            return "-";
        }
    }

    public static boolean S() {
        try {
            String[] split = r3.a.G().q().split("\\|");
            String str = Build.MODEL;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (String str2 : split) {
                if (TextUtils.equals(str, str2) || TextUtils.equals(str2, "all")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            d.d(th2);
            return false;
        }
    }

    public static boolean T(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(f(), 128);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode < 99;
        } catch (Throwable th2) {
            d.d(th2);
            return false;
        }
    }

    public static boolean U(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.alipay.android.app", 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static ActivityInfo a(Context context) {
        ActivityInfo[] activityInfoArr;
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                    if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            d.d(th2);
            return null;
        }
    }

    public static c b(PackageInfo packageInfo, int i10, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new c(packageInfo, i10, str);
    }

    public static c c(y3.a aVar, Context context, String str, int i10, String str2) {
        PackageInfo packageInfo;
        if (EnvUtils.a() && "com.eg.android.AlipayGphone".equals(str)) {
            str = "com.eg.android.AlipayGphoneRC";
        }
        try {
            packageInfo = w(context, str);
        } catch (Throwable th2) {
            p3.a.h(aVar, "auth", "GetPackageInfoEx", th2.getMessage());
            packageInfo = null;
        }
        if (!s(aVar, packageInfo)) {
            return null;
        }
        return b(packageInfo, i10, str2);
    }

    public static c d(y3.a aVar, Context context, List<a.b> list) {
        c c10;
        if (list == null) {
            return null;
        }
        for (a.b bVar : list) {
            if (bVar != null && (c10 = c(aVar, context, bVar.f33391a, bVar.f33392b, bVar.f33393c)) != null && !c10.b(aVar) && !c10.a()) {
                return c10;
            }
        }
        return null;
    }

    public static <T> T e(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static String f() {
        if (EnvUtils.a()) {
            return "com.eg.android.AlipayGphoneRC";
        }
        try {
            return o3.a.f31407d.get(0).f33391a;
        } catch (Throwable unused) {
            return "com.eg.android.AlipayGphone";
        }
    }

    public static String g(int i10) {
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb2.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (nextInt == 1) {
                sb2.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (nextInt == 2) {
                sb2.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb2.toString();
    }

    public static String h(Context context, String str) {
        String str2 = "";
        try {
            String str3 = str2;
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    str3 = str3 + "#M";
                } else {
                    if (runningAppProcessInfo.processName.startsWith(str + ":")) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str3);
                        sb2.append("#");
                        sb2.append(runningAppProcessInfo.processName.replace(str + ":", str2));
                        str3 = sb2.toString();
                    }
                }
            }
            str2 = str3;
        } catch (Throwable unused) {
        }
        if (str2.length() > 0) {
            str2 = str2.substring(1);
        }
        return str2.length() == 0 ? "N" : str2;
    }

    public static String i(String str, String str2) {
        String string = Settings.Secure.getString(((Application) y3.b.e().c()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    public static String j(String str, String str2, String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int i10 = 0;
            if (!TextUtils.isEmpty(str2)) {
                i10 = str3.indexOf(str2, indexOf);
            }
            if (i10 < 1) {
                return str3.substring(indexOf);
            }
            return str3.substring(indexOf, i10);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k(String str, boolean z10) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            if (!z10 || digest.length <= 16) {
                return n(digest);
            }
            byte[] bArr = new byte[16];
            System.arraycopy(digest, 0, bArr, 0, 16);
            return n(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String l(y3.a aVar) {
        return E(aVar, "ro.build.fingerprint");
    }

    public static String m(y3.a aVar, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e10) {
            p3.a.d(aVar, "auth", "GetPublicKeyFromSignEx", e10);
            return null;
        }
    }

    public static String n(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append(Character.forDigit((b10 & 240) >> 4, 16));
            sb2.append(Character.forDigit(b10 & 15, 16));
        }
        return sb2.toString();
    }

    public static Map<String, String> o(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER, 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    public static JSONObject p(Intent intent) {
        Bundle extras;
        JSONObject jSONObject = new JSONObject();
        if (!(intent == null || (extras = intent.getExtras()) == null)) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, String.valueOf(extras.get(str)));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public static boolean q(long j10, Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        ConditionVariable conditionVariable = new ConditionVariable();
        Thread thread = new Thread(new RunnableC0092b(runnable, conditionVariable));
        if (!TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        boolean z10 = true;
        try {
            if (j10 <= 0) {
                conditionVariable.block();
            } else {
                z10 = conditionVariable.block(j10);
            }
        } catch (Throwable unused) {
        }
        return z10;
    }

    public static boolean r(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = f6930a;
            if (!TextUtils.equals(str, strArr[0])) {
                if (!TextUtils.equals(str, strArr[1])) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean s(y3.a aVar, PackageInfo packageInfo) {
        String str = "";
        boolean z10 = false;
        if (packageInfo == null) {
            str = str + "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = str + "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = str + "info.signatures.length <= 0";
            } else {
                z10 = true;
            }
        }
        if (!z10) {
            p3.a.h(aVar, "auth", "NotIncludeSignatures", str);
        }
        return z10;
    }

    public static boolean t(y3.a aVar, String str) {
        try {
            String host = new URL(str).getHost();
            if (!host.endsWith("alipay.com")) {
                return host.endsWith("alipay.net");
            }
            return true;
        } catch (Throwable th2) {
            p3.a.d(aVar, "biz", "ckUrlErr", th2);
            return false;
        }
    }

    public static boolean u(y3.a aVar, String str, Activity activity) {
        int parseInt;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase()) || str.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase())) {
            try {
                c d10 = d(aVar, activity, o3.a.f31407d);
                if (d10 != null && !d10.a() && !d10.b(aVar)) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp\\?", "alipays://platformapi/startApp?");
                    }
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Throwable unused) {
            }
            return true;
        } else if (TextUtils.equals(str, "sdklite://h5quit") || TextUtils.equals(str, "http://m.alipay.com/?action=h5quit")) {
            o3.b.c(o3.b.a());
            activity.finish();
            return true;
        } else if (!str.startsWith("sdklite://h5quit?result=")) {
            return false;
        } else {
            try {
                String substring = str.substring(str.indexOf("sdklite://h5quit?result=") + 24);
                parseInt = Integer.parseInt(substring.substring(substring.lastIndexOf("&end_code=") + 10));
            } catch (Exception unused2) {
                o3.b.c(o3.b.h());
            }
            if (!(parseInt == com.alipay.sdk.app.c.SUCCEEDED.b() || parseInt == com.alipay.sdk.app.c.PAY_WAITTING.b())) {
                com.alipay.sdk.app.c b10 = com.alipay.sdk.app.c.b(com.alipay.sdk.app.c.FAILED.b());
                o3.b.c(o3.b.b(b10.b(), b10.a(), ""));
                activity.runOnUiThread(new a(activity));
                return true;
            }
            if (q3.a.f32921c) {
                StringBuilder sb2 = new StringBuilder();
                String decode = URLDecoder.decode(str);
                String decode2 = URLDecoder.decode(decode);
                String str3 = decode2.substring(decode2.indexOf("sdklite://h5quit?result=") + 24, decode2.lastIndexOf("&end_code=")).split("&return_url=")[0];
                int indexOf = decode.indexOf("&return_url=") + 12;
                sb2.append(str3);
                sb2.append("&return_url=");
                sb2.append(decode.substring(indexOf, decode.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf)));
                sb2.append(decode.substring(decode.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf)));
                str2 = sb2.toString();
            } else {
                String decode3 = URLDecoder.decode(str);
                str2 = decode3.substring(decode3.indexOf("sdklite://h5quit?result=") + 24, decode3.lastIndexOf("&end_code="));
            }
            com.alipay.sdk.app.c b11 = com.alipay.sdk.app.c.b(parseInt);
            o3.b.c(o3.b.b(b11.b(), b11.a(), str2));
            activity.runOnUiThread(new a(activity));
            return true;
        }
    }

    public static int v(int i10) {
        return i10 / AppConfig.STATUS_SUCCESS;
    }

    public static PackageInfo w(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static String x(Context context) {
        return "-1;-1";
    }

    public static String y(String str) {
        return (!EnvUtils.a() || !TextUtils.equals(str, "com.eg.android.AlipayGphoneRC")) ? "com.eg.android.AlipayGphone.IAlixPay" : "com.eg.android.AlipayGphoneRC.IAlixPay";
    }

    public static Map<String, String> z(y3.a aVar, String str) {
        String[] split;
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            for (String str2 : str.substring(indexOf + 1).split(ContainerUtils.FIELD_DELIMITER)) {
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), M(aVar, str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }
}
