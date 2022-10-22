package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.f;
import java.util.ArrayList;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h0 extends l0 {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<a.f> f8616b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ b0 f8617c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(b0 b0Var, ArrayList<a.f> arrayList) {
        super(b0Var, null);
        this.f8617c = b0Var;
        this.f8616b = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final void a() {
        w0 w0Var;
        Set<Scope> r10;
        f fVar;
        w0 w0Var2;
        w0Var = this.f8617c.f8516a;
        n0 n0Var = w0Var.f8776n;
        r10 = this.f8617c.r();
        n0Var.f8668q = r10;
        ArrayList<a.f> arrayList = this.f8616b;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            a.f fVar2 = arrayList.get(i10);
            i10++;
            fVar = this.f8617c.f8530o;
            w0Var2 = this.f8617c.f8516a;
            fVar2.g(fVar, w0Var2.f8776n.f8668q);
        }
    }
}
