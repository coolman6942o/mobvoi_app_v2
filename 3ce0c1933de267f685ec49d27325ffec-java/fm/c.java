package fm;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import bm.d;
import bm.e;
import bm.f;
import bm.g;
import bm.h;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import il.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public abstract class c extends bm.c {
    public BluetoothGattCharacteristic J0;
    public List<BluetoothGattCharacteristic> K0;
    public List<BluetoothGattCharacteristic> L0;
    public final BluetoothGattCallback M0 = new a();

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
                        b.c(String.format("disconnect in OTA process, mErrorState:0x%04X ", Integer.valueOf(cVar2.C)));
                    }
                    c.this.s();
                }
                c.this.G(0);
            }
            synchronized (c.this.f36598l) {
                c cVar3 = c.this;
                if (cVar3.f36599m != 256) {
                    cVar3.f36597k = true;
                }
                c.this.f36598l.notifyAll();
            }
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
                return;
            }
            if (i10 == 0) {
                cVar.O0(bluetoothGatt);
                c.this.K0(bluetoothGatt);
                c.this.G(515);
                c.this.A();
            } else {
                cVar.C = i10 | 2048;
            }
            synchronized (c.this.f36598l) {
                c cVar2 = c.this;
                if (cVar2.f36599m == 515) {
                    cVar2.f36597k = true;
                }
                c.this.f36598l.notifyAll();
            }
        }
    }

    public c(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
    }

    public void A0(byte[] bArr) {
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
            b.g("image active success");
            i0(this.C);
            m(this.f36609w);
            return;
        }
        throw new OtaException(i10);
    }

    public boolean C0(wl.a aVar, int i10, int i11, int i12) {
        int i13;
        if (aVar.C == 0) {
            return false;
        }
        b.k(this.f36587a, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(aVar.k0()), Integer.valueOf(i11), Integer.valueOf(i12)));
        if (aVar.C == 1) {
            i13 = aVar.k0();
        } else if (i10 < 0 || i10 >= this.f36608v.size()) {
            i13 = 0;
        } else {
            int i14 = 0;
            for (int i15 = i10; i15 < this.f36608v.size(); i15++) {
                wl.a aVar2 = this.f36608v.get(i15);
                if (aVar2.C != aVar.C) {
                    break;
                }
                i14 += aVar2.k0();
            }
            i13 = i14;
        }
        return i13 + i11 > i12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r5 != (u().f() + 12)) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[Catch: IOException -> 0x01f7, TryCatch #0 {IOException -> 0x01f7, blocks: (B:10:0x004c, B:12:0x0051, B:14:0x005c, B:15:0x0069, B:17:0x006d, B:19:0x0082, B:21:0x0089, B:22:0x0090, B:24:0x0097, B:25:0x00a0, B:26:0x00a4, B:27:0x00b6, B:29:0x00ba, B:31:0x00d3), top: B:68:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3 A[Catch: IOException -> 0x01f7, TRY_LEAVE, TryCatch #0 {IOException -> 0x01f7, blocks: (B:10:0x004c, B:12:0x0051, B:14:0x005c, B:15:0x0069, B:17:0x006d, B:19:0x0082, B:21:0x0089, B:22:0x0090, B:24:0x0097, B:25:0x00a0, B:26:0x00a4, B:27:0x00b6, B:29:0x00ba, B:31:0x00d3), top: B:68:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0103 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, wl.a aVar) {
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
                    boolean z10 = this.f36587a;
                    Locale locale = Locale.US;
                    b.k(z10, String.format(locale, "mCurrentMaxBufferSize=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.R), Integer.valueOf(this.P), Integer.valueOf(this.P)));
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
                                b.d(this.f36587a, String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
                                if (u().o() < i11) {
                                    i11 = u().o();
                                    b.k(this.f36587a, "reach bottom, only read some,  checkImageBufferSize: " + i11);
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
                                    boolean I0 = I0(bArr3, i12);
                                    if (!I0) {
                                        u().b(0 - i12);
                                        i15++;
                                        b.l("check failed, retransTimes: " + i15);
                                    } else {
                                        i15 = 0;
                                    }
                                    if (i15 < 3) {
                                        if (I0) {
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
                            b.d(this.f36587a, String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
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
                    b.d(this.f36587a, String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
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

    public boolean I0(byte[] bArr, int i10) {
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

    public final int K0(BluetoothGatt bluetoothGatt) {
        StringBuilder sb2;
        UUID uuid;
        try {
            this.f5243z0 = UUID.fromString(t().u());
            this.D0 = UUID.fromString(t().g());
            this.E0 = UUID.fromString(t().f());
            this.F0 = UUID.fromString(t().e());
        } catch (Exception e10) {
            b.l(e10.toString());
        }
        BluetoothGattService service = bluetoothGatt.getService(this.D0);
        this.G0 = service;
        if (service == null) {
            b.c("DFU_SERVICE not found:" + this.D0);
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        }
        if (this.f36587a) {
            b.c("find DFU_SERVICE: " + this.D0.toString());
        }
        BluetoothGattCharacteristic characteristic = this.G0.getCharacteristic(this.F0);
        this.H0 = characteristic;
        if (characteristic == null) {
            sb2 = new StringBuilder();
            sb2.append("not found DFU_CONTROL_POINT_UUID: ");
            uuid = this.F0;
        } else {
            if (this.f36587a) {
                b.c("find DFU_CONTROL_POINT_UUID: " + this.F0.toString());
            }
            this.H0.setWriteType(2);
            b.c(dl.c.b(this.H0.getProperties()));
            BluetoothGattCharacteristic characteristic2 = this.G0.getCharacteristic(this.E0);
            this.I0 = characteristic2;
            if (characteristic2 == null) {
                sb2 = new StringBuilder();
                sb2.append("not found DFU_DATA_UUID: ");
                uuid = this.E0;
            } else {
                if (this.f36587a) {
                    b.c("find DFU_DATA_UUID: " + this.E0.toString());
                }
                this.I0.setWriteType(1);
                b.c(dl.c.b(this.I0.getProperties()));
                return 0;
            }
        }
        sb2.append(uuid.toString());
        b.c(sb2.toString());
        return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int L0(String str) {
        BluetoothDevice bluetoothDevice;
        int i10;
        StringBuilder sb2;
        G(256);
        this.C = 0;
        this.f36597k = false;
        if (this.f36587a) {
            b.c("Connecting to device..." + fl.a.c(str, true));
        }
        BluetoothGatt bluetoothGatt = null;
        try {
            bluetoothDevice = this.f37629k0.getRemoteDevice(str);
        } catch (Exception e10) {
            b.l(e10.toString());
            bluetoothDevice = null;
        }
        al.c cVar = this.f5233r0;
        if (cVar != null) {
            cVar.p(str, this.M0);
            this.f5233r0.g(str, this.M0);
            bluetoothGatt = this.f5233r0.i(str);
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
                }
                return this.C;
            }
        } else if (bluetoothDevice != null) {
            bluetoothGatt = bluetoothDevice.connectGatt(this.f36589c, false, this.M0);
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
            } catch (InterruptedException e12) {
                e = e12;
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
        } else {
            b.l("device is null");
            this.f5234s0 = null;
        }
        if (this.C == 0) {
            if (!this.f36597k) {
                b.l("wait for connect, but can not connect with no callback");
                i10 = DfuException.ERROR_CONNECTION_TIMEOUT;
            } else if (bluetoothGatt == null || this.f36599m != 515) {
                b.l("connect with some error, please check. mConnectionState=" + this.f36599m);
                i10 = DfuException.ERROR_CONNECT_ERROR;
            }
            this.C = i10;
        }
        if (this.C == 0 && this.f36587a) {
            b.j("connected the device which going to upgrade");
        }
        return this.C;
    }

    public final void O0(BluetoothGatt bluetoothGatt) {
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
        UUID uuid = f.f27087a;
        BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(uuid);
        this.B0 = characteristic;
        if (characteristic == null) {
            b.l("OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC not found: " + uuid);
        } else {
            if (this.f36587a) {
                b.c("find OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC = " + uuid);
                b.c(dl.c.b(this.B0.getProperties()));
            }
            this.B0.setWriteType(1);
        }
        BluetoothGattService bluetoothGattService2 = this.A0;
        UUID uuid2 = f.f27088b;
        BluetoothGattCharacteristic characteristic2 = bluetoothGattService2.getCharacteristic(uuid2);
        this.J0 = characteristic2;
        if (characteristic2 == null) {
            b.l("OTA_MAC_ADDR_CHARACTERISTIC_UUID not found:" + uuid2);
        } else if (this.f36587a) {
            b.c("find OTA_MAC_ADDR_CHARACTERISTIC_UUID = " + uuid2);
            b.c(dl.c.b(this.B0.getProperties()));
        }
        BluetoothGattService bluetoothGattService3 = this.A0;
        UUID uuid3 = f.f27089c;
        BluetoothGattCharacteristic characteristic3 = bluetoothGattService3.getCharacteristic(uuid3);
        this.C0 = characteristic3;
        if (characteristic3 == null) {
            b.l("OTA_DEVICE_INFO_CHARACTERISTIC_UUID not found:" + uuid3);
        } else if (this.f36587a) {
            b.c("find OTA_DEVICE_INFO_CHARACTERISTIC_UUID: " + uuid3);
            b.c(dl.c.b(this.C0.getProperties()));
        }
        this.K0 = new ArrayList();
        int i10 = 65504;
        while (true) {
            if (i10 >= 65519) {
                break;
            }
            UUID c10 = fl.b.c(i10);
            BluetoothGattCharacteristic characteristic4 = this.A0.getCharacteristic(c10);
            if (characteristic4 != null) {
                if (this.f36588b) {
                    b.j("find image version characteristic: " + c10.toString());
                }
                this.K0.add(characteristic4);
                i10++;
            } else if (this.f36588b) {
                b.j("not found image version characteristic:" + c10.toString());
            }
        }
        this.L0 = new ArrayList();
        for (int i11 = 65524; i11 < 65526; i11++) {
            UUID c11 = fl.b.c(i11);
            BluetoothGattCharacteristic characteristic5 = this.A0.getCharacteristic(c11);
            if (characteristic5 != null) {
                if (this.f36587a) {
                    b.c("find image session size characteristic: " + c11.toString());
                }
                this.L0.add(characteristic5);
            } else if (this.f36587a) {
                b.c("not found image session size characteristic:" + c11.toString());
                return;
            } else {
                return;
            }
        }
    }

    public void S0(int i10) {
        v0(i10, false);
    }

    public void V0(int i10) {
        u0(i10, this.P);
        int f10 = u().f();
        int i11 = this.P;
        if (f10 != i11 && i11 != -1) {
            b.c("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
    }

    public void f1() {
        A0(new byte[]{4, 0});
    }

    public boolean g1() {
        if (this.H0 == null) {
            b.m(this.f36587a, "no mControlPointCharacteristic found");
            return false;
        }
        b.d(this.f36587a, "<< OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE(0x09)");
        a0(this.H0, new byte[]{9}, false);
        try {
            b.k(this.f36588b, "... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            d a10 = d.a(v().f5995a, v().f6005k, f0(1600L));
            if (a10 != null && a10.b()) {
                b(a10.f5246c);
                d0(a10.f5247d ? a10.f5248e : v().V);
            }
            return true;
        } catch (DfuException unused) {
            b.l("enableBufferCheck failed, just think remote is normal function.");
            this.C = 0;
            return false;
        }
    }

    public void h1() {
        List<BluetoothGattCharacteristic> list = this.K0;
        if (list == null || list.size() <= 0) {
            b.d(this.f36587a, "no ImageVersionCharacteristics to read");
            v().d0(null);
            return;
        }
        v().d0(null);
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.K0) {
            if (this.f36588b) {
                b.j("read image version : " + bluetoothGattCharacteristic.getUuid().toString());
            }
            byte[] c02 = c0(bluetoothGattCharacteristic);
            if (c02 != null) {
                v().g(c02);
            }
        }
    }

    public boolean i1() {
        if (this.C0 == null) {
            return false;
        }
        if (this.f36587a) {
            b.j("start to read remote device info");
        }
        byte[] c02 = c0(this.C0);
        if (c02 == null) {
            if (this.f36587a) {
                b.j("read device info failed");
            }
            throw new OtaException("read remote device info failed", 270);
        }
        v().b0(c02);
        b(v().B);
        return true;
    }

    public boolean j1() {
        if (this.J0 == null) {
            return false;
        }
        if (this.f36587a) {
            b.j("start to read remote dev Mac Addr info");
        }
        byte[] c02 = c0(this.J0);
        if (c02 != null) {
            if (c02.length >= 6) {
                byte[] bArr = new byte[6];
                System.arraycopy(c02, 0, bArr, 0, 6);
                v().h0(bArr);
            }
            if (c02.length < 12) {
                return true;
            }
            byte[] bArr2 = new byte[6];
            System.arraycopy(c02, 6, bArr2, 0, 6);
            v().p0(bArr2);
            return true;
        }
        b.l("Get remote dev Mac Addr info failed, do nothing.");
        throw new OtaException("remote dev Mac Addr info error", DfuException.ERROR_READ_REMOTE_MAC_ADDR);
    }

    public void k1() {
        List<BluetoothGattCharacteristic> list = this.L0;
        byte[] bArr = null;
        if (list == null || list.size() <= 0) {
            b.d(this.f36587a, "no ImageSectionCharacteristics to read");
            v().i0(null);
            return;
        }
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : this.L0) {
            if (this.f36588b) {
                b.j("read image section size : " + bluetoothGattCharacteristic.getUuid().toString());
            }
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
        v().i0(bArr);
    }

    public void l1() {
        if (!this.f36594h) {
            boolean z10 = this.f36587a;
            b.d(z10, "isBufferCheckEnabled=" + v().Q());
            this.O = (!v().Q() || !g1()) ? 0 : 1;
            boolean z11 = this.f36588b;
            b.k(z11, "mRemoteOtaFunctionInfo=" + this.O);
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public boolean m1() {
        try {
            b.d(this.f36587a, "<< OPCODE_DFU_RESET_SYSTEM (0x05)");
            return a0(this.H0, new byte[]{5}, true);
        } catch (DfuException e10) {
            b.l(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e10.getErrCode())));
            this.C = 0;
            return false;
        }
    }

    public void q0() {
        byte[] bArr = new byte[16];
        System.arraycopy(this.f36609w.x(), 0, bArr, 0, 12);
        g.b bVar = new g.b(v().f6005k);
        if (v().N()) {
            bVar.a(this.B.a(bArr, 0, 16));
        } else {
            bVar.a(bArr);
        }
        g b10 = bVar.b();
        if (this.f36587a) {
            b.c(b10.toString());
        }
        a0(this.H0, b10.a(), false);
        if (this.f36587a) {
            b.j("... Reading OPCODE_DFU_START_DFU(0x01) notification");
        }
        byte b11 = m0()[2];
        if (b11 != 1) {
            b.l(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b11)));
            throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
    }

    public int r0(String str, int i10) {
        int i11 = 0;
        while (e()) {
            int L0 = L0(str);
            if (L0 == 0) {
                return 0;
            }
            if ((L0 & (-2049)) != 133) {
                e0(this.f5234s0);
            } else {
                b.l("connect fail with GATT_ERROR, do not need disconnect");
            }
            R(this.f5234s0);
            try {
                Thread.sleep(1600L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            i11++;
            b.c("tryConnectTime=" + i11);
            if (i11 > i10) {
                return L0;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public void s0(byte b10) {
        A0(new byte[]{4, b10});
    }

    public void t0(int i10, byte b10) {
        h c10 = new h.b(v().f5995a, v().f6005k).b(i10).a(b10).c();
        if (this.f36587a) {
            b.c(c10.toString());
        }
        a0(this.H0, c10.a(), false);
        if (this.f36587a) {
            b.j("... waiting DFU_VALIDATE_FW_IMAGE response");
        }
        byte b11 = m0()[2];
        if (b11 != 1) {
            Object[] objArr = new Object[1];
            if (b11 == 5) {
                objArr[0] = Byte.valueOf(b11);
                b.l(String.format("0x%02X, Validate FW failed, CRC check error", objArr));
                throw new OtaException("Validate FW failed", DfuException.ERROR_REMOTE_CRC_ERROR);
            }
            objArr[0] = Byte.valueOf(b11);
            b.l(String.format("0x%02X(not supported), Validate FW failed", objArr));
            throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
    }

    public void u0(int i10, int i11) {
        e b10 = new e.b(v().f6005k).a(i10).c(i11).b();
        if (this.f36587a) {
            b.c(b10.toString());
        }
        a0(this.H0, b10.a(), false);
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
            m1();
        }
        this.f5230o0.o();
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

    public void w0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, wl.a aVar) {
        int i10;
        l();
        this.C = 0;
        this.f36606t = false;
        int i11 = this.K;
        byte[] bArr = new byte[i11];
        while (!this.f36606t) {
            if (!this.f36594h) {
                H();
                if (this.f36587a) {
                    b.j(u().toString());
                }
                try {
                    if (u().f() == 0) {
                        int i12 = this.K;
                        byte[] bArr2 = new byte[i12];
                        aVar.i0(bArr2, i12 - 12);
                        System.arraycopy(aVar.E(), 0, bArr, 0, 12);
                        System.arraycopy(bArr2, 0, bArr, 12, this.K - 12);
                        i10 = this.K;
                    } else {
                        i10 = aVar.i0(bArr, i11);
                    }
                    if (u().o() < this.K) {
                        b.j("reach the end of the file, only read some");
                        i10 = u().o();
                    }
                    int i13 = i10;
                    if (i13 > 0) {
                        if (v().N()) {
                            for (int i14 = i13; i14 > 0; i14 -= 16) {
                                if (i14 >= 16) {
                                    int i15 = i13 - i14;
                                    System.arraycopy(this.B.a(bArr, i15, 16), 0, bArr, i15, 16);
                                    if (v().r() == 0) {
                                        break;
                                    }
                                }
                            }
                        }
                        Y(bluetoothGatt, bluetoothGattCharacteristic, bArr, i13, false);
                        O();
                        k();
                    } else if (u().t()) {
                        b.c("image file has already been send over");
                        return;
                    } else {
                        b.l("Error while reading file with size: " + i13);
                        throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                    }
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }
}
