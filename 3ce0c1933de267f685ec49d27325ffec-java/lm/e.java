package lm;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import bm.a;
import bm.f;
import com.realsil.sdk.dfu.exception.ConnectionException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.params.QcConfig;
import com.tendcloud.tenddata.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public class e extends lm.a implements f {
    public static volatile e I;
    public BluetoothGattCharacteristic A;
    public bm.a B;
    public a.c C = new a();
    public Runnable D = new b();
    public Runnable E = new c();
    public Runnable F = new d();
    public Handler G = new Handler(Looper.getMainLooper());
    public BluetoothGattCallback H = new C0390e();

    /* renamed from: w  reason: collision with root package name */
    public al.c f30554w;

    /* renamed from: x  reason: collision with root package name */
    public BluetoothGatt f30555x;

    /* renamed from: y  reason: collision with root package name */
    public BluetoothGattService f30556y;

    /* renamed from: z  reason: collision with root package name */
    public BluetoothGattService f30557z;

    /* loaded from: classes2.dex */
    public class a implements a.c {
        public a() {
        }

        @Override // bm.a.c
        public void a(int i10) {
            e eVar;
            int i11;
            if (!e.this.h()) {
                e eVar2 = e.this;
                il.b.k(eVar2.f30542c, String.format("ignore, is not in preparing state: 0x%04X", Integer.valueOf(eVar2.f30549j)));
            } else if (i10 == 1) {
                if (e.this.g()) {
                    eVar = e.this;
                    i11 = 2074;
                } else {
                    eVar = e.this;
                    i11 = 527;
                }
                eVar.m(i11);
            } else if (i10 == 2) {
                e.this.o(new ConnectionException(5));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(15000L);
            try {
                Thread.sleep(800L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            e.this.N();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.N();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread thread;
            e eVar = e.this;
            if (eVar.f30549j == 536) {
                eVar.f30514r = eVar.t(eVar.f30515s);
                if (e.this.f30514r == 11) {
                    il.b.j("BOND_BONDING: wait to discover service");
                    thread = new Thread(e.this.D);
                } else {
                    il.b.j(">> mBondState: " + e.this.f30514r);
                    thread = new Thread(e.this.E);
                }
                thread.start();
                return;
            }
            il.b.c("ignore state:" + e.this.f30549j);
        }
    }

    /* renamed from: lm.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0390e extends BluetoothGattCallback {
        public C0390e() {
        }

        public final void a() {
            if (e.this.h()) {
                e.this.k();
                e.this.o(new ConnectionException(0));
                return;
            }
            e.this.m(4097);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i10);
            UUID uuid = bluetoothGattCharacteristic.getUuid();
            bluetoothGattCharacteristic.getValue();
            if (i10 == 0) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                if (f.f5254a0.equals(uuid)) {
                    ByteBuffer wrap = ByteBuffer.wrap(value);
                    wrap.order(ByteOrder.LITTLE_ENDIAN);
                    e.this.J(wrap.getShort(0));
                    if (e.this.B != null) {
                        bm.a aVar = e.this.B;
                        e eVar = e.this;
                        String str = eVar.f30515s;
                        BluetoothGatt bluetoothGatt2 = eVar.f30555x;
                        e eVar2 = e.this;
                        aVar.e(str, bluetoothGatt2, eVar2.f30556y, eVar2.f30557z);
                        return;
                    }
                    return;
                }
                return;
            }
            il.b.d(e.this.f30540a, String.format("Characteristic read error:0x%04X ", Integer.valueOf(i10)));
            if (!f.f5254a0.equals(uuid)) {
                il.b.j("ignore exctption when read other info");
            } else if (e.this.h()) {
                e.this.o(new ConnectionException(5));
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (i10 == 0) {
                if (i11 == 2) {
                    e eVar = e.this;
                    eVar.f30555x = eVar.f30554w.i(e.this.f30515s);
                    lm.b bVar = e.this.f30545f;
                    if (bVar != null && bVar.h()) {
                        dl.c.c(bluetoothGatt);
                    }
                    if (bluetoothGatt != null) {
                        e eVar2 = e.this;
                        if (eVar2.f30549j != 536) {
                            eVar2.m(536);
                            if (e.this.G != null) {
                                il.b.j("delay to discover service for : 1600");
                                e.this.G.removeCallbacks(e.this.F);
                                boolean postDelayed = e.this.G.postDelayed(e.this.F, 1600L);
                                if (!postDelayed) {
                                    boolean z10 = e.this.f30540a;
                                    il.b.k(z10, "postDelayed:" + postDelayed);
                                    return;
                                }
                                return;
                            }
                            il.b.k(e.this.f30540a, "mHandler == null");
                            return;
                        }
                        return;
                    }
                } else if (i11 == 0) {
                    e.this.d();
                } else {
                    return;
                }
            }
            a();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            e eVar = e.this;
            int i11 = eVar.f30549j;
            if (i11 == 1025) {
                il.b.c("ignore, when it is ota processing");
            } else if (i10 == 0) {
                eVar.m(539);
                if (i11 == 537) {
                    e.this.k();
                }
            } else {
                il.b.l("service discovery failed !!!");
                if (e.this.h()) {
                    e.this.o(new ConnectionException(1));
                }
            }
        }
    }

    public e(Context context) {
        this.f30543d = context;
        q();
    }

    public static e R(Context context) {
        if (I == null) {
            synchronized (e.class) {
                if (I == null) {
                    I = new e(context.getApplicationContext());
                }
            }
        }
        return I;
    }

    @Override // lm.a
    public boolean B(cm.d dVar, DfuConfig dfuConfig, QcConfig qcConfig, boolean z10) {
        if (!super.B(dVar, dfuConfig, qcConfig, z10)) {
            return false;
        }
        m(1025);
        al.c cVar = this.f30554w;
        if (cVar != null) {
            cVar.p(this.f30515s, this.H);
        }
        bm.a aVar = this.B;
        if (aVar != null) {
            aVar.b();
        }
        boolean f10 = this.f30544e.f(dfuConfig);
        if (!f10) {
            m(1026);
        }
        return f10;
    }

    public final boolean E(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice == null) {
            return false;
        }
        if (!al.b.g().j(4)) {
            il.b.l("HID_HOST not supported");
            return false;
        }
        int bondState = bluetoothDevice.getBondState();
        if (bondState != 12) {
            boolean z10 = this.f30540a;
            il.b.d(z10, "connect with not bond device, bond first, current state: " + bondState);
            n(512, 20);
            return bluetoothDevice.createBond();
        } else if (U(bluetoothDevice.getAddress())) {
            il.b.c("hogp already connected");
            return G(bluetoothDevice.getAddress());
        } else if (dl.b.c(bluetoothDevice)) {
            il.b.c("remove bond first");
            m(533);
            return false;
        } else {
            il.b.c("remove bond failed");
            m(529);
            return al.b.g().c(bluetoothDevice);
        }
    }

    public final boolean F(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f30555x == null || bluetoothGattCharacteristic == null) {
            il.b.l("mBtGatt is null maybe disconnected just now");
            return false;
        }
        if (this.f30540a) {
            il.b.j(String.format(Locale.US, "readCharacteristic:(%d) %s", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
        }
        return this.f30555x.readCharacteristic(bluetoothGattCharacteristic);
    }

    public final boolean G(String str) {
        m(535);
        return this.f30554w.g(str, this.H);
    }

    public final void J(int i10) {
        bm.a aVar;
        bm.a aVar2;
        boolean z10 = true;
        il.b.j(String.format("protocolType=0x%04X", Integer.valueOf(i10)));
        bm.a aVar3 = this.B;
        if (aVar3 != null) {
            aVar3.b();
        }
        if (i10 == 16) {
            aVar = new hm.a();
        } else if (i10 == 20) {
            aVar = new fm.a();
        } else {
            if (i10 == 18) {
                lm.b bVar = this.f30545f;
                if (bVar == null || !"BeeTgt02".equals(bVar.d())) {
                    z10 = false;
                }
                aVar2 = new dm.a(i10, z10);
            } else if (i10 == 19) {
                lm.b bVar2 = this.f30545f;
                if (bVar2 == null || !"BeeTgt02".equals(bVar2.d())) {
                    z10 = false;
                }
                aVar2 = new em.a(i10, z10);
            } else {
                lm.b bVar3 = this.f30545f;
                if (bVar3 == null || !"BeeTgt02".equals(bVar3.d())) {
                    z10 = false;
                }
                aVar = new gm.a(0, z10);
            }
            this.B = aVar2;
            this.B.f(this.f30545f, this.f30515s, this.f30555x, this.f30556y, this.f30557z, this.C);
        }
        this.B = aVar;
        this.B.f(this.f30545f, this.f30515s, this.f30555x, this.f30556y, this.f30557z, this.C);
    }

    public final boolean K(String str) {
        return E(v(str));
    }

    public final boolean N() {
        boolean z10;
        if (this.f30549j == 537) {
            il.b.l("discoverServices already started");
            return false;
        }
        m(537);
        il.b.k(this.f30542c, "discoverServices...");
        BluetoothGatt bluetoothGatt = this.f30555x;
        if (bluetoothGatt != null) {
            z10 = bluetoothGatt.discoverServices();
        } else {
            il.b.c("mBtGatt is null");
            z10 = false;
        }
        if (!z10) {
            il.b.d(this.f30541b, "discoverServices failed");
            if (h()) {
                o(new ConnectionException(1));
            }
            return false;
        }
        synchronized (this.f30548i) {
            try {
                il.b.j("wait discover service complete");
                this.f30548i.wait(ab.Y);
            } catch (InterruptedException e10) {
                il.b.d(this.f30541b, e10.toString());
            }
        }
        if (this.f30549j == 537) {
            il.b.l("discoverServices timeout");
            d();
            return false;
        }
        V();
        return true;
    }

    public boolean T(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice != null && al.b.g().f(4, bluetoothDevice) == 2;
    }

    public boolean U(String str) {
        return T(v(str));
    }

    public void V() {
        UUID uuid;
        BluetoothGatt bluetoothGatt;
        BluetoothGattService bluetoothGattService;
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        BluetoothGatt bluetoothGatt2 = this.f30555x;
        if (bluetoothGatt2 != null) {
            lm.b bVar = this.f30545f;
            if (bVar != null) {
                bluetoothGattService = bluetoothGatt2.getService(bVar.e());
                bluetoothGatt = this.f30555x;
                uuid = this.f30545f.c();
            } else {
                bluetoothGattService = bluetoothGatt2.getService(f.Z);
                bluetoothGatt = this.f30555x;
                uuid = f.f5255b0;
            }
            BluetoothGattService service = bluetoothGatt.getService(uuid);
            this.f30556y = bluetoothGattService;
            this.f30557z = service;
            m(540);
            if (bluetoothGattService == null) {
                boolean z10 = this.f30540a;
                il.b.d(z10, "not find OTA_SERVICE = " + f.Z);
                bluetoothGattCharacteristic = null;
            } else {
                boolean z11 = this.f30540a;
                il.b.k(z11, "find OTA_SERVICE = " + f.Z);
                bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(f.f5254a0);
            }
            this.A = bluetoothGattCharacteristic;
            if (this.A != null) {
                boolean z12 = this.f30540a;
                il.b.k(z12, "find CHARACTERISTIC_PROTOCOL_TYPE = " + f.f5254a0);
                F(this.A);
                return;
            }
            J(0);
            bm.a aVar = this.B;
            if (aVar != null) {
                aVar.e(this.f30515s, this.f30555x, this.f30556y, this.f30557z);
            }
        }
    }

    @Override // lm.c
    public boolean b() {
        boolean z10;
        if (!super.b()) {
            m(4098);
            return false;
        }
        if (!this.f30545f.g() || !(z10 = K(this.f30515s))) {
            z10 = G(this.f30515s);
        }
        if (!z10) {
            m(4098);
        }
        return z10;
    }

    @Override // lm.a, lm.c
    public boolean c(lm.b bVar) {
        boolean z10;
        if (!super.c(bVar)) {
            return false;
        }
        String str = this.f30515s;
        if (str != null && (Build.VERSION.SDK_INT < 19 ? !e(str, this.f30545f.a()) : !str.equals(this.f30545f.a()))) {
            this.f30554w.p(this.f30515s, this.H);
            this.f30554w.c(this.f30515s);
        }
        this.f30513q = v(this.f30545f.a());
        String a10 = this.f30545f.a();
        this.f30515s = a10;
        int t10 = t(a10);
        this.f30514r = t10;
        il.b.k(this.f30540a, String.format(Locale.US, ">> mBondState: %d", Integer.valueOf(t10)));
        if (!this.f30545f.g() || !(z10 = K(this.f30515s))) {
            z10 = G(this.f30515s);
        }
        if (!z10) {
            m(4098);
        }
        return z10;
    }

    @Override // lm.c
    public void d() {
        super.d();
        String str = this.f30515s;
        if (str == null) {
            il.b.c("no device registered");
        } else {
            al.c cVar = this.f30554w;
            if (cVar != null) {
                if (!cVar.n(str)) {
                    il.b.j("already disconnected");
                } else if (this.f30554w.m(this.f30515s, this.H)) {
                    m(4096);
                    this.f30554w.c(this.f30515s);
                    this.f30555x = null;
                } else {
                    il.b.k(this.f30541b, "no gatt callback registered");
                }
            }
        }
        m(4097);
        this.f30555x = null;
    }

    @Override // lm.a
    public void q() {
        super.q();
        al.c k10 = al.c.k();
        this.f30554w = k10;
        if (k10 == null) {
            al.c.l(this.f30543d);
            this.f30554w = al.c.k();
        }
    }

    @Override // lm.a
    public cm.d u() {
        bm.a aVar = this.B;
        return aVar != null ? aVar.k() : super.u();
    }

    @Override // lm.a
    public void y(int i10) {
        super.y(i10);
        if (i10 == 10 && Build.VERSION.SDK_INT >= 29) {
            if (h()) {
                il.b.j("auto disconnect when bt off");
                d();
                k();
                o(new ConnectionException(0));
                return;
            }
            m(4097);
        }
    }

    @Override // lm.a
    public void z(int i10) {
        switch (i10) {
            case 10:
                il.b.k(this.f30540a, "BOND_NONE");
                if (this.f30549j == 533 && this.f30513q != null) {
                    il.b.k(this.f30540a, "createBond");
                    this.f30513q.createBond();
                    return;
                }
                return;
            case 11:
                il.b.k(this.f30540a, "BOND_BONDING");
                return;
            case 12:
                il.b.k(this.f30540a, "BOND_BONDED");
                if (this.f30549j != 532) {
                    k();
                    return;
                } else if (this.f30513q == null) {
                    return;
                } else {
                    if (!U(this.f30515s)) {
                        il.b.k(this.f30542c, "hid not connect");
                        m(529);
                        al.b.g().c(this.f30513q);
                        return;
                    }
                    il.b.k(this.f30542c, "hid already connected");
                    G(this.f30515s);
                    return;
                }
            default:
                return;
        }
    }
}
