package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.huawei.hms.ml.camera.CameraConfig;
import com.mobvoi.wear.util.LogCleaner;
/* loaded from: classes.dex */
public final class z4 extends z2 {

    /* renamed from: c  reason: collision with root package name */
    private Handler f9851c;

    /* renamed from: e  reason: collision with root package name */
    private final h0 f9853e = new a5(this, this.f9815a);

    /* renamed from: f  reason: collision with root package name */
    private final h0 f9854f = new b5(this, this.f9815a);

    /* renamed from: d  reason: collision with root package name */
    private long f9852d = b().c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public z4(d2 d2Var) {
        super(d2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j10) {
        h0 h0Var;
        long j11;
        e();
        E();
        this.f9853e.a();
        this.f9854f.a();
        c().R().d("Activity resumed, time", Long.valueOf(j10));
        this.f9852d = j10;
        if (b().b() - r().f9447t.a() > r().f9449v.a()) {
            r().f9448u.b(true);
            r().f9450w.b(0L);
        }
        if (r().f9448u.a()) {
            h0Var = this.f9853e;
            j11 = r().f9446s.a();
        } else {
            h0Var = this.f9854f;
            j11 = LogCleaner.ONE_HOUR;
        }
        h0Var.f(Math.max(0L, j11 - r().f9450w.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(long j10) {
        e();
        E();
        this.f9853e.a();
        this.f9854f.a();
        c().R().d("Activity paused, time", Long.valueOf(j10));
        if (this.f9852d != 0) {
            r().f9450w.b(r().f9450w.a() + (j10 - this.f9852d));
        }
    }

    private final void E() {
        synchronized (this) {
            if (this.f9851c == null) {
                this.f9851c = new Handler(Looper.getMainLooper());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        e();
        H(false);
        h().C(b().c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void F() {
        this.f9853e.a();
        this.f9854f.a();
        this.f9852d = 0L;
    }

    public final boolean H(boolean z10) {
        e();
        u();
        long c10 = b().c();
        r().f9449v.b(b().b());
        long j10 = c10 - this.f9852d;
        if (z10 || j10 >= 1000) {
            r().f9450w.b(j10);
            c().R().d("Recording user engagement, ms", Long.valueOf(j10));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j10);
            x3.H(m().M(), bundle, true);
            i().G(CameraConfig.CAMERA_FOCUS_AUTO, "_e", bundle);
            this.f9852d = c10;
            this.f9854f.a();
            this.f9854f.f(Math.max(0L, LogCleaner.ONE_HOUR - r().f9450w.a()));
            return true;
        }
        c().R().d("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j10));
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return false;
    }
}
