package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.f;
/* loaded from: classes.dex */
public class a extends f.a {
    public static Account U1(f fVar) {
        if (fVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return fVar.o();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }
}
