package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.tasks.c;
/* loaded from: classes.dex */
public final class d2<ResultT> extends p1 {

    /* renamed from: a  reason: collision with root package name */
    private final o<a.b, ResultT> f8550a;

    /* renamed from: b  reason: collision with root package name */
    private final c<ResultT> f8551b;

    /* renamed from: c  reason: collision with root package name */
    private final m f8552c;

    public d2(int i10, o<a.b, ResultT> oVar, c<ResultT> cVar, m mVar) {
        super(i10);
        this.f8551b = cVar;
        this.f8550a = oVar;
        this.f8552c = mVar;
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void b(Status status) {
        this.f8551b.d(this.f8552c.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void c(e.a<?> aVar) throws DeadObjectException {
        Status a10;
        try {
            this.f8550a.a(aVar.m(), this.f8551b);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            a10 = r0.a(e11);
            b(a10);
        } catch (RuntimeException e12) {
            e(e12);
        }
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void d(s sVar, boolean z10) {
        sVar.c(this.f8551b, z10);
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void e(RuntimeException runtimeException) {
        this.f8551b.d(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final Feature[] g(e.a<?> aVar) {
        return this.f8550a.c();
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final boolean h(e.a<?> aVar) {
        return this.f8550a.b();
    }
}
