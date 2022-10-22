package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
/* loaded from: classes.dex */
final class g0 extends x0 {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ b.c f8608b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(e0 e0Var, v0 v0Var, b.c cVar) {
        super(v0Var);
        this.f8608b = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.x0
    public final void a() {
        this.f8608b.a(new ConnectionResult(16, null));
    }
}
