package i6;

import b6.i;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
public class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f28099a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f28100b;

    public b(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f28100b.newThread(new d(runnable, 0));
        newThread.setName(this.f28099a);
        return newThread;
    }

    private b(String str, int i10) {
        this.f28100b = Executors.defaultThreadFactory();
        this.f28099a = (String) i.l(str, "Name must not be null");
    }
}
