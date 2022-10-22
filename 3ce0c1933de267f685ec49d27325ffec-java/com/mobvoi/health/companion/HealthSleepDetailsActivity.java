package com.mobvoi.health.companion;

import android.os.Bundle;
import com.mobvoi.companion.base.m3.a;
import fg.s;
import fg.t;
import tg.d;
/* loaded from: classes2.dex */
public class HealthSleepDetailsActivity extends a {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f26834h);
        if (bundle == null) {
            d dVar = new d();
            Bundle bundle2 = new Bundle();
            bundle2.putString("sportId", getIntent().getStringExtra("sportId"));
            dVar.setArguments(bundle2);
            getSupportFragmentManager().l().b(s.J0, dVar).k();
        }
    }
}
