package com.mobvoi.companion.scheduler;

import android.content.Intent;
import androidx.core.app.g;
import com.mobvoi.android.common.utils.k;
import md.a;
/* loaded from: classes2.dex */
public class PeriodicalIntentService extends g {
    @Override // androidx.core.app.g
    protected void g(Intent intent) {
        k.c("PeriodicalIntentService", "onHandleWork %s", intent);
        if ("com.mobvoi.companion.action.UPLOAD_INSTALLED_APPS".equals(intent.getAction())) {
            a.b();
            a.c(this);
        }
    }
}
