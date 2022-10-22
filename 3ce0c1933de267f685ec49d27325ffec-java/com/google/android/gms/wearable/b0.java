package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.m;
/* loaded from: classes.dex */
final class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzl f10208a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10209b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(m.d dVar, zzl zzlVar) {
        this.f10209b = dVar;
        this.f10208a = zzlVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.wearable.internal.zzl, com.google.android.gms.wearable.p] */
    @Override // java.lang.Runnable
    public final void run() {
        m.this.onNotificationReceived(this.f10208a);
    }
}
