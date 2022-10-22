package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;
import java.util.concurrent.atomic.AtomicReference;
import q6.i;
/* loaded from: classes.dex */
public abstract class i2 extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    protected volatile boolean f8633b;

    /* renamed from: c  reason: collision with root package name */
    protected final AtomicReference<j2> f8634c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f8635d;

    /* renamed from: e  reason: collision with root package name */
    protected final b f8636e;

    /* JADX INFO: Access modifiers changed from: protected */
    public i2(h hVar) {
        this(hVar, b.q());
    }

    private static int l(j2 j2Var) {
        if (j2Var == null) {
            return -1;
        }
        return j2Var.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(int i10, int i11, Intent intent) {
        j2 j2Var = this.f8634c.get();
        boolean z10 = true;
        if (i10 != 1) {
            if (i10 == 2) {
                int i12 = this.f8636e.i(b());
                if (i12 != 0) {
                    z10 = false;
                }
                if (j2Var != null) {
                    if (j2Var.a().G0() == 18 && i12 == 18) {
                        return;
                    }
                    if (z10) {
                        p();
                        return;
                    } else if (j2Var != null) {
                        m(j2Var.a(), j2Var.b());
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            z10 = false;
            if (z10) {
            }
        } else {
            if (i11 != -1) {
                if (i11 == 0) {
                    int i13 = 13;
                    if (intent != null) {
                        i13 = intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
                    }
                    j2 j2Var2 = new j2(new ConnectionResult(i13, null), l(j2Var));
                    this.f8634c.set(j2Var2);
                    j2Var = j2Var2;
                }
                z10 = false;
            }
            if (z10) {
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void f(Bundle bundle) {
        super.f(bundle);
        if (bundle != null) {
            this.f8634c.set(bundle.getBoolean("resolving_error", false) ? new j2(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void i(Bundle bundle) {
        super.i(bundle);
        j2 j2Var = this.f8634c.get();
        if (j2Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", j2Var.b());
            bundle.putInt("failed_status", j2Var.a().G0());
            bundle.putParcelable("failed_resolution", j2Var.a().I0());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.f8633b = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        this.f8633b = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void m(ConnectionResult connectionResult, int i10);

    public final void n(ConnectionResult connectionResult, int i10) {
        j2 j2Var = new j2(connectionResult, i10);
        if (this.f8634c.compareAndSet(null, j2Var)) {
            this.f8635d.post(new k2(this, j2Var));
        }
    }

    protected abstract void o();

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m(new ConnectionResult(13, null), l(this.f8634c.get()));
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        this.f8634c.set(null);
        o();
    }

    private i2(h hVar, b bVar) {
        super(hVar);
        this.f8634c = new AtomicReference<>(null);
        this.f8635d = new i(Looper.getMainLooper());
        this.f8636e = bVar;
    }
}
