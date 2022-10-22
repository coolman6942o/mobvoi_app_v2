package com.paypal.android.sdk;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class w1 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22042a;

    /* renamed from: b  reason: collision with root package name */
    private static int f22043b;

    /* renamed from: c  reason: collision with root package name */
    private static int f22044c;

    static {
        new w1();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f22042a = availableProcessors;
        f22043b = availableProcessors + 1;
        f22044c = (availableProcessors << 1) + 1;
    }

    private w1() {
        new z1((byte) 0);
    }

    public static ThreadPoolExecutor a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f22043b, f22044c, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
