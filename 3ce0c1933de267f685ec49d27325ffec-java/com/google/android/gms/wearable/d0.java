package com.google.android.gms.wearable;

import c7.e;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.m;
/* loaded from: classes.dex */
final class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzaw f10212a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10213b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(m.d dVar, zzaw zzawVar) {
        this.f10213b = dVar;
        this.f10212a = zzawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar;
        this.f10212a.G0(m.this);
        zzaw zzawVar = this.f10212a;
        eVar = m.this.zzaj;
        zzawVar.G0(eVar);
    }
}
