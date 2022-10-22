package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class l2 implements Callable<List<q5>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzdz f9479a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9480b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9481c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ f2 f9482d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l2(f2 f2Var, zzdz zzdzVar, String str, String str2) {
        this.f9482d = f2Var;
        this.f9479a = zzdzVar;
        this.f9480b = str;
        this.f9481c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<q5> call() throws Exception {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9482d.f9262a;
        j5Var.b0();
        j5Var2 = this.f9482d.f9262a;
        return j5Var2.P().b0(this.f9479a.f9859a, this.f9480b, this.f9481c);
    }
}
