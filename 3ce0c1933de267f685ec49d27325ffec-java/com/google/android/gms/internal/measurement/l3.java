package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicReference f9483a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f9484b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ String f9485c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ String f9486d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ c3 f9487e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l3(c3 c3Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f9487e = c3Var;
        this.f9483a = atomicReference;
        this.f9484b = str;
        this.f9485c = str2;
        this.f9486d = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9487e.f9815a.q0().J(this.f9483a, this.f9484b, this.f9485c, this.f9486d);
    }
}
