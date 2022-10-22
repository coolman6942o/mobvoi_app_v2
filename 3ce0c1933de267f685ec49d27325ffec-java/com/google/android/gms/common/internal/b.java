package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.h;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class b<T extends IInterface> {
    private static final Feature[] A = new Feature[0];

    /* renamed from: a  reason: collision with root package name */
    private int f8894a;

    /* renamed from: b  reason: collision with root package name */
    private long f8895b;

    /* renamed from: c  reason: collision with root package name */
    private long f8896c;

    /* renamed from: d  reason: collision with root package name */
    private int f8897d;

    /* renamed from: e  reason: collision with root package name */
    private long f8898e;

    /* renamed from: f  reason: collision with root package name */
    private w f8899f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f8900g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.gms.common.internal.e f8901h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.gms.common.c f8902i;

    /* renamed from: j  reason: collision with root package name */
    final Handler f8903j;

    /* renamed from: k  reason: collision with root package name */
    private final Object f8904k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f8905l;

    /* renamed from: m  reason: collision with root package name */
    private com.google.android.gms.common.internal.j f8906m;

    /* renamed from: n  reason: collision with root package name */
    protected c f8907n;

    /* renamed from: o  reason: collision with root package name */
    private T f8908o;

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList<h<?>> f8909p;

    /* renamed from: q  reason: collision with root package name */
    private j f8910q;

    /* renamed from: r  reason: collision with root package name */
    private int f8911r;

    /* renamed from: s  reason: collision with root package name */
    private final a f8912s;

    /* renamed from: t  reason: collision with root package name */
    private final AbstractC0108b f8913t;

    /* renamed from: u  reason: collision with root package name */
    private final int f8914u;

    /* renamed from: v  reason: collision with root package name */
    private final String f8915v;

    /* renamed from: w  reason: collision with root package name */
    private ConnectionResult f8916w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f8917x;

    /* renamed from: y  reason: collision with root package name */
    private volatile zzb f8918y;

    /* renamed from: z  reason: collision with root package name */
    protected AtomicInteger f8919z;

    /* loaded from: classes.dex */
    public interface a {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i10);
    }

    /* renamed from: com.google.android.gms.common.internal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0108b {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    protected class d implements c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.b.c
        public void a(ConnectionResult connectionResult) {
            if (connectionResult.K0()) {
                b bVar = b.this;
                bVar.g(null, bVar.F());
            } else if (b.this.f8913t != null) {
                b.this.f8913t.onConnectionFailed(connectionResult);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes.dex */
    private abstract class f extends h<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        private final int f8921d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f8922e;

        protected f(int i10, Bundle bundle) {
            super(Boolean.TRUE);
            this.f8921d = i10;
            this.f8922e = bundle;
        }

        @Override // com.google.android.gms.common.internal.b.h
        protected final /* synthetic */ void c(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                b.this.U(1, null);
                return;
            }
            int i10 = this.f8921d;
            if (i10 != 0) {
                if (i10 != 10) {
                    b.this.U(1, null);
                    Bundle bundle = this.f8922e;
                    if (bundle != null) {
                        pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
                    }
                    f(new ConnectionResult(this.f8921d, pendingIntent));
                    return;
                }
                b.this.U(1, null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), b.this.v(), b.this.m()));
            } else if (!g()) {
                b.this.U(1, null);
                f(new ConnectionResult(8, null));
            }
        }

        @Override // com.google.android.gms.common.internal.b.h
        protected final void d() {
        }

        protected abstract void f(ConnectionResult connectionResult);

        protected abstract boolean g();
    }

    /* loaded from: classes.dex */
    final class g extends r6.d {
        public g(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.d();
            hVar.b();
        }

        private static boolean b(Message message) {
            int i10 = message.what;
            return i10 == 2 || i10 == 1 || i10 == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (b.this.f8919z.get() == message.arg1) {
                int i10 = message.what;
                if ((i10 == 1 || i10 == 7 || ((i10 == 4 && !b.this.z()) || message.what == 5)) && !b.this.h()) {
                    a(message);
                    return;
                }
                int i11 = message.what;
                PendingIntent pendingIntent = null;
                if (i11 == 4) {
                    b.this.f8916w = new ConnectionResult(message.arg2);
                    if (!b.this.k0() || b.this.f8917x) {
                        if (b.this.f8916w != null) {
                            connectionResult2 = b.this.f8916w;
                        } else {
                            connectionResult2 = new ConnectionResult(8);
                        }
                        b.this.f8907n.a(connectionResult2);
                        b.this.J(connectionResult2);
                        return;
                    }
                    b.this.U(3, null);
                } else if (i11 == 5) {
                    if (b.this.f8916w != null) {
                        connectionResult = b.this.f8916w;
                    } else {
                        connectionResult = new ConnectionResult(8);
                    }
                    b.this.f8907n.a(connectionResult);
                    b.this.J(connectionResult);
                } else if (i11 == 3) {
                    Object obj = message.obj;
                    if (obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) obj;
                    }
                    ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                    b.this.f8907n.a(connectionResult3);
                    b.this.J(connectionResult3);
                } else if (i11 == 6) {
                    b.this.U(5, null);
                    if (b.this.f8912s != null) {
                        b.this.f8912s.onConnectionSuspended(message.arg2);
                    }
                    b.this.K(message.arg2);
                    b.this.Z(5, 1, null);
                } else if (i11 == 2 && !b.this.isConnected()) {
                    a(message);
                } else if (b(message)) {
                    ((h) message.obj).e();
                } else {
                    int i12 = message.what;
                    StringBuilder sb2 = new StringBuilder(45);
                    sb2.append("Don't know how to handle message: ");
                    sb2.append(i12);
                    Log.wtf("GmsClient", sb2.toString(), new Exception());
                }
            } else if (b(message)) {
                a(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public abstract class h<TListener> {

        /* renamed from: a  reason: collision with root package name */
        private TListener f8925a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8926b = false;

        public h(TListener tlistener) {
            this.f8925a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.f8925a = null;
            }
        }

        public final void b() {
            a();
            synchronized (b.this.f8909p) {
                b.this.f8909p.remove(this);
            }
        }

        protected abstract void c(TListener tlistener);

        protected abstract void d();

        public final void e() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f8925a;
                if (this.f8926b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 47);
                    sb2.append("Callback proxy ");
                    sb2.append(valueOf);
                    sb2.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb2.toString());
                }
            }
            if (tlistener != null) {
                try {
                    c(tlistener);
                } catch (RuntimeException e10) {
                    d();
                    throw e10;
                }
            } else {
                d();
            }
            synchronized (this) {
                this.f8926b = true;
            }
            b();
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends h.a {

        /* renamed from: a  reason: collision with root package name */
        private b f8928a;

        /* renamed from: b  reason: collision with root package name */
        private final int f8929b;

        public i(b bVar, int i10) {
            this.f8928a = bVar;
            this.f8929b = i10;
        }

        @Override // com.google.android.gms.common.internal.h
        public final void A0(int i10, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.h
        public final void J0(int i10, IBinder iBinder, Bundle bundle) {
            b6.i.l(this.f8928a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f8928a.L(i10, iBinder, bundle, this.f8929b);
            this.f8928a = null;
        }

        @Override // com.google.android.gms.common.internal.h
        public final void q0(int i10, IBinder iBinder, zzb zzbVar) {
            b6.i.l(this.f8928a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            b6.i.k(zzbVar);
            this.f8928a.Y(zzbVar);
            J0(i10, iBinder, zzbVar.f8969a);
        }
    }

    /* loaded from: classes.dex */
    public final class j implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final int f8930a;

        public j(int i10) {
            this.f8930a = i10;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.google.android.gms.common.internal.j jVar;
            if (iBinder == null) {
                b.this.b0(16);
                return;
            }
            synchronized (b.this.f8905l) {
                b bVar = b.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof com.google.android.gms.common.internal.j)) {
                    jVar = new com.google.android.gms.common.internal.i(iBinder);
                } else {
                    jVar = (com.google.android.gms.common.internal.j) queryLocalInterface;
                }
                bVar.f8906m = jVar;
            }
            b.this.T(0, null, this.f8930a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (b.this.f8905l) {
                b.this.f8906m = null;
            }
            Handler handler = b.this.f8903j;
            handler.sendMessage(handler.obtainMessage(6, this.f8930a, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class k extends f {

        /* renamed from: g  reason: collision with root package name */
        private final IBinder f8932g;

        public k(int i10, IBinder iBinder, Bundle bundle) {
            super(i10, bundle);
            this.f8932g = iBinder;
        }

        @Override // com.google.android.gms.common.internal.b.f
        protected final void f(ConnectionResult connectionResult) {
            if (b.this.f8913t != null) {
                b.this.f8913t.onConnectionFailed(connectionResult);
            }
            b.this.J(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.b.f
        protected final boolean g() {
            try {
                String interfaceDescriptor = this.f8932g.getInterfaceDescriptor();
                if (!b.this.m().equals(interfaceDescriptor)) {
                    String m10 = b.this.m();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(m10).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb2.append("service descriptor mismatch: ");
                    sb2.append(m10);
                    sb2.append(" vs. ");
                    sb2.append(interfaceDescriptor);
                    Log.e("GmsClient", sb2.toString());
                    return false;
                }
                IInterface n10 = b.this.n(this.f8932g);
                if (n10 == null || (!b.this.Z(2, 4, n10) && !b.this.Z(3, 4, n10))) {
                    return false;
                }
                b.this.f8916w = null;
                Bundle w10 = b.this.w();
                if (b.this.f8912s == null) {
                    return true;
                }
                b.this.f8912s.onConnected(w10);
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class l extends f {
        public l(int i10, Bundle bundle) {
            super(i10, null);
        }

        @Override // com.google.android.gms.common.internal.b.f
        protected final void f(ConnectionResult connectionResult) {
            if (!b.this.z() || !b.this.k0()) {
                b.this.f8907n.a(connectionResult);
                b.this.J(connectionResult);
                return;
            }
            b.this.b0(16);
        }

        @Override // com.google.android.gms.common.internal.b.f
        protected final boolean g() {
            b.this.f8907n.a(ConnectionResult.f8431e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, Looper looper, int i10, a aVar, AbstractC0108b bVar, String str) {
        this(context, looper, com.google.android.gms.common.internal.e.a(context), com.google.android.gms.common.c.h(), i10, (a) b6.i.k(aVar), (AbstractC0108b) b6.i.k(bVar), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(int i10, T t10) {
        w wVar;
        w wVar2;
        b6.i.a((i10 == 4) == (t10 != null));
        synchronized (this.f8904k) {
            this.f8911r = i10;
            this.f8908o = t10;
            M(i10, t10);
            if (i10 != 1) {
                if (i10 == 2 || i10 == 3) {
                    if (!(this.f8910q == null || (wVar2 = this.f8899f) == null)) {
                        String c10 = wVar2.c();
                        String a10 = this.f8899f.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c10).length() + 70 + String.valueOf(a10).length());
                        sb2.append("Calling connect() while still connected, missing disconnect() for ");
                        sb2.append(c10);
                        sb2.append(" on ");
                        sb2.append(a10);
                        Log.e("GmsClient", sb2.toString());
                        this.f8901h.b(this.f8899f.c(), this.f8899f.a(), this.f8899f.b(), this.f8910q, i0());
                        this.f8919z.incrementAndGet();
                    }
                    this.f8910q = new j(this.f8919z.get());
                    if (this.f8911r != 3 || E() == null) {
                        wVar = new w(H(), v(), false, 129);
                    } else {
                        wVar = new w(C().getPackageName(), E(), true, 129);
                    }
                    this.f8899f = wVar;
                    if (!this.f8901h.c(new e.a(wVar.c(), this.f8899f.a(), this.f8899f.b()), this.f8910q, i0())) {
                        String c11 = this.f8899f.c();
                        String a11 = this.f8899f.a();
                        StringBuilder sb3 = new StringBuilder(String.valueOf(c11).length() + 34 + String.valueOf(a11).length());
                        sb3.append("unable to connect to service: ");
                        sb3.append(c11);
                        sb3.append(" on ");
                        sb3.append(a11);
                        Log.e("GmsClient", sb3.toString());
                        T(16, null, this.f8919z.get());
                    }
                } else if (i10 == 4) {
                    I(t10);
                }
            } else if (this.f8910q != null) {
                this.f8901h.b(this.f8899f.c(), this.f8899f.a(), this.f8899f.b(), this.f8910q, i0());
                this.f8910q = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(zzb zzbVar) {
        this.f8918y = zzbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Z(int i10, int i11, T t10) {
        synchronized (this.f8904k) {
            if (this.f8911r != i10) {
                return false;
            }
            U(i11, t10);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(int i10) {
        int i11;
        if (j0()) {
            i11 = 5;
            this.f8917x = true;
        } else {
            i11 = 4;
        }
        Handler handler = this.f8903j;
        handler.sendMessage(handler.obtainMessage(i11, this.f8919z.get(), 16));
    }

    private final String i0() {
        String str = this.f8915v;
        return str == null ? this.f8900g.getClass().getName() : str;
    }

    private final boolean j0() {
        boolean z10;
        synchronized (this.f8904k) {
            z10 = this.f8911r == 3;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k0() {
        if (this.f8917x || TextUtils.isEmpty(m()) || TextUtils.isEmpty(E())) {
            return false;
        }
        try {
            Class.forName(m());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public Account A() {
        return null;
    }

    public Feature[] B() {
        return A;
    }

    public final Context C() {
        return this.f8900g;
    }

    protected Bundle D() {
        return new Bundle();
    }

    protected String E() {
        return null;
    }

    protected Set<Scope> F() {
        return Collections.EMPTY_SET;
    }

    public final T G() throws DeadObjectException {
        T t10;
        synchronized (this.f8904k) {
            if (this.f8911r != 5) {
                y();
                b6.i.o(this.f8908o != null, "Client is connected but service is null");
                t10 = this.f8908o;
            } else {
                throw new DeadObjectException();
            }
        }
        return t10;
    }

    protected String H() {
        return "com.google.android.gms";
    }

    protected void I(T t10) {
        this.f8896c = System.currentTimeMillis();
    }

    protected void J(ConnectionResult connectionResult) {
        this.f8897d = connectionResult.G0();
        this.f8898e = System.currentTimeMillis();
    }

    protected void K(int i10) {
        this.f8894a = i10;
        this.f8895b = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(int i10, IBinder iBinder, Bundle bundle, int i11) {
        Handler handler = this.f8903j;
        handler.sendMessage(handler.obtainMessage(1, i11, -1, new k(i10, iBinder, bundle)));
    }

    void M(int i10, T t10) {
    }

    public boolean N() {
        return false;
    }

    public void O(int i10) {
        Handler handler = this.f8903j;
        handler.sendMessage(handler.obtainMessage(6, this.f8919z.get(), i10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(c cVar, int i10, PendingIntent pendingIntent) {
        this.f8907n = (c) b6.i.l(cVar, "Connection progress callbacks cannot be null.");
        Handler handler = this.f8903j;
        handler.sendMessage(handler.obtainMessage(3, this.f8919z.get(), i10, pendingIntent));
    }

    protected final void T(int i10, Bundle bundle, int i11) {
        Handler handler = this.f8903j;
        handler.sendMessage(handler.obtainMessage(7, i11, -1, new l(i10, null)));
    }

    public void a() {
        this.f8919z.incrementAndGet();
        synchronized (this.f8909p) {
            int size = this.f8909p.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f8909p.get(i10).a();
            }
            this.f8909p.clear();
        }
        synchronized (this.f8905l) {
            this.f8906m = null;
        }
        U(1, null);
    }

    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i10;
        T t10;
        com.google.android.gms.common.internal.j jVar;
        synchronized (this.f8904k) {
            i10 = this.f8911r;
            t10 = this.f8908o;
        }
        synchronized (this.f8905l) {
            jVar = this.f8906m;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i10 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i10 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i10 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i10 == 4) {
            printWriter.print("CONNECTED");
        } else if (i10 != 5) {
            printWriter.print(GrsBaseInfo.CountryCodeSource.UNKNOWN);
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t10 == null) {
            printWriter.append(LpaConstants.VALUE_NULL);
        } else {
            printWriter.append((CharSequence) m()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t10.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (jVar == null) {
            printWriter.println(LpaConstants.VALUE_NULL);
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(jVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f8896c > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j10 = this.f8896c;
            String format = simpleDateFormat.format(new Date(this.f8896c));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format).length() + 21);
            sb2.append(j10);
            sb2.append(" ");
            sb2.append(format);
            append.println(sb2.toString());
        }
        if (this.f8895b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i11 = this.f8894a;
            if (i11 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i11 != 2) {
                printWriter.append((CharSequence) String.valueOf(i11));
            } else {
                printWriter.append("CAUSE_NETWORK_LOST");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j11 = this.f8895b;
            String format2 = simpleDateFormat.format(new Date(this.f8895b));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb3.append(j11);
            sb3.append(" ");
            sb3.append(format2);
            append2.println(sb3.toString());
        }
        if (this.f8898e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) com.google.android.gms.common.api.b.a(this.f8897d));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j12 = this.f8898e;
            String format3 = simpleDateFormat.format(new Date(this.f8898e));
            StringBuilder sb4 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb4.append(j12);
            sb4.append(" ");
            sb4.append(format3);
            append3.println(sb4.toString());
        }
    }

    public boolean f() {
        return false;
    }

    public void g(com.google.android.gms.common.internal.f fVar, Set<Scope> set) {
        Throwable e10;
        Bundle D = D();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.f8914u);
        getServiceRequest.f8873d = this.f8900g.getPackageName();
        getServiceRequest.f8876g = D;
        if (set != null) {
            getServiceRequest.f8875f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (t()) {
            getServiceRequest.f8877h = A() != null ? A() : new Account("<<default account>>", "com.google");
            if (fVar != null) {
                getServiceRequest.f8874e = fVar.asBinder();
            }
        } else if (N()) {
            getServiceRequest.f8877h = A();
        }
        getServiceRequest.f8878i = A;
        getServiceRequest.f8879j = B();
        try {
            synchronized (this.f8905l) {
                com.google.android.gms.common.internal.j jVar = this.f8906m;
                if (jVar != null) {
                    jVar.L(new i(this, this.f8919z.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e11) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e11);
            O(1);
        } catch (RemoteException e12) {
            e10 = e12;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e10);
            L(8, null, null, this.f8919z.get());
        } catch (SecurityException e13) {
            throw e13;
        } catch (RuntimeException e14) {
            e10 = e14;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e10);
            L(8, null, null, this.f8919z.get());
        }
    }

    public boolean h() {
        boolean z10;
        synchronized (this.f8904k) {
            int i10 = this.f8911r;
            if (!(i10 == 2 || i10 == 3)) {
                z10 = false;
            }
            z10 = true;
        }
        return z10;
    }

    public String i() {
        w wVar;
        if (isConnected() && (wVar = this.f8899f) != null) {
            return wVar.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public boolean isConnected() {
        boolean z10;
        synchronized (this.f8904k) {
            z10 = this.f8911r == 4;
        }
        return z10;
    }

    public void j(c cVar) {
        this.f8907n = (c) b6.i.l(cVar, "Connection progress callbacks cannot be null.");
        U(2, null);
    }

    public void l(e eVar) {
        eVar.a();
    }

    protected abstract String m();

    protected abstract T n(IBinder iBinder);

    public boolean o() {
        return true;
    }

    public int p() {
        return com.google.android.gms.common.c.f8812a;
    }

    public final Feature[] r() {
        zzb zzbVar = this.f8918y;
        if (zzbVar == null) {
            return null;
        }
        return zzbVar.f8970b;
    }

    public Intent s() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public boolean t() {
        return false;
    }

    public IBinder u() {
        synchronized (this.f8905l) {
            com.google.android.gms.common.internal.j jVar = this.f8906m;
            if (jVar == null) {
                return null;
            }
            return jVar.asBinder();
        }
    }

    protected abstract String v();

    public Bundle w() {
        return null;
    }

    public void x() {
        int j10 = this.f8902i.j(this.f8900g, p());
        if (j10 != 0) {
            U(1, null);
            P(new d(), j10, null);
            return;
        }
        j(new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected boolean z() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, Looper looper, com.google.android.gms.common.internal.e eVar, com.google.android.gms.common.c cVar, int i10, a aVar, AbstractC0108b bVar, String str) {
        this.f8904k = new Object();
        this.f8905l = new Object();
        this.f8909p = new ArrayList<>();
        this.f8911r = 1;
        this.f8916w = null;
        this.f8917x = false;
        this.f8918y = null;
        this.f8919z = new AtomicInteger(0);
        this.f8900g = (Context) b6.i.l(context, "Context must not be null");
        Looper looper2 = (Looper) b6.i.l(looper, "Looper must not be null");
        this.f8901h = (com.google.android.gms.common.internal.e) b6.i.l(eVar, "Supervisor must not be null");
        this.f8902i = (com.google.android.gms.common.c) b6.i.l(cVar, "API availability must not be null");
        this.f8903j = new g(looper);
        this.f8914u = i10;
        this.f8912s = aVar;
        this.f8913t = bVar;
        this.f8915v = str;
    }
}
