package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.b;
/* loaded from: classes.dex */
public final class y0 extends b<r0> {
    public y0(Context context, Looper looper, b.a aVar, b.AbstractC0108b bVar) {
        super(context, looper, 93, aVar, bVar, null);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String m() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // com.google.android.gms.common.internal.b
    public final /* synthetic */ r0 n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof r0 ? (r0) queryLocalInterface : new t0(iBinder);
    }

    @Override // com.google.android.gms.common.internal.b
    protected final String v() {
        return "com.google.android.gms.measurement.START";
    }
}
