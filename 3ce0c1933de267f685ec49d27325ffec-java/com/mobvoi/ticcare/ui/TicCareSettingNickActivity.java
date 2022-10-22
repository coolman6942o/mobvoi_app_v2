package com.mobvoi.ticcare.ui;

import ak.e;
import ak.f;
import ak.g;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import b1.a;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.mobvoi.ticcare.ui.TicCareSettingNickActivity;
import gk.b;
/* loaded from: classes2.dex */
public class TicCareSettingNickActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    EditText f20800a;

    /* renamed from: b  reason: collision with root package name */
    private b f20801b;

    /* renamed from: c  reason: collision with root package name */
    private TicCareDeviceInfo f20802c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f20803d = false;

    private void J() {
        TicCareDeviceInfo ticCareDeviceInfo;
        String obj = this.f20800a.getText().toString();
        if (!TextUtils.isEmpty(obj) && (ticCareDeviceInfo = this.f20802c) != null) {
            if (this.f20803d) {
                ticCareDeviceInfo.remarkName = obj;
                this.f20801b.s(ticCareDeviceInfo);
                return;
            }
            this.f20801b.e0(ticCareDeviceInfo, obj);
        }
    }

    private void L() {
        a.b(getApplicationContext()).d(new Intent("action.bind_ticcare_device"));
        a.b(getApplicationContext()).d(new Intent("com.mobvoi.baiding.action.JUMP_TO_DEVICE"));
        Intent intent = new Intent("action_device_add");
        intent.putExtra("device_tag", "tic_care");
        a.b(com.mobvoi.android.common.utils.b.e()).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(Integer num) {
        int intValue = num.intValue();
        if (intValue == 0) {
            L();
            finish();
        } else if (intValue != 400) {
            Toast.makeText(this, getString(g.f247r), 0).show();
        } else {
            Toast.makeText(this, getString(g.f236c), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(Integer num) {
        int intValue = num.intValue();
        if (intValue != -1) {
            if (intValue != 0) {
                switch (intValue) {
                    case 100002:
                        break;
                    case 100003:
                        Toast.makeText(this, getString(g.b_res_0x7f1401c8), 0).show();
                        return;
                    default:
                        return;
                }
            } else {
                L();
                finish();
                return;
            }
        }
        Toast.makeText(this, getString(g.f247r), 0).show();
    }

    protected void K() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f20802c = (TicCareDeviceInfo) intent.getParcelableExtra("extra.device_info");
            this.f20803d = intent.getBooleanExtra("extra.is_add_care_device", false);
            if (!TextUtils.isEmpty(this.f20802c.remarkName)) {
                this.f20800a.setText(this.f20802c.remarkName);
            }
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return e.d_res_0x7f0e0059;
    }

    protected void initView() {
        setTitle(g.f239h);
        this.f20800a = (EditText) findViewById(ak.d.i_res_0x7f0b0249);
        String country = getResources().getConfiguration().locale.getCountry();
        if (country.equals("CN") || country.equals("JA")) {
            this.f20800a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        } else {
            this.f20800a.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
        }
        b bVar = (b) new h0(this).a(b.class);
        this.f20801b = bVar;
        bVar.H().i(this, new x() { // from class: hk.g
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                TicCareSettingNickActivity.this.M((Integer) obj);
            }
        });
        this.f20801b.x().i(this, new x() { // from class: hk.h
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                TicCareSettingNickActivity.this.N((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        K();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(f.a_res_0x7f0f0001, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f20801b.w();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != ak.d.f231x) {
            return super.onOptionsItemSelected(menuItem);
        }
        J();
        return true;
    }
}
