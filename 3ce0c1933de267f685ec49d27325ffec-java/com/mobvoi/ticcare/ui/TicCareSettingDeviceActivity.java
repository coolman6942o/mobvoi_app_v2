package com.mobvoi.ticcare.ui;

import ak.e;
import ak.g;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import b1.a;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.mobvoi.ticcare.ui.TicCareSettingDeviceActivity;
import gk.b;
/* loaded from: classes2.dex */
public class TicCareSettingDeviceActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    private TextView f20789a;

    /* renamed from: b  reason: collision with root package name */
    private TicCareDeviceInfo f20790b;

    /* renamed from: c  reason: collision with root package name */
    private b f20791c;

    private void K() {
        this.f20791c.t(this.f20790b);
    }

    private void M() {
        a.b(getApplicationContext()).d(new Intent("action.unbind_ticcare_device"));
        a.b(getApplicationContext()).d(new Intent("com.mobvoi.baiding.action.JUMP_TO_DEVICE"));
        Intent intent = new Intent("action_device_add");
        intent.putExtra("device_tag", "tic_care");
        a.b(com.mobvoi.android.common.utils.b.e()).d(intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(Boolean bool) {
        if (bool.booleanValue()) {
            M();
        } else {
            Toast.makeText(this, getString(g.f247r), 0).show();
        }
    }

    private void S() {
        Intent intent = new Intent(this, TicCareSettingNickActivity.class);
        intent.putExtra("extra.device_info", this.f20790b);
        startActivity(intent);
        finish();
    }

    protected void L() {
        Intent intent = getIntent();
        if (intent != null) {
            TicCareDeviceInfo ticCareDeviceInfo = (TicCareDeviceInfo) intent.getParcelableExtra("extra.device_info");
            this.f20790b = ticCareDeviceInfo;
            if (!TextUtils.isEmpty(ticCareDeviceInfo.remarkName)) {
                this.f20789a.setText(this.f20790b.remarkName);
            } else {
                this.f20789a.setText(this.f20790b.deviceName);
            }
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return e.e_res_0x7f0e005a;
    }

    protected void initView() {
        setTitle(g.f239h);
        this.f20789a = (TextView) findViewById(ak.d.O_res_0x7f0b081e);
        findViewById(ak.d.v_res_0x7f0b05ab).setOnClickListener(new View.OnClickListener() { // from class: hk.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicCareSettingDeviceActivity.this.N(view);
            }
        });
        findViewById(ak.d.u_res_0x7f0b059f).setOnClickListener(new View.OnClickListener() { // from class: hk.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TicCareSettingDeviceActivity.this.O(view);
            }
        });
        b bVar = (b) new h0(this).a(b.class);
        this.f20791c = bVar;
        bVar.y().i(this, new x() { // from class: hk.f
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                TicCareSettingDeviceActivity.this.Q((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        L();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f20791c.w();
    }
}
