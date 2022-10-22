package com.amap.api.maps2d.model;

import android.os.RemoteException;
/* loaded from: classes.dex */
public final class RuntimeRemoteException extends RuntimeException {
    public RuntimeRemoteException(String str) {
        super(str);
    }

    public RuntimeRemoteException(RemoteException remoteException) {
        super(remoteException);
    }
}
