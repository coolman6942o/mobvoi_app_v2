package com.mobvoi.companion;

import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.health.k1;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.server.PhoneMessageProxyService;
import fd.a;
/* loaded from: classes2.dex */
public class WearableModule {
    public static final String TAG = "WearableModule";
    private static WearableModule sInstance = new WearableModule();
    private static boolean wearableModuleInitialed = false;
    private boolean mIsVpa;

    /* loaded from: classes2.dex */
    public enum WearableType {
        TicWatch,
        TicWear,
        TicBand,
        TicLite
    }

    private WearableModule() {
    }

    public static void finish() {
        k1.b();
        wearableModuleInitialed = false;
    }

    public static WearableModule getInstance() {
        return sInstance;
    }

    public static void init(Context context, WearableType wearableType) {
        if (wearableModuleInitialed) {
            k.a(TAG, "Health module already initialed.");
            reInit(context, wearableType);
            return;
        }
        k1.c(context, wearableType);
        wearableModuleInitialed = true;
    }

    private void initDefaultHealthInfo(Context context) {
        init(context, WearableType.TicWatch);
    }

    private void initMps(Context context, boolean z10) {
        if (z10) {
            PhoneMessageProxyService.onAppStart(context, true, false);
        } else {
            PhoneMessageProxyService.onAppStart(context, true, false);
        }
        MessageProxyClient.getInstance().connectProxyService();
        MessageProxyClient.getInstance().registerMessagePath("/debug", 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.Companion.COMPANION, 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.Health.HEALTH, 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.Sports.SPORTS, 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.TicPay.PREFIX, 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.Lpa.PREFIX, 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.Tickids.PREFIX, 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.WatchfaceMarket.PREFIX, 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.ScreenShot.PREFIX, 1);
        MessageProxyClient.getInstance().registerMessagePath(WearPath.Recorder.RECORDER, 1);
        MessageProxyClient.getInstance().addListener(a.b());
    }

    public static boolean isWearableModuleInitialed() {
        return wearableModuleInitialed;
    }

    private static void reInit(Context context, WearableType wearableType) {
        if (wearableType != WearableType.TicBand) {
            eg.a.e().q(true);
        }
    }

    public void initApp(Context context, boolean z10) {
        this.mIsVpa = z10;
        initMps(context, z10);
        initDefaultHealthInfo(context);
    }

    public boolean isVpa() {
        return this.mIsVpa;
    }
}
