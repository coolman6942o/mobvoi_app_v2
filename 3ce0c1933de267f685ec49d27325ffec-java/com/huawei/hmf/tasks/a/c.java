package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class c extends CancellationToken {

    /* renamed from: a  reason: collision with root package name */
    public final List<Runnable> f13661a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Object f13662b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public boolean f13663c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.f13663c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.f13662b) {
            if (this.f13663c) {
                runnable.run();
            } else {
                this.f13661a.add(runnable);
            }
        }
        return this;
    }
}
