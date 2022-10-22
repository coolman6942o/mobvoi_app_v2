package com.mobvoi.mcuwatch.ui.lpa;

import android.os.Bundle;
import com.mobvoi.companion.R;
import com.mobvoi.companion.base.m3.d;
import zi.a;
/* compiled from: SimOpenBaseActivity.kt */
/* loaded from: classes2.dex */
public final class SimOpenBaseActivity extends d {
    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return R.layout.activity_unicom;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().n0() > 0) {
            getSupportFragmentManager().W0();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getString(R.string.item_4g_center));
        getSupportFragmentManager().l().b(R.id.fragment, new a()).k();
    }
}
