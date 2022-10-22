package androidx.core.graphics;

import a0.e;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import h0.f;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
/* compiled from: TypefaceCompatApi26Impl.java */
/* loaded from: classes.dex */
public class d extends b {

    /* renamed from: g  reason: collision with root package name */
    protected final Class<?> f2444g;

    /* renamed from: h  reason: collision with root package name */
    protected final Constructor<?> f2445h;

    /* renamed from: i  reason: collision with root package name */
    protected final Method f2446i;

    /* renamed from: j  reason: collision with root package name */
    protected final Method f2447j;

    /* renamed from: k  reason: collision with root package name */
    protected final Method f2448k;

    /* renamed from: l  reason: collision with root package name */
    protected final Method f2449l;

    /* renamed from: m  reason: collision with root package name */
    protected final Method f2450m;

    public d() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> y10 = y();
            constructor = z(y10);
            method4 = v(y10);
            method3 = w(y10);
            method2 = A(y10);
            method = u(y10);
            method5 = x(y10);
            cls = y10;
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e10.getClass().getName(), e10);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f2444g = cls;
        this.f2445h = constructor;
        this.f2446i = method4;
        this.f2447j = method3;
        this.f2448k = method2;
        this.f2449l = method;
        this.f2450m = method5;
    }

    private Object o() {
        try {
            return this.f2445h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void p(Object obj) {
        try {
            this.f2449l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean q(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2446i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean r(Object obj, ByteBuffer byteBuffer, int i10, int i11, int i12) {
        try {
            return ((Boolean) this.f2447j.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Integer.valueOf(i12))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean s(Object obj) {
        try {
            return ((Boolean) this.f2448k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean t() {
        if (this.f2446i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f2446i != null;
    }

    protected Method A(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // androidx.core.graphics.b, androidx.core.graphics.g
    public Typeface b(Context context, e.b bVar, Resources resources, int i10) {
        e.c[] a10;
        if (!t()) {
            return super.b(context, bVar, resources, i10);
        }
        Object o10 = o();
        if (o10 == null) {
            return null;
        }
        for (e.c cVar : bVar.a()) {
            if (!q(context, o10, cVar.a(), cVar.c(), cVar.e(), cVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                p(o10);
                return null;
            }
        }
        if (!s(o10)) {
            return null;
        }
        return l(o10);
    }

    @Override // androidx.core.graphics.b, androidx.core.graphics.g
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        Typeface l10;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!t()) {
            f.b h10 = h(bVarArr, i10);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h10.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(h10.e()).setItalic(h10.f()).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        } else {
            Map<Uri, ByteBuffer> h11 = b0.e.h(context, bVarArr, cancellationSignal);
            Object o10 = o();
            if (o10 == null) {
                return null;
            }
            boolean z10 = false;
            for (f.b bVar : bVarArr) {
                ByteBuffer byteBuffer = h11.get(bVar.d());
                if (byteBuffer != null) {
                    if (!r(o10, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                        p(o10);
                        return null;
                    }
                    z10 = true;
                }
            }
            if (!z10) {
                p(o10);
                return null;
            } else if (s(o10) && (l10 = l(o10)) != null) {
                return Typeface.create(l10, i10);
            } else {
                return null;
            }
        }
    }

    @Override // androidx.core.graphics.g
    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        if (!t()) {
            return super.e(context, resources, i10, str, i11);
        }
        Object o10 = o();
        if (o10 == null) {
            return null;
        }
        if (!q(context, o10, str, 0, -1, -1, null)) {
            p(o10);
            return null;
        } else if (!s(o10)) {
            return null;
        } else {
            return l(o10);
        }
    }

    protected Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2444g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f2450m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method u(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method v(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method w(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class<?> y() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor<?> z(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }
}
