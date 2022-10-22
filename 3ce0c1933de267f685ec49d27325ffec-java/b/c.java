package b;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.ParcelUuid;
import b.b;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class c {

    /* renamed from: m  reason: collision with root package name */
    public static boolean f4931m = true;

    /* renamed from: n  reason: collision with root package name */
    public static boolean f4932n = true;

    /* renamed from: o  reason: collision with root package name */
    public static c f4933o;

    /* renamed from: p  reason: collision with root package name */
    public static final ParcelUuid f4934p = ParcelUuid.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* renamed from: q  reason: collision with root package name */
    public static final UUID f4935q = UUID.fromString("6A24EEAB-4B65-4693-986B-3C26C352264F");

    /* renamed from: b  reason: collision with root package name */
    public cl.a f4937b;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f4939d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f4940e;

    /* renamed from: f  reason: collision with root package name */
    public C0062c f4941f;

    /* renamed from: g  reason: collision with root package name */
    public b f4942g;

    /* renamed from: h  reason: collision with root package name */
    public d f4943h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f4944i;

    /* renamed from: k  reason: collision with root package name */
    public volatile b.b f4946k;

    /* renamed from: c  reason: collision with root package name */
    public Object f4938c = new Object();

    /* renamed from: j  reason: collision with root package name */
    public final Object f4945j = new Object();

    /* renamed from: l  reason: collision with root package name */
    public cl.b f4947l = new a();

    /* renamed from: a  reason: collision with root package name */
    public List<b.d> f4936a = new CopyOnWriteArrayList();

    /* loaded from: classes.dex */
    public class a extends cl.b {
        public a() {
        }

        @Override // cl.b
        public void a(BluetoothDevice bluetoothDevice, boolean z10, int i10) {
            super.a(bluetoothDevice, z10, i10);
            String address = bluetoothDevice != null ? bluetoothDevice.getAddress() : null;
            if (c.f4932n) {
                il.b.j(String.format(Locale.US, "%s status: %b 0x%04X", fl.a.c(address, true), Boolean.valueOf(z10), Integer.valueOf(i10)));
            }
            if (!z10 || i10 == 0) {
                c.this.l();
            }
            try {
                synchronized (c.this.f4936a) {
                    if (c.this.f4936a != null && c.this.f4936a.size() > 0) {
                        for (b.d dVar : c.this.f4936a) {
                            dVar.b(bluetoothDevice, z10, i10);
                        }
                    }
                }
            } catch (Exception e10) {
                il.b.l(e10.toString());
            }
        }

        @Override // cl.b
        public void b(byte[] bArr) {
            if (c.this.f4943h != null && bArr != null) {
                c.this.f4943h.a(bArr);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends zk.a<b.b> {
        public b() {
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this();
        }

        public final boolean f(b.b bVar) {
            byte[] b10;
            String str;
            if (bVar == null) {
                str = "command == null";
            } else if (bVar.d() == null) {
                str = "payload == null";
            } else {
                synchronized (c.this.f4938c) {
                    b10 = bVar.b(c.this.f4939d);
                    c.this.u();
                }
                return c.this.p().n(b10);
            }
            il.b.c(str);
            return false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("AckThread");
            if (c.f4932n) {
                il.b.j("AckThread is running...");
            }
            while (!Thread.currentThread().isInterrupted() && !d()) {
                b.b e10 = e();
                if (e10 != null) {
                    f(e10);
                }
            }
            if (c.f4932n) {
                il.b.j("TxThread stopped");
            }
        }
    }

    /* renamed from: b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0062c extends zk.a<b.b> {
        public C0062c() {
        }

        public /* synthetic */ C0062c(c cVar, a aVar) {
            this();
        }

        public final boolean f(b.b bVar) {
            byte[] b10;
            boolean n10;
            synchronized (c.this.f4938c) {
                b10 = bVar.b(c.this.f4939d);
                c.this.u();
            }
            if (bVar.f() == 1) {
                return c.this.p().n(b10);
            }
            boolean z10 = false;
            c.this.f4944i = false;
            int i10 = 0;
            do {
                n10 = c.this.p().n(b10);
                if (n10) {
                    synchronized (c.this.f4945j) {
                        if (!c.this.f4944i) {
                            try {
                                c.this.f4945j.wait(500L);
                            } catch (InterruptedException e10) {
                                e10.printStackTrace();
                            }
                            z10 = !c.this.f4944i;
                            n10 = c.this.f4944i;
                            if (!c.this.f4944i) {
                                il.b.k(c.f4932n, "ACK timeout for 500 ms");
                            }
                        }
                    }
                    i10++;
                    if (i10 >= bVar.e()) {
                        break;
                    }
                } else {
                    break;
                }
            } while (z10);
            return n10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("CommandThread");
            if (c.f4932n) {
                il.b.j("CommandThread is running...");
            }
            c.this.f4946k = null;
            while (!Thread.currentThread().isInterrupted() && !d()) {
                b.b e10 = e();
                if (e10 != null) {
                    if (e10.g()) {
                        c.this.f4946k = e10;
                    }
                    f(e10);
                }
            }
            c.this.f4946k = null;
            if (c.f4932n) {
                il.b.j("TxThread stopped");
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends zk.a<byte[]> {
        public d() {
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this();
        }

        public final void f(b.a aVar) {
            try {
                if (c.this.f4946k == null) {
                    c.this.w();
                } else if (c.this.f4946k.a() == aVar.e()) {
                    c.this.w();
                    c.this.f4946k = null;
                } else {
                    il.b.k(c.f4932n, String.format("ignore ACK, expect is 0x%04X", Short.valueOf(c.this.f4946k.a())));
                }
                synchronized (c.this.f4936a) {
                    if (c.this.f4936a != null && c.this.f4936a.size() > 0) {
                        for (b.d dVar : c.this.f4936a) {
                            dVar.a(aVar);
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                il.b.e(e10.toString());
            }
        }

        public final void g(e eVar) {
            try {
                c.this.j(eVar.a(), (byte) 0);
                if (c.this.f4946k != null && c.this.f4946k.c() == eVar.a()) {
                    c.this.w();
                    c.this.f4946k = null;
                }
                synchronized (c.this.f4936a) {
                    if (c.this.f4936a != null && c.this.f4936a.size() > 0) {
                        for (b.d dVar : c.this.f4936a) {
                            dVar.c(eVar);
                        }
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                il.b.e(e10.toString());
            }
        }

        public final void h(byte[] bArr) {
            int length = bArr.length;
            int i10 = 0;
            do {
                int i11 = length - i10;
                if (i11 > 0) {
                    try {
                        byte[] bArr2 = new byte[i11];
                        System.arraycopy(bArr, i10, bArr2, 0, i11);
                        e f10 = e.f(bArr2);
                        if (f10 == null) {
                            il.b.c("error packet : " + jl.a.a(bArr));
                            return;
                        }
                        i(f10);
                        i10 += f10.e();
                        continue;
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        il.b.e(e10.toString());
                        continue;
                    }
                } else {
                    return;
                }
            } while (i10 < length);
        }

        public final synchronized void i(e eVar) {
            short a10 = eVar.a();
            eVar.h();
            byte[] g10 = eVar.g();
            if (eVar.i() == c.this.f4940e) {
                if (c.f4931m) {
                    il.b.j(String.format(Locale.US, "dumplicate packet(0x%02X), [0x%02X 0x%04X >>]", Integer.valueOf(c.this.f4940e), Byte.valueOf(eVar.i()), Short.valueOf(a10)));
                }
                return;
            }
            c.this.f4940e = eVar.i();
            if (eVar.j()) {
                b.a k10 = eVar.k();
                if (k10 != null) {
                    if (c.f4931m) {
                        il.b.j(String.format(Locale.US, "[0x%02X ACK->0x%04X] 0x%02X", Byte.valueOf(eVar.i()), Short.valueOf(k10.e()), Byte.valueOf(k10.a())));
                    }
                    f(k10);
                } else {
                    il.b.c(String.format(Locale.US, "[0x%02X NA->0x%04X] %s", Byte.valueOf(eVar.i()), Short.valueOf(a10), jl.a.a(g10)));
                }
            } else {
                if (c.f4931m) {
                    il.b.j(String.format(Locale.US, "[0x%02X PACK->0x%04X] %s", Byte.valueOf(eVar.i()), Short.valueOf(a10), jl.a.a(g10)));
                }
                g(eVar);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (c.f4931m) {
                il.b.c("RxThread is running");
            }
            while (!Thread.currentThread().isInterrupted() && !d()) {
                byte[] e10 = e();
                if (e10 != null) {
                    h(e10);
                }
            }
            if (c.f4931m) {
                il.b.c("RxThread stopped");
            }
        }
    }

    public c() {
        f4931m = wk.b.f36299b;
        f4932n = wk.b.f36300c;
    }

    public static synchronized void F() {
        synchronized (c.class) {
            if (f4933o == null) {
                synchronized (c.class) {
                    if (f4933o == null) {
                        f4933o = new c();
                    }
                }
            }
        }
    }

    public static c H() {
        if (f4933o == null) {
            F();
        }
        return f4933o;
    }

    public final void C() {
        C0062c cVar = this.f4941f;
        if (cVar != null) {
            cVar.b(true);
        }
        if (f4932n) {
            il.b.j("startTxSchedule.");
        }
        C0062c cVar2 = new C0062c(this, null);
        this.f4941f = cVar2;
        cVar2.start();
    }

    public final void d() {
        if (this.f4943h != null) {
            if (f4932n) {
                il.b.j("clearRx");
            }
            this.f4943h.c();
            this.f4943h.b(true);
        }
        if (this.f4941f != null) {
            if (f4932n) {
                il.b.j("clearTx.");
            }
            this.f4941f.c();
            w();
        }
        if (this.f4942g != null) {
            if (f4932n) {
                il.b.j("clearAck.");
            }
            this.f4942g.c();
            w();
        }
    }

    public void e(b.d dVar) {
        synchronized (this.f4936a) {
            if (this.f4936a == null) {
                this.f4936a = new CopyOnWriteArrayList();
            }
            if (!this.f4936a.contains(dVar)) {
                this.f4936a.add(dVar);
            }
            if (f4931m) {
                il.b.j("callback's size=" + this.f4936a.size());
            }
        }
    }

    public boolean f(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket) {
        return g(bluetoothDevice, bluetoothSocket, f4935q);
    }

    public boolean g(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, UUID uuid) {
        String str;
        StringBuilder sb2;
        boolean z10;
        if (bluetoothDevice == null) {
            return false;
        }
        if (p().j(bluetoothDevice)) {
            cl.b bVar = this.f4947l;
            if (bVar != null) {
                bVar.a(bluetoothDevice, true, 512);
            }
            return true;
        }
        this.f4939d = 1;
        this.f4940e = 0;
        C();
        y();
        z();
        if (f4932n) {
            dl.b.a(bluetoothDevice);
        }
        ParcelUuid b10 = a.a.b(bluetoothDevice.getUuids(), uuid, true);
        if (b10 == null) {
            b10 = a.a.b(bluetoothDevice.getUuids(), f4935q, true);
            if (b10 != null) {
                z10 = f4931m;
                sb2 = new StringBuilder();
                str = "use vendor spp: ";
            } else {
                b10 = f4934p;
                z10 = f4931m;
                sb2 = new StringBuilder();
                str = "use well-known spp: ";
            }
        } else {
            z10 = f4931m;
            sb2 = new StringBuilder();
            str = "use pref spp: ";
        }
        sb2.append(str);
        sb2.append(b10.toString());
        il.b.k(z10, sb2.toString());
        b10.getUuid();
        return p().g(bluetoothDevice, bluetoothSocket, b10.getUuid());
    }

    public synchronized boolean h(b.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (this.f4942g == null) {
            C();
        }
        if (this.f4942g == null) {
            return false;
        }
        if (f4931m) {
            il.b.j(String.format(Locale.US, "<< writeType=%d, %s", Integer.valueOf(bVar.f()), jl.a.a(bVar.d())));
        }
        this.f4942g.a(bVar);
        return true;
    }

    public boolean j(short s10, byte b10) {
        return h(new b.C0061b().a(1).b(s10).d(b.a.c(s10, b10)).e());
    }

    public boolean k(short s10, byte[] bArr) {
        return o(new b.C0061b().a(2).c(s10, bArr).e());
    }

    public final void l() {
        d();
    }

    public void n(b.d dVar) {
        synchronized (this.f4936a) {
            List<b.d> list = this.f4936a;
            if (list != null) {
                list.remove(dVar);
            }
        }
    }

    public synchronized boolean o(b.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (this.f4941f == null) {
            C();
        }
        if (this.f4941f == null) {
            return false;
        }
        if (f4931m) {
            il.b.j(String.format(Locale.US, "<< writeType=%d, %s", Integer.valueOf(bVar.f()), jl.a.a(bVar.d())));
        }
        this.f4941f.a(bVar);
        return true;
    }

    public final cl.a p() {
        if (this.f4937b == null) {
            this.f4937b = new cl.a(this.f4947l);
        }
        return this.f4937b;
    }

    public void r() {
        d();
        if (this.f4937b != null) {
            if (f4932n) {
                il.b.j("disconnect");
            }
            this.f4937b.m();
        }
    }

    public final void u() {
        if (this.f4939d != 255) {
            this.f4939d++;
        } else {
            this.f4939d = 1;
        }
    }

    public final void w() {
        synchronized (this.f4945j) {
            this.f4944i = true;
            this.f4945j.notifyAll();
        }
    }

    public final void y() {
        b bVar = this.f4942g;
        if (bVar != null) {
            bVar.b(true);
        }
        if (f4932n) {
            il.b.j("startAckThread.");
        }
        b bVar2 = new b(this, null);
        this.f4942g = bVar2;
        bVar2.start();
    }

    public final void z() {
        d dVar = this.f4943h;
        if (dVar != null) {
            dVar.b(true);
        }
        d dVar2 = new d(this, null);
        this.f4943h = dVar2;
        dVar2.start();
    }
}
