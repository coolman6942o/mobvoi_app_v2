package i6;

import b6.i;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f28101a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f28102b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f28103c;

    public c(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f28103c.newThread(new d(runnable, 0));
        String str = this.f28101a;
        int andIncrement = this.f28102b.getAndIncrement();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 13);
        sb2.append(str);
        sb2.append("[");
        sb2.append(andIncrement);
        sb2.append("]");
        newThread.setName(sb2.toString());
        return newThread;
    }

    private c(String str, int i10) {
        this.f28102b = new AtomicInteger();
        this.f28103c = Executors.defaultThreadFactory();
        this.f28101a = (String) i.l(str, "Name must not be null");
    }
}
