package com.mobvoi.companion;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.app.PayTask;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.wear.util.TelephonyUtil;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.Map;
import vk.a;
import yd.g;
/* loaded from: classes2.dex */
public class BrowserActivity extends BasicBrowserActivity {

    /* loaded from: classes2.dex */
    private final class MobvoiJSBridge extends BasicBrowserActivity.b {
        private static final String TAG = "MobvoiJSBridge";

        private MobvoiJSBridge() {
            super();
        }

        @JavascriptInterface
        public void feedback() {
            WearableUiUtils.feedback(BrowserActivity.this);
        }

        @JavascriptInterface
        public void invokeAliPay(String str) {
            Map<String, String> payV2 = new PayTask(BrowserActivity.this).payV2(str, true);
            for (String str2 : payV2.keySet()) {
                if (TextUtils.equals(str2, "resultStatus")) {
                    k.c(TAG, "Alipay result: %s", payV2.get(str2));
                }
            }
        }

        @JavascriptInterface
        public void invokeJupiterEsim(String str) {
            Intent intent = new Intent();
            intent.putExtra("esim_select_region_extra", str);
            BrowserActivity.this.setResult(-1, intent);
            BrowserActivity.this.finish();
        }

        @JavascriptInterface
        public void invokePingPP(String str) {
            a.a(BrowserActivity.this, str);
        }

        @JavascriptInterface
        public void invokeWxPay(String str) {
            BrowserActivity browserActivity = BrowserActivity.this;
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(browserActivity, AppInitializer.getInstance(browserActivity).getWxAppId());
            createWXAPI.registerApp(AppInitializer.getInstance(BrowserActivity.this).getWxAppId());
            createWXAPI.sendReq((PayReq) JSON.parseObject(str, PayReq.class));
        }
    }

    public static void startActivityForAppstore(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.mobvoi.appstore");
        if (launchIntentForPackage != null) {
            launchIntentForPackage.putExtra(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE, "ticwear_companion");
            context.startActivity(launchIntentForPackage);
            return;
        }
        context.startActivity(g.a(context));
    }

    @Override // com.mobvoi.companion.browser.BasicBrowserActivity
    protected BasicBrowserActivity.b createJsBridge() {
        return new MobvoiJSBridge();
    }
}
