package yk;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.tendcloud.tenddata.ab;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: c  reason: collision with root package name */
    public Context f37110c;

    /* renamed from: d  reason: collision with root package name */
    public ScannerParams f37111d;

    /* renamed from: e  reason: collision with root package name */
    public el.d f37112e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f37113f;

    /* renamed from: g  reason: collision with root package name */
    public BluetoothAdapter f37114g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f37108a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37109b = false;

    /* renamed from: h  reason: collision with root package name */
    public int f37115h = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f37116i = false;

    /* renamed from: j  reason: collision with root package name */
    public long f37117j = 0;

    /* renamed from: k  reason: collision with root package name */
    public final BroadcastReceiver f37118k = new C0540a();

    /* renamed from: l  reason: collision with root package name */
    public Runnable f37119l = new b();

    /* renamed from: m  reason: collision with root package name */
    public Runnable f37120m = new c();

    /* renamed from: n  reason: collision with root package name */
    public boolean f37121n = false;

    /* renamed from: o  reason: collision with root package name */
    public Runnable f37122o = new d();

    /* renamed from: yk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0540a extends BroadcastReceiver {

        /* renamed from: yk.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0541a implements Runnable {
            public RunnableC0541a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.o();
            }
        }

        public C0540a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                il.b.j(String.format(Locale.US, "[%s] %d -> %d", action, Integer.valueOf(intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1)), Integer.valueOf(intExtra)));
                if (intExtra == 10 && a.this.k()) {
                    new Thread(new RunnableC0541a()).start();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String format;
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            a aVar = a.this;
            if (timeInMillis < aVar.f37117j) {
                aVar.f37117j = 0L;
            }
            long j10 = timeInMillis - aVar.f37117j;
            int i10 = aVar.f37115h;
            if (i10 == 1) {
                if (j10 > ab.Y) {
                    format = String.format(Locale.US, "no scan response received after start scan for %d ms", Long.valueOf((long) ab.Y));
                } else {
                    return;
                }
            } else if (i10 != 2) {
                boolean z10 = aVar.f37109b;
                il.b.k(z10, "ignore state:" + a.this.f37115h);
                a.b(a.this);
                return;
            } else if (j10 > ab.Y) {
                format = String.format(Locale.US, "exceed %d ms , no scan response received since last time", Long.valueOf((long) ab.Y));
            } else {
                a.b(aVar);
                return;
            }
            il.b.c(format);
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            il.b.k(a.this.f37109b, "scan delay time reached");
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            el.d dVar = aVar.f37112e;
            if (dVar != null) {
                dVar.a();
            } else {
                il.b.k(aVar.f37109b, "no callback registed");
            }
            a.this.n();
        }
    }

    public static void b(a aVar) {
        Handler handler = aVar.f37113f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(aVar.f37120m);
            aVar.f37113f.postDelayed(aVar.f37120m, aVar.f37111d.k());
            return;
        }
        il.b.k(aVar.f37109b, "mHandler == null");
    }

    public void a(int i10) {
        int i11 = this.f37115h;
        if (i11 != i10) {
            if (this.f37108a) {
                il.b.c(String.format(Locale.US, "ScanState 0x%02X >> 0x%02X", Integer.valueOf(i11), Integer.valueOf(i10)));
            }
            this.f37115h = i10;
            el.d dVar = this.f37112e;
            if (dVar != null) {
                dVar.c(i10);
            } else {
                il.b.k(this.f37109b, "no callback registed");
            }
        }
        int i12 = this.f37115h;
        if (i12 == 0 || i12 == 3) {
            Handler handler = this.f37113f;
            if (handler != null) {
                handler.removeCallbacks(this.f37120m);
                this.f37113f.removeCallbacks(this.f37119l);
                this.f37113f.removeCallbacks(this.f37122o);
            }
            boolean z10 = this.f37121n;
            if (z10) {
                if (this.f37113f != null) {
                    il.b.k(this.f37108a, "wait to start auto scan");
                    this.f37113f.postDelayed(this.f37122o, this.f37111d.b());
                }
            } else if (this.f37109b) {
                il.b.j(String.format("continousScanEnabled=%b", Boolean.valueOf(z10)));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c() {
        BluetoothAdapter bluetoothAdapter;
        if (this.f37116i) {
            il.b.c("please call onDestroy() method first");
            return false;
        }
        this.f37108a = wk.b.f36299b;
        this.f37109b = wk.b.f36300c;
        if (Build.VERSION.SDK_INT >= 18) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.f37110c.getSystemService("bluetooth");
            if (bluetoothManager != null) {
                bluetoothAdapter = bluetoothManager.getAdapter();
            }
            if (this.f37111d == null) {
                il.b.k(this.f37109b, "create new ScannerParams");
                this.f37111d = new ScannerParams();
            }
            if (this.f37113f == null) {
                HandlerThread handlerThread = new HandlerThread("ScannerPresenter");
                handlerThread.start();
                this.f37113f = new Handler(handlerThread.getLooper());
            }
            if (this.f37112e == null) {
                il.b.k(this.f37109b, "callback is null");
            }
            this.f37110c.registerReceiver(this.f37118k, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            this.f37116i = true;
            il.b.j("initialized");
            return true;
        }
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.f37114g = bluetoothAdapter;
        if (this.f37111d == null) {
        }
        if (this.f37113f == null) {
        }
        if (this.f37112e == null) {
        }
        this.f37110c.registerReceiver(this.f37118k, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        this.f37116i = true;
        il.b.j("initialized");
        return true;
    }

    public abstract boolean d(BluetoothDevice bluetoothDevice);

    public boolean e(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
        boolean z10;
        this.f37117j = Calendar.getInstance().getTimeInMillis();
        int i11 = this.f37115h;
        if (i11 == 1) {
            a(2);
        } else if (i11 != 2) {
            il.b.j(String.format("stop to calibration state: 0x%04X", Integer.valueOf(i11)));
            j();
            return false;
        }
        if (bluetoothDevice == null) {
            il.b.c("ignore, device is null");
            return false;
        }
        if (this.f37111d.g() <= -1000 || this.f37111d.g() <= i10) {
            z10 = d(bluetoothDevice);
        } else {
            il.b.l("filter, low rssi:" + i10);
            z10 = false;
        }
        if (!z10) {
            return false;
        }
        el.b bVar = new el.b(bluetoothDevice, bluetoothDevice.getName(), i10, bluetoothDevice.getBondState() == 12, false, bArr);
        if (!f(bVar)) {
            return false;
        }
        el.d dVar = this.f37112e;
        if (dVar != null) {
            dVar.b(bVar);
        } else {
            il.b.k(this.f37109b, "no callback registed");
        }
        if (this.f37111d.i() == 1) {
            il.b.c("SCAN_MECHANISM_FILTER_ONE > scanDevice(false)");
            j();
        }
        return true;
    }

    public boolean f(el.b bVar) {
        return true;
    }

    public boolean g() {
        if (this.f37113f != null) {
            il.b.k(this.f37109b, String.format(Locale.US, "wait to check scan period(%d)", Long.valueOf((long) ab.Y)));
            this.f37113f.removeCallbacks(this.f37119l);
            return this.f37113f.postDelayed(this.f37119l, ab.Y);
        }
        il.b.k(this.f37109b, "mHandler == null");
        return false;
    }

    public boolean h() {
        int i10 = this.f37115h;
        if (i10 == 1 || i10 == 2) {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis < this.f37117j) {
                this.f37117j = 0L;
            }
            if (timeInMillis - this.f37117j > ab.Y) {
                il.b.c(String.format(Locale.US, "exceed %d ms , no scan response received since last time", Long.valueOf((long) ab.Y)));
                j();
            } else {
                g();
            }
            return false;
        }
        a(1);
        this.f37113f.removeCallbacks(this.f37120m);
        this.f37113f.removeCallbacks(this.f37119l);
        this.f37113f.removeCallbacks(this.f37122o);
        this.f37117j = 0L;
        ScannerParams scannerParams = this.f37111d;
        if (scannerParams != null) {
            this.f37121n = scannerParams.l();
        } else {
            this.f37121n = false;
        }
        return true;
    }

    public boolean i() {
        Handler handler = this.f37113f;
        if (handler == null) {
            return true;
        }
        handler.removeCallbacks(this.f37120m);
        this.f37113f.removeCallbacks(this.f37119l);
        this.f37113f.removeCallbacks(this.f37122o);
        return true;
    }

    public abstract boolean j();

    public boolean k() {
        int i10 = this.f37115h;
        return i10 == 2 || i10 == 1;
    }

    public void l() {
        Context context = this.f37110c;
        if (context != null) {
            try {
                context.unregisterReceiver(this.f37118k);
            } catch (Exception e10) {
                il.b.f(this.f37109b, e10.toString());
            }
        }
        this.f37112e = null;
        Handler handler = this.f37113f;
        if (handler != null) {
            handler.removeCallbacks(this.f37120m);
            this.f37113f.removeCallbacks(this.f37122o);
            this.f37113f.removeCallbacks(this.f37119l);
            this.f37113f = null;
        }
        o();
        this.f37116i = false;
    }

    public void m(ScannerParams scannerParams) {
        this.f37111d = scannerParams;
    }

    public abstract boolean n();

    public abstract boolean o();
}
