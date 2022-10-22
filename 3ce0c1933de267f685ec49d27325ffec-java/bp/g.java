package bp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.k;
import bp.j;
import com.realsil.sdk.dfu.DfuException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Locale;
/* compiled from: DfuBaseService.java */
/* loaded from: classes3.dex */
public abstract class g extends IntentService implements j.a {

    /* renamed from: t  reason: collision with root package name */
    static boolean f5429t = false;

    /* renamed from: b  reason: collision with root package name */
    private BluetoothAdapter f5431b;

    /* renamed from: c  reason: collision with root package name */
    private String f5432c;

    /* renamed from: d  reason: collision with root package name */
    private String f5433d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5434e;

    /* renamed from: f  reason: collision with root package name */
    protected int f5435f;

    /* renamed from: g  reason: collision with root package name */
    private int f5436g;

    /* renamed from: i  reason: collision with root package name */
    j f5438i;

    /* renamed from: j  reason: collision with root package name */
    private long f5439j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5440k;

    /* renamed from: l  reason: collision with root package name */
    private h f5441l;

    /* renamed from: m  reason: collision with root package name */
    private InputStream f5442m;

    /* renamed from: n  reason: collision with root package name */
    private InputStream f5443n;

    /* renamed from: a  reason: collision with root package name */
    private final Object f5430a = new Object();

    /* renamed from: h  reason: collision with root package name */
    private int f5437h = -1;

    /* renamed from: o  reason: collision with root package name */
    private final BroadcastReceiver f5444o = new a();

    /* renamed from: p  reason: collision with root package name */
    private final BroadcastReceiver f5445p = new b();

    /* renamed from: q  reason: collision with root package name */
    private final BroadcastReceiver f5446q = new c();

    /* renamed from: r  reason: collision with root package name */
    private final BroadcastReceiver f5447r = new d();

    /* renamed from: s  reason: collision with root package name */
    private final BluetoothGattCallback f5448s = new e();

