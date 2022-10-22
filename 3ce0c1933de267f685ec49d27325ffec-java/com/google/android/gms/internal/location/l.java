package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.location.LocationAvailability;
import w6.b;
/* loaded from: classes.dex */
final class l implements i.b<b> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LocationAvailability f9109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, LocationAvailability locationAvailability) {
        this.f9109a = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final /* synthetic */ void a(b bVar) {
        bVar.onLocationAvailability(this.f9109a);
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final void b() {
    }
}
