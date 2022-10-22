package com.google.common.reflect;

import com.google.common.base.p;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
/* compiled from: Reflection.java */
/* loaded from: classes.dex */
public final class c {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        p.o(invocationHandler);
        p.j(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
