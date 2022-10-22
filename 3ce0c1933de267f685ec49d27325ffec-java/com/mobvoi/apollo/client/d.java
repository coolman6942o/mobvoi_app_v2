package com.mobvoi.apollo.client;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.ParcelUuid;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.apollo.client.d;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import com.mobvoi.apollo.protocol.model.WatchInfo;
import com.mobvoi.apollo.protocol.model.WatchVersion;
import com.mobvoi.wear.util.LogCleaner;
import ja.g;
import ja.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import ka.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
/* compiled from: ApolloGattClient.kt */
/* loaded from: classes2.dex */
public final class d extends g implements i.c {

    /* renamed from: e  reason: collision with root package name */
    private b f15468e;

    /* renamed from: f  reason: collision with root package name */
    private final i f15469f;

    /* renamed from: g  reason: collision with root package name */
    private final r f15470g;

    /* renamed from: i  reason: collision with root package name */
    private BluetoothDevice f15472i;

    /* renamed from: j  reason: collision with root package name */
    private final io.d f15473j;

    /* renamed from: k  reason: collision with root package name */
    private final fa.i f15474k;

    /* renamed from: h  reason: collision with root package name */
    private final da.b f15471h = new da.b();

    /* renamed from: l  reason: collision with root package name */
    private final ka.b f15475l = new ka.b(new C0189d());

    /* renamed from: m  reason: collision with root package name */
    private final Runnable f15476m = new Runnable() { // from class: com.mobvoi.apollo.client.a
        @Override // java.lang.Runnable
        public final void run() {
            d.r(d.this);
        }
    };

    /* compiled from: ApolloGattClient.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ApolloGattClient.kt */
    /* loaded from: classes2.dex */
    public interface b {

        /* compiled from: ApolloGattClient.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            public static void a(b bVar, BluetoothDevice device, da.a payload) {
                kotlin.jvm.internal.i.f(bVar, "this");
                kotlin.jvm.internal.i.f(device, "device");
                kotlin.jvm.internal.i.f(payload, "payload");
            }

            public static void b(b bVar, ka.a packet) {
                kotlin.jvm.internal.i.f(bVar, "this");
                kotlin.jvm.internal.i.f(packet, "packet");
            }

            public static void c(b bVar, boolean z10) {
                kotlin.jvm.internal.i.f(bVar, "this");
            }

            public static void d(b bVar) {
                kotlin.jvm.internal.i.f(bVar, "this");
            }

            public static void e(b bVar, int i10, int i11) {
                kotlin.jvm.internal.i.f(bVar, "this");
            }

            public static void f(b bVar) {
                kotlin.jvm.internal.i.f(bVar, "this");
            }

            public static void g(b bVar, BluetoothDevice device, ClientState newState) {
                kotlin.jvm.internal.i.f(bVar, "this");
                kotlin.jvm.internal.i.f(device, "device");
                kotlin.jvm.internal.i.f(newState, "newState");
            }
        }

        void a(BluetoothDevice bluetoothDevice, ClientState clientState);

        void b(ka.a aVar);

        void c();

        void d(int i10, int i11);

        void i(boolean z10);

        void k(BluetoothDevice bluetoothDevice, da.a aVar);

        void m();
    }

    /* compiled from: ApolloGattClient.kt */
    /* loaded from: classes2.dex */
    public static final class c implements g.a {
        c() {
        }

        @Override // ja.g.a
        public void a(BluetoothDevice device, ClientState newState) {
            b bVar;
            kotlin.jvm.internal.i.f(device, "device");
            kotlin.jvm.internal.i.f(newState, "newState");
            k.a("ApolloGattClient", "onStateChanged " + ((Object) device.getName()) + ", newState=" + newState);
            ClientState clientState = ClientState.CONNECTED;
            if (newState == clientState) {
                d.this.f15470g.p(device.getAddress());
            } else if (newState == ClientState.DISCONNECTED) {
                d.this.f15475l.d();
            }
            if (newState != clientState && (bVar = d.this.f15468e) != null) {
                bVar.a(device, newState);
            }
        }
    }

