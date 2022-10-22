package com.google.android.gms.common.api.internal;

import android.os.Looper;
import b6.i;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
final class d0 implements b.c {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<b0> f8545a;

    /* renamed from: b  reason: collision with root package name */
    private final a<?> f8546b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8547c;

    public d0(b0 b0Var, a<?> aVar, boolean z10) {
        this.f8545a = new WeakReference<>(b0Var);
        this.f8546b = aVar;
        this.f8547c = z10;
    }

    @Override // com.google.android.gms.common.internal.b.c
    public final void a(ConnectionResult connectionResult) {
        w0 w0Var;
        Lock lock;
        Lock lock2;
        boolean x10;
        boolean m10;
        b0 b0Var = this.f8545a.get();
        if (b0Var != null) {
            Looper myLooper = Looper.myLooper();
            w0Var = b0Var.f8516a;
            i.o(myLooper == w0Var.f8776n.o(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            lock = b0Var.f8517b;
            lock.lock();
            try {
                x10 = b0Var.x(0);
                if (x10) {
                    if (!connectionResult.K0()) {
                        b0Var.t(connectionResult, this.f8546b, this.f8547c);
                    }
                    m10 = b0Var.m();
                    if (m10) {
                        b0Var.n();
                    }
                }
            } finally {
                lock2 = b0Var.f8517b;
                lock2.unlock();
            }
        }
    }
}
