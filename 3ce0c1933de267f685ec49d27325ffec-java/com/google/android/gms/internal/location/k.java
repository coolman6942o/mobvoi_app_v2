package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.location.LocationResult;
import w6.b;
/* loaded from: classes.dex */
final class k implements i.b<b> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LocationResult f9108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, LocationResult locationResult) {
        this.f9108a = locationResult;
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final /* synthetic */ void a(b bVar) {
        bVar.onLocationResult(this.f9108a);
    }

    @Override // com.google.android.gms.common.api.internal.i.b
    public final void b() {
    }
}
