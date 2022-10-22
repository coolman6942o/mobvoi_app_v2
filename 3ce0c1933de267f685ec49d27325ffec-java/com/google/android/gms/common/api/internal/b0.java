package com.google.android.gms.common.api.internal;

import a7.e;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import b6.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.signin.internal.zaj;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
public final class b0 implements v0 {

    /* renamed from: a  reason: collision with root package name */
    private final w0 f8516a;

    /* renamed from: b  reason: collision with root package name */
    private final Lock f8517b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f8518c;

    /* renamed from: d  reason: collision with root package name */
    private final c f8519d;

    /* renamed from: e  reason: collision with root package name */
    private ConnectionResult f8520e;

    /* renamed from: f  reason: collision with root package name */
    private int f8521f;

    /* renamed from: h  reason: collision with root package name */
    private int f8523h;

    /* renamed from: k  reason: collision with root package name */
    private e f8526k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f8527l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f8528m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8529n;

    /* renamed from: o  reason: collision with root package name */
    private f f8530o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8531p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f8532q;

    /* renamed from: r  reason: collision with root package name */
    private final b6.c f8533r;

    /* renamed from: s  reason: collision with root package name */
    private final Map<a<?>, Boolean> f8534s;

    /* renamed from: t  reason: collision with root package name */
    private final a.AbstractC0105a<? extends e, a7.a> f8535t;

    /* renamed from: g  reason: collision with root package name */
    private int f8522g = 0;

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f8524i = new Bundle();

    /* renamed from: j  reason: collision with root package name */
    private final Set<a.c> f8525j = new HashSet();

    /* renamed from: u  reason: collision with root package name */
    private ArrayList<Future<?>> f8536u = new ArrayList<>();

