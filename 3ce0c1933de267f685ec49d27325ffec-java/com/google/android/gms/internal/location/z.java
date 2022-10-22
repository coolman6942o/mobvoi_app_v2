package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.LocationRequest;
import t6.e;
import w6.c;
/* loaded from: classes.dex */
final class z extends b {

    /* renamed from: s  reason: collision with root package name */
    private final /* synthetic */ LocationRequest f9113s;

    /* renamed from: t  reason: collision with root package name */
    private final /* synthetic */ c f9114t;

    /* renamed from: u  reason: collision with root package name */
    private final /* synthetic */ Looper f9115u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, d dVar, LocationRequest locationRequest, c cVar, Looper looper) {
        super(dVar);
        this.f9113s = locationRequest;
        this.f9114t = cVar;
        this.f9115u = looper;
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void r(p pVar) throws RemoteException {
        pVar.u0(this.f9113s, j.a(this.f9114t, e.a(this.f9115u), c.class.getSimpleName()), new c(this));
    }
}
