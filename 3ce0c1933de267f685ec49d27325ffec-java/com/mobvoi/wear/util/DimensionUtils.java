package com.mobvoi.wear.util;

import android.content.Context;
import android.util.TypedValue;
/* loaded from: classes2.dex */
public class DimensionUtils {
    public static float dp2px(Context context, float f10) {
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static float px2dp(Context context, float f10) {
        return f10 / context.getResources().getDisplayMetrics().density;
    }

    public static float sp2px(Context context, float f10) {
        return (int) TypedValue.applyDimension(2, f10, context.getResources().getDisplayMetrics());
    }
}
