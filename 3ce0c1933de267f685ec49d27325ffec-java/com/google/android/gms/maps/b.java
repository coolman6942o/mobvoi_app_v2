package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import y6.d;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final d f10013a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar) {
        this.f10013a = dVar;
    }

    public final void a(boolean z10) {
        try {
            this.f10013a.y(z10);
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final void b(boolean z10) {
        try {
            this.f10013a.H0(z10);
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final void c(boolean z10) {
        try {
            this.f10013a.v1(z10);
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }

    public final void d(boolean z10) {
        try {
            this.f10013a.p0(z10);
        } catch (RemoteException e10) {
            throw new RuntimeRemoteException(e10);
        }
    }
}
