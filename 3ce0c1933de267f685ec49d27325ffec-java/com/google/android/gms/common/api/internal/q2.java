package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ p2 f8716a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q2(p2 p2Var) {
        this.f8716a = p2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        lock = this.f8716a.f8704m;
        lock.lock();
        try {
            this.f8716a.B();
        } finally {
            lock2 = this.f8716a.f8704m;
            lock2.unlock();
        }
    }
}
