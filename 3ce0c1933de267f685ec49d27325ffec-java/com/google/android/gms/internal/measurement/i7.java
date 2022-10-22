package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import k6.d;
/* loaded from: classes.dex */
public final class i7 extends g7 {

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f9373c;

    /* renamed from: d  reason: collision with root package name */
    private final q7 f9374d;

    public i7(Context context, FirebaseCrash.a aVar, Throwable th2, q7 q7Var) {
        super(context, aVar);
        this.f9373c = th2;
        this.f9374d = q7Var;
    }

    @Override // com.google.android.gms.internal.measurement.g7
    protected final String a() {
        return "Failed to report uncaught exception";
    }

    @Override // com.google.android.gms.internal.measurement.g7
    protected final void b(m7 m7Var) throws RemoteException {
        q7 q7Var = this.f9374d;
        if (q7Var != null) {
            q7Var.b(true, System.currentTimeMillis());
            try {
                Thread.sleep(200L);
            } catch (InterruptedException unused) {
                Log.w("FirebaseCrash", "Failed to wait for analytics event to be logged");
                return;
            }
        }
        m7Var.r(d.A2(this.f9373c));
    }
}
