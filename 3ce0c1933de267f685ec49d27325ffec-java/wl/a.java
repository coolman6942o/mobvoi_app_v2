package wl;

import com.huawei.agconnect.exception.AGCServerException;
import com.realsil.sdk.dfu.DfuException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import kl.b;
/* loaded from: classes2.dex */
public abstract class a extends BufferedInputStream {
    public static int D = 1;
    public static int E = 1;
    public int A;
    public int B;
    public int C;

    /* renamed from: a  reason: collision with root package name */
    public boolean f36301a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36302b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f36303c;

    /* renamed from: d  reason: collision with root package name */
    public List<rl.a> f36304d;

    /* renamed from: e  reason: collision with root package name */
    public int f36305e;

    /* renamed from: f  reason: collision with root package name */
    public int f36306f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f36307g;

    /* renamed from: h  reason: collision with root package name */
    public int f36308h;

    /* renamed from: i  reason: collision with root package name */
    public byte f36309i;

    /* renamed from: j  reason: collision with root package name */
    public int f36310j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f36311k;

    /* renamed from: l  reason: collision with root package name */
    public int f36312l;

    /* renamed from: m  reason: collision with root package name */
    public int f36313m;

    /* renamed from: n  reason: collision with root package name */
    public int f36314n;

    /* renamed from: o  reason: collision with root package name */
    public int f36315o;

    /* renamed from: p  reason: collision with root package name */
    public int f36316p;

    /* renamed from: q  reason: collision with root package name */
    public String f36317q;

    /* renamed from: r  reason: collision with root package name */
    public int f36318r;

    /* renamed from: s  reason: collision with root package name */
    public int f36319s;

    /* renamed from: t  reason: collision with root package name */
    public byte f36320t;

    /* renamed from: u  reason: collision with root package name */
    public short f36321u;

    /* renamed from: v  reason: collision with root package name */
    public byte[] f36322v;

    /* renamed from: w  reason: collision with root package name */
    public byte[] f36323w;

    /* renamed from: x  reason: collision with root package name */
    public final int f36324x;

    /* renamed from: y  reason: collision with root package name */
    public int f36325y;

    /* renamed from: z  reason: collision with root package name */
    public int f36326z;

    public a(InputStream inputStream) {
        this(inputStream, 20);
    }

    public a(InputStream inputStream, int i10) {
        super(new BufferedInputStream(inputStream));
        this.f36301a = true;
        this.f36302b = b.f30016b;
        this.f36308h = 0;
        this.f36314n = 0;
        this.f36326z = 1;
        this.A = 1;
        this.B = 254;
        this.C = 1;
        this.f36301a = b.f30015a;
        this.f36324x = i10;
        this.f36303c = new byte[512];
        this.f36307g = new byte[12];
        this.f36322v = new byte[12];
        this.f36325y = 0;
        h();
    }

    public byte[] E() {
        return this.f36307g;
    }

    public byte I() {
        return this.f36309i;
    }

    public int O() {
        return this.f36310j;
    }

    public int Q() {
        return this.f36313m;
    }

    public int T() {
        return this.f36312l;
    }

    public int V() {
        return this.A;
    }

    public byte[] W() {
        return this.f36323w;
    }