    /* compiled from: DfuBaseService.java */
    /* loaded from: classes3.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 0);
            g gVar = g.this;
            gVar.r("User action received: " + intExtra);
            if (intExtra == 0) {
                g.this.A(15, "[Broadcast] Pause action received");
                if (g.this.f5441l != null) {
                    g.this.f5441l.b();
                }
            } else if (intExtra == 1) {
                g.this.A(15, "[Broadcast] Resume action received");
                if (g.this.f5441l != null) {
                    g.this.f5441l.d();
                }
            } else if (intExtra == 2) {
                g.this.A(15, "[Broadcast] Abort action received");
                g.this.f5440k = true;
                if (g.this.f5441l != null) {
                    g.this.f5441l.a();
                }
            }
        }
    }

    /* compiled from: DfuBaseService.java */
    /* loaded from: classes3.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 12);
            g gVar = g.this;
            gVar.s("Action received: android.bluetooth.adapter.action.STATE_CHANGED [state: " + intExtra + ", previous state: " + intExtra2 + "]");
            if (intExtra2 != 12) {
                return;
            }
            if (intExtra == 13 || intExtra == 10) {
                g.this.A(15, "Bluetooth adapter disabled");
                g gVar2 = g.this;
                gVar2.f5435f = 0;
                if (gVar2.f5441l != null) {
                    g.this.f5441l.e().a();
                }
            }
        }
    }

    /* compiled from: DfuBaseService.java */
    /* loaded from: classes3.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra;
            if (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(g.this.f5432c) && (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) != 11 && g.this.f5441l != null) {
                g.this.f5441l.c(intExtra);
            }
        }
    }

    /* compiled from: DfuBaseService.java */
    /* loaded from: classes3.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(g.this.f5432c)) {
                String action = intent.getAction();
                g gVar = g.this;
                gVar.r("Action received: " + action);
                g gVar2 = g.this;
                gVar2.A(0, "[Broadcast] Action received: " + action);
            }
        }
    }

    /* compiled from: DfuBaseService.java */
    /* loaded from: classes3.dex */
    class e extends BluetoothGattCallback {
        e() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (g.this.f5441l != null) {
                g.this.f5441l.e().onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            if (g.this.f5441l != null) {
                g.this.f5441l.e().onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            if (g.this.f5441l != null) {
                g.this.f5441l.e().onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (i10 != 0) {
                if (i10 == 8 || i10 == 19) {
                    g gVar = g.this;
                    gVar.s("Target device disconnected with status: " + i10);
                } else {
                    g gVar2 = g.this;
                    gVar2.p("Connection state change error: " + i10 + " newState: " + i11);
                }
                g.this.f5436g = i10 | 32768;
                if (i11 == 0) {
                    g gVar3 = g.this;
                    gVar3.f5435f = 0;
                    if (gVar3.f5441l != null) {
                        g.this.f5441l.e().a();
                    }
                }
            } else if (i11 == 2) {
                g.this.r("Connected to GATT server");
                g gVar4 = g.this;
                gVar4.A(5, "Connected to " + g.this.f5432c);
                g.this.f5435f = -2;
                if (bluetoothGatt.getDevice().getBondState() == 12) {
                    g.this.r("Waiting 1600 ms for a possible Service Changed indication...");
                    g.this.H(1600);
                }
                g.this.A(1, "Discovering services...");
                g.this.A(0, "gatt.discoverServices()");
                boolean discoverServices = bluetoothGatt.discoverServices();
                g gVar5 = g.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempting to start service discovery... ");
                sb2.append(discoverServices ? "succeed" : "failed");
                gVar5.r(sb2.toString());
                if (!discoverServices) {
                    g.this.f5436g = 4101;
                } else {
                    return;
                }
            } else if (i11 == 0) {
                g.this.r("Disconnected from GATT server");
                g gVar6 = g.this;
                gVar6.f5435f = 0;
                if (gVar6.f5441l != null) {
                    g.this.f5441l.e().a();
                }
            }
            synchronized (g.this.f5430a) {
                g.this.f5430a.notifyAll();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            if (g.this.f5441l != null) {
                g.this.f5441l.e().onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            if (g.this.f5441l != null) {
                g.this.f5441l.e().onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @SuppressLint({"NewApi"})
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (g.this.f5441l != null) {
                g.this.f5441l.e().onMtuChanged(bluetoothGatt, i10, i11);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        @SuppressLint({"NewApi"})
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i10, int i11, int i12) {
            if (g.this.f5441l != null) {
                g.this.f5441l.e().onPhyUpdate(bluetoothGatt, i10, i11, i12);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            if (i10 == 0) {
                g.this.r("Services discovered");
                g.this.f5435f = -3;
            } else {
                g gVar = g.this;
                gVar.p("Service discovery error: " + i10);
                g.this.f5436g = i10 | 16384;
            }
            synchronized (g.this.f5430a) {
                g.this.f5430a.notifyAll();
            }
        }
    }

    public g() {
        super("DfuBaseService");
    }

    private void B(j jVar) {
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", jVar.f());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f5432c);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", jVar.e());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", jVar.h());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS", jVar.g());
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS", jVar.c());
        b1.a.b(this).d(intent);
    }

    private void C() {
        k.d q5 = new k.d(this, "dfu").u(17301640).k(getString(u.m_res_0x7f1403b1)).j(getString(u.l_res_0x7f1403b0)).h(-7829368).s(-1).q(true);
        Class<? extends Activity> m10 = m();
        if (m10 != null) {
            Intent intent = new Intent(this, m10);
            intent.addFlags(268435456);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f5432c);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", this.f5433d);
            q5.i(PendingIntent.getActivity(this, 0, intent, 134217728));
        } else {
            s("getNotificationTarget() should not return null if the service is to be started as a foreground service");
        }
        F(q5);
        startForeground(DfuException.ERROR_DFU_ROLE_SWAP_FAILED, q5.b());
    }

    private boolean n() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
        if (bluetoothManager == null) {
            p("Unable to initialize BluetoothManager.");
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.f5431b = adapter;
        if (adapter != null) {
            return true;
        }
        p("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        Log.e("DfuBaseService", str);
    }

    private void q(String str, Throwable th2) {
        Log.e("DfuBaseService", str, th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        if (f5429t) {
            Log.i("DfuBaseService", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        if (f5429t) {
            Log.w("DfuBaseService", str);
        }
    }

    private static IntentFilter t() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
        return intentFilter;
    }

    private InputStream u(int i10, String str, int i11, int i12) throws IOException {
        InputStream openRawResource = getResources().openRawResource(i10);
        if ("application/zip".equals(str)) {
            return new cp.a(openRawResource, i11, i12);
        }
        openRawResource.mark(2);
        int read = openRawResource.read();
        openRawResource.reset();
        return read == 58 ? new cp.b(openRawResource, i11) : openRawResource;
    }

    private InputStream v(Uri uri, String str, int i10, int i11) throws IOException {
        InputStream openInputStream = getContentResolver().openInputStream(uri);
        if ("application/zip".equals(str)) {
            return new cp.a(openInputStream, i10, i11);
        }
        Cursor query = getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        try {
            return (!query.moveToNext() || !query.getString(0).toLowerCase(Locale.US).endsWith("hex")) ? openInputStream : new cp.b(openInputStream, i10);
        } finally {
            query.close();
        }
    }

    private InputStream w(String str, String str2, int i10, int i11) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        if ("application/zip".equals(str2)) {
            return new cp.a(fileInputStream, i10, i11);
        }
        return str.toLowerCase(Locale.US).endsWith("hex") ? new cp.b(fileInputStream, i10) : fileInputStream;
    }

    private void y(int i10) {
        z(i10);
        if (!this.f5434e) {
            String str = this.f5432c;
            String str2 = this.f5433d;
            if (str2 == null) {
                str2 = getString(u.w_res_0x7f1403bc);
            }
            k.d e10 = new k.d(this, "dfu").u(17301640).r(true).h(-65536).q(false).k(getString(u.j_res_0x7f1403ae)).u(17301641).j(getString(u.k_res_0x7f1403af)).e(true);
            Intent intent = new Intent(this, m());
            intent.addFlags(268435456);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", str2);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS", i10);
            e10.i(PendingIntent.getActivity(this, 0, intent, 134217728));
            E(e10);
            ((NotificationManager) getSystemService("notification")).notify(DfuException.ERROR_DFU_ROLE_SWAP_FAILED, e10.b());
        }
    }

    private void z(int i10) {
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
        if ((i10 & 16384) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i10 & (-16385));
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 2);
        } else if ((32768 & i10) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i10 & (-32769));
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 1);
        } else if ((i10 & 8192) > 0) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i10 & (-8193));
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 3);
        } else {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", i10);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE", 0);
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f5432c);
        b1.a.b(this).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i10, String str) {
        Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG");
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO", "[DFU] " + str);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL", i10);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f5432c);
        b1.a.b(this).d(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(BluetoothGatt bluetoothGatt, int i10) {
        if (this.f5435f != 0) {
            l(bluetoothGatt);
        }
        x(bluetoothGatt, false);
        j(bluetoothGatt);
        H(600);
        if (i10 != 0) {
            y(i10);
        }
    }

    protected void E(k.d dVar) {
    }

    protected void F(k.d dVar) {
    }

    protected void G(k.d dVar, int i10) {
        if (i10 != -7 && i10 != -6) {
            Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 2);
            dVar.a(t.f5503a, getString(u.a_res_0x7f1403a2), PendingIntent.getBroadcast(this, 1, intent, 134217728));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(int i10) {
        synchronized (this.f5430a) {
            try {
                A(0, "wait(" + i10 + ")");
                this.f5430a.wait((long) i10);
            } catch (InterruptedException e10) {
                q("Sleeping interrupted", e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I() {
        try {
            synchronized (this.f5430a) {
                while (this.f5435f != 0 && this.f5436g == 0) {
                    this.f5430a.wait();
                }
            }
        } catch (InterruptedException e10) {
            q("Sleeping interrupted", e10);
        }
    }

    @Override // bp.j.a
    public void a() {
        j jVar = this.f5438i;
        int f10 = jVar.f();
        if (this.f5437h != f10) {
            this.f5437h = f10;
            B(jVar);
            if (!this.f5434e) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.f5439j >= 250 || -6 == f10 || -7 == f10) {
                    this.f5439j = elapsedRealtime;
                    String str = this.f5432c;
                    String str2 = this.f5433d;
                    if (str2 == null) {
                        str2 = getString(u.w_res_0x7f1403bc);
                    }
                    k.d r10 = new k.d(this, "dfu").u(17301640).r(true);
                    r10.h(-7829368);
                    switch (f10) {
                        case -7:
                            r10.q(false).k(getString(u.b_res_0x7f1403a5)).u(17301641).j(getString(u.c_res_0x7f1403a6)).e(true);
                            break;
                        case -6:
                            r10.q(false).k(getString(u.d_res_0x7f1403a8)).u(17301641).j(getString(u.e_res_0x7f1403a9)).e(true).h(-16730086);
                            break;
                        case -5:
                            r10.q(true).k(getString(u.h_res_0x7f1403ac)).j(getString(u.i_res_0x7f1403ad, new Object[]{str2})).t(100, 0, true);
                            break;
                        case -4:
                            r10.q(true).k(getString(u.u_res_0x7f1403ba)).j(getString(u.v_res_0x7f1403bb)).t(100, 0, true);
                            break;
                        case -3:
                            r10.q(true).k(getString(u.p_res_0x7f1403b5)).j(getString(u.q_res_0x7f1403b6)).t(100, 0, true);
                            break;
                        case -2:
                            r10.q(true).k(getString(u.n_res_0x7f1403b3)).j(getString(u.o_res_0x7f1403b4)).t(100, 0, true);
                            break;
                        case -1:
                            r10.q(true).k(getString(u.f_res_0x7f1403aa)).j(getString(u.g_res_0x7f1403ab, new Object[]{str2})).t(100, 0, true);
                            break;
                        default:
                            r10.q(true).k(jVar.h() == 1 ? getString(u.r_res_0x7f1403b7) : getString(u.t_res_0x7f1403b9, new Object[]{Integer.valueOf(jVar.e()), Integer.valueOf(jVar.h())})).j(getString(u.s_res_0x7f1403b8, new Object[]{str2})).t(100, f10, false);
                            break;
                    }
                    Intent intent = new Intent(this, m());
                    intent.addFlags(268435456);
                    intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
                    intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", str2);
                    intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS", f10);
                    r10.i(PendingIntent.getActivity(this, 0, intent, 134217728));
                    G(r10, f10);
                    ((NotificationManager) getSystemService("notification")).notify(DfuException.ERROR_DFU_ROLE_SWAP_FAILED, r10.b());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(BluetoothGatt bluetoothGatt) {
        r("Cleaning up...");
        A(0, "gatt.close()");
        bluetoothGatt.close();
        this.f5435f = -5;
    }

    protected BluetoothGatt k(String str) {
        if (!this.f5431b.isEnabled()) {
            return null;
        }
        this.f5435f = -1;
        r("Connecting to the device...");
        BluetoothDevice remoteDevice = this.f5431b.getRemoteDevice(str);
        A(0, "gatt = device.connectGatt(autoConnect = false)");
        BluetoothGatt connectGatt = remoteDevice.connectGatt(this, false, this.f5448s);
        try {
            synchronized (this.f5430a) {
                while (true) {
                    int i10 = this.f5435f;
                    if ((i10 == -1 || i10 == -2) && this.f5436g == 0) {
                        this.f5430a.wait();
                    }
                }
            }
        } catch (InterruptedException e10) {
            q("Sleeping interrupted", e10);
        }
        return connectGatt;
    }

    protected void l(BluetoothGatt bluetoothGatt) {
        if (this.f5435f != 0) {
            A(1, "Disconnecting...");
            this.f5438i.p(-5);
            this.f5435f = -4;
            r("Disconnecting from the device...");
            A(0, "gatt.disconnect()");
            bluetoothGatt.disconnect();
            I();
            A(5, "Disconnected");
        }
    }

    protected abstract Class<? extends Activity> m();

    protected abstract boolean o();

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f5429t = o();
        r("DFU service created. Version: 1.8.1");
        n();
        b1.a b10 = b1.a.b(this);
        IntentFilter t10 = t();
        b10.c(this.f5444o, t10);
        registerReceiver(this.f5444o, t10);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        registerReceiver(this.f5447r, intentFilter);
        registerReceiver(this.f5446q, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        registerReceiver(this.f5445p, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        h hVar = this.f5441l;
        if (hVar != null) {
            hVar.a();
        }
        b1.a.b(this).e(this.f5444o);
        unregisterReceiver(this.f5444o);
        unregisterReceiver(this.f5447r);
        unregisterReceiver(this.f5446q);
        unregisterReceiver(this.f5445p);
        try {
            InputStream inputStream = this.f5442m;
            if (inputStream != null) {
                inputStream.close();
            }
            InputStream inputStream2 = this.f5443n;
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th2) {
            this.f5442m = null;
            this.f5443n = null;
            throw th2;
        }
        this.f5442m = null;
        this.f5443n = null;
        r("DFU service destroyed");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:74:0x0165
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:92)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // android.app.IntentService
    protected void onHandleIntent(android.content.Intent r24) {
        /*
            Method dump skipped, instructions count: 1334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bp.g.onHandleIntent(android.content.Intent):void");
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        ((NotificationManager) getSystemService("notification")).cancel(DfuException.ERROR_DFU_ROLE_SWAP_FAILED);
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(BluetoothGatt bluetoothGatt, boolean z10) {
        if (z10 || bluetoothGatt.getDevice().getBondState() == 10) {
            A(0, "gatt.refresh() (hidden)");
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                if (method != null) {
                    boolean booleanValue = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                    r("Refreshing result: " + booleanValue);
                }
            } catch (Exception e10) {
                q("An exception occurred while refreshing device", e10);
                A(15, "Refreshing failed");
            }
        }
    }
}
