package kc;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.base.settings.a;
/* compiled from: WindowUtil.java */
/* loaded from: classes2.dex */
public class f {
    public static int b() {
        int statusBarHeight = a.getStatusBarHeight(b.e());
        if (statusBarHeight == -1) {
            return 0;
        }
        return statusBarHeight;
    }

    public static void c(Activity activity) {
        final View decorView = activity.getWindow().getDecorView();
        decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: kc.e
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets d10;
                d10 = f.d(decorView, view, windowInsets);
                return d10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ WindowInsets d(View view, View view2, WindowInsets windowInsets) {
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        if (systemWindowInsetTop != a.getStatusBarHeight(b.e())) {
            a.setStatusBarHeight(b.e(), systemWindowInsetTop);
        }
        view.setOnApplyWindowInsetsListener(null);
        return windowInsets;
    }
}
