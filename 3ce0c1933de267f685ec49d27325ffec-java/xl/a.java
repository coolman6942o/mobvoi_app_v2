package xl;

import android.content.Context;
import android.text.TextUtils;
import cm.d;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.utils.AesJni;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import yl.b;
/* loaded from: classes2.dex */
public abstract class a extends Thread {
    public byte[] A;
    public AesJni B;
    public volatile int C;
    public String D;
    public String E;
    public String F;
    public String G;
    public d M;
    public DfuProgressInfo N;
    public b W;

    /* renamed from: c  reason: collision with root package name */
    public Context f36589c;

    /* renamed from: e  reason: collision with root package name */
    public DfuConfig f36591e;

    /* renamed from: f  reason: collision with root package name */
    public b f36592f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36593g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36594h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36595i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36596j;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f36601o;

    /* renamed from: r  reason: collision with root package name */
    public volatile boolean f36604r;

    /* renamed from: s  reason: collision with root package name */
    public volatile boolean f36605s;

    /* renamed from: t  reason: collision with root package name */
    public volatile boolean f36606t;

    /* renamed from: w  reason: collision with root package name */
    public wl.a f36609w;

    /* renamed from: x  reason: collision with root package name */
    public wl.a f36610x;

    /* renamed from: y  reason: collision with root package name */
    public int f36611y;

    /* renamed from: z  reason: collision with root package name */
    public int f36612z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f36587a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36588b = false;

    /* renamed from: d  reason: collision with root package name */
    public int f36590d = 0;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f36597k = false;

    /* renamed from: l  reason: collision with root package name */
    public final Object f36598l = new Object();

    /* renamed from: m  reason: collision with root package name */
    public int f36599m = 0;

    /* renamed from: n  reason: collision with root package name */
    public final Object f36600n = new Object();

    /* renamed from: p  reason: collision with root package name */
    public volatile byte[] f36602p = null;

    /* renamed from: q  reason: collision with root package name */
    public final Object f36603q = new Object();

    /* renamed from: u  reason: collision with root package name */
    public volatile int f36607u = DfuException.ERROR_FILE_IO_EXCEPTION;

    /* renamed from: v  reason: collision with root package name */
    public List<wl.a> f36608v = new ArrayList();
    public int H = -1;
    public int I = 0;
    public boolean J = false;
    public int K = 20;
    public final Object L = new Object();
    public int O = 0;
    public int P = 0;
    public int Q = 0;
    public int R = 256;
    public int S = 16;
    public boolean T = false;
    public final Object U = new Object();
    public final Object V = new Object();

    public a(Context context, DfuConfig dfuConfig, b bVar) {
        this.f36589c = context;
        this.f36591e = dfuConfig;
        this.f36592f = bVar;
    }

    public static byte[] n(String str) {
        byte[] bArr = new byte[6];
        if (str != null) {
            bArr[5] = (byte) ((Character.digit(str.charAt(15), 16) * 16) + Character.digit(str.charAt(16), 16));
            bArr[4] = (byte) ((Character.digit(str.charAt(12), 16) * 16) + Character.digit(str.charAt(13), 16));
            bArr[3] = (byte) ((Character.digit(str.charAt(9), 16) * 16) + Character.digit(str.charAt(10), 16));
            bArr[2] = (byte) ((Character.digit(str.charAt(6), 16) * 16) + Character.digit(str.charAt(7), 16));
            bArr[1] = (byte) ((Character.digit(str.charAt(3), 16) * 16) + Character.digit(str.charAt(4), 16));
            bArr[0] = (byte) ((Character.digit(str.charAt(0), 16) * 16) + Character.digit(str.charAt(1), 16));
        } else {
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 0;
            bArr[4] = 0;
            bArr[5] = 0;
        }
        return bArr;
    }

    public void A() {
        try {
            synchronized (this.f36598l) {
                this.f36597k = true;
                if (this.f36588b) {
                    il.b.j(String.format("isConnectedCallbackCome=%b", Boolean.valueOf(this.f36597k)));
                }
                this.f36598l.notifyAll();
            }
        } catch (Exception e10) {
            il.b.e(e10.toString());
        }
    }

