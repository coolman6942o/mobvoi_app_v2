package a0;

import a0.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f50a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<c, SparseArray<b>> f51b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f52c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        static ColorStateList a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f53a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f54b;

        b(ColorStateList colorStateList, Configuration configuration) {
            this.f53a = colorStateList;
            this.f54b = configuration;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final Resources f55a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f56b;

        c(Resources resources, Resources.Theme theme) {
            this.f55a = resources;
            this.f56b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f55a.equals(cVar.f55a) && j0.c.a(this.f56b, cVar.f56b);
        }

        public int hashCode() {
            return j0.c.b(this.f55a, this.f56b);
        }
    }

    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static abstract class d {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Typeface f57a;

            a(Typeface typeface) {
                this.f57a = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.e(this.f57a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f59a;

            b(int i10) {
                this.f59a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.d(this.f59a);
            }
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void a(int i10, Handler handler) {
            c(handler).post(new b(i10));
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new a(typeface));
        }

        public abstract void d(int i10);

        public abstract void e(Typeface typeface);
    }

    /* compiled from: ResourcesCompat.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f61a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f62b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f63c;

            static void a(Resources.Theme theme) {
                synchronized (f61a) {
                    if (!f63c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f62b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e10) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e10);
                        }
                        f63c = true;
                    }
                    Method method = f62b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e11) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e11);
                            f62b = null;
                        }
                    }
                }
            }
        }

        /* compiled from: ResourcesCompat.java */
        /* loaded from: classes.dex */
        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                b.a(theme);
            } else if (i10 >= 23) {
                a.a(theme);
            }
        }
    }

    private static void a(c cVar, int i10, ColorStateList colorStateList) {
        synchronized (f52c) {
            WeakHashMap<c, SparseArray<b>> weakHashMap = f51b;
            SparseArray<b> sparseArray = weakHashMap.get(cVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(cVar, sparseArray);
            }
            sparseArray.append(i10, new b(colorStateList, cVar.f55a.getConfiguration()));
        }
    }

    private static ColorStateList b(c cVar, int i10) {
        b bVar;
        synchronized (f52c) {
            SparseArray<b> sparseArray = f51b.get(cVar);
            if (!(sparseArray == null || sparseArray.size() <= 0 || (bVar = sparseArray.get(i10)) == null)) {
                if (bVar.f54b.equals(cVar.f55a.getConfiguration())) {
                    return bVar.f53a;
                }
                sparseArray.remove(i10);
            }
            return null;
        }
    }

    public static Typeface c(Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, new TypedValue(), 0, null, null, false, true);
    }

    public static int d(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColor(i10, theme);
        }
        return resources.getColor(i10);
    }

    public static ColorStateList e(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        c cVar = new c(resources, theme);
        ColorStateList b10 = b(cVar, i10);
        if (b10 != null) {
            return b10;
        }
        ColorStateList l10 = l(resources, i10, theme);
        if (l10 != null) {
            a(cVar, i10, l10);
            return l10;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return a.a(resources, i10, theme);
        } else {
            return resources.getColorStateList(i10);
        }
    }

    public static Drawable f(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i10, theme);
        }
        return resources.getDrawable(i10);
    }

    public static Drawable g(Resources resources, int i10, int i11, Resources.Theme theme) throws Resources.NotFoundException {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 21) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
        if (i12 >= 15) {
            return resources.getDrawableForDensity(i10, i11);
        }
        return resources.getDrawable(i10);
    }

    public static Typeface h(Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface i(Context context, int i10, TypedValue typedValue, int i11, d dVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return n(context, i10, typedValue, i11, dVar, null, true, false);
    }

    public static void j(Context context, int i10, d dVar, Handler handler) throws Resources.NotFoundException {
        j0.h.g(dVar);
        if (context.isRestricted()) {
            dVar.a(-4, handler);
        } else {
            n(context, i10, new TypedValue(), 0, dVar, handler, false, false);
        }
    }

    private static TypedValue k() {
        ThreadLocal<TypedValue> threadLocal = f50a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList l(Resources resources, int i10, Resources.Theme theme) {
        if (m(resources, i10)) {
            return null;
        }
        try {
            return a0.c.a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    private static boolean m(Resources resources, int i10) {
        TypedValue k10 = k();
        resources.getValue(i10, k10, true);
        int i11 = k10.type;
        return i11 >= 28 && i11 <= 31;
    }

    private static Typeface n(Context context, int i10, TypedValue typedValue, int i11, d dVar, Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        Typeface o10 = o(context, resources, typedValue, i10, i11, dVar, handler, z10, z11);
        if (o10 != null || dVar != null || z11) {
            return o10;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface o(Context context, Resources resources, TypedValue typedValue, int i10, int i11, d dVar, Handler handler, boolean z10, boolean z11) {
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            if (!charSequence2.startsWith("res/")) {
                if (dVar != null) {
                    dVar.a(-3, handler);
                }
                return null;
            }
            Typeface f10 = androidx.core.graphics.a.f(resources, i10, i11);
            if (f10 != null) {
                if (dVar != null) {
                    dVar.b(f10, handler);
                }
                return f10;
            } else if (z11) {
                return null;
            } else {
                try {
                    if (charSequence2.toLowerCase().endsWith(".xml")) {
                        e.a b10 = a0.e.b(resources.getXml(i10), resources);
                        if (b10 != null) {
                            return androidx.core.graphics.a.c(context, b10, resources, i10, i11, dVar, handler, z10);
                        }
                        Log.e("ResourcesCompat", "Failed to find font-family tag");
                        if (dVar != null) {
                            dVar.a(-3, handler);
                        }
                        return null;
                    }
                    Typeface d10 = androidx.core.graphics.a.d(context, resources, i10, charSequence2, i11);
                    if (dVar != null) {
                        if (d10 != null) {
                            dVar.b(d10, handler);
                        } else {
                            dVar.a(-3, handler);
                        }
                    }
                    return d10;
                } catch (IOException e10) {
                    Log.e("ResourcesCompat", "Failed to read xml resource " + charSequence2, e10);
                    if (dVar != null) {
                        dVar.a(-3, handler);
                    }
                    return null;
                } catch (XmlPullParserException e11) {
                    Log.e("ResourcesCompat", "Failed to parse xml resource " + charSequence2, e11);
                    if (dVar != null) {
                    }
                    return null;
                }
            }
        } else {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i10) + "\" (" + Integer.toHexString(i10) + ") is not a Font: " + typedValue);
        }
    }
}
