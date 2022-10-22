package io.reactivex.internal.operators.observable;

import bo.a;
import bo.b;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.internal.util.c;
import io.reactivex.internal.util.d;
import io.reactivex.internal.util.f;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.LinkedBlockingQueue;
import zn.g;
/* compiled from: ObservableBlockingSubscribe.java */
/* loaded from: classes3.dex */
public final class k {
    public static <T> void a(p<? extends T> pVar) {
        d dVar = new d();
        LambdaObserver lambdaObserver = new LambdaObserver(a.g(), dVar, dVar, a.g());
        pVar.subscribe(lambdaObserver);
        c.a(dVar, lambdaObserver);
        Throwable th2 = dVar.f29255a;
        if (th2 != null) {
            throw f.d(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void b(p<? extends T> pVar, r<? super T> rVar) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        BlockingObserver blockingObserver = new BlockingObserver(linkedBlockingQueue);
        rVar.onSubscribe(blockingObserver);
        pVar.subscribe(blockingObserver);
        while (!blockingObserver.isDisposed()) {
            Object poll = linkedBlockingQueue.poll();
            if (poll == null) {
                try {
                    poll = linkedBlockingQueue.take();
                } catch (InterruptedException e10) {
                    blockingObserver.dispose();
                    rVar.onError(e10);
                    return;
                }
            }
            if (blockingObserver.isDisposed() || pVar == BlockingObserver.TERMINATED || NotificationLite.acceptFull(poll, rVar)) {
                return;
            }
            while (!blockingObserver.isDisposed()) {
            }
        }
    }

    public static <T> void c(p<? extends T> pVar, g<? super T> gVar, g<? super Throwable> gVar2, zn.a aVar) {
        b.e(gVar, "onNext is null");
        b.e(gVar2, "onError is null");
        b.e(aVar, "onComplete is null");
        b(pVar, new LambdaObserver(gVar, gVar2, aVar, a.g()));
    }
}
