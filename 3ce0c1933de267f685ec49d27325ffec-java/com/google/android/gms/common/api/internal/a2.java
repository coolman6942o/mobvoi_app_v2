package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.tasks.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a2<T> extends p1 {

    /* renamed from: a  reason: collision with root package name */
    protected final c<T> f8507a;

    public a2(int i10, c<T> cVar) {
        super(i10);
        this.f8507a = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public void b(Status status) {
        this.f8507a.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void c(e.a<?> aVar) throws DeadObjectException {
        Status a10;
        Status a11;
        try {
            i(aVar);
        } catch (DeadObjectException e10) {
            a10 = r0.a(e10);
            b(a10);
            throw e10;
        } catch (RemoteException e11) {
            a11 = r0.a(e11);
            b(a11);
        } catch (RuntimeException e12) {
            e(e12);
        }
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public void e(RuntimeException runtimeException) {
        this.f8507a.d(runtimeException);
    }

    protected abstract void i(e.a<?> aVar) throws RemoteException;
}
