package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
/* compiled from: WindowCompat.java */
/* loaded from: classes.dex */
public final class m0 {

    /* compiled from: WindowCompat.java */
    /* loaded from: classes.dex */
    private static class a {
        static void a(Window window, boolean z10) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z10 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* compiled from: WindowCompat.java */
    /* loaded from: classes.dex */
    private static class b {
        static o0 a(Window window) {
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                return o0.d(insetsController);
            }
            return null;
        }

        static void b(Window window, boolean z10) {
            window.setDecorFitsSystemWindows(z10);
        }
    }

    public static o0 a(Window window, View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return b.a(window);
        }
        return new o0(window, view);
    }

    public static void b(Window window, boolean z10) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            b.b(window, z10);
        } else if (i10 >= 16) {
            a.a(window, z10);
        }
    }
}
