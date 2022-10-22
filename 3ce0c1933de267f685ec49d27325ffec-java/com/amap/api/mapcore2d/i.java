package com.amap.api.mapcore2d;

import android.content.Context;
import java.lang.Thread;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import k4.d;
/* compiled from: SDKLogHandler.java */
/* loaded from: classes.dex */
public class i extends d implements Thread.UncaughtExceptionHandler {

    /* renamed from: d  reason: collision with root package name */
    private static ExecutorService f6995d;

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f6996e = new a();

    /* renamed from: c  reason: collision with root package name */
    private Context f6997c;

    /* compiled from: SDKLogHandler.java */
    /* loaded from: classes.dex */
    static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f6998a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f6998a.getAndIncrement());
        }
    }

    static {
        Collections.synchronizedSet(new HashSet());
    }

    public static synchronized i c() {
        i iVar;
        synchronized (i.class) {
            iVar = (i) d.f29746b;
        }
        return iVar;
    }

    public static synchronized ExecutorService d() {
        ExecutorService executorService;
        synchronized (i.class) {
            try {
                ExecutorService executorService2 = f6995d;
                if (executorService2 == null || executorService2.isShutdown()) {
                    f6995d = Executors.newSingleThreadExecutor(f6996e);
                }
                executorService = f6995d;
            }
        }
        return executorService;
    }

    @Override // k4.d
    protected void a(Throwable th2, int i10, String str, String str2) {
        h.d(this.f6997c, th2, i10, str, str2);
    }

    public void e(Throwable th2, String str, String str2) {
        if (th2 != null) {
            try {
                a(th2, 1, str, str2);
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        if (th2 != null) {
            a(th2, 0, null, null);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f29747a;
            if (uncaughtExceptionHandler != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                } catch (Throwable unused) {
                }
                this.f29747a.uncaughtException(thread, th2);
            }
        }
    }
}
