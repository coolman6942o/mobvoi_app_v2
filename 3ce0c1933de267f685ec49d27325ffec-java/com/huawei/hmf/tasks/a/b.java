package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class b<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private OnCanceledListener f13657a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f13658b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f13659c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Executor executor, OnCanceledListener onCanceledListener) {
        this.f13657a = onCanceledListener;
        this.f13658b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f13659c) {
            this.f13657a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.f13658b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (b.this.f13659c) {
                        if (b.this.f13657a != null) {
                            b.this.f13657a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
