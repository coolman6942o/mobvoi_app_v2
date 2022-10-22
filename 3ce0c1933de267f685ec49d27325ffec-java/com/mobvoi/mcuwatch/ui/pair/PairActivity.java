package com.mobvoi.mcuwatch.ui.pair;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.lifecycle.h0;
import com.google.gson.e;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.ui.bledialog.BleOpenHandler;
import com.mobvoi.mcuwatch.ui.pair.PairActivity;
import com.mobvoi.mcuwatch.ui.search.widget.SearchBlankPage;
import com.mobvoi.wear.common.base.TicwatchModels;
import ei.h;
import fi.a;
import fj.j;
import fj.p;
import nj.g;
import nj.q;
import pk.f;
import pk.n;
import sh.i;
import sh.k;
import yp.b;
/* loaded from: classes2.dex */
public class PairActivity extends d implements BleOpenHandler.c, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f19957a;

    /* renamed from: d  reason: collision with root package name */
    private p f19960d;

    /* renamed from: e  reason: collision with root package name */
    private Button f19961e;

    /* renamed from: f  reason: collision with root package name */
    private SearchBlankPage f19962f;

    /* renamed from: g  reason: collision with root package name */
    private f f19963g;

    /* renamed from: i  reason: collision with root package name */
    private BleOpenHandler f19965i;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19958b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f19959c = 3;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19964h = false;

    private boolean L() {
        f fVar = this.f19963g;
        return fVar != null && !TextUtils.isEmpty(fVar.a());
    }

    private void M() {
        l.a().postDelayed(new Runnable() { // from class: fj.a
            @Override // java.lang.Runnable
            public final void run() {
                PairActivity.this.Q();
            }
        }, 100L);
    }

    private void N() {
        Intent intent = new Intent("com.mobvoi.action.DEVICE");
        intent.setPackage(getPackageName());
        intent.addFlags(4194304);
        intent.setFlags(536870912);
        startActivity(intent);
    }

    @SuppressLint({"MissingPermission"})
    private void O() {
        String stringExtra = getIntent().getStringExtra("page_from");
        this.f19957a = stringExtra;
        if (TextUtils.equals(stringExtra, "search_device")) {
            this.f19963g = (f) new e().j(getIntent().getStringExtra("data"), f.class);
        } else {
            h.a().c(this);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) getIntent().getParcelableExtra("ble_device");
            String stringExtra2 = getIntent().getStringExtra("watch_model");
            String name = bluetoothDevice.getName();
            String address = bluetoothDevice.getAddress();
            if (!TextUtils.isEmpty(stringExtra2) && "TicWatch GTW".contains(stringExtra2)) {
                name = g.j(name);
            } else if (!TextUtils.isEmpty(name)) {
                int i10 = k.O2;
                if (name.contains(getString(i10))) {
                    name = name.replace(getString(i10), getString(k.P2));
                }
            }
            this.f19963g = new f(name, address, -1);
        }
        if (!L()) {
            com.mobvoi.android.common.utils.k.d("PairActivity", "Must has address or device params");
            finish();
            return;
        }
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        this.f19960d.onCleared();
        N();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && this.f19958b) {
            String str2 = " ";
            if (this.f19963g.a().split(":").length >= 2) {
                str2 = str2 + split[split.length - 2] + split[split.length - 1];
            }
            if (str.contains("RH239C")) {
                this.f19963g.d("TicWatch GTH Pro" + str2);
            } else if (str.contains("RH239")) {
                this.f19963g.d(TicwatchModels.TICWATCH_GTH + str2);
            } else if (str.contains("RH115")) {
                this.f19963g.d(TicwatchModels.TICWATCH_GTX + str2);
            } else if (str.contains("RH275")) {
                this.f19963g.d("TicWatch GTA" + str2);
            } else if (str.contains("RH189KM")) {
                this.f19963g.d("Mobvoi GTK" + str2);
            } else if (str.contains("RH189")) {
                this.f19963g.d("TicWatch GTK" + str2);
            }
            V();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(a aVar) {
        int c10 = aVar.c();
        if (this.f19959c != c10) {
            this.f19959c = c10;
            if (c10 == 0) {
                b0(5);
            } else if (c10 == 1) {
                com.mobvoi.android.common.utils.k.c("PairActivity", "Ble Device CONNECTED name = %s ", this.f19963g.b());
                if (TextUtils.isEmpty(this.f19963g.b())) {
                    this.f19958b = true;
                } else {
                    V();
                }
            } else if (c10 == 2) {
                b0(3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(Throwable th2) {
        com.mobvoi.android.common.utils.k.e("PairActivity", "Connect fail", th2);
        this.f19962f.setMode(5);
    }

    private void V() {
        this.f19958b = false;
        b0(4);
        this.f19960d.x(this.f19963g);
        n.d(this.f19963g);
        String i10 = q.i(this.f19963g.b());
        String a10 = this.f19963g.a();
        sb.a.c(a10, a10, i10);
    }

    private void W() {
    }

    private void X() {
    }

    public static void Y(Context context, BluetoothDevice bluetoothDevice, String str, String str2) {
        Intent intent = new Intent(context, PairActivity.class);
        intent.putExtra("ble_device", bluetoothDevice);
        intent.putExtra("watch_model", str);
        intent.putExtra("page_from", str2);
        context.startActivity(intent);
    }

    public static void Z(Context context, f fVar, String str) {
        Intent intent = new Intent(context, PairActivity.class);
        intent.putExtra("data", new e().s(fVar));
        intent.putExtra("page_from", str);
        context.startActivity(intent);
    }

    private void a0() {
        if (!this.f19960d.n()) {
            b0(5);
        } else if (!this.f19964h) {
            com.mobvoi.android.common.utils.k.a("PairActivity", "startConnect");
            b0(3);
            this.f19959c = 3;
            this.f19960d.onCleared();
            p pVar = this.f19960d;
            pVar.a(pVar.I().H(xp.a.b()).X(new b() { // from class: fj.c
                @Override // yp.b
                public final void call(Object obj) {
                    PairActivity.this.S((String) obj);
                }
            }));
            p pVar2 = this.f19960d;
            pVar2.a(pVar2.P(this, this.f19963g.a()).H(xp.a.b()).Y(new b() { // from class: fj.b
                @Override // yp.b
                public final void call(Object obj) {
                    PairActivity.this.T((a) obj);
                }
            }, new b() { // from class: fj.d
                @Override // yp.b
                public final void call(Object obj) {
                    PairActivity.this.U((Throwable) obj);
                }
            }));
        }
    }

    private void b0(int i10) {
        this.f19962f.setMode(i10);
        if (i10 == 3) {
            this.f19964h = true;
            this.f19961e.setText(k.f34848p0);
            X();
        } else if (i10 == 4) {
            this.f19961e.setText(k.N3);
            W();
        } else if (i10 == 5) {
            this.f19964h = false;
            this.f19961e.setText(k.f34884w0);
            W();
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.bledialog.BleOpenHandler.c
    public void A() {
        a0();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return i.A;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        onClick(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int mode = this.f19962f.getMode();
        if (mode == 3) {
            this.f19960d.B(this);
            finish();
        } else if (mode == 4) {
            M();
        } else if (mode == 5) {
            if (view == null) {
                finish();
            } else {
                a0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19960d = (p) new h0(this).a(p.class);
        this.f19961e = (Button) findViewById(sh.h.f34689r2);
        this.f19962f = (SearchBlankPage) findViewById(sh.h.f34693s2);
        this.f19961e.setOnClickListener(this);
        setTitle(k.Y2);
        if (!this.f19960d.n()) {
            BleOpenHandler bleOpenHandler = new BleOpenHandler(this, this, getLifecycle());
            this.f19965i = bleOpenHandler;
            bleOpenHandler.n();
        }
        if (j.e(this)) {
            O();
        } else {
            androidx.core.app.a.s(this, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"}, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 != 10 || !hc.e.k(iArr)) {
            Toast.makeText(this, getString(k.Z1), 0).show();
            b0(3);
            return;
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
