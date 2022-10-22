package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.firebase.crash.FirebaseCrash;
import h6.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class g7 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected final FirebaseCrash.a f9305a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f9306b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g7(Context context, FirebaseCrash.a aVar) {
        this.f9305a = aVar;
        this.f9306b = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(m7 m7Var) throws RemoteException;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        android.util.Log.e("FirebaseCrash", "Firebase Crash Reporting not enabled");
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        try {
            m7 a10 = this.f9305a.a();
            if (a10 != null && a10.x1()) {
                b(a10);
                return;
            }
            Log.e("FirebaseCrash", "Crash api not available");
        } catch (RemoteException | RuntimeException e10) {
            g.a(this.f9306b, e10);
            Log.e("FirebaseCrash", a(), e10);
        }
    }
}
