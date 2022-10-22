package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.io.File;
import java.io.FileInputStream;
import k4.d;
/* compiled from: AppInfo.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f6961a = "";

    public static String a(Context context) {
        try {
            return c(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return f6961a;
        }
    }

    private static String b(Context context) {
        Throwable th2;
        File file = new File(h.c(context, "k.store"));
        String str = "";
        if (!file.exists()) {
            return str;
        }
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String d10 = g.d(bArr);
                if (d10.length() == 32) {
                    str = d10;
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return str;
            } catch (Throwable th4) {
                th2 = th4;
                try {
                    d.b(th2, "AppInfo", "getKeyFromFile");
                    if (file.exists()) {
                        file.delete();
                    }
                    return str;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th2 = th6;
        }
    }

    private static String c(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f6961a;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return f6961a;
            }
            String string = bundle.getString("com.amap.api.v2.apikey");
            f6961a = string;
            if (string == null) {
                f6961a = b(context);
            }
        }
        return f6961a;
    }
}
