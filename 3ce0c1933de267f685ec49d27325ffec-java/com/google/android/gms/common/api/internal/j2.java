package com.google.android.gms.common.api.internal;

import b6.i;
import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes.dex */
final class j2 {

    /* renamed from: a  reason: collision with root package name */
    private final int f8640a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f8641b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j2(ConnectionResult connectionResult, int i10) {
        i.k(connectionResult);
        this.f8641b = connectionResult;
        this.f8640a = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ConnectionResult a() {
        return this.f8641b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f8640a;
    }
}