    public void B() {
        this.f36606t = u().t();
        b bVar = this.f36592f;
        if (bVar != null) {
            bVar.b(u());
        } else {
            il.b.k(this.f36588b, "no callback registered ");
        }
    }

    public void C() {
        synchronized (this.f36600n) {
            this.f36601o = true;
            this.f36600n.notifyAll();
        }
    }

    public void D(int i10) {
        E(i10, true);
    }

    public void E(int i10, boolean z10) {
        il.b.c(String.format("DFU: 0x%04X >> 0x%04X(%s)", Integer.valueOf(this.f36607u), Integer.valueOf(i10), kl.a.b(i10)));
        this.f36607u = i10;
        if (z10) {
            b bVar = this.f36592f;
            if (bVar != null) {
                bVar.c(this.f36607u, null);
            } else {
                il.b.k(this.f36588b, "no callback registered");
            }
        } else {
            il.b.c("no need to notify state change");
        }
    }

    public void F() {
    }

    public void G(int i10) {
        il.b.c(String.format("Conn: 0x%04X >> 0x%04X(%s)", Integer.valueOf(this.f36599m), Integer.valueOf(i10), kl.a.a(i10)));
        this.f36599m = i10;
    }

    public void H() {
        if (this.W == null) {
            l();
        }
        this.W.b();
    }

    public void I() {
        String str;
        try {
        } catch (InterruptedException e10) {
            il.b.l("waitUntilDisconnected interrupted: " + e10.toString());
        }
        synchronized (this.f36598l) {
            int i10 = this.f36599m;
            if (i10 == 0 || i10 == 1280) {
                if (this.f36587a) {
                    il.b.c("connection already disconnected");
                }
                return;
            }
            if (this.f36587a) {
                il.b.j("wait for disconnect, wait for 32000ms");
            }
            this.f36598l.wait(32000L);
            int i11 = this.f36599m;
            if (i11 != 0 && i11 != 1280) {
                str = "waitUntilDisconnected timeout";
            } else if (this.f36587a) {
                str = "connection disconnected";
            } else {
                return;
            }
            il.b.c(str);
        }
    }

    public short a(byte[] bArr, int i10) {
        short s10 = 0;
        for (int i11 = 0; i11 < i10; i11 += 2) {
            s10 = (short) (s10 ^ ((short) ((bArr[i11 + 1] << 8) | (bArr[i11] & 255))));
        }
        return (short) (((s10 & 255) << 8) | ((65280 & s10) >> 8));
    }

    public void b(int i10) {
        int max = Math.max(16, i10);
        this.R = max;
        il.b.k(this.f36587a, String.format(Locale.US, "mCurrentMaxBufferSize= %d", Integer.valueOf(max)));
    }

