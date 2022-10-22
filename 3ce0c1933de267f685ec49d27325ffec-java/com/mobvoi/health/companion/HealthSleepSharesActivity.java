package com.mobvoi.health.companion;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.mobvoi.companion.base.m3.a;
import com.mobvoi.health.companion.HealthSleepSharesActivity;
import fg.s;
import fg.t;
import fg.u;
/* loaded from: classes2.dex */
public class HealthSleepSharesActivity extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f26833g);
        ((TextView) findViewById(s.V)).setText(u.f26950q);
        findViewById(s.f26820z).setOnClickListener(new View.OnClickListener() { // from class: fg.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HealthSleepSharesActivity.this.H(view);
            }
        });
        if (bundle == null) {
            com.mobvoi.health.companion.sleep.a aVar = new com.mobvoi.health.companion.sleep.a();
            Bundle bundle2 = new Bundle();
            bundle2.putString("sleepId", getIntent().getStringExtra("sleepId"));
            aVar.setArguments(bundle2);
            getSupportFragmentManager().l().b(s.J0, aVar).j();
        }
    }
}
