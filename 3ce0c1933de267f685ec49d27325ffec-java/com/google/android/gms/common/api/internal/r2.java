package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r2 implements l1 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p2 f8720a;

    private r2(p2 p2Var) {
        this.f8720a = p2Var;
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void a(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.f8720a.f8704m;
        lock.lock();
        try {
            this.f8720a.f8701j = connectionResult;
            this.f8720a.B();
        } finally {
            lock2 = this.f8720a.f8704m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void b(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.f8720a.f8704m;
        lock.lock();
        try {
            this.f8720a.n(bundle);
            this.f8720a.f8701j = ConnectionResult.f8431e;
            this.f8720a.B();
        } finally {
            lock2 = this.f8720a.f8704m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void c(int i10, boolean z10) {
        Lock lock;
        Lock lock2;
        boolean z11;
        ConnectionResult connectionResult;
        ConnectionResult connectionResult2;
        w0 w0Var;
        lock = this.f8720a.f8704m;
        lock.lock();
        try {
            z11 = this.f8720a.f8703l;
            if (!z11) {
                connectionResult = this.f8720a.f8702k;
                if (connectionResult != null) {
                    connectionResult2 = this.f8720a.f8702k;
                    if (connectionResult2.K0()) {
                        this.f8720a.f8703l = true;
                        w0Var = this.f8720a.f8696e;
                        w0Var.onConnectionSuspended(i10);
                        return;
                    }
                }
            }
            this.f8720a.f8703l = false;
            this.f8720a.m(i10, z10);
        } finally {
            lock2 = this.f8720a.f8704m;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r2(p2 p2Var, q2 q2Var) {
        this(p2Var);
    }
}
