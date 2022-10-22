package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.MapView;
import y6.b;
import y6.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends i {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ x6.d f10014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MapView.a aVar, x6.d dVar) {
        this.f10014a = dVar;
    }

    @Override // y6.h
    public final void R1(b bVar) throws RemoteException {
        this.f10014a.a(new a(bVar));
    }
}
