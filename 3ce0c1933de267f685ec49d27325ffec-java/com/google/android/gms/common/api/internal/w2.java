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
public final class w2 implements b<Map<f2<?>, String>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ u2 f8783a;

    private w2(u2 u2Var) {
        this.f8783a = u2Var;
    }

    @Override // b7.b
    public final void a(com.google.android.gms.tasks.b<Map<f2<?>, String>> bVar) {
        Lock lock;
        Lock lock2;
        boolean z10;
        Map map;
        ConnectionResult connectionResult;
        Condition condition;
        n0 n0Var;
        ConnectionResult connectionResult2;
        Map map2;
        Map map3;
        ConnectionResult u10;
        boolean z11;
        ConnectionResult u11;
        Map map4;
        Map map5;
        boolean o10;
        Map map6;
        Map map7;
        Map map8;
        Map map9;
        Map map10;
        lock = this.f8783a.f8745f;
        lock.lock();
        try {
            z10 = this.f8783a.f8753n;
            if (z10) {
                if (bVar.o()) {
                    u2 u2Var = this.f8783a;
                    map8 = u2Var.f8740a;
                    u2Var.f8754o = new a(map8.size());
                    map9 = this.f8783a.f8740a;
                    for (t2 t2Var : map9.values()) {
                        map10 = this.f8783a.f8754o;
                        map10.put(t2Var.o(), ConnectionResult.f8431e);
                    }
                } else if (bVar.j() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) bVar.j();
                    z11 = this.f8783a.f8751l;
                    if (z11) {
                        u2 u2Var2 = this.f8783a;
                        map4 = u2Var2.f8740a;
                        u2Var2.f8754o = new a(map4.size());
                        map5 = this.f8783a.f8740a;
                        for (t2 t2Var2 : map5.values()) {
                            Object o11 = t2Var2.o();
                            ConnectionResult connectionResult3 = availabilityException.getConnectionResult(t2Var2);
                            o10 = this.f8783a.o(t2Var2, connectionResult3);
                            if (o10) {
                                map6 = this.f8783a.f8754o;
                                map6.put(o11, new ConnectionResult(16));
                            } else {
                                map7 = this.f8783a.f8754o;
                                map7.put(o11, connectionResult3);
                            }
                        }
                    } else {
                        this.f8783a.f8754o = availabilityException.zaj();
                    }
                    u2 u2Var3 = this.f8783a;
                    u11 = u2Var3.u();
                    u2Var3.f8757r = u11;
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", bVar.j());
                    this.f8783a.f8754o = Collections.emptyMap();
                    this.f8783a.f8757r = new ConnectionResult(8);
                }
                map = this.f8783a.f8755p;
                if (map != null) {
                    map2 = this.f8783a.f8754o;
                    map3 = this.f8783a.f8755p;
                    map2.putAll(map3);
                    u2 u2Var4 = this.f8783a;
                    u10 = u2Var4.u();
                    u2Var4.f8757r = u10;
                }
                connectionResult = this.f8783a.f8757r;
                if (connectionResult == null) {
                    this.f8783a.s();
                    this.f8783a.t();
                } else {
                    this.f8783a.f8753n = false;
                    n0Var = this.f8783a.f8744e;
                    connectionResult2 = this.f8783a.f8757r;
                    n0Var.a(connectionResult2);
                }
                condition = this.f8783a.f8748i;
                condition.signalAll();
            }
        } finally {
            lock2 = this.f8783a.f8745f;
            lock2.unlock();
        }
    }
}
