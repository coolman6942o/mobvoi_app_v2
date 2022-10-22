package com.mobvoi.wear.loc;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.a;
import com.mobvoi.android.common.utils.k;
import io.m;
import kotlin.jvm.internal.i;
import w6.b;
import w6.c;
/* compiled from: GmsLocationClient.kt */
/* loaded from: classes2.dex */
public final class GmsLocationClient extends AdaptiveLocationProvider implements d.b, d.c, c {
    public a fusedClient;
    private Location lastLoc;
    private final GmsLocationClient$mLocationCallback$1 mLocationCallback = new b() { // from class: com.mobvoi.wear.loc.GmsLocationClient$mLocationCallback$1
        @Override // w6.b
        public void onLocationResult(LocationResult locationResult) {
            i.f(locationResult, "locationResult");
            k.c("LocationProvider", "[%s] ==W== mLocationCallback: lastLocation==> %s , timestamp: %s", GmsLocationClient.this.mOwnerTag, locationResult.G0(), com.mobvoi.android.common.utils.d.a(locationResult.G0().getTime()));
            for (Location location : locationResult.H0()) {
                k.c("LocationProvider", "[%s] locationResult:==> %s , timestamp: %s", GmsLocationClient.this.mOwnerTag, location, com.mobvoi.android.common.utils.d.a(location.getTime()));
                GmsLocationClient.this.onLocationChanged(location);
            }
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.mobvoi.wear.loc.GmsLocationClient$mLocationCallback$1] */
    public GmsLocationClient(String ownerTag, Context context, long j10, long j11, long j12) {
        super(ownerTag, context, j10, j11, j12);
        i.f(ownerTag, "ownerTag");
        i.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLastLocation$lambda-1  reason: not valid java name */
    public static final void m17getLastLocation$lambda1(GmsLocationClient this$0, Location location) {
        i.f(this$0, "this$0");
        if (location == null) {
            location = null;
        } else {
            k.c("LocationProvider", "[%s] fused OnSuccess last:==> %s , timestamp: %s", this$0.mOwnerTag, location, com.mobvoi.android.common.utils.d.a(location.getTime()));
            m mVar = m.f28349a;
        }
        this$0.lastLoc = location;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestUpdates$lambda-3  reason: not valid java name */
    public static final void m18requestUpdates$lambda3(GmsLocationClient this$0, Void r32) {
        i.f(this$0, "this$0");
        k.c("LocationProvider", "[%s] fusedClient OnSuccessListener: Task ==> %s", this$0.mOwnerTag, r32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestUpdates$lambda-4  reason: not valid java name */
    public static final void m19requestUpdates$lambda4(GmsLocationClient this$0, Exception it) {
        i.f(this$0, "this$0");
        i.f(it, "it");
        k.c("LocationProvider", "[%s] fusedClient FailureListener: Exception ==> %s", this$0.mOwnerTag, it.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestUpdates$lambda-5  reason: not valid java name */
    public static final void m20requestUpdates$lambda5(GmsLocationClient this$0, com.google.android.gms.tasks.b it) {
        i.f(this$0, "this$0");
        i.f(it, "it");
        k.c("LocationProvider", "[%s] fusedClient Complete: Task ==> %s", this$0.mOwnerTag, it);
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected boolean clientIsPrepared() {
        return true;
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected void destroyClient() {
    }

    public final a getFusedClient() {
        a aVar = this.fusedClient;
        if (aVar != null) {
            return aVar;
        }
        i.u("fusedClient");
        throw null;
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected Location getLastLocation() {
        getFusedClient().p().f(new b7.d() { // from class: com.mobvoi.wear.loc.g
            @Override // b7.d
            public final void onSuccess(Object obj) {
                GmsLocationClient.m17getLastLocation$lambda1(GmsLocationClient.this, (Location) obj);
            }
        });
        return this.lastLoc;
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    public void init() {
        super.init();
        a a10 = w6.d.a(this.mContext);
        i.e(a10, "getFusedLocationProviderClient(mContext)");
        setFusedClient(a10);
    }

    @Override // com.google.android.gms.common.api.d.b
    public void onConnected(Bundle bundle) {
        k.c("LocationProvider", "[%s] onConnected", this.mOwnerTag);
    }

    @Override // com.google.android.gms.common.api.d.c
    public void onConnectionFailed(ConnectionResult p02) {
        i.f(p02, "p0");
        k.f("LocationProvider", "[%s] onConnectionFailed: %s", this.mOwnerTag, p02);
    }

    @Override // com.google.android.gms.common.api.d.b
    public void onConnectionSuspended(int i10) {
        k.s("LocationProvider", "[%s] onConnectionSuspended: %d", this.mOwnerTag, Integer.valueOf(i10));
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected void prepareClient(Runnable runnable) {
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected void removeUpdates() {
        k.c("LocationProvider", "[%s] removeUpdates =====！！！！", this.mOwnerTag);
        getFusedClient().q(this.mLocationCallback);
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected void requestUpdates() {
        LocationRequest G0 = LocationRequest.G0();
        G0.K0(this.mUpdateInterval);
        G0.L0(this.mRequestTimeout);
        G0.M0(100);
        try {
            getFusedClient().r(G0, this.mLocationCallback, null).f(new b7.d() { // from class: com.mobvoi.wear.loc.h
                @Override // b7.d
                public final void onSuccess(Object obj) {
                    GmsLocationClient.m18requestUpdates$lambda3(GmsLocationClient.this, (Void) obj);
                }
            }).d(new b7.c() { // from class: com.mobvoi.wear.loc.f
                @Override // b7.c
                public final void onFailure(Exception exc) {
                    GmsLocationClient.m19requestUpdates$lambda4(GmsLocationClient.this, exc);
                }
            }).b(new b7.b() { // from class: com.mobvoi.wear.loc.e
                @Override // b7.b
                public final void a(com.google.android.gms.tasks.b bVar) {
                    GmsLocationClient.m20requestUpdates$lambda5(GmsLocationClient.this, bVar);
                }
            });
        } catch (SecurityException e10) {
            k.r("LocationProvider", "Can not request location, permission denied!", e10, new Object[0]);
        }
    }

    public final void setFusedClient(a aVar) {
        i.f(aVar, "<set-?>");
        this.fusedClient = aVar;
    }
}
