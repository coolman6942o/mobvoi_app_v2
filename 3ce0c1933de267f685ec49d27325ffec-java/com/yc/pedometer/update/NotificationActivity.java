package com.yc.pedometer.update;

import android.app.Activity;
import android.os.Bundle;
import gn.u;
/* loaded from: classes2.dex */
public class NotificationActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u.d("MyDeviceActivity", "NotificationActivity---isTaskRoot=" + isTaskRoot());
        isTaskRoot();
        finish();
    }
}
