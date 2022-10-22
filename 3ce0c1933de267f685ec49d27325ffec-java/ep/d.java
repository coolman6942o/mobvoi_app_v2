package ep;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import java.util.List;
import java.util.Locale;
/* compiled from: BootloaderScannerLollipop.java */
@TargetApi(21)
/* loaded from: classes3.dex */
public class d extends ScanCallback implements ep.a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f26245a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private String f26246b;

    /* renamed from: c  reason: collision with root package name */
    private String f26247c;

    /* renamed from: d  reason: collision with root package name */
    private String f26248d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26249e;

    /* compiled from: BootloaderScannerLollipop.java */
    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException unused) {
            }
            if (!d.this.f26249e) {
                d.this.f26248d = null;
                d.this.f26249e = true;
                synchronized (d.this.f26245a) {
                    d.this.f26245a.notifyAll();
                }
            }
        }
    }

    @Override // ep.a
    public String a(String str) {
        BluetoothLeScanner bluetoothLeScanner;
        String substring = str.substring(0, 15);
        String format = String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255));
        this.f26246b = str;
        this.f26247c = substring + format;
        this.f26248d = null;
        this.f26249e = false;
        new Thread(new a(), "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12 || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return null;
        }
        bluetoothLeScanner.startScan((List<ScanFilter>) null, new ScanSettings.Builder().setScanMode(2).build(), this);
        try {
            synchronized (this.f26245a) {
                while (!this.f26249e) {
                    this.f26245a.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        bluetoothLeScanner.stopScan(this);
        return this.f26248d;
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int i10, ScanResult scanResult) {
        String address = scanResult.getDevice().getAddress();
        if (this.f26246b.equals(address) || this.f26247c.equals(address)) {
            this.f26248d = address;
            this.f26249e = true;
            synchronized (this.f26245a) {
                this.f26245a.notifyAll();
            }
        }
    }
}
