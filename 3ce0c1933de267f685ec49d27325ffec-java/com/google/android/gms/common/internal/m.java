package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.b;
/* loaded from: classes.dex */
final class m implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ d.b f8951a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d.b bVar) {
        this.f8951a = bVar;
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void onConnected(Bundle bundle) {
        this.f8951a.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.internal.b.a
    public final void onConnectionSuspended(int i10) {
        this.f8951a.onConnectionSuspended(i10);
    }
}
