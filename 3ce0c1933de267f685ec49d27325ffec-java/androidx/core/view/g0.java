package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import z.b;
/* compiled from: ViewGroupCompat.java */
/* loaded from: classes.dex */
public final class g0 {
    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(b.Q);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && d0.N(viewGroup) == null) ? false : true;
    }
}
