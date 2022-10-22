package kotlinx.coroutines;

import io.b;
import kotlin.coroutines.f;
/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public final class i0 {
    public static final void a(f fVar, Throwable th2) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) fVar.get(CoroutineExceptionHandler.f30111f0);
            if (coroutineExceptionHandler == null) {
                h0.a(fVar, th2);
            } else {
                coroutineExceptionHandler.handleException(fVar, th2);
            }
        } catch (Throwable th3) {
            h0.a(fVar, b(th2, th3));
        }
    }

    public static final Throwable b(Throwable th2, Throwable th3) {
        if (th2 == th3) {
            return th2;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
        b.a(runtimeException, th2);
        return runtimeException;
    }
}
