package fm;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import bm.a;
import bm.f;
import cm.e;
import com.realsil.sdk.dfu.DfuException;
import dl.c;
import hm.g;
import il.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
/* loaded from: classes2.dex */
public class a extends bm.a {

    /* renamed from: w  reason: collision with root package name */
    public BluetoothGattCharacteristic f27083w;

    /* renamed from: x  reason: collision with root package name */
    public BluetoothGattCharacteristic f27084x;

    /* renamed from: y  reason: collision with root package name */
    public BluetoothGattCharacteristic f27085y;

    public a() {
        this.f5209d = 20;
    }

    @Override // bm.a
    public void d(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
        super.d(bluetoothGatt, bluetoothGattCharacteristic, i10);
        UUID uuid = bluetoothGattCharacteristic.getUuid();
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (i10 == 0) {
            int length = value != null ? value.length : 0;
            if (f.a.f5259b.equals(uuid)) {
                g(value);
            } else if (f.b.f5261b.equals(uuid)) {
                b.j("PNP_ID: " + jl.a.a(value));
                k().o0(value);
            } else if (g.f27885c.equals(uuid)) {
                k().b0(value);
            } else if (!g.f27884b.equals(uuid)) {
                int g10 = fl.b.g(uuid);
                if (g10 >= 65504 && g10 <= 65519) {
                    k().g(value);
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
        if (this.f27085y != null) {
            l(DfuException.ERROR_CONNECTION_TIMEOUT);
            boolean i13 = i(this.f27085y);
            boolean z13 = this.f5208c;
            b.k(z13, "read device info :" + i13);
            if (!i13) {
                this.f5215j.clear();
                l(2);
                return;
            }
        }
        if (this.f27084x != null) {
            l(DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK);
            boolean i14 = i(this.f27084x);
            boolean z14 = this.f5208c;
            b.k(z14, "read device mac :" + i14);
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.f5215j) {
            int g10 = fl.b.g(bluetoothGattCharacteristic.getUuid());
            b.k(this.f5208c, String.format("uuidShortValue=0x%4x", Integer.valueOf(g10)));
            if (g10 >= 65472 && g10 <= 65487) {
                l(DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR);
                i10 = i(bluetoothGattCharacteristic);
                z10 = this.f5208c;
                sb2 = new StringBuilder();
                str = "read debug info :";
            } else if (g10 >= 65504 && g10 <= 65519) {
                l(DfuException.ERROR_WRITE_CHARAC_ERROR);
                i10 = i(bluetoothGattCharacteristic);
                z10 = this.f5208c;
                sb2 = new StringBuilder();
                str = "read image version :";
            } else if (g10 >= 65524 && g10 <= 65526) {
                l(DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES);
                i10 = i(bluetoothGattCharacteristic);
                z10 = this.f5208c;
                sb2 = new StringBuilder();
                str = "read image section size :";
            }
            sb2.append(str);
            sb2.append(i10);
            b.k(z10, sb2.toString());
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
        if (this.f27083w != null) {
            this.f5217l.add(new e(0));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fa A[EDGE_INSN: B:54:0x00fa->B:38:0x00fa ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014b A[EDGE_INSN: B:55:0x014b->B:45:0x014b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t() {
        int i10;
        int i11;
        int i12;
        UUID c10;
        BluetoothGattCharacteristic characteristic;
        UUID c11;
        BluetoothGattCharacteristic characteristic2;
        String str;
        BluetoothGattService bluetoothGattService = this.f5211f;
        if (bluetoothGattService == null) {
            b.c("mOtaService is null");
            return;
        }
        UUID uuid = g.f27883a;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService.getCharacteristic(uuid);
        this.f27083w = characteristic3;
        if (characteristic3 != null) {
            boolean z10 = this.f5206a;
            b.k(z10, "find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
        } else if (this.f5207b) {
            b.c("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found");
        }
        BluetoothGattService bluetoothGattService2 = this.f5211f;
        UUID uuid2 = g.f27884b;
        BluetoothGattCharacteristic characteristic4 = bluetoothGattService2.getCharacteristic(uuid2);
        this.f27084x = characteristic4;
        if (characteristic4 == null) {
            if (this.f5207b) {
                b.c("OTA_DEVICE_MAC_CHARACTERISTIC_UUID not found");
            }
        } else if (this.f5206a) {
            b.c("find OTA_DEVICE_MAC_CHARACTERISTIC_UUID = " + uuid2);
            b.j(c.b(this.f27084x.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.f5211f;
        UUID uuid3 = g.f27885c;
        BluetoothGattCharacteristic characteristic5 = bluetoothGattService3.getCharacteristic(uuid3);
        this.f27085y = characteristic5;
        if (characteristic5 == null) {
            if (this.f5207b) {
                str = "OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found";
                b.c(str);
            }
            i10 = 65472;
            while (true) {
                if (i10 > 65487) {
                    break;
                }
                c11 = fl.b.c(i10);
                characteristic2 = this.f5211f.getCharacteristic(c11);
                if (characteristic2 != null) {
                    boolean z11 = this.f5206a;
                    b.d(z11, "find debug characteristic: " + c11.toString());
                    this.f5215j.add(characteristic2);
                    i10++;
                } else if (this.f5207b) {
                    b.c("not found debug characteristic:" + c11.toString());
                }
            }
            i11 = 65504;
            while (true) {
                if (i11 > 65519) {
                    break;
                }
                c10 = fl.b.c(i11);
                characteristic = this.f5211f.getCharacteristic(c10);
                if (characteristic == null) {
                    boolean z12 = this.f5208c;
                    b.d(z12, "not found image version characteristic:" + c10.toString());
                    break;
                }
                boolean z13 = this.f5208c;
                b.d(z13, "find image version characteristic: " + c10.toString());
                this.f5215j.add(characteristic);
                i11++;
            }
            for (i12 = 65524; i12 <= 65526; i12++) {
                UUID c12 = fl.b.c(i12);
                BluetoothGattCharacteristic characteristic6 = this.f5211f.getCharacteristic(c12);
                if (characteristic6 == null) {
                    boolean z14 = this.f5208c;
                    b.k(z14, "not found image session size characteristic:" + c12.toString());
                    return;
                }
                boolean z15 = this.f5208c;
                b.k(z15, "find image session size characteristic: " + c12.toString());
                this.f5215j.add(characteristic6);
            }
        }
        if (this.f5208c) {
            b.c("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID = " + uuid3);
            str = c.b(this.f27085y.getProperties());
            b.c(str);
        }
        i10 = 65472;
        while (true) {
            if (i10 > 65487) {
            }
            boolean z112 = this.f5206a;
            b.d(z112, "find debug characteristic: " + c11.toString());
            this.f5215j.add(characteristic2);
            i10++;
        }
        i11 = 65504;
        while (true) {
            if (i11 > 65519) {
            }
            boolean z132 = this.f5208c;
            b.d(z132, "find image version characteristic: " + c10.toString());
            this.f5215j.add(characteristic);
            i11++;
        }
        while (i12 <= 65526) {
        }
    }

    public final void u() {
        this.f5217l.clear();
        if (this.f5212g != null) {
            this.f5217l.add(new e(16));
        }
        if (k().f6015u && this.f27083w != null) {
            this.f5217l.add(new e(0));
        }
    }
}
