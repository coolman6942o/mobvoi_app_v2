package com.mobvoi.health.companion;

import android.os.Bundle;
import com.mobvoi.companion.base.m3.a;
import com.mobvoi.health.common.data.pojo.SportType;
import fg.s;
import fg.t;
import zg.a0;
/* loaded from: classes2.dex */
public class McuHealthSportDetailsActivity extends a {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f26834h);
        if (bundle == null) {
            a0 a0Var = new a0();
            Bundle bundle2 = new Bundle();
            bundle2.putString("sportId", getIntent().getStringExtra("sportId"));
            bundle2.putSerializable("type", (SportType) getIntent().getSerializableExtra("type"));
            a0Var.setArguments(bundle2);
            getSupportFragmentManager().l().b(s.J0, a0Var).j();
        }
    }
}
