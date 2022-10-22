package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m5 implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzdz f9519a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j5 f9520b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m5(j5 j5Var, zzdz zzdzVar) {
        this.f9520b = j5Var;
        this.f9519a = zzdzVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        v H = this.f9520b.M().D(this.f9519a.f9859a) ? this.f9520b.H(this.f9519a) : this.f9520b.P().f0(this.f9519a.f9859a);
        if (H != null) {
            return H.a();
        }
        this.f9520b.c().N().a("App info was null when attempting to get app instance id");
        return null;
    }
}
