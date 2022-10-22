package em;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import cm.d;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import wl.a;
import xl.b;
/* loaded from: classes2.dex */
public class e extends b {
    public e(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
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
            int v12 = v1(this.E, t().B());
            if (v12 != 0) {
                il.b.e("Something error in OTA process, errorCode: " + v12 + "mProcessState" + this.f36607u);
                t0(v12, true);
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
            o1();
            t0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, false);
        }
        return true;
    }

    @Override // xl.a
    public void q() {
        int y10;
        super.q();
        try {
            setName("ProcessorX0013SEx");
            il.b.c("ProcessorX0013SEx running.");
            y10 = y();
        } catch (Exception e10) {
            e10.printStackTrace();
            il.b.e(e10.toString());
            Y0(0);
        }
        if (y10 != 0) {
            Y0(y10);
            return;
        }
        r1();
        m(this.f36609w);
        if (this.f36587a) {
            il.b.c("GattDfuTaskX0000 stopped");
        }
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final boolean r1() {
        a aVar;
        D(514);
        this.E = this.F;
        this.f36596j = true;
        boolean z10 = false;
        while (e()) {
            try {
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errCode = e10.getErrCode();
                if (errCode == 4128) {
                    t0(errCode, true);
                } else {
                    if (!(errCode == 4097 || errCode == 265)) {
                        o1();
                    }
                    t0(errCode, false);
                }
            }
            if (!z1() || !u1()) {
                return false;
            }
            this.f36612z += u().f();
            if (u().u()) {
                il.b.c("no pendding image file to upload.");
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
                    this.f36596j = true;
                    this.f36612z = 0;
                    k1();
                } else if (v().K() == 3 && (aVar = this.f36610x) != null && A0(aVar, this.f36612z, v().C * 4096)) {
                    il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
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

    public final void s1() {
        this.f36595i = false;
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.M = new d(this.f36590d, 2);
        t1();
        n1();
        m1();
        if (this.f36587a) {
            il.b.c(v().toString());
        }
        Q();
        List<a> list = this.f36608v;
        if (list != null && list.size() > 0) {
            for (a aVar : this.f36608v) {
                aVar.Q();
            }
        }
        this.f36595i = true;
        il.b.c("Ota Environment prepared.");
    }

    public final boolean t1() {
        if (this.C0 == null) {
            return false;
        }
        if (this.f36587a) {
            il.b.j("start to read remote dev info");
        }
        byte[] c02 = c0(this.C0);
        if (c02 != null) {
            v().T(c02);
            b(v().B);
            return true;
        }
        il.b.e("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public final boolean u1() {
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
            if (this.f36587a) {
                il.b.c("isBufferCheckEnabled=" + v().Q());
            }
            if (!v().Q()) {
                this.O = 0;
            } else {
                this.O = l1();
            }
            if (this.f36587a) {
                il.b.j("mRemoteOtaFunctionInfo=" + this.O);
            }
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
                il.b.c("Last send reach the bottom");
            } else {
                y1(u().g());
                if (this.O == 1) {
                    u0(this.f5234s0, this.I0, this.f36609w);
                } else {
                    w1(this.f5234s0, this.I0, this.f36609w);
                }
            }
            u().v();
            try {
                Thread.sleep(30L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            b1(u().g());
            return true;
        } else {
            Y0(4113);
            return false;
        }
    }

    public final int v1(String str, int i10) {
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
            if (i11 > i10) {
                return L0;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public final void w1(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, a aVar) {
        int i10;
        il.b.d(this.f36587a, "uploadFirmwareImageForBeeUpdate");
        l();
        this.C = 0;
        this.f36606t = false;
        byte[] bArr = new byte[this.K];
        while (!this.f36606t) {
            if (!this.f36594h) {
                H();
                if (this.f36587a) {
                    il.b.j(u().toString());
                }
                try {
                    int f10 = u().f();
                    if (f10 == 0) {
                        int i11 = this.K;
                        byte[] bArr2 = new byte[i11];
                        aVar.i0(bArr2, i11 - 12);
                        System.arraycopy(aVar.E(), 0, bArr, 0, 12);
                        System.arraycopy(bArr2, 0, bArr, 12, this.K - 12);
                        i10 = this.K;
                    } else {
                        i10 = (f10 % 256 == 0 || (f10 % 256) % 240 != 0) ? aVar.j0(bArr) : aVar.i0(bArr, 16);
                    }
                    if (u().o() < this.K) {
                        il.b.j("reach the end of the file, only read some");
                        i10 = u().o();
                    }
                    int i12 = i10;
                    if (i12 > 0) {
                        if (v().N()) {
                            for (int i13 = i12; i13 > 0; i13 -= 16) {
                                if (i13 >= 16) {
                                    int i14 = i12 - i13;
                                    System.arraycopy(this.B.a(bArr, i14, 16), 0, bArr, i14, 16);
                                    if (v().r() == 0) {
                                        break;
                                    }
                                }
                            }
                        }
                        Y(bluetoothGatt, bluetoothGattCharacteristic, bArr, i12, false);
                        O();
                        k();
                    } else if (u().t()) {
                        il.b.g("image file has already been send over");
                        return;
                    } else {
                        il.b.e("Error while reading file with size: " + i12);
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

    public final void x1(String str) {
        if (!this.f36594h) {
            D(516);
            int v12 = v1(str, t().B());
            if (v12 != 0) {
                if (v12 != 4128) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new CompatScanFilter.b().c(str).b());
                    ScannerParams k02 = k0();
                    k02.s(arrayList);
                    k02.r(str);
                    L(k02);
                    int v13 = v1(str, t().B());
                    if (v13 != 0) {
                        if (v13 == 4128) {
                            throw new OtaException("aborted, connectRemoteDevice failed", v13);
                        }
                        throw new OtaException("connectRemoteDevice failed", v13);
                    }
                    return;
                }
                throw new OtaException("aborted, connectRemoteDevice failed", v12);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void y1(int i10) {
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
        int f10 = u().f();
        int i12 = this.P;
        if (f10 != i12 && i12 != -1) {
            il.b.c("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
    }

    public final boolean z1() {
        x1(this.E);
        p0();
        if (!this.f36595i) {
            s1();
        } else {
            P();
        }
        if (this.f36609w != null) {
            return true;
        }
        Y0(4097);
        return false;
    }
}
