package com.mobvoi.companion.health;

import android.os.Bundle;
import com.mobvoi.companion.R;
import com.mobvoi.companion.TicAppConstants;
import com.mobvoi.health.companion.system.c;
import io.m;
import ta.a;
/* compiled from: CareHealthActivity.kt */
/* loaded from: classes2.dex */
public final class CareHealthActivity extends o1 {
    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return R.layout.care_health_activity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(TicAppConstants.CARE_REMARK_NAME);
        String stringExtra2 = getIntent().getStringExtra(TicAppConstants.CARE_DEVICE_NAME);
        boolean booleanExtra = getIntent().getBooleanExtra(TicAppConstants.CARE_SHOW_SPORT_DATA, false);
        setTitle(stringExtra);
        setSubtitle(stringExtra2);
        if (bundle == null) {
            w3 w3Var = new w3();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean(TicAppConstants.CARE_SHOW_SPORT_DATA, booleanExtra);
            m mVar = m.f28349a;
            w3Var.setArguments(bundle2);
            getSupportFragmentManager().l().b(R.id.fragment_container, w3Var).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c.a().j(a.x(), a.d(), false);
    }
}
