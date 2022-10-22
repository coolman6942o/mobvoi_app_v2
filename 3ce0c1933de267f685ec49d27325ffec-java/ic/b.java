package ic;

import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
/* compiled from: ShareChooser.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static c f28231a = new a();

    public static void a(c cVar) {
        f28231a = cVar;
    }

    public static void b(Context context) {
        f28231a.b(context, false);
    }

    public static void c(Context context) {
        f28231a.b(context, true);
    }

    public static void d(Context context, String str, String str2, String str3, int i10) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            k.s("ShareChooser", "Can't share with empty url(%s) or title(%s)", str, str2);
        } else {
            f28231a.a(context, str, str2, str3, i10);
        }
    }
}
