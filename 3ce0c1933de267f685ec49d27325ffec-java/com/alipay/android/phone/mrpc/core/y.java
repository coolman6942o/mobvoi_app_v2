package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class y implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public g f6801a;

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f6802b;

    /* renamed from: c  reason: collision with root package name */
    public z f6803c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f6801a = gVar;
        this.f6802b = cls;
        this.f6803c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f6803c.a(method, objArr);
    }
}
