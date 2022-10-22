package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zaj;
/* loaded from: classes.dex */
final class s1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zaj f8727a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ q1 f8728b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1(q1 q1Var, zaj zajVar) {
        this.f8728b = q1Var;
        this.f8727a = zajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8728b.E2(this.f8727a);
    }
}
