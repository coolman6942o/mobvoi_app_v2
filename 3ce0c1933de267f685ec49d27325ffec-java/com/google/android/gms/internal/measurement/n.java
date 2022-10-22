package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    protected volatile int f9521a = -1;

    protected int a() {
        return 0;
    }

    public void b(h hVar) throws IOException {
    }

    public abstract n c(g gVar) throws IOException;

    /* renamed from: d */
    public n clone() throws CloneNotSupportedException {
        return (n) super.clone();
    }

    public final int e() {
        if (this.f9521a < 0) {
            f();
        }
        return this.f9521a;
    }

    public final int f() {
        int a10 = a();
        this.f9521a = a10;
        return a10;
    }

    public String toString() {
        return o.b(this);
    }
}
