package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s2 implements l1 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p2 f8729a;

    private s2(p2 p2Var) {
        this.f8729a = p2Var;
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void a(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        lock = this.f8729a.f8704m;
        lock.lock();
        try {
            this.f8729a.f8702k = connectionResult;
            this.f8729a.B();
        } finally {
            lock2 = this.f8729a.f8704m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void b(Bundle bundle) {
        Lock lock;
        Lock lock2;
        lock = this.f8729a.f8704m;
        lock.lock();
        try {
            this.f8729a.f8702k = ConnectionResult.f8431e;
            this.f8729a.B();
        } finally {
            lock2 = this.f8729a.f8704m;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.l1
    public final void c(int i10, boolean z10) {
        Lock lock;
        Lock lock2;
        boolean z11;
        w0 w0Var;
        lock = this.f8729a.f8704m;
        lock.lock();
        try {
            z11 = this.f8729a.f8703l;
            if (z11) {
                this.f8729a.f8703l = false;
                this.f8729a.m(i10, z10);
                return;
            }
            this.f8729a.f8703l = true;
            w0Var = this.f8729a.f8695d;
            w0Var.onConnectionSuspended(i10);
        } finally {
            lock2 = this.f8729a.f8704m;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s2(p2 p2Var, q2 q2Var) {
        this(p2Var);
    }
}
