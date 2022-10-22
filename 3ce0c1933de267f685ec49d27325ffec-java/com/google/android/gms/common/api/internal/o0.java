package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o0 implements d.a {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ n0 f8686a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(n0 n0Var) {
        this.f8686a = n0Var;
    }

    @Override // com.google.android.gms.common.internal.d.a
    public final boolean isConnected() {
        return this.f8686a.p();
    }

    @Override // com.google.android.gms.common.internal.d.a
    public final Bundle w() {
        return null;
    }
}
