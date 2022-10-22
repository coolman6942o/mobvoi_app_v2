package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j2 f8646a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ i2 f8647b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k2(i2 i2Var, j2 j2Var) {
        this.f8647b = i2Var;
        this.f8646a = j2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f8647b.f8633b) {
            ConnectionResult a10 = this.f8646a.a();
            if (a10.J0()) {
                i2 i2Var = this.f8647b;
                i2Var.f8504a.startActivityForResult(GoogleApiActivity.b(i2Var.b(), a10.I0(), this.f8646a.b(), false), 1);
            } else if (this.f8647b.f8636e.m(a10.G0())) {
                i2 i2Var2 = this.f8647b;
                i2Var2.f8636e.A(i2Var2.b(), this.f8647b.f8504a, a10.G0(), 2, this.f8647b);
            } else if (a10.G0() == 18) {
                Dialog u10 = b.u(this.f8647b.b(), this.f8647b);
                i2 i2Var3 = this.f8647b;
                i2Var3.f8636e.w(i2Var3.b().getApplicationContext(), new l2(this, u10));
            } else {
                this.f8647b.m(a10, this.f8646a.b());
            }
        }
    }
}
