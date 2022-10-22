package k0;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
/* compiled from: AccessibilityRecordCompat.java */
/* loaded from: classes.dex */
public class e {
    public static void a(AccessibilityRecord accessibilityRecord, int i10) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i10);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i10) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i10);
        }
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view, int i10) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i10);
        }
    }
}
