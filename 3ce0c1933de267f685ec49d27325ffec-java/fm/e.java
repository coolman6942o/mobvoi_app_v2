package fm;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import cm.d;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import jl.a;
import xl.b;
/* loaded from: classes2.dex */
public final class e extends c {
    public e(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0141 A[ORIG_RETURN, RETURN] */
    @Override // bm.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V(el.b bVar) {
        boolean z10;
        String str;
        BluetoothDevice a10 = bVar.a();
        el.e e10 = el.e.e(bVar.c());
        if (this.f36607u == 519) {
            if (e10 != null) {
                il.b.k(this.f36587a, e10.toString());
                byte[] c10 = e10.c(t().s());
                if (c10 == null) {
                    str = "no match manufacture data found";
                    il.b.c(str);
                    return;
                }
                il.b.k(this.f36588b, "manufacturerSpecificData=" + a.a(c10));
                il.b.k(this.f36588b, "deviceMac= " + a.a(v().u()));
                z10 = Arrays.equals(c10, v().u());
                if (!z10) {
                    this.D = bVar.b();
                    this.E = a10.getAddress();
                    il.b.d(this.f36587a, "find target device: name=" + this.D + " addr=" + this.E);
                    o0();
                    synchronized (this.f37630l0) {
                        this.f37631m0 = true;
                        this.f37630l0.notifyAll();
                    }
                    return;
                }
                return;
            }
            str = "ignore , specScanRecord is null";
            il.b.c(str);
            return;
        }
        if (this.f36607u == 515) {
            String str2 = this.F;
            z10 = str2 != null && str2.equals(a10.getAddress());
        } else if (this.f36607u == 527) {
            if (e10 != null) {
                il.b.j(e10.toString());
                byte[] c11 = e10.c(t().s());
                if (c11 != null) {
                    il.b.k(this.f36587a, "manufacturerSpecificData=" + a.a(c11));
                    il.b.k(this.f36587a, "rwsBdAddr= " + a.a(v().F()));
                    z10 = Arrays.equals(c11, v().F());
                } else {
                    return;
                }
            }
            str = "ignore , specScanRecord is null";
            il.b.c(str);
            return;
        } else {
            str = "ignore process state: " + this.f36607u;
            il.b.c(str);
            return;
        }
        if (!z10) {
        }
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
                il.b.e(String.format("Something error in OTA process, errorCode: 0x%04X, mProcessState=0x%04X", Integer.valueOf(r02), Integer.valueOf(this.f36607u)));
                v0(r02, true);
                return false;
            }
        }
        if (z10) {
            try {
                f1();
                D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            } catch (DfuException e10) {
                e10.printStackTrace();
                S0(e10.getErrCode());
            }
        } else {
            m1();
            v0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, false);
        }
        return true;
    }

    public final boolean n1() {
        s1(this.E);
        p0();
        if (!this.f36595i) {
            p1();
        } else {
            P();
        }
        if (this.f36609w != null) {
            return true;
        }
        S0(4097);
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:16|(1:18)(9:19|(2:21|(5:23|24|(2:26|(2:29|30))|31|(2:33|30)(1:35))(6:37|40|55|41|64|63))(1:38)|36|39|40|55|41|64|63)|34|40|55|41|64|63) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f3, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f4, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean o1() {
        DfuProgressInfo u10;
        while (e()) {
            try {
                if (!n1() || !q1()) {
                    return false;
                }
                this.f36612z += u().f();
                if (u().u()) {
                    il.b.c("no pendding image file to upload.");
                    t0(u().g(), (byte) 1);
                    u().x(this.f36612z);
                    return true;
                }
                il.b.c("has pendding image file to upload");
                if (v().K() == 1) {
                    t0(u().g(), (byte) 1);
                    this.E = this.F;
                    this.f36596j = true;
                    this.f36612z = 0;
                    f1();
                } else {
                    if (v().K() == 3) {
                        wl.a aVar = this.f36610x;
                        if (aVar != null) {
                            wl.a aVar2 = this.f36609w;
                            if (aVar2 != null) {
                                int i10 = aVar2.C;
                                int i11 = aVar.C;
                                if (i10 != i11 && i11 == 0) {
                                    t0(u().g(), (byte) 1);
                                    il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                                    this.f36596j = true;
                                    this.f36612z = 0;
                                    s0((byte) 1);
                                }
                            }
                            if (C0(aVar, this.f36611y, this.f36612z, v().C * 4096)) {
                                t0(u().g(), (byte) 1);
                                il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                                this.f36596j = true;
                                this.f36612z = 0;
                                s0((byte) 1);
                            } else {
                                u10 = u();
                            }
                        } else {
                            t0(u().g(), (byte) 1);
                            Thread.sleep(1000L);
                        }
                    } else {
                        u10 = u();
                    }
                    t0(u10.g(), (byte) 0);
                    Thread.sleep(1000L);
                }
                w();
                Thread.sleep(1000L);
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errCode = e10.getErrCode();
                if (errCode == 4128) {
                    v0(errCode, true);
                } else {
                    if (!(errCode == 4097 || errCode == 265)) {
                        m1();
                    }
                    v0(errCode, false);
                }
                return false;
            }
        }
        v0(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void p1() {
        this.f36595i = false;
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.M = new d(20, 2);
        i1();
        if (!v().R() || v().H() == 0) {
            j1();
            h1();
            k1();
            if (this.f36587a) {
                il.b.c(v().toString());
            }
            Q();
            this.f36595i = true;
            il.b.c("Ota Environment prepared.");
            return;
        }
        throw new OtaException("rws state not ready", DfuException.ERROR_DFU_SPP_RWS_NOT_READY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x008c, code lost:
        if (r6.J == false) goto L19;
     */
    @Override // xl.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q() {
        int y10;
        super.q();
        try {
            setName("ProcessorXG0014S");
            il.b.c("ProcessorXG0014S running.");
            y10 = y();
        } catch (Exception e10) {
            e10.printStackTrace();
            il.b.l(e10.toString());
            S0(0);
        }
        if (y10 != 0) {
            S0(y10);
            return;
        }
        D(514);
        this.E = this.F;
        this.f36596j = true;
        if (o1()) {
            if (v().R()) {
                f1();
                D(522);
                il.b.c("wait master to handover ...");
                ArrayList arrayList = new ArrayList();
                arrayList.add(new CompatScanFilter.b().f(t().s(), v().F()).b());
                ScannerParams k02 = k0();
                k02.s(arrayList);
                r1(k02);
                il.b.c("start to upload secondary bud ...");
                this.f36596j = true;
                this.f36595i = false;
                this.f36612z = 0;
                if (o1()) {
                    if (!this.J) {
                        D(523);
                    }
                    f1();
                    D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
                }
            }
        }
        m(this.f36609w);
        il.b.d(this.f36587a, "ProcessorXG0010S stopped");
        F();
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final boolean q1() {
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
            l1();
            u().D();
            t1(u().g());
            if (!t().G()) {
                this.P = 0;
                il.b.c(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.P)));
            }
            if (this.P == 0) {
                q0();
            }
            if (this.P - 12 >= u().i()) {
                il.b.c("Last send reach the bottom");
            } else {
                V0(u().g());
                if (this.O == 1) {
                    F0(this.f5234s0, this.I0, this.f36609w);
                } else {
                    w0(this.f5234s0, this.I0, this.f36609w);
                }
            }
            u().v();
            return true;
        } else {
            S0(4113);
            return false;
        }
    }

    public void r1(ScannerParams scannerParams) {
        if (!this.f36594h) {
            D(527);
            this.C = 0;
            this.f37631m0 = false;
            N(scannerParams);
            try {
                synchronized (this.f37630l0) {
                    if (this.C == 0 && !this.f37631m0) {
                        this.f37630l0.wait(31000L);
                    }
                }
            } catch (InterruptedException e10) {
                il.b.e("findRemoteDevice interrupted, e = " + e10.toString());
                this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
            }
            if (this.C == 0 && !this.f37631m0) {
                il.b.l("didn't find the secondary bud device");
                this.C = DfuException.ERROR_CANNOT_FIND_DEVICE;
            }
            if (this.C != 0) {
                throw new OtaException("Error while scan remote device", this.C);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void s1(String str) {
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

    public final void t1(int i10) {
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
