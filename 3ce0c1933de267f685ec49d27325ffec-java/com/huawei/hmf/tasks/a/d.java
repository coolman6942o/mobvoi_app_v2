package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class d<TResult> implements ExecuteResult<TResult> {

    /* renamed from: a  reason: collision with root package name */
    Executor f13664a;

    /* renamed from: b  reason: collision with root package name */
    private OnCompleteListener<TResult> f13665b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f13666c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f13665b = onCompleteListener;
        this.f13664a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.f13666c) {
            this.f13665b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.f13664a.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (d.this.f13666c) {
                    if (d.this.f13665b != null) {
                        d.this.f13665b.onComplete(task);
                    }
                }
            }
        });
    }
}
