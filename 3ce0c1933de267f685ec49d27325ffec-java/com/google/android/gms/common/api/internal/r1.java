package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ q1 f8719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r1(q1 q1Var) {
        this.f8719a = q1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t1 t1Var;
        t1Var = this.f8719a.f8715g;
        t1Var.c(new ConnectionResult(4));
    }
}