    public void c(long j10) {
        try {
            il.b.j("wait device auto reconnect for " + j10);
            synchronized (this.V) {
                this.V.wait(j10);
            }
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
    }

    public void d(wl.a aVar) {
        if (u().i() > 102400 && u().f() == 104000) {
            try {
                u().y(143348);
                aVar.skip(39348);
                il.b.c("big image reach the special size, skip some packet");
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    public boolean e() {
        return !this.f36594h;
    }

    public boolean f() {
        if (z()) {
            il.b.c("already in idle state");
        } else {
            this.f36594h = true;
            E(525, true);
            g();
        }
        p();
        synchronized (this.f36600n) {
            this.f36600n.notifyAll();
        }
        synchronized (this.f36598l) {
            this.f36598l.notifyAll();
        }
        r();
        return true;
    }

    public void g() {
    }

    public boolean h(boolean z10) {
        if (this.f36607u == 523) {
            return true;
        }
        il.b.l(String.format("activeImage failed, state conflict: 0x%04X", Integer.valueOf(this.f36607u)));
        return false;
    }

    public void i(int i10, boolean z10) {
        int i11 = 0;
        if (i10 != 0) {
            try {
                int max = Math.max(i10 - 12, 0);
                byte[] bArr = new byte[u().i()];
                i11 = z10 ? this.f36609w.i0(bArr, max) : this.f36609w.read(bArr, 0, max);
            } catch (IOException e10) {
                il.b.e(e10.toString());
                return;
            }
        }
        u().y(i11);
    }

    public boolean j() {
        String str;
        if (this.B == null) {
            this.B = new AesJni();
        }
        if (this.B.aesInit(3, this.A)) {
            return true;
        }
        if (this.f36588b) {
            str = "encrpt initial error, encrypted key: " + Arrays.toString(this.A);
        } else {
            str = "encrpt initial error, encrypted key invalid!";
        }
        il.b.l(str);
        return false;
    }

    public void k() {
        b bVar = this.W;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void l() {
        this.W = new b(t().L(), t().l());
    }

    public void m(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (this.f36588b) {
                    il.b.j("closeInputStream...");
                }
                inputStream.close();
            } catch (IOException e10) {
                boolean z10 = this.f36587a;
                il.b.m(z10, "closeInputStream fail: " + e10.toString());
            }
        }
    }

    public boolean o() {
        return (this.f36599m & 512) == 512;
    }

    public void p() {
        synchronized (this.L) {
            this.L.notifyAll();
        }
    }

    public void q() {
    }

    public void r() {
        try {
            synchronized (this.V) {
                this.V.notifyAll();
            }
        } catch (Exception e10) {
            il.b.e(e10.toString());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        setName("DFU");
        q();
        F();
    }

    public void s() {
        synchronized (this.f36603q) {
            this.f36604r = true;
            this.f36603q.notifyAll();
        }
    }

    public DfuConfig t() {
        if (this.f36591e == null) {
            this.f36591e = new DfuConfig();
        }
        return this.f36591e;
    }

    public DfuProgressInfo u() {
        if (this.N == null) {
            this.N = new DfuProgressInfo();
        }
        return this.N;
    }

    public d v() {
        if (this.M == null) {
            this.M = new d(this.f36590d, 2);
        }
        return this.M;
    }

    public void w() {
        c(5000L);
    }

    public void x() {
        E(513, true);
        this.f36593g = false;
        this.f36594h = false;
        this.T = false;
        this.B = new AesJni();
        this.f36595i = false;
        this.f36608v = new ArrayList();
        this.f36612z = 0;
        this.N = new DfuProgressInfo();
        this.C = 0;
        if (t().p() != 0) {
            this.f36587a = true;
        } else {
            this.f36587a = kl.b.f30015a;
        }
        this.f36588b = kl.b.f30016b;
        if (this.f36587a) {
            il.b.c(t().toString());
        }
        this.f36590d = t().A();
        this.F = t().b();
        this.I = t().v();
        this.G = t().j();
        this.H = t().h();
        this.A = t().C();
        this.J = t().E();
        this.K = t().z();
    }

    public int y() {
        StringBuilder sb2;
        if (!this.f36593g) {
            il.b.l("DfuThread not initialized");
            return 4114;
        } else if (TextUtils.isEmpty(this.G)) {
            il.b.l("the file path string is null");
            return 4098;
        } else {
            String b10 = jl.b.b(this.G);
            if (b10 == null || !b10.equalsIgnoreCase(t().k())) {
                il.b.l("the file suffix is not right, suffix=" + b10);
                return 4099;
            }
            if (t().i() == 1) {
                if (lm.d.d(this.f36589c, this.G)) {
                    return 0;
                }
                sb2 = new StringBuilder();
            } else if (jl.b.a(this.G)) {
                return 0;
            } else {
                sb2 = new StringBuilder();
            }
            sb2.append("the bin file not exist, path: ");
            sb2.append(this.G);
            il.b.l(sb2.toString());
            return 4100;
        }
    }

    public boolean z() {
        return (this.f36607u & 256) == 256;
    }
}
