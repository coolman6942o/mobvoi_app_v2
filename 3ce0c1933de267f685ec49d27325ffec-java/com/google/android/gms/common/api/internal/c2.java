package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.tasks.c;
/* loaded from: classes.dex */
public final class c2 extends a2<Void> {

    /* renamed from: b  reason: collision with root package name */
    private final k<a.b, ?> f8543b;

    /* renamed from: c  reason: collision with root package name */
    private final q<a.b, ?> f8544c;

    public c2(o1 o1Var, c<Void> cVar) {
        super(3, cVar);
        this.f8543b = o1Var.f8687a;
        this.f8544c = o1Var.f8688b;
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final /* bridge */ /* synthetic */ void d(s sVar, boolean z10) {
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final Feature[] g(e.a<?> aVar) {
        return this.f8543b.c();
    }

    @Override // com.google.android.gms.common.api.internal.p1
    public final boolean h(e.a<?> aVar) {
        return this.f8543b.e();
    }

    @Override // com.google.android.gms.common.api.internal.a2
    public final void i(e.a<?> aVar) throws RemoteException {
        this.f8543b.d(aVar.m(), this.f8507a);
        if (this.f8543b.b() != null) {
            aVar.v().put(this.f8543b.b(), new o1(this.f8543b, this.f8544c));
        }
    }
}
