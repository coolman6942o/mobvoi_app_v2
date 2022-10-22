package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.m;
/* loaded from: classes.dex */
final class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzi f10210a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10211b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(m.d dVar, zzi zziVar) {
        this.f10211b = dVar;
        this.f10210a = zziVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.wearable.internal.zzi, com.google.android.gms.wearable.o] */
    @Override // java.lang.Runnable
    public final void run() {
        m.this.onEntityUpdate(this.f10210a);
    }
}
