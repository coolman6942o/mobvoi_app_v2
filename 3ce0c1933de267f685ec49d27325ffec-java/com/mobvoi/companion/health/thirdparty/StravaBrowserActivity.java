package com.mobvoi.companion.health.thirdparty;

import android.os.Bundle;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.browser.BasicBrowserActivity;
/* loaded from: classes2.dex */
public class StravaBrowserActivity extends BasicBrowserActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.browser.BasicBrowserActivity, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String userAgentString = getWebView().getSettings().getUserAgentString();
        getWebView().getSettings().setUserAgentString("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        k.a("StravaBrowserActivity", userAgentString);
    }
}
