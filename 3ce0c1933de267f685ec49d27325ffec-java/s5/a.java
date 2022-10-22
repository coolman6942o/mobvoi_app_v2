package s5;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import n6.d;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.google.android.gms.common.a f34309a;

    /* renamed from: b  reason: collision with root package name */
    private d f34310b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34311c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f34312d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private b f34313e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f34314f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f34315g;

    /* renamed from: h  reason: collision with root package name */
    private final long f34316h;

    /* renamed from: s5.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0494a {

        /* renamed from: a  reason: collision with root package name */
        private final String f34317a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f34318b;

        public C0494a(String str, boolean z10) {
            this.f34317a = str;
            this.f34318b = z10;
        }

        public final String a() {
            return this.f34317a;
        }

        public final boolean b() {
            return this.f34318b;
        }

        public final String toString() {
            String str = this.f34317a;
            boolean z10 = this.f34318b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            sb2.append(z10);
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f34319a;

        /* renamed from: b  reason: collision with root package name */
        private long f34320b;

        /* renamed from: c  reason: collision with root package name */
        CountDownLatch f34321c = new CountDownLatch(1);

        /* renamed from: d  reason: collision with root package name */
        boolean f34322d = false;

        public b(a aVar, long j10) {
            this.f34319a = new WeakReference<>(aVar);
            this.f34320b = j10;
            start();
        }

        private final void a() {
            a aVar = this.f34319a.get();
            if (aVar != null) {
                aVar.a();
                this.f34322d = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (!this.f34321c.await(this.f34320b, TimeUnit.MILLISECONDS)) {
                    a();
                }
            } catch (InterruptedException unused) {
                a();
            }
        }
    }

    private a(Context context, long j10, boolean z10, boolean z11) {
        Context applicationContext;
        i.k(context);
        if (z10 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f34314f = context;
        this.f34311c = false;
        this.f34316h = j10;
        this.f34315g = z11;
    }

    public static C0494a b(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        c cVar = new c(context);
        boolean a10 = cVar.a("gads:ad_id_app_context:enabled", false);
        float b10 = cVar.b("gads:ad_id_app_context:ping_ratio", 0.0f);
        String c10 = cVar.c("gads:ad_id_use_shared_preference:experiment_id", "");
        a aVar = new a(context, -1L, a10, cVar.a("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            aVar.h(false);
            C0494a c11 = aVar.c();
            aVar.i(c11, a10, b10, SystemClock.elapsedRealtime() - elapsedRealtime, c10, null);
            return c11;
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    public static void d(boolean z10) {
    }

    private static com.google.android.gms.common.a e(Context context, boolean z10) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int j10 = c.h().j(context, e.f8830a);
            if (j10 == 0 || j10 == 2) {
                String str = z10 ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (g6.a.b().a(context, intent, aVar, 1)) {
                        return aVar;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th2) {
                    throw new IOException(th2);
                }
            } else {
                throw new IOException("Google Play services not available");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    private static d f(Context context, com.google.android.gms.common.a aVar) throws IOException {
        try {
            return n6.e.c(aVar.a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }

    private final void g() {
        synchronized (this.f34312d) {
            b bVar = this.f34313e;
            if (bVar != null) {
                bVar.f34321c.countDown();
                try {
                    this.f34313e.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f34316h > 0) {
                this.f34313e = new b(this, this.f34316h);
            }
        }
    }

    private final void h(boolean z10) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        i.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f34311c) {
                a();
            }
            com.google.android.gms.common.a e10 = e(this.f34314f, this.f34315g);
            this.f34309a = e10;
            this.f34310b = f(this.f34314f, e10);
            this.f34311c = true;
            if (z10) {
                g();
            }
        }
    }

    private final boolean i(C0494a aVar, boolean z10, float f10, long j10, String str, Throwable th2) {
        if (Math.random() > f10) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = "1";
        hashMap.put("app_context", z10 ? str2 : "0");
        if (aVar != null) {
            if (!aVar.b()) {
                str2 = "0";
            }
            hashMap.put("limit_ad_tracking", str2);
        }
        if (!(aVar == null || aVar.a() == null)) {
            hashMap.put("ad_id_size", Integer.toString(aVar.a().length()));
        }
        if (th2 != null) {
            hashMap.put("error", th2.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j10));
        new s5.b(this, hashMap).start();
        return true;
    }

    public final void a() {
        i.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f34314f != null && this.f34309a != null) {
                if (this.f34311c) {
                    g6.a.b().c(this.f34314f, this.f34309a);
                }
                this.f34311c = false;
                this.f34310b = null;
                this.f34309a = null;
            }
        }
    }

    public C0494a c() throws IOException {
        C0494a aVar;
        i.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.f34311c) {
                synchronized (this.f34312d) {
                    b bVar = this.f34313e;
                    if (bVar == null || !bVar.f34322d) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    h(false);
                    if (!this.f34311c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e10) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e10);
                }
            }
            i.k(this.f34309a);
            i.k(this.f34310b);
            try {
                aVar = new C0494a(this.f34310b.getId(), this.f34310b.f0(true));
            } catch (RemoteException e11) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e11);
                throw new IOException("Remote exception");
            }
        }
        g();
        return aVar;
    }

    protected void finalize() throws Throwable {
        a();
        super.finalize();
    }
}
