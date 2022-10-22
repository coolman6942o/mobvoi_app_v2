package zl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import cm.d;
import com.mobvoi.wear.util.LogCleaner;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.util.List;
import ul.c;
import xl.a;
/* loaded from: classes2.dex */
public abstract class b extends a {

    /* renamed from: j0  reason: collision with root package name */
    public BluetoothManager f37628j0;

    /* renamed from: k0  reason: collision with root package name */
    public BluetoothAdapter f37629k0;

    /* renamed from: l0  reason: collision with root package name */
    public final Object f37630l0 = new Object();

    /* renamed from: m0  reason: collision with root package name */
    public volatile boolean f37631m0 = false;

    /* renamed from: n0  reason: collision with root package name */
    public int[] f37632n0;

    public b(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
        x();
    }

    public int J(String str) {
        BluetoothDevice M;
        if (this.f37629k0 == null || (M = M(str)) == null) {
            return 10;
        }
        return M.getBondState();
    }

    public void K(BluetoothDevice bluetoothDevice, int i10) {
        String str;
        if (bluetoothDevice != null && (str = this.E) != null && str.equals(bluetoothDevice.getAddress()) && i10 == 2) {
            il.b.j("profile connected");
            r();
        }
    }

    public void L(ScannerParams scannerParams) {
        if (!this.f36594h) {
            D(515);
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
                il.b.l("findRemoteDevice interrupted, e = " + e10.toString());
                this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
            }
            if (this.C == 0 && !this.f37631m0) {
                il.b.l("didn't find the remote device");
                this.C = DfuException.ERROR_CANNOT_FIND_DEVICE;
            }
            if (this.C != 0) {
                throw new OtaException("Error while scan remote device", this.C);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public BluetoothDevice M(String str) {
        try {
            return this.f37629k0.getRemoteDevice(str);
        } catch (Exception e10) {
            il.b.l(e10.toString());
            return null;
        }
    }

    public boolean N(ScannerParams scannerParams) {
        return false;
    }

    public void O() {
        synchronized (this.U) {
            if (this.T) {
                il.b.d(this.f36587a, "Remote busy now, just wait!");
                try {
                    this.U.wait(LogCleaner.ONE_MINUTE);
                } catch (InterruptedException unused) {
                }
                if (this.f36588b) {
                    il.b.j("Remote idle now, just go!");
                }
            }
        }
    }

    public void P() {
        int k10 = u().k();
        int l10 = u().l();
        if (l10 < 0 || l10 >= k10) {
            il.b.c("invalid FileIndex: " + l10 + ", reset to 0");
            l10 = 0;
        }
        u().z(l10);
        wl.a aVar = this.f36608v.get(l10);
        this.f36609w = aVar;
        if (aVar != null) {
            u().s(this.f36609w.w(), this.f36609w.O(), this.f36609w.T(), this.f36609w.k0(), t().Q());
        } else {
            il.b.k(this.f36588b, "mCurBinInputStream == null");
        }
        int i10 = l10 + 1;
        if (i10 < k10) {
            this.f36610x = this.f36608v.get(i10);
            this.f36611y = i10;
        } else {
            this.f36610x = null;
            this.f36611y = -1;
        }
        if (this.f36587a) {
            il.b.j(u().toString());
        }
    }

    public void Q() {
        m(this.f36609w);
        List<wl.a> r10 = ul.b.r(new c.b().f(t().y()).e(t().i()).h(this.G).i(t().k()).o(this.f36589c).g(this.H).m(t().v()).k(v()).j(t().N()).l(t().P()).n(t().R(), t().D()).c());
        this.f36608v = r10;
        if (r10 == null || r10.size() <= 0) {
            il.b.d(this.f36587a, "pendingImageInputStreams is null or empty");
            throw new LoadFileException("no available file to update", 4097);
        }
        if (u().l() == 0) {
            this.f37632n0 = new int[this.f36608v.size()];
        }
        u().B(this.f36608v.size());
        P();
    }

    @Override // xl.a
    public void x() {
        String str;
        super.x();
        this.M = new d(this.f36590d, 2);
        if (this.f37628j0 == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.f36589c.getSystemService("bluetooth");
            this.f37628j0 = bluetoothManager;
            if (bluetoothManager == null) {
                str = "Unable to initialize BluetoothManager.";
                il.b.l(str);
            }
        }
        BluetoothAdapter adapter = this.f37628j0.getAdapter();
        this.f37629k0 = adapter;
        if (adapter == null) {
            str = "Unable to obtain a BluetoothAdapter.";
            il.b.l(str);
        }
    }

    @Override // xl.a
    public int y() {
        int y10 = super.y();
        if (y10 != 0) {
            return y10;
        }
        if (BluetoothAdapter.checkBluetoothAddress(this.F)) {
            return 0;
        }
        if (this.f36587a) {
            il.b.l("invalid address: " + this.F);
            return 4112;
        }
        il.b.c("invalid address: ");
        return 4112;
    }
}
