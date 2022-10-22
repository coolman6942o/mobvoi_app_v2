package aa;

import android.content.Context;
import android.util.TypedValue;
import com.mobvoi.android.common.utils.b;
/* compiled from: UiUtil.java */
/* loaded from: classes2.dex */
public class d {
    public static int a(float f10) {
        return b(f10, b.e());
    }

    public static int b(float f10, Context context) {
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static int c(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int d(float f10, Context context) {
        return (int) TypedValue.applyDimension(2, f10, context.getResources().getDisplayMetrics());
    }
}
