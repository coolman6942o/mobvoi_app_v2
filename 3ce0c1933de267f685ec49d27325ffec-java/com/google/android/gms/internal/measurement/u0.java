package com.google.android.gms.internal.measurement;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.f;
import com.google.firebase.iid.FirebaseInstanceId;
import j6.a;
import java.math.BigInteger;
import java.util.Locale;
/* loaded from: classes.dex */
public final class u0 extends z2 {

    /* renamed from: c  reason: collision with root package name */
    private String f9687c;

    /* renamed from: d  reason: collision with root package name */
    private String f9688d;

    /* renamed from: e  reason: collision with root package name */
    private int f9689e;

    /* renamed from: f  reason: collision with root package name */
    private String f9690f;

    /* renamed from: g  reason: collision with root package name */
    private long f9691g;

    /* renamed from: h  reason: collision with root package name */
    private int f9692h;

    /* renamed from: i  reason: collision with root package name */
    private String f9693i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(d2 d2Var) {
        super(d2Var);
    }

    private final String C() {
        e();
        if (s().C(this.f9687c) && !this.f9815a.g0()) {
            return null;
        }
        try {
            return FirebaseInstanceId.b().a();
        } catch (IllegalStateException unused) {
            c().N().a("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String A() {
        u();
        return this.f9687c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdz B(String str) {
        e();
        String A = A();
        String z10 = z();
        u();
        String str2 = this.f9688d;
        long E = E();
        u();
        String str3 = this.f9690f;
        u();
        e();
        if (this.f9691g == 0) {
            this.f9691g = this.f9815a.K().n0(getContext(), getContext().getPackageName());
        }
        long j10 = this.f9691g;
        boolean g02 = this.f9815a.g0();
        boolean z11 = true;
        boolean z12 = !r().f9451x;
        String C = C();
        u();
        long A0 = this.f9815a.A0();
        int F = F();
        Boolean w10 = s().w("google_analytics_adid_collection_enabled");
        boolean booleanValue = Boolean.valueOf(w10 == null || w10.booleanValue()).booleanValue();
        Boolean w11 = s().w("google_analytics_ssaid_collection_enabled");
        if (w11 != null && !w11.booleanValue()) {
            z11 = false;
        }
        return new zzdz(A, z10, str2, E, str3, 12451L, j10, str, g02, z12, C, 0L, A0, F, booleanValue, Boolean.valueOf(z11).booleanValue(), r().O());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String D() {
        byte[] bArr = new byte[16];
        p().y0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int E() {
        u();
        return this.f9689e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int F() {
        u();
        return this.f9692h;
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:2|(1:4)(6:64|5|(1:8)(2:9|(1:11))|70|12|(5:14|(1:16)(1:17)|66|18|19))|23|(1:28)(1:27)|(1:(1:31)(1:32))|(3:34|(1:36)(1:(1:(9:46|48|68|49|(1:51)(1:52)|53|(1:55)|58|(2:60|61)(2:62|63))(1:45))(1:41))|37)|47|48|68|49|(0)(0)|53|(0)|58|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0157, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0158, code lost:
        c().K().c("getGoogleAppId or isMeasurementEnabled failed with exception. appId", com.google.android.gms.internal.measurement.z0.I(r0), r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0145 A[Catch: IllegalStateException -> 0x0157, TRY_LEAVE, TryCatch #2 {IllegalStateException -> 0x0157, blocks: (B:49:0x0135, B:53:0x0141, B:55:0x0145), top: B:68:0x0135 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017a  */
    @Override // com.google.android.gms.internal.measurement.z2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void w() {
        String str;
        boolean z10;
        Object[] objArr;
        String b10;
        b1 P;
        String str2;
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        String str3 = "Unknown";
        String str4 = "";
        String str5 = "unknown";
        int i10 = Integer.MIN_VALUE;
        if (packageManager == null) {
            c().K().d("PackageManager is null, app identity information might be inaccurate. appId", z0.I(packageName));
        } else {
            try {
                str5 = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                c().K().d("Error retrieving app installer package name. appId", z0.I(packageName));
            }
            if (str5 == null) {
                str5 = "manual_install";
            } else if ("com.android.vending".equals(str5)) {
                str5 = str4;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    String charSequence = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : str3;
                    try {
                        str3 = packageInfo.versionName;
                        i10 = packageInfo.versionCode;
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str = str3;
                        str3 = charSequence;
                        c().K().c("Error retrieving package info. appId, appName", z0.I(packageName), str3);
                        str3 = str;
                        this.f9687c = packageName;
                        this.f9690f = str5;
                        this.f9688d = str3;
                        this.f9689e = i10;
                        this.f9691g = 0L;
                        Status c10 = f.c(getContext());
                        z10 = true;
                        if (c10 != null) {
                        }
                        if (objArr == null) {
                        }
                        if (objArr != null) {
                        }
                        z10 = false;
                        this.f9693i = str4;
                        b10 = f.b();
                        if (!TextUtils.isEmpty(b10)) {
                        }
                        this.f9693i = str4;
                        if (z10) {
                        }
                        if (Build.VERSION.SDK_INT >= 16) {
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused3) {
                str = str3;
            }
        }
        this.f9687c = packageName;
        this.f9690f = str5;
        this.f9688d = str3;
        this.f9689e = i10;
        this.f9691g = 0L;
        Status c102 = f.c(getContext());
        z10 = true;
        objArr = (c102 != null || !c102.K0()) ? null : 1;
        if (objArr == null) {
            if (c102 == null) {
                c().K().a("GoogleService failed to initialize (no status)");
            } else {
                c().K().c("GoogleService failed to initialize, status", Integer.valueOf(c102.H0()), c102.I0());
            }
        }
        if (objArr != null) {
            Boolean w10 = s().w("firebase_analytics_collection_enabled");
            if (s().J()) {
                P = c().P();
                str2 = "Collection disabled with firebase_analytics_collection_deactivated=1";
            } else if (w10 != null && !w10.booleanValue()) {
                P = c().P();
                str2 = "Collection disabled with firebase_analytics_collection_enabled=0";
            } else if (w10 != null || !f.d()) {
                c().R().a("Collection enabled");
                this.f9693i = str4;
                b10 = f.b();
                if (!TextUtils.isEmpty(b10)) {
                    str4 = b10;
                }
                this.f9693i = str4;
                if (z10) {
                    c().R().c("App package, google app id", this.f9687c, this.f9693i);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f9692h = a.a(getContext()) ? 1 : 0;
                    return;
                } else {
                    this.f9692h = 0;
                    return;
                }
            } else {
                P = c().P();
                str2 = "Collection disabled with google_app_measurement_enable=0";
            }
            P.a(str2);
        }
        z10 = false;
        this.f9693i = str4;
        b10 = f.b();
        if (!TextUtils.isEmpty(b10)) {
        }
        this.f9693i = str4;
        if (z10) {
        }
        if (Build.VERSION.SDK_INT >= 16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String z() {
        u();
        return this.f9693i;
    }
}
