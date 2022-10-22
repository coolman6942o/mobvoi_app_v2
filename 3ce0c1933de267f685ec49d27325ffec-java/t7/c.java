package t7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.widget.x0;
import e.a;
/* compiled from: MaterialResources.java */
/* loaded from: classes.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i10) {
        int color;
        int resourceId;
        ColorStateList a10;
        if (typedArray.hasValue(i10) && (resourceId = typedArray.getResourceId(i10, 0)) != 0 && (a10 = a.a(context, resourceId)) != null) {
            return a10;
        }
        if (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i10, -1)) == -1) {
            return typedArray.getColorStateList(i10);
        }
        return ColorStateList.valueOf(color);
    }

    public static ColorStateList b(Context context, x0 x0Var, int i10) {
        int b10;
        int n10;
        ColorStateList a10;
        if (x0Var.s(i10) && (n10 = x0Var.n(i10, 0)) != 0 && (a10 = a.a(context, n10)) != null) {
            return a10;
        }
        if (Build.VERSION.SDK_INT > 15 || (b10 = x0Var.b(i10, -1)) == -1) {
            return x0Var.c(i10);
        }
        return ColorStateList.valueOf(b10);
    }

    public static int c(Context context, TypedArray typedArray, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i10, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i10, i11);
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, i11);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        Drawable b10;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (b10 = a.b(context, resourceId)) == null) ? typedArray.getDrawable(i10) : b10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(TypedArray typedArray, int i10, int i11) {
        return typedArray.hasValue(i10) ? i10 : i11;
    }

    public static d f(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        if (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return new d(context, resourceId);
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
