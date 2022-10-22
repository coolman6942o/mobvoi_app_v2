package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.e;
/* loaded from: classes.dex */
public final class b2<A extends c<? extends h, a.b>> extends r0 {

    /* renamed from: a  reason: collision with root package name */
    private final A f8538a;

    public b2(int i10, A a10) {
        super(i10);
        this.f8538a = a10;
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void b(Status status) {
        this.f8538a.x(status);
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void c(e.a<?> aVar) throws DeadObjectException {
        try {
            this.f8538a.v(aVar.m());
        } catch (RuntimeException e10) {
            e(e10);
        }
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void d(s sVar, boolean z10) {
        sVar.b(this.f8538a, z10);
    }

    @Override // com.google.android.gms.common.api.internal.r0
    public final void e(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 2 + String.valueOf(localizedMessage).length());
        sb2.append(simpleName);
        sb2.append(": ");
        sb2.append(localizedMessage);
        this.f8538a.x(new Status(10, sb2.toString()));
    }
}
