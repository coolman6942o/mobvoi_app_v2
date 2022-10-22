package com.google.android.gms.tasks;

import b7.d;
/* loaded from: classes.dex */
final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b f10176a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ n f10177b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, b bVar) {
        this.f10177b = nVar;
        this.f10176a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        d dVar;
        d dVar2;
        obj = this.f10177b.f10174b;
        synchronized (obj) {
            dVar = this.f10177b.f10175c;
            if (dVar != null) {
                dVar2 = this.f10177b.f10175c;
                dVar2.onSuccess(this.f10176a.k());
            }
        }
    }
}
