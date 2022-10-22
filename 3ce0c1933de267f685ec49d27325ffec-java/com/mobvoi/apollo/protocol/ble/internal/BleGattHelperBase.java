package com.mobvoi.apollo.protocol.ble.internal;

import android.bluetooth.BluetoothDevice;
import android.os.SystemClock;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.protocol.ble.BleException;
import io.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BleGattHelperBase.kt */
/* loaded from: classes2.dex */
public class BleGattHelperBase {

    /* renamed from: a  reason: collision with root package name */
    private long f15604a = 10000;

    /* renamed from: b  reason: collision with root package name */
    private final b f15605b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<BluetoothDevice, b> f15606c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private Object f15607d = new Object();

    /* compiled from: BleGattHelperBase.kt */
    /* loaded from: classes2.dex */
    public enum Operation {
        NO_OP,
        ADD_SERVICE,
        CONNECT,
        DISCONNECT,
        DISCOVERY_SERVICES,
        CONFIG_MTU,
        READ_CHARACTERISTIC,
        WRITE_CHARACTERISTIC,
        READ_DESCRIPTOR,
        WRITE_DESCRIPTOR
    }

    /* compiled from: BleGattHelperBase.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: BleGattHelperBase.kt */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f15608a = 20;

        /* renamed from: b  reason: collision with root package name */
        private Operation f15609b = Operation.NO_OP;

        /* renamed from: c  reason: collision with root package name */
        private UUID f15610c;

        /* renamed from: d  reason: collision with root package name */
        private Exception f15611d;

        public final Exception a() {
            return this.f15611d;
        }

        public final Operation b() {
            return this.f15609b;
        }

        public final UUID c() {
            return this.f15610c;
        }

        public final int d() {
            return this.f15608a;
        }

        public final void e() {
            this.f15609b = Operation.NO_OP;
            this.f15610c = null;
            this.f15611d = null;
        }

        public final void f(Exception exc) {
            this.f15611d = exc;
        }

        public final void g(Operation operation) {
            i.f(operation, "<set-?>");
            this.f15609b = operation;
        }

        public final void h(int i10) {
            this.f15608a = i10 - 3;
        }

        public final void i(Operation op2, UUID uuid) {
            i.f(op2, "op");
            this.f15609b = op2;
            this.f15610c = uuid;
            this.f15611d = null;
        }
    }

    static {
        new a(null);
    }

    private final void b(BluetoothDevice bluetoothDevice, UUID uuid) {
        b g10 = g(bluetoothDevice);
        if (g10.c() == null) {
            k.s("BleGattHelperBase", "Unexpected event from characteristic [%s] on device [%s] while doing operation [%s]", uuid, bluetoothDevice, g10.b());
        }
        if (!i.b(uuid, g10.c())) {
            k.s("BleGattHelperBase", "Unexpected characteristic [%s] ([%s] expected) on device [%s] while doing operation [%s]", uuid, g10.c(), bluetoothDevice, g10.b());
        }
    }

    private final void d(BluetoothDevice bluetoothDevice, int i10, Operation operation) throws BleException {
        if (i10 == 0) {
            return;
        }
        if (i10 == 15) {
            throw new BleException("Not paired yet");
        } else if (bluetoothDevice != null) {
            throw new BleException("Operation [%s] on device [%s] failed: %s", operation, bluetoothDevice, oa.a.f31484a.c(i10));
        } else {
            throw new BleException("Operation [%s] failed: %s", operation, oa.a.f31484a.c(i10));
        }
    }

    private final void e(BluetoothDevice bluetoothDevice, Operation operation) {
        b g10 = g(bluetoothDevice);
        if (g10.b() != operation) {
            k.s("BleGattHelperBase", "Unexpected result for operation [%s] while doing operation [%s] on device [%s]", operation, g10.b(), bluetoothDevice);
        }
    }

    private final void h(BluetoothDevice bluetoothDevice) {
        b g10 = g(bluetoothDevice);
        if (com.mobvoi.apollo.protocol.ble.b.f15583a.c()) {
            k.c("BleGattHelperBase", "notifyCompletion: %s", g10.b());
        }
        this.f15607d.notify();
        g10.g(Operation.NO_OP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(BluetoothDevice device, int i10, Operation op2, UUID uuid) {
        i.f(device, "device");
        i.f(op2, "op");
        synchronized (this.f15607d) {
            try {
                d(device, i10, op2);
                if (uuid != null) {
                    b(device, uuid);
                }
                e(device, op2);
                h(device);
            } catch (BleException e10) {
                i(device, e10);
            }
            m mVar = m.f28349a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(BluetoothDevice bluetoothDevice) {
        b g10 = g(bluetoothDevice);
        Exception a10 = g10.a();
        g10.f(null);
        if (a10 != null) {
            throw a10;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object f() {
        return this.f15607d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b g(BluetoothDevice bluetoothDevice) {
        synchronized (this.f15606c) {
            if (bluetoothDevice == null) {
                return this.f15605b;
            }
            b bVar = this.f15606c.get(bluetoothDevice);
            if (bVar == null) {
                bVar = new b();
                this.f15606c.put(bluetoothDevice, bVar);
            }
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i(BluetoothDevice bluetoothDevice, BleException e10) {
        i.f(e10, "e");
        k.s("BleGattHelperBase", "notifyException: %s", e10.toString());
        g(bluetoothDevice).f(e10);
        h(bluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<byte[]> j(int i10, byte[] data) {
        ArrayList c10;
        i.f(data, "data");
        if (data.length <= i10) {
            c10 = kotlin.collections.m.c(data);
            return c10;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < data.length) {
            int min = Math.min(data.length - i11, i10);
            byte[] bArr = new byte[min];
            System.arraycopy(data, i11, bArr, 0, min);
            arrayList.add(bArr);
            i11 += i10;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(BluetoothDevice bluetoothDevice, UUID uuid, Operation op2) throws BleException {
        i.f(op2, "op");
        com.mobvoi.apollo.protocol.ble.b bVar = com.mobvoi.apollo.protocol.ble.b.f15583a;
        if (bVar.c()) {
            k.c("BleGattHelperBase", "waitForOperation device[%s] operation[%s] uuid[%s]", bluetoothDevice, op2, uuid);
        }
        b g10 = g(bluetoothDevice);
        g10.i(op2, uuid);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f15607d.wait(this.f15604a);
            if (g10.b() != Operation.NO_OP) {
                Object[] objArr = new Object[4];
                objArr[0] = op2;
                if (bluetoothDevice == null) {
                    bluetoothDevice = "-";
                }
                objArr[1] = bluetoothDevice;
                if (uuid == null) {
                    uuid = "-";
                }
                objArr[2] = uuid;
                objArr[3] = Long.valueOf(this.f15604a);
                throw new BleException("Operation[%s] for %s/%s timeout after %dms", objArr);
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 >= this.f15604a) {
                k.s("BleGattHelperBase", "Operation[%s] timeout, timeUsed: %dms", op2, Long.valueOf(elapsedRealtime2));
            } else if (bVar.c()) {
                k.c("BleGattHelperBase", "Operation[%s] done, timeUsed: %dms", op2, Long.valueOf(elapsedRealtime2));
            }
            c(bluetoothDevice);
        } finally {
            g10.e();
        }
    }
}
