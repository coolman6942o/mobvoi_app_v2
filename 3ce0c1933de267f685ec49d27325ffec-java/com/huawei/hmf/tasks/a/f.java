package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class f<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private OnFailureListener f13675a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f13676b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f13677c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Executor executor, OnFailureListener onFailureListener) {
        this.f13675a = onFailureListener;
        this.f13676b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f13677c) {
            this.f13675a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (!task.isSuccessful() && !task.isCanceled()) {
            this.f13676b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (f.this.f13677c) {
                        if (f.this.f13675a != null) {
                            f.this.f13675a.onFailure(task.getException());
                        }
                    }
                }
            });
        }
    }
}
