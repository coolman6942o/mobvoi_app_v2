package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class x0 {

    /* renamed from: a  reason: collision with root package name */
    private final v0 f8785a;

    /* JADX INFO: Access modifiers changed from: protected */
    public x0(v0 v0Var) {
        this.f8785a = v0Var;
    }

    protected abstract void a();

    public final void b(w0 w0Var) {
        Lock lock;
        Lock lock2;
        v0 v0Var;
        lock = w0Var.f8763a;
        lock.lock();
        try {
            v0Var = w0Var.f8773k;
            if (v0Var == this.f8785a) {
                a();
            }
        } finally {
            lock2 = w0Var.f8763a;
            lock2.unlock();
        }
    }
}
