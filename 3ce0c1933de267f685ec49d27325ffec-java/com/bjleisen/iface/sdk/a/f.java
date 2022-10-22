package com.bjleisen.iface.sdk.a;

import java.lang.ref.WeakReference;
/* compiled from: RequestHandle.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<c> f7653a;

    public f(c cVar) {
        this.f7653a = new WeakReference<>(cVar);
    }

    private boolean c() {
        c cVar = this.f7653a.get();
        return cVar == null || cVar.b();
    }

    private boolean d() {
        c cVar = this.f7653a.get();
        return cVar == null || cVar.a();
    }

    public final boolean a() {
        c cVar = this.f7653a.get();
        return cVar == null || cVar.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if ((r0 == null || r0.a()) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b() {
        c cVar = this.f7653a.get();
        boolean z10 = false;
        if (!(cVar == null || cVar.b())) {
            c cVar2 = this.f7653a.get();
        }
        z10 = true;
        if (z10) {
            this.f7653a.clear();
        }
        return z10;
    }
}
