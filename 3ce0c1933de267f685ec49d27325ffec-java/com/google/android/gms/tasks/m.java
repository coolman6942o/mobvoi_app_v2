package com.google.android.gms.tasks;

import b7.c;
/* loaded from: classes.dex */
final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b f10171a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ l f10172b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, b bVar) {
        this.f10172b = lVar;
        this.f10171a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        c cVar;
        c cVar2;
        obj = this.f10172b.f10169b;
        synchronized (obj) {
            cVar = this.f10172b.f10170c;
            if (cVar != null) {
                cVar2 = this.f10172b.f10170c;
                cVar2.onFailure(this.f10171a.j());
            }
        }
    }
}
