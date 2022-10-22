package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import r6.b;
/* loaded from: classes.dex */
public abstract class b0 extends b implements a0 {
    public static a0 m1(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof a0) {
            return (a0) queryLocalInterface;
        }
        return new c0(iBinder);
    }
}
