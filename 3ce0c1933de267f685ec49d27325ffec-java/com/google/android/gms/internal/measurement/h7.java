package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.firebase.crash.FirebaseCrash;
/* loaded from: classes.dex */
public final class h7 extends g7 {

    /* renamed from: c  reason: collision with root package name */
    private final String f9350c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9351d;

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f9352e;

    public h7(Context context, FirebaseCrash.a aVar, String str, long j10, Bundle bundle) {
        super(context, aVar);
        this.f9350c = str;
        this.f9351d = j10;
        this.f9352e = bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.g7
    public final String a() {
        return "Failed to log analytics event";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.g7
    public final void b(m7 m7Var) throws RemoteException {
        m7Var.z1(this.f9350c, this.f9351d, this.f9352e);
    }
}
