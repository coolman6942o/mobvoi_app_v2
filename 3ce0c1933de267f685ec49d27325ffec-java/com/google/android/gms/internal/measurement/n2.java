package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class n2 implements Callable<List<zzed>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzdz f9527a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9528b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9529c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ f2 f9530d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n2(f2 f2Var, zzdz zzdzVar, String str, String str2) {
        this.f9530d = f2Var;
        this.f9527a = zzdzVar;
        this.f9528b = str;
        this.f9529c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzed> call() throws Exception {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9530d.f9262a;
        j5Var.b0();
        j5Var2 = this.f9530d.f9262a;
        return j5Var2.P().k0(this.f9527a.f9859a, this.f9528b, this.f9529c);
    }
}
