package com.mobvoi.wear.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Looper;
import androidx.core.content.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.android.common.utils.o;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import t9.a;
import t9.d;
/* loaded from: classes2.dex */
public abstract class AdaptiveLocationProvider implements LocationListener {
    private static final String ACCURACY_KEY = "accuracy";
    private static final String LAT_KEY = "lat";
    private static final String LNG_KEY = "lng";
    private static final String PREF_NAME = "google_location";
    private static final String PROVIDER_KEY = "provider";
    static final String TAG = "LocationProvider";
    private static final String TIME_KEY = "time";
    Context mContext;
    private Location mLastLocation;
    private LocationListener mListener;
    long mLocationOutdatedInterval;
    String mOwnerTag;
    long mRequestTimeout;
    private boolean mRequestingLocation;
    long mUpdateInterval;
    private boolean mNeedNetwork = false;
    private final Object mRefreshLock = new Object();
    private Runnable mLocationRequestTask = new Runnable() { // from class: com.mobvoi.wear.loc.a
        @Override // java.lang.Runnable
        public final void run() {
            AdaptiveLocationProvider.this.doRequestLocation();
        }
    };
    private Runnable mStopCleanupRunnable = new Runnable() { // from class: com.mobvoi.wear.loc.d
        @Override // java.lang.Runnable
        public final void run() {
            AdaptiveLocationProvider.this.lambda$new$1();
        }
    };
    private Runnable mTimeoutCleanupRunnable = new Runnable() { // from class: com.mobvoi.wear.loc.b
        @Override // java.lang.Runnable
        public final void run() {
            AdaptiveLocationProvider.this.lambda$new$2();
        }
    };
    private d mTaskScheduler = new d(new a(Looper.getMainLooper()), TAG);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdaptiveLocationProvider(String str, Context context, long j10, long j11, long j12) {
        this.mOwnerTag = str;
        this.mContext = context;
        this.mUpdateInterval = j10;
        this.mRequestTimeout = j11;
        this.mLocationOutdatedInterval = j12;
    }

    private void cleanup(String str) {
        k.c(TAG, "[%s] cleanup: %s, requesting: %s", this.mOwnerTag, str, Boolean.valueOf(this.mRequestingLocation));
        if (this.mRequestingLocation) {
            this.mRequestingLocation = false;
            this.mTaskScheduler.f(this.mLocationRequestTask);
            this.mTaskScheduler.f(this.mStopCleanupRunnable);
            this.mTaskScheduler.f(this.mTimeoutCleanupRunnable);
            removeUpdates();
            destroyClient();
        }
    }

