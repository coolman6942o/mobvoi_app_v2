package ja;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.ParcelUuid;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.f;
/* compiled from: BleScanner.kt */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: j  reason: collision with root package name */
    public static final a f29469j = new a(null);

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f29470k = {"android.permission.ACCESS_COARSE_LOCATION"};

    /* renamed from: a  reason: collision with root package name */
    private final Context f29471a;

    /* renamed from: b  reason: collision with root package name */
    private BluetoothLeScanner f29472b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29474d;

    /* renamed from: e  reason: collision with root package name */
    private ScanSettings f29475e;

    /* renamed from: f  reason: collision with root package name */
    private List<ScanFilter> f29476f;

    /* renamed from: g  reason: collision with root package name */
    private c f29477g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f29478h;

    /* renamed from: c  reason: collision with root package name */
    private final b f29473c = new b(this);

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<String, ScanResult> f29479i = new HashMap<>();

    /* compiled from: BleScanner.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String[] a() {
            return i.f29470k;
        }

        public final boolean b(Context context) {
            kotlin.jvm.internal.i.f(context, "context");
            String[] a10 = a();
            int length = a10.length;
            int i10 = 0;
            while (i10 < length) {
                String str = a10[i10];
                i10++;
                if (androidx.core.content.b.a(context, str) == -1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: BleScanner.kt */
    /* loaded from: classes2.dex */
    private final class b extends ScanCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f29480a;

        public b(i this$0) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            this.f29480a = this$0;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onBatchScanResults(List<ScanResult> results) {
            kotlin.jvm.internal.i.f(results, "results");
            k.a("BleScanner", kotlin.jvm.internal.i.n("onBatchScanResults: ", Integer.valueOf(results.size())));
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int i10) {
            k.a("BleScanner", kotlin.jvm.internal.i.n("onScanFailed: ", Integer.valueOf(i10)));
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int i10, ScanResult result) {
            kotlin.jvm.internal.i.f(result, "result");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onScanResult ");
            BluetoothDevice device = result.getDevice();
            String str = null;
            sb2.append((Object) (device == null ? null : device.getAddress()));
            sb2.append(", ");
            BluetoothDevice device2 = result.getDevice();
            if (device2 != null) {
                str = device2.getName();
            }
            sb2.append((Object) str);
            k.a("BleScanner", sb2.toString());
            if (i10 == 1) {
                this.f29480a.h(result, "all match");
            } else if (i10 == 2) {
                this.f29480a.h(result, "first match");
            } else if (i10 != 4) {
                k.a("BleScanner", kotlin.jvm.internal.i.n("unknown callbackType: ", Integer.valueOf(i10)));
            } else {
                this.f29480a.g(result, "match lost");
            }
        }
    }

    /* compiled from: BleScanner.kt */
    /* loaded from: classes2.dex */
    public interface c {
        void b(ScanResult scanResult);
    }

    public i(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.i.e(applicationContext, "context.applicationContext");
        this.f29471a = applicationContext;
    }

    private final ScanSettings e() {
        ScanSettings scanSettings = this.f29475e;
        if (scanSettings != null) {
            Objects.requireNonNull(scanSettings, "null cannot be cast to non-null type android.bluetooth.le.ScanSettings");
            return scanSettings;
        }
        ScanSettings build = new ScanSettings.Builder().build();
        kotlin.jvm.internal.i.e(build, "Builder().build()");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(ScanResult scanResult, String str) {
        BluetoothDevice device = scanResult.getDevice();
        com.mobvoi.apollo.protocol.ble.b bVar = com.mobvoi.apollo.protocol.ble.b.f15583a;
        if (bVar.d()) {
            k.a("BleScanner", '[' + str + "] rssi: " + scanResult.getRssi() + ", address: " + ((Object) device.getAddress()) + ", name: [" + ((Object) device.getName()) + "], bondState: " + device.getBondState() + ", type: " + device.getType());
        }
        ParcelUuid[] uuids = device.getUuids();
        if (uuids != null) {
            int i10 = 0;
            if ((!(uuids.length == 0)) && bVar.d()) {
                int length = uuids.length;
                while (i10 < length) {
                    ParcelUuid parcelUuid = uuids[i10];
                    i10++;
                    k.a("BleScanner", kotlin.jvm.internal.i.n("UUID: ", parcelUuid.getUuid()));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final ScanResult scanResult, String str) {
        g(scanResult, str);
        if (!this.f29478h || scanResult.getDevice().getName() != null) {
            String btAddress = scanResult.getDevice().getAddress();
            HashMap<String, ScanResult> hashMap = this.f29479i;
            kotlin.jvm.internal.i.e(btAddress, "btAddress");
            hashMap.put(btAddress, scanResult);
            if (com.mobvoi.apollo.protocol.ble.b.f15583a.d()) {
                k.a("BleScanner", "Total scan results: " + this.f29479i + ".size");
            }
            l.a().post(new Runnable() { // from class: ja.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.i(i.this, scanResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(i this$0, ScanResult result) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(result, "$result");
        c cVar = this$0.f29477g;
        if (cVar != null) {
            kotlin.jvm.internal.i.d(cVar);
            cVar.b(result);
        }
    }

    public final boolean f() {
        return this.f29474d;
    }

    public final void j(List<ScanFilter> list) {
        this.f29476f = list;
    }

    public final void k(ScanSettings scanSettings) {
        kotlin.jvm.internal.i.f(scanSettings, "scanSettings");
        this.f29475e = scanSettings;
    }

    public final boolean l(c listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        if (this.f29472b == null) {
            oa.a aVar = oa.a.f31484a;
            if (!aVar.a(this.f29471a)) {
                return false;
            }
            BluetoothAdapter d10 = aVar.d(this.f29471a);
            BluetoothLeScanner bluetoothLeScanner = d10 == null ? null : d10.getBluetoothLeScanner();
            this.f29472b = bluetoothLeScanner;
            if (bluetoothLeScanner == null) {
                k.a("BleScanner", "Failed to get BLE scanner");
                return false;
            }
        }
        if (f29469j.b(this.f29471a)) {
            k.a("BleScanner", "No location permissions");
            return false;
        } else if (!this.f29474d) {
            this.f29479i.clear();
            k.a("BleScanner", kotlin.jvm.internal.i.n("Scan filters: ", this.f29476f));
            k.a("BleScanner", kotlin.jvm.internal.i.n("Scan settings:  ", this.f29475e));
            BluetoothLeScanner bluetoothLeScanner2 = this.f29472b;
            kotlin.jvm.internal.i.d(bluetoothLeScanner2);
            bluetoothLeScanner2.startScan(this.f29476f, e(), this.f29473c);
            this.f29474d = true;
            this.f29477g = listener;
            return true;
        } else {
            k.a("BleScanner", "Scanning was already started");
            return false;
        }
    }

    public final void m() {
        k.a("BleScanner", "Stop scanning");
        if (this.f29474d) {
            BluetoothLeScanner bluetoothLeScanner = this.f29472b;
            kotlin.jvm.internal.i.d(bluetoothLeScanner);
            bluetoothLeScanner.stopScan(this.f29473c);
            this.f29477g = null;
            this.f29474d = false;
        }
    }
}
