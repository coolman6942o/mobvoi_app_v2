package com.google.android.gms.common.api.internal;

import android.os.Bundle;
/* loaded from: classes.dex */
final class a3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ LifecycleCallback f8508a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f8509b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ z2 f8510c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a3(z2 z2Var, LifecycleCallback lifecycleCallback, String str) {
        this.f8510c = z2Var;
        this.f8508a = lifecycleCallback;
        this.f8509b = str;
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
        i10 = this.f8510c.f8804b;
        if (i10 > 0) {
            LifecycleCallback lifecycleCallback = this.f8508a;
            bundle = this.f8510c.f8805c;
            if (bundle != null) {
                bundle3 = this.f8510c.f8805c;
                bundle2 = bundle3.getBundle(this.f8509b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.f(bundle2);
        }
        i11 = this.f8510c.f8804b;
        if (i11 >= 2) {
            this.f8508a.j();
        }
        i12 = this.f8510c.f8804b;
        if (i12 >= 3) {
            this.f8508a.h();
        }
        i13 = this.f8510c.f8804b;
        if (i13 >= 4) {
            this.f8508a.k();
        }
        i14 = this.f8510c.f8804b;
        if (i14 >= 5) {
            this.f8508a.g();
        }
    }
}
