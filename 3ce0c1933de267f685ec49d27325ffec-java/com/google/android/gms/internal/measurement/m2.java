package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
final class m2 implements Callable<List<q5>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f9505a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9506b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9507c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ f2 f9508d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m2(f2 f2Var, String str, String str2, String str3) {
        this.f9508d = f2Var;
        this.f9505a = str;
        this.f9506b = str2;
        this.f9507c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<q5> call() throws Exception {
        j5 j5Var;
        j5 j5Var2;
        j5Var = this.f9508d.f9262a;
        j5Var.b0();
        j5Var2 = this.f9508d.f9262a;
        return j5Var2.P().b0(this.f9505a, this.f9506b, this.f9507c);
    }
}
