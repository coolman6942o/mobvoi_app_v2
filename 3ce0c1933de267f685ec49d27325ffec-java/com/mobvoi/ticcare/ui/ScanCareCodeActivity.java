package com.mobvoi.ticcare.ui;

import ak.e;
import ak.f;
import ak.g;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.TicAppConstants;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.qr.QRCodeReaderView;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.mobvoi.ticcare.ui.ScanCareCodeActivity;
import gk.b;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import lb.c;
import lk.a;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ScanCareCodeActivity extends d implements Observer, QRCodeReaderView.b, View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    private static final String f20783f = ScanCareCodeActivity.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private QRCodeReaderView f20784a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20785b = false;

    /* renamed from: c  reason: collision with root package name */
    private b f20786c;

    /* renamed from: d  reason: collision with root package name */
    private TicCareDeviceInfo f20787d;

    /* renamed from: e  reason: collision with root package name */
    private Dialog f20788e;

    private boolean K() {
        if (a.a(this, "android.permission.CAMERA") == 0) {
            return true;
        }
        if (a.d(this, "android.permission.CAMERA")) {
            a.c(this, new String[]{"android.permission.CAMERA"}, 10);
            return false;
        }
        U();
        return true;
    }

    private void M() {
        Intent intent = new Intent(this, TicCareSettingNickActivity.class);
        intent.putExtra("extra.device_info", this.f20787d);
        intent.putExtra("extra.is_add_care_device", true);
        startActivity(intent);
        finish();
    }

    private void N() {
        Intent intent = new Intent("action_device_add");
        intent.putExtra("device_tag", "tic_care");
        b1.a.b(com.mobvoi.android.common.utils.b.e()).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(Integer num) {
        int intValue = num.intValue();
        if (intValue == -1 || intValue == 100002) {
            Toast.makeText(this, getString(g.f247r), 0).show();
            finish();
        } else if (intValue == 1000) {
            Toast.makeText(this, getString(g.f235a), 0).show();
            N();
            finish();
        } else if (intValue == 1001) {
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(DialogInterface dialogInterface, int i10) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        try {
            startActivity(intent);
        } catch (Exception unused) {
            k.d(f20783f, "Error to go Settings.");
        }
        dialogInterface.dismiss();
        finish();
    }

    private void T(String str) {
        this.f20786c.b0(str);
    }

    private void U() {
        if (this.f20788e == null) {
            this.f20788e = new k7.b(this).q(g.f246q).d(false).D(getString(g.f245p, new Object[]{getString(g.f244o)})).j(g.f237f, new DialogInterface.OnClickListener() { // from class: hk.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    ScanCareCodeActivity.this.Q(dialogInterface, i10);
                }
            }).m(g.f238g, new DialogInterface.OnClickListener() { // from class: hk.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    ScanCareCodeActivity.this.S(dialogInterface, i10);
                }
            }).a();
        }
        this.f20788e.show();
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void E(String str, byte[] bArr, Camera.Parameters parameters) {
        String str2 = f20783f;
        k.h(str2, " onQRCodeRead result = " + str);
        if (TextUtils.isEmpty(str) || !str.contains("care_code")) {
            this.f20785b = false;
            Toast.makeText(this, getString(g.e_res_0x7f140263), 0).show();
            return;
        }
        this.f20785b = true;
        QRCodeReaderView qRCodeReaderView = this.f20784a;
        if (qRCodeReaderView != null) {
            qRCodeReaderView.setCanScan(false);
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).get("care_code");
            TicCareDeviceInfo ticCareDeviceInfo = new TicCareDeviceInfo();
            this.f20787d = ticCareDeviceInfo;
            ticCareDeviceInfo.wwid = jSONObject.optString("wwid");
            this.f20787d.deviceName = jSONObject.optString(TicAppConstants.CARE_DEVICE_NAME);
            this.f20787d.deviceType = jSONObject.optString("deviceType");
            this.f20787d.deviceId = jSONObject.optString("deviceId");
            TicCareDeviceInfo ticCareDeviceInfo2 = this.f20787d;
            ticCareDeviceInfo2.remarkName = "";
            T(ticCareDeviceInfo2.wwid);
        } catch (JSONException e10) {
            e10.printStackTrace();
            Toast.makeText(this, getString(g.e_res_0x7f140263), 0).show();
        }
        this.f20785b = false;
    }

    protected void L() {
        if (K()) {
            QRCodeReaderView qRCodeReaderView = (QRCodeReaderView) findViewById(ak.d.f229s);
            this.f20784a = qRCodeReaderView;
            qRCodeReaderView.setOnQRCodeReadListener(this);
        }
        b bVar = (b) new h0(this).a(b.class);
        this.f20786c = bVar;
        bVar.B().i(this, new x() { // from class: hk.c
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                ScanCareCodeActivity.this.O((Integer) obj);
            }
        });
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void P() {
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void R() {
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return e.a_res_0x7f0e004d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 101 && intent != null) {
            try {
                E(oj.e.a(MediaStore.Images.Media.getBitmap(getContentResolver(), intent.getData())), null, null);
            } catch (IOException e10) {
                e10.printStackTrace();
                Toast.makeText(this, getString(g.f247r), 0).show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(g.d_res_0x7f1401cc);
        L();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(f.b_res_0x7f0f0002, menu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QRCodeReaderView qRCodeReaderView = this.f20784a;
        if (qRCodeReaderView != null) {
            qRCodeReaderView.setCanScan(false);
        }
        this.f20785b = false;
        this.f20786c.w();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != ak.d.f228q) {
            return super.onOptionsItemSelected(menuItem);
        }
        c.e(this, 101);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z10) {
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 10 && strArr.length > 0 && "android.permission.CAMERA".equals(strArr[0])) {
            finish();
            if (iArr.length > 0 && iArr[0] == 0) {
                overridePendingTransition(0, 0);
                startActivity(new Intent(this, ScanCareCodeActivity.class));
            }
        }
    }

    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        QRCodeReaderView qRCodeReaderView = this.f20784a;
        if (qRCodeReaderView != null) {
            qRCodeReaderView.setCanScan(!this.f20785b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStop() {
        super.onStop();
        QRCodeReaderView qRCodeReaderView = this.f20784a;
        if (qRCodeReaderView != null) {
            qRCodeReaderView.setCanScan(false);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue() && !isFinishing()) {
            finish();
        }
    }
}
