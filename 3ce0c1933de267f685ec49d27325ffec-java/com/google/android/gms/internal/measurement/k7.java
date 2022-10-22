package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import h6.g;
/* loaded from: classes.dex */
public final class k7 extends g7 {

    /* renamed from: c  reason: collision with root package name */
    private final String f9466c;

    public k7(Context context, FirebaseCrash.a aVar, String str) {
        super(context, aVar);
        this.f9466c = str;
    }

    @Override // com.google.android.gms.internal.measurement.g7
    protected final String a() {
        String valueOf = String.valueOf(this.f9466c);
        return valueOf.length() != 0 ? "Failed to set InstanceId to ".concat(valueOf) : new String("Failed to set InstanceId to ");
    }

    @Override // com.google.android.gms.internal.measurement.g7
    protected final void b(m7 m7Var) throws RemoteException {
        m7Var.a1(this.f9466c);
    }

    @Override // com.google.android.gms.internal.measurement.g7, java.lang.Runnable
    public final void run() {
        try {
            m7 a10 = this.f9305a.a();
            if (a10 == null) {
                Log.e("FirebaseCrash", "Crash api not available");
            } else {
                b(a10);
            }
        } catch (RemoteException | RuntimeException e10) {
            g.a(this.f9306b, e10);
            Log.e("FirebaseCrash", a(), e10);
        }
    }
}
