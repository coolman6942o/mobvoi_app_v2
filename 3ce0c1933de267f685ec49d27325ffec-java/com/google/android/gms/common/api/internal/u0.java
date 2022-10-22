package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u0 extends j1 {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<n0> f8739a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u0(n0 n0Var) {
        this.f8739a = new WeakReference<>(n0Var);
    }

    @Override // com.google.android.gms.common.api.internal.j1
    public final void a() {
        n0 n0Var = this.f8739a.get();
        if (n0Var != null) {
            n0Var.w();
        }
    }
}
