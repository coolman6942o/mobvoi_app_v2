package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private boolean f9970a;

    /* renamed from: b  reason: collision with root package name */
    private long f9971b;

    /* renamed from: c  reason: collision with root package name */
    private float f9972c;

    /* renamed from: d  reason: collision with root package name */
    private long f9973d;

    /* renamed from: e  reason: collision with root package name */
    private int f9974e;

    public zzj() {
        this(true, 50L, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(boolean z10, long j10, float f10, long j11, int i10) {
        this.f9970a = z10;
        this.f9971b = j10;
        this.f9972c = f10;
        this.f9973d = j11;
        this.f9974e = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzjVar = (zzj) obj;
        return this.f9970a == zzjVar.f9970a && this.f9971b == zzjVar.f9971b && Float.compare(this.f9972c, zzjVar.f9972c) == 0 && this.f9973d == zzjVar.f9973d && this.f9974e == zzjVar.f9974e;
    }

    public final int hashCode() {
        return h.b(Boolean.valueOf(this.f9970a), Long.valueOf(this.f9971b), Float.valueOf(this.f9972c), Long.valueOf(this.f9973d), Integer.valueOf(this.f9974e));
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DeviceOrientationRequest[mShouldUseMag=");
        sb2.append(this.f9970a);
        sb2.append(" mMinimumSamplingPeriodMs=");
        sb2.append(this.f9971b);
        sb2.append(" mSmallestAngleChangeRadians=");
        sb2.append(this.f9972c);
        long j10 = this.f9973d;
        if (j10 != Long.MAX_VALUE) {
            sb2.append(" expireIn=");
            sb2.append(j10 - SystemClock.elapsedRealtime());
            sb2.append("ms");
        }
        if (this.f9974e != Integer.MAX_VALUE) {
            sb2.append(" num=");
            sb2.append(this.f9974e);
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.c(parcel, 1, this.f9970a);
        a.o(parcel, 2, this.f9971b);
        a.i(parcel, 3, this.f9972c);
        a.o(parcel, 4, this.f9973d);
        a.l(parcel, 5, this.f9974e);
        a.b(parcel, a10);
    }
}
