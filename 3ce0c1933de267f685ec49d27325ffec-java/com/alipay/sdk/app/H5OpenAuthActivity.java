package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import com.mobvoi.wear.lpa.LpaConstants;
import y3.a;
/* loaded from: classes.dex */
public class H5OpenAuthActivity extends H5PayActivity {

    /* renamed from: i  reason: collision with root package name */
    public boolean f6862i = false;

    @Override // com.alipay.sdk.app.H5PayActivity
    public void a() {
    }

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.f6862i) {
            try {
                a a10 = a.C0536a.a(getIntent());
                if (a10 != null) {
                    p3.a.g(this, a10, "", a10.f36738d);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            a a10 = a.C0536a.a(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data != null && data.toString().startsWith("alipays://platformapi/startapp")) {
                    finish();
                }
            } catch (Throwable th2) {
                String uri = (intent == null || intent.getData() == null) ? LpaConstants.VALUE_NULL : intent.getData().toString();
                if (a10 != null) {
                    p3.a.e(a10, "biz", "StartActivityEx", th2, uri);
                }
                this.f6862i = true;
                throw th2;
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
