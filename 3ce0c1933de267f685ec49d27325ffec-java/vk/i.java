package vk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i {

    /* renamed from: e */
    private static Context f35817e;

    /* renamed from: a */
    String f35818a;

    /* renamed from: b */
    String f35819b;

    /* renamed from: c */
    String f35820c;

    /* renamed from: d */
    String f35821d;

    public i(Context context) {
        if (context != null) {
            j(context);
        }
    }

    private static String a(InputStream inputStream) {
        String next = new Scanner(inputStream, "UTF-8").useDelimiter("\\A").next();
        inputStream.close();
        return next;
    }

    public static String b(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (str.length() > 0) {
            sb2.append(str.substring(0, 1).toLowerCase());
            for (int i10 = 1; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                    charAt = Character.toLowerCase(charAt);
                }
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    public static h c(k kVar) {
        URL url;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        OutputStream outputStream;
        String str = kVar.f35822a;
        Object obj = kVar.f35823b;
        String str2 = kVar.f35824c;
        Map<String, String> map = kVar.f35825d;
        try {
            url = new URL(str);
        } catch (MalformedURLException e10) {
            c.a(e10);
            url = null;
        }
        if (url == null) {
            return null;
        }
        try {
            httpURLConnection = url.getProtocol().equals("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
        } catch (IOException e11) {
            c.a(e11);
            httpURLConnection = null;
        }
        if (httpURLConnection == null) {
            return null;
        }
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setUseCaches(false);
        for (Map.Entry<String, String> entry : l().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        if (map != null) {
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
            }
        }
        try {
            httpURLConnection.setRequestMethod(str2);
            if (str2.equals("POST")) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                String jSONObject = obj instanceof String ? (String) obj : obj instanceof Map ? new JSONObject((Map) obj).toString() : obj instanceof List ? new JSONArray((Collection) ((List) obj)).toString() : "{}";
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(jSONObject.getBytes("UTF-8"));
                        outputStream.close();
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    outputStream = null;
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            return new h(responseCode, a((responseCode < 200 || responseCode >= 300) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream()), httpURLConnection.getHeaderFields(), kVar.f35826e);
        } catch (IOException e12) {
            c.a(e12);
            return null;
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static i d() {
        i iVar;
        iVar = m.f35827a;
        return iVar;
    }

    public static i e(Context context) {
        i iVar;
        iVar = m.f35827a;
        if (f35817e == null) {
            Context applicationContext = context.getApplicationContext();
            f35817e = applicationContext;
            iVar.j(applicationContext);
        }
        return iVar;
    }

    public static String i(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e10) {
            c.a(e10);
            return null;
        } catch (NoSuchAlgorithmException e11) {
            c.a(e11);
            return null;
        }
    }

    private static Map<String, String> l() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bindings_version", "2.1.4");
        hashMap2.put("lang", "Java");
        hashMap2.put("os_version", Build.VERSION.RELEASE);
        hashMap2.put("model", Build.MODEL);
        hashMap.put("X-Pingpp-User-Agent", new JSONObject(hashMap2).toString());
        return hashMap;
    }

    public void f(String str, Object obj, Map<String, String> map) {
        g(str, obj, map, null);
    }

    public void g(String str, Object obj, Map<String, String> map, e eVar) {
        new l(this).execute(new k(this, str, obj, "POST", map, eVar));
    }

    public String h() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f35818a != null) {
            sb2.append("6_");
            sb2.append(this.f35818a);
        }
        if (this.f35819b != null) {
            if (sb2.length() > 0) {
                sb2.append("|");
            }
            sb2.append("7_");
            sb2.append(this.f35819b);
        }
        if (this.f35820c != null) {
            if (sb2.length() > 0) {
                sb2.append("|");
            }
            sb2.append("8_");
            sb2.append(this.f35820c);
        }
        if (this.f35821d != null) {
            if (sb2.length() > 0) {
                sb2.append("|");
            }
            sb2.append("9_");
            sb2.append(this.f35821d);
        }
        return sb2.toString();
    }

    public void j(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        try {
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null) {
                this.f35818a = UUID.nameUUIDFromBytes(deviceId.getBytes("UTF-8")).toString();
            }
        } catch (Exception e10) {
            c.b(e10.getMessage());
        }
        try {
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            if (simSerialNumber != null) {
                this.f35820c = UUID.nameUUIDFromBytes(simSerialNumber.getBytes("UTF-8")).toString();
            }
        } catch (Exception e11) {
            c.b(e11.getMessage());
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string != null && !"9774d56d682e549c".equals(string)) {
                this.f35819b = UUID.nameUUIDFromBytes(string.getBytes("UTF-8")).toString();
            }
        } catch (Exception e12) {
            c.b(e12.getMessage());
        }
        try {
            String str = Build.SERIAL;
            if (str != null) {
                this.f35821d = UUID.nameUUIDFromBytes(str.getBytes("UTF-8")).toString();
            }
        } catch (Exception e13) {
            c.b(e13.getMessage());
        }
    }
}
