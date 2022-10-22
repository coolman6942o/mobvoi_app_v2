package com.mobvoi.companion.map;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.IBinder;
import com.mobvoi.companion.map.LocationUpdatesService;
import com.mobvoi.companion.map.d;
import com.mobvoi.companion.map.g;
import com.mobvoi.companion.map.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: GoogleMapLocationImpl.java */
/* loaded from: classes2.dex */
public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    private Context f17269a;

    /* renamed from: b  reason: collision with root package name */
    private b f17270b;

    /* renamed from: c  reason: collision with root package name */
    private LocationUpdatesService f17271c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17272d = false;

    /* renamed from: e  reason: collision with root package name */
    ExecutorService f17273e = Executors.newSingleThreadExecutor();

    /* renamed from: g  reason: collision with root package name */
    private final ServiceConnection f17275g = new a();

    /* renamed from: f  reason: collision with root package name */
    private List<g.a> f17274f = new ArrayList();

    /* compiled from: GoogleMapLocationImpl.java */
    /* loaded from: classes2.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f17271c = ((LocationUpdatesService.b) iBinder).a();
            if (d.this.f17271c != null) {
                d.this.f17271c.i();
            }
            d.this.f17272d = true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.this.f17271c = null;
            d.this.f17272d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GoogleMapLocationImpl.java */
    /* loaded from: classes2.dex */
    public class b extends BroadcastReceiver {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Location location) {
            List<Address> fromLocation;
            synchronized (d.class) {
                j jVar = null;
                try {
                    for (g.a aVar : d.this.f17274f) {
                        if (aVar.a(location)) {
                            if (jVar == null && (fromLocation = new Geocoder(d.this.f17269a).getFromLocation(location.getLatitude(), location.getLongitude(), 1)) != null && fromLocation.size() > 0) {
                                Address address = fromLocation.get(0);
                                jVar = new j.b().g(location.getLatitude()).h(location.getLongitude()).c(location.getAltitude()).b(location.getAccuracy()).k(location.getTime()).j(location.getSpeed()).e(address.getCountryName()).i(address.getAdminArea()).d(address.getLocality()).f(address.getSubLocality()).a();
                            }
                            if (jVar != null) {
                                aVar.b(jVar);
                            }
                        } else {
                            return;
                        }
                    }
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            final Location location = (Location) intent.getParcelableExtra("com.mobvoi.companion.maplocationService.location");
            if (location != null) {
                d.this.f17273e.execute(new Runnable() { // from class: com.mobvoi.companion.map.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.b.this.b(location);
                    }
                });
            }
        }

        /* synthetic */ b(d dVar, a aVar) {
            this();
        }
    }

    @Override // com.mobvoi.companion.map.g
    public void a(Context context, g.a aVar) {
        synchronized (d.class) {
            if (!this.f17274f.contains(aVar)) {
                this.f17274f.add(aVar);
            }
            if (!this.f17272d) {
                this.f17269a = context.getApplicationContext();
                this.f17270b = new b(this, null);
                b1.a.b(this.f17269a).c(this.f17270b, new IntentFilter("com.mobvoi.companion.maplocationService.broadcast"));
                this.f17269a.bindService(new Intent(this.f17269a, LocationUpdatesService.class), this.f17275g, 1);
            }
        }
    }

    @Override // com.mobvoi.companion.map.g
    public void b(g.a aVar) {
        synchronized (d.class) {
            if (this.f17274f.contains(aVar)) {
                this.f17274f.remove(aVar);
            }
            if (this.f17272d && this.f17271c != null && this.f17274f.size() == 0) {
                this.f17271c.h();
                b1.a.b(this.f17269a).e(this.f17270b);
                this.f17269a.unbindService(this.f17275g);
                this.f17272d = false;
            }
        }
    }
}
