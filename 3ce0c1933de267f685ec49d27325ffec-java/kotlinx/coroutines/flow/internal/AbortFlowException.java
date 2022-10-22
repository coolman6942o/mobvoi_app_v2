package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.n0;
/* compiled from: FlowExceptions.kt */
/* loaded from: classes3.dex */
public final class AbortFlowException extends CancellationException {
    private final c<?> owner;

    public AbortFlowException(c<?> cVar) {
        super("Flow was aborted, no more elements needed");
        this.owner = cVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (n0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final c<?> getOwner() {
        return this.owner;
    }
}
