package com.tendcloud.tenddata;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class TalkingDataSDK {
    public static final int ANALYTICS_INTELLIGENT_DISABLE = 2;
    public static final int ANTI_CHEATING_DISABLE = 8;
    public static final int DEVICE_IDENTIFICATION_DISABLE = 4;
    public static final int PRECISE_AREA_DISABLE = 1;

    public static synchronized String getDeviceId(Context context) {
        String d10;
        synchronized (TalkingDataSDK.class) {
            d10 = ac.d(context, a.UNIVERSAL);
        }
        return d10;
    }

    public static synchronized String getOAID(Context context) {
        String e10;
        synchronized (TalkingDataSDK.class) {
            e10 = ac.e(context, a.UNIVERSAL);
        }
        return e10;
    }

    public static void init(Context context, String str, String str2, String str3) {
        ac.a(context, str, str2, str3, a.UNIVERSAL);
    }

    public static void onAchievementUnlock(String str, String str2) {
        ac.k(str, str2, a.UNIVERSAL);
    }

    public static void onAddItemToShoppingCart(String str, String str2, String str3, int i10, int i11) {
        ac.a(str, str2, str3, i10, i11, a.UNIVERSAL);
    }

    public static void onBooking(String str, String str2, String str3, int i10, String str4) {
        ac.b(str, str2, str3, i10, str4, a.UNIVERSAL);
    }

    public static void onBrowse(String str, String str2, long j10, int i10) {
        ac.c(str, str2, j10, i10, a.UNIVERSAL);
    }

    public static void onCancelOrder(TalkingDataOrder talkingDataOrder) {
        ac.a(talkingDataOrder, a.UNIVERSAL);
    }

    public static void onChargeBack(String str, String str2, String str3, String str4) {
        ac.a(str, str2, str3, str4, a.UNIVERSAL);
    }

    public static void onContact(String str, String str2) {
        ac.e(str, str2, a.UNIVERSAL);
    }

    public static void onCreateCard(String str, String str2, String str3) {
        ac.a(str, str2, str3, a.UNIVERSAL);
    }

    public static void onCreateRole(String str) {
        ac.e(str, a.UNIVERSAL);
    }

    public static void onCredit(String str, int i10, String str2) {
        ac.c(str, i10, str2, a.UNIVERSAL);
    }

    public static void onError(Context context, Throwable th2) {
        ac.a(context, th2, a.UNIVERSAL);
    }

    public static void onEvent(Context context, String str, double d10, Map<String, Object> map) {
        ac.a(context, str, d10, map, a.UNIVERSAL);
    }

    public static void onFavorite(String str, String str2) {
        ac.b(str, str2, a.UNIVERSAL);
    }

    public static void onFreeFinished(String str, String str2) {
        ac.i(str, str2, a.UNIVERSAL);
    }

    public static void onGuideFinished(String str, String str2) {
        ac.g(str, str2, a.UNIVERSAL);
    }

    public static void onLearn(String str, String str2, long j10, int i10) {
        ac.a(str, str2, j10, i10, a.UNIVERSAL);
    }

    public static void onLevelPass(String str, String str2) {
        ac.j(str, str2, a.UNIVERSAL);
    }

    public static void onLogin(String str, TalkingDataProfile talkingDataProfile) {
        ac.a(str, talkingDataProfile, a.UNIVERSAL);
    }

    public static void onOrderPaySucc(TalkingDataOrder talkingDataOrder, String str, String str2) {
        ac.a(talkingDataOrder, str, str2, a.UNIVERSAL);
    }

    public static void onPageBegin(Context context, String str) {
        ac.a(context, str, a.UNIVERSAL);
    }

    public static void onPageEnd(Context context, String str) {
        ac.b(context, str, a.UNIVERSAL);
    }

    @Deprecated
    public static void onPause(Activity activity) {
        ac.b(activity, a.UNIVERSAL);
    }

    public static void onPay(String str, String str2, int i10, String str3, String str4, String str5, int i11) {
        ac.a(str, str2, i10, str3, str4, str5, i11, a.UNIVERSAL);
    }

    public static void onPlaceOrder(TalkingDataOrder talkingDataOrder, String str) {
        ac.a(talkingDataOrder, str, a.UNIVERSAL);
    }

    public static void onPreviewFinished(String str, String str2) {
        ac.h(str, str2, a.UNIVERSAL);
    }

    public static void onProfileUpdate(TalkingDataProfile talkingDataProfile) {
        ac.a(talkingDataProfile, a.UNIVERSAL);
    }

    public static void onPunch(String str, String str2) {
        ac.d(str, str2, a.UNIVERSAL);
    }

    public static void onRead(String str, String str2, long j10, int i10) {
        ac.b(str, str2, j10, i10, a.UNIVERSAL);
    }

    public static void onReceiveDeepLink(String str) {
        ac.d(str, a.UNIVERSAL);
    }

    public static void onRegister(String str, TalkingDataProfile talkingDataProfile, String str2) {
        ac.a(str, talkingDataProfile, str2, a.UNIVERSAL);
    }

    public static void onReservation(String str, String str2, String str3, int i10, String str4) {
        ac.a(str, str2, str3, i10, str4, a.UNIVERSAL);
    }

    @Deprecated
    public static void onResume(Activity activity) {
        ac.a(activity, a.UNIVERSAL);
    }

    public static void onSearch(TalkingDataSearch talkingDataSearch) {
        ac.a(talkingDataSearch, a.UNIVERSAL);
    }

    public static void onShare(String str, String str2) {
        ac.c(str, str2, a.UNIVERSAL);
    }

    public static void onTransaction(String str, TalkingDataTransaction talkingDataTransaction) {
        ac.a(str, talkingDataTransaction, a.UNIVERSAL);
    }

    public static void onTrialFinished(String str, String str2) {
        ac.f(str, str2, a.UNIVERSAL);
    }

    public static void onViewItem(String str, String str2, String str3, int i10) {
        ac.a(str, str2, str3, i10, a.UNIVERSAL);
    }

    public static void onViewShoppingCart(TalkingDataShoppingCart talkingDataShoppingCart) {
        ac.a(talkingDataShoppingCart, a.UNIVERSAL);
    }

    public static void removeGlobalKV(String str) {
        ac.a(str, a.UNIVERSAL);
    }

    public static synchronized void setConfigurationDisable(int i10) {
        synchronized (TalkingDataSDK.class) {
            ac.setConfigurationDisable(i10);
        }
    }

    public static void setGlobalKV(String str, Object obj) {
        ac.a(str, obj, a.UNIVERSAL);
    }

    public static void setReportUncaughtExceptions(boolean z10) {
        ac.a(z10, a.UNIVERSAL);
    }

    public static void setVerboseLogDisable() {
        ac.c();
    }
}
