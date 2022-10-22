package km;

import android.content.Context;
import android.util.SparseIntArray;
import cm.d;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.params.QcConfig;
import com.tendcloud.tenddata.ab;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import ul.c;
import wl.a;
import xl.b;
/* loaded from: classes2.dex */
public class l extends k {
    public SparseIntArray A0;

    /* renamed from: z0  reason: collision with root package name */
    public QcConfig f30040z0;

    public l(Context context, DfuConfig dfuConfig, QcConfig qcConfig, b bVar) {
        super(context, dfuConfig, bVar);
        this.f30040z0 = qcConfig;
    }

    public final void O0() {
        il.b.d(this.f36587a, String.format("<< CMD_OTA_GET_OTHER_INFO (0x%04X)", (short) 1547));
        byte[] u02 = u0((short) 1547, null);
        if (u02 == null || u02.length <= 0) {
            v().q0(0);
        } else {
            v().q0(u02[0] & 1);
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

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
        if (r6 == 1) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0116, code lost:
        if (r1 == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0153, code lost:
        S0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0157, code lost:
        il.b.j("processForceCopyProcedure failed");
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8 A[Catch: DfuException -> 0x0119, TRY_ENTER, TryCatch #3 {DfuException -> 0x0119, blocks: (B:8:0x000f, B:11:0x0016, B:13:0x0022, B:15:0x002b, B:17:0x002f, B:35:0x00ba, B:39:0x00d8, B:41:0x00de, B:43:0x00e4, B:47:0x00ef, B:49:0x00f5, B:52:0x0101), top: B:80:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0108 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean P0() {
        boolean z10;
        int i10;
        Exception e10;
        boolean z11 = false;
        while (e()) {
            try {
                if (!Z0()) {
                    return false;
                }
                if (v().O() && v().f6005k >= 5) {
                    il.b.c(String.format(Locale.US, "binId=0x%04X, activeCompareVersionFlag=%d, inactiveCompareVersionFlag=%d", Integer.valueOf(this.f36609w.w()), Integer.valueOf(this.f36609w.v()), Integer.valueOf(this.f36609w.V())));
                    if (s0(this.f36609w)) {
                        try {
                            byte d02 = d0(u().g(), this.f36609w.W());
                            if ((d02 & 1) == 1) {
                                il.b.c("current image's sha256 is same as the inactive bank image, need to skip");
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if ((d02 & 2) == 2) {
                                try {
                                    if (y0(u().e())) {
                                        il.b.c("current image's sha256 is same as the active bank image, need to copy");
                                        z10 |= true;
                                    } else {
                                        il.b.j(String.format("0x%04X not support copy image", Integer.valueOf(u().e())));
                                    }
                                } catch (Exception e11) {
                                    e10 = e11;
                                    il.b.l("checkimage failed" + e10.toString());
                                    String str = "validate faild during copy, switch to push flow";
                                    if (z10) {
                                    }
                                    i10 = T0();
                                    if (i10 == 0) {
                                    }
                                }
                            }
                        } catch (Exception e12) {
                            e10 = e12;
                            z10 = false;
                        }
                        String str2 = "validate faild during copy, switch to push flow";
                        if (z10) {
                            i10 = R0();
                        } else if (z10) {
                            i10 = U0();
                            if (i10 == 1) {
                                str2 = "validate faild during skip, switch to push flow";
                                il.b.c(str2);
                            }
                            if (i10 == 0) {
                                return false;
                            }
                            if (i10 == 3) {
                                z11 = true;
                            }
                            try {
                                Thread.sleep(1000L);
                                continue;
                            } catch (InterruptedException e13) {
                                e13.printStackTrace();
                                continue;
                            }
                        } else if (z10) {
                            i10 = U0();
                            if (i10 == 1) {
                                il.b.c("validate faild during skip, switch to copy flow");
                                i10 = R0();
                                if (i10 == 1) {
                                    il.b.c(str2);
                                }
                            }
                            if (i10 == 0) {
                            }
                        }
                        i10 = T0();
                        if (i10 == 0) {
                        }
                    }
                }
                z10 = false;
                String str22 = "validate faild during copy, switch to push flow";
                if (z10) {
                }
                i10 = T0();
                if (i10 == 0) {
                }
            } catch (DfuException e14) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e14.toString());
                int errCode = e14.getErrCode();
                if (errCode == 4128) {
                    i0(errCode, true);
                } else if (errCode == 4097) {
                    i0(errCode, false);
                } else {
                    M0();
                    z0(errCode);
                }
            }
        }
        z0(DfuException.ERROR_DFU_ABORTED);
        return false;
        return z11;
    }

    @Override // im.a, zl.b
    public void Q() {
        m(this.f36609w);
        cm.a q5 = ul.b.q(new c.b().f(t().y()).e(t().i()).h(this.G).i(t().k()).o(this.f36589c).m(this.I).g(this.H).k(v()).j(t().N()).l(t().P()).n(t().R(), t().D()).d(true).c());
        if (q5 == null) {
            this.A0 = null;
            this.f36608v = null;
        } else if (q5.f5985h == 4096) {
            this.f36608v = q5.f5993p;
            this.A0 = q5.f5994q;
        } else {
            this.f36608v = null;
            this.A0 = null;
        }
        List<a> list = this.f36608v;
        if (list == null || list.size() <= 0) {
            il.b.c("pendingImageInputStreams == null || pendingImageInputStreams.size() <= 0");
            throw new LoadFileException("load image file error", 4097);
        }
        if (u().l() == 0) {
            this.f37632n0 = new int[this.f36608v.size()];
        }
        u().B(this.f36608v.size());
        if (this.f36587a) {
            il.b.j(u().toString());
        }
        P();
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
        QcConfig qcConfig = this.f30040z0;
        if (qcConfig != null) {
            try {
                S((short) 1554, new byte[]{(byte) (qcConfig.a() & 255)});
            } catch (Exception unused) {
                il.b.j("CMD_OTA_TEST error, ignore");
            }
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
                throw new OtaException(String.format("role swap failed, bud role(%d) din't change, target is %d", Integer.valueOf(v().t()), Integer.valueOf(this.f30036w0)), DfuException.ERROR_DFU_ROLE_SWAP_FAILED);
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
        a aVar;
        D(521);
        u().D();
        if (this.f36587a) {
            il.b.j("processCopyProcedure ...");
            il.b.j(u().toString());
        }
        try {
            w0(u().g());
            u().v();
            B();
            this.f36612z += u().f();
            if (u().u()) {
                il.b.k(this.f36588b, "no pendding image file to upload");
                u().x(this.f36612z);
                return 3;
            }
            il.b.c("has pendding image file to upload");
            if (v().K() == 1) {
                this.E = this.F;
                this.f36596j = true;
                this.f36612z = 0;
                o0(true);
            } else {
                if (v().K() == 3 && (aVar = this.f36610x) != null && p0(aVar, this.f36612z, v().C * 4096)) {
                    il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                    this.f36596j = true;
                    this.f36612z = 0;
                    g0((byte) 1, true);
                }
                return 2;
            }
            int d10 = u().d() / 30;
            c(ab.Y);
            return 2;
        } catch (DfuException unused) {
            return 1;
        }
    }

    public final void S0() {
        SparseIntArray sparseIntArray = this.A0;
        if (sparseIntArray == null || sparseIntArray.size() <= 0) {
            il.b.j("no force copy images exist");
            return;
        }
        for (int i10 = 0; i10 < this.A0.size(); i10++) {
            int keyAt = this.A0.keyAt(i10);
            il.b.j(String.format(Locale.US, "force copy data image:%d, imageId=0x%02X, value=0x%02X", Integer.valueOf(i10), Integer.valueOf(keyAt), Integer.valueOf(this.A0.valueAt(i10))));
            w0(keyAt);
        }
    }

    public final int T0() {
        if (!V0()) {
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
            return 3;
        }
        il.b.c("has pendding image file to upload");
        if (v().K() == 1) {
            if (v().f6005k >= 3) {
                h0(u().g(), (byte) 1);
            } else {
                h0(u().g(), (byte) 0);
            }
            this.E = this.F;
            this.f36596j = true;
            this.f36612z = 0;
            o0(true);
        } else {
            if (v().K() == 3) {
                a aVar = this.f36610x;
                if (aVar != null) {
                    if (p0(aVar, this.f36612z, v().C * 4096)) {
                        if (v().f6005k >= 3) {
                            h0(u().g(), (byte) 1);
                        } else {
                            h0(u().g(), (byte) 0);
                        }
                        il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                        this.f36596j = true;
                        this.f36612z = 0;
                        g0((byte) 1, true);
                    }
                } else if (v().f6005k >= 3) {
                    h0(u().g(), (byte) 1);
                    return 2;
                }
            }
            h0(u().g(), (byte) 0);
            return 2;
        }
        int d10 = u().d() / 30;
        c(ab.Y);
        return 2;
    }

    public final int U0() {
        int g10;
        if (!e()) {
            z0(DfuException.ERROR_DFU_ABORTED);
            return 0;
        }
        D(521);
        il.b.c(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.I), Integer.valueOf(v().f6004j)));
        il.b.j(u().toString());
        u().D();
        A0(u().g());
        if (!t().G()) {
            this.P = 0;
        }
        il.b.k(this.f36587a, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.P), Integer.valueOf(this.P)));
        if (this.P == 0) {
            N0();
        }
        if (this.P >= u().i()) {
            il.b.d(this.f36587a, "Last send reach the bottom");
        } else {
            Y0(u().g());
        }
        u().v();
        B();
        this.f36612z += u().f();
        try {
            if (u().u()) {
                il.b.c("no pendding image file to upload,");
                h0(u().g(), (byte) 1);
                u().x(this.f36612z);
                return 3;
            }
            il.b.c("has pendding image file to upload");
            if (v().K() == 1) {
                h0(u().g(), (byte) 1);
                this.E = this.F;
                this.f36596j = true;
                this.f36612z = 0;
                o0(true);
            } else {
                if (v().K() == 3) {
                    a aVar = this.f36610x;
                    if (aVar == null) {
                        h0(u().g(), (byte) 1);
                        return 2;
                    } else if (p0(aVar, this.f36612z, v().C * 4096)) {
                        h0(u().g(), (byte) 1);
                        il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                        this.f36596j = true;
                        this.f36612z = 0;
                        g0((byte) 1, true);
                    } else {
                        g10 = u().g();
                    }
                } else {
                    g10 = u().g();
                }
                h0(g10, (byte) 0);
                return 2;
            }
            int d10 = u().d() / 30;
            c(ab.Y);
            return 2;
        } catch (DfuException unused) {
            u().C(u().j());
            return 1;
        }
    }

    public final boolean V0() {
        int i10;
        if (!e()) {
            i10 = DfuException.ERROR_DFU_ABORTED;
        } else if (!v().N() || j()) {
            D(521);
            if (this.f36587a) {
                il.b.c(String.format("mOtaWorkMode=0x%04X, ICType=%2X", Integer.valueOf(this.I), Integer.valueOf(v().f6004j)));
            }
            il.b.j(u().toString());
            A0(u().g());
            if (!t().G() && this.P != 0) {
                if ((v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 8) && v().f6005k <= 4) {
                    il.b.c("clear soc data");
                    M0();
                }
                this.P = 0;
            }
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
            if (this.P == 0) {
                N0();
            }
            if (this.P >= u().i()) {
                boolean z12 = this.f36587a;
                if (z12) {
                    il.b.d(z12, "Last send reach the bottom");
                }
            } else {
                Y0(u().g());
                if (this.O == 1) {
                    W0(this.f36609w);
                } else {
                    X0(this.f36609w);
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
        if (r9 != u().f()) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c A[Catch: IOException -> 0x0202, TryCatch #0 {IOException -> 0x0202, blocks: (B:10:0x0042, B:12:0x0047, B:15:0x0053, B:16:0x0076, B:18:0x007c, B:20:0x00a3, B:21:0x00b3, B:23:0x00c8, B:25:0x00cc, B:27:0x00e5, B:28:0x0103, B:30:0x0106), top: B:68:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e5 A[Catch: IOException -> 0x0202, TryCatch #0 {IOException -> 0x0202, blocks: (B:10:0x0042, B:12:0x0047, B:15:0x0053, B:16:0x0076, B:18:0x007c, B:20:0x00a3, B:21:0x00b3, B:23:0x00c8, B:25:0x00cc, B:27:0x00e5, B:28:0x0103, B:30:0x0106), top: B:68:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106 A[Catch: IOException -> 0x0202, TRY_LEAVE, TryCatch #0 {IOException -> 0x0202, blocks: (B:10:0x0042, B:12:0x0047, B:15:0x0053, B:16:0x0076, B:18:0x007c, B:20:0x00a3, B:21:0x00b3, B:23:0x00c8, B:25:0x00cc, B:27:0x00e5, B:28:0x0103, B:30:0x0106), top: B:68:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0129 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W0(a aVar) {
        int i10;
        byte[] bArr;
        int i11;
        int i12;
        il.b.k(this.f36587a, "updateImageWithCheckBufferForBeeUpdate");
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
                                if (!t02) {
                                    u().b(0 - i11);
                                    i13++;
                                } else {
                                    i13 = 0;
                                }
                                if (i13 >= 3) {
                                    il.b.l("Error while buffer check, reach max try times: " + i13 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                                    throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                                } else if (t02) {
                                    break;
                                } else {
                                    bArr2 = bArr;
                                }
                            } else if (u().t()) {
                                il.b.c("image file has already been send over");
                            } else {
                                il.b.l("Error while reading file with size: " + i11);
                                throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                            }
                        } catch (IOException unused) {
                            throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                        }
                    }
                    il.b.c(String.format(locale, "offset may not alignment, reinstall input stream, mImageUpdateOffset=%d, %s", Integer.valueOf(this.P), u().toString()));
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

    public final void X0(a aVar) {
        int i10;
        il.b.c("uploadFirmwareImageForBeeUpdate");
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
                        il.b.c("image file has already been send over");
                        return;
                    } else {
                        il.b.l("Error while reading file with size: " + i10);
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

    public final void Y0(int i10) {
        if (this.P == 0 && v().f6005k < 3) {
            this.P = 12;
        }
        il.b.d(this.f36587a, String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(this.P), Integer.valueOf(this.P)));
        int f10 = u().f();
        int i11 = this.P;
        if (f10 != i11 && i11 != -1) {
            il.b.l("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
    }

    public final boolean Z0() {
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
                il.b.l(e10.toString());
                return;
            }
        }
        u().y(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // xl.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q() {
        int y10;
        al.b g10;
        String str;
        super.q();
        int i10 = 0;
        try {
            setName("ProcessorXS0011ForceCopy");
            il.b.c("ProcessorXS0011ForceCopy running.");
            y10 = y();
        } catch (DfuException e10) {
            il.b.l(e10.toString());
            i10 = e10.getErrCode();
            z0(i10);
            il.b.d(this.f36587a, "DfuThread stopped");
            if (this.f36607u == 525) {
            }
        } catch (Exception e11) {
            il.b.l(e11.toString());
            z0(i10);
            il.b.d(this.f36587a, "DfuThread stopped");
            if (this.f36607u == 525) {
            }
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
        il.b.d(this.f36587a, "DfuThread stopped");
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }
}
