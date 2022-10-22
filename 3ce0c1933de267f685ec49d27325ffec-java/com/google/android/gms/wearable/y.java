package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.m;
/* loaded from: classes.dex */
final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzfo f10332a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10333b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(m.d dVar, zzfo zzfoVar) {
        this.f10333b = dVar;
        this.f10332a = zzfoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.this.onPeerDisconnected(this.f10332a);
    }
}
