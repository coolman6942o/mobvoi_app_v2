package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
/* compiled from: Timeout.kt */
/* loaded from: classes3.dex */
public final class TimeoutCancellationException extends CancellationException implements e0<TimeoutCancellationException> {
    public final j1 coroutine;

    public TimeoutCancellationException(String str, j1 j1Var) {
        super(str);
        this.coroutine = j1Var;
    }

    @Override // kotlinx.coroutines.e0
    public TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }

    public TimeoutCancellationException(String str) {
        this(str, null);
    }
}
