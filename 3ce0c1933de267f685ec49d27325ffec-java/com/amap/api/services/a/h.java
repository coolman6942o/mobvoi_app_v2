package com.amap.api.services.a;

import android.content.Context;
import java.lang.Thread;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import n4.c;
/* compiled from: SDKLogHandler.java */
/* loaded from: classes.dex */
public class h extends c implements Thread.UncaughtExceptionHandler {

    /* renamed from: d  reason: collision with root package name */
    private static ExecutorService f7199d;

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f7200e = new a();

    /* renamed from: c  reason: collision with root package name */
    private Context f7201c;

    /* compiled from: SDKLogHandler.java */
    /* loaded from: classes.dex */
    static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f7202a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f7202a.getAndIncrement());
        }
    }

    static {
        Collections.synchronizedSet(new HashSet());
    }

    public static synchronized h c() {
        h hVar;
        synchronized (h.class) {
            hVar = (h) c.f31013b;
        }
        return hVar;
    }

    public static synchronized ExecutorService d() {
        ExecutorService executorService;
        synchronized (h.class) {
            try {
                ExecutorService executorService2 = f7199d;
                if (executorService2 == null || executorService2.isShutdown()) {
                    f7199d = Executors.newSingleThreadExecutor(f7200e);
                }
                executorService = f7199d;
            }
        }
        return executorService;
    }

    @Override // n4.c
    protected void a(Throwable th2, int i10, String str, String str2) {
        g.d(this.f7201c, th2, i10, str, str2);
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
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f31014a;
            if (uncaughtExceptionHandler != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
                } catch (Throwable unused) {
                }
                this.f31014a.uncaughtException(thread, th2);
            }
        }
    }
}
