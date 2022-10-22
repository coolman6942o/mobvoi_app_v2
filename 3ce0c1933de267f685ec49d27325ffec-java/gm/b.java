package gm;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import bm.c;
import bm.f;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.ConnectionParameters;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public abstract class b extends c {
    public BluetoothGattCharacteristic J0;
    public BluetoothGattCharacteristic K0;
    public BluetoothGattCharacteristic L0;
    public BluetoothGattCharacteristic M0;
    public List<BluetoothGattCharacteristic> N0;
    public final BluetoothGattCallback O0 = new a();
    public byte P0 = -1;

    /* loaded from: classes2.dex */
    public class a extends BluetoothGattCallback {
        public a() {
        }

        public final synchronized void a(byte[] bArr) {
            if (bArr != null) {
                if (bArr.length >= 2) {
                    boolean z10 = false;
                    int i10 = bArr[0] & 255;
                    int i11 = bArr[1] & 255;
                    if (b.this.f36588b) {
                        il.b.j(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i10), Integer.valueOf(i11)));
                    }
                    if (i10 == 16) {
                        if (i11 == 7) {
                            synchronized (b.this.L) {
                                if (b.this.P0 == 7) {
                                    b.this.f5235t0 = bArr;
                                    b.this.f5237v0 = true;
                                    b.this.L.notifyAll();
                                } else {
                                    il.b.k(b.this.f36588b, "ignore connection parameters notification");
                                }
                            }
                        } else if (i11 != 8) {
                            synchronized (b.this.L) {
                                b.this.f5235t0 = bArr;
                                b.this.f5237v0 = true;
                                b.this.L.notifyAll();
                            }
                        } else {
                            byte b10 = bArr.length >= 3 ? bArr[2] : (byte) 0;
                            il.b.k(b.this.f36587a, "remote state changed, busyMode=" + ((int) b10));
                            synchronized (b.this.U) {
                                b bVar = b.this;
                                if (b10 == 1) {
                                    z10 = true;
                                }
                                bVar.T = z10;
                                b.this.U.notifyAll();
                            }
                        }
                    }
                    return;
                }
            }
            il.b.l("notification data invalid");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            a(bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            b bVar = b.this;
            if (i10 == 0) {
                bVar.f36602p = bluetoothGattCharacteristic.getValue();
            } else {
                bVar.C = i10 | 1024;
                il.b.l(String.format(Locale.US, "read Characteristic error:0x%04X", Integer.valueOf(bVar.C)));
            }
            b.this.C();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0075, code lost:
            if (r5 != null) goto L10;
         */
        @Override // android.bluetooth.BluetoothGattCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            String str;
            b bVar;
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (i10 == 0) {
                b bVar2 = b.this;
                bVar2.f36605s = false;
                if (bVar2.E0 != null && b.this.E0.equals(bluetoothGattCharacteristic.getUuid())) {
                    if (value != null) {
                        bVar = b.this;
                        bVar.u().b(value.length);
                        b.this.B();
                    }
                    str = "characteristic'value is null, exception";
                    il.b.l(str);
                }
            } else if (i10 != 257 && i10 != 143) {
                b bVar3 = b.this;
                bVar3.C = i10 | 1024;
                str = String.format("Characteristic write error: 0x%04X", Integer.valueOf(bVar3.C));
                il.b.l(str);
            } else if (b.this.E0 != null && b.this.E0.equals(bluetoothGattCharacteristic.getUuid())) {
                if (i10 == 143) {
                    bVar = b.this;
                    bVar.f36605s = false;
                } else {
                    b bVar4 = b.this;
                    bVar4.f36605s = true;
                    if (bVar4.f36587a) {
                        il.b.c("write image packet error, status=" + i10 + ", please retry.");
                    }
                }
            }
            b.this.s();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (i10 != 0) {
                if (i11 == 0) {
                    b.this.G(0);
                }
                b.this.C = i10 | 2048;
            } else if (i11 == 2) {
                b bVar = b.this;
                if (bVar.f36594h) {
                    il.b.l("task already aborted, ignore");
                    return;
                } else if (bVar.f36599m == 256) {
                    dl.c.c(bluetoothGatt);
                    b.this.l0();
                    return;
                }
            } else if (i11 == 0) {
                if (b.this.f36607u == 521) {
                    b bVar2 = b.this;
                    bVar2.C = i10 | 2048;
                    if (bVar2.f36587a) {
                        il.b.c(String.format("disconnect in OTA process, mErrorState: 0x%04X", Integer.valueOf(bVar2.C)));
                    }
                    b.this.s();
                }
                b.this.G(0);
            }
            b.this.A();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            if (i10 != 0) {
                b.this.C = i10 | 1024;
            } else if (f.Y.equals(bluetoothGattDescriptor.getUuid())) {
                b.this.f5236u0 = true;
            }
            b.this.p();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (i11 == 0 && b.this.t().O()) {
                b.this.g0(i10);
            }
            b.this.f5238w0 = true;
            b.this.p();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i10, int i11, int i12) {
            super.onPhyUpdate(bluetoothGatt, i10, i11, i12);
            b bVar = b.this;
            il.b.k(bVar.f36588b, String.format("onPhyUpdate: mConnectionState=0x%04X", Integer.valueOf(bVar.f36599m)));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            b bVar = b.this;
            if (bVar.f36594h) {
                il.b.l("task already aborted, ignore");
            } else if (i10 == 0) {
                try {
                    bVar.f5243z0 = UUID.fromString(bVar.t().u());
                    b bVar2 = b.this;
                    bVar2.D0 = UUID.fromString(bVar2.t().g());
                    b bVar3 = b.this;
                    bVar3.E0 = UUID.fromString(bVar3.t().f());
                    b bVar4 = b.this;
                    bVar4.F0 = UUID.fromString(bVar4.t().e());
                } catch (Exception e10) {
                    il.b.l(e10.toString());
                }
                b.this.W0(bluetoothGatt);
                b.this.R0(bluetoothGatt);
                b.this.L0(bluetoothGatt);
                b.this.G(515);
                b.this.A();
            } else {
                bVar.C = i10 | 2048;
                bVar.A();
            }
        }
    }

    public b(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
    }

    public void A0(boolean z10) {
        il.b.c("<< OPCODE_DFU_ENSURE_CURRENT_BUFFER(0x0C)");
        a0(this.H0, new byte[]{12, !z10 ? 1 : 0}, false);
    }

    public void B0(byte[] bArr) {
        boolean z10;
        D(524);
        int i10 = DfuException.ERROR_DFU_ABORTED;
        boolean z11 = false;
        try {
            il.b.d(this.f36587a, "<< OPCODE_DFU_ACTIVE_IMAGE_RESET(0x04)");
            z10 = a0(this.H0, bArr, false);
        } catch (DfuException e10) {
            if (e10.getErrCode() != 4128) {
                if (!t().S()) {
                    il.b.c("active cmd has no response, ignore");
                    z10 = true;
                } else {
                    il.b.l("active cmd has no response, notify error");
                    i10 = e10.getErrCode();
                }
            }
        }
        i10 = 0;
        z11 = z10;
        if (z11) {
            il.b.d(this.f36587a, "image active success");
            i0(this.C);
            m(this.f36609w);
            return;
        }
        throw new OtaException(i10);
    }

    public boolean D0(wl.a aVar, int i10, int i11) {
        il.b.k(this.f36587a, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(aVar.k0()), Integer.valueOf(i10), Integer.valueOf(i11)));
        return aVar.k0() + i10 > i11;
    }

    public boolean J0(byte[] bArr, int i10) {
        if (bArr == null) {
            il.b.l("buffer == null");
            return false;
        }
        short a10 = a(bArr, i10);
        if (this.f36588b) {
            il.b.j(String.format(Locale.US, "bufferCheck (%d) >> (%d) %s", Short.valueOf(a10), Integer.valueOf(i10), jl.a.a(bArr)));
        }
        if (this.f36587a) {
            il.b.c("<< OPCODE_DFU_REPORT_BUFFER_CRC(0x0A)");
        }
        a0(this.H0, new byte[]{10, (byte) (i10 & 255), (byte) (i10 >> 8), (byte) (a10 & 255), (byte) ((a10 >> 8) & 255)}, false);
        if (this.f36588b) {
            il.b.j("... waiting OPCODE_DFU_REPORT_BUFFER_CRC(0x0A) response");
        }
        byte[] m02 = m0();
        byte b10 = m02[2];
        ByteBuffer wrap = ByteBuffer.wrap(m02);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.P = wrap.getInt(3);
        if (this.f36588b) {
            il.b.j(String.format(Locale.US, "status:0x%04X, mImageUpdateOffset=0x%08X(%d)", Byte.valueOf(b10), Integer.valueOf(this.P), Integer.valueOf(this.P)));
        }
        if (b10 == 1) {
            return true;
        }
        if (b10 == 5 || b10 == 6 || b10 == 7) {
            return false;
        }
        if (b10 != 8) {
            throw new OtaException("ERROR_OPCODE_RESPONSE_NOT_SUPPORTED", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("DFU_STATUS_FLASH_ERASE_ERROR", b10 | 512);
    }

    public final int L0(BluetoothGatt bluetoothGatt) {
        UUID uuid = f.b.f5260a;
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service != null) {
            if (this.f36588b) {
                il.b.j("find DEVICE_INFORMATION_SERVICE: " + uuid.toString());
            }
            UUID uuid2 = f.b.f5261b;
            if (service.getCharacteristic(uuid2) == null) {
                il.b.c("DIS_PNP_ID_CHARACTERISTIC not found:" + uuid2);
                return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
            } else if (!this.f36587a) {
                return 0;
            } else {
                il.b.c("find DIS_PNP_ID_CHARACTERISTIC: " + uuid2.toString());
                return 0;
            }
        } else if (!this.f36587a) {
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        } else {
            il.b.c("DEVICE_INFORMATION_SERVICE not found:" + uuid);
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int N0(String str) {
        BluetoothGatt bluetoothGatt;
        StringBuilder sb2;
        BluetoothDevice M = M(str);
        if (M == null) {
            return DfuException.ERROR_CONNECT_ERROR;
        }
        G(256);
        this.C = 0;
        this.f36597k = false;
        if (this.f36587a) {
            il.b.j(String.format("Connecting to device:%s, isConnectedCallbackCome=%b", fl.a.c(str, true), Boolean.valueOf(this.f36597k)));
        }
        al.c cVar = this.f5233r0;
        if (cVar != null) {
            cVar.p(str, this.O0);
            this.f5233r0.g(str, this.O0);
            bluetoothGatt = this.f5233r0.i(str);
            this.f5234s0 = bluetoothGatt;
            try {
                synchronized (this.f36598l) {
                    if (this.f36588b) {
                        il.b.j(String.format("isConnectedCallbackCome=%b, mErrorState=0x%04X", Boolean.valueOf(this.f36597k), Integer.valueOf(this.C)));
                    }
                    if (!this.f36597k && this.C == 0) {
                        if (this.f36587a) {
                            il.b.c("wait for connect gatt for 32000 ms");
                        }
                        this.f36598l.wait(32000L);
                    }
                }
            } catch (InterruptedException e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("Sleeping interrupted : ");
                sb2.append(e.toString());
                il.b.l(sb2.toString());
                this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                if (this.C == 0) {
                }
                return this.C;
            }
        } else {
            bluetoothGatt = M.connectGatt(this.f36589c, false, this.O0);
            this.f5234s0 = bluetoothGatt;
            try {
                synchronized (this.f36598l) {
                    if (!this.f36597k && this.C == 0) {
                        if (this.f36587a) {
                            il.b.c("wait for connect gatt for 32000 ms");
                        }
                        this.f36598l.wait(32000L);
                    }
                }
            } catch (InterruptedException e11) {
                e = e11;
                sb2 = new StringBuilder();
                sb2.append("Sleeping interrupted : ");
                sb2.append(e.toString());
                il.b.l(sb2.toString());
                this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                if (this.C == 0) {
                }
                return this.C;
            }
        }
        if (this.C == 0) {
            if (!this.f36597k) {
                il.b.l("wait for connect, but can not connect with no callback");
                this.C = DfuException.ERROR_CONNECTION_TIMEOUT;
            } else if (bluetoothGatt == null || this.f36599m != 515) {
                il.b.l("connect with some error, please check. mConnectionState=" + this.f36599m);
                this.C = DfuException.ERROR_CONNECT_ERROR;
            } else if (this.f36587a) {
                il.b.j("connected the device which going to upgrade");
            }
        }
        return this.C;
    }

    public final int R0(BluetoothGatt bluetoothGatt) {
        StringBuilder sb2;
        UUID uuid;
        BluetoothGattService service = bluetoothGatt.getService(this.D0);
        this.G0 = service;
        if (service == null) {
            il.b.c("DFU_SERVICE not found:" + this.D0);
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        }
        if (this.f36588b) {
            il.b.c("find DFU_SERVICE: " + this.D0.toString());
        }
        BluetoothGattCharacteristic characteristic = this.G0.getCharacteristic(this.F0);
        this.H0 = characteristic;
        if (characteristic == null) {
            sb2 = new StringBuilder();
            sb2.append("not found DFU_CONTROL_POINT_UUID: ");
            uuid = this.F0;
        } else {
            if (this.f36588b) {
                il.b.c("find DFU_CONTROL_POINT_UUID: " + this.F0.toString());
            }
            this.H0.setWriteType(2);
            if (this.f36588b) {
                il.b.j(dl.c.b(this.H0.getProperties()));
            }
            BluetoothGattCharacteristic characteristic2 = this.G0.getCharacteristic(this.E0);
            this.I0 = characteristic2;
            if (characteristic2 == null) {
                sb2 = new StringBuilder();
                sb2.append("not found DFU_DATA_UUID: ");
                uuid = this.E0;
            } else {
                if (this.f36588b) {
                    il.b.j("find DFU_DATA_UUID: " + this.E0.toString());
                }
                this.I0.setWriteType(1);
                if (!this.f36588b) {
                    return 0;
                }
                il.b.j(dl.c.b(this.I0.getProperties()));
                return 0;
            }
        }
        sb2.append(uuid.toString());
        il.b.c(sb2.toString());
        return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
    }

    public final void W0(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.f5243z0);
        this.A0 = service;
        if (service == null) {
            il.b.l("OTA_SERVICE not found: " + this.f5243z0.toString());
            return;
        }
        if (this.f36587a) {
            il.b.c("find OTA_SERVICE: " + this.f5243z0.toString());
        }
        BluetoothGattService bluetoothGattService = this.A0;
        UUID uuid = h.f27508a;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.B0 = characteristic;
        if (characteristic == null && this.I == 0) {
            il.b.c("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found: " + uuid);
        } else if (this.f36588b) {
            il.b.j("find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
            il.b.j(dl.c.b(this.B0.getProperties()));
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.B0;
        if (bluetoothGattCharacteristic != null) {
            bluetoothGattCharacteristic.setWriteType(1);
        }
        BluetoothGattService bluetoothGattService2 = this.A0;
        UUID uuid2 = h.f27509b;
        BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
        this.J0 = characteristic2;
        if (characteristic2 == null) {
            il.b.c("OTA_MAC_ADDR_CHARACTERISTIC_UUID not found:" + uuid2);
        } else if (this.f36588b) {
            il.b.j("find OTA_MAC_ADDR_CHARACTERISTIC_UUID = " + uuid2);
            il.b.j(dl.c.b(this.B0.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.A0;
        UUID uuid3 = h.f27510c;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
        this.L0 = characteristic3;
        if (characteristic3 == null) {
            il.b.c("OTA_READ_PATCH_CHARACTERISTIC_UUID not found:" + uuid3);
        } else if (this.f36588b) {
            il.b.j("find OTA_PATCH_VERSION_CHARACTERISTIC_UUID: " + uuid3.toString());
            il.b.j(dl.c.b(this.L0.getProperties()));
        }
        BluetoothGattService bluetoothGattService4 = this.A0;
        UUID uuid4 = h.f27511d;
        BluetoothGattCharacteristic characteristic4 = bluetoothGattService4.getCharacteristic(uuid4);
        this.K0 = characteristic4;
        if (characteristic4 == null) {
            il.b.c("OTA_READ_APP_CHARACTERISTIC_UUID not found: " + uuid4);
        } else if (this.f36588b) {
            il.b.j("find OTA_APP_VERSION_CHARACTERISTIC_UUID: " + uuid4.toString());
            il.b.j(dl.c.b(this.K0.getProperties()));
        }
        BluetoothGattService bluetoothGattService5 = this.A0;
        UUID uuid5 = h.f27512e;
        BluetoothGattCharacteristic characteristic5 = bluetoothGattService5.getCharacteristic(uuid5);
        this.M0 = characteristic5;
        if (characteristic5 == null) {
            il.b.c("OTA_PATCH_EXTENSION_VERSION_CHARACTERISTIC_UUID not found:" + uuid5);
        } else if (this.f36588b) {
            il.b.j("find OTA_PATCH_EXTENSION_VERSION_CHARACTERISTIC_UUID: " + uuid5.toString());
            il.b.j(dl.c.b(this.M0.getProperties()));
        }
        BluetoothGattService bluetoothGattService6 = this.A0;
        UUID uuid6 = h.f27513f;
        BluetoothGattCharacteristic characteristic6 = bluetoothGattService6.getCharacteristic(uuid6);
        this.C0 = characteristic6;
        if (characteristic6 == null) {
            il.b.c("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found:" + uuid6);
        } else if (this.f36588b) {
            il.b.j("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID: " + uuid6);
            il.b.j(dl.c.b(this.C0.getProperties()));
        }
        this.N0 = new ArrayList();
        for (int i10 = 65504; i10 < 65519; i10++) {
            UUID c10 = fl.b.c(i10);
            BluetoothGattCharacteristic characteristic7 = this.A0.getCharacteristic(c10);
            if (characteristic7 != null) {
                if (this.f36588b) {
                    il.b.j("find image version characteristic: " + c10.toString());
                    il.b.j(dl.c.b(characteristic7.getProperties()));
                }
                this.N0.add(characteristic7);
            } else if (this.f36588b) {
                il.b.j("not found image version characteristic:" + c10.toString());
                return;
            } else {
                return;
            }
        }
    }

    public boolean X0(int i10) {
        byte b10;
        String str;
        il.b.c(String.format("<< OPCODE_DFU_CHECK_CURRENT_BUFFER(0x0B) , crc=0x%04X", Integer.valueOf(i10)));
        a0(this.H0, new byte[]{11}, false);
        if (this.f36587a) {
            il.b.c("... waiting CHECK_CURRENT_BUFFER response");
        }
        byte[] m02 = m0();
        if (m02[2] == 1) {
            int i11 = ((m02[4] << 8) & 65280) | (m02[3] & 255);
            if (i11 == i10) {
                return true;
            }
            str = "CRC check error, local: " + i10 + ", remote : " + i11;
        } else {
            str = "check current buffer failed, status: " + ((int) b10);
        }
        il.b.l(str);
        return false;
    }

    public void a1(int i10) {
        v0(i10, false);
    }

    public void c1(int i10) {
        int i11;
        int i12;
        if (this.f36587a) {
            il.b.c("<< OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06)");
        }
        a0(this.H0, new byte[]{6, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255)}, false);
        if (this.f36587a) {
            il.b.j("... Reading OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06) notification");
        }
        byte[] m02 = m0();
        int length = m02 != null ? m02.length : 0;
        byte b10 = -2;
        if (length > 2) {
            b10 = m02[2];
        }
        if (b10 == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(m02);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            if (length >= 11) {
                i11 = wrap.getShort(3) & 65535;
                i12 = 7;
            } else if (length >= 9) {
                i11 = wrap.getShort(3) & 65535;
                i12 = 5;
            } else {
                this.P = 0;
                i11 = 0;
                il.b.c(String.format(Locale.US, "mOriginalFwVersion=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P), Integer.valueOf(this.P)));
                return;
            }
            this.P = wrap.getInt(i12);
            il.b.c(String.format(Locale.US, "mOriginalFwVersion=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P), Integer.valueOf(this.P)));
            return;
        }
        il.b.e(String.format("0x%02X, Get target image info failed", Integer.valueOf((int) DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
        throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public void d1(int i10) {
        il.b.c("<< OPCODE_DFU_VALIDATE_FW_IMAGE (0x03)");
        a0(this.H0, new byte[]{3, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255)}, false);
        int i11 = 10000;
        if ((v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 12) && u().i() > 2097152) {
            i11 = Math.max(((u().i() / 1048576) + 1) * 4 * 1000, 10000);
        }
        if (this.f36587a) {
            il.b.c("... waiting DFU_VALIDATE_FW_IMAGE response for " + i11);
        }
        byte b10 = f0(i11)[2];
        if (b10 != 1) {
            if (b10 == 5) {
                il.b.e(String.format("0x%02X, Validate FW failed, CRC check error", Byte.valueOf(b10)));
                throw new OtaException("Validate FW failed", DfuException.ERROR_REMOTE_CRC_ERROR);
            } else {
                il.b.e(String.format("0x%02X(not supported), Validate FW failed", Byte.valueOf(b10)));
                throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
            }
        }
    }

    public void n1() {
        B0(new byte[]{4});
    }

    public void o1() {
        if (t().a().longValue() > 0) {
            try {
                Thread.sleep(t().a().longValue());
            } catch (InterruptedException unused) {
            }
        }
    }

    public int p1() {
        byte[] f02;
        if (this.H0 == null) {
            il.b.l("no mControlPointCharacteristic found");
            return 0;
        }
        il.b.c("<< OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE(0x09)");
        a0(this.H0, new byte[]{9}, false);
        try {
            if (this.f36587a) {
                il.b.c("... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            }
            f02 = f0(1600L);
        } catch (DfuException unused) {
            il.b.l("Read DFU_REPORT_OTA_FUNCTION_VERSION exception, just think remote is normal function.");
            this.C = 0;
        }
        if (f02[2] == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(f02);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i10 = (((short) (wrap.get(4) & 255)) << 8) | ((short) (wrap.get(3) & 255));
            int i11 = ((short) (wrap.get(5) & 255)) | (((short) (wrap.get(6) & 255)) << 8);
            if (this.f36587a) {
                il.b.j("maxBufferSize=" + i10 + ", bufferCheckMtuSize=" + i11);
            }
            b(i10);
            d0(i11);
            return 1;
        }
        il.b.c("Read DFU_REPORT_OTA_FUNCTION_VERSION failed, just think remote is normal function.");
        return 0;
    }

    public void q0() {
        il.b.j("<< OPCODE_DFU_START_DFU(0x01)");
        byte[] bArr = new byte[16];
        System.arraycopy(this.f36609w.E(), 0, bArr, 0, 12);
        byte[] bArr2 = new byte[17];
        bArr2[0] = 1;
        if (v().N()) {
            System.arraycopy(this.B.a(bArr, 0, 16), 0, bArr2, 1, 16);
        } else {
            System.arraycopy(bArr, 0, bArr2, 1, 16);
        }
        a0(this.H0, bArr2, false);
        if (this.f36587a) {
            il.b.j("... Reading OPCODE_DFU_START_DFU(0x01) notification");
        }
        byte b10 = m0()[2];
        if (b10 != 1) {
            il.b.e(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b10)));
            throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
    }

    public void q1() {
        int i10;
        int i11;
        if (v().f6005k == 0) {
            if (this.L0 != null) {
                il.b.j("read patch version");
                byte[] c02 = c0(this.L0);
                if (c02 != null) {
                    try {
                        ByteBuffer wrap = ByteBuffer.wrap(c02);
                        wrap.order(ByteOrder.LITTLE_ENDIAN);
                        if (v().f6004j > 3) {
                            if (v().f6004j != 5) {
                                if (v().f6004j != 9) {
                                    if (v().f6004j == 12) {
                                    }
                                }
                            }
                            i11 = wrap.getInt(0);
                            v().n0(i11);
                        }
                        i11 = wrap.getShort(0) & 65535;
                        v().n0(i11);
                    } catch (Exception e10) {
                        il.b.l(e10.toString());
                    }
                }
            }
            if (this.K0 != null) {
                il.b.j("read app version");
                byte[] c03 = c0(this.K0);
                if (c03 != null) {
                    try {
                        ByteBuffer wrap2 = ByteBuffer.wrap(c03);
                        wrap2.order(ByteOrder.LITTLE_ENDIAN);
                        if (v().f6004j > 3) {
                            if (v().f6004j != 5) {
                                if (v().f6004j != 9) {
                                    if (v().f6004j == 12) {
                                    }
                                }
                            }
                            i10 = wrap2.getInt(0);
                            v().e0(i10);
                        }
                        i10 = wrap2.getShort(0) & 65535;
                        v().e0(i10);
                    } catch (Exception e11) {
                        il.b.e(e11.toString());
                    }
                }
            }
            if (this.M0 != null) {
                il.b.j("read patch extension version");
                byte[] c04 = c0(this.M0);
                if (c04 != null) {
                    ByteBuffer wrap3 = ByteBuffer.wrap(c04);
                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                    v().m0(wrap3.getShort(0) & 65535);
                    return;
                }
                return;
            }
            return;
        }
        List<BluetoothGattCharacteristic> list = this.N0;
        byte[] bArr = null;
        if (list == null || list.size() <= 0) {
            v().d0(null);
            il.b.c("no ImageVersionCharacteristics to read");
            return;
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.N0) {
            il.b.j(this.f36588b ? "read image version : " + bluetoothGattCharacteristic.getUuid().toString() : "read image version");
            byte[] c05 = c0(bluetoothGattCharacteristic);
            if (c05 != null) {
                if (bArr == null) {
                    bArr = c05;
                } else {
                    byte[] bArr2 = new byte[bArr.length + c05.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(c05, 0, bArr2, bArr.length, c05.length);
                    bArr = bArr2;
                }
            }
        }
        v().d0(bArr);
    }

    public void r0() {
        il.b.c("<< OPCODE_DFU_CONNECTION_PARAMETER_UPDATE(0x07)");
        this.P0 = (byte) 7;
        byte[] bArr = new byte[9];
        bArr[0] = 7;
        ConnectionParameters d10 = t().d();
        if (d10 != null) {
            bArr[1] = (byte) (d10.c() & 255);
            bArr[2] = (byte) ((d10.c() >> 8) & 255);
            bArr[3] = (byte) (d10.b() & 255);
            bArr[4] = (byte) ((d10.b() >> 8) & 255);
            bArr[5] = (byte) (d10.a() & 255);
            bArr[6] = (byte) ((d10.a() >> 8) & 255);
            bArr[7] = (byte) (d10.d() & 255);
            bArr[8] = (byte) ((d10.d() >> 8) & 255);
        }
        a0(this.H0, bArr, false);
        try {
            if (this.f36587a) {
                il.b.c("... waiting OPCODE_DFU_CONNECTION_PARAMETER_UPDATE(0x07) response");
            }
            m0();
        } catch (DfuException e10) {
            il.b.l("ignore connection parameters update exception: " + e10.getMessage());
            this.C = 0;
        }
        this.P0 = (byte) -1;
    }

    public boolean r1() {
        if (this.J0 == null) {
            return false;
        }
        if (this.f36588b) {
            il.b.j("start to read remote dev Mac Addr info");
        }
        byte[] c02 = c0(this.J0);
        if (c02 == null || c02.length < 6) {
            il.b.l("Get remote dev Mac Addr info failed, do nothing.");
            throw new OtaException("remote dev Mac Addr info error", DfuException.ERROR_READ_REMOTE_MAC_ADDR);
        }
        byte[] bArr = new byte[6];
        System.arraycopy(c02, 0, bArr, 0, 6);
        v().h0(bArr);
        return true;
    }

    public void s1() {
        il.b.c("<<  OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE(0x0A)");
        a0(this.H0, new byte[]{10}, false);
        if (this.f36587a) {
            il.b.c("... Reading OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE notification");
        }
        byte[] m02 = m0();
        byte b10 = m02[2];
        if (b10 == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(m02);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i10 = wrap.getInt(3);
            il.b.j(String.format(Locale.US, "maxBufferCheckSize=(0x%04X, %d)", Integer.valueOf(i10), Integer.valueOf(i10)));
            b(i10);
            return;
        }
        il.b.l("Get remote buffer size info failed, status: " + ((int) b10));
        throw new OtaException("Get remote buffer size info failed", b10 | 512);
    }

    public void t0(byte b10) {
        B0(new byte[]{4, b10});
    }

    public int t1() {
        byte[] f02;
        byte b10;
        if (this.H0 == null) {
            il.b.l("no mControlPointCharacteristic found");
            return 0;
        }
        il.b.j("<< OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION(0x09)");
        a0(this.H0, new byte[]{9}, false);
        try {
            if (this.f36587a) {
                il.b.c("Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification");
            }
            f02 = f0(1600L);
            b10 = f02[2];
        } catch (DfuException unused) {
            il.b.l("Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification failed, just think remote is normal function.");
            this.C = 0;
        }
        if (b10 == 1) {
            ByteBuffer.wrap(f02).order(ByteOrder.LITTLE_ENDIAN);
            return 1;
        }
        il.b.l("reportOtaFunctionVersion failed, status: " + ((int) b10));
        return 0;
    }

    public void u0(int i10, int i11) {
        il.b.c("<< OPCODE_DFU_RECEIVE_FW_IMAGE (0x02)");
        a0(this.H0, new byte[]{2, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) (i11 & 255), (byte) ((i11 >> 8) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 24) & 255)}, false);
    }

    public boolean u1() {
        try {
            il.b.d(this.f36587a, "<< OPCODE_DFU_RESET_SYSTEM (0x05)");
            return a0(this.H0, new byte[]{5}, true);
        } catch (DfuException e10) {
            il.b.l(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e10.getErrCode())));
            this.C = 0;
            return false;
        }
    }

    public void v0(int i10, boolean z10) {
        if (this.f36594h) {
            i10 = 4128;
        }
        if (i10 != 4128) {
            E(DfuException.ERROR_CONNECTION_TIMEOUT, true);
        }
        il.b.j(String.format("error = 0x%04X, needReset=%b", Integer.valueOf(i10), Boolean.valueOf(z10)));
        if (z10) {
            u1();
        }
        el.c cVar = this.f5230o0;
        if (cVar != null) {
            cVar.o();
        }
        m(this.f36609w);
        if (t().K(1)) {
            i0(i10);
        }
        xl.b bVar = this.f36592f;
        if (bVar != null) {
            bVar.a(i10);
        }
        this.f36594h = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
        if (r4 != (u().f() + 12)) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072 A[Catch: IOException -> 0x01fc, TryCatch #0 {IOException -> 0x01fc, blocks: (B:13:0x0051, B:15:0x0056, B:17:0x0061, B:18:0x006e, B:20:0x0072, B:22:0x0087, B:24:0x008e, B:25:0x009d, B:26:0x00af, B:28:0x00b3, B:30:0x00b7, B:31:0x00c6, B:33:0x00d0, B:35:0x00dc), top: B:72:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d A[Catch: IOException -> 0x01fc, TryCatch #0 {IOException -> 0x01fc, blocks: (B:13:0x0051, B:15:0x0056, B:17:0x0061, B:18:0x006e, B:20:0x0072, B:22:0x0087, B:24:0x008e, B:25:0x009d, B:26:0x00af, B:28:0x00b3, B:30:0x00b7, B:31:0x00c6, B:33:0x00d0, B:35:0x00dc), top: B:72:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3 A[Catch: IOException -> 0x01fc, TRY_LEAVE, TryCatch #0 {IOException -> 0x01fc, blocks: (B:13:0x0051, B:15:0x0056, B:17:0x0061, B:18:0x006e, B:20:0x0072, B:22:0x0087, B:24:0x008e, B:25:0x009d, B:26:0x00af, B:28:0x00b3, B:30:0x00b7, B:31:0x00c6, B:33:0x00d0, B:35:0x00dc), top: B:72:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0 A[Catch: IOException -> 0x01fc, TryCatch #0 {IOException -> 0x01fc, blocks: (B:13:0x0051, B:15:0x0056, B:17:0x0061, B:18:0x006e, B:20:0x0072, B:22:0x0087, B:24:0x008e, B:25:0x009d, B:26:0x00af, B:28:0x00b3, B:30:0x00b7, B:31:0x00c6, B:33:0x00d0, B:35:0x00dc), top: B:72:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0102 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, wl.a aVar) {
        int i10;
        int i11;
        il.b.j("uploadFirmwareWithBufferCheck ...");
        l();
        this.C = 0;
        this.f36606t = false;
        int i12 = 0;
        while (!this.f36606t) {
            if (!this.f36594h) {
                int i13 = this.R;
                byte[] bArr = new byte[i13];
                int i14 = i12;
                while (true) {
                    if (this.f36587a) {
                        il.b.j(String.format(Locale.US, "mCurrentMaxBufferSize=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.R), Integer.valueOf(this.P), Integer.valueOf(this.P)));
                    }
                    if (i14 <= 0) {
                        try {
                            int i15 = this.P;
                            if (i15 != -1) {
                            }
                            if (this.P != 0) {
                                System.arraycopy(this.f36609w.E(), 0, bArr, 0, 12);
                                int i16 = i13 - 12;
                                byte[] bArr2 = new byte[i16];
                                int i02 = this.f36609w.i0(bArr2, i16);
                                if (i02 > 0) {
                                    System.arraycopy(bArr2, 0, bArr, 12, i02);
                                    i10 = i02 + 12;
                                } else {
                                    i10 = 12;
                                }
                                u().c(12);
                                u().y(0);
                            } else {
                                i10 = this.f36609w.i0(bArr, Math.min(this.R, this.f36609w.k0()));
                            }
                            if (this.f36587a) {
                                il.b.j(String.format(Locale.US, "checkImageBufferSize=%d", Integer.valueOf(i10)));
                            }
                            if (u().o() < i10) {
                                i10 = u().o();
                                if (this.f36587a) {
                                    il.b.j("reach bottom, only read some,  checkImageBufferSize: " + i10);
                                }
                            }
                            i11 = i10;
                            if (this.f36587a) {
                                il.b.c(u().toString());
                            }
                            if (i11 <= 0) {
                                byte[] bArr3 = new byte[this.R];
                                int i17 = this.S;
                                byte[] bArr4 = new byte[i17];
                                int i18 = 0;
                                while (i18 < i11) {
                                    int min = Math.min(i17, i11 - i18);
                                    System.arraycopy(bArr, i18, bArr4, 0, min);
                                    if (v().N()) {
                                        int i19 = 0;
                                        while (true) {
                                            if (i19 < min) {
                                                int min2 = Math.min(min - i19, 16);
                                                if (min2 < 16) {
                                                    il.b.k(this.f36588b, "encryptSize < 16, no need to encrypt:" + min2);
                                                    break;
                                                }
                                                System.arraycopy(this.B.a(bArr4, i19, 16), 0, bArr4, i19, 16);
                                                i19 += 16;
                                                if (v().r() == 0) {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    H();
                                    int i20 = i18;
                                    Y(bluetoothGatt, bluetoothGattCharacteristic, bArr4, min, false);
                                    System.arraycopy(bArr4, 0, bArr3, i20, min);
                                    i18 = i20 + min;
                                    O();
                                    k();
                                }
                                boolean J0 = J0(bArr3, i11);
                                if (!J0) {
                                    u().b(0 - i11);
                                    i14++;
                                    il.b.l("check failed, retransTimes: " + i14);
                                } else {
                                    i14 = 0;
                                }
                                if (i14 < 3) {
                                    if (J0) {
                                        break;
                                    }
                                } else {
                                    il.b.l("Error while buffer check, reach max try times: " + i14 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                                    throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                                }
                            } else if (u().t()) {
                                il.b.c("image file has already been send over");
                            } else {
                                il.b.l("Error while reading file with size: " + i11);
                                throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                            }
                        } catch (IOException unused) {
                            throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                        }
                    }
                    il.b.c("the last sent to remote may not alignment, reinstall input stream");
                    Q();
                    i(this.P, true);
                    if (this.P != 0) {
                    }
                    if (this.f36587a) {
                    }
                    if (u().o() < i10) {
                    }
                    i11 = i10;
                    if (this.f36587a) {
                    }
                    if (i11 <= 0) {
                    }
                }
                i12 = i14;
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }
}
