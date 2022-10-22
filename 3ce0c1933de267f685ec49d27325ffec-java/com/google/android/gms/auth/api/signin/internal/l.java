package com.google.android.gms.auth.api.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public interface l extends IInterface {
    void J(Status status) throws RemoteException;

    void h0(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException;

    void u(Status status) throws RemoteException;
}
