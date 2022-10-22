package km;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import b.c;
import b.d;
import b.e;
import com.alipay.sdk.app.PayTask;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.tendcloud.tenddata.ab;
import il.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.Set;
import km.b;
import km.h;
import km.p;
/* loaded from: classes2.dex */
public class k extends im.a {

    /* renamed from: w0  reason: collision with root package name */
    public int f30036w0;

    /* renamed from: x0  reason: collision with root package name */
    public boolean f30037x0;

    /* renamed from: y0  reason: collision with root package name */
    public d f30038y0 = new a();

    /* loaded from: classes2.dex */
    public class a extends d {
        public a() {
        }

        @Override // b.d
        public void a(b.a aVar) {
            super.a(aVar);
            k.this.j0(aVar);
        }

        @Override // b.d
        public void b(BluetoothDevice bluetoothDevice, boolean z10, int i10) {
            super.b(bluetoothDevice, z10, i10);
            if (i10 == 512) {
                k.this.G(515);
            } else if (i10 == 0) {
                if (k.this.f36607u == 521) {
                    k kVar = k.this;
                    kVar.C = 2048;
                    if (kVar.f36587a) {
                        b.c("disconnect in OTA process, mErrorState: " + k.this.C);
                    }
                }
                k.this.G(0);
                synchronized (k.this.f36600n) {
                    k.this.f36601o = false;
                    k.this.f36600n.notifyAll();
                }
            } else {
                return;
            }
            k.this.A();
            k.this.s();
        }

        @Override // b.d
        public void c(e eVar) {
            super.c(eVar);
            k.this.k0(eVar);
        }
    }

    public k(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
    }

