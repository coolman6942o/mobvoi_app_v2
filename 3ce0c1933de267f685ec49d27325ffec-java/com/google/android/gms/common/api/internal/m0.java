package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import java.util.Collections;
/* loaded from: classes.dex */
public final class m0 implements v0 {

    /* renamed from: a  reason: collision with root package name */
    private final w0 f8651a;

    public m0(w0 w0Var) {
        this.f8651a = w0Var;
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final boolean a() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void b() {
        this.f8651a.m();
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void c(ConnectionResult connectionResult, a<?> aVar, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final <A extends a.b, T extends c<? extends h, A>> T d(T t10) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void e() {
        for (a.f fVar : this.f8651a.f8768f.values()) {
            fVar.a();
        }
        this.f8651a.f8776n.f8668q = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final <A extends a.b, R extends h, T extends c<R, A>> T f(T t10) {
        this.f8651a.f8776n.f8660i.add(t10);
        return t10;
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.v0
    public final void onConnectionSuspended(int i10) {
    }
}
