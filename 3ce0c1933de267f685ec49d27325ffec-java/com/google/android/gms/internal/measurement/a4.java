package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import b6.i;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.mobvoi.wear.util.LogCleaner;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import g6.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class a4 extends z2 {

    /* renamed from: d  reason: collision with root package name */
    private r0 f9160d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Boolean f9161e;

    /* renamed from: f  reason: collision with root package name */
    private final h0 f9162f;

    /* renamed from: g  reason: collision with root package name */
    private final e5 f9163g;

    /* renamed from: i  reason: collision with root package name */
    private final h0 f9165i;

    /* renamed from: h  reason: collision with root package name */
    private final List<Runnable> f9164h = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final o4 f9159c = new o4(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public a4(d2 d2Var) {
        super(d2Var);
        this.f9163g = new e5(d2Var.b());
        this.f9162f = new b4(this, d2Var);
        this.f9165i = new g4(this, d2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(ComponentName componentName) {
        e();
        if (this.f9160d != null) {
            this.f9160d = null;
            c().R().d("Disconnected from device MeasurementService", componentName);
            e();
            V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        e();
        this.f9163g.b();
        this.f9162f.f(p0.I.a().longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        e();
        if (A()) {
            c().R().a("Inactivity, disconnecting from the service");
            z();
        }
    }

    private final void X(Runnable runnable) throws IllegalStateException {
        e();
        if (A()) {
            runnable.run();
        } else if (this.f9164h.size() >= 1000) {
            c().K().a("Discarding data. Max runnable queue size reached");
        } else {
            this.f9164h.add(runnable);
            this.f9165i.f(LogCleaner.ONE_MINUTE);
            V();
        }
    }

    private final zzdz Y(boolean z10) {
        return j().B(z10 ? c().T() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        e();
        c().R().d("Processing queued up service tasks", Integer.valueOf(this.f9164h.size()));
        for (Runnable runnable : this.f9164h) {
            try {
                runnable.run();
            } catch (Exception e10) {
                c().K().d("Task exception while flushing queue", e10);
            }
        }
        this.f9164h.clear();
        this.f9165i.a();
    }

    public final boolean A() {
        e();
        u();
        return this.f9160d != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C() {
        e();
        u();
        zzdz Y = Y(false);
        n().A();
        X(new c4(this, Y));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F(r0 r0Var) {
        e();
        i.k(r0Var);
        this.f9160d = r0Var;
        R();
        c0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void G(r0 r0Var, AbstractSafeParcelable abstractSafeParcelable, zzdz zzdzVar) {
        int i10;
        b1 K;
        String str;
        e();
        u();
        int i11 = 0;
        int i12 = 100;
        while (i11 < 1001 && i12 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> F = n().F(100);
            if (F != null) {
                arrayList.addAll(F);
                i10 = F.size();
            } else {
                i10 = 0;
            }
            if (abstractSafeParcelable != null && i10 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i13 = 0;
            while (i13 < size) {
                Object obj = arrayList.get(i13);
                i13++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzeu) {
                    try {
                        r0Var.l1((zzeu) abstractSafeParcelable2, zzdzVar);
                    } catch (RemoteException e10) {
                        e = e10;
                        K = c().K();
                        str = "Failed to send event to the service";
                        K.d(str, e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjx) {
                    try {
                        r0Var.K((zzjx) abstractSafeParcelable2, zzdzVar);
                    } catch (RemoteException e11) {
                        e = e11;
                        K = c().K();
                        str = "Failed to send attribute to the service";
                        K.d(str, e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzed) {
                    try {
                        r0Var.X0((zzed) abstractSafeParcelable2, zzdzVar);
                    } catch (RemoteException e12) {
                        e = e12;
                        K = c().K();
                        str = "Failed to send conditional property to the service";
                        K.d(str, e);
                    }
                } else {
                    c().K().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i11++;
            i12 = i10;
        }
    }

    public final void I(AtomicReference<String> atomicReference) {
        e();
        u();
        X(new d4(this, atomicReference, Y(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J(AtomicReference<List<zzed>> atomicReference, String str, String str2, String str3) {
        e();
        u();
        X(new k4(this, atomicReference, str, str2, str3, Y(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K(AtomicReference<List<zzjx>> atomicReference, String str, String str2, String str3, boolean z10) {
        e();
        u();
        X(new l4(this, atomicReference, str, str2, str3, z10, Y(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L(AtomicReference<List<zzjx>> atomicReference, boolean z10) {
        e();
        u();
        X(new n4(this, atomicReference, Y(false), z10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M(zzeu zzeuVar, String str) {
        i.k(zzeuVar);
        e();
        u();
        X(new i4(this, true, n().C(zzeuVar), zzeuVar, Y(true), str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(w3 w3Var) {
        e();
        u();
        X(new f4(this, w3Var));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(zzjx zzjxVar) {
        e();
        u();
        X(new m4(this, n().D(zzjxVar), zzjxVar, Y(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(zzed zzedVar) {
        i.k(zzedVar);
        e();
        u();
        X(new j4(this, true, n().E(zzedVar), new zzed(zzedVar), Y(true), zzedVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V() {
        boolean z10;
        boolean z11;
        String str;
        b1 b1Var;
        String str2;
        b1 b1Var2;
        e();
        u();
        if (!A()) {
            boolean z12 = false;
            if (this.f9161e == null) {
                e();
                u();
                Boolean L = r().L();
                if (L == null || !L.booleanValue()) {
                    if (j().F() != 1) {
                        c().R().a("Checking service availability");
                        int j10 = c.h().j(p().getContext(), 12451);
                        if (j10 != 0) {
                            if (j10 == 1) {
                                c().R().a("Service missing");
                            } else if (j10 != 2) {
                                if (j10 == 3) {
                                    b1Var2 = c().N();
                                    str2 = "Service disabled";
                                } else if (j10 == 9) {
                                    b1Var2 = c().N();
                                    str2 = "Service invalid";
                                } else if (j10 != 18) {
                                    c().N().d("Unexpected service status", Integer.valueOf(j10));
                                    z10 = false;
                                    z11 = z10;
                                    if (z11) {
                                        r().F(z10);
                                    }
                                } else {
                                    b1Var = c().N();
                                    str = "Service updating";
                                }
                                b1Var2.a(str2);
                                z10 = false;
                                z11 = z10;
                                if (z11) {
                                }
                            } else {
                                c().Q().a("Service container out of date");
                                if (p().z0() >= 12600) {
                                    Boolean L2 = r().L();
                                    z10 = L2 == null || L2.booleanValue();
                                    z11 = false;
                                    if (z11) {
                                    }
                                }
                            }
                            z10 = false;
                            z11 = true;
                            if (z11) {
                            }
                        } else {
                            b1Var = c().R();
                            str = "Service available";
                        }
                        b1Var.a(str);
                    }
                    z10 = true;
                    z11 = z10;
                    if (z11) {
                    }
                } else {
                    z10 = true;
                }
                this.f9161e = Boolean.valueOf(z10);
            }
            if (this.f9161e.booleanValue()) {
                this.f9159c.c();
                return;
            }
            List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), WXMediaMessage.THUMB_LENGTH_LIMIT);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                z12 = true;
            }
            if (z12) {
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.f9159c.b(intent);
                return;
            }
            c().K().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z() {
        e();
        u();
        X(new e4(this, Y(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a0() {
        e();
        u();
        X(new h4(this, Y(true)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean b0() {
        return this.f9161e;
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return false;
    }

    public final void z() {
        e();
        u();
        try {
            a.b().c(getContext(), this.f9159c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f9160d = null;
    }
}
