package bh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.mobvoi.android.common.utils.b;
import fg.o;
import fg.p;
import fg.u;
/* compiled from: NoDataUtil.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static String f5150a;

    /* renamed from: b  reason: collision with root package name */
    private static Paint f5151b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    private static int f5152c;

    /* renamed from: d  reason: collision with root package name */
    private static float f5153d;

    public static void a(Canvas canvas, boolean z10, float f10, float f11, boolean z11) {
        if (z10) {
            float f12 = 0.0f;
            if (z11) {
                f12 = f5153d;
            }
            f5151b.setColor(b.e().getResources().getColor(o.f26460h));
            canvas.drawText(f5150a, f10 - (f5152c / 2), f11 - f12, f5151b);
        }
    }

    public static void b(Context context) {
        if (f5150a == null) {
            f5150a = context.getString(u.N2);
            f5151b.setColor(-7829368);
            f5151b.setAlpha(128);
            f5151b.setTextSize(context.getResources().getDimensionPixelSize(p.I));
            Rect rect = new Rect();
            Paint paint = f5151b;
            String str = f5150a;
            paint.getTextBounds(str, 0, str.length(), rect);
            f5152c = rect.width();
            f5153d = (f5151b.descent() + f5151b.ascent()) / 2.0f;
        }
    }
}
