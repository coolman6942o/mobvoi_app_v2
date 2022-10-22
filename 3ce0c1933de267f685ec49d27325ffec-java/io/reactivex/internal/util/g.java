package io.reactivex.internal.util;

import fo.a;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import vp.b;
/* compiled from: HalfSerializer.java */
/* loaded from: classes3.dex */
public final class g {
    public static void a(r<?> rVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                rVar.onError(terminate);
            } else {
                rVar.onComplete();
            }
        }
    }

    public static void b(b<?> bVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                bVar.onError(terminate);
            } else {
                bVar.onComplete();
            }
        }
    }

    public static void c(r<?> rVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th2)) {
            a.s(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            rVar.onError(atomicThrowable.terminate());
        }
    }

    public static void d(b<?> bVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.addThrowable(th2)) {
            a.s(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            bVar.onError(atomicThrowable.terminate());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void e(r<? super T> rVar, T t10, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            rVar.onNext(t10);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    rVar.onError(terminate);
                } else {
                    rVar.onComplete();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(b<? super T> bVar, T t10, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(t10);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    bVar.onError(terminate);
                } else {
                    bVar.onComplete();
                }
            }
        }
    }
}
