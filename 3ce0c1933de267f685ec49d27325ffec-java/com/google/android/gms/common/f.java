package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import b6.i;
import j6.c;
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static f f8835b;

    /* renamed from: a  reason: collision with root package name */
    private final Context f8836a;

    private f(Context context) {
        this.f8836a = context.getApplicationContext();
    }

    public static f a(Context context) {
        i.k(context);
        synchronized (f.class) {
            if (f8835b == null) {
                h.c(context);
                f8835b = new f(context);
            }
        }
        return f8835b;
    }

    private static j d(PackageInfo packageInfo, j... jVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        k kVar = new k(packageInfo.signatures[0].toByteArray());
        for (int i10 = 0; i10 < jVarArr.length; i10++) {
            if (jVarArr[i10].equals(kVar)) {
                return jVarArr[i10];
            }
        }
        return null;
    }

    private final q e(String str, int i10) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo g10 = c.a(this.f8836a).g(str, 64, i10);
            boolean f10 = e.f(this.f8836a);
            if (g10 == null) {
                return q.d("null pkg");
            }
            if (g10.signatures.length != 1) {
                return q.d("single cert required");
            }
            k kVar = new k(g10.signatures[0].toByteArray());
            String str2 = g10.packageName;
            q a10 = h.a(str2, kVar, f10, false);
            return (!a10.f8978a || (applicationInfo = g10.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !h.a(str2, kVar, false, true).f8978a) ? a10 : q.d("debuggable release cert app rejected");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return q.d(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static boolean f(PackageInfo packageInfo, boolean z10) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if ((z10 ? d(packageInfo, m.f8976a) : d(packageInfo, m.f8976a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (f(packageInfo, false)) {
            return true;
        }
        if (f(packageInfo, true)) {
            if (e.f(this.f8836a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i10) {
        q qVar;
        String[] e10 = c.a(this.f8836a).e(i10);
        if (e10 == null || e10.length == 0) {
            qVar = q.d("no pkgs");
        } else {
            qVar = null;
            for (String str : e10) {
                qVar = e(str, i10);
                if (qVar.f8978a) {
                    break;
                }
            }
        }
        qVar.g();
        return qVar.f8978a;
    }
}
