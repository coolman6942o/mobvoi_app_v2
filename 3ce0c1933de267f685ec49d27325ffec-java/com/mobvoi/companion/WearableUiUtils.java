package com.mobvoi.companion;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import ce.h;
import com.alibaba.fastjson.JSON;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.profile.healthcomplete.HealthInfoCompleteActivity;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.companion.wear.a;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.info.CapabilityHelper;
import com.mobvoi.wear.info.CompanionInfo;
import com.mobvoi.wear.info.WearInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import qk.e;
/* loaded from: classes2.dex */
public class WearableUiUtils {
    public static final String FOLLOW_INTENT = "follow_intent";
    private static final String HEALTH_DATA_CHECK_KEY = "health_data_check_key";
    private static final String ILLEGAL_HEALTH_DATA = "0";
    private static final String LOCALE_EN = "en";
    private static final String LOCALE_TW = "tw";
    private static final String TAG = "WearableUiUtils";
    private static final int TICPAY_CARD_ENTRY_POSITION = 3;
    public static final String WEIBO_URL = "http://weibo.com/u/5512657430?refer_flag=1001030101_";
    private static final String WENWEN_WECHAT_ID = "ticwatch";

    public static void addWatchFeedbackInfo(Intent intent) {
        if (isWearableDeviceConnected()) {
            Bundle bundle = new Bundle();
            WearInfo e10 = a.f().e();
            if (e10 != null) {
                bundle.putString("wearInfo", e10.toString());
            }
            intent.putExtra("query_param", bundle);
        }
    }

    public static void deleteDevice(Context context) {
        CompanionSetting.setNotStarted(context);
        CompanionSetting.setDeviceName("");
        CompanionSetting.setDeviceAddress(context, "");
    }

    public static void feedback(Context context) {
        if (context != null) {
            Intent intent = new Intent("com.mobvoi.companion.aw.action.FEEDBACK_CN");
            intent.putExtra("common_list_type", 1);
            intent.putExtra("wwid", AccountManager.h().g().wwid);
            intent.putExtra("type", TicwatchModels.TICWATCH1);
            intent.setPackage(context.getPackageName());
            addWatchFeedbackInfo(intent);
            context.startActivity(intent);
        }
    }

    private static String getReadableVersionName() {
        String versionName = getVersionName();
        if (versionName == null) {
            versionName = "";
        }
        return versionName.startsWith("tic_") ? versionName.replace("tic_", "") : versionName;
    }

