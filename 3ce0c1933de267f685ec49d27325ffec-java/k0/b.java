package k0;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
/* compiled from: AccessibilityEventCompat.java */
/* loaded from: classes.dex */
public final class b {
    public static int a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i10) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i10);
        }
    }
}
