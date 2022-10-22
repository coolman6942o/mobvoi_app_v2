package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class y2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LifecycleCallback f8797a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f8798b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ x2 f8799c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y2(x2 x2Var, LifecycleCallback lifecycleCallback, String str) {
        this.f8799c = x2Var;
        this.f8797a = lifecycleCallback;
        this.f8798b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i10 = this.f8799c.f8789b;
        if (i10 > 0) {
            LifecycleCallback lifecycleCallback = this.f8797a;
            bundle = this.f8799c.f8790c;
            if (bundle != null) {
                bundle3 = this.f8799c.f8790c;
                bundle2 = bundle3.getBundle(this.f8798b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
        i11 = this.f8799c.f8789b;
        if (i11 >= 2) {
            this.f8797a.j();
        }
        i12 = this.f8799c.f8789b;
        if (i12 >= 3) {
            this.f8797a.h();
        }
        i13 = this.f8799c.f8789b;
        if (i13 >= 4) {
            this.f8797a.k();
        }
        i14 = this.f8799c.f8789b;
        if (i14 >= 5) {
            this.f8797a.g();
        }
    }
}
