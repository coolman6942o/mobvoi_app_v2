package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p000authapi.b;
import p6.a;
/* loaded from: classes.dex */
public abstract class m extends b implements l {
    public m() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.p000authapi.b
    protected final boolean c(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        switch (i10) {
            case 101:
                h0((GoogleSignInAccount) a.a(parcel, GoogleSignInAccount.CREATOR), (Status) a.a(parcel, Status.CREATOR));
                break;
            case 102:
                u((Status) a.a(parcel, Status.CREATOR));
                break;
            case 103:
                J((Status) a.a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
