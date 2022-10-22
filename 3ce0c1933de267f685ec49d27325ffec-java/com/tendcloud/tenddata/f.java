package com.tendcloud.tenddata;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.io.File;
/* compiled from: td */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f22891a;

    /* renamed from: b  reason: collision with root package name */
    private PackageInfo f22892b = null;

    private f() {
    }

    public static f a() {
        if (f22891a == null) {
            synchronized (f.class) {
                if (f22891a == null) {
                    f22891a = new f();
                }
            }
        }
        return f22891a;
    }

    private synchronized boolean i(Context context) {
        try {
            if (this.f22892b == null) {
                this.f22892b = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            }
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    public int b(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            if (!i(context)) {
                return -1;
            }
            return this.f22892b.versionCode;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public String c(Context context) {
        if (context == null) {
            return "unknown";
        }
        try {
            if (!i(context)) {
                return "unknown";
            }
            return this.f22892b.versionName;
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public long d(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            if (i(context) && u.a(9)) {
                return this.f22892b.firstInstallTime;
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public long e(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            if (i(context) && u.a(9)) {
                return this.f22892b.lastUpdateTime;
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public long f(Context context) {
        if (context == null) {
            return -1L;
        }
        try {
            return new File(context.getApplicationInfo().sourceDir).length();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public String g(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!i(context)) {
                return null;
            }
            Signature[] signatureArr = this.f22892b.signatures;
            if (signatureArr.length < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(signatureArr[0].toCharsString());
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String h(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }
}
