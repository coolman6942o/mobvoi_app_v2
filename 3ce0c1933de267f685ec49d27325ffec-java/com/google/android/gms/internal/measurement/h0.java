package com.google.android.gms.internal.measurement;

import android.os.Handler;
import b6.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class h0 {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Handler f9308d;

    /* renamed from: a  reason: collision with root package name */
    private final a3 f9309a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f9310b;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f9311c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(a3 a3Var) {
        i.k(a3Var);
        this.f9309a = a3Var;
        this.f9310b = new i0(this, a3Var);
    }

    private final Handler b() {
        Handler handler;
        if (f9308d != null) {
            return f9308d;
        }
        synchronized (h0.class) {
            if (f9308d == null) {
                f9308d = new Handler(this.f9309a.getContext().getMainLooper());
            }
            handler = f9308d;
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f9311c = 0L;
        b().removeCallbacks(this.f9310b);
    }

    public abstract void c();

    public final boolean e() {
        return this.f9311c != 0;
    }

    public final void f(long j10) {
        a();
        if (j10 >= 0) {
            this.f9311c = this.f9309a.b().b();
            if (!b().postDelayed(this.f9310b, j10)) {
                this.f9309a.c().K().d("Failed to schedule delayed post. time", Long.valueOf(j10));
            }
        }
    }
}
