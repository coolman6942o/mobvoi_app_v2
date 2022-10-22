package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.e;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes.dex */
final class g1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f8609a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ e.c f8610b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(e.c cVar, ConnectionResult connectionResult) {
        this.f8610b = cVar;
        this.f8609a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f2 f2Var;
        a.f fVar;
        f2 f2Var2;
        a.f fVar2;
        if (this.f8609a.K0()) {
            this.f8610b.f8589e = true;
            fVar = this.f8610b.f8585a;
            if (fVar.t()) {
                this.f8610b.g();
                return;
            }
            try {
                fVar2 = this.f8610b.f8585a;
                fVar2.g(null, Collections.emptySet());
            } catch (SecurityException e10) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e10);
                Map map = e.this.f8565i;
                f2Var2 = this.f8610b.f8586b;
                ((e.a) map.get(f2Var2)).onConnectionFailed(new ConnectionResult(10));
            }
        } else {
            Map map2 = e.this.f8565i;
            f2Var = this.f8610b.f8586b;
            ((e.a) map2.get(f2Var)).onConnectionFailed(this.f8609a);
        }
    }
}
