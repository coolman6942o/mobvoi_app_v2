package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;
/* compiled from: UnsafeUtil.java */
/* loaded from: classes.dex */
final class c1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f13194a = g();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f13195b = l();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f13196c = k();

    /* renamed from: d  reason: collision with root package name */
    private static final long f13197d = a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UnsafeUtil.java */
    /* loaded from: classes.dex */
    public static class a implements PrivilegedExceptionAction<Unsafe> {
        a() {
        }

        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields;
            for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    static {
        c(b(Buffer.class, "address"));
    }

    private static int a() {
        if (f13196c) {
            return f13194a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }

    private static Field b(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long c(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = f13194a) == null) {
            return -1L;
        }
        return unsafe.objectFieldOffset(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long d() {
        return f13197d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte e(Object obj, long j10) {
        return f13194a.getByte(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long f(Object obj, long j10) {
        return f13194a.getLong(obj, j10);
    }

    private static Unsafe g() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h() {
        return f13196c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i() {
        return f13195b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(Object obj, long j10, byte b10) {
        f13194a.putByte(obj, j10, b10);
    }

    private static boolean k() {
        Unsafe unsafe = f13194a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("allocateInstance", Class.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean l() {
        Unsafe unsafe = f13194a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("setMemory", cls2, cls2, Byte.TYPE);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
