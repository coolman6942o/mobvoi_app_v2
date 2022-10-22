package com.google.android.gms.common.api.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z extends x0 {

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ y f8800b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, v0 v0Var) {
        super(v0Var);
        this.f8800b = yVar;
    }

    @Override // com.google.android.gms.common.api.internal.x0
    public final void a() {
        this.f8800b.onConnectionSuspended(1);
    }
}
