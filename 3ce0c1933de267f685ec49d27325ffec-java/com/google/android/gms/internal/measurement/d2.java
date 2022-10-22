package com.google.android.gms.internal.measurement;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import b6.i;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import h6.e;
import h6.h;
import j6.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class d2 extends j5 implements a3 {
    private static volatile d2 U;
    private final z4 A;
    private final r5 D;
    private final x0 E;
    private final e F;
    private final x3 G;
    private final c3 H;
    private v0 J;
    private a4 K;
    private j0 L;
    private u0 M;
    private q1 N;
    private Boolean P;
    private long Q;
    private int R;
    private int S;
    private final long T;

    /* renamed from: v  reason: collision with root package name */
    private final Context f9221v;

    /* renamed from: x  reason: collision with root package name */
    private final k1 f9223x;

    /* renamed from: y  reason: collision with root package name */
    private final z0 f9224y;

    /* renamed from: z  reason: collision with root package name */
    private final z1 f9225z;
    private boolean O = false;

    /* renamed from: w  reason: collision with root package name */
    private final a0 f9222w = new a0(this);
    private final r I = new r(this);
    private final AppMeasurement B = new AppMeasurement(this);
    private final FirebaseAnalytics C = new FirebaseAnalytics(this);

    private d2(b3 b3Var) {
        String str;
        b1 b1Var;
        i.k(b3Var);
        i(this);
        Context context = b3Var.f9181a;
        this.f9221v = context;
        v6.b(context);
        this.f9410u = -1L;
        e d10 = h.d();
        this.F = d10;
        this.T = d10.b();
        k1 k1Var = new k1(this);
        k1Var.y();
        this.f9223x = k1Var;
        z0 z0Var = new z0(this);
        z0Var.y();
        this.f9224y = z0Var;
        r5 r5Var = new r5(this);
        r5Var.y();
        this.D = r5Var;
        x0 x0Var = new x0(this);
        x0Var.y();
        this.E = x0Var;
        x3 x3Var = new x3(this);
        x3Var.y();
        this.G = x3Var;
        c3 c3Var = new c3(this);
        c3Var.y();
        this.H = c3Var;
        z4 z4Var = new z4(this);
        z4Var.y();
        this.A = z4Var;
        z1 z1Var = new z1(this);
        z1Var.y();
        this.f9225z = z1Var;
        if (context.getApplicationContext() instanceof Application) {
            c3 o02 = o0();
            if (o02.getContext().getApplicationContext() instanceof Application) {
                Application application = (Application) o02.getContext().getApplicationContext();
                if (o02.f9194c == null) {
                    o02.f9194c = new v3(o02, null);
                }
                application.unregisterActivityLifecycleCallbacks(o02.f9194c);
                application.registerActivityLifecycleCallbacks(o02.f9194c);
                b1Var = o02.c().R();
                str = "Registered activity lifecycle callback";
            }
            d1 d1Var = new d1(this);
            d1Var.y();
            this.f9391b = d1Var;
            y1 y1Var = new y1(this);
            y1Var.y();
            this.f9390a = y1Var;
            z1Var.J(new e2(this, b3Var));
        }
        b1Var = c().N();
        str = "Application context is not an Application";
        b1Var.a(str);
        d1 d1Var2 = new d1(this);
        d1Var2.y();
        this.f9391b = d1Var2;
        y1 y1Var2 = new y1(this);
        y1Var2.y();
        this.f9390a = y1Var2;
        z1Var.J(new e2(this, b3Var));
    }

    private static void h0(y2 y2Var) {
        if (y2Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void i0(z2 z2Var) {
        if (z2Var == null) {
            throw new IllegalStateException("Component not created");
        } else if (!z2Var.t()) {
            String valueOf = String.valueOf(z2Var.getClass());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 27);
            sb2.append("Component not initialized: ");
            sb2.append(valueOf);
            throw new IllegalStateException(sb2.toString());
        }
    }

    private final void l0() {
        if (!this.O) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void m0() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    public static d2 t0(Context context) {
        i.k(context);
        i.k(context.getApplicationContext());
        if (U == null) {
            synchronized (d2.class) {
                if (U == null) {
                    U = new d2(new b3(context));
                }
            }
        }
        return U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long A0() {
        Long valueOf = Long.valueOf(L().f9437j.a());
        return valueOf.longValue() == 0 ? this.T : Math.min(this.T, valueOf.longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B0() {
        this.S++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean C0() {
        l0();
        p();
        Boolean bool = this.P;
        if (bool == null || this.Q == 0 || (bool != null && !bool.booleanValue() && Math.abs(b().c() - this.Q) > 1000)) {
            this.Q = b().c();
            boolean z10 = false;
            if (K().D0("android.permission.INTERNET") && K().D0("android.permission.ACCESS_NETWORK_STATE") && (c.a(getContext()).f() || (u1.b(getContext()) && u4.j(getContext(), false)))) {
                z10 = true;
            }
            Boolean valueOf = Boolean.valueOf(z10);
            this.P = valueOf;
            if (valueOf.booleanValue()) {
                this.P = Boolean.valueOf(K().h0(p0().z()));
            }
        }
        return this.P.booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final j0 G() {
        i0(this.L);
        return this.L;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final x0 J() {
        h0(this.E);
        return this.E;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final r5 K() {
        h0(this.D);
        return this.D;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final k1 L() {
        h0(this.f9223x);
        return this.f9223x;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final a0 M() {
        return this.f9222w;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    protected final void a() {
        p();
        if (L().f9432e.a() == 0) {
            L().f9432e.b(b().b());
        }
        if (Long.valueOf(L().f9437j.a()).longValue() == 0) {
            c().R().d("Persisting first open", Long.valueOf(this.T));
            L().f9437j.b(this.T);
        }
        if (C0()) {
            if (!TextUtils.isEmpty(p0().z())) {
                String J = L().J();
                if (J == null) {
                    L().D(p0().z());
                } else if (!J.equals(p0().z())) {
                    c().P().a("Rechecking which service to use due to a GMP App Id change");
                    L().M();
                    this.K.z();
                    this.K.V();
                    L().D(p0().z());
                    L().f9437j.b(this.T);
                    L().f9439l.a(null);
                }
            }
            o0().j0(L().f9439l.b());
            if (!TextUtils.isEmpty(p0().z())) {
                boolean g02 = g0();
                if (!L().P() && !M().J()) {
                    L().H(!g02);
                }
                if (!M().D(p0().A()) || g02) {
                    o0().u0();
                }
                q0().I(new AtomicReference<>());
            }
        } else if (g0()) {
            if (!K().D0("android.permission.INTERNET")) {
                c().K().a("App is missing INTERNET permission");
            }
            if (!K().D0("android.permission.ACCESS_NETWORK_STATE")) {
                c().K().a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!c.a(getContext()).f()) {
                if (!u1.b(getContext())) {
                    c().K().a("AppMeasurementReceiver not registered/enabled");
                }
                if (!u4.j(getContext(), false)) {
                    c().K().a("AppMeasurementService not registered/enabled");
                }
            }
            c().K().a("Uploading is not possible. App measurement disabled");
        }
        super.a();
    }

    @Override // com.google.android.gms.internal.measurement.j5, com.google.android.gms.internal.measurement.y
    public final e b() {
        return this.F;
    }

    @Override // com.google.android.gms.internal.measurement.j5, com.google.android.gms.internal.measurement.y
    public final z0 c() {
        i0(this.f9224y);
        return this.f9224y;
    }

    @Override // com.google.android.gms.internal.measurement.j5, com.google.android.gms.internal.measurement.y
    public final z1 d() {
        i0(this.f9225z);
        return this.f9225z;
    }

    public final boolean g0() {
        p();
        l0();
        boolean z10 = false;
        if (M().J()) {
            return false;
        }
        Boolean w10 = M().w("firebase_analytics_collection_enabled");
        if (w10 != null) {
            z10 = w10.booleanValue();
        } else if (!f.d()) {
            z10 = true;
        }
        return L().G(z10);
    }

    @Override // com.google.android.gms.internal.measurement.j5, com.google.android.gms.internal.measurement.y
    public final Context getContext() {
        return this.f9221v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j0(b3 b3Var) {
        String str;
        b1 b1Var;
        p();
        j0 j0Var = new j0(this);
        j0Var.y();
        this.L = j0Var;
        u0 u0Var = new u0(this);
        u0Var.y();
        this.M = u0Var;
        v0 v0Var = new v0(this);
        v0Var.y();
        this.J = v0Var;
        a4 a4Var = new a4(this);
        a4Var.y();
        this.K = a4Var;
        this.D.x();
        this.f9223x.x();
        this.N = new q1(this);
        this.M.x();
        c().P().d("App measurement is starting up, version", 12451L);
        c().P().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String A = u0Var.A();
        if (K().k0(A)) {
            b1Var = c().P();
            str = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
        } else {
            b1Var = c().P();
            String valueOf = String.valueOf(A);
            str = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
        }
        b1Var.a(str);
        c().Q().a("Debug-level message logging enabled");
        if (this.R != this.S) {
            c().K().c("Not all components initialized", Integer.valueOf(this.R), Integer.valueOf(this.S));
        }
        super.k(b3Var);
        this.O = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void k0(z2 z2Var) {
        this.R++;
    }

    public final r n0() {
        h0(this.I);
        return this.I;
    }

    public final c3 o0() {
        i0(this.H);
        return this.H;
    }

    @Override // com.google.android.gms.internal.measurement.j5
    public final void p() {
        d().e();
    }

    public final u0 p0() {
        i0(this.M);
        return this.M;
    }

    public final a4 q0() {
        i0(this.K);
        return this.K;
    }

    public final x3 r0() {
        i0(this.G);
        return this.G;
    }

    public final v0 s0() {
        i0(this.J);
        return this.J;
    }

    public final z4 u0() {
        i0(this.A);
        return this.A;
    }

    public final z0 v0() {
        z0 z0Var = this.f9224y;
        if (z0Var == null || !z0Var.t()) {
            return null;
        }
        return this.f9224y;
    }

    public final q1 w0() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final z1 x0() {
        return this.f9225z;
    }

    public final AppMeasurement y0() {
        return this.B;
    }

    public final FirebaseAnalytics z0() {
        return this.C;
    }
}
