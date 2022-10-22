package com.mobvoi.companion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.d;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountHomeActivity;
import com.mobvoi.health.companion.HealthActivity;
import com.mobvoi.health.companion.sleep.SleepDetailActivity;
import com.mobvoi.health.companion.sport.SportDetailActivity;
import com.mobvoi.wear.common.base.WearPath;
import jh.h;
import ta.a;
/* loaded from: classes2.dex */
public class RouteActivity extends d {
    private static final String TAG = "RouteActivity";

    private void parseUri() {
        Uri data = getIntent().getData();
        if (data != null) {
            String scheme = data.getScheme();
            String host = data.getHost();
            String path = data.getPath();
            k.c(TAG, "start from uri, scheme : %s , host : %s, path : %s", scheme, host, path);
            if (TextUtils.equals("mobvoi", scheme)) {
                if (TextUtils.isEmpty(a.x())) {
                    k.a(TAG, "Check account not logged in！");
                    Intent intent = new Intent(this, AccountHomeActivity.class);
                    intent.putExtra("key_type", "key_login");
                    intent.addFlags(268435456);
                    startActivity(intent);
                    finish();
                    return;
                }
                String queryParameter = data.getQueryParameter("dateType");
                String queryParameter2 = data.getQueryParameter("endDate");
                long j10 = -1;
                if (!TextUtils.isEmpty(queryParameter2)) {
                    try {
                        j10 = Long.parseLong(queryParameter2);
                    } catch (NumberFormatException e10) {
                        k.e(TAG, "timestamp parsed error!", e10);
                    }
                }
                if (TextUtils.equals(path, WearPath.Health.HEALTH)) {
                    HealthActivity.x0(this, queryParameter, j10);
                } else if (TextUtils.equals(path, "/fitness")) {
                    h.s0(this, SportDetailActivity.class, queryParameter, j10);
                } else if (TextUtils.equals(path, WearPath.Sleep.SLEEP)) {
                    h.s0(this, SleepDetailActivity.class, queryParameter, j10);
                }
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseUri();
    }
}
