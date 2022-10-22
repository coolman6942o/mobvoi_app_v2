package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9488a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9489b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9490c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f9491d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ boolean f9492e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ zzdz f9493f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ a4 f9494g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l4(a4 a4Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z10, zzdz zzdzVar) {
        this.f9494g = a4Var;
        this.f9488a = atomicReference;
        this.f9489b = str;
        this.f9490c = str2;
        this.f9491d = str3;
        this.f9492e = z10;
        this.f9493f = zzdzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        r0 r0Var;
        AtomicReference atomicReference2;
        List<zzjx> G;
        synchronized (this.f9488a) {
            try {
                r0Var = this.f9494g.f9160d;
            } catch (RemoteException e10) {
                this.f9494g.c().K().b("Failed to get user properties", z0.I(this.f9489b), this.f9490c, e10);
                this.f9488a.set(Collections.emptyList());
                atomicReference = this.f9488a;
            }
            if (r0Var == null) {
                this.f9494g.c().K().b("Failed to get user properties", z0.I(this.f9489b), this.f9490c, this.f9491d);
                this.f9488a.set(Collections.emptyList());
                this.f9488a.notify();
                return;
            }
            if (TextUtils.isEmpty(this.f9489b)) {
                atomicReference2 = this.f9488a;
                G = r0Var.f2(this.f9490c, this.f9491d, this.f9492e, this.f9493f);
            } else {
                atomicReference2 = this.f9488a;
                G = r0Var.G(this.f9489b, this.f9490c, this.f9491d, this.f9492e);
            }
            atomicReference2.set(G);
            this.f9494g.R();
            atomicReference = this.f9488a;
            atomicReference.notify();
        }
    }
}
