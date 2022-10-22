package com.google.android.gms.common.api.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x1 implements z1 {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ w1 f8786a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1(w1 w1Var) {
        this.f8786a = w1Var;
    }

    @Override // com.google.android.gms.common.api.internal.z1
    public final void a(BasePendingResult<?> basePendingResult) {
        this.f8786a.f8780a.remove(basePendingResult);
    }
}
