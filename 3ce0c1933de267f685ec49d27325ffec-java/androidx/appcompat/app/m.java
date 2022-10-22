package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.core.content.c;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.LogCleaner;
import java.util.Calendar;
/* compiled from: TwilightManager.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: d  reason: collision with root package name */
    private static m f564d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f565a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f566b;

    /* renamed from: c  reason: collision with root package name */
    private final a f567c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TwilightManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f568a;

        /* renamed from: b  reason: collision with root package name */
        long f569b;

        a() {
        }
    }

    m(Context context, LocationManager locationManager) {
        this.f565a = context;
        this.f566b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(Context context) {
        if (f564d == null) {
            Context applicationContext = context.getApplicationContext();
            f564d = new m(applicationContext, (LocationManager) applicationContext.getSystemService(SharedWearInfoHelper.LocationInfo.TABLE));
        }
        return f564d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location location = null;
        Location c10 = c.c(this.f565a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        if (c.c(this.f565a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = c("gps");
        }
        return (location == null || c10 == null) ? location != null ? location : c10 : location.getTime() > c10.getTime() ? location : c10;
    }

    private Location c(String str) {
        try {
            if (this.f566b.isProviderEnabled(str)) {
                return this.f566b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e10) {
            Log.d("TwilightManager", "Failed to get last known location", e10);
            return null;
        }
    }

    private boolean e() {
        return this.f567c.f569b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j10;
        a aVar = this.f567c;
        long currentTimeMillis = System.currentTimeMillis();
        l b10 = l.b();
        b10.a(currentTimeMillis - LogCleaner.ONE_DAY, location.getLatitude(), location.getLongitude());
        b10.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = true;
        if (b10.f563c != 1) {
            z10 = false;
        }
        boolean z11 = z10;
        long j11 = b10.f562b;
        long j12 = b10.f561a;
        b10.a(currentTimeMillis + LogCleaner.ONE_DAY, location.getLatitude(), location.getLongitude());
        long j13 = b10.f562b;
        if (j11 == -1 || j12 == -1) {
            j10 = 43200000 + currentTimeMillis;
        } else {
            j10 = (currentTimeMillis > j12 ? j13 + 0 : currentTimeMillis > j11 ? j12 + 0 : j11 + 0) + LogCleaner.ONE_MINUTE;
        }
        aVar.f568a = z11;
        aVar.f569b = j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f567c;
        if (e()) {
            return aVar.f568a;
        }
        Location b10 = b();
        if (b10 != null) {
            f(b10);
            return aVar.f568a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i10 = Calendar.getInstance().get(11);
        return i10 < 6 || i10 >= 22;
    }
}
