package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public class n0 {

    /* renamed from: b  reason: collision with root package name */
    public static final n0 f2580b;

    /* renamed from: a  reason: collision with root package name */
    private final l f2581a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WindowInsetsCompat.java */
    @SuppressLint({"SoonBlockedPrivateApi"})
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f2582a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f2583b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f2584c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f2585d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f2582a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f2583b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f2584c = declaredField3;
                declaredField3.setAccessible(true);
                f2585d = true;
            } catch (ReflectiveOperationException e10) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        public static n0 a(View view) {
            if (f2585d && view.isAttachedToWindow()) {
                try {
                    Object obj = f2582a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f2583b.get(obj);
                        Rect rect2 = (Rect) f2584c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            n0 a10 = new b().b(b0.b.c(rect)).c(b0.b.c(rect2)).a();
                            a10.t(a10);
                            a10.d(view.getRootView());
                            return a10;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                }
            }
            return null;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class e extends d {
        e() {
        }

        e(n0 n0Var) {
            super(n0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private final n0 f2594a;

        /* renamed from: b  reason: collision with root package name */
        b0.b[] f2595b;

        f() {
            this(new n0((n0) null));
        }

        protected final void a() {
            b0.b[] bVarArr = this.f2595b;
            if (bVarArr != null) {
                b0.b bVar = bVarArr[m.a(1)];
                b0.b bVar2 = this.f2595b[m.a(2)];
                if (bVar2 == null) {
                    bVar2 = this.f2594a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f2594a.f(1);
                }
                f(b0.b.a(bVar, bVar2));
                b0.b bVar3 = this.f2595b[m.a(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                b0.b bVar4 = this.f2595b[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                b0.b bVar5 = this.f2595b[m.a(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        n0 b() {
            a();
            return this.f2594a;
        }

        void c(b0.b bVar) {
        }

        void d(b0.b bVar) {
        }

        void e(b0.b bVar) {
        }

        void f(b0.b bVar) {
        }

        void g(b0.b bVar) {
        }

        f(n0 n0Var) {
            this.f2594a = n0Var;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class i extends h {
        i(n0 n0Var, WindowInsets windowInsets) {
            super(n0Var, windowInsets);
        }

        @Override // androidx.core.view.n0.l
        n0 a() {
            return n0.w(this.f2601c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.n0.g, androidx.core.view.n0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f2601c, iVar.f2601c) && Objects.equals(this.f2605g, iVar.f2605g);
        }

        @Override // androidx.core.view.n0.l
        androidx.core.view.d f() {
            return androidx.core.view.d.e(this.f2601c.getDisplayCutout());
        }

        @Override // androidx.core.view.n0.l
        public int hashCode() {
            return this.f2601c.hashCode();
        }

        i(n0 n0Var, i iVar) {
            super(n0Var, iVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class k extends j {

        /* renamed from: q  reason: collision with root package name */
        static final n0 f2610q = n0.w(WindowInsets.CONSUMED);

        k(n0 n0Var, WindowInsets windowInsets) {
            super(n0Var, windowInsets);
        }

        @Override // androidx.core.view.n0.g, androidx.core.view.n0.l
        final void d(View view) {
        }

        @Override // androidx.core.view.n0.g, androidx.core.view.n0.l
        public b0.b g(int i10) {
            return b0.b.d(this.f2601c.getInsets(n.a(i10)));
        }

        k(n0 n0Var, k kVar) {
            super(n0Var, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: b  reason: collision with root package name */
        static final n0 f2611b = new b().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final n0 f2612a;

        l(n0 n0Var) {
            this.f2612a = n0Var;
        }

        n0 a() {
            return this.f2612a;
        }

        n0 b() {
            return this.f2612a;
        }

        n0 c() {
            return this.f2612a;
        }

        void d(View view) {
        }

        void e(n0 n0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return o() == lVar.o() && n() == lVar.n() && j0.c.a(k(), lVar.k()) && j0.c.a(i(), lVar.i()) && j0.c.a(f(), lVar.f());
        }

        androidx.core.view.d f() {
            return null;
        }

        b0.b g(int i10) {
            return b0.b.f4958e;
        }

        b0.b h() {
            return k();
        }

        public int hashCode() {
            return j0.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        b0.b i() {
            return b0.b.f4958e;
        }

        b0.b j() {
            return k();
        }

        b0.b k() {
            return b0.b.f4958e;
        }

        b0.b l() {
            return k();
        }

        n0 m(int i10, int i11, int i12, int i13) {
            return f2611b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(b0.b[] bVarArr) {
        }

        void q(b0.b bVar) {
        }

        void r(n0 n0Var) {
        }

        public void s(b0.b bVar) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class m {
        static int a(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        public static int b() {
            return 7;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static final class n {
        static int a(int i10) {
            int i11;
            int i12 = 0;
            for (int i13 = 1; i13 <= 256; i13 <<= 1) {
                if ((i10 & i13) != 0) {
                    if (i13 == 1) {
                        i11 = WindowInsets.Type.statusBars();
                    } else if (i13 == 2) {
                        i11 = WindowInsets.Type.navigationBars();
                    } else if (i13 == 4) {
                        i11 = WindowInsets.Type.captionBar();
                    } else if (i13 == 8) {
                        i11 = WindowInsets.Type.ime();
                    } else if (i13 == 16) {
                        i11 = WindowInsets.Type.systemGestures();
                    } else if (i13 == 32) {
                        i11 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i13 == 64) {
                        i11 = WindowInsets.Type.tappableElement();
                    } else if (i13 == 128) {
                        i11 = WindowInsets.Type.displayCutout();
                    }
                    i12 |= i11;
                }
            }
            return i12;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f2580b = k.f2610q;
        } else {
            f2580b = l.f2611b;
        }
    }

    private n0(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f2581a = new k(this, windowInsets);
        } else if (i10 >= 29) {
            this.f2581a = new j(this, windowInsets);
        } else if (i10 >= 28) {
            this.f2581a = new i(this, windowInsets);
        } else if (i10 >= 21) {
            this.f2581a = new h(this, windowInsets);
        } else if (i10 >= 20) {
            this.f2581a = new g(this, windowInsets);
        } else {
            this.f2581a = new l(this);
        }
    }

    static b0.b o(b0.b bVar, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, bVar.f4959a - i10);
        int max2 = Math.max(0, bVar.f4960b - i11);
        int max3 = Math.max(0, bVar.f4961c - i12);
        int max4 = Math.max(0, bVar.f4962d - i13);
        return (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) ? bVar : b0.b.b(max, max2, max3, max4);
    }

    public static n0 w(WindowInsets windowInsets) {
        return x(windowInsets, null);
    }

    public static n0 x(WindowInsets windowInsets, View view) {
        n0 n0Var = new n0((WindowInsets) j0.h.g(windowInsets));
        if (view != null && d0.W(view)) {
            n0Var.t(d0.L(view));
            n0Var.d(view.getRootView());
        }
        return n0Var;
    }

    @Deprecated
    public n0 a() {
        return this.f2581a.a();
    }

    @Deprecated
    public n0 b() {
        return this.f2581a.b();
    }

    @Deprecated
    public n0 c() {
        return this.f2581a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        this.f2581a.d(view);
    }

    public androidx.core.view.d e() {
        return this.f2581a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        return j0.c.a(this.f2581a, ((n0) obj).f2581a);
    }

    public b0.b f(int i10) {
        return this.f2581a.g(i10);
    }

    @Deprecated
    public b0.b g() {
        return this.f2581a.h();
    }

    @Deprecated
    public b0.b h() {
        return this.f2581a.i();
    }

    public int hashCode() {
        l lVar = this.f2581a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    @Deprecated
    public b0.b i() {
        return this.f2581a.j();
    }

    @Deprecated
    public int j() {
        return this.f2581a.k().f4962d;
    }

    @Deprecated
    public int k() {
        return this.f2581a.k().f4959a;
    }

    @Deprecated
    public int l() {
        return this.f2581a.k().f4961c;
    }

    @Deprecated
    public int m() {
        return this.f2581a.k().f4960b;
    }

    public n0 n(int i10, int i11, int i12, int i13) {
        return this.f2581a.m(i10, i11, i12, i13);
    }

    public boolean p() {
        return this.f2581a.n();
    }

    @Deprecated
    public n0 q(int i10, int i11, int i12, int i13) {
        return new b(this).c(b0.b.b(i10, i11, i12, i13)).a();
    }

    void r(b0.b[] bVarArr) {
        this.f2581a.p(bVarArr);
    }

    void s(b0.b bVar) {
        this.f2581a.q(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(n0 n0Var) {
        this.f2581a.r(n0Var);
    }

    void u(b0.b bVar) {
        this.f2581a.s(bVar);
    }

    public WindowInsets v() {
        l lVar = this.f2581a;
        if (lVar instanceof g) {
            return ((g) lVar).f2601c;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private static Field f2587e = null;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f2588f = false;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor<WindowInsets> f2589g = null;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f2590h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f2591c;

        /* renamed from: d  reason: collision with root package name */
        private b0.b f2592d;

        c() {
            this.f2591c = h();
        }

        private static WindowInsets h() {
            if (!f2588f) {
                try {
                    f2587e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f2588f = true;
            }
            Field field = f2587e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!f2590h) {
                try {
                    f2589g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f2590h = true;
            }
            Constructor<WindowInsets> constructor = f2589g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        @Override // androidx.core.view.n0.f
        n0 b() {
            a();
            n0 w10 = n0.w(this.f2591c);
            w10.r(this.f2595b);
            w10.u(this.f2592d);
            return w10;
        }

        @Override // androidx.core.view.n0.f
        void d(b0.b bVar) {
            this.f2592d = bVar;
        }

        @Override // androidx.core.view.n0.f
        void f(b0.b bVar) {
            WindowInsets windowInsets = this.f2591c;
            if (windowInsets != null) {
                this.f2591c = windowInsets.replaceSystemWindowInsets(bVar.f4959a, bVar.f4960b, bVar.f4961c, bVar.f4962d);
            }
        }

        c(n0 n0Var) {
            super(n0Var);
            this.f2591c = n0Var.v();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets.Builder f2593c;

        d() {
            this.f2593c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.n0.f
        n0 b() {
            a();
            n0 w10 = n0.w(this.f2593c.build());
            w10.r(this.f2595b);
            return w10;
        }

        @Override // androidx.core.view.n0.f
        void c(b0.b bVar) {
            this.f2593c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.n0.f
        void d(b0.b bVar) {
            this.f2593c.setStableInsets(bVar.e());
        }

        @Override // androidx.core.view.n0.f
        void e(b0.b bVar) {
            this.f2593c.setSystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.n0.f
        void f(b0.b bVar) {
            this.f2593c.setSystemWindowInsets(bVar.e());
        }

        @Override // androidx.core.view.n0.f
        void g(b0.b bVar) {
            this.f2593c.setTappableElementInsets(bVar.e());
        }

        d(n0 n0Var) {
            super(n0Var);
            WindowInsets.Builder builder;
            WindowInsets v10 = n0Var.v();
            if (v10 != null) {
                builder = new WindowInsets.Builder(v10);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f2593c = builder;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class h extends g {

        /* renamed from: m  reason: collision with root package name */
        private b0.b f2606m;

        h(n0 n0Var, WindowInsets windowInsets) {
            super(n0Var, windowInsets);
            this.f2606m = null;
        }

        @Override // androidx.core.view.n0.l
        n0 b() {
            return n0.w(this.f2601c.consumeStableInsets());
        }

        @Override // androidx.core.view.n0.l
        n0 c() {
            return n0.w(this.f2601c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.n0.l
        final b0.b i() {
            if (this.f2606m == null) {
                this.f2606m = b0.b.b(this.f2601c.getStableInsetLeft(), this.f2601c.getStableInsetTop(), this.f2601c.getStableInsetRight(), this.f2601c.getStableInsetBottom());
            }
            return this.f2606m;
        }

        @Override // androidx.core.view.n0.l
        boolean n() {
            return this.f2601c.isConsumed();
        }

        @Override // androidx.core.view.n0.l
        public void s(b0.b bVar) {
            this.f2606m = bVar;
        }

        h(n0 n0Var, h hVar) {
            super(n0Var, hVar);
            this.f2606m = null;
            this.f2606m = hVar.f2606m;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static class g extends l {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f2596h = false;

        /* renamed from: i  reason: collision with root package name */
        private static Method f2597i;

        /* renamed from: j  reason: collision with root package name */
        private static Class<?> f2598j;

        /* renamed from: k  reason: collision with root package name */
        private static Field f2599k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f2600l;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f2601c;

        /* renamed from: d  reason: collision with root package name */
        private b0.b[] f2602d;

        /* renamed from: e  reason: collision with root package name */
        private b0.b f2603e;

        /* renamed from: f  reason: collision with root package name */
        private n0 f2604f;

        /* renamed from: g  reason: collision with root package name */
        b0.b f2605g;

        g(n0 n0Var, WindowInsets windowInsets) {
            super(n0Var);
            this.f2603e = null;
            this.f2601c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private b0.b t(int i10, boolean z10) {
            b0.b bVar = b0.b.f4958e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    bVar = b0.b.a(bVar, u(i11, z10));
                }
            }
            return bVar;
        }

        private b0.b v() {
            n0 n0Var = this.f2604f;
            if (n0Var != null) {
                return n0Var.h();
            }
            return b0.b.f4958e;
        }

        private b0.b w(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f2596h) {
                    x();
                }
                Method method = f2597i;
                if (!(method == null || f2598j == null || f2599k == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f2599k.get(f2600l.get(invoke));
                        if (rect != null) {
                            return b0.b.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e10) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void x() {
            try {
                f2597i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f2598j = cls;
                f2599k = cls.getDeclaredField("mVisibleInsets");
                f2600l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f2599k.setAccessible(true);
                f2600l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f2596h = true;
        }

        @Override // androidx.core.view.n0.l
        void d(View view) {
            b0.b w10 = w(view);
            if (w10 == null) {
                w10 = b0.b.f4958e;
            }
            q(w10);
        }

        @Override // androidx.core.view.n0.l
        void e(n0 n0Var) {
            n0Var.t(this.f2604f);
            n0Var.s(this.f2605g);
        }

        @Override // androidx.core.view.n0.l
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f2605g, ((g) obj).f2605g);
        }

        @Override // androidx.core.view.n0.l
        public b0.b g(int i10) {
            return t(i10, false);
        }

        @Override // androidx.core.view.n0.l
        final b0.b k() {
            if (this.f2603e == null) {
                this.f2603e = b0.b.b(this.f2601c.getSystemWindowInsetLeft(), this.f2601c.getSystemWindowInsetTop(), this.f2601c.getSystemWindowInsetRight(), this.f2601c.getSystemWindowInsetBottom());
            }
            return this.f2603e;
        }

        @Override // androidx.core.view.n0.l
        n0 m(int i10, int i11, int i12, int i13) {
            b bVar = new b(n0.w(this.f2601c));
            bVar.c(n0.o(k(), i10, i11, i12, i13));
            bVar.b(n0.o(i(), i10, i11, i12, i13));
            return bVar.a();
        }

        @Override // androidx.core.view.n0.l
        boolean o() {
            return this.f2601c.isRound();
        }

        @Override // androidx.core.view.n0.l
        public void p(b0.b[] bVarArr) {
            this.f2602d = bVarArr;
        }

        @Override // androidx.core.view.n0.l
        void q(b0.b bVar) {
            this.f2605g = bVar;
        }

        @Override // androidx.core.view.n0.l
        void r(n0 n0Var) {
            this.f2604f = n0Var;
        }

        protected b0.b u(int i10, boolean z10) {
            int i11;
            androidx.core.view.d dVar;
            if (i10 != 1) {
                b0.b bVar = null;
                if (i10 != 2) {
                    if (i10 == 8) {
                        b0.b[] bVarArr = this.f2602d;
                        if (bVarArr != null) {
                            bVar = bVarArr[m.a(8)];
                        }
                        if (bVar != null) {
                            return bVar;
                        }
                        b0.b k10 = k();
                        b0.b v10 = v();
                        int i12 = k10.f4962d;
                        if (i12 > v10.f4962d) {
                            return b0.b.b(0, 0, 0, i12);
                        }
                        b0.b bVar2 = this.f2605g;
                        if (bVar2 == null || bVar2.equals(b0.b.f4958e) || (i11 = this.f2605g.f4962d) <= v10.f4962d) {
                            return b0.b.f4958e;
                        }
                        return b0.b.b(0, 0, 0, i11);
                    } else if (i10 == 16) {
                        return j();
                    } else {
                        if (i10 == 32) {
                            return h();
                        }
                        if (i10 == 64) {
                            return l();
                        }
                        if (i10 != 128) {
                            return b0.b.f4958e;
                        }
                        n0 n0Var = this.f2604f;
                        if (n0Var != null) {
                            dVar = n0Var.e();
                        } else {
                            dVar = f();
                        }
                        if (dVar != null) {
                            return b0.b.b(dVar.b(), dVar.d(), dVar.c(), dVar.a());
                        }
                        return b0.b.f4958e;
                    }
                } else if (z10) {
                    b0.b v11 = v();
                    b0.b i13 = i();
                    return b0.b.b(Math.max(v11.f4959a, i13.f4959a), 0, Math.max(v11.f4961c, i13.f4961c), Math.max(v11.f4962d, i13.f4962d));
                } else {
                    b0.b k11 = k();
                    n0 n0Var2 = this.f2604f;
                    if (n0Var2 != null) {
                        bVar = n0Var2.h();
                    }
                    int i14 = k11.f4962d;
                    if (bVar != null) {
                        i14 = Math.min(i14, bVar.f4962d);
                    }
                    return b0.b.b(k11.f4959a, 0, k11.f4961c, i14);
                }
            } else if (z10) {
                return b0.b.b(0, Math.max(v().f4960b, k().f4960b), 0, 0);
            } else {
                return b0.b.b(0, k().f4960b, 0, 0);
            }
        }

        g(n0 n0Var, g gVar) {
            this(n0Var, new WindowInsets(gVar.f2601c));
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    private static class j extends i {

        /* renamed from: n  reason: collision with root package name */
        private b0.b f2607n = null;

        /* renamed from: o  reason: collision with root package name */
        private b0.b f2608o = null;

        /* renamed from: p  reason: collision with root package name */
        private b0.b f2609p = null;

        j(n0 n0Var, WindowInsets windowInsets) {
            super(n0Var, windowInsets);
        }

        @Override // androidx.core.view.n0.l
        b0.b h() {
            if (this.f2608o == null) {
                this.f2608o = b0.b.d(this.f2601c.getMandatorySystemGestureInsets());
            }
            return this.f2608o;
        }

        @Override // androidx.core.view.n0.l
        b0.b j() {
            if (this.f2607n == null) {
                this.f2607n = b0.b.d(this.f2601c.getSystemGestureInsets());
            }
            return this.f2607n;
        }

        @Override // androidx.core.view.n0.l
        b0.b l() {
            if (this.f2609p == null) {
                this.f2609p = b0.b.d(this.f2601c.getTappableElementInsets());
            }
            return this.f2609p;
        }

        @Override // androidx.core.view.n0.g, androidx.core.view.n0.l
        n0 m(int i10, int i11, int i12, int i13) {
            return n0.w(this.f2601c.inset(i10, i11, i12, i13));
        }

        @Override // androidx.core.view.n0.h, androidx.core.view.n0.l
        public void s(b0.b bVar) {
        }

        j(n0 n0Var, j jVar) {
            super(n0Var, jVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final f f2586a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f2586a = new e();
            } else if (i10 >= 29) {
                this.f2586a = new d();
            } else if (i10 >= 20) {
                this.f2586a = new c();
            } else {
                this.f2586a = new f();
            }
        }

        public n0 a() {
            return this.f2586a.b();
        }

        @Deprecated
        public b b(b0.b bVar) {
            this.f2586a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(b0.b bVar) {
            this.f2586a.f(bVar);
            return this;
        }

        public b(n0 n0Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f2586a = new e(n0Var);
            } else if (i10 >= 29) {
                this.f2586a = new d(n0Var);
            } else if (i10 >= 20) {
                this.f2586a = new c(n0Var);
            } else {
                this.f2586a = new f(n0Var);
            }
        }
    }

    public n0(n0 n0Var) {
        if (n0Var != null) {
            l lVar = n0Var.f2581a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (lVar instanceof k)) {
                this.f2581a = new k(this, (k) lVar);
            } else if (i10 >= 29 && (lVar instanceof j)) {
                this.f2581a = new j(this, (j) lVar);
            } else if (i10 >= 28 && (lVar instanceof i)) {
                this.f2581a = new i(this, (i) lVar);
            } else if (i10 >= 21 && (lVar instanceof h)) {
                this.f2581a = new h(this, (h) lVar);
            } else if (i10 < 20 || !(lVar instanceof g)) {
                this.f2581a = new l(this);
            } else {
                this.f2581a = new g(this, (g) lVar);
            }
            lVar.e(this);
            return;
        }
        this.f2581a = new l(this);
    }
}
