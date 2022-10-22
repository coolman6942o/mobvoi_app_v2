package com.google.android.gms.common.api.internal;

import android.app.Activity;
import b6.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.c;
import java.util.concurrent.CancellationException;
/* loaded from: classes.dex */
public class m1 extends i2 {

    /* renamed from: f  reason: collision with root package name */
    private c<Void> f8652f = new c<>();

    private m1(h hVar) {
        super(hVar);
        this.f8504a.g("GmsAvailabilityHelper", this);
    }

    public static m1 r(Activity activity) {
        h c10 = LifecycleCallback.c(activity);
        m1 m1Var = (m1) c10.t("GmsAvailabilityHelper", m1.class);
        if (m1Var == null) {
            return new m1(c10);
        }
        if (m1Var.f8652f.a().n()) {
            m1Var.f8652f = new c<>();
        }
        return m1Var;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void g() {
        super.g();
        this.f8652f.d(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.i2
    public final void m(ConnectionResult connectionResult, int i10) {
        this.f8652f.b(a.a(new Status(connectionResult.G0(), connectionResult.H0(), connectionResult.I0())));
    }

    @Override // com.google.android.gms.common.api.internal.i2
    protected final void o() {
        int i10 = this.f8636e.i(this.f8504a.u());
        if (i10 == 0) {
            this.f8652f.c(null);
        } else if (!this.f8652f.a().n()) {
            n(new ConnectionResult(i10, null), 0);
        }
    }

    public final b<Void> q() {
        return this.f8652f.a();
    }
}
