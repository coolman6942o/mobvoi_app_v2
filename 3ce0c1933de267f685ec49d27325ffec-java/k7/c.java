package k7;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import com.google.android.material.internal.k;
import d7.d;
import d7.l;
/* compiled from: MaterialDialogs.java */
/* loaded from: classes.dex */
public class c {
    public static Rect a(Context context, int i10, int i11) {
        TypedArray h10 = k.h(context, null, l.S1, i10, i11, new int[0]);
        int dimensionPixelSize = h10.getDimensionPixelSize(l.V1, context.getResources().getDimensionPixelSize(d.P));
        int dimensionPixelSize2 = h10.getDimensionPixelSize(l.W1, context.getResources().getDimensionPixelSize(d.Q));
        int dimensionPixelSize3 = h10.getDimensionPixelSize(l.U1, context.getResources().getDimensionPixelSize(d.O));
        int dimensionPixelSize4 = h10.getDimensionPixelSize(l.T1, context.getResources().getDimensionPixelSize(d.N));
        h10.recycle();
        if (Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        return new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
    }

    public static InsetDrawable b(Drawable drawable, Rect rect) {
        return new InsetDrawable(drawable, rect.left, rect.top, rect.right, rect.bottom);
    }
}
