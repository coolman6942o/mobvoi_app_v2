package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.g;
/* loaded from: classes2.dex */
public class UTDevice {
    public static String d(Context context) {
        a b10 = b.b(context);
        return (b10 == null || g.m22a(b10.f())) ? "ffffffffffffffffffffffff" : b10.f();
    }

    public static String e(Context context) {
        String h10 = c.a(context).h();
        return (h10 == null || g.m22a(h10)) ? "ffffffffffffffffffffffff" : h10;
    }

    @Deprecated
    public static String getUtdid(Context context) {
        return d(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return e(context);
    }
}
