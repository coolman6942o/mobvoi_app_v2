package com.realsil.sdk.dfu.v;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.os.Handler;
import android.os.Looper;
import bm.f;
import com.realsil.sdk.core.usb.GlobalUsbGatt;
import com.realsil.sdk.core.usb.UsbGatt;
import com.realsil.sdk.core.usb.UsbGattCharacteristic;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.util.Locale;
/* loaded from: classes2.dex */
public abstract class b extends mm.a implements f {

    /* renamed from: k0  reason: collision with root package name */
    public GlobalUsbGatt f22296k0;

    /* renamed from: l0  reason: collision with root package name */
    public UsbGatt f22297l0;

    /* renamed from: m0  reason: collision with root package name */
    public volatile byte[] f22298m0 = null;

    /* renamed from: n0  reason: collision with root package name */
    public volatile boolean f22299n0 = false;

    /* renamed from: o0  reason: collision with root package name */
    public volatile boolean f22300o0 = false;

    /* renamed from: p0  reason: collision with root package name */
    public Handler f22301p0 = new Handler(Looper.getMainLooper());

    /* renamed from: q0  reason: collision with root package name */
    public Runnable f22302q0 = new a();

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.f36599m == 513) {
                bVar.Z();
            }
        }
    }

    public b(Context context, DfuConfig dfuConfig, xl.b bVar) {
        super(context, dfuConfig, bVar);
    }

    public void N(UsbGatt usbGatt) {
        if (usbGatt != null) {
            UsbDevice device = usbGatt.getDevice();
            boolean z10 = this.f36587a;
            il.b.d(z10, "close gatt connection: " + device.getDeviceName());
            GlobalUsbGatt globalUsbGatt = this.f22296k0;
            if (globalUsbGatt != null) {
                globalUsbGatt.closeGatt(device.getDeviceName());
            } else {
                usbGatt.close();
            }
        }
        G(1280);
    }

    public final void O(UsbGatt usbGatt, boolean z10) {
    }

    @TargetApi(23)
    public boolean P(UsbGatt usbGatt, int i10) {
        this.C = 0;
        this.f22300o0 = false;
        boolean z10 = this.f36587a;
        il.b.d(z10, "requestMtu: " + i10);
        if (!usbGatt.requestMtu(i10)) {
            il.b.l("requestMtu failed");
            return false;
        }
        try {
            synchronized (this.L) {
                if (!this.f22300o0 && this.C == 0) {
                    if (this.f36587a) {
                        il.b.j("wait mtu request callback for 15000ms");
                    }
                    this.L.wait(15000L);
                }
            }
        } catch (InterruptedException e10) {
            il.b.l("requestMtu: Sleeping interrupted, e = " + e10);
        }
        if (this.f22300o0 || this.C != 0) {
            return true;
        }
        il.b.d(this.f36587a, "requestMtu No CallBack");
        return false;
    }

    public final boolean Q(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, byte[] bArr, int i10) {
        String str;
        if (usbGatt == null) {
            str = "gatt == null";
        } else if (usbGattCharacteristic == null) {
            str = "characteristic == null";
        } else {
            if (bArr.length > i10) {
                byte[] bArr2 = new byte[i10];
                System.arraycopy(bArr, 0, bArr2, 0, i10);
                bArr = bArr2;
            }
            if (this.f36587a) {
                il.b.j(String.format(Locale.US, "[TX] WRITE_TYPE_0x%02X, %s >> (%d)%s", Integer.valueOf(usbGattCharacteristic.getWriteType()), usbGattCharacteristic.getUuid(), Integer.valueOf(bArr.length), jl.a.a(bArr)));
            }
            usbGattCharacteristic.setValue(bArr);
            return usbGatt.writeCharacteristic(usbGattCharacteristic);
        }
        il.b.l(str);
        return false;
    }

    public boolean R(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, byte[] bArr, int i10, boolean z10) {
        if (!z10 && this.f36594h) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        } else if (bArr == null || i10 < 0) {
            il.b.l("value == null || size < 0");
            return false;
        } else {
            this.f22298m0 = null;
            this.f36605s = true;
            boolean z11 = false;
            int i11 = 0;
            while (this.f36605s) {
                this.f36604r = false;
                if (i11 > 0) {
                    try {
                        il.b.d(this.f36587a, "re-send command just wait a while");
                        Thread.sleep(1000L);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                    if (!z10 && this.f36594h) {
                        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
                    }
                }
                z11 = Q(usbGatt, usbGattCharacteristic, bArr, i10);
                if (z11) {
                    synchronized (this.f36603q) {
                        try {
                            if (!this.f36604r && this.f36599m == 515) {
                                this.f36603q.wait(15000L);
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
    }

    public final boolean S(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic, byte[] bArr, boolean z10) {
        return R(usbGatt, usbGattCharacteristic, bArr, bArr != null ? bArr.length : -1, z10);
    }

    public boolean T(UsbGattCharacteristic usbGattCharacteristic, byte[] bArr, boolean z10) {
        return S(this.f22297l0, usbGattCharacteristic, bArr, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] U(UsbGatt usbGatt, UsbGattCharacteristic usbGattCharacteristic) {
        int i10;
        if (this.f36594h) {
            throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
        } else if (usbGatt == null) {
            il.b.l("gatt == null");
            return null;
        } else {
            this.C = 0;
            this.f36602p = null;
            this.f36601o = false;
            if (usbGatt.readCharacteristic(usbGattCharacteristic)) {
                synchronized (this.f36600n) {
                    try {
                        if (this.C == 0 && !this.f36601o && this.f36599m == 515) {
                            this.f36600n.wait(15000L);
                        }
                    } catch (InterruptedException e10) {
                        il.b.l("sleeping interrupted:" + e10);
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
            il.b.l("readCharacteristic failed");
            i10 = DfuException.ERROR_SEND_COMMAND_FAIL;
            this.C = i10;
            if (this.C != 0) {
            }
        }
    }

    public byte[] V(UsbGattCharacteristic usbGattCharacteristic) {
        return U(this.f22297l0, usbGattCharacteristic);
    }

    public void W(int i10) {
        int i11 = 16;
        if (i10 - 3 > 16) {
            i11 = 16 * (i10 / 16);
        }
        this.S = i11;
        il.b.c("> mBufferCheckMtuSize=" + this.S);
    }

    public void X(UsbGatt usbGatt) {
        int i10 = this.f36599m;
        if (i10 == 0 || i10 == 1280) {
            il.b.d(this.f36587a, "already disconnect");
        } else if (usbGatt != null) {
            G(1024);
            usbGatt.disconnect();
            I();
        } else {
            il.b.d(this.f36587a, "gatt == null");
            G(0);
        }
    }

    public void Y(int i10) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
        il.b.c(String.format("terminateConnection, error = 0x%04X", Integer.valueOf(i10)));
        UsbGatt usbGatt = this.f22297l0;
        if (usbGatt != null) {
            X(usbGatt);
            O(this.f22297l0, t().K(2));
            N(this.f22297l0);
        }
    }

    public boolean Z() {
        if (this.f22297l0 == null) {
            il.b.l("mUsbGatt == null");
            this.C = DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED;
            A();
            return false;
        } else if (this.f36594h) {
            il.b.l("task already aborted, ignore");
            return false;
        } else {
            il.b.d(this.f36587a, "Attempting to start service discovery...");
            boolean discoverServices = this.f22297l0.discoverServices();
            boolean z10 = this.f36587a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("discoverServices ");
            sb2.append(discoverServices ? "succeed" : "failed");
            il.b.d(z10, sb2.toString());
            if (!discoverServices) {
                this.C = DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED;
                A();
            }
            return discoverServices;
        }
    }

    @Override // xl.a
    public boolean f() {
        Handler handler = this.f22301p0;
        if (handler != null) {
            handler.removeCallbacks(this.f22302q0);
        }
        return super.f();
    }

    @Override // mm.a, xl.a
    public void x() {
        super.x();
        this.f22296k0 = GlobalUsbGatt.getInstance();
    }
}
