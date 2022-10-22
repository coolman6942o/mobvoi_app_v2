package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.util.List;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k0;
import zo.a;
/* compiled from: DebuggerInfo.kt */
/* loaded from: classes3.dex */
public final class DebuggerInfo implements Serializable {
    private final Long coroutineId;
    private final String dispatcher;
    private final List<StackTraceElement> lastObservedStackTrace;
    private final String lastObservedThreadName;
    private final String lastObservedThreadState;
    private final String name;
    private final long sequenceNumber;
    private final String state;

    public DebuggerInfo(a aVar, f fVar) {
        j0 j0Var = (j0) fVar.get(j0.f30246b);
        this.coroutineId = j0Var == null ? null : Long.valueOf(j0Var.Q());
        d dVar = (d) fVar.get(d.f30064e0);
        this.dispatcher = dVar == null ? null : dVar.toString();
        k0 k0Var = (k0) fVar.get(k0.f30250b);
        this.name = k0Var == null ? null : k0Var.Q();
        throw null;
    }

    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    public final String getDispatcher() {
        return this.dispatcher;
    }

    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final String getState() {
        return this.state;
    }
}
