package com.paypal.android.sdk;

import android.os.Build;
import java.io.File;
/* loaded from: classes2.dex */
public final class y {
    static {
        new r();
    }

    public static boolean a() {
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || b() || c();
    }

    private static boolean b() {
        try {
            return new File(r.a("suFileName")).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean c() {
        try {
            return new File(r.a("superUserApk")).exists();
        } catch (Exception unused) {
            return false;
        }
    }
}
