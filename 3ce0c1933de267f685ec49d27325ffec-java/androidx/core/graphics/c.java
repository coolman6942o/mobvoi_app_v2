package androidx.core.graphics;

import a0.e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import h0.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: TypefaceCompatApi24Impl.java */
/* loaded from: classes.dex */
class c extends g {

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f2440b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<?> f2441c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f2442d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f2443e;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi24Impl", e10.getClass().getName(), e10);
            cls = null;
            method2 = null;
            method = null;
        }
        f2441c = constructor;
        f2440b = cls;
        f2442d = method;
        f2443e = method2;
    }

    private static boolean k(Object obj, ByteBuffer byteBuffer, int i10, int i11, boolean z10) {
        try {
            return ((Boolean) f2442d.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(f2440b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2443e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        Method method = f2442d;
        if (method == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return method != null;
    }

    private static Object n() {
        try {
            return f2441c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.g
    public Typeface b(Context context, e.b bVar, Resources resources, int i10) {
        e.c[] a10;
        Object n10 = n();
        if (n10 == null) {
            return null;
        }
        for (e.c cVar : bVar.a()) {
            ByteBuffer b10 = b0.e.b(context, resources, cVar.b());
            if (b10 == null || !k(n10, b10, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return l(n10);
    }

    @Override // androidx.core.graphics.g
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        Object n10 = n();
        if (n10 == null) {
            return null;
        }
        androidx.collection.f fVar = new androidx.collection.f();
        for (f.b bVar : bVarArr) {
            Uri d10 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) fVar.get(d10);
            if (byteBuffer == null) {
                byteBuffer = b0.e.f(context, cancellationSignal, d10);
                fVar.put(d10, byteBuffer);
            }
            if (byteBuffer == null || !k(n10, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface l10 = l(n10);
        if (l10 == null) {
            return null;
        }
        return Typeface.create(l10, i10);
    }
}
