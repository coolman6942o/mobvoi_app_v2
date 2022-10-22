package nm;

import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.realsil.sdk.dfu.DfuService;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.params.QcConfig;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import ll.a;
import ll.b;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f31307a;

    /* renamed from: b  reason: collision with root package name */
    public nm.b f31308b;

    /* renamed from: c  reason: collision with root package name */
    public ll.a f31309c;

    /* renamed from: d  reason: collision with root package name */
    public b.a f31310d = new BinderC0413a();

    /* renamed from: e  reason: collision with root package name */
    public final ServiceConnection f31311e = new b();

    /* renamed from: nm.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class BinderC0413a extends b.a {
        public BinderC0413a() {
        }

        @Override // ll.b
        public void P1(DfuProgressInfo dfuProgressInfo) {
            if (a.this.f31308b != null) {
                a.this.f31308b.b(dfuProgressInfo);
            }
        }

        @Override // ll.b
        public void a(int i10) {
            if (a.this.f31308b != null) {
                a.this.f31308b.c(i10, null);
            }
        }

        @Override // ll.b
        public void b(int i10) {
            if (a.this.f31308b != null) {
                a.this.f31308b.a(i10);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            il.b.j("onServiceConnected: className=" + componentName.getClassName() + ", packageName=" + componentName.getPackageName());
            a.this.f31309c = a.AbstractBinderC0385a.c(iBinder);
            if (a.this.f31309c != null) {
                try {
                    if (!a.this.f31309c.m2("DfuProxy", a.this.f31310d)) {
                        il.b.c("registerCallback failed, need to unbind");
                        a.this.l();
                    } else if (a.this.f31308b != null) {
                        a.this.f31308b.d(true, a.this);
                    }
                } catch (RemoteException e10) {
                    il.b.e(e10.toString());
                    a.this.l();
                }
            } else {
                if (a.this.f31308b != null) {
                    a.this.f31308b.d(false, a.this);
                }
                il.b.j("rebind DfuService...");
                a.this.k();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            il.b.c("Proxy object disconnected with an extreme situations");
            try {
                if (a.this.f31309c != null) {
                    a.this.f31309c.T1("DfuProxy", a.this.f31310d);
                }
            } catch (RemoteException e10) {
                il.b.e(e10.toString());
            }
            a.this.f31309c = null;
            if (a.this.f31308b != null) {
                a.this.f31308b.d(false, null);
                a.this.k();
            }
        }
    }

    public a(Context context, nm.b bVar) {
        this.f31307a = context;
        this.f31308b = bVar;
        BluetoothAdapter.getDefaultAdapter();
    }

    public static boolean e(Context context, nm.b bVar) {
        if (context == null || bVar == null) {
            return false;
        }
        a aVar = new a(context, bVar);
        if (aVar.d(context)) {
            return aVar.k();
        }
        il.b.l("please declare com.realsil.sdk.dfu.DfuService in your AndroidManifest.xml");
        return false;
    }

    public boolean c() {
        ll.a aVar = this.f31309c;
        if (aVar == null) {
            il.b.c("Proxy not attached to service");
            return false;
        }
        try {
            return aVar.c();
        } catch (RemoteException unused) {
            il.b.e("Stack:" + Log.getStackTraceString(new Throwable()));
            return false;
        }
    }

    public final boolean d(Context context) {
        return context.getPackageManager().queryIntentServices(new Intent(context, DfuService.class), WXMediaMessage.THUMB_LENGTH_LIMIT).size() > 0;
    }

    public boolean f(DfuConfig dfuConfig) {
        return g(dfuConfig, null);
    }

    public void finalize() {
        this.f31308b = null;
        i();
    }

    public boolean g(DfuConfig dfuConfig, QcConfig qcConfig) {
        String str;
        ll.a aVar = this.f31309c;
        if (aVar == null) {
            str = "Proxy not attached to service";
        } else {
            try {
                return aVar.k1("DfuProxy", dfuConfig, qcConfig);
            } catch (RemoteException unused) {
                str = "Stack:" + Log.getStackTraceString(new Throwable());
            }
        }
        il.b.l(str);
        return false;
    }

    public void i() {
        this.f31308b = null;
        c();
        l();
    }

    public final boolean k() {
        try {
            il.b.j("bindService DfuService ...");
            Intent intent = new Intent(this.f31307a, DfuService.class);
            intent.setAction(ll.a.class.getName());
            return this.f31307a.bindService(intent, this.f31311e, 1);
        } catch (Exception e10) {
            il.b.e("Unable to bind DfuService " + e10.toString());
            return false;
        }
    }

    public final void l() {
        synchronized (this.f31311e) {
            ll.a aVar = this.f31309c;
            if (aVar != null) {
                try {
                    aVar.T1("DfuProxy", this.f31310d);
                    this.f31309c = null;
                    this.f31307a.unbindService(this.f31311e);
                } catch (Exception e10) {
                    il.b.l("Unable to unbind DfuService: " + e10.toString());
                }
            }
        }
    }
}
