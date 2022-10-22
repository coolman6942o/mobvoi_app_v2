package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;
/* loaded from: classes.dex */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f13669a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final int f13670b;

    /* renamed from: c  reason: collision with root package name */
    private final i<Void> f13671c;

    /* renamed from: d  reason: collision with root package name */
    private int f13672d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f13673e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13674f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i10, i<Void> iVar) {
        this.f13670b = i10;
        this.f13671c = iVar;
    }

    private void a() {
        if (this.f13672d < this.f13670b) {
            return;
        }
        if (this.f13673e != null) {
            this.f13671c.a(new ExecutionException("a task failed", this.f13673e));
        } else if (this.f13674f) {
            this.f13671c.a();
        } else {
            this.f13671c.a((i<Void>) null);
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.f13669a) {
            this.f13672d++;
            this.f13674f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.f13669a) {
            this.f13672d++;
            this.f13673e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.f13669a) {
            this.f13672d++;
            a();
        }
    }
}
