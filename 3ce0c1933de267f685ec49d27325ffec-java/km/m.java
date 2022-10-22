package km;

import android.content.Context;
import cm.d;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.io.IOException;
import java.util.Locale;
import wl.a;
import xl.b;
/* loaded from: classes2.dex */
public class m extends k {
    public m(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
    }

    public final void O0() {
        il.b.d(this.f36587a, String.format("<< CMD_OTA_GET_OTHER_INFO (0x%04X)", (short) 1547));
        byte[] r02 = r0((short) 1547);
        if (r02 == null || r02.length <= 0) {
            v().q0(0);
        } else {
            v().q0(r02[0] & 1);
        }
    }

    @Override // im.a, zl.b
    public void P() {
        int k10 = u().k();
        int l10 = u().l();
        if (l10 < 0 || l10 >= k10) {
            il.b.j("invalid FileIndex: " + l10 + ", reset to 0");
            l10 = 0;
        }
        u().z(l10);
        a aVar = this.f36608v.get(l10);
        this.f36609w = aVar;
        if (aVar != null) {
            if (this.f36587a) {
                il.b.j(String.format("mCurBinInputStream's binId=0x%04X", Integer.valueOf(aVar.w())));
            }
            u().s(this.f36609w.w(), this.f36609w.O(), this.f36609w.T(), this.f36609w.k0() + 12, t().Q());
        } else {
            il.b.k(this.f36588b, "mCurBinInputStream == null");
        }
        int i10 = l10 + 1;
        if (i10 < k10) {
            this.f36610x = this.f36608v.get(i10);
            this.f36611y = i10;
            return;
        }
        this.f36610x = null;
        this.f36611y = -1;
    }

