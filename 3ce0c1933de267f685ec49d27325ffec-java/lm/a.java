package lm;

import al.d;
import al.e;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.text.TextUtils;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.params.QcConfig;
import java.util.Locale;
import lm.c;
import ul.c;
/* loaded from: classes2.dex */
public abstract class a extends c {

    /* renamed from: n  reason: collision with root package name */
    public BluetoothAdapter f30510n;

    /* renamed from: o  reason: collision with root package name */
    public al.b f30511o;

    /* renamed from: p  reason: collision with root package name */
    public d f30512p;

    /* renamed from: q  reason: collision with root package name */
    public BluetoothDevice f30513q;

    /* renamed from: s  reason: collision with root package name */
    public String f30515s;

    /* renamed from: u  reason: collision with root package name */
    public al.a f30517u;

    /* renamed from: r  reason: collision with root package name */
    public int f30514r = 10;

    /* renamed from: t  reason: collision with root package name */
    public e f30516t = new C0388a();

    /* renamed from: v  reason: collision with root package name */
    public nm.b f30518v = new b();

    /* renamed from: lm.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0388a extends e {
        public C0388a() {
        }

        @Override // al.e
        public void c(BluetoothDevice bluetoothDevice, int i10) {
            super.c(bluetoothDevice, i10);
            a.this.y(i10);
        }

        @Override // al.e
        public void d(BluetoothDevice bluetoothDevice, int i10) {
            super.d(bluetoothDevice, i10);
            BluetoothDevice bluetoothDevice2 = a.this.f30513q;
            if (bluetoothDevice2 == null || !bluetoothDevice2.equals(bluetoothDevice)) {
                il.b.j("bonded device not match with current device");
            } else {
                a.this.z(i10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends nm.b {
        public b() {
        }

        @Override // xl.b
        public void a(int i10) {
            a aVar = a.this;
            aVar.f30550k = false;
            aVar.i(i10);
        }

        @Override // xl.b
        public void b(DfuProgressInfo dfuProgressInfo) {
            super.b(dfuProgressInfo);
            a.this.l(dfuProgressInfo);
        }

        @Override // xl.b
        public void c(int i10, Throughput throughput) {
            super.c(i10, throughput);
            a aVar = a.this;
            aVar.f30550k = (i10 & 512) == 512;
            c.b bVar = aVar.f30547h;
            if (bVar != null) {
                bVar.b(i10, throughput);
            } else {
                il.b.k(aVar.f30542c, "no callback registered");
            }
        }

        @Override // nm.b
        public void d(boolean z10, nm.a aVar) {
            int i10;
            a aVar2;
            if (z10) {
                il.b.c("DfuService connected");
                aVar2 = a.this;
                aVar2.f30544e = aVar;
                i10 = DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED;
            } else {
                il.b.c("DfuService disconnected");
                aVar2 = a.this;
                aVar2.f30544e = null;
                i10 = 0;
            }
            aVar2.m(i10);
        }
    }

    public boolean A(cm.d dVar, DfuConfig dfuConfig) {
        return B(dVar, dfuConfig, null, true);
    }

    public boolean B(cm.d dVar, DfuConfig dfuConfig, QcConfig qcConfig, boolean z10) {
        if (dfuConfig == null) {
            il.b.l("dfuConfig cannot be null");
            throw new IllegalArgumentException("dfuConfig cannot be null");
        } else if (this.f30544e == null) {
            il.b.l("DFU not ready, please make sure that you have call initialize() before");
            f();
            return false;
        } else {
            if (dVar != null) {
                dfuConfig.Z(dVar.E());
            }
            if (!z10 || dVar == null || x(dVar, dfuConfig) == 0) {
                return true;
            }
            i(4097);
            return false;
        }
    }

    @Override // lm.c
    public boolean c(lm.b bVar) {
        if (!super.c(bVar)) {
            return false;
        }
        if (this.f30545f.a() != null) {
            return true;
        }
        il.b.l("address is null");
        return false;
    }

    @Override // lm.c
    public boolean f() {
        return w(this.f30547h);
    }

    public void o(DfuException dfuException) {
        if (p(dfuException.getErrCode())) {
            this.f30546g--;
            Handler handler = this.f30551l;
            if (handler != null) {
                handler.postDelayed(this.f30552m, 1000L);
                return;
            }
            return;
        }
        d();
        j(dfuException.getErrType(), dfuException.getErrCode());
    }

    public boolean p(int i10) {
        if (this.f30549j <= 258) {
            il.b.l("has not be initialized");
            return false;
        }
        int i11 = this.f30546g;
        if (i11 > 0) {
            return i10 == 0 || i10 == 1 || i10 == 6;
        }
        il.b.j(String.format(Locale.US, "reconnectTimes=%d, no need to reconnect", Integer.valueOf(i11)));
        return false;
    }

    public void q() {
        boolean z10 = kl.b.f30015a;
        this.f30540a = z10;
        this.f30541b = z10;
        this.f30542c = kl.b.f30016b;
        this.f30510n = BluetoothAdapter.getDefaultAdapter();
        u().l0(2);
        this.f30517u = s();
        al.b g10 = al.b.g();
        this.f30511o = g10;
        if (g10 == null) {
            al.b.i(this.f30543d);
            this.f30511o = al.b.g();
        }
        al.b bVar = this.f30511o;
        if (bVar != null) {
            bVar.b(this.f30517u);
        } else {
            il.b.k(this.f30540a, "BluetoothProfileManager not initialized");
        }
        d d10 = d.d();
        this.f30512p = d10;
        if (d10 == null) {
            d.e(this.f30543d);
            this.f30512p = d.d();
        }
        d dVar = this.f30512p;
        if (dVar != null) {
            dVar.b(this.f30516t);
        } else {
            il.b.l("BluetoothProfileManager not initialized");
        }
    }

    public boolean r(DfuConfig dfuConfig, cm.d dVar) {
        cm.a q5 = ul.b.q(new c.b().o(this.f30543d).e(dfuConfig.i()).h(dfuConfig.j()).l(dfuConfig.P()).j(dfuConfig.N()).i(dfuConfig.k()).n(dfuConfig.R(), dfuConfig.D()).m(dfuConfig.v()).k(dVar).c());
        return q5 != null && q5.f5985h == 4096;
    }

    public al.a s() {
        return null;
    }

    public int t(String str) {
        BluetoothDevice v10;
        if (this.f30510n == null || (v10 = v(str)) == null) {
            return 10;
        }
        return v10.getBondState();
    }

    public cm.d u() {
        return new cm.d(2);
    }

    public BluetoothDevice v(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BluetoothAdapter bluetoothAdapter = this.f30510n;
        if (bluetoothAdapter == null) {
            il.b.l("mBluetoothAdapter == null");
            return null;
        }
        try {
            return bluetoothAdapter.getRemoteDevice(str);
        } catch (Exception e10) {
            il.b.e(e10.toString());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
        if (r5 == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean w(c.b bVar) {
        this.f30547h = bVar;
        int i10 = 0;
        if (this.f30549j == 257) {
            il.b.l("STATE_INIT_BINDING_SERVICE ...");
            return false;
        }
        boolean z10 = true;
        if (this.f30544e == null) {
            m(DfuException.ERROR_FILE_IO_EXCEPTION);
            z10 = nm.a.e(this.f30543d, this.f30518v);
            boolean z11 = this.f30540a;
            il.b.k(z11, "getDfuProxy: " + z10);
        } else {
            il.b.k(this.f30540a, "dfu already binded");
            i10 = DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED;
        }
        m(i10);
        return z10;
    }

    public int x(cm.d dVar, DfuConfig dfuConfig) {
        boolean z10;
        String str;
        try {
            if (!r(dfuConfig, dVar)) {
                il.b.l("checkImage failed");
                return 4097;
            } else if (!dfuConfig.F() || !dVar.P()) {
                return 0;
            } else {
                if (dVar.R()) {
                    if (dVar.D() > 0 && dVar.D() < dfuConfig.r()) {
                        z10 = this.f30540a;
                        str = "primary battery low";
                    } else if (dVar.I() <= 0 || dVar.I() >= dfuConfig.r()) {
                        return 0;
                    } else {
                        z10 = this.f30540a;
                        str = "secondary battery low";
                    }
                } else if (dVar.D() >= dfuConfig.r()) {
                    return 0;
                } else {
                    z10 = this.f30540a;
                    str = "battery low";
                }
                il.b.d(z10, str);
                return DfuException.ERROR_BATTERY_LEVEL_LOW;
            }
        } catch (DfuException e10) {
            return e10.getErrCode();
        }
    }

    public void y(int i10) {
    }

    public abstract void z(int i10);
}
