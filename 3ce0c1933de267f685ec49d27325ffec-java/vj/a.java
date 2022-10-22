package vj;

import android.graphics.Paint;
import android.view.View;
import kotlin.jvm.internal.i;
/* compiled from: Graphics.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final int a(View view, int i10) {
        i.f(view, "<this>");
        return (int) (i10 * view.getResources().getDisplayMetrics().density);
    }

    public static final Paint b(int i10) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i10);
        return paint;
    }
}
