package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.k;
/* loaded from: classes.dex */
public final class y implements v0 {

    /* renamed from: a  reason: collision with root package name */
    private final w0 f8791a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8792b = false;

    public y(w0 w0Var) {
        this.f8791a = w0Var;
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final boolean a() {
        if (this.f8792b) {
            return false;
        }
        if (this.f8791a.f8776n.E()) {
            this.f8792b = true;
            for (v1 v1Var : this.f8791a.f8776n.f8675x) {
                v1Var.c();
            }
            return false;
        }
        this.f8791a.q(null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void b() {
        if (this.f8792b) {
            this.f8792b = false;
            this.f8791a.l(new a0(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void c(ConnectionResult connectionResult, a<?> aVar, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final <A extends a.b, T extends c<? extends h, A>> T d(T t10) {
        try {
            this.f8791a.f8776n.f8676y.b(t10);
            n0 n0Var = this.f8791a.f8776n;
            a.f fVar = n0Var.f8667p.get(t10.t());
            i.l(fVar, "Appropriate Api was not requested.");
            if (fVar.isConnected() || !this.f8791a.f8769g.containsKey(t10.t())) {
                boolean z10 = fVar instanceof k;
                a.h hVar = fVar;
                if (z10) {
                    hVar = ((k) fVar).q0();
                }
                t10.v(hVar);
            } else {
                t10.x(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f8791a.l(new z(this, this));
        }
        return t10;
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void e() {
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final <A extends a.b, R extends h, T extends c<R, A>> T f(T t10) {
        return (T) d(t10);
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void onConnectionSuspended(int i10) {
        this.f8791a.q(null);
        this.f8791a.f8777o.c(i10, this.f8792b);
    }
}
