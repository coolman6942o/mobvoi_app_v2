package com.realsil.sdk.dfu;

import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.realsil.sdk.dfu.params.QcConfig;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Locale;
import ll.a;
/* loaded from: classes2.dex */
public class DfuService extends Service {

    /* renamed from: o  reason: collision with root package name */
    public static boolean f22165o = true;

    /* renamed from: a  reason: collision with root package name */
    public IBinder f22166a;

    /* renamed from: f  reason: collision with root package name */
    public xl.a f22171f;

    /* renamed from: g  reason: collision with root package name */
    public BluetoothManager f22172g;

    /* renamed from: h  reason: collision with root package name */
    public al.b f22173h;

    /* renamed from: k  reason: collision with root package name */
    public Throughput f22176k;

    /* renamed from: b  reason: collision with root package name */
    public String f22167b = "";

    /* renamed from: c  reason: collision with root package name */
    public RemoteCallbackList<ll.b> f22168c = new RemoteCallbackList<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, ll.b> f22169d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public int f22170e = 0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22174i = false;

    /* renamed from: j  reason: collision with root package name */
    public int f22175j = DfuException.ERROR_FILE_IO_EXCEPTION;

    /* renamed from: l  reason: collision with root package name */
    public Handler f22177l = new a(Looper.getMainLooper());

    /* renamed from: m  reason: collision with root package name */
    public al.a f22178m = new b();

