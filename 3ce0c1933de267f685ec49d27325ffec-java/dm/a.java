package dm;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import bm.a;
import bm.f;
import cm.d;
import cm.e;
import com.realsil.sdk.dfu.DfuException;
import dl.c;
import il.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class a extends bm.a {

    /* renamed from: w  reason: collision with root package name */
    public BluetoothGattCharacteristic f25666w;

    /* renamed from: x  reason: collision with root package name */
    public BluetoothGattCharacteristic f25667x;

    /* renamed from: y  reason: collision with root package name */
    public BluetoothGattCharacteristic f25668y;

    public a(int i10, boolean z10) {
        this.f5209d = i10;
    }

    @Override // bm.a
    public void d(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
        d k10;
        int i11;
        d k11;
        int i12;
        d k12;
        int i13;
        super.d(bluetoothGatt, bluetoothGattCharacteristic, i10);
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        bluetoothGattCharacteristic.getValue();
        b.k(this.f5207b, "processCharacteristicRead");
        if (i10 == 0) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            int length = value != null ? value.length : 0;
            if (f.a.f5259b.equals(uuid)) {
                g(value);
            } else if (f.b.f5261b.equals(uuid)) {
                b.j("PNP_ID: " + jl.a.a(value));
                k().o0(value);
            } else if (g.f25676f.equals(uuid)) {
                b.k(this.f5208c, "update device info");
                k().Z(value);
            } else if (g.f25672b.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap = ByteBuffer.wrap(value);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    if (length >= 6) {
                        byte[] bArr = new byte[6];
                        wrap.get(bArr, 0, 6);
                        k().h0(bArr);
                    }
                }
            } else if (g.f25673c.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap2 = ByteBuffer.wrap(value);
                    wrap2.order(ByteOrder.LITTLE_ENDIAN);
                    if (length == 2) {
                        k12 = k();
                        i13 = wrap2.getShort(0);
                    } else if (length >= 4) {
                        k12 = k();
                        i13 = wrap2.getInt(0);
                    }
                    k12.n0(i13 & 65535);
                }
            } else if (g.f25674d.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap3 = ByteBuffer.wrap(value);
                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                    if (length == 2) {
                        k11 = k();
                        i12 = wrap3.getShort(0) & 65535;
                    } else if (length >= 4) {
                        k11 = k();
                        i12 = wrap3.getInt(0);
                    }
                    k11.e0(i12);
                }
            } else if (!g.f25675e.equals(uuid)) {
                int g10 = fl.b.g(uuid);
                if (g10 >= 65504 && g10 <= 65519) {
                    b.k(this.f5207b, "X0012:appendActiveImageVersionBytes");
                    k().c(value);
                } else if (g10 >= 65472 && g10 <= 65487) {
                    k().e(g10, value);
                }
            } else if (length > 0) {
                ByteBuffer wrap4 = ByteBuffer.wrap(value);
                wrap4.order(ByteOrder.LITTLE_ENDIAN);
                if (length == 1) {
                    k10 = k();
                    i11 = wrap4.get(0);
                } else if (length == 2) {
                    k10 = k();
                    i11 = wrap4.getShort(0) & 65535;
                }
                k10.m0(i11);
            }
        } else {
            boolean z10 = this.f5206a;
            b.f(z10, "Characteristic read error: " + i10);
            if (g.f25676f.equals(uuid)) {
                l(2);
            } else {
                b.c("ignore exctption when read other info");
                return;
            }
        }
        q();
    }

    @Override // bm.a
    public void f(lm.b bVar, String str, BluetoothGatt bluetoothGatt, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2, a.c cVar) {
        super.f(bVar, str, bluetoothGatt, bluetoothGattService, bluetoothGattService2, cVar);
        t();
        s();
    }

    @Override // bm.a
    public void p() {
        super.p();
        l(DfuException.ERROR_FILE_IO_EXCEPTION);
        if (this.f5213h != null) {
            l(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            boolean i10 = i(this.f5213h);
            boolean z10 = this.f5207b;
            b.k(z10, "read battery level :" + i10);
        }
        if (this.f5214i != null) {
            l(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
            boolean i11 = i(this.f5214i);
            boolean z11 = this.f5207b;
            b.k(z11, "read PnP_ID :" + i11);
        }
        if (this.f25668y != null) {
            l(DfuException.ERROR_CONNECTION_TIMEOUT);
            boolean i12 = i(this.f25668y);
            boolean z12 = this.f5207b;
            b.k(z12, "read device info :" + i12);
            if (!i12) {
                this.f5215j.clear();
                l(2);
                return;
            }
        }
        if (this.f25667x != null) {
            l(DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK);
            boolean i13 = i(this.f25667x);
            boolean z13 = this.f5207b;
            b.k(z13, "read device mac :" + i13);
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.f5215j) {
            int g10 = fl.b.g(bluetoothGattCharacteristic.getUuid());
            b.k(this.f5208c, String.format("uuidShortValue=0x%4x", Integer.valueOf(g10)));
            if (g10 >= 65472 && g10 <= 65487) {
                l(DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR);
                boolean i14 = i(bluetoothGattCharacteristic);
                boolean z14 = this.f5208c;
                b.k(z14, "read debug info :" + i14);
            } else if (g10 >= 65504 && g10 <= 65519) {
                l(DfuException.ERROR_WRITE_CHARAC_ERROR);
                boolean i15 = i(bluetoothGattCharacteristic);
                boolean z15 = this.f5207b;
                b.d(z15, "X0012: read image version :" + i15);
            }
        }
        if (this.f5208c) {
            b.c("readDeviceInfo complete: " + k().toString());
        }
        this.f5215j.clear();
        l(1);
    }

    public final void s() {
        e eVar;
        List<e> list;
        if (this.f5212g == null) {
            boolean z10 = this.f5206a;
            b.m(z10, "not find DFU_SERVICE_UUID = " + f.f25670a);
            if (this.f25666w != null) {
                list = this.f5217l;
                eVar = new e(0);
            } else {
                return;
            }
        } else {
            boolean z11 = this.f5207b;
            b.d(z11, "find DFU_SERVICE_UUID = " + this.f5212g.getUuid());
            this.f5217l.add(new e(16));
            if (this.f25666w != null) {
                list = this.f5217l;
                eVar = new e(0);
            } else {
                return;
            }
        }
        list.add(eVar);
    }

    public final void t() {
        BluetoothGattService bluetoothGattService = this.f5211f;
        if (bluetoothGattService != null) {
            UUID uuid = g.f25671a;
            BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
            this.f25666w = characteristic;
            if (characteristic == null) {
                b.c("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found");
            } else {
                boolean z10 = this.f5206a;
                b.k(z10, "find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
            }
            BluetoothGattService bluetoothGattService2 = this.f5211f;
            UUID uuid2 = g.f25672b;
            BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
            this.f25667x = characteristic2;
            if (characteristic2 == null) {
                b.c("OTA_DEVICE_MAC_CHARACTERISTIC_UUID not found");
            } else if (this.f5206a) {
                b.j("find OTA_DEVICE_MAC_CHARACTERISTIC_UUID = " + uuid2);
                b.j(c.b(this.f25667x.getProperties()));
            }
            BluetoothGattService bluetoothGattService3 = this.f5211f;
            UUID uuid3 = g.f25676f;
            BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
            this.f25668y = characteristic3;
            if (characteristic3 == null) {
                if (this.f5206a) {
                    b.c("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found");
                }
            } else if (this.f5208c) {
                b.j("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID = " + uuid3);
                b.j(c.b(this.f25668y.getProperties()));
            }
            int i10 = 65472;
            while (true) {
                if (i10 > 65487) {
                    break;
                }
                UUID c10 = fl.b.c(i10);
                BluetoothGattCharacteristic characteristic4 = this.f5211f.getCharacteristic(c10);
                if (characteristic4 != null) {
                    if (this.f5208c) {
                        boolean z11 = this.f5206a;
                        b.k(z11, "find debug characteristic: " + c10.toString());
                    }
                    this.f5215j.add(characteristic4);
                    i10++;
                } else if (this.f5208c) {
                    b.j("not found debug characteristic:" + c10.toString());
                }
            }
            for (int i11 = 65504; i11 <= 65519; i11++) {
                UUID c11 = fl.b.c(i11);
                BluetoothGattCharacteristic characteristic5 = this.f5211f.getCharacteristic(c11);
                if (characteristic5 == null) {
                    boolean z12 = this.f5208c;
                    b.k(z12, "not found image version characteristic:" + c11.toString());
                    return;
                }
                boolean z13 = this.f5206a;
                b.k(z13, "find image version characteristic: " + c11.toString());
                this.f5215j.add(characteristic5);
            }
        }
    }
}
