package gm;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cm.d;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import wl.a;
import xl.b;
/* loaded from: classes2.dex */
public class c extends b {
    public c(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
    }

    public final boolean A1() {
        if (this.C0 == null) {
            return false;
        }
        if (this.f36588b) {
            il.b.j("start to read remote dev info");
        }
        byte[] c02 = c0(this.C0);
        if (c02 != null) {
            v().T(c02);
            b(v().B);
            return true;
        }
        il.b.l("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0194, code lost:
        if (r6.O == 1) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01a4, code lost:
        if (r6.O == 1) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a6, code lost:
        w0(r6.f5234s0, r6.I0, r6.f36609w);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b0, code lost:
        F1(r6.f5234s0, r6.I0, r6.f36609w);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean B1() {
        if (!e()) {
            v0(DfuException.ERROR_DFU_ABORTED, true);
            return false;
        } else if (!v().N() || j()) {
            D(521);
            if (this.f36587a) {
                il.b.j(u().toString());
            }
            S(this.f5234s0, this.H0, true);
            if (Build.VERSION.SDK_INT >= 23) {
                W(this.f5234s0, 256);
            }
            n0();
            if (v().f6004j <= 3) {
                this.O = t1();
                if (this.f36588b) {
                    il.b.j("mRemoteOtaFunctionInfo=" + this.O);
                }
                if (this.O == 1) {
                    s1();
                }
            } else {
                if (!v().Q()) {
                    this.O = 0;
                } else {
                    this.O = p1();
                }
                if (this.f36588b) {
                    il.b.j("mRemoteOtaFunctionInfo=" + this.O);
                }
            }
            r0();
            u().D();
            c1(u().g());
            if (!t().G()) {
                this.P = 0;
                il.b.c(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.P)));
            }
            if (this.P == 0) {
                q0();
            }
            if (this.P - 12 >= u().i()) {
                il.b.c("Last send reach the bottom");
            } else if (v().f6004j <= 3) {
                J1(u().g());
                if (this.O == 1) {
                    D1(this.f5234s0, this.I0, this.f36609w);
                } else {
                    E1(this.f5234s0, this.I0, this.f36609w);
                }
            } else if (v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) {
                I1(u().g());
            } else {
                I1(u().g());
            }
            u().v();
            d1(u().g());
            return true;
        } else {
            a1(4113);
            return false;
        }
    }

