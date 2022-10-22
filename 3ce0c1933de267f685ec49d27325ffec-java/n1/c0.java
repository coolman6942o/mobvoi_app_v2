package n1;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.d0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    private static final i0 f30884a;

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f30885b;

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(c0.c(view));
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            c0.g(view, f10.floatValue());
        }
    }

    /* compiled from: ViewUtils.java */
    /* loaded from: classes.dex */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(View view) {
            return d0.w(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            d0.A0(view, rect);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f30884a = new h0();
        } else if (i10 >= 23) {
            f30884a = new g0();
        } else if (i10 >= 22) {
            f30884a = new f0();
        } else if (i10 >= 21) {
            f30884a = new e0();
        } else if (i10 >= 19) {
            f30884a = new d0();
        } else {
            f30884a = new i0();
        }
        f30885b = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        f30884a.a(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0 b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new a0(view);
        }
        return z.e(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float c(View view) {
        return f30884a.c(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m0 d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new l0(view);
        }
        return new k0(view.getWindowToken());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(View view) {
        f30884a.d(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(View view, int i10, int i11, int i12, int i13) {
        f30884a.e(view, i10, i11, i12, i13);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(View view, float f10) {
        f30884a.f(view, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(View view, int i10) {
        f30884a.g(view, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(View view, Matrix matrix) {
        f30884a.h(view, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(View view, Matrix matrix) {
        f30884a.i(view, matrix);
    }
}
