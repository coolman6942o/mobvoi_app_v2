package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;
/* loaded from: classes.dex */
public class CancellationTokenSource {
    private c impl = new c();

    public void cancel() {
        c cVar = this.impl;
        if (!cVar.f13663c) {
            synchronized (cVar.f13662b) {
                cVar.f13663c = true;
                for (Runnable runnable : cVar.f13661a) {
                    runnable.run();
                }
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