    public boolean P0() {
        int R0;
        boolean z10 = false;
        while (e()) {
            try {
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errCode = e10.getErrCode();
                if (errCode == 4128) {
                    i0(errCode, true);
                } else if (errCode == 4097) {
                    i0(errCode, false);
                } else {
                    M0();
                    z0(errCode);
                }
            }
            if (!W0() || (R0 = R0()) == 0) {
                return false;
            }
            if (R0 == 2) {
                z10 = true;
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
        z0(DfuException.ERROR_DFU_ABORTED);
        return false;
    }

    public final void Q0() {
        this.f36595i = false;
        if (!e()) {
            z0(DfuException.ERROR_DFU_ABORTED);
            return;
        }
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        this.M = new d(17, 2);
        L0();
        if (v().R()) {
            if (v().f6005k < 6) {
                O0();
                if (v().H() != 0) {
                    throw new OtaException("rws state not ready", DfuException.ERROR_DFU_SPP_RWS_NOT_READY);
                }
            } else if (this.f30037x0 && v().t() != this.f30036w0) {
                throw new OtaException("role swap failed", DfuException.ERROR_DFU_ROLE_SWAP_FAILED);
            }
        }
        I0();
        if (v().O() && v().f6005k >= 5) {
            K0();
        }
        if (v().K() == 3) {
            J0();
        }
        if (this.f36587a) {
            il.b.c(v().toString());
        }
        Q();
        this.f36595i = true;
        il.b.c("Ota Environment prepared.");
    }

    public final int R0() {
        if (!S0()) {
            return 0;
        }
        this.f36612z += u().f();
        if (u().u()) {
            il.b.c("no pendding image file to upload.");
            if (v().f6005k >= 3) {
                h0(u().g(), (byte) 1);
            } else {
                h0(u().g(), (byte) 0);
            }
            u().x(this.f36612z);
            return 2;
        }
        il.b.c("has pendding image file to upload");
        h0(u().g(), (byte) 0);
        return 1;
    }

    public final boolean S0() {
        int i10;
        if (!e()) {
            i10 = DfuException.ERROR_DFU_ABORTED;
        } else if (!v().N() || j()) {
            D(521);
            il.b.d(this.f36587a, String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.I), Integer.valueOf(v().f6004j)));
            il.b.k(this.f36587a, u().toString());
            boolean z10 = this.f36587a;
            il.b.k(z10, "isBufferCheckEnabled=" + v().Q());
            if (v().Q() && F0()) {
                this.O = 1;
            } else {
                this.O = 0;
            }
            boolean z11 = this.f36587a;
            il.b.k(z11, "mRemoteOtaFunctionInfo=" + this.O);
            u().D();
            A0(u().g());
            if (!t().G()) {
                this.P = 0;
            }
            il.b.k(this.f36587a, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.P), Integer.valueOf(this.P)));
            if (this.P == 0) {
                f0((byte) 1);
            }
            if (this.P >= u().i()) {
                il.b.d(this.f36587a, "Last send reach the bottom");
            } else {
                V0(u().g());
                if (this.O == 1) {
                    U0(this.f36609w);
                } else {
                    T0(this.f36609w);
                }
            }
            u().v();
            return true;
        } else {
            i10 = 4113;
        }
        z0(i10);
        return false;
    }

    public final void T0(a aVar) {
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
                    if (u().f() == 0) {
                        int i12 = this.K;
                        byte[] bArr2 = new byte[i12];
                        aVar.i0(bArr2, i12 - 12);
                        System.arraycopy(aVar.E(), 0, bArr, 0, 12);
                        System.arraycopy(bArr2, 0, bArr, 12, this.K - 12);
                        i10 = this.K;
                        u().c(12);
                        u().y(0);
                    } else {
                        i10 = aVar.i0(bArr, i11);
                    }
                    if (u().o() < this.K) {
                        il.b.k(this.f36587a, "reach the end of the file, only read some");
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r9 != u().f()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079 A[Catch: IOException -> 0x01f6, TryCatch #0 {IOException -> 0x01f6, blocks: (B:10:0x003b, B:12:0x0040, B:15:0x004c, B:16:0x0073, B:18:0x0079, B:20:0x00a0, B:21:0x00b0, B:23:0x00c5, B:25:0x00c9, B:27:0x00e2, B:28:0x0100, B:30:0x0103), top: B:68:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e2 A[Catch: IOException -> 0x01f6, TryCatch #0 {IOException -> 0x01f6, blocks: (B:10:0x003b, B:12:0x0040, B:15:0x004c, B:16:0x0073, B:18:0x0079, B:20:0x00a0, B:21:0x00b0, B:23:0x00c5, B:25:0x00c9, B:27:0x00e2, B:28:0x0100, B:30:0x0103), top: B:68:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0103 A[Catch: IOException -> 0x01f6, TRY_LEAVE, TryCatch #0 {IOException -> 0x01f6, blocks: (B:10:0x003b, B:12:0x0040, B:15:0x004c, B:16:0x0073, B:18:0x0079, B:20:0x00a0, B:21:0x00b0, B:23:0x00c5, B:25:0x00c9, B:27:0x00e2, B:28:0x0100, B:30:0x0103), top: B:68:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0126 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void U0(a aVar) {
        int i10;
        byte[] bArr;
        int i11;
        int i12;
        this.C = 0;
        this.f36606t = false;
        int i13 = 0;
        while (!this.f36606t) {
            if (!this.f36594h) {
                byte[] bArr2 = new byte[this.R];
                int i14 = this.S;
                byte[] bArr3 = new byte[i14];
                while (true) {
                    Locale locale = Locale.US;
                    il.b.j(String.format(locale, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.P), Integer.valueOf(this.P)));
                    if (i13 <= 0) {
                        try {
                            int i15 = this.P;
                            if (i15 != -1) {
                            }
                            i10 = this.P;
                            if (i10 != 0) {
                                i11 = this.R - this.Q;
                                bArr = new byte[i11];
                                System.arraycopy(this.f36609w.E(), 0, bArr, 0, 12);
                                int i16 = i11 - 12;
                                byte[] bArr4 = new byte[i16];
                                System.arraycopy(bArr4, 0, bArr, 12, this.f36609w.i0(bArr4, i16));
                                u().y(0);
                            } else {
                                if (i10 == 12) {
                                    i12 = this.f36609w.i0(bArr2, bArr2.length - 12);
                                    u().y(0);
                                } else {
                                    i12 = this.f36609w.i0(bArr2, Math.min(this.R, this.f36609w.k0()));
                                }
                                i11 = i12;
                                bArr = bArr2;
                            }
                            il.b.k(this.f36587a, String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
                            if (u().o() < i11) {
                                i11 = u().o();
                                il.b.d(this.f36587a, "File in the middle, only read some,  checkImageBufferSize: " + i11);
                            }
                            if (i11 != bArr.length) {
                                il.b.d(this.f36587a, "Reach the bottom of the image: " + i11);
                            }
                            il.b.j(u().toString());
                            if (i11 <= 0) {
                                int i17 = 0;
                                while (i17 < i11) {
                                    int min = Math.min(i14, i11 - i17);
                                    System.arraycopy(bArr, i17, bArr3, 0, min);
                                    if (v().N()) {
                                        int i18 = 0;
                                        while (true) {
                                            if (i18 < min) {
                                                int min2 = Math.min(min - i18, 16);
                                                if (min2 < 16) {
                                                    il.b.d(this.f36588b, "encryptSize < 16, no need to encrypt:" + min2);
                                                    break;
                                                }
                                                byte[] a10 = this.B.a(bArr3, i18, 16);
                                                System.arraycopy(a10, 0, bArr3, i18, 16);
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
                                    if (T((short) 1539, bArr3, min)) {
                                        u().b(min);
                                        B();
                                    }
                                    O();
                                }
                                boolean t02 = t0(bArr, i11);
                                i13 = !t02 ? i13 + 1 : 0;
                                if (i13 >= 3) {
                                    il.b.l("Error while buffer check, reach max try times: " + i13 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                                    throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                                } else if (t02) {
                                    break;
                                } else {
                                    bArr2 = bArr;
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
                    il.b.c(String.format(locale, "offset may not alignment, reinstall input stream, mImageUpdateOffset=%d, sent=%d", Integer.valueOf(this.P), Integer.valueOf(u().f())));
                    Q();
                    i(this.P, true);
                    i10 = this.P;
                    if (i10 != 0) {
                    }
                    il.b.k(this.f36587a, String.format(locale, "checkImageBufferSize=%d", Integer.valueOf(i11)));
                    if (u().o() < i11) {
                    }
                    if (i11 != bArr.length) {
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

    public final void V0(int i10) {
        int i11 = this.P;
        if (i11 == 0) {
            if (v().f6005k < 3) {
                this.P = 12;
            }
            il.b.d(this.f36587a, String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.P), Integer.valueOf(this.P)));
        } else {
            il.b.d(this.f36587a, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P)));
        }
        int f10 = u().f();
        int i12 = this.P;
        if (f10 != i12 && i12 != -1) {
            il.b.l("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
    }

    public final boolean W0() {
        x0(this.E);
        if (!this.f36595i) {
            Q0();
        } else {
            P();
        }
        if (this.f36609w != null) {
            return true;
        }
        z0(4097);
        return false;
    }

    @Override // xl.a
    public void i(int i10, boolean z10) {
        if (i10 != 0) {
            try {
                int max = Math.max(i10 - 12, 0);
                byte[] bArr = new byte[u().i()];
                if (z10) {
                    this.f36609w.i0(bArr, max);
                } else {
                    this.f36609w.read(bArr, 0, max);
                }
            } catch (IOException e10) {
                il.b.e(e10.toString());
                return;
            }
        }
        u().y(i10);
    }

    @Override // xl.a
    public void q() {
        int y10;
        al.b g10;
        String str;
        super.q();
        try {
            setName("ProcessorXS0011ForceTemp");
            il.b.c("ProcessorXS0011ForceTemp is running.");
            y10 = y();
        } catch (Exception e10) {
            e10.printStackTrace();
            il.b.e(e10.toString());
            z0(0);
        }
        if (y10 != 0) {
            z0(y10);
            return;
        }
        D(514);
        this.E = this.F;
        this.f36596j = true;
        this.f36612z = 0;
        this.f30037x0 = false;
        if (P0()) {
            if (v().R()) {
                H0();
                il.b.c("start to upload secondary bud ...");
                this.f36596j = true;
                this.f36595i = false;
                this.f36612z = 0;
                if (P0()) {
                    if (!this.J) {
                        D(523);
                    } else {
                        o0(true);
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
                    o0(true);
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
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
        il.b.c("ProcessorXS0011ForceTemp stopped.");
    }
}
