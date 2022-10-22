package com.google.zxing;

import com.google.zxing.common.a;
/* compiled from: BinaryBitmap.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final a f13402a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.zxing.common.b f13403b;

    public b(a aVar) {
        if (aVar != null) {
            this.f13402a = aVar;
            return;
        }
        throw new IllegalArgumentException("Binarizer must be non-null.");
    }

    public com.google.zxing.common.b a() throws NotFoundException {
        if (this.f13403b == null) {
            this.f13403b = this.f13402a.b();
        }
        return this.f13403b;
    }

    public a b(int i10, a aVar) throws NotFoundException {
        return this.f13402a.c(i10, aVar);
    }

    public int c() {
        return this.f13402a.d();
    }

    public int d() {
        return this.f13402a.f();
    }

    public boolean e() {
        return this.f13402a.e().e();
    }

    public b f() {
        return new b(this.f13402a.a(this.f13402a.e().f()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
