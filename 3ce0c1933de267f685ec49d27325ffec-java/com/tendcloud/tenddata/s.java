package com.tendcloud.tenddata;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadPoolExecutor f22998a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f22999b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f23000c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f23001d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f23002e = 30;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f23003f;

    /* renamed from: g  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f23004g;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f22999b = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f23000c = max;
        int i10 = (availableProcessors * 2) + 1;
        f23001d = i10;
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.tendcloud.tenddata.s.1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ThreadPoolUtils #" + this.mCount.getAndIncrement());
            }
        };
        f23003f = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f23004g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i10, 30L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f22998a = threadPoolExecutor;
    }
}
