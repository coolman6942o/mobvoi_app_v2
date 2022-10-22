package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.m;
/* loaded from: classes.dex */
final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzfo f10330a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10331b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(m.d dVar, zzfo zzfoVar) {
        this.f10331b = dVar;
        this.f10330a = zzfoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.this.onPeerConnected(this.f10330a);
    }
}
