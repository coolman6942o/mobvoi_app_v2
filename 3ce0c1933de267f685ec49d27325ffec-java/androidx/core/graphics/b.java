package androidx.core.graphics;

import a0.e;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import h0.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: TypefaceCompatApi21Impl.java */
/* loaded from: classes.dex */
class b extends g {

    /* renamed from: b  reason: collision with root package name */
    private static Class<?> f2435b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Constructor<?> f2436c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f2437d = null;

    /* renamed from: e  reason: collision with root package name */
    private static Method f2438e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f2439f = false;

    private static boolean k(Object obj, String str, int i10, boolean z10) {
        n();
        try {
            return ((Boolean) f2437d.invoke(obj, str, Integer.valueOf(i10), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static Typeface l(Object obj) {
        n();
        try {
            Object newInstance = Array.newInstance(f2435b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2438e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    private File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void n() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f2439f) {
            f2439f = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e10) {
                Log.e("TypefaceCompatApi21Impl", e10.getClass().getName(), e10);
                method2 = null;
                cls = null;
                method = null;
            }
            f2436c = constructor;
            f2435b = cls;
            f2437d = method;
            f2438e = method2;
        }
    }

    private static Object o() {
        n();
        try {
            return f2436c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // androidx.core.graphics.g
    public Typeface b(Context context, e.b bVar, Resources resources, int i10) {
        e.c[] a10;
        Object o10 = o();
        for (e.c cVar : bVar.a()) {
            File e10 = b0.e.e(context);
            if (e10 == null) {
                return null;
            }
            try {
                if (!b0.e.c(e10, resources, cVar.b())) {
                    return null;
                }
                if (!k(o10, e10.getPath(), cVar.e(), cVar.f())) {
                    return null;
                }
                e10.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                e10.delete();
            }
        }
        return l(o10);
    }

    @Override // androidx.core.graphics.g
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        if (bVarArr.length < 1) {
            return null;
        }
        f.b h10 = h(bVarArr, i10);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h10.d(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File m10 = m(openFileDescriptor);
            if (m10 != null && m10.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(m10);
                openFileDescriptor.close();
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface d10 = super.d(context, fileInputStream);
            fileInputStream.close();
            openFileDescriptor.close();
            return d10;
        } catch (IOException unused) {
            return null;
        }
    }
}
