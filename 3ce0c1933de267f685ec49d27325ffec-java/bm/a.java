package bm;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import bm.f;
import cm.d;
import cm.e;
import com.tendcloud.tenddata.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public abstract class a implements f {

    /* renamed from: d  reason: collision with root package name */
    public int f5209d;

    /* renamed from: e  reason: collision with root package name */
    public BluetoothGatt f5210e;

    /* renamed from: f  reason: collision with root package name */
    public BluetoothGattService f5211f;

    /* renamed from: g  reason: collision with root package name */
    public BluetoothGattService f5212g;

    /* renamed from: h  reason: collision with root package name */
    public BluetoothGattCharacteristic f5213h;

    /* renamed from: i  reason: collision with root package name */
    public BluetoothGattCharacteristic f5214i;

    /* renamed from: j  reason: collision with root package name */
    public List<BluetoothGattCharacteristic> f5215j;

    /* renamed from: k  reason: collision with root package name */
    public d f5216k;

    /* renamed from: m  reason: collision with root package name */
    public String f5218m;

    /* renamed from: n  reason: collision with root package name */
    public c f5219n;

    /* renamed from: o  reason: collision with root package name */
    public lm.b f5220o;

    /* renamed from: q  reason: collision with root package name */
    public b f5222q;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5206a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5207b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5208c = false;

    /* renamed from: l  reason: collision with root package name */
    public List<e> f5217l = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    public int f5221p = 1;

    /* renamed from: r  reason: collision with root package name */
    public final BluetoothGattCallback f5223r = new C0075a();

    /* renamed from: s  reason: collision with root package name */
    public Object f5224s = new Object();

    /* renamed from: t  reason: collision with root package name */
    public boolean f5225t = true;

    /* renamed from: u  reason: collision with root package name */
    public int f5226u = 0;

    /* renamed from: v  reason: collision with root package name */
    public Object f5227v = new Object();

    /* renamed from: bm.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0075a extends BluetoothGattCallback {
        public C0075a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            a.this.c(bluetoothGatt, bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            a.this.d(bluetoothGatt, bluetoothGattCharacteristic, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (i10 == 0 && i11 == 0 && a.this.m()) {
                a.this.l(2);
                a.this.q();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i10);
            try {
                il.b.j("onDescriptorWrite: " + i10);
                synchronized (a.this.f5224s) {
                    a.this.f5225t = true;
                    a.this.f5224s.notifyAll();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                il.b.e(e10.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Thread {
        public b() {
        }

        public /* synthetic */ b(a aVar, C0075a aVar2) {
            this();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            setName("AdapterXGBase-DeviceInfoThread");
            a.this.p();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(int i10);
    }

    public void b() {
        b bVar = this.f5222q;
        if (bVar != null) {
            bVar.interrupt();
            this.f5222q = null;
        }
        this.f5226u = 0;
        al.c.k().p(this.f5218m, this.f5223r);
    }

    public void c(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
    }

    public void d(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
    }

    public void e(String str, BluetoothGatt bluetoothGatt, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2) {
        il.b.j("sync data ...");
        this.f5218m = str;
        this.f5210e = bluetoothGatt;
        this.f5211f = bluetoothGattService;
        this.f5212g = bluetoothGattService2;
        n();
        o();
        b bVar = new b(this, null);
        this.f5222q = bVar;
        bVar.start();
    }

    public void f(lm.b bVar, String str, BluetoothGatt bluetoothGatt, BluetoothGattService bluetoothGattService, BluetoothGattService bluetoothGattService2, c cVar) {
        boolean z10 = kl.b.f30015a;
        this.f5207b = z10;
        this.f5206a = z10;
        this.f5208c = kl.b.f30016b;
        this.f5220o = bVar;
        this.f5218m = str;
        this.f5210e = al.c.k().i(str);
        this.f5211f = bluetoothGattService;
        this.f5212g = bluetoothGattService2;
        this.f5219n = cVar;
        this.f5217l = new ArrayList();
        this.f5215j = new ArrayList();
        lm.b bVar2 = this.f5220o;
        this.f5221p = bVar2 != null ? bVar2.b() : 1;
        n();
        o();
        al.c.k().o(this.f5218m, this.f5223r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r4.length > 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
        r4 = r0.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r4.length > 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(byte[] bArr) {
        short s10;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        if (this.f5221p != 1) {
            if (bArr.length >= 2) {
                s10 = wrap.getShort();
            }
        }
        boolean z10 = this.f5207b;
        il.b.k(z10, "current battery: " + ((int) s10));
        k().f0(s10);
    }

    public boolean h(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) {
        String str;
        StringBuilder sb2;
        int properties = bluetoothGattCharacteristic.getProperties();
        if ((properties & 16) == 0) {
            il.b.l("check properties failed: " + properties);
            this.f5225t = false;
            return false;
        }
        if (this.f5206a) {
            sb2 = new StringBuilder();
            sb2.append("setCharacteristicNotification() - uuid: ");
            sb2.append(bluetoothGattCharacteristic.getUuid());
            str = " enabled: ";
        } else {
            sb2 = new StringBuilder();
            str = "setCharacteristicNotification()  enabled: ";
        }
        sb2.append(str);
        sb2.append(z10);
        il.b.j(sb2.toString());
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z10);
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(f.Y);
        if (descriptor != null) {
            boolean z11 = descriptor.getValue() != null && descriptor.getValue().length == 2 && descriptor.getValue()[0] > 0 && descriptor.getValue()[1] == 0;
            boolean z12 = this.f5206a;
            il.b.k(z12, "current cccd state: " + z11);
            if (z10 && z11) {
                this.f5225t = true;
                il.b.l("cccd already enabled");
                return true;
            } else if (z10 || z11) {
                descriptor.setValue(z10 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                if (bluetoothGatt.writeDescriptor(descriptor)) {
                    synchronized (this.f5224s) {
                        il.b.c("wait write Characteristic Notification 15000ms");
                        try {
                            this.f5225t = false;
                            this.f5224s.wait(ab.Y);
                        } catch (InterruptedException e10) {
                            il.b.e("wait writeDescriptor interrupted: " + e10.toString());
                        }
                    }
                    return this.f5225t;
                }
            } else {
                il.b.l("cccd already disable");
                this.f5225t = true;
                return true;
            }
        }
        return false;
    }

    public boolean i(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str;
        if (this.f5210e == null) {
            str = "mBluetoothGatt is null maybe disconnected just now";
        } else if (bluetoothGattCharacteristic == null) {
            str = "characteristic can not be null";
        } else {
            if (this.f5206a) {
                il.b.j(String.format(Locale.US, "readCharacteristic:(%d) %s", Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()), bluetoothGattCharacteristic.getUuid().toString()));
            }
            if (this.f5210e.readCharacteristic(bluetoothGattCharacteristic)) {
                r();
                return this.f5226u != 2;
            }
            str = "readCharacteristic failed";
        }
        il.b.l(str);
        return false;
    }

    public d k() {
        if (this.f5216k == null) {
            this.f5216k = new d(this.f5209d, 2);
        }
        return this.f5216k;
    }

    public void l(int i10) {
        il.b.c(String.format("syndata: 0x%04X >> 0x%04X", Integer.valueOf(this.f5226u), Integer.valueOf(i10)));
        this.f5226u = i10;
        c cVar = this.f5219n;
        if (cVar != null) {
            cVar.a(i10);
        } else {
            il.b.k(this.f5208c, "no callback registered");
        }
    }

    public boolean m() {
        return (this.f5226u & 256) == 256;
    }

    public final void n() {
        BluetoothGatt bluetoothGatt = this.f5210e;
        UUID uuid = f.a.f5258a;
        BluetoothGattService service = bluetoothGatt.getService(uuid);
        if (service == null) {
            il.b.k(this.f5207b, "BATTERY_SERVICE not found");
            return;
        }
        if (this.f5208c) {
            il.b.j("find BATTERY_SERVICE: " + uuid.toString());
        }
        UUID uuid2 = f.a.f5259b;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
        this.f5213h = characteristic;
        if (characteristic == null) {
            il.b.k(this.f5207b, "BAS_READ_CHARACTERITIC not found");
        } else if (this.f5206a) {
            il.b.j("find BAS_READ_CHARACTERITIC: " + uuid2.toString());
        }
    }

    public final void o() {
        UUID uuid;
        UUID uuid2;
        String str;
        BluetoothGattService service = this.f5210e.getService(f.b.f5260a);
        if (service == null) {
            il.b.j("DEVICE_INFORMATION_SERVICE not found");
            return;
        }
        il.b.c("find DEVICE_INFORMATION_SERVICE: " + uuid.toString());
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(f.b.f5261b);
        this.f5214i = characteristic;
        if (characteristic == null) {
            str = "DIS_PNP_ID_CHARACTERISTIC not found";
        } else {
            str = "find DIS_PNP_ID_CHARACTERISTIC: " + uuid2.toString();
        }
        il.b.c(str);
    }

    public void p() {
    }

    public void q() {
        synchronized (this.f5227v) {
            if (this.f5208c) {
                il.b.j("triggleSyncLock");
            }
            this.f5227v.notifyAll();
        }
    }

    public void r() {
        synchronized (this.f5227v) {
            try {
                if (this.f5208c) {
                    il.b.j("waitSyncLock");
                }
                this.f5227v.wait(6000L);
            } catch (InterruptedException e10) {
                il.b.l("wait sync data interrupted: " + e10.toString());
            }
        }
    }
}
