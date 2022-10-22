package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.u;
import w6.b;
/* loaded from: classes.dex */
final class j extends u {

    /* renamed from: a  reason: collision with root package name */
    private final i<b> f9107a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i<b> iVar) {
        this.f9107a = iVar;
    }

    @Override // com.google.android.gms.location.t
    public final void L0(LocationAvailability locationAvailability) {
        this.f9107a.c(new l(this, locationAvailability));
    }

    public final synchronized void U1() {
        this.f9107a.a();
    }

    @Override // com.google.android.gms.location.t
    public final void q1(LocationResult locationResult) {
        this.f9107a.c(new k(this, locationResult));
    }
}
