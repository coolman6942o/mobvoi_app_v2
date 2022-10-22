package al;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: h  reason: collision with root package name */
    public static d f279h;

    /* renamed from: a  reason: collision with root package name */
    public boolean f280a;

    /* renamed from: b  reason: collision with root package name */
    public Context f281b;

    /* renamed from: c  reason: collision with root package name */
    public List<e> f282c;

    /* renamed from: d  reason: collision with root package name */
    public BluetoothAdapter f283d;

    /* renamed from: e  reason: collision with root package name */
    public a f284e = null;

    /* renamed from: f  reason: collision with root package name */
    public Object f285f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public Object f286g = new Object();

    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.content.BroadcastReceiver
        @TargetApi(19)
        public void onReceive(Context context, Intent intent) {
            char c10;
            String str;
            String str2;
            String action = intent.getAction();
            action.hashCode();
            switch (action.hashCode()) {
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -301431627:
                    if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -223687943:
                    if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1546533238:
                    if (action.equals("android.bluetooth.adapter.action.BLE_ACL_CONNECTED")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1652078734:
                    if (action.equals("android.bluetooth.adapter.action.BLE_ACL_DISCONNECTED")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1821585647:
                    if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2116862345:
                    if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    d dVar = d.this;
                    dVar.getClass();
                    String action2 = intent.getAction();
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    il.b.c(String.format(Locale.US, "action=%s, state: %d->%d", action2, Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1)), Integer.valueOf(intExtra)));
                    boolean z10 = dVar.f280a;
                    switch (intExtra) {
                        case 10:
                            if (z10) {
                                il.b.j("ACTION_STATE_CHANGED: STATE_OFF");
                            }
                            synchronized (dVar.f286g) {
                                dVar.f286g.notifyAll();
                            }
                            break;
                        case 11:
                            if (z10) {
                                str = "ACTION_STATE_CHANGED: STATE_TURNING_ON";
                                il.b.j(str);
                                break;
                            }
                            break;
                        case 12:
                            if (z10) {
                                il.b.j("ACTION_STATE_CHANGED: STATE_ON");
                            }
                            synchronized (dVar.f285f) {
                                dVar.f285f.notifyAll();
                            }
                            break;
                        case 13:
                            if (z10) {
                                str = "ACTION_STATE_CHANGED: STATE_TURNING_OFF";
                                il.b.j(str);
                                break;
                            }
                            break;
                        default:
                            if (z10) {
                                str = "ACTION_STATE_CHANGED: " + intExtra;
                                il.b.j(str);
                                break;
                            }
                            break;
                    }
                    List<e> list = dVar.f282c;
                    if (list != null) {
                        for (e eVar : list) {
                            eVar.c(null, intExtra);
                        }
                        return;
                    }
                    return;
                case 1:
                    d dVar2 = d.this;
                    dVar2.getClass();
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice != null) {
                        if (dVar2.f280a) {
                            il.b.c(String.format(Locale.US, "%s: action=%s", fl.a.c(bluetoothDevice.getAddress(), true), intent.getAction()));
                        }
                        List<e> list2 = dVar2.f282c;
                        if (list2 != null) {
                            for (e eVar2 : list2) {
                                eVar2.a(bluetoothDevice, true);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    d dVar3 = d.this;
                    dVar3.getClass();
                    BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice2 != null) {
                        int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", 0);
                        if (dVar3.f280a) {
                            il.b.c(String.format(Locale.US, "%s: action=%s", fl.a.c(bluetoothDevice2.getAddress(), true), intent.getAction()));
                            il.b.j("android.bluetooth.device.extra.PAIRING_VARIANT>> " + dl.b.b(intExtra2) + " (" + intExtra2 + ")");
                        }
                        List<e> list3 = dVar3.f282c;
                        if (list3 != null) {
                            for (e eVar3 : list3) {
                                eVar3.e(bluetoothDevice2, intExtra2);
                            }
                        }
                        if (bluetoothDevice2.getBondState() == 12) {
                            str2 = "device already bonded: " + bluetoothDevice2.getAddress();
                            break;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 3:
                    d dVar4 = d.this;
                    dVar4.getClass();
                    BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (dVar4.f280a) {
                        il.b.c(String.format(Locale.US, "%s: action=%s", fl.a.c(bluetoothDevice3.getAddress(), true), intent.getAction()));
                    }
                    List<e> list4 = dVar4.f282c;
                    if (list4 != null) {
                        for (e eVar4 : list4) {
                            eVar4.b(bluetoothDevice3, true);
                        }
                        return;
                    }
                    return;
                case 4:
                    d dVar5 = d.this;
                    dVar5.getClass();
                    BluetoothDevice bluetoothDevice4 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice4 != null) {
                        if (dVar5.f280a) {
                            il.b.c(String.format(Locale.US, "%s: action=%s", fl.a.c(bluetoothDevice4.getAddress(), true), intent.getAction()));
                        }
                        List<e> list5 = dVar5.f282c;
                        if (list5 != null) {
                            for (e eVar5 : list5) {
                                eVar5.b(bluetoothDevice4, false);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    d dVar6 = d.this;
                    dVar6.getClass();
                    BluetoothDevice bluetoothDevice5 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice5 != null) {
                        if (dVar6.f280a) {
                            il.b.c(String.format(Locale.US, "%s: action=%s", fl.a.c(bluetoothDevice5.getAddress(), true), intent.getAction()));
                        }
                        List<e> list6 = dVar6.f282c;
                        if (list6 != null) {
                            for (e eVar6 : list6) {
                                eVar6.a(bluetoothDevice5, false);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                case 6:
                    d dVar7 = d.this;
                    dVar7.getClass();
                    BluetoothDevice bluetoothDevice6 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra3 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
                    int intExtra4 = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
                    int intExtra5 = intent.getIntExtra("android.bluetooth.device.extra.REASON", -1);
                    if (bluetoothDevice6 != null) {
                        il.b.c(String.format(Locale.US, "%s: action=%s, bondState:%d->%d, reason=%d", fl.a.c(bluetoothDevice6.getAddress(), true), intent.getAction(), Integer.valueOf(intExtra3), Integer.valueOf(intExtra4), Integer.valueOf(intExtra5)));
                        List<e> list7 = dVar7.f282c;
                        if (list7 != null) {
                            for (e eVar7 : list7) {
                                eVar7.d(bluetoothDevice6, intExtra4);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    str2 = "action:" + action;
                    break;
            }
            il.b.c(str2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            il.b.c("scan delay time reached");
            d.this.c();
        }
    }

    public d(Context context) {
        this.f280a = false;
        new b();
        this.f281b = context.getApplicationContext();
        this.f280a = wk.b.f36299b;
        a();
    }

    public static d d() {
        return f279h;
    }

    public static void e(Context context) {
        if (f279h == null) {
            synchronized (d.class) {
                if (f279h == null) {
                    f279h = new d(context);
                }
            }
        }
    }

    public final boolean a() {
        BluetoothAdapter bluetoothAdapter;
        String str;
        Context context = this.f281b;
        if (context == null) {
            str = "not intialized";
        } else {
            if (this.f283d == null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
                    if (bluetoothManager == null) {
                        str = "Unable to initialize BluetoothManager.";
                    } else {
                        bluetoothAdapter = bluetoothManager.getAdapter();
                    }
                } else {
                    bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                }
                this.f283d = bluetoothAdapter;
                if (this.f283d == null) {
                    str = "Unable to obtain a BluetoothAdapter.";
                }
            }
            if (this.f283d == null) {
                il.b.l("mBluetoothAdapter == null");
                return true;
            }
            this.f284e = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.BLE_ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.adapter.action.BLE_ACL_DISCONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
            this.f281b.registerReceiver(this.f284e, intentFilter);
            return true;
        }
        il.b.l(str);
        return false;
    }

    public void b(e eVar) {
        if (this.f282c == null) {
            this.f282c = new CopyOnWriteArrayList();
        }
        if (!this.f282c.contains(eVar)) {
            this.f282c.add(eVar);
        }
    }

    public final boolean c() {
        BluetoothAdapter bluetoothAdapter = this.f283d;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            il.b.l("bluetooth is not supported or disabled");
        }
        if (!this.f283d.isDiscovering()) {
            return true;
        }
        if (this.f280a) {
            il.b.c("stopInquiry()");
        }
        return this.f283d.cancelDiscovery();
    }
}
