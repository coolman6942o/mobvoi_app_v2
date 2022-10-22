package com.realsil.sdk.dfu.v;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Build;
import cm.d;
import com.realsil.sdk.core.usb.GlobalUsbGatt;
import com.realsil.sdk.core.usb.UsbGatt;
import com.realsil.sdk.core.usb.UsbGattCallback;
import com.realsil.sdk.core.usb.UsbGattCharacteristic;
import com.realsil.sdk.core.usb.UsbGattImpl;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import gm.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import xl.b;
/* loaded from: classes2.dex */
public class a extends b {
    public UsbGattCharacteristic A0;

    /* renamed from: r0  reason: collision with root package name */
    public UsbGattCharacteristic f22287r0;

    /* renamed from: s0  reason: collision with root package name */
    public UsbGattCharacteristic f22288s0;

    /* renamed from: t0  reason: collision with root package name */
    public UsbGattCharacteristic f22289t0;

    /* renamed from: u0  reason: collision with root package name */
    public UsbGattCharacteristic f22290u0;

    /* renamed from: v0  reason: collision with root package name */
    public UsbGattCharacteristic f22291v0;

    /* renamed from: w0  reason: collision with root package name */
    public List<UsbGattCharacteristic> f22292w0;

    /* renamed from: z0  reason: collision with root package name */
    public UsbGattCharacteristic f22295z0;

    /* renamed from: x0  reason: collision with root package name */
    public UUID f22293x0 = g.f27505b;

    /* renamed from: y0  reason: collision with root package name */
    public UUID f22294y0 = g.f27506c;
    public final UsbGattCallback B0 = new C0247a(this);

