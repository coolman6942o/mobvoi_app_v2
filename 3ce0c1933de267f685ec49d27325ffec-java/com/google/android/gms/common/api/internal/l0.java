package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;
/* loaded from: classes.dex */
abstract class l0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b0 f8648a;

    private l0(b0 b0Var) {
        this.f8648a = b0Var;
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        Lock lock;
        w0 w0Var;
        Lock lock2;
        lock = this.f8648a.f8517b;
        lock.lock();
        try {
            if (!Thread.interrupted()) {
                a();
            }
        } catch (RuntimeException e10) {
            w0Var = this.f8648a.f8516a;
            w0Var.o(e10);
        } finally {
            lock2 = this.f8648a.f8517b;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l0(b0 b0Var, c0 c0Var) {
        this(b0Var);
    }
}