    public final int C1(String str, int i10) {
        int i11 = 0;
        while (e()) {
            int N0 = N0(str);
            if (N0 == 0) {
                return 0;
            }
            if ((N0 & (-2049)) != 133) {
                e0(this.f5234s0);
            } else {
                il.b.l("connect fail with GATT_ERROR, do not need disconnect");
            }
            R(this.f5234s0);
            try {
                Thread.sleep(1600L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            i11++;
            il.b.c("tryConnectTime=" + i11);
            if (i11 >= i10) {
                return N0;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public final void D1(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, a aVar) {
        int i10;
        if (this.f36587a) {
            il.b.c(String.format(Locale.US, "updateImageWithCheckBufferForBee1, packetSize=%d, mCurrentMaxBufferSize=%d", Integer.valueOf(this.K), Integer.valueOf(this.R)));
        }
        this.C = 0;
        this.f36606t = false;
        int i11 = this.K;
        byte[] bArr = new byte[i11];
        byte[] bArr2 = new byte[this.R];
        while (!this.f36606t) {
            if (!this.f36594h) {
                d(aVar);
                if (this.f36587a) {
                    il.b.j(u().toString());
                }
                try {
                    int read = aVar.read(bArr2);
                    if (u().o() < read) {
                        read = u().o();
                        if (this.f36587a) {
                            il.b.c("Reach the bottom of the image,  checkImageBufferSize: " + read);
                        }
                    }
                    int i12 = read;
                    byte[] bArr3 = new byte[this.R];
                    int i13 = 0;
                    while (true) {
                        int i14 = 0;
                        while (i14 < i12) {
                            int min = Math.min(i11, i12 - i14);
                            System.arraycopy(bArr2, i14, bArr, 0, min);
                            if (v().N() && min >= 16) {
                                System.arraycopy(this.B.a(bArr, 0, 16), 0, bArr, 0, 16);
                            } else if (min <= 0) {
                                il.b.e("Error while reading file with bufferSize= " + min);
                                throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                            }
                            System.arraycopy(bArr, 0, bArr3, i14, min);
                            i14 += min;
                            Y(bluetoothGatt, bluetoothGattCharacteristic, bArr, min, false);
                            O();
                        }
                        if (this.f36588b) {
                            il.b.j("pos: " + i14 + ", checkImageBufferSize: " + i12);
                        }
                        boolean X0 = X0(ml.a.a(bArr2, 0, i12));
                        if (!X0) {
                            u().b(0 - i12);
                            i10 = i13 + 1;
                            il.b.l("check failed, retransBufferCheckTimes: " + i10);
                        } else {
                            i10 = i13;
                        }
                        A0(X0);
                        if (i10 >= 3) {
                            il.b.l("Error while buffer check, reach max try times: " + i10 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                            throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                        } else if (X0) {
                            break;
                        } else {
                            i13 = i10;
                        }
                    }
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final void E1(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, a aVar) {
        l();
        this.C = 0;
        this.f36606t = false;
        int i10 = this.K;
        byte[] bArr = new byte[i10];
        while (!this.f36606t) {
            if (!this.f36594h) {
                d(aVar);
                if (this.f36587a) {
                    il.b.j(u().toString());
                }
                H();
                try {
                    int i02 = aVar.i0(bArr, i10);
                    if (u().o() < this.K) {
                        if (this.f36587a) {
                            il.b.j("reach the end of the file, only read some");
                        }
                        i02 = u().o();
                    }
                    int i11 = i02;
                    if (i11 > 0) {
                        if (v().N()) {
                            for (int i12 = i11; i12 > 0; i12 -= 16) {
                                if (i12 >= 16) {
                                    int i13 = i11 - i12;
                                    System.arraycopy(this.B.a(bArr, i13, 16), 0, bArr, i13, 16);
                                    if (v().r() == 0) {
                                        break;
                                    }
                                }
                            }
                        }
                        Y(bluetoothGatt, bluetoothGattCharacteristic, bArr, i11, false);
                        O();
                        k();
                    } else if (u().t()) {
                        il.b.c("image file has already been send over");
                        return;
                    } else {
                        il.b.e("Error while reading file with size: " + i11);
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

    public final void F1(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, a aVar) {
        int i10;
        il.b.j("uploadFirmwareImageForBeeUpdate");
        l();
        this.C = 0;
        this.f36606t = false;
        int i11 = this.K;
        byte[] bArr = new byte[i11];
        while (!this.f36606t) {
            if (!this.f36594h) {
                H();
                if (this.f36587a) {
                    il.b.j(u().toString());
                }
                try {
                    if (this.P == 0) {
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
                        il.b.j("reach the end of the file, only read some");
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
                        il.b.g("image file has already been send over");
                        return;
                    } else {
                        il.b.e("Error while reading file with size: " + i13);
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

    public final void G1(String str) {
        if (!this.f36594h) {
            D(DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR);
            int C1 = C1(str, t().B());
            if (C1 != 0) {
                if (C1 == 4128) {
                    throw new OtaException("aborted, connectRemoteDevice failed", C1);
                }
                throw new OtaException("connectOtaRemoteDevice failed", C1);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void H1(String str) {
        if (!this.f36594h) {
            D(516);
            int C1 = C1(str, t().B());
            if (C1 != 0) {
                if (C1 != 4128) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new CompatScanFilter.b().c(str).b());
                    ScannerParams k02 = k0();
                    k02.s(arrayList);
                    k02.r(str);
                    L(k02);
                    int C12 = C1(str, t().B());
                    if (C12 != 0) {
                        if (C12 == 4128) {
                            throw new OtaException("aborted, connectRemoteDevice failed", C12);
                        }
                        throw new OtaException("connectRemoteDevice failed", C12);
                    }
                    return;
                }
                throw new OtaException("aborted, connectRemoteDevice failed", C1);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void I1(int i10) {
        String str;
        int i11 = this.P;
        if (i11 == 0) {
            this.P = 12;
            if (this.f36587a) {
                str = String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", 12, Integer.valueOf(this.P));
                il.b.j(str);
            }
        } else if (this.f36587a) {
            str = String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P));
            il.b.j(str);
        }
        u0(i10, this.P);
        if (this.P != u().f() + 12 && this.P != -1) {
            if (this.f36587a) {
                il.b.c(String.format(Locale.US, "mBytesSent(%d) != mImageUpdateOffset(%d), reload image bin file", Integer.valueOf(u().f() + 12), Integer.valueOf(this.P)));
            }
            Q();
            i(this.P, false);
        }
    }

    public final void J1(int i10) {
        int i11 = this.P;
        if (i11 == 0) {
            i11 = 12;
        }
        u0(i10, i11);
        if (u().f() != this.P) {
            il.b.c("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
        if (this.f36587a) {
            il.b.j(u().toString());
        }
    }

    @Override // xl.a
    public boolean h(boolean z10) {
        if (!super.h(z10)) {
            return false;
        }
        if (this.f36599m != 515) {
            if (this.f36587a) {
                il.b.c("start to re-connect the RCU which going to active image, current state is: " + this.f36599m);
            }
            int C1 = C1(this.E, t().B());
            if (C1 != 0) {
                il.b.e("Something error in OTA process, errorCode: " + C1 + "mProcessState" + this.f36607u);
                v0(C1, true);
                return false;
            }
        }
        if (z10) {
            try {
                o1();
                n1();
                D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            } catch (DfuException e10) {
                a1(e10.getErrCode());
            }
        } else {
            if (u1()) {
                I();
            }
            v0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, false);
        }
        return true;
    }

    @Override // xl.a
    public void q() {
        int y10;
        super.q();
        try {
            setName("ProcessorXG0000N");
            il.b.c("ProcessorXG0000N running.");
            y10 = y();
        } catch (Exception e10) {
            il.b.e(e10.toString());
            a1(0);
        }
        if (y10 != 0) {
            a1(y10);
            return;
        }
        y1();
        m(this.f36609w);
        if (this.f36587a) {
            il.b.c("ProcessorXG0000N stopped");
        }
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final int v1() {
        if (this.A0 == null) {
            il.b.l("OTA SERVICE not found:" + this.f5243z0.toString());
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        } else if (this.B0 != null) {
            return 0;
        } else {
            il.b.l("not found OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC : " + h.f27508a.toString());
            return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
        }
    }

    public final boolean w1() {
        if (this.f36596j) {
            if (TextUtils.isEmpty(this.E)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(((v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 13 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) ? new CompatScanFilter.b().f(t().s(), v().u()) : new CompatScanFilter.b().f(t().s(), xl.a.n(this.F))).b());
                ScannerParams k02 = k0();
                k02.s(arrayList);
                U(k02, 31000L);
            }
            G1(this.E);
            if (!this.f36595i) {
                z1();
            } else {
                P();
            }
            if (this.f36609w == null) {
                a1(4097);
                return false;
            }
        } else {
            H1(this.E);
            int v12 = v1();
            if (v12 == 0) {
                if (!this.f36595i) {
                    z1();
                } else {
                    P();
                }
                if (this.f36609w == null) {
                    a1(4097);
                    return false;
                } else if (!x1()) {
                    a1(DfuException.ERROR_ENTER_OTA_MODE_FAILED);
                    return false;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(((v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) ? new CompatScanFilter.b().f(t().s(), v().u()) : new CompatScanFilter.b().f(t().s(), xl.a.n(this.F))).b());
                    ScannerParams k03 = k0();
                    k03.s(arrayList2);
                    U(k03, 31000L);
                    G1(this.E);
                }
            } else {
                throw new OtaException("load ota service failed", v12);
            }
        }
        p0();
        this.f36596j = true;
        return true;
    }

    public final boolean x1() {
        boolean z10;
        if (this.f36594h) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        } else if (this.B0 == null) {
            return false;
        } else {
            D(518);
            il.b.c("<< OPCODE_ENTER_OTA_MODE(0x01), enable device to enter OTA mode");
            try {
                z10 = a0(this.B0, h.f27514g, false);
            } catch (DfuException e10) {
                boolean z11 = e10.getErrCode() != 267;
                il.b.e("<< OPCODE_ENTER_OTA_MODE(0x01) failed, ignore it :" + e10.getMessage());
                this.C = 0;
                z10 = z11;
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
            if (z10 && t().U()) {
                I();
            }
            R(this.f5234s0);
            return z10;
        }
    }

    public final boolean y1() {
        a aVar;
        D(514);
        this.E = this.F;
        this.f36596j = false;
        boolean z10 = false;
        while (e()) {
            try {
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errCode = e10.getErrCode();
                if (errCode == 4128) {
                    v0(errCode, true);
                } else {
                    if (!(errCode == 4097 || errCode == 265 || !u1())) {
                        I();
                    }
                    v0(errCode, false);
                }
            }
            if (!w1() || !B1()) {
                return false;
            }
            this.f36612z += u().f();
            if (u().u()) {
                il.b.j("no pendding image file to upload.");
                u().x(this.f36612z);
                if (!this.J) {
                    D(523);
                } else {
                    o1();
                    n1();
                    D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
                }
                z10 = true;
            } else {
                il.b.j("has pendding image file to upload");
                if (v().K() == 1) {
                    this.E = this.F;
                    this.f36596j = false;
                    this.f36612z = 0;
                    o1();
                    n1();
                } else if (v().K() == 3 && (aVar = this.f36610x) != null && D0(aVar, this.f36612z, v().C * 4096)) {
                    il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                    this.E = null;
                    this.f36596j = true;
                    this.f36612z = 0;
                    o1();
                    t0((byte) 1);
                }
                w();
            }
            try {
                Thread.sleep(1000L);
                continue;
            } catch (InterruptedException unused) {
            }
            if (z10) {
                return z10;
            }
        }
        v0(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void z1() {
        this.f36595i = false;
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.M = new d(this.f36590d, 2);
        A1();
        if (v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) {
            r1();
        }
        q1();
        if (this.f36587a) {
            il.b.c(v().toString());
        }
        Q();
        this.f36595i = true;
        il.b.c("Ota Environment prepared.");
    }
}