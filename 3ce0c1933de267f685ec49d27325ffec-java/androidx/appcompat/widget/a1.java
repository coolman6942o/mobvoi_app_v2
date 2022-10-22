package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;
/* compiled from: TooltipCompat.java */
/* loaded from: classes.dex */
public class a1 {
    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            b1.f(view, charSequence);
        }
    }
}
