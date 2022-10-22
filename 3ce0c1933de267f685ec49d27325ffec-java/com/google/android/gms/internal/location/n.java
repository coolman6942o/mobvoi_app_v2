package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.location.x;
import w6.c;
/* loaded from: classes.dex */
final class n extends x {

    /* renamed from: a  reason: collision with root package name */
    private final i<c> f9110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(i<c> iVar) {
        this.f9110a = iVar;
    }

    public final synchronized void U1() {
        this.f9110a.a();
    }

    @Override // com.google.android.gms.location.w
    public final synchronized void onLocationChanged(Location location) {
        this.f9110a.c(new o(this, location));
    }
}
