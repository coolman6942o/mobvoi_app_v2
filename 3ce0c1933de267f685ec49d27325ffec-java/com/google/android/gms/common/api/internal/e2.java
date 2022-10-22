package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.tasks.c;
/* loaded from: classes.dex */
public final class e2 extends a2<Boolean> {

    /* renamed from: b  reason: collision with root package name */
    private final i.a<?> f8594b;

    public e2(i.a<?> aVar, c<Boolean> cVar) {
        super(4, cVar);
        this.f8594b = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final /* bridge */ /* synthetic */ void d(s sVar, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final Feature[] g(e.a<?> aVar) {
        o1 o1Var = aVar.v().get(this.f8594b);
        if (o1Var == null) {
            return null;
        }
        return o1Var.f8687a.c();
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final boolean h(e.a<?> aVar) {
        o1 o1Var = aVar.v().get(this.f8594b);
        return o1Var != null && o1Var.f8687a.e();
    }

    @Override // com.google.android.gms.common.api.internal.a2
    public final void i(e.a<?> aVar) throws RemoteException {
        o1 remove = aVar.v().remove(this.f8594b);
        if (remove != null) {
            remove.f8688b.b(aVar.m(), this.f8507a);
            remove.f8687a.a();
            return;
        }
        this.f8507a.e(Boolean.FALSE);
    }
}
