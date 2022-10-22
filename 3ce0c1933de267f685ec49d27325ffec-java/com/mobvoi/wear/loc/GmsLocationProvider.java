package com.mobvoi.wear.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.location.LocationRequest;
import com.mobvoi.android.common.utils.k;
import w6.c;
/* loaded from: classes2.dex */
public class GmsLocationProvider extends AdaptiveLocationProvider implements d.b, d.c, c {
    private d mApiClient;
    private Runnable mOnPreparedRunnable;

    public GmsLocationProvider(String str, Context context, long j10, long j11, long j12) {
        super(str, context, j10, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeUpdates$1(Status status) {
        k.c("LocationProvider", "[%s] removeLocationUpdateResult: %s", this.mOwnerTag, status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestUpdates$0(Status status) {
        k.c("LocationProvider", "[%s] requestLocationUpdateResult: %s", this.mOwnerTag, status);
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected boolean clientIsPrepared() {
        return this.mApiClient.p();
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected void destroyClient() {
        this.mOnPreparedRunnable = null;
        this.mApiClient.h();
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    @SuppressLint({"MissingPermission"})
    protected Location getLastLocation() {
        return w6.d.f36008d.a(this.mApiClient);
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    public void init() {
        super.init();
        this.mApiClient = new d.a(this.mContext).a(w6.d.f36007c).c(this).d(this).e();
    }

    @Override // com.google.android.gms.common.api.d.b
    public void onConnected(Bundle bundle) {
        k.c("LocationProvider", "[%s] onConnected", this.mOwnerTag);
        Runnable runnable = this.mOnPreparedRunnable;
        if (runnable != null) {
            runnable.run();
            this.mOnPreparedRunnable = null;
        }
    }

    @Override // com.google.android.gms.common.api.d.c
    public void onConnectionFailed(ConnectionResult connectionResult) {
        k.f("LocationProvider", "[%s] onConnectionFailed: %s", this.mOwnerTag, connectionResult);
    }

    @Override // com.google.android.gms.common.api.d.b
    public void onConnectionSuspended(int i10) {
        k.s("LocationProvider", "[%s] onConnectionSuspended: %d", this.mOwnerTag, Integer.valueOf(i10));
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected void prepareClient(Runnable runnable) {
        this.mOnPreparedRunnable = runnable;
        this.mApiClient.f();
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    protected void removeUpdates() {
        w6.d.f36008d.b(this.mApiClient, this).e(new i() { // from class: com.mobvoi.wear.loc.j
            @Override // com.google.android.gms.common.api.i
            public final void a(h hVar) {
                GmsLocationProvider.this.lambda$removeUpdates$1((Status) hVar);
            }
        });
    }

    @Override // com.mobvoi.wear.loc.AdaptiveLocationProvider
    @SuppressLint({"MissingPermission"})
    protected void requestUpdates() {
        LocationRequest G0 = LocationRequest.G0();
        G0.M0(102);
        G0.K0(this.mUpdateInterval);
        G0.I0(this.mRequestTimeout);
        w6.d.f36008d.c(this.mApiClient, G0, this, Looper.getMainLooper()).e(new i() { // from class: com.mobvoi.wear.loc.i
            @Override // com.google.android.gms.common.api.i
            public final void a(h hVar) {
                GmsLocationProvider.this.lambda$requestUpdates$0((Status) hVar);
            }
        });
    }
}
