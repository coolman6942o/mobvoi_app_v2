package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import c0.d;
import c0.e;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: DrawableCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f2462a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f2463b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f2464c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2465d;

    public static void a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public static void c(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            drawable.clearColorFilter();
        } else if (i10 >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                c(((InsetDrawable) drawable).getDrawable());
            } else if (drawable instanceof e) {
                c(((e) drawable).b());
            } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    Drawable child = drawableContainerState.getChild(i11);
                    if (child != null) {
                        c(child);
                    }
                }
            }
        } else {
            drawable.clearColorFilter();
        }
    }

    public static int d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static ColorFilter e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static int f(Drawable drawable) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i10 >= 17) {
            if (!f2465d) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f2464c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e10) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e10);
                }
                f2465d = true;
            }
            Method method = f2464c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e11) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e11);
                    f2464c = null;
                }
            }
        }
        return 0;
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean h(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    @Deprecated
    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z10) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z10);
        }
    }

    public static void k(Drawable drawable, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f10, f11);
        }
    }

    public static void l(Drawable drawable, int i10, int i11, int i12, int i13) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i10, i11, i12, i13);
        }
    }

    public static boolean m(Drawable drawable, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            return drawable.setLayoutDirection(i10);
        }
        if (i11 >= 17) {
            if (!f2463b) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f2462a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e10) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e10);
                }
                f2463b = true;
            }
            Method method = f2462a;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i10));
                    return true;
                } catch (Exception e11) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e11);
                    f2462a = null;
                }
            }
        }
        return false;
    }

    public static void n(Drawable drawable, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i10);
        } else if (drawable instanceof d) {
            ((d) drawable).setTint(i10);
        }
    }

    public static void o(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof d) {
            ((d) drawable).setTintList(colorStateList);
        }
    }

    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof d) {
            ((d) drawable).setTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T q(Drawable drawable) {
        return drawable instanceof e ? (T) ((e) drawable).b() : drawable;
    }

    public static Drawable r(Drawable drawable) {
        int i10 = Build.VERSION.SDK_INT;
        return i10 >= 23 ? drawable : i10 >= 21 ? !(drawable instanceof d) ? new c(drawable) : drawable : !(drawable instanceof d) ? new b(drawable) : drawable;
    }
}
