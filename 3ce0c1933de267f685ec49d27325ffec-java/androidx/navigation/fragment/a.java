package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import kotlin.jvm.internal.i;
/* compiled from: Fragment.kt */
/* loaded from: classes.dex */
public final class a {
    public static final NavController a(Fragment findNavController) {
        i.g(findNavController, "$this$findNavController");
        NavController Z = NavHostFragment.Z(findNavController);
        i.c(Z, "NavHostFragment.findNavController(this)");
        return Z;
    }
}
