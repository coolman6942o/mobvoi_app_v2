package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import q6.b;
import q6.c;
/* loaded from: classes.dex */
public abstract class e extends b implements d {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // q6.b
    protected boolean m1(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 3) {
            t1((ConnectionResult) c.b(parcel, ConnectionResult.CREATOR), (zaa) c.b(parcel, zaa.CREATOR));
        } else if (i10 == 4) {
            I0((Status) c.b(parcel, Status.CREATOR));
        } else if (i10 == 6) {
            P0((Status) c.b(parcel, Status.CREATOR));
        } else if (i10 == 7) {
            j((Status) c.b(parcel, Status.CREATOR), (GoogleSignInAccount) c.b(parcel, GoogleSignInAccount.CREATOR));
        } else if (i10 != 8) {
            return false;
        } else {
            A((zaj) c.b(parcel, zaj.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
