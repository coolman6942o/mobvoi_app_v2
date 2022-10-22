package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.internal.location.d;
import com.google.android.gms.internal.location.p;
import com.google.android.gms.tasks.c;
import w6.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends q<p, b> {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a f9954b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(a aVar, i.a aVar2) {
        super(aVar2);
        this.f9954b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.q
    public final /* synthetic */ void b(p pVar, c cVar) throws RemoteException {
        d t10;
        p pVar2 = pVar;
        t10 = this.f9954b.t(cVar);
        try {
            pVar2.v0(a(), t10);
        } catch (RuntimeException e10) {
            cVar.d(e10);
        }
    }
}
