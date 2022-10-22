package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import b6.i;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.k;
/* loaded from: classes.dex */
public abstract class c<R extends h, A extends a.b> extends BasePendingResult<R> implements d<R> {

    /* renamed from: q  reason: collision with root package name */
    private final a.c<A> f8539q;

    /* renamed from: r  reason: collision with root package name */
    private final a<?> f8540r;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(a<?> aVar, d dVar) {
        super((d) i.l(dVar, "GoogleApiClient must not be null"));
        i.l(aVar, "Api must not be null");
        this.f8539q = (a.c<A>) aVar.a();
        this.f8540r = aVar;
    }

    private void w(RemoteException remoteException) {
        x(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.d
    public /* bridge */ /* synthetic */ void a(Object obj) {
        super.j((h) obj);
    }

    protected abstract void r(A a10) throws RemoteException;

    public final a<?> s() {
        return this.f8540r;
    }

    public final a.c<A> t() {
        return this.f8539q;
    }

    protected void u(R r10) {
    }

    public final void v(A a10) throws DeadObjectException {
        if (a10 instanceof k) {
            a10 = ((k) a10).q0();
        }
        try {
            r(a10);
        } catch (DeadObjectException e10) {
            w(e10);
            throw e10;
        } catch (RemoteException e11) {
            w(e11);
        }
    }

    public final void x(Status status) {
        i.b(!status.K0(), "Failed result must not be success");
        R g10 = g(status);
        j(g10);
        u(g10);
    }
}
