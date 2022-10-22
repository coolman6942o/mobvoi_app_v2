package com.mobvoi.companion.map;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.k;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.b;
import com.mobvoi.companion.map.LocationUpdatesService;
import dd.d;
/* loaded from: classes2.dex */
public class LocationUpdatesService extends Service {

    /* renamed from: h  reason: collision with root package name */
    private static final String f17247h = LocationUpdatesService.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f17248a = new b();

    /* renamed from: b  reason: collision with root package name */
    private NotificationManager f17249b;

    /* renamed from: c  reason: collision with root package name */
    private LocationRequest f17250c;

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.gms.location.a f17251d;

    /* renamed from: e  reason: collision with root package name */
    private w6.b f17252e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17253f;

    /* renamed from: g  reason: collision with root package name */
    private Location f17254g;

    /* loaded from: classes2.dex */
    class a extends w6.b {
        a() {
        }

        @Override // w6.b
        public void onLocationResult(LocationResult locationResult) {
            super.onLocationResult(locationResult);
            LocationUpdatesService.this.g(locationResult.G0());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends Binder {
        public b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LocationUpdatesService a() {
            return LocationUpdatesService.this;
        }
    }

    @SuppressLint({"RestrictedApi"})
    private void c() {
        LocationRequest locationRequest = new LocationRequest();
        this.f17250c = locationRequest;
        locationRequest.K0(2000L);
        this.f17250c.J0(1000L);
        this.f17250c.M0(100);
    }

    private void d() {
        try {
            this.f17251d.p().b(new b7.b() { // from class: cd.e
                @Override // b7.b
                public final void a(b bVar) {
                    LocationUpdatesService.this.f(bVar);
                }
            });
        } catch (SecurityException e10) {
            String str = f17247h;
            Log.e(str, "Lost location permission." + e10);
        }
    }

    private Notification e() {
        k.d z10 = new k.d(this).j(getString(d.b_res_0x7f140f3b)).q(true).s(1).u(dd.a.f25606b).z(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            z10.g("channel_01");
        }
        return z10.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(com.google.android.gms.tasks.b bVar) {
        if (!bVar.o() || bVar.k() == null) {
            Log.w(f17247h, "Failed to get location.");
        } else {
            g((Location) bVar.k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Location location) {
        if (this.f17254g == null || location.getLatitude() != this.f17254g.getLatitude() || location.getLongitude() != this.f17254g.getLongitude()) {
            this.f17254g = location;
            Intent intent = new Intent("com.mobvoi.companion.maplocationService.broadcast");
            intent.putExtra("com.mobvoi.companion.maplocationService.location", location);
            b1.a.b(getApplicationContext()).d(intent);
        }
    }

    public void h() {
        this.f17253f = false;
        try {
            this.f17251d.q(this.f17252e);
            stopForeground(true);
            stopSelf();
        } catch (SecurityException e10) {
            String str = f17247h;
            Log.e(str, "Lost location permission. Could not remove updates. " + e10);
        }
    }

    public void i() {
        this.f17253f = true;
        startService(new Intent(getApplicationContext(), LocationUpdatesService.class));
        try {
            this.f17251d.r(this.f17250c, this.f17252e, Looper.myLooper());
        } catch (SecurityException e10) {
            this.f17253f = false;
            String str = f17247h;
            Log.e(str, "Lost location permission. Could not request updates. " + e10);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        stopForeground(true);
        return this.f17248a;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f17251d = w6.d.a(this);
        this.f17252e = new a();
        c();
        d();
        this.f17249b = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f17249b.createNotificationChannel(new NotificationChannel("channel_01", getString(d.a_res_0x7f140ea9), 3));
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        stopForeground(true);
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (!this.f17253f) {
            return 2;
        }
        startForeground(10001, e());
        return 2;
    }
}
