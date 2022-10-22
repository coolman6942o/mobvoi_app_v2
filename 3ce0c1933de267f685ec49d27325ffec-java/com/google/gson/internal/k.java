package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* compiled from: UnsafeAllocator.java */
/* loaded from: classes.dex */
public abstract class k {

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class a extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f12647a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f12648b;

        a(Method method, Object obj) {
            this.f12647a = method;
            this.f12648b = obj;
        }

        @Override // com.google.gson.internal.k
        public <T> T c(Class<T> cls) throws Exception {
            k.a(cls);
            return (T) this.f12647a.invoke(this.f12648b, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class b extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f12649a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f12650b;

        b(Method method, int i10) {
            this.f12649a = method;
            this.f12650b = i10;
        }

        @Override // com.google.gson.internal.k
        public <T> T c(Class<T> cls) throws Exception {
            k.a(cls);
            return (T) this.f12649a.invoke(null, cls, Integer.valueOf(this.f12650b));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class c extends k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f12651a;

        c(Method method) {
            this.f12651a = method;
        }

        @Override // com.google.gson.internal.k
        public <T> T c(Class<T> cls) throws Exception {
            k.a(cls);
            return (T) this.f12651a.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* loaded from: classes.dex */
    static class d extends k {
        d() {
        }

        @Override // com.google.gson.internal.k
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        } else if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static k b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}
