package com.mobvoi.device;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.a;
import com.mobvoi.companion.base.m3.d;
import ge.l;
import ge.m;
/* loaded from: classes2.dex */
public class DevicePairActivity extends d {
    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return l.a_res_0x7f0e0036;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        a supportActionBar;
        super.onCreate(bundle);
        setTitle(m.a_res_0x7f14003b);
        if (TextUtils.isEmpty(ta.a.s()) && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.t(false);
        }
    }
}
