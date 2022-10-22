package com.google.android.gms.internal.measurement;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import b6.i;
import com.google.android.gms.common.util.a;
import j6.c;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class a0 extends y2 {

    /* renamed from: b  reason: collision with root package name */
    private c0 f9149b = b0.f9172a;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f9150c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(d2 d2Var) {
        super(d2Var);
    }

    public static long K() {
        return p0.F.a().longValue();
    }

    public static long L() {
        return p0.f9564f.a().longValue();
    }

    public static boolean N() {
        return p0.f9560b.a().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean A(String str) {
        return H(str, p0.Q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean B(String str) {
        return H(str, p0.R);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean C(String str) {
        return H(str, p0.S);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean D(String str) {
        return H(str, p0.T);
    }

    public final int E(String str, q0<Integer> q0Var) {
        if (str != null) {
            String a10 = this.f9149b.a(str, q0Var.c());
            if (!TextUtils.isEmpty(a10)) {
                try {
                    return q0Var.b(Integer.valueOf(Integer.parseInt(a10))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return q0Var.a().intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean F(String str) {
        return H(str, p0.V);
    }

    public final double G(String str, q0<Double> q0Var) {
        if (str != null) {
            String a10 = this.f9149b.a(str, q0Var.c());
            if (!TextUtils.isEmpty(a10)) {
                try {
                    return q0Var.b(Double.valueOf(Double.parseDouble(a10))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return q0Var.a().doubleValue();
    }

    public final boolean H(String str, q0<Boolean> q0Var) {
        Boolean b10;
        if (str != null) {
            String a10 = this.f9149b.a(str, q0Var.c());
            if (!TextUtils.isEmpty(a10)) {
                b10 = q0Var.b(Boolean.valueOf(Boolean.parseBoolean(a10)));
                return b10.booleanValue();
            }
        }
        b10 = q0Var.a();
        return b10.booleanValue();
    }

    public final boolean I() {
        if (this.f9150c == null) {
            synchronized (this) {
                if (this.f9150c == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String a10 = a.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f9150c = Boolean.valueOf(str != null && str.equals(a10));
                    }
                    if (this.f9150c == null) {
                        this.f9150c = Boolean.TRUE;
                        c().K().a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f9150c.booleanValue();
    }

    public final boolean J() {
        Boolean w10 = w("firebase_analytics_collection_deactivated");
        return w10 != null && w10.booleanValue();
    }

    public final String M() {
        String str;
        b1 b1Var;
        Object e10;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        } catch (ClassNotFoundException e11) {
            e10 = e11;
            b1Var = c().K();
            str = "Could not find SystemProperties class";
            b1Var.d(str, e10);
            return "";
        } catch (IllegalAccessException e12) {
            e10 = e12;
            b1Var = c().K();
            str = "Could not access SystemProperties.get()";
            b1Var.d(str, e10);
            return "";
        } catch (NoSuchMethodException e13) {
            e10 = e13;
            b1Var = c().K();
            str = "Could not find SystemProperties.get() method";
            b1Var.d(str, e10);
            return "";
        } catch (InvocationTargetException e14) {
            e10 = e14;
            b1Var = c().K();
            str = "SystemProperties.get() threw an exception";
            b1Var.d(str, e10);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean O() {
        return H(j().A(), p0.J);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String P() {
        String A = j().A();
        q0<String> q0Var = p0.K;
        return A == null ? q0Var.a() : q0Var.b(this.f9149b.a(A, q0Var.c()));
    }

    public final long t(String str, q0<Long> q0Var) {
        if (str != null) {
            String a10 = this.f9149b.a(str, q0Var.c());
            if (!TextUtils.isEmpty(a10)) {
                try {
                    return q0Var.b(Long.valueOf(Long.parseLong(a10))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return q0Var.a().longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u(c0 c0Var) {
        this.f9149b = c0Var;
    }

    public final int v(String str) {
        return E(str, p0.f9575q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean w(String str) {
        i.g(str);
        try {
            if (getContext().getPackageManager() == null) {
                c().K().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo b10 = c.a(getContext()).b(getContext().getPackageName(), 128);
            if (b10 == null) {
                c().K().a("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            Bundle bundle = b10.metaData;
            if (bundle == null) {
                c().K().a("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (!bundle.containsKey(str)) {
                return null;
            } else {
                return Boolean.valueOf(b10.metaData.getBoolean(str));
            }
        } catch (PackageManager.NameNotFoundException e10) {
            c().K().d("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    public final boolean x(String str) {
        return "1".equals(this.f9149b.a(str, "gaia_collection_enabled"));
    }

    public final boolean y(String str) {
        return "1".equals(this.f9149b.a(str, "measurement.event_sampling_enabled"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean z(String str) {
        return H(str, p0.O);
    }
}
