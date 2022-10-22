package com.google.android.gms.tasks;

import b7.a;
/* loaded from: classes.dex */
final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ h f10162a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f10162a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        a aVar;
        a aVar2;
        obj = this.f10162a.f10160b;
        synchronized (obj) {
            aVar = this.f10162a.f10161c;
            if (aVar != null) {
                aVar2 = this.f10162a.f10161c;
                aVar2.onCanceled();
            }
        }
    }
}
