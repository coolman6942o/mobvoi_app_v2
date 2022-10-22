package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.collection.a;
import b7.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements b<Map<f2<?>, String>> {

    /* renamed from: a  reason: collision with root package name */
    private l f8717a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ u2 f8718b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(u2 u2Var, l lVar) {
        this.f8718b = u2Var;
        this.f8717a = lVar;
    }

    @Override // b7.b
    public final void a(com.google.android.gms.tasks.b<Map<f2<?>, String>> bVar) {
        Lock lock;
        Lock lock2;
        boolean z10;
        Map map;
        Map map2;
        ConnectionResult u10;
        Condition condition;
        boolean z11;
        Map map3;
        Map map4;
        boolean o10;
        Map map5;
        Map map6;
        Map map7;
        Map map8;
        Map map9;
        lock = this.f8718b.f8745f;
        lock.lock();
        try {
            z10 = this.f8718b.f8753n;
            if (!z10) {
                this.f8717a.onComplete();
                return;
            }
            if (bVar.o()) {
                u2 u2Var = this.f8718b;
                map7 = u2Var.f8741b;
                u2Var.f8755p = new a(map7.size());
                map8 = this.f8718b.f8741b;
                for (t2 t2Var : map8.values()) {
                    map9 = this.f8718b.f8755p;
                    map9.put(t2Var.o(), ConnectionResult.f8431e);
                }
            } else if (bVar.j() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) bVar.j();
                z11 = this.f8718b.f8751l;
                if (z11) {
                    u2 u2Var2 = this.f8718b;
                    map3 = u2Var2.f8741b;
                    u2Var2.f8755p = new a(map3.size());
                    map4 = this.f8718b.f8741b;
                    for (t2 t2Var2 : map4.values()) {
                        Object o11 = t2Var2.o();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(t2Var2);
                        o10 = this.f8718b.o(t2Var2, connectionResult);
                        if (o10) {
                            map5 = this.f8718b.f8755p;
                            map5.put(o11, new ConnectionResult(16));
                        } else {
                            map6 = this.f8718b.f8755p;
                            map6.put(o11, connectionResult);
                        }
                    }
                } else {
                    this.f8718b.f8755p = availabilityException.zaj();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", bVar.j());
                this.f8718b.f8755p = Collections.emptyMap();
            }
            if (this.f8718b.isConnected()) {
                map = this.f8718b.f8754o;
                map2 = this.f8718b.f8755p;
                map.putAll(map2);
                u10 = this.f8718b.u();
                if (u10 == null) {
                    this.f8718b.s();
                    this.f8718b.t();
                    condition = this.f8718b.f8748i;
                    condition.signalAll();
                }
            }
            this.f8717a.onComplete();
        } finally {
            lock2 = this.f8718b.f8745f;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        this.f8717a.onComplete();
    }
}
