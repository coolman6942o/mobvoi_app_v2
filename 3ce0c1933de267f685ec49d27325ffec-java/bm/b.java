package bm;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.tendcloud.tenddata.ab;
import el.c;
import el.d;
import el.e;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes2.dex */
public abstract class b extends zl.b implements f {

    /* renamed from: o0  reason: collision with root package name */
    public c f5230o0;

    /* renamed from: p0  reason: collision with root package name */
    public volatile boolean f5231p0;

    /* renamed from: q0  reason: collision with root package name */
    public C0076b f5232q0;

    /* renamed from: r0  reason: collision with root package name */
    public al.c f5233r0;

    /* renamed from: s0  reason: collision with root package name */
    public BluetoothGatt f5234s0;

    /* renamed from: t0  reason: collision with root package name */
    public volatile byte[] f5235t0 = null;

    /* renamed from: u0  reason: collision with root package name */
    public volatile boolean f5236u0 = false;

    /* renamed from: v0  reason: collision with root package name */
    public volatile boolean f5237v0 = false;

    /* renamed from: w0  reason: collision with root package name */
    public volatile boolean f5238w0 = false;

    /* renamed from: x0  reason: collision with root package name */
    public Handler f5239x0 = new Handler(Looper.getMainLooper());

    /* renamed from: y0  reason: collision with root package name */
    public Runnable f5240y0 = new a();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.f36599m == 513) {
                int J = bVar.J(bVar.E);
                boolean z10 = b.this.f36587a;
                il.b.k(z10, ">> mBondState: " + J);
                b.this.j0();
            }
        }
    }

    /* renamed from: bm.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0076b extends d {
        public C0076b() {
        }

        public /* synthetic */ C0076b(b bVar, a aVar) {
            this();
        }

        @Override // el.d
        public void b(el.b bVar) {
            super.b(bVar);
            if (!b.this.f5231p0) {
                if (b.this.f36587a) {
                    il.b.c("is already stop the scan, do nothing");
                }
            } else if (bVar != null) {
                b.this.V(bVar);
            } else if (b.this.f36587a) {
                il.b.c("ignore, device == null");
            }
        }

        @Override // el.d
        public void c(int i10) {
            super.c(i10);
            if (b.this.f36588b) {
                il.b.j("state= " + i10);
            }
        }
    }

    public b(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
    }

    @Override // xl.a
    public void F() {
        super.F();
        this.f5231p0 = false;
        c cVar = this.f5230o0;
        if (cVar != null) {
            cVar.l();
        }
    }

    @Override // zl.b
    public boolean N(ScannerParams scannerParams) {
        if (this.f36587a) {
            il.b.j("start le scan");
        }
        this.f5231p0 = true;
        c cVar = this.f5230o0;
        if (cVar == null) {
            h0(scannerParams);
        } else {
            cVar.m(scannerParams);
        }
        return this.f5230o0.n();
    }

    public void R(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            BluetoothDevice device = bluetoothGatt.getDevice();
            boolean K = t().K(4);
            if (this.f36587a) {
                il.b.j(String.format("close gatt connection: %s, closeClient=%b", fl.a.c(device.getAddress(), true), Boolean.valueOf(K)));
            }
            al.c cVar = this.f5233r0;
            if (cVar != null) {
                cVar.e(device.getAddress(), K);
            } else if (K) {
                bluetoothGatt.close();
            }
        }
        G(1280);
    }

    public void S(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) {
        String str;
        StringBuilder sb2;
        String str2;
        int properties = bluetoothGattCharacteristic.getProperties();
        if ((properties & 16) == 0) {
            str2 = "check properties failed: " + properties;
        } else {
            if (this.f36587a) {
                sb2 = new StringBuilder();
                sb2.append("setCharacteristicNotification() - uuid: ");
                sb2.append(bluetoothGattCharacteristic.getUuid());
                str = " enabled: ";
            } else {
                sb2 = new StringBuilder();
                str = "setCharacteristicNotification() enabled: ";
            }
            sb2.append(str);
            sb2.append(z10);
            il.b.j(sb2.toString());
            if (bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z10)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(f.Y);
                if (descriptor != null) {
                    boolean z11 = true;
                    if (descriptor.getValue() == null || descriptor.getValue().length != 2 || descriptor.getValue()[0] <= 0 || descriptor.getValue()[1] != 0) {
                        z11 = false;
                    }
                    il.b.k(this.f36587a, "current cccd state: " + z11);
                    if (z10 && z11) {
                        str2 = "cccd already enabled";
                    } else if (z10 || z11) {
                        this.C = 0;
                        this.f5236u0 = false;
                        descriptor.setValue(z10 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                        if (bluetoothGatt.writeDescriptor(descriptor)) {
                            synchronized (this.L) {
                                if (this.C == 0 && !this.f5236u0) {
                                    try {
                                        if (this.f36588b) {
                                            il.b.j("wait writeDescriptor for 15000ms");
                                        }
                                        this.L.wait(15000L);
                                    } catch (InterruptedException e10) {
                                        il.b.l("wait writeDescriptor interrupted: " + e10.toString());
                                    }
                                }
                            }
                            if (this.C == 0 && !this.f5236u0) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(z10 ? "Enabling " : "Disabling");
                                sb3.append(" notifications failed");
                                il.b.l(sb3.toString());
                                this.C = DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR;
                            }
                            if (this.C != 0) {
                                throw new OtaException("Unable to set notifications state", this.C);
                            } else if (this.f36587a) {
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append(z10 ? "Enabe" : "Disable");
                                sb4.append(" notifications success");
                                il.b.j(sb4.toString());
                                return;
                            } else {
                                return;
                            }
                        } else {
                            this.C = DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR;
                            throw new OtaException("writeDescriptor failed", this.C);
                        }
                    } else {
                        str2 = "cccd already disable";
                    }
                } else {
                    this.C = DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR;
                    throw new OtaException("no descriptor exist", this.C);
                }
            } else {
                this.C = DfuException.ERROR_WRITE_CHARAC_NOTIFY_ERROR;
                throw new OtaException("setCharacteristicNotification failed", this.C);
            }
        }
        il.b.l(str2);
    }

    public final void T(BluetoothGatt bluetoothGatt, boolean z10) {
        if (z10 || bluetoothGatt.getDevice().getBondState() == 10) {
            dl.c.c(bluetoothGatt);
        }
    }

    public void U(ScannerParams scannerParams, long j10) {
        if (!this.f36594h) {
            D(519);
            this.C = 0;
            this.f37631m0 = false;
            N(scannerParams);
            try {
                synchronized (this.f37630l0) {
                    if (this.C == 0 && !this.f37631m0) {
                        this.f37630l0.wait(j10);
                    }
                }
            } catch (InterruptedException e10) {
                il.b.l("scanLeDevice interrupted, e = " + e10.toString());
                this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
            }
            if (this.C == 0 && !this.f37631m0) {
                il.b.l("didn't find the special device");
                this.C = DfuException.ERROR_CANNOT_FIND_DEVICE;
            }
            if (this.C != 0) {
                throw new OtaException("Error while scan remote ota device", this.C);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ed, code lost:
        if (r1.equals(r5.F) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01ae, code lost:
        if (r1.equals(r0.getAddress()) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01b0, code lost:
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f7 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void V(el.b bVar) {
        boolean z10;
        BluetoothDevice a10 = bVar.a();
        e e10 = e.e(bVar.c());
        if (this.f36607u == 519) {
            if (e10 == null) {
                il.b.d(this.f36587a, "ignore , specScanRecord is null");
                return;
            }
            if (this.f36588b) {
                il.b.j(e10.toString());
            }
            byte[] c10 = e10.c(t().s());
            if (c10 == null) {
                il.b.d(this.f36587a, "no match manufacture data found");
                return;
            }
            if (this.f36587a) {
                il.b.j("manufacturerSpecificData=" + jl.a.a(c10));
            }
            if (v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 13 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) {
                if (this.f36588b) {
                    il.b.j("deviceMac= " + jl.a.a(v().u()));
                }
                z10 = Arrays.equals(c10, v().u());
                if (!z10) {
                    this.D = bVar.b();
                    this.E = a10.getAddress();
                    if (this.f36587a) {
                        il.b.c("find target device: name=" + this.D + " addr=" + this.E);
                    }
                    o0();
                    synchronized (this.f37630l0) {
                        this.f37631m0 = true;
                        this.f37630l0.notifyAll();
                    }
                    return;
                }
                return;
            }
            String d10 = fl.a.d(c10);
            if (this.f36588b) {
                il.b.j("manufacturerAddr= " + d10 + ", mDeviceAddress= " + fl.a.c(this.F, true));
            }
            if (d10 != null) {
            }
            z10 = false;
            if (!z10) {
            }
        } else if (this.f36607u != 515) {
            il.b.j("ignore process state: " + this.f36607u);
        } else if (this.I != 18) {
            String str = this.F;
            if (str != null) {
            }
            z10 = false;
            if (!z10) {
            }
        } else if (e10 == null) {
            il.b.c("ignore , specScanRecord is null");
        } else {
            if (this.f36587a) {
                il.b.j(e10.toString());
            }
            byte[] c11 = e10.c(t().s());
            if (c11 != null) {
                if (this.f36587a) {
                    il.b.j("manufacturerSpecificData=" + jl.a.a(c11));
                }
                String d11 = fl.a.d(c11);
                if (this.f36588b) {
                    il.b.j("manufacturerAddr= " + fl.a.c(d11, true) + ", mDeviceAddress= " + fl.a.c(this.F, true));
                }
                z10 = "00:E0:12:34:77:88".equals(d11);
                if (!z10) {
                }
            }
        }
    }

    @TargetApi(23)
    public boolean W(BluetoothGatt bluetoothGatt, int i10) {
        this.C = 0;
        this.f5238w0 = false;
        if (this.f36587a) {
            il.b.c("requestMtu: " + i10);
        }
        if (!bluetoothGatt.requestMtu(i10)) {
            il.b.l("requestMtu failed");
            return false;
        }
        try {
            synchronized (this.L) {
                if (!this.f5238w0 && this.C == 0) {
                    if (this.f36587a) {
                        il.b.j("wait mtu request callback for 15000ms");
                    }
                    this.L.wait(15000L);
                }
            }
        } catch (InterruptedException e10) {
            il.b.l("requestMtu: Sleeping interrupted, e = " + e10);
        }
        if (this.f5238w0 || this.C != 0) {
            return true;
        }
        if (this.f36587a) {
            il.b.c("requestMtu No CallBack");
        }
        return false;
    }

    public final boolean X(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i10) {
        String str;
        if (bluetoothGatt == null) {
            str = "gatt == null";
        } else if (bluetoothGattCharacteristic == null) {
            str = "characteristic == null";
        } else {
            if (bArr.length > i10) {
                byte[] bArr2 = new byte[i10];
                System.arraycopy(bArr, 0, bArr2, 0, i10);
                bArr = bArr2;
            }
            if (this.f36587a) {
                il.b.j(String.format(Locale.US, "[TX] WRITE_TYPE_0x%02X, (%d)%s >> (%d)%s", Integer.valueOf(bluetoothGattCharacteristic.getWriteType()), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bArr.length), jl.a.a(bArr)));
            }
            bluetoothGattCharacteristic.setValue(bArr);
            return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
        il.b.l(str);
        return false;
    }

    public boolean Y(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i10, boolean z10) {
        String str;
        if (z10 || !this.f36594h) {
            if (bluetoothGattCharacteristic == null) {
                str = "characteristic == null";
            } else if (bArr == null || i10 < 0) {
                str = "value == null || size < 0";
            } else {
                this.f5235t0 = null;
                this.f36605s = true;
                boolean z11 = false;
                int i11 = 0;
                while (this.f36605s) {
                    this.f36604r = false;
                    if (i11 > 0) {
                        try {
                            if (this.f36587a) {
                                il.b.c("re-send command just wait a while");
                            }
                            Thread.sleep(1000L);
                        } catch (InterruptedException e10) {
                            il.b.l(e10.toString());
                        }
                        if (!z10 && this.f36594h) {
                            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
                        }
                    }
                    long j10 = 15000;
                    if (bluetoothGattCharacteristic.getWriteType() == 2) {
                        j10 = ab.Y;
                    }
                    z11 = X(bluetoothGatt, bluetoothGattCharacteristic, bArr, i10);
                    if (z11) {
                        synchronized (this.f36603q) {
                            try {
                                if (!this.f36604r && this.f36599m == 515) {
                                    this.f36603q.wait(j10);
                                } else if (this.f36588b) {
                                    il.b.j("writePacket success");
                                }
                            } catch (InterruptedException e11) {
                                il.b.l("mWriteLock Sleeping interrupted,e:" + e11);
                                if (this.C == 0) {
                                    this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                                }
                            }
                        }
                        if (this.C == 0 && !this.f36604r) {
                            il.b.l("send command but no callback");
                            this.C = DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK;
                        }
                    } else {
                        il.b.l("writePacket failed");
                        this.C = DfuException.ERROR_WRITE_CHARAC_ERROR;
                        z11 = false;
                    }
                    if (this.C != 0 || i11 <= 3) {
                        i11++;
                    } else {
                        il.b.l("send command reach max try time");
                        this.C = DfuException.ERROR_SEND_COMMAND_REACH_MAX_RETRY_TIMES;
                    }
                    if (this.C != 0) {
                        throw new OtaException("Error while send command", this.C);
                    }
                }
                return z11;
            }
            il.b.l(str);
            return false;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final boolean Z(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z10) {
        return Y(bluetoothGatt, bluetoothGattCharacteristic, bArr, bArr != null ? bArr.length : -1, z10);
    }

    public boolean a0(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, boolean z10) {
        return Z(this.f5234s0, bluetoothGattCharacteristic, bArr, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] b0(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        int i10;
        String str;
        if (!this.f36594h) {
            if (bluetoothGatt == null) {
                str = "gatt == null";
            } else if (bluetoothGattCharacteristic == null) {
                str = "characteristic == null";
            } else if ((bluetoothGattCharacteristic.getProperties() & 2) == 0) {
                str = "characteristic not support PROPERTY_READ";
            } else {
                il.b.j(String.format(Locale.US, "readCharacteristic:(handler=%d) %s", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
                this.C = 0;
                this.f36602p = null;
                this.f36601o = false;
                if (bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic)) {
                    synchronized (this.f36600n) {
                        try {
                            if (this.C == 0 && !this.f36601o && this.f36599m == 515) {
                                this.f36600n.wait(15000L);
                            }
                        } catch (InterruptedException e10) {
                            il.b.l("mCharacteristicReadCalledLock Sleeping interrupted,e:" + e10);
                            this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
                        }
                    }
                    if (this.C == 0 && !this.f36601o) {
                        il.b.l("read value but no callback");
                        i10 = DfuException.ERROR_SEND_COMMAND_WITH_NO_CALLBACK;
                    }
                    if (this.C != 0) {
                        return this.f36602p;
                    }
                    throw new OtaException("Error while send command", this.C);
                }
                il.b.c("readCharacteristic failed");
                i10 = DfuException.ERROR_SEND_COMMAND_FAIL;
                this.C = i10;
                if (this.C != 0) {
                }
            }
            il.b.l(str);
            return null;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public byte[] c0(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return b0(this.f5234s0, bluetoothGattCharacteristic);
    }

    public void d0(int i10) {
        if (!t().H()) {
            il.b.c("not support update buffer check mtu size");
            return;
        }
        int i11 = 16;
        if (i10 - 3 > 16) {
            i11 = 16 * (i10 / 16);
        }
        this.S = i11;
        il.b.j("> mBufferCheckMtuSize=" + this.S);
    }

    public void e0(BluetoothGatt bluetoothGatt) {
        int i10 = this.f36599m;
        if (i10 == 0 || i10 == 1280) {
            if (this.f36587a) {
                il.b.c("already disconnect");
            }
        } else if (bluetoothGatt != null) {
            G(1024);
            if (this.f36587a) {
                il.b.j("disconnect()");
            }
            bluetoothGatt.disconnect();
            I();
        } else {
            if (this.f36587a) {
                il.b.j("gatt == null");
            }
            G(0);
        }
    }

    @Override // xl.a
    public boolean f() {
        Handler handler = this.f5239x0;
        if (handler != null) {
            handler.removeCallbacks(this.f5240y0);
        }
        return super.f();
    }

    public byte[] f0(long j10) {
        this.C = 0;
        this.f5237v0 = true;
        try {
            synchronized (this.L) {
                if (this.C == 0 && this.f5235t0 == null && this.f36599m == 515) {
                    this.f5237v0 = false;
                    if (this.f36588b) {
                        il.b.j("wait for notification, wait for " + j10 + "ms");
                    }
                    this.L.wait(j10);
                }
                if (this.C == 0 && !this.f5237v0) {
                    il.b.l("wait for notification, but not come");
                    this.C = DfuException.ERROR_NOTIFICATION_NO_RESPONSE;
                }
            }
        } catch (InterruptedException e10) {
            il.b.l("readNotificationResponse interrupted, " + e10.toString());
            this.C = DfuException.ERROR_LOCK_WAIT_INTERRUPTED;
        }
        if (this.C == 0) {
            return this.f5235t0;
        }
        throw new OtaException("Unable to receive notification", this.C);
    }

    public void g0(int i10) {
        int i11 = 16;
        if (i10 - 3 > 16) {
            i11 = 16 * (i10 / 16);
        }
        this.K = i11;
        il.b.j("> MAX_PACKET_SIZE=" + this.K);
    }

    public final void h0(ScannerParams scannerParams) {
        if (this.f5232q0 == null) {
            this.f5232q0 = new C0076b(this, null);
        }
        this.f5230o0 = new c(this.f36589c, scannerParams, this.f5232q0);
    }

    public void i0(int i10) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
        il.b.c(String.format("terminateConnection, error = 0x%04X", Integer.valueOf(i10)));
        BluetoothGatt bluetoothGatt = this.f5234s0;
        if (bluetoothGatt != null) {
            e0(bluetoothGatt);
            T(this.f5234s0, t().K(2));
            R(this.f5234s0);
        }
    }

    public boolean j0() {
        if (this.f5234s0 == null) {
            il.b.l("mBluetoothGatt == null");
            this.C = DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED;
            A();
            return false;
        } else if (this.f36594h) {
            il.b.l("task already aborted, ignore");
            this.C = DfuException.ERROR_DFU_ABORTED;
            return false;
        } else {
            if (this.f36587a) {
                il.b.c("Attempting to start service discovery...");
            }
            boolean discoverServices = this.f5234s0.discoverServices();
            if (this.f36588b) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("discoverServices ");
                sb2.append(discoverServices ? "succeed" : "failed");
                il.b.c(sb2.toString());
            }
            if (!discoverServices) {
                this.C = DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED;
                A();
            }
            return discoverServices;
        }
    }

    public ScannerParams k0() {
        ScannerParams scannerParams = new ScannerParams(17);
        scannerParams.t(31000L);
        return scannerParams;
    }

    public void l0() {
        G(513);
        if (this.f5239x0 != null) {
            il.b.j(String.format(Locale.US, "delay to discover service for :%d ms ", 1600));
            this.f5239x0.postDelayed(this.f5240y0, 1600L);
            return;
        }
        j0();
    }

    public byte[] m0() {
        return f0(t().t());
    }

    public boolean n0() {
        String str;
        if (this.f5234s0 == null) {
            str = "mBluetoothGatt == null";
        } else if (this.f36594h) {
            str = "task already aborted, ignore";
        } else if (t().x() == 0) {
            il.b.k(this.f36587a, "no need to set phy");
            return true;
        } else if (Build.VERSION.SDK_INT < 26) {
            il.b.d(this.f36587a, "PHY not supported");
            return true;
        } else {
            boolean z10 = this.f36587a;
            il.b.k(z10, "setPreferredPhy:" + t().x());
            int x10 = t().x();
            if (x10 == 0) {
                this.f5234s0.setPreferredPhy(1, 1, 0);
            } else if (x10 == 2) {
                this.f5234s0.setPreferredPhy(4, 4, 1);
            } else if (x10 != 3) {
                this.f5234s0.setPreferredPhy(2, 2, 0);
            } else {
                this.f5234s0.setPreferredPhy(4, 4, 2);
            }
            return true;
        }
        il.b.l(str);
        return false;
    }

    public boolean o0() {
        this.f5231p0 = false;
        c cVar = this.f5230o0;
        if (cVar != null) {
            return cVar.o();
        }
        return true;
    }

    @Override // zl.b, xl.a
    public void x() {
        super.x();
        this.f5233r0 = al.c.k();
        h0(null);
    }
}