    /* compiled from: ApolloGattClient.kt */
    /* renamed from: com.mobvoi.apollo.client.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0189d implements b.AbstractC0367b {
        C0189d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final byte[] j(String requestStr) {
            kotlin.jvm.internal.i.f(requestStr, "$requestStr");
            return fa.a.f26369a.b(requestStr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(byte[] bArr) {
            q.L(q.f15504a, 16, bArr, null, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String l(d this$0, String requestStr) {
            String str;
            kotlin.jvm.internal.i.f(this$0, "this$0");
            kotlin.jvm.internal.i.f(requestStr, "$requestStr");
            try {
                la.b request = (la.b) this$0.w().j(requestStr, la.b.class);
                fa.c cVar = fa.c.f26373a;
                kotlin.jvm.internal.i.e(request, "request");
                str = cVar.e(request);
            } catch (Exception e10) {
                str = "{\"code\": 10001, \"msg\": \"" + ((Object) e10.getMessage()) + "\"}";
            }
            k.a("ApolloGattClient", kotlin.jvm.internal.i.n("http response: ", str));
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(String response) {
            q qVar = q.f15504a;
            kotlin.jvm.internal.i.e(response, "response");
            byte[] bytes = response.getBytes(kotlin.text.d.f30092a);
            kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            q.L(qVar, 4, bytes, null, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(Throwable th2) {
            k.d("ApolloGattClient", th2.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String o(d this$0, String requestStr) {
            String str;
            kotlin.jvm.internal.i.f(this$0, "this$0");
            kotlin.jvm.internal.i.f(requestStr, "$requestStr");
            try {
                la.b request = (la.b) this$0.w().j(requestStr, la.b.class);
                fa.c cVar = fa.c.f26373a;
                kotlin.jvm.internal.i.e(request, "request");
                str = cVar.d(request);
            } catch (Exception e10) {
                str = fa.c.f26373a.c(10001, e10.getMessage(), GrsBaseInfo.CountryCodeSource.UNKNOWN);
            }
            k.a("ApolloGattClient", kotlin.jvm.internal.i.n("http response: ", str));
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(String response) {
            q qVar = q.f15504a;
            kotlin.jvm.internal.i.e(response, "response");
            byte[] bytes = response.getBytes(kotlin.text.d.f30092a);
            kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            q.L(qVar, 8, bytes, null, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(Throwable th2) {
            k.d("ApolloGattClient", th2.getMessage());
        }

        @Override // ka.b.AbstractC0367b
        public void b(ka.a packet) {
            byte[] c10;
            kotlin.jvm.internal.i.f(packet, "packet");
            k.a("ApolloGattClient", kotlin.jvm.internal.i.n("onPacketFound ", packet));
            d.this.f15474k.l(packet);
            int a10 = packet.a();
            if (a10 == 3) {
                byte[] c11 = packet.c();
                if (c11 != null) {
                    final d dVar = d.this;
                    final String str = new String(c11, kotlin.text.d.f30092a);
                    k.a("ApolloGattClient", kotlin.jvm.internal.i.n("Apollo watch: COMMAND_ESIM_HTTP_REQUEST raw req: ", str));
                    rx.c.x(new Callable() { // from class: com.mobvoi.apollo.client.e
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            String l10;
                            l10 = d.C0189d.l(d.this, str);
                            return l10;
                        }
                    }).Z(cq.a.c()).Y(h.f15495a, j.f15497a);
                }
            } else if (a10 == 7) {
                byte[] c12 = packet.c();
                if (c12 != null) {
                    final d dVar2 = d.this;
                    final String str2 = new String(c12, kotlin.text.d.f30092a);
                    k.a("ApolloGattClient", kotlin.jvm.internal.i.n("Apollo watch: COMMAND_HTTP_REQUEST raw req: ", str2));
                    rx.c.x(new Callable() { // from class: com.mobvoi.apollo.client.f
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            String o10;
                            o10 = d.C0189d.o(d.this, str2);
                            return o10;
                        }
                    }).Z(cq.a.c()).Y(i.f15496a, k.f15498a);
                }
            } else if (a10 == 9) {
                byte[] c13 = packet.c();
                if (c13 != null) {
                    final String str3 = new String(c13, kotlin.text.d.f30092a);
                    rx.c.x(new Callable() { // from class: com.mobvoi.apollo.client.g
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            byte[] j10;
                            j10 = d.C0189d.j(str3);
                            return j10;
                        }
                    }).Z(cq.a.c()).X(l.f15499a);
                }
            } else if (a10 == 352) {
                byte[] c14 = packet.c();
                if (c14 != null) {
                    d dVar3 = d.this;
                    WatchInfo watchInfo = (WatchInfo) dVar3.w().j(new String(c14, kotlin.text.d.f30092a), WatchInfo.class);
                    if (watchInfo != null) {
                        dVar3.f15470g.q(watchInfo.getVersion());
                        dVar3.f15470g.o(watchInfo.getFotaVersion());
                        k.a("ApolloGattClient", oa.d.f31487a.a(packet.a()) + ": " + watchInfo);
                    }
                }
            } else if (a10 == 368 && (c10 = packet.c()) != null) {
                d dVar4 = d.this;
                WatchVersion watchVersion = (WatchVersion) dVar4.w().j(new String(c10, kotlin.text.d.f30092a), WatchVersion.class);
                k.a("ApolloGattClient", kotlin.jvm.internal.i.n("version: ", watchVersion));
                dVar4.f15470g.q(watchVersion.getVersion());
                dVar4.f15470g.o(watchVersion.getFotaVersion());
            }
            b bVar = d.this.f15468e;
            if (bVar != null) {
                bVar.b(packet);
            }
        }
    }

    /* compiled from: ApolloGattClient.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements qo.a<com.google.gson.e> {
        public static final e INSTANCE = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final com.google.gson.e invoke() {
            return new com.google.gson.e();
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, b bVar) {
        super("ApolloGattClient", context);
        io.d a10;
        kotlin.jvm.internal.i.f(context, "context");
        this.f15468e = bVar;
        this.f15469f = new i(context);
        r rVar = new r(context);
        this.f15470g = rVar;
        a10 = io.f.a(e.INSTANCE);
        this.f15473j = a10;
        this.f15474k = new fa.i(this, rVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(d this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.x();
    }

    @SuppressLint({"MissingPermission"})
    private final void s(BluetoothDevice bluetoothDevice) {
        k.a("ApolloGattClient", "connectDevice: " + ((Object) bluetoothDevice.getAddress()) + " (" + ((Object) bluetoothDevice.getName()) + ')');
        this.f15472i = bluetoothDevice;
        g(bluetoothDevice, new c());
    }

    private final void u() {
        B();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.gson.e w() {
        return (com.google.gson.e) this.f15473j.getValue();
    }

    private final void x() {
        k.a("ApolloGattClient", "onBleScanTimeout");
        B();
        b bVar = this.f15468e;
        if (bVar != null) {
            bVar.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(d this$0, Boolean it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(it, "it");
        if (it.booleanValue()) {
            b bVar = this$0.f15468e;
            if (bVar != null) {
                BluetoothDevice v10 = this$0.v();
                kotlin.jvm.internal.i.d(v10);
                bVar.a(v10, ClientState.CONNECTED);
            }
            b bVar2 = this$0.f15468e;
            if (bVar2 != null) {
                bVar2.c();
                return;
            }
            return;
        }
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Throwable th2) {
    }

    public final void A() {
        if (this.f15469f.f()) {
            k.a("ApolloGattClient", "already in scanning");
            return;
        }
        k.a("ApolloGattClient", "startBleScan");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanFilter.Builder().setServiceData(new ParcelUuid(la.a.f30445a.a()), new byte[]{-120, 1}, new byte[]{-1, -1}).build());
        this.f15469f.j(arrayList);
        ScanSettings settings = new ScanSettings.Builder().setScanMode(2).build();
        i iVar = this.f15469f;
        kotlin.jvm.internal.i.e(settings, "settings");
        iVar.k(settings);
        this.f15469f.l(this);
        b bVar = this.f15468e;
        if (bVar != null) {
            bVar.i(true);
        }
        l.a().postDelayed(this.f15476m, LogCleaner.ONE_MINUTE);
    }

    public final void B() {
        if (this.f15469f.f()) {
            k.a("ApolloGattClient", "stopBleScan");
            this.f15469f.m();
            b bVar = this.f15468e;
            if (bVar != null) {
                bVar.i(false);
            }
            l.a().removeCallbacks(this.f15476m);
        }
    }

    @Override // ja.i.c
    public void b(ScanResult result) {
        kotlin.jvm.internal.i.f(result, "result");
        da.a b10 = this.f15471h.b(result);
        if (b10 != null) {
            k.a("ApolloGattClient", "payload: " + ((int) b10.b()) + ", " + b10.a());
            b bVar = this.f15468e;
            if (bVar != null) {
                BluetoothDevice device = result.getDevice();
                kotlin.jvm.internal.i.e(device, "result.device");
                bVar.k(device, b10);
            }
        }
    }

    @Override // com.mobvoi.apollo.protocol.ble.client.a.b
    public void c() {
        this.f15474k.f().Y(new yp.b() { // from class: com.mobvoi.apollo.client.b
            @Override // yp.b
            public final void call(Object obj) {
                d.y(d.this, (Boolean) obj);
            }
        }, com.mobvoi.apollo.client.c.f15465a);
    }

    @Override // com.mobvoi.apollo.protocol.ble.client.a.b
    public void d(int i10, int i11) {
        b bVar = this.f15468e;
        if (bVar != null) {
            bVar.d(i10, i11);
        }
    }

    @Override // com.mobvoi.apollo.protocol.ble.client.a.b
    public void e(com.mobvoi.apollo.protocol.ble.a characteristic, byte[] value) {
        kotlin.jvm.internal.i.f(characteristic, "characteristic");
        kotlin.jvm.internal.i.f(value, "value");
        ka.b bVar = this.f15475l;
        byte[] copyOf = Arrays.copyOf(value, value.length);
        kotlin.jvm.internal.i.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        bVar.c(copyOf);
    }

    public final void t(BluetoothDevice bluetoothDevice) {
        u();
        if (bluetoothDevice == null) {
            String f10 = this.f15470g.f();
            if (!(f10 == null || f10.length() == 0)) {
                BluetoothAdapter d10 = oa.a.f31484a.d(h());
                BluetoothDevice remoteDevice = d10 == null ? null : d10.getRemoteDevice(f10);
                if (remoteDevice != null) {
                    s(remoteDevice);
                    return;
                }
                return;
            }
            return;
        }
        s(bluetoothDevice);
    }

    public final BluetoothDevice v() {
        return this.f15472i;
    }
}
