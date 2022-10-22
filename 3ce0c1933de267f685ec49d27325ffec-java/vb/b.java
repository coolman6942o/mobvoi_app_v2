package vb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mobvoi.companion.TicwearUiUtils;
import com.mobvoi.companion.aw.ui.pairing.ParingActivity;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.wear.common.base.TicwatchModels;
/* compiled from: TicUiUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static String a() {
        String wearModel = CompanionSetting.getWearModel();
        com.mobvoi.android.common.utils.b.e();
        String str = a.isOversea() ? "http://activities.mobvoi.com/use-help/en/pages/index.html?type=esc" : "http://activities.chumenwenwen.com/use-help/pages/index.html?type=esc";
        if (TextUtils.isEmpty(wearModel) || TicwatchModels.isC2(wearModel) || TicwatchModels.isE2(wearModel) || TicwatchModels.isLily(wearModel) || TicwatchModels.isLotus(wearModel) || TicwatchModels.isSakura(wearModel) || TicwatchModels.isTulip(wearModel) || TicwatchModels.isTicwatch2(wearModel) || TicwatchModels.isTicwatch1(wearModel) || TicwatchModels.isSakura2020(wearModel)) {
            return str;
        }
        if (TicwatchModels.isRover(wearModel)) {
            return a.isOversea() ? "http://activities.mobvoi.com/use-help/en/pages/index.html?type=pro3" : "http://activities.chumenwenwen.com/use-help/pages/index.html?type=pro3";
        }
        if (TicwatchModels.isJupiter() || TicwatchModels.isPro2021(wearModel)) {
            return a.isOversea() ? "http://activities.mobvoi.com/use-help/en/pages/index.html?type=pro" : "http://activities.chumenwenwen.com/use-help/pages/index.html?type=pro";
        }
        if (TicwatchModels.isE3(wearModel)) {
            return "http://activities.mobvoi.com/use-help/en/pages/index.html?type=e3";
        }
        String str2 = a.isOversea() ? "http://activities.mobvoi.com/use-help/en/pages/index.html?type=" : "http://activities.chumenwenwen.com/use-help/pages/index.html?type=";
        return str2 + wearModel.replaceAll(" ", "_");
    }

    public static boolean b(Context context) {
        return TicwearUiUtils.AndroidWear.hasAndroidWear(context);
    }

    public static void c(Context context) {
        TicwearUiUtils.AndroidWear.launchAndroidWear(context);
    }

    public static void d(Context context) {
        if (a.isOversea()) {
            TicwearUiUtils.AndroidWear.openPlayStore(context);
        } else {
            TicwearUiUtils.AndroidWear.openPlayChineseStore(context);
        }
    }

    public static void e(Context context) {
        if (b(context)) {
            c(context);
        } else {
            f(context);
        }
    }

    public static void f(Context context) {
        Intent intent = new Intent(context, ParingActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    public static void g(String str) {
        h(str, "watch_home");
    }

    public static void h(String str, String str2) {
    }
}
