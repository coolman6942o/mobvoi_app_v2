package em;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import bm.a;
import bm.f;
import cm.d;
import cm.e;
import com.realsil.sdk.dfu.DfuException;
import dl.c;
import gm.g;
import gm.h;
import il.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class a extends bm.a {
    public BluetoothGattCharacteristic A;
    public BluetoothGattCharacteristic B;
    public BluetoothGattCharacteristic C;
    public boolean D;

    /* renamed from: w  reason: collision with root package name */
    public BluetoothGattCharacteristic f26120w;

    /* renamed from: x  reason: collision with root package name */
    public BluetoothGattCharacteristic f26121x;

    /* renamed from: y  reason: collision with root package name */
    public BluetoothGattCharacteristic f26122y;

    /* renamed from: z  reason: collision with root package name */
    public BluetoothGattCharacteristic f26123z;

    public a(int i10, boolean z10) {
        this.f5209d = i10;
        this.D = z10;
    }

    @Override // bm.a
    public void c(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.c(bluetoothGatt, bluetoothGattCharacteristic);
        bluetoothGattCharacteristic.getUuid();
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (!g.f27506c.equals(bluetoothGattCharacteristic.getUuid())) {
            return;
        }
        if (value == null || value.length < 2) {
            b.l("notification data invalid");
            return;
        }
        int i10 = value[0] & 255;
        int i11 = value[1] & 255;
        byte b10 = value[2];
        if (this.f5208c) {
            b.j(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
        if (i10 == 16 && i11 == 13) {
            if (b10 == 1) {
                k().U(value, 3);
            } else {
                b.l("Get temp dev info failed");
            }
            q();
        }
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
        if (i10 == 0) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            int length = value != null ? value.length : 0;
            if (f.a.f5259b.equals(uuid)) {
                g(value);
            } else if (f.b.f5261b.equals(uuid)) {
                b.j("PNP_ID: " + jl.a.a(value));
                k().o0(value);
            } else if (h.f27513f.equals(uuid)) {
                k().T(value);
            } else if (h.f27509b.equals(uuid)) {
                if (length > 0) {
                    ByteBuffer wrap = ByteBuffer.wrap(value);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    if (length >= 6) {
                        byte[] bArr = new byte[6];
                        wrap.get(bArr, 0, 6);
                        k().h0(bArr);
                    }
                }
            } else if (h.f27510c.equals(uuid)) {
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
            } else if (h.f27511d.equals(uuid)) {
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
            } else if (h.f27512e.equals(uuid)) {
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
            } else {
                int g10 = fl.b.g(uuid);
                if (g10 >= 65504 && g10 <= 65519) {
                    k().c(value);
                } else if (g10 >= 65472 && g10 <= 65487) {
                    k().e(g10, value);
                }
            }
        } else {
            boolean z10 = this.f5206a;
            b.f(z10, "Characteristic read error: " + i10);
            if (h.f27513f.equals(uuid)) {
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
        if (this.D) {
            b.j("No Temp OTA, no need to check ota service");
        } else {
            t();
        }
        s();
    }

    @Override // bm.a
    public void p() {
        boolean i10;
        boolean z10;
        StringBuilder sb2;
        String str;
        super.p();
        l(DfuException.ERROR_FILE_IO_EXCEPTION);
        if (this.f5213h != null) {
            l(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            boolean i11 = i(this.f5213h);
            boolean z11 = this.f5208c;
            b.k(z11, "read battery level :" + i11);
        }
        if (this.f5214i != null) {
            l(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
            boolean i12 = i(this.f5214i);
            boolean z12 = this.f5208c;
            b.k(z12, "read PnP_ID :" + i12);
        }
        if (this.f26122y != null) {
            l(DfuException.ERROR_CONNECTION_TIMEOUT);
            boolean i13 = i(this.f26122y);
            boolean z13 = this.f5208c;
            b.k(z13, "read device info :" + i13);
            if (!i13) {
                this.f5215j.clear();
                l(2);
                return;
            }
        }
        if (this.f26121x != null) {
            l(DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK);
            boolean i14 = i(this.f26121x);
            boolean z14 = this.f5208c;
            b.k(z14, "read device mac :" + i14);
        }
        if (k().f6005k == 0) {
            if (this.f26123z != null) {
                l(DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS);
                boolean i15 = i(this.f26123z);
                boolean z15 = this.f5208c;
                b.k(z15, "read app version :" + i15);
            }
            if (this.A != null) {
                l(DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS);
                boolean i16 = i(this.A);
                boolean z16 = this.f5208c;
                b.k(z16, "attempt to read patch version :" + i16);
            }
            if (this.B != null) {
                l(DfuException.ERROR_CONNECT_ERROR);
                boolean i17 = i(this.B);
                boolean z17 = this.f5208c;
                b.k(z17, "attempt to read patch extension version :" + i17);
            }
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.C;
        if (bluetoothGattCharacteristic != null) {
            if (h(this.f5210e, bluetoothGattCharacteristic, true)) {
                l(DfuException.ERROR_CANNOT_FIND_DEVICE);
                boolean u10 = u();
                boolean z18 = this.f5208c;
                b.k(z18, "readTempDeviceInfo:" + u10);
            } else {
                b.d(this.f5207b, "readTempDeviceInfo failed");
            }
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : this.f5215j) {
            int g10 = fl.b.g(bluetoothGattCharacteristic2.getUuid());
            b.k(this.f5206a, String.format("uuidShortValue=0x%4x", Integer.valueOf(g10)));
            if (g10 >= 65472 && g10 <= 65487) {
                l(DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR);
                i10 = i(bluetoothGattCharacteristic2);
                z10 = this.f5208c;
                sb2 = new StringBuilder();
                str = "read debug info :";
            } else if (g10 >= 65504 && g10 <= 65519 && k().f6005k != 0) {
                l(DfuException.ERROR_WRITE_CHARAC_ERROR);
                i10 = i(bluetoothGattCharacteristic2);
                z10 = this.f5208c;
                sb2 = new StringBuilder();
                str = "read image version :";
            }
            sb2.append(str);
            sb2.append(i10);
            b.k(z10, sb2.toString());
        }
        if (this.f5208c) {
            b.c("readDeviceInfo complete: " + k().toString());
        }
        this.f5215j.clear();
        l(1);
    }

    public final void s() {
        String str;
        List<e> list;
        e eVar;
        if (this.f5212g == null) {
            this.C = null;
            b.m(this.f5206a, "not find DFU_SERVICE_UUID = " + g.f27504a);
            if (this.f26120w != null) {
                list = this.f5217l;
                eVar = new e(0);
            } else {
                return;
            }
        } else {
            b.d(this.f5206a, "find DFU_SERVICE_UUID = " + this.f5212g.getUuid());
            if (this.D) {
                this.f5217l.add(new e(18));
                BluetoothGattService bluetoothGattService = this.f5212g;
                UUID uuid = g.f27506c;
                BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
                this.C = characteristic;
                if (characteristic == null) {
                    str = "not found DFU_CONTROL_POINT_CHARACTERISTIC: " + uuid;
                } else {
                    if (this.f5206a) {
                        b.c("find DFU_CONTROL_POINT_CHARACTERISTIC: " + uuid);
                        b.c(c.b(this.C.getProperties()));
                    }
                    this.C.setWriteType(2);
                    return;
                }
            } else {
                BluetoothGattService bluetoothGattService2 = this.f5212g;
                UUID uuid2 = g.f27507d;
                BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
                if (characteristic2 != null) {
                    b.d(this.f5206a, "find DFU_EXTEND_FLASH_CHARACTERISTIC = " + uuid2);
                    this.f5217l.add(new e(17));
                    str = c.b(characteristic2.getProperties());
                } else {
                    b.d(this.f5206a, "DFU_EXTEND_FLASH_CHARACTERISTIC not found");
                    this.f5217l.add(new e(16));
                    if (this.f26120w != null) {
                        list = this.f5217l;
                        eVar = new e(0);
                    } else {
                        return;
                    }
                }
            }
            b.c(str);
            return;
        }
        list.add(eVar);
    }

    public final void t() {
        BluetoothGattService bluetoothGattService = this.f5211f;
        if (bluetoothGattService != null) {
            UUID uuid = h.f27508a;
            BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
            this.f26120w = characteristic;
            if (characteristic == null) {
                b.c("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found");
            } else {
                boolean z10 = this.f5206a;
                b.k(z10, "find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
            }
            BluetoothGattService bluetoothGattService2 = this.f5211f;
            UUID uuid2 = h.f27509b;
            BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
            this.f26121x = characteristic2;
            if (characteristic2 == null) {
                if (this.f5207b) {
                    b.c("OTA_DEVICE_MAC_CHARACTERISTIC_UUID not found");
                }
            } else if (this.f5208c) {
                b.j("find OTA_DEVICE_MAC_CHARACTERISTIC_UUID = " + uuid2);
                b.j(c.b(this.f26121x.getProperties()));
            }
            BluetoothGattService bluetoothGattService3 = this.f5211f;
            UUID uuid3 = h.f27510c;
            BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
            this.A = characteristic3;
            if (characteristic3 == null) {
                if (this.f5207b) {
                    b.c("OTA_READ_PATCH_CHARACTERISTIC_UUID not found");
                }
            } else if (this.f5208c) {
                b.j("find OTA_READ_PATCH_CHARACTERISTIC_UUID = " + uuid3);
                b.j(c.b(this.A.getProperties()));
            }
            BluetoothGattService bluetoothGattService4 = this.f5211f;
            UUID uuid4 = h.f27511d;
            BluetoothGattCharacteristic characteristic4 = bluetoothGattService4.getCharacteristic(uuid4);
            this.f26123z = characteristic4;
            if (characteristic4 == null) {
                if (this.f5207b) {
                    b.c("OTA_APP_VERSION_CHARACTERISTIC_UUID not found");
                }
            } else if (this.f5208c) {
                b.j("find OTA_APP_VERSION_CHARACTERISTIC_UUID = " + uuid4);
                b.j(c.b(this.f26123z.getProperties()));
            }
            BluetoothGattService bluetoothGattService5 = this.f5211f;
            UUID uuid5 = h.f27512e;
            BluetoothGattCharacteristic characteristic5 = bluetoothGattService5.getCharacteristic(uuid5);
            this.B = characteristic5;
            if (characteristic5 == null) {
                b.c("OTA_READ_PATCH_EXTENSION_CHARACTERISTIC_UUID not found");
            } else if (this.f5206a) {
                b.j("find OTA_READ_PATCH_EXTENSION_CHARACTERISTIC_UUID = " + uuid5);
                b.j(c.b(this.B.getProperties()));
            }
            BluetoothGattService bluetoothGattService6 = this.f5211f;
            UUID uuid6 = h.f27513f;
            BluetoothGattCharacteristic characteristic6 = bluetoothGattService6.getCharacteristic(uuid6);
            this.f26122y = characteristic6;
            if (characteristic6 == null) {
                if (this.f5207b) {
                    b.c("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found");
                }
            } else if (this.f5208c) {
                b.j("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID = " + uuid6);
                b.j(c.b(this.f26122y.getProperties()));
            }
            int i10 = 65472;
            while (true) {
                if (i10 > 65487) {
                    break;
                }
                UUID c10 = fl.b.c(i10);
                BluetoothGattCharacteristic characteristic7 = this.f5211f.getCharacteristic(c10);
                if (characteristic7 != null) {
                    boolean z11 = this.f5208c;
                    b.k(z11, "find debug characteristic: " + c10.toString());
                    this.f5215j.add(characteristic7);
                    i10++;
                } else if (this.f5207b) {
                    b.c("not found debug characteristic:" + c10.toString());
                }
            }
            for (int i11 = 65504; i11 <= 65519; i11++) {
                UUID c11 = fl.b.c(i11);
                BluetoothGattCharacteristic characteristic8 = this.f5211f.getCharacteristic(c11);
                if (characteristic8 == null) {
                    boolean z12 = this.f5206a;
                    b.d(z12, "not found image version characteristic:" + c11.toString());
                    return;
                }
                boolean z13 = this.f5206a;
                b.d(z13, "find image version characteristic: " + c11.toString());
                this.f5215j.add(characteristic8);
            }
        }
    }

    public final boolean u() {
        if (this.f5210e == null || this.C == null) {
            b.l("mBtGatt is null maybe disconnected just now");
            return false;
        }
        b.j("attempt to read temp device info ....: ");
        this.C.setValue(new byte[]{13});
        boolean writeCharacteristic = this.f5210e.writeCharacteristic(this.C);
        if (writeCharacteristic) {
            r();
        }
        return writeCharacteristic;
    }
}
