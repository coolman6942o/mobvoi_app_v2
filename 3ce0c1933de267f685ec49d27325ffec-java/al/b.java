package al;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothHealth;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import dl.d;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: m  reason: collision with root package name */
    public static b f249m;

    /* renamed from: a  reason: collision with root package name */
    public boolean f250a;

    /* renamed from: b  reason: collision with root package name */
    public Context f251b;

    /* renamed from: c  reason: collision with root package name */
    public List<al.a> f252c;

    /* renamed from: d  reason: collision with root package name */
    public BluetoothAdapter f253d;

    /* renamed from: g  reason: collision with root package name */
    public BluetoothHealth f256g;

    /* renamed from: e  reason: collision with root package name */
    public BluetoothHeadset f254e = null;

    /* renamed from: f  reason: collision with root package name */
    public BluetoothA2dp f255f = null;

    /* renamed from: h  reason: collision with root package name */
    public BluetoothProfile f257h = null;

    /* renamed from: i  reason: collision with root package name */
    public BluetoothProfile f258i = null;

    /* renamed from: j  reason: collision with root package name */
    public BluetoothProfile f259j = null;

    /* renamed from: k  reason: collision with root package name */
    public a f260k = null;

    /* renamed from: l  reason: collision with root package name */
    public BluetoothProfile.ServiceListener f261l = new C0003b();

    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.content.BroadcastReceiver
        @TargetApi(19)
        public void onReceive(Context context, Intent intent) {
            char c10;
            b bVar;
            String str;
            String action = intent.getAction();
            action.hashCode();
            switch (action.hashCode()) {
                case -1435586571:
                    if (action.equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1021360715:
                    if (action.equals("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -855499628:
                    if (action.equals("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1244161670:
                    if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1347806984:
                    if (action.equals("android.bluetooth.avrcp-controller.profile.action.CONNECTION_STATE_CHANGED")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1772843706:
                    if (action.equals("android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT")) {
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
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice != null) {
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        il.b.c(String.format(Locale.US, "%s: action=%s, state: %d->%d", fl.a.c(bluetoothDevice.getAddress(), true), action, Integer.valueOf(intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1)), Integer.valueOf(intExtra)));
                        List<al.a> list = b.this.f252c;
                        if (list != null && list.size() > 0) {
                            for (al.a aVar : b.this.f252c) {
                                aVar.c(bluetoothDevice, intExtra);
                            }
                            return;
                        }
                        bVar = b.this;
                        break;
                    } else {
                        return;
                    }
                    break;
                case 1:
                    BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice2 != null) {
                        il.b.c(String.format(Locale.US, "%s: action=%s, state: %d->%d", fl.a.c(bluetoothDevice2.getAddress(), true), action, Integer.valueOf(intExtra3), Integer.valueOf(intExtra2)));
                        List<al.a> list2 = b.this.f252c;
                        if (list2 != null && list2.size() > 0) {
                            for (al.a aVar2 : b.this.f252c) {
                                aVar2.e(bluetoothDevice2, intExtra2);
                            }
                            return;
                        }
                        bVar = b.this;
                        break;
                    } else {
                        return;
                    }
                case 2:
                    BluetoothDevice bluetoothDevice3 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra4 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra5 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice3 != null) {
                        il.b.c(String.format(Locale.US, "%s: action=%s, state: %d->%d", fl.a.c(bluetoothDevice3.getAddress(), true), action, Integer.valueOf(intExtra5), Integer.valueOf(intExtra4)));
                        List<al.a> list3 = b.this.f252c;
                        if (list3 != null && list3.size() > 0) {
                            for (al.a aVar3 : b.this.f252c) {
                                aVar3.a(bluetoothDevice3, intExtra4);
                            }
                            return;
                        }
                        bVar = b.this;
                        break;
                    } else {
                        return;
                    }
                case 3:
                    BluetoothDevice bluetoothDevice4 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra6 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra7 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice4 != null) {
                        il.b.c(String.format(Locale.US, "action=%s, device:%s, state: %d->%d", action, fl.a.c(bluetoothDevice4.getAddress(), true), Integer.valueOf(intExtra7), Integer.valueOf(intExtra6)));
                        List<al.a> list4 = b.this.f252c;
                        if (list4 != null && list4.size() > 0) {
                            for (al.a aVar4 : b.this.f252c) {
                                aVar4.d(bluetoothDevice4, intExtra6);
                            }
                            return;
                        }
                        bVar = b.this;
                        break;
                    } else {
                        return;
                    }
                case 4:
                    BluetoothDevice bluetoothDevice5 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra8 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra9 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice5 != null) {
                        il.b.c(String.format(Locale.US, "%s: action=%s, state: %d->%d", fl.a.c(bluetoothDevice5.getAddress(), true), action, Integer.valueOf(intExtra9), Integer.valueOf(intExtra8)));
                        List<al.a> list5 = b.this.f252c;
                        if (list5 != null && list5.size() > 0) {
                            for (al.a aVar5 : b.this.f252c) {
                                aVar5.b(bluetoothDevice5, intExtra8);
                            }
                            return;
                        }
                        bVar = b.this;
                        break;
                    } else {
                        return;
                    }
                case 5:
                    BluetoothDevice bluetoothDevice6 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    int intExtra10 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    int intExtra11 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                    if (bluetoothDevice6 != null) {
                        il.b.c(String.format(Locale.US, "%s: action=%s, state: %d->%d", fl.a.c(bluetoothDevice6.getAddress(), true), action, Integer.valueOf(intExtra11), Integer.valueOf(intExtra10)));
                        return;
                    }
                    return;
                case 6:
                    bVar = b.this;
                    bVar.getClass();
                    BluetoothDevice bluetoothDevice7 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice7 == null) {
                        str = "onVendorSpecificHeadsetEvent() remote device is null";
                    } else {
                        String stringExtra = intent.getStringExtra("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD");
                        if (stringExtra == null) {
                            str = "onVendorSpecificHeadsetEvent() command is null";
                        } else {
                            int intExtra12 = intent.getIntExtra("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_CMD_TYPE", -1);
                            if (intExtra12 == 0 && intExtra12 == 1 && intExtra12 == 2 && intExtra12 == 3 && intExtra12 == 4) {
                                Object[] objArr = (Object[]) intent.getExtras().get("android.bluetooth.headset.extra.VENDOR_SPECIFIC_HEADSET_EVENT_ARGS");
                                List<al.a> list6 = bVar.f252c;
                                if (list6 != null && list6.size() > 0) {
                                    for (al.a aVar6 : bVar.f252c) {
                                        aVar6.f(bluetoothDevice7, stringExtra, intExtra12, objArr);
                                    }
                                    return;
                                }
                            } else {
                                str = "onVendorSpecificHeadsetEvent() unknown command";
                            }
                        }
                    }
                    il.b.j(str);
                    return;
                default:
                    return;
            }
            il.b.k(bVar.f250a, "no callback registed");
        }
    }

    /* renamed from: al.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0003b implements BluetoothProfile.ServiceListener {
        public C0003b() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i10, BluetoothProfile bluetoothProfile) {
            String e10 = fl.a.e(i10);
            il.b.c(e10 + " profile connected");
            if (i10 == 11) {
                b.this.f258i = bluetoothProfile;
            } else if (i10 == 12) {
                b.this.f259j = bluetoothProfile;
            } else if (i10 == 1) {
                b.this.f254e = (BluetoothHeadset) bluetoothProfile;
            } else if (i10 == 2) {
                b.this.f255f = (BluetoothA2dp) bluetoothProfile;
            } else if (i10 == 3) {
                b.this.f256g = (BluetoothHealth) bluetoothProfile;
            } else if (i10 == 4) {
                b.this.f257h = bluetoothProfile;
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i10) {
            String e10 = fl.a.e(i10);
            il.b.c(e10 + " profile disconnected");
            if (i10 == 1) {
                b.this.f254e = null;
            } else if (i10 == 2) {
                b.this.f255f = null;
            } else if (i10 == 3) {
                b.this.f256g = null;
            } else if (i10 == 4) {
                b.this.f257h = null;
            } else if (i10 == 11) {
                b.this.f258i = null;
            } else if (i10 == 12) {
                b.this.f259j = null;
            }
        }
    }

    public b(Context context) {
        this.f250a = false;
        this.f251b = context.getApplicationContext();
        this.f250a = wk.b.f36300c;
        a();
    }

    public static b g() {
        return f249m;
    }

    public static void i(Context context) {
        if (f249m == null) {
            synchronized (b.class) {
                if (f249m == null) {
                    f249m = new b(context);
                }
            }
        }
    }

    public final boolean a() {
        BluetoothAdapter bluetoothAdapter;
        String str;
        Context context = this.f251b;
        if (context == null) {
            str = "not intialized";
        } else {
            if (this.f253d == null) {
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
                this.f253d = bluetoothAdapter;
                if (this.f253d == null) {
                    str = "Unable to obtain a BluetoothAdapter.";
                }
            }
            k();
            return true;
        }
        il.b.l(str);
        return false;
    }

    public void b(al.a aVar) {
        if (aVar != null) {
            if (this.f252c == null) {
                this.f252c = new CopyOnWriteArrayList();
            }
            if (!this.f252c.contains(aVar)) {
                this.f252c.add(aVar);
            }
            boolean z10 = this.f250a;
            il.b.d(z10, "mManagerCallbacks.size=" + this.f252c.size());
        }
    }

    public boolean c(BluetoothDevice bluetoothDevice) {
        BluetoothProfile bluetoothProfile;
        String str;
        if (Build.VERSION.SDK_INT >= 28) {
            bluetoothProfile = this.f257h;
            str = "android.bluetooth.BluetoothHidHost";
        } else {
            bluetoothProfile = this.f257h;
            str = "android.bluetooth.BluetoothInputDevice";
        }
        return d.a(bluetoothProfile, str, bluetoothDevice);
    }

    public boolean d(BluetoothDevice bluetoothDevice) {
        String str;
        if (bluetoothDevice == null) {
            str = "device is null";
        } else {
            BluetoothA2dp bluetoothA2dp = this.f255f;
            if (bluetoothA2dp == null) {
                str = "A2DP not initialized";
            } else if (bluetoothA2dp.getConnectionState(bluetoothDevice) != 2) {
                str = "A2DP already disconnected";
            } else {
                d.d(this.f255f, bluetoothDevice, 100);
                return d.b(this.f255f, bluetoothDevice);
            }
        }
        il.b.l(str);
        return false;
    }

    public boolean e(String str) {
        String str2;
        BluetoothDevice remoteDevice = this.f253d.getRemoteDevice(str);
        if (remoteDevice == null) {
            return false;
        }
        BluetoothHeadset bluetoothHeadset = this.f254e;
        if (bluetoothHeadset == null) {
            str2 = "BluetoothHeadset service is not connected";
        } else if (bluetoothHeadset.getConnectionState(remoteDevice) == 2) {
            return d.b(this.f254e, remoteDevice);
        } else {
            str2 = "BluetoothHeadset profile is not connected";
        }
        il.b.l(str2);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f(int i10, BluetoothDevice bluetoothDevice) {
        BluetoothProfile bluetoothProfile;
        BluetoothProfile bluetoothProfile2;
        BluetoothProfile bluetoothProfile3;
        BluetoothAdapter bluetoothAdapter = this.f253d;
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            il.b.c("BT not enabled");
            return -1;
        }
        if (i10 == 1) {
            BluetoothHeadset bluetoothHeadset = this.f254e;
            if (bluetoothHeadset != null) {
                return bluetoothHeadset.getConnectionState(bluetoothDevice);
            }
            il.b.c("HEADSET profile not connected");
        } else if (i10 != 2) {
            if (i10 != 4) {
                if (i10 != 11) {
                    if (i10 != 12) {
                        return 0;
                    }
                    bluetoothProfile = this.f259j;
                    if (bluetoothProfile == null) {
                        return bluetoothProfile.getConnectionState(bluetoothDevice);
                    }
                    il.b.c("AVRCP profile not connected");
                    return 0;
                }
                bluetoothProfile2 = this.f258i;
                if (bluetoothProfile2 == null) {
                    return d.c(bluetoothProfile2, "android.bluetooth.BluetoothA2dpSink", bluetoothDevice);
                }
                il.b.c("A2DP_SINK profile not connected");
                bluetoothProfile = this.f259j;
                if (bluetoothProfile == null) {
                }
            }
            bluetoothProfile3 = this.f257h;
            if (bluetoothProfile3 == null) {
                return Build.VERSION.SDK_INT >= 28 ? d.c(bluetoothProfile3, "android.bluetooth.BluetoothHidHost", bluetoothDevice) : d.c(bluetoothProfile3, "android.bluetooth.BluetoothInputDevice", bluetoothDevice);
            }
            il.b.c("HID_HOST profile not connected");
            bluetoothProfile2 = this.f258i;
            if (bluetoothProfile2 == null) {
            }
        }
        BluetoothA2dp bluetoothA2dp = this.f255f;
        if (bluetoothA2dp != null) {
            return bluetoothA2dp.getConnectionState(bluetoothDevice);
        }
        il.b.c("A2DP profile not connected");
        bluetoothProfile3 = this.f257h;
        if (bluetoothProfile3 == null) {
        }
    }

    public boolean h(int i10) {
        try {
            if (this.f253d.getProfileProxy(this.f251b, this.f261l, i10)) {
                if (this.f250a) {
                    il.b.j(String.format(Locale.US, "getProfileProxy %d success", Integer.valueOf(i10)));
                }
                return true;
            }
            il.b.l(String.format(Locale.US, "getProfileProxy %d failed", Integer.valueOf(i10)));
            return false;
        } catch (Exception e10) {
            il.b.l(String.format(Locale.US, "getProfileProxy %d exception: %s", Integer.valueOf(i10), e10.toString()));
            return false;
        }
    }

    public boolean j(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 11 ? i10 == 12 && this.f259j != null : this.f258i != null : this.f257h != null : this.f255f != null : this.f254e != null;
    }

    public void k() {
        if (this.f253d == null) {
            il.b.l("mBluetoothAdapter == null");
            return;
        }
        this.f260k = new a();
        IntentFilter intentFilter = new IntentFilter();
        h(2);
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.PLAYING_STATE_CHANGED");
        h(1);
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.action.VENDOR_SPECIFIC_HEADSET_EVENT");
        h(4);
        intentFilter.addAction("android.bluetooth.input.profile.action.CONNECTION_STATE_CHANGED");
        h(11);
        intentFilter.addAction("android.bluetooth.a2dp-sink.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp-sink.profile.action.PLAYING_STATE_CHANGED");
        h(12);
        intentFilter.addAction("android.bluetooth.avrcp-controller.profile.action.CONNECTION_STATE_CHANGED");
        this.f251b.registerReceiver(this.f260k, intentFilter);
    }

    public void l(al.a aVar) {
        List<al.a> list = this.f252c;
        if (list != null) {
            list.remove(aVar);
        }
    }
}
