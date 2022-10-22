package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.i;
import w6.c;
/* loaded from: classes.dex */
final class o implements i.b<c> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Location f9111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, Location location) {
        this.f9111a = location;
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final /* synthetic */ void a(c cVar) {
        cVar.onLocationChanged(this.f9111a);
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final void b() {
    }
}
