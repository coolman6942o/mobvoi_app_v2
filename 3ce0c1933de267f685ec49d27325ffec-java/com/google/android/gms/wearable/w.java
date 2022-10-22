package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfe;
import com.google.android.gms.wearable.m;
/* loaded from: classes.dex */
final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzfe f10328a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10329b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(m.d dVar, zzfe zzfeVar) {
        this.f10329b = dVar;
        this.f10328a = zzfeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.this.onMessageReceived(this.f10328a);
    }
}
