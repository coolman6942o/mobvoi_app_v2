package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.mobvoi.wear.util.LogCleaner;
/* loaded from: classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private int f9929a;

    /* renamed from: b  reason: collision with root package name */
    private long f9930b;

    /* renamed from: c  reason: collision with root package name */
    private long f9931c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9932d;

    /* renamed from: e  reason: collision with root package name */
    private long f9933e;

    /* renamed from: f  reason: collision with root package name */
    private int f9934f;

    /* renamed from: g  reason: collision with root package name */
    private float f9935g;

    /* renamed from: h  reason: collision with root package name */
    private long f9936h;

    public LocationRequest() {
        this.f9929a = 102;
        this.f9930b = LogCleaner.ONE_HOUR;
        this.f9931c = 600000L;
        this.f9932d = false;
        this.f9933e = Long.MAX_VALUE;
        this.f9934f = Integer.MAX_VALUE;
        this.f9935g = 0.0f;
        this.f9936h = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequest(int i10, long j10, long j11, boolean z10, long j12, int i11, float f10, long j13) {
        this.f9929a = i10;
        this.f9930b = j10;
        this.f9931c = j11;
        this.f9932d = z10;
        this.f9933e = j12;
        this.f9934f = i11;
        this.f9935g = f10;
        this.f9936h = j13;
    }

    public static LocationRequest G0() {
        return new LocationRequest();
    }

    private static void N0(long j10) {
        if (j10 < 0) {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("invalid interval: ");
            sb2.append(j10);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final long H0() {
        long j10 = this.f9936h;
        long j11 = this.f9930b;
        return j10 < j11 ? j11 : j10;
    }

    public final LocationRequest I0(long j10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j10 > Long.MAX_VALUE - elapsedRealtime) {
            this.f9933e = Long.MAX_VALUE;
        } else {
            this.f9933e = j10 + elapsedRealtime;
        }
        if (this.f9933e < 0) {
            this.f9933e = 0L;
        }
        return this;
    }

    public final LocationRequest J0(long j10) {
        N0(j10);
        this.f9932d = true;
        this.f9931c = j10;
        return this;
    }

    public final LocationRequest K0(long j10) {
        N0(j10);
        this.f9930b = j10;
        if (!this.f9932d) {
            this.f9931c = (long) (j10 / 6.0d);
        }
        return this;
    }

    public final LocationRequest L0(long j10) {
        N0(j10);
        this.f9936h = j10;
        return this;
    }

    public final LocationRequest M0(int i10) {
        if (i10 == 100 || i10 == 102 || i10 == 104 || i10 == 105) {
            this.f9929a = i10;
            return this;
        }
        StringBuilder sb2 = new StringBuilder(28);
        sb2.append("invalid quality: ");
        sb2.append(i10);
        throw new IllegalArgumentException(sb2.toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.f9929a == locationRequest.f9929a && this.f9930b == locationRequest.f9930b && this.f9931c == locationRequest.f9931c && this.f9932d == locationRequest.f9932d && this.f9933e == locationRequest.f9933e && this.f9934f == locationRequest.f9934f && this.f9935g == locationRequest.f9935g && H0() == locationRequest.H0();
    }

    public final int hashCode() {
        return h.b(Integer.valueOf(this.f9929a), Long.valueOf(this.f9930b), Float.valueOf(this.f9935g), Long.valueOf(this.f9936h));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request[");
        int i10 = this.f9929a;
        sb2.append(i10 != 100 ? i10 != 102 ? i10 != 104 ? i10 != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.f9929a != 105) {
            sb2.append(" requested=");
            sb2.append(this.f9930b);
            sb2.append("ms");
        }
        sb2.append(" fastest=");
        sb2.append(this.f9931c);
        sb2.append("ms");
        if (this.f9936h > this.f9930b) {
            sb2.append(" maxWait=");
            sb2.append(this.f9936h);
            sb2.append("ms");
        }
        if (this.f9935g > 0.0f) {
            sb2.append(" smallestDisplacement=");
            sb2.append(this.f9935g);
            sb2.append("m");
        }
        long j10 = this.f9933e;
        if (j10 != Long.MAX_VALUE) {
            sb2.append(" expireIn=");
            sb2.append(j10 - SystemClock.elapsedRealtime());
            sb2.append("ms");
        }
        if (this.f9934f != Integer.MAX_VALUE) {
            sb2.append(" num=");
            sb2.append(this.f9934f);
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9929a);
        a.o(parcel, 2, this.f9930b);
        a.o(parcel, 3, this.f9931c);
        a.c(parcel, 4, this.f9932d);
        a.o(parcel, 5, this.f9933e);
        a.l(parcel, 6, this.f9934f);
        a.i(parcel, 7, this.f9935g);
        a.o(parcel, 8, this.f9936h);
        a.b(parcel, a10);
    }
}
