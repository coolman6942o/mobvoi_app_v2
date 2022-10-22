package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface t extends IInterface {
    void L0(LocationAvailability locationAvailability) throws RemoteException;

    void q1(LocationResult locationResult) throws RemoteException;
}
