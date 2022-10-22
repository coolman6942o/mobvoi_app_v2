package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.mobvoi.wear.permission.PermissionConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
/*  JADX ERROR: NullPointerException in pass: ProcessKotlinInternals
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.kotlin.ProcessKotlinInternals.processMth(ProcessKotlinInternals.java:92)
    	at jadx.core.dex.visitors.kotlin.ProcessKotlinInternals.visit(ProcessKotlinInternals.java:83)
    */
/* compiled from: td */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22928a = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";

    /* renamed from: b  reason: collision with root package name */
    public static final String f22929b = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq";

    /* renamed from: c  reason: collision with root package name */
    public static final String f22930c = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";

    /* renamed from: d  reason: collision with root package name */
    private static final int f22931d = 3600000;

    /* renamed from: i  reason: collision with root package name */
    private static int[] f22936i;

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f22932e = Pattern.compile("([0-9]+)");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f22933f = Pattern.compile("\\s*([0-9]+)");

    /* renamed from: g  reason: collision with root package name */
    private static List<PackageInfo> f22934g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private static boolean f22935h = false;

    /* renamed from: j  reason: collision with root package name */
    private static final FileFilter f22937j = new FileFilter() { // from class: com.tendcloud.tenddata.j.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file != null) {
                try {
                    String name = file.getName();
                    if (name != null && name.startsWith("cpu")) {
                        for (int i10 = 3; i10 < name.length(); i10++) {
                            if (name.charAt(i10) < '0' || name.charAt(i10) > '9') {
                                return false;
                            }
                        }
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private static BroadcastReceiver f22938k = new BroadcastReceiver() { // from class: com.tendcloud.tenddata.j.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    };

    public static String a() {
        return ab.f22571k + Build.VERSION.RELEASE;
    }

    public static boolean b() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
            if (invoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(invoke.toString());
        } catch (Throwable th2) {
            g.iForInternal("SA.HasHarmonyOS", th2.getMessage());
            return false;
        }
    }

    public static String c() {
        try {
            return Build.ID;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d() {
        return Build.MANUFACTURER.trim();
    }

    public static String e() {
        return Build.BRAND.trim();
    }

    public static String f() {
        return Build.MODEL.trim();
    }

    public static int g() {
        return TimeZone.getDefault().getRawOffset() / f22931d;
    }

    public static String h() {
        try {
            String trim = Build.MODEL.trim();
            String a10 = a(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(a10)) {
                a10 = a(Build.BRAND.trim(), trim);
            }
            if (a10 == null) {
                a10 = "";
            }
            return a10 + ":" + trim;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i() {
        try {
            if (u.a(14)) {
                return Build.getRadioVersion();
            }
            return "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static int j() {
        return Build.VERSION.SDK_INT;
    }

    public static String k() {
        return Build.VERSION.RELEASE;
    }

    public static String l() {
        return Locale.getDefault().getLanguage();
    }

    public static String m() {
        return Locale.getDefault().getCountry();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
        throw new java.lang.RuntimeException("List size more than 104857600 limit");
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[Catch: all -> 0x0091, TryCatch #1 {all -> 0x0091, blocks: (B:6:0x0013, B:15:0x003c, B:17:0x0044, B:19:0x004b, B:21:0x0058, B:23:0x005f, B:25:0x0068, B:27:0x0078, B:28:0x0082, B:29:0x0085, B:30:0x0088), top: B:36:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String[] n() {
        boolean z10;
        String[] strArr = new String[4];
        for (int i10 = 0; i10 < 4; i10++) {
            strArr[i10] = "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                bufferedReader.close();
                                fileReader.close();
                            } catch (IOException unused) {
                            }
                            z10 = true;
                            break;
                        }
                        arrayList.add(readLine);
                        if (arrayList.size() > 104857600) {
                            break;
                        }
                    } catch (IOException unused2) {
                        z10 = false;
                        String[] strArr2 = {"Processor\\s*:\\s*(.*)", "CPU\\s*variant\\s*:\\s*0x(.*)", "Hardware\\s*:\\s*(.*)"};
                        if (z10) {
                        }
                        strArr[3] = c(f22928a);
                        return strArr;
                    }
                } catch (Throwable unused3) {
                    bufferedReader.close();
                    fileReader.close();
                    z10 = false;
                    String[] strArr22 = {"Processor\\s*:\\s*(.*)", "CPU\\s*variant\\s*:\\s*0x(.*)", "Hardware\\s*:\\s*(.*)"};
                    if (z10) {
                    }
                    strArr[3] = c(f22928a);
                    return strArr;
                }
            }
            String[] strArr222 = {"Processor\\s*:\\s*(.*)", "CPU\\s*variant\\s*:\\s*0x(.*)", "Hardware\\s*:\\s*(.*)"};
            if (z10) {
                int size = arrayList.size();
                for (int i11 = 0; i11 < 3; i11++) {
                    Pattern compile = Pattern.compile(strArr222[i11]);
                    for (int i12 = 0; i12 < size; i12++) {
                        Matcher matcher = compile.matcher((String) arrayList.get(i12));
                        if (matcher.find()) {
                            strArr[i11] = matcher.toMatchResult().group(1);
                        }
                    }
                }
            }
            strArr[3] = c(f22928a);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
        return strArr;
    }

    public static JSONObject o() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ContactConstant.CallsRecordKeys.NAME, n()[2]);
            jSONObject.put("coreNum", p());
            jSONObject.put("maxFreq", a(f22928a));
            jSONObject.put("minFreq", a(f22929b));
            jSONObject.put("curFreq", a(f22930c));
            return jSONObject;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    public static int p() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(f22937j);
            if (listFiles != null) {
                return listFiles.length;
            }
            return 1;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static int[] q() {
        int[] iArr = {0, 0};
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                int blockSize = statFs.getBlockSize();
                int blockCount = statFs.getBlockCount();
                int availableBlocks = statFs.getAvailableBlocks();
                iArr[0] = (blockCount * (blockSize / 512)) / 2;
                iArr[1] = (availableBlocks * (blockSize / 512)) / 2;
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public static int[] r() {
        int[] iArr = {0, 0};
        int[] iArr2 = new int[4];
        for (int i10 = 0; i10 < 4; i10++) {
            iArr2[i10] = 0;
        }
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            for (int i11 = 0; i11 < 4; i11++) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine.length() <= 104857600) {
                            iArr2[i11] = b(readLine);
                        } else {
                            throw new RuntimeException("Input stream more than 100 MB size limit");
                        }
                    } catch (IOException unused) {
                        bufferedReader.close();
                    }
                } catch (IOException unused2) {
                }
            }
            iArr[0] = iArr2[0];
            iArr[1] = iArr2[1] + iArr2[2] + iArr2[3];
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
        return iArr;
    }

    public static int[] s() {
        int[] iArr = new int[4];
        int[] iArr2 = f22936i;
        if (iArr2 == null || iArr2.length <= 0) {
            f22936i = a(iArr);
        }
        return f22936i;
    }

    public static int t() {
        try {
            Matcher matcher = f22933f.matcher(c("/sys/class/power_supply/battery/full_bat"));
            if (matcher.find()) {
                return Integer.parseInt(matcher.toMatchResult().group(0));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean a(Context context) {
        try {
            if (u.a(17)) {
                return Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            try {
                context = ab.f22568h;
                if (context == null) {
                    return 0;
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
                return 0;
            }
        }
        Intent registerReceiver = context.registerReceiver(f22938k, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i10 = registerReceiver != null ? registerReceiver.getExtras().getInt("level", 0) : 0;
        context.unregisterReceiver(f22938k);
        return i10;
    }

    public static int d(Context context) {
        int i10;
        if (context == null) {
            try {
                context = ab.f22568h;
                if (context == null) {
                    return 0;
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
                return 0;
            }
        }
        Intent registerReceiver = context.registerReceiver(f22938k, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            i10 = registerReceiver.getIntExtra(PermissionConstant.Columns.STATUS, 0);
        } else {
            i10 = 0;
        }
        context.unregisterReceiver(f22938k);
        return i10;
    }

    public static int e(Context context) {
        if (context == null) {
            try {
                context = ab.f22568h;
                if (context == null) {
                    return -1;
                }
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return -1;
    }

    public static int f(Context context) {
        if (context == null) {
            try {
                context = ab.f22568h;
                if (context == null) {
                    return -1;
                }
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return -1;
    }

    public static int g(Context context) {
        if (context == null) {
            try {
                context = ab.f22568h;
                if (context == null) {
                    return -1;
                }
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.densityDpi;
        }
        return -1;
    }

    private static String a(String str, String str2) {
        try {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("unknown") && !lowerCase.startsWith("alps") && !lowerCase.startsWith("android") && !lowerCase.startsWith("sprd") && !lowerCase.startsWith("spreadtrum") && !lowerCase.startsWith("rockchip") && !lowerCase.startsWith("wondermedia") && !lowerCase.startsWith("mtk") && !lowerCase.startsWith("mt65") && !lowerCase.startsWith("nvidia") && !lowerCase.startsWith("brcm") && !lowerCase.startsWith("marvell")) {
                if (!str2.toLowerCase().contains(lowerCase)) {
                    return str;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static JSONObject b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("brightness", h(context));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static String b(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                return "";
            }
            int i10 = displayMetrics.widthPixels;
            int i11 = displayMetrics.heightPixels;
            return Math.min(i10, i11) + MessageProxyConstants.NODE_ID_ANY + Math.max(i10, i11) + MessageProxyConstants.NODE_ID_ANY + displayMetrics.densityDpi;
        } catch (Throwable unused) {
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: AttachTryCatchVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Null type added to not empty exception handler: IOException -> 0x002a
        	at jadx.core.dex.trycatch.ExceptionHandler.addCatchType(ExceptionHandler.java:54)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.createHandler(AttachTryCatchVisitor.java:136)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.convertToHandlers(AttachTryCatchVisitor.java:123)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.initTryCatches(AttachTryCatchVisitor.java:59)
        	at jadx.core.dex.visitors.AttachTryCatchVisitor.visit(AttachTryCatchVisitor.java:47)
        */
    private static java.lang.String c(java.lang.String r7) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.io.IOException -> L2a
            r1.<init>(r7)     // Catch: java.io.IOException -> L2a
            r7 = 1024(0x400, float:1.435E-42)
            char[] r2 = new char[r7]
            java.io.BufferedReader r3 = new java.io.BufferedReader
            r3.<init>(r1, r7)
            r4 = -1
            r5 = 0
            r3.read(r2, r5, r7)
            r6 = move-result
            if (r4 == r6) goto L24
            java.lang.String r4 = new java.lang.String
            r4.<init>(r2, r5, r6)
            r0.append(r4)
            goto L13
            r3.close()
            r1.close()
        L2a:
            r0.toString()
            r7 = move-result
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.j.c(java.lang.String):java.lang.String");
    }

    public static int h(Context context) {
        if (context == null && (context = ab.f22568h) == null) {
            return -1;
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static int b(String str) {
        try {
            String str2 = "";
            Matcher matcher = f22932e.matcher(str);
            if (matcher.find()) {
                str2 = matcher.toMatchResult().group(0);
            }
            return Integer.parseInt(str2);
        } catch (Exception e10) {
            bf.postSDKError(e10);
            return 0;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                int i10 = displayMetrics.widthPixels;
                int i11 = displayMetrics.heightPixels;
                jSONObject.put("pixel", Math.min(i10, i11) + MessageProxyConstants.NODE_ID_ANY + Math.max(i10, i11) + MessageProxyConstants.NODE_ID_ANY + displayMetrics.densityDpi);
                jSONObject.put("densityDpi", displayMetrics.densityDpi);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (r5 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String readLine;
        int i10 = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(str);
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable unused) {
                bufferedReader = null;
            }
            try {
                readLine = bufferedReader.readLine();
            } catch (Throwable unused2) {
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Throwable unused3) {
                    }
                }
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
        if (readLine.length() <= 104857600) {
            i10 = Integer.parseInt(readLine.trim());
            try {
                fileReader.close();
            } catch (Throwable unused5) {
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused6) {
                return i10;
            }
        } else {
            throw new RuntimeException("Input stream more than 100 MB size limit");
        }
    }

    private static int[] a(int[] iArr) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            iArr[0] = (statFs.getBlockCount() * (statFs.getBlockSize() / 512)) / 2;
            iArr[1] = (statFs.getAvailableBlocks() * (statFs.getBlockSize() / 512)) / 2;
        } catch (Throwable unused) {
        }
        try {
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            iArr[2] = (statFs2.getBlockCount() * (statFs2.getBlockSize() / 512)) / 2;
            iArr[3] = (statFs2.getAvailableBlocks() * (statFs2.getBlockSize() / 512)) / 2;
        } catch (Throwable unused2) {
        }
        return iArr;
    }
}
