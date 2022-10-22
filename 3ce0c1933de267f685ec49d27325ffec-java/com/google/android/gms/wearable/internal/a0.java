package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import c7.d1;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
import com.google.android.gms.wearable.a;
/* loaded from: classes.dex */
final class a0 extends y<a.b> {

    /* renamed from: s  reason: collision with root package name */
    private final /* synthetic */ String f10217s;

    /* renamed from: t  reason: collision with root package name */
    private final /* synthetic */ int f10218t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(z zVar, d dVar, String str, int i10) {
        super(dVar);
        this.f10217s = str;
        this.f10218t = i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ h g(Status status) {
        return new d1(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void r(x xVar) throws RemoteException {
        ((i) xVar.G()).Z1(new s(this), this.f10217s, this.f10218t);
    }
}
