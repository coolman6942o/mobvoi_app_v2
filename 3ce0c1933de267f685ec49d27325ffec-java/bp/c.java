package bp;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import bp.h;
import ep.b;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseDfuImpl.java */
/* loaded from: classes3.dex */
public abstract class c implements l {

    /* renamed from: s  reason: collision with root package name */
    protected static final UUID f5401s = new UUID(26392574038016L, -9223371485494954757L);

    /* renamed from: t  reason: collision with root package name */
    protected static final UUID f5402t = new UUID(46200963207168L, -9223371485494954757L);

    /* renamed from: u  reason: collision with root package name */
    protected static final UUID f5403u = new UUID(45088566677504L, -9223371485494954757L);

    /* renamed from: v  reason: collision with root package name */
    protected static final char[] f5404v = "0123456789ABCDEF".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    protected InputStream f5406b;

    /* renamed from: c  reason: collision with root package name */
    protected InputStream f5407c;

    /* renamed from: d  reason: collision with root package name */
    protected BluetoothGatt f5408d;

    /* renamed from: e  reason: collision with root package name */
    protected int f5409e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f5410f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f5411g;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f5413i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f5414j;

    /* renamed from: k  reason: collision with root package name */
    protected int f5415k;

    /* renamed from: n  reason: collision with root package name */
    protected g f5418n;

    /* renamed from: o  reason: collision with root package name */
    protected j f5419o;

    /* renamed from: p  reason: collision with root package name */
    protected int f5420p;

    /* renamed from: q  reason: collision with root package name */
    protected int f5421q;

    /* renamed from: r  reason: collision with root package name */
    private int f5422r;

    /* renamed from: a  reason: collision with root package name */
    protected final Object f5405a = new Object();

    /* renamed from: l  reason: collision with root package name */
    protected byte[] f5416l = null;

    /* renamed from: m  reason: collision with root package name */
    protected byte[] f5417m = new byte[20];

    /* renamed from: h  reason: collision with root package name */
    protected boolean f5412h = true;

