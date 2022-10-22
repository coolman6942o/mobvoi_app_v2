package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.p000authapi.b;
/* loaded from: classes.dex */
public abstract class k extends b implements j {
    public k() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.b
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            n();
        } else if (i10 != 2) {
            return false;
        } else {
            h2();
        }
        return true;
    }
}
