package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.tasks.c;
/* loaded from: classes.dex */
public abstract class k<A extends a.b, L> {

    /* renamed from: a  reason: collision with root package name */
    private final i<L> f8642a;

    /* renamed from: b  reason: collision with root package name */
    private final Feature[] f8643b = null;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8644c = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(i<L> iVar) {
        this.f8642a = iVar;
    }

    public void a() {
        this.f8642a.a();
    }

    public i.a<L> b() {
        return this.f8642a.b();
    }

    public Feature[] c() {
        return this.f8643b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void d(A a10, c<Void> cVar) throws RemoteException;

    public final boolean e() {
        return this.f8644c;
    }
}
