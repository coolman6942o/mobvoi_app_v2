package com.mobvoi.companion.lpa;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.R;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.WearInfo;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import lb.c;
/* compiled from: SimOpenBaseActivity.kt */
/* loaded from: classes2.dex */
public final class SimOpenBaseActivity extends l {

    /* compiled from: SimOpenBaseActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

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
        h hVar;
        super.onCreate(bundle);
        Fragment uVar = new u();
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
            if (e10 == null || TextUtils.isEmpty(e10.certModel)) {
                k.a("SimOpenBaseActivity", "Maybe wearInfo doesn't has certModel");
            } else {
                Bundle bundle2 = new Bundle();
                if (i.b(TicwatchModels.CertModels.PRO_4G_US_OPEN, e10.certModel) || i.b(TicwatchModels.CertModels.PRO_4G_US_VERIZON, e10.certModel)) {
                    hVar = new h();
                    bundle2.putString("regiion", "regiion_us");
                    hVar.setArguments(bundle2);
                } else if (c.d()) {
                    uVar = new i();
                } else {
                    hVar = new h();
                    bundle2.putString("regiion", "regiion_eu");
                    hVar.setArguments(bundle2);
                }
                uVar = hVar;
            }
        }
        if (i.b("unicom", CompanionSetting.getTicwatchChannel())) {
            if (CompanionSetting.getUnicomProfileEnableStatus()) {
                uVar = new e();
            } else {
                uVar = new m0();
            }
            setTitle(getString(R.string.item_3g_center));
        } else {
            setTitle(getString(R.string.item_4g_center));
        }
        getSupportFragmentManager().l().b(R.id.fragment, uVar).k();
    }
}
