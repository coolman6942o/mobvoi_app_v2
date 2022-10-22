package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class h<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private OnSuccessListener<TResult> f13682a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f13683b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f13684c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.f13682a = onSuccessListener;
        this.f13683b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f13684c) {
            this.f13682a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() && !task.isCanceled()) {
            this.f13683b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (h.this.f13684c) {
                        if (h.this.f13682a != null) {
                            h.this.f13682a.onSuccess(task.getResult());
                        }
                    }
                }
            });
        }
    }
}
