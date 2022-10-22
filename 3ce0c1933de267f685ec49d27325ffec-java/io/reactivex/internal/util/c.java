package io.reactivex.internal.util;

import fo.a;
import io.reactivex.internal.schedulers.g;
import java.util.concurrent.CountDownLatch;
import xn.b;
/* compiled from: BlockingHelper.java */
/* loaded from: classes3.dex */
public final class c {
    public static void a(CountDownLatch countDownLatch, b bVar) {
        if (countDownLatch.getCount() != 0) {
            try {
                b();
                countDownLatch.await();
            } catch (InterruptedException e10) {
                bVar.dispose();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e10);
            }
        }
    }

    public static void b() {
        if (!a.j()) {
            return;
        }
        if ((Thread.currentThread() instanceof g) || a.q()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }
}
