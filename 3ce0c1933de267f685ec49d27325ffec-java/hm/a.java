package hm;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import bm.a;
import bm.f;
import cm.e;
import com.realsil.sdk.dfu.DfuException;
import dl.c;
import il.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
/* loaded from: classes2.dex */
public class a extends bm.a {

    /* renamed from: w  reason: collision with root package name */
    public BluetoothGattCharacteristic f27879w;

    /* renamed from: x  reason: collision with root package name */
    public BluetoothGattCharacteristic f27880x;

    /* renamed from: y  reason: collision with root package name */
    public BluetoothGattCharacteristic f27881y;

    public a() {
        this.f5209d = 16;
    }

    @Override // bm.a
    public void d(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
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
            } else if (g.f27885c.equals(uuid)) {
                k().V(value);
            } else if (!g.f27884b.equals(uuid)) {
                int g10 = fl.b.g(uuid);
                if (g10 >= 65504 && g10 <= 65519) {
                    k().c(value);
                } else if (g10 >= 65472 && g10 <= 65487) {
                    k().e(g10, value);
                } else if (g10 >= 65524 && g10 <= 65526) {
                    k().f(value);
                }
            } else if (length > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(value);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                if (length >= 6) {
                    byte[] bArr = new byte[6];
                    wrap.get(bArr, 0, 6);
                    k().h0(bArr);
                }
            }
        } else {
            boolean z10 = this.f5206a;
            b.m(z10, "Characteristic read error: " + i10);
            if (g.f27885c.equals(uuid)) {
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
        boolean z10;
        String str;
        boolean i10;
        boolean z11;
        StringBuilder sb2;
        super.p();
        l(DfuException.ERROR_FILE_IO_EXCEPTION);
        if (this.f5213h != null) {
            l(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            boolean i11 = i(this.f5213h);
            b.k(this.f5208c, "read battery level :" + i11);
        }
        if (this.f5214i != null) {
            l(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
            boolean i12 = i(this.f5214i);
            b.k(this.f5208c, "read PnP_ID :" + i12);
        }
        if (this.f27881y != null) {
            l(DfuException.ERROR_CONNECTION_TIMEOUT);
            boolean i13 = i(this.f27881y);
            b.k(this.f5208c, "read device info :" + i13);
            if (!i13) {
                this.f5215j.clear();
                l(2);
                return;
            }
        }
        if (this.f27880x != null) {
            l(DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK);
            boolean i14 = i(this.f27880x);
            b.k(this.f5208c, "read device mac :" + i14);
        }
        int i15 = k().f6005k;
        int i16 = DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR;
        if (i15 < 4) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.f5215j) {
                int g10 = fl.b.g(bluetoothGattCharacteristic.getUuid());
                b.k(this.f5208c, String.format("uuidShortValue=0x%4x", Integer.valueOf(g10)));
                if (g10 >= 65472 && g10 <= 65487) {
                    l(DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR);
                    i10 = i(bluetoothGattCharacteristic);
                    z11 = this.f5208c;
                    sb2 = new StringBuilder();
                    sb2.append("read debug info :");
                } else if (g10 >= 65504 && g10 <= 65519) {
                    l(DfuException.ERROR_WRITE_CHARAC_ERROR);
                    i10 = i(bluetoothGattCharacteristic);
                    z11 = this.f5208c;
                    sb2 = new StringBuilder();
                    sb2.append("read image version :");
                } else if (g10 >= 65524 && g10 <= 65526) {
                    l(DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES);
                    i10 = i(bluetoothGattCharacteristic);
                    z11 = this.f5208c;
                    sb2 = new StringBuilder();
                    sb2.append("read image section version :");
                }
                sb2.append(i10);
                b.k(z11, sb2.toString());
            }
        } else {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : this.f5215j) {
                int g11 = fl.b.g(bluetoothGattCharacteristic2.getUuid());
                b.k(this.f5208c, String.format("uuidShortValue=0x%4x", Integer.valueOf(g11)));
                if (g11 >= 65472 && g11 <= 65487) {
                    l(i16);
                    boolean i17 = i(bluetoothGattCharacteristic2);
                    z10 = this.f5208c;
                    str = "read debug info :" + i17;
                } else if (g11 == 65504) {
                    l(DfuException.ERROR_WRITE_CHARAC_ERROR);
                    boolean i18 = i(bluetoothGattCharacteristic2);
                    z10 = this.f5208c;
                    str = "read image version :" + i18;
                } else if (g11 == 65524) {
                    l(DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES);
                    boolean i19 = i(bluetoothGattCharacteristic2);
                    b.k(this.f5208c, "read image section version :" + i19);
                    i16 = DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR;
                }
                b.k(z10, str);
            }
        }
        u();
        if (this.f5208c) {
            b.c("readDeviceInfo complete: " + k().toString());
        }
        this.f5215j.clear();
        l(1);
    }

    public final void s() {
        if (this.f5212g != null) {
            this.f5217l.add(new e(16));
        }
        if (this.f27879w != null) {
            this.f5217l.add(new e(0));
        }
    }

    public final void t() {
        BluetoothGattService bluetoothGattService = this.f5211f;
        if (bluetoothGattService == null) {
            b.l("mOtaService is null");
            return;
        }
        UUID uuid = g.f27883a;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.f27879w = characteristic;
        if (characteristic == null) {
            b.c("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found");
        } else {
            boolean z10 = this.f5206a;
            b.k(z10, "find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
        }
        BluetoothGattService bluetoothGattService2 = this.f5211f;
        UUID uuid2 = g.f27884b;
        BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
        this.f27880x = characteristic2;
        if (characteristic2 == null) {
            b.c("OTA_DEVICE_MAC_CHARACTERISTIC_UUID not found");
        } else if (this.f5206a) {
            b.c("find OTA_DEVICE_MAC_CHARACTERISTIC_UUID = " + uuid2);
            b.j(c.b(this.f27880x.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.f5211f;
        UUID uuid3 = g.f27885c;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
        this.f27881y = characteristic3;
        if (characteristic3 == null) {
            if (this.f5207b) {
                b.l("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found");
            }
        } else if (this.f5208c) {
            b.c("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID = " + uuid3);
            b.c(c.b(this.f27881y.getProperties()));
        }
        int i10 = 65472;
        while (true) {
            if (i10 > 65487) {
                break;
            }
            UUID c10 = fl.b.c(i10);
            BluetoothGattCharacteristic characteristic4 = this.f5211f.getCharacteristic(c10);
            if (characteristic4 == null) {
                boolean z11 = this.f5208c;
                b.d(z11, "not found debug characteristic:" + c10.toString());
                break;
            }
            boolean z12 = this.f5208c;
            b.d(z12, "find debug characteristic: " + c10.toString());
            this.f5215j.add(characteristic4);
            i10++;
        }
        int i11 = 65504;
        while (true) {
            if (i11 > 65519) {
                break;
            }
            UUID c11 = fl.b.c(i11);
            BluetoothGattCharacteristic characteristic5 = this.f5211f.getCharacteristic(c11);
            if (characteristic5 == null) {
                boolean z13 = this.f5208c;
                b.k(z13, "not found image version characteristic:" + c11.toString());
                break;
            }
            boolean z14 = this.f5208c;
            b.k(z14, "find image version characteristic: " + c11.toString());
            this.f5215j.add(characteristic5);
            i11++;
        }
        for (int i12 = 65524; i12 <= 65526; i12++) {
            UUID c12 = fl.b.c(i12);
            BluetoothGattCharacteristic characteristic6 = this.f5211f.getCharacteristic(c12);
            if (characteristic6 == null) {
                boolean z15 = this.f5206a;
                b.d(z15, "not found image session size characteristic:" + c12.toString());
                return;
            }
            boolean z16 = this.f5208c;
            b.d(z16, "find image session size characteristic: " + c12.toString());
            this.f5215j.add(characteristic6);
        }
    }

    public final void u() {
        this.f5217l.clear();
        if (this.f5212g != null) {
            this.f5217l.add(new e(16));
            if (k().S()) {
                this.f5217l.add(new e(23));
            }
        }
        if (k().f6015u && this.f27879w != null) {
            this.f5217l.add(new e(0));
            if (k().S()) {
                this.f5217l.add(new e(22));
            }
        }
    }
}
