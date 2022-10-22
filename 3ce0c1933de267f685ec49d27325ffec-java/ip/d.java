package ip;

import gp.b;
import io.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.jvm.internal.i;
/* compiled from: TaskQueue.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f29312a;

    /* renamed from: b  reason: collision with root package name */
    private a f29313b;

    /* renamed from: c  reason: collision with root package name */
    private final List<a> f29314c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f29315d;

    /* renamed from: e  reason: collision with root package name */
    private final e f29316e;

    /* renamed from: f  reason: collision with root package name */
    private final String f29317f;

    public d(e taskRunner, String name) {
        i.f(taskRunner, "taskRunner");
        i.f(name, "name");
        this.f29316e = taskRunner;
        this.f29317f = name;
    }

    public static /* synthetic */ void j(d dVar, a aVar, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        dVar.i(aVar, j10);
    }

    public final void a() {
        if (!b.f27632h || !Thread.holdsLock(this)) {
            synchronized (this.f29316e) {
                if (b()) {
                    this.f29316e.h(this);
                }
                m mVar = m.f28349a;
            }
            return;
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

    public final boolean b() {
        a aVar = this.f29313b;
        if (aVar != null) {
            i.d(aVar);
            if (aVar.a()) {
                this.f29315d = true;
            }
        }
        boolean z10 = false;
        for (int size = this.f29314c.size() - 1; size >= 0; size--) {
            if (this.f29314c.get(size).a()) {
                a aVar2 = this.f29314c.get(size);
                if (e.f29320j.a().isLoggable(Level.FINE)) {
                    b.a(aVar2, this, "canceled");
                }
                this.f29314c.remove(size);
                z10 = true;
            }
        }
        return z10;
    }

    public final a c() {
        return this.f29313b;
    }

    public final boolean d() {
        return this.f29315d;
    }

    public final List<a> e() {
        return this.f29314c;
    }

    public final String f() {
        return this.f29317f;
    }

    public final boolean g() {
        return this.f29312a;
    }

    public final e h() {
        return this.f29316e;
    }

    public final void i(a task, long j10) {
        i.f(task, "task");
        synchronized (this.f29316e) {
            if (!this.f29312a) {
                if (k(task, j10, false)) {
                    this.f29316e.h(this);
                }
                m mVar = m.f28349a;
            } else if (task.a()) {
                if (e.f29320j.a().isLoggable(Level.FINE)) {
                    b.a(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (e.f29320j.a().isLoggable(Level.FINE)) {
                    b.a(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean k(a task, long j10, boolean z10) {
        String str;
        i.f(task, "task");
        task.e(this);
        long a10 = this.f29316e.g().a();
        long j11 = a10 + j10;
        int indexOf = this.f29314c.indexOf(task);
        if (indexOf != -1) {
            if (task.c() <= j11) {
                if (e.f29320j.a().isLoggable(Level.FINE)) {
                    b.a(task, this, "already scheduled");
                }
                return false;
            }
            this.f29314c.remove(indexOf);
        }
        task.g(j11);
        if (e.f29320j.a().isLoggable(Level.FINE)) {
            if (z10) {
                str = "run again after " + b.b(j11 - a10);
            } else {
                str = "scheduled after " + b.b(j11 - a10);
            }
            b.a(task, this, str);
        }
        Iterator<a> it = this.f29314c.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            if (it.next().c() - a10 > j10) {
                break;
            }
            i10++;
        }
        if (i10 == -1) {
            i10 = this.f29314c.size();
        }
        this.f29314c.add(i10, task);
        return i10 == 0;
    }

    public final void l(a aVar) {
        this.f29313b = aVar;
    }

    public final void m(boolean z10) {
        this.f29315d = z10;
    }

    public final void n() {
        if (!b.f27632h || !Thread.holdsLock(this)) {
            synchronized (this.f29316e) {
                this.f29312a = true;
                if (b()) {
                    this.f29316e.h(this);
                }
                m mVar = m.f28349a;
            }
            return;
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

    public String toString() {
        return this.f29317f;
    }
}
