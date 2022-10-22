package ek;

import android.content.Context;
import com.mobvoi.android.common.utils.q;
/* compiled from: SharePrefsUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static boolean a(Context context, String str) {
        return q.a(context, "prefs.tic_care", str, true);
    }

    public static void b(Context context, String str, boolean z10) {
        q.e(context, "prefs.tic_care", str, z10);
    }
}
