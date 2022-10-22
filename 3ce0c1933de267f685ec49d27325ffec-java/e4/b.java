package e4;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import c4.a;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.lpa.LpaConstants;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.mobvoi.wear.permission.PermissionConstant;
import com.tendcloud.tenddata.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static b f25775a = new b();

    public static String A(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String B() {
        try {
            long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(currentTimeMillis - (currentTimeMillis % 1000));
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String C(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String D() {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SystemClock.elapsedRealtime());
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String E(Context context) {
        String str;
        WifiManager wifiManager;
        if (c(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            wifiManager = (WifiManager) context.getSystemService("wifi");
        } catch (Throwable unused) {
        }
        if (wifiManager.isWifiEnabled()) {
            str = wifiManager.getConnectionInfo().getBSSID();
            return str != null ? "" : str;
        }
        str = "";
        if (str != null) {
        }
    }

    public static String F() {
        try {
            StringBuilder sb2 = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb2.append("00:");
            for (int i10 = 0; i10 < 7; i10++) {
                sb2.append(new File(strArr[i10]).exists() ? "1" : "0");
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x001f -> B:12:0x001f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String G(Context context) {
        String str;
        int i10;
        int i11 = context.getApplicationInfo().targetSdkVersion;
        try {
            i10 = Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
        }
        if (i10 >= 29) {
            str = "";
            return str != null ? "" : str;
        }
        str = (i10 < 26 || i11 < 28) ? Build.SERIAL : Build.getSerial();
        if (str != null) {
        }
    }

    public static String H() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb2 = new StringBuilder();
        sb2.append("00");
        sb2.append(":");
        for (int i10 = 0; i10 <= 0; i10++) {
            try {
                Class.forName(strArr[0]);
                sb2.append("1");
            } catch (Throwable unused) {
                sb2.append("0");
            }
        }
        return sb2.toString();
    }

    public static String I(Context context) {
        try {
            String O = O(context);
            String S = S();
            if (a.g(O) && a.g(S)) {
                return O + ":" + S();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String J() {
        StringBuilder sb2 = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb2.append("00:");
        for (String str : linkedHashMap.keySet()) {
            LineNumberReader lineNumberReader = null;
            char c10 = '0';
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine != null) {
                            if (readLine.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                                c10 = '1';
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Throwable unused) {
                        lineNumberReader = lineNumberReader2;
                        sb2.append('0');
                        if (lineNumberReader != null) {
                            lineNumberReader.close();
                        }
                    }
                }
                sb2.append(c10);
                try {
                    lineNumberReader2.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        }
        return sb2.toString();
    }

    public static String K(Context context) {
        try {
            long j10 = 0;
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            for (int i10 = 0; i10 < 5; i10++) {
                long j11 = -1;
                try {
                    j11 = new File(strArr[i10]).lastModified();
                } catch (Throwable unused) {
                }
                j10 = Math.max(j11, j10);
            }
            return "1:" + j10;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String L() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str : linkedHashMap.keySet()) {
            char c10 = '0';
            try {
                String str2 = null;
                String str3 = (String) Build.class.getField(str).get(null);
                String str4 = (String) linkedHashMap.get(str);
                if (str3 != null) {
                    str2 = str3.toLowerCase();
                }
                if (str2 != null && str2.contains(str4)) {
                    c10 = '1';
                }
            } catch (Throwable unused) {
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String M(Context context) {
        boolean z10;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra(PermissionConstant.Columns.STATUS, -1);
            if (!(intExtra2 == 2 || intExtra2 == 5)) {
                z10 = false;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(!z10 ? "1" : "0");
                sb2.append(":");
                sb2.append(intExtra);
                return sb2.toString();
            }
            z10 = true;
            StringBuilder sb22 = new StringBuilder();
            sb22.append(!z10 ? "1" : "0");
            sb22.append(":");
            sb22.append(intExtra);
            return sb22.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String N() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("00:");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            char c10 = '0';
            String str2 = (String) linkedHashMap.get(str);
            String f10 = a.f(str, "");
            if (f10 != null && f10.contains(str2)) {
                c10 = '1';
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    public static String O(Context context) {
        if (c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            int subtype = activeNetworkInfo.getSubtype();
            return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String P() {
        try {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            if (list == null) {
                return "02:00:00:00:00:00";
            }
            for (NetworkInterface networkInterface : list) {
                if (!(networkInterface == null || networkInterface.getName() == null || !networkInterface.getName().equalsIgnoreCase("wlan0"))) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "02:00:00:00:00:00";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        sb2.append(String.format("%02X:", Integer.valueOf(hardwareAddress[i10] & 255)));
                    }
                    if (sb2.length() > 0) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Throwable unused) {
            return "02:00:00:00:00:00";
        }
    }

    public static String Q() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader(j.f22928a);
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (fileReader == null) {
                        return "";
                    }
                    try {
                        fileReader.close();
                        return "";
                    } catch (Throwable unused3) {
                        return "";
                    }
                }
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        if (!a.d(readLine)) {
            String trim = readLine.trim();
            try {
                bufferedReader.close();
            } catch (Throwable unused6) {
            }
            try {
                fileReader.close();
            } catch (Throwable unused7) {
            }
            return trim;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused8) {
        }
        fileReader.close();
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        r1 = r2[1].trim();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r0 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String R() {
        BufferedReader bufferedReader;
        String[] split;
        String str = "";
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (!a.d(readLine) && (split = readLine.split(":")) != null && split.length > 1 && split[0].contains("BogoMIPS")) {
                                break;
                            }
                        }
                    } catch (Throwable unused) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                try {
                    fileReader2.close();
                } catch (Throwable unused3) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                    return str;
                }
            } catch (Throwable unused5) {
                bufferedReader = null;
            }
        } catch (Throwable unused6) {
            bufferedReader = null;
        }
    }

    public static String S() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        TelephonyManager telephonyManager;
        String deviceId;
        if (c(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
                return deviceId != null ? "" : deviceId;
            }
        }
        deviceId = null;
        if (deviceId != null) {
        }
    }

    public static boolean c(Context context, String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    public static b d() {
        return f25775a;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context) {
        TelephonyManager telephonyManager;
        String subscriberId;
        if (c(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                subscriberId = telephonyManager.getSubscriberId();
                return subscriberId != null ? "" : subscriberId;
            }
        }
        subscriberId = "";
        if (subscriberId != null) {
        }
    }

    public static String f() {
        long j10;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j10 = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            j10 = 0;
        }
        return String.valueOf(j10);
    }

    public static String g(Context context) {
        int i10 = 0;
        try {
            i10 = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i10 == 1 ? "1" : "0";
    }

    public static String h() {
        long j10;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(a.a().getPath());
            j10 = statFs.getBlockSize() * statFs.getAvailableBlocks();
            return String.valueOf(j10);
        }
        j10 = 0;
        return String.valueOf(j10);
    }

    public static String i(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i10 = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i10));
            jSONObject.put("call", String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put("alarm", String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
        if (r2 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String j() {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        String str = "0000000000000000";
        LineNumberReader lineNumberReader = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/cpuinfo"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    LineNumberReader lineNumberReader2 = new LineNumberReader(inputStreamReader);
                    for (int i10 = 1; i10 < 100; i10++) {
                        try {
                            String readLine = lineNumberReader2.readLine();
                            if (readLine != null) {
                                if (readLine.indexOf("Serial") >= 0) {
                                    str = readLine.substring(readLine.indexOf(":") + 1, readLine.length()).trim();
                                    break;
                                }
                            }
                        } catch (Throwable unused) {
                            lineNumberReader = lineNumberReader2;
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                    }
                    try {
                        lineNumberReader2.close();
                    } catch (Throwable unused4) {
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused5) {
                    }
                } catch (Throwable unused6) {
                }
            } catch (Throwable unused7) {
                inputStreamReader = null;
            }
        } catch (Throwable unused8) {
            fileInputStream = null;
            inputStreamReader = null;
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused9) {
        }
        return str == null ? "" : str;
    }

    public static String k(Context context) {
        TelephonyManager telephonyManager;
        String networkOperatorName;
        if (context != null) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                networkOperatorName = telephonyManager.getNetworkOperatorName();
                return (networkOperatorName != null || LpaConstants.VALUE_NULL.equals(networkOperatorName)) ? "" : networkOperatorName;
            }
        }
        networkOperatorName = null;
        if (networkOperatorName != null) {
        }
    }

    public static String l() {
        String Q = Q();
        return !a.d(Q) ? Q : R();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m(Context context) {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        String j10;
        if (context != null) {
            try {
                sensorManager = (SensorManager) context.getSystemService("sensor");
            } catch (Throwable unused) {
            }
            if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0)) {
                StringBuilder sb2 = new StringBuilder();
                for (Sensor sensor : sensorList) {
                    sb2.append(sensor.getName());
                    sb2.append(sensor.getVersion());
                    sb2.append(sensor.getVendor());
                }
                j10 = a.j(sb2.toString());
                return j10 != null ? "" : j10;
            }
        }
        j10 = null;
        if (j10 != null) {
        }
    }

    public static String n() {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                String[] split = bufferedReader.readLine().split(":\\s+", 2);
                if (split == null || split.length <= 1) {
                    try {
                        fileReader2.close();
                    } catch (Throwable unused2) {
                        try {
                            bufferedReader.close();
                            return "";
                        } catch (Throwable unused3) {
                            return "";
                        }
                    }
                } else {
                    String str = split[1];
                    try {
                        fileReader2.close();
                    } catch (Throwable unused4) {
                    }
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused5) {
                    }
                    return str;
                }
            } catch (Throwable unused6) {
                fileReader = fileReader2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused7) {
                    }
                }
                if (bufferedReader == null) {
                    return "";
                }
                bufferedReader.close();
                return "";
            }
        } catch (Throwable unused8) {
            bufferedReader = null;
        }
    }

    public static String o(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (!(sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0)) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put(ContactConstant.CallsRecordKeys.NAME, sensor.getName());
                            jSONObject.put("version", sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
        if (r0 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String p() {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        long j10 = 0;
        try {
            FileReader fileReader2 = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j10 = Integer.parseInt(readLine.split("\\s+")[1]);
                }
                try {
                    fileReader2.close();
                } catch (Throwable unused2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused3) {
                    }
                    return String.valueOf(j10);
                }
            } catch (Throwable unused4) {
                fileReader = fileReader2;
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused5) {
                    }
                }
            }
        } catch (Throwable unused6) {
            bufferedReader = null;
        }
    }

    public static String q(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + MessageProxyConstants.NODE_ID_ANY + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String r() {
        long j10;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j10 = statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable unused) {
            j10 = 0;
        }
        return String.valueOf(j10);
    }

    public static String s(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(displayMetrics.widthPixels);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String t() {
        long j10;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            j10 = statFs.getBlockSize() * statFs.getBlockCount();
            return String.valueOf(j10);
        }
        j10 = 0;
        return String.valueOf(j10);
    }

    public static String u(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(displayMetrics.heightPixels);
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String v() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String w(Context context) {
        String str = "";
        if (c(context, "android.permission.ACCESS_WIFI_STATE")) {
            return str;
        }
        try {
            str = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            if (str == null || str.length() == 0 || "02:00:00:00:00:00".equals(str)) {
                return P();
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String x() {
        String str;
        try {
            str = Locale.getDefault().toString();
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public static String y(Context context) {
        if (c(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getSimSerialNumber();
            if (simSerialNumber == null) {
                return "";
            }
            try {
                if (simSerialNumber.length() == 0) {
                    return "";
                }
            } catch (Throwable unused) {
            }
            return simSerialNumber;
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String z() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public final String a() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new c(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }
}
