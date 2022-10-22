package rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.d;
import rx.internal.util.atomic.c;
import rx.internal.util.unsafe.f0;
import rx.internal.util.unsafe.r;
import rx.j;
/* compiled from: RxRingBuffer.java */
/* loaded from: classes3.dex */
public class f implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final int f34130c;

    /* renamed from: a  reason: collision with root package name */
    private Queue<Object> f34131a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f34132b;

    static {
        int i10 = e.b() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i10 = Integer.parseInt(property);
            } catch (NumberFormatException e10) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e10.getMessage());
            }
        }
        f34130c = i10;
    }

    private f(Queue<Object> queue, int i10) {
        this.f34131a = queue;
    }

    public static f a() {
        if (f0.b()) {
            return new f(true, f34130c);
        }
        return new f();
    }

    public static f b() {
        if (f0.b()) {
            return new f(false, f34130c);
        }
        return new f();
    }

    public Object c(Object obj) {
        return d.d(obj);
    }

    public boolean d(Object obj) {
        return d.e(obj);
    }

    public boolean e() {
        Queue<Object> queue = this.f34131a;
        return queue == null || queue.isEmpty();
    }

    public void f() {
        if (this.f34132b == null) {
            this.f34132b = d.b();
        }
    }

    public void g(Object obj) throws MissingBackpressureException {
        boolean z10;
        boolean z11;
        synchronized (this) {
            Queue<Object> queue = this.f34131a;
            z10 = true;
            z11 = false;
            if (queue != null) {
                z11 = !queue.offer(d.g(obj));
                z10 = false;
            }
        }
        if (z10) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        } else if (z11) {
            throw new MissingBackpressureException();
        }
    }

    public Object h() {
        synchronized (this) {
            Queue<Object> queue = this.f34131a;
            if (queue == null) {
                return null;
            }
            Object peek = queue.peek();
            Object obj = this.f34132b;
            if (peek == null && obj != null && queue.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    public Object i() {
        synchronized (this) {
            Queue<Object> queue = this.f34131a;
            if (queue == null) {
                return null;
            }
            Object poll = queue.poll();
            Object obj = this.f34132b;
            if (poll == null && obj != null && queue.peek() == null) {
                this.f34132b = null;
                poll = obj;
            }
            return poll;
        }
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.f34131a == null;
    }

    public synchronized void j() {
    }

    @Override // rx.j
    public void unsubscribe() {
        j();
    }

    private f(boolean z10, int i10) {
        this.f34131a = z10 ? new rx.internal.util.unsafe.j<>(i10) : new r<>(i10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    f() {
        this(new c(r1), r1);
        int i10 = f34130c;
    }
}
