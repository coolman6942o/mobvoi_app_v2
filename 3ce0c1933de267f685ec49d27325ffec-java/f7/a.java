package f7;

import android.graphics.Canvas;
import android.os.Build;
/* compiled from: CanvasCompat.java */
/* loaded from: classes.dex */
public class a {
    public static int a(Canvas canvas, float f10, float f11, float f12, float f13, int i10) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f10, f11, f12, f13, i10);
        }
        return canvas.saveLayerAlpha(f10, f11, f12, f13, i10, 31);
    }
}
