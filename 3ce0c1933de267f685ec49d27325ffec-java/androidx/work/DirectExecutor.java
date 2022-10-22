package androidx.work;

import java.util.concurrent.Executor;
import kotlin.jvm.internal.i;
/* compiled from: DirectExecutor.kt */
/* loaded from: classes.dex */
public enum DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        i.f(command, "command");
        command.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
