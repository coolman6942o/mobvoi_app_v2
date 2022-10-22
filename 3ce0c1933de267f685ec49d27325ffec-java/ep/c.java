package ep;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import java.util.Locale;
/* compiled from: BootloaderScannerJB.java */
/* loaded from: classes3.dex */
public class c implements ep.a, BluetoothAdapter.LeScanCallback {

    /* renamed from: a  reason: collision with root package name */
    private final Object f26239a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private String f26240b;

    /* renamed from: c  reason: collision with root package name */
    private String f26241c;

    /* renamed from: d  reason: collision with root package name */
    private String f26242d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26243e;

    /* compiled from: BootloaderScannerJB.java */
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
            if (!c.this.f26243e) {
                c.this.f26242d = null;
                c.this.f26243e = true;
                synchronized (c.this.f26239a) {
                    c.this.f26239a.notifyAll();
                }
            }
        }
    }

    @Override // ep.a
    public String a(String str) {
        String substring = str.substring(0, 15);
        String format = String.format(Locale.US, "%02X", Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() + 1) & 255));
        this.f26240b = str;
        this.f26241c = substring + format;
        this.f26242d = null;
        this.f26243e = false;
        new Thread(new a(), "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            return null;
        }
        defaultAdapter.startLeScan(this);
        try {
            synchronized (this.f26239a) {
                while (!this.f26243e) {
                    this.f26239a.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        defaultAdapter.stopLeScan(this);
        return this.f26242d;
    }

    @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
    public void onLeScan(BluetoothDevice bluetoothDevice, int i10, byte[] bArr) {
        String address = bluetoothDevice.getAddress();
        if (this.f26240b.equals(address) || this.f26241c.equals(address)) {
            this.f26242d = address;
            this.f26243e = true;
            synchronized (this.f26239a) {
                this.f26239a.notifyAll();
            }
        }
    }
}
