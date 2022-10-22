package com.mobvoi.apollo.protocol.ble.client;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.apollo.protocol.ble.BleException;
import com.mobvoi.apollo.protocol.ble.client.a;
import com.mobvoi.apollo.protocol.ble.internal.BleGattHelperBase;
import com.realsil.sdk.dfu.DfuException;
import io.m;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BleCentralHelper.kt */
@SuppressLint({"MissingPermission"})
/* loaded from: classes2.dex */
public final class a extends BleGattHelperBase {

    /* renamed from: e  reason: collision with root package name */
    private final Context f15590e;

    /* renamed from: f  reason: collision with root package name */
    private final b f15591f;

    /* renamed from: h  reason: collision with root package name */
    private BluetoothDevice f15593h;

    /* renamed from: i  reason: collision with root package name */
    private BluetoothGatt f15594i;

    /* renamed from: g  reason: collision with root package name */
    private final c f15592g = new c(this);

    /* renamed from: j  reason: collision with root package name */
    private ClientState f15595j = ClientState.DISCONNECTED;

    /* compiled from: BleCentralHelper.kt */
    /* renamed from: com.mobvoi.apollo.protocol.ble.client.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0195a {
        private C0195a() {
        }

        public /* synthetic */ C0195a(f fVar) {
            this();
        }
    }

    /* compiled from: BleCentralHelper.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a(BluetoothDevice bluetoothDevice, ClientState clientState);

        void c();

        void d(int i10, int i11);

        void e(com.mobvoi.apollo.protocol.ble.a aVar, byte[] bArr);
    }

    /* compiled from: BleCentralHelper.kt */
    /* loaded from: classes2.dex */
    private final class c extends BluetoothGattCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f15596a;

        public c(a this$0) {
            i.f(this$0, "this$0");
            this.f15596a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(a this$0, com.mobvoi.apollo.protocol.ble.a characteristicInfo, byte[] data) {
            i.f(this$0, "this$0");
            i.f(characteristicInfo, "$characteristicInfo");
            b L = this$0.L();
            i.e(data, "data");
            L.e(characteristicInfo, data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(a this$0, com.mobvoi.apollo.protocol.ble.a characteristicInfo, byte[] data) {
            i.f(this$0, "this$0");
            i.f(characteristicInfo, "$characteristicInfo");
            b L = this$0.L();
            i.e(data, "data");
            L.e(characteristicInfo, data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(a this$0) {
            i.f(this$0, "this$0");
            this$0.L().c();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            i.f(gatt, "gatt");
            i.f(characteristic, "characteristic");
            final com.mobvoi.apollo.protocol.ble.a a10 = com.mobvoi.apollo.protocol.ble.a.f15579d.a(characteristic);
            final byte[] value = characteristic.getValue();
            com.mobvoi.apollo.protocol.ble.b bVar = com.mobvoi.apollo.protocol.ble.b.f15583a;
            if (bVar.c()) {
                k.a("BleCentralHelper", i.n("onCharacteristicChanged: ", a10));
            }
            Handler b10 = bVar.b();
            final a aVar = this.f15596a;
            b10.post(new Runnable() { // from class: com.mobvoi.apollo.protocol.ble.client.c
                @Override // java.lang.Runnable
                public final void run() {
                    a.c.d(a.this, a10, value);
                }
            });
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i10) {
            i.f(gatt, "gatt");
            i.f(characteristic, "characteristic");
            final com.mobvoi.apollo.protocol.ble.a a10 = com.mobvoi.apollo.protocol.ble.a.f15579d.a(characteristic);
            final byte[] value = characteristic.getValue();
            com.mobvoi.apollo.protocol.ble.b bVar = com.mobvoi.apollo.protocol.ble.b.f15583a;
            if (bVar.c()) {
                k.c("BleCentralHelper", "onCharacteristicRead: %s, status[%s]", a10, oa.a.f31484a.c(i10));
            }
            if (i10 == 0) {
                characteristic.getService().getInstanceId();
                Handler b10 = bVar.b();
                final a aVar = this.f15596a;
                b10.post(new Runnable() { // from class: com.mobvoi.apollo.protocol.ble.client.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c.e(a.this, a10, value);
                    }
                });
            }
            this.f15596a.y(gatt, i10, BleGattHelperBase.Operation.READ_CHARACTERISTIC, characteristic.getUuid());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int i10) {
            i.f(gatt, "gatt");
            i.f(characteristic, "characteristic");
            if (com.mobvoi.apollo.protocol.ble.b.f15583a.c()) {
                k.c("BleCentralHelper", "onCharacteristicWrite, uuid[%s] status[%s]", characteristic.getUuid(), oa.a.f31484a.c(i10));
            }
            this.f15596a.y(gatt, i10, BleGattHelperBase.Operation.WRITE_CHARACTERISTIC, characteristic.getUuid());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt gatt, int i10, int i11) {
            i.f(gatt, "gatt");
            if (com.mobvoi.apollo.protocol.ble.b.f15583a.c()) {
                oa.a aVar = oa.a.f31484a;
                k.c("BleCentralHelper", "onConnectionStateChange, status[%s] newState[%s] device[%s]", aVar.c(i10), aVar.b(i11), gatt.getDevice());
            }
            if (i10 != 0) {
                k.a("BleCentralHelper", "Close the connection device[" + gatt.getDevice() + ']');
                gatt.close();
                if (gatt == this.f15596a.f15594i) {
                    this.f15596a.f15594i = null;
                    this.f15596a.Q(ClientState.DISCONNECTED);
                }
            } else if (i11 == 0) {
                k.a("BleCentralHelper", "Close the connection device[" + gatt.getDevice() + ']');
                gatt.close();
                this.f15596a.f15594i = null;
                this.f15596a.Q(ClientState.DISCONNECTED);
            } else if (i11 == 1) {
                this.f15596a.Q(ClientState.CONNECTING);
            } else if (i11 == 2) {
                this.f15596a.f15594i = gatt;
                this.f15596a.Q(ClientState.CONNECTED);
                this.f15596a.M(DfuException.ERROR_REMOTE_CRC_ERROR);
                this.f15596a.C();
            } else if (i11 == 3) {
                this.f15596a.Q(ClientState.DISCONNECTING);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int i10) {
            i.f(gatt, "gatt");
            i.f(descriptor, "descriptor");
            if (com.mobvoi.apollo.protocol.ble.b.f15583a.c()) {
                k.c("BleCentralHelper", "onDescriptorRead, uuid[%s] status[%s]", descriptor.getUuid(), oa.a.f31484a.c(i10));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor descriptor, int i10) {
            i.f(descriptor, "descriptor");
            if (com.mobvoi.apollo.protocol.ble.b.f15583a.c()) {
                k.c("BleCentralHelper", "onDescriptorWrite, uuid[%s] status[%s]", descriptor.getUuid(), oa.a.f31484a.c(i10));
            }
            if (i10 == 0 && i.b(descriptor.getCharacteristic().getUuid(), la.a.f30445a.b())) {
                l a10 = l.a();
                final a aVar = this.f15596a;
                a10.post(new Runnable() { // from class: com.mobvoi.apollo.protocol.ble.client.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.c.f(a.this);
                    }
                });
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt gatt, int i10, int i11) {
            i.f(gatt, "gatt");
            k.c("BleCentralHelper", "onMtuChanged, mtu[%d] status[%s]", Integer.valueOf(i10), oa.a.f31484a.c(i11));
            if (i11 == 0) {
                this.f15596a.g(gatt.getDevice()).h(i10);
            }
            this.f15596a.x(gatt, i11, BleGattHelperBase.Operation.CONFIG_MTU);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt gatt, int i10) {
            BluetoothGattDescriptor descriptor;
            i.f(gatt, "gatt");
            k.c("BleCentralHelper", "onServicesDiscovered, status[%s]", oa.a.f31484a.c(i10));
            this.f15596a.x(gatt, i10, BleGattHelperBase.Operation.DISCOVERY_SERVICES);
            if (i10 == 0) {
                List<BluetoothGattService> services = gatt.getServices();
                if (services != null) {
                    Iterator<T> it = services.iterator();
                    while (it.hasNext()) {
                        k.c("BleCentralHelper", "Service found: %s", ((BluetoothGattService) it.next()).getUuid());
                    }
                }
                la.a aVar = la.a.f30445a;
                BluetoothGattService service = gatt.getService(aVar.a());
                BluetoothGattCharacteristic characteristic = service == null ? null : service.getCharacteristic(aVar.b());
                if (characteristic != null) {
                    gatt.setCharacteristicNotification(characteristic, true);
                    if ((characteristic.getProperties() & 16) == 16 && (descriptor = characteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"))) != null) {
                        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        gatt.writeDescriptor(descriptor);
                    }
                }
            }
        }
    }

    static {
        new C0195a(null);
    }

    public a(Context context, b contract) {
        i.f(context, "context");
        i.f(contract, "contract");
        this.f15590e = context;
        this.f15591f = contract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(a this$0) {
        i.f(this$0, "this$0");
        this$0.E();
    }

    private final void E() {
        k.a("BleCentralHelper", "discovery services...");
        if (this.f15595j != ClientState.CONNECTED) {
            k.q("BleCentralHelper", "not connected, failed to discovery services");
            return;
        }
        try {
            synchronized (f()) {
                BluetoothGatt J = J();
                J.discoverServices();
                k(J.getDevice(), null, BleGattHelperBase.Operation.DISCOVERY_SERVICES);
                m mVar = m.f28349a;
            }
        } catch (Exception e10) {
            k.s("BleCentralHelper", "Failed to discover services: %s", e10.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(a this$0) {
        i.f(this$0, "this$0");
        Toast.makeText(this$0.K(), "MTU 请求超时 10s", 0).show();
    }

    private final void H(UUID uuid, UUID uuid2, byte[] bArr) {
        k.a("BleCentralHelper", "sendData: " + ((Object) com.mobvoi.android.common.utils.f.b(bArr)) + ", size" + bArr.length);
        if (bArr.length == 0) {
            k.q("BleCentralHelper", "Zero length data, ignore");
        } else if (this.f15595j != ClientState.CONNECTED) {
            k.q("BleCentralHelper", "not connected, failed to send data");
        } else {
            BluetoothGatt bluetoothGatt = this.f15594i;
            if (bluetoothGatt == null) {
                k.q("BleCentralHelper", "no BluetoothGatt, failed to send data");
                return;
            }
            BluetoothGattService service = bluetoothGatt.getService(uuid);
            if (service == null) {
                k.q("BleCentralHelper", "no GATT service found, failed to send data");
                return;
            }
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
            if (characteristic == null) {
                k.q("BleCentralHelper", "no characteristic found, failed to send data");
                return;
            }
            final int b10 = oa.b.f31485a.b(bArr, 2);
            final List<byte[]> j10 = j(g(bluetoothGatt.getDevice()).d(), bArr);
            final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
            try {
                synchronized (f()) {
                    for (byte[] bArr2 : j10) {
                        if (com.mobvoi.apollo.protocol.ble.b.f15583a.a()) {
                            k.p("BleCentralHelper", "Sending data [%s]", com.mobvoi.android.common.utils.f.b(bArr2));
                        }
                        if (!characteristic.setValue(bArr2)) {
                            k.q("BleCentralHelper", "Failed to set characteristic value");
                            return;
                        } else if (!bluetoothGatt.writeCharacteristic(characteristic)) {
                            k.q("BleCentralHelper", "Failed to write characteristic");
                            return;
                        } else {
                            k(bluetoothGatt.getDevice(), uuid2, BleGattHelperBase.Operation.WRITE_CHARACTERISTIC);
                            ref$FloatRef.element += 1.0f;
                            l.a().post(new Runnable() { // from class: ja.f
                                @Override // java.lang.Runnable
                                public final void run() {
                                    a.I(Ref$FloatRef.this, j10, this, b10);
                                }
                            });
                            if (b10 == 4 || b10 == 8 || b10 == 16) {
                                try {
                                    Thread.sleep(100L);
                                } catch (Exception e10) {
                                    k.a("BleCentralHelper", String.valueOf(e10.getMessage()));
                                }
                            } else if (b10 == 1296) {
                                try {
                                    Thread.sleep(50L);
                                } catch (Exception e11) {
                                    k.a("BleCentralHelper", String.valueOf(e11.getMessage()));
                                }
                            }
                        }
                    }
                    m mVar = m.f28349a;
                }
            } catch (Exception e12) {
                k.s("BleCentralHelper", "Failed to send data: %s", e12.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Ref$FloatRef sentSize, List segments, a this$0, int i10) {
        int b10;
        i.f(sentSize, "$sentSize");
        i.f(segments, "$segments");
        i.f(this$0, "this$0");
        b10 = so.c.b((sentSize.element / segments.size()) * 100);
        this$0.L().d(i10, b10);
    }

    private final BluetoothGatt J() {
        BluetoothGatt bluetoothGatt = this.f15594i;
        if (bluetoothGatt != null) {
            c(bluetoothGatt.getDevice());
            return bluetoothGatt;
        }
        throw new BleException("Bluetooth GATT not connected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(a this$0, int i10) {
        i.f(this$0, "this$0");
        this$0.F(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(a this$0, UUID serviceUuid, UUID characteristicUUid, byte[] data) {
        i.f(this$0, "this$0");
        i.f(serviceUuid, "$serviceUuid");
        i.f(characteristicUUid, "$characteristicUUid");
        i.f(data, "$data");
        this$0.H(serviceUuid, characteristicUUid, data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(final ClientState clientState) {
        if (clientState != this.f15595j) {
            k.c("BleCentralHelper", "updateState: %s", clientState);
            this.f15595j = clientState;
            l.a().post(new Runnable() { // from class: ja.d
                @Override // java.lang.Runnable
                public final void run() {
                    a.R(a.this, clientState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(a this$0, ClientState newState) {
        i.f(this$0, "this$0");
        i.f(newState, "$newState");
        b L = this$0.L();
        BluetoothDevice bluetoothDevice = this$0.f15593h;
        i.d(bluetoothDevice);
        L.a(bluetoothDevice, newState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(BluetoothGatt bluetoothGatt, int i10, BleGattHelperBase.Operation operation) {
        y(bluetoothGatt, i10, operation, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(BluetoothGatt bluetoothGatt, int i10, BleGattHelperBase.Operation operation, UUID uuid) {
        synchronized (f()) {
            try {
                BluetoothDevice device = z(bluetoothGatt).getDevice();
                i.e(device, "localGatt.device");
                a(device, i10, operation, uuid);
            } catch (BleException e10) {
                i(bluetoothGatt.getDevice(), e10);
            }
            m mVar = m.f28349a;
        }
    }

    private final BluetoothGatt z(BluetoothGatt bluetoothGatt) throws BleException {
        BluetoothGatt bluetoothGatt2 = this.f15594i;
        if (bluetoothGatt2 == null) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            i.e(device, "gatt.device");
            throw new BleException("Received an event from device [%s] when not connected.", device);
        } else if (i.b(bluetoothGatt.getDevice(), bluetoothGatt2.getDevice())) {
            return bluetoothGatt2;
        } else {
            BluetoothDevice device2 = bluetoothGatt.getDevice();
            i.e(device2, "gatt.device");
            BluetoothDevice device3 = bluetoothGatt2.getDevice();
            i.e(device3, "curGatt.device");
            throw new BleException("Received an event from an unexpected device [%s]. Expected [%s]", device2, device3);
        }
    }

    public final void A() {
        if (this.f15594i != null) {
            k.a("BleCentralHelper", "Close the connection");
            BluetoothGatt bluetoothGatt = this.f15594i;
            if (bluetoothGatt != null) {
                bluetoothGatt.close();
            }
            this.f15594i = null;
            Q(ClientState.DISCONNECTED);
            com.mobvoi.apollo.protocol.ble.b.f15583a.b().removeCallbacksAndMessages(null);
        }
    }

    public final boolean B(BluetoothDevice device) {
        BluetoothGatt bluetoothGatt;
        i.f(device, "device");
        k.c("BleCentralHelper", "Connect to %s", device);
        BluetoothGatt bluetoothGatt2 = this.f15594i;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.close();
        }
        ClientState clientState = this.f15595j;
        if (clientState == ClientState.DISCONNECTED || clientState == ClientState.DISCONNECTING) {
            Q(ClientState.CONNECTING);
        }
        this.f15593h = device;
        if (Build.VERSION.SDK_INT >= 23) {
            bluetoothGatt = device.connectGatt(this.f15590e, false, this.f15592g, 2);
        } else {
            bluetoothGatt = device.connectGatt(this.f15590e, false, this.f15592g);
        }
        this.f15594i = bluetoothGatt;
        return bluetoothGatt != null;
    }

    public final void C() {
        com.mobvoi.apollo.protocol.ble.b.f15583a.b().post(new Runnable() { // from class: ja.b
            @Override // java.lang.Runnable
            public final void run() {
                a.D(a.this);
            }
        });
    }

    public final void F(int i10) {
        k.c("BleCentralHelper", "request mtu: %d", Integer.valueOf(i10));
        try {
            synchronized (f()) {
                BluetoothGatt J = J();
                J.requestMtu(i10);
                k(J.getDevice(), null, BleGattHelperBase.Operation.CONFIG_MTU);
                m mVar = m.f28349a;
            }
        } catch (Exception e10) {
            l.a().post(new Runnable() { // from class: ja.a
                @Override // java.lang.Runnable
                public final void run() {
                    com.mobvoi.apollo.protocol.ble.client.a.G(com.mobvoi.apollo.protocol.ble.client.a.this);
                }
            });
            k.s("BleCentralHelper", "Failed to request MTU: %s", e10.toString());
        }
    }

    public final Context K() {
        return this.f15590e;
    }

    public final b L() {
        return this.f15591f;
    }

    public final void M(final int i10) {
        com.mobvoi.apollo.protocol.ble.b.f15583a.b().post(new Runnable() { // from class: ja.c
            @Override // java.lang.Runnable
            public final void run() {
                a.N(a.this, i10);
            }
        });
    }

    public final void O(final UUID serviceUuid, final UUID characteristicUUid, final byte[] data) {
        i.f(serviceUuid, "serviceUuid");
        i.f(characteristicUUid, "characteristicUUid");
        i.f(data, "data");
        com.mobvoi.apollo.protocol.ble.b.f15583a.b().post(new Runnable() { // from class: ja.e
            @Override // java.lang.Runnable
            public final void run() {
                a.P(a.this, serviceUuid, characteristicUUid, data);
            }
        });
    }
}
