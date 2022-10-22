package com.mobvoi.wear.watchface;

import android.content.Context;
import android.content.Intent;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.net.Uri;
/* loaded from: classes2.dex */
public class WatchFaceCompanionConfigUtil {
    private static final ColorMatrixColorFilter sGreyOutFilter = createGreyOutFilter();

    public static Intent buildLaunchCompanionConfigActivityIntent(String str) {
        return new Intent(str).addCategory(WatchFaceConstants.CATEGORY_COMPANION_CONFIGURATION);
    }

    private static ColorMatrixColorFilter createGreyOutFilter() {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        return new ColorMatrixColorFilter(colorMatrix);
    }

    public static ColorMatrixColorFilter getsGreyOutFilter() {
        return sGreyOutFilter;
    }

    public static boolean isCompanionConfigActionHandlable(Context context, String str) {
        return !context.getPackageManager().queryIntentActivities(buildLaunchCompanionConfigActivityIntent(str), 0).isEmpty();
    }

    public static void redirectToPlayStoreForPackage(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
    }
}
