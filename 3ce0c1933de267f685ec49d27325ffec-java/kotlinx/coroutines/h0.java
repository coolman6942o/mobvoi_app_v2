package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.coroutines.f;
import xo.e;
import xo.k;
import xo.m;
/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes3.dex */
public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<CoroutineExceptionHandler> f30188a;

    static {
        e c10;
        List<CoroutineExceptionHandler> m10;
        c10 = k.c(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator());
        m10 = m.m(c10);
        f30188a = m10;
    }

    public static final void a(f fVar, Throwable th2) {
        for (CoroutineExceptionHandler coroutineExceptionHandler : f30188a) {
            try {
                coroutineExceptionHandler.handleException(fVar, th2);
            } catch (Throwable th3) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, i0.b(th2, th3));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th2);
    }
}
