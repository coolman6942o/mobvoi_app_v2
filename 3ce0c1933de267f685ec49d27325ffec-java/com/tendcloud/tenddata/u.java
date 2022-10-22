package com.tendcloud.tenddata;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f23005a = false;

    /* renamed from: b  reason: collision with root package name */
    public static String f23006b = "TDLog";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f23007c = false;

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f23008d = true;

    /* renamed from: e  reason: collision with root package name */
    private static volatile int f23009e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static final String f23010f = "UTF-8";

    /* renamed from: g  reason: collision with root package name */
    private static final String f23011g = "ge";

    /* renamed from: h  reason: collision with root package name */
    private static final String f23012h = "tp";

    /* renamed from: i  reason: collision with root package name */
    private static final String f23013i = "rop";

    /* renamed from: k  reason: collision with root package name */
    private static final byte f23015k = 61;

    /* renamed from: l  reason: collision with root package name */
    private static final String f23016l = "US-ASCII";

    /* renamed from: p  reason: collision with root package name */
    private static final String f23020p = "00:00:00:00:00:00";

    /* renamed from: q  reason: collision with root package name */
    private static final String f23021q = "02:00:00:00:00:00";

    /* renamed from: j  reason: collision with root package name */
    private static final ExecutorService f23014j = Executors.newSingleThreadExecutor();

    /* renamed from: m  reason: collision with root package name */
    private static final byte[] f23017m = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: n  reason: collision with root package name */
    private static byte[] f23018n = {1, 2, 3, 4, 5, 6, 7, 8};

    /* renamed from: o  reason: collision with root package name */
    private static final SecureRandom f23019o = new SecureRandom();

    /* renamed from: r  reason: collision with root package name */
    private static final Pattern f23022r = Pattern.compile("^([0-9A-F]{2}:){5}([0-9A-F]{2})$");

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
        if (r2 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
            try {
                byte[] bArr = new byte[inputStream.available()];
                if (inputStream.read(bArr) > 0) {
                    String string = new JSONObject(new String(bArr)).getString("td_channel_id");
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                    }
                    return string;
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            inputStream = null;
        }
        try {
            inputStream.close();
        } catch (Throwable unused4) {
            return null;
        }
    }

    public static boolean b(Context context) {
        return false;
    }

    public static final boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String c(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes(f23010f)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] d(String str) {
        try {
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i10 = 0; i10 < length; i10 += 2) {
                bArr[i10 / 2] = (byte) ((Character.digit(str.charAt(i10), 16) << 4) + Character.digit(str.charAt(i10 + 1), 16));
            }
            return bArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(MessageDigest.getInstance("SHA-256").digest(str.getBytes(f23010f)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void execute(Runnable runnable) {
        ExecutorService executorService = f23014j;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }

    public static byte[] f(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(9, true);
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            try {
                DeflaterOutputStream deflaterOutputStream2 = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                try {
                    deflaterOutputStream2.write(str.getBytes(f23010f));
                    deflaterOutputStream2.close();
                } catch (Throwable unused) {
                    deflaterOutputStream = deflaterOutputStream2;
                    if (deflaterOutputStream != null) {
                        deflaterOutputStream.close();
                    }
                    deflater.end();
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static Long g(String str) {
        long j10 = -1L;
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return j10;
        }
    }

    public static Integer h(String str) {
        int i10 = -1;
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return i10;
        }
    }

    public static boolean i(String str) {
        return !b(str) && n.f22975h.matcher(str).matches();
    }

    public static boolean j(String str) {
        try {
            if (b(str) || !f23022r.matcher(str).matches() || f23021q.equals(str)) {
                return true;
            }
            return f23020p.equals(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r3.checkCallingOrSelfPermission(r4) == 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str) {
        boolean z10 = false;
        try {
            z10 = true;
        } catch (Throwable unused) {
        }
        if (a(23)) {
            if (context.checkSelfPermission(str) == 0) {
            }
            return z10;
        }
        return z10;
    }

    public static boolean b(int i10) {
        return Build.VERSION.SDK_INT < i10;
    }

    public static String b(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length);
        } catch (Throwable th2) {
            if (f23008d) {
                str = null;
            } else {
                throw new AssertionError(th2.getMessage());
            }
        }
        if (f23008d || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
        if (r3.checkCallingOrSelfPermission(r4) == 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(Context context, String str) {
        boolean z10 = false;
        try {
            z10 = true;
        } catch (Throwable unused) {
        }
        if (a(23)) {
            if (context.checkSelfPermission(str) == 0) {
            }
            return z10;
        }
        return z10;
    }

    public static String d(Context context, String str) {
        try {
            return a(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData, str);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static FileChannel e(Context context, String str) {
        RandomAccessFile randomAccessFile;
        try {
            File file = new File(context.getFilesDir(), str + "td.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable unused) {
            randomAccessFile = null;
        }
        try {
            return randomAccessFile.getChannel();
        } catch (Throwable unused2) {
            if (randomAccessFile == null) {
                return null;
            }
            try {
                randomAccessFile.close();
                return null;
            } catch (Throwable unused3) {
                return null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (r1 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(byte[] bArr) {
        String str;
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = gZIPInputStream.read(bArr2, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    } catch (Throwable unused) {
                        str = null;
                    }
                }
                str = new String(byteArrayOutputStream2.toByteArray());
                try {
                    byteArrayOutputStream2.flush();
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            } catch (Throwable unused5) {
                str = null;
            }
        } catch (Throwable unused6) {
            gZIPInputStream = null;
            str = null;
        }
        try {
            gZIPInputStream.close();
        } catch (Throwable unused7) {
            return str;
        }
    }

    public static boolean a(Context context) {
        if (f23009e == -1) {
            try {
                String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).processName;
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (Process.myPid() == runningAppProcessInfo.pid && runningAppProcessInfo.processName.equals(str)) {
                            f23009e = 0;
                            return true;
                        }
                    }
                } else {
                    f23009e = 1;
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
            return false;
        } else if (f23009e == 0) {
            return true;
        } else {
            f23009e = -1;
            return false;
        }
    }

    public static byte[] b(byte[] bArr, int i10, int i11) {
        Objects.requireNonNull(bArr, "Cannot serialize a null array.");
        if (i10 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i10);
        } else if (i11 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i11);
        } else if (i10 + i11 <= bArr.length) {
            int i12 = 4;
            int i13 = (i11 / 3) * 4;
            if (i11 % 3 <= 0) {
                i12 = 0;
            }
            int i14 = i13 + i12;
            byte[] bArr2 = new byte[i14];
            int i15 = i11 - 2;
            int i16 = 0;
            int i17 = 0;
            while (i16 < i15) {
                a(bArr, i16 + i10, 3, bArr2, i17);
                i16 += 3;
                i17 += 4;
            }
            if (i16 < i11) {
                a(bArr, i10 + i16, i11 - i16, bArr2, i17);
                i17 += 4;
            }
            if (i17 > i14 - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i17];
            System.arraycopy(bArr2, 0, bArr3, 0, i17);
            return bArr3;
        } else {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(bArr.length)));
        }
    }

    public static byte[] d(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            byte[] bArr2 = new byte[1024];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Throwable unused) {
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable unused2) {
        }
        inflater.end();
        return bArr;
    }

    public static int c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo != null) {
                return applicationInfo.targetSdkVersion;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void a(Object obj, final q qVar, String str, String str2) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            final Object obj2 = declaredField.get(obj);
            Class<?> cls = Class.forName(str2);
            declaredField.set(obj, Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.tendcloud.tenddata.u.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj3, Method method, Object[] objArr) {
                    q.this.beforeMethodInvoke(obj3, method, objArr);
                    Object invoke = method.invoke(obj2, objArr);
                    q.this.afterMethodInvoked(obj3, method, objArr, invoke);
                    return invoke;
                }
            }));
        } catch (Throwable unused) {
        }
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, generateSecret, new IvParameterSpec(f23018n));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Class<?> cls, final q qVar, String str, String str2) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        final Object obj = declaredField.get(null);
        Class<?> cls2 = Class.forName(str2);
        declaredField.set(null, Proxy.newProxyInstance(cls.getClass().getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.tendcloud.tenddata.u.2
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) {
                q.this.beforeMethodInvoke(obj2, method, objArr);
                Object invoke = method.invoke(obj, objArr);
                q.this.afterMethodInvoked(obj2, method, objArr, invoke);
                return invoke;
            }
        }));
    }

    public static String b(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Throwable th2;
        ByteArrayInputStream byteArrayInputStream;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int read = byteArrayInputStream.read(bArr2);
                            if (read != -1) {
                                fileOutputStream.write(bArr2, 0, read);
                                messageDigest.update(bArr2, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        fileOutputStream.close();
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable unused2) {
                        }
                        return a(messageDigest.digest());
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    fileOutputStream = null;
                }
            } catch (Throwable th5) {
                th2 = th5;
                fileOutputStream = null;
                byteArrayInputStream = null;
            }
        } catch (Throwable unused5) {
            return null;
        }
    }

    public static final String a(String str) {
        if (str == null) {
            return null;
        }
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        TreeMap treeMap = new TreeMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                treeMap.put(next, jSONObject.get(next));
            }
        } catch (Throwable unused) {
        }
        return treeMap;
    }

    public static SecureRandom b() {
        return f23019o;
    }

    public static Map<String, Object> b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next));
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean a(int i10) {
        return Build.VERSION.SDK_INT >= i10;
    }

    public static boolean a(Context context, int i10) {
        try {
            return c(context) >= i10;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(byte[] bArr) {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : bArr) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    sb2.append('0');
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int b(Context context, int i10) {
        try {
            return (int) ((i10 * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static byte[] a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        try {
            byte[] bArr3 = f23017m;
            int i13 = 0;
            int i14 = (i11 > 0 ? (bArr[i10] << 24) >>> 8 : 0) | (i11 > 1 ? (bArr[i10 + 1] << 24) >>> 16 : 0);
            if (i11 > 2) {
                i13 = (bArr[i10 + 2] << 24) >>> 24;
            }
            int i15 = i14 | i13;
            if (i11 == 1) {
                bArr2[i12] = bArr3[i15 >>> 18];
                bArr2[i12 + 1] = bArr3[(i15 >>> 12) & 63];
                bArr2[i12 + 2] = f23015k;
                bArr2[i12 + 3] = f23015k;
                return bArr2;
            } else if (i11 == 2) {
                bArr2[i12] = bArr3[i15 >>> 18];
                bArr2[i12 + 1] = bArr3[(i15 >>> 12) & 63];
                bArr2[i12 + 2] = bArr3[(i15 >>> 6) & 63];
                bArr2[i12 + 3] = f23015k;
                return bArr2;
            } else if (i11 != 3) {
                return bArr2;
            } else {
                bArr2[i12] = bArr3[i15 >>> 18];
                bArr2[i12 + 1] = bArr3[(i15 >>> 12) & 63];
                bArr2[i12 + 2] = bArr3[(i15 >>> 6) & 63];
                bArr2[i12 + 3] = bArr3[i15 & 63];
                return bArr2;
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    public static String a(byte[] bArr, int i10, int i11) {
        byte[] b10 = b(bArr, i10, i11);
        try {
            return new String(b10, f23016l);
        } catch (Throwable unused) {
            return new String(b10);
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            for (String str2 : bundle.keySet()) {
                if (str2.equalsIgnoreCase(str)) {
                    return String.valueOf(bundle.get(str));
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, generateSecret, new IvParameterSpec(f23018n));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
        throw new java.lang.RuntimeException("Input stream more than 100 MB size limit");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream(), f23010f));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb2.append(readLine);
                    sb2.append("\n");
                    if (sb2.length() > 104857600) {
                        break;
                    }
                } catch (Throwable unused2) {
                }
            }
            String sb3 = sb2.toString();
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
            return sb3;
        } catch (Throwable unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused5) {
                }
            }
            return null;
        }
    }

    public static void a(File file, byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr2 = new byte[4096];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read != -1) {
                    fileOutputStream.write(bArr2, 0, read);
                } else {
                    fileOutputStream.close();
                    byteArrayInputStream.close();
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
