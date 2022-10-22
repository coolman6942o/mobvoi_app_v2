package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
/* loaded from: classes.dex */
final class q4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ComponentName f9611a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ o4 f9612b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q4(o4 o4Var, ComponentName componentName) {
        this.f9612b = o4Var;
        this.f9611a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9612b.f9554c.B(this.f9611a);
    }
}
