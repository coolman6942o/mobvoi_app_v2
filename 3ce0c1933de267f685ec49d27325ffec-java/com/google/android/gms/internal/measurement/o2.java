package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class o2 implements Callable<List<zzed>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f9546a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9547b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9548c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ f2 f9549d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o2(f2 f2Var, String str, String str2, String str3) {
        this.f9549d = f2Var;
        this.f9546a = str;
        this.f9547b = str2;
        this.f9548c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzed> call() throws Exception {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9549d.f9262a;
        j5Var.b0();
        j5Var2 = this.f9549d.f9262a;
        return j5Var2.P().k0(this.f9546a, this.f9547b, this.f9548c);
    }
}
