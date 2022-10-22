package com.mobvoi.wear.util;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes2.dex */
public class PriorityThreadFactory implements ThreadFactory {
    private final String mName;
    private final int mPriority;

    public PriorityThreadFactory(String str, int i10) {
        this.mName = str;
        this.mPriority = i10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.mName) { // from class: com.mobvoi.wear.util.PriorityThreadFactory.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(PriorityThreadFactory.this.mPriority);
                super.run();
            }
        };
    }
}
