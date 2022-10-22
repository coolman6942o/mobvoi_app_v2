package com.tendcloud.tenddata;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Environment;
import android.preference.PreferenceManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;
import java.util.regex.Pattern;
/* compiled from: td */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22920a = "pref.deviceid.key";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22923d = ".tcookieid";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22924e = ".tlocalcookieid";

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f22925f;

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f22921b = Pattern.compile("[0-4][0-9a-f]{24,32}");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f22922c = Pattern.compile("[0-4][0-9a-f]{32}");

    /* renamed from: g  reason: collision with root package name */
    private static String f22926g = "TD_Custom_Dev_Id";

    /* renamed from: h  reason: collision with root package name */
    private static String f22927h = null;

    public static synchronized String a(Context context) {
        String str;
        synchronized (i.class) {
            if (f22925f == null) {
                f22925f = d(context);
            }
            str = f22925f;
        }
        return str;
    }

    static String b(Context context) {
        try {
            String b10 = o.b(context, "tdid", f22920a, (String) null);
            return u.b(b10) ? PreferenceManager.getDefaultSharedPreferences(context).getString(f22920a, null) : b10;
        } catch (Throwable unused) {
            return "";
        }
    }

    static String c(Context context) {
        if (f22927h == null) {
            try {
                Sensor[] sensorArr = new Sensor[64];
                for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
                    if (sensor.getType() < 64 && sensor.getType() >= 0) {
                        sensorArr[sensor.getType()] = sensor;
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int i10 = 0; i10 < 64; i10++) {
                    if (sensorArr[i10] != null) {
                        stringBuffer.append(i10);
                        stringBuffer.append('.');
                        stringBuffer.append(sensorArr[i10].getVendor());
                        stringBuffer.append('-');
                        stringBuffer.append(sensorArr[i10].getName());
                        stringBuffer.append('-');
                        stringBuffer.append(sensorArr[i10].getVersion());
                        stringBuffer.append('\n');
                    }
                }
                f22927h = String.valueOf(stringBuffer.toString().hashCode());
            } catch (Throwable unused) {
            }
        }
        return f22927h;
    }

    private static String d(Context context) {
        String str;
        String b10 = b(context);
        boolean a10 = a();
        String a11 = a(context, a10, f22924e);
        if (!u.b(b10) && f22922c.matcher(b10).matches()) {
            str = b10;
        } else if (u.b(a11) || !f22922c.matcher(a11).matches()) {
            int i10 = 0;
            String[] strArr = {a(f22923d), a(context, a10, f22923d)};
            while (true) {
                if (i10 >= 2) {
                    str = null;
                    break;
                }
                str = strArr[i10];
                if (!u.b(str) && f22922c.matcher(str).matches()) {
                    break;
                }
                i10++;
            }
        } else {
            str = a11;
        }
        if (u.b(str)) {
            if (u.a(29)) {
                str = b();
            } else {
                str = e(context);
            }
        }
        if (!str.equals(b10)) {
            b(context, str);
        }
        if (u.b(a11)) {
            a(context, str, a10);
        }
        return str;
    }

    private static String e(Context context) {
        String f10 = f(context);
        return Constant.APPLY_MODE_DECIDED_BY_BANK + u.c(f10);
    }

    private static String f(Context context) {
        try {
            return k.f(context) + '-' + k.a(com.unionpay.tsmservice.mi.data.Constant.KEY_MAC) + '-' + k.a("androidId");
        } catch (Throwable unused) {
            return "";
        }
    }

    static String a(Context context, boolean z10, String str) {
        if (u.a(23) && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return null;
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return "";
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (!z10) {
            str = str + c(context);
        }
        String a10 = a(new File(externalStorageDirectory, str));
        if (!u.b(a10)) {
            return a10;
        }
        return a(new File(Environment.getExternalStorageDirectory(), ".tid" + c(context)));
    }

    private static void b(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("tdid", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(f22920a, str);
                edit.apply();
            }
        } catch (Throwable unused) {
        }
    }

    private static String b() {
        String a10 = k.a(com.unionpay.tsmservice.mi.data.Constant.KEY_MAC);
        if (u.b(a10)) {
            a10 = k.a("androidId");
        }
        if (u.b(a10)) {
            a10 = UUID.randomUUID().toString();
        }
        return "4" + u.c(3 + a10);
    }

    static String a(String str) {
        File[] listFiles;
        String str2 = null;
        try {
            File[] listFiles2 = new File("/").listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                for (File file : listFiles2) {
                    if (file.isDirectory() && !"/sdcard".equals(file.getAbsolutePath())) {
                        if (file.canWrite()) {
                            str2 = a(new File(file, str));
                            if (!u.b(str2)) {
                                return str2;
                            }
                        }
                        if (file.listFiles() != null) {
                            for (File file2 : file.listFiles()) {
                                if (file2.isDirectory()) {
                                    str2 = a(new File(file2, str));
                                    if (!u.b(str2)) {
                                        return str2;
                                    }
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    private static String a(File file) {
        FileInputStream fileInputStream;
        try {
            if (file.exists() && file.canRead()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[128];
                        String str = new String(bArr, 0, fileInputStream.read(bArr));
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return str;
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    private static void a(Context context, String str, boolean z10) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String str2 = f22924e;
            if (!z10) {
                str2 = str2 + c(context);
            }
            a(new File(externalStorageDirectory, str2), str);
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, String str) {
        File[] listFiles;
        try {
            File[] listFiles2 = new File("/").listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                for (File file : listFiles2) {
                    if (file.isDirectory() && !"/sdcard".equals(file.getAbsolutePath())) {
                        if (file.canWrite()) {
                            if (!new File(file, f22923d + c(context)).exists()) {
                                a(new File(file, f22923d), str);
                            }
                        }
                        if (file.listFiles() != null) {
                            for (File file2 : file.listFiles()) {
                                if (file2.isDirectory() && file2.canWrite()) {
                                    if (!new File(file2, f22923d + c(context)).exists()) {
                                        a(new File(file2, f22923d), str);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(File file, String str) {
        FileOutputStream fileOutputStream = null;
        if (file.exists() || !u.b(ab.f22568h, "android.permission.WRITE_EXTERNAL_STORAGE") || ((u.a(ab.f22568h, 29) && u.a(29)) || file.createNewFile())) {
            if (file.canWrite()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str.getBytes());
                    if (u.a(9)) {
                        Class<?> cls = file.getClass();
                        Class<?> cls2 = Boolean.TYPE;
                        cls.getMethod("setReadable", cls2, cls2).invoke(file, Boolean.TRUE, Boolean.FALSE);
                    } else {
                        Runtime runtime = Runtime.getRuntime();
                        runtime.exec("chmod 444 " + file.getAbsolutePath());
                    }
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream == null) {
                        return;
                    }
                    fileOutputStream.close();
                }
            }
            if (fileOutputStream == null) {
                return;
            }
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
            }
        }
    }

    static boolean a() {
        boolean z10;
        if (u.a(9)) {
            z10 = Environment.isExternalStorageRemovable();
            return !z10;
        }
        z10 = true;
        return !z10;
    }
}
