package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    public g f6799a;

    /* renamed from: b  reason: collision with root package name */
    public z f6800b = new z(this);

    public x(g gVar) {
        this.f6799a = gVar;
    }

    public final g a() {
        return this.f6799a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f6799a, cls, this.f6800b));
    }
}
