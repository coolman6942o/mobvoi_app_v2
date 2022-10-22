package com.google.android.gms.common.api.internal;

import a7.b;
import a7.e;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.c;
import com.google.android.gms.signin.internal.zaj;
import java.util.Set;
/* loaded from: classes.dex */
public final class q1 extends c implements d.b, d.c {

    /* renamed from: h  reason: collision with root package name */
    private static a.AbstractC0105a<? extends e, a7.a> f8708h = b.f121c;

    /* renamed from: a  reason: collision with root package name */
    private final Context f8709a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f8710b;

    /* renamed from: c  reason: collision with root package name */
    private final a.AbstractC0105a<? extends e, a7.a> f8711c;

    /* renamed from: d  reason: collision with root package name */
    private Set<Scope> f8712d;

    /* renamed from: e  reason: collision with root package name */
    private b6.c f8713e;

    /* renamed from: f  reason: collision with root package name */
    private e f8714f;

    /* renamed from: g  reason: collision with root package name */
    private t1 f8715g;

    public q1(Context context, Handler handler, b6.c cVar) {
        this(context, handler, cVar, f8708h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E2(zaj zajVar) {
        ConnectionResult G0 = zajVar.G0();
        if (G0.K0()) {
            ResolveAccountResponse H0 = zajVar.H0();
            ConnectionResult H02 = H0.H0();
            if (!H02.K0()) {
                String valueOf = String.valueOf(H02);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 48);
                sb2.append("Sign-in succeeded with resolve account failure: ");
                sb2.append(valueOf);
                Log.wtf("SignInCoordinator", sb2.toString(), new Exception());
                this.f8715g.c(H02);
                this.f8714f.a();
                return;
            }
            this.f8715g.b(H0.G0(), this.f8712d);
        } else {
            this.f8715g.c(G0);
        }
        this.f8714f.a();
    }

    @Override // com.google.android.gms.signin.internal.d
    public final void A(zaj zajVar) {
        this.f8710b.post(new s1(this, zajVar));
    }

    public final void B2(t1 t1Var) {
        e eVar = this.f8714f;
        if (eVar != null) {
            eVar.a();
        }
        this.f8713e.m(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0105a<? extends e, a7.a> aVar = this.f8711c;
        Context context = this.f8709a;
        Looper looper = this.f8710b.getLooper();
        b6.c cVar = this.f8713e;
        this.f8714f = aVar.c(context, looper, cVar, cVar.k(), this, this);
        this.f8715g = t1Var;
        Set<Scope> set = this.f8712d;
        if (set == null || set.isEmpty()) {
            this.f8710b.post(new r1(this));
        } else {
            this.f8714f.b();
        }
    }

    public final e C2() {
        return this.f8714f;
    }

    public final void D2() {
        e eVar = this.f8714f;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnected(Bundle bundle) {
        this.f8714f.q(this);
    }

    @Override // com.google.android.gms.common.api.d.c
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f8715g.c(connectionResult);
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnectionSuspended(int i10) {
        this.f8714f.a();
    }

    public q1(Context context, Handler handler, b6.c cVar, a.AbstractC0105a<? extends e, a7.a> aVar) {
        this.f8709a = context;
        this.f8710b = handler;
        this.f8713e = (b6.c) i.l(cVar, "ClientSettings must not be null");
        this.f8712d = cVar.j();
        this.f8711c = aVar;
    }
}
