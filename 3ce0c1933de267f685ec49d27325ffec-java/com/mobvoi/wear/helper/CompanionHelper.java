package com.mobvoi.wear.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.R;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.info.AccountInfoHelper;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.WatchInfoUtils;
/* loaded from: classes2.dex */
public class CompanionHelper {
    public static final String REMOTE_URL_ANDROID_CHINA = "http://mushroom.chumenwenwen.com/api/qrdownload/mobvoi_assistant_release";
    public static final String REMOTE_URL_ANDROID_GLOBAL = "https://play.google.com/store/apps/details?id=com.mobvoi.companion.aw";
    public static final String REMOTE_URL_IOS_CHINA = "http://mushroom.chumenwenwen.com/api/qrdownload/mobvoi_assistant_release";
    public static final String REMOTE_URL_IOS_GLOBAL = "https://itunes.apple.com/us/app/id1287014629";
    private static final String TAG = "CompanionHelper";

    public static String getCompanionAppName(Context context) {
        if (WatchInfoUtils.isTicwearSystem()) {
            if (WatchInfoUtils.isGlobalVersion(context)) {
                return context.getString(R.string.ticwatch_tw_companion_name_oversea);
            }
            return context.getString(R.string.ticwatch_tw_companion_name_china);
        } else if (WatchInfoUtils.isGlobalVersion(context)) {
            return context.getString(R.string.ticwatch_aw_companion_name_oversea);
        } else {
            return context.getString(R.string.ticwatch_aw_companion_name_china);
        }
    }

    public static Intent getOpenStoreIntent(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(getStoreUrl(context)));
        intent.setFlags(268435456);
        return intent;
    }

    public static String getPhoneAppStoreName(Context context) {
        if (SharedWearInfoHelper.getInstance(context).getPairedPlatform() == 2) {
            return context.getString(R.string.app_store_ios);
        }
        if (WatchInfoUtils.isGlobalVersion(context)) {
            return context.getString(R.string.app_store_android_oversea);
        }
        return context.getString(R.string.app_store_android_china);
    }

    public static String getStoreUrl(Context context) {
        int pairedPlatform = SharedWearInfoHelper.getInstance(context).getPairedPlatform();
        boolean z10 = !WatchInfoUtils.isGlobalVersion(context);
        return pairedPlatform == 2 ? z10 ? "http://mushroom.chumenwenwen.com/api/qrdownload/mobvoi_assistant_release" : REMOTE_URL_IOS_GLOBAL : z10 ? "http://mushroom.chumenwenwen.com/api/qrdownload/mobvoi_assistant_release" : REMOTE_URL_ANDROID_GLOBAL;
    }

    public static boolean setupCompleted(Context context, boolean z10) {
        boolean isLoggedIn = AccountInfoHelper.getInstance(context).isLoggedIn();
        boolean isInfoSynced = SharedWearInfoHelper.getInstance(context).isInfoSynced();
        if (isLoggedIn && z10) {
            k.a(TAG, "Logged in, can standalone, ok to enter App.");
            return true;
        } else if (!isLoggedIn || !isInfoSynced) {
            return false;
        } else {
            k.a(TAG, "Logged in, and installed companion, ok to enter App.");
            return true;
        }
    }

    public static boolean startCompanionCheck(Activity activity, int i10, String str, String str2, String str3, String str4, boolean z10, boolean z11) {
        Intent intent = new Intent(Constants.Companion.CHECK_ACTION);
        intent.putExtra(Constants.Companion.INSTALL_EXPLAIN_ANDROID, str);
        intent.putExtra(Constants.Companion.INSTALL_EXPLAIN_IOS, str2);
        intent.putExtra(Constants.Companion.LOGIN_EXPLAIN_ANDROID, str3);
        intent.putExtra(Constants.Companion.LOGIN_EXPLAIN_IOS, str4);
        intent.putExtra(Constants.Companion.CAN_SKIP, z10);
        intent.putExtra(Constants.Companion.CAN_STANDALONE, z11);
        intent.putExtra("package_name", activity.getPackageName());
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            k.c(TAG, "Has companion check activity, start with requestCode %d, canSkip %s, canStandalone %s", Integer.valueOf(i10), Boolean.valueOf(z10), Boolean.valueOf(z11));
            activity.startActivityForResult(intent, i10);
            return true;
        }
        k.a(TAG, "Companion check activity not found, skip check.");
        return false;
    }
}
