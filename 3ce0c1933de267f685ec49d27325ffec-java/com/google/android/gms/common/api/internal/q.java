package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.tasks.c;
/* loaded from: classes.dex */
public abstract class q<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    private final i.a<L> f8706a;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(i.a<L> aVar) {
        this.f8706a = aVar;
    }

    public i.a<L> a() {
        return this.f8706a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(A a10, c<Boolean> cVar) throws RemoteException;
}
