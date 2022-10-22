package ei;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.apollo.client.ApolloClientService;
import com.mobvoi.apollo.client.d;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.client.r;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import com.mobvoi.mcuwatch.notify.NotificationService;
import com.mobvoi.mcuwatch.settings.persistence.DeviceDataSourceImpl;
import com.mobvoi.mcuwatch.ui.card.e0;
import java.util.ArrayList;
import java.util.List;
import pk.f;
import yp.g;
/* compiled from: ApolloServiceClient.java */
/* loaded from: classes2.dex */
public class e implements d.b, g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: k  reason: collision with root package name */
    private static final e f26080k = new e();

    /* renamed from: a  reason: collision with root package name */
    private final Context f26081a;

    /* renamed from: b  reason: collision with root package name */
    private List<BluetoothDevice> f26082b;

    /* renamed from: c  reason: collision with root package name */
    private fi.a f26083c;

    /* renamed from: d  reason: collision with root package name */
    private com.mobvoi.mcuwatch.notify.a f26084d;

    /* renamed from: e  reason: collision with root package name */
    private final e0 f26085e = e0.g();

    /* renamed from: f  reason: collision with root package name */
    private long f26086f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f26087g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f26088h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26089i = false;

    /* renamed from: j  reason: collision with root package name */
    private final BroadcastReceiver f26090j;

    /* compiled from: ApolloServiceClient.java */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a(e eVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("action.LOGIN".equals(action)) {
                com.mobvoi.apollo.mqtt.b.e(ta.a.d());
            } else if ("action.LOGOUT".equals(action)) {
                q.v();
            }
        }
    }

    /* compiled from: ApolloServiceClient.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26091a;

        static {
            int[] iArr = new int[ClientState.values().length];
            f26091a = iArr;
            try {
                iArr[ClientState.CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26091a[ClientState.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26091a[ClientState.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private e() {
        a aVar = new a(this);
        this.f26090j = aVar;
        Application e10 = com.mobvoi.android.common.utils.b.e();
        this.f26081a = e10;
        DeviceDataSourceImpl.getInstance().deviceDel().u(new g() { // from class: ei.d
            @Override // yp.g
            public final Object call(Object obj) {
                Boolean z10;
                z10 = e.this.z((String) obj);
                return z10;
            }
        }).X(new yp.b() { // from class: ei.c
            @Override // yp.b
            public final void call(Object obj) {
                e.this.A((String) obj);
            }
        });
        IntentFilter intentFilter = new IntentFilter("action.LOGOUT");
        intentFilter.addAction("action.LOGIN");
        b1.a.b(e10).c(aVar, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str) {
        B();
    }

    private void B() {
        com.mobvoi.mcuwatch.engine.b.f19144a.n();
        ApolloClientService.f15458a.a(this.f26081a);
        l.a().postDelayed(ei.b.f26077a, 1000L);
    }

    private void C() {
        if (System.currentTimeMillis() - this.f26087g > 5000) {
            this.f26087g = System.currentTimeMillis();
            q.f15504a.E();
            if (System.currentTimeMillis() - this.f26086f > 7200000) {
                this.f26085e.m();
            }
        }
    }

    public static e x() {
        return f26080k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean z(String str) {
        fi.a aVar = this.f26083c;
        return Boolean.valueOf(aVar != null && aVar.b().equals(str));
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void a(BluetoothDevice bluetoothDevice, ClientState clientState) {
        k.h("ApolloServiceClient", " onStateChanged clientState = " + clientState);
        k.h("ApolloServiceClient", " onStateChanged device.getAddress() = " + bluetoothDevice.getAddress());
        int i10 = b.f26091a[clientState.ordinal()];
        if (i10 == 1) {
            this.f26083c = new fi.a(2, bluetoothDevice.getAddress());
        } else if (i10 == 2) {
            List<BluetoothDevice> list = this.f26082b;
            if (list != null) {
                list.clear();
            }
            this.f26083c = new fi.a(1, bluetoothDevice.getAddress());
            nj.g.n(true);
        } else if (i10 == 3) {
            this.f26083c = new fi.a(0, bluetoothDevice.getAddress());
            this.f26086f = 0L;
            b1.a.b(this.f26081a).d(new Intent("com.mobvoi.ACTION_MCU_DEVICE_DISCONNECT"));
        }
        if (this.f26083c != null) {
            ci.a.b().g(this.f26083c);
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void b(ka.a aVar) {
        if (aVar.a() == 377) {
            this.f26085e.m();
        } else if (aVar.a() == 384) {
            if (aVar.c() != null && aVar.c().length > 0 && aVar.c()[0] == 0) {
                this.f26086f = System.currentTimeMillis();
            }
        } else if (aVar.a() == 5) {
            this.f26088h = false;
            h.a().f(this.f26081a);
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void c() {
        C();
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void d(int i10, int i11) {
    }

    @Override // ei.g
    public void e(Context context) {
        q.f15504a.S();
    }

    @Override // ei.g
    public void f(Context context) {
        if (this.f26088h) {
            q.f15504a.H();
        }
        this.f26088h = true;
    }

    @Override // ei.g
    public void g(Context context, String str) {
        new r(context).w(true);
        k.h("ApolloServiceClient", " startConnect macAddress = " + str);
        ApolloClientService.f15458a.c(context);
        List<BluetoothDevice> list = this.f26082b;
        if (list != null) {
            for (BluetoothDevice bluetoothDevice : list) {
                if (TextUtils.equals(bluetoothDevice.getAddress(), str)) {
                    q.f15504a.s(bluetoothDevice);
                    return;
                }
            }
        }
        k.i("ApolloServiceClient", "no scan before connect to %s", str);
        BluetoothAdapter d10 = oa.a.f31484a.d(context);
        if (d10 != null) {
            q.f15504a.s(d10.getRemoteDevice(str));
        }
    }

    @Override // ei.g
    public void h() {
        q.f15504a.H();
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void i(boolean z10) {
    }

    @Override // ei.g
    public void j(Context context) {
        q.f15504a.S();
        l.a().postDelayed(ei.a.f26076a, 600L);
    }

    @Override // com.mobvoi.apollo.client.d.b
    @SuppressLint({"MissingPermission"})
    public void k(BluetoothDevice bluetoothDevice, da.a aVar) {
        if (bluetoothDevice != null) {
            k.h("ApolloServiceClient", " onDeviceFound device.getAddress() = " + bluetoothDevice.getAddress());
            List<BluetoothDevice> list = this.f26082b;
            if (list != null && !list.contains(bluetoothDevice)) {
                this.f26082b.add(bluetoothDevice);
                ci.a.b().g(new f(nj.g.j(bluetoothDevice.getName()), bluetoothDevice.getAddress(), 0));
            }
        }
    }

    @Override // ei.g
    public void l(Context context, String str) {
        new r(context).w(false);
        BluetoothAdapter d10 = oa.a.f31484a.d(context);
        if (d10 != null) {
            q.f15504a.s(d10.getRemoteDevice(str));
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void m() {
    }

    @Override // ei.g
    public boolean n() {
        return oa.a.f31484a.a(com.mobvoi.android.common.utils.b.e());
    }

    @Override // ei.g
    public void o(Context context) {
        if (this.f26082b == null) {
            this.f26082b = new ArrayList();
        }
        this.f26082b.clear();
        q.f15504a.R();
    }

    @Override // ei.g
    public void p(Context context) {
        if (!this.f26089i) {
            this.f26089i = true;
            com.mobvoi.mcuwatch.engine.b.f19144a.l(context);
            w();
            String d10 = ta.a.d();
            if (!TextUtils.isEmpty(d10)) {
                com.mobvoi.apollo.mqtt.b.e(d10);
            }
        }
    }

    @Override // ei.g
    public fi.a q(String str) {
        fi.a aVar = this.f26083c;
        if (aVar == null || !TextUtils.equals(str, aVar.b())) {
            return fi.a.f27043c.c(str);
        }
        return this.f26083c;
    }

    @Override // ei.g
    public void r() {
    }

    @Override // ei.g
    public void s() {
    }

    @Override // ei.g
    public boolean t() {
        if (!ci.a.b().e()) {
            return false;
        }
        C();
        return true;
    }

    public void w() {
        q.f15504a.j(this);
    }

    public rk.a y() {
        if (this.f26084d == null) {
            com.mobvoi.mcuwatch.notify.a aVar = new com.mobvoi.mcuwatch.notify.a();
            this.f26084d = aVar;
            aVar.b(NotificationService.d());
        }
        return this.f26084d;
    }
}
