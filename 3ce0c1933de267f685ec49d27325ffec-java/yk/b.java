package yk;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import el.d;
import java.util.Locale;
/* loaded from: classes2.dex */
public class b extends yk.a {

    /* renamed from: p  reason: collision with root package name */
    public final BroadcastReceiver f37128p;

    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            short s10;
            BluetoothDevice bluetoothDevice;
            String format;
            String action = intent.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(action) || "android.bluetooth.device.action.CLASS_CHANGED".equals(action)) {
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                s10 = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
                if (bluetoothDevice != null) {
                    if (b.this.f37109b) {
                        format = String.format("%s %s", action, fl.a.b(bluetoothDevice));
                        il.b.j(format);
                    }
                    b.this.e(bluetoothDevice, s10, null);
                } else if (b.this.f37109b) {
                    str = String.format("%s", action);
                    il.b.j(str);
                }
            } else if ("android.bluetooth.device.action.NAME_CHANGED".equals(action) || "android.bluetooth.device.action.UUID".equals(action)) {
                if (b.this.f37115h == 2) {
                    bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    s10 = intent.getShortExtra("android.bluetooth.device.extra.RSSI", (short) 0);
                    if (bluetoothDevice != null) {
                        if (b.this.f37109b) {
                            format = String.format("%s %s/%s", action, bluetoothDevice.getName(), bluetoothDevice.toString());
                            il.b.j(format);
                        }
                        b.this.e(bluetoothDevice, s10, null);
                    } else if (b.this.f37109b) {
                        str = String.format("%s", action);
                        il.b.j(str);
                    }
                }
            } else if ("android.bluetooth.adapter.action.DISCOVERY_STARTED".equals(action)) {
                b.this.a(2);
            } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                b.this.a(3);
            }
        }
    }

    public b(Context context, Handler handler, ScannerParams scannerParams, d dVar) {
        this.f37128p = new a();
        this.f37110c = context.getApplicationContext();
        this.f37113f = handler;
        this.f37111d = scannerParams;
        this.f37112e = dVar;
        c();
    }

    public b(Context context, ScannerParams scannerParams, d dVar) {
        this(context, null, scannerParams, dVar);
    }

    @Override // yk.a
    public boolean c() {
        if (!super.c()) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.addAction("android.bluetooth.device.action.UUID");
        this.f37110c.registerReceiver(this.f37128p, intentFilter);
        il.b.k(this.f37109b, "bredr initialized");
        return true;
    }

    @Override // yk.a
    public boolean d(BluetoothDevice bluetoothDevice) {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.f37111d.j() == 33) {
                if (bluetoothDevice.getType() != 1) {
                    if (this.f37109b) {
                        il.b.j(String.format(Locale.US, "filter, invalid type: %d, expect type is %d", Integer.valueOf(bluetoothDevice.getType()), 1));
                    }
                    return false;
                }
            } else if (!(this.f37111d.j() != 32 || bluetoothDevice.getType() == 1 || bluetoothDevice.getType() == 3 || bluetoothDevice.getType() == 0)) {
                if (this.f37109b) {
                    il.b.j(String.format(Locale.US, "filter, invalid type: %d, expect type is %d/%d/%d", Integer.valueOf(bluetoothDevice.getType()), 0, 1, 3));
                }
                return false;
            }
        }
        if (!TextUtils.isEmpty(this.f37111d.e())) {
            if (!jl.a.c(this.f37111d.e(), bluetoothDevice.getName())) {
                if (!this.f37111d.o()) {
                    if (this.f37108a) {
                        il.b.j(String.format("conflict name: %s", bluetoothDevice.getName()));
                    }
                    return false;
                } else if (bluetoothDevice.getName() == null || !bluetoothDevice.getName().contains(this.f37111d.e())) {
                    if (this.f37108a) {
                        il.b.j(String.format("conflict name: %s", bluetoothDevice.getName()));
                    }
                    return false;
                }
            }
        } else if (!this.f37111d.p() && TextUtils.isEmpty(bluetoothDevice.getName())) {
            if (this.f37109b) {
                il.b.j("name is null, ignore");
            }
            return false;
        }
        if (TextUtils.isEmpty(this.f37111d.a()) || jl.a.c(this.f37111d.a(), bluetoothDevice.getAddress())) {
            ParcelUuid[] uuids = bluetoothDevice.getUuids();
            if (1 == this.f37111d.c()) {
                BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
                if (bluetoothClass.getMajorDeviceClass() != 1024 && (dl.a.a(bluetoothClass, 0) || dl.a.a(bluetoothClass, 1))) {
                    if (this.f37109b) {
                        il.b.j("major device class filter failed");
                    }
                    return false;
                } else if (bluetoothDevice.getBondState() == 12 && !fl.b.b(uuids, fl.b.f27082c)) {
                    if (this.f37109b) {
                        il.b.j("profile filter failed");
                    }
                    return false;
                }
            }
            if (bluetoothDevice.getBondState() != 12 || fl.b.a(uuids, this.f37111d.d())) {
                return true;
            }
            if (this.f37109b) {
                il.b.j("uuid filter failed");
            }
            return false;
        }
        if (this.f37109b) {
            il.b.j("address not match:" + bluetoothDevice.getAddress());
        }
        return false;
    }

    @Override // yk.a
    public boolean j() {
        i();
        if (this.f37114g.isDiscovering()) {
            il.b.k(this.f37109b, "cancelDiscovery");
            if (!this.f37114g.cancelDiscovery()) {
                il.b.c("cancelDiscovery failed");
                return false;
            }
        }
        a(0);
        return true;
    }

    @Override // yk.a
    public void l() {
        Context context = this.f37110c;
        if (context != null) {
            try {
                context.unregisterReceiver(this.f37128p);
            } catch (Exception e10) {
                il.b.f(this.f37109b, e10.toString());
            }
        }
        super.l();
    }

    @Override // yk.a
    public boolean n() {
        if (!h()) {
            return true;
        }
        if (this.f37114g.isDiscovering()) {
            this.f37114g.cancelDiscovery();
        }
        boolean z10 = this.f37108a;
        il.b.k(z10, "startDiscovery for " + this.f37111d.k() + "ms");
        if (!this.f37114g.startDiscovery()) {
            il.b.c("startDiscovery failed");
            o();
            return false;
        }
        g();
        return true;
    }

    @Override // yk.a
    public boolean o() {
        this.f37121n = false;
        return j();
    }
}
