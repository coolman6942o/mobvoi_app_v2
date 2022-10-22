package androidx.navigation;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import androidx.core.app.a;
import java.lang.ref.WeakReference;
/* compiled from: Navigation.java */
/* loaded from: classes.dex */
public final class s {
    public static NavController a(Activity activity, int i10) {
        NavController c10 = c(a.t(activity, i10));
        if (c10 != null) {
            return c10;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i10);
    }

    public static NavController b(View view) {
        NavController c10 = c(view);
        if (c10 != null) {
            return c10;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    private static NavController c(View view) {
        while (view != null) {
            NavController d10 = d(view);
            if (d10 != null) {
                return d10;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private static NavController d(View view) {
        Object tag = view.getTag(v.f3564a);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    public static void e(View view, NavController navController) {
        view.setTag(v.f3564a, navController);
    }
}
