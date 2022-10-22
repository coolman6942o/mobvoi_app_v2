package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.vectordrawable.graphics.drawable.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ResourceManagerInternal.java */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: i  reason: collision with root package name */
    private static n0 f1263i;

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, androidx.collection.g<ColorStateList>> f1265a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.collection.f<String, e> f1266b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.collection.g<String> f1267c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, androidx.collection.d<WeakReference<Drawable.ConstantState>>> f1268d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f1269e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1270f;

    /* renamed from: g  reason: collision with root package name */
    private f f1271g;

    /* renamed from: h  reason: collision with root package name */
    private static final PorterDuff.Mode f1262h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j  reason: collision with root package name */
    private static final c f1264j = new c(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.n0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return f.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.n0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e10);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class c extends q.a<Integer, PorterDuffColorFilter> {
        public c(int i10) {
            super(i10);
        }

        private static int i(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter j(int i10, PorterDuff.Mode mode) {
            return c(Integer.valueOf(i(i10, mode)));
        }

        PorterDuffColorFilter k(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return d(Integer.valueOf(i(i10, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.n0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        g.c.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e10) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e10);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public interface f {
        boolean a(Context context, int i10, Drawable drawable);

        PorterDuff.Mode b(int i10);

        Drawable c(n0 n0Var, Context context, int i10);

        ColorStateList d(Context context, int i10);

        boolean e(Context context, int i10, Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceManagerInternal.java */
    /* loaded from: classes.dex */
    public static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.n0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return i.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e10);
                return null;
            }
        }
    }

    private void a(String str, e eVar) {
        if (this.f1266b == null) {
            this.f1266b = new androidx.collection.f<>();
        }
        this.f1266b.put(str, eVar);
    }

    private synchronized boolean b(Context context, long j10, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.collection.d<WeakReference<Drawable.ConstantState>> dVar = this.f1268d.get(context);
        if (dVar == null) {
            dVar = new androidx.collection.d<>();
            this.f1268d.put(context, dVar);
        }
        dVar.k(j10, new WeakReference<>(constantState));
        return true;
    }

    private void c(Context context, int i10, ColorStateList colorStateList) {
        if (this.f1265a == null) {
            this.f1265a = new WeakHashMap<>();
        }
        androidx.collection.g<ColorStateList> gVar = this.f1265a.get(context);
        if (gVar == null) {
            gVar = new androidx.collection.g<>();
            this.f1265a.put(context, gVar);
        }
        gVar.a(i10, colorStateList);
    }

    private void d(Context context) {
        if (!this.f1270f) {
            this.f1270f = true;
            Drawable j10 = j(context, g.d.f27168a);
            if (j10 == null || !q(j10)) {
                this.f1270f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i10) {
        if (this.f1269e == null) {
            this.f1269e = new TypedValue();
        }
        TypedValue typedValue = this.f1269e;
        context.getResources().getValue(i10, typedValue, true);
        long e10 = e(typedValue);
        Drawable i11 = i(context, e10);
        if (i11 != null) {
            return i11;
        }
        f fVar = this.f1271g;
        Drawable c10 = fVar == null ? null : fVar.c(this, context, i10);
        if (c10 != null) {
            c10.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e10, c10);
        }
        return c10;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized n0 h() {
        n0 n0Var;
        synchronized (n0.class) {
            if (f1263i == null) {
                n0 n0Var2 = new n0();
                f1263i = n0Var2;
                p(n0Var2);
            }
            n0Var = f1263i;
        }
        return n0Var;
    }

    private synchronized Drawable i(Context context, long j10) {
        androidx.collection.d<WeakReference<Drawable.ConstantState>> dVar = this.f1268d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> f10 = dVar.f(j10);
        if (f10 != null) {
            Drawable.ConstantState constantState = f10.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.l(j10);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter j10;
        synchronized (n0.class) {
            c cVar = f1264j;
            j10 = cVar.j(i10, mode);
            if (j10 == null) {
                j10 = new PorterDuffColorFilter(i10, mode);
                cVar.k(i10, mode, j10);
            }
        }
        return j10;
    }

    private ColorStateList n(Context context, int i10) {
        androidx.collection.g<ColorStateList> gVar;
        WeakHashMap<Context, androidx.collection.g<ColorStateList>> weakHashMap = this.f1265a;
        if (weakHashMap == null || (gVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return gVar.e(i10);
    }

    private static void p(n0 n0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            n0Var.a("vector", new g());
            n0Var.a("animated-vector", new b());
            n0Var.a("animated-selector", new a());
            n0Var.a("drawable", new d());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i10) {
        int next;
        androidx.collection.f<String, e> fVar = this.f1266b;
        if (fVar == null || fVar.isEmpty()) {
            return null;
        }
        androidx.collection.g<String> gVar = this.f1267c;
        if (gVar != null) {
            String e10 = gVar.e(i10);
            if ("appcompat_skip_skip".equals(e10) || (e10 != null && this.f1266b.get(e10) == null)) {
                return null;
            }
        } else {
            this.f1267c = new androidx.collection.g<>();
        }
        if (this.f1269e == null) {
            this.f1269e = new TypedValue();
        }
        TypedValue typedValue = this.f1269e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long e11 = e(typedValue);
        Drawable i11 = i(context, e11);
        if (i11 != null) {
            return i11;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.f1267c.a(i10, name);
                    e eVar = this.f1266b.get(name);
                    if (eVar != null) {
                        i11 = eVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (i11 != null) {
                        i11.setChangingConfigurations(typedValue.changingConfigurations);
                        b(context, e11, i11);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e12) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e12);
            }
        }
        if (i11 == null) {
            this.f1267c.a(i10, "appcompat_skip_skip");
        }
        return i11;
    }

    private Drawable v(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList m10 = m(context, i10);
        if (m10 != null) {
            if (g0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r10 = androidx.core.graphics.drawable.a.r(drawable);
            androidx.core.graphics.drawable.a.o(r10, m10);
            PorterDuff.Mode o10 = o(i10);
            if (o10 == null) {
                return r10;
            }
            androidx.core.graphics.drawable.a.p(r10, o10);
            return r10;
        }
        f fVar = this.f1271g;
        if ((fVar == null || !fVar.e(context, i10, drawable)) && !x(context, i10, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Drawable drawable, v0 v0Var, int[] iArr) {
        if (!g0.a(drawable) || drawable.mutate() == drawable) {
            boolean z10 = v0Var.f1358d;
            if (z10 || v0Var.f1357c) {
                drawable.setColorFilter(g(z10 ? v0Var.f1355a : null, v0Var.f1357c ? v0Var.f1356b : f1262h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public synchronized Drawable j(Context context, int i10) {
        return k(context, i10, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i10, boolean z10) {
        Drawable r10;
        d(context);
        r10 = r(context, i10);
        if (r10 == null) {
            r10 = f(context, i10);
        }
        if (r10 == null) {
            r10 = androidx.core.content.b.e(context, i10);
        }
        if (r10 != null) {
            r10 = v(context, i10, z10, r10);
        }
        if (r10 != null) {
            g0.b(r10);
        }
        return r10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i10) {
        ColorStateList n10;
        n10 = n(context, i10);
        if (n10 == null) {
            f fVar = this.f1271g;
            n10 = fVar == null ? null : fVar.d(context, i10);
            if (n10 != null) {
                c(context, i10, n10);
            }
        }
        return n10;
    }

    PorterDuff.Mode o(int i10) {
        f fVar = this.f1271g;
        if (fVar == null) {
            return null;
        }
        return fVar.b(i10);
    }

    public synchronized void s(Context context) {
        androidx.collection.d<WeakReference<Drawable.ConstantState>> dVar = this.f1268d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, d1 d1Var, int i10) {
        Drawable r10 = r(context, i10);
        if (r10 == null) {
            r10 = d1Var.a(i10);
        }
        if (r10 == null) {
            return null;
        }
        return v(context, i10, false, r10);
    }

    public synchronized void u(f fVar) {
        this.f1271g = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(Context context, int i10, Drawable drawable) {
        f fVar = this.f1271g;
        return fVar != null && fVar.a(context, i10, drawable);
    }
}
