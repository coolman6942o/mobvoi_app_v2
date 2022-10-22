package jm;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import b.c;
import b.d;
import b.e;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.tendcloud.tenddata.ab;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import jm.a;
import km.i;
/* loaded from: classes2.dex */
public class b extends im.a {

    /* renamed from: w0  reason: collision with root package name */
    public d f29648w0 = new a();

    /* loaded from: classes2.dex */
    public class a extends d {
        public a() {
        }

        @Override // b.d
        public void a(b.a aVar) {
            super.a(aVar);
            b.this.i0(aVar);
        }

        @Override // b.d
        public void b(BluetoothDevice bluetoothDevice, boolean z10, int i10) {
            super.b(bluetoothDevice, z10, i10);
            if (i10 == 512) {
                b.this.G(515);
            } else if (i10 == 0) {
                if (b.this.f36607u == 521) {
                    b bVar = b.this;
                    bVar.C = 2048;
                    if (bVar.f36587a) {
                        il.b.l(String.format("disconnect in OTA process, mErrorState: 0x%04X", Integer.valueOf(bVar.C)));
                    }
                    b.this.s();
                }
                b.this.G(0);
            } else {
                return;
            }
            b.this.A();
        }

        @Override // b.d
        public void c(e eVar) {
            super.c(eVar);
            b.this.j0(eVar);
        }
    }

    public b(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
    }

    public final void A0() {
        if (o0(null)) {
            if (v().R()) {
                il.b.j("RWS, no need to disconnect manully");
            } else {
                if (o()) {
                    I();
                } else {
                    il.b.c("device already disconnected");
                }
                y0(0);
            }
            m(this.f36609w);
        }
    }

    public final void B0() {
        G0().r();
        G0().n(this.f29648w0);
        G(1280);
    }

    public final boolean C0() {
        w0(this.E);
        if (!this.f36595i) {
            I0();
        } else {
            P();
        }
        if (this.f36609w != null) {
            return true;
        }
        t0(4097);
        return false;
    }

    public final void D0() {
        int i10 = this.f36599m;
        if (i10 != 0 && i10 != 1280) {
            G0().r();
            I();
        } else if (this.f36587a) {
            il.b.c("already disconnect");
        }
    }

