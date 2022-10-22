package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.c;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
final class i0 extends c {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<b0> f8630a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(b0 b0Var) {
        this.f8630a = new WeakReference<>(b0Var);
    }

    @Override // com.google.android.gms.signin.internal.d
    public final void A(zaj zajVar) {
        w0 w0Var;
        b0 b0Var = this.f8630a.get();
        if (b0Var != null) {
            w0Var = b0Var.f8516a;
            w0Var.l(new j0(this, b0Var, b0Var, zajVar));
        }
    }
}
