package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import h6.g;
/* loaded from: classes.dex */
public final class j7 extends g7 {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9418c;

    public j7(Context context, FirebaseCrash.a aVar, boolean z10) {
        super(context, aVar);
        this.f9418c = z10;
    }

    @Override // com.google.android.gms.internal.measurement.g7
    protected final String a() {
        boolean z10 = this.f9418c;
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append("Failed to setAppState to ");
        sb2.append(z10);
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.measurement.g7
    protected final void b(m7 m7Var) throws RemoteException {
        m7Var.l0(this.f9418c);
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