    public b0(w0 w0Var, b6.c cVar, Map<a<?>, Boolean> map, c cVar2, a.AbstractC0105a<? extends e, a7.a> aVar, Lock lock, Context context) {
        this.f8516a = w0Var;
        this.f8533r = cVar;
        this.f8534s = map;
        this.f8519d = cVar2;
        this.f8535t = aVar;
        this.f8517b = lock;
        this.f8518c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(ConnectionResult connectionResult) {
        return this.f8527l && !connectionResult.J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(ConnectionResult connectionResult) {
        q();
        u(!connectionResult.J0());
        this.f8516a.q(connectionResult);
        this.f8516a.f8777o.a(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(zaj zajVar) {
        if (x(0)) {
            ConnectionResult G0 = zajVar.G0();
            if (G0.K0()) {
                ResolveAccountResponse H0 = zajVar.H0();
                ConnectionResult H02 = H0.H0();
                if (!H02.K0()) {
                    String valueOf = String.valueOf(H02);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 48);
                    sb2.append("Sign-in succeeded with resolve account failure: ");
                    sb2.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb2.toString(), new Exception());
                    B(H02);
                    return;
                }
                this.f8529n = true;
                this.f8530o = H0.G0();
                this.f8531p = H0.I0();
                this.f8532q = H0.J0();
                n();
            } else if (A(G0)) {
                p();
                n();
            } else {
                B(G0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m() {
        int i10 = this.f8523h - 1;
        this.f8523h = i10;
        if (i10 > 0) {
            return false;
        }
        if (i10 < 0) {
            Log.w("GoogleApiClientConnecting", this.f8516a.f8776n.F());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            B(new ConnectionResult(8, null));
            return false;
        }
        ConnectionResult connectionResult = this.f8520e;
        if (connectionResult == null) {
            return true;
        }
        this.f8516a.f8775m = this.f8521f;
        B(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        if (this.f8523h == 0) {
            if (!this.f8528m || this.f8529n) {
                ArrayList arrayList = new ArrayList();
                this.f8522g = 1;
                this.f8523h = this.f8516a.f8768f.size();
                for (a.c<?> cVar : this.f8516a.f8768f.keySet()) {
                    if (!this.f8516a.f8769g.containsKey(cVar)) {
                        arrayList.add(this.f8516a.f8768f.get(cVar));
                    } else if (m()) {
                        o();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f8536u.add(z0.a().submit(new h0(this, arrayList)));
                }
            }
        }
    }

    private final void o() {
        this.f8516a.p();
        z0.a().execute(new c0(this));
        e eVar = this.f8526k;
        if (eVar != null) {
            if (this.f8531p) {
                eVar.c(this.f8530o, this.f8532q);
            }
            u(false);
        }
        for (a.c<?> cVar : this.f8516a.f8769g.keySet()) {
            this.f8516a.f8768f.get(cVar).a();
        }
        this.f8516a.f8777o.b(this.f8524i.isEmpty() ? null : this.f8524i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        this.f8528m = false;
        this.f8516a.f8776n.f8668q = Collections.emptySet();
        for (a.c<?> cVar : this.f8525j) {
            if (!this.f8516a.f8769g.containsKey(cVar)) {
                this.f8516a.f8769g.put(cVar, new ConnectionResult(17, null));
            }
        }
    }

    private final void q() {
        ArrayList<Future<?>> arrayList = this.f8536u;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Future<?> future = arrayList.get(i10);
            i10++;
            future.cancel(true);
        }
        this.f8536u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<Scope> r() {
        if (this.f8533r == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f8533r.j());
        Map<a<?>, c.b> g10 = this.f8533r.g();
        for (a<?> aVar : g10.keySet()) {
            if (!this.f8516a.f8769g.containsKey(aVar.a())) {
                hashSet.addAll(g10.get(aVar).f5059a);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if ((r5.J0() || r4.f8519d.c(r5.G0()) != null) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t(ConnectionResult connectionResult, a<?> aVar, boolean z10) {
        int b10 = aVar.c().b();
        boolean z11 = false;
        if (z10) {
        }
        if (this.f8520e == null || b10 < this.f8521f) {
            z11 = true;
        }
        if (z11) {
            this.f8520e = connectionResult;
            this.f8521f = b10;
        }
        this.f8516a.f8769g.put(aVar.a(), connectionResult);
    }

    private final void u(boolean z10) {
        e eVar = this.f8526k;
        if (eVar != null) {
            if (eVar.isConnected() && z10) {
                this.f8526k.d();
            }
            this.f8526k.a();
            if (this.f8533r.l()) {
                this.f8526k = null;
            }
            this.f8530o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean x(int i10) {
        if (this.f8522g == i10) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f8516a.f8776n.F());
        String valueOf = String.valueOf(this);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
        sb2.append("Unexpected callback in ");
        sb2.append(valueOf);
        Log.w("GoogleApiClientConnecting", sb2.toString());
        int i11 = this.f8523h;
        StringBuilder sb3 = new StringBuilder(33);
        sb3.append("mRemainingConnections=");
        sb3.append(i11);
        Log.w("GoogleApiClientConnecting", sb3.toString());
        String z10 = z(this.f8522g);
        String z11 = z(i10);
        StringBuilder sb4 = new StringBuilder(String.valueOf(z10).length() + 70 + String.valueOf(z11).length());
        sb4.append("GoogleApiClient connecting is in step ");
        sb4.append(z10);
        sb4.append(" but received callback for step ");
        sb4.append(z11);
        Log.wtf("GoogleApiClientConnecting", sb4.toString(), new Exception());
        B(new ConnectionResult(8, null));
        return false;
    }

    private static String z(int i10) {
        return i10 != 0 ? i10 != 1 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final boolean a() {
        q();
        u(true);
        this.f8516a.q(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void b() {
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void c(ConnectionResult connectionResult, a<?> aVar, boolean z10) {
        if (x(1)) {
            t(connectionResult, aVar, z10);
            if (m()) {
                o();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final <A extends a.b, T extends c<? extends h, A>> T d(T t10) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void e() {
        this.f8516a.f8769g.clear();
        this.f8528m = false;
        this.f8520e = null;
        this.f8522g = 0;
        this.f8527l = true;
        this.f8529n = false;
        this.f8531p = false;
        HashMap hashMap = new HashMap();
        boolean z10 = false;
        for (a<?> aVar : this.f8534s.keySet()) {
            a.f fVar = this.f8516a.f8768f.get(aVar.a());
            z10 |= aVar.c().b() == 1;
            boolean booleanValue = this.f8534s.get(aVar).booleanValue();
            if (fVar.t()) {
                this.f8528m = true;
                if (booleanValue) {
                    this.f8525j.add(aVar.a());
                } else {
                    this.f8527l = false;
                }
            }
            hashMap.put(fVar, new d0(this, aVar, booleanValue));
        }
        if (z10) {
            this.f8528m = false;
        }
        if (this.f8528m) {
            this.f8533r.m(Integer.valueOf(System.identityHashCode(this.f8516a.f8776n)));
            k0 k0Var = new k0(this, null);
            a.AbstractC0105a<? extends e, a7.a> aVar2 = this.f8535t;
            Context context = this.f8518c;
            Looper o10 = this.f8516a.f8776n.o();
            b6.c cVar = this.f8533r;
            this.f8526k = aVar2.c(context, o10, cVar, cVar.k(), k0Var, k0Var);
        }
        this.f8523h = this.f8516a.f8768f.size();
        this.f8536u.add(z0.a().submit(new e0(this, hashMap)));
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final <A extends a.b, R extends h, T extends c<R, A>> T f(T t10) {
        this.f8516a.f8776n.f8660i.add(t10);
        return t10;
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void onConnected(Bundle bundle) {
        if (x(1)) {
            if (bundle != null) {
                this.f8524i.putAll(bundle);
            }
            if (m()) {
                o();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void onConnectionSuspended(int i10) {
        B(new ConnectionResult(8, null));
    }
}
