package androidx.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
/* compiled from: EdgeEffectCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: EdgeEffectCompat.java */
    /* loaded from: classes.dex */
    private static class a {
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float c(EdgeEffect edgeEffect, float f10, float f11) {
            try {
                return edgeEffect.onPullDistance(f10, f11);
            } catch (Throwable unused) {
                edgeEffect.onPull(f10, f11);
                return 0.0f;
            }
        }
    }

    public static EdgeEffect a(Context context, AttributeSet attributeSet) {
        if (g0.a.c()) {
            return a.a(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    public static float b(EdgeEffect edgeEffect) {
        if (g0.a.c()) {
            return a.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void c(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f10, f11);
        } else {
            edgeEffect.onPull(f10);
        }
    }

    public static float d(EdgeEffect edgeEffect, float f10, float f11) {
        if (g0.a.c()) {
            return a.c(edgeEffect, f10, f11);
        }
        c(edgeEffect, f10, f11);
        return f10;
    }
}
