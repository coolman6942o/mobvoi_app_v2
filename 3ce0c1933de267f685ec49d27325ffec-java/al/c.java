package al;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import il.b;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
@TargetApi(18)
/* loaded from: classes2.dex */
public class c {

    /* renamed from: l  reason: collision with root package name */
    public static boolean f264l = false;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f265m = true;

    /* renamed from: n  reason: collision with root package name */
    public static c f266n;

    /* renamed from: a  reason: collision with root package name */
    public boolean f267a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f268b;

    /* renamed from: c  reason: collision with root package name */
    public BluetoothManager f269c;

    /* renamed from: d  reason: collision with root package name */
    public BluetoothAdapter f270d;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f275i;

    /* renamed from: k  reason: collision with root package name */
    public Context f277k;

    /* renamed from: j  reason: collision with root package name */
    public final Object f276j = new Object();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, BluetoothGatt> f272f = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f274h = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, List<BluetoothGattCallback>> f273g = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public List<String> f271e = new CopyOnWriteArrayList();

    /* loaded from: classes2.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (c.this.f267a) {
                b.c(value != null ? String.format(Locale.US, "<< onCharacteristicChanged: %s\n(%d)%s", bluetoothGattCharacteristic.getUuid(), Integer.valueOf(value.length), jl.a.a(value)) : String.format(Locale.US, "<< onCharacteristicChanged: %s", bluetoothGattCharacteristic.getUuid()));
            }
            List<BluetoothGattCallback> list = c.this.f273g.get(address);
            if (list != null && list.size() > 0) {
                for (BluetoothGattCallback bluetoothGattCallback : list) {
                    bluetoothGattCallback.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            b.c(c.this.f267a ? value != null ? String.format(Locale.US, "<< onCharacteristicRead(%s): %s \n\t(%d)%s", bluetoothGattCharacteristic.getUuid(), bl.b.a(i10), Integer.valueOf(value.length), jl.a.a(value)) : String.format(Locale.US, "<< onCharacteristicRead(%s): %s", bluetoothGattCharacteristic.getUuid(), bl.b.a(i10)) : value != null ? String.format(Locale.US, "<< onCharacteristicRead: %s (%d)", bl.b.a(i10), Integer.valueOf(value.length)) : String.format(Locale.US, "<< onCharacteristicRead: %s", bl.b.a(i10)));
            synchronized (c.this.f276j) {
                c.this.f275i = true;
                c.this.f276j.notifyAll();
            }
            List<BluetoothGattCallback> list = c.this.f273g.get(bluetoothGatt.getDevice().getAddress());
            if (list != null && list.size() > 0) {
                for (BluetoothGattCallback bluetoothGattCallback : list) {
                    bluetoothGattCallback.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i10);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            String address = bluetoothGatt.getDevice().getAddress();
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (c.this.f267a) {
                b.c(value != null ? String.format(Locale.US, "onCharacteristicWrite: %s << %s\n(%d)%s", bl.b.a(i10), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(value.length), jl.a.a(value)) : String.format(Locale.US, "onCharacteristicWrite: %s << %s", bl.b.a(i10), bluetoothGattCharacteristic.getUuid()));
            }
            synchronized (c.this.f276j) {
                c.this.f275i = true;
                c.this.f276j.notifyAll();
            }
            List<BluetoothGattCallback> list = c.this.f273g.get(address);
            if (list != null && list.size() > 0) {
                for (BluetoothGattCallback bluetoothGattCallback : list) {
                    bluetoothGattCallback.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i10);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            if (device != null) {
                String address = device.getAddress();
                b.j(String.format(Locale.US, "onConnectionStateChange: %s, status: %s , newState: %s", fl.a.c(address, true), bl.b.b(i10), fl.a.f(i11)));
                if (i10 == 0 && i11 == 2) {
                    c.this.f274h.put(address, 2);
                    c.this.f272f.put(address, bluetoothGatt);
                } else {
                    c.this.f274h.put(address, 0);
                }
                List<BluetoothGattCallback> list = c.this.f273g.get(address);
                if (list != null && list.size() > 0) {
                    for (BluetoothGattCallback bluetoothGattCallback : list) {
                        bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, i10, i11);
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            String address = bluetoothGatt.getDevice().getAddress();
            UUID uuid = bluetoothGattDescriptor.getCharacteristic().getUuid();
            byte[] value = bluetoothGattDescriptor.getValue();
            if (c.this.f267a) {
                b.c(value != null ? String.format(Locale.US, "onDescriptorWrite: %s>> {\nCharacteristic:%s\nDescriptor:%s\nvalue:(%d)%s\n}", bl.b.a(i10), uuid, bluetoothGattDescriptor.getUuid(), Integer.valueOf(value.length), jl.a.a(value)) : String.format(Locale.US, "onDescriptorWrite: %s>> {\nCharacteristic:%s\nDescriptor:%s}", bl.b.a(i10), uuid, bluetoothGattDescriptor.getUuid()));
            }
            synchronized (c.this.f276j) {
                c.this.f275i = true;
                c.this.f276j.notifyAll();
            }
            List<BluetoothGattCallback> list = c.this.f273g.get(address);
            if (list != null && list.size() > 0) {
                for (BluetoothGattCallback bluetoothGattCallback : list) {
                    bluetoothGattCallback.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i10);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @TargetApi(21)
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            String address = bluetoothGatt.getDevice().getAddress();
            b.c(String.format(Locale.US, "onMtuChanged: %s << mtu=%d, addr=%s", bl.b.a(i11), Integer.valueOf(i10), fl.a.c(address, true)));
            List<BluetoothGattCallback> list = c.this.f273g.get(address);
            if (list != null && list.size() > 0) {
                for (BluetoothGattCallback bluetoothGattCallback : list) {
                    bluetoothGattCallback.onMtuChanged(bluetoothGatt, i10, i11);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyRead(BluetoothGatt bluetoothGatt, int i10, int i11, int i12) {
            super.onPhyRead(bluetoothGatt, i10, i11, i12);
            String address = bluetoothGatt.getDevice().getAddress();
            b.c(String.format(Locale.US, "onPhyRead: %s << %s: txPhy=%d, rxPhy=%d", fl.a.c(address, true), bl.b.a(i12), Integer.valueOf(i10), Integer.valueOf(i11)));
            List<BluetoothGattCallback> list = c.this.f273g.get(address);
            if (list != null && list.size() > 0) {
                for (BluetoothGattCallback bluetoothGattCallback : list) {
                    bluetoothGattCallback.onPhyRead(bluetoothGatt, i10, i11, i12);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i10, int i11, int i12) {
            super.onPhyUpdate(bluetoothGatt, i10, i11, i12);
            String address = bluetoothGatt.getDevice().getAddress();
            b.c(String.format(Locale.US, "onPhyUpdate: %s << %s: txPhy=%d, rxPhy=%d", fl.a.c(address, true), bl.b.a(i12), Integer.valueOf(i10), Integer.valueOf(i11)));
            List<BluetoothGattCallback> list = c.this.f273g.get(address);
            if (list != null && list.size() > 0) {
                for (BluetoothGattCallback bluetoothGattCallback : list) {
                    bluetoothGattCallback.onPhyUpdate(bluetoothGatt, i10, i11, i12);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i10, int i11) {
            super.onReadRemoteRssi(bluetoothGatt, i10, i11);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i10) {
            super.onReliableWriteCompleted(bluetoothGatt, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            String address = bluetoothGatt.getDevice().getAddress();
            b.c(String.format(Locale.US, "onServicesDiscovered: %s << addr=%s", bl.b.a(i10), fl.a.c(address, true)));
            if (c.f264l) {
                for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
                    b.c(String.format(Locale.US, "service: type=%d, %d/%s", Integer.valueOf(bluetoothGattService.getType()), Integer.valueOf(bluetoothGattService.getInstanceId()), bluetoothGattService.getUuid().toString()));
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        b.j(String.format(Locale.US, "\tcharacteristic: %d/%s", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
                    }
                }
            }
            List<BluetoothGattCallback> list = c.this.f273g.get(address);
            if (list != null && list.size() > 0) {
                for (BluetoothGattCallback bluetoothGattCallback : list) {
                    bluetoothGattCallback.onServicesDiscovered(bluetoothGatt, i10);
                }
            }
        }
    }

    static {
        UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    }

    public c(Context context) {
        this.f267a = false;
        this.f268b = false;
        this.f277k = context;
        this.f267a = wk.b.f36299b;
        this.f268b = wk.b.f36300c;
        a();
    }

    public static c k() {
        return f266n;
    }

    public static synchronized void l(Context context) {
        synchronized (c.class) {
            if (f266n == null) {
                synchronized (c.class) {
                    if (f266n == null) {
                        f266n = new c(context.getApplicationContext());
                    }
                }
            }
        }
    }

    public final boolean a() {
        String str;
        if (this.f269c == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.f277k.getSystemService("bluetooth");
            this.f269c = bluetoothManager;
            if (bluetoothManager == null) {
                str = "BLUETOOTH_SERVICE not supported.";
                b.l(str);
                return false;
            }
        }
        if (this.f270d == null) {
            BluetoothAdapter adapter = this.f269c.getAdapter();
            this.f270d = adapter;
            if (adapter == null) {
                str = "BluetoothAdapter is not supported";
                b.l(str);
                return false;
            }
        }
        b.c("initialize success");
        return true;
    }

    public void c(String str) {
        if (str != null) {
            BluetoothGatt bluetoothGatt = this.f272f.get(str);
            if (bluetoothGatt != null) {
                if (n(str)) {
                    if (this.f267a) {
                        b.j("disconnect : " + str);
                    }
                    bluetoothGatt.disconnect();
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                }
                if (f265m) {
                    if (this.f268b) {
                        b.j("closeGatt, addr:=" + str);
                    }
                    bluetoothGatt.close();
                }
                this.f272f.remove(str);
            }
            HashMap<String, List<BluetoothGattCallback>> hashMap = this.f273g;
            if (hashMap != null) {
                hashMap.remove(str);
            }
            List<String> list = this.f271e;
            if (list != null && list.contains(str)) {
                this.f271e.remove(str);
            }
        }
    }

    public synchronized void d(String str) {
        e(str, f265m);
    }

    public synchronized void e(String str, boolean z10) {
        BluetoothGatt bluetoothGatt;
        if (str == null) {
            b.d(this.f267a, "Invalid address");
            return;
        }
        HashMap<String, BluetoothGatt> hashMap = this.f272f;
        if (hashMap != null) {
            if (z10 && (bluetoothGatt = hashMap.get(str)) != null) {
                if (this.f268b) {
                    b.j("closeGatt, addr:=" + str);
                }
                bluetoothGatt.close();
            }
            this.f272f.remove(str);
        }
        HashMap<String, List<BluetoothGattCallback>> hashMap2 = this.f273g;
        if (hashMap2 != null) {
            hashMap2.remove(str);
        }
        List<String> list = this.f271e;
        if (list != null) {
            list.remove(str);
        }
    }

    public boolean f(String str, int i10, BluetoothGattCallback bluetoothGattCallback) {
        return Build.VERSION.SDK_INT >= 26 ? h(str, false, i10, 1, bluetoothGattCallback) : h(str, false, i10, 1, bluetoothGattCallback);
    }

    public boolean g(String str, BluetoothGattCallback bluetoothGattCallback) {
        int i10 = Build.VERSION.SDK_INT;
        return f(str, 2, bluetoothGattCallback);
    }

    public boolean h(String str, boolean z10, int i10, int i11, BluetoothGattCallback bluetoothGattCallback) {
        BluetoothGatt bluetoothGatt;
        BluetoothAdapter bluetoothAdapter = this.f270d;
        if (bluetoothAdapter == null) {
            b.l("BluetoothAdapter not initialized");
            return false;
        } else if (str == null) {
            b.l("unspecified address.");
            return false;
        } else {
            BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
            if (remoteDevice == null) {
                b.l("Device not found.  Unable to connect.");
                return false;
            }
            if (this.f271e.contains(str) && (bluetoothGatt = this.f272f.get(str)) != null) {
                if (n(str)) {
                    if (this.f267a) {
                        b.j("already connected, addr=" + fl.a.c(str, true));
                    }
                    o(str, bluetoothGattCallback);
                    if (bluetoothGattCallback != null) {
                        bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, 0, 2);
                    }
                    return true;
                } else if (z10) {
                    o(str, bluetoothGattCallback);
                    if (this.f267a) {
                        b.j("re-connect previous device: " + str);
                    }
                    if (bluetoothGatt.connect()) {
                        this.f274h.put(str, 1);
                        return true;
                    }
                    b.c("reconnect failed.");
                    d(str);
                    return false;
                } else {
                    d(str);
                }
            }
            if (this.f267a) {
                b.j("create connection to " + fl.a.c(str, true));
            }
            o(str, bluetoothGattCallback);
            this.f274h.put(str, 1);
            int i12 = Build.VERSION.SDK_INT;
            BluetoothGatt connectGatt = i12 >= 26 ? remoteDevice.connectGatt(this.f277k, z10, new a(), i10, i11) : i12 >= 23 ? remoteDevice.connectGatt(this.f277k, z10, new a(), i10) : remoteDevice.connectGatt(this.f277k, z10, new a());
            if (connectGatt == null) {
                b.c("BluetoothGatt not exist.  Unable to connect.");
                this.f274h.put(str, 0);
                d(str);
                return false;
            }
            this.f272f.put(str, connectGatt);
            if (!this.f271e.contains(str)) {
                this.f271e.add(str);
            }
            return true;
        }
    }

    public BluetoothGatt i(String str) {
        return this.f272f.get(str);
    }

    public List<BluetoothGattCallback> j(String str) {
        HashMap<String, List<BluetoothGattCallback>> hashMap = this.f273g;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public boolean m(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> j10 = j(str);
        return j10 != null && j10.contains(bluetoothGattCallback);
    }

    public boolean n(String str) {
        Integer num = this.f274h.get(str);
        return num != null && num.intValue() == 2;
    }

    public synchronized void o(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> j10 = j(str);
        if (j10 == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(bluetoothGattCallback);
            this.f273g.put(str, copyOnWriteArrayList);
            return;
        }
        if (!j10.contains(bluetoothGattCallback)) {
            j10.add(bluetoothGattCallback);
            this.f273g.put(str, j10);
        }
    }

    public synchronized void p(String str, BluetoothGattCallback bluetoothGattCallback) {
        List<BluetoothGattCallback> j10 = j(str);
        if (j10 == null) {
            if (this.f267a) {
                b.j("callback not registered, addr= " + fl.a.c(str, true));
            }
            return;
        }
        if (j10.contains(bluetoothGattCallback)) {
            j10.remove(bluetoothGattCallback);
            this.f273g.put(str, j10);
        }
    }
}
