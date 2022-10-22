package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.tasks.c;
/* loaded from: classes.dex */
public abstract class o<A extends a.b, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final Feature[] f8684a = null;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8685b = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(A a10, c<ResultT> cVar) throws RemoteException;

    public boolean b() {
        return this.f8685b;
    }

    public final Feature[] c() {
        return this.f8684a;
    }
}
