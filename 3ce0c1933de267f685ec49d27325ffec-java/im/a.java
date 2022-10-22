package im;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import b.c;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import el.d;
import el.e;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ul.c;
import zl.b;
/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: o0  reason: collision with root package name */
    public el.a f28334o0;

    /* renamed from: p0  reason: collision with root package name */
    public volatile boolean f28335p0;

    /* renamed from: q0  reason: collision with root package name */
    public C0318a f28336q0;

    /* renamed from: r0  reason: collision with root package name */
    public volatile byte[] f28337r0 = null;

    /* renamed from: s0  reason: collision with root package name */
    public volatile boolean f28338s0 = false;

    /* renamed from: t0  reason: collision with root package name */
    public Set<Short> f28339t0;

    /* renamed from: u0  reason: collision with root package name */
    public Map<Short, b.a> f28340u0;

    /* renamed from: v0  reason: collision with root package name */
    public c f28341v0;

    /* renamed from: im.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0318a extends d {
        public C0318a() {
        }

        @Override // el.d
        public void b(el.b bVar) {
            super.b(bVar);
            if (!a.this.f28335p0) {
                if (a.this.f36587a) {
                    il.b.c("is already stop the scan, do nothing");
                }
            } else if (bVar != null) {
                a.this.R(bVar);
            } else if (a.this.f36587a) {
                il.b.c("ignore, device == null");
            }
        }

        @Override // el.d
        public void c(int i10) {
            super.c(i10);
            if (a.this.f36588b) {
                il.b.j("state= " + i10);
            }
        }
    }

    public a(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
    }

    @Override // xl.a
    public void F() {
        super.F();
        this.f28335p0 = false;
        el.a aVar = this.f28334o0;
        if (aVar != null) {
            aVar.l();
        }
    }

    @Override // zl.b
    public boolean N(ScannerParams scannerParams) {
        if (this.f36587a) {
            il.b.j("start le scan");
        }
        this.f28335p0 = true;
        el.a aVar = this.f28334o0;
        if (aVar == null) {
            Z(scannerParams);
        } else {
            aVar.m(scannerParams);
        }
        return this.f28334o0.n();
    }

    @Override // zl.b
    public void P() {
        int k10 = u().k();
        int l10 = u().l();
        if (l10 < 0 || l10 >= k10) {
            il.b.j("invalid FileIndex: " + l10 + ", reset to 0");
            l10 = 0;
        }
        u().z(l10);
        wl.a aVar = this.f36608v.get(l10);
        this.f36609w = aVar;
        if (aVar != null) {
            if (this.f36587a) {
                il.b.j(String.format("mCurBinInputStream's binId=0x%04X", Integer.valueOf(aVar.w())));
            }
            u().s(this.f36609w.w(), this.f36609w.O(), this.f36609w.T(), this.f36609w.k0(), t().Q());
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

    @Override // zl.b
    public void Q() {
        m(this.f36609w);
        List<wl.a> r10 = ul.b.r(new c.b().f(t().y()).e(t().i()).h(this.G).i(t().k()).o(this.f36589c).m(this.I).g(this.H).k(v()).j(t().N()).l(t().P()).n(t().R(), t().D()).c());
        this.f36608v = r10;
        if (r10 == null || r10.size() <= 0) {
            il.b.d(this.f36587a, "pendingImageInputStreams == null || pendingImageInputStreams.size() <= 0");
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

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e3, code lost:
        if (r1.equals(r5.F) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0129, code lost:
        if (r1.equals(r0.getAddress()) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012b, code lost:
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R(el.b bVar) {
        boolean z10;
        BluetoothDevice a10 = bVar.a();
        e e10 = e.e(bVar.c());
        if (this.f36607u == 519) {
            if (e10 == null) {
                il.b.c("ignore , specScanRecord is null");
                return;
            }
            if (this.f36587a) {
                il.b.j(e10.toString());
            }
            byte[] c10 = e10.c(t().s());
            if (c10 == null) {
                il.b.c("no match manufacture data found");
                return;
            }
            if (this.f36587a) {
                il.b.j("manufacturerSpecificData=" + jl.a.a(c10));
            }
            if (v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) {
                if (this.f36588b) {
                    il.b.j("deviceMac= " + jl.a.a(v().u()));
                }
                z10 = Arrays.equals(c10, v().u());
            } else {
                String d10 = fl.a.d(c10);
                if (this.f36588b) {
                    il.b.j("manufacturerAddr= " + fl.a.c(d10, true) + ", mDeviceAddress= " + fl.a.c(this.F, true));
                }
                if (d10 != null) {
                }
                z10 = false;
            }
        } else if (this.f36607u == 515) {
            String str = this.F;
            if (str != null) {
            }
            z10 = false;
        } else {
            il.b.j("ignore process state: " + this.f36607u);
            return;
        }
        if (z10) {
            this.D = bVar.b();
            this.E = a10.getAddress();
            if (this.f36587a) {
                il.b.c("find target device: name=" + this.D + " addr=" + fl.a.c(this.E, true));
            }
            c0();
            synchronized (this.f37630l0) {
                this.f37631m0 = true;
                this.f37630l0.notifyAll();
            }
        }
    }

    public boolean S(short s10, byte[] bArr) {
        return U(s10, bArr, bArr != null ? bArr.length : -1, false);
    }

    public boolean T(short s10, byte[] bArr, int i10) {
        return U(s10, bArr, i10, false);
    }

    public boolean U(short s10, byte[] bArr, int i10, boolean z10) {
        if (!this.f36594h || z10) {
            this.f28337r0 = null;
            this.f36605s = true;
            boolean z11 = false;
            this.f36604r = false;
            boolean X = X(s10, bArr, i10);
            int i11 = DfuException.ERROR_WRITE_CHARAC_ERROR;
            if (X) {
                synchronized (this.f36603q) {
                    try {
                        if (!this.f36604r && this.f36599m == 515) {
                            this.f36603q.wait(15000L);
                        }
                    } catch (InterruptedException e10) {
                        il.b.l("mWriteLock Sleeping interrupted,e:" + e10);
                        if (this.C == 0) {
                            this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                        }
                    }
                }
                if (this.f36588b) {
                    il.b.j(String.format("errorCode=0x%04X, mWriteRequestCompleted=%b, mConnectionState=0x%04X", 0, Boolean.valueOf(this.f36604r), Integer.valueOf(this.f36599m)));
                }
                if (this.C == 0) {
                    if (!this.f36604r) {
                        il.b.d(this.f36587a, "send command but no callback");
                        i11 = DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK;
                    } else if (this.f36605s) {
                        il.b.d(this.f36587a, "write failed");
                    }
                    this.C = i11;
                }
                z11 = X;
            } else {
                il.b.c("write spp data error");
                this.C = DfuException.ERROR_WRITE_CHARAC_ERROR;
            }
            if (this.C == 0) {
                return z11;
            }
            throw new OtaException("Error while send command", this.C);
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public boolean V(short s10, byte[] bArr, boolean z10) {
        return U(s10, bArr, bArr != null ? bArr.length : -1, z10);
    }

    public void W(int i10) {
        int i11 = 16;
        if (i10 > 16) {
            i11 = 16 * (i10 / 16);
        }
        this.S = i11;
        il.b.c("> mBufferCheckMtuSize=" + this.S);
    }

    public final boolean X(short s10, byte[] bArr, int i10) {
        if (this.f28341v0 == null) {
            il.b.l("mTransportLayer == null");
            return false;
        }
        if (bArr != null && bArr.length > i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, 0, bArr2, 0, i10);
            bArr = bArr2;
        }
        return this.f28341v0.k(s10, bArr);
    }

    public byte[] Y(long j10) {
        this.C = 0;
        this.f28338s0 = true;
        try {
            synchronized (this.L) {
                if (this.C == 0 && this.f28337r0 == null && this.f36599m == 515) {
                    this.f28338s0 = false;
                    if (this.f36588b) {
                        il.b.j("wait for notification, wait for " + j10 + "ms");
                    }
                    this.L.wait(j10);
                }
                if (this.C == 0 && !this.f28338s0) {
                    il.b.l("wait for notification, but not come");
                    this.C = DfuException.ERROR_NOTIFICATION_NO_RESPONSE;
                }
            }
        } catch (InterruptedException e10) {
            il.b.e("readNotificationResponse interrupted, " + e10.toString());
            this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
        }
        if (this.C == 0) {
            return this.f28337r0;
        }
        throw new OtaException("Unable to receive notification", this.C);
    }

    public final void Z(ScannerParams scannerParams) {
        if (this.f28336q0 == null) {
            this.f28336q0 = new C0318a();
        }
        this.f28334o0 = new el.a(this.f36589c, scannerParams, this.f28336q0);
    }

    public ScannerParams a0() {
        ScannerParams scannerParams = new ScannerParams(32);
        scannerParams.t(31000L);
        return scannerParams;
    }

    public byte[] b0() {
        return Y(t().t());
    }

    public boolean c0() {
        this.f28335p0 = false;
        el.a aVar = this.f28334o0;
        if (aVar == null) {
            return true;
        }
        aVar.o();
        return true;
    }

    @Override // zl.b, xl.a
    public void x() {
        super.x();
        this.f28339t0 = new HashSet();
        this.f28340u0 = new HashMap();
        Z(null);
        this.f36593g = true;
        il.b.j("initialize success");
    }
}
