package androidx.fragment.app;

import android.os.Build;
import android.view.View;
import androidx.collection.a;
import java.util.ArrayList;
import n1.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransition.java */
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    static final z f3219a;

    /* renamed from: b  reason: collision with root package name */
    static final z f3220b;

    static {
        f3219a = Build.VERSION.SDK_INT >= 21 ? new y() : null;
        f3220b = b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Fragment fragment, Fragment fragment2, boolean z10, a<String, View> aVar, boolean z11) {
        if (z10) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static z b() {
        try {
            return (z) e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(a<String, String> aVar, a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.n(size))) {
                aVar.l(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(ArrayList<View> arrayList, int i10) {
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).setVisibility(i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        return (f3219a == null && f3220b == null) ? false : true;
    }
}