    public static AdaptiveLocationProvider create(String str, Context context, long j10, long j11, long j12) {
        SharedWearInfoHelper.getInstance(context);
        return new GmsLocationClient(str, context, j10, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestLocation() {
        k.c(TAG, "[%s] start requesting location updates: %s", this.mOwnerTag, Boolean.valueOf(this.mRequestingLocation));
        this.mTaskScheduler.f(this.mLocationRequestTask);
        if (!this.mRequestingLocation) {
            if (!clientIsPrepared()) {
                k.c(TAG, "[%s] prepare api client", this.mOwnerTag);
                prepareClient(new Runnable() { // from class: com.mobvoi.wear.loc.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdaptiveLocationProvider.this.lambda$doRequestLocation$0();
                    }
                });
                return;
            }
            this.mRequestingLocation = true;
            this.mTaskScheduler.f(this.mTimeoutCleanupRunnable);
            this.mTaskScheduler.l(this.mTimeoutCleanupRunnable, this.mRequestTimeout);
            requestUpdates();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doRequestLocation$0() {
        this.mTaskScheduler.l(this.mLocationRequestTask, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        cleanup("Stop");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2() {
        cleanup("Timeout");
    }

    private Location loadLocation() {
        if (SharedWearInfoHelper.isInfoProviderExist(this.mContext)) {
            return SharedWearInfoHelper.getInstance(this.mContext).getLastLocation();
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(PREF_NAME, 0);
        Location location = new Location(sharedPreferences.getString("provider", ""));
        location.setLatitude(Double.valueOf(sharedPreferences.getString("lat", "0.0")).doubleValue());
        location.setLongitude(Double.valueOf(sharedPreferences.getString("lng", "0.0")).doubleValue());
        location.setAccuracy(sharedPreferences.getFloat("accuracy", 0.0f));
        location.setTime(sharedPreferences.getLong("time", 0L));
        return location;
    }

    private void saveLocation(Location location) {
        if (SharedWearInfoHelper.isInfoProviderExist(this.mContext)) {
            SharedWearInfoHelper.getInstance(this.mContext).saveLastLocation(location);
        } else {
            this.mContext.getSharedPreferences(PREF_NAME, 0).edit().putString("provider", location.getProvider()).putString("lat", Double.toString(location.getLatitude())).putString("lng", Double.toString(location.getLongitude())).putFloat("accuracy", location.getAccuracy()).putLong("time", location.getTime()).apply();
        }
    }

    protected abstract boolean clientIsPrepared();

    protected abstract void destroyClient();

    public Location getCurrentLocation(boolean z10, boolean z11) {
        k.c(TAG, "[%s] getCurrentLocation, refresh: %s, waiting: %s", this.mOwnerTag, Boolean.valueOf(z10), Boolean.valueOf(z11));
        if (z10 && z11) {
            if (k.j()) {
                o.d();
            } else {
                k.s(TAG, "[%s] getCurrentLocation wait in main thread!", this.mOwnerTag);
            }
        }
        if (hasPermissions()) {
            Location lastLocation = getLastLocation();
            Location loadLocation = loadLocation();
            this.mLastLocation = loadLocation;
            if (!(lastLocation == null || ((loadLocation != null && lastLocation.getTime() <= this.mLastLocation.getTime()) || lastLocation.getLatitude() == 0.0d || lastLocation.getLongitude() == 0.0d))) {
                this.mLastLocation = lastLocation;
                saveLocation(lastLocation);
                LocationListener locationListener = this.mListener;
                if (locationListener != null) {
                    locationListener.onLocationChanged(lastLocation);
                }
                k.c(TAG, "[%s] got last known location: %s, timestamp: %s", this.mOwnerTag, lastLocation, com.mobvoi.android.common.utils.d.a(lastLocation.getTime()));
            }
            boolean z12 = this.mLastLocation == null || System.currentTimeMillis() - this.mLastLocation.getTime() > this.mLocationOutdatedInterval;
            if (z10 && z12 && requestLocationUpdate() && z11) {
                k.c(TAG, "[%s] waiting for location update... %d seconds timeout", this.mOwnerTag, Long.valueOf(this.mRequestTimeout / 1000));
                synchronized (this.mRefreshLock) {
                    try {
                        this.mRefreshLock.wait(this.mRequestTimeout);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            k.c(TAG, "[%s] Got current location: %s", this.mOwnerTag, this.mLastLocation);
            return this.mLastLocation;
        }
        k.s(TAG, "[%s] no location permissions", this.mOwnerTag);
        return null;
    }

    protected abstract Location getLastLocation();

    public boolean hasPermissions() {
        return SharedWearInfoHelper.getInstance(this.mContext).isGdprDataEnabled(SharedWearInfoHelper.GdprInfo.KEY_DATA_GPS) && b.a(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public void init() {
        Location loadLocation = loadLocation();
        this.mLastLocation = loadLocation;
        if (loadLocation == null) {
            k.c(TAG, "[%s] no saved location found", this.mOwnerTag);
        } else {
            k.c(TAG, "[%s] loaded location: %s, timestamp: %s", this.mOwnerTag, loadLocation, com.mobvoi.android.common.utils.d.a(loadLocation.getTime()));
        }
    }

    @Override // com.mobvoi.wear.loc.LocationListener
    public void onLocationChanged(Location location) {
        if (location == null) {
            k.q(TAG, "null location updated!");
            return;
        }
        k.c(TAG, "[%s] onLocationChanged: %s, timestamp: %s", this.mOwnerTag, location, com.mobvoi.android.common.utils.d.a(location.getTime()));
        if (location.getTime() + this.mLocationOutdatedInterval >= System.currentTimeMillis()) {
            this.mLastLocation = location;
            saveLocation(location);
            synchronized (this.mRefreshLock) {
                this.mRefreshLock.notifyAll();
            }
            cleanup("GotLocation");
            LocationListener locationListener = this.mListener;
            if (locationListener != null) {
                locationListener.onLocationChanged(location);
            }
        }
    }

    protected abstract void prepareClient(Runnable runnable);

    public void removeLocationUpdate() {
        this.mTaskScheduler.f(this.mStopCleanupRunnable);
        this.mTaskScheduler.l(this.mStopCleanupRunnable, 0L);
    }

    protected abstract void removeUpdates();

    @SuppressLint({"MissingPermission"})
    public boolean requestLocationUpdate() {
        k.c(TAG, "[%s] requestLocationUpdate", this.mOwnerTag);
        if (!hasPermissions()) {
            k.s(TAG, "[%s] LOCATION permission not granted", this.mOwnerTag);
            return false;
        } else if (!this.mNeedNetwork || m.b(this.mContext)) {
            this.mTaskScheduler.f(this.mLocationRequestTask);
            this.mTaskScheduler.l(this.mLocationRequestTask, 0L);
            return true;
        } else {
            k.s(TAG, "[%s] No network but required", this.mOwnerTag);
            return false;
        }
    }

    protected abstract void requestUpdates();

    public void setLocationListener(LocationListener locationListener) {
        this.mListener = locationListener;
    }

    public void setNeedNetwork(boolean z10) {
        this.mNeedNetwork = z10;
    }
}