    private static String getVersionCode() {
        try {
            Application e10 = b.e();
            return String.valueOf(e10.getPackageManager().getPackageInfo(e10.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e11) {
            Log.d(TAG, "Error when get version code.", e11);
            return null;
        }
    }

    private static String getVersionName() {
        try {
            Application e10 = b.e();
            return e10.getPackageManager().getPackageInfo(e10.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            Log.d(TAG, "Error when get version name.", e11);
            return null;
        }
    }

    public static boolean isHealthChecked() {
        return q.a(b.e(), "settings", HEALTH_DATA_CHECK_KEY, false);
    }

    public static boolean isHealthDataValid() {
        sa.a e10 = ta.a.e();
        if (e10 == null) {
            return true;
        }
        String str = e10.height;
        String str2 = e10.weight;
        return !TextUtils.isEmpty(str) && !"0".equals(str) && !TextUtils.isEmpty(str2) && !"0".equals(str2);
    }

    public static boolean isWatchConnected() {
        return e.a("android_wear") || e.a("android_wear3");
    }

    public static boolean isWearableDeviceConnected() {
        return e.a("android_wear") || e.a("android_wear3") || e.a("ticlite_mcu");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showHealthSettingDialog$0(Intent intent, Context context, DialogInterface dialogInterface, int i10) {
        if (intent != null) {
            context.startActivity(intent);
        }
    }

    public static void openHealthInitPages(Context context, Intent intent) {
        Intent intent2 = new Intent(context, HealthInfoCompleteActivity.class);
        if (intent != null) {
            intent2.putExtra(FOLLOW_INTENT, intent);
        }
        context.startActivity(intent2);
    }

    public static void saveHealthChecked() {
        q.e(b.e(), "settings", HEALTH_DATA_CHECK_KEY, true);
    }

    public static void sendAccountInfoToWear(Context context) {
        CompanionInfo companionInfo = new CompanionInfo();
        sa.a g10 = AccountManager.h().g();
        companionInfo.deviceId = com.mobvoi.android.common.utils.e.e(context);
        companionInfo.accountId = g10.accountId;
        companionInfo.nickName = g10.nickName;
        companionInfo.phoneNumber = g10.phoneNumber;
        companionInfo.email = g10.email;
        companionInfo.sex = AccountConstant.Sex.values()[g10.sex].name();
        companionInfo.weight = g10.weight;
        companionInfo.height = g10.height;
        companionInfo.sessionId = g10.sessionId;
        companionInfo.wwid = g10.wwid;
        companionInfo.birthday = g10.birthday;
        companionInfo.model = Build.MODEL;
        companionInfo.systemVersion = Build.VERSION.RELEASE;
        companionInfo.headUrl = g10.headUrl;
        companionInfo.capabilities = CapabilityHelper.getAppCapabilities(context);
        companionInfo.unit = com.mobvoi.companion.base.settings.a.getUnit(context);
        companionInfo.temperature = com.mobvoi.companion.base.settings.a.getTempUnit(context);
        companionInfo.dateformat = com.mobvoi.companion.base.settings.a.getDateFormat(context);
        companionInfo.versionName = getReadableVersionName();
        companionInfo.versionCode = getVersionCode();
        companionInfo.temperature = com.mobvoi.companion.base.settings.a.getTempUnit(context);
        companionInfo.dateformat = com.mobvoi.companion.base.settings.a.getDateFormat(context);
        companionInfo.isVpa = WearableModule.getInstance().isVpa();
        MessageProxyClient.getInstance().sendMessage(WearPath.Companion.SEND_COMPANION_INFO, JSON.toJSONString(companionInfo).getBytes());
    }

    public static void showBonusInfo(Context context) {
        String str;
        Intent intent = new Intent(BasicBrowserActivity.ACTION);
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            str = "http://wechat-platform.chumenwenwen.com/referral/index_en.html?utm_campaign=referral&utm_medium=android&utm_source=companion_android&referral_code=" + ta.a.r();
            intent.putExtra(BasicBrowserActivity.KEY_EXTRA_SHARE_URL, "https://en.ticwear.com/pages/share-referral?utm_source=companion&referral_code=" + ta.a.r());
        } else {
            str = "http://wechat-platform.chumenwenwen.com/referral/index.html?wwid=" + ta.a.x() + "&referral_code=" + ta.a.r();
        }
        intent.putExtra("url", str);
        intent.putExtra(BasicBrowserActivity.KEY_ADD_WWID_COOKIE, true);
        intent.setPackage(context.getPackageName());
        context.startActivity(intent);
        CompanionSetting.setRedPointStatus(false);
    }

    public static void showHealthSettingDialog(final Context context, final Intent intent) {
        Spanned fromHtml = Html.fromHtml(context.getResources().getString(h.f5874u));
        new k7.b(context).r(fromHtml).D(Html.fromHtml(context.getResources().getString(h.f5876v))).d(true).j(h.f5844f, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                WearableUiUtils.lambda$showHealthSettingDialog$0(intent, context, dialogInterface, i10);
            }
        }).m(h.f5848h, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                WearableUiUtils.openHealthInitPages(context, null);
            }
        }).a().show();
    }

    public static void startAuthActivity(Context context) {
        ((uc.a) kc.b.b().a(uc.a.class)).a(context, null);
    }
}
