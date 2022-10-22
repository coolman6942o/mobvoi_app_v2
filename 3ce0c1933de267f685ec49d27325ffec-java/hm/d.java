package hm;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.ConnectionParameters;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Locale;
import xl.a;
import xl.b;
/* loaded from: classes2.dex */
public class d extends c {
    public d(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
    }

    @Override // xl.a
    public boolean h(boolean z10) {
        if (!super.h(z10)) {
            return false;
        }
        if (this.f36599m != 515) {
            boolean z11 = this.f36587a;
            il.b.d(z11, "start to re-connect the RCU which going to active image, current state is: " + this.f36599m);
            int r02 = r0(this.E, t().B());
            if (r02 != 0) {
                il.b.l(String.format("Something error in OTA process, errorCode: 0x%04X, mProcessState=0x%04X", Integer.valueOf(r02), Integer.valueOf(this.f36607u)));
                v0(r02, true);
                return false;
            }
        }
        if (z10) {
            try {
                g1();
                D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            } catch (DfuException e10) {
                il.b.l(e10.toString());
                T0(e10.getErrCode());
            }
        } else {
            if (n1()) {
                I();
            }
            v0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, false);
        }
        return true;
    }

    public final int o1() {
        if (this.A0 == null) {
            il.b.l("OTA SERVICE not found:" + this.f5243z0.toString());
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        } else if (this.B0 != null) {
            return 0;
        } else {
            il.b.l("not found OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC : " + g.f27883a.toString());
            return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
        }
    }

    public final boolean p1() {
        if (this.f36596j) {
            if (TextUtils.isEmpty(this.E)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(((v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) ? new CompatScanFilter.b().f(t().s(), v().u()) : new CompatScanFilter.b().f(t().s(), a.n(this.F))).b());
                ScannerParams k02 = k0();
                k02.s(arrayList);
                U(k02, 31000L);
            }
            v1(this.E);
            if (!this.f36595i) {
                s1();
            } else {
                P();
            }
            if (this.f36609w == null) {
                T0(4097);
                return false;
            }
        } else {
            w1(this.E);
            int o12 = o1();
            if (o12 == 0) {
                if (!this.f36595i) {
                    s1();
                } else {
                    P();
                }
                if (this.f36609w == null) {
                    T0(4097);
                    return false;
                } else if (!q1()) {
                    T0(DfuException.ERROR_ENTER_OTA_MODE_FAILED);
                    return false;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(((v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 11 || v().f6004j == 12) ? new CompatScanFilter.b().f(t().s(), v().u()) : new CompatScanFilter.b().f(t().s(), a.n(this.F))).b());
                    ScannerParams k03 = k0();
                    k03.s(arrayList2);
                    U(k03, 31000L);
                    v1(this.E);
                }
            } else {
                throw new OtaException("load ota service failed", o12);
            }
        }
        p0();
        this.f36596j = true;
        return true;
    }

    @Override // xl.a
    public void q() {
        int y10;
        super.q();
        try {
            setName("ProcessorXG0010N");
            il.b.c("ProcessorXG0010N running.");
            y10 = y();
        } catch (Exception e10) {
            il.b.l(e10.toString());
            T0(0);
        }
        if (y10 != 0) {
            T0(y10);
            return;
        }
        D(514);
        this.E = this.F;
        this.f36596j = false;
        r1();
        m(this.f36609w);
        il.b.d(this.f36587a, "ProcessorXG0010N stopped");
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final boolean q1() {
        boolean z10;
        if (this.f36594h) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        } else if (this.B0 == null) {
            return false;
        } else {
            D(518);
            il.b.c("<< OPCODE_ENTER_OTA_MODE(0x01), enable device to enter OTA mode");
            try {
                z10 = a0(this.B0, g.f27886d, false);
            } catch (DfuException e10) {
                boolean z11 = e10.getErrCode() != 267;
                il.b.l("<< OPCODE_ENTER_OTA_MODE(0x01) failed, ignore it :" + e10.getMessage());
                this.C = 0;
                z10 = z11;
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException unused) {
            }
            if (z10 && t().U()) {
                I();
            }
            R(this.f5234s0);
            return z10;
        }
    }

    public final boolean r1() {
        DfuProgressInfo u10;
        boolean z10 = false;
        while (e()) {
            try {
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errCode = e10.getErrCode();
                if (errCode == 4128) {
                    v0(errCode, true);
                } else {
                    if (errCode != 4097 && errCode != 265 && n1() && this.I == 0) {
                        I();
                    }
                    v0(errCode, false);
                }
            }
            if (!p1() || !t1()) {
                return false;
            }
            this.f36612z += u().f();
            if (u().u()) {
                il.b.c("no pendding image file to upload.");
                t0(u().g(), (byte) 1);
                u().x(this.f36612z);
                if (!this.J) {
                    D(523);
                } else {
                    g1();
                    D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
                }
                z10 = true;
            } else {
                il.b.d(this.f36587a, "has pendding image file to upload");
                if (v().K() == 1) {
                    t0(u().g(), (byte) 1);
                    this.E = this.F;
                    this.f36596j = false;
                    this.f36612z = 0;
                    g1();
                } else {
                    if (v().K() == 3) {
                        wl.a aVar = this.f36610x;
                        if (aVar == null) {
                            u10 = u();
                        } else if (C0(aVar, this.f36612z, v().C * 4096)) {
                            il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                            t0(u().g(), (byte) 1);
                            this.E = null;
                            this.f36596j = true;
                            this.f36612z = 0;
                            s0((byte) 1);
                        } else {
                            u10 = u();
                        }
                    } else {
                        u10 = u();
                    }
                    t0(u10.g(), (byte) 0);
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

    public final void s1() {
        this.f36595i = false;
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException unused) {
        }
        this.M = new cm.d(16, 2);
        j1();
        k1();
        i1();
        l1();
        if (this.f36587a) {
            il.b.c(v().toString());
        }
        Q();
        this.f36595i = true;
        il.b.c("Ota Environment prepared.");
    }

    public final boolean t1() {
        if (!e()) {
            v0(DfuException.ERROR_DFU_ABORTED, true);
            return false;
        } else if (!v().N() || j()) {
            D(521);
            il.b.c(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.I), Integer.valueOf(v().f6004j)));
            if (this.f36587a) {
                il.b.j(u().toString());
            }
            S(this.f5234s0, this.H0, true);
            if (Build.VERSION.SDK_INT >= 23) {
                W(this.f5234s0, 256);
            }
            m1();
            u1();
            u().D();
            x1(u().g());
            if (!t().G()) {
                this.P = 0;
                il.b.c(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.P)));
            }
            if (this.P == 0) {
                q0();
            }
            if (this.P - 12 >= u().i()) {
                il.b.j("Last send reach the bottom");
            } else {
                W0(u().g());
                if (this.O == 1) {
                    G0(this.f5234s0, this.I0, this.f36609w);
                } else {
                    w0(this.f5234s0, this.I0, this.f36609w);
                }
            }
            u().v();
            return true;
        } else {
            T0(4113);
            return false;
        }
    }

    public final void u1() {
        if (!this.f36594h) {
            il.b.c("<< OPCODE_DFU_CONNECTION_PARAMETER_UPDATE(0x07)");
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
                il.b.d(this.f36587a, "... waiting OPCODE_DFU_CONNECTION_PARAMETER_UPDATE(0x07) response");
                m0();
            } catch (DfuException e10) {
                il.b.l("ignore connection parameters update exception: " + e10.getMessage());
                this.C = 0;
            }
        } else {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        }
    }

    public final void v1(String str) {
        if (!this.f36594h) {
            D(DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR);
            int r02 = r0(str, t().B());
            if (r02 != 0) {
                if (r02 == 4128) {
                    throw new OtaException("aborted, connectRemoteDevice failed", r02);
                }
                throw new OtaException("connectOtaRemoteDevice failed", r02);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void w1(String str) {
        if (!this.f36594h) {
            D(516);
            int r02 = r0(str, t().B());
            if (r02 != 0) {
                if (r02 != 4128) {
                    L(k0());
                    if (!this.f36594h) {
                        int r03 = r0(str, t().B());
                        if (r03 != 0) {
                            if (r03 == 4128) {
                                throw new OtaException("aborted, connectRemoteDevice failed", r03);
                            }
                            throw new OtaException("connectRemoteDevice failed", r03);
                        }
                        return;
                    }
                    throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
                }
                throw new OtaException("aborted, connectRemoteDevice failed", r02);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void x1(int i10) {
        int i11;
        int i12;
        if (!this.f36594h) {
            il.b.d(this.f36587a, "<< OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06)");
            a0(this.H0, new byte[]{6, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255)}, false);
            il.b.d(this.f36587a, "... Reading OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06) notification");
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
            il.b.l(String.format("0x%04X, Get target image info failed", Integer.valueOf((int) DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
            throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }
}
