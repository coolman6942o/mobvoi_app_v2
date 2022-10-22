package d1;

import androidx.appcompat.app.d;
import androidx.navigation.NavController;
import androidx.navigation.k;
import java.util.Set;
import o0.c;
/* compiled from: NavigationUI.java */
/* loaded from: classes.dex */
public final class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(k kVar, Set<Integer> set) {
        while (!set.contains(Integer.valueOf(kVar.i()))) {
            kVar = kVar.l();
            if (kVar == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(NavController navController, d dVar) {
        c b10 = dVar.b();
        k i10 = navController.i();
        Set<Integer> c10 = dVar.c();
        if (b10 != null && i10 != null && a(i10, c10)) {
            b10.a();
            return true;
        } else if (navController.u()) {
            return true;
        } else {
            if (dVar.a() != null) {
                return dVar.a().a();
            }
            return false;
        }
    }

    public static void c(d dVar, NavController navController, d dVar2) {
        navController.a(new b(dVar, dVar2));
    }
}
