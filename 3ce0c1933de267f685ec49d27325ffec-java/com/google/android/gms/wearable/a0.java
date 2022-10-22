package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.m;
/* loaded from: classes.dex */
final class a0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzah f10206a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10207b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(m.d dVar, zzah zzahVar) {
        this.f10207b = dVar;
        this.f10206a = zzahVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.this.onCapabilityChanged(this.f10206a);
    }
}
