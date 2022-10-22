package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.text.TextUtils;
import b6.i;
import com.google.android.gms.common.e;
import com.google.android.gms.common.f;
import h6.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
/* loaded from: classes.dex */
public final class f2 extends s0 {

    /* renamed from: a  reason: collision with root package name */
    private final j5 f9262a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f9263b;

    /* renamed from: c  reason: collision with root package name */
    private String f9264c;

    public f2(j5 j5Var) {
        this(j5Var, null);
    }

    private f2(j5 j5Var, String str) {
        i.k(j5Var);
        this.f9262a = j5Var;
        this.f9264c = null;
    }

    private final void A2(String str, boolean z10) {
        boolean z11;
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                try {
                    if (this.f9263b == null) {
                        if (!"com.google.android.gms".equals(this.f9264c) && !p.a(this.f9262a.getContext(), Binder.getCallingUid()) && !f.a(this.f9262a.getContext()).c(Binder.getCallingUid())) {
                            z11 = false;
                            this.f9263b = Boolean.valueOf(z11);
                        }
                        z11 = true;
                        this.f9263b = Boolean.valueOf(z11);
                    }
                    if (this.f9263b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e10) {
                    this.f9262a.c().K().d("Measurement Service called with invalid calling package. appId", z0.I(str));
                    throw e10;
                }
            }
            if (this.f9264c == null && e.m(this.f9262a.getContext(), Binder.getCallingUid(), str)) {
                this.f9264c = str;
            }
            if (!str.equals(this.f9264c)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
            return;
        }
        this.f9262a.c().K().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    private final void B2(Runnable runnable) {
        i.k(runnable);
        if (!p0.U.a().booleanValue() || !this.f9262a.d().N()) {
            this.f9262a.d().J(runnable);
        } else {
            runnable.run();
        }
    }

    private final void U1(zzdz zzdzVar, boolean z10) {
        i.k(zzdzVar);
        A2(zzdzVar.f9859a, false);
        this.f9262a.K().h0(zzdzVar.f9860b);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void C1(zzed zzedVar) {
        i.k(zzedVar);
        i.k(zzedVar.f9878c);
        A2(zzedVar.f9876a, true);
        zzed zzedVar2 = new zzed(zzedVar);
        B2(zzedVar.f9878c.G0() == null ? new j2(this, zzedVar2) : new k2(this, zzedVar2));
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzjx> G(String str, String str2, String str3, boolean z10) {
        A2(str, true);
        try {
            List<q5> list = (List) this.f9262a.d().F(new m2(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (q5 q5Var : list) {
                if (z10 || !r5.j0(q5Var.f9615c)) {
                    arrayList.add(new zzjx(q5Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f9262a.c().K().c("Failed to get user attributes. appId", z0.I(str), e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void K(zzjx zzjxVar, zzdz zzdzVar) {
        i.k(zzjxVar);
        U1(zzdzVar, false);
        B2(zzjxVar.G0() == null ? new t2(this, zzjxVar, zzdzVar) : new u2(this, zzjxVar, zzdzVar));
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final byte[] P(zzeu zzeuVar, String str) {
        i.g(str);
        i.k(zzeuVar);
        A2(str, true);
        this.f9262a.c().Q().d("Log and bundle. event", this.f9262a.J().M(zzeuVar.f9888a));
        long a10 = this.f9262a.b().a() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f9262a.d().I(new s2(this, zzeuVar, str)).get();
            if (bArr == null) {
                this.f9262a.c().K().d("Log and bundle returned null. appId", z0.I(str));
                bArr = new byte[0];
            }
            this.f9262a.c().Q().b("Log and bundle processed. event, size, time_ms", this.f9262a.J().M(zzeuVar.f9888a), Integer.valueOf(bArr.length), Long.valueOf((this.f9262a.b().a() / 1000000) - a10));
            return bArr;
        } catch (InterruptedException | ExecutionException e10) {
            this.f9262a.c().K().b("Failed to log and bundle. appId, event, error", z0.I(str), this.f9262a.J().M(zzeuVar.f9888a), e10);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void Q0(zzdz zzdzVar) {
        A2(zzdzVar.f9859a, false);
        B2(new p2(this, zzdzVar));
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void X0(zzed zzedVar, zzdz zzdzVar) {
        i.k(zzedVar);
        i.k(zzedVar.f9878c);
        U1(zzdzVar, false);
        zzed zzedVar2 = new zzed(zzedVar);
        zzedVar2.f9876a = zzdzVar.f9859a;
        B2(zzedVar.f9878c.G0() == null ? new h2(this, zzedVar2, zzdzVar) : new i2(this, zzedVar2, zzdzVar));
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void c0(zzdz zzdzVar) {
        U1(zzdzVar, false);
        B2(new g2(this, zzdzVar));
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzed> e2(String str, String str2, String str3) {
        A2(str, true);
        try {
            return (List) this.f9262a.d().F(new o2(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f9262a.c().K().d("Failed to get conditional user properties", e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzjx> f2(String str, String str2, boolean z10, zzdz zzdzVar) {
        U1(zzdzVar, false);
        try {
            List<q5> list = (List) this.f9262a.d().F(new l2(this, zzdzVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (q5 q5Var : list) {
                if (z10 || !r5.j0(q5Var.f9615c)) {
                    arrayList.add(new zzjx(q5Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f9262a.c().K().c("Failed to get user attributes. appId", z0.I(zzdzVar.f9859a), e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzjx> i1(zzdz zzdzVar, boolean z10) {
        U1(zzdzVar, false);
        try {
            List<q5> list = (List) this.f9262a.d().F(new v2(this, zzdzVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (q5 q5Var : list) {
                if (z10 || !r5.j0(q5Var.f9615c)) {
                    arrayList.add(new zzjx(q5Var));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e10) {
            this.f9262a.c().K().c("Failed to get user attributes. appId", z0.I(zzdzVar.f9859a), e10);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void l1(zzeu zzeuVar, zzdz zzdzVar) {
        i.k(zzeuVar);
        U1(zzdzVar, false);
        B2(new q2(this, zzeuVar, zzdzVar));
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void r0(zzdz zzdzVar) {
        U1(zzdzVar, false);
        B2(new w2(this, zzdzVar));
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final String r1(zzdz zzdzVar) {
        U1(zzdzVar, false);
        return this.f9262a.N(zzdzVar);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final List<zzed> v2(String str, String str2, zzdz zzdzVar) {
        U1(zzdzVar, false);
        try {
            return (List) this.f9262a.d().F(new n2(this, zzdzVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.f9262a.c().K().d("Failed to get conditional user properties", e10);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void w0(zzeu zzeuVar, String str, String str2) {
        i.k(zzeuVar);
        i.g(str);
        A2(str, true);
        B2(new r2(this, zzeuVar, str));
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void x0(long j10, String str, String str2, String str3) {
        B2(new x2(this, str2, str3, str, j10));
    }
}
