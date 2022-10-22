package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.huawei.hms.ml.camera.CameraConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ boolean f9816a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ w3 f9817b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ w3 f9818c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ x3 f9819d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y3(x3 x3Var, boolean z10, w3 w3Var, w3 w3Var2) {
        this.f9819d = x3Var;
        this.f9816a = z10;
        this.f9817b = w3Var;
        this.f9818c = w3Var2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z10;
        x3 x3Var;
        w3 w3Var;
        if (this.f9816a && (w3Var = (x3Var = this.f9819d).f9794c) != null) {
            x3Var.G(w3Var);
        }
        w3 w3Var2 = this.f9817b;
        if (w3Var2 != null) {
            long j10 = w3Var2.f9774c;
            w3 w3Var3 = this.f9818c;
            if (j10 == w3Var3.f9774c && r5.C0(w3Var2.f9773b, w3Var3.f9773b) && r5.C0(this.f9817b.f9772a, this.f9818c.f9772a)) {
                z10 = false;
                if (z10) {
                    Bundle bundle = new Bundle();
                    x3.H(this.f9818c, bundle, true);
                    w3 w3Var4 = this.f9817b;
                    if (w3Var4 != null) {
                        String str = w3Var4.f9772a;
                        if (str != null) {
                            bundle.putString("_pn", str);
                        }
                        bundle.putString("_pc", this.f9817b.f9773b);
                        bundle.putLong("_pi", this.f9817b.f9774c);
                    }
                    this.f9819d.i().Y(CameraConfig.CAMERA_FOCUS_AUTO, "_vs", bundle);
                }
                x3 x3Var2 = this.f9819d;
                x3Var2.f9794c = this.f9818c;
                x3Var2.l().N(this.f9818c);
            }
        }
        z10 = true;
        if (z10) {
        }
        x3 x3Var22 = this.f9819d;
        x3Var22.f9794c = this.f9818c;
        x3Var22.l().N(this.f9818c);
    }
}
