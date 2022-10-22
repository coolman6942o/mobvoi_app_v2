package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.d;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
final class p0 implements d.b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f8689a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ n f8690b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ n0 f8691c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(n0 n0Var, AtomicReference atomicReference, n nVar) {
        this.f8691c = n0Var;
        this.f8689a = atomicReference;
        this.f8690b = nVar;
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnected(Bundle bundle) {
        this.f8691c.y((d) this.f8689a.get(), this.f8690b, true);
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnectionSuspended(int i10) {
    }
}