    public final int E0() {
        il.b.d(this.f36587a, String.format("<< CMD_OTA_BUFFER_CHECK_ENABLE (0x%04X)", (short) 1543));
        S((short) 1543, null);
        try {
            il.b.d(this.f36587a, "... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            byte[] Y = Y(1600L);
            if (Y[0] == 1) {
                ByteBuffer wrap = ByteBuffer.wrap(Y);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i10 = (((short) (wrap.get(2) & 255)) << 8) | ((short) (wrap.get(1) & 255));
                int i11 = ((short) (wrap.get(3) & 255)) | (((short) (wrap.get(4) & 255)) << 8);
                boolean z10 = this.f36587a;
                il.b.k(z10, "maxBufferSize=" + i10 + ", bufferCheckMtuSize=" + i11);
                b(i10);
                W(i11);
                return 1;
            }
        } catch (DfuException unused) {
            il.b.l("Read DFU_REPORT_OTA_FUNCTION_VERSION failed, just think remote is normal function.");
            this.C = 0;
        }
        return 0;
    }

    public final void F0() {
        il.b.d(this.f36587a, String.format("<< CMD_OTA_GET_OTHER_INFO (0x%04X)", (short) 1547));
        byte[] p02 = p0((short) 1547);
        if (p02 == null || p02.length <= 0) {
            v().q0(0);
        } else {
            v().q0(p02[0] & 1);
        }
    }

    public final c G0() {
        if (this.f28341v0 == null) {
            c H = c.H();
            this.f28341v0 = H;
            H.e(this.f29648w0);
        }
        return this.f28341v0;
    }

    public boolean H0() {
        wl.a aVar;
        boolean z10 = false;
        while (e()) {
            try {
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errCode = e10.getErrCode();
                if (errCode == 4128) {
                    h0(errCode, true);
                } else if (errCode == 4097) {
                    h0(errCode, false);
                } else {
                    L0();
                    t0(errCode);
                }
            }
            if (!C0() || !e0()) {
                return false;
            }
            this.f36612z += u().f();
            if (u().u()) {
                il.b.c("no pendding image file to upload.");
                u().x(this.f36612z);
                z10 = true;
            } else {
                il.b.c("has pendding image file to upload");
                if (v().K() == 1) {
                    this.E = this.F;
                    this.f36596j = true;
                    this.f36612z = 0;
                    A0();
                } else if (v().K() == 3 && (aVar = this.f36610x) != null && n0(aVar, this.f36612z, v().C * 4096)) {
                    il.b.c("make device to enter the ota advertiser mode, and let the app continue update imae");
                    this.f36596j = true;
                    this.f36612z = 0;
                    g0((byte) 1);
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
        t0(DfuException.ERROR_DFU_ABORTED);
        return false;
    }

    public final void I0() {
        this.f36595i = false;
        if (!e()) {
            t0(DfuException.ERROR_DFU_ABORTED);
            return;
        }
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.M = new cm.d(this.f36590d, 2);
        K0();
        if (v().R()) {
            F0();
            if (v().H() != 0) {
                throw new OtaException("rws state not ready", DfuException.ERROR_DFU_SPP_RWS_NOT_READY);
            }
        }
        J0();
        if (this.f36587a) {
            il.b.c(v().toString());
        }
        Q();
        List<wl.a> list = this.f36608v;
        if (list != null && list.size() > 0) {
            for (wl.a aVar : this.f36608v) {
                aVar.Q();
            }
        }
        this.f36595i = true;
        il.b.c("Ota Environment prepared.");
    }

    public final void J0() {
        il.b.d(this.f36587a, String.format("<< CMD_OTA_GET_IMAGE_INFO (0x%04X)", (short) 1537));
        v().d0(p0((short) 1537));
    }

    public final boolean K0() {
        il.b.d(this.f36587a, String.format("<< CMD_OTA_GET_DEVICE_INFO (0x%04X)", (short) 1536));
        byte[] p02 = p0((short) 1536);
        if (p02 != null) {
            il.b.j(jl.a.a(p02));
            v().T(p02);
            b(v().B);
            if (this.f36587a) {
                il.b.c(v().toString());
            }
            return true;
        }
        il.b.e("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public final boolean L0() {
        try {
            il.b.d(this.f36587a, String.format("<< CMD_OTA_RESET (0x%04X)", (short) 1541));
            return S((short) 1541, null);
        } catch (DfuException e10) {
            il.b.l(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e10.getErrCode())));
            this.C = 0;
            return false;
        }
    }

    public final void d0() {
        il.b.k(this.f36587a, String.format("<< CMD_OTA_START(0x%04X)", (short) 1538));
        byte[] bArr = new byte[16];
        System.arraycopy(this.f36609w.E(), 0, bArr, 0, 12);
        if (v().N()) {
            S((short) 1538, this.B.a(bArr, 0, 16));
        } else {
            S((short) 1538, bArr);
        }
        il.b.k(this.f36587a, "... Reading CMD_OTA_START notification");
        byte b10 = b0()[0];
        if (b10 != 1) {
            il.b.e(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b10)));
            throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
    }

    public final boolean e0() {
        int i10;
        if (!e()) {
            i10 = DfuException.ERROR_DFU_ABORTED;
        } else {
            D(521);
            if (this.f36587a) {
                il.b.c(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.I), Integer.valueOf(v().f6004j)));
                il.b.j(String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.P), Integer.valueOf(this.P)));
            }
            if (this.f36587a) {
                il.b.j(u().toString());
            }
            if (v().f6004j > 3) {
                if (this.f36587a) {
                    il.b.j("isBufferCheckEnabled=" + v().Q());
                }
                if (!v().Q()) {
                    this.O = 0;
                } else {
                    this.O = E0();
                }
                if (this.f36587a) {
                    il.b.j("mRemoteOtaFunctionInfo=" + this.O);
                }
            } else if (this.f36587a) {
                il.b.c("not support ic:" + v().f6004j);
            }
            if (!v().N() || j()) {
                u().D();
                v0(u().g());
                if (!t().G()) {
                    this.P = 0;
                }
                if (this.P == 0) {
                    d0();
                }
                if (this.P - 12 < u().i()) {
                    x0(u().g());
                    if (this.O == 1) {
                        u0(this.f36609w);
                    } else {
                        q0(this.f36609w);
                    }
                } else if (this.f36587a) {
                    il.b.c("Last send reach the bottom");
                }
                u().v();
                z0(u().g());
                return true;
            }
            i10 = 4113;
        }
        t0(i10);
        return false;
    }

    public final int f0(String str, int i10) {
        int i11 = 0;
        while (e()) {
            int s02 = s0(str);
            if (s02 == 0) {
                return 0;
            }
            if ((s02 & (-2049)) != 133) {
                D0();
            } else if (this.f36587a) {
                il.b.c("connect fail with GATT_ERROR, do not need disconnect");
            }
            G(1280);
            try {
                Thread.sleep(1600L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            i11++;
            if (i11 > i10) {
                return s02;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public final void g0(byte b10) {
        if (o0(new byte[]{b10})) {
            if (v().R()) {
                il.b.j("RWS, no need to disconnect manully");
            } else {
                if (o()) {
                    I();
                } else {
                    il.b.c("device already disconnected");
                }
                y0(0);
            }
            m(this.f36609w);
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
            int f02 = f0(this.E, t().B());
            if (f02 != 0) {
                il.b.e("Something error in OTA process, errorCode: " + f02 + "mProcessState" + this.f36607u);
                h0(f02, true);
                return false;
            }
        }
        if (z10) {
            try {
                A0();
                if (t().I(1)) {
                    al.b.g().d(this.f37629k0.getRemoteDevice(this.E));
                    al.b.g().e(this.E);
                }
                D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            } catch (DfuException e10) {
                e10.printStackTrace();
                t0(e10.getErrCode());
            }
        } else {
            L0();
            h0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, true);
        }
        return true;
    }

    public final void h0(int i10, boolean z10) {
        if (this.f36594h) {
            i10 = 4128;
        }
        if (i10 != 4128) {
            E(DfuException.ERROR_CONNECTION_TIMEOUT, true);
        }
        if (this.f36587a) {
            il.b.c(String.format("error = 0x%04X", Integer.valueOf(i10)));
        }
        if (z10) {
            L0();
        }
        el.a aVar = this.f28334o0;
        if (aVar != null) {
            aVar.o();
        }
        if (t().K(1)) {
            y0(i10);
        }
        m(this.f36609w);
        xl.b bVar = this.f36592f;
        if (bVar != null) {
            bVar.a(i10);
        }
        this.f36594h = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void i0(b.a aVar) {
        short e10 = aVar.e();
        byte a10 = aVar.a();
        if (this.f28340u0.containsKey(Short.valueOf(e10))) {
            this.f28340u0.put(Short.valueOf(e10), aVar);
        }
        switch (e10) {
            case 1536:
                il.b.j("ACK-CMD_OTA_GET_DEVICE_INFO");
                if (a10 == 2 || a10 == 1) {
                    il.b.l("CMD_OTA_GET_DEVICE_INFO not support");
                    this.C = DfuException.ERROR_DFU_SPP_OTA_NOT_SUPPORTED;
                    this.f36602p = null;
                    this.f28339t0.remove((short) 1536);
                    C();
                    return;
                }
                return;
            case 1537:
            default:
                return;
            case 1538:
            case 1540:
            case 1541:
            case 1542:
            case 1543:
            case 1544:
            case 1545:
                if (aVar.a() == 0) {
                    this.f36605s = false;
                } else {
                    this.f36605s = true;
                }
                s();
                break;
            case 1539:
                break;
        }
        if (aVar.a() != 0) {
            this.f36605s = true;
            s();
        }
    }

    public final void j0(e eVar) {
        short a10 = eVar.a();
        eVar.h();
        byte[] g10 = eVar.g();
        switch (a10) {
            case 1536:
            case 1537:
            case 1544:
            case 1545:
                short s10 = (short) (a10 & 65535);
                if (this.f28339t0.contains(Short.valueOf(s10))) {
                    this.f28339t0.remove(Short.valueOf(s10));
                    this.f36602p = g10;
                    C();
                    return;
                }
                il.b.l(String.format("not expect event: 0x%04X", Short.valueOf(s10)));
                return;
            case 1538:
            case 1540:
            case 1541:
            case 1542:
            case 1543:
                synchronized (this.L) {
                    this.f28337r0 = g10;
                    this.f28338s0 = true;
                    this.L.notifyAll();
                }
                return;
            case 1539:
                if (((g10 == null || g10.length <= 0) ? (byte) 1 : g10[0]) == 1) {
                    this.f36605s = false;
                } else {
                    this.f36605s = true;
                }
                s();
                return;
            default:
                return;
        }
    }

    public boolean n0(wl.a aVar, int i10, int i11) {
        il.b.k(this.f36587a, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(aVar.k0()), Integer.valueOf(i10), Integer.valueOf(i11)));
        return aVar.k0() + i10 > i11;
    }

    public final boolean o0(byte[] bArr) {
        D(524);
        boolean z10 = true;
        int i10 = DfuException.ERROR_DFU_ABORTED;
        try {
            if (this.f36587a) {
                il.b.c(String.format("<< CMD_OTA_ACTIVE_RESET(0x%04X)", (short) 1542));
            }
            z10 = S((short) 1542, bArr);
        } catch (DfuException e10) {
            if (e10.getErrCode() != 4128) {
                if (!t().S()) {
                    il.b.c("active cmd has no response, ignore");
                } else {
                    il.b.l("active cmd has no response, notify error");
                    i10 = e10.getErrCode();
                }
            }
            z10 = false;
        }
        i10 = 0;
        if (z10) {
            il.b.c("image active success");
            return z10;
        }
        throw new OtaException(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] p0(short s10) {
        short s11;
        Set<Short> set;
        this.C = 0;
        this.f36602p = null;
        short s12 = 1536;
        if (s10 != 1536) {
            s12 = 1537;
            if (s10 != 1537) {
                if (s10 != 1546) {
                    if (s10 == 1547) {
                        set = this.f28339t0;
                        s11 = 1545;
                    }
                    this.f36601o = false;
                    if (!G0().k(s10, null)) {
                        return null;
                    }
                    synchronized (this.f36600n) {
                        try {
                            if (this.C == 0 && !this.f36601o && this.f36599m == 515) {
                                this.f36600n.wait(15000L);
                            }
                        } catch (InterruptedException e10) {
                            il.b.l("mCharacteristicReadCalledLock Sleeping interrupted,e:" + e10);
                            this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                        }
                    }
                    if (this.C == 0 && !this.f36601o) {
                        il.b.d(this.f36587a, "read value but no callback");
                        this.C = DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK;
                    }
                    if (this.C == 0) {
                        return this.f36602p;
                    }
                    throw new OtaException("Error while send command", this.C);
                }
                set = this.f28339t0;
                s11 = 1544;
                set.add(Short.valueOf(s11));
                this.f36601o = false;
                if (!G0().k(s10, null)) {
                }
            }
        }
        this.f28339t0.add(Short.valueOf(s12));
        this.f36601o = false;
        if (!G0().k(s10, null)) {
        }
    }

    @Override // xl.a
    public void q() {
        int y10;
        al.b g10;
        String str;
        super.q();
        try {
            setName("ProcessorXS0000");
            il.b.c("ProcessorXS0000 running.");
            y10 = y();
        } catch (Exception e10) {
            e10.printStackTrace();
            il.b.e(e10.toString());
            t0(0);
        }
        if (y10 != 0) {
            t0(y10);
            return;
        }
        D(514);
        this.E = this.F;
        this.f36596j = true;
        this.f36612z = 0;
        if (H0()) {
            if (v().R()) {
                A0();
                D(522);
                this.f36596j = true;
                this.f36595i = false;
                this.f36612z = 0;
                il.b.d(this.f36587a, "wait master to handover ...");
                try {
                    Thread.sleep(t().m() * 1000);
                } catch (InterruptedException unused) {
                }
                if (H0()) {
                    if (!this.J) {
                        D(523);
                    } else {
                        A0();
                        if (t().I(1)) {
                            al.b.g().d(this.f37629k0.getRemoteDevice(this.E));
                            g10 = al.b.g();
                            str = this.E;
                            g10.e(str);
                        }
                        D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
                    }
                }
            } else {
                if (this.J) {
                    A0();
                    if (t().I(1)) {
                        al.b.g().d(this.f37629k0.getRemoteDevice(this.E));
                        g10 = al.b.g();
                        str = this.E;
                        g10.e(str);
                    }
                    D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
                }
                D(523);
            }
        }
        m(this.f36609w);
        if (this.f36587a) {
            il.b.c("DfuThread stopped");
        }
        c cVar = this.f28341v0;
        if (cVar != null) {
            cVar.n(this.f29648w0);
        }
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final void q0(wl.a aVar) {
        int i10;
        l();
        this.C = 0;
        this.f36606t = false;
        int i11 = this.K;
        byte[] bArr = new byte[i11];
        while (!this.f36606t) {
            if (!this.f36594h) {
                H();
                il.b.j(u().toString());
                try {
                    u().f();
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
                        if (this.f36587a) {
                            il.b.j("reach the end of the file, only read some");
                        }
                        i10 = u().o();
                    }
                    if (i10 > 0) {
                        if (v().N()) {
                            for (int i13 = i10; i13 > 0; i13 -= 16) {
                                if (i13 >= 16) {
                                    int i14 = i10 - i13;
                                    System.arraycopy(this.B.a(bArr, i14, 16), 0, bArr, i14, 16);
                                    if (v().r() == 0) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (T((short) 1539, bArr, i10)) {
                            u().b(i10);
                            B();
                        }
                        O();
                        k();
                    } else if (u().t()) {
                        il.b.g("image file has already been send over");
                        return;
                    } else {
                        il.b.e("Error while reading file with size: " + i10);
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

    public final boolean r0(byte[] bArr, int i10) {
        short a10 = a(bArr, i10);
        if (this.f36587a) {
            il.b.j(String.format("<< CMD_OTA_BUFFER_CHECK(0x%04X)", (short) 1544));
        }
        S((short) 1544, new byte[]{(byte) (i10 & 255), (byte) (i10 >> 8), (byte) (a10 & 255), (byte) ((a10 >> 8) & 255)});
        if (this.f36587a) {
            il.b.j(String.format("... waiting EVENT_OTA_BUFFER_CHECK(0x%04X)response", (short) 1542));
        }
        byte[] b02 = b0();
        byte b10 = b02[0];
        if (b10 == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(b02);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i11 = wrap.getInt(1);
            this.P = i11;
            if (this.f36587a) {
                il.b.c(String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P)));
            }
            return true;
        } else if (b10 == 5 || b10 == 6 || b10 == 7) {
            return false;
        } else {
            if (b10 != 8) {
                throw new OtaException("ERROR_OPCODE_RESPONSE_NOT_SUPPORTED", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
            }
            throw new OtaException("DFU_STATUS_FLASH_ERASE_ERROR", b10 | 512);
        }
    }

    public final int s0(String str) {
        BluetoothDevice bluetoothDevice;
        int i10;
        G(256);
        this.C = 0;
        this.f36597k = false;
        try {
            bluetoothDevice = this.f37629k0.getRemoteDevice(str);
        } catch (Exception e10) {
            il.b.e(e10.toString());
            bluetoothDevice = null;
        }
        if (bluetoothDevice == null) {
            return 4112;
        }
        il.b.k(this.f36587a, "connecting to " + fl.a.c(str, true));
        G0().e(this.f29648w0);
        G0().f(bluetoothDevice, null);
        try {
            synchronized (this.f36598l) {
                if (!this.f36597k && this.C == 0) {
                    il.b.d(this.f36587a, "wait for connect for 32000 ms");
                    this.f36598l.wait(32000L);
                }
            }
        } catch (InterruptedException e11) {
            il.b.l("Sleeping interrupted : " + e11.toString());
            this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
        }
        if (this.C == 0) {
            if (!this.f36597k) {
                il.b.l("wait for connect, but can not connect with no callback");
                i10 = DfuException.ERROR_CONNECTION_TIMEOUT;
            } else if (this.f36599m != 515) {
                il.b.l("connect with some error, please check. mConnectionState" + this.f36599m);
                i10 = DfuException.ERROR_CONNECT_ERROR;
            }
            this.C = i10;
        }
        if (this.C == 0) {
            il.b.k(this.f36587a, "connected the device which going to upgrade");
        } else if (this.f36599m == 256) {
            G(0);
        }
        return this.C;
    }

    public final void t0(int i10) {
        h0(i10, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (r10 != (u().f() + 12)) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[Catch: IOException -> 0x01f8, TryCatch #0 {IOException -> 0x01f8, blocks: (B:13:0x0046, B:15:0x004b, B:17:0x0056, B:18:0x0063, B:20:0x0067, B:22:0x008f, B:23:0x009f, B:24:0x00b1, B:27:0x00b7, B:28:0x00c6, B:30:0x00d0, B:32:0x00dc, B:34:0x00f2, B:36:0x00f6), top: B:73:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0 A[Catch: IOException -> 0x01f8, TryCatch #0 {IOException -> 0x01f8, blocks: (B:13:0x0046, B:15:0x004b, B:17:0x0056, B:18:0x0063, B:20:0x0067, B:22:0x008f, B:23:0x009f, B:24:0x00b1, B:27:0x00b7, B:28:0x00c6, B:30:0x00d0, B:32:0x00dc, B:34:0x00f2, B:36:0x00f6), top: B:73:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0117 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u0(wl.a aVar) {
        int i10;
        int i11;
        if (this.f36587a) {
            il.b.j("updateImageWithCheckBufferForBeeUpdate");
        }
        this.C = 0;
        this.f36606t = false;
        int i12 = 0;
        while (!this.f36606t) {
            if (!this.f36594h) {
                int i13 = this.R;
                byte[] bArr = new byte[i13];
                int i14 = this.S;
                byte[] bArr2 = new byte[i14];
                while (true) {
                    Locale locale = Locale.US;
                    il.b.j(String.format(locale, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.P), Integer.valueOf(this.P)));
                    if (i12 <= 0) {
                        try {
                            int i15 = this.P;
                            if (i15 != -1) {
                            }
                            i10 = this.P;
                            if (i10 != 0) {
                                System.arraycopy(this.f36609w.E(), 0, bArr, 0, 12);
                                int i16 = i13 - 12;
                                byte[] bArr3 = new byte[i16];
                                System.arraycopy(bArr3, 0, bArr, 12, this.f36609w.i0(bArr3, i16));
                                u().c(12);
                                u().y(0);
                                i11 = i13;
                            } else if (i10 == 12) {
                                i11 = this.f36609w.i0(bArr, i13 - 12);
                                u().y(0);
                            } else {
                                i11 = this.f36609w.i0(bArr, Math.min(this.R, this.f36609w.k0()));
                            }
                            if (this.f36587a) {
                                il.b.j(String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
                            }
                            if (u().o() < i11) {
                                i11 = u().o();
                                if (this.f36587a) {
                                    il.b.c("File in the middle, only read some,  checkImageBufferSize: " + i11);
                                }
                            }
                            if (i11 != i13 && this.f36587a) {
                                il.b.c("Reach the bottom of the image: " + i11);
                            }
                            il.b.j(u().toString());
                            if (i11 <= 0) {
                                int i17 = 0;
                                while (i17 < i11) {
                                    int min = Math.min(i14, i11 - i17);
                                    System.arraycopy(bArr, i17, bArr2, 0, min);
                                    if (v().N()) {
                                        int i18 = 0;
                                        while (true) {
                                            if (i18 < min) {
                                                int min2 = Math.min(min - i18, 16);
                                                if (min2 < 16) {
                                                    il.b.d(this.f36588b, "encryptSize < 16, no need to encrypt:" + min2);
                                                    break;
                                                }
                                                byte[] a10 = this.B.a(bArr2, i18, 16);
                                                System.arraycopy(a10, 0, bArr2, i18, 16);
                                                System.arraycopy(a10, 0, bArr, i17 + i18, 16);
                                                i18 += 16;
                                                if (v().r() == 0) {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    i17 += min;
                                    if (T((short) 1539, bArr2, min)) {
                                        u().b(min);
                                        B();
                                    }
                                    O();
                                }
                                boolean r02 = r0(bArr, i11);
                                if (!r02) {
                                    i12++;
                                    il.b.c("check failed, retransTimes: " + i12);
                                } else {
                                    i12 = 0;
                                }
                                if (i12 < 3) {
                                    if (r02) {
                                        break;
                                    }
                                } else {
                                    il.b.l("Error while buffer check, reach max try times: " + i12 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                                    throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                                }
                            } else if (u().t()) {
                                il.b.g("image file has already been send over");
                            } else {
                                il.b.e("Error while reading file with size: " + i11);
                                throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                            }
                        } catch (IOException unused) {
                            throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                        }
                    }
                    il.b.c("the last sent to remote may not alignment, reinstall input stream");
                    Q();
                    i(this.P, true);
                    i10 = this.P;
                    if (i10 != 0) {
                    }
                    if (this.f36587a) {
                    }
                    if (u().o() < i11) {
                    }
                    if (i11 != i13) {
                        il.b.c("Reach the bottom of the image: " + i11);
                    }
                    il.b.j(u().toString());
                    if (i11 <= 0) {
                    }
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final void v0(int i10) {
        jm.a a10 = new a.b(i10).a();
        il.b.k(this.f36587a, a10.toString());
        S(a10.b(), a10.a());
        il.b.k(this.f36587a, "... Reading CMD_OTA_IMAGE_INFO notification");
        i b10 = i.b(b0());
        if (b10 == null || b10.c() != 1) {
            il.b.l(String.format("0x%02X, Get target image info failed", Integer.valueOf((int) DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
            throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        if (this.f36587a) {
            il.b.j(b10.toString());
        }
        this.P = b10.d();
    }

    public final void w0(String str) {
        if (!this.f36594h) {
            D(516);
            int f02 = f0(str, t().B());
            if (f02 != 0) {
                if (f02 != 4128) {
                    il.b.c(String.format("connect failed:0x%04X", Integer.valueOf(f02)));
                    L(a0());
                    int f03 = f0(str, t().B());
                    if (f03 != 0) {
                        if (f03 == 4128) {
                            throw new OtaException("aborted, connectRemoteDevice failed", f03);
                        }
                        throw new OtaException("connectRemoteDevice failed", f03);
                    }
                    return;
                }
                throw new OtaException("aborted, connectRemoteDevice failed", f02);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void x0(int i10) {
        String str;
        boolean z10;
        int i11 = this.P;
        if (i11 == 0) {
            this.P = 12;
            z10 = this.f36587a;
            str = String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", 12, Integer.valueOf(this.P));
        } else {
            z10 = this.f36587a;
            str = String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P));
        }
        il.b.d(z10, str);
        int f10 = u().f();
        int i12 = this.P;
        if (f10 != i12 && i12 != -1) {
            il.b.l("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
    }

    public final void y0(int i10) {
        int i11 = this.f36599m;
        if (!(i11 == 0 || i11 == 1280)) {
            D0();
        }
        B0();
        if (this.f36587a) {
            il.b.c(String.format("terminateConnection, error = 0x%04X", Integer.valueOf(i10)));
        }
    }

    public final void z0(int i10) {
        byte[] bArr = {(byte) (i10 & 255), (byte) ((i10 >> 8) & 255)};
        il.b.d(this.f36587a, String.format("<< CMD_OTA_VALID (0x%04X)", (short) 1540));
        if (S((short) 1540, bArr)) {
            il.b.d(this.f36587a, "... waiting CMD_OTA_VALID response");
            byte b10 = Y(ab.Y)[0];
            if (b10 != 1) {
                Object[] objArr = new Object[1];
                if (b10 == 5) {
                    objArr[0] = Byte.valueOf(b10);
                    il.b.e(String.format("0x%02X, Validate FW failed, CRC check error", objArr));
                    throw new OtaException("Validate FW failed", DfuException.ERROR_REMOTE_CRC_ERROR);
                }
                objArr[0] = Byte.valueOf(b10);
                il.b.e(String.format("0x%02X(not supported), Validate FW failed", objArr));
                throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
            }
            return;
        }
        throw new OtaException("Validate FW failed", 512);
    }
}
