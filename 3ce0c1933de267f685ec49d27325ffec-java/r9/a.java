package r9;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: FileDownloadExecutors.java */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileDownloadExecutors.java */
    /* renamed from: r9.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class ThreadFactoryC0459a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f33465a;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f33467c = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        private final ThreadGroup f33466b = Thread.currentThread().getThreadGroup();

        static {
            new AtomicInteger(1);
        }

        ThreadFactoryC0459a(String str) {
            this.f33465a = e.A(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f33466b;
            Thread thread = new Thread(threadGroup, runnable, this.f33465a + this.f33467c.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static ThreadPoolExecutor a(int i10, String str) {
        return b(i10, new LinkedBlockingQueue(), str);
    }

    public static ThreadPoolExecutor b(int i10, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new ThreadFactoryC0459a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor c(String str) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryC0459a(str));
    }
}
