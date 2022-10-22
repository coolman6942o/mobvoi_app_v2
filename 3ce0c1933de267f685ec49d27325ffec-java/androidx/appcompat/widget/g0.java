package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import c0.e;
import f.c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: DrawableUtils.java */
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1159a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1160b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f1161c = new Rect();

    /* compiled from: DrawableUtils.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final boolean f1162a;

        /* renamed from: b  reason: collision with root package name */
        private static final Method f1163b;

        /* renamed from: c  reason: collision with root package name */
        private static final Field f1164c;

        /* renamed from: d  reason: collision with root package name */
        private static final Field f1165d;

        /* renamed from: e  reason: collision with root package name */
        private static final Field f1166e;

        /* renamed from: f  reason: collision with root package name */
        private static final Field f1167f;

        /* JADX WARN: Removed duplicated region for block: B:25:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
        static {
            boolean z10;
            Field field;
            Field field2;
            Field field3;
            Method method;
            Field field4;
            Class<?> cls;
            try {
                cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", new Class[0]);
            } catch (ClassNotFoundException unused) {
                method = null;
                field3 = null;
            } catch (NoSuchFieldException unused2) {
                method = null;
                field3 = null;
            } catch (NoSuchMethodException unused3) {
                method = null;
                field3 = null;
            }
            try {
                field3 = cls.getField("left");
                try {
                    field2 = cls.getField("top");
                    try {
                        field = cls.getField("right");
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused4) {
                        field = null;
                    }
                    try {
                        field4 = cls.getField("bottom");
                        z10 = true;
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused5) {
                        z10 = false;
                        field4 = null;
                        if (!z10) {
                        }
                    }
                } catch (ClassNotFoundException unused6) {
                    field2 = null;
                    field = field2;
                    z10 = false;
                    field4 = null;
                    if (!z10) {
                    }
                } catch (NoSuchFieldException unused7) {
                    field2 = null;
                    field = field2;
                    z10 = false;
                    field4 = null;
                    if (!z10) {
                    }
                } catch (NoSuchMethodException unused8) {
                    field2 = null;
                    field = field2;
                    z10 = false;
                    field4 = null;
                    if (!z10) {
                    }
                }
            } catch (ClassNotFoundException unused9) {
                field3 = null;
                field2 = field3;
                field = field2;
                z10 = false;
                field4 = null;
                if (!z10) {
                }
            } catch (NoSuchFieldException unused10) {
                field3 = null;
                field2 = field3;
                field = field2;
                z10 = false;
                field4 = null;
                if (!z10) {
                }
            } catch (NoSuchMethodException unused11) {
                field3 = null;
                field2 = field3;
                field = field2;
                z10 = false;
                field4 = null;
                if (!z10) {
                }
            }
            if (!z10) {
                f1163b = method;
                f1164c = field3;
                f1165d = field2;
                f1166e = field;
                f1167f = field4;
                f1162a = true;
                return;
            }
            f1163b = null;
            f1164c = null;
            f1165d = null;
            f1166e = null;
            f1167f = null;
            f1162a = false;
        }

        static Rect a(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f1162a) {
                try {
                    Object invoke = f1163b.invoke(drawable, new Object[0]);
                    if (invoke != null) {
                        return new Rect(f1164c.getInt(invoke), f1165d.getInt(invoke), f1166e.getInt(invoke), f1167f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return g0.f1161c;
        }
    }

    /* compiled from: DrawableUtils.java */
    /* loaded from: classes.dex */
    static class b {
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(Drawable drawable) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (i10 < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (i10 < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!a(drawable2)) {
                    return false;
                }
            }
            return true;
        } else if (drawable instanceof e) {
            return a(((e) drawable).b());
        } else {
            if (drawable instanceof c) {
                return a(((c) drawable).a());
            }
            if (drawable instanceof ScaleDrawable) {
                return a(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            c(drawable);
        } else if (i10 >= 29 && i10 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1159a);
        } else {
            drawable.setState(f1160b);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            Insets a10 = b.a(drawable);
            return new Rect(a10.left, a10.top, a10.right, a10.bottom);
        } else if (i10 >= 18) {
            return a.a(androidx.core.graphics.drawable.a.q(drawable));
        } else {
            return f1161c;
        }
    }

    public static PorterDuff.Mode e(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
