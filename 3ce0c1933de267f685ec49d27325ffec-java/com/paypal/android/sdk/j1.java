package com.paypal.android.sdk;

import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
final class j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ h1 f21386a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j1(h1 h1Var) {
        this.f21386a = h1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        concurrentLinkedQueue = this.f21386a.f21332h;
        ((Runnable) concurrentLinkedQueue.poll()).run();
    }
}
