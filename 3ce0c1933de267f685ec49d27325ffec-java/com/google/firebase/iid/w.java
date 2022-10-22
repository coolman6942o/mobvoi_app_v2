package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.b;
import c8.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;
import s6.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w {
    private static x a(SharedPreferences sharedPreferences, String str) throws y {
        String string = sharedPreferences.getString(m.g(str, "|P|"), null);
        String string2 = sharedPreferences.getString(m.g(str, "|K|"), null);
        if (string == null || string2 == null) {
            return null;
        }
        return new x(l(string, string2), g(sharedPreferences, str));
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Throwable, com.google.firebase.iid.x] */
    private static x b(File file) throws y, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String property = properties.getProperty("pub");
            String property2 = properties.getProperty("pri");
            th = 0;
            if (!(property == null || property2 == null)) {
                try {
                    return new x(l(property, property2), Long.parseLong(properties.getProperty("cre")));
                } catch (NumberFormatException e10) {
                    throw new y(e10);
                }
            }
            return th;
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Context context) {
        File[] listFiles;
        for (File file : i(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    private static void d(Context context, String str, x xVar) {
        String e10;
        String f10;
        long j10;
        try {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Writing key to properties file");
            }
            File o10 = o(context, str);
            o10.createNewFile();
            Properties properties = new Properties();
            e10 = xVar.e();
            properties.setProperty("pub", e10);
            f10 = xVar.f();
            properties.setProperty("pri", f10);
            j10 = xVar.f12527b;
            properties.setProperty("cre", String.valueOf(j10));
            FileOutputStream fileOutputStream = new FileOutputStream(o10);
            properties.store(fileOutputStream, (String) null);
            f(null, fileOutputStream);
        } catch (IOException e11) {
            String valueOf = String.valueOf(e11);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 21);
            sb2.append("Failed to write key: ");
            sb2.append(valueOf);
            Log.w("FirebaseInstanceId", sb2.toString());
        }
    }

    private static /* synthetic */ void e(Throwable th2, FileInputStream fileInputStream) {
        if (th2 != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
                g.b(th2, th3);
            }
        } else {
            fileInputStream.close();
        }
    }

    private static /* synthetic */ void f(Throwable th2, FileOutputStream fileOutputStream) {
        if (th2 != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th3) {
                g.b(th2, th3);
            }
        } else {
            fileOutputStream.close();
        }
    }

    private static long g(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(m.g(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private static File i(Context context) {
        File h10 = b.h(context);
        if (h10 != null && h10.isDirectory()) {
            return h10;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private final void j(Context context, String str, x xVar) {
        String e10;
        String f10;
        long j10;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (xVar.equals(a(sharedPreferences, str))) {
                return;
            }
        } catch (y unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String g10 = m.g(str, "|P|");
        e10 = xVar.e();
        edit.putString(g10, e10);
        String g11 = m.g(str, "|K|");
        f10 = xVar.f();
        edit.putString(g11, f10);
        String g12 = m.g(str, "cre");
        j10 = xVar.f12527b;
        edit.putString(g12, String.valueOf(j10));
        edit.commit();
    }

    private static KeyPair l(String str, String str2) throws y {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(decode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e10) {
                String valueOf = String.valueOf(e10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 19);
                sb2.append("Invalid key stored ");
                sb2.append(valueOf);
                Log.w("FirebaseInstanceId", sb2.toString());
                throw new y(e10);
            }
        } catch (IllegalArgumentException e11) {
            throw new y(e11);
        }
    }

    private final x m(Context context, String str) throws y {
        y e10;
        x n10;
        try {
            n10 = n(context, str);
        } catch (y e11) {
            e10 = e11;
        }
        if (n10 != null) {
            j(context, str, n10);
            return n10;
        }
        e10 = null;
        try {
            x a10 = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
            if (a10 != null) {
                d(context, str, a10);
                return a10;
            }
        } catch (y e12) {
            e10 = e12;
        }
        if (e10 == null) {
            return null;
        }
        throw e10;
    }

    private final x n(Context context, String str) throws y {
        File o10 = o(context, str);
        if (!o10.exists()) {
            return null;
        }
        try {
            return b(o10);
        } catch (IOException e10) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e10);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 40);
                sb2.append("Failed to read key from file, retrying: ");
                sb2.append(valueOf);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
            try {
                return b(o10);
            } catch (IOException e11) {
                String valueOf2 = String.valueOf(e11);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 45);
                sb3.append("IID file exists, but failed to read from it: ");
                sb3.append(valueOf2);
                Log.w("FirebaseInstanceId", sb3.toString());
                throw new y(e11);
            }
        }
    }

    private static File o(Context context, String str) {
        String sb2;
        if (TextUtils.isEmpty(str)) {
            sb2 = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                StringBuilder sb3 = new StringBuilder(String.valueOf(encodeToString).length() + 33);
                sb3.append("com.google.InstanceId_");
                sb3.append(encodeToString);
                sb3.append(".properties");
                sb2 = sb3.toString();
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
        return new File(i(context), sb2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final x h(Context context, String str) throws y {
        x m10 = m(context, str);
        return m10 != null ? m10 : k(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final x k(Context context, String str) {
        x xVar = new x(a.a(), System.currentTimeMillis());
        try {
            x m10 = m(context, str);
            if (m10 != null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
                }
                return m10;
            }
        } catch (y unused) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        d(context, str, xVar);
        j(context, str, xVar);
        return xVar;
    }
}
