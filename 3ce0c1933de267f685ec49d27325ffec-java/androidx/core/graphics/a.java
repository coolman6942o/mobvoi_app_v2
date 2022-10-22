package androidx.core.graphics;

import a0.e;
import a0.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import h0.f;
/* compiled from: TypefaceCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final g f2432a;

    /* renamed from: b  reason: collision with root package name */
    private static final q.a<String, Typeface> f2433b;

    /* compiled from: TypefaceCompat.java */
    /* renamed from: androidx.core.graphics.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0019a extends f.c {

        /* renamed from: a  reason: collision with root package name */
        private h.d f2434a;

        public C0019a(h.d dVar) {
            this.f2434a = dVar;
        }

        @Override // h0.f.c
        public void a(int i10) {
            h.d dVar = this.f2434a;
            if (dVar != null) {
                dVar.d(i10);
            }
        }

        @Override // h0.f.c
        public void b(Typeface typeface) {
            h.d dVar = this.f2434a;
            if (dVar != null) {
                dVar.e(typeface);
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f2432a = new f();
        } else if (i10 >= 28) {
            f2432a = new e();
        } else if (i10 >= 26) {
            f2432a = new d();
        } else if (i10 >= 24 && c.m()) {
            f2432a = new c();
        } else if (i10 >= 21) {
            f2432a = new b();
        } else {
            f2432a = new g();
        }
        f2433b = new q.a<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        Typeface g10;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (g10 = g(context, typeface, i10)) == null) ? Typeface.create(typeface, i10) : g10;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        return f2432a.c(context, cancellationSignal, bVarArr, i10);
    }

    public static Typeface c(Context context, e.a aVar, Resources resources, int i10, int i11, h.d dVar, Handler handler, boolean z10) {
        Typeface typeface;
        if (aVar instanceof e.d) {
            e.d dVar2 = (e.d) aVar;
            Typeface h10 = h(dVar2.c());
            if (h10 != null) {
                if (dVar != null) {
                    dVar.b(h10, handler);
                }
                return h10;
            }
            r9 = true;
            boolean z11 = false;
            if (!z10 ? dVar != null : dVar2.a() != 0) {
            }
            int d10 = z10 ? dVar2.d() : -1;
            typeface = f.c(context, dVar2.b(), i11, z11, d10, h.d.c(handler), new C0019a(dVar));
        } else {
            typeface = f2432a.b(context, (e.b) aVar, resources, i11);
            if (dVar != null) {
                if (typeface != null) {
                    dVar.b(typeface, handler);
                } else {
                    dVar.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f2433b.d(e(resources, i10, i11), typeface);
        }
        return typeface;
    }

    public static Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        Typeface e10 = f2432a.e(context, resources, i10, str, i11);
        if (e10 != null) {
            f2433b.d(e(resources, i10, i11), e10);
        }
        return e10;
    }

    private static String e(Resources resources, int i10, int i11) {
        return resources.getResourcePackageName(i10) + "-" + i10 + "-" + i11;
    }

    public static Typeface f(Resources resources, int i10, int i11) {
        return f2433b.c(e(resources, i10, i11));
    }

    private static Typeface g(Context context, Typeface typeface, int i10) {
        g gVar = f2432a;
        e.b i11 = gVar.i(typeface);
        if (i11 == null) {
            return null;
        }
        return gVar.b(context, i11, context.getResources(), i10);
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
