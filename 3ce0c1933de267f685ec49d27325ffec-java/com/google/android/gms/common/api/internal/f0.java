package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
/* loaded from: classes.dex */
final class f0 extends x0 {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f8600b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ e0 f8601c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(e0 e0Var, v0 v0Var, ConnectionResult connectionResult) {
        super(v0Var);
        this.f8601c = e0Var;
        this.f8600b = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.x0
    public final void a() {
        this.f8601c.f8592c.B(this.f8600b);
    }
}
