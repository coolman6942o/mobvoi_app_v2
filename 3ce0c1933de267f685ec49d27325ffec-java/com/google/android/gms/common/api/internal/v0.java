package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.h;
/* loaded from: classes.dex */
public interface v0 {
    boolean a();

    void b();

    void c(ConnectionResult connectionResult, a<?> aVar, boolean z10);

    <A extends a.b, T extends c<? extends h, A>> T d(T t10);

    void e();

    <A extends a.b, R extends h, T extends c<R, A>> T f(T t10);

    void onConnected(Bundle bundle);

    void onConnectionSuspended(int i10);
}
