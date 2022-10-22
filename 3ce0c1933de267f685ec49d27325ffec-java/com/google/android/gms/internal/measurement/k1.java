package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import s5.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k1 extends z2 {

    /* renamed from: y  reason: collision with root package name */
    static final Pair<String, Long> f9429y = new Pair<>("", 0L);

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f9430c;

    /* renamed from: d  reason: collision with root package name */
    public o1 f9431d;

    /* renamed from: m  reason: collision with root package name */
    private String f9440m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f9441n;

    /* renamed from: o  reason: collision with root package name */
    private long f9442o;

    /* renamed from: p  reason: collision with root package name */
    private String f9443p;

    /* renamed from: q  reason: collision with root package name */
    private long f9444q;

    /* renamed from: x  reason: collision with root package name */
    public boolean f9451x;

    /* renamed from: e  reason: collision with root package name */
    public final n1 f9432e = new n1(this, "last_upload", 0);

    /* renamed from: f  reason: collision with root package name */
    public final n1 f9433f = new n1(this, "last_upload_attempt", 0);

    /* renamed from: g  reason: collision with root package name */
    public final n1 f9434g = new n1(this, "backoff", 0);

    /* renamed from: h  reason: collision with root package name */
    public final n1 f9435h = new n1(this, "last_delete_stale", 0);

    /* renamed from: s  reason: collision with root package name */
    public final n1 f9446s = new n1(this, "time_before_start", 10000);

    /* renamed from: t  reason: collision with root package name */
    public final n1 f9447t = new n1(this, "session_timeout", 1800000);

    /* renamed from: u  reason: collision with root package name */
    public final m1 f9448u = new m1(this, "start_new_session", true);

    /* renamed from: v  reason: collision with root package name */
    public final n1 f9449v = new n1(this, "last_pause_time", 0);

    /* renamed from: w  reason: collision with root package name */
    public final n1 f9450w = new n1(this, "time_active", 0);

    /* renamed from: i  reason: collision with root package name */
    public final n1 f9436i = new n1(this, "midnight_offset", 0);

    /* renamed from: j  reason: collision with root package name */
    public final n1 f9437j = new n1(this, "first_open_time", 0);

    /* renamed from: k  reason: collision with root package name */
    public final n1 f9438k = new n1(this, "app_install_time", 0);

    /* renamed from: l  reason: collision with root package name */
    public final p1 f9439l = new p1(this, "app_instance_id", null);

    /* renamed from: r  reason: collision with root package name */
    private final Object f9445r = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public k1(d2 d2Var) {
        super(d2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPreferences I() {
        e();
        u();
        return this.f9430c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair<String, Boolean> B(String str) {
        e();
        long c10 = b().c();
        if (this.f9440m != null && c10 < this.f9442o) {
            return new Pair<>(this.f9440m, Boolean.valueOf(this.f9441n));
        }
        this.f9442o = c10 + s().t(str, p0.f9562d);
        a.d(true);
        try {
            a.C0494a b10 = a.b(getContext());
            if (b10 != null) {
                this.f9440m = b10.a();
                this.f9441n = b10.b();
            }
            if (this.f9440m == null) {
                this.f9440m = "";
            }
        } catch (Exception e10) {
            c().Q().d("Unable to get advertising id", e10);
            this.f9440m = "";
        }
        a.d(false);
        return new Pair<>(this.f9440m, Boolean.valueOf(this.f9441n));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String C(String str) {
        e();
        String str2 = (String) B(str).first;
        MessageDigest z10 = r5.z("MD5");
        if (z10 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, z10.digest(str2.getBytes())));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void D(String str) {
        e();
        SharedPreferences.Editor edit = I().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void E(String str) {
        synchronized (this.f9445r) {
            this.f9443p = str;
            this.f9444q = b().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void F(boolean z10) {
        e();
        c().R().d("Setting useService", Boolean.valueOf(z10));
        SharedPreferences.Editor edit = I().edit();
        edit.putBoolean("use_service", z10);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean G(boolean z10) {
        e();
        return I().getBoolean("measurement_enabled", z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(boolean z10) {
        e();
        c().R().d("Updating deferred analytics collection", Boolean.valueOf(z10));
        SharedPreferences.Editor edit = I().edit();
        edit.putBoolean("deferred_analytics_collection", z10);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String J() {
        e();
        return I().getString("gmp_app_id", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String K() {
        synchronized (this.f9445r) {
            if (Math.abs(b().c() - this.f9444q) >= 1000) {
                return null;
            }
            return this.f9443p;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean L() {
        e();
        if (!I().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(I().getBoolean("use_service", false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void M() {
        e();
        c().R().a("Clearing collection preferences.");
        boolean contains = I().contains("measurement_enabled");
        boolean z10 = true;
        if (contains) {
            z10 = G(true);
        }
        SharedPreferences.Editor edit = I().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            z(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String N() {
        e();
        String string = I().getString("previous_os_version", null);
        k().u();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = I().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean O() {
        e();
        return I().getBoolean("deferred_analytics_collection", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean P() {
        return this.f9430c.contains("deferred_analytics_collection");
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final void w() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f9430c = sharedPreferences;
        boolean z10 = sharedPreferences.getBoolean("has_been_opened", false);
        this.f9451x = z10;
        if (!z10) {
            SharedPreferences.Editor edit = this.f9430c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f9431d = new o1(this, "health_monitor", Math.max(0L, p0.f9563e.a().longValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z(boolean z10) {
        e();
        c().R().d("Setting measurementEnabled", Boolean.valueOf(z10));
        SharedPreferences.Editor edit = I().edit();
        edit.putBoolean("measurement_enabled", z10);
        edit.apply();
    }
}
