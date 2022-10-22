package com.mobvoi.companion;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.settings.a;
/* loaded from: classes2.dex */
public class TicwearUiUtils {
    private static final String TAG = "UiUtils";

    /* loaded from: classes2.dex */
    public static class AndroidWear {
        private static final String WEAR_OS_DOWNLOAD_CN = "https://mushroom.mobvoi.com/api/qrdownload/android_wear_companion";
        private static final String WEAR_OS_PKG_CN = "com.google.android.wearable.app.cn";
        private static final String WEAR_OS_PKG_INTL = "com.google.android.wearable.app";

        public static boolean checkPackInfo(Context context, String str) {
            PackageInfo packageInfo;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException e10) {
                e10.printStackTrace();
                packageInfo = null;
            }
            return packageInfo != null;
        }

        public static Intent getViewActivity(String str) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setFlags(268435456);
            return intent;
        }

        public static boolean hasAndroidWear(Context context) {
            return checkPackInfo(context, a.isOversea() ? WEAR_OS_PKG_INTL : WEAR_OS_PKG_CN);
        }

        public static void launchAndroidWear(Context context) {
            openMainActivity(context, a.isOversea() ? WEAR_OS_PKG_INTL : WEAR_OS_PKG_CN);
        }

        public static void openMainActivity(Context context, String str) {
            PackageManager packageManager = context.getPackageManager();
            if (checkPackInfo(context, str)) {
                context.startActivity(packageManager.getLaunchIntentForPackage(str));
            } else {
                openPlayStore(context);
            }
        }

        public static void openPlayChineseStore(Context context) {
            context.startActivity(getViewActivity(WEAR_OS_DOWNLOAD_CN));
        }

        public static void openPlayStore(Context context) {
            openPlayStore(context, a.isOversea() ? WEAR_OS_PKG_INTL : WEAR_OS_PKG_CN);
        }

        public static void openUrl(Context context, String str) {
            context.startActivity(getViewActivity(str));
        }

        public static void openPlayStore(Context context, String str) {
            String str2 = "market://details?id=" + str;
            if (getViewActivity(str2).resolveActivity(context.getPackageManager()) == null) {
                str2 = "https://play.google.com/store/apps/details?id=" + str;
            }
            k.i(TicwearUiUtils.TAG, "Start activity with data %s", str2);
            context.startActivity(getViewActivity(str2));
        }
    }
}
