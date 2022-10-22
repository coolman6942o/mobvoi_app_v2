package com.yc.pedometer.update;

import android.app.Activity;
import bp.g;
import gn.u;
/* loaded from: classes2.dex */
public class DfuService extends g {
    @Override // bp.g
    protected Class<? extends Activity> m() {
        u.d("MyDeviceActivity", "DfuService---1");
        return NotificationActivity.class;
    }

    @Override // bp.g
    protected boolean o() {
        return true;
    }
}
