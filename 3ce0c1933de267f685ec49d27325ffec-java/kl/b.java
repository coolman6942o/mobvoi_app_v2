package kl;

import al.c;
import al.d;
import android.content.Context;
import java.util.Locale;
import wl.a;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f30015a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f30016b = false;

    public static void a(Context context, boolean z10) {
        f30015a = z10;
        f30016b = wk.b.f36300c;
        il.b.d(true, String.format(Locale.US, "{\nLIBRARY_PACKAGE_NAME=%s\n%s:%s:%s\nDEBUG=%b\nBUILD_TYPE=%s\nDEBUG_ENABLE=%b\n}", "com.realsil.sdk.dfu", "com.realsil.sdk", "rtk-dfu", "3.4.2", Boolean.FALSE, "release", Boolean.valueOf(f30015a)));
        if (c.k() == null) {
            c.l(context);
        }
        al.b.i(context);
        d.e(context);
        a.E = a.D;
    }
}
