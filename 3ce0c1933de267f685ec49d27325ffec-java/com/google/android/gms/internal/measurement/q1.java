package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.ml.camera.CameraConfig;
import g6.a;
import j6.b;
import j6.c;
import java.util.List;
/* loaded from: classes.dex */
public final class q1 {

    /* renamed from: a */
    private final d2 f9603a;

    /* renamed from: b */
    volatile n6 f9604b;

    /* renamed from: c */
    private ServiceConnection f9605c;

    public q1(d2 d2Var) {
        this.f9603a = d2Var;
    }

    private final boolean d() {
        try {
            b a10 = c.a(this.f9603a.getContext());
            if (a10 != null) {
                return a10.d("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f9603a.c().P().a("Failed to retrieve Package Manager to check Play Store compatibility");
            return false;
        } catch (Exception e10) {
            this.f9603a.c().P().d("Failed to retrieve Play Store version", e10);
            return false;
        }
    }

    public final void b(Bundle bundle) {
        b1 K;
        String str;
        this.f9603a.p();
        if (bundle != null) {
            long j10 = bundle.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j10 == 0) {
                K = this.f9603a.c().K();
                str = "Service response is missing Install Referrer install timestamp";
            } else {
                String string = bundle.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    K = this.f9603a.c().K();
                    str = "No referrer defined in install referrer response";
                } else {
                    this.f9603a.c().R().d("InstallReferrer API result", string);
                    Bundle A = this.f9603a.K().A(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                    if (A == null) {
                        K = this.f9603a.c().K();
                        str = "No campaign params defined in install referrer result";
                    } else {
                        String string2 = A.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j11 = bundle.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j11 == 0) {
                                K = this.f9603a.c().K();
                                str = "Install Referrer is missing click timestamp for ad campaign";
                            } else {
                                A.putLong("click_timestamp", j11);
                            }
                        }
                        if (j10 == this.f9603a.L().f9438k.a()) {
                            K = this.f9603a.c().R();
                            str = "Campaign has already been logged";
                        } else {
                            A.putString("_cis", "referrer API");
                            this.f9603a.L().f9438k.b(j10);
                            this.f9603a.o0().G(CameraConfig.CAMERA_FOCUS_AUTO, "_cmp", A);
                            if (this.f9605c != null) {
                                a.b().c(this.f9603a.getContext(), this.f9605c);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
            K.a(str);
        }
    }

    public final void c() {
        this.f9603a.p();
        if (!d()) {
            this.f9603a.c().P().a("Install Referrer Reporter is not available");
            this.f9605c = null;
            return;
        }
        this.f9605c = new s1(this);
        this.f9603a.c().P().a("Install Referrer Reporter is initializing");
        this.f9603a.p();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f9603a.getContext().getPackageManager();
        if (packageManager == null) {
            this.f9603a.c().N().a("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f9603a.c().P().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str = serviceInfo.packageName;
            if (serviceInfo.name == null || this.f9605c == null || !"com.android.vending".equals(str) || !d()) {
                this.f9603a.c().P().a("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            try {
                this.f9603a.c().P().d("Install Referrer Service is", a.b().a(this.f9603a.getContext(), new Intent(intent), this.f9605c, 1) ? "available" : "not available");
            } catch (Exception e10) {
                this.f9603a.c().K().d("Exception occurred while binding to Install Referrer Service", e10.getMessage());
            }
        }
    }

    public final Bundle e() {
        this.f9603a.p();
        if (this.f9604b == null) {
            this.f9603a.c().N().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f9603a.getContext().getPackageName());
        try {
            Bundle J1 = this.f9604b.J1(bundle);
            if (J1 != null) {
                return J1;
            }
            this.f9603a.c().K().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e10) {
            this.f9603a.c().K().d("Exception occurred while retrieving the Install Referrer", e10.getMessage());
            return null;
        }
    }
}
