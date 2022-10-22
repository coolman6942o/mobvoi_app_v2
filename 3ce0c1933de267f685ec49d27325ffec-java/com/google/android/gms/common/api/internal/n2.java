package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
/* loaded from: classes.dex */
public final class n2 implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    public final a<?> f8681a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8682b;

    /* renamed from: c  reason: collision with root package name */
    private o2 f8683c;

    public n2(a<?> aVar, boolean z10) {
        this.f8681a = aVar;
        this.f8682b = z10;
    }

    private final void b() {
        i.l(this.f8683c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public final void a(o2 o2Var) {
        this.f8683c = o2Var;
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnected(Bundle bundle) {
        b();
        this.f8683c.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.d.c
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        b();
        this.f8683c.c(connectionResult, this.f8681a, this.f8682b);
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnectionSuspended(int i10) {
        b();
        this.f8683c.onConnectionSuspended(i10);
    }
}
