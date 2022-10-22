package com.mobvoi.ticcare.ui;

import ak.e;
import ak.g;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.mobvoi.companion.base.m3.d;
import jk.a;
import kk.i;
/* loaded from: classes2.dex */
public class TicCareSettingActivity extends d {
    private void J(a aVar) {
        getSupportFragmentManager().l().s(ak.d.j_res_0x7f0b029c, aVar).h(null).j();
    }

    protected void H() {
        if (getSupportFragmentManager().n0() > 1) {
            getSupportFragmentManager().W0();
        } else {
            androidx.core.app.a.p(this);
        }
    }

    protected void I() {
        J(new i());
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return e.c_res_0x7f0e0058;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        H();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(g.f239h);
        FrameLayout frameLayout = (FrameLayout) findViewById(ak.d.j_res_0x7f0b029c);
        I();
    }
}