    public void A0(int i10) {
        h a10 = new h.b(i10).a();
        b.k(this.f36587a, a10.toString());
        S(a10.b(), a10.a());
        b.k(this.f36588b, "... Reading CMD_OTA_IMAGE_INFO notification");
        i b10 = i.b(b0());
        if (b10 == null || b10.f30031b != 1) {
            b.l(String.format("0x%02X, Get target image info failed", Integer.valueOf((int) DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
            throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        if (this.f36587a) {
            b.j(b10.toString());
        }
        this.P = b10.d();
        this.Q = b10.a();
    }

    public boolean B0(int i10) {
        byte[] bArr = {(byte) (i10 & 255)};
        b.k(this.f36587a, String.format("<< CMD_OTA_ROLE_SWAP (0x%04X)", (short) 1553));
        if (S((short) 1553, bArr)) {
            b.k(this.f36588b, "... waiting CMD_OTA_ROLW_SWAP response");
            byte b10 = Y(ab.Y)[0];
            if (b10 == 1) {
                b.d(this.f36587a, "role swap operation done");
                return true;
            }
            b.l(String.format("role swap failed, maybe b2b disconnect, status=0x%02X", Byte.valueOf(b10)));
            throw new OtaException(String.format("roleSwap failed, status=0x%02X", Byte.valueOf(b10)), DfuException.ERROR_DFU_ROLE_SWAP_FAILED);
        }
        throw new OtaException("roleSwap failed", 512);
    }

    public void C0(int i10) {
        int i11 = this.f36599m;
        if (!(i11 == 0 || i11 == 1280)) {
            E0();
        }
        D0();
        b.d(this.f36587a, String.format("terminateConnection, error = 0x%04X", Integer.valueOf(i10)));
    }

    public void D0() {
        G0().r();
        G0().n(this.f30038y0);
        G(1280);
    }

    public void E0() {
        int i10 = this.f36599m;
        if (i10 == 0 || i10 == 1280) {
            b.d(this.f36587a, "already disconnect");
            return;
        }
        G0().r();
        I();
    }

    @Override // im.a, xl.a
    public void F() {
        super.F();
        c cVar = this.f28341v0;
        if (cVar != null) {
            cVar.n(this.f30038y0);
        }
    }

    public boolean F0() {
        b.k(this.f36587a, String.format("<< CMD_OTA_BUFFER_CHECK_ENABLE (0x%04X)", (short) 1543));
        if (!S((short) 1543, null)) {
            b.c("enableBufferCheck failed");
            return false;
        }
        try {
            b.k(this.f36587a, "... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE response");
            d a10 = d.a(Y(PayTask.f6879j));
            b.k(this.f36587a, a10.toString());
            if (a10.f30025b != 1) {
                b.c("enableBufferCheck failed");
                return false;
            }
            int i10 = v().f6005k >= 6 ? v().V : a10.f30027d;
            b(a10.f30026c);
            W(i10);
            return true;
        } catch (DfuException unused) {
            b.l("wait EnableBufferCheckRsp timeout");
            this.C = DfuException.ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE;
            throw new OtaException("Unable to receive notification", DfuException.ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE);
        }
    }

    public c G0() {
        if (this.f28341v0 == null) {
            c H = c.H();
            this.f28341v0 = H;
            H.e(this.f30038y0);
        }
        return this.f28341v0;
    }

    public void H0() {
        b.k(this.f36588b, "processRoleSwapProcedure ...");
        if (v().f6005k <= 5) {
            o0(false);
        } else {
            int i10 = 1;
            this.f30037x0 = true;
            if (v().t() == 1) {
                i10 = 2;
            } else {
                v().t();
            }
            this.f30036w0 = i10;
            B0(0);
        }
        D(522);
        try {
            b.d(this.f36587a, "wait master to handover ...");
            Thread.sleep(t().m() * 1000);
        } catch (InterruptedException unused) {
        }
    }

    public void I0() {
        byte[] bArr;
        if (v().f6005k <= 5) {
            b.k(this.f36587a, String.format("<< CMD_OTA_GET_IMAGE_INFO (0x%04X)", (short) 1537));
            bArr = r0((short) 1537);
        } else {
            b.k(this.f36587a, String.format("<< CMD_OTA_GET_IMAGE_INFO (0x%04X), bank=0x00", (short) 1537));
            bArr = u0((short) 1537, new byte[]{0});
        }
        v().j0(bArr);
    }

    public void J0() {
        b.k(this.f36587a, String.format("<< CMD_OTA_IMAGE_SECTION_SIZE_INFO (0x%04X)", (short) 1546));
        v().i0(r0((short) 1546));
    }

    public void K0() {
        if (v().f6005k <= 5) {
            b.k(this.f36587a, String.format("<< CMD_GET_INACTIVE_BANK_IMAGE_INFO (0x%04X)", (short) 1550));
            v().k0(r0((short) 1550));
            return;
        }
        b.k(this.f36587a, String.format("<< CMD_OTA_GET_IMAGE_INFO (0x%04X), bank=0x01", (short) 1537));
        v().j0(u0((short) 1537, new byte[]{1}));
    }

    public boolean L0() {
        b.d(this.f36587a, String.format("<< CMD_GET_TARGET_INFO (0x%04X)", (short) 1536));
        byte[] r02 = r0((short) 1536);
        if (r02 != null) {
            v().X(r02);
            return true;
        }
        b.l("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public boolean M0() {
        try {
            if (this.f36587a) {
                b.j(String.format("<< CMD_OTA_RESET (0x%04X)", (short) 1541));
            }
            return V((short) 1541, null, true);
        } catch (DfuException e10) {
            b.l(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e10.getErrCode())));
            this.C = 0;
            return false;
        }
    }

    public void N0() {
        f0((byte) 0);
    }

    public byte d0(int i10, byte[] bArr) {
        if (bArr == null || bArr.length != 32) {
            b.j("invalid sha256:" + jl.a.a(bArr));
            return (byte) 0;
        }
        if (this.f36587a) {
            b.j(String.format(Locale.US, "checkImage:imageId=0x%04X, sha256=%s", Integer.valueOf(i10), jl.a.a(bArr)));
        }
        byte[] bArr2 = new byte[36];
        bArr2[0] = 1;
        bArr2[1] = 0;
        bArr2[2] = (byte) (i10 & 255);
        bArr2[3] = (byte) ((i10 >> 8) & 255);
        System.arraycopy(bArr, 0, bArr2, 4, 32);
        if (this.f36587a) {
            b.j(String.format("<< CMD_CHECK_IMAGE (0x%04X)", (short) 1552));
        }
        if (S((short) 1552, bArr2)) {
            b.k(this.f36587a, "... waiting CMD_CHECK_IMAGE response");
            byte[] Y = Y(ab.Y);
            if (Y == null || Y.length < 2) {
                return (byte) 0;
            }
            ByteBuffer wrap = ByteBuffer.wrap(Y);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i11 = (((short) (wrap.get(1) & 255)) << 8) | ((short) (wrap.get(0) & 255));
            byte b10 = wrap.get(2);
            if (this.f36587a) {
                b.j(String.format(Locale.US, "image_Id=%d,result=0x%02X ", Integer.valueOf(i11), Byte.valueOf(b10)));
            }
            return b10;
        }
        throw new OtaException("checkImage failed", 512);
    }

    public int e0(String str, int i10) {
        int i11 = 0;
        while (e()) {
            int v02 = v0(str);
            if (v02 == 0) {
                return 0;
            }
            if ((v02 & (-2049)) != 133) {
                E0();
            } else {
                b.m(this.f36587a, "connect fail with GATT_ERROR, do not need disconnect");
            }
            G(1280);
            try {
                Thread.sleep(1600L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            i11++;
            if (i11 > i10) {
                return v02;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public void f0(byte b10) {
        p c10 = new p.b().b(this.f36609w.x()).a(b10).c();
        b.k(this.f36587a, c10.toString());
        if (v().N()) {
            S(c10.b(), this.B.a(c10.a(), 0, 16));
        } else {
            S(c10.b(), c10.a());
        }
        b.k(this.f36588b, "... Reading CMD_OTA_START notification");
        byte b11 = b0()[0];
        if (b11 != 1) {
            b.l(String.format("start dfu failed, status=0x%02X", Byte.valueOf(b11)));
            throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
    }

    public void g0(byte b10, boolean z10) {
        if (q0(new byte[]{b10})) {
            if (z10) {
                if (o()) {
                    I();
                } else {
                    b.c("device already disconnected");
                }
                C0(0);
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
            boolean z11 = this.f36587a;
            b.h(z11, "start to re-connect the RCU which going to active image, current state is: " + this.f36599m);
            int e02 = e0(this.E, t().B());
            if (e02 != 0) {
                b.l("Something error in OTA process, errorCode: " + e02 + "mProcessState" + this.f36607u);
                i0(e02, true);
                return false;
            }
        }
        if (z10) {
            try {
                o0(true);
                if (t().I(1)) {
                    al.b.g().d(this.f37629k0.getRemoteDevice(this.E));
                    al.b.g().e(this.E);
                }
                D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            } catch (DfuException e10) {
                e10.printStackTrace();
                z0(e10.getErrCode());
            }
        } else {
            M0();
            i0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, true);
        }
        return true;
    }

    public void h0(int i10, byte b10) {
        byte[] bArr = {(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), b10};
        b.k(this.f36587a, String.format("<< CMD_OTA_VALID (0x%04X)", (short) 1540));
        if (S((short) 1540, bArr)) {
            b.k(this.f36588b, "... waiting CMD_OTA_VALID response");
            byte b11 = Y(ab.Y)[0];
            if (b11 == 1) {
                b.k(this.f36588b, "validate success");
            } else if (b11 == 5) {
                b.l(String.format("0x%02X, Validate FW failed", Byte.valueOf(b11)));
                throw new OtaException("Validate FW failed", DfuException.ERROR_REMOTE_CRC_ERROR);
            } else {
                b.l(String.format("Validate FW failed, status=0x%02X", Byte.valueOf(b11)));
                throw new OtaException("Validate FW failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
            }
        } else {
            throw new OtaException("Validate FW failed", 512);
        }
    }

    public void i0(int i10, boolean z10) {
        if (this.f36594h) {
            i10 = 4128;
        }
        if (this.f36587a) {
            b.j(String.format("error = 0x%04X, needReset=%b", Integer.valueOf(i10), Boolean.valueOf(z10)));
        }
        if (i10 != 4128) {
            E(DfuException.ERROR_CONNECTION_TIMEOUT, true);
        }
        if (z10) {
            M0();
        }
        el.a aVar = this.f28334o0;
        if (aVar != null) {
            aVar.o();
        }
        if (t().K(1)) {
            C0(i10);
        }
        m(this.f36609w);
        xl.b bVar = this.f36592f;
        if (bVar != null) {
            bVar.a(i10);
        }
        this.f36594h = true;
    }

    public final void j0(b.a aVar) {
        short e10 = aVar.e();
        byte a10 = aVar.a();
        if (this.f28340u0.containsKey(Short.valueOf(e10))) {
            this.f28340u0.put(Short.valueOf(e10), aVar);
        }
        if (e10 != 1536) {
            switch (e10) {
                case 1538:
                case 1539:
                case 1540:
                case 1541:
                case 1542:
                case 1543:
                case 1544:
                case 1545:
                    break;
                default:
                    switch (e10) {
                        case 1551:
                        case 1552:
                        case 1553:
                        case 1554:
                            break;
                        default:
                            return;
                    }
            }
            if (aVar.a() == 0) {
                this.f36605s = false;
            } else {
                this.f36605s = true;
            }
            s();
            return;
        }
        b.j("ACK-CMD_OTA_GET_DEVICE_INFO");
        if (a10 == 2 || a10 == 1) {
            b.l("CMD_OTA_GET_DEVICE_INFO not support");
            this.C = DfuException.ERROR_DFU_SPP_OTA_NOT_SUPPORTED;
            this.f36602p = null;
            this.f28339t0.remove((short) 1536);
            C();
        }
    }

    public final void k0(e eVar) {
        short a10 = eVar.a();
        eVar.h();
        byte[] g10 = eVar.g();
        switch (a10) {
            case 1536:
            case 1537:
            case 1544:
            case 1545:
            case 1549:
                short s10 = (short) (a10 & 65535);
                if (this.f28339t0.contains(Short.valueOf(s10))) {
                    this.f28339t0.remove(Short.valueOf(s10));
                    this.f36602p = g10;
                    C();
                    return;
                }
                b.c(String.format("not expect event: 0x%04X", Short.valueOf(s10)));
                return;
            case 1538:
            case 1540:
            case 1541:
            case 1542:
            case 1543:
            case 1547:
            case 1550:
            case 1551:
            case 1552:
                synchronized (this.L) {
                    this.f28337r0 = g10;
                    this.f28338s0 = true;
                    this.L.notifyAll();
                }
                return;
            case 1539:
            case 1546:
            case 1548:
            default:
                return;
        }
    }

    public void o0(boolean z10) {
        if (q0(null)) {
            if (z10) {
                if (o()) {
                    I();
                } else {
                    b.c("device already disconnected");
                }
                C0(0);
            }
            m(this.f36609w);
        }
    }

    public boolean p0(wl.a aVar, int i10, int i11) {
        b.k(this.f36587a, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(aVar.k0()), Integer.valueOf(i10), Integer.valueOf(i11)));
        return aVar.k0() + i10 > i11;
    }

    public boolean q0(byte[] bArr) {
        D(524);
        int i10 = DfuException.ERROR_DFU_ABORTED;
        boolean z10 = true;
        boolean z11 = false;
        try {
            b.d(this.f36587a, String.format("<< CMD_OTA_ACTIVE_RESET(0x%04X)", (short) 1542));
            z10 = S((short) 1542, bArr);
        } catch (DfuException e10) {
            if (e10.getErrCode() != 4128) {
                if (v().f6005k >= 4) {
                    b.c(String.format("activeImageAndReset failed, errorcode= 0x%04X", Integer.valueOf(e10.getErrCode())));
                } else if (!t().S()) {
                    b.c("active cmd has no response, ignore");
                } else {
                    b.l("active cmd has no response, notify error");
                }
                i10 = e10.getErrCode();
            }
            z10 = false;
        }
        i10 = 0;
        if (z10 && v().f6005k >= 4) {
            try {
                b.d(this.f36587a, "... Reading CMD_OTA_ACTIVE_RESET notification");
                Y(1600L);
            } catch (DfuException e11) {
                b.l("Read CMD_OTA_ACTIVE_RESET notification failed");
                i10 = e11.getErrCode();
            }
        }
        z11 = z10;
        if (z11) {
            b.c("image active success");
            return z11;
        }
        throw new OtaException(i10);
    }

    public byte[] r0(short s10) {
        return u0(s10, null);
    }

    public boolean s0(wl.a aVar) {
        return (aVar.f36309i == 11 && aVar.w() == 520) || this.f36609w.v() == 0 || this.f36609w.V() == 0;
    }

    public boolean t0(byte[] bArr, int i10) {
        b b10 = new b.C0368b().a(bArr, i10).b();
        il.b.k(this.f36587a, b10.toString());
        S(b10.c(), b10.b());
        il.b.k(this.f36587a, String.format("... waiting EVENT_OTA_BUFFER_CHECK(0x%04X)response", (short) 1542));
        km.a a10 = km.a.a(b0());
        byte b11 = a10.f30018b;
        if (b11 == 1) {
            int i11 = a10.f30019c;
            this.P = i11;
            il.b.d(this.f36587a, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P)));
            return true;
        } else if (b11 == 5 || b11 == 6 || b11 == 7) {
            il.b.l(String.format("buffer check failed, status=0x%02X ", Byte.valueOf(b11)));
            return false;
        } else if (b11 != 8) {
            throw new OtaException("ERROR_OPCODE_RESPONSE_NOT_SUPPORTED", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        } else {
            throw new OtaException("DFU_STATUS_FLASH_ERASE_ERROR", b11 | 512);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] u0(short s10, byte[] bArr) {
        short s11;
        Set<Short> set;
        this.C = 0;
        this.f36602p = null;
        short s12 = 1536;
        if (s10 != 1536) {
            s12 = 1537;
            if (s10 != 1537) {
                if (s10 == 1546) {
                    set = this.f28339t0;
                    s11 = 1544;
                } else if (s10 != 1547) {
                    if (s10 == 1550) {
                        set = this.f28339t0;
                        s11 = 1549;
                    }
                    this.f36601o = false;
                    if (!G0().k(s10, bArr)) {
                        return null;
                    }
                    synchronized (this.f36600n) {
                        try {
                            if (this.C == 0 && !this.f36601o && this.f36599m == 515) {
                                this.f36600n.wait(15000L);
                            }
                        } catch (InterruptedException e10) {
                            il.b.l("sleeping interrupted:" + e10);
                            this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                        }
                    }
                    if (this.C == 0 && !this.f36601o) {
                        il.b.d(this.f36588b, "read value but no callback");
                        this.C = DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK;
                    }
                    if (this.C == 0) {
                        return this.f36602p;
                    }
                    throw new OtaException("Error while send command", this.C);
                } else {
                    set = this.f28339t0;
                    s11 = 1545;
                }
                set.add(Short.valueOf(s11));
                this.f36601o = false;
                if (!G0().k(s10, bArr)) {
                }
            }
        }
        this.f28339t0.add(Short.valueOf(s12));
        this.f36601o = false;
        if (!G0().k(s10, bArr)) {
        }
    }

    public int v0(String str) {
        BluetoothDevice bluetoothDevice;
        int i10;
        G(256);
        this.C = 0;
        this.f36597k = false;
        try {
            bluetoothDevice = this.f37629k0.getRemoteDevice(str);
        } catch (Exception e10) {
            il.b.l(e10.toString());
            bluetoothDevice = null;
        }
        if (bluetoothDevice == null) {
            return 4112;
        }
        il.b.k(this.f36587a, "connecting to " + fl.a.c(str, true));
        G0().e(this.f30038y0);
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
            il.b.k(this.f36588b, "connected the device which going to upgrade");
        } else if (this.f36599m == 256) {
            G(0);
        }
        return this.C;
    }

    public boolean w0(int i10) {
        byte[] bArr = {(byte) (i10 & 255), (byte) ((i10 >> 8) & 255)};
        il.b.k(this.f36587a, String.format("<< CMD_COPY_IMAGE (0x%04X)", (short) 1551));
        if (S((short) 1551, bArr)) {
            il.b.k(this.f36588b, "... waiting CMD_COPY_IMAGE response");
            byte b10 = Y(ab.Y)[0];
            if (b10 == 1) {
                return true;
            }
            il.b.l(String.format("copyImage failed, status=0x%02X", Byte.valueOf(b10)));
            throw new OtaException("copyImage failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
        throw new OtaException("copyImage failed", 512);
    }

    public void x0(String str) {
        if (!this.f36594h) {
            D(516);
            int e02 = e0(str, t().B());
            if (e02 != 0) {
                if (e02 != 4128) {
                    il.b.c(String.format("connect failed:0x%04X", Integer.valueOf(e02)));
                    L(a0());
                    int e03 = e0(str, t().B());
                    if (e03 != 0) {
                        if (e03 == 4128) {
                            throw new OtaException("aborted, connectRemoteDevice failed", e03);
                        }
                        throw new OtaException("connectRemoteDevice failed", e03);
                    }
                    return;
                }
                throw new OtaException("aborted, connectRemoteDevice failed", e02);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public boolean y0(int i10) {
        return i10 == 1024 || i10 == 1040 || i10 == 1280 || i10 == 1538 || i10 == 2304;
    }

    public void z0(int i10) {
        i0(i10, false);
    }
}