    /* renamed from: com.realsil.sdk.dfu.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0247a extends UsbGattCallback {
        public C0247a(a aVar) {
        }
    }

    public a(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
    }

    public final boolean A0() {
        q0(this.E);
        z0();
        if (!this.f36595i) {
            D0();
        } else {
            L();
        }
        if (this.f36609w != null) {
            return true;
        }
        t0(4097);
        return false;
    }

    public boolean B0() {
        return this.I == 16;
    }

    public final boolean C0() {
        wl.a aVar;
        D(514);
        this.E = this.F;
        this.f36596j = this.I != 0;
        boolean z10 = false;
        while (e()) {
            try {
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errCode = e10.getErrCode();
                if (errCode == 4128) {
                    g0(errCode, true);
                } else {
                    if (!(errCode == 4097 || errCode == 265)) {
                        a0();
                    }
                    g0(errCode, false);
                }
            }
            if (!A0() || !c0()) {
                return false;
            }
            this.f36612z += u().f();
            if (u().u()) {
                il.b.c("no pendding image file to upload.");
                u().x(this.f36612z);
                if (!this.J) {
                    D(523);
                } else {
                    y0();
                    D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
                }
                z10 = true;
            } else {
                il.b.c("has pendding image file to upload");
                if (v().K() == 1) {
                    this.E = this.F;
                    this.f36596j = this.I != 0;
                    this.f36612z = 0;
                    y0();
                } else if (v().K() == 3 && (aVar = this.f36610x) != null && k0(aVar, this.f36612z, v().C * 4096)) {
                    il.b.g("make device to enter the ota advertiser mode, and let the app continue update image");
                    this.f36596j = true;
                    this.f36612z = 0;
                    e0((byte) 1);
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
        g0(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }

    public final void D0() {
        this.f36595i = false;
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.M = new d(this.f36590d, 2);
        G0();
        if (v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 11 || v().f6004j == 12) {
            H0();
        }
        E0();
        if (this.f36587a) {
            il.b.c(v().toString());
        }
        M();
        List<wl.a> list = this.f36608v;
        if (list != null && list.size() > 0) {
            for (wl.a aVar : this.f36608v) {
                aVar.Q();
            }
        }
        this.f36595i = true;
        il.b.c("Ota Environment prepared.");
    }

    public final void E0() {
        int i10;
        int i11;
        if (v().f6005k == 0) {
            if (this.f22289t0 != null) {
                il.b.j("read patch version");
                byte[] V = V(this.f22289t0);
                if (V != null) {
                    try {
                        ByteBuffer wrap = ByteBuffer.wrap(V);
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
                        il.b.e(e10.toString());
                    }
                }
            }
            if (this.f22288s0 != null) {
                il.b.j("read app version");
                byte[] V2 = V(this.f22288s0);
                if (V2 != null) {
                    try {
                        ByteBuffer wrap2 = ByteBuffer.wrap(V2);
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
            if (this.f22290u0 != null) {
                il.b.j("read patch extension version");
                byte[] V3 = V(this.f22290u0);
                if (V3 != null) {
                    ByteBuffer wrap3 = ByteBuffer.wrap(V3);
                    wrap3.order(ByteOrder.LITTLE_ENDIAN);
                    v().m0(wrap3.getShort(0) & 65535);
                    return;
                }
                return;
            }
            return;
        }
        List<UsbGattCharacteristic> list = this.f22292w0;
        byte[] bArr = null;
        if (list == null || list.size() <= 0) {
            v().d0(null);
            il.b.l("no ImageVersionCharacteristics to read");
            return;
        }
        for (UsbGattCharacteristic usbGattCharacteristic : this.f22292w0) {
            il.b.j(this.f36587a ? "read image version : " + usbGattCharacteristic.getUuid().toString() : "read image version");
            byte[] V4 = V(usbGattCharacteristic);
            if (V4 != null) {
                if (bArr == null) {
                    bArr = V4;
                } else {
                    byte[] bArr2 = new byte[bArr.length + V4.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(V4, 0, bArr2, bArr.length, V4.length);
                    bArr = bArr2;
                }
            }
        }
        v().d0(bArr);
    }

    public final byte[] F0() {
        return o0(t().t());
    }

    public final boolean G0() {
        if (this.f22291v0 == null) {
            return false;
        }
        il.b.k(this.f36587a, "start to read remote dev info");
        byte[] V = V(this.f22291v0);
        if (V != null) {
            v().T(V);
            b(v().B);
            return true;
        }
        il.b.e("Get dev info failed");
        throw new OtaException("get remote dev info failed", 270);
    }

    public final boolean H0() {
        if (this.f22287r0 == null) {
            return false;
        }
        il.b.k(this.f36587a, "start to read remote dev Mac Addr info");
        byte[] V = V(this.f22287r0);
        if (V == null || V.length < 6) {
            il.b.e("Get remote dev Mac Addr info failed, do nothing.");
            throw new OtaException("remote dev Mac Addr info error", DfuException.ERROR_READ_REMOTE_MAC_ADDR);
        }
        byte[] bArr = new byte[6];
        System.arraycopy(V, 0, bArr, 0, 6);
        v().h0(bArr);
        return true;
    }

    public final void I0() {
        il.b.c("<<  OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE(0x0A)");
        T(this.f22295z0, new byte[]{10}, false);
        il.b.d(this.f36587a, "... Reading OPCODE_DFU_REPORT_CURRENT_BUFFER_SIZE notification");
        byte[] F0 = F0();
        byte b10 = F0[2];
        if (b10 == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(F0);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i10 = wrap.getInt(3);
            il.b.j(String.format(Locale.US, "maxBufferCheckSize=(0x%04X, %d)", Integer.valueOf(i10), Integer.valueOf(i10)));
            b(i10);
            return;
        }
        il.b.l("Get remote buffer size info failed, status: " + ((int) b10));
        throw new OtaException("Get remote buffer size info failed", b10 | 512);
    }

    public final int J0() {
        if (this.f22295z0 == null) {
            il.b.l("no mControlPointCharacteristic found");
            return 0;
        }
        il.b.c("<< OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE(0x09)");
        T(this.f22295z0, new byte[]{9}, false);
        try {
            il.b.d(this.f36587a, "... Reading OPCODE_DFU_ENABLE_BUFFER_CHECK_MODE notification");
            byte[] o02 = o0(1600L);
            if (o02[2] == 1) {
                ByteBuffer wrap = ByteBuffer.wrap(o02);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                int i10 = (((short) (wrap.get(4) & 255)) << 8) | ((short) (wrap.get(3) & 255));
                int i11 = ((short) (wrap.get(5) & 255)) | (((short) (wrap.get(6) & 255)) << 8);
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

    public final int K0() {
        byte[] o02;
        byte b10;
        if (this.f22295z0 == null) {
            il.b.l("no mControlPointCharacteristic found");
            return 0;
        }
        il.b.c("<< OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION(0x09)");
        T(this.f22295z0, new byte[]{9}, false);
        try {
            il.b.d(this.f36587a, "Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification");
            o02 = o0(1600L);
            b10 = o02[2];
        } catch (DfuException unused) {
            il.b.l("Reading OPCODE_DFU_REPORT_OTA_FUNCTION_VERSION notification failed, just think remote is normal function.");
            this.C = 0;
        }
        if (b10 == 1) {
            ByteBuffer.wrap(o02).order(ByteOrder.LITTLE_ENDIAN);
            return 1;
        }
        il.b.l("reportOtaFunctionVersion failed, status: " + ((int) b10));
        return 0;
    }

    public final boolean a0() {
        try {
            il.b.d(this.f36587a, "<< OPCODE_DFU_RESET_SYSTEM (0x05)");
            return T(this.f22295z0, new byte[]{5}, true);
        } catch (DfuException e10) {
            il.b.c(String.format("Send OPCODE_DFU_RESET_SYSTEM failed, ignore it, errorcode= 0x%04X", Integer.valueOf(e10.getErrCode())));
            this.C = 0;
            return false;
        }
    }

    public final void b0() {
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
        T(this.f22295z0, bArr2, false);
        il.b.k(this.f36587a, "... Reading OPCODE_DFU_START_DFU(0x01) notification");
        byte b10 = F0()[2];
        if (b10 != 1) {
            il.b.e(String.format("0x%02X(not supported), start dfu failed", Byte.valueOf(b10)));
            throw new OtaException("start dfu failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x01d3, code lost:
        if (r10.O == 1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01e3, code lost:
        if (r10.O == 1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01e5, code lost:
        m0(r10.f22297l0, r10.A0, r10.f36609w);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01ef, code lost:
        r0(r10.f22297l0, r10.A0, r10.f36609w);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c0() {
        if (!e()) {
            g0(DfuException.ERROR_DFU_ABORTED, true);
            return false;
        } else if (!v().N() || j()) {
            D(521);
            il.b.c(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.I), Integer.valueOf(v().f6004j)));
            if (this.f36587a) {
                il.b.j(u().toString());
            }
            if (Build.VERSION.SDK_INT >= 23) {
                P(this.f22297l0, 256);
            }
            if (v().f6004j <= 3) {
                if (this.I == 16 && t().J()) {
                    try {
                        Thread.sleep(t().o() * 1000);
                    } catch (InterruptedException unused) {
                    }
                }
                this.O = K0();
                boolean z10 = this.f36587a;
                il.b.k(z10, "mRemoteOtaFunctionInfo=" + this.O);
                if (this.O == 1) {
                    I0();
                }
            } else {
                il.b.c("isBufferCheckEnabled=" + v().Q());
                if (!v().Q()) {
                    this.O = 0;
                } else {
                    this.O = J0();
                }
                boolean z11 = this.f36587a;
                il.b.k(z11, "mRemoteOtaFunctionInfo=" + this.O);
            }
            u().D();
            u0(u().g());
            if (!t().G()) {
                this.P = 0;
                il.b.c(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.P)));
            }
            if (this.P == 0) {
                b0();
            }
            if (this.P - 12 >= u().i()) {
                il.b.c("Last send reach the bottom");
            } else if (v().f6004j <= 3) {
                w0(u().g());
                if (this.O == 1) {
                    h0(this.f22297l0, this.A0, this.f36609w);
                } else {
                    p0(this.f22297l0, this.A0, this.f36609w);
                }
            } else if (v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 11 || v().f6004j == 12) {
                v0(u().g());
            } else {
                v0(u().g());
            }
            u().v();
            x0(u().g());
            return true;
        } else {
            t0(4113);
            return false;
        }
    }

    public final int d0(String str, int i10) {
        int i11 = 0;
        while (e()) {
            int l02 = l0(str);
            if (l02 == 0) {
                return 0;
            }
            if ((l02 & (-2049)) != 133) {
                X(this.f22297l0);
            } else {
                il.b.l("connect fail with GATT_ERROR, do not need disconnect");
            }
            N(this.f22297l0);
            try {
                Thread.sleep(1600L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            i11++;
            il.b.c("tryConnectTime=" + i11);
            if (i11 > i10) {
                return l02;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public final void e0(byte b10) {
        j0(new byte[]{4, b10});
    }

    public final void f0(int i10, int i11) {
        il.b.c("<< OPCODE_DFU_RECEIVE_FW_IMAGE (0x02)");
        T(this.f22295z0, new byte[]{2, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) (i11 & 255), (byte) ((i11 >> 8) & 255), (byte) ((i11 >> 16) & 255), (byte) ((i11 >> 24) & 255)}, false);
    }

    public final void g0(int i10, boolean z10) {
        if (this.f36594h) {
            i10 = 4128;
        }
        if (i10 != 4128) {
            E(DfuException.ERROR_CONNECTION_TIMEOUT, true);
        }
        il.b.j(String.format("error = 0x%04X, needReset=%b", Integer.valueOf(i10), Boolean.valueOf(z10)));
        if (z10) {
            a0();
        }
        m(this.f36609w);
        if (t().K(1)) {
            Y(i10);
        }
        b bVar = this.f36592f;
        if (bVar != null) {
            bVar.a(i10);
        }
        this.f36594h = true;
    }

    @Override // xl.a
    public boolean h(boolean z10) {
        if (!super.h(z10)) {
            return false;
        }
        if (this.f36599m != 515) {
            boolean z11 = this.f36587a;
            il.b.d(z11, "start to re-connect the RCU which going to active image, current state is: " + this.f36599m);
            int d02 = d0(this.E, t().B());
            if (d02 != 0) {
                il.b.e("Something error in OTA process, errorCode: " + d02 + "mProcessState" + this.f36607u);
                g0(d02, true);
                return false;
            }
        }
        if (z10) {
            try {
                y0();
                D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            } catch (DfuException e10) {
                e10.printStackTrace();
                t0(e10.getErrCode());
            }
        } else {
            if (a0() && !B0()) {
                I();
            }
            g0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, false);
        }
        return true;
    }

    public final void h0(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, wl.a aVar) {
        int i10;
        il.b.d(this.f36587a, String.format(Locale.US, "updateImageWithCheckBufferForBee1, packetSize=%d, mCurrentMaxBufferSize=%d", Integer.valueOf(this.K), Integer.valueOf(this.R)));
        this.C = 0;
        this.f36606t = false;
        int i11 = this.K;
        byte[] bArr = new byte[i11];
        byte[] bArr2 = new byte[this.R];
        while (!this.f36606t) {
            if (!this.f36594h) {
                if (this.I != 17) {
                    d(aVar);
                }
                il.b.k(this.f36587a, u().toString());
                try {
                    int read = aVar.read(bArr2);
                    if (u().o() < read) {
                        read = u().o();
                        il.b.h(this.f36587a, "Reach the bottom of the image,  checkImageBufferSize: " + read);
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
                            R(usbGatt, usbGattCharacteristic, bArr, min, false);
                            K();
                        }
                        il.b.k(this.f36588b, "pos: " + i14 + ", checkImageBufferSize: " + i12);
                        boolean s02 = s0(ml.a.a(bArr2, 0, i12));
                        if (!s02) {
                            u().b(0 - i12);
                            i10 = i13 + 1;
                            il.b.c("check failed, retransBufferCheckTimes: " + i10);
                        } else {
                            i10 = i13;
                        }
                        i0(s02);
                        if (i10 >= 3) {
                            il.b.l("Error while buffer check, reach max try times: " + i10 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                            throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                        } else if (s02) {
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

    public final void i0(boolean z10) {
        il.b.c("<< OPCODE_DFU_ENSURE_CURRENT_BUFFER(0x0C)");
        T(this.f22295z0, new byte[]{12, !z10 ? 1 : 0}, false);
    }

    public final void j0(byte[] bArr) {
        boolean z10;
        D(524);
        boolean z11 = this.f36594h;
        int i10 = DfuException.ERROR_DFU_ABORTED;
        if (!z11) {
            boolean z12 = false;
            try {
                il.b.c("<< OPCODE_DFU_ACTIVE_IMAGE_RESET(0x04)");
                z10 = T(this.f22295z0, bArr, false);
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
            z12 = z10;
            if (z12) {
                il.b.c("image active success");
                Y(this.C);
                m(this.f36609w);
                return;
            }
            throw new OtaException(i10);
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public boolean k0(wl.a aVar, int i10, int i11) {
        il.b.k(this.f36587a, String.format(Locale.US, "nextBinSize=%d, mBytesSentBuffer=%d, bufferSize=%d", Integer.valueOf(aVar.k0()), Integer.valueOf(i10), Integer.valueOf(i11)));
        return aVar.k0() + i10 > i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l0(String str) {
        int i10;
        StringBuilder sb2;
        G(256);
        this.C = 0;
        this.f36597k = false;
        boolean z10 = this.f36587a;
        il.b.d(z10, "Connecting to device..." + fl.a.c(str, true));
        UsbDevice J = J(str);
        UsbGatt usbGatt = null;
        if (J == null) {
            il.b.l("device is null");
            this.f22297l0 = null;
            return 256;
        }
        GlobalUsbGatt globalUsbGatt = this.f22296k0;
        if (globalUsbGatt != null) {
            globalUsbGatt.unRegisterCallback(str, this.B0);
            if (this.f22296k0.connect(J, this.f36589c, this.B0)) {
                usbGatt = this.f22296k0.getBluetoothGatt(str);
                this.f22297l0 = usbGatt;
                try {
                    synchronized (this.f36598l) {
                        if (!this.f36597k && this.C == 0) {
                            il.b.d(this.f36587a, "wait for connect gatt for 32000 ms");
                            this.f36598l.wait(32000L);
                        }
                    }
                } catch (InterruptedException e10) {
                    sb2 = new StringBuilder();
                    sb2.append("Sleeping interrupted : ");
                    sb2.append(e10.toString());
                    il.b.l(sb2.toString());
                    this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                    if (this.C == 0) {
                    }
                    if (this.C == 0) {
                    }
                    return this.C;
                }
            } else {
                this.C = 256;
            }
        } else {
            usbGatt = UsbGattImpl.connectGatt(J, this.f36589c, this.B0);
            this.f22297l0 = usbGatt;
            try {
                synchronized (this.f36598l) {
                    if (!this.f36597k && this.C == 0) {
                        il.b.d(this.f36587a, "wait for connect gatt for 32000 ms");
                        this.f36598l.wait(32000L);
                    }
                }
            } catch (InterruptedException e11) {
                sb2 = new StringBuilder();
                sb2.append("sleeping interrupted:");
                sb2.append(e11);
                il.b.l(sb2.toString());
                this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                if (this.C == 0) {
                }
                if (this.C == 0) {
                }
                return this.C;
            }
        }
        if (this.C == 0) {
            if (!this.f36597k) {
                il.b.l("wait for connect, but can not connect with no callback");
                i10 = DfuException.ERROR_CONNECTION_TIMEOUT;
            } else if (usbGatt == null || this.f36599m != 515) {
                il.b.l("connect with some error, please check. mConnectionState=" + this.f36599m);
                i10 = DfuException.ERROR_CONNECT_ERROR;
            }
            this.C = i10;
        }
        if (this.C == 0) {
            il.b.k(this.f36587a, "connected the device which going to upgrade");
        }
        return this.C;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
        if (r5 != (u().f() + 12)) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d A[Catch: IOException -> 0x01f3, TryCatch #0 {IOException -> 0x01f3, blocks: (B:10:0x004c, B:12:0x0051, B:14:0x005c, B:15:0x0069, B:17:0x006d, B:19:0x0082, B:21:0x0089, B:22:0x0090, B:24:0x0097, B:25:0x00a0, B:26:0x00a4, B:27:0x00b6, B:29:0x00ba, B:31:0x00d3), top: B:66:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3 A[Catch: IOException -> 0x01f3, TRY_LEAVE, TryCatch #0 {IOException -> 0x01f3, blocks: (B:10:0x004c, B:12:0x0051, B:14:0x005c, B:15:0x0069, B:17:0x006d, B:19:0x0082, B:21:0x0089, B:22:0x0090, B:24:0x0097, B:25:0x00a0, B:26:0x00a4, B:27:0x00b6, B:29:0x00ba, B:31:0x00d3), top: B:66:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ff A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m0(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, wl.a aVar) {
        int i10;
        int i11;
        int i12;
        il.b.j("updateImageWithCheckBufferForBeeUpdate");
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
                    il.b.k(z10, String.format(locale, "mCurrentMaxBufferSize=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.R), Integer.valueOf(this.P), Integer.valueOf(this.P)));
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
                                il.b.d(this.f36587a, String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
                                if (u().o() < i11) {
                                    i11 = u().o();
                                    il.b.k(this.f36587a, "reach bottom, only read some,  checkImageBufferSize: " + i11);
                                }
                                i12 = i11;
                                il.b.c(u().toString());
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
                                                        il.b.d(this.f36588b, "encryptSize < 16, no need to encrypt:" + min2);
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
                                        R(usbGatt, usbGattCharacteristic, bArr4, min, false);
                                        System.arraycopy(bArr4, 0, bArr3, i21, min);
                                        i19 = i21 + min;
                                        K();
                                    }
                                    boolean n02 = n0(bArr3, i12);
                                    if (!n02) {
                                        u().b(0 - i12);
                                        i15++;
                                        il.b.c("check failed, retransTimes: " + i15);
                                    } else {
                                        i15 = 0;
                                    }
                                    if (i15 < 3) {
                                        if (n02) {
                                            break;
                                        }
                                    } else {
                                        il.b.l("Error while buffer check, reach max try times: " + i15 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                                        throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                                    }
                                } else if (u().t()) {
                                    il.b.g("image file has already been send over");
                                } else {
                                    il.b.e("Error while reading file with size: " + i12);
                                    throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                                }
                            }
                            u().y(0);
                            il.b.d(this.f36587a, String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
                            if (u().o() < i11) {
                            }
                            i12 = i11;
                            il.b.c(u().toString());
                            if (i12 > 0) {
                            }
                        } catch (IOException unused) {
                            throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                        }
                    }
                    il.b.c("the last sent to remote may not alignment, reinstall input stream");
                    M();
                    i(this.P, true);
                    i10 = this.P;
                    if (i10 != 0) {
                    }
                    u().y(0);
                    il.b.d(this.f36587a, String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
                    if (u().o() < i11) {
                    }
                    i12 = i11;
                    il.b.c(u().toString());
                    if (i12 > 0) {
                    }
                }
                i13 = i15;
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final boolean n0(byte[] bArr, int i10) {
        if (bArr == null) {
            il.b.l("buffer == null");
            return false;
        }
        if (this.f36587a) {
            il.b.j(String.format(Locale.US, "bufferCheck (%d) >> (%d) %s", Integer.valueOf(i10), Integer.valueOf(bArr.length), jl.a.a(bArr)));
        }
        short a10 = a(bArr, i10);
        il.b.d(this.f36587a, "<< OPCODE_DFU_REPORT_BUFFER_CRC(0x0A)");
        T(this.f22295z0, new byte[]{10, (byte) (i10 & 255), (byte) (i10 >> 8), (byte) (a10 & 255), (byte) ((a10 >> 8) & 255)}, false);
        il.b.d(this.f36587a, "... waiting OPCODE_DFU_REPORT_BUFFER_CRC(0x0A) response");
        byte[] F0 = F0();
        byte b10 = F0[2];
        ByteBuffer wrap = ByteBuffer.wrap(F0);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        this.P = wrap.getInt(3);
        il.b.d(this.f36587a, String.format(Locale.US, "status:0x%04X, mImageUpdateOffset=0x%08X(%d)", Byte.valueOf(b10), Integer.valueOf(this.P), Integer.valueOf(this.P)));
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

    public final byte[] o0(long j10) {
        this.C = 0;
        this.f22299n0 = true;
        try {
            synchronized (this.L) {
                if (this.C == 0 && this.f22298m0 == null && this.f36599m == 515) {
                    this.f22299n0 = false;
                    boolean z10 = this.f36587a;
                    il.b.k(z10, "wait for notification, wait for " + j10 + "ms");
                    this.L.wait(j10);
                }
                if (this.C == 0 && !this.f22299n0) {
                    il.b.l("wait for notification, but not come");
                    this.C = DfuException.ERROR_NOTIFICATION_NO_RESPONSE;
                }
            }
        } catch (InterruptedException e10) {
            il.b.e("readNotificationResponse interrupted, " + e10.toString());
            this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
        }
        if (this.C == 0) {
            return this.f22298m0;
        }
        throw new OtaException("Unable to receive notification", this.C);
    }

    public final void p0(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, wl.a aVar) {
        il.b.d(this.f36587a, "uploadFirmwareImage");
        l();
        this.C = 0;
        this.f36606t = false;
        int i10 = this.K;
        byte[] bArr = new byte[i10];
        while (!this.f36606t) {
            if (!this.f36594h) {
                if (this.I != 17) {
                    d(aVar);
                }
                il.b.k(this.f36587a, u().toString());
                H();
                try {
                    int i02 = aVar.i0(bArr, i10);
                    if (u().o() < this.K) {
                        il.b.k(this.f36587a, "reach the end of the file, only read some");
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
                        R(usbGatt, usbGattCharacteristic, bArr, i11, false);
                        K();
                        k();
                    } else if (u().t()) {
                        il.b.g("image file has already been send over");
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

    @Override // xl.a
    public void q() {
        int y10;
        super.q();
        try {
            setName("ProcessorXU0000");
            il.b.g("ProcessorXU0000 running.");
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
        C0();
        m(this.f36609w);
        il.b.d(this.f36587a, "GattDfuTaskX0000 stopped");
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final void q0(String str) {
        if (!this.f36594h) {
            D(516);
            int d02 = d0(str, t().B());
            if (d02 != 0) {
                if (d02 == 4128) {
                    throw new OtaException("aborted, connectRemoteDevice failed", d02);
                }
                throw new OtaException("connectRemoteDevice failed", d02);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void r0(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, wl.a aVar) {
        int i10;
        il.b.d(this.f36587a, "uploadFirmwareImageForBeeUpdate");
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
                        R(usbGatt, usbGattCharacteristic, bArr, i13, false);
                        K();
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

    public final boolean s0(int i10) {
        byte b10;
        String str;
        il.b.c(String.format("<< OPCODE_DFU_CHECK_CURRENT_BUFFER(0x0B) , crc=0x%04X", Integer.valueOf(i10)));
        T(this.f22295z0, new byte[]{11}, false);
        il.b.d(this.f36587a, "... waiting CHECK_CURRENT_BUFFER response");
        byte[] F0 = F0();
        if (F0[2] == 1) {
            int i11 = ((F0[4] << 8) & 65280) | (F0[3] & 255);
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

    public final void t0(int i10) {
        g0(i10, false);
    }

    public final void u0(int i10) {
        int i11;
        int i12;
        il.b.d(this.f36587a, "<< OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06)");
        T(this.f22295z0, new byte[]{6, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255)}, false);
        il.b.d(this.f36587a, "... Reading OPCODE_DFU_REPORT_TARGET_IMAGE_INFO(0x06) notification");
        byte[] F0 = F0();
        int length = F0 != null ? F0.length : 0;
        byte b10 = -2;
        if (length > 2) {
            b10 = F0[2];
        }
        if (b10 == 1) {
            ByteBuffer wrap = ByteBuffer.wrap(F0);
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
                il.b.j(String.format(Locale.US, "mOriginalFwVersion=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P), Integer.valueOf(this.P)));
                return;
            }
            this.P = wrap.getInt(i12);
            il.b.j(String.format(Locale.US, "mOriginalFwVersion=%d, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P), Integer.valueOf(this.P)));
            return;
        }
        il.b.l(String.format("0x%02X, Get target image info failed", Integer.valueOf((int) DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED)));
        throw new OtaException("Get target image info failed", DfuException.ERROR_OPCODE_RESPONSE_NOT_SUPPORTED);
    }

    public final void v0(int i10) {
        boolean z10;
        String str;
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
        f0(i10, this.P);
        int f10 = u().f();
        int i12 = this.P;
        if (f10 != i12 && i12 != -1) {
            il.b.c("mBytesSent != mImageUpdateOffset, reload image bin file");
            M();
            i(this.P, false);
        }
    }

    public final void w0(int i10) {
        int i11 = this.P;
        if (i11 == 0) {
            i11 = 12;
        }
        f0(i10, i11);
        if (u().f() != this.P) {
            il.b.c("mBytesSent != mImageUpdateOffset, reload image bin file");
            M();
            i(this.P, false);
        }
        il.b.j(u().toString());
    }

    @Override // com.realsil.sdk.dfu.v.b, mm.a, xl.a
    public void x() {
        super.x();
        try {
            this.f22293x0 = UUID.fromString(t().f());
            this.f22294y0 = UUID.fromString(t().e());
        } catch (Exception e10) {
            e10.printStackTrace();
            il.b.e(e10.toString());
        }
        this.f36593g = true;
    }

    public final void x0(int i10) {
        il.b.c("<< OPCODE_DFU_VALIDATE_FW_IMAGE (0x03)");
        T(this.f22295z0, new byte[]{3, (byte) (i10 & 255), (byte) ((i10 >> 8) & 255)}, false);
        il.b.d(this.f36587a, "... waiting DFU_VALIDATE_FW_IMAGE response");
        byte b10 = F0()[2];
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

    public final void y0() {
        j0(new byte[]{4});
    }

    public final int z0() {
        StringBuilder sb2;
        UUID uuid;
        if (this.f22295z0 == null) {
            sb2 = new StringBuilder();
            sb2.append("not found DFU_CONTROL_POINT_UUID : ");
            uuid = this.f22294y0;
        } else {
            boolean z10 = this.f36587a;
            il.b.k(z10, "find DFU_CONTROL_POINT_UUID: " + this.f22294y0.toString());
            if (this.A0 == null) {
                sb2 = new StringBuilder();
                sb2.append("not found DFU_DATA_UUID :");
                uuid = this.f22293x0;
            } else {
                boolean z11 = this.f36587a;
                il.b.k(z11, "find DFU_DATA_UUID: " + this.f22293x0.toString());
                return 0;
            }
        }
        sb2.append(uuid.toString());
        il.b.l(sb2.toString());
        return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
    }
}
