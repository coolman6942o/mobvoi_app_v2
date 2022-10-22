package com.google.android.gms.internal.measurement;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g5 extends h0 {

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ j5 f9302e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ f5 f9303f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g5(f5 f5Var, a3 a3Var, j5 j5Var) {
        super(a3Var);
        this.f9303f = f5Var;
        this.f9302e = j5Var;
    }

    @Override // com.google.android.gms.internal.measurement.h0
    public final void c() {
        this.f9303f.z();
        this.f9303f.c().R().a("Starting upload from DelayedRunnable");
        this.f9302e.W();
    }
}
