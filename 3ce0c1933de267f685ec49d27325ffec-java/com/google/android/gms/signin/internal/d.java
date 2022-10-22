package com.google.android.gms.signin.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public interface d extends IInterface {
    void A(zaj zajVar) throws RemoteException;

    void I0(Status status) throws RemoteException;

    void P0(Status status) throws RemoteException;

    void j(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void t1(ConnectionResult connectionResult, zaa zaaVar) throws RemoteException;
}