    /* compiled from: BaseDfuImpl.java */
    /* loaded from: classes3.dex */
    protected class a extends h.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
        }

        private String d(byte[] bArr) {
            int length;
            if (bArr == null || (length = bArr.length) == 0) {
                return "";
            }
            char[] cArr = new char[(length * 3) - 1];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = bArr[i10] & 255;
                int i12 = i10 * 3;
                char[] cArr2 = c.f5404v;
                cArr[i12] = cArr2[i11 >>> 4];
                cArr[i12 + 1] = cArr2[i11 & 15];
                if (i10 != length - 1) {
                    cArr[i12 + 2] = '-';
                }
            }
            return new String(cArr);
        }

        private String e(int i10) {
            if (i10 == 1) {
                return "LE 1M";
            }
            if (i10 == 2) {
                return "LE 2M";
            }
            if (i10 == 3) {
                return "LE Coded";
            }
            return "UNKNOWN (" + i10 + ")";
        }

        @Override // bp.h.a
        public void a() {
            c cVar = c.this;
            cVar.f5412h = false;
            cVar.s();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public String b(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            return d(bluetoothGattCharacteristic.getValue());
        }

        protected String c(BluetoothGattDescriptor bluetoothGattDescriptor) {
            return d(bluetoothGattDescriptor.getValue());
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            if (i10 == 0) {
                g gVar = c.this.f5418n;
                gVar.A(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + b(bluetoothGattCharacteristic));
                c.this.f5416l = bluetoothGattCharacteristic.getValue();
                c.this.f5413i = true;
            } else {
                c cVar = c.this;
                cVar.o("Characteristic read error: " + i10);
                c.this.f5415k = i10 | 16384;
            }
            c.this.s();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            if (i10 != 0) {
                c cVar = c.this;
                cVar.o("Descriptor read error: " + i10);
                c.this.f5415k = i10 | 16384;
            } else if (c.f5403u.equals(bluetoothGattDescriptor.getUuid())) {
                g gVar = c.this.f5418n;
                gVar.A(5, "Read Response received from descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + c(bluetoothGattDescriptor));
                if (c.f5402t.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                    c.this.f5413i = true;
                } else {
                    c.this.o("Unknown descriptor read");
                }
            }
            c.this.s();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            if (i10 != 0) {
                c cVar = c.this;
                cVar.o("Descriptor write error: " + i10);
                c.this.f5415k = i10 | 16384;
            } else if (c.f5403u.equals(bluetoothGattDescriptor.getUuid())) {
                g gVar = c.this.f5418n;
                gVar.A(5, "Data written to descr." + bluetoothGattDescriptor.getCharacteristic().getUuid() + ", value (0x): " + c(bluetoothGattDescriptor));
                if (c.f5402t.equals(bluetoothGattDescriptor.getCharacteristic().getUuid())) {
                    g gVar2 = c.this.f5418n;
                    gVar2.A(1, "Indications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                } else {
                    g gVar3 = c.this.f5418n;
                    gVar3.A(1, "Notifications enabled for " + bluetoothGattDescriptor.getCharacteristic().getUuid());
                }
            }
            c.this.s();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (i11 == 0) {
                c.this.f5418n.A(5, "MTU changed to: " + i10);
                int i12 = i10 + (-3);
                c cVar = c.this;
                if (i12 > cVar.f5417m.length) {
                    cVar.f5417m = new byte[i12];
                }
                cVar.q("MTU changed to: " + i10);
            } else {
                c.this.r("Changing MTU failed: " + i11 + " (mtu: " + i10 + ")");
                if (i11 == 4 && c.this.f5422r > 23) {
                    int i13 = c.this.f5422r - 3;
                    c cVar2 = c.this;
                    if (i13 > cVar2.f5417m.length) {
                        cVar2.f5417m = new byte[cVar2.f5422r - 3];
                        c.this.q("MTU restored to: " + c.this.f5422r);
                    }
                }
            }
            c cVar3 = c.this;
            cVar3.f5413i = true;
            cVar3.s();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i10, int i11, int i12) {
            if (i12 == 0) {
                g gVar = c.this.f5418n;
                gVar.A(5, "PHY updated (TX: " + e(i10) + ", RX: " + e(i11) + ")");
                c cVar = c.this;
                cVar.q("PHY updated (TX: " + e(i10) + ", RX: " + e(i11) + ")");
                return;
            }
            c cVar2 = c.this;
            cVar2.r("Updating PHY failed: " + i12 + " (txPhy: " + i10 + ", rxPhy: " + i11 + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Intent intent, g gVar) {
        this.f5418n = gVar;
        this.f5419o = gVar.f5438i;
    }

    private boolean k(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", new Class[0]);
            if (method != null) {
                this.f5418n.A(0, "gatt.getDevice().createBond() (hidden)");
                return ((Boolean) method.invoke(bluetoothDevice, new Object[0])).booleanValue();
            }
        } catch (Exception e10) {
            Log.w("DfuImpl", "An exception occurred while creating bond", e10);
        }
        return false;
    }

    private boolean n() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattDescriptor descriptor;
        if (!this.f5412h) {
            throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
        } else if (!this.f5411g) {
            BluetoothGatt bluetoothGatt = this.f5408d;
            BluetoothGattService service = bluetoothGatt.getService(f5401s);
            if (service == null || (characteristic = service.getCharacteristic(f5402t)) == null || (descriptor = characteristic.getDescriptor(f5403u)) == null) {
                return false;
            }
            this.f5413i = false;
            this.f5415k = 0;
            q("Reading Service Changed CCCD value...");
            this.f5418n.A(1, "Reading Service Changed CCCD value...");
            g gVar = this.f5418n;
            gVar.A(0, "gatt.readDescriptor(" + descriptor.getUuid() + ")");
            bluetoothGatt.readDescriptor(descriptor);
            try {
                synchronized (this.f5405a) {
                    while (true) {
                        if ((this.f5413i || !this.f5412h || this.f5415k != 0) && !this.f5410f) {
                            break;
                        }
                        this.f5405a.wait();
                    }
                }
            } catch (InterruptedException e10) {
                p("Sleeping interrupted", e10);
            }
            if (this.f5415k != 0) {
                throw new DfuException("Unable to read Service Changed CCCD", this.f5415k);
            } else if (this.f5412h) {
                return descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] == BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[0] && descriptor.getValue()[1] == BluetoothGattDescriptor.ENABLE_INDICATION_VALUE[1];
            } else {
                throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    @Override // bp.i
    public void a() {
        this.f5410f = false;
        this.f5411g = true;
        s();
    }

    @Override // bp.i
    public void b() {
        this.f5410f = true;
    }

    @Override // bp.h
    public void c(int i10) {
        this.f5413i = true;
        s();
    }

    @Override // bp.i
    public void d() {
        this.f5410f = false;
        s();
    }

    @Override // bp.l
    public boolean g(Intent intent, BluetoothGatt bluetoothGatt, int i10, InputStream inputStream, InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        int i11;
        BluetoothGattService service;
        BluetoothGattCharacteristic characteristic;
        this.f5408d = bluetoothGatt;
        this.f5409e = i10;
        this.f5406b = inputStream;
        this.f5407c = inputStream2;
        int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 1);
        int intExtra2 = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 1);
        this.f5422r = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU", 23);
        if (i10 > 4) {
            r("DFU target does not support (SD/BL)+App update, splitting into 2 parts");
            this.f5418n.A(15, "Sending system components");
            int i12 = this.f5409e & (-5);
            this.f5409e = i12;
            ((cp.a) this.f5406b).E(i12);
            intExtra2 = 2;
        }
        if (intExtra == 2) {
            this.f5418n.A(15, "Sending application");
        }
        int i13 = 0;
        try {
            if (inputStream2.markSupported()) {
                inputStream2.reset();
            }
            i11 = inputStream2.available();
        } catch (Exception unused) {
            i11 = 0;
        }
        this.f5421q = i11;
        try {
            if (inputStream.markSupported()) {
                if (inputStream instanceof cp.a) {
                    ((cp.a) inputStream).h();
                } else {
                    inputStream.reset();
                }
            }
            i13 = inputStream.available();
        } catch (Exception unused2) {
        }
        this.f5420p = i13;
        this.f5419o.i(i13, intExtra, intExtra2);
        if (!(bluetoothGatt.getDevice().getBondState() != 12 || (service = bluetoothGatt.getService(f5401s)) == null || (characteristic = service.getCharacteristic(f5402t)) == null)) {
            if (!n()) {
                l(characteristic, 2);
            }
            this.f5418n.A(10, "Service Changed indications enabled");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public boolean j() {
        boolean z10;
        BluetoothDevice device = this.f5408d.getDevice();
        if (device.getBondState() == 12) {
            return true;
        }
        this.f5413i = false;
        this.f5418n.A(1, "Starting pairing...");
        if (Build.VERSION.SDK_INT >= 19) {
            this.f5418n.A(0, "gatt.getDevice().createBond()");
            z10 = device.createBond();
        } else {
            z10 = k(device);
        }
        try {
            synchronized (this.f5405a) {
                while (!this.f5413i && !this.f5411g) {
                    this.f5405a.wait();
                }
            }
        } catch (InterruptedException e10) {
            p("Sleeping interrupted", e10);
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        BluetoothGatt bluetoothGatt = this.f5408d;
        String str = i10 == 1 ? "notifications" : "indications";
        if (!this.f5412h) {
            throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
        } else if (!this.f5411g) {
            this.f5416l = null;
            this.f5415k = 0;
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(f5403u);
            boolean z10 = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
            if (!z10) {
                q("Enabling " + str + "...");
                g gVar = this.f5418n;
                gVar.A(1, "Enabling " + str + " for " + bluetoothGattCharacteristic.getUuid());
                g gVar2 = this.f5418n;
                gVar2.A(0, "gatt.setCharacteristicNotification(" + bluetoothGattCharacteristic.getUuid() + ", true)");
                bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                descriptor.setValue(i10 == 1 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                g gVar3 = this.f5418n;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("gatt.writeDescriptor(");
                sb2.append(descriptor.getUuid());
                sb2.append(i10 == 1 ? ", value=0x01-00)" : ", value=0x02-00)");
                gVar3.A(0, sb2.toString());
                bluetoothGatt.writeDescriptor(descriptor);
                try {
                    synchronized (this.f5405a) {
                        while (true) {
                            if ((z10 || !this.f5412h || this.f5415k != 0) && !this.f5410f) {
                                break;
                            }
                            this.f5405a.wait();
                            z10 = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
                        }
                    }
                } catch (InterruptedException e10) {
                    p("Sleeping interrupted", e10);
                }
                if (this.f5415k != 0) {
                    throw new DfuException("Unable to set " + str + " state", this.f5415k);
                } else if (!this.f5412h) {
                    throw new DeviceDisconnectedException("Unable to set " + str + " state: device disconnected");
                }
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m() {
        return this.f5408d.getDevice().getBondState() == 12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str) {
        Log.e("DfuImpl", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(String str, Throwable th2) {
        Log.e("DfuImpl", str, th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(String str) {
        if (g.f5429t) {
            Log.i("DfuImpl", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(String str) {
        if (g.f5429t) {
            Log.w("DfuImpl", str);
        }
    }

    @Override // bp.l
    public void release() {
        this.f5418n = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        synchronized (this.f5405a) {
            this.f5405a.notifyAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String t(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return "";
        }
        char[] cArr = new char[(length * 3) - 1];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = bArr[i10] & 255;
            int i12 = i10 * 3;
            char[] cArr2 = f5404v;
            cArr[i12] = cArr2[i11 >>> 4];
            cArr[i12 + 1] = cArr2[i11 & 15];
            if (i10 != length - 1) {
                cArr[i12 + 2] = '-';
            }
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] u() throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        try {
            synchronized (this.f5405a) {
                while (true) {
                    if ((this.f5416l != null || !this.f5412h || this.f5415k != 0 || this.f5411g) && !this.f5410f) {
                        break;
                    }
                    this.f5405a.wait();
                }
            }
        } catch (InterruptedException e10) {
            p("Sleeping interrupted", e10);
        }
        if (this.f5411g) {
            throw new UploadAbortedException();
        } else if (this.f5415k != 0) {
            throw new DfuException("Unable to write Op Code", this.f5415k);
        } else if (this.f5412h) {
            return this.f5416l;
        } else {
            throw new DeviceDisconnectedException("Unable to write Op Code: device disconnected");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v() {
        Exception e10;
        BluetoothDevice device = this.f5408d.getDevice();
        boolean z10 = true;
        if (device.getBondState() == 10) {
            return true;
        }
        this.f5418n.A(1, "Removing bond information...");
        try {
            Method method = device.getClass().getMethod("removeBond", new Class[0]);
            if (method != null) {
                this.f5413i = false;
                this.f5418n.A(0, "gatt.getDevice().removeBond() (hidden)");
                z10 = ((Boolean) method.invoke(device, new Object[0])).booleanValue();
                try {
                    try {
                        synchronized (this.f5405a) {
                            while (!this.f5413i && !this.f5411g) {
                                this.f5405a.wait();
                            }
                        }
                    } catch (InterruptedException e11) {
                        p("Sleeping interrupted", e11);
                    }
                } catch (Exception e12) {
                    e10 = e12;
                    Log.w("DfuImpl", "An exception occurred while removing bond information", e10);
                    return z10;
                }
            }
        } catch (Exception e13) {
            e10 = e13;
            z10 = false;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(int i10) throws DeviceDisconnectedException, UploadAbortedException {
        if (!this.f5411g) {
            this.f5413i = false;
            this.f5418n.A(1, "Requesting new MTU...");
            g gVar = this.f5418n;
            gVar.A(0, "gatt.requestMtu(" + i10 + ")");
            if (this.f5408d.requestMtu(i10)) {
                try {
                    synchronized (this.f5405a) {
                        while (true) {
                            if ((this.f5413i || !this.f5412h || this.f5415k != 0) && !this.f5410f) {
                                break;
                            }
                            this.f5405a.wait();
                        }
                    }
                } catch (InterruptedException e10) {
                    p("Sleeping interrupted", e10);
                }
                if (!this.f5412h) {
                    throw new DeviceDisconnectedException("Unable to read Service Changed CCCD: device disconnected");
                }
                return;
            }
            return;
        }
        throw new UploadAbortedException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(Intent intent, boolean z10) {
        String str;
        if (z10) {
            this.f5418n.A(1, "Scanning for the DFU Bootloader...");
            str = b.a().a(this.f5408d.getDevice().getAddress());
            q("Scanning for new address finished with: " + str);
            if (str != null) {
                g gVar = this.f5418n;
                gVar.A(5, "DFU Bootloader found with address " + str);
            } else {
                this.f5418n.A(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            str = null;
        }
        if (str != null) {
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", str);
        }
        this.f5418n.startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y() {
        try {
            synchronized (this.f5405a) {
                while (this.f5410f) {
                    this.f5405a.wait();
                }
            }
        } catch (InterruptedException e10) {
            p("Sleeping interrupted", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z10) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.f5411g) {
            this.f5416l = null;
            this.f5415k = 0;
            this.f5413i = false;
            this.f5414j = z10;
            bluetoothGattCharacteristic.setWriteType(2);
            bluetoothGattCharacteristic.setValue(bArr);
            g gVar = this.f5418n;
            gVar.A(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
            g gVar2 = this.f5418n;
            gVar2.A(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.f5408d.writeCharacteristic(bluetoothGattCharacteristic);
            try {
                synchronized (this.f5405a) {
                    while (true) {
                        if ((this.f5413i || !this.f5412h || this.f5415k != 0) && !this.f5410f) {
                            break;
                        }
                        this.f5405a.wait();
                    }
                }
            } catch (InterruptedException e10) {
                p("Sleeping interrupted", e10);
            }
            boolean z11 = this.f5414j;
            if (!z11 && this.f5415k != 0) {
                throw new DfuException("Unable to write Op Code " + ((int) bArr[0]), this.f5415k);
            } else if (!z11 && !this.f5412h) {
                throw new DeviceDisconnectedException("Unable to write Op Code " + ((int) bArr[0]) + ": device disconnected");
            }
        } else {
            throw new UploadAbortedException();
        }
    }
}
