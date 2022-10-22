package cl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import com.mobvoi.wear.common.base.WearPath;
import com.realsil.sdk.dfu.DfuException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: p  reason: collision with root package name */
    public static final UUID f5953p = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* renamed from: a  reason: collision with root package name */
    public boolean f5954a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5955b;

    /* renamed from: c  reason: collision with root package name */
    public BluetoothAdapter f5956c;

    /* renamed from: d  reason: collision with root package name */
    public int f5957d;

    /* renamed from: e  reason: collision with root package name */
    public BluetoothDevice f5958e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5959f;

    /* renamed from: g  reason: collision with root package name */
    public xk.a f5960g;

    /* renamed from: h  reason: collision with root package name */
    public cl.b f5961h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5962i;

    /* renamed from: j  reason: collision with root package name */
    public int f5963j;

    /* renamed from: k  reason: collision with root package name */
    public UUID f5964k;

    /* renamed from: l  reason: collision with root package name */
    public b f5965l;

    /* renamed from: m  reason: collision with root package name */
    public c f5966m;

    /* renamed from: n  reason: collision with root package name */
    public C0086a f5967n;

    /* renamed from: o  reason: collision with root package name */
    public int f5968o;

    /* renamed from: cl.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0086a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final BluetoothServerSocket f5969a;

        public C0086a(boolean z10) {
            this.f5969a = a(z10);
            a.this.b(a.this.f5958e, DfuException.ERROR_FILE_IO_EXCEPTION);
        }

        public final BluetoothServerSocket a(boolean z10) {
            BluetoothServerSocket bluetoothServerSocket;
            try {
                if (z10) {
                    a aVar = a.this;
                    bluetoothServerSocket = aVar.f5956c.listenUsingRfcommWithServiceRecord("RtkSppSecure", aVar.f5964k);
                } else {
                    a aVar2 = a.this;
                    bluetoothServerSocket = aVar2.f5956c.listenUsingInsecureRfcommWithServiceRecord("RtkSppInsecure", aVar2.f5964k);
                }
                return bluetoothServerSocket;
            } catch (IOException e10) {
                il.b.c("createServerSocket failed: " + e10.toString());
                return null;
            }
        }

        public void b() {
            try {
                if (this.f5969a != null) {
                    il.b.k(a.this.f5954a, "cancel AcceptThread");
                    this.f5969a.close();
                }
            } catch (IOException e10) {
                il.b.l("close() of server failed： " + e10);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            il.b.k(a.this.f5954a, "BEGIN mAcceptThread");
            setName("AcceptThread:BluetoothSpp");
            while (a.this.f5957d != 512) {
                try {
                    BluetoothSocket accept = this.f5969a.accept();
                    if (accept != null) {
                        synchronized (a.this) {
                            a aVar = a.this;
                            int i10 = aVar.f5957d;
                            if (i10 == 0 || i10 == 512) {
                                try {
                                    accept.close();
                                } catch (IOException e10) {
                                    il.b.l("Could not close unwanted socket： " + e10);
                                }
                            } else if (i10 == 256 || i10 == 257) {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    aVar.f5968o = accept.getConnectionType();
                                }
                                a.this.i(accept, accept.getRemoteDevice());
                            }
                        }
                    }
                } catch (IOException e11) {
                    il.b.l("accept() failed" + e11);
                    a aVar2 = a.this;
                    aVar2.b(aVar2.f5958e, 0);
                }
            }
            il.b.d(a.this.f5954a, "END AcceptThread");
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public BluetoothSocket f5971a;

        /* renamed from: b  reason: collision with root package name */
        public final BluetoothDevice f5972b;

        public b(BluetoothDevice bluetoothDevice, boolean z10) {
            this.f5972b = bluetoothDevice;
            this.f5971a = a(bluetoothDevice, z10);
        }

        public final BluetoothSocket a(BluetoothDevice bluetoothDevice, boolean z10) {
            BluetoothSocket bluetoothSocket;
            boolean z11 = a.this.f5954a;
            il.b.k(z11, "mSecureUuid=" + a.this.f5964k);
            try {
                bluetoothSocket = z10 ? bluetoothDevice.createRfcommSocketToServiceRecord(a.this.f5964k) : bluetoothDevice.createInsecureRfcommSocketToServiceRecord(a.this.f5964k);
            } catch (IOException e10) {
                il.b.l("createBluetoothSocket failed: " + e10.toString());
                bluetoothSocket = null;
            }
            if (bluetoothSocket != null && Build.VERSION.SDK_INT >= 23) {
                a.this.f5968o = bluetoothSocket.getConnectionType();
            }
            return bluetoothSocket;
        }

        public void b() {
            try {
                BluetoothSocket bluetoothSocket = this.f5971a;
                if (bluetoothSocket != null) {
                    bluetoothSocket.close();
                }
            } catch (IOException e10) {
                il.b.l("close socket failed: " + e10);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a aVar;
            setName("ConnectThread:BluetoothSpp");
            if (a.this.f5955b) {
                il.b.j("SocketConnectionType: " + a.this.f5968o);
            }
            BluetoothAdapter bluetoothAdapter = a.this.f5956c;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.cancelDiscovery();
            }
            BluetoothSocket bluetoothSocket = this.f5971a;
            if (bluetoothSocket == null) {
                il.b.l("create BluetoothSocket fail");
                a aVar2 = a.this;
                aVar2.b(aVar2.f5958e, 0);
                return;
            }
            try {
                if (bluetoothSocket.isConnected()) {
                    il.b.d(a.this.f5954a, "socket already connected");
                } else {
                    a aVar3 = a.this;
                    aVar3.b(aVar3.f5958e, 256);
                    il.b.k(a.this.f5955b, "connect socket ...");
                    this.f5971a.connect();
                }
                synchronized (a.this) {
                    aVar = a.this;
                    aVar.f5965l = null;
                }
                aVar.i(this.f5971a, this.f5972b);
            } catch (IOException e10) {
                il.b.l(e10.toString());
                try {
                    this.f5971a.close();
                } catch (IOException e11) {
                    il.b.l("unable to close socket during connection failure: " + e11);
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e12) {
                    e12.printStackTrace();
                }
                if ("Connect refused".equals(e10.getMessage())) {
                    if (this.f5972b.getBondState() == 12) {
                        this.f5971a = a(this.f5972b, false);
                    }
                    BluetoothSocket bluetoothSocket2 = this.f5971a;
                    if (bluetoothSocket2 == null) {
                        il.b.c("create Insecure BluetoothSocket fail");
                        a aVar4 = a.this;
                        aVar4.b(aVar4.f5958e, 0);
                        return;
                    }
                    try {
                        if (bluetoothSocket2.isConnected()) {
                            il.b.c("socket already connected");
                        } else {
                            a aVar5 = a.this;
                            aVar5.b(aVar5.f5958e, 256);
                            il.b.k(a.this.f5955b, "connect socket ...");
                            this.f5971a.connect();
                        }
                        return;
                    } catch (IOException e13) {
                        il.b.c(e13.toString());
                        try {
                            this.f5971a.close();
                        } catch (IOException e14) {
                            il.b.l("unable to close socket during connection failure: " + e14);
                        }
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e15) {
                            e15.printStackTrace();
                        }
                        a.c(a.this);
                    }
                }
                a.c(a.this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final BluetoothSocket f5974a;

        /* renamed from: b  reason: collision with root package name */
        public BufferedInputStream f5975b;

        /* renamed from: c  reason: collision with root package name */
        public BufferedOutputStream f5976c;

        public c(BluetoothSocket bluetoothSocket) {
            BufferedInputStream bufferedInputStream;
            IOException e10;
            BufferedOutputStream bufferedOutputStream = null;
            this.f5975b = null;
            this.f5976c = null;
            il.b.c("create ConnectedThread");
            this.f5974a = bluetoothSocket;
            try {
                bufferedInputStream = new BufferedInputStream(bluetoothSocket.getInputStream());
            } catch (IOException e11) {
                e10 = e11;
                bufferedInputStream = null;
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(bluetoothSocket.getOutputStream());
            } catch (IOException e12) {
                e10 = e12;
                il.b.l("temp sockets not created: " + e10);
                this.f5975b = bufferedInputStream;
                this.f5976c = bufferedOutputStream;
            }
            this.f5975b = bufferedInputStream;
            this.f5976c = bufferedOutputStream;
        }

        public void a() {
            BluetoothSocket bluetoothSocket = this.f5974a;
            if (bluetoothSocket != null) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e10) {
                    il.b.l("close socket failed: " + e10);
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[1024];
            a aVar = a.this;
            aVar.b(aVar.f5958e, 512);
            while (!Thread.currentThread().isInterrupted() && a.this.f5957d == 512) {
                try {
                    int read = this.f5975b.read(bArr);
                    if (read > 0) {
                        byte[] bArr2 = new byte[read];
                        System.arraycopy(bArr, 0, bArr2, 0, read);
                        if (a.this.f5954a) {
                            il.b.c(String.format(Locale.US, ">> (%d) %s", Integer.valueOf(read), jl.a.a(bArr2)));
                        }
                        cl.b bVar = a.this.f5961h;
                        if (bVar != null) {
                            bVar.b(bArr2);
                        }
                    }
                } catch (IOException e10) {
                    il.b.l(e10.toString());
                    a aVar2 = a.this;
                    il.b.k(aVar2.f5954a, "connectionLost");
                    aVar2.b(aVar2.f5958e, 0);
                    aVar2.f5958e = null;
                    aVar2.k();
                }
            }
            if (a.this.f5957d == 768) {
                a();
                a aVar3 = a.this;
                il.b.k(aVar3.f5954a, "connectionLost");
                aVar3.b(aVar3.f5958e, 0);
                aVar3.f5958e = null;
                aVar3.k();
            }
        }
    }

    public a(int i10, UUID uuid, cl.b bVar) {
        this.f5954a = false;
        this.f5955b = false;
        this.f5957d = 0;
        this.f5958e = null;
        this.f5959f = false;
        this.f5963j = 1;
        this.f5964k = f5953p;
        this.f5968o = -1;
        this.f5963j = i10;
        this.f5964k = uuid;
        this.f5961h = bVar;
        this.f5957d = 0;
        this.f5954a = wk.b.f36299b;
        this.f5955b = wk.b.f36300c;
        f();
    }

    public a(cl.b bVar) {
        this(1, f5953p, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0066, code lost:
        if (r0 == 2) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(a aVar) {
        boolean z10;
        String format;
        if (aVar.f5959f) {
            aVar.f5959f = false;
            BluetoothDevice bluetoothDevice = aVar.f5958e;
            boolean z11 = true;
            if (bluetoothDevice == null) {
                z10 = aVar.f5955b;
                format = "mDevice == null";
            } else {
                int i10 = aVar.f5957d;
                if (i10 != 256) {
                    z10 = aVar.f5955b;
                    format = String.format("mConnectionState=0x%04X", Integer.valueOf(i10));
                } else {
                    int bondState = bluetoothDevice.getBondState();
                    il.b.k(aVar.f5955b, String.format("bondState=0x%02X", Integer.valueOf(bondState)));
                    if (bondState == 12) {
                        int f10 = al.b.g().f(1, aVar.f5958e);
                        il.b.k(aVar.f5955b, String.format("hfpState=0x%02X", Integer.valueOf(f10)));
                    }
                    z11 = false;
                    if (z11) {
                        aVar.f5959f = false;
                        il.b.k(aVar.f5955b, "processAbnormalDisconnection ..");
                        aVar.e(aVar.f5960g);
                        return;
                    }
                }
            }
            il.b.k(z10, format);
            z11 = false;
            if (z11) {
            }
        }
        il.b.k(aVar.f5954a, "connectionFailed");
        aVar.b(aVar.f5958e, 0);
        aVar.f5958e = null;
        aVar.k();
    }

    public final void a() {
        b bVar = this.f5965l;
        if (bVar != null) {
            bVar.b();
            this.f5965l.interrupt();
            this.f5965l = null;
        }
        c cVar = this.f5966m;
        if (cVar != null) {
            cVar.a();
            this.f5966m.interrupt();
            this.f5966m = null;
        }
    }

    public final synchronized void b(BluetoothDevice bluetoothDevice, int i10) {
        int i11 = this.f5957d;
        if (i10 != i11) {
            il.b.j(String.format(Locale.US, ">> ConnectionState=0x%04X > 0x%04X", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
        this.f5957d = i10;
        cl.b bVar = this.f5961h;
        if (bVar != null) {
            bVar.a(bluetoothDevice, true, i10);
        } else {
            il.b.k(this.f5955b, "no callback registered");
        }
    }

    public final boolean e(xk.a aVar) {
        this.f5960g = aVar;
        this.f5958e = aVar.f36584a;
        this.f5964k = aVar.f36586c;
        if (!this.f5962i) {
            f();
        }
        BluetoothSocket bluetoothSocket = aVar.f36585b;
        if (bluetoothSocket != null) {
            i(bluetoothSocket, aVar.f36584a);
        } else {
            a();
            b bVar = new b(this.f5958e, true);
            this.f5965l = bVar;
            bVar.start();
        }
        return true;
    }

    public final void f() {
        il.b.k(this.f5954a, "initialize...");
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.f5956c = defaultAdapter;
        if (defaultAdapter == null) {
            il.b.c("bluetoothAdapter not initialized ");
            this.f5962i = false;
        } else if (!defaultAdapter.isEnabled()) {
            il.b.c("bluetooth is disabled");
            this.f5962i = false;
        } else {
            this.f5962i = true;
        }
    }

    public synchronized boolean g(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, UUID uuid) {
        uuid = xk.a.f36583d;
        if (uuid != null) {
        }
        return h(new xk.a(bluetoothDevice, bluetoothSocket, uuid, false));
    }

    public synchronized boolean h(xk.a aVar) {
        if (aVar == null) {
            il.b.j("connParameters can not be null or empty");
            return false;
        }
        BluetoothDevice bluetoothDevice = aVar.f36584a;
        if (bluetoothDevice == null) {
            il.b.j("device can not be null or empty");
            return false;
        }
        BluetoothDevice bluetoothDevice2 = this.f5958e;
        if (bluetoothDevice2 != null) {
            if (bluetoothDevice2.equals(bluetoothDevice)) {
                int i10 = this.f5957d;
                if (i10 == 512) {
                    il.b.k(this.f5954a, "device already connected");
                    b(this.f5958e, 512);
                    return true;
                } else if (i10 == 256) {
                    il.b.k(this.f5954a, "device is already at connecting state");
                    b(this.f5958e, 256);
                    return true;
                }
            } else {
                int i11 = this.f5957d;
                if (i11 == 512) {
                    il.b.k(this.f5954a, "device already connected");
                    a();
                    return false;
                } else if (i11 == 256) {
                    il.b.k(this.f5954a, "device is already at connecting state");
                    a();
                    return false;
                }
            }
        }
        this.f5959f = true;
        e(aVar);
        return true;
    }

    public synchronized void i(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        il.b.k(this.f5954a, "spp connected");
        this.f5958e = bluetoothDevice;
        a();
        C0086a aVar = this.f5967n;
        if (aVar != null) {
            aVar.b();
            this.f5967n = null;
        }
        c cVar = new c(bluetoothSocket);
        this.f5966m = cVar;
        cVar.start();
    }

    public boolean j(BluetoothDevice bluetoothDevice) {
        BluetoothDevice bluetoothDevice2 = this.f5958e;
        return bluetoothDevice2 != null && bluetoothDevice2.equals(bluetoothDevice) && this.f5957d == 512;
    }

    public synchronized void k() {
        l(true);
    }

    public synchronized void l(boolean z10) {
        boolean z11 = this.f5954a;
        il.b.k(z11, "start secure: " + z10);
        b bVar = this.f5965l;
        if (bVar != null) {
            bVar.b();
            this.f5965l.interrupt();
            this.f5965l = null;
        }
        c cVar = this.f5966m;
        if (cVar != null) {
            cVar.a();
            this.f5966m.interrupt();
            this.f5966m = null;
        }
        if ((this.f5963j & 2) == 2 && this.f5967n == null) {
            C0086a aVar = new C0086a(z10);
            this.f5967n = aVar;
            aVar.start();
        }
    }

    public synchronized void m() {
        il.b.k(this.f5954a, WearPath.MediaControls.CONTROLL_COMMAND_STOP);
        if (this.f5957d == 512) {
            b(this.f5958e, 768);
        }
        this.f5958e = null;
        b bVar = this.f5965l;
        if (bVar != null) {
            bVar.b();
            this.f5965l.interrupt();
            this.f5965l = null;
        }
        c cVar = this.f5966m;
        if (cVar != null) {
            cVar.a();
            this.f5966m.interrupt();
            this.f5966m = null;
        }
        C0086a aVar = this.f5967n;
        if (aVar != null) {
            aVar.b();
            this.f5967n.interrupt();
            this.f5967n = null;
        }
    }

    public boolean n(byte[] bArr) {
        return o(bArr, true);
    }

    public boolean o(byte[] bArr, boolean z10) {
        synchronized (this) {
            if (this.f5957d != 512) {
                il.b.d(this.f5954a, "not connected");
                return false;
            }
            c cVar = this.f5966m;
            if (cVar == null) {
                il.b.c("ConnectedThread not created");
                return false;
            } else if (cVar.f5976c == null) {
                return false;
            } else {
                try {
                    if (a.this.f5954a) {
                        il.b.c(String.format(Locale.US, "<< (%d) %s", Integer.valueOf(bArr.length), jl.a.a(bArr)));
                    }
                    cVar.f5976c.write(bArr);
                    if (z10) {
                        cVar.f5976c.flush();
                    }
                    return true;
                } catch (IOException e10) {
                    il.b.l("Exception during write： " + e10);
                    return false;
                }
            }
        }
    }
}