    public final String c(byte[] bArr) {
        int length = bArr.length;
        for (int length2 = bArr.length - 1; length2 >= 0; length2--) {
            if (bArr[length2] == -1 || bArr[length2] == 0) {
                length--;
            }
        }
        try {
            return new String(bArr, 0, length, "ascii");
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public boolean d() {
        List<rl.a> list = this.f36304d;
        return list != null && list.size() > 0;
    }

    public boolean g0() {
        return false;
    }

    public final void h() {
        if (E != D || !markSupported()) {
            u();
        } else {
            q();
        }
    }

    public void h0() {
        try {
            int i10 = this.f36309i == 11 ? DfuException.ERROR_CONNECTION_TIMEOUT : 360;
            int i11 = i10 + 32;
            byte[] bArr = new byte[i11];
            read(bArr, 0, i11);
            byte[] bArr2 = new byte[32];
            this.f36323w = bArr2;
            System.arraycopy(bArr, i10, bArr2, 0, 32);
            boolean z10 = this.f36302b;
            il.b.k(z10, "sha256=" + jl.a.a(this.f36323w));
        } catch (Exception e10) {
            il.b.e(e10.toString());
        }
    }

    public void i() {
        if (this.f36302b) {
            il.b.j("dfuHeader=" + jl.a.a(this.f36322v));
        }
    }

    public int i0(byte[] bArr, int i10) {
        int read = read(bArr, 0, i10);
        if (read > 0) {
            this.f36325y += read;
        }
        return read;
    }

    public int j0(byte[] bArr) {
        return i0(bArr, this.f36324x);
    }

    public int k0() {
        return this.f36313m - this.f36325y;
    }

    public void m0(int i10) {
        this.f36326z = i10;
    }

    public final void n() {
        int i10;
        StringBuilder sb2;
        if (this.f36302b) {
            il.b.j("mpHeaderBuf=" + jl.a.a(this.f36303c));
        }
        List<rl.a> a10 = rl.a.a(this.f36303c);
        this.f36304d = a10;
        if (a10 == null || a10.size() <= 0) {
            il.b.j("not found mp header");
            return;
        }
        for (rl.a aVar : this.f36304d) {
            byte[] d10 = aVar.d();
            if (d10 != null && d10.length > 0) {
                int e10 = aVar.e();
                if (e10 != 1) {
                    if (e10 != 2) {
                        if (e10 == 3) {
                            this.f36317q = c(d10);
                        } else if (e10 != 4) {
                            switch (e10) {
                                case 17:
                                    this.f36308h = d10[0] & 255;
                                    break;
                                case 18:
                                    if (d10.length >= 2) {
                                        this.f36310j = ((d10[1] << 8) & 65280) | (d10[0] & 255);
                                        this.f36311k = true;
                                        break;
                                    } else {
                                        break;
                                    }
                                case 19:
                                    if (d10.length >= 4) {
                                        this.f36318r = ((d10[3] << 24) & (-16777216)) | ((d10[2] << 16) & 16711680) | ((d10[1] << 8) & 65280) | (d10[0] & 255);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 20:
                                    if (d10.length >= 4) {
                                        i10 = ((d10[3] << 24) & (-16777216)) | ((d10[2] << 16) & 16711680) | ((d10[1] << 8) & 65280) | (d10[0] & 255);
                                        this.f36306f = i10;
                                        if (this.f36314n < 2) {
                                            this.f36314n = 2;
                                            this.f36313m = i10 - 12;
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                case 21:
                                    if (d10.length >= 2) {
                                        this.f36319s = ((d10[1] << 8) & 65280) | (d10[0] & 255);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 22:
                                    if (d10.length >= 4) {
                                        this.f36312l = ((d10[3] << 24) & (-16777216)) | ((d10[2] << 16) & 16711680) | ((d10[1] << 8) & 65280) | (d10[0] & 255);
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else if (d10.length >= 4) {
                            i10 = ((d10[3] << 24) & (-16777216)) | ((d10[2] << 16) & 16711680) | ((d10[1] << 8) & 65280) | (d10[0] & 255);
                            this.f36305e = i10;
                            if (this.f36314n < 1) {
                                this.f36314n = 1;
                                this.f36313m = i10 - 12;
                            }
                        }
                    } else if (d10.length != 4) {
                        sb2 = new StringBuilder();
                        sb2.append("invalid sub header, ");
                        sb2.append(aVar.toString());
                        il.b.c(sb2.toString());
                        this.f36304d = null;
                    } else {
                        this.f36316p = ((d10[3] << 24) & (-16777216)) | ((d10[2] << 16) & 16711680) | ((d10[1] << 8) & 65280) | (d10[0] & 255);
                    }
                } else if (d10.length != 2) {
                    sb2 = new StringBuilder();
                    sb2.append("invalid sub header, ");
                    sb2.append(aVar.toString());
                    il.b.c(sb2.toString());
                    this.f36304d = null;
                } else {
                    this.f36315o = ((d10[1] << 8) & 65280) | (d10[0] & 255);
                }
            }
        }
        if (this.f36301a) {
            Locale locale = Locale.US;
            il.b.c(String.format(locale, "MpHeader: binId=0x%04x, binVersion=0x%04x, partNumber=%s, mpDataLength=0x%08x(%d), otaVersion=0x%02x,  mImageSizeMechanism=0x%02x", Integer.valueOf(this.f36315o), Integer.valueOf(this.f36316p), this.f36317q, Integer.valueOf(this.f36305e), Integer.valueOf(this.f36305e), Integer.valueOf(this.f36308h), Integer.valueOf(this.f36314n)));
            if (this.f36308h > 0) {
                il.b.c(String.format(locale, "imageId=0x%04x, flashAddr=0x%08x, mpImageSize=0x%08x(%d), secureVersion=0x%04x, imageVersion=0x%08x", Integer.valueOf(this.f36310j), Integer.valueOf(this.f36318r), Integer.valueOf(this.f36306f), Integer.valueOf(this.f36306f), Integer.valueOf(this.f36319s), Integer.valueOf(this.f36312l)));
            }
        }
    }

    public void o() {
        if (this.f36302b) {
            il.b.j("headBuf=" + jl.a.a(this.f36307g));
        }
    }

    public void o0(int i10) {
        this.A = i10;
    }

    public final void q() {
        if (this.f36302b) {
            il.b.j("markSupported");
        }
        mark(0);
        read(this.f36303c, 0, 512);
        n();
        if (!d()) {
            il.b.k(this.f36302b, "reset to begin");
            reset();
        }
        il.b.k(this.f36302b, String.format(Locale.US, "isNeedReadDfuHeader()=%b, available()=%d", Boolean.valueOf(g0()), Integer.valueOf(available())));
        if (!g0() || available() < 316) {
            read(this.f36307g, 0, 12);
            System.arraycopy(this.f36307g, 0, this.f36322v, 0, 12);
        } else {
            mark(0);
            try {
                skip(304L);
            } catch (IOException unused) {
                il.b.l("skip error");
            }
            read(this.f36322v, 0, 12);
            i();
            reset();
            read(this.f36307g, 0, 12);
        }
        o();
    }

    public void r0(byte[] bArr) {
        this.f36323w = bArr;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Use readPacket() method instead");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return i0(bArr, bArr.length);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f36325y = 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.US;
        sb2.append(String.format(locale, "otaVersion=0x%02X, icType=0x%02X, imageId=0x%04X,binId=0x%04X, imageVersion=0x%08X, imageSize=0x%08X(%d)", Integer.valueOf(this.f36308h), Byte.valueOf(this.f36309i), Integer.valueOf(this.f36310j), Integer.valueOf(this.f36315o), Integer.valueOf(this.f36312l), Integer.valueOf(this.f36313m), Integer.valueOf(this.f36313m)));
        sb2.append(String.format(locale, ", sha256=%s, activeCompareVersionFlag=%d, inactiveCompareVersionFlag=%d,otaTempBufferCheckOrder=%d", jl.a.a(this.f36323w), Integer.valueOf(this.f36326z), Integer.valueOf(this.A), Integer.valueOf(this.C)));
        return sb2.toString();
    }

    public final void u() {
        read(this.f36307g, 0, 12);
        byte[] bArr = this.f36307g;
        if (bArr[0] == 1 && bArr[1] == 0 && bArr[2] == 2) {
            System.arraycopy(bArr, 0, this.f36303c, 0, 12);
            read(this.f36303c, 12, AGCServerException.UNKNOW_EXCEPTION);
            n();
            read(this.f36307g, 0, 12);
        }
        il.b.k(this.f36302b, String.format(Locale.US, "isNeedReadDfuHeader()=%b, available()=%d", Boolean.valueOf(g0()), Integer.valueOf(available())));
        if (!g0() || available() < 316) {
            System.arraycopy(this.f36307g, 0, this.f36322v, 0, 12);
        } else {
            byte[] bArr2 = new byte[304];
            System.arraycopy(this.f36307g, 0, bArr2, 0, 12);
            read(bArr2, 12, 292);
            read(this.f36322v, 0, 12);
            i();
        }
        o();
    }

    public int v() {
        return this.f36326z;
    }

    public int w() {
        return this.f36315o;
    }

    public byte[] x() {
        return this.f36322v;
    }
}
