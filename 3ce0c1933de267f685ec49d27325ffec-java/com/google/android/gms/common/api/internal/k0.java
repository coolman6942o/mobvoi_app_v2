package com.google.android.gms.common.api.internal;

import a7.e;
import android.os.Bundle;
import b6.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
final class k0 implements d.b, d.c {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b0 f8645a;

    private k0(b0 b0Var) {
        this.f8645a = b0Var;
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnected(Bundle bundle) {
        c cVar;
        e eVar;
        Lock lock;
        Lock lock2;
        e eVar2;
        e eVar3;
        cVar = this.f8645a.f8533r;
        if (cVar.l()) {
            lock = this.f8645a.f8517b;
            lock.lock();
            try {
                eVar2 = this.f8645a.f8526k;
                if (eVar2 != null) {
                    eVar3 = this.f8645a.f8526k;
                    eVar3.q(new i0(this.f8645a));
                }
            } finally {
                lock2 = this.f8645a.f8517b;
                lock2.unlock();
            }
        } else {
            eVar = this.f8645a.f8526k;
            eVar.q(new i0(this.f8645a));
        }
    }

    @Override // com.google.android.gms.common.api.d.c
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        boolean A;
        lock = this.f8645a.f8517b;
        lock.lock();
        try {
            A = this.f8645a.A(connectionResult);
            if (A) {
                this.f8645a.p();
                this.f8645a.n();
            } else {
                this.f8645a.B(connectionResult);
            }
        } finally {
            lock2 = this.f8645a.f8517b;
            lock2.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.d.b
    public final void onConnectionSuspended(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k0(b0 b0Var, c0 c0Var) {
        this(b0Var);
    }
}
