package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.internal.location.p;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.location.a;
import com.google.android.gms.tasks.c;
import w6.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends k<p, b> {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ zzbd f9952d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ i f9953e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(a aVar, i iVar, zzbd zzbdVar, i iVar2) {
        super(iVar);
        this.f9952d = zzbdVar;
        this.f9953e = iVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.k
    public final /* synthetic */ void d(p pVar, c cVar) throws RemoteException {
        pVar.t0(this.f9952d, this.f9953e, new a.BinderC0114a(cVar));
    }
}
