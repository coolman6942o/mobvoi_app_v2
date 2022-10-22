package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9456a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9457b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9458c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f9459d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ zzdz f9460e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ a4 f9461f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k4(a4 a4Var, AtomicReference atomicReference, String str, String str2, String str3, zzdz zzdzVar) {
        this.f9461f = a4Var;
        this.f9456a = atomicReference;
        this.f9457b = str;
        this.f9458c = str2;
        this.f9459d = str3;
        this.f9460e = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        r0 r0Var;
        AtomicReference atomicReference2;
        List<zzed> e22;
        synchronized (this.f9456a) {
            try {
                r0Var = this.f9461f.f9160d;
            } catch (RemoteException e10) {
                this.f9461f.c().K().b("Failed to get conditional properties", z0.I(this.f9457b), this.f9458c, e10);
                this.f9456a.set(Collections.emptyList());
                atomicReference = this.f9456a;
            }
            if (r0Var == null) {
                this.f9461f.c().K().b("Failed to get conditional properties", z0.I(this.f9457b), this.f9458c, this.f9459d);
                this.f9456a.set(Collections.emptyList());
                this.f9456a.notify();
                return;
            }
            if (TextUtils.isEmpty(this.f9457b)) {
                atomicReference2 = this.f9456a;
                e22 = r0Var.v2(this.f9458c, this.f9459d, this.f9460e);
            } else {
                atomicReference2 = this.f9456a;
                e22 = r0Var.e2(this.f9457b, this.f9458c, this.f9459d);
            }
            atomicReference2.set(e22);
            this.f9461f.R();
            atomicReference = this.f9456a;
            atomicReference.notify();
        }
    }
}
