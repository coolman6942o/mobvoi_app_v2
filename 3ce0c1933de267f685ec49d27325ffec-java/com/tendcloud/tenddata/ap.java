package com.tendcloud.tenddata;

import android.content.SharedPreferences;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* compiled from: td */
/* loaded from: classes2.dex */
final class ap {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22632a = "mPBE";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22633b = "_Ladder_Project";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22634c = "Pythagoras_phase";

    private ap() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : bArr) {
            sb2.append((int) b10);
            sb2.append(",");
        }
        a(ab.f22568h.getFilesDir() + File.separator + f22632a, str, sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2) {
        a(ab.f22568h.getFilesDir().getPath(), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(String str, String str2) {
        System.getProperties().setProperty(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
        if (r4 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
        if (r4 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String d(String str, String str2) {
        File file = new File(str);
        String str3 = "";
        if (!file.exists() && !file.isDirectory() && !file.mkdirs()) {
            return str3;
        }
        FileInputStream fileInputStream = null;
        try {
            File file2 = new File(file, str2);
            if (file2.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file2);
                try {
                    byte[] bArr = new byte[(int) file2.length()];
                    if (fileInputStream2.read(bArr) > 0) {
                        str3 = new String(bArr);
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                }
            } else if (!file2.createNewFile()) {
                return str3;
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        return System.getProperties().getProperty(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        return d(ab.f22568h.getFilesDir().getPath(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        a(ab.f22568h.getFilesDir() + File.separator + f22633b, str, str2);
    }

    private static void a(String str, String str2, String str3) {
        File file;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file = new File(str);
            } catch (Throwable unused) {
                return;
            }
        } catch (Throwable unused2) {
        }
        if (file.exists() || file.isDirectory() || file.mkdirs()) {
            File file2 = new File(file, str2);
            if (file2.exists() || file2.createNewFile()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(str3.getBytes());
                    fileOutputStream2.close();
                } catch (Throwable unused3) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(String str, int i10) {
        SharedPreferences sharedPreferences = ab.f22568h.getSharedPreferences(f22632a, 0);
        String string = sharedPreferences.getString(str, "");
        String str2 = ab.f22568h.getFilesDir() + File.separator + f22632a;
        String d10 = d(str2, str);
        if (!u.b(d10)) {
            return a(i10, d10);
        }
        if (u.b(string)) {
            return null;
        }
        a(str2, str, string);
        sharedPreferences.edit().putString(str, "").apply();
        return a(i10, string);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        SharedPreferences sharedPreferences = ab.f22568h.getSharedPreferences(f22634c, 0);
        String string = sharedPreferences.getString(str, "");
        String str2 = ab.f22568h.getFilesDir() + File.separator + f22633b;
        String d10 = d(str2, str);
        if (!u.b(d10) || u.b(string)) {
            return d10;
        }
        a(str2, str, string);
        sharedPreferences.edit().putString(str, "").apply();
        return string;
    }

    private static byte[] a(int i10, String str) {
        try {
            if (u.b(str)) {
                return null;
            }
            byte[] bArr = new byte[i10];
            String[] split = str.split(",");
            for (int i11 = 0; i11 < split.length; i11++) {
                bArr[i11] = Byte.parseByte(split[i11]);
            }
            return bArr;
        } catch (Throwable unused) {
            return null;
        }
    }
}
