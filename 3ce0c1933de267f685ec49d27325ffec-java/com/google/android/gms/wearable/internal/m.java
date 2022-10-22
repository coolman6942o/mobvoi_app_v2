package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import c7.d0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.h;
/* loaded from: classes.dex */
final class m extends y<Object> {

    /* renamed from: s  reason: collision with root package name */
    private final /* synthetic */ String f10220s;

    /* renamed from: t  reason: collision with root package name */
    private final /* synthetic */ String f10221t;

    /* renamed from: u  reason: collision with root package name */
    private final /* synthetic */ byte[] f10222u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, d dVar, String str, String str2, byte[] bArr) {
        super(dVar);
        this.f10220s = str;
        this.f10221t = str2;
        this.f10222u = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ h g(Status status) {
        return new d0(status, -1);
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void r(x xVar) throws RemoteException {
        ((i) xVar.G()).z(new w(this), this.f10220s, this.f10221t, this.f10222u);
    }
}
