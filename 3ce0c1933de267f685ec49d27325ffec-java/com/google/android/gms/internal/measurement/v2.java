package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class v2 implements Callable<List<q5>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzdz f9742a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f2 f9743b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v2(f2 f2Var, zzdz zzdzVar) {
        this.f9743b = f2Var;
        this.f9742a = zzdzVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<q5> call() throws Exception {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9743b.f9262a;
        j5Var.b0();
        j5Var2 = this.f9743b.f9262a;
        return j5Var2.P().e0(this.f9742a.f9859a);
    }
}
