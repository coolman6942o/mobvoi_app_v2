package com.mobvoi.health.companion;

import android.os.Bundle;
import com.mobvoi.companion.base.m3.a;
import com.mobvoi.health.common.data.pojo.SportType;
import zg.p;
/* loaded from: classes2.dex */
public class HealthSportDetailsActivity extends a {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            p pVar = new p();
            Bundle bundle2 = new Bundle();
            boolean booleanExtra = getIntent().getBooleanExtra("devicePage", false);
            bundle2.putString("sportId", getIntent().getStringExtra("sportId"));
            bundle2.putSerializable("type", (SportType) getIntent().getSerializableExtra("type"));
            bundle2.putBoolean("devicePage", booleanExtra);
            pVar.setArguments(bundle2);
            getSupportFragmentManager().l().b(16908290, pVar).j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "sportDetail");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "sportDetail");
    }
}
