package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.e;
import h6.n;
/* loaded from: classes.dex */
public abstract class r0 {
    public r0(int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status a(RemoteException remoteException) {
        StringBuilder sb2 = new StringBuilder();
        if (n.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb2.append("TransactionTooLargeException: ");
        }
        sb2.append(remoteException.getLocalizedMessage());
        return new Status(8, sb2.toString());
    }

    public abstract void b(Status status);

    public abstract void c(e.a<?> aVar) throws DeadObjectException;

    public abstract void d(s sVar, boolean z10);

    public abstract void e(RuntimeException runtimeException);
}
