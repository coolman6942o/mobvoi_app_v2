package okhttp3;

import gp.b;
import io.m;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.i;
import okhttp3.internal.connection.e;
/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: c  reason: collision with root package name */
    private Runnable f32256c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f32257d;

    /* renamed from: a  reason: collision with root package name */
    private int f32254a = 64;

    /* renamed from: b  reason: collision with root package name */
    private int f32255b = 5;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayDeque<e.a> f32258e = new ArrayDeque<>();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<e.a> f32259f = new ArrayDeque<>();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<e> f32260g = new ArrayDeque<>();

    private final e.a e(String str) {
        Iterator<e.a> it = this.f32259f.iterator();
        while (it.hasNext()) {
            e.a next = it.next();
            if (i.b(next.d(), str)) {
                return next;
            }
        }
        Iterator<e.a> it2 = this.f32258e.iterator();
        while (it2.hasNext()) {
            e.a next2 = it2.next();
            if (i.b(next2.d(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void f(Deque<T> deque, T t10) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t10)) {
                runnable = this.f32256c;
                m mVar = m.f28349a;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!i() && runnable != null) {
            runnable.run();
        }
    }

    private final boolean i() {
        int i10;
        boolean z10;
        if (!b.f27632h || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<e.a> it = this.f32258e.iterator();
                i.e(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    e.a asyncCall = it.next();
                    if (this.f32259f.size() >= this.f32254a) {
                        break;
                    } else if (asyncCall.c().get() < this.f32255b) {
                        it.remove();
                        asyncCall.c().incrementAndGet();
                        i.e(asyncCall, "asyncCall");
                        arrayList.add(asyncCall);
                        this.f32259f.add(asyncCall);
                    }
                }
                z10 = j() > 0;
                m mVar = m.f28349a;
            }
            int size = arrayList.size();
            for (i10 = 0; i10 < size; i10++) {
                ((e.a) arrayList.get(i10)).a(d());
            }
            return z10;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public final synchronized void a() {
        Iterator<e.a> it = this.f32258e.iterator();
        while (it.hasNext()) {
            it.next().b().cancel();
        }
        Iterator<e.a> it2 = this.f32259f.iterator();
        while (it2.hasNext()) {
            it2.next().b().cancel();
        }
        Iterator<e> it3 = this.f32260g.iterator();
        while (it3.hasNext()) {
            it3.next().cancel();
        }
    }

    public final void b(e.a call) {
        e.a e10;
        i.f(call, "call");
        synchronized (this) {
            this.f32258e.add(call);
            if (!call.b().n() && (e10 = e(call.d())) != null) {
                call.e(e10);
            }
            m mVar = m.f28349a;
        }
        i();
    }

    public final synchronized void c(e call) {
        i.f(call, "call");
        this.f32260g.add(call);
    }

    public final synchronized ExecutorService d() {
        ExecutorService executorService;
        if (this.f32257d == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            this.f32257d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, b.J(b.f27633i + " Dispatcher", false));
        }
        executorService = this.f32257d;
        i.d(executorService);
        return executorService;
    }

    public final void g(e.a call) {
        i.f(call, "call");
        call.c().decrementAndGet();
        f(this.f32259f, call);
    }

    public final void h(e call) {
        i.f(call, "call");
        f(this.f32260g, call);
    }

    public final synchronized int j() {
        return this.f32259f.size() + this.f32260g.size();
    }
}
