package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class s2 implements Callable<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzeu f9652a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9653b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ f2 f9654c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s2(f2 f2Var, zzeu zzeuVar, String str) {
        this.f9654c = f2Var;
        this.f9652a = zzeuVar;
        this.f9653b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9654c.f9262a;
        j5Var.b0();
        j5Var2 = this.f9654c.f9262a;
        return j5Var2.n(this.f9652a, this.f9653b);
    }
}
