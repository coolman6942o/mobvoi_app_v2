package z9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.a;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
/* compiled from: PermissionUtils.java */
/* loaded from: classes2.dex */
public class e {
    private static void a(Object obj) {
        if (!(obj instanceof Activity) && !(obj instanceof Fragment)) {
            throw new IllegalArgumentException("The caller must be an Activity or a Fragment: " + obj.getClass().getName());
        }
    }

    private static void b(Object obj, d dVar) {
        a(obj);
        c(obj, dVar.f37316b, dVar.f37315a);
    }

    private static void c(Object obj, String[] strArr, int i10) {
        if (obj instanceof Activity) {
            a.s((Activity) obj, strArr, i10);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).requestPermissions(strArr, i10);
        }
    }

    public static boolean d(Context context, String... strArr) {
        boolean z10 = true;
        if (strArr.length < 1) {
            return false;
        }
        for (String str : strArr) {
            if (b.a(context, str) == -1) {
                z10 = false;
            }
        }
        return z10;
    }

    public static void e(Activity activity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + activity.getPackageName()));
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }

    public static void f(Activity activity, d dVar) {
        b(activity, dVar);
    }

    public static boolean g(Activity activity, String str) {
        return h(activity, str);
    }

    private static boolean h(Object obj, String str) {
        if (obj instanceof Activity) {
            return a.w((Activity) obj, str);
        }
        if (obj instanceof Fragment) {
            return ((Fragment) obj).shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
