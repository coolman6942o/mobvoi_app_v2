package com.huawei.hianalytics.mn.no.a.op;

import com.mobvoi.wear.util.LogCleaner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class no {

    /* renamed from: mn  reason: collision with root package name */
    private ThreadPoolExecutor f13528mn = new ThreadPoolExecutor(0, 1, LogCleaner.ONE_MINUTE, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000));
    private static no qr = new no();
    private static no pq = new no();

    /* renamed from: no  reason: collision with root package name */
    private static no f13526no = new no();

    /* renamed from: op  reason: collision with root package name */
    private static no f13527op = new no();

    /* loaded from: classes.dex */
    static class mn implements Runnable {

        /* renamed from: mn  reason: collision with root package name */
        private Runnable f13529mn;

        public mn(Runnable runnable) {
            this.f13529mn = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f13529mn;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    com.huawei.hianalytics.mn.no.qr.mn.op("TaskThread", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    private no() {
    }

    public static no mn() {
        return f13526no;
    }

    public static no no() {
        return f13527op;
    }

    public void mn(com.huawei.hianalytics.mn.no.a.op.mn mnVar) {
        try {
            this.f13528mn.execute(new mn(mnVar));
        } catch (RejectedExecutionException unused) {
            com.huawei.hianalytics.mn.no.qr.mn.op("TaskThread", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
