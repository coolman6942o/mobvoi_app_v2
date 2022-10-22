package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class LocationAvailability extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new b();
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private int f9924a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private int f9925b;

    /* renamed from: c  reason: collision with root package name */
    private long f9926c;

    /* renamed from: d  reason: collision with root package name */
    private int f9927d;

    /* renamed from: e  reason: collision with root package name */
    private zzaj[] f9928e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationAvailability(int i10, int i11, int i12, long j10, zzaj[] zzajVarArr) {
        this.f9927d = i10;
        this.f9924a = i11;
        this.f9925b = i12;
        this.f9926c = j10;
        this.f9928e = zzajVarArr;
    }

    public final boolean G0() {
        return this.f9927d < 1000;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && LocationAvailability.class == obj.getClass()) {
            LocationAvailability locationAvailability = (LocationAvailability) obj;
            if (this.f9924a == locationAvailability.f9924a && this.f9925b == locationAvailability.f9925b && this.f9926c == locationAvailability.f9926c && this.f9927d == locationAvailability.f9927d && Arrays.equals(this.f9928e, locationAvailability.f9928e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return h.b(Integer.valueOf(this.f9927d), Integer.valueOf(this.f9924a), Integer.valueOf(this.f9925b), Long.valueOf(this.f9926c), this.f9928e);
    }

    public final String toString() {
        boolean G0 = G0();
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("LocationAvailability[isLocationAvailable: ");
        sb2.append(G0);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9924a);
        a.l(parcel, 2, this.f9925b);
        a.o(parcel, 3, this.f9926c);
        a.l(parcel, 4, this.f9927d);
        a.w(parcel, 5, this.f9928e, i10, false);
        a.b(parcel, a10);
    }
}
