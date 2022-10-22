package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.e;
/* loaded from: classes.dex */
final class d1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f8548a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ e.a f8549b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d1(e.a aVar, ConnectionResult connectionResult) {
        this.f8549b = aVar;
        this.f8548a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8549b.onConnectionFailed(this.f8548a);
    }
}
