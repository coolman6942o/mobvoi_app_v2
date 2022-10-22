package dm;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import bm.f;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.ConnectionParameters;
import com.realsil.sdk.dfu.model.DfuConfig;
import il.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public abstract class c extends bm.c {
    public BluetoothGattCharacteristic J0;
    public List<BluetoothGattCharacteristic> K0;
    public final BluetoothGattCallback L0 = new a();

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
                    if (c.this.f36588b) {
                        b.j(String.format("responseType = %02X , requestOpCode = %02X", Integer.valueOf(i10), Integer.valueOf(i11)));
                    }
                    if (i10 == 16) {
                        if (i11 == 7) {
                            synchronized (c.this.L) {
                                b.c("ignore connection parameters notification");
                                c.this.f5235t0 = bArr;
                                c.this.f5237v0 = true;
                                c.this.L.notifyAll();
                            }
                        } else if (i11 != 8) {
                            synchronized (c.this.L) {
                                c.this.f5235t0 = bArr;
                                c.this.f5237v0 = true;
                                c.this.L.notifyAll();
                            }
                        } else {
                            byte b10 = bArr.length >= 3 ? bArr[2] : (byte) 0;
                            b.c("remote state changed, busyMode=" + ((int) b10));
                            synchronized (c.this.U) {
                                c cVar = c.this;
                                if (b10 == 1) {
                                    z10 = true;
                                }
                                cVar.T = z10;
                                c.this.U.notifyAll();
                            }
                        }
                    }
                    return;
                }
            }
            b.l("notification data invalid");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            a(bluetoothGattCharacteristic.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            c cVar = c.this;
            if (i10 == 0) {
                cVar.f36602p = bluetoothGattCharacteristic.getValue();
            } else {
                cVar.C = i10 | 1024;
                b.l(String.format(Locale.US, "read Characteristic error:0x%04X", Integer.valueOf(cVar.C)));
            }
            c.this.C();
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
            c cVar;
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (i10 == 0) {
                c cVar2 = c.this;
                cVar2.f36605s = false;
                if (cVar2.E0 != null && c.this.E0.equals(bluetoothGattCharacteristic.getUuid())) {
                    if (value != null) {
                        cVar = c.this;
                        cVar.u().b(value.length);
                        c.this.B();
                    }
                    str = "characteristic'value is null, exception";
                    b.l(str);
                }
            } else if (i10 != 257 && i10 != 143) {
                c cVar3 = c.this;
                cVar3.C = i10 | 1024;
                str = String.format("Characteristic write error: 0x%04X", Integer.valueOf(cVar3.C));
                b.l(str);
            } else if (c.this.E0 != null && c.this.E0.equals(bluetoothGattCharacteristic.getUuid())) {
                if (i10 == 143) {
                    cVar = c.this;
                    cVar.f36605s = false;
                } else {
                    c cVar4 = c.this;
                    cVar4.f36605s = true;
                    if (cVar4.f36587a) {
                        b.c("write image packet error, status=" + i10 + ", please retry.");
                    }
                }
            }
            c.this.s();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (i10 != 0) {
                if (i11 == 0) {
                    c.this.G(0);
                }
                c.this.C = i10 | 2048;
            } else if (i11 == 2) {
                c cVar = c.this;
                if (cVar.f36594h) {
                    b.l("task already aborted, ignore");
                    return;
                } else if (cVar.f36599m == 256) {
                    dl.c.c(bluetoothGatt);
                    c.this.l0();
                    return;
                }
            } else if (i11 == 0) {
                if (c.this.f36607u == 521) {
                    c cVar2 = c.this;
                    cVar2.C = i10 | 2048;
                    if (cVar2.f36587a) {
                        b.c(String.format("disconnect in OTA process, mErrorState: 0x%04X", Integer.valueOf(cVar2.C)));
                    }
                    c.this.s();
                }
                c.this.G(0);
            }
            c.this.A();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            if (i10 != 0) {
                c.this.C = i10 | 1024;
            } else if (f.Y.equals(bluetoothGattDescriptor.getUuid())) {
                c.this.f5236u0 = true;
            }
            c.this.p();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (i11 == 0) {
                boolean z10 = c.this.f36588b;
                b.k(z10, "mtu=" + i10);
                if (c.this.t().O()) {
                    c.this.g0(i10);
                }
            }
            c.this.f5238w0 = true;
            c.this.p();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i10, int i11, int i12) {
            super.onPhyUpdate(bluetoothGatt, i10, i11, i12);
            b.j(String.format("onPhyUpdate: mConnectionState=0x%04X", Integer.valueOf(c.this.f36599m)));
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            c cVar = c.this;
            if (cVar.f36594h) {
                b.l("task already aborted, ignore");
            } else if (i10 == 0) {
                try {
                    cVar.f5243z0 = UUID.fromString(cVar.t().u());
                    c cVar2 = c.this;
                    cVar2.D0 = UUID.fromString(cVar2.t().g());
                    c cVar3 = c.this;
                    cVar3.E0 = UUID.fromString(cVar3.t().f());
                    c cVar4 = c.this;
                    cVar4.F0 = UUID.fromString(cVar4.t().e());
                } catch (Exception e10) {
                    b.l(e10.toString());
                }
                c.this.X0(bluetoothGatt);
                c.this.S0(bluetoothGatt);
                c.this.M0(bluetoothGatt);
                c.this.G(515);
                c.this.A();
            } else {
                cVar.C = i10 | 2048;
                cVar.A();
            }
        }
    }

    public c(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
    }

    public void A0(boolean z10) {
        b.c("<< OPCODE_DFU_ENSURE_CURRENT_BUFFER(0x0C)");
        a0(this.H0, new byte[]{12, !z10 ? 1 : 0}, false);
    }

    public void B0(byte[] bArr) {
        boolean z10;
        D(524);
        int i10 = DfuException.ERROR_DFU_ABORTED;
        boolean z11 = false;
        try {
            b.c("<< OPCODE_DFU_ACTIVE_IMAGE_RESET(0x04)");
            z10 = a0(this.H0, bArr, false);
        } catch (DfuException e10) {
            if (e10.getErrCode() != 4128) {
                if (!t().S()) {
                    b.c("active cmd has no response, ignore");
                    z10 = true;
                } else {
                    b.l("active cmd has no response, notify error");
                    i10 = e10.getErrCode();
                }
            }
        }
        i10 = 0;
        z11 = z10;
        if (z11) {
            b.c("image active success");
            i0(this.C);
            m(this.f36609w);
            return;
        }
        throw new OtaException(i10);
    }

    public boolean D0(wl.a aVar, int i10, int i11) {
        b.k(this.f36587a, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(aVar.k0()), Integer.valueOf(i10), Integer.valueOf(i11)));
        return aVar.k0() + i10 > i11;
    }

    public void H0(int i10, int i11) {
        b.c("<< OPCODE_DFU_RECEIVE_FW_IMAGE (0x02)");
        a0(this.H0, new byte[]{2, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) (i11 & 255), (byte) ((i11 >> 8) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 24) & 255)}, false);
    }

    public boolean K0(byte[] bArr, int i10) {
        if (bArr == null) {
            b.l("buffer == null");
            return false;
        }
        if (this.f36587a) {
            b.j(String.format(Locale.US, "bufferCheck (%d) >> (%d) %s", Integer.valueOf(i10), Integer.valueOf(bArr.length), jl.a.a(bArr)));
        }
        short a10 = a(bArr, i10);
        if (this.f36587a) {
            b.c("<< OPCODE_DFU_REPORT_BUFFER_CRC(0x0A)");
        }
        a0(this.H0, new byte[]{10, (byte) (i10 & 255), (byte) (i10 >> 8), (byte) (a10 & 255), (byte) ((a10 >> 8) & 255)}, false);
        if (this.f36587a) {
            b.c("... waiting OPCODE_DFU_REPORT_BUFFER_CRC(0x0A) response");
        }
        byte[] m02 = m0();
        byte b10 = m02[2];
        ByteBuffer wrap = ByteBuffer.wrap(m02);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.P = wrap.getInt(3);
        if (this.f36587a) {
            b.c(String.format(Locale.US, "status:0x%04X, mImageUpdateOffset=0x%08X(%d)", Byte.valueOf(b10), Integer.valueOf(this.P), Integer.valueOf(this.P)));
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

    public final int M0(BluetoothGatt bluetoothGatt) {
        UUID uuid = f.b.f5260a;
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service != null) {
            if (this.f36588b) {
                b.j("find DEVICE_INFORMATION_SERVICE: " + uuid.toString());
            }
            UUID uuid2 = f.b.f5261b;
            if (service.getCharacteristic(uuid2) == null) {
                b.c("DIS_PNP_ID_CHARACTERISTIC not found:" + uuid2);
                return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
            } else if (!this.f36587a) {
                return 0;
            } else {
                b.c("find DIS_PNP_ID_CHARACTERISTIC: " + uuid2.toString());
                return 0;
            }
        } else if (!this.f36587a) {
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        } else {
            b.c("DEVICE_INFORMATION_SERVICE not found:" + uuid);
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int O0(String str) {
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
            b.j(String.format("Connecting to device:%s, isConnectedCallbackCome=%b", fl.a.c(str, true), Boolean.valueOf(this.f36597k)));
        }
        al.c cVar = this.f5233r0;
        if (cVar != null) {
            cVar.p(str, this.L0);
            this.f5233r0.g(str, this.L0);
            bluetoothGatt = this.f5233r0.i(str);
            this.f5234s0 = bluetoothGatt;
            try {
                synchronized (this.f36598l) {
                    if (this.f36587a) {
                        b.j(String.format("isConnectedCallbackCome=%b, mErrorState=0x%04X", Boolean.valueOf(this.f36597k), Integer.valueOf(this.C)));
                    }
                    if (!this.f36597k && this.C == 0) {
                        if (this.f36587a) {
                            b.c("wait for connect gatt for 32000 ms");
                        }
                        this.f36598l.wait(32000L);
                    }
                }
            } catch (InterruptedException e10) {
                e = e10;
                sb2 = new StringBuilder();
                sb2.append("Sleeping interrupted : ");
                sb2.append(e.toString());
                b.l(sb2.toString());
                this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                if (this.C == 0) {
                }
                if (this.C == 0) {
                }
                return this.C;
            }
        } else {
            bluetoothGatt = M.connectGatt(this.f36589c, false, this.L0);
            this.f5234s0 = bluetoothGatt;
            try {
                synchronized (this.f36598l) {
                    if (!this.f36597k && this.C == 0) {
                        if (this.f36587a) {
                            b.c("wait for connect gatt for 32000 ms");
                        }
                        this.f36598l.wait(32000L);
                    }
                }
            } catch (InterruptedException e11) {
                e = e11;
                sb2 = new StringBuilder();
                sb2.append("Sleeping interrupted : ");
                sb2.append(e.toString());
                b.l(sb2.toString());
                this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                if (this.C == 0) {
                }
                if (this.C == 0) {
                    b.j("connected the device which going to upgrade");
                }
                return this.C;
            }
        }
        if (this.C == 0) {
            if (!this.f36597k) {
                b.l("wait for connect, but can not connect with no callback");
                this.C = DfuException.ERROR_CONNECTION_TIMEOUT;
            } else if (bluetoothGatt == null || this.f36599m != 515) {
                b.l("connect with some error, please check. mConnectionState=" + this.f36599m);
                this.C = DfuException.ERROR_CONNECT_ERROR;
            }
        }
        if (this.C == 0 && this.f36587a) {
            b.j("connected the device which going to upgrade");
        }
        return this.C;
    }

    public final int S0(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.D0);
        this.G0 = service;
        if (service == null) {
            b.l("DFU_SERVICE not found:" + this.D0);
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        }
        if (this.f36587a) {
            b.c("find DFU_SERVICE: " + this.D0.toString());
        }
        BluetoothGattCharacteristic characteristic = this.G0.getCharacteristic(this.F0);
        this.H0 = characteristic;
        if (characteristic == null) {
            b.c("not found DFU_CONTROL_POINT_UUID: " + this.F0.toString());
            return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
        }
        if (this.f36587a) {
            b.c("find DFU_CONTROL_POINT_UUID: " + this.F0.toString());
        }
        this.H0.setWriteType(2);
        b.c(dl.c.b(this.H0.getProperties()));
        BluetoothGattCharacteristic characteristic2 = this.G0.getCharacteristic(this.E0);
        this.I0 = characteristic2;
        if (characteristic2 == null) {
            b.l("not found DFU_DATA_UUID: " + this.E0.toString());
            return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
        }
        if (this.f36587a) {
            b.c("find DFU_DATA_UUID: " + this.E0.toString());
        }
        this.I0.setWriteType(1);
        b.c(dl.c.b(this.I0.getProperties()));
        return 0;
    }

    public final void X0(BluetoothGatt bluetoothGatt) {
        BluetoothGattService service = bluetoothGatt.getService(this.f5243z0);
        this.A0 = service;
        if (service == null) {
            b.l("OTA_SERVICE not found: " + this.f5243z0.toString());
            return;
        }
        if (this.f36587a) {
            b.c("find OTA_SERVICE: " + this.f5243z0.toString());
        }
        BluetoothGattService bluetoothGattService = this.A0;
        UUID uuid = g.f25671a;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.B0 = characteristic;
        if (characteristic == null && this.I == 0) {
            b.l("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found: " + uuid);
        } else if (this.f36587a) {
            b.c("find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
            b.c(dl.c.b(this.B0.getProperties()));
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.B0;
        if (bluetoothGattCharacteristic != null) {
            bluetoothGattCharacteristic.setWriteType(1);
        }
        BluetoothGattService bluetoothGattService2 = this.A0;
        UUID uuid2 = g.f25672b;
        BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
        this.J0 = characteristic2;
        if (characteristic2 == null) {
            b.l("OTA_MAC_ADDR_CHARACTERISTIC_UUID not found:" + uuid2);
        } else if (this.f36587a) {
            b.c("find OTA_MAC_ADDR_CHARACTERISTIC_UUID = " + uuid2);
            b.c(dl.c.b(this.B0.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.A0;
        UUID uuid3 = g.f25676f;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
        this.C0 = characteristic3;
        if (characteristic3 == null) {
            b.l("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found:" + uuid3);
        } else if (this.f36587a) {
            b.c("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID: " + uuid3);
            b.c(dl.c.b(this.C0.getProperties()));
        }
        this.K0 = new ArrayList();
        for (int i10 = 65504; i10 < 65519; i10++) {
            UUID c10 = fl.b.c(i10);
            BluetoothGattCharacteristic characteristic4 = this.A0.getCharacteristic(c10);
            if (characteristic4 != null) {
                if (this.f36587a) {
                    b.j("find image version characteristic: " + c10.toString());
                }
                b.c(dl.c.b(characteristic4.getProperties()));
                this.K0.add(characteristic4);
            } else if (this.f36588b) {
                b.j("not found image version characteristic:" + c10.toString());
                return;
            } else {
                return;
            }
        }
    }

    public boolean Y0(int i10) {
        byte b10;
        String str;
        b.c(String.format("<< OPCODE_DFU_CHECK_CURRENT_BUFFER(0x0B) , crc=0x%04X", Integer.valueOf(i10)));
        a0(this.H0, new byte[]{11}, false);
        if (this.f36587a) {
            b.c("... waiting CHECK_CURRENT_BUFFER response");
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
        b.l(str);
        return false;
    }

    public void b1(int i10) {
        List<wl.a> list = this.f36608v;
        if (list != null) {
            wl.a aVar = null;
            Iterator<wl.a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                wl.a next = it.next();
                if (next.O() == i10) {
                    aVar = next;
                    break;
                }
            }
            if (aVar != null) {
                u0(aVar.O(), aVar.f36312l);
            }
        }
    }

    public void d1(int i10) {
        v0(i10, false);
    }

    public void e1(int i10) {
        int i11;
        int i12;
        if (this.f36587a) {
            b.c("<< OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06)");
        }
        a0(this.H0, new byte[]{6, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255)}, false);
        if (this.f36587a) {
            b.c("... Reading OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06) notification");
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
                b.c(String.format(Locale.US, "mOriginalFwVersion=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P), Integer.valueOf(this.P)));
                return;
            }
            this.P = wrap.getInt(i12);
            b.c(String.format(Locale.US, "mOriginalFwVersion=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P), Integer.valueOf(this.P)));
            return;
        }
        b.l(String.format("0x%02X, Get target image info failed", Integer.valueOf((int) DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
        throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public void g1(int i10) {
        b.c("<< OPCODE_DFU_VALIDATE_FW_IMAGE (0x03)");
        a0(this.H0, new byte[]{3, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255)}, false);
        int i11 = 10000;
        if ((v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 12) && u().i() > 2097152) {
            i11 = Math.max(((u().i() / 1048576) + 1) * 4 * 1000, 10000);
        }
        if (this.f36587a) {
            b.c("... waiting DFU_VALIDATE_FW_IMAGE response for " + i11);
        }
        byte b10 = f0(i11)[2];
        if (b10 != 1) {
            if (b10 == 5) {
                b.l(String.format("0x%02X, Validate FW failed, CRC check error", Byte.valueOf(b10)));
                throw new OtaException("Validate FW failed", DfuException.ERROR_REMOTE_CRC_ERROR);
            } else {
                b.l(String.format("0x%02X(not supported), Validate FW failed", Byte.valueOf(b10)));
                throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
            }
        }
    }

    @Override // bm.b
    public byte[] m0() {
        return f0(t().t());
    }

    public void o1() {
        B0(new byte[]{4});
    }

    public void p1() {
        List<BluetoothGattCharacteristic> list = this.K0;
        byte[] bArr = null;
        if (list == null || list.size() <= 0) {
            v().d0(null);
            b.k(this.f36588b, "no ImageVersionCharacteristics to read");
            return;
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.K0) {
            b.j(this.f36587a ? "read image version : " + bluetoothGattCharacteristic.getUuid().toString() : "read image version");
            byte[] c02 = c0(bluetoothGattCharacteristic);
            if (c02 != null) {
                if (bArr == null) {
                    bArr = c02;
                } else {
                    byte[] bArr2 = new byte[bArr.length + c02.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(c02, 0, bArr2, bArr.length, c02.length);
                    bArr = bArr2;
                }
            }
        }
        v().d0(bArr);
    }

    public void q0() {
        b.j("<< OPCODE_DFU_START_DFU(0x01)");
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
            b.j("... Reading OPCODE_DFU_START_DFU(0x01) notification");
        }
        byte b10 = m0()[2];
        if (b10 != 1) {
            b.l(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b10)));
            throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
    }

    public boolean q1() {
        if (this.C0 == null) {
            return false;
        }
        if (this.f36587a) {
            b.j("start to read remote dev info");
        }
        byte[] c02 = c0(this.C0);
        if (c02 != null) {
            v().Z(c02);
            b(v().B);
            return true;
        }
        b.l("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public void r0() {
        b.c("<< OPCODE_DFU_CONNECTION_PARAMETER_UPDATE(0x07)");
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
                b.c("... waiting OPCODE_DFU_CONNECTION_PARAMETER_UPDATE(0x07) response");
            }
            m0();
        } catch (DfuException e10) {
            b.l("ignore connection parameters update exception: " + e10.getMessage());
            this.C = 0;
        }
    }

    public boolean r1() {
        if (this.J0 == null) {
            return false;
        }
        if (this.f36587a) {
            b.j("start to read remote dev Mac Addr info");
        }
        byte[] c02 = c0(this.J0);
        if (c02 == null || c02.length < 6) {
            b.l("Get remote dev Mac Addr info failed, do nothing.");
            throw new OtaException("remote dev Mac Addr info error", DfuException.ERROR_READ_REMOTE_MAC_ADDR);
        }
        byte[] bArr = new byte[6];
        System.arraycopy(c02, 0, bArr, 0, 6);
        v().h0(bArr);
        return true;
    }

    public void s1() {
        b.c("<<  OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE(0x0A)");
        a0(this.H0, new byte[]{10}, false);
        if (this.f36587a) {
            b.c("... Reading OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE notification");
        }
        byte[] m02 = m0();
        byte b10 = m02[2];
        if (b10 == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(m02);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i10 = wrap.getInt(3);
            b.j(String.format(Locale.US, "maxBufferCheckSize=(0x%04X, %d)", Integer.valueOf(i10), Integer.valueOf(i10)));
            b(i10);
            return;
        }
        b.l("Get remote buffer size info failed, status: " + ((int) b10));
        throw new OtaException("Get remote buffer size info failed", b10 | 512);
    }

    public void t0(byte b10) {
        B0(new byte[]{4, b10});
    }

    public int t1() {
        if (this.H0 == null) {
            b.l("no mControlPointCharacteristic found");
            return 0;
        }
        b.c("<< OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE(0x09)");
        a0(this.H0, new byte[]{9}, false);
        try {
            if (this.f36587a) {
                b.c("... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            }
            byte[] f02 = f0(1600L);
            if (f02[2] == 1) {
                ByteBuffer wrap = ByteBuffer.wrap(f02);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i10 = (((short) (wrap.get(4) & 255)) << 8) | ((short) (wrap.get(3) & 255));
                int i11 = ((short) (wrap.get(5) & 255)) | (((short) (wrap.get(6) & 255)) << 8);
                if (this.f36587a) {
                    b.j("maxBufferSize=" + i10 + ", bufferCheckMtuSize=" + i11);
                }
                b(i10);
                d0(i11);
                return 1;
            }
        } catch (DfuException unused) {
            b.l("Read DFU_REPORT_OTA_FUNCTION_VERSION failed, just think remote is normal function.");
            this.C = 0;
        }
        return 0;
    }

    public void u0(int i10, int i11) {
        b.j(String.format("<< OPCODE_DFU_CHECK_IMAGE(0x%02X)", (byte) 13));
        a0(this.H0, new byte[]{13, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) (i11 & 255), (byte) ((i11 >> 8) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 24) & 255)}, false);
        if (this.f36587a) {
            b.j("... Reading OPCODE_DFU_CHECK_IMAGE notification");
        }
        byte b10 = m0()[2];
        if (b10 != 1) {
            b.l(String.format("0x%02X: check image failed", Byte.valueOf(b10)));
            throw new OtaException("check image failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
    }

    public int u1() {
        byte[] f02;
        byte b10;
        if (this.H0 == null) {
            b.l("no mControlPointCharacteristic found");
            return 0;
        }
        b.j("<< OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION(0x09)");
        a0(this.H0, new byte[]{9}, false);
        try {
            if (this.f36587a) {
                b.c("Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification");
            }
            f02 = f0(1600L);
            b10 = f02[2];
        } catch (DfuException unused) {
            b.l("Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification failed, just think remote is normal function.");
            this.C = 0;
        }
        if (b10 == 1) {
            ByteBuffer.wrap(f02).order(ByteOrder.LITTLE_ENDIAN);
            return 1;
        }
        b.l("reportOtaFunctionVersion failed, status: " + ((int) b10));
        return 0;
    }

    public void v0(int i10, boolean z10) {
        if (this.f36594h) {
            i10 = 4128;
        }
        if (i10 != 4128) {
            E(DfuException.ERROR_CONNECTION_TIMEOUT, true);
        }
        b.j(String.format("error = 0x%04X, needReset=%b", Integer.valueOf(i10), Boolean.valueOf(z10)));
        if (z10) {
            v1();
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

    public boolean v1() {
        try {
            b.d(this.f36587a, "<< OPCODE_DFU_RESET_SYSTEM (0x05)");
            return a0(this.H0, new byte[]{5}, true);
        } catch (DfuException e10) {
            b.l(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e10.getErrCode())));
            this.C = 0;
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
        if (r4 != (u().f() + 12)) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f A[Catch: IOException -> 0x01ff, TryCatch #0 {IOException -> 0x01ff, blocks: (B:13:0x004e, B:15:0x0053, B:17:0x005e, B:18:0x006b, B:20:0x006f, B:22:0x0084, B:24:0x008b, B:25:0x0092, B:27:0x0099, B:28:0x00a2, B:29:0x00a6, B:30:0x00b8, B:32:0x00bc, B:34:0x00c0, B:35:0x00cf, B:37:0x00d9, B:39:0x00e5), top: B:76:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc A[Catch: IOException -> 0x01ff, TRY_LEAVE, TryCatch #0 {IOException -> 0x01ff, blocks: (B:13:0x004e, B:15:0x0053, B:17:0x005e, B:18:0x006b, B:20:0x006f, B:22:0x0084, B:24:0x008b, B:25:0x0092, B:27:0x0099, B:28:0x00a2, B:29:0x00a6, B:30:0x00b8, B:32:0x00bc, B:34:0x00c0, B:35:0x00cf, B:37:0x00d9, B:39:0x00e5), top: B:76:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9 A[Catch: IOException -> 0x01ff, TryCatch #0 {IOException -> 0x01ff, blocks: (B:13:0x004e, B:15:0x0053, B:17:0x005e, B:18:0x006b, B:20:0x006f, B:22:0x0084, B:24:0x008b, B:25:0x0092, B:27:0x0099, B:28:0x00a2, B:29:0x00a6, B:30:0x00b8, B:32:0x00bc, B:34:0x00c0, B:35:0x00cf, B:37:0x00d9, B:39:0x00e5), top: B:76:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, wl.a aVar) {
        int i10;
        int i11;
        int i12;
        b.j("uploadFirmwareWithBufferCheck");
        this.C = 0;
        this.f36606t = false;
        int i13 = 0;
        while (!this.f36606t) {
            if (!this.f36594h) {
                int i14 = this.R;
                byte[] bArr = new byte[i14];
                int i15 = i13;
                while (true) {
                    if (this.f36587a) {
                        b.j(String.format(Locale.US, "mCurrentMaxBufferSize=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.R), Integer.valueOf(this.P), Integer.valueOf(this.P)));
                    }
                    if (i15 <= 0) {
                        try {
                            int i16 = this.P;
                            if (i16 != -1) {
                            }
                            i10 = this.P;
                            if (i10 != 0) {
                                System.arraycopy(this.f36609w.E(), 0, bArr, 0, 12);
                                int i17 = i14 - 12;
                                byte[] bArr2 = new byte[i17];
                                int i02 = this.f36609w.i0(bArr2, i17);
                                if (i02 > 0) {
                                    System.arraycopy(bArr2, 0, bArr, 12, i02);
                                    i11 = i02 + 12;
                                } else {
                                    i11 = 12;
                                }
                                u().c(12);
                            } else if (i10 == 12) {
                                i11 = this.f36609w.i0(bArr, i14 - 12);
                            } else {
                                i11 = this.f36609w.i0(bArr, Math.min(this.R, this.f36609w.k0()));
                                if (this.f36587a) {
                                    b.c(String.format(Locale.US, "checkImageBufferSize=%d", Integer.valueOf(i11)));
                                }
                                if (u().o() < i11) {
                                    i11 = u().o();
                                    if (this.f36587a) {
                                        b.j("reach bottom, only read some,  checkImageBufferSize: " + i11);
                                    }
                                }
                                i12 = i11;
                                if (this.f36587a) {
                                    b.c(u().toString());
                                }
                                if (i12 > 0) {
                                    byte[] bArr3 = new byte[this.R];
                                    int i18 = this.S;
                                    byte[] bArr4 = new byte[i18];
                                    int i19 = 0;
                                    while (i19 < i12) {
                                        int min = Math.min(i18, i12 - i19);
                                        System.arraycopy(bArr, i19, bArr4, 0, min);
                                        if (v().N()) {
                                            int i20 = 0;
                                            while (true) {
                                                if (i20 < min) {
                                                    int min2 = Math.min(min - i20, 16);
                                                    if (min2 < 16) {
                                                        b.d(this.f36588b, "encryptSize < 16, no need to encrypt:" + min2);
                                                        break;
                                                    }
                                                    System.arraycopy(this.B.a(bArr4, i20, 16), 0, bArr4, i20, 16);
                                                    i20 += 16;
                                                    if (v().r() == 0) {
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                        int i21 = i19;
                                        Y(bluetoothGatt, bluetoothGattCharacteristic, bArr4, min, false);
                                        System.arraycopy(bArr4, 0, bArr3, i21, min);
                                        i19 = i21 + min;
                                        O();
                                    }
                                    boolean K0 = K0(bArr3, i12);
                                    if (!K0) {
                                        u().b(0 - i12);
                                        i15++;
                                        b.l("check failed, retransTimes: " + i15);
                                    } else {
                                        i15 = 0;
                                    }
                                    if (i15 < 3) {
                                        if (K0) {
                                            break;
                                        }
                                    } else {
                                        b.l("Error while buffer check, reach max try times: " + i15 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                                        throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                                    }
                                } else if (u().t()) {
                                    b.g("image file has already been send over");
                                } else {
                                    b.l("Error while reading file with size: " + i12);
                                    throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                                }
                            }
                            u().y(0);
                            if (this.f36587a) {
                            }
                            if (u().o() < i11) {
                            }
                            i12 = i11;
                            if (this.f36587a) {
                            }
                            if (i12 > 0) {
                            }
                        } catch (IOException unused) {
                            throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                        }
                    }
                    b.c("the last sent to remote may not alignment, reinstall input stream");
                    Q();
                    i(this.P, true);
                    i10 = this.P;
                    if (i10 != 0) {
                    }
                    u().y(0);
                    if (this.f36587a) {
                    }
                    if (u().o() < i11) {
                    }
                    i12 = i11;
                    if (this.f36587a) {
                    }
                    if (i12 > 0) {
                    }
                }
                i13 = i15;
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }
}
