package androidx.navigation;

import android.app.Activity;
import kotlin.jvm.internal.i;
/* compiled from: Activity.kt */
/* loaded from: classes.dex */
public final class a {
    public static final NavController a(Activity findNavController, int i10) {
        i.g(findNavController, "$this$findNavController");
        NavController a10 = s.a(findNavController, i10);
        i.c(a10, "Navigation.findNavController(this, viewId)");
        return a10;
    }
}
