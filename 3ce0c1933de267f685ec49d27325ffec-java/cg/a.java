package cg;

import android.graphics.Color;
import android.graphics.Paint;
/* compiled from: UiUtil.java */
/* loaded from: classes2.dex */
public class a {
    public static int a(int i10, float f10) {
        return Color.argb((int) (Color.alpha(i10) * f10), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    public static float b(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.descent - fontMetrics.ascent;
    }
}
