package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final int f13652a;

    /* renamed from: b  reason: collision with root package name */
    static final int f13653b;

    /* renamed from: c  reason: collision with root package name */
    private static final a f13654c = new a();

    /* renamed from: e  reason: collision with root package name */
    private static final int f13655e;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f13656d = new ExecutorC0177a((byte) 0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class ExecutorC0177a implements Executor {
        private ExecutorC0177a() {
        }

        /* synthetic */ ExecutorC0177a(byte b10) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f13655e = availableProcessors;
        f13652a = availableProcessors + 1;
        f13653b = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f13652a, f13653b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f13654c.f13656d;
    }
}
