package com.yc.pedometer.sdk;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.yc.pedometer.sdk.BluetoothLeService;
import en.d;
import en.j;
import gn.u;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    private static a f24669i;

    /* renamed from: a  reason: collision with root package name */
    private Context f24670a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24672c;

    /* renamed from: d  reason: collision with root package name */
    private BluetoothAdapter f24673d;

    /* renamed from: e  reason: collision with root package name */
    private d f24674e;

    /* renamed from: h  reason: collision with root package name */
    private j f24677h;

    /* renamed from: b  reason: collision with root package name */
    private BluetoothLeService f24671b = null;

    /* renamed from: f  reason: collision with root package name */
    private ServiceConnection f24675f = new ServiceConnectionC0269a();

    /* renamed from: g  reason: collision with root package name */
    private BluetoothAdapter.LeScanCallback f24676g = new b();

    /* renamed from: com.yc.pedometer.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class ServiceConnectionC0269a implements ServiceConnection {
        ServiceConnectionC0269a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (((BluetoothLeService.a) iBinder).a() instanceof BluetoothLeService) {
                try {
                    a.this.f24671b = ((BluetoothLeService.a) iBinder).a();
                } catch (Exception e10) {
                    u.a("onServiceConnected", "onServiceConnected  (BluetoothLeService.LocalBinder) service =" + e10);
                }
                if (a.this.f24671b != null) {
                    a.this.f24671b.E0();
                }
                u.a("onServiceConnected", "onServiceConnected  mICallback =" + a.this.f24677h);
                if (a.this.f24677h != null) {
                    a.this.f24677h.e(39);
                    return;
                }
                return;
            }
            u.a("onServiceConnected", "instanceof BluetoothLeService false");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes2.dex */
    class b implements BluetoothAdapter.LeScanCallback {
        b() {
        }

        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
            a.this.f24674e.h(bluetoothDevice, i10, bArr);
        }
    }

    private a(Context context) {
        u.a("BLEServiceOperate", "sdk version ute_sdk_v3.1.0 2021-11-26");
        try {
            this.f24672c = context.bindService(new Intent(context, BluetoothLeService.class), this.f24675f, 1);
        } catch (Exception unused) {
        }
        u.a("BLEServiceOperate", "bindService,connect_result=" + this.f24672c);
        this.f24670a = context;
    }

    public static a h(Context context) {
        if (f24669i == null) {
            f24669i = new a(context);
        }
        return f24669i;
    }

    public boolean e(String str) {
        u.d("BLEServiceOperate", "mLeService=" + this.f24671b);
        BluetoothLeService bluetoothLeService = this.f24671b;
        if (bluetoothLeService != null) {
            return bluetoothLeService.V(str);
        }
        return false;
    }

    public void f() {
        fn.a.A(this.f24670a).c0();
        BluetoothLeService bluetoothLeService = this.f24671b;
        if (bluetoothLeService != null) {
            bluetoothLeService.f0();
        }
    }

    public BluetoothLeService g() {
        return this.f24671b;
    }

    public boolean i() {
        boolean hasSystemFeature = this.f24670a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        BluetoothAdapter adapter = ((BluetoothManager) this.f24670a.getSystemService("bluetooth")).getAdapter();
        this.f24673d = adapter;
        if (adapter == null) {
            return false;
        }
        return hasSystemFeature;
    }

    public void j(d dVar) {
        this.f24674e = dVar;
    }

    public void k(j jVar) {
        u.a("onServiceConnected", "setServiceStatusCallback mICallback =" + this.f24677h);
        this.f24677h = jVar;
    }

    public void l() {
        BluetoothAdapter bluetoothAdapter = this.f24673d;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.startLeScan(this.f24676g);
        }
    }

    public void m() {
        BluetoothAdapter bluetoothAdapter = this.f24673d;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(this.f24676g);
        }
    }

    public void n() {
        if (this.f24672c) {
            BluetoothLeService.d();
            try {
                this.f24670a.unbindService(this.f24675f);
                this.f24672c = false;
            } catch (Exception unused) {
            }
        }
        f24669i = null;
        u.a("BLEServiceOperate", "unBindService,connect_result2=" + this.f24672c);
    }
}
