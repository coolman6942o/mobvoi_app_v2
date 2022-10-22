package com.paypal.android.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f21452a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f21453b;

    /* renamed from: c  reason: collision with root package name */
    private static final Uri f21454c;

    static {
        Uri uri;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(t.class.getSimpleName());
        sb2.append(".");
        sb2.append(m0.class.getSimpleName());
        Boolean bool = Boolean.FALSE;
        f21452a = Boolean.valueOf(System.getProperty("dyson.debug.mode", bool.toString())).booleanValue();
        f21453b = Boolean.valueOf(System.getProperty("prd.debug.mode", bool.toString())).booleanValue();
        try {
            uri = Uri.parse("content://com.google.android.gsf.gservices");
        } catch (Exception unused) {
            uri = null;
        }
        f21454c = uri;
    }

    private m0() {
    }

    public static String A() {
        String property;
        String property2;
        if (Build.VERSION.SDK_INT < 14 || (property = System.getProperty("http.proxyHost")) == null || (property2 = System.getProperty("http.proxyPort")) == null) {
            return null;
        }
        return "host=" + property + ",port=" + property2;
    }

    public static String B(Context context) {
        int i10 = context.getSharedPreferences("RiskManagerCT", 0).getInt("RiskManagerCT", 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10);
        return sb2.toString();
    }

    public static String C() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0) {
                    String name = networkInterface.getName();
                    if (name.startsWith("ppp") || name.startsWith("tun") || name.startsWith("tap")) {
                        return name;
                    }
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Location a(LocationManager locationManager) {
        Location location = null;
        try {
            List<String> providers = locationManager.getProviders(true);
            for (int size = providers.size() - 1; size >= 0; size--) {
                location = locationManager.getLastKnownLocation(providers.get(size));
                if (location != null) {
                    break;
                }
            }
        } catch (RuntimeException unused) {
        }
        return location;
    }

    public static o b(Context context) {
        o oVar = new o();
        oVar.b(context.getPackageName());
        try {
            oVar.d(context.getPackageManager().getPackageInfo(oVar.a(), 0).versionName);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return oVar;
    }

    public static Object c(Object obj, Class cls) {
        if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
            return null;
        }
        return cls.cast(obj);
    }

    public static Object d(Map map, Class cls, String str, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(str)) == null) {
            return obj;
        }
        if (cls.isAssignableFrom(obj2.getClass())) {
            return cls.cast(obj2);
        }
        k(6, "PRD", "cannot parse data for " + str, new Exception("cannot parse data for " + str));
        return obj;
    }

    public static String e() {
        q qVar;
        String c10;
        String str = "";
        try {
            qVar = new q();
            qVar.a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.ebay.lid/");
            c10 = qVar.c("fb.bin");
            try {
            } catch (Exception unused) {
                str = c10;
            }
        } catch (Exception unused2) {
        }
        if (!str.equals(c10.trim())) {
            return c10;
        }
        str = v(true);
        qVar.b("fb.bin", str.getBytes("UTF-8"));
        return str;
    }

    public static String f(Context context, String str, String str2) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                return applicationInfo.metaData.getString(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String g(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : digest) {
            stringBuffer.append(Integer.toString((b10 & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString().substring(0, 32);
    }

    public static String h(Map map, String str, String str2) {
        return (String) d(map, String.class, str, null);
    }

    public static List i(boolean z10) {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        String hostAddress = nextElement.getHostAddress();
                        if (!(nextElement instanceof Inet6Address) || z10) {
                            arrayList.add(hostAddress);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static void j(int i10, String str, String str2) {
        if (f21453b) {
            Log.println(i10, str, str2);
        }
    }

    public static void k(int i10, String str, String str2, Throwable th2) {
        if (f21453b) {
            Log.println(6, str, str2 + '\n' + Log.getStackTraceString(th2));
        }
    }

    public static void l(String str, String str2) {
    }

    public static void m(String str, String str2, Throwable th2) {
    }

    public static void n(String str, JSONObject jSONObject) {
        if (f21452a && jSONObject != null) {
            jSONObject.toString();
        }
    }

    public static boolean o(Context context, String str) {
        return context.getApplicationContext().checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean p(PackageManager packageManager, Intent intent) {
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, WXMediaMessage.THUMB_LENGTH_LIMIT);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean q(Map map, String str, Boolean bool) {
        return ((Boolean) d(map, Boolean.class, str, bool)).booleanValue();
    }

    public static String r() {
        List i10 = i(false);
        return i10.isEmpty() ? "" : (String) i10.get(0);
    }

    public static String s(Context context) {
        Uri uri = f21454c;
        if (uri != null && o(context, "com.google.android.providers.gsf.permission.READ_GSERVICES")) {
            Cursor query = context.getContentResolver().query(uri, null, null, new String[]{"android_id"}, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToFirst() && query.getColumnCount() >= 2) {
                    return Long.toHexString(Long.parseLong(query.getString(1)));
                }
                return null;
            } catch (NumberFormatException unused) {
            } finally {
                query.close();
            }
        }
        return null;
    }

    public static String t(Context context, String str) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb2.append(readLine);
            } else {
                bufferedReader.close();
                return new String(Base64.decode(sb2.toString(), 0), "UTF-8");
            }
        }
    }

    public static String u(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if ((charAt >= '0' && charAt <= '9') || ((charAt >= 'A' && charAt <= 'F') || (charAt >= 'a' && charAt <= 'f'))) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str.charAt(i11));
                int parseInt = Integer.parseInt(sb3.toString(), 16);
                i10 += parseInt;
                arrayList.add(Integer.valueOf(parseInt));
            }
        }
        int i12 = i10 + 1;
        int size = arrayList.size() % 4;
        for (int i13 = 0; i13 < arrayList.size() - size; i13 += 4) {
            sb2.append(Integer.toHexString((((Integer) arrayList.get((((Integer) arrayList.get(i13 + 3)).intValue() % 4) + i13)).intValue() + i12) % 16));
        }
        if (sb2.toString().length() == 0) {
            return null;
        }
        return sb2.toString().length() >= 4 ? sb2.toString().substring(0, 4) : sb2.toString();
    }

    public static String v(boolean z10) {
        return z10 ? UUID.randomUUID().toString() : UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static boolean w(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int i10 = 0;
        while (i10 < split.length && i10 < split2.length && split[i10].equals(split2[i10])) {
            i10++;
        }
        return Integer.valueOf(Integer.signum((i10 >= split.length || i10 >= split2.length) ? split.length - split2.length : Integer.valueOf(split[i10]).compareTo(Integer.valueOf(split2[i10])))).intValue() >= 0;
    }

    public static long x() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockSize() * statFs.getBlockCount();
        } catch (IllegalArgumentException e10) {
            e10.getLocalizedMessage();
            return 0L;
        }
    }

    public static String y(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RiskManagerAG", 0);
        String string = sharedPreferences.getString("RiskManagerAG", "");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (str == null || str.equals(string)) {
            if (!string.equals("")) {
                return string;
            }
            str = v(true);
        }
        edit.putString("RiskManagerAG", str);
        edit.commit();
        return str;
    }

    public static void z(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("RiskManagerCT", 0);
        int i10 = sharedPreferences.getInt("RiskManagerCT", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i11 = 1;
        if (i10 > 0 && i10 < Integer.MAX_VALUE) {
            i11 = 1 + i10;
        }
        edit.putInt("RiskManagerCT", i11);
        edit.commit();
    }
}
