package j7;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import t7.b;
/* compiled from: MaterialColors.java */
/* loaded from: classes.dex */
public class a {
    public static int a(int i10, int i11) {
        return b0.a.j(i10, (Color.alpha(i10) * i11) / 255);
    }

    public static int b(Context context, int i10, int i11) {
        TypedValue a10 = b.a(context, i10);
        return a10 != null ? a10.data : i11;
    }

    public static int c(Context context, int i10, String str) {
        return b.d(context, i10, str);
    }

    public static int d(View view, int i10) {
        return b.e(view, i10);
    }

    public static int e(View view, int i10, int i11) {
        return b(view.getContext(), i10, i11);
    }

    public static boolean f(int i10) {
        return i10 != 0 && b0.a.c(i10) > 0.5d;
    }

    public static int g(int i10, int i11) {
        return b0.a.f(i11, i10);
    }

    public static int h(int i10, int i11, float f10) {
        return g(i10, b0.a.j(i11, Math.round(Color.alpha(i11) * f10)));
    }

    public static int i(View view, int i10, int i11, float f10) {
        return h(d(view, i10), d(view, i11), f10);
    }
}
