package com.mobvoi.companion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.companion.setting.CompanionSetting;
import io.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: AppInitializer.kt */
/* loaded from: classes2.dex */
public final class AppInitializer implements AccountManager.f {
    public static final Companion Companion = new Companion(null);
    private static final int OVERSEA_SUPPORT_VERSION = 14800;
    private static final String SPEECH_WORK_DIR = "companion";
    private static final int SUPPORT_VERSION = 48000;
    private static final String TAG = "CompanionAppInitializer";
    private static final String TICWEAR_WX_APP_ID = "wxae399a44829855e9";
    private static final String VPA_WX_APP_ID = "wx4de775c4090faa82";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile AppInitializer sInstance;
    private Context mContext;
    private final Intent notificationIntent;

    /* compiled from: AppInitializer.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final AppInitializer getInstance(Context context) {
            i.f(context, "context");
            if (AppInitializer.sInstance == null) {
                synchronized (AppInitializer.class) {
                    if (AppInitializer.sInstance == null) {
                        Companion companion = AppInitializer.Companion;
                        AppInitializer.sInstance = new AppInitializer(context, null);
                    }
                    m mVar = m.f28349a;
                }
            }
            return AppInitializer.sInstance;
        }
    }

    /* compiled from: AppInitializer.kt */
    /* loaded from: classes2.dex */
    public enum Platform {
        VPA,
        TICWEAR
    }

    private AppInitializer(Context context) {
        Context applicationContext = context.getApplicationContext();
        i.e(applicationContext, "context.applicationContext");
        this.mContext = applicationContext;
    }

    public /* synthetic */ AppInitializer(Context context, f fVar) {
        this(context);
    }

    public static final AppInitializer getInstance(Context context) {
        return Companion.getInstance(context);
    }

    public final String getAppkey() {
        String appVoiceKey = CompanionSetting.getAppVoiceKey(this.mContext, a.isOversea());
        i.e(appVoiceKey, "getAppVoiceKey(mContext, BaseCompanionSetting.isOversea())");
        return appVoiceKey;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final Intent getNotificationIntent() {
        return this.notificationIntent;
    }

    public final String getWxAppId() {
        String packageName = this.mContext.getPackageName();
        if (i.b("com.mobvoi.baiding", packageName)) {
            return VPA_WX_APP_ID;
        }
        if (i.b(BuildConfig.LIBRARY_PACKAGE_NAME, packageName)) {
            return TICWEAR_WX_APP_ID;
        }
        throw new IllegalArgumentException("Invalid app.");
    }

    @Override // com.mobvoi.assistant.account.data.AccountManager.f
    public void onCancel() {
    }

    @Override // com.mobvoi.assistant.account.data.AccountManager.f
    public void onEvent(AccountManager.AccountChangeEvent event, AccountManager.h callback) {
        i.f(event, "event");
        i.f(callback, "callback");
        if (event == AccountManager.AccountChangeEvent.OnLogout || event == AccountManager.AccountChangeEvent.OnCleanUp) {
            CompanionSetting.setNotStarted(this.mContext);
            CompanionSetting.setDeviceName("");
            CompanionSetting.setDeviceAddress(this.mContext, "");
            gd.a.a();
        } else if (event == AccountManager.AccountChangeEvent.OnLogin) {
            sa.a e10 = ta.a.e();
            sb.a.g(e10.wwid, e10.phoneNumber, e10.email, e10.nickName, e10.region, e10.sex == 0);
            rb.a.v(this.mContext);
        }
    }

    public final void setMContext(Context context) {
        i.f(context, "<set-?>");
        this.mContext = context;
    }
}
