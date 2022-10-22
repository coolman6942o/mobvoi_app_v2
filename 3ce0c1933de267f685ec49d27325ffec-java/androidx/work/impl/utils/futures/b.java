package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;
/* compiled from: DirectExecutor.java */
/* loaded from: classes.dex */
enum b implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
