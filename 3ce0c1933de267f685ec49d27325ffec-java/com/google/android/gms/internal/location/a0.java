package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.j;
import w6.c;
/* loaded from: classes.dex */
final class a0 extends b {

    /* renamed from: s  reason: collision with root package name */
    private final /* synthetic */ c f9099s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(y yVar, d dVar, c cVar) {
        super(dVar);
        this.f9099s = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void r(p pVar) throws RemoteException {
        pVar.s0(j.b(this.f9099s, c.class.getSimpleName()), new c(this));
    }
}
