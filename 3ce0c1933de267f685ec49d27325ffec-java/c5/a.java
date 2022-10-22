package c5;

import a0.h;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.b;
import i.d;
/* compiled from: DrawableDecoderCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f5577a = true;

    public static Drawable a(Context context, int i10, Resources.Theme theme) {
        return c(context, context, i10, theme);
    }

    public static Drawable b(Context context, Context context2, int i10) {
        return c(context, context2, i10, null);
    }

    private static Drawable c(Context context, Context context2, int i10, Resources.Theme theme) {
        try {
            if (f5577a) {
                return e(context2, i10, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e10) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return b.e(context2, i10);
            }
            throw e10;
        } catch (NoClassDefFoundError unused2) {
            f5577a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i10, theme);
    }

    private static Drawable d(Context context, int i10, Resources.Theme theme) {
        return h.f(context.getResources(), i10, theme);
    }

    private static Drawable e(Context context, int i10, Resources.Theme theme) {
        if (theme != null) {
            context = new d(context, theme);
        }
        return e.a.b(context, i10);
    }
}
