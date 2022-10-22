package com.mobvoi.mcuwatch.ui.pair.qrscan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.a;
import androidx.core.content.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.ui.pair.PairActivity;
import com.mobvoi.mcuwatch.ui.pair.qrscan.ScanQrActivity;
import com.mobvoi.mcuwatch.ui.search.SearchActivity;
import com.mobvoi.qr.QRCodeReaderView;
import ei.h;
import nj.q;
import sh.i;
/* loaded from: classes2.dex */
public class ScanQrActivity extends d implements QRCodeReaderView.b {

    /* renamed from: a  reason: collision with root package name */
    private BluetoothAdapter f19979a;

    /* renamed from: b  reason: collision with root package name */
    private String f19980b;

    /* renamed from: c  reason: collision with root package name */
    private QRCodeReaderView f19981c;

    private boolean N() {
        if (this.f19979a != null) {
            return true;
        }
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            k.d("ScanQrActivity", "Unable to initialize BluetoothManager.");
            Toast.makeText(this, sh.k.X, 0).show();
            finish();
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.f19979a = adapter;
        if (adapter != null) {
            return true;
        }
        k.d("ScanQrActivity", "Initialisation of the Bluetooth Adapter failed");
        Toast.makeText(this, sh.k.X, 0).show();
        finish();
        return false;
    }

    private boolean O() {
        if (b.a(this, "android.permission.CAMERA") == 0) {
            return true;
        }
        n nVar = n.f19178a;
        if (nVar.o()) {
            a.s(this, new String[]{"android.permission.CAMERA"}, 10);
            nVar.c0(false);
            return false;
        } else if (a.w(this, "android.permission.CAMERA")) {
            a.s(this, new String[]{"android.permission.CAMERA"}, 10);
            return false;
        } else {
            a0();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(View view) {
        SearchActivity.start(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(DialogInterface dialogInterface, int i10) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(DialogInterface dialogInterface, int i10) {
        h.a().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(DialogInterface dialogInterface, int i10) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i10) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        try {
            startActivity(intent);
        } catch (Exception unused) {
            k.d("ScanQrActivity", "Error to go Settings.");
        }
        dialogInterface.dismiss();
        finish();
    }

    private String Y(String str) {
        k.a("ScanQrActivity", "parseAddress:" + str);
        try {
            Uri parse = Uri.parse(str);
            this.f19980b = parse.getQueryParameter("model");
            String queryParameter = parse.getQueryParameter("MAC");
            if (TextUtils.isEmpty(queryParameter) || queryParameter.length() < 17) {
                return null;
            }
            return queryParameter.substring(0, 17);
        } catch (Exception unused) {
            k.d("ScanQrActivity", " parseAddress err");
            return null;
        }
    }

    private void Z(Context context) {
        new k7.b(context).q(sh.k.Z2).h(sh.k.X2).d(false).j(sh.k.f34848p0, new DialogInterface.OnClickListener() { // from class: gj.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ScanQrActivity.this.U(dialogInterface, i10);
            }
        }).m(sh.k.D3, gj.d.f27483a).t();
    }

    private void a0() {
        new k7.b(this).d(false).D(getString(sh.k.Y1, new Object[]{getString(sh.k.X1)})).j(sh.k.f34848p0, new DialogInterface.OnClickListener() { // from class: gj.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ScanQrActivity.this.W(dialogInterface, i10);
            }
        }).m(sh.k.f34853q0, new DialogInterface.OnClickListener() { // from class: gj.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ScanQrActivity.this.X(dialogInterface, i10);
            }
        }).t();
    }

    public static void b0(Context context, String str) {
        Intent intent = new Intent(context, ScanQrActivity.class);
        intent.putExtra("page_from", str);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void initView() {
        QRCodeReaderView qRCodeReaderView = (QRCodeReaderView) findViewById(sh.h.f34715x2);
        this.f19981c = qRCodeReaderView;
        qRCodeReaderView.setOnQRCodeReadListener(this);
        findViewById(sh.h.N2).setOnClickListener(new View.OnClickListener() { // from class: gj.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScanQrActivity.this.T(view);
            }
        });
    }

    public static void start(Context context) {
        Intent intent = new Intent(context, ScanQrActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void E(String str, byte[] bArr, Camera.Parameters parameters) {
        k.a("ScanQrActivity", "parse address : " + str);
        if (!TextUtils.isEmpty(str)) {
            String Y = Y(str);
            if (!TextUtils.isEmpty(Y)) {
                QRCodeReaderView qRCodeReaderView = this.f19981c;
                if (qRCodeReaderView != null) {
                    qRCodeReaderView.setCanScan(false);
                }
                Q(Y);
                return;
            }
        }
        Toast.makeText(this, getString(sh.k.f34867s4), 0).show();
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void P() {
    }

    protected void Q(String str) {
        k.a("ScanQrActivity", "connect to a device with address " + str);
        if (N()) {
            if (!BluetoothAdapter.checkBluetoothAddress(str)) {
                Toast.makeText(this, sh.k.f34867s4, 0).show();
                return;
            }
            BluetoothAdapter bluetoothAdapter = this.f19979a;
            if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
                k.d("ScanQrActivity", "ble not enabled or not support 4.0");
                Toast.makeText(this, sh.k.f34822j4, 0).show();
                return;
            }
            BluetoothDevice remoteDevice = this.f19979a.getRemoteDevice(str);
            if (remoteDevice == null) {
                k.d("ScanQrActivity", "unable to get a BluetoothDevice from address " + str);
                Toast.makeText(this, sh.k.f34867s4, 0).show();
                return;
            }
            PairActivity.Y(this, remoteDevice, this.f19980b, "scan_qr");
            new Handler().postDelayed(new Runnable() { // from class: gj.f
                @Override // java.lang.Runnable
                public final void run() {
                    ScanQrActivity.this.S();
                }
            }, 200L);
        }
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void R() {
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return i.f34750r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setTitle(sh.k.f34872t4);
        if (q.g().t()) {
            if (TextUtils.equals(getIntent().getStringExtra("page_from"), "mcu_setting")) {
                q.g().B(q.g().l());
            }
            Z(this);
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f19981c.setCanScan(false);
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 10 && strArr.length > 0 && "android.permission.CAMERA".equals(strArr[0]) && iArr.length > 0) {
            if (iArr[0] != 0) {
                Toast.makeText(this, sh.k.f34793e0, 0).show();
                finish();
                return;
            }
            finish();
            overridePendingTransition(0, 0);
            startActivity(new Intent(this, ScanQrActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (b.a(this, "android.permission.CAMERA") == 0) {
            this.f19981c.setCanScan(true);
        }
    }
}
