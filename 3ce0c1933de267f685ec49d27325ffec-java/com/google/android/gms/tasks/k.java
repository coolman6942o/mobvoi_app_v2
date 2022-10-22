package com.google.android.gms.tasks;

import b7.b;
/* loaded from: classes.dex */
final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b f10166a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ j f10167b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, b bVar) {
        this.f10167b = jVar;
        this.f10166a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        b bVar;
        b bVar2;
        obj = this.f10167b.f10164b;
        synchronized (obj) {
            bVar = this.f10167b.f10165c;
            if (bVar != null) {
                bVar2 = this.f10167b.f10165c;
                bVar2.a(this.f10166a);
            }
        }
    }
}
