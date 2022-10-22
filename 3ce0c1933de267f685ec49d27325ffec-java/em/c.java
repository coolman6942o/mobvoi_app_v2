package em;

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

    public final void A1(String str) {
        if (!this.f36594h) {
            D(516);
            int x12 = x1(str, t().B());
            if (x12 != 0) {
                if (x12 != 4128) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new CompatScanFilter.b().c(str).b());
                    ScannerParams k02 = k0();
                    k02.s(arrayList);
                    k02.r(str);
                    L(k02);
                    int x13 = x1(str, t().B());
                    if (x13 != 0) {
                        if (x13 == 4128) {
                            throw new OtaException("aborted, connectRemoteDevice failed", x13);
                        }
                        throw new OtaException("connectRemoteDevice failed", x13);
                    }
                    return;
                }
                throw new OtaException("aborted, connectRemoteDevice failed", x12);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void B1(int i10) {
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
        E0(i10, this.P);
        if (this.P != u().f() + 12 && this.P != -1) {
            if (this.f36587a) {
                il.b.c(String.format(Locale.US, "mBytesSent(%d) != mImageUpdateOffset(%d), reload image bin file", Integer.valueOf(u().f() + 12), Integer.valueOf(this.P)));
            }
            Q();
            i(this.P, false);
        }
    }

    public final int C1() {
        if (this.A0 == null) {
            il.b.l("OTA SERVICE not found:" + this.f5243z0.toString());
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        } else if (this.B0 != null) {
            return 0;
        } else {
            il.b.l("not found OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC : " + g.f26125a.toString());
            return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
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
            int x12 = x1(this.E, t().B());
            if (x12 != 0) {
                il.b.l("Something error in OTA process, errorCode: " + x12 + "mProcessState" + this.f36607u);
                t0(x12, true);
                return false;
            }
        }
        if (z10) {
            try {
                k1();
                D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            } catch (DfuException e10) {
                e10.printStackTrace();
                Y0(e10.getErrCode());
            }
        } else {
            if (o1()) {
                I();
            }
            t0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, false);
        }
        return true;
    }

    @Override // xl.a
    public void q() {
        int y10;
        super.q();
        try {
            setName("ProcessorX0013N");
            il.b.c("ProcessorX0013N running.");
            y10 = y();
        } catch (Exception e10) {
            il.b.l(e10.toString());
            Y0(0);
        }
        if (y10 != 0) {
            Y0(y10);
            return;
        }
        t1();
        m(this.f36609w);
        if (this.f36587a) {
            il.b.c("ProcessorX0013N stopped");
        }
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final boolean r1() {
        if (this.f36596j) {
            if (TextUtils.isEmpty(this.E)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new CompatScanFilter.b().f(t().s(), v().u()).b());
                ScannerParams k02 = k0();
                k02.s(arrayList);
                U(k02, 31000L);
            }
            z1(this.E);
            if (!this.f36595i) {
                u1();
            } else {
                P();
            }
            if (this.f36609w == null) {
                Y0(4097);
                return false;
            }
        } else {
            A1(this.E);
            int C1 = C1();
            if (C1 == 0) {
                if (!this.f36595i) {
                    u1();
                } else {
                    P();
                }
                if (this.f36609w == null) {
                    Y0(4097);
                    return false;
                } else if (!s1()) {
                    Y0(DfuException.ERROR_ENTER_OTA_MODE_FAILED);
                    return false;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new CompatScanFilter.b().f(t().s(), v().u()).b());
                    ScannerParams k03 = k0();
                    k03.s(arrayList2);
                    U(k03, 31000L);
                    z1(this.E);
                }
            } else {
                throw new OtaException("load ota service failed", C1);
            }
        }
        p0();
        this.f36596j = true;
        return true;
    }

    public final boolean s1() {
        boolean z10;
        if (this.f36594h) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        } else if (this.B0 == null) {
            return false;
        } else {
            D(518);
            il.b.c("<< OPCODE_ENTER_OTA_MODE(0x01), enable device to enter OTA mode");
            try {
                z10 = a0(this.B0, g.f26131g, false);
            } catch (DfuException e10) {
                boolean z11 = e10.getErrCode() != 267;
                il.b.l("<< OPCODE_ENTER_OTA_MODE(0x01) failed, ignore it :" + e10.getMessage());
                this.C = 0;
                z10 = z11;
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
            if (t().U()) {
                I();
            }
            R(this.f5234s0);
            return z10;
        }
    }

    public final boolean t1() {
        a aVar;
        D(514);
        this.E = this.F;
        this.f36596j = false;
        boolean z10 = false;
        while (e()) {
            try {
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errorNumber = e10.getErrorNumber();
                if (errorNumber == 4128) {
                    t0(errorNumber, true);
                } else {
                    if (!(errorNumber == 4097 || errorNumber == 265 || !o1())) {
                        I();
                    }
                    t0(errorNumber, false);
                }
            }
            if (!r1() || !w1()) {
                return false;
            }
            this.f36612z += u().f();
            if (u().u()) {
                il.b.j("no pendding image file to upload.");
                u().x(this.f36612z);
                if (!this.J) {
                    D(523);
                } else {
                    k1();
                    D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
                }
                z10 = true;
            } else {
                il.b.j("has pendding image file to upload");
                if (v().K() == 1) {
                    this.E = this.F;
                    this.f36596j = false;
                    this.f36612z = 0;
                    k1();
                } else if (v().K() == 3 && (aVar = this.f36610x) != null && A0(aVar, this.f36612z, v().C * 4096)) {
                    il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                    this.E = null;
                    this.f36596j = true;
                    this.f36612z = 0;
                    r0((byte) 1);
                }
                w();
            }
            try {
                Thread.sleep(1000L);
                continue;
            } catch (InterruptedException e11) {
                e11.printStackTrace();
                continue;
            }
            if (z10) {
                return z10;
            }
        }
        t0(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void u1() {
        this.f36595i = false;
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.M = new d(this.f36590d, 2);
        v1();
        n1();
        m1();
        if (this.f36587a) {
            il.b.c(v().toString());
        }
        Q();
        this.f36595i = true;
        il.b.c("Ota Environment prepared.");
    }

    public final boolean v1() {
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

    public final boolean w1() {
        if (!e()) {
            t0(DfuException.ERROR_DFU_ABORTED, true);
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
            if (!v().Q()) {
                this.O = 0;
            } else {
                this.O = l1();
            }
            if (this.f36588b) {
                il.b.j("mRemoteOtaFunctionInfo=" + this.O);
            }
            q1();
            u().D();
            U0(10131);
            a1(u().g());
            if (!t().G()) {
                this.P = 0;
                il.b.c(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.P)));
            }
            if (this.P == 0) {
                p1();
            }
            if (this.P - 12 >= u().i()) {
                il.b.k(this.f36588b, "Last send reach the bottom");
            } else {
                B1(u().g());
                if (this.O == 1) {
                    u0(this.f5234s0, this.I0, this.f36609w);
                } else {
                    y1(this.f5234s0, this.I0, this.f36609w);
                }
            }
            u().v();
            b1(u().g());
            return true;
        } else {
            Y0(4113);
            return false;
        }
    }

    public final int x1(String str, int i10) {
        int i11 = 0;
        while (e()) {
            int L0 = L0(str);
            if (L0 == 0) {
                return 0;
            }
            if ((L0 & (-2049)) != 133) {
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
                return L0;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public final void y1(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, a aVar) {
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
                        il.b.l("Error while reading file with size: " + i13);
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

    public final void z1(String str) {
        if (!this.f36594h) {
            D(DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR);
            int x12 = x1(str, t().B());
            if (x12 != 0) {
                if (x12 == 4128) {
                    throw new OtaException("aborted, connectRemoteDevice failed", x12);
                }
                throw new OtaException("connectOtaRemoteDevice failed", x12);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }
}
