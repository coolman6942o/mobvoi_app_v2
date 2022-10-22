package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public abstract class o6 extends l6 implements n6 {
    public static n6 m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return queryLocalInterface instanceof n6 ? (n6) queryLocalInterface : new p6(iBinder);
    }
}