    /* renamed from: n  reason: collision with root package name */
    public xl.b f22179n = new c();

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x000c, code lost:
            if (r0 != 4) goto L11;
         */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            int i10 = message.what;
            int i11 = 1;
            if (i10 != 1) {
                i11 = 2;
                if (i10 != 2) {
                    i11 = 3;
                    if (i10 != 3) {
                        i11 = 4;
                    }
                }
            }
            DfuService.this.d(i11, message.obj);
            super.handleMessage(message);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends al.a {
        public b() {
        }

        @Override // al.a
        public void d(BluetoothDevice bluetoothDevice, int i10) {
            super.d(bluetoothDevice, i10);
            if (DfuService.this.f22170e == 1 && i10 == 2 && DfuService.this.f22171f != null && (DfuService.this.f22171f instanceof zl.b)) {
                ((zl.b) DfuService.this.f22171f).K(bluetoothDevice, i10);
            }
        }

        @Override // al.a
        public void e(BluetoothDevice bluetoothDevice, int i10) {
            super.e(bluetoothDevice, i10);
            if (DfuService.this.f22170e == 0 && i10 == 2 && DfuService.this.f22171f != null && (DfuService.this.f22171f instanceof zl.b)) {
                ((zl.b) DfuService.this.f22171f).K(bluetoothDevice, i10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends xl.b {
        public c() {
        }

        @Override // xl.b
        public void a(int i10) {
            super.a(i10);
            DfuService.this.f22174i = false;
            if (DfuService.this.f22177l != null) {
                DfuService.this.f22177l.sendMessage(DfuService.this.f22177l.obtainMessage(2, Integer.valueOf(i10)));
            } else {
                il.b.k(false, "handle was not initialized");
            }
        }

        @Override // xl.b
        public void b(DfuProgressInfo dfuProgressInfo) {
            super.b(dfuProgressInfo);
            DfuService.this.f22176k = dfuProgressInfo.p();
            if (DfuService.this.f22177l != null) {
                DfuService.this.f22177l.sendMessage(DfuService.this.f22177l.obtainMessage(3, dfuProgressInfo));
            } else {
                il.b.k(false, "handle was not initialized");
            }
        }

        @Override // xl.b
        public void c(int i10, Throughput throughput) {
            super.c(i10, throughput);
            DfuService.this.f22175j = i10;
            DfuService.this.f22176k = throughput;
            DfuService dfuService = DfuService.this;
            dfuService.f22174i = (dfuService.f22175j & 512) == 512;
            if (DfuService.this.f22177l != null) {
                DfuService.this.f22177l.sendMessage(DfuService.this.f22177l.obtainMessage(1, Integer.valueOf(i10)));
            } else {
                il.b.k(false, "handle was not initialized");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends a.AbstractBinderC0385a {

        /* renamed from: a  reason: collision with root package name */
        public DfuService f22183a;

        public d(DfuService dfuService) {
            this.f22183a = dfuService;
        }

        @Override // ll.a
        public void T1(String str, ll.b bVar) {
            if (bVar != null) {
                il.b.j("unregisterCallback: " + str);
                DfuService.this.f22168c.unregister(bVar);
                DfuService.this.f22169d.remove(str);
            }
        }

        public final DfuService U1() {
            DfuService dfuService = this.f22183a;
            if (dfuService != null) {
                return dfuService;
            }
            return null;
        }

        @Override // ll.a
        public int a() {
            return DfuService.this.f22175j;
        }

        @Override // ll.a
        public boolean a(boolean z10) {
            DfuService U1 = U1();
            return U1 != null && U1.i(z10);
        }

        @Override // ll.a
        public Throughput b() {
            return DfuService.this.f22176k;
        }

        @Override // ll.a
        public boolean c() {
            DfuService U1 = U1();
            return U1 != null && U1.h();
        }

        @Override // android.os.Binder, android.os.IBinder
        public void dump(FileDescriptor fileDescriptor, String[] strArr) {
        }

        @Override // android.os.Binder, android.os.IBinder
        public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) {
        }

        @Override // android.os.Binder, android.os.IBinder
        public String getInterfaceDescriptor() {
            return null;
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean isBinderAlive() {
            return false;
        }

        @Override // ll.a
        public boolean k1(String str, DfuConfig dfuConfig, QcConfig qcConfig) {
            DfuService U1 = U1();
            return U1 != null && U1.p(str, dfuConfig, qcConfig);
        }

        @Override // android.os.Binder, android.os.IBinder
        public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i10) {
        }

        @Override // ll.a
        public boolean m2(String str, ll.b bVar) {
            if (bVar == null) {
                return false;
            }
            il.b.j("registerCallback: " + str);
            DfuService.this.f22168c.register(bVar);
            DfuService.this.f22169d.put(str, bVar);
            return DfuService.this.f22169d.get(str) != null;
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean pingBinder() {
            return false;
        }

        @Override // android.os.Binder, android.os.IBinder
        public IInterface queryLocalInterface(String str) {
            return null;
        }

        @Override // android.os.Binder, android.os.IBinder
        public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i10) {
            return false;
        }
    }

    public final void d(int i10, Object obj) {
        ll.b bVar = this.f22169d.get(this.f22167b);
        if (bVar != null) {
            this.f22168c.beginBroadcast();
            try {
            } catch (RemoteException e10) {
                il.b.e(e10.toString());
            }
            if (i10 == 1) {
                bVar.a(((Integer) obj).intValue());
            } else if (i10 != 2) {
                if (i10 == 3) {
                    bVar.P1((DfuProgressInfo) obj);
                }
                this.f22168c.finishBroadcast();
            } else {
                bVar.b(((Integer) obj).intValue());
            }
            this.f22168c.finishBroadcast();
        }
    }

    public final boolean f() {
        String str;
        if (this.f22172g == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.f22172g = bluetoothManager;
            if (bluetoothManager == null) {
                str = "Unable to initialize BluetoothManager.";
                il.b.l(str);
                return false;
            }
        }
        if (this.f22172g.getAdapter() == null) {
            str = "Unable to obtain a BluetoothAdapter.";
            il.b.l(str);
            return false;
        }
        boolean z10 = kl.b.f30015a;
        f22165o = z10;
        if (!z10) {
            return true;
        }
        il.b.j("initialize success");
        return true;
    }

    public boolean h() {
        xl.a aVar = this.f22171f;
        if (aVar == null) {
            return true;
        }
        aVar.f();
        return true;
    }

    public boolean i(boolean z10) {
        xl.a aVar = this.f22171f;
        return aVar != null && aVar.h(z10);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (f22165o) {
            il.b.j("onBind");
        }
        return this.f22166a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f22166a = new d(this);
        al.b g10 = al.b.g();
        this.f22173h = g10;
        if (g10 == null) {
            al.b.i(this);
            this.f22173h = al.b.g();
        }
        al.b bVar = this.f22173h;
        if (bVar != null) {
            bVar.b(this.f22178m);
        } else {
            il.b.c("BluetoothProfileManager not initialized");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (f22165o) {
            il.b.j("onDestroy()+");
        }
        this.f22174i = false;
        this.f22175j = DfuException.ERROR_FILE_IO_EXCEPTION;
        al.b bVar = this.f22173h;
        if (bVar != null) {
            bVar.l(this.f22178m);
        }
        if (f22165o) {
            il.b.j("onDestroy()-");
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (f22165o) {
            il.b.c("onUnbind");
        }
        return super.onUnbind(intent);
    }

    public boolean p(String str, DfuConfig dfuConfig, QcConfig qcConfig) {
        String str2;
        if (str == null) {
            str2 = "the packageName is null";
        } else if (dfuConfig == null) {
            str2 = "dfuConfig can not be null";
        } else {
            boolean z10 = this.f22174i;
            if (z10 && (this.f22175j & 512) == 512) {
                str2 = String.format(Locale.US, "isInOtaProcess=%b, mProcessState=0x%04X", Boolean.valueOf(z10), Integer.valueOf(this.f22175j));
            } else if (!f()) {
                str2 = "initialize failed";
            } else if (this.f22169d.get(str) == null) {
                str2 = "didn't find the special callback in the service";
            } else {
                this.f22175j = DfuException.ERROR_FILE_IO_EXCEPTION;
                this.f22176k = null;
                this.f22167b = str;
                int c10 = dfuConfig.c();
                this.f22170e = c10;
                il.b.j(String.format("channelType=0X%02X, protocolType=0X%04X,workMode=0x%02X", Integer.valueOf(c10), Integer.valueOf(dfuConfig.A()), Integer.valueOf(dfuConfig.v())));
                xl.a a10 = yl.a.a(this, dfuConfig, qcConfig, this.f22179n);
                this.f22171f = a10;
                if (a10 == null) {
                    return false;
                }
                a10.start();
                return true;
            }
        }
        il.b.l(str2);
        return false;
    }
}
