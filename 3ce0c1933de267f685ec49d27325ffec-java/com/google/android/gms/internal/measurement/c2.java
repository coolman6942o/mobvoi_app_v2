package com.google.android.gms.internal.measurement;

import android.os.Process;
import b6.i;
import com.tendcloud.tenddata.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c2 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Object f9191a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<b2<?>> f9192b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ z1 f9193c;

    public c2(z1 z1Var, String str, BlockingQueue<b2<?>> blockingQueue) {
        this.f9193c = z1Var;
        i.k(str);
        i.k(blockingQueue);
        this.f9192b = blockingQueue;
        setName(str);
    }

    private final void a(InterruptedException interruptedException) {
        this.f9193c.c().N().d(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void b() {
        synchronized (this.f9191a) {
            this.f9191a.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Object obj;
        Semaphore semaphore;
        Object obj2;
        c2 c2Var;
        c2 c2Var2;
        Object obj3;
        Object obj4;
        Semaphore semaphore2;
        Object obj5;
        c2 c2Var3;
        c2 c2Var4;
        boolean z10;
        Semaphore semaphore3;
        boolean z11 = false;
        while (!z11) {
            try {
                semaphore3 = this.f9193c.f9846k;
                semaphore3.acquire();
                z11 = true;
            } catch (InterruptedException e10) {
                a(e10);
            }
        }
        try {
            int i10 = Process.getThreadPriority(Process.myTid());
            while (true) {
                b2<?> poll = this.f9192b.poll();
                if (poll == null) {
                    synchronized (this.f9191a) {
                        if (this.f9192b.peek() == null) {
                            z10 = this.f9193c.f9847l;
                            if (!z10) {
                                try {
                                    this.f9191a.wait(ab.Y);
                                } catch (InterruptedException e11) {
                                    a(e11);
                                }
                            }
                        }
                    }
                    obj3 = this.f9193c.f9845j;
                    synchronized (obj3) {
                        if (this.f9192b.peek() == null) {
                            break;
                        }
                    }
                } else {
                    if (!poll.f9178b) {
                        i10 = 10;
                    }
                    Process.setThreadPriority(i10);
                    poll.run();
                }
            }
            obj4 = this.f9193c.f9845j;
            synchronized (obj4) {
                semaphore2 = this.f9193c.f9846k;
                semaphore2.release();
                obj5 = this.f9193c.f9845j;
                obj5.notifyAll();
                c2Var3 = this.f9193c.f9839d;
                if (this == c2Var3) {
                    this.f9193c.f9839d = null;
                } else {
                    c2Var4 = this.f9193c.f9840e;
                    if (this == c2Var4) {
                        this.f9193c.f9840e = null;
                    } else {
                        this.f9193c.c().K().a("Current scheduler thread is neither worker nor network");
                    }
                }
            }
        } catch (Throwable th2) {
            obj = this.f9193c.f9845j;
            synchronized (obj) {
                semaphore = this.f9193c.f9846k;
                semaphore.release();
                obj2 = this.f9193c.f9845j;
                obj2.notifyAll();
                c2Var = this.f9193c.f9839d;
                if (this != c2Var) {
                    c2Var2 = this.f9193c.f9840e;
                    if (this == c2Var2) {
                        this.f9193c.f9840e = null;
                    } else {
                        this.f9193c.c().K().a("Current scheduler thread is neither worker nor network");
                    }
                } else {
                    this.f9193c.f9839d = null;
                }
                throw th2;
            }
        }
    }
}
