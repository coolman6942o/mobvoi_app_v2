package yd;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import kotlin.jvm.internal.i;
/* compiled from: CompatStatusBarManager.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f37003a = new d();

    private d() {
    }

    private final void a(Window window) {
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                declaredField2.setInt(attributes, declaredField.getInt(null) | declaredField2.getInt(attributes));
                window.setAttributes(attributes);
            } catch (Exception unused) {
            }
        }
    }

    private final void b(Window window) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i10 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Class<?> cls3 = Integer.TYPE;
                cls.getMethod("setExtraFlags", cls3, cls3).invoke(window, Integer.valueOf(i10), Integer.valueOf(i10));
                window.getDecorView().setSystemUiVisibility(9216);
            } catch (Exception unused) {
            }
        }
    }

    public static final void c(Activity activity, boolean z10) {
        i.f(activity, "activity");
        d dVar = f37003a;
        dVar.e(activity);
        Window window = activity.getWindow();
        if (z10) {
            window.setNavigationBarColor(-1);
            dVar.d(activity, true);
            dVar.b(window);
            dVar.a(window);
            return;
        }
        window.setNavigationBarColor(-16777216);
    }

    private final void d(Activity activity, boolean z10) {
        if (z10) {
            int i10 = 9472;
            if (Build.VERSION.SDK_INT >= 26) {
                i10 = 9488;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(i10);
        }
    }

    private final void e(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(1280);
        window.setStatusBarColor(0);
    }
}
