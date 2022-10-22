package com.google.zxing;

import com.google.zxing.common.b;
/* compiled from: Binarizer.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final c f13401a;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(c cVar) {
        this.f13401a = cVar;
    }

    public abstract a a(c cVar);

    public abstract b b() throws NotFoundException;

    public abstract com.google.zxing.common.a c(int i10, com.google.zxing.common.a aVar) throws NotFoundException;

    public final int d() {
        return this.f13401a.a();
    }

    public final c e() {
        return this.f13401a;
    }

    public final int f() {
        return this.f13401a.d();
    }
}
