package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.b;
/* loaded from: classes.dex */
final class n implements b.AbstractC0108b {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ d.c f8952a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d.c cVar) {
        this.f8952a = cVar;
    }

    @Override // com.google.android.gms.common.internal.b.AbstractC0108b
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f8952a.onConnectionFailed(connectionResult);
    }
}
